#define PROBLEM "https://judge.yosupo.jp/problem/scc"
#include <iostream>
#include "C++/graph/Graph.hpp"
#include "C++/graph/SCC.hpp"
int main() {
    int n, m;
    std::cin >> n >> m;
    man::graph<false> g(n, 0);
    g.input(m);
    man::SCC scc(g);
    const auto res = scc.groups();
    std::cout << res.size() << '\n';
    for(const auto &el: res) {
        const int len = el.size();
        std::cout << len << ' ';
        for(int i = 0; i < len; ++i) {
            std::cout << el[i] << " \n"[i + 1 == len];
        }
    }
}