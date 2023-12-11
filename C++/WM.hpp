// inspired by ei1333( https://ei1333.github.io/library/structure/wavelet/wavelet-matrix.hpp )

#pragma once

#include <cassert>
#include <vector>
#include <algorithm>
#include <tuple>
struct SIDict {
private:
    int blk;
    std::vector<int> bit, sum;
public:
    SIDict(){}
    SIDict(const int len): blk((len + 31) >> 5), bit(blk), sum(blk){}
    void set(const int k){ bit[k >> 5] |= 1 << (k & 31); }
    void build() {
		sum[0] = 0;
		for(int i = 0; ++i < blk;) {
			sum[i] = sum[i - 1] + __builtin_popcount(bit[i - 1]);
		}
	}
    int rank(const int k) const { return (sum[k >> 5] + __builtin_popcount(bit[k >> 5] & ((1 << (k & 31)) - 1))); }
    int rank(const bool val, const int k) const { return val ? rank(k) : k - rank(k); }
    bool operator[](const int k) noexcept { return (bit[k >> 5] >> (k & 31)) & 1; }
};

template <class T, int log> struct WMBeta {
private:
    SIDict matrix[log];
    int mid[log];
    T access(int k) const {
        T ret = 0;
        for(int level = log; --level >= 0;) {
            const bool f = matrix[level][k];
            if(f) {
                ret |= (T)1 << level;
            }
            k = matrix[level].rank(f, k) + mid[level] * f;
        }
        return ret;
    }
    std::pair<int, int> succ(const bool f, const int l, const int r, const int level) const { return {matrix[level].rank(f, l) + mid[level] * f, matrix[level].rank(f, r) + mid[level] * f}; }
public:
    WMBeta(){}
    WMBeta(std::vector<T> v) {
        const int len = v.size();
        std::vector<T> l(len), r(len);
        for(int level = log; --level >= 0;) {
            matrix[level] = SIDict(len + 1);
            int left = 0, right = 0;
            for(int i = 0; i < len; ++i) {
                if((v[i] >> level) & 1) {
                    matrix[level].set(i);
                    r[right++] = v[i];
                }
                else {
                    l[left++] = v[i];
                }
            }
            mid[level] = left;
            matrix[level].build();
            v.swap(l);
            for(int i = 0; i < right; ++i) {
                v[left + i] = r[i];
            }
        }
    }
    T operator[](const int k) noexcept { return access(k); }
    int rank(const T x, int r) const {
        int l = 0;
        for(int level = log; --level >= 0;) {
            std::tie(l, r) = succ((x >> level) & 1, l, r, level);
        }
        return r - l;
    }
    T kth_min(int l, int r, int k) const {
        assert(0 <= k && k < r - l);
        T ret = 0;
        for(int level = log; --level >= 0;) {
            const int cnt = matrix[level].rank(false, r) - matrix[level].rank(false, l);
            const bool f = cnt <= k;
            if(f) {
                ret |= T(1) << level;
                k -= cnt;
            }
            std::tie(l, r) = succ(f, l, r, level);
        }
        return ret;
    }
    T kth_max(const int l, const int r, const int k) const { return kth_min(l, r, r - l - k - 1); }
    int range_freq(int l, int r, const T upper) const {
        int ret = 0;
        for(int level = log; --level;) {
            const bool f = (upper >> level) & 1;
            if(f) {
                ret += matrix[level].rank(false, r) - matrix[level].rank(false, l);
            }
            std::tie(l, r) = succ(f, l, r, level);
        }
        return ret;
    }
    int range_freq(const int l, const int r, const T lower, const T upper) const { return range_freq(l, r, upper) - range_freq(l, r, lower); }
    T prev(const int l, const int r, const T upper) const {
		const int cnt = range_freq(l, r, upper);
		return cnt == 0 ? (T)-1 : kth_min(l, r, cnt - 1);
	}
    T next(const int l, const int r, const T lower) const {
		const int cnt = range_freq(l, r, lower);
		return cnt == r - l ? (T)-1 : kth_min(l, r, cnt);
	}
};

template <class T, int log> struct WaveletMatrix {
private:
    WMBeta<int, log> mat;
    std::vector<T> ys;
    inline int get(const T x) const { return std::lower_bound(ys.cbegin(), ys.cend(), x) - ys.cbegin(); }
    T access(const int k) const { return ys[mat[k]]; }
public:
    WaveletMatrix(const std::vector<T> v): ys(v) {
        std::sort(ys.begin(), ys.end());
        ys.erase(std::unique(ys.begin(), ys.end()), ys.end());
        std::vector<int> t(v.size());
        for(int i = 0; auto &el: v) {
            t[i++] = get(el);
        }
        mat = WMBeta<int, log>(t);
    }
    T operator[](const int k) noexcept { return access(k); }
    int rank(const T x, const int r) const {
        const auto pos = get(x);
        if(pos == ys.size() || ys[pos] != x) {
            return 0;
        }
        return mat.rank(pos, r);
    }
    T kth_min(const int l, const int r, const int k) const { return ys[mat.kth_min(l, r, k)]; }
    T kth_max(const int l, const int r, const int k) const { return ys[mat.kth_max(l, r, k)]; }
    int range_freq(const int l, const int r, const T upper) const { return mat.range_freq(l, r, get(upper)); }
    int range_freq(const int l, const int r, const T lower, const T upper) const { return mat.range_freq(l, r, get(lower), get(upper)); }
    T prev(const int l, const int r, const T upper) {
        const auto ret = mat.prev(l, r, get(upper));
        return ret == -1 ? (T)-1 : ys[ret];
    }
    T next(const int l, const int r, const T lower) {
        const auto ret = mat.next(l, r, get(lower));
        return ret == -1 ? (T)-1 : ys[ret];
    }
};