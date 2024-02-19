#pragma once

#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#ifndef TEMPLATE
template <class T, class U> bool chmin(T& a, const U& b){ if(a>b){ a=b; return 1; } return 0; }
#endif
#include "C++/graph/edge.hpp"
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
typedef std::vector<edge> ve;
typedef std::vector<ve> we;

/**
 * @brief グラフライブラリ
 */