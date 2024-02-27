#define PROBLEM "https://judge.yosupo.jp/problem/point_add_range_sum"
/*#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")//*/
//#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
#include "C++/template.hpp"
#include "C++/ds/SegmentTree.hpp"
using namespace zia_qu;
using namespace Lady_sANDy;
using namespace Heileden;

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
	INT(n,q);
	SegTree<ll> rsq(n,[](ll a, ll b){ return a+b; },0);
	rep(n) {
		INT(a);
        rsq.update(i,a);
	}
	while(q--) {
		INT(t,p,q);
		if(t) out(rsq.query(p,q));
		else rsq.add(p,q);
	}
}