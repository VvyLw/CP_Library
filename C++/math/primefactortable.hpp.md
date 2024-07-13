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
    document_title: "\u7D20\u56E0\u6570\u5206\u89E3\u30C6\u30FC\u30D6\u30EB"
    links: []
  bundledCode: "#line 2 \"C++/math/primefactortable.hpp\"\n\n#include <vector>\n#include\
    \ <map>\n#include <numeric>\nnamespace Heileden {\nstruct p_fact {\n    std::vector<int64_t>\
    \ spf;\n    p_fact(const int n): spf(n + 1){\n        std::iota(spf.begin(), spf.end(),\
    \ 0);\n        for(int64_t i = 2; i * i <= n; ++i) {\n            if(spf[i] ==\
    \ i) {\n                for(int64_t j = i * i; j <= n; j += i) {\n           \
    \         if(spf[j]==j) {\n                        spf[j]=i;\n               \
    \     }\n                }\n            }\n        }\n    }\n    std::map<int,\
    \ int> get(int n) {\n        std::map<int, int> m;\n        while(n != 1) {\n\
    \            m[spf[n]]++;\n            n /= spf[n];\n        }\n        return\
    \ m;\n    }\n};\n}\n\n/**\n * @brief \u7D20\u56E0\u6570\u5206\u89E3\u30C6\u30FC\
    \u30D6\u30EB\n */\n"
  code: "#pragma once\n\n#include <vector>\n#include <map>\n#include <numeric>\nnamespace\
    \ Heileden {\nstruct p_fact {\n    std::vector<int64_t> spf;\n    p_fact(const\
    \ int n): spf(n + 1){\n        std::iota(spf.begin(), spf.end(), 0);\n       \
    \ for(int64_t i = 2; i * i <= n; ++i) {\n            if(spf[i] == i) {\n     \
    \           for(int64_t j = i * i; j <= n; j += i) {\n                    if(spf[j]==j)\
    \ {\n                        spf[j]=i;\n                    }\n              \
    \  }\n            }\n        }\n    }\n    std::map<int, int> get(int n) {\n \
    \       std::map<int, int> m;\n        while(n != 1) {\n            m[spf[n]]++;\n\
    \            n /= spf[n];\n        }\n        return m;\n    }\n};\n}\n\n/**\n\
    \ * @brief \u7D20\u56E0\u6570\u5206\u89E3\u30C6\u30FC\u30D6\u30EB\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/primefactortable.hpp
  requiredBy:
  - C++/template.hpp
  timestamp: '2024-03-29 03:01:20+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/add.test.cpp
  - test/s_rmq.test.cpp
  - test/aarray.test.cpp
  - test/segtree.test.cpp
  - test/sr_sum.test.cpp
  - test/extgcd.test.cpp
  - test/fwtree.test.cpp
  - test/uf.test.cpp
  - test/add128.test.cpp
  - test/stable.test.cpp
  - test/m_add.test.cpp
  - test/parsum.test.cpp
documentation_of: C++/math/primefactortable.hpp
layout: document
redirect_from:
- /library/C++/math/primefactortable.hpp
- /library/C++/math/primefactortable.hpp.html
title: "\u7D20\u56E0\u6570\u5206\u89E3\u30C6\u30FC\u30D6\u30EB"
---
