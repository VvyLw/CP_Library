---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':x:'
    path: test/zalgo.test.cpp
    title: test/zalgo.test.cpp
  _isVerificationFailed: true
  _pathExtension: hpp
  _verificationStatusIcon: ':x:'
  attributes:
    document_title: Z-Algorithm
    links: []
  bundledCode: "#line 2 \"C++/string/z-algo.hpp\"\n\n#include <vector>\n#include <ranges>\n\
    namespace man {\ninline std::vector<int> zalg(const std::string &s) noexcept {\n\
    \    const int n = std::ssize(s);\n    int j = 0;\n    std::vector<int> pre(n);\n\
    \    for(const auto i: std::views::iota(1, n)) {\n        if(i + pre[i - j] <\
    \ j + pre[j]) {\n            pre[i] = pre[i - j];\n        } else {\n        \
    \    int k = std::max(0, j + pre[j] - i);\n            while(i + k < n && s[k]\
    \ == s[i + k]) {\n                ++k;\n            }\n            pre[i] = k;\n\
    \            j = i;\n        }\n    }\n    pre.front() = n;\n    return pre;\n\
    }\n}\n\n/**\n * @brief Z-Algorithm\n */\n"
  code: "#pragma once\n\n#include <vector>\n#include <ranges>\nnamespace man {\ninline\
    \ std::vector<int> zalg(const std::string &s) noexcept {\n    const int n = std::ssize(s);\n\
    \    int j = 0;\n    std::vector<int> pre(n);\n    for(const auto i: std::views::iota(1,\
    \ n)) {\n        if(i + pre[i - j] < j + pre[j]) {\n            pre[i] = pre[i\
    \ - j];\n        } else {\n            int k = std::max(0, j + pre[j] - i);\n\
    \            while(i + k < n && s[k] == s[i + k]) {\n                ++k;\n  \
    \          }\n            pre[i] = k;\n            j = i;\n        }\n    }\n\
    \    pre.front() = n;\n    return pre;\n}\n}\n\n/**\n * @brief Z-Algorithm\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/string/z-algo.hpp
  requiredBy: []
  timestamp: '2025-06-06 22:43:06+09:00'
  verificationStatus: LIBRARY_ALL_WA
  verifiedWith:
  - test/zalgo.test.cpp
documentation_of: C++/string/z-algo.hpp
layout: document
redirect_from:
- /library/C++/string/z-algo.hpp
- /library/C++/string/z-algo.hpp.html
title: Z-Algorithm
---
