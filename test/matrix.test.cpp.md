---
data:
  _extendedDependsOn:
  - icon: ':x:'
    path: C++/Matrix.hpp
    title: "\u884C\u5217\u30E9\u30A4\u30D6\u30E9\u30EA"
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: cpp
  _verificationStatusIcon: ':x:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://yukicoder.me/problems/no/2441
    links:
    - https://yukicoder.me/problems/no/2441
  bundledCode: "#line 1 \"test/matrix.test.cpp\"\n#define PROBLEM \"https://yukicoder.me/problems/no/2441\"\
    \n#include <iostream>\n#include <C++/Matrix.hpp>\nint main() {\n    int a, b,\
    \ c, d;\n    std::cin >> a >> b >> c >> d;\n    Matrix<int64_t> m(2);\n    m[0][0]\
    \ = a;\n    m[0][1] = b;\n    m[1][0] = c;\n    m[1][1] = d;\n    m ^= 3;\n  \
    \  for(int i = 0; i < 2; ++i) {\n        std::cout << m[i][0] << ' ' << m[i][1]\
    \ << '\\n';\n    }\n}\n"
  code: "#define PROBLEM \"https://yukicoder.me/problems/no/2441\"\n#include <iostream>\n\
    #include <C++/Matrix.hpp>\nint main() {\n    int a, b, c, d;\n    std::cin >>\
    \ a >> b >> c >> d;\n    Matrix<int64_t> m(2);\n    m[0][0] = a;\n    m[0][1]\
    \ = b;\n    m[1][0] = c;\n    m[1][1] = d;\n    m ^= 3;\n    for(int i = 0; i\
    \ < 2; ++i) {\n        std::cout << m[i][0] << ' ' << m[i][1] << '\\n';\n    }\n\
    }"
  dependsOn:
  - C++/Matrix.hpp
  isVerificationFile: true
  path: test/matrix.test.cpp
  requiredBy: []
  timestamp: '2024-01-30 15:48:07+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: test/matrix.test.cpp
layout: document
redirect_from:
- /verify/test/matrix.test.cpp
- /verify/test/matrix.test.cpp.html
title: test/matrix.test.cpp
---
