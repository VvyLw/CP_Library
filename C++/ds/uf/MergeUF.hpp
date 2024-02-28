#pragma once

#include "C++/ds/uf/UnionFind.hpp"
template <class T> struct MergeUF: UnionFind {
    using UnionFind::par;
    using UnionFind::operator[];
    using UnionFind::size;
    using UnionFind::groups;
    MergeUF(const int n): UnionFind(n){}
    ~MergeUF(){}
    virtual T get(const int i) = 0;
    virtual void merge(const int i, const int j) = 0;
    bool unite(int x, int y) {
        x = (*this)[x], y = (*this)[y];
        if(x == y) return false;
        if(-par[x] < -par[y]) {
            std::swap(x, y);
        }
        par[x] += par[y], par[y] = x;
		merge(x, y);
		return true;
	}
};
/**
 * @brief MergeUnionFind
 */