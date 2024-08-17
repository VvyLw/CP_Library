---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    document_title: doubling
    links:
    - https://algo-logic.info/doubling/
  bundledCode: "#line 2 \"C++/other/doubling.hpp\"\n\n#include <vector>\n#include\
    \ <cmath>\ntemplate <class T, typename std::enable_if<std::is_same<T, std::vector<typename\
    \ T::value_type>>::value || std::is_same<T, std::valarray<typename T::value_type>>::value,\
    \ std::nullptr_t>::type = nullptr>\nconstexpr inline std::vector<std::vector<int>>\
    \ doubling(const int64_t k, const T &a) noexcept {\n    const int z = std::ceil(std::log2(k)),\
    \ n = a.size();\n    std::vector dbl(z, std::vector(n, 0));\n    for(int i = 0;\
    \ i < n; ++i) {\n        dbl.front()[i] = a[i];\n    }\n    for(int i = 0; ++i\
    \ < z;) {\n        for(int j = 0; j < n; ++j) {\n            dbl[i][j] = dbl[i\
    \ - 1][dbl[i - 1][j]];\n        }\n    }\n    return dbl;\n}\n\n/**\n * @brief\
    \ doubling\n * @see https://algo-logic.info/doubling/\n */\n"
  code: "#pragma once\n\n#include <vector>\n#include <cmath>\ntemplate <class T, typename\
    \ std::enable_if<std::is_same<T, std::vector<typename T::value_type>>::value ||\
    \ std::is_same<T, std::valarray<typename T::value_type>>::value, std::nullptr_t>::type\
    \ = nullptr>\nconstexpr inline std::vector<std::vector<int>> doubling(const int64_t\
    \ k, const T &a) noexcept {\n    const int z = std::ceil(std::log2(k)), n = a.size();\n\
    \    std::vector dbl(z, std::vector(n, 0));\n    for(int i = 0; i < n; ++i) {\n\
    \        dbl.front()[i] = a[i];\n    }\n    for(int i = 0; ++i < z;) {\n     \
    \   for(int j = 0; j < n; ++j) {\n            dbl[i][j] = dbl[i - 1][dbl[i - 1][j]];\n\
    \        }\n    }\n    return dbl;\n}\n\n/**\n * @brief doubling\n * @see https://algo-logic.info/doubling/\n\
    \ */"
  dependsOn: []
  isVerificationFile: false
  path: C++/other/doubling.hpp
  requiredBy: []
  timestamp: '2024-08-18 01:12:31+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/other/doubling.hpp
layout: document
redirect_from:
- /library/C++/other/doubling.hpp
- /library/C++/other/doubling.hpp.html
title: doubling
---
