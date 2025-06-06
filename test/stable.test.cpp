#define PROBLEM "https://judge.yosupo.jp/problem/staticrmq"
/*#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")//*/
//#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
#include "C++/template.hpp"
#include "C++/ds/SparseTable.hpp"
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
    std::vector<int> a(n);
	std::cin >> a;
    man::SparseTable<int> st(a, [](int a, int b) -> int { return std::min(a, b); });
    while(q--) {
        int l, r;
		std::cin >> l >> r;
        std::cout << st.query(l, r) << '\n';
    }
}