#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/problems/DSL_2_E"
#include <iostream>
#include "FenwickTree.hpp"
int main() {
    std::cin.tie(nullptr) -> sync_with_stdio(false);
    int n, q;
    std::cin >> n >> q;
    FenwickTree<int64_t> bit(n);
    while(q--) {
        int h;
        std::cin >> h;
        if(h == 0) {
            int s, t, x;
            std::cin >> s >> t >> x;
            bit.add(--s, --t, x);
        } else {
            int i;
            std::cin >> i;
            std::cout << bit.sum(--i) << '\n';
        }
    }
}