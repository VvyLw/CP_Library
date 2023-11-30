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
    PROBLEM: https://judge.yosupo.jp/problem/counting_primes
    links:
    - https://judge.yosupo.jp/problem/counting_primes
  bundledCode: "#line 1 \"test/pcounter.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/counting_primes\"\
    \n#include <iostream>\n#include <C++/math.hpp>\nint main() {\n    ll n;\n    std::cin\
    \ >> n;\n    std::cout << p_count(ll(1e11)).pi(n) << '\\n';\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/counting_primes\"\n#include\
    \ <iostream>\n#include <C++/math.hpp>\nint main() {\n    ll n;\n    std::cin >>\
    \ n;\n    std::cout << p_count(ll(1e11)).pi(n) << '\\n';\n}"
  dependsOn:
  - C++/math.hpp
  isVerificationFile: true
  path: test/pcounter.test.cpp
  requiredBy: []
  timestamp: '2023-12-01 04:17:01+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/pcounter.test.cpp
layout: document
redirect_from:
- /verify/test/pcounter.test.cpp
- /verify/test/pcounter.test.cpp.html
title: test/pcounter.test.cpp
---
