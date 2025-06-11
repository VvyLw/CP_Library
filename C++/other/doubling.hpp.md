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
    \ <cmath>\n#include <ranges>\nnamespace man {\ntemplate <class T> requires std::ranges::random_access_range<T>\
    \ constexpr inline std::vector<std::vector<int>> doubling(const T &a, const int64_t\
    \ k) noexcept {\n    const int z = std::ceil(std::log2(k)), n = std::ssize(a);\n\
    \    std::vector dbl(z, std::vector(n, 0));\n    for(const auto &i: std::views::iota(0,\
    \ n)) {\n        dbl.front()[i] = a[i];\n    }\n    for(const auto &i: std::views::iota(1,\
    \ z)) {\n        for(const auto &j: std::views::iota(0, n)) {\n            dbl[i][j]\
    \ = dbl[i - 1][dbl[i - 1][j]];\n        }\n    }\n    return dbl;\n}\n}\n\n/**\n\
    \ * @brief doubling\n * @see https://algo-logic.info/doubling/\n */\n"
  code: "#pragma once\n\n#include <vector>\n#include <cmath>\n#include <ranges>\n\
    namespace man {\ntemplate <class T> requires std::ranges::random_access_range<T>\
    \ constexpr inline std::vector<std::vector<int>> doubling(const T &a, const int64_t\
    \ k) noexcept {\n    const int z = std::ceil(std::log2(k)), n = std::ssize(a);\n\
    \    std::vector dbl(z, std::vector(n, 0));\n    for(const auto &i: std::views::iota(0,\
    \ n)) {\n        dbl.front()[i] = a[i];\n    }\n    for(const auto &i: std::views::iota(1,\
    \ z)) {\n        for(const auto &j: std::views::iota(0, n)) {\n            dbl[i][j]\
    \ = dbl[i - 1][dbl[i - 1][j]];\n        }\n    }\n    return dbl;\n}\n}\n\n/**\n\
    \ * @brief doubling\n * @see https://algo-logic.info/doubling/\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/other/doubling.hpp
  requiredBy: []
  timestamp: '2025-06-11 17:30:11+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/other/doubling.hpp
layout: document
redirect_from:
- /library/C++/other/doubling.hpp
- /library/C++/other/doubling.hpp.html
title: doubling
---
