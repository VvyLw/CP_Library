#pragma once

#include "C++/graph/WeightedGraph.hpp"
#ifndef TEMPLATE
template <class T, class U> inline bool chmax(T& a, const U& b){ if(a<b){ a=b; return 1; } return 0; }
#endif
template <bool undirected=true> struct diameter: w_graph<undirected> {
private:
    using w_graph<undirected>::indexed;
    using w_graph<undirected>::id;
    using w_graph<undirected>::edges;
    std::vector<int> to;
    std::vector<edge> path;
    std::pair<int64_t, int> dfs(const int i, const int par) {
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
    diameter(const int n, const int id = 1): w_graph<undirected>(n, id){}
    using w_graph<undirected>::add;
    using w_graph<undirected>::input;
    using w_graph<undirected>::get_edge;    
    int64_t build() {
        to.assign(this->size(), -1);
        auto p = dfs(0, -1);
        auto q = dfs(p.second, -1);
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
    std::vector<edge> get_path() const { return path; }
};