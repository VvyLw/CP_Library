#define PROBLEM "https://judge.yosupo.jp/problem/aplusb"
/*#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")//*/
//#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
#include <C++/template.hpp>
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
    INT(a,b);
    out(a+b);
}