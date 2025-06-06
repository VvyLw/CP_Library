#define PROBLEM "https://judge.yosupo.jp/problem/range_chmin_chmax_add_range_sum"
#include <iostream>
#include "C++/ds/SegmentTreeBeats.hpp"

int main() {
    int n, q;
    std::cin >> n >> q;
    std::vector<int64_t> a(n);
    for(auto &e: a) {
        std::cin >> e;
    }
    man::SegmentTreeBeats seg(a);
    while(q--) {
        int t, l, r;
        std::cin >> t >> l >> r;
        if(t == 0) {
            int64_t b;
            std::cin >> b;
            seg.chmin(l, r, b);
        } else if(t == 1) {
            int64_t b;
            std::cin >> b;
            seg.chmax(l, r, b);
        } else if(t == 2) {
            int64_t b;
            std::cin >> b;
            seg.add(l, r, b);
        } else {
            std::cout << seg.sum(l, r) << '\n';
        }
    }
}