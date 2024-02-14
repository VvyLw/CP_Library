#pragma once

#include <ostream>
#include <cassert>
#include <vector>
#include <cmath>
#include <functional>
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
    LazySegTree(const std::vector<T> &v, const F &f, const M &map, const C &comp, const T &e, const U &id): LazySegTree(v.size(), f, map, comp, e, id){ build(v); }
    void build(const std::vector<T> &v) {
        assert(n == (int) v.size());
        for(int k = 0; k < n; ++k) {
            data[k + sz] = v[k];
        }
        for(int k = sz; --k > 0;) {
            update(k);
        }
    }
    void set(int k, const T &x) {
        k += sz;
        for(int i = h; i > 0; i--) {
            propagate(k >> i);
        }
        data[k] = x;
        for(int i = 0; ++i <= h;) {
            update(k >> i);
        }
    }
    T &operator[](int k) {
        k += sz;
        for(int i = h; i > 0; i--) {
            propagate(k >> i);
        }
        return data[k];
    }
    T const& operator[](const int k) const { return data[k + sz]; }
    T query(int l, int r) {
        if(l >= r) {
            return e;
        }
        l += sz;
        r += sz;
        for(int i = h; i > 0; i--) {
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
    T all() const { return data[1]; }
    void apply(int k, const U &x) {
        k += sz;
        for(int i = h; i > 0; i--) {
            propagate(k >> i);
        }
        data[k] = map(data[k], x);
        for(int i = 0; ++i <= h;) {
            update(k >> i);
        }
    }
    void apply(int l, int r, const U &x) {
        if(l >= r) {
            return;
        }
        l += sz;
        r += sz;
        for(int i = h; i > 0; i--) {
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
        for(int i = 0; ++i <= h;) {
            if(((l >> i) << i) != l) {
                update(l >> i);
            }
            if(((r >> i) << i) != r) {
                update((r - 1) >> i);
            }
        }
    }
    inline int size() const { return n; }
    template <class Boolean> int find_first(int l, const Boolean &fn) {
        if(l >= n) {
            return n;
        }
        l += sz;
        for(int i = h; i > 0; i--) {
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
    template <class Boolean> int find_last(int r, const Boolean &fn) {
        if(r <= 0) {
            return -1;
        }
        r += sz;
        for(int i = h; i > 0; i--) {
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
    void clear() {
        for(auto &el: data) {
            el = e;
        }
    }
    friend std::ostream &operator<<(std::ostream &os, const LazySegTree &seg) {
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
    operator T(){ return first; }
    friend std::ostream &operator<<(std::ostream &os, const zwei &z) {
        os << z.first;
        return os;
    }
};

template <class T> struct RAMX: LazySegTree<T, T> {    
    RAMX(const std::vector<T> &v, const T &e): LazySegTree<T, T>(v, [](const T a, const T b){ return std::max(a, b); }, [](const T a, const T b){ return a + b; }, [](const T a, const T b){ return a + b; }, e, 0){}
};
template <class T> struct RAMN: LazySegTree<T, T> {
    RAMN(const std::vector<T> &v, const T &e): LazySegTree<T, T>(v, [](const T a, const T b){ return std::min(a, b); }, [](const T a, const T b){ return a + b; }, [](const T a, const T b){ return a + b; }, e, 0){}
};
template <class T> struct RUMX: LazySegTree<T, T> {    
    RUMX(const std::vector<T> &v, const T &eid): LazySegTree<T, T>(v, [](const T a, const T b){ return std::max(a, b); }, [](const T, const T b){ return b; }, [](const T, const T b){ return b; }, eid, eid){}
};
template <class T> struct RUMN: LazySegTree<T, T> {
    RUMN(const std::vector<T> &v, const T &eid): LazySegTree<T, T>(v, [](const T a, const T b){ return std::min(a, b); }, [](const T, const T b){ return b; }, [](const T, const T b){ return b; }, eid, eid){}
};
template <class T> struct RUSM: LazySegTree<zwei<T>, T> {
    RUSM(const std::vector<T> &v, const T &id): LazySegTree<zwei<T>, T>(v.size(), [](const zwei<T> a, const zwei<T> b){ return zwei<T>(a.first * b.first, a.second * b.second); }, [](const zwei<T> a, const T b){ return zwei<T>(a.second * b, a.second); }, [](const T a, const T b){ return a + b; }, zwei<T>(0, 0), id) {
        std::vector<zwei<T>> w(v.size());
        for(size_t i = 0; i < v.size(); ++i) {
            w[i] = zwei<T>(v[i], 1);
        }
        LazySegTree<zwei<T>, T>::build(w);
    }
};

/**
 * @brief 遅延セグ木
 * @see https://ei1333.github.io/library/structure/segment-tree/lazy-segment-tree.hpp
 */