#define PROBLEM "https://judge.yosupo.jp/problem/binomial_coefficient_prime_mod"
#include <iostream>
#include "C++/math/ModPrime.hpp"
int main() {
    std::cin.tie(nullptr) -> sync_with_stdio(false);
    int t, m;
    std::cin >> t >> m;
    man::ModPrime<(int) 1e7> mp(m);
    while(t--) {
        int n, k;
        std::cin >> n >> k;
        std::cout << mp.C(n, k) << '\n';
    }
}