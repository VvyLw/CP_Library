---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/math.hpp
    title: C++/math.hpp
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://judge.yosupo.jp/problem/kth_root_integer
    links:
    - https://judge.yosupo.jp/problem/kth_root_integer
  bundledCode: "#line 1 \"test/kthrooti.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/kth_root_integer\"\
    \n#include <iostream>\n#include <C++/math.hpp>\nvoid solve() {\n    ul a;\n  \
    \  int k;\n    std::cin >> a >> k;\n    std::cout << kthrooti(a, k) << '\\n';\n\
    }\nint main() {\n    std::cin.tie(nullptr) -> sync_with_stdio(false);\n    int\
    \ t;\n    std::cin >> t;\n    while(t--) {\n        solve();\n    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/kth_root_integer\"\n#include\
    \ <iostream>\n#include <C++/math.hpp>\nvoid solve() {\n    ul a;\n    int k;\n\
    \    std::cin >> a >> k;\n    std::cout << kthrooti(a, k) << '\\n';\n}\nint main()\
    \ {\n    std::cin.tie(nullptr) -> sync_with_stdio(false);\n    int t;\n    std::cin\
    \ >> t;\n    while(t--) {\n        solve();\n    }\n}"
  dependsOn:
  - C++/math.hpp
  isVerificationFile: true
  path: test/kthrooti.test.cpp
  requiredBy: []
  timestamp: '2023-12-03 13:05:02+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/kthrooti.test.cpp
layout: document
redirect_from:
- /verify/test/kthrooti.test.cpp
- /verify/test/kthrooti.test.cpp.html
title: test/kthrooti.test.cpp
---
