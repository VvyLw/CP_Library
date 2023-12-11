#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/1/DSL_1_B"
#include <iostream>
#include "C++/UFPotential.hpp"
int main() {
    int n, q;
    std::cin >> n >> q;
    UFPotential uf(n);
    while(q--) {
        int t, x, y;
        std::cin >> t >> x >> y;
        if(t) {
            if(uf[x] == uf[y]) {
                std::cout << uf.dist(x, y) << '\n';
            }
            else {
                std::cout << "?\n";
            }
        }
        else {
            int z;
            std::cin >> z;
            uf.unite(x, y, z);
        }
    }
}