#pragma once

#include <cassert>
#include <vector>
#include <algorithm>
struct UnionFind {
protected:
    std::vector<int> par;
public:
    UnionFind(const int n): par(n, -1){}
    int operator[](int i) {
        while(par[i] >= 0) {
            const int p = par[par[i]];
            if(p < 0) return par[i];
            i = par[i] = p;
        }
        return i;
    }
    bool unite(int x, int y) {
        x = (*this)[x], y = (*this)[y];
        if(x == y) return false;
        if(-par[x] < -par[y]) {
            std::swap(x, y);
        }
        par[x] += par[y], par[y] = x;
        return true;
    }
    int size(const int x) {
        return -par[(*this)[x]];
    }
    int size() const { return par.size(); }
#if __cplusplus >= 202101L
    std::vector<std::vector<int>> groups() {
        const int n = std::ssize(par);
        std::vector<std::vector<int>> res(n);
        for(int i = 0; i < n; ++i) {
            res[(*this)[i]].emplace_back(i);
        }
        const auto it = std::ranges::remove_if(res, [&](const std::vector<int> &v){ return v.empty(); });
        res.erase(it.begin(), it.end());
        return res;
    }
#else
    std::vector<std::vector<int>> groups() {
        const int n = par.size();
        std::vector<std::vector<int>> res(n);
        for(int i = 0; i < n; ++i) {
            res[(*this)[i]].emplace_back(i);
        }
        res.erase(std::remove_if(res.begin(), res.end(), [&](const std::vector<int> &v){ return v.empty(); }), res.end());
        return res;
    }
#endif
};

inline bool is_bipartite(UnionFind uf) {
    assert(uf.size() % 2 == 0);
    const int n = uf.size() / 2;
    bool ok = true;
    for(int i = 0; i < n; ++i) {
        ok &= uf[i] != uf[i + n];
    }
    return ok;
}
/**
 * @brief UnionFind
 * @see https://github.com/maspypy/library/blob/main/ds/unionfind/unionfind.hpp
 */