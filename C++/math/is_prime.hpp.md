---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
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
    links: []
  bundledCode: "#line 2 \"C++/math/is_prime.hpp\"\n#include <cstdint>\n\nnamespace\
    \ man {\nconstexpr inline bool is_prime(const uint64_t n) noexcept {\n\tif(n <=\
    \ 1) {\n\t\treturn false;\n\t}\n\tif(n <= 3) {\n\t\treturn true;\n\t}\n\tif(n\
    \ % 2 ==0 || n % 3 == 0) {\n\t\treturn false;\n\t}\n\tfor(int64_t i = 5; i * i\
    \ <= n; i += 6) {\n\t\tif(n % i == 0 || n % (i + 2) == 0) {\n\t\t\treturn false;\n\
    \t\t}\n\t}\n\treturn true;\n}\n}\n"
  code: "#pragma once\n#include <cstdint>\n\nnamespace man {\nconstexpr inline bool\
    \ is_prime(const uint64_t n) noexcept {\n\tif(n <= 1) {\n\t\treturn false;\n\t\
    }\n\tif(n <= 3) {\n\t\treturn true;\n\t}\n\tif(n % 2 ==0 || n % 3 == 0) {\n\t\t\
    return false;\n\t}\n\tfor(int64_t i = 5; i * i <= n; i += 6) {\n\t\tif(n % i ==\
    \ 0 || n % (i + 2) == 0) {\n\t\t\treturn false;\n\t\t}\n\t}\n\treturn true;\n\
    }\n}"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/is_prime.hpp
  requiredBy:
  - C++/template.hpp
  timestamp: '2025-06-06 22:43:06+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/aarray.test.cpp
  - test/m_add.test.cpp
  - test/sr_sum.test.cpp
  - test/uf.test.cpp
  - test/add128.test.cpp
  - test/parsum.test.cpp
  - test/extgcd.test.cpp
  - test/stable.test.cpp
  - test/fwtree.test.cpp
  - test/segtree.test.cpp
  - test/add.test.cpp
  - test/s_rmq.test.cpp
documentation_of: C++/math/is_prime.hpp
layout: document
redirect_from:
- /library/C++/math/is_prime.hpp
- /library/C++/math/is_prime.hpp.html
title: C++/math/is_prime.hpp
---
