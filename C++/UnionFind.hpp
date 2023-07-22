// inspired by maspy(https://github.com/maspypy/library/blob/main/ds/unionfind/unionfind.hpp)
#pragma once

#include <vector>
using namespace std;
typedef long long ll;
struct UnionFind {
    vector<ll> par;
    UnionFind(ll n): par(n, -1){}
    ll operator[](ll a) {
        while(par[a] >= 0) {
            ll p = par[par[a]];
            if(p < 0) return par[a];
            a = par[a] = p;
        }
        return a;
    }
    bool unite(ll x, ll y) {
        x = (*this)[x], y = (*this)[y];
        if(x == y) return 0;
        if(-par[x] < -par[y]) swap(x, y);
        par[x] += par[y], par[y] = x;
        return 1;
    }
    ll size(ll x) {
        x = (*this)[x];
        return -par[x];
    }
};
