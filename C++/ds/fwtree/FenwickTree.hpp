#pragma once

#include <vector>
#include <ranges>
namespace man {
template <class T> struct FenwickTree {
private:
    int n;
    std::vector<T> data;
    inline void init(const size_t size) noexcept {
        n = size + 2;
        data.resize(n + 1);
    }
public:
    FenwickTree(){}
    FenwickTree(const size_t size){ init(size); }
    FenwickTree(const std::vector<T> &a) {
        init(a.size());
        for(const auto i: std::views::iota(0, std::ssize(a))) {
            add(i, a[i]);
        }
    }
    constexpr inline T sum(int k) const noexcept {
        if(k < 0) {
            return 0;
        }
        T ret = 0;
        for(++k; k > 0; k -= k & -k) {
            ret += data[k];
        }
        return ret;
    }
    constexpr inline T sum(int l, int r) const noexcept { return sum(r) - sum(l - 1); }
    constexpr inline T operator[](int k) const noexcept { return sum(k) - sum(k - 1); }
    constexpr inline void add(int k, const T &x) noexcept {
        for(++k; k < n; k += k & -k) {
            data[k] += x;
        }
    }
    constexpr inline void add(const int l, const int r, const T& x) noexcept {
        add(l, x);
        add(r + 1, -x);
    }
    constexpr inline int lower_bound(T w) noexcept {
        if(w <= 0) {
            return 0;
        }
        int x = 0;
        for(int k = 1 << std::__lg(n); k > 0; k >>= 1) {
            if(x + k <= n - 1 && data[x + k] < w) {
                w -= data[x + k];
                x += k;
            }
        }
        return x;
    }
    constexpr inline int upper_bound(T w) noexcept {
        if(w < 0) {
            return 0;
        }
        int x = 0;
        for(int k = 1 << std::__lg(n); k > 0; k >>= 1) {
            if(x + k <= n - 1 && data[x + k] <= w) {
                w -= data[x + k];
                x += k;
            }
        }
        return x;
    }
};
}

/**
 * @brief Binary Indexed Tree
 * @see https://nyaannyaan.github.io/library/data-structure/binary-indexed-tree.hpp
 */