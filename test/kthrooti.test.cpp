#define PROBLEM "https://judge.yosupo.jp/problem/kth_root_integer"
#include <iostream>
#include "C++/math/kthrooti.hpp"
void solve() {
    uint64_t a;
    int k;
    std::cin >> a >> k;
    std::cout << man::kthrooti(a, k) << '\n';
}
int main() {
    std::cin.tie(nullptr) -> sync_with_stdio(false);
    int t;
    std::cin >> t;
    while(t--) {
        solve();
    }
}