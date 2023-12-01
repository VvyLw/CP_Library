---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/SegmentTree.hpp
    title: C++/SegmentTree.hpp
  - icon: ':heavy_check_mark:'
    path: C++/template.hpp
    title: C++/template.hpp
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://judge.yosupo.jp/problem/point_add_range_sum
    links:
    - https://judge.yosupo.jp/problem/point_add_range_sum
  bundledCode: "#line 1 \"test/segtree.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/point_add_range_sum\"\
    \n/*#pragma GCC optimize(\"O3\")\n#pragma GCC optimize(\"unroll-loops\")//*/\n\
    //#pragma GCC target(\"sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native\"\
    )\n#include <C++/template.hpp>\n#include <C++/SegmentTree.hpp>\nusing namespace\
    \ zia_qu;\nusing namespace Lady_sANDy;\nusing namespace Heileden;\n\nint main()\
    \ {\n\tVvyLw::wa_haya_exe();\n\tnow(start);\n\t/*INT(t); while(t--)//*/\n\tVvyLw::solve();\n\
    \tnow(stop);\n\ttime(start, stop);\n}\n\n// --------------------------------------------------------------------------------------------------------------\n\
    \n\nvoid VvyLw::solve() {\n\tINT(n,q);\n\tSegTree<ll> rsq(n,[](ll a, ll b){ return\
    \ a+b; },0);\n\trep(n) {\n\t\tINT(a);\n        rsq.update(i,a);\n\t}\n\twhile(q--)\
    \ {\n\t\tINT(t,p,q);\n\t\tif(t) out(rsq.query(p,q));\n\t\telse rsq.add(p,q);\n\
    \t}\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/point_add_range_sum\"\n\
    /*#pragma GCC optimize(\"O3\")\n#pragma GCC optimize(\"unroll-loops\")//*/\n//#pragma\
    \ GCC target(\"sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native\")\n#include\
    \ <C++/template.hpp>\n#include <C++/SegmentTree.hpp>\nusing namespace zia_qu;\n\
    using namespace Lady_sANDy;\nusing namespace Heileden;\n\nint main() {\n\tVvyLw::wa_haya_exe();\n\
    \tnow(start);\n\t/*INT(t); while(t--)//*/\n\tVvyLw::solve();\n\tnow(stop);\n\t\
    time(start, stop);\n}\n\n// --------------------------------------------------------------------------------------------------------------\n\
    \n\nvoid VvyLw::solve() {\n\tINT(n,q);\n\tSegTree<ll> rsq(n,[](ll a, ll b){ return\
    \ a+b; },0);\n\trep(n) {\n\t\tINT(a);\n        rsq.update(i,a);\n\t}\n\twhile(q--)\
    \ {\n\t\tINT(t,p,q);\n\t\tif(t) out(rsq.query(p,q));\n\t\telse rsq.add(p,q);\n\
    \t}\n}"
  dependsOn:
  - C++/template.hpp
  - C++/SegmentTree.hpp
  isVerificationFile: true
  path: test/segtree.test.cpp
  requiredBy: []
  timestamp: '2023-12-02 08:23:51+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/segtree.test.cpp
layout: document
redirect_from:
- /verify/test/segtree.test.cpp
- /verify/test/segtree.test.cpp.html
title: test/segtree.test.cpp
---
