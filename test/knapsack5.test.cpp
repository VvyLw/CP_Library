#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/problems/DPL_1_C"
#include <iostream>
#include "C++/dp.hpp"
int main() {
    int n, wg;
    std::cin >> n >> wg;
    std::vector<int> v(n), w(n);
    for(int i = 0; i < n; ++i) {
        std::cin >> v[i] >> w[i];
    }
    std::cout << knapsack(w, v, wg) << '\n';
}