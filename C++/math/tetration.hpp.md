---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/math/euler_phi.hpp
    title: Euler's Phi-function
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/tetration.test.cpp
    title: test/tetration.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: "Tetration(a\u2191\u2191b)"
    links: []
  bundledCode: "#line 2 \"C++/math/tetration.hpp\"\n\n#line 2 \"C++/math/euler_phi.hpp\"\
    \nnamespace man {\ntemplate <std::integral T> constexpr inline T euler_phi(T n)\
    \ noexcept {\n\tT ret = n;\n\tfor(T i = 2; i * i <= n; ++i) {\n\t    if(n % i\
    \ == 0) {\n\t\t\tret -= ret / i;\n\t\t\twhile(n % i == 0) {\n\t\t\t\tn /= i;\n\
    \t\t\t}\n\t\t}\n\t}\n\tif(n > 1) {\n\t\tret -= ret / n;\n\t}\n\treturn ret;\n\
    }\n}\n\n/**\n * @brief Euler's Phi-function\n */\n#line 4 \"C++/math/tetration.hpp\"\
    \n#ifndef TEMPLATE\nnamespace man {\ntemplate <std::integral T> constexpr inline\
    \ T pow(T a, T b, const T mod = 0) noexcept {\n\tT ret = 1;\n\tif(mod != 0) {\n\
    \t\tret %= mod;\n\t\ta %= mod;\n\t}\n\twhile(b > 0) {\n\t\tif(b & 1) {\n\t\t\t\
    ret *= a;\n\t\t}\n\t\tif(mod != 0) {\n\t\t\tret %= mod;\n\t\t}\n\t\ta *= a;\n\t\
    \tif(mod) {\n\t\t\ta %= mod;\n\t\t}\n\t\tb >>= 1;\n\t}\n\treturn ret;\n}\n}\n\
    #endif\nnamespace man {\ntemplate <std::integral T> constexpr inline T tetration(const\
    \ T a, const T b, const T m) noexcept {\n    if(m == 1) {\n        return 0;\n\
    \    }\n    if(a == 0) {\n        return (b & 1) ? 0 : 1;\n    }\n    if(b ==\
    \ 0) {\n        return 1;\n    }\n    if(b == 1) {\n        return a % m;\n  \
    \  }\n    if(b == 2) {\n        return pow(a, a, m);\n    }\n    const auto phi\
    \ = euler_phi(m);\n    auto tmp = tetration(a, b - 1, phi);\n    if(!tmp) {\n\
    \        tmp += phi;\n    }\n    return pow(a, tmp, m);\n}\n}\n\n/**\n * @brief\
    \ Tetration(a\u2191\u2191b)\n */\n"
  code: "#pragma once\n\n#include \"C++/math/euler_phi.hpp\"\n#ifndef TEMPLATE\nnamespace\
    \ man {\ntemplate <std::integral T> constexpr inline T pow(T a, T b, const T mod\
    \ = 0) noexcept {\n\tT ret = 1;\n\tif(mod != 0) {\n\t\tret %= mod;\n\t\ta %= mod;\n\
    \t}\n\twhile(b > 0) {\n\t\tif(b & 1) {\n\t\t\tret *= a;\n\t\t}\n\t\tif(mod !=\
    \ 0) {\n\t\t\tret %= mod;\n\t\t}\n\t\ta *= a;\n\t\tif(mod) {\n\t\t\ta %= mod;\n\
    \t\t}\n\t\tb >>= 1;\n\t}\n\treturn ret;\n}\n}\n#endif\nnamespace man {\ntemplate\
    \ <std::integral T> constexpr inline T tetration(const T a, const T b, const T\
    \ m) noexcept {\n    if(m == 1) {\n        return 0;\n    }\n    if(a == 0) {\n\
    \        return (b & 1) ? 0 : 1;\n    }\n    if(b == 0) {\n        return 1;\n\
    \    }\n    if(b == 1) {\n        return a % m;\n    }\n    if(b == 2) {\n   \
    \     return pow(a, a, m);\n    }\n    const auto phi = euler_phi(m);\n    auto\
    \ tmp = tetration(a, b - 1, phi);\n    if(!tmp) {\n        tmp += phi;\n    }\n\
    \    return pow(a, tmp, m);\n}\n}\n\n/**\n * @brief Tetration(a\u2191\u2191b)\n\
    \ */"
  dependsOn:
  - C++/math/euler_phi.hpp
  isVerificationFile: false
  path: C++/math/tetration.hpp
  requiredBy: []
  timestamp: '2025-06-11 17:30:11+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/tetration.test.cpp
documentation_of: C++/math/tetration.hpp
layout: document
redirect_from:
- /library/C++/math/tetration.hpp
- /library/C++/math/tetration.hpp.html
title: "Tetration(a\u2191\u2191b)"
---
