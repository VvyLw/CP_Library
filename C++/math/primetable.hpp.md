---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
  - icon: ':heavy_check_mark:'
    path: C++/math/primecounter.hpp
    title: "\u7D20\u6570\u306E\u500B\u6570"
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
    path: test/pcounter.test.cpp
    title: test/pcounter.test.cpp
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
    document_title: Sieve of Eratosthenes
    links: []
  bundledCode: "#line 2 \"C++/math/primetable.hpp\"\n\n#include <vector>\nnamespace\
    \ Heileden {\nstruct p_table {\n    std::vector<int> SoE;\n    p_table(const int\
    \ n): SoE(n + 1, 1) {\n        SoE[0] = SoE[1] = 0;\n        for(int64_t i = 2;\
    \ i <= n; ++i) {\n            if(!SoE[i]) {\n                continue;\n     \
    \       }\n            for(int64_t j = i * i; j <= n; j += i) {\n            \
    \    SoE[j] = 0;\n            }\n        }\n    }\n    std::vector<int> get()\
    \ {\n        std::vector<int> p;\n        for(size_t i = 2; i < SoE.size(); ++i)\
    \ {\n            if(SoE[i]) {\n                p.emplace_back(i);\n          \
    \  }\n        }\n        return p;\n    }\n};\n}\n\n/**\n * @brief Sieve of Eratosthenes\n\
    \ */\n"
  code: "#pragma once\n\n#include <vector>\nnamespace Heileden {\nstruct p_table {\n\
    \    std::vector<int> SoE;\n    p_table(const int n): SoE(n + 1, 1) {\n      \
    \  SoE[0] = SoE[1] = 0;\n        for(int64_t i = 2; i <= n; ++i) {\n         \
    \   if(!SoE[i]) {\n                continue;\n            }\n            for(int64_t\
    \ j = i * i; j <= n; j += i) {\n                SoE[j] = 0;\n            }\n \
    \       }\n    }\n    std::vector<int> get() {\n        std::vector<int> p;\n\
    \        for(size_t i = 2; i < SoE.size(); ++i) {\n            if(SoE[i]) {\n\
    \                p.emplace_back(i);\n            }\n        }\n        return\
    \ p;\n    }\n};\n}\n\n/**\n * @brief Sieve of Eratosthenes\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/primetable.hpp
  requiredBy:
  - C++/template.hpp
  - C++/math/primecounter.hpp
  timestamp: '2024-03-29 03:01:20+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/add128.test.cpp
  - test/parsum.test.cpp
  - test/uf.test.cpp
  - test/fwtree.test.cpp
  - test/add.test.cpp
  - test/s_rmq.test.cpp
  - test/stable.test.cpp
  - test/aarray.test.cpp
  - test/pcounter.test.cpp
  - test/sr_sum.test.cpp
  - test/m_add.test.cpp
  - test/segtree.test.cpp
  - test/extgcd.test.cpp
documentation_of: C++/math/primetable.hpp
layout: document
redirect_from:
- /library/C++/math/primetable.hpp
- /library/C++/math/primetable.hpp.html
title: Sieve of Eratosthenes
---
