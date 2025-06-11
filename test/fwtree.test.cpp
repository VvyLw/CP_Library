#define PROBLEM "https://judge.yosupo.jp/problem/point_add_range_sum"
/*#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")//*/
//#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
#include "C++/template.hpp"
#include "C++/ds/fwtree/FenwickTree.hpp"

int main() {
	VvyLw::wa_haya_exe();
	now(start);
	/*INT(t); while(t--)//*/
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
	man::FenwickTree bit(a);
	while(q--) {
		int t, p, q;
		std::cin >> t >> p >> q;
		if(t) {
			std::cout << bit.sum(p, --q) << '\n';
		} else {
			bit.add(p, q);
		}
	}
}