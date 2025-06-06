#define PROBLEM "https://judge.yosupo.jp/problem/tetration_mod"
#include <iostream>
#include "C++/math/tetration.hpp"
void solve() {
    int64_t a, b, m;
    std::cin >> a >> b >> m;
    std::cout << man::tetration(a, b, m) << '\n';
}
int main() {
    int t;
    std::cin >> t;
    while(t--) {
        solve();
    }
}