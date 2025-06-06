#pragma once

#pragma GCC diagnostic ignored "-Wreorder"

#include <vector>
#include <ranges>
namespace man {
template <class G> struct LowestCommonAncestor {
private:
    const int LOG;
    std::vector<int> dep, sum;
    const G &g;
    std::vector<std::vector<int>> table;
    constexpr inline void dfs(const int idx, const int par, const int d) noexcept {
        table[0][idx] = par;
        dep[idx] = d;
        for(const auto &el: g[idx]) {
            if(el != par) {
                sum[el] = sum[idx] + el.cost;
                dfs(el, idx, d + 1);
            }
        }
    }
    constexpr inline void build() noexcept{
        dfs(0, -1, 0);
        for(const auto k: std::views::iota(0, LOG - 1)) {
            for(const auto i: std::views::iota(0, std::ssize(table[k]))) {
                if(table[k][i] == -1) {
                    table[k + 1][i] = -1;
                } else {
                    table[k + 1][i] = table[k][table[k][i]];
                }
            }
        }
    }
public:
    LowestCommonAncestor(const G &g_): g(g_), dep(std::ssize(g_)), sum(std::ssize(g_)), LOG(std::__lg(std::ssize(g_)) + 1) {
        table.assign(LOG, std::vector<int>(std::ssize(g_), -1));
        build();
    }
    constexpr inline int climb(int u, const int k) noexcept {
		if(dep[u] < k) {
			return -1;
		}
		for(const auto i: std::views::iota(0, LOG) | std::views::reverse) {
			if((k >> i) & 1) {
                u = table[i][u];
            }
		}
		return u;
	}
    constexpr inline int query(int u, int v) noexcept {
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
    constexpr inline int dist(const int u, const int v) const noexcept { return sum[u] + sum[v] - 2 * sum[query(u, v)]; }
};
}
/**
 * @brief Lowest Common Ancestor(最小共通祖先)
 * @docs docs/LCA.md
 * @see https://ei1333.github.io/luzhiled/snippets/tree/doubling-lowest-common-ancestor.html
 */