#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/problems/DPL_1_D"
#include <iostream>
#include "C++/LIS.hpp"
int main() {
    int n;
    std::cin >> n;
    std::vector<int> a(n);
    for(auto &el: a) {
        std::cin >> el;
    }
    std::cout << lis(a).size() << '\n';
}