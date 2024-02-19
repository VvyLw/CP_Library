#define PROBLEM "https://yukicoder.me/problems/no/117"
#include <iostream>
#include "math/ModPrime.hpp"
constexpr int mod = 1e9 + 7;
ModPrime<(int) 2e7 + 1> mp(mod);
int main() {
    std::cin.tie(nullptr) -> sync_with_stdio(false);
    int t;
    std::cin >> t;
    while(t--) {
        char c, tmp;
        int n, k;
        std::cin >> c >> tmp >> n >> tmp >> k >> tmp;
        std::cout << (c == 'C' ? mp.C(n, k) : c == 'P' ? mp.P(n, k) : mp.H(n, k)) << '\n';
    }
}