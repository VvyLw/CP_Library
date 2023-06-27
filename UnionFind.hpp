#include <vector>
using namespace std;
typedef long long ll;
struct UnionFind {
    vector<ll> par;
    UnionFind(ll n){ par.resize(n,-1); }
    ll operator[](ll a) {
        while(par[a] >= 0) {
            ll p = par[par[a]];
            if(p < 0) return par[a];
            a = par[a] = p;
        }
        return a;
    }
    void unite(ll x, ll y) {
        x = (*this)[x], y = (*this)[y];
        if(x == y) return;
        if(-par[x] < -par[y]) swap(x, y);
        par[x] += par[y], par[y] = x;
    }
    ll size(ll x) {
        x = (*this)[x];
        return -par[x];
    }
};