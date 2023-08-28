// inspired by Luzhiled(https://ei1333.github.io/luzhiled/snippets/tree/doubling-lowest-common-ancestor.html)
#pragma once

#include <vector>
using namespace std;
template <class G> struct LowestCommonAncestor {
    const int LOG;
    vi dep;
    const G &g;
    wi table;
    LowestCommonAncestor(const G &g_) : g(g_), dep(g_.size()), LOG(zia_qu::bitdigit(g_.size())) {
        table.assign(LOG, vi(g_.size(), -1));
    }
    void dfs(ll idx, ll par, ll d) {
        table[0][idx] = par;
        dep[idx] = d;
        each(to,g[idx]) {
            if(to != par) dfs(to, idx, d + 1);
        }
    }
    void build() {
        dfs(0, -1, 0);
        rep(k,LOG-1) {
            rep(table[k].size()) {
                if(table[k][i] == -1) table[k + 1][i] = -1;
                else table[k + 1][i] = table[k][table[k][i]];
            }
        }
    }
    ll query(ll u, ll v) {
        if(dep[u] > dep[v]) swap(u, v);
        rvp(LOG) {
            if(((dep[v] - dep[u]) >> i) & 1) v = table[i][v];
        }
        if(u == v) return u;
            rvp(LOG) {
            if(table[i][u] != table[i][v]) {
                u = table[i][u];
                v = table[i][v];
            }
        }
        return table[0][u];
    }
    ll dist(ll u, ll v){ return dep[u] + dep[v] - 2 * query(u, v); }
};