---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    document_title: Manacher
    links:
    - https://ei1333.github.io/library/string/manacher.hpp
  bundledCode: "#line 2 \"C++/string/manacher.hpp\"\n\n#include <cassert>\n#include\
    \ <vector>\n#include <algorithm>\nstd::vector<int> manacher(std::string s, const\
    \ bool calc_even = true) {\n    int n = s.size();\n    if(calc_even) {\n     \
    \   assert(n > 0);\n        s.resize(2 * n - 1);\n        for(int i = n; --i >=\
    \ 0;) {\n            s[2 * i] = s[i];\n        }\n        const auto d = *std::min_element(s.begin(),\
    \ s.end());\n        for(int i = 0; i < n - 1; ++i) {\n            s[2 * i + 1]\
    \ = d;\n        }\n    }\n    n = s.size();\n    std::vector<int> rad(n);\n  \
    \  for(int i = 0, j = 0; i < n;) {\n        while(i - j >= 0 && i + j < n && s[i\
    \ - j] == s[i + j]) {\n            ++j;\n        }\n        rad[i] = j;\n    \
    \    int k = 1;\n        while(i - k >= 0 && i + k < n && k + rad[i - k] < j)\
    \ {\n            rad[i + k] = rad[i - k];\n            ++k;\n        }\n     \
    \   i += k, j -= k;\n    }\n    if(calc_even) {\n        for(int i = 0; i < n;\
    \ ++i) {\n            if(((i ^ rad[i]) & 1) == 0) {\n                rad[i]--;\n\
    \            }\n        }\n    }\n    else {\n        for(auto &x: rad) x = 2\
    \ * x - 1;\n    }\n    return rad;\n}\n\n/**\n * @brief Manacher\n * @see https://ei1333.github.io/library/string/manacher.hpp\n\
    \ */\n"
  code: "#pragma once\n\n#include <cassert>\n#include <vector>\n#include <algorithm>\n\
    std::vector<int> manacher(std::string s, const bool calc_even = true) {\n    int\
    \ n = s.size();\n    if(calc_even) {\n        assert(n > 0);\n        s.resize(2\
    \ * n - 1);\n        for(int i = n; --i >= 0;) {\n            s[2 * i] = s[i];\n\
    \        }\n        const auto d = *std::min_element(s.begin(), s.end());\n  \
    \      for(int i = 0; i < n - 1; ++i) {\n            s[2 * i + 1] = d;\n     \
    \   }\n    }\n    n = s.size();\n    std::vector<int> rad(n);\n    for(int i =\
    \ 0, j = 0; i < n;) {\n        while(i - j >= 0 && i + j < n && s[i - j] == s[i\
    \ + j]) {\n            ++j;\n        }\n        rad[i] = j;\n        int k = 1;\n\
    \        while(i - k >= 0 && i + k < n && k + rad[i - k] < j) {\n            rad[i\
    \ + k] = rad[i - k];\n            ++k;\n        }\n        i += k, j -= k;\n \
    \   }\n    if(calc_even) {\n        for(int i = 0; i < n; ++i) {\n           \
    \ if(((i ^ rad[i]) & 1) == 0) {\n                rad[i]--;\n            }\n  \
    \      }\n    }\n    else {\n        for(auto &x: rad) x = 2 * x - 1;\n    }\n\
    \    return rad;\n}\n\n/**\n * @brief Manacher\n * @see https://ei1333.github.io/library/string/manacher.hpp\n\
    \ */"
  dependsOn: []
  isVerificationFile: false
  path: C++/string/manacher.hpp
  requiredBy: []
  timestamp: '2024-02-19 12:20:55+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/string/manacher.hpp
layout: document
redirect_from:
- /library/C++/string/manacher.hpp
- /library/C++/string/manacher.hpp.html
title: Manacher
---
