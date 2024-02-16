#pragma once

#include "C++/FenwickTree.hpp"
template <class T> struct RangeBIT {
private:
    FenwickTree<T> a, b;
public:
    RangeBIT(const int n): a(n + 1), b(n + 1){}
    RangeBIT(const std::vector<T> &v) {
        this(v.size());
        for(size_t i = 0; i < v.size(); ++i) {
            add(i, i + 1, v[i]);
        }
    }
    void add(const int l, const int r, const T &x) {
        a.add(l, x);
        a.add(r, -x);
        b.add(l, x * (1 - l));
        b.add(r, x * (r - 1));
    }
    inline T operator[](const int i) const { return sum(i, i + 1); }
    inline T sum(int l, int r) {
        l--, r--;
        return a.sum(r) * r + b.sum(r) - a.sum(l) * l - b.sum(l);
    }
};