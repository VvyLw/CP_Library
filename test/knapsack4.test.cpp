#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/problems/DPL_1_G"
#include <iostream>
#include "C++/dp.hpp"
int main() {
    int n, wg;
    std::cin >> n >> wg;
    std::vector<int> v(n), w(n), m(n);
    for(int i = 0; i < n; ++i) {
        std::cin >> v[i] >> w[i] >> m[i];
    }
    const auto res = knapsack_sup_v(w, v, m, wg);
    std::cout << *std::max_element(res.begin(), res.end()) << '\n';
}