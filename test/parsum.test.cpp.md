---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/FenwickTree.hpp
    title: C++/FenwickTree.hpp
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
  bundledCode: "#line 1 \"test/parsum.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/point_add_range_sum\"\
    \n/*#pragma GCC optimize(\"O3\")\n#pragma GCC optimize(\"unroll-loops\")//*/\n\
    //#pragma GCC target(\"sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native\"\
    )\n#include <C++/template.hpp>\n#include <C++/FenwickTree.hpp>\nusing namespace\
    \ zia_qu;\nusing namespace Lady_sANDy;\nusing namespace Heileden;\nint main()\
    \ {\n  \tVvyLw::wa_haya_exe();\n  \tnow(start);\n  \t//INT(t); while(t--)\n  \t\
    VvyLw::solve();\n  \tnow(stop);\n  \ttime(start, stop);\n}\n\n// --------------------------------------------------------------------------------------------------------------\n\
    \nvoid VvyLw::solve() {\n    INT(n,q);\n    FenwickTree<ll> bit(n);\n    rep(n)\
    \ {\n        INT(a);\n        bit.add(i,a);\n    }\n    while(q--) {\n       \
    \ INT(t,p,q);\n        if(t) out(bit.sum(p,q-1));\n        else bit.add(p,q);\n\
    \    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/point_add_range_sum\"\n\
    /*#pragma GCC optimize(\"O3\")\n#pragma GCC optimize(\"unroll-loops\")//*/\n//#pragma\
    \ GCC target(\"sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native\")\n#include\
    \ <C++/template.hpp>\n#include <C++/FenwickTree.hpp>\nusing namespace zia_qu;\n\
    using namespace Lady_sANDy;\nusing namespace Heileden;\nint main() {\n  \tVvyLw::wa_haya_exe();\n\
    \  \tnow(start);\n  \t//INT(t); while(t--)\n  \tVvyLw::solve();\n  \tnow(stop);\n\
    \  \ttime(start, stop);\n}\n\n// --------------------------------------------------------------------------------------------------------------\n\
    \nvoid VvyLw::solve() {\n    INT(n,q);\n    FenwickTree<ll> bit(n);\n    rep(n)\
    \ {\n        INT(a);\n        bit.add(i,a);\n    }\n    while(q--) {\n       \
    \ INT(t,p,q);\n        if(t) out(bit.sum(p,q-1));\n        else bit.add(p,q);\n\
    \    }\n}"
  dependsOn:
  - C++/template.hpp
  - C++/FenwickTree.hpp
  isVerificationFile: true
  path: test/parsum.test.cpp
  requiredBy: []
  timestamp: '2023-12-08 03:00:55+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/parsum.test.cpp
layout: document
redirect_from:
- /verify/test/parsum.test.cpp
- /verify/test/parsum.test.cpp.html
title: test/parsum.test.cpp
---
