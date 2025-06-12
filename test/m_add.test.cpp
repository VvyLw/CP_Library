#define PROBLEM "https://judge.yosupo.jp/problem/many_aplusb"
/*#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")//*/
//#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
#include "C++/template.hpp"
int main() {
  	now(start);
  	VvyLw::wa_haya_exe<multi>();
  	now(stop);
  	time(start, stop);
}

// --------------------------------------------------------------------------------------------------------------

inline void VvyLw::solve() noexcept {
    i64 a, b;
    std::cin >> a >> b;
	std::cout << a + b << '\n';
}