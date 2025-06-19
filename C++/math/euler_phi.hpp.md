---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
  - icon: ':heavy_check_mark:'
    path: C++/math/tetration.hpp
    title: "Tetration(a\u2191\u2191b)"
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/phi.test.cpp
    title: test/phi.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/tetration.test.cpp
    title: test/tetration.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: Euler's Phi-function
    links: []
  bundledCode: "#line 2 \"C++/math/euler_phi.hpp\"\nnamespace man {\ntemplate <std::integral\
    \ T> constexpr inline T euler_phi(T n) noexcept {\n\tT ret = n;\n\tfor(T i = 2;\
    \ i * i <= n; ++i) {\n\t    if(n % i == 0) {\n\t\t\tret -= ret / i;\n\t\t\twhile(n\
    \ % i == 0) {\n\t\t\t\tn /= i;\n\t\t\t}\n\t\t}\n\t}\n\tif(n > 1) {\n\t\tret -=\
    \ ret / n;\n\t}\n\treturn ret;\n}\n}\n\n/**\n * @brief Euler's Phi-function\n\
    \ */\n"
  code: "#pragma once\nnamespace man {\ntemplate <std::integral T> constexpr inline\
    \ T euler_phi(T n) noexcept {\n\tT ret = n;\n\tfor(T i = 2; i * i <= n; ++i) {\n\
    \t    if(n % i == 0) {\n\t\t\tret -= ret / i;\n\t\t\twhile(n % i == 0) {\n\t\t\
    \t\tn /= i;\n\t\t\t}\n\t\t}\n\t}\n\tif(n > 1) {\n\t\tret -= ret / n;\n\t}\n\t\
    return ret;\n}\n}\n\n/**\n * @brief Euler's Phi-function\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/euler_phi.hpp
  requiredBy:
  - C++/math/tetration.hpp
  timestamp: '2025-06-11 17:30:11+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/phi.test.cpp
  - test/tetration.test.cpp
documentation_of: C++/math/euler_phi.hpp
layout: document
redirect_from:
- /library/C++/math/euler_phi.hpp
- /library/C++/math/euler_phi.hpp.html
title: Euler's Phi-function
---
