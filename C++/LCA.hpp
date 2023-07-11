// inspired by Luzhiled(https://ei1333.github.io/luzhiled/snippets/tree/doubling-lowest-common-ancestor.html)
#include <vector>
using namespace std;
template <class G> struct LowestCommonAncestor {
    const int LOG;
    vector<int> dep;
    const G &g;
    vector<vector<int>> table;
    LowestCommonAncestor(const G &g_) : g(g_), dep(g_.size()), LOG(__lg(g_.size()) - 1) {
        table.assign(LOG, vector<int>(g_.size(), -1));
    }
    void dfs(int idx, int par, int d) {
        table[0][idx] = par;
        dep[idx] = d;
        for(auto to: g[idx]) {
            if(to != par) dfs(to, idx, d + 1);
        }
    }
    void build() {
        dfs(0, -1, 0);
        for(int k = 0; k < LOG-1; ++k) {
            for(size_t i = 0; i < table[k].size(); ++i) {
                if(table[k][i] == -1) table[k + 1][i] = -1;
                else table[k + 1][i] = table[k][table[k][i]];
            }
        }
    }
    int query(int u, int v) {
        if(dep[u] > dep[v]) swap(u, v);
        for(int i = LOG - 1; i >= 0; i--) {
            if(((dep[v] - dep[u]) >> i) & 1) v = table[i][v];
        }
        if(u == v) return u;
            for(int i = LOG - 1; i >= 0; i--) {
            if(table[i][u] != table[i][v]) {
                u = table[i][u];
                v = table[i][v];
            }
        }
        return table[0][u];
    }
    int dist(int u, int v){ return dep[u] + dep[v] - 2 * query(u, v); }
};
