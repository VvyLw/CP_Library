#define PROBLEM "https://judge.yosupo.jp/problem/tree_diameter"
#include <iostream>
#include "C++/graph/diameter.hpp"
int main() {
    int n;
    std::cin >> n;
    man::diameter g(n, 0);
    g.input(n - 1);
    std::cout << g.build() << ' ';
    const auto p = g.get_path();
    std::cout << p.size() + 1 << '\n';
	std::cout << p[0].src << ' ';
	for(size_t i = 0; i < p.size(); ++i) {
		std::cout << p[i] << " \n"[i + 1 == p.size()];
	}
}