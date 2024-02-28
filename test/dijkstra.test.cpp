#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/problems/GRL_1_A"
#include <iostream>
#include "C++/graph/WeightedGraph.hpp"
constexpr long long LINF = (1LL << 61) - 1;
int main() {
    int v, e, r;
    std::cin >> v >> e >> r;
    w_graph<false> g(v, 0);
    g.input(e);
    const auto dj = g.dijkstra(r).get();
    for(const auto &el: dj) {
        if(el == LINF) {
            std::cout << "INF\n";
        } else {
            std::cout << el << '\n';
        }
    }
}