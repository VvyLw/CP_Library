---
data:
  _extendedDependsOn:
  - icon: ':x:'
    path: C++/ds/uf/UFPotential.hpp
    title: "\u30DD\u30C6\u30F3\u30B7\u30E3\u30EB\u4ED8\u304DUnionFind"
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
  bundledCode: "#line 1 \"test/C++/ufpotential.test.cpp\"\n#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/1/DSL_1_B\"\
    \n#include <iostream>\n#line 2 \"C++/ds/uf/UFPotential.hpp\"\n\n#include <vector>\n\
    struct UFPotential {\nprivate:\n    std::vector<int> par;\n    std::vector<long\
    \ long> diff;\npublic:\n    UFPotential(const int n): par(n, -1), diff(n){}\n\
    \    int root(const int i) {\n        if(par[i] < 0) {\n            return i;\n\
    \        }\n        const int r = root(par[i]);\n        diff[i] += diff[par[i]];\n\
    \        return par[i] = r;\n    }\n    long long dist(const int i) {\n      \
    \  root(i);\n        return diff[i];\n    }\n    long long dist(const int x, const\
    \ int y){ return dist(y) - dist(x); }\n    int unite(int x, int y, long long w)\
    \ {\n        w += dist(y, x);\n        x = root(x), y = root(y);\n        if(x\
    \ == y) {\n            return w == 0 ? 0 : -1;\n        }\n        if(par[x] >\
    \ par[y]) {\n            std::swap(x, y);\n            w = -w;\n        }\n  \
    \      par[x] += par[y];\n        par[y] = x;\n        diff[y] = w;\n        return\
    \ 1;\n    }\n    int operator[](const int i) noexcept { return root(i); }\n};\n\
    /**\n * @brief \u30DD\u30C6\u30F3\u30B7\u30E3\u30EB\u4ED8\u304DUnionFind\n * @see\
    \ https://github.com/tatyam-prime/kyopro_library/blob/master/UnionFind.cpp\n */\n\
    #line 4 \"test/C++/ufpotential.test.cpp\"\nint main() {\n    int n, q;\n    std::cin\
    \ >> n >> q;\n    UFPotential uf(n);\n    while(q--) {\n        int t, x, y;\n\
    \        std::cin >> t >> x >> y;\n        if(t) {\n            if(uf[x] == uf[y])\
    \ {\n                std::cout << uf.dist(x, y) << '\\n';\n            }\n   \
    \         else {\n                std::cout << \"?\\n\";\n            }\n    \
    \    }\n        else {\n            int z;\n            std::cin >> z;\n     \
    \       uf.unite(x, y, z);\n        }\n    }\n}\n"
  code: "#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/1/DSL_1_B\"\
    \n#include <iostream>\n#include \"C++/ds/uf/UFPotential.hpp\"\nint main() {\n\
    \    int n, q;\n    std::cin >> n >> q;\n    UFPotential uf(n);\n    while(q--)\
    \ {\n        int t, x, y;\n        std::cin >> t >> x >> y;\n        if(t) {\n\
    \            if(uf[x] == uf[y]) {\n                std::cout << uf.dist(x, y)\
    \ << '\\n';\n            }\n            else {\n                std::cout << \"\
    ?\\n\";\n            }\n        }\n        else {\n            int z;\n      \
    \      std::cin >> z;\n            uf.unite(x, y, z);\n        }\n    }\n}"
  dependsOn:
  - C++/ds/uf/UFPotential.hpp
  isVerificationFile: true
  path: test/C++/ufpotential.test.cpp
  requiredBy: []
  timestamp: '2024-03-02 19:12:32+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: test/C++/ufpotential.test.cpp
layout: document
redirect_from:
- /verify/test/C++/ufpotential.test.cpp
- /verify/test/C++/ufpotential.test.cpp.html
title: test/C++/ufpotential.test.cpp
---
