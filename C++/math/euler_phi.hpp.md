---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
  - icon: ':x:'
    path: C++/math/tetration.hpp
    title: "Tetration(a\u2191\u2191b)"
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/phi.test.cpp
    title: test/phi.test.cpp
  - icon: ':x:'
    path: test/tetration.test.cpp
    title: test/tetration.test.cpp
  _isVerificationFailed: true
  _pathExtension: hpp
  _verificationStatusIcon: ':question:'
  attributes:
    document_title: Euler's Phi-function
    links: []
  bundledCode: "#line 2 \"C++/math/euler_phi.hpp\"\ntemplate <class T> inline T euler_phi(T\
    \ n) {\n\tT res = n;\n\tfor(T i = 2; i * i <= n; ++i) {\n\t    if(n % i == 0)\
    \ {\n\t\t\tres -= res / i;\n\t\t\twhile(n % i == 0) {\n\t\t\t\tn /= i;\n\t\t\t\
    }\n\t\t}\n\t}\n\tif(n > 1) {\n\t\tres -= res / n;\n\t}\n\treturn res;\n}\n\n/**\n\
    \ * @brief Euler's Phi-function\n */\n"
  code: "#pragma once\ntemplate <class T> inline T euler_phi(T n) {\n\tT res = n;\n\
    \tfor(T i = 2; i * i <= n; ++i) {\n\t    if(n % i == 0) {\n\t\t\tres -= res /\
    \ i;\n\t\t\twhile(n % i == 0) {\n\t\t\t\tn /= i;\n\t\t\t}\n\t\t}\n\t}\n\tif(n\
    \ > 1) {\n\t\tres -= res / n;\n\t}\n\treturn res;\n}\n\n/**\n * @brief Euler's\
    \ Phi-function\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/euler_phi.hpp
  requiredBy:
  - C++/math/tetration.hpp
  timestamp: '2024-02-19 12:20:55+09:00'
  verificationStatus: LIBRARY_SOME_WA
  verifiedWith:
  - test/tetration.test.cpp
  - test/phi.test.cpp
documentation_of: C++/math/euler_phi.hpp
layout: document
redirect_from:
- /library/C++/math/euler_phi.hpp
- /library/C++/math/euler_phi.hpp.html
title: Euler's Phi-function
---
