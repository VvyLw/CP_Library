#define PROBLEM "https://judge.yosupo.jp/problem/static_range_sum"
/*#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")//*/
//#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
#include "C++/template.hpp"
#include "C++/math/psum/psum.hpp"
int main() {
  	VvyLw::wa_haya_exe();
  	now(start);
  	//INT(t); while(t--)
  	VvyLw::solve();
  	now(stop);
  	time(start, stop);
}

// --------------------------------------------------------------------------------------------------------------

void VvyLw::solve() {
    int n, q;
    std::cin >> n >> q;
    man::vec::zhl a(n);
    std::cin >> a;
    man::psum s(a);
    while(q--) {
        int l, r;
        std::cin >> l >> r;
        std::cout << s.sum(l, r) << '\n';
    }
}