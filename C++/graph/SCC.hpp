#pragma once

#include <vector>
#include <algorithm>
template <class G> struct SCC {
private:
    std::vector<int> comp, order, used;
	std::vector<std::vector<int>> group;
	G g, rg, dag;
	void dfs(const int i) {
		if(used[i]) {
			return;
		}
		used[i] = true;
		for(const auto &e: g[i]) {
			dfs(e);
		}
		order.push_back(i);
  	}
  	void rdfs(const int i, const int cnt) {
    	if(comp[i] != -1) {
			return;
		}
    	comp[i] = cnt;
    	for(const auto &e: rg[i]) {
			rdfs(e, cnt);
		}
  	}
	void build() {
		const int n = g.size();
		rg = G(n, 0);
		for(int i = 0; i < n; ++i) {
			for(const auto &e: g[i]) {
				rg.add(e.to, e.src);
			}
		}
		used.assign(n, 0);
		comp.assign(n, -1);
		for(int i = 0; i < n; ++i) {
			dfs(i);
		}
		std::reverse(order.begin(), order.end());
		int ptr = 0;
		for(const auto &i: order) {
			if(comp[i] == -1) {
				rdfs(i, ptr++);
			}
		}
		dag = G(ptr, 0);
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
public:
    SCC(const G &g): g(g){ build(); }
	int operator[](const int i) const { return comp[i]; }
	std::vector<std::vector<int>> groups() const { return group; }
	G DAG() const { return dag; }
};

/**
 * @brief SCC
 * @see https://ei1333.github.io/library/graph/connected-components/strongly-connected-components.hpp
 */