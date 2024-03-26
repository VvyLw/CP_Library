#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/problems/DPL_1_A"
#include <iostream>
#include "C++/other/dp.hpp"
int main() {
    int n, m;
    std::cin >> n >> m;
    std::vector<int> c(m);
    for(auto &el: c) {
        std::cin >> el;
    }
    std::cout << coin(c, n) << '\n';
}