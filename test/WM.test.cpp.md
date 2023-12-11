---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/WM.hpp
    title: C++/WM.hpp
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://judge.yosupo.jp/problem/range_kth_smallest
    links:
    - https://judge.yosupo.jp/problem/range_kth_smallest
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 401, in update\n    self.update(self._resolve(pathlib.Path(included), included_from=path))\n\
    \  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 312, in update\n    raise BundleErrorAt(path, i + 1, \"#pragma once found\
    \ in a non-first line\")\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt:\
    \ C++/WM.hpp: line 3: #pragma once found in a non-first line\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/range_kth_smallest\"\n\
    #include <iostream>\n#include \"C++/WM.hpp\"\nint main() {\n    int n, q;\n  \
    \  std::cin >> n >> q;\n    std::vector<int> a(n);\n    for(auto &el: a) {\n \
    \       std::cin >> el;\n    }\n    WaveletMatrix<int, 18> wm(a);\n    while(q--)\
    \ {\n        int l, r, k;\n        std::cin >> l >> r >> k;\n        std::cout\
    \ << wm.kth_min(l, r, k) << '\\n';\n    }\n}"
  dependsOn:
  - C++/WM.hpp
  isVerificationFile: true
  path: test/WM.test.cpp
  requiredBy: []
  timestamp: '2023-12-11 21:29:48+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/WM.test.cpp
layout: document
redirect_from:
- /verify/test/WM.test.cpp
- /verify/test/WM.test.cpp.html
title: test/WM.test.cpp
---
