---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':x:'
    path: test/C++/zalgo.test.cpp
    title: test/C++/zalgo.test.cpp
  _isVerificationFailed: true
  _pathExtension: hpp
  _verificationStatusIcon: ':x:'
  attributes:
    document_title: Z-Algorithm
    links: []
  bundledCode: "#line 2 \"C++/string/z-algo.hpp\"\n\n#include <vector>\nstd::vector<int>\
    \ zalg(const std::string &s) {\n    const int n = s.size();\n    int j = 0;\n\
    \    std::vector<int> pre(n);\n    for(int i = 1; i < n; ++i) {\n        if(i\
    \ + pre[i - j] < j + pre[j]) pre[i] = pre[i - j];\n        else {\n          \
    \  int k = std::max(0, j + pre[j] - i);\n            while(i + k < n && s[k] ==\
    \ s[i + k]) ++k;\n            pre[i] = k;\n            j = i;\n        }\n   \
    \ }\n    pre.front() = n;\n    return pre;\n}\n\n/**\n * @brief Z-Algorithm\n\
    \ */\n"
  code: "#pragma once\n\n#include <vector>\nstd::vector<int> zalg(const std::string\
    \ &s) {\n    const int n = s.size();\n    int j = 0;\n    std::vector<int> pre(n);\n\
    \    for(int i = 1; i < n; ++i) {\n        if(i + pre[i - j] < j + pre[j]) pre[i]\
    \ = pre[i - j];\n        else {\n            int k = std::max(0, j + pre[j] -\
    \ i);\n            while(i + k < n && s[k] == s[i + k]) ++k;\n            pre[i]\
    \ = k;\n            j = i;\n        }\n    }\n    pre.front() = n;\n    return\
    \ pre;\n}\n\n/**\n * @brief Z-Algorithm\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/string/z-algo.hpp
  requiredBy: []
  timestamp: '2024-02-19 12:47:06+09:00'
  verificationStatus: LIBRARY_ALL_WA
  verifiedWith:
  - test/C++/zalgo.test.cpp
documentation_of: C++/string/z-algo.hpp
layout: document
redirect_from:
- /library/C++/string/z-algo.hpp
- /library/C++/string/z-algo.hpp.html
title: Z-Algorithm
---
