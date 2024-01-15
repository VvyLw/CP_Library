#pragma once

// inspired by Nyaan( https://github.com/NyaanNyaan/library/blob/master/data-structure/binary-indexed-tree.hpp )
#include <vector>
template <class T> struct FenwickTree {
private:
    int N;
    std::vector<T> data;
    void init(const size_t size) {
        N = size + 2;
        data.assign(N + 1, {});
    }
public:
    FenwickTree(){}
    FenwickTree(size_t size){ init(size); }
    FenwickTree(const std::vector<T> &a) {
        init(a.size());
        for(size_t i = 0; i < a.size(); ++i) {
            add(i, a[i]);
        }
    }
    // get sum of [0,k]
    T sum(int k) const {
        if(k < 0) return T{};  // return 0 if k < 0
        T ret{};
        for(++k; k > 0; k -= k & -k) ret += data[k];
        return ret;
    }
    // getsum of [l,r]
    inline T sum(int l, int r) const { return sum(r) - sum(l - 1); }
    // get value of k
    inline T operator[](int k) const { return sum(k) - sum(k - 1); }
    // data[k] += x
    void add(int k, T x) {
        for(++k; k < N; k += k & -k) data[k] += x;
    }
    // range add x to [l,r]
    void imos(int l, int r, T x) {
        add(l, x);
        add(r + 1, -x);
    }
    // minimize i s.t. sum(i) >= w
    int lower_bound(T w) {
        if(w <= 0) return 0;
        int x = 0;
        for(int k = 1 << std::__lg(N); k; k >>= 1) {
            if(x + k <= N - 1 && data[x + k] < w) {
                w -= data[x + k];
                x += k;
            }
        }
        return x;
    }
    // minimize i s.t. sum(i) > w
    int upper_bound(T w) {
        if(w < 0) return 0;
        int x = 0;
        for(int k = 1 << std::__lg(N); k; k >>= 1) {
            if(x + k <= N - 1 && data[x + k] <= w) {
                w -= data[x + k];
                x += k;
            }
        }
        return x;
    }
};

#include <algorithm>
template <class T> inline long long inv_num(const std::vector<T> &a) {
    std::vector<std::pair<T, int>> p(a.size());
    for(size_t i = 0; i < a.size(); ++i) {
        p[i] = {a[i], i};
    }
    std::sort(p.begin(), p.end());
    std::vector<int> id(a.size());
    for(int i = 0; i < a.size(); ++i) {
        id[p[i].second] = i;
    }
    FenwickTree<T> bit(a.size());
    long long res = 0;
    for(size_t i = 0; i < a.size(); ++i) {
        res += i - bit.sum(id[i]);
        bit.add(id[i], 1);
    }
    return res;
}