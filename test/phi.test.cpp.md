---
data:
  _extendedDependsOn:
  - icon: ':x:'
    path: C++/math/euler_phi.hpp
    title: Euler's Phi-function
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: cpp
  _verificationStatusIcon: ':x:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://onlinejudge.u-aizu.ac.jp/courses/library/6/NTL/1/NTL_1_D
    links:
    - https://onlinejudge.u-aizu.ac.jp/courses/library/6/NTL/1/NTL_1_D
  bundledCode: "#line 1 \"test/phi.test.cpp\"\n#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/library/6/NTL/1/NTL_1_D\"\
    \n#include <iostream>\n#line 2 \"C++/math/euler_phi.hpp\"\nnamespace man {\ntemplate\
    \ <class T> constexpr inline T euler_phi(T n) noexcept {\n\tT ret = n;\n\tfor(T\
    \ i = 2; i * i <= n; ++i) {\n\t    if(n % i == 0) {\n\t\t\tret -= ret / i;\n\t\
    \t\twhile(n % i == 0) {\n\t\t\t\tn /= i;\n\t\t\t}\n\t\t}\n\t}\n\tif(n > 1) {\n\
    \t\tret -= ret / n;\n\t}\n\treturn ret;\n}\n}\n\n/**\n * @brief Euler's Phi-function\n\
    \ */\n#line 4 \"test/phi.test.cpp\"\nint main() {\n    long n;\n    std::cin >>\
    \ n;\n    std::cout << man::euler_phi(n) << '\\n';\n}\n"
  code: "#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/library/6/NTL/1/NTL_1_D\"\
    \n#include <iostream>\n#include \"C++/math/euler_phi.hpp\"\nint main() {\n   \
    \ long n;\n    std::cin >> n;\n    std::cout << man::euler_phi(n) << '\\n';\n}"
  dependsOn:
  - C++/math/euler_phi.hpp
  isVerificationFile: true
  path: test/phi.test.cpp
  requiredBy: []
  timestamp: '2025-06-06 22:43:22+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: test/phi.test.cpp
layout: document
redirect_from:
- /verify/test/phi.test.cpp
- /verify/test/phi.test.cpp.html
title: test/phi.test.cpp
---
