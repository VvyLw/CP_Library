#pragma once

#include <vector>
#include <algorithm>
#include "C++/graph/Graph.hpp"
struct SCC {
private:
	using G = graph<false>;
    std::vector<int> comp;
	std::vector<std::vector<int>> group;
	G dag;
public:
    SCC(const G &g) {
        const int n = g.size();
		G rg(n, 0);
		for(int i = 0; i < n; ++i) {
			for(const auto &e: g[i]) {
				rg.add(e.to, e.src);
			}
		}
		std::vector<int> order;
		std::vector<bool> used(n);
		comp.assign(n, -1);
		const auto dfs = [&](const auto &f, const int i) -> void {
			if(used[i]) {
				return;
			}
			used[i] = true;
			for(const auto &e: g[i]) {
				f(f, e);
			}
			order.emplace_back(i);
		};
		for(int i = 0; i < n; ++i) {
			dfs(dfs, i);
		}
		std::reverse(order.begin(), order.end());
		const auto rdfs = [&](const auto &f, const int i, const int cnt) -> void {
			if(comp[i] != -1) {
				return;
			}
			comp[i] = cnt;
			for(const auto &e: rg[i]) {
				f(f, e, cnt);
			}
		};
		int ptr = 0;
		for(const auto &i: order) {
			if(comp[i] == -1) {
				rdfs(rdfs, i, ptr++);
			}
		}
		G dag(ptr, 0);
		for(int i = 0; i < n; ++i) {
			for(const auto &e: g[i]) {
				const int x = comp[e.src], y = comp[e.to];
				if(x == y) {
					continue;
				}
				dag.add(x, y);
			}
		}
		group.resize(ptr);
		for(int i = 0; i < n; ++i) {
			group[comp[i]].emplace_back(i);
		}
    }
	int operator[](const int i) const { return comp[i]; }
	std::vector<std::vector<int>> groups() const { return group; }
	G DAG() const { return dag; }
};

/**
 * @brief SCC
 * @docs docs/SCC.md
 * @see https://ei1333.github.io/library/graph/connected-components/strongly-connected-components.hpp
 */