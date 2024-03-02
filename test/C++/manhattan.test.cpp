#define PROBLEM "https://judge.yosupo.jp/problem/manhattanmst"
#include <iostream>
#include "C++/graph/mst/kruskal.hpp"
#include "C++/graph/mst/manhattan.hpp"
int main() {
    int n;
    std::cin >> n;
    std::vector<int> x(n), y(n);
    for(int i = 0; i < n; ++i) {
        std::cin >> x[i] >> y[i];
    }
    const auto ans = kruskal(manhattan(x, y), n);
    std::cout << ans.cost << '\n';
    for(const auto &e: ans.tree) {
        std::cout << e.src << ' ' << e.to << '\n';
    }
}