#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/courses/library/5/GRL/1/GRL_1_C"
#include "graph.hpp"
constexpr long long lim = (1LL << 61) - 1;
int main() {
    int v, e;
    std::cin >> v >> e;
    w_graph<false> g(v, 0);
    g.input(e);
    const auto res = g.warshall_floyd();
    for(int i = 0; i < v; ++i) {
        if(res[i][i] < 0) {
            std::cout << "NEGATIVE CYCLE\n";
            std::exit(0);
        }
    }
    for(const auto &w: res) {
        for(size_t i = 0; i < v; ++i) {
            if(w[i] == lim) {
                std::cout << "INF" << " \n"[i + 1 == v];
            }
            else {
                std::cout << w[i] << " \n"[i + 1 == v];
            }
        }
    }
}