#define PROBLEM "https://judge.yosupo.jp/problem/kth_root_integer"
#include <iostream>
#include "math/kthrooti.hpp"
void solve() {
    ul a;
    int k;
    std::cin >> a >> k;
    std::cout << Heileden::kthrooti(a, k) << '\n';
}
int main() {
    std::cin.tie(nullptr) -> sync_with_stdio(false);
    int t;
    std::cin >> t;
    while(t--) {
        solve();
    }
}