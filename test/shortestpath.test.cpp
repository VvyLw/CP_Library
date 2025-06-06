#define PROBLEM "https://judge.yosupo.jp/problem/shortest_path"
#include <iostream>
#include "C++/graph/WeightedGraph.hpp"
int main() {
    int n, m, s, t;
    std::cin >> n >> m >> s >> t;
    man::w_graph<false> g(n, 0);
    g.input(m);
    auto dj = g.dijkstra(s);
    if(!dj.is_thru(t)) {
        std::cout << "-1\n";
        return 0;
    }
    const auto ed = dj.path(t);
    std::cout << dj.get()[t] << ' ';
    const int len = ed.size() - 1;
    std::cout << len << '\n';
    for(int i = 0; i < len; ++i) {
        std::cout << ed[i] << ' ' << ed[i + 1] << '\n';
    }
}