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
    PROBLEM: https://judge.yosupo.jp/problem/associative_array
    links:
    - https://judge.yosupo.jp/problem/associative_array
  bundledCode: "#line 1 \"test/aarray.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/associative_array\"\
    \n/*#pragma GCC optimize(\"O3\")\n#pragma GCC optimize(\"unroll-loops\")//*/\n\
    //#pragma GCC target(\"sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native\"\
    )\n#include <C++/template.hpp>\nusing namespace zia_qu;\nusing namespace Lady_sANDy;\n\
    using namespace Heileden;\nint main() {\n  \tVvyLw::wa_haya_exe();\n  \tnow(start);\n\
    \  \t//INT(t); while(t--)\n  \tVvyLw::solve();\n  \tnow(stop);\n  \ttime(start,\
    \ stop);\n}\n\n// --------------------------------------------------------------------------------------------------------------\n\
    \nvoid VvyLw::solve() {\n    INT(q);\n    unordered_map<ll,ll> um;\n    while(q--)\
    \ {\n        LL(t,k);\n        if(t) {\n            out(um[k]);\n        }\n \
    \       else {\n            LL(v);\n            um[k]=v;\n        }\n    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/associative_array\"\n/*#pragma\
    \ GCC optimize(\"O3\")\n#pragma GCC optimize(\"unroll-loops\")//*/\n//#pragma\
    \ GCC target(\"sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native\")\n#include\
    \ <C++/template.hpp>\nusing namespace zia_qu;\nusing namespace Lady_sANDy;\nusing\
    \ namespace Heileden;\nint main() {\n  \tVvyLw::wa_haya_exe();\n  \tnow(start);\n\
    \  \t//INT(t); while(t--)\n  \tVvyLw::solve();\n  \tnow(stop);\n  \ttime(start,\
    \ stop);\n}\n\n// --------------------------------------------------------------------------------------------------------------\n\
    \nvoid VvyLw::solve() {\n    INT(q);\n    unordered_map<ll,ll> um;\n    while(q--)\
    \ {\n        LL(t,k);\n        if(t) {\n            out(um[k]);\n        }\n \
    \       else {\n            LL(v);\n            um[k]=v;\n        }\n    }\n}"
  dependsOn:
  - C++/template.hpp
  isVerificationFile: true
  path: test/aarray.test.cpp
  requiredBy: []
  timestamp: '2023-12-01 05:44:25+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/aarray.test.cpp
layout: document
redirect_from:
- /verify/test/aarray.test.cpp
- /verify/test/aarray.test.cpp.html
title: test/aarray.test.cpp
---
