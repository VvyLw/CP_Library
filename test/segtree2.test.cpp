#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/2/DSL_2_A"
#include <iostream>
#include <limits>
#include "C++/ds/SegmentTree.hpp"
int main() {
    int n, q;
    std::cin >> n >> q;
    man::SegTree<int> seg(n, [](const int x, const int y) -> int { return std::min(x, y); }, std::numeric_limits<int>::max());
    while(q--) {
        int com, x, y;
        std::cin >> com >> x >> y;
        if(com == 0) {
            seg.update(x, y);
        } else {
            std::cout << seg.query(x, y + 1) << '\n';
        }
    }
}