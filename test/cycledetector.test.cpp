#define PROBLEM "https://judge.yosupo.jp/problem/cycle_detection"
#include <iostream>
#include "C++/graph/Graph.hpp"
int main() {
    int n, m;
    std::cin >> n >> m;
    man::graph<false> g(n, 0);
    g.input(m);
    const auto res = g.cycle();
    if(res.empty()) {
        std::cout << -1 << '\n';
    } else {
        std::cout << res.size() << '\n';
        for(const auto &e: res) {
            std::cout << e.id << '\n';
        }
    }
}