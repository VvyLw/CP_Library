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
    PROBLEM: https://judge.yosupo.jp/problem/zalgorithm
    links:
    - https://judge.yosupo.jp/problem/zalgorithm
  bundledCode: "#line 1 \"test/zalgo.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/zalgorithm\"\
    \n#include <iostream>\n#include <C++/Strings.hpp>\nint main() {\n    std::string\
    \ s;\n    std::cin >> s;\n    const auto res = zalg(s);\n    for(size_t i = 0;\
    \ i < s.size(); ++i) {\n        std::cout << res[i] << \" \\n\"[i + 1 == s.size()];\n\
    \    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/zalgorithm\"\n#include\
    \ <iostream>\n#include <C++/Strings.hpp>\nint main() {\n    std::string s;\n \
    \   std::cin >> s;\n    const auto res = zalg(s);\n    for(size_t i = 0; i < s.size();\
    \ ++i) {\n        std::cout << res[i] << \" \\n\"[i + 1 == s.size()];\n    }\n\
    }"
  dependsOn:
  - C++/Strings.hpp
  isVerificationFile: true
  path: test/zalgo.test.cpp
  requiredBy: []
  timestamp: '2023-11-30 23:03:49+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/zalgo.test.cpp
layout: document
redirect_from:
- /verify/test/zalgo.test.cpp
- /verify/test/zalgo.test.cpp.html
title: test/zalgo.test.cpp
---
