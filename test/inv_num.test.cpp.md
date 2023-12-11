---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/FenwickTree.hpp
    title: C++/FenwickTree.hpp
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://onlinejudge.u-aizu.ac.jp/problems/ALDS1_5_D
    links:
    - https://onlinejudge.u-aizu.ac.jp/problems/ALDS1_5_D
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 401, in update\n    self.update(self._resolve(pathlib.Path(included), included_from=path))\n\
    \  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 312, in update\n    raise BundleErrorAt(path, i + 1, \"#pragma once found\
    \ in a non-first line\")\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt:\
    \ C++/FenwickTree.hpp: line 2: #pragma once found in a non-first line\n"
  code: "#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/problems/ALDS1_5_D\"\n\
    #include <iostream>\n#include \"C++/FenwickTree.hpp\"\nint main() {\n    int n;\n\
    \    std::cin >> n;\n    std::vector<int> a(n);\n    for(auto &el: a) {\n    \
    \    std::cin >> el;\n    }\n    std::cout << inv_num(a) << '\\n';\n}"
  dependsOn:
  - C++/FenwickTree.hpp
  isVerificationFile: true
  path: test/inv_num.test.cpp
  requiredBy: []
  timestamp: '2023-12-11 21:08:07+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/inv_num.test.cpp
layout: document
redirect_from:
- /verify/test/inv_num.test.cpp
- /verify/test/inv_num.test.cpp.html
title: test/inv_num.test.cpp
---
