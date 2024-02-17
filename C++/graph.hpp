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
    int id;
    std::vector<edge> edges;
    graph(const int n, const int indexed_ = 1): indexed(indexed_), id(0){ this -> resize(n); }
    void add(int a, int b) {
        a -= indexed, b-= indexed;
        (*this)[a].emplace_back(a, b, id);
        edges.emplace_back(a, b, id++);
        if(undirected) {
            (*this)[b].emplace_back(b, a, --id);
            edges.emplace_back(b, a, id++);
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
                if(d[el] != -1) {
                    continue;
                }
                d[el] = d[tmp] + 1;
                q.emplace(el);
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
				deg[ed]++;
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
				if(--deg[ed] == 0) {
					sk.emplace(ed);
				}
			}
		}
		return ord.size() == size() ? ord : std::vector<int>{};
	}
    std::vector<edge> cycle() {
        const int n = size();
        std::vector<int> used(n);
        std::vector<edge> pre(n), cycle;
        const auto dfs = [&](const auto &f, const int i) -> bool {
            used[i] = 1;
			for(const auto &e: (*this)[i]) {
				if(used[e] == 0) {
					pre[e] = e;
					if(f(f, e)) {
						return true;
					}
				} else if(used[e] == 1) {
					int now = i;
					while(now != e) {
						cycle.emplace_back(pre[now]);
						now = pre[now].src;
					}
					cycle.emplace_back(e);
					return true;
				}
			}
			used[i] = 2;
			return false;
        };
        for(int i = 0; i < n; ++i) {
			if(used[i] == 0 && dfs(dfs, i)) {
				std::reverse(cycle.begin(), cycle.end());
				return cycle;
			}
		}
		return {};
    }
};
template <bool undirected = true> struct w_graph: public graph<undirected> {
private:
    using graph<undirected>::indexed;
    using graph<undirected>::id;
    using graph<undirected>::edges;
public:
    w_graph(const int n, const int indexed_ = 1): graph<undirected>(n, indexed_){}
    using graph<undirected>::all_dist;
    using graph<undirected>::dist;
    using graph<undirected>::t_sort;
    void add(int a, int b, const long long cost) {
        a -= indexed, b -= indexed;
        (*this)[a].emplace_back(a, b, id, cost);
        edges.emplace_back(a, b, id++, cost);
        if(undirected) {
            (*this)[b].emplace_back(b, a, --id, cost);
            edges.emplace_back(b, a, id++, cost);
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
                    dj.emplace(cst[el], el);
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
				chmin(cst[e], cst[e.src] + e.cost);
			}
		}
		for(const auto &e: edges) {
			if(cst[e.src] == lim) {
				continue;
			}
			if(cst[e.src] + e.cost < cst[e]) {
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
                cst[i][j] = j.cost;
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
/**
 * @brief グラフライブラリ
 */