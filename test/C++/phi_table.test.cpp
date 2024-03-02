#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/problems/2286"
#include <iostream>
#include "C++/math/phitable.hpp"
constexpr int n = 1e6;
int main() {
    const auto phi = phi_table(n).get();
    std::vector<int64_t> ret(n + 1);
    ret[1] = 2;
    for(int i = 2; i <= n; ++i) {
        ret[i] = ret[i - 1] + phi[i];
    }
    int t;
    std::cin >> t;
    while(t--) {
        int i;
        std::cin >> i;
        std::cout << ret[i] << '\n';
    }
}