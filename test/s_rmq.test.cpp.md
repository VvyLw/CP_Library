---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/SparseTable.hpp
    title: C++/SparseTable.hpp
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
    PROBLEM: https://judge.yosupo.jp/problem/staticrmq
    links:
    - https://judge.yosupo.jp/problem/staticrmq
  bundledCode: "#line 1 \"test/s_rmq.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/staticrmq\"\
    \n/*#pragma GCC optimize(\"O3\")\n#pragma GCC optimize(\"unroll-loops\")//*/\n\
    //#pragma GCC target(\"sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native\"\
    )\n#include <C++/template.hpp>\n#include <C++/SparseTable.hpp>\nusing namespace\
    \ zia_qu;\nusing namespace Lady_sANDy;\nusing namespace Heileden;\nint main()\
    \ {\n  \tVvyLw::wa_haya_exe();\n  \tnow(start);\n  \t//INT(t); while(t--)\n  \t\
    VvyLw::solve();\n  \tnow(stop);\n  \ttime(start, stop);\n}\n\n// --------------------------------------------------------------------------------------------------------------\n\
    \nvoid VvyLw::solve() {\n    INT(n,q);\n    VEC(int,a,n);\n    SparseTable<int>\
    \ st(a,[](int a, int b){ return min(a, b); });\n    while(q--) {\n        INT(l,r);\n\
    \        out(st.query(l, r));\n    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/staticrmq\"\n/*#pragma\
    \ GCC optimize(\"O3\")\n#pragma GCC optimize(\"unroll-loops\")//*/\n//#pragma\
    \ GCC target(\"sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native\")\n#include\
    \ <C++/template.hpp>\n#include <C++/SparseTable.hpp>\nusing namespace zia_qu;\n\
    using namespace Lady_sANDy;\nusing namespace Heileden;\nint main() {\n  \tVvyLw::wa_haya_exe();\n\
    \  \tnow(start);\n  \t//INT(t); while(t--)\n  \tVvyLw::solve();\n  \tnow(stop);\n\
    \  \ttime(start, stop);\n}\n\n// --------------------------------------------------------------------------------------------------------------\n\
    \nvoid VvyLw::solve() {\n    INT(n,q);\n    VEC(int,a,n);\n    SparseTable<int>\
    \ st(a,[](int a, int b){ return min(a, b); });\n    while(q--) {\n        INT(l,r);\n\
    \        out(st.query(l, r));\n    }\n}"
  dependsOn:
  - C++/template.hpp
  - C++/SparseTable.hpp
  isVerificationFile: true
  path: test/s_rmq.test.cpp
  requiredBy: []
  timestamp: '2023-12-02 12:45:43+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/s_rmq.test.cpp
layout: document
redirect_from:
- /verify/test/s_rmq.test.cpp
- /verify/test/s_rmq.test.cpp.html
title: test/s_rmq.test.cpp
---