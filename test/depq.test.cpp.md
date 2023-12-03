---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/depq.hpp
    title: C++/depq.hpp
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://judge.yosupo.jp/problem/double_ended_priority_queue
    links:
    - https://judge.yosupo.jp/problem/double_ended_priority_queue
  bundledCode: "#line 1 \"test/depq.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/double_ended_priority_queue\"\
    \n#include <iostream>\n#include <C++/depq.hpp>\nint main() {\n    int n, q;\n\
    \    std::cin >> n >> q;\n    std::vector<int> s(n);\n    for(auto &el: s) {\n\
    \        std::cin >> el;\n    }\n    depq<int> depq(s);\n    while(q--) {\n  \
    \      int t;\n        std::cin >> t;\n        if(t == 0) {\n            int x;\n\
    \            std::cin >> x;\n            depq.push(x);\n        }\n        else\
    \ if(t == 1) {\n            std::cout << depq.pop_min() << '\\n';\n        }\n\
    \        else {\n            std::cout << depq.pop_max() << '\\n';\n        }\n\
    \    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/double_ended_priority_queue\"\
    \n#include <iostream>\n#include <C++/depq.hpp>\nint main() {\n    int n, q;\n\
    \    std::cin >> n >> q;\n    std::vector<int> s(n);\n    for(auto &el: s) {\n\
    \        std::cin >> el;\n    }\n    depq<int> depq(s);\n    while(q--) {\n  \
    \      int t;\n        std::cin >> t;\n        if(t == 0) {\n            int x;\n\
    \            std::cin >> x;\n            depq.push(x);\n        }\n        else\
    \ if(t == 1) {\n            std::cout << depq.pop_min() << '\\n';\n        }\n\
    \        else {\n            std::cout << depq.pop_max() << '\\n';\n        }\n\
    \    }\n}"
  dependsOn:
  - C++/depq.hpp
  isVerificationFile: true
  path: test/depq.test.cpp
  requiredBy: []
  timestamp: '2023-12-04 01:25:52+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/depq.test.cpp
layout: document
redirect_from:
- /verify/test/depq.test.cpp
- /verify/test/depq.test.cpp.html
title: test/depq.test.cpp
---
