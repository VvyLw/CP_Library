#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/problems/ALDS1_5_D"
#include <iostream>
#include "C++/math/inverse_num.hpp"
int main() {
    int n;
    std::cin >> n;
    std::vector<int> a(n);
    for(auto &el: a) {
        std::cin >> el;
    }
    std::cout << man::inv_num(a) << '\n';
}