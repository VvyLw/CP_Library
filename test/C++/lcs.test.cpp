#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/problems/ALDS1_10_C"
#include <iostream>
#include "C++/dp.hpp"
int main() {
    int q;
    std::cin >> q;
    while(q--) {
        std::string x, y;
        std::cin >> x >> y;
        const int z = lcs(x, y);
        std::cout << z << '\n';
    }
}