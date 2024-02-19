#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/2/DSL_2_I"
#include <iostream>
#include "C++/structure/LazySegmentTree.hpp"
int main() {
    int n, q;
    std::cin >> n >> q;
    RUSM<int> seg(std::vector(n, 0));
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