#pragma once

#include <vector>
namespace man {
struct UFPotential {
private:
    std::vector<int> par;
    std::vector<int64_t> diff;
public:
    UFPotential(const int n): par(n, -1), diff(n){}
    inline int root(const int i) noexcept {
        if(par[i] < 0) {
            return i;
        }
        const int r = root(par[i]);
        diff[i] += diff[par[i]];
        return par[i] = r;
    }
    inline int dist(const int i) noexcept {
        root(i);
        return diff[i];
    }
    inline int64_t dist(const int x, const int y) noexcept { return dist(y) - dist(x); }
    inline int unite(int x, int y, long long w) noexcept {
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
    inline int operator[](const int i) noexcept { return root(i); }
};
}
/**
 * @brief ポテンシャル付きUnionFind
 * @see https://github.com/tatyam-prime/kyopro_library/blob/master/UnionFind.cpp
 */