#pragma once

#include "C++/graph/WeightedGraph.hpp"
#ifndef TEMPLATE
namespace man {
template <class T, class U> inline bool chmax(T& a, const U& b){ if(a<b){ a=b; return 1; } return 0; }
}
#endif
namespace man {
template <bool undirected=true> struct diameter: w_graph<undirected> {
private:
    using w_graph<undirected>::indexed;
    using w_graph<undirected>::id;
    using w_graph<undirected>::edges;
    std::vector<int> to;
    std::vector<edge> path;
    constexpr inline std::pair<int64_t, int> dfs(const int i, const int par) noexcept {
        std::pair<int64_t, int> ret(0, i);
        for(const auto &e: (*this)[i]) {
            if(e == par) {
                continue;
            }
            auto cost = dfs(e, i);
            cost.first += e.cost;
            if(chmax(ret, cost)) {
                to[i] = e;
            }
        }
        return ret;
    }
public:
    diameter(const int n, const int id = 1): w_graph<undirected>(n, id), to(n, -1){}
    using w_graph<undirected>::add;
    using w_graph<undirected>::input;
    using w_graph<undirected>::get_edge;    
    constexpr inline int64_t build() noexcept {
        const auto p = dfs(0, -1);
        const auto q = dfs(p.second, -1);
        int now = p.second;
        while(now != q.second) {
            for(const auto &e: (*this)[now]) {
                if(to[now] == e) {
                    path.emplace_back(e);
                }
            }
            now = to[now];
        }
        return q.first;
    }
    constexpr inline std::vector<edge> get_path() const noexcept { return path; }
};
}

/**
 * @brief 木の直径
 * @see https://ei1333.github.io/library/graph/tree/tree-diameter.hpp
 */