#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/problems/DSL_2_F"
#include <iostream>
#include "C++/structure/LazySegmentTree.hpp"
int main() {
    std::cin.tie(nullptr) -> sync_with_stdio(false);
    int n, q;
    std::cin >> n >> q;
    RUMN<int> seg(std::vector(n, INT32_MAX));
    while(q--) {
        int h, s, t;
        std::cin >> h >> s >> t;
        t++;
        if(h == 0) {
            int x;
            std::cin >> x;
            seg.apply(s, t, x);
        } else {
            std::cout << seg.query(s, t) << '\n';
        }
    }
}