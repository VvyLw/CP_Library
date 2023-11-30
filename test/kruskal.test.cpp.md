---
data:
  _extendedDependsOn:
  - icon: ':x:'
    path: C++/MST.hpp
    title: C++/MST.hpp
  - icon: ':x:'
    path: C++/UnionFind.hpp
    title: C++/UnionFind.hpp
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: cpp
  _verificationStatusIcon: ':x:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://onlinejudge.u-aizu.ac.jp/courses/library/5/GRL/all/GRL_2_A
    links:
    - https://onlinejudge.u-aizu.ac.jp/courses/library/5/GRL/all/GRL_2_A
  bundledCode: "#line 1 \"test/kruskal.test.cpp\"\n#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/library/5/GRL/all/GRL_2_A\"\
    \n#include <C++/MST.hpp>\nint main() {\n    std::cin.tie(nullptr) -> sync_with_stdio(false);\n\
    \    int n, m;\n    std::cin >> n >> m;\n    Graph g(n);\n    g.input(m, 0);\n\
    \    std::cout << g.kruskal() << '\\n';\n}\n"
  code: "#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/library/5/GRL/all/GRL_2_A\"\
    \n#include <C++/MST.hpp>\nint main() {\n    std::cin.tie(nullptr) -> sync_with_stdio(false);\n\
    \    int n, m;\n    std::cin >> n >> m;\n    Graph g(n);\n    g.input(m, 0);\n\
    \    std::cout << g.kruskal() << '\\n';\n}"
  dependsOn:
  - C++/MST.hpp
  - C++/UnionFind.hpp
  isVerificationFile: true
  path: test/kruskal.test.cpp
  requiredBy: []
  timestamp: '2023-12-01 06:41:59+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: test/kruskal.test.cpp
layout: document
redirect_from:
- /verify/test/kruskal.test.cpp
- /verify/test/kruskal.test.cpp.html
title: test/kruskal.test.cpp
---
