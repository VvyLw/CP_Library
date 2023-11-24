#define PROBLEM "https://judge.yosupo.jp/problem/lca"
#include <iostream>
#include <C++/LCA.hpp>
#include <C++/graph.hpp>
int main() {
    cin.tie(nullptr) -> sync_with_stdio(false);
    int n, q;
    cin >> n >> q;
    graph<false> g(n);
    for(int i = 1; i < n; ++i) {
        int p;
        cin >> p;
        g.add(p, i, 0);
    }
    LowestCommonAncestor lca(g);
    lca.build();
    while(q--) {
        int u, v;
        std::cin >> u >> v;
        std::cout << lca.query(u, v) << '\n';
    }
}