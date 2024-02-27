#pragma once

#include <vector>
struct UFPotential {
private:
    std::vector<int> par;
    std::vector<long long> diff;
public:
    UFPotential(const int n): par(n, -1), diff(n){}
    int root(const int i) {
        if(par[i] < 0) {
            return i;
        }
        const int r = root(par[i]);
        diff[i] += diff[par[i]];
        return par[i] = r;
    }
    long long dist(const int i) {
        root(i);
        return diff[i];
    }
    long long dist(const int x, const int y){ return dist(y) - dist(x); }
    int unite(int x, int y, long long w) {
        w += dist(y, x);
        x = root(x), y = root(y);
        if(x == y) {
            return w == 0 ? 0 : -1;
        }
        if(par[x] > par[y]) {
            std::swap(x, y);
            w = -w;
        }
        par[x] += par[y];
        par[y] = x;
        diff[y] = w;
        return 1;
    }
    int operator[](const int i) noexcept { return root(i); }
};
/**
 * @brief ポテンシャル付きUnionFind
 * @see https://github.com/tatyam-prime/kyopro_library/blob/master/UnionFind.cpp
 */