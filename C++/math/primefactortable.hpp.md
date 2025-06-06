---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    document_title: "\u7D20\u56E0\u6570\u5206\u89E3\u30C6\u30FC\u30D6\u30EB"
    links: []
  bundledCode: "#line 2 \"C++/math/primefactortable.hpp\"\n\n#include <vector>\n#include\
    \ <map>\n#include <numeric>\nnamespace man {\nstruct p_fact {\n    std::vector<int64_t>\
    \ spf;\n    p_fact(const int n): spf(n + 1){\n        std::iota(spf.begin(), spf.end(),\
    \ 0);\n        for(int64_t i = 2; i * i <= n; ++i) {\n            if(spf[i] ==\
    \ i) {\n                for(int64_t j = i * i; j <= n; j += i) {\n           \
    \         if(spf[j] == j) {\n                        spf[j] = i;\n           \
    \         }\n                }\n            }\n        }\n    }\n    inline std::map<int,\
    \ int> get(int n) noexcept {\n        std::map<int, int> m;\n        while(n !=\
    \ 1) {\n            m[spf[n]]++;\n            n /= spf[n];\n        }\n      \
    \  return m;\n    }\n};\n}\n\n/**\n * @brief \u7D20\u56E0\u6570\u5206\u89E3\u30C6\
    \u30FC\u30D6\u30EB\n */\n"
  code: "#pragma once\n\n#include <vector>\n#include <map>\n#include <numeric>\nnamespace\
    \ man {\nstruct p_fact {\n    std::vector<int64_t> spf;\n    p_fact(const int\
    \ n): spf(n + 1){\n        std::iota(spf.begin(), spf.end(), 0);\n        for(int64_t\
    \ i = 2; i * i <= n; ++i) {\n            if(spf[i] == i) {\n                for(int64_t\
    \ j = i * i; j <= n; j += i) {\n                    if(spf[j] == j) {\n      \
    \                  spf[j] = i;\n                    }\n                }\n   \
    \         }\n        }\n    }\n    inline std::map<int, int> get(int n) noexcept\
    \ {\n        std::map<int, int> m;\n        while(n != 1) {\n            m[spf[n]]++;\n\
    \            n /= spf[n];\n        }\n        return m;\n    }\n};\n}\n\n/**\n\
    \ * @brief \u7D20\u56E0\u6570\u5206\u89E3\u30C6\u30FC\u30D6\u30EB\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/primefactortable.hpp
  requiredBy: []
  timestamp: '2025-06-06 22:43:06+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/math/primefactortable.hpp
layout: document
redirect_from:
- /library/C++/math/primefactortable.hpp
- /library/C++/math/primefactortable.hpp.html
title: "\u7D20\u56E0\u6570\u5206\u89E3\u30C6\u30FC\u30D6\u30EB"
---
