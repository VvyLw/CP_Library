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
    int n, log, s;
    std::vector<T> val;
    std::vector<U> lazy;
    const F f;
    const T e;
    const M map;
    const C comp;
    const U id;
    void push(const int i) {
        if(lazy[i] != id) {
            val[2 * i + 0] = map(val[2 * i + 0], lazy[i]);
            val[2 * i + 1] = map(val[2 * i + 1], lazy[i]);
            if(2 * i < n) {
                compose(lazy[2 * i + 0], lazy[i]);
                compose(lazy[2 * i + 1], lazy[i]);
            }
            lazy[i] = id;
        }
    }
    inline void upd(const int i){ val[i] = f(val[2 * i + 0], val[2 * i + 1]); }
    inline void apply(int i, const U& x) {
        if(x != id) {
            val[i] = map(val[i], x);
            if(i < n) {
                compose(lazy[i], x);
            }
        }
    }
    inline void compose(U& a, const U& b){ a = a == id ? b : comp(a, b); }
public:
    LazySegTree(const int s, const F &f, const M &map, const C &comp, const T e, const U id): s(s), f(f), map(map), comp(comp), e(e), id(id){}
    LazySegTree(const std::vector<T> &v, const F &f, const M &map, const C &comp, const T e, const U id): s(v.size()), f(f), map(map), comp(comp), e(e), id(id){}
    void init(const std::vector<T> &v) {
        n = 1, log = 0;
        while(n < s) {
            n <<= 1;
            log++;
        }
        val.resize(2 * n, e);
        lazy.resize(n, id);
        for(int i = 0; i < s; ++i) {
            val[i + n] = v[i];
        }
        for(int i = n - 1; i--;) {
            upd(i);
        }
    }
    void set(const int k, const U &x){ update(k, k + 1, x); }
    void update(int l, int r, const U& x) {
        if(l == r) {
            return;
        }
        l += n, r += n;
        for(int i = log; i >= 1; i--) {
            if(((l >> i) << i) != l) {
                push(l >> i);
            }
            if(((r >> i) << i) != r) {
                push((r - 1) >> i);
            }
        }
        for(int p = l, q = r; p < q; p >>= 1, q >>= 1) {
            if(p & 1) {
                apply(p++, x);
            }
            if(q & 1) {
                apply(--q, x);
            }
        }
        for(int i = 1; i <= log; ++i) {
            if(((l >> i) << i) != l) {
                upd(l >> i);
            }
            if(((r >> i) << i) != r) {
                upd((r - 1) >> i);
            }
        }
    }
    T query(int l, int r) {
        if(l == r) {
            return e;
        }
        l += n, r += n;
        T L = e, R = e;
        for(int i = log; i >= 1; i--) {
            if(((l >> i) << i) != l) {
                push(l >> i);
            }
            if(((r >> i) << i) != r) {
                push((r - 1) >> i);
            }
        }
        while(l < r) {
            if(l & 1) {
                L = f(L, val[l++]);
            }
            if(r & 1) {
                R = f(val[--r], R);
            }
            l >>= 1;
            r >>= 1;
        }
        return f(L, R);
    }
    T const& operator[](const int k) const { return val[k + n]; }
    T &operator[](int k) {
        k += n;
        for(int i = log; i >= 1; i--) {
            if(((k >> i) << i) != k || (((k + 1) >> i) << i) != (k + 1)) {
                push(k >> i);
            }
        }
        return val[k];
    }
    inline int size() const { return s; }
    template <class Boolean> int max_right(int l, const Boolean &fn) {
        assert(0 <= l && l <= s);
        assert(fn(id));
        if(l == n) {
            return n;
        }
        l += n;
        for(int i = log; i >= 1; i--) {
            push(l >> i);
        }
        T sm = e;
        do {
            while(l & 1 == 0) {
                l >>= 1;
            }
            if(!fn(f(sm, val[l]))) {
                while(l < n) {
                    push(l);
                    l = (2 * l);
                    if(fn(f(sm, val[l]))) {
                        sm = f(sm, val[l]);
                        l++;
                    }
                }
                return l - n;
            }
            sm = f(sm, val[l]);
            l++;
        } while((l & -l) != l);
        return s;
    }
    template <class Boolean> int min_left(int r, const Boolean &fn) {
        assert(0 <= r && r <= s);
        assert(fn(id));
        if(r == 0) {
            return 0;
        }
        r += n;
        for(int i = log; i >= 1; i--) {
            push((r - 1) >> i);
        }
        T sm = e;
        do {
            r--;
            while(r > 1 && (r & 1)) {
                r >>= 1;
            }
            if(!fn(f(val[r], sm))) {
                while(r < n) {
                    push(r);
                    r = 2 * r + 1;
                    if(fn(f(val[r], sm))) {
                        sm = f(val[r], sm);
                        r--;
                    }
                }
                return r + 1 - n;
            }
            sm = f(val[r], sm);
        } while((r & -r) != r);
        return 0;
    }
    void clear() {
        for(auto& el: val) {
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

template <class T> struct RAQRMX: LazySegTree<T, T> {    
    RAQRMX(const std::vector<T> &v, const T &e): LazySegTree<T, T>(v, [](const T a, const T b){ return std::max(a, b); }, [](const T a, const T b){ return a + b; }, [](const T a, const T b){ return a + b; }, e, 0){ LazySegTree<T, T>::init(v); }
};
template <class T> struct RAQRMN: LazySegTree<T, T> {
    RAQRMN(const std::vector<T> &v, const T &e): LazySegTree<T, T>(v, [](const T a, const T b){ return std::min(a, b); }, [](const T a, const T b){ return a + b; }, [](const T a, const T b){ return a + b; }, e, 0){ LazySegTree<T, T>::init(v); }
};
template <class T> struct RAQRSM: LazySegTree<zwei<T>, T> {
    RAQRSM(const std::vector<T> &v): LazySegTree<zwei<T>, T>(v.size(), [](const zwei<T> a, const zwei<T> b){ return zwei<T>(a.first * b.first, a.second * b.second); }, [](const zwei<T> a, const T b){ return zwei<T>(a.first + a.second * b, a.second); }, [](const T a, const T b){ return a + b; }, zwei<T>(0, 0), 0) {
        std::vector<zwei<T>> w(v.size());
        for(size_t i = 0; i < v.size(); ++i) {
            w[i] = zwei<T>(v[i], 1);
        }
        LazySegTree<zwei<T>, T>::init(w);
    }
};
template <class T> struct RUQRMX: LazySegTree<T, T> {    
    RUQRMX(const std::vector<T> &v, const T &eid): LazySegTree<T, T>(v, [](const T a, const T b){ return std::max(a, b); }, [](const T, const T b){ return b; }, [](const T, const T b){ return b; }, eid, eid){ LazySegTree<T, T>::init(v); }
};
template <class T> struct RUQRMN: LazySegTree<T, T> {
    RUQRMN(const std::vector<T> &v, const T &eid): LazySegTree<T, T>(v, [](const T a, const T b){ return std::min(a, b); }, [](const T, const T b){ return b; }, [](const T, const T b){ return b; }, eid, eid){ LazySegTree<T, T>::init(v); }
};
template <class T> struct RUQRSM: LazySegTree<zwei<T>, T> {
    RUQRSM(const std::vector<T> &v, const T &id): LazySegTree<zwei<T>, T>(v.size(), [](const zwei<T> a, const zwei<T> b){ return zwei<T>(a.first * b.first, a.second * b.second); }, [](const zwei<T> a, const T b){ return zwei<T>(a.first + a.second * b, a.second); }, [](const T a, const T b){ return a + b; }, zwei<T>(0, 0), id) {
        std::vector<zwei<T>> w(v.size());
        for(size_t i = 0; i < v.size(); ++i) {
            w[i] = zwei<T>(v[i], 1);
        }
        LazySegTree<zwei<T>, T>::init(w);
    }
};

/**
 * @brief 遅延セグ木
 * @see https://nyaannyaan.github.io/library/segment-tree/lazy-segment-tree-utility.hpp
 */