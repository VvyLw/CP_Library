---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/ModPrime.hpp
    title: ModPrime
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://judge.yosupo.jp/problem/binomial_coefficient_prime_mod
    links:
    - https://judge.yosupo.jp/problem/binomial_coefficient_prime_mod
  bundledCode: "#line 1 \"test/modprime.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/binomial_coefficient_prime_mod\"\
    \n#include <iostream>\n#include <C++/ModPrime.hpp>\nint main() {\n    int t, m;\n\
    \    std::cin >> t >> m;\n    ModPrime<(int) 1e7> mp(m);\n    while(t--) {\n \
    \       int n, k;\n        std::cin >> n >> k;\n        std::cout << mp.C(n, k)\
    \ << '\\n';\n    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/binomial_coefficient_prime_mod\"\
    \n#include <iostream>\n#include <C++/ModPrime.hpp>\nint main() {\n    int t, m;\n\
    \    std::cin >> t >> m;\n    ModPrime<(int) 1e7> mp(m);\n    while(t--) {\n \
    \       int n, k;\n        std::cin >> n >> k;\n        std::cout << mp.C(n, k)\
    \ << '\\n';\n    }\n}"
  dependsOn:
  - C++/ModPrime.hpp
  isVerificationFile: true
  path: test/modprime.test.cpp
  requiredBy: []
  timestamp: '2024-02-02 19:51:38+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/modprime.test.cpp
layout: document
redirect_from:
- /verify/test/modprime.test.cpp
- /verify/test/modprime.test.cpp.html
title: test/modprime.test.cpp
---
