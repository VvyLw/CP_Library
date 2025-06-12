#define PROBLEM "https://judge.yosupo.jp/problem/point_add_range_sum"
/*#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")//*/
//#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
#include "C++/ds/fwtree/FenwickTree.hpp"
#include "C++/template.hpp"
int main() {
  	now(start);
  	VvyLw::wa_haya_exe();
  	now(stop);
  	time(start, stop);
}

// --------------------------------------------------------------------------------------------------------------

inline void VvyLw::solve() noexcept {
    int n, q;
    std::cin >> n >> q;
    man::FenwickTree<i64> bit(n);
    for(const auto i: std::views::iota(0, n)) {
        int a;
        std::cin >> a;
        bit.add(i, a);
    }
    while(q--) {
        int t, p, q;
        std::cin >> t >> p >> q;
        if(t) {
            std::cout << bit.sum(p, q - 1) << '\n';
        } else {
            bit.add(p, q);
        }
    }
}