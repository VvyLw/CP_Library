#pragma once

#include <ostream>
#include <cassert>
#include <vector>
#include <algorithm>
#include <functional>
#include <cmath>
#include <limits>
#include <ranges>
namespace man {
template <class T, class U> struct LazySegTree {
private:
    using F = std::function<T(T, T)>;
    using M = std::function<T(T, U)>;
    using C = std::function<U(U, U)>;
    int n, sz, h;
    std::vector<T> data;
    std::vector<U> lazy;
    const F f;
    const M map;
    const C comp;
    const T e;
    const U id;
    inline void update(const int k){ data[k] = f(data[2 * k], data[2 * k + 1]); }
    inline void all_apply(const int k, const U &x) {
        data[k] = map(data[k], x);
        if(k < sz) {
            lazy[k] = comp(lazy[k], x);
        }
    }
    inline void propagate(const int k) {
        if(lazy[k] != id) {
            all_apply(2 * k, lazy[k]);
            all_apply(2 * k + 1, lazy[k]);
            lazy[k] = id;
        }
    }
public:
    LazySegTree(const int n, const F &f, const M &map, const C &comp, const T &e, const U &id): n(n), f(f), map(map), comp(comp), e(e), id(id) {
        sz = 1;
        h = 0;
        while(sz < n) {
            sz <<= 1;
            h++;
        }
        data.assign(2 * sz, e);
        lazy.assign(2 * sz, id);
    }
    LazySegTree(const std::vector<T> &v, const F &f, const M &map, const C &comp, const T &e, const U &id): LazySegTree(std::ssize(v), f, map, comp, e, id){ build(v); }
    void build(const std::vector<T> &v) {
        assert(n == std::ssize(v));
        for(const auto k: std::views::iota(0, n)) {
            data[k + sz] = v[k];
        }
        for(const auto k: std::views::iota(1, sz) | std::views::reverse) {
            update(k);
        }
    }
    void set(int k, const T &x) {
        k += sz;
        for(const auto i: std::views::iota(1) | std::views::take(h) | std::views::reverse) {
            propagate(k >> i);
        }
        data[k] = x;
        for(const auto i: std::views::iota(1) | std::views::take(h)) {
            update(k >> i);
        }
    }
    inline T &operator[](int k) noexcept {
        k += sz;
        for(const auto i: std::views::iota(1) | std::views::take(h) | std::views::reverse) {
            propagate(k >> i);
        }
        return data[k];
    }
    inline T const& operator[](const int k) const noexcept { return data[k + sz]; }
    inline T query(int l, int r) noexcept {
        if(l >= r) {
            return e;
        }
        l += sz;
        r += sz;
        for(const auto i: std::views::iota(1) | std::views::take(h) | std::views::reverse) {
            if(((l >> i) << i) != l) {
                propagate(l >> i);
            }
            if(((r >> i) << i) != r) {
                propagate((r - 1) >> i);
            }
        }
        T L = e, R = e;
        for(; l < r; l >>= 1, r >>= 1) {
            if(l & 1) {
                L = f(L, data[l++]);
            }
            if(r & 1) {
                R = f(data[--r], R);
            }
        }
        return f(L, R);
    }
    constexpr inline T all() const noexcept { return data[1]; }
    constexpr inline void apply(int k, const U &x) noexcept {
        k += sz;
        for(const auto i: std::views::iota(1) | std::views::take(h) | std::views::reverse) {
            propagate(k >> i);
        }
        data[k] = map(data[k], x);
        for(const auto i: std::views::iota(1) | std::views::take(h)) {
            update(k >> i);
        }
    }
    constexpr inline void apply(int l, int r, const U &x) noexcept {
        if(l >= r) {
            return;
        }
        l += sz;
        r += sz;
        for(const auto i: std::views::iota(1) | std::views::take(h) | std::views::reverse) {
            if(((l >> i) << i) != l) {
                propagate(l >> i);
            }
            if(((r >> i) << i) != r) {
                propagate((r - 1) >> i);
            }
        }
        int l2 = l, r2 = r;
        for(; l < r; l >>= 1, r >>= 1) {
            if(l & 1) {
                all_apply(l++, x);
            }
            if(r & 1) {
                all_apply(--r, x);
            }
        }
        l = l2, r = r2;
        for(const auto i: std::views::iota(1) | std::views::take(h)) {
            if(((l >> i) << i) != l) {
                update(l >> i);
            }
            if(((r >> i) << i) != r) {
                update((r - 1) >> i);
            }
        }
    }
    constexpr inline int size() const noexcept { return n; }
    template <class Boolean = bool> constexpr inline int find_first(int l, const Boolean &fn) noexcept {
        if(l >= n) {
            return n;
        }
        l += sz;
        for(const auto i: std::views::iota(1) | std::views::take(h) | std::views::reverse) {
            propagate(l >> i);
        }
        T sum = e;
        do {
            while((l & 1) == 0) {
                l >>= 1;
            }
            if(fn(f(sum, data[l]))) {
                while(l < sz) {
                    propagate(l);
                    l <<= 1;
                    const auto nxt = f(sum, data[l]);
                    if(!fn(nxt)) {
                        sum = nxt;
                        l++;
                    }
                }
                return l + 1 - sz;
            }
            sum = f(sum, data[l++]);
        } while((l & -l) != l);
        return n;
    }
    template <class Boolean = bool> constexpr inline int find_last(int r, const Boolean &fn) noexcept {
        if(r <= 0) {
            return -1;
        }
        r += sz;
        for(const auto i: std::views::iota(1) | std::views::take(h) | std::views::reverse) {
            propagate((r - 1) >> i);
        }
        T sum = e;
        do {
            r--;
            while(r > 1 && r & 1) {
                r >>= 1;
            }
            if(fn(f(data[r], sum))) {
                while(r < sz) {
                    propagate(r);
                    r = (r << 1) + 1;
                    const auto nxt = f(data[r], sum);
                    if(!fn(nxt)) {
                        sum = nxt;
                        r--;
                    }
                }
                return r - sz;
            }
            sum = f(data[r], sum);
        } while((r & -r) != r);
        return -1;
    }
    constexpr inline void clear() noexcept { std::ranges::fill(data, e); }
    inline friend std::ostream &operator<<(std::ostream &os, const LazySegTree &seg) noexcept {
        os << seg[0];
        for(int i = 0; ++i < seg.size();) {
            os << ' ' << seg[i];
        }
        return os;
    }
};

template <class T> struct zwei {
    T first, second;
    zwei(){}
    zwei(const T &f, const T &s): first(f), second(s){}
    constexpr bool operator!=(const zwei<T> &z) noexcept { return first != z.first || second != z.second; }
    operator T() const { return first; }
    friend std::ostream &operator<<(std::ostream &os, const zwei &z) {
        os << z.first;
        return os;
    }
};

template <class T> struct RAMX: LazySegTree<T, T> {    
    RAMX(const std::vector<T> &v): LazySegTree<T, T>(v, [](const T a, const T b){ return std::max(a, b); }, [](const T a, const T b){ return a + b; }, [](const T a, const T b){ return a + b; }, std::numeric_limits<T>::min(), 0){}
};
template <class T> struct RAMN: LazySegTree<T, T> {
    RAMN(const std::vector<T> &v): LazySegTree<T, T>(v, [](const T a, const T b){ return std::min(a, b); }, [](const T a, const T b){ return a + b; }, [](const T a, const T b){ return a + b; }, std::numeric_limits<T>::max(), 0){}
};
template <class T> struct RASM: LazySegTree<zwei<T>, T> {
    RASM(const std::vector<T> &v): LazySegTree<zwei<T>, T>(std::ssize(v), [](const zwei<T> a, const zwei<T> b){ return zwei<T>(a.first + b.first, a.second + b.second); }, [](const zwei<T> a, const T b){ return zwei<T>(a.first + a.second * b, a.second); }, [](const T a, const T b){ return a + b; }, zwei<T>(0, 0), 0) {
        std::vector<zwei<T>> w(std::ssize(v));
        for(const auto i: std::views::iota(0, std::ssize(v))) {
            w[i] = zwei<T>(v[i], 1);
        }
        LazySegTree<zwei<T>, T>::build(w);
    }
};
template <class T> struct RUMX: LazySegTree<T, T> {    
    RUMX(const std::vector<T> &v): LazySegTree<T, T>(v, [](const T a, const T b){ return std::max(a, b); }, [](const T, const T b){ return b; }, [](const T, const T b){ return b; }, std::numeric_limits<T>::min(), std::numeric_limits<T>::min()){}
};
template <class T> struct RUMN: LazySegTree<T, T> {
    RUMN(const std::vector<T> &v): LazySegTree<T, T>(v, [](const T a, const T b){ return std::min(a, b); }, [](const T, const T b){ return b; }, [](const T, const T b){ return b; }, std::numeric_limits<T>::max(), std::numeric_limits<T>::max()){}
};
template <class T> struct RUSM: LazySegTree<zwei<T>, T> {
    RUSM(const std::vector<T> &v): LazySegTree<zwei<T>, T>(std::ssize(v), [](const zwei<T> a, const zwei<T> b){ return zwei<T>(a.first + b.first, a.second + b.second); }, [](const zwei<T> a, const T b){ return zwei<T>(a.second * b, a.second); }, [](const T a, const T b){ return b; }, zwei<T>(0, 0), std::numeric_limits<T>::min()) {
        std::vector<zwei<T>> w(std::ssize(v));
        for(const auto i: std::views::iota(0, std::ssize(v))) {
            w[i] = zwei<T>(v[i], 1);
        }
        LazySegTree<zwei<T>, T>::build(w);
    }
};
}

/**
 * @brief 遅延セグ木
 * @see https://ei1333.github.io/library/structure/segment-tree/lazy-segment-tree.hpp
 */