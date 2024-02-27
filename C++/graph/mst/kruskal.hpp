#pragma once

#include <vector>
#include "C++/graph/mst/MST.hpp"
#include "C++/ds/uf/UnionFind.hpp"
inline MST kruskal(std::vector<edge> edges, const int n) {
    std::sort(edges.begin(), edges.end(), [&](const edge &e, const edge &f){ return e.cost < f.cost; });
    UnionFind uf(n);
    std::vector<edge> e;
    long long res = 0;
    for(const auto &ed: edges) {
        if(uf.unite(ed.src, ed)) {
            e.emplace_back(ed);
            res += ed.cost;
        }
    }
    return MST{e, res};
}

/**
 * @brief Kruskal法
 */