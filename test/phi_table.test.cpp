#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/problems/2286"
#include <iostream>
#include "C++/math.hpp"
int main() {
    const auto phi = phi_table(int(1e6)).acc();
    int t;
    std::cin >> t;
    while(t--) {
        int i;
        std::cin >> i;
        std::cout << phi[i] << '\n';
    }
}