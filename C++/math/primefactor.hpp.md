---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
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
  requiredBy: []
  timestamp: '2025-06-06 22:43:06+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/math/primefactor.hpp
layout: document
redirect_from:
- /library/C++/math/primefactor.hpp
- /library/C++/math/primefactor.hpp.html
title: "\u7D20\u56E0\u6570\u5206\u89E3"
---
