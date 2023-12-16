#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/courses/library/5/GRL/1/GRL_1_B"
#include "C++/graph.hpp"
constexpr long long lim = std::numeric_limits<long long>::max();
int main() {
    int v, e, r;
    std::cin >> v >> e >> r;
    w_graph<false> g(v, 0);
    g.input(e);
    const auto res = g.bellman_ford(r);
    if(res.empty()) {
        std::cout << "NEGATIVE CYCLE\n";
        std::exit(0);
    }
    for(const auto &el: res) {
        if(el == lim) {
            std::cout << "INF\n";
        }
        else {
            std::cout << el << '\n';
        }
    }
}