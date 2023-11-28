#include <iostream>
#include <C++/UnionFind.hpp>
struct Edge {
	long long a, b, cost;
	bool operator<(const Edge& e) const {
		return cost < e.cost;
	}
};
struct Graph {
	int n;
	std::vector<Edge> edges;
	Graph(const int n_): n(n_){}
	void input(int m, const uint indexed=1) {
		while(m--) {
			Edge e;
            std::cin >> e.a >> e.b >> e.cost;
			e.a-=indexed, e.b-=indexed;
			edges.emplace_back(e);
		}
	}
	long long kruskal() {
#if __cplusplus >= 202101L
		std::ranges::sort(edges);
#else
        std::sort(edges.begin(), edges.end());
#endif
		UnionFind uf(n);
		long long res = 0;
		for(const auto &ed: edges) {
			if(uf.unite(ed.a, ed.b)) res += ed.cost;
		}
		return res;
	}
};