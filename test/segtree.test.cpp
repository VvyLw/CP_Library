#define PROBLEM "https://judge.yosupo.jp/problem/point_add_range_sum"
/*#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")//*/
//#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
#include "C++/template.hpp"
#include "C++/ds/SegmentTree.hpp"

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
	man::SegTree<i64> rsq(a, [](const i64 a, const i64 b) -> i64 { return a + b; }, 0);
	while(q--) {
		int t, p, q;
		std::cin >> t >> p >> q;
		if(t) {
			std::cout << rsq.query(p, q) << '\n';
		} else {
			rsq.add(p, q);
		}
	}
}