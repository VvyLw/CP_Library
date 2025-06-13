#pragma once

#include <ranges>
#include "C++/graph/mst/MST.hpp"
#include "C++/other/SkewHeap.hpp"
namespace man {
inline MST directed(std::vector<man::edge> edges, const int n, const int v) noexcept {
    for(const auto i: std::views::iota(0, n)) {
        if(i != v) {
            edges.emplace_back(i, v, 0);
        }
    }
    int x = 0;
    std::vector<int> par(2 * n, -1), vis(par), link(par), st;
    using Node = typename internal::SkewHeap<>::Node;
    internal::SkewHeap heap;
    std::vector<Node*> ins(2 * n, nullptr);
    for(const auto i: std::views::iota(0, std::ssize(edges))) {
        const auto &e = edges[i];
        ins[e] = heap.push(ins[e], e.cost, i);
    }
    const auto go = [&](int z) -> int {
        z = edges[ins[z]->idx].src;
        while(link[z] != -1) {
            st.emplace_back(z);
            z = link[z];
        }
        for(const auto &p: st) {
            link[p] = z;
        }
        st.clear();
        return z;
    };
    for(int i = n; ins[x] != 0; ++i) {
        while(vis[x] == -1) {
            vis[x] = 0;
            x = go(x);
        }
        while(x != i) {
            const auto w = ins[x] -> key;
            auto z = heap.pop(ins[x]);
            z = heap.add(z, -w);
            ins[i] = heap.meld(ins[i], z);
            par[x] = i;
            link[x] = i;
            x = go(x);
        }
        while(ins[x] && go(x) == x) {
            ins[x] = heap.pop(ins[x]);
        }
    }
    for(int i = v; i != -1; i = par[i]) {
		vis[i] = 1;
	}
    long long cost = 0;
    std::vector<man::edge> e;
    for(int i = x; i >= 0; i--) {
		if(vis[i] == 1) {
			continue;
		}
        cost += edges[ins[i] -> idx].cost;
        e.emplace_back(edges[ins[i] -> idx]);
        for(int j = edges[ins[i] -> idx]; j != -1 && vis[j] == 0; j = par[j]) {
            vis[j] = 1;
        }
    }
    return {e, cost};
}
}

/**
 * @brief Directed MST
 * @see https://ei1333.github.io/library/graph/mst/directed-mst.hpp
 */