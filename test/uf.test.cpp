#define PROBLEM "https://judge.yosupo.jp/problem/unionfind"
/*#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")//*/
//#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
#include "C++/ds/uf/UnionFind.hpp"
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
    man::UnionFind uf(n);
    REP(q) {
        int t, a, b;
        std::cin >> t >> a >> b;
        if(t) {
            std::cout << (uf[a] == uf[b]) << '\n';
        } else {
            uf.unite(a,b);
        }
    }
}