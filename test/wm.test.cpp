#define PROBLEM "https://judge.yosupo.jp/problem/range_kth_smallest"
#include <iostream>
#include "C++/ds/WM.hpp"
int main() {
    int n, q;
    std::cin >> n >> q;
    std::vector<int> a(n);
    for(auto &el: a) {
        std::cin >> el;
    }
    man::WaveletMatrix<int> wm(a);
    while(q--) {
        int l, r, k;
        std::cin >> l >> r >> k;
        std::cout << wm.kth_min(l, r, k) << '\n';
    }
}