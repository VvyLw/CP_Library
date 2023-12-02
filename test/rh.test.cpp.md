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
    PROBLEM: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/14/ALDS1_14_B
    links:
    - https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/14/ALDS1_14_B
  bundledCode: "#line 1 \"test/rh.test.cpp\"\n#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/14/ALDS1_14_B\"\
    \n#include <iostream>\n#include <C++/Strings.hpp>\nint main() {\n    std::string\
    \ t, p;\n    std::cin >> t >> p;\n    RH rh1(t), rh2(p);\n    for(size_t i = 0;\
    \ i + p.size() <= t.size(); ++i) {\n        if(rh1.get(i, i + p.size()) == rh2.get(0,\
    \ p.size())) {\n            std::cout << i << '\\n';\n        }\n    }\n}\n"
  code: "#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/14/ALDS1_14_B\"\
    \n#include <iostream>\n#include <C++/Strings.hpp>\nint main() {\n    std::string\
    \ t, p;\n    std::cin >> t >> p;\n    RH rh1(t), rh2(p);\n    for(size_t i = 0;\
    \ i + p.size() <= t.size(); ++i) {\n        if(rh1.get(i, i + p.size()) == rh2.get(0,\
    \ p.size())) {\n            std::cout << i << '\\n';\n        }\n    }\n}"
  dependsOn:
  - C++/Strings.hpp
  isVerificationFile: true
  path: test/rh.test.cpp
  requiredBy: []
  timestamp: '2023-12-02 09:13:29+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/rh.test.cpp
layout: document
redirect_from:
- /verify/test/rh.test.cpp
- /verify/test/rh.test.cpp.html
title: test/rh.test.cpp
---
