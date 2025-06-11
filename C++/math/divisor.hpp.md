---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    document_title: "\u7D04\u6570\u5217\u6319"
    links: []
  bundledCode: "#line 2 \"C++/math/divisor.hpp\"\n\n#include <vector>\n#include <algorithm>\n\
    namespace man {\ntemplate <std::integral T> inline std::vector<T> div(const T\
    \ n) noexcept {\n    std::vector<T> d;\n    for(int64_t i = 1; i * i <= n; ++i)\
    \ {\n        if(n % i == 0) {\n            d.emplace_back(i);\n            if(i\
    \ * i != n) {\n                d.emplace_back(n / i);\n            }\n       \
    \ }\n    }\n    std::ranges::sort(d);\n    return d;\n}\n}\n\n/**\n * @brief \u7D04\
    \u6570\u5217\u6319\n */\n"
  code: "#pragma once\n\n#include <vector>\n#include <algorithm>\nnamespace man {\n\
    template <std::integral T> inline std::vector<T> div(const T n) noexcept {\n \
    \   std::vector<T> d;\n    for(int64_t i = 1; i * i <= n; ++i) {\n        if(n\
    \ % i == 0) {\n            d.emplace_back(i);\n            if(i * i != n) {\n\
    \                d.emplace_back(n / i);\n            }\n        }\n    }\n   \
    \ std::ranges::sort(d);\n    return d;\n}\n}\n\n/**\n * @brief \u7D04\u6570\u5217\
    \u6319\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/divisor.hpp
  requiredBy: []
  timestamp: '2025-06-11 17:30:11+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/math/divisor.hpp
layout: document
redirect_from:
- /library/C++/math/divisor.hpp
- /library/C++/math/divisor.hpp.html
title: "\u7D04\u6570\u5217\u6319"
---
