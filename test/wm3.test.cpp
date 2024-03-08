#define PROBLEM "https://judge.yosupo.jp/problem/static_range_frequency"
#include <iostream>
#include "C++/ds/WM.hpp"
int main() {
    std::cin.tie(nullptr) -> sync_with_stdio(false);
    int n, q;
    std::cin >> n >> q;
    std::vector<int> a(n);
    for(auto &el: a) {
        std::cin >> el;
    }
    WaveletMatrix wm(a);
    while(q--) {
        int l, r, x;
        std::cin >> l >> r >> x;
        std::cout << wm.rank(l, r, x) << '\n';
    }
}