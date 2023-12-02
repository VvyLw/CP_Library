#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/courses/library/5/GRL/all/GRL_2_A"
#include <C++/MST.hpp>
int main() {
    std::cin.tie(nullptr) -> sync_with_stdio(false);
    int n, m;
    std::cin >> n >> m;
    Graph g(n, 0);
    g.input(m);
    std::cout << g.kruskal() << '\n';
}