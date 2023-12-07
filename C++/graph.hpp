#pragma once

#include <iostream>
#include <vector>
#include <queue>
using namespace std;
//#include "template.hpp"
template <class T, class U> bool chmin(T& a, const U& b){ if(a>b){ a=b; return 1; } return 0; }
struct edge {
    int src, to;
    long long cost;
    edge(){}
    edge(const int to_): to(to_){}
    edge(const int to_, const long long cost_): to(to_), cost(cost_){}
    edge(const int src_, const int to_, const long long cost_): src(src_), to(to_), cost(cost_){}
};
template <bool undirected = true> struct graph: std::vector<std::vector<edge>> {
private:
    const int indexed;
public:
    graph(const int n, const int indexed_ = 1): indexed(indexed_) {
        this -> resize(n);
    }
    void add(int a, int b) {
        a -= indexed, b-= indexed;
        (*this)[a].emplace_back(edge(b));
        if(undirected) {
            (*this)[b].emplace_back(edge(a));
        }
    }
    void input(const int m) {
        for(int i = 0; i < m; ++i) {
            int a, b;
            std::cin >> a >> b;
            add(a, b);
        }
    }
protected:
    std::vector<int> all_dist(const int v) {
        std::vector<int> d(this -> size(), -1);
        std::queue<int> q;
        d[v] = 0;
        q.emplace(v);
        while(q.size()) {
            const int tmp = q.front();
            q.pop();
            for(const auto &el: (*this)[tmp]) {
                if(d[el.to] != -1) {
                    continue;
                }
                d[el.to] = d[tmp] + 1;
                q.emplace(el.to);
            }
        }
        return d;
    }
    int dist(const int u, const int v) const { return all_dist(u)[v]; }
};
template <bool undirected = true> struct w_graph: graph<undirected> {
private:
    const int indexed;
public:
    w_graph(const int n, const int indexed_ = 1): graph<undirected>(n, indexed_){}
    void add(int a, int b, const long long cost) {
        a -= indexed, b -= indexed;
        (*this)[a].emplace_back(edge(b, cost));
        if(undirected) {
            (*this)[b].emplace_back(edge(a, cost));
        }
    }
    void input(const int m) {
        for(int i = 0; i < m; ++i) {
            int a, b;
            long long c;
            std::cin >> a >> b >> c;
            add(a, b, c);
        }
    }
    std::vector<long long> dijkstra(const int v) {
        std::vector<long long> cst(this -> size(), (1LL << 61) - 1);
        std::priority_queue<std::pair<long long, int>, std::vector<std::pair<long long, int>>, std::greater<std::pair<long long, int>>> dj;
        cst[v] = 0;
        dj.emplace(cst[v], v);
        while(dj.size()) {
            const auto tmp = dj.top();
            dj.pop();
            if(cst[tmp.second] < tmp.first) {
                continue;
            }
            for(const auto &el: (*this)[tmp.second]) {
                if(chmin(cst[el], tmp.first + el.cost)) {
                    dj.emplace(cst[el.to], el.to);
                }
            }
        }
        return cst;
    }
    std::vector<std::vector<long long>> warshall_floyd() {
		const int n = this -> size();
		std::vector cst(n, std::vector(n, (1LL << 61) - 1));
		for(int i = 0; i < n; ++i) {
            cst[i][i] = 0;
        }
		for(int i = 0; i < n; ++i) {
            for(const auto &j: (*this)[i]) {
                cst[i][j] = j.cost;
            }
        }
		for(int k = 0 ; k < n; ++k) {
            for(int i = 0; i < n; ++i) {
                for(int j = 0; j < n; ++j) {
                    chmin(cst[i][j], cst[i][k] + cst[k][j]);
                }
            }
        }
		return cst;
	}
};

#include <C++/UnionFind.hpp>
struct tree {
private:
	int n, indexed;
	std::vector<edge> edges;
public:
	tree(const int n_, const int indexed_ = 1): n(n_), indexed(indexed_){}
	void input(int m) {
		while(m--) {
            edge e;
            std::cin >> e.src >> e.to >> e.cost;
			e.src -= indexed, e.to -= indexed;
			edges.emplace_back(e);
		}
	}
	long long kruskal() {
        std::sort(edges.begin(), edges.end(), [&](const edge &e, const edge &f){ return e.cost < f.cost; });
		UnionFind uf(n);
		long long res = 0;
		for(const auto &ed: edges) {
			if(uf.unite(ed.src, ed.to)) {
                res += ed.cost;
            }
		}
		return res;
	}
};