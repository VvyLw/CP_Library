---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
  - icon: ':warning:'
    path: C++/mypair.hpp
    title: C++/mypair.hpp
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    document_title: "\u5B9A\u6570"
    links: []
  bundledCode: "#line 2 \"C++/constance.hpp\"\n\n#include <limits>\n#ifndef TEMPLATE\n\
    using ll = long long;\nusing ld = long double;\n#endif\ntemplate <class T> using\
    \ L = std::numeric_limits<T>;\nconstexpr int dx[] = {0, 0, 0, -1, 1, -1, -1, 1,\
    \ 1};\nconstexpr int dy[] = {0, -1, 1, 0, 0, -1, 1, -1, 1};\nconstexpr int MOD\
    \ = 0x3b800001;\nconstexpr int M0D = 1e9 + 7;\nconstexpr int INF = 1 << 30;\n\
    constexpr ll LINF = (1LL << 61) - 1;\nconstexpr ld DINF = L<ld>::infinity();\n\
    template <class T> constexpr T LIM = L<T>::max();\n#if __cplusplus >= 202100L\n\
    #include <numbers>\nconstexpr ld PI = std::numbers::pi;\nconstexpr ld E = std::numbers::e;\n\
    #else\n#include <cmath>\nconst ld PI = std::acos(-1);\nconst ld E = 2.718281828459045;\n\
    #endif\n\n/**\n * @brief \u5B9A\u6570\n */\n"
  code: "#pragma once\n\n#include <limits>\n#ifndef TEMPLATE\nusing ll = long long;\n\
    using ld = long double;\n#endif\ntemplate <class T> using L = std::numeric_limits<T>;\n\
    constexpr int dx[] = {0, 0, 0, -1, 1, -1, -1, 1, 1};\nconstexpr int dy[] = {0,\
    \ -1, 1, 0, 0, -1, 1, -1, 1};\nconstexpr int MOD = 0x3b800001;\nconstexpr int\
    \ M0D = 1e9 + 7;\nconstexpr int INF = 1 << 30;\nconstexpr ll LINF = (1LL << 61)\
    \ - 1;\nconstexpr ld DINF = L<ld>::infinity();\ntemplate <class T> constexpr T\
    \ LIM = L<T>::max();\n#if __cplusplus >= 202100L\n#include <numbers>\nconstexpr\
    \ ld PI = std::numbers::pi;\nconstexpr ld E = std::numbers::e;\n#else\n#include\
    \ <cmath>\nconst ld PI = std::acos(-1);\nconst ld E = 2.718281828459045;\n#endif\n\
    \n/**\n * @brief \u5B9A\u6570\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/constance.hpp
  requiredBy:
  - C++/mypair.hpp
  timestamp: '2024-02-19 12:20:55+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/constance.hpp
layout: document
redirect_from:
- /library/C++/constance.hpp
- /library/C++/constance.hpp.html
title: "\u5B9A\u6570"
---
