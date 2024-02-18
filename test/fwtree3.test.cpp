#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/2/DSL_2_G"
#include <iostream>
#include "RangeBIT.hpp"
int main() {
    int n, q;
    std::cin >> n >> q;
    RangeBIT<int64_t> bit(n);
    while(q--) {
        int h, s, t;
        std::cin >> h >> s >> t;
        s--;
        if(h == 0) {
            int x;
            std::cin >> x;
            bit.add(s, t, x);
        } else {
            std::cout << bit.sum(s, t) << '\n';
        }
    }
}