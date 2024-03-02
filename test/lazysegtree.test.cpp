#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/problems/DSL_2_D"
#include <iostream>
#include "C++/ds/LazySegmentTree.hpp"
int main() {
    std::cin.tie(nullptr) -> sync_with_stdio(false);
    int n, q;
    std::cin >> n >> q;
    RUSM<int64_t> seg(std::vector<int64_t>(n, INT32_MAX));
    while(q--) {
        int h;
        std::cin >> h;
        if(h == 0) {
            int s, t, x;
            std::cin >> s >> t >> x;
            seg.apply(s, ++t, x);
        } else {
            int i;
            std::cin >> i;
            std::cout << seg[i] << '\n';
        }
    }
}