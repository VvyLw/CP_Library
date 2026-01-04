---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
  - icon: ':warning:'
    path: C++/math/divisortable.hpp
    title: "\u7D04\u6570\u306E\u500B\u6570(\u7DDA\u5F62\u7BE9)"
  - icon: ':heavy_check_mark:'
    path: C++/math/primecounter.hpp
    title: "\u7D20\u6570\u306E\u500B\u6570"
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/pcounter.test.cpp
    title: test/pcounter.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: Sieve of Eratosthenes
    links: []
  bundledCode: "#line 2 \"C++/math/primetable.hpp\"\n\n#include <vector>\n#include\
    \ <ranges>\nnamespace man {\nstruct p_table {\n    std::vector<int> SoE;\n   \
    \ p_table(const int n): SoE(n + 1, 1) {\n        SoE[0] = SoE[1] = 0;\n      \
    \  for(const long long i: std::views::iota(2, n + 1)) {\n            if(!SoE[i])\
    \ {\n                continue;\n            }\n            for(long long j = i\
    \ * i; j <= n; j += i) {\n                SoE[j] = 0;\n            }\n       \
    \ }\n    }\n    std::vector<int> get() {\n        std::vector<int> p;\n      \
    \  for(const auto i: std::views::iota(2, std::ssize(SoE))) {\n            if(SoE[i])\
    \ {\n                p.emplace_back(i);\n            }\n        }\n        return\
    \ p;\n    }\n};\n}\n\n/**\n * @brief Sieve of Eratosthenes\n */\n"
  code: "#pragma once\n\n#include <vector>\n#include <ranges>\nnamespace man {\nstruct\
    \ p_table {\n    std::vector<int> SoE;\n    p_table(const int n): SoE(n + 1, 1)\
    \ {\n        SoE[0] = SoE[1] = 0;\n        for(const long long i: std::views::iota(2,\
    \ n + 1)) {\n            if(!SoE[i]) {\n                continue;\n          \
    \  }\n            for(long long j = i * i; j <= n; j += i) {\n               \
    \ SoE[j] = 0;\n            }\n        }\n    }\n    std::vector<int> get() {\n\
    \        std::vector<int> p;\n        for(const auto i: std::views::iota(2, std::ssize(SoE)))\
    \ {\n            if(SoE[i]) {\n                p.emplace_back(i);\n          \
    \  }\n        }\n        return p;\n    }\n};\n}\n\n/**\n * @brief Sieve of Eratosthenes\n\
    \ */"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/primetable.hpp
  requiredBy:
  - C++/math/divisortable.hpp
  - C++/math/primecounter.hpp
  timestamp: '2025-06-14 01:07:36+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/pcounter.test.cpp
documentation_of: C++/math/primetable.hpp
layout: document
redirect_from:
- /library/C++/math/primetable.hpp
- /library/C++/math/primetable.hpp.html
title: Sieve of Eratosthenes
---
