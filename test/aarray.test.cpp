#define PROBLEM "https://judge.yosupo.jp/problem/associative_array"
/*#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")//*/
//#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
#include "C++/template.hpp"
using namespace std;
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
    INT(q);
    unordered_map<ll,ll> um;
    while(q--) {
        LL(t,k);
        if(t) {
            out(um[k]);
        }
        else {
            LL(v);
            um[k]=v;
        }
    }
}