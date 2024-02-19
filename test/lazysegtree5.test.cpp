#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/2/DSL_2_G"
#include <iostream>
#include "C++/structure/LazySegmentTree.hpp"
int main() {
    int n, q;
    std::cin >> n >> q;
    RASM<int64_t> seg(std::vector(n, 0L));
    while(q--) {
        int h, s, t;
        std::cin >> h >> s >> t;
        s--;
        if(h == 0) {
            int x;
            std::cin >> x;
            seg.apply(s, t, x);
        } else {
            std::cout << seg.query(s, t) << '\n';
        }
    }
}