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
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 401, in update\n    self.update(self._resolve(pathlib.Path(included), included_from=path))\n\
    \  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 312, in update\n    raise BundleErrorAt(path, i + 1, \"#pragma once found\
    \ in a non-first line\")\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt:\
    \ C++/SparseTable.hpp: line 2: #pragma once found in a non-first line\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/staticrmq\"\n/*#pragma\
    \ GCC optimize(\"O3\")\n#pragma GCC optimize(\"unroll-loops\")//*/\n//#pragma\
    \ GCC target(\"sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native\")\n#include\
    \ \"C++/template.hpp\"\n#include \"C++/SparseTable.hpp\"\nusing namespace std;\n\
    using namespace zia_qu;\nusing namespace Lady_sANDy;\nusing namespace Heileden;\n\
    int main() {\n\tVvyLw::wa_haya_exe();\n\tnow(start);\n\t/*INT(t); while(t--)//*/\n\
    \tVvyLw::solve();\n\tnow(stop);\n\ttime(start, stop);\n}\n\n// --------------------------------------------------------------------------------------------------------------\n\
    \n\nvoid VvyLw::solve() {\n\tINT(n,q);\n    VEC(int,a,n);\n    SparseTable<int>\
    \ st(a,[](int a, int b){ return min(a,b); });\n    while(q--) {\n        INT(l,r);\n\
    \        out(st.query(l,r));\n    }\n}"
  dependsOn:
  - C++/template.hpp
  - C++/SparseTable.hpp
  isVerificationFile: true
  path: test/stable.test.cpp
  requiredBy: []
  timestamp: '2023-12-11 21:08:07+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/stable.test.cpp
layout: document
redirect_from:
- /verify/test/stable.test.cpp
- /verify/test/stable.test.cpp.html
title: test/stable.test.cpp
---
