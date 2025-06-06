#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/problems/DPL_1_G"
#include <iostream>
#include "C++/other/dp.hpp"
int main() {
    int n, wg;
    std::cin >> n >> wg;
    std::vector<int> v(n), w(n), m(n);
    for(int i = 0; i < n; ++i) {
        std::cin >> v[i] >> w[i] >> m[i];
    }
    const auto ret = man::knapsack_sup_v(w, v, m, wg);
    std::cout << *std::ranges::max_element(ret) << '\n';
}