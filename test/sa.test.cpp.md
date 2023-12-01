---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/Strings.hpp
    title: C++/Strings.hpp
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://judge.yosupo.jp/problem/suffixarray
    links:
    - https://judge.yosupo.jp/problem/suffixarray
  bundledCode: "#line 1 \"test/sa.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/suffixarray\"\
    \n#include <C++/Strings.hpp>\nint main() {\n    std::string s;\n    std::cin >>\
    \ s;\n    SuffixArray sa(s);\n    sa.erase(sa.begin());\n    for(size_t i = 0;\
    \ i < sa.size(); ++i) {\n        std::cout << sa[i] << \" \\n\"[i + 1 == sa.size()];\n\
    \    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/suffixarray\"\n#include\
    \ <C++/Strings.hpp>\nint main() {\n    std::string s;\n    std::cin >> s;\n  \
    \  SuffixArray sa(s);\n    sa.erase(sa.begin());\n    for(size_t i = 0; i < sa.size();\
    \ ++i) {\n        std::cout << sa[i] << \" \\n\"[i + 1 == sa.size()];\n    }\n\
    }"
  dependsOn:
  - C++/Strings.hpp
  isVerificationFile: true
  path: test/sa.test.cpp
  requiredBy: []
  timestamp: '2023-12-02 08:23:51+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/sa.test.cpp
layout: document
redirect_from:
- /verify/test/sa.test.cpp
- /verify/test/sa.test.cpp.html
title: test/sa.test.cpp
---
