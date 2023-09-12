// inspired by maspy(https://github.com/maspypy/library/blob/main/ds/unionfind/unionfind.hpp)
#pragma once

#include <vector>
#include <algorithm>
using namespace std;
typedef long long ll;
struct UnionFind {
private:
    vector<ll> par;
public:
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
    vector<vector<ll>> groups() {
        const int n = par.size();
        vector<vector<ll>> res(n);
        for(int i = 0; i < n; ++i) res[(*this)[i]].emplace_back(i);
        res.erase(remove_if(res.begin(), res.end(), [&](const vector<ll> &v){ return v.empty(); }), res.end());
        return res;
    }
};
