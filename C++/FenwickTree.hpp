#pragma once

#include <vector>
template <class T> struct FenwickTree {
private:
    int n;
    std::vector<T> data;
    void init(const size_t size) {
        n = size + 2;
        data.resize(n + 1);
    }
public:
    FenwickTree(){}
    FenwickTree(const size_t size){ init(size); }
    FenwickTree(const std::vector<T> &a) {
        init(a.size());
        for(size_t i = 0; i < a.size(); ++i) {
            add(i, a[i]);
        }
    }
    T sum(int k) const {
        if(k < 0) {
            return 0;
        }
        T ret = 0;
        for(++k; k > 0; k -= k & -k) {
            ret += data[k];
        }
        return ret;
    }
    inline T sum(int l, int r) const { return sum(r) - sum(l - 1); }
    inline T operator[](int k) const { return sum(k) - sum(k - 1); }
    void add(int k, const T &x) {
        for(++k; k < n; k += k & -k) {
            data[k] += x;
        }
    }
    void add(const int l, const int r, const T& x) {
        add(l, x);
        add(r + 1, -x);
    }
    int lower_bound(T w) {
        if(w <= 0) {
            return 0;
        }
        int x = 0;
        for(int k = 1 << std::__lg(n); k; k >>= 1) {
            if(x + k <= n - 1 && data[x + k] < w) {
                w -= data[x + k];
                x += k;
            }
        }
        return x;
    }
    int upper_bound(T w) {
        if(w < 0) {
            return 0;
        }
        int x = 0;
        for(int k = 1 << std::__lg(n); k; k >>= 1) {
            if(x + k <= n - 1 && data[x + k] <= w) {
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
    for(size_t i = 0; i < a.size(); ++i) {
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
/**
 * @brief Binary Indexed Tree
 * @see https://nyaannyaan.github.io/library/data-structure/binary-indexed-tree.hpp
 */