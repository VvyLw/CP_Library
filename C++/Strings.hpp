#pragma once

#include <iostream>
#include <cassert>
#include <vector>
#include <algorithm>
#include <numeric>
#include <chrono>
typedef long long ll;
typedef unsigned long long ul;
typedef __uint128_t u128;

std::string rle(const std::string &s) {
	const int n = s.size();
	std::string t;
	for(int l = 0; l < n;) {
		int r = l + 1;
		for(; r < n && s[l] == s[r]; ++r){}
		t += s[l];
		t += std::to_string(r - l);
		l = r;
	}
	return t;
}

std::string rle_rev(const std::string &s) {
	const int n = s.size();
	std::string t;
	for(int l = 0; l < n;) {
		int r = l + 1;
		for(; r < n && '0' <= s[r] && s[r] <= '9'; ++r){}
		t += std::string(std::stoi(s.substr(l + 1, r - l)), s[l]);
		l = r;
	}
	return t;
}

std::vector<int> manacher(std::string s, const bool calc_even = true) {
    int n = s.size();
    if(calc_even) {
        assert(n > 0);
        s.resize(2 * n - 1);
        for(int i = n; --i >= 0;) {
            s[2 * i] = s[i];
        }
        const auto d = *std::min_element(s.begin(), s.end());
        for(int i = 0; i < n - 1; ++i) {
            s[2 * i + 1] = d;
        }
    }
    n = s.size();
    std::vector<int> rad(n);
    for(int i = 0, j = 0; i < n;) {
        while(i - j >= 0 && i + j < n && s[i - j] == s[i + j]) {
            ++j;
        }
        rad[i] = j;
        int k = 1;
        while(i - k >= 0 && i + k < n && k + rad[i - k] < j) {
            rad[i + k] = rad[i - k];
            ++k;
        }
        i += k, j -= k;
    }
    if(calc_even) {
        for(int i = 0; i < n; ++i) {
            if(((i ^ rad[i]) & 1) == 0) {
                rad[i]--;
            }
        }
    }
    else {
        for(auto &x: rad) x = 2 * x - 1;
    }
    return rad;
}

std::vector<ll> zalg(const std::string &s) {
    const ll n = s.size();
    ll j = 0;
    std::vector<ll> pre(n);
    for(ll i = 1; i < n; ++i) {
        if(i + pre[i - j] < j + pre[j]) pre[i] = pre[i - j];
        else {
            ll k = std::max(0LL, j + pre[j] - i);
            while(i + k < n && s[k] == s[i + k]) ++k;
            pre[i] = k;
            j = i;
        }
    }
    pre.front() = n;
    return pre;
}

