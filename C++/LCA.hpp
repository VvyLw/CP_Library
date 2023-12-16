#pragma once

// inspired by Luzhiled( https://ei1333.github.io/luzhiled/snippets/tree/doubling-lowest-common-ancestor.html )
#include <vector>
template <class G> struct LowestCommonAncestor {
private:
    const int LOG;
    std::vector<int> dep, sum;
    const G &g;
    std::vector<std::vector<int>> table;
    void dfs(const int idx, const int par, const int d) {
        table[0][idx] = par;
        dep[idx] = d;
        for(const auto &el: g[idx]) {
            if(el.to != par) {
                sum[el.to] = sum[idx] + el.cost;
                dfs(el.to, idx, d + 1);
            }
        }
    }
    void build() {
        dfs(0, -1, 0);
        for(int k = 0; k < LOG - 1; ++k) {
            for(size_t i = 0; i < table[k].size(); ++i) {
                if(table[k][i] == -1) {
                    table[k + 1][i] = -1;
                }
                else {
                    table[k + 1][i] = table[k][table[k][i]];
                }
            }
        }
    }
public:
    LowestCommonAncestor(const G &g_) : g(g_), dep(g_.size()), sum(g_.size()), LOG(std::__lg(g_.size()) + 1) {
        table.assign(LOG, std::vector<int>(g_.size(), -1));
        build();
    }
    int climb(int u, const int k) {
		if(dep[u] < k) {
			return -1;
		}
		for(int i = LOG; --i >= 0;) {
			if((k >> i) & 1) {
                u = table[i][u];
            }
		}
		return u;
	}
    int query(int u, int v) {
        if(dep[u] > dep[v]) {
            std::swap(u, v);
        }
        v = climb(v, dep[v] - dep[u]);
        if(u == v) {
            return u;
        }
        for(int i = LOG; --i >= 0;) {
            if(table[i][u] != table[i][v]) {
                u = table[i][u];
                v = table[i][v];
            }
        }
        return table[0][u];
    }
    int dist(const int u, const int v){ return sum[u] + sum[v] - 2 * sum[query(u, v)]; }
};