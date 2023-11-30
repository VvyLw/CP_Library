---
data:
  _extendedDependsOn:
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
    PROBLEM: https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/1/DSL_1_B
    links:
    - https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/1/DSL_1_B
  bundledCode: "#line 1 \"test/ufpotential.test.cpp\"\n#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/1/DSL_1_B\"\
    \n#include <iostream>\n#include <C++/UnionFind.hpp>\nint main() {\n    int n,\
    \ q;\n    std::cin >> n >> q;\n    UFPotential uf(n);\n    while(q--) {\n    \
    \    int t, x, y;\n        std::cin >> t >> x >> y;\n        if(t) {\n       \
    \     if(uf[x] == uf[y]) {\n                std::cout << uf.dist(x, y) << '\\\
    n';\n            }\n            else {\n                std::cout << \"?\\n\"\
    ;\n            }\n        }\n        else {\n            int z;\n            std::cin\
    \ >> z;\n            uf.unite(x, y, z);\n        }\n    }\n}\n"
  code: "#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/1/DSL_1_B\"\
    \n#include <iostream>\n#include <C++/UnionFind.hpp>\nint main() {\n    int n,\
    \ q;\n    std::cin >> n >> q;\n    UFPotential uf(n);\n    while(q--) {\n    \
    \    int t, x, y;\n        std::cin >> t >> x >> y;\n        if(t) {\n       \
    \     if(uf[x] == uf[y]) {\n                std::cout << uf.dist(x, y) << '\\\
    n';\n            }\n            else {\n                std::cout << \"?\\n\"\
    ;\n            }\n        }\n        else {\n            int z;\n            std::cin\
    \ >> z;\n            uf.unite(x, y, z);\n        }\n    }\n}"
  dependsOn:
  - C++/UnionFind.hpp
  isVerificationFile: true
  path: test/ufpotential.test.cpp
  requiredBy: []
  timestamp: '2023-12-01 06:41:59+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: test/ufpotential.test.cpp
layout: document
redirect_from:
- /verify/test/ufpotential.test.cpp
- /verify/test/ufpotential.test.cpp.html
title: test/ufpotential.test.cpp
---
