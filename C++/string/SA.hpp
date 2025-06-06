#pragma once

#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric>
#include <ranges>
namespace man {
struct SuffixArray: std::vector<int> {
private:
    inline std::vector<int> sa_is(const std::vector<int> &s) const noexcept {
    	const int n = std::ssize(s);
    	std::vector<int> ret(n), is_s(n), is_lms(n);
    	int m = 0;
    	for(const auto i: std::views::iota(0, n - 1) | std::views::reverse) {
      		is_s[i] = (s[i] > s[i + 1]) || (s[i] == s[i + 1] && is_s[i + 1]);
      		m += is_lms[i + 1] = is_s[i] && !is_s[i + 1];
    	}
    	const auto induced_sort = [&](const std::vector<int> &lms) -> void {
      		const int upper = *std::ranges::max_element(s);
      		std::vector<int> l(upper + 2), r(upper + 2);
			for(const auto &v: s) {
				++l[v + 1];
				++r[v];
			}
			std::partial_sum(l.begin(), l.end(), l.begin());
			std::partial_sum(r.begin(), r.end(), r.begin());
			ret.assign(std::ssize(ret), -1);
			for(const auto i: std::views::iota(0, std::ssize(lms)) | std::views::reverse) {
				ret[--r[s[lms[i]]]] = lms[i];
			}
			for(const auto &v: ret) {
				if(v >= 1 && is_s[v - 1]) {
					ret[l[s[v - 1]]++] = v - 1;
				}
			}
			r.assign(std::ssize(r), 0);
			for(const auto &v: s) {
				++r[v];
			}
			std::partial_sum(r.begin(), r.end(), r.begin());
			for(int k = std::ssize(ret) - 1, i = ret[k]; k >= 1; i = ret[--k]) {
				if(i >= 1 && !is_s[i - 1]) {
					ret[--r[s[i - 1]]] = i - 1;
				}
			}
		};
		std::vector<int> lms, new_lms;
		lms.reserve(m);
		for(const auto i: std::views::iota(1, n)) {
			if(is_lms[i]) {
				lms.emplace_back(i);
			}
		}
		induced_sort(lms);
		new_lms.reserve(m);
		for(const auto i: std::views::iota(0, n)) {
			if(!is_s[ret[i]] && ret[i] > 0 && is_s[ret[i] - 1]) {
				new_lms.emplace_back(ret[i]);
			}
		}
		const auto same = [&](int a, int b) -> bool {
			if(s[a++] != s[b++]) {
				return false;
			}
			while(true) {
				if(s[a] != s[b]) {
					return false;
				}
				if(is_lms[a] || is_lms[b]) {
					return is_lms[a] && is_lms[b];
				}
				a++, b++;
			}
		};
		int rank = 0;
		ret[n - 1] = 0;
		for(const auto i: std::views::iota(1, m)) {
			if(!same(new_lms[i - 1], new_lms[i])) {
				++rank;
			}
			ret[new_lms[i]] = rank;
		}
		if(rank + 1 < m) {
			std::vector<int> new_s(m);
			for(const auto i: std::views::iota(0, m)) {
				new_s[i] = ret[lms[i]];
			}
			const auto lms_sa = sa_is(new_s);
			for(const auto i: std::views::iota(0, m)) {
				new_lms[i] = lms[lms_sa[i]];
			}
		}
		induced_sort(new_lms);
		return ret;
	}
public:
	std::string vs;
	explicit SuffixArray(const std::string &vs, bool compress = false): vs(vs) {
		std::vector<int> new_vs(std::ssize(vs) + 1);
		if(compress) {
            std::string xs = vs;
            std::ranges::sort(xs);
			const auto it = std::ranges::unique(xs);
            xs.erase(it.begin(), it.end());
            for(const auto i: std::views::iota(0, std::ssize(vs))) {
                new_vs[i] = std::ranges::lower_bound(xs, vs[i]) - xs.cbegin() + 1;
            }
		} else {
            const auto d = *std::ranges::min_element(vs);
            for(const auto i: std::views::iota(0, std::ssize(vs))) {
                new_vs[i] = vs[i] - d + 1;
            }
		}
		const auto ret = sa_is(new_vs);
		assign(ret.cbegin(), ret.cend());
	}
	inline void output() const noexcept {
		for(const auto i: std::views::iota(0U, size())) {
            std::cout << i << ":[" << (*this)[i] << "]";
            for(const auto j: std::views::iota((*this)[i], std::ssize(vs))) {
                std::cout << " " << vs[j];
            }
            std::cout << "\n";
		}
	}
	constexpr inline bool lt_substr(const std::string &t, int si = 0, int ti = 0) noexcept {
		const int sn = std::ssize(vs), tn = std::ssize(t);
		while(si < sn && ti < tn) {
            if(vs[si] < t[ti]) {
                return true;
            }
            if(vs[si] > t[ti]) {
                return false;
            }
            ++si, ++ti;
		}
		return si >= sn && ti < tn;
	}
	inline int lower_bound(const std::string &t) noexcept {
		int ng = 0, ok = size();
		while(ok - ng > 1) {
            const int mid = (ok + ng) / 2;
            (lt_substr(t, (*this)[mid]) ? ng : ok) = mid;
		}
		return ok;
	}
	inline std::pair<int, int> equal_range(std::string t) noexcept {
		const int low = lower_bound(t);
		int ng = low - 1, ok = size();
		t.back()++;
		while(ok - ng > 1) {
            int mid = (ok + ng) / 2;
            (lt_substr(t, (*this)[mid]) ? ng : ok) = mid;
		}
		t.back()--;
		return {low, ok};
	}
	inline std::vector<int> lcp_array() const noexcept {
		const int n = size() - 1;
		std::vector<int> lcp(n + 1), rank(n + 1);
		for(const auto i: std::views::iota(0, n + 1)) {
		    rank[(*this)[i]] = i;
		}
		int h = 0;
		for(const auto i: std::views::iota(0, n + 1)) {
            if(rank[i] < n) {
                const int j = (*this)[rank[i] + 1];
                for(; j + h < n && i + h < n; ++h) {
                    if(vs[j + h] != vs[i + h]) {
                        break;
                    }
                }
                lcp[rank[i] + 1] = h;
                if(h > 0) {
                    h--;
                }
            }
		}
		return lcp;
	}
};
}

/**
 * @brief Suffix Array
 * @see https://ei1333.github.io/library/string/suffix-array.hpp
 */