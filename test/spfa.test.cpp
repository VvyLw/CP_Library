#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/courses/library/5/GRL/1/GRL_1_B"
#include "C++/graph/WeightedGraph.hpp"
constexpr auto LIM = (1LL << 61) - 1;
int main() {
    int v, e, r;
    std::cin >> v >> e >> r;
    man::w_graph<false> g(v, 0);
    g.input(e);
    const auto res = g.spfa(r);
    if(res.empty()) {
        std::cout << "NEGATIVE CYCLE\n";
        std::exit(0);
    }
    for(const auto &el: res) {
        if(el == LIM) {
            std::cout << "INF\n";
        }
        else {
            std::cout << el << '\n';
        }
    }
}