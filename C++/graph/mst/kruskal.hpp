#pragma once

#include <vector>
#include "C++/graph/mst/MST.hpp"
#include "C++/ds/uf/UnionFind.hpp"
namespace man {
inline MST kruskal(std::vector<edge> edges, const int n) noexcept {
    std::ranges::sort(edges, [&](const edge &e, const edge &f) -> bool { return e.cost < f.cost; });
    UnionFind uf(n);
    std::vector<edge> e;
    int64_t ret = 0;
    for(const auto &ed: edges) {
        if(uf.unite(ed.src, ed)) {
            e.emplace_back(ed);
            ret += ed.cost;
        }
    }
    return {e, ret};
}
}

/**
 * @brief Kruskal法
 */