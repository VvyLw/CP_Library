#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/problems/DPL_3_C"
#include <iostream>
#include "C++/other/dp.hpp"
int main() {
    int n;
    std::cin >> n;
    std::vector<int> a(n);
    for(auto &el: a) {
        std::cin >> el;
    }
    std::cout << max_rectangle(a) << '\n';
}