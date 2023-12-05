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
  bundledCode: "#line 1 \"test/WM.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/range_kth_smallest\"\
    \n#include <iostream>\n#include <C++/WM.hpp>\nint main() {\n    int n, q;\n  \
    \  std::cin >> n >> q;\n    std::vector<int> a(n);\n    for(auto &el: a) {\n \
    \       std::cin >> el;\n    }\n    WaveletMatrix<int, 18> wm(a);\n    while(q--)\
    \ {\n        int l, r, k;\n        std::cin >> l >> r >> k;\n        std::cout\
    \ << wm.kth_min(l, r, k) << '\\n';\n    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/range_kth_smallest\"\n\
    #include <iostream>\n#include <C++/WM.hpp>\nint main() {\n    int n, q;\n    std::cin\
    \ >> n >> q;\n    std::vector<int> a(n);\n    for(auto &el: a) {\n        std::cin\
    \ >> el;\n    }\n    WaveletMatrix<int, 18> wm(a);\n    while(q--) {\n       \
    \ int l, r, k;\n        std::cin >> l >> r >> k;\n        std::cout << wm.kth_min(l,\
    \ r, k) << '\\n';\n    }\n}"
  dependsOn:
  - C++/WM.hpp
  isVerificationFile: true
  path: test/WM.test.cpp
  requiredBy: []
  timestamp: '2023-12-06 01:59:37+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/WM.test.cpp
layout: document
redirect_from:
- /verify/test/WM.test.cpp
- /verify/test/WM.test.cpp.html
title: test/WM.test.cpp
---
