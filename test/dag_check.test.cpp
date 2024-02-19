#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/courses/library/5/GRL/4/GRL_4_A"
#include "C++/graph/Graph.hpp"
int main() {
    int v, e;
    std::cin >> v >> e;
    graph<false> g(v, 0);
    g.input(e);
    std::cout << g.t_sort().empty() << '\n';
}