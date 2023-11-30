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
    PROBLEM: https://judge.yosupo.jp/problem/enumerate_palindromes
    links:
    - https://judge.yosupo.jp/problem/enumerate_palindromes
  bundledCode: "#line 1 \"test/manacher.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/enumerate_palindromes\"\
    \n#include <iostream>\n#include <C++/Strings.hpp>\nint main() {\n    std::string\
    \ s;\n    std::cin >> s;\n    const auto res = manacher(s);\n    for(size_t i\
    \ = 0; i < res.size(); ++i) {\n        std::cout << res[i] << \" \\n\"[i + 1 ==\
    \ res.size()];\n    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/enumerate_palindromes\"\
    \n#include <iostream>\n#include <C++/Strings.hpp>\nint main() {\n    std::string\
    \ s;\n    std::cin >> s;\n    const auto res = manacher(s);\n    for(size_t i\
    \ = 0; i < res.size(); ++i) {\n        std::cout << res[i] << \" \\n\"[i + 1 ==\
    \ res.size()];\n    }\n}"
  dependsOn:
  - C++/Strings.hpp
  isVerificationFile: true
  path: test/manacher.test.cpp
  requiredBy: []
  timestamp: '2023-12-01 00:51:30+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/manacher.test.cpp
layout: document
redirect_from:
- /verify/test/manacher.test.cpp
- /verify/test/manacher.test.cpp.html
title: test/manacher.test.cpp
---
