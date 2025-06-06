#define PROBLEM "https://judge.yosupo.jp/problem/many_aplusb_128bit"
/*#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")//*/
//#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
#include "C++/template.hpp"
int main() {
  	VvyLw::wa_haya_exe();
  	now(start);
  	int t;
	std::cin >> t;
	for([[maybe_unused]] const auto _: std::views::iota(0, t)) {
		VvyLw::solve();
	}
  	now(stop);
  	time(start, stop);
}

// --------------------------------------------------------------------------------------------------------------

void VvyLw::solve() {
    i128 a, b;
	std::cin >> a >> b;
    std::cout << a + b << '\n';
}