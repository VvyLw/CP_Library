#pragma once

#pragma GCC diagnostic ignored "-Wreorder"

#include <vector>
#include <functional>
namespace man {
template <class T> struct DualSegTree {
private:
    using F = std::function<T(T, T)>;
    int sz, h;
    std::vector<T> lazy;
    const T id;
    const F ap;
    constexpr inline void propagate(const int k) noexcept {
        if(lazy[k] != id) {
            lazy[2 * k] = ap(lazy[2 * k], lazy[k]);
            lazy[2 * k + 1] = ap(lazy[2 * k + 1], lazy[k]);
            lazy[k] = id;
        }
    }
    constexpr inline void thrust(const int k) noexcept {
        for(int i = h; i > 0; i--) {
            propagate(k >> i);
        }
    }
public:
    DualSegTree(const int n, const F &ap, const T &id): ap(ap), id(id) {
        sz = 1;
        h = 0;
        while(sz < n) {
            sz <<= 1;
            h++;
        }
        lazy.assign(2 * sz, id);
    }
    constexpr inline void apply(int a, int b, const T &x) noexcept {
        thrust(a += sz);
        thrust(b += sz - 1);
        for(int l = a, r = b + 1; l < r; l >>= 1, r >>= 1) {
            if(l & 1) {
                lazy[l] = ap(lazy[l], x);
                l++;
            }
            if(r & 1) {
                r--;
                lazy[r] = ap(lazy[r], x);
            }
        }
    }
    constexpr inline T operator[](int k) noexcept {
        thrust(k += sz);
        return lazy[k];
    }
};
}

/**
 * @brief 双対セグ木
 * @see https://ei1333.github.io/library/structure/segment-tree/dual-segment-tree.hpp
 */