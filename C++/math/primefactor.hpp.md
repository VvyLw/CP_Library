---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
  - icon: ':question:'
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
  - icon: ':x:'
    path: test/parsum.test.cpp
    title: test/parsum.test.cpp
  - icon: ':x:'
    path: test/s_rmq.test.cpp
    title: test/s_rmq.test.cpp
  - icon: ':x:'
    path: test/segtree.test.cpp
    title: test/segtree.test.cpp
  - icon: ':x:'
    path: test/sr_sum.test.cpp
    title: test/sr_sum.test.cpp
  - icon: ':x:'
    path: test/stable.test.cpp
    title: test/stable.test.cpp
  - icon: ':x:'
    path: test/uf.test.cpp
    title: test/uf.test.cpp
  _isVerificationFailed: true
  _pathExtension: hpp
  _verificationStatusIcon: ':question:'
  attributes:
    document_title: "\u7D20\u56E0\u6570\u5206\u89E3"
    links: []
  bundledCode: "#line 2 \"C++/math/primefactor.hpp\"\n\n#include <vector>\n#include\
    \ <utility>\nnamespace man {\ntemplate <class T> inline std::vector<std::pair<T,\
    \ int>> prmfct(T n) noexcept {\n    std::vector<std::pair<T, int>> ret;\n    for(int64_t\
    \ i = 2; i * i <= n; ++i) {\n        if(n % i != 0) {\n            continue;\n\
    \        }\n        int tmp = 0;\n        while(n % i == 0) {\n            tmp++;\n\
    \            n /= i;\n        }\n        ret.emplace_back(i, tmp);\n    }\n  \
    \  if(n != 1) {\n        ret.emplace_back(n, 1);\n    }\n    return ret;\n}\n\
    }\n\n/**\n * @brief \u7D20\u56E0\u6570\u5206\u89E3\n */\n"
  code: "#pragma once\n\n#include <vector>\n#include <utility>\nnamespace man {\n\
    template <class T> inline std::vector<std::pair<T, int>> prmfct(T n) noexcept\
    \ {\n    std::vector<std::pair<T, int>> ret;\n    for(int64_t i = 2; i * i <=\
    \ n; ++i) {\n        if(n % i != 0) {\n            continue;\n        }\n    \
    \    int tmp = 0;\n        while(n % i == 0) {\n            tmp++;\n         \
    \   n /= i;\n        }\n        ret.emplace_back(i, tmp);\n    }\n    if(n !=\
    \ 1) {\n        ret.emplace_back(n, 1);\n    }\n    return ret;\n}\n}\n\n/**\n\
    \ * @brief \u7D20\u56E0\u6570\u5206\u89E3\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/primefactor.hpp
  requiredBy:
  - C++/template.hpp
  timestamp: '2025-06-06 22:43:06+09:00'
  verificationStatus: LIBRARY_SOME_WA
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
documentation_of: C++/math/primefactor.hpp
layout: document
redirect_from:
- /library/C++/math/primefactor.hpp
- /library/C++/math/primefactor.hpp.html
title: "\u7D20\u56E0\u6570\u5206\u89E3"
---
