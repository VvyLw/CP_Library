#pragma once

#include <cassert>
#include <vector>
#include <algorithm>
#include <tuple>
#include <ranges>
namespace man {
namespace internal {
struct SIDict {
private:
    int blk;
    std::vector<int> bit, sum;
public:
    SIDict(){}
    SIDict(const int len): blk((len + 31) >> 5), bit(blk), sum(blk){}
    inline void set(const int k) noexcept { bit[k >> 5] |= 1 << (k & 31); }
    inline void build() noexcept {
		sum[0] = 0;
		for(const auto i: std::views::iota(0, blk - 1)) {
			sum[i + 1] = sum[i] + __builtin_popcount(bit[i]);
		}
	}
    inline int rank(const int k) const noexcept { return (sum[k >> 5] + __builtin_popcount(bit[k >> 5] & ((1 << (k & 31)) - 1))); }
    inline int rank(const bool val, const int k) const noexcept { return val ? rank(k) : k - rank(k); }
    inline bool operator[](const int k) noexcept { return (bit[k >> 5] >> (k & 31)) & 1; }
};

template <std::integral T, int log> struct WMBeta {
private:
    SIDict matrix[log];
    int mid[log];
    constexpr inline T access(int k) const noexcept {
        T ret = 0;
        for(const auto level: std::views::iota(0, log) | std::views::reverse) {
            const bool f = matrix[level][k];
            if(f) {
                ret |= (T) 1 << level;
            }
            k = matrix[level].rank(f, k) + mid[level] * f;
        }
        return ret;
    }
    constexpr inline std::pair<int, int> succ(const bool f, const int l, const int r, const int level) const noexcept { return {matrix[level].rank(f, l) + mid[level] * f, matrix[level].rank(f, r) + mid[level] * f}; }
public:
    WMBeta(){}
    WMBeta(std::vector<T> v) {
        const int len = std::ssize(v);
        std::vector<T> l(len), r(len);
        for(const auto level: std::views::iota(0, log) | std::views::reverse) {
            matrix[level] = SIDict(len + 1);
            int left = 0, right = 0;
            for(const auto i: std::views::iota(0, len)) {
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
            for(const auto i: std::views::iota(0, right)) {
                v[left + i] = r[i];
            }
        }
    }
    constexpr inline T operator[](const int k) const noexcept { return access(k); }
    constexpr inline int rank(const T x, int r) const noexcept {
        int l = 0;
        for(const auto level: std::views::iota(0, log) | std::views::reverse) {
            std::tie(l, r) = succ((x >> level) & 1, l, r, level);
        }
        return r - l;
    }
    constexpr inline T kth_min(int l, int r, int k) const noexcept {
        assert(0 <= k && k < r - l);
        T ret = 0;
        for(const auto level: std::views::iota(0, log) | std::views::reverse) {
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
    constexpr inline T kth_max(const int l, const int r, const int k) const noexcept{ return kth_min(l, r, r - l - k - 1); }
    constexpr inline int range_freq(int l, int r, const T upper) const noexcept {
        int ret = 0;
        for(const auto level: std::views::iota(0, log) | std::views::reverse) {
            const bool f = (upper >> level) & 1;
            if(f) {
                ret += matrix[level].rank(false, r) - matrix[level].rank(false, l);
            }
            std::tie(l, r) = succ(f, l, r, level);
        }
        return ret;
    }
    constexpr inline int range_freq(const int l, const int r, const T lower, const T upper) const noexcept { return range_freq(l, r, upper) - range_freq(l, r, lower); }
    constexpr inline T prev(const int l, const int r, const T upper) const noexcept {
		const int cnt = range_freq(l, r, upper);
		return cnt == 0 ? (T)-1 : kth_min(l, r, cnt - 1);
	}
    constexpr inline T next(const int l, const int r, const T lower) const noexcept {
		const int cnt = range_freq(l, r, lower);
		return cnt == r - l ? (T)-1 : kth_min(l, r, cnt);
	}
};
}

template <std::integral T, int log = 20> struct WaveletMatrix {
private:
    internal::WMBeta<int, log> mat;
    std::vector<T> ys;
    constexpr inline int get(const T x) const noexcept { return std::ranges::lower_bound(ys, x) - ys.cbegin(); }
    constexpr inline T access(const int k) const noexcept { return ys[mat[k]]; }
public:
    WaveletMatrix(const std::vector<T> v): ys(v) {
        std::sort(ys.begin(), ys.end());
        const auto it = std::ranges::unique(ys);
        ys.erase(it.begin(), it.end());
        std::vector<int> t(v.size());
        for(int i = 0; auto &el: v) {
            t[i++] = get(el);
        }
        mat = internal::WMBeta<int, log>(t);
    }
    constexpr inline T operator[](const int k) const noexcept { return access(k); }
    constexpr inline int rank(const int r, const T x) const noexcept {
        const auto pos = get(x);
        if(pos == std::ssize(ys) || ys[pos] != x) {
            return 0;
        }
        return mat.rank(pos, r);
    }
    constexpr inline int rank(const int l, const int r, const T x) const noexcept { return rank(r, x) - rank(l, x); }
    constexpr inline T kth_min(const int l, const int r, const int k) const noexcept { return ys[mat.kth_min(l, r, k)]; }
    constexpr inline T kth_max(const int l, const int r, const int k) const noexcept { return ys[mat.kth_max(l, r, k)]; }
    constexpr inline int range_freq(const int l, const int r, const T upper) const noexcept { return mat.range_freq(l, r, get(upper)); }
    constexpr inline int range_freq(const int l, const int r, const T lower, const T upper) const noexcept { return mat.range_freq(l, r, get(lower), get(upper)); }
    constexpr inline T prev(const int l, const int r, const T upper) noexcept {
        const auto ret = mat.prev(l, r, get(upper));
        return ret == -1 ? (T)-1 : ys[ret];
    }
    constexpr inline T next(const int l, const int r, const T lower) noexcept {
        const auto ret = mat.next(l, r, get(lower));
        return ret == -1 ? (T)-1 : ys[ret];
    }
};
}
/**
 * @brief Wavelet Matrix
 * @see https://ei1333.github.io/library/structure/wavelet/wavelet-matrix.hpp
 */