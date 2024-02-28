#define PROBLEM "https://judge.yosupo.jp/problem/longest_increasing_subsequence"
#include <iostream>
#include "C++/LIS.hpp"
int main() {
    int n;
    std::cin >> n;
    std::vector<int> a(n), res;
    for(auto &el: a) {
        std::cin >> el;
    }
    res = lis(a);
    std::cout << res.size() << '\n';
    for(size_t i = 0; i < res.size(); ++i) {
        std::cout << res[i] << " \n"[i + 1 == res.size()];
    }
}