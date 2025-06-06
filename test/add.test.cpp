#define PROBLEM "https://judge.yosupo.jp/problem/aplusb"
/*#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")//*/
//#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
#include "C++/template.hpp"
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
    int a, b;
	std::cin >> a >> b;
    std::cout << a + b << '\n';
}