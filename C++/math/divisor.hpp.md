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
    document_title: "\u7D04\u6570\u5217\u6319"
    links: []
  bundledCode: "#line 2 \"C++/math/divisor.hpp\"\n\n#include <vector>\n#include <algorithm>\n\
    namespace man {\ntemplate <class T> inline std::vector<T> div(const T n) noexcept\
    \ {\n    std::vector<T> d;\n    for(int64_t i = 1; i * i <= n; ++i) {\n      \
    \  if(n % i == 0) {\n            d.emplace_back(i);\n            if(i * i != n)\
    \ {\n                d.emplace_back(n / i);\n            }\n        }\n    }\n\
    \    std::ranges::sort(d);\n    return d;\n}\n}\n\n/**\n * @brief \u7D04\u6570\
    \u5217\u6319\n */\n"
  code: "#pragma once\n\n#include <vector>\n#include <algorithm>\nnamespace man {\n\
    template <class T> inline std::vector<T> div(const T n) noexcept {\n    std::vector<T>\
    \ d;\n    for(int64_t i = 1; i * i <= n; ++i) {\n        if(n % i == 0) {\n  \
    \          d.emplace_back(i);\n            if(i * i != n) {\n                d.emplace_back(n\
    \ / i);\n            }\n        }\n    }\n    std::ranges::sort(d);\n    return\
    \ d;\n}\n}\n\n/**\n * @brief \u7D04\u6570\u5217\u6319\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/divisor.hpp
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
documentation_of: C++/math/divisor.hpp
layout: document
redirect_from:
- /library/C++/math/divisor.hpp
- /library/C++/math/divisor.hpp.html
title: "\u7D04\u6570\u5217\u6319"
---
