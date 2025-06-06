#define PROBLEM "https://judge.yosupo.jp/problem/unionfind"
/*#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")//*/
//#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
#include "C++/template.hpp"
#include "C++/ds/uf/UnionFind.hpp"
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
    man::UnionFind uf(n);
    while(q--) {
        int t, a, b;
        std::cin >> t >> a >> b;
        if(t) {
            std::cout << (uf[a] == uf[b]) << '\n';
        } else {
            uf.unite(a,b);
        }
    }
}