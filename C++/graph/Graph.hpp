#pragma once

#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <stack>
#include <ranges>
#ifndef TEMPLATE
namespace man {
template <class T, class U> constexpr inline bool chmin(T& a, const U& b) noexcept { if(a > b){ a = b; return true; } return false; }
}
#endif
#include "C++/graph/edge.hpp"
namespace man {
template <bool undirected = true> struct graph: std::vector<std::vector<edge>> {
protected:
    int indexed, id;
    std::vector<edge> edges;
public:
    graph(){}
    graph(const int n, const int indexed_ = 1): indexed(indexed_), id(0){ this->resize(n); }
    inline void add(int a, int b) noexcept {
        a -= indexed, b-= indexed;
        (*this)[a].emplace_back(a, b, id);
        edges.emplace_back(a, b, id++);
        if(undirected) {
            (*this)[b].emplace_back(b, a, --id);
            edges.emplace_back(b, a, id++);
        }
    }
    inline void input(const int m) noexcept {
        for([[maybe_unused]] const auto _: std::views::iota(0, m)) {
            int a, b;
            std::cin >> a >> b;
            add(a, b);
        }
    }
    inline std::vector<edge> get_edge() const noexcept { return edges; }
    inline std::vector<int> all_dist(const int v) noexcept {
        std::vector<int> d(this -> size(), -1);
        std::queue<int> q;
        d[v] = 0;
        q.emplace(v);
        while(!q.empty()) {
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
    inline int dist(const int u, const int v) noexcept { return all_dist(u)[v]; }
    inline std::vector<int> t_sort() noexcept {
        const int n = this->size();
		std::vector<int> deg(n);
		for(const auto i: std::views::iota(0, n)) {
			for(const auto ed: (*this)[i]) {
				deg[ed]++;
			}
		}
		std::stack<int> sk;
		for(const auto i: std::views::iota(0, n)) {
			if(deg[i] == 0) {
				sk.emplace(i);
			}
		}
		std::vector<int> ord;
		while(!sk.empty()) {
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
    inline std::vector<edge> cycle() noexcept {
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
				std::ranges::reverse(cycle);
				return cycle;
			}
		}
		return {};
    }
};
}

/**
 * @brief グラフライブラリ
 */