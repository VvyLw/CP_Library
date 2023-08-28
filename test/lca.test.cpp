#define PROBLEM "https://judge.yosupo.jp/problem/lca"
/*#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")//*/
//#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
#include <C++/template.hpp>
#include <C++/graph.hpp>
#include <C++/LCA.hpp>
using namespace zia_qu;
using namespace Lady_sANDy;
using namespace Heileden;
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
    INT(n,q);
    graph<0> g(n);
    rep(i,1,n-1) {
        INT(p);
        g.add(p,i,0);
    }
    LowestCommonAncestor lca(g);
    lca.build();
    while(q--) {
        INT(u,v);
        out(lca.query(u,v));
    }
}