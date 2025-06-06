#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/problems/GRL_3_C"
#include <iostream>
#include "C++/graph/Graph.hpp"
#include "C++/graph/SCC.hpp"
int main() {
    int v, e, q;
    std::cin >> v >> e;
    man::graph<false> g(v, 0);
    g.input(e);
    man::SCC scc(g);
    std::cin >> q;
    while(q--) {
        int a, b;
        std::cin >> a >> b;
        std::cout << int(scc[a] == scc[b]) << '\n';
    }
}