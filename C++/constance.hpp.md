---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
  - icon: ':question:'
    path: C++/io/input.hpp
    title: "\u5165\u529B"
  - icon: ':question:'
    path: C++/io/output.hpp
    title: "\u51FA\u529B"
  - icon: ':question:'
    path: C++/math/primefactor.hpp
    title: "\u7D20\u56E0\u6570\u5206\u89E3"
  - icon: ':question:'
    path: C++/mypair.hpp
    title: C++/mypair.hpp
  - icon: ':question:'
    path: C++/template.hpp
    title: "\u30C6\u30F3\u30D7\u30EC\u30FC\u30C8"
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/C++/aarray.test.cpp
    title: test/C++/aarray.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/C++/add.test.cpp
    title: test/C++/add.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/C++/add128.test.cpp
    title: test/C++/add128.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/C++/add128_2.test.cpp
    title: test/C++/add128_2.test.cpp
  - icon: ':x:'
    path: test/C++/extgcd.test.cpp
    title: test/C++/extgcd.test.cpp
  - icon: ':x:'
    path: test/C++/fwtree.test.cpp
    title: test/C++/fwtree.test.cpp
  - icon: ':x:'
    path: test/C++/m_add.test.cpp
    title: test/C++/m_add.test.cpp
  - icon: ':x:'
    path: test/C++/parsum.test.cpp
    title: test/C++/parsum.test.cpp
  - icon: ':x:'
    path: test/C++/s_rmq.test.cpp
    title: test/C++/s_rmq.test.cpp
  - icon: ':x:'
    path: test/C++/segtree.test.cpp
    title: test/C++/segtree.test.cpp
  - icon: ':x:'
    path: test/C++/sr_sum.test.cpp
    title: test/C++/sr_sum.test.cpp
  - icon: ':x:'
    path: test/C++/stable.test.cpp
    title: test/C++/stable.test.cpp
  - icon: ':x:'
    path: test/C++/uf.test.cpp
    title: test/C++/uf.test.cpp
  _isVerificationFailed: true
  _pathExtension: hpp
  _verificationStatusIcon: ':question:'
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
  - C++/io/output.hpp
  - C++/io/input.hpp
  - C++/math/primefactor.hpp
  - C++/mypair.hpp
  - C++/template.hpp
  timestamp: '2024-02-19 12:20:55+09:00'
  verificationStatus: LIBRARY_SOME_WA
  verifiedWith:
  - test/C++/sr_sum.test.cpp
  - test/C++/m_add.test.cpp
  - test/C++/add.test.cpp
  - test/C++/parsum.test.cpp
  - test/C++/segtree.test.cpp
  - test/C++/stable.test.cpp
  - test/C++/fwtree.test.cpp
  - test/C++/uf.test.cpp
  - test/C++/extgcd.test.cpp
  - test/C++/add128_2.test.cpp
  - test/C++/add128.test.cpp
  - test/C++/s_rmq.test.cpp
  - test/C++/aarray.test.cpp
documentation_of: C++/constance.hpp
layout: document
redirect_from:
- /library/C++/constance.hpp
- /library/C++/constance.hpp.html
title: "\u5B9A\u6570"
---
