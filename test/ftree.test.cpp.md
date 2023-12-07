---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/FenwickTree.hpp
    title: C++/FenwickTree.hpp
  - icon: ':question:'
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
  bundledCode: "#line 1 \"test/ftree.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/point_add_range_sum\"\
    \n/*#pragma GCC optimize(\"O3\")\n#pragma GCC optimize(\"unroll-loops\")//*/\n\
    //#pragma GCC target(\"sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native\"\
    )\n#include <C++/template.hpp>\n#include <C++/FenwickTree.hpp>\nusing namespace\
    \ zia_qu;\nusing namespace Lady_sANDy;\nusing namespace Heileden;\n\nint main()\
    \ {\n\tVvyLw::wa_haya_exe();\n\tnow(start);\n\t/*INT(t); while(t--)//*/\n\tVvyLw::solve();\n\
    \tnow(stop);\n\ttime(start, stop);\n}\n\n// --------------------------------------------------------------------------------------------------------------\n\
    \n\nvoid VvyLw::solve() {\n\tINT(n,q);\n\tFenwickTree<ll> bit(n);\n\trep(n) {\n\
    \t\tINT(a);\n\t\tbit.add(i,a);\n\t}\n\twhile(q--) {\n\t\tINT(t,p,q);\n\t\tif(t)\
    \ out(bit.sum(p,--q));\n\t\telse bit.add(p,q);\n\t}\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/point_add_range_sum\"\n\
    /*#pragma GCC optimize(\"O3\")\n#pragma GCC optimize(\"unroll-loops\")//*/\n//#pragma\
    \ GCC target(\"sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native\")\n#include\
    \ <C++/template.hpp>\n#include <C++/FenwickTree.hpp>\nusing namespace zia_qu;\n\
    using namespace Lady_sANDy;\nusing namespace Heileden;\n\nint main() {\n\tVvyLw::wa_haya_exe();\n\
    \tnow(start);\n\t/*INT(t); while(t--)//*/\n\tVvyLw::solve();\n\tnow(stop);\n\t\
    time(start, stop);\n}\n\n// --------------------------------------------------------------------------------------------------------------\n\
    \n\nvoid VvyLw::solve() {\n\tINT(n,q);\n\tFenwickTree<ll> bit(n);\n\trep(n) {\n\
    \t\tINT(a);\n\t\tbit.add(i,a);\n\t}\n\twhile(q--) {\n\t\tINT(t,p,q);\n\t\tif(t)\
    \ out(bit.sum(p,--q));\n\t\telse bit.add(p,q);\n\t}\n}"
  dependsOn:
  - C++/template.hpp
  - C++/FenwickTree.hpp
  isVerificationFile: true
  path: test/ftree.test.cpp
  requiredBy: []
  timestamp: '2023-12-08 03:00:55+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/ftree.test.cpp
layout: document
redirect_from:
- /verify/test/ftree.test.cpp
- /verify/test/ftree.test.cpp.html
title: test/ftree.test.cpp
---