// inspired by ei1333( https://ei1333.github.io/library/string/suffix-array.hpp )
struct SuffixArray : std::vector<int> {
private:
    std::vector<int> sa_is(const std::vector<int> &s) const {
    	const int n = s.size();
    	std::vector<int> ret(n), is_s(n), is_lms(n);;
    	int m = 0;
    	for(int i = n - 2; i >= 0; i--) {
      		is_s[i] = (s[i] > s[i + 1]) || (s[i] == s[i + 1] && is_s[i + 1]);
      		m += is_lms[i + 1] = is_s[i] && !is_s[i + 1];
    	}
    	const auto induced_sort = [&](const std::vector<int> &lms) -> void {
      		const int upper = *std::max_element(s.begin(), s.end());
      		std::vector<int> l(upper + 2), r(upper + 2);
			for(const auto &v: s) {
				++l[v + 1];
				++r[v];
			}
			std::partial_sum(l.begin(), l.end(), l.begin());
			std::partial_sum(r.begin(), r.end(), r.begin());
			ret.assign(ret.size(), -1);
			for(int i = std::ssize(lms); --i >= 0;) {
				ret[--r[s[lms[i]]]] = lms[i];
			}
			for(const auto &v: ret) {
				if(v >= 1 && is_s[v - 1]) {
					ret[l[s[v - 1]]++] = v - 1;
				}
			}
			r.assign(r.size(), 0);
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
		for(int i = 0; ++i < n;) {
			if(is_lms[i]) {
				lms.emplace_back(i);
			}
		}
		induced_sort(lms);
		new_lms.reserve(m);
		for(int i = 0; i < n; ++i) {
			if(!is_s[ret[i]] && ret[i] > 0 && is_s[ret[i] - 1]) {
				new_lms.emplace_back(ret[i]);
			}
		}
		const auto same = [&](int a, int b) -> bool {
			if(s[a++] != s[b++]) {
				return false;
			}
			while(1) {
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
		for(int i = 0; ++i < m;) {
			if(!same(new_lms[i - 1], new_lms[i])) {
				++rank;
			}
			ret[new_lms[i]] = rank;
		}
		if(rank + 1 < m) {
			std::vector<int> new_s(m);
			for(int i = 0; i < m; ++i) {
				new_s[i] = ret[lms[i]];
			}
			const auto lms_sa = sa_is(new_s);
			for(int i = 0; i < m; ++i) {
				new_lms[i] = lms[lms_sa[i]];
			}
		}
		induced_sort(new_lms);
		return ret;
	}
public:
	std::string vs;
	explicit SuffixArray(const std::string &vs, bool compress = false): vs(vs) {
		std::vector<int> new_vs(vs.size() + 1);
		if(compress) {
		std::string xs = vs;
		std::sort(xs.begin(), xs.end());
		xs.erase(std::unique(xs.begin(), xs.end()), xs.end());
		for(size_t i = 0; i < vs.size(); ++i) {
			new_vs[i] = std::lower_bound(xs.begin(), xs.end(), vs[i]) - xs.begin() + 1;
		}
		}
		else {
		const auto d = *std::min_element(vs.begin(), vs.end());
		for(size_t i = 0; i < vs.size(); ++i) {
			new_vs[i] = vs[i] - d + 1;
		}
		}
		const auto ret = sa_is(new_vs);
		assign(ret.begin(), ret.end());
	}
	void output() const {
		for(size_t i = 0; i < size(); ++i) {
		std::cout << i << ":[" << (*this)[i] << "]";
		for(size_t j = (*this)[i]; j < vs.size(); ++j) {
			std::cout << " " << vs[j];
		}
		std::cout << "\n";
		}
	}
	bool lt_substr(const std::string &t, int si = 0, int ti = 0) {
		const int sn = vs.size(), tn = t.size();
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
	int lower_bound(const std::string &t) {
		int ng = 0, ok = size();
		while(ok - ng > 1) {
		const int mid = (ok + ng) / 2;
		(lt_substr(t, (*this)[mid]) ? ng : ok) = mid;
		}
		return ok;
	}
	std::pair<int, int> equal_range(std::string t) {
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
	std::vector<int> lcp_array() const {
		const int n = size() - 1;
		std::vector<int> lcp(n + 1), rank(n + 1);
		for(int i = 0; i <= n; ++i) {
		rank[(*this)[i]] = i;
		}
		int h = 0;
		for(int i = 0; i <= n; ++i) {
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

// inspired by tatyam( https://github.com/tatyam-prime/kyopro_library/blob/master/RollingHash.cpp )
#ifndef TEMPLATE
const ul LINF = (1LL << 61) - 1;
#endif
const ul base = std::chrono::duration_cast<std::chrono::microseconds>(std::chrono::system_clock::now().time_since_epoch()).count() % LINF;
template <ul mod> struct RollingHash {
private:
    std::vector<ul> hashed, power;
    static constexpr ul mask(const ll a){ return (1ULL << a) - 1; }
    inline ul mul(const ul a, const ul b) const {
        u128 ans = u128(a) * b;
        ans = (ans >> 61) + (ans & mod);
        if(ans >= mod) ans -= mod;
        return ans;
    }
public:
    RollingHash(const std::string &s) {
        const ll n = s.size();
        hashed.resize(n + 1);
        power.resize(n + 1);
        power[0] = 1;
        for(ll i = 0; i < n; ++i) {
            power[i + 1] = mul(power[i], base);
            hashed[i + 1] = mul(hashed[i], base) + s[i];
            if(hashed[i + 1] >= mod) hashed[i + 1] -= mod;
        }
    }
    ul get(const ll l, const ll r) const {
        ul ret = hashed[r] + mod - mul(hashed[l], power[r - l]);
        if(ret >= mod) ret -= mod;
        return ret;
    }
    ul connect(const ul h1, const ul h2, const ll h2len) const {
        ul ret = mul(h1, power[h2len]) + h2;
        if(ret >= mod) ret -= mod;
        return ret;
    }
    ll LCP(const RollingHash &b, ll l1, ll r1, ll l2, ll r2) {
        ll low = -1, high = std::min(r1 - l1, r2 - l2) + 1;
        while(high - low > 1) {
            const ll mid = (low + high) / 2;
            if(get(l1, l1 + mid) == b.get(l2, l2 + mid)) low = mid;
            else high = mid;
        }
        return low;
    }
};
using RH = RollingHash<LINF>;