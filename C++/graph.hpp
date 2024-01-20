#pragma once

#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <limits>
#ifndef TEMPLATE
template <class T, class U> bool chmin(T& a, const U& b){ if(a>b){ a=b; return 1; } return 0; }
#endif
#include "C++/edge.hpp"
template <bool undirected = true> struct graph: public std::vector<std::vector<edge>> {
    const int indexed;
    std::vector<edge> edges;
    graph(const int n, const int indexed_ = 1): indexed(indexed_){ this -> resize(n); }
    void add(int a, int b) {
        a -= indexed, b-= indexed;
        (*this)[a].emplace_back(b);
        edges.emplace_back(a, b, 0);
        if(undirected) {
            (*this)[b].emplace_back(a);
            edges.emplace_back(b, a, 0);
        }
    }
    void input(const int m) {
        for(int i = 0; i < m; ++i) {
            int a, b;
            std::cin >> a >> b;
            add(a, b);
        }
    }
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
    std::vector<int> t_sort() {
        const int n = this -> size();
		std::vector<int> deg(n);
		for(int i = 0; i < n; ++i) {
			for(const auto ed: (*this)[i]) {
				deg[ed.to]++;
			}
		}
		std::stack<int> sk;
		for(int i = 0; i < n; ++i) {
			if(deg[i] == 0) {
				sk.emplace(i);
			}
		}
		std::vector<int> ord;
		while(sk.size()) {
			const auto tmp = sk.top();
            sk.pop();
			ord.emplace_back(tmp);
			for(const auto ed: (*this)[tmp]) {
				if(--deg[ed.to] == 0) {
					sk.emplace(ed.to);
				}
			}
		}
		return ord.size() == size() ? ord : std::vector<int>{};
	}
};
template <bool undirected = true> struct w_graph: public graph<undirected> {
private:
    using graph<undirected>::indexed;
    using graph<undirected>::edges;
public:
    w_graph(const int n, const int indexed_ = 1): graph<undirected>(n, indexed_){}
    using graph<undirected>::all_dist;
    using graph<undirected>::dist;
    using graph<undirected>::t_sort;
    void add(int a, int b, const long long cost) {
        a -= indexed, b -= indexed;
        (*this)[a].emplace_back(b, cost);
        edges.emplace_back(a, b, cost);
        if(undirected) {
            (*this)[b].emplace_back(a, cost);
            edges.emplace_back(b, a, cost);
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
    std::vector<long long> bellman_ford(const int v) {
        const long long lim = std::numeric_limits<long long>::max();
        std::vector<long long> cst(this -> size(), lim);
        cst[v] = 0;
        for(size_t i = 0; i < this -> size() - 1; ++i) {
			for(const auto &e: edges) {
				if(cst[e.src] == lim) {
					continue;
				}
				chmin(cst[e.to], cst[e.src] + e.cost);
			}
		}
		for(const auto &e: edges) {
			if(cst[e.src] == lim) {
				continue;
			}
			if(cst[e.src] + e.cost < cst[e.to]) {
				return std::vector<long long>{};
			}
		}
		return cst;
    }
    std::vector<std::vector<long long>> warshall_floyd() {
		const int n = this -> size();
        const long long lim = (1LL << 61) - 1;
		std::vector cst(n, std::vector(n, lim));
		for(int i = 0; i < n; ++i) {
            cst[i][i] = 0;
        }
		for(int i = 0; i < n; ++i) {
            for(const auto &j: (*this)[i]) {
                cst[i][j.to] = j.cost;
            }
        }
		for(int k = 0; k < n; ++k) {
            for(int i = 0; i < n; ++i) {
                for(int j = 0; j < n; ++j) {
                    if(cst[i][k] == lim || cst[k][j] == lim) {
                        continue;
                    }
                    chmin(cst[i][j], cst[i][k] + cst[k][j]);
                }
            }
        }
		return cst;
	}
};
typedef std::vector<edge> ve;
typedef std::vector<ve> we;