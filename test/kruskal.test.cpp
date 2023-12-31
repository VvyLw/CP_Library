#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/courses/library/5/GRL/all/GRL_2_A"
#include <iostream>
#include "C++/MST.hpp"
int main() {
    std::cin.tie(nullptr) -> sync_with_stdio(false);
    int n, m;
    std::cin >> n >> m;
    std::vector<edge> e;
    while(m--) {
        int s, t, w;
        std::cin >> s >> t >> w;
        e.emplace_back(s, t, w);
    }
    std::cout << kruskal(e, n).cost << '\n';
}