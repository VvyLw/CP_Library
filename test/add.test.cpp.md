---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/constance.hpp
    title: "\u5B9A\u6570"
  - icon: ':heavy_check_mark:'
    path: C++/io/input.hpp
    title: "\u5165\u529B"
  - icon: ':heavy_check_mark:'
    path: C++/io/output.hpp
    title: "\u51FA\u529B"
  - icon: ':heavy_check_mark:'
    path: C++/math/divisor.hpp
    title: "\u7D04\u6570\u5217\u6319"
  - icon: ':heavy_check_mark:'
    path: C++/math/kthrooti.hpp
    title: "k\u4E57\u6839(\u6574\u6570)"
  - icon: ':heavy_check_mark:'
    path: C++/math/primefactor.hpp
    title: "\u7D20\u56E0\u6570\u5206\u89E3"
  - icon: ':heavy_check_mark:'
    path: C++/math/primefactortable.hpp
    title: "\u7D20\u56E0\u6570\u5206\u89E3\u30C6\u30FC\u30D6\u30EB"
  - icon: ':heavy_check_mark:'
    path: C++/math/primetable.hpp
    title: Sieve of Eratosthenes
  - icon: ':heavy_check_mark:'
    path: C++/math/psum/psum.hpp
    title: "\u7D2F\u7A4D\u548C"
  - icon: ':heavy_check_mark:'
    path: C++/mypair.hpp
    title: C++/mypair.hpp
  - icon: ':heavy_check_mark:'
    path: C++/myvector.hpp
    title: C++/myvector.hpp
  - icon: ':heavy_check_mark:'
    path: C++/template.hpp
    title: "\u30C6\u30F3\u30D7\u30EC\u30FC\u30C8"
  - icon: ':heavy_check_mark:'
    path: C++/timer.hpp
    title: "\u30BF\u30A4\u30DE\u30FC"
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://judge.yosupo.jp/problem/aplusb
    links:
    - https://judge.yosupo.jp/problem/aplusb
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 401, in update\n    self.update(self._resolve(pathlib.Path(included), included_from=path))\n\
    \  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 355, in update\n    raise BundleErrorAt(path, i + 1, \"found codes out\
    \ of include guard\")\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt:\
    \ C++/template.hpp: line 4: found codes out of include guard\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/aplusb\"\n/*#pragma GCC\
    \ optimize(\"O3\")\n#pragma GCC optimize(\"unroll-loops\")//*/\n//#pragma GCC\
    \ target(\"sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native\")\n#include\
    \ \"C++/template.hpp\"\nusing namespace zia_qu;\nusing namespace Lady_sANDy;\n\
    using namespace Heileden;\nint main() {\n  \tVvyLw::wa_haya_exe();\n  \tnow(start);\n\
    \  \t/*INT(t); while(t--)//*/\n  \tVvyLw::solve();\n  \tnow(stop);\n  \ttime(start,\
    \ stop);\n}\n\n// --------------------------------------------------------------------------------------------------------------\n\
    \nvoid VvyLw::solve() {\n    INT(a,b);\n    out(a+b);\n}"
  dependsOn:
  - C++/template.hpp
  - C++/timer.hpp
  - C++/mypair.hpp
  - C++/constance.hpp
  - C++/myvector.hpp
  - C++/io/input.hpp
  - C++/io/output.hpp
  - C++/math/divisor.hpp
  - C++/math/primefactor.hpp
  - C++/math/primetable.hpp
  - C++/math/primefactortable.hpp
  - C++/math/psum/psum.hpp
  - C++/math/kthrooti.hpp
  isVerificationFile: true
  path: test/add.test.cpp
  requiredBy: []
  timestamp: '2024-02-20 01:36:11+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/add.test.cpp
layout: document
redirect_from:
- /verify/test/add.test.cpp
- /verify/test/add.test.cpp.html
title: test/add.test.cpp
---
