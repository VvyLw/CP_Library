#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/problems/GRL_2_B"
#include <iostream>
#include "C++/MST.hpp"
int main() {
    int v, e, r;
    std::cin >> v >> e >> r;
    std::vector<edge> edges;
    while(e--) {
        int s, t, w;
        std::cin >> s >> t >> w;
        edges.emplace_back(s, t, -1, w);
    }
    std::cout << directed(edges, v, r).cost << '\n';
}