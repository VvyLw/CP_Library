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
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 401, in update\n    self.update(self._resolve(pathlib.Path(included), included_from=path))\n\
    \  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 355, in update\n    raise BundleErrorAt(path, i + 1, \"found codes out\
    \ of include guard\")\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt:\
    \ C++/template.hpp: line 4: found codes out of include guard\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/static_range_sum\"\n/*#pragma\
    \ GCC optimize(\"O3\")\n#pragma GCC optimize(\"unroll-loops\")//*/\n//#pragma\
    \ GCC target(\"sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native\")\n#include\
    \ \"C++/template.hpp\"\nusing namespace zia_qu;\nusing namespace Lady_sANDy;\n\
    using namespace Heileden;\nint main() {\n  \tVvyLw::wa_haya_exe();\n  \tnow(start);\n\
    \  \t//INT(t); while(t--)\n  \tVvyLw::solve();\n  \tnow(stop);\n  \ttime(start,\
    \ stop);\n}\n\n// --------------------------------------------------------------------------------------------------------------\n\
    \nvoid VvyLw::solve() {\n    INT(n,q);\n    VEC(ll,a,n);\n    asum s(a);\n   \
    \ while(q--) {\n        INT(l,r);\n        out(s.query(l,r));\n    }\n}"
  dependsOn:
  - C++/template.hpp
  isVerificationFile: true
  path: test/sr_sum.test.cpp
  requiredBy: []
  timestamp: '2023-12-17 00:18:18+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/sr_sum.test.cpp
layout: document
redirect_from:
- /verify/test/sr_sum.test.cpp
- /verify/test/sr_sum.test.cpp.html
title: test/sr_sum.test.cpp
---
