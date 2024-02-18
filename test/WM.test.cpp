#define PROBLEM "https://judge.yosupo.jp/problem/range_kth_smallest"
#include <iostream>
#include "WM.hpp"
int main() {
    int n, q;
    std::cin >> n >> q;
    std::vector<int> a(n);
    for(auto &el: a) {
        std::cin >> el;
    }
    WaveletMatrix<int, 18> wm(a);
    while(q--) {
        int l, r, k;
        std::cin >> l >> r >> k;
        std::cout << wm.kth_min(l, r, k) << '\n';
    }
}