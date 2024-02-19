#define PROBLEM "https://judge.yosupo.jp/problem/tetration_mod"
#include <iostream>
#include "math/tetration.hpp"
void solve() {
    long long a, b, m;
    std::cin >> a >> b >> m;
    std::cout << tetration(a, b, m) << '\n';
}
int main() {
    int t;
    std::cin >> t;
    while(t--) {
        solve();
    }
}