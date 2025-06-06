#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/problems/DSL_5_B"
#include <iostream>
#include <algorithm>
#include "C++/math/psum/psum2d.hpp"
constexpr int m = 1000;
int main() {
    std::cin.tie(nullptr) -> sync_with_stdio(false);
    int n;
    std::cin >> n;
    man::psum2d<int64_t> p(m, m);
    while(n--) {
        int x1, y1, x2, y2;
        std::cin >> x1 >> y1 >> x2 >> y2;
        p.add(x1, y1, x2, y2, 1);
    }
    p.build();
    int64_t ans = 0;
    for(int i = 0; i < m; ++i) {
        for(int j = 0; j < m; ++j) {
            ans = std::max(ans, p.get(i, j));
        }
    }
    std::cout << ans << '\n';
}