#define PROBLEM "https://judge.yosupo.jp/problem/associative_array"
/*#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")//*/
//#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
#include "C++/template.hpp"
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
    int q;
    std::cin >> q;
    std::unordered_map<i64, i64> um;
    for([[maybe_unused]] const auto _: std::views::iota(0, q)) {
        i64 t, k;
        std::cin >> t >> k;
        if(t) {
            std::cout << um[k] << '\n';
        } else {
            i64 v;
            std::cin >> v;
            um[k] = v;
        }
    }
}