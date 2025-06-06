#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/2/DSL_2_D"
#include <iostream>
#include <cstdint>
#include "C++/ds/DualSegmentTree.hpp"
int main() {
    int n, q;
    std::cin >> n >> q;
    man::DualSegTree<int> seg(n, [](const int a, const int b) -> int { return b; }, INT32_MAX);
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