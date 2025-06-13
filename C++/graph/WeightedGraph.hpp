#pragma once

#include "C++/graph/Graph.hpp"
#include "C++/graph/ShortestPath.hpp"
namespace man {
template <bool undirected = true> struct w_graph: graph<undirected> {
protected:
    using graph<undirected>::indexed;
    using graph<undirected>::id;
    using graph<undirected>::edges;
public:
    w_graph(const int n, const int indexed_ = 1): graph<undirected>(n, indexed_){}
    using graph<undirected>::get_edge;
    using graph<undirected>::all_dist;
    using graph<undirected>::dist;
    using graph<undirected>::t_sort;
    using graph<undirected>::cycle;
    inline void add(int a, int b, const long long cost) noexcept {
        a -= indexed, b -= indexed;
        (*this)[a].emplace_back(a, b, id, cost);
        edges.emplace_back(a, b, id++, cost);
        if(undirected) {
            (*this)[b].emplace_back(b, a, --id, cost);
            edges.emplace_back(b, a, id++, cost);
        }
    }
    inline void input(const int m) noexcept {
        for([[maybe_unused]] const auto _: std::views::iota(0, m)) {
            int a, b;
            long long c;
            std::cin >> a >> b >> c;
            add(a, b, c);
        }
    }
    inline ShortestPath dijkstra(const int v) noexcept {
        std::vector<long long> cst(this->size(), (1LL << 61) - 1);
        std::vector<int> src(this->size(), -1);
        std::priority_queue<std::pair<long long, int>, std::vector<std::pair<long long, int>>, std::greater<std::pair<long long, int>>> dj;
        cst[v] = 0;
        dj.emplace(cst[v], v);
        while(!dj.empty()) {
            const auto tmp = dj.top();
            dj.pop();
            if(cst[tmp.second] < tmp.first) {
                continue;
            }
            for(const auto &el: (*this)[tmp.second]) {
                if(chmin(cst[el], tmp.first + el.cost)) {
                    src[el] = tmp.second;
                    dj.emplace(cst[el], el);
                }
            }
        }
        return {cst, src};
    }
    inline std::vector<long long> spfa(const int v) noexcept {
        const int n = this -> size();
        std::vector<long long> cst(n, (1LL << 61) - 1);
        std::vector<int> pending(n), times(n);
        std::queue<int> q;
        q.emplace(v);
        pending[v] = 1;
        ++times[v];
        cst[v] = 0;
        while(!q.empty()) {
            const int p = q.front();
            q.pop();
            pending[p] = 0;
            for(const auto &e : (*this)[p]) {
                const long long next = cst[p] + e.cost;
                if(next >= cst[e]) {
                    continue;
                }
                cst[e] = next;
                if(!pending[e]) {
                    if(++times[e] >= n) {
                        cst.clear();
                        return cst;
                    }
                    pending[e] = 1;
                    q.emplace(e);
                }
            }
        }
		return cst;
    }
    std::vector<std::vector<long long>> warshall_floyd() {
		const int n = this -> size();
        const long long lim = (1LL << 61) - 1;
		std::vector cst(n, std::vector(n, lim));
		for(const auto i: std::views::iota(0, n)) {
            cst[i][i] = 0;
        }
		for(const auto i: std::views::iota(0, n)) {
            for(const auto &j: (*this)[i]) {
                cst[i][j] = j.cost;
            }
        }
		for(const auto k: std::views::iota(0, n)) {
            for(const auto i: std::views::iota(0, n)) {
                for(const auto j: std::views::iota(0, n)) {
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
}

/**
 * @brief 重み付きグラフライブラリ
 */