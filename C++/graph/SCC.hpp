#pragma once

#include <vector>
#include <algorithm>
#include <ranges>
namespace man {
template <class G> struct SCC {
private:
	std::vector<int> comp, order, used;
	std::vector<std::vector<int>> group;
	G g, rg, dag;
	inline void dfs(const int i) noexcept {
		if(used[i]) {
			return;
		}
		used[i] = true;
		for(const auto &e: g[i]) {
			dfs(e);
		}
		order.push_back(i);
  	}
  	constexpr inline void rdfs(const int i, const int cnt) noexcept {
    	if(comp[i] != -1) {
			return;
		}
    	comp[i] = cnt;
    	for(const auto &e: rg[i]) {
			rdfs(e, cnt);
		}
  	}
	inline void build() noexcept {
		const int n = std::ssize(g);
		rg = G(n, 0);
		for(const auto i: std::views::iota(0, n)) {
			for(const auto &e: g[i]) {
				rg.add(e.to, e.src);
			}
		}
		used.assign(n, 0);
		comp.assign(n, -1);
		for(const auto i: std::views::iota(0, n)) {
			dfs(i);
		}
		std::ranges::reverse(order);
		int ptr = 0;
		for(const auto &i: order) {
			if(comp[i] == -1) {
				rdfs(i, ptr++);
			}
		}
		dag = G(ptr, 0);
		for(const auto i: std::views::iota(0, n)) {
			for(const auto &e: g[i]) {
				const int x = comp[e.src], y = comp[e.to];
				if(x == y) {
					continue;
				}
				dag.add(x, y);
			}
		}
		group.resize(ptr);
		for(const auto i: std::views::iota(0, n)) {
			group[comp[i]].emplace_back(i);
		}
	}
public:
    SCC(const G &g): g(g){ build(); }
	constexpr inline int operator[](const int i) const noexcept { return comp[i]; }
	inline std::vector<std::vector<int>> groups() const noexcept { return group; }
	inline G DAG() const noexcept { return dag; }
};
}

/**
 * @brief Strongly Connected Components(強連結成分分解)
 * @see https://ei1333.github.io/library/graph/connected-components/strongly-connected-components.hpp
 */