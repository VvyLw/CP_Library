---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
  - icon: ':heavy_check_mark:'
    path: C++/core/io/input.hpp
    title: "\u5165\u529B"
  - icon: ':heavy_check_mark:'
    path: C++/core/mypair.hpp
    title: C++/core/mypair.hpp
  - icon: ':heavy_check_mark:'
    path: C++/template.hpp
    title: "\u30C6\u30F3\u30D7\u30EC\u30FC\u30C8"
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/aarray.test.cpp
    title: test/aarray.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/add.test.cpp
    title: test/add.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/add128.test.cpp
    title: test/add128.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/add128_2.test.cpp
    title: test/add128_2.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/extgcd.test.cpp
    title: test/extgcd.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/fwtree.test.cpp
    title: test/fwtree.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/m_add.test.cpp
    title: test/m_add.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/parsum.test.cpp
    title: test/parsum.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/s_rmq.test.cpp
    title: test/s_rmq.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/segtree.test.cpp
    title: test/segtree.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/sr_sum.test.cpp
    title: test/sr_sum.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/stable.test.cpp
    title: test/stable.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/uf.test.cpp
    title: test/uf.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: "\u5B9A\u6570"
    links: []
  bundledCode: "#line 2 \"C++/core/constance.hpp\"\n\n#include <limits>\n#ifndef TEMPLATE\n\
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
  path: C++/core/constance.hpp
  requiredBy:
  - C++/template.hpp
  - C++/core/mypair.hpp
  - C++/core/io/input.hpp
  timestamp: '2024-03-09 13:04:52+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/stable.test.cpp
  - test/s_rmq.test.cpp
  - test/fwtree.test.cpp
  - test/sr_sum.test.cpp
  - test/add.test.cpp
  - test/add128_2.test.cpp
  - test/uf.test.cpp
  - test/aarray.test.cpp
  - test/add128.test.cpp
  - test/parsum.test.cpp
  - test/extgcd.test.cpp
  - test/m_add.test.cpp
  - test/segtree.test.cpp
documentation_of: C++/core/constance.hpp
layout: document
redirect_from:
- /library/C++/core/constance.hpp
- /library/C++/core/constance.hpp.html
title: "\u5B9A\u6570"
---
