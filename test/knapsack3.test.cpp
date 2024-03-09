#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/problems/DPL_1_I"
#include <iostream>
#include "C++/other/dp.hpp"
int main() {
    int n;
    int64_t wg;
    std::cin >> n >> wg;
    std::vector<int> v(n);
    std::vector<int64_t> w(n), m(n);
    for(int i = 0; i < n; ++i) {
        std::cin >> v[i] >> w[i] >> m[i];
    }
    std::cout << knapsack_sup_w(w, v, m, wg) << '\n';
}