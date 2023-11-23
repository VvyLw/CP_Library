---
data:
  _extendedDependsOn:
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
    PROBLEM: https://judge.yosupo.jp/problem/static_range_sum
    links:
    - https://judge.yosupo.jp/problem/static_range_sum
  bundledCode: "#line 1 \"test/sr_sum.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/static_range_sum\"\
    \n/*#pragma GCC optimize(\"O3\")\n#pragma GCC optimize(\"unroll-loops\")//*/\n\
    //#pragma GCC target(\"sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native\"\
    )\n#include <C++/template.hpp>\nusing namespace zia_qu;\nusing namespace Lady_sANDy;\n\
    using namespace Heileden;\nint main() {\n  \tVvyLw::wa_haya_exe();\n  \tnow(start);\n\
    \  \t//INT(t); while(t--)\n  \tVvyLw::solve();\n  \tnow(stop);\n  \ttime(start,\
    \ stop);\n}\n\n// --------------------------------------------------------------------------------------------------------------\n\
    \nvoid VvyLw::solve() {\n    INT(n,q);\n    VEC(ll,a,n);\n    asum s(a);\n   \
    \ while(q--) {\n        INT(l,r);\n        out(s.query(l,r));\n    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/static_range_sum\"\n/*#pragma\
    \ GCC optimize(\"O3\")\n#pragma GCC optimize(\"unroll-loops\")//*/\n//#pragma\
    \ GCC target(\"sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native\")\n#include\
    \ <C++/template.hpp>\nusing namespace zia_qu;\nusing namespace Lady_sANDy;\nusing\
    \ namespace Heileden;\nint main() {\n  \tVvyLw::wa_haya_exe();\n  \tnow(start);\n\
    \  \t//INT(t); while(t--)\n  \tVvyLw::solve();\n  \tnow(stop);\n  \ttime(start,\
    \ stop);\n}\n\n// --------------------------------------------------------------------------------------------------------------\n\
    \nvoid VvyLw::solve() {\n    INT(n,q);\n    VEC(ll,a,n);\n    asum s(a);\n   \
    \ while(q--) {\n        INT(l,r);\n        out(s.query(l,r));\n    }\n}"
  dependsOn:
  - C++/template.hpp
  isVerificationFile: true
  path: test/sr_sum.test.cpp
  requiredBy: []
  timestamp: '2023-11-23 12:08:21+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/sr_sum.test.cpp
layout: document
redirect_from:
- /verify/test/sr_sum.test.cpp
- /verify/test/sr_sum.test.cpp.html
title: test/sr_sum.test.cpp
---
