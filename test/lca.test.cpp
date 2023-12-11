#define PROBLEM "https://judge.yosupo.jp/problem/lca"
#include "C++/LCA.hpp"
#include "C++/graph.hpp"
int main() {
    std::cin.tie(nullptr) -> sync_with_stdio(false);
    int n, q;
    std::cin >> n >> q;
    graph<false> g(n, 0);
    for(int i = 1; i < n; ++i) {
        int p;
        std::cin >> p;
        g.add(p, i);
    }
    LowestCommonAncestor lca(g);
    while(q--) {
        int u, v;
        std::cin >> u >> v;
        std::cout << lca.query(u, v) << '\n';
    }
}