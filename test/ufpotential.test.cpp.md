---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/ds/uf/UFPotential.hpp
    title: "\u30DD\u30C6\u30F3\u30B7\u30E3\u30EB\u4ED8\u304DUnionFind"
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/1/DSL_1_B
    links:
    - https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/1/DSL_1_B
  bundledCode: "#line 1 \"test/ufpotential.test.cpp\"\n#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/1/DSL_1_B\"\
    \n#include <iostream>\n#line 2 \"C++/ds/uf/UFPotential.hpp\"\n\n#include <vector>\n\
    namespace man {\nstruct UFPotential {\nprivate:\n    std::vector<int> par;\n \
    \   std::vector<int64_t> diff;\npublic:\n    UFPotential(const int n): par(n,\
    \ -1), diff(n){}\n    inline int root(const int i) noexcept {\n        if(par[i]\
    \ < 0) {\n            return i;\n        }\n        const int r = root(par[i]);\n\
    \        diff[i] += diff[par[i]];\n        return par[i] = r;\n    }\n    inline\
    \ int dist(const int i) noexcept {\n        root(i);\n        return diff[i];\n\
    \    }\n    inline int64_t dist(const int x, const int y) noexcept { return dist(y)\
    \ - dist(x); }\n    inline int unite(int x, int y, long long w) noexcept {\n \
    \       w += dist(y, x);\n        x = root(x), y = root(y);\n        if(x == y)\
    \ {\n            return w == 0 ? 0 : -1;\n        }\n        if(par[x] > par[y])\
    \ {\n            std::swap(x, y);\n            w = -w;\n        }\n        par[x]\
    \ += par[y];\n        par[y] = x;\n        diff[y] = w;\n        return 1;\n \
    \   }\n    inline int operator[](const int i) noexcept { return root(i); }\n};\n\
    }\n/**\n * @brief \u30DD\u30C6\u30F3\u30B7\u30E3\u30EB\u4ED8\u304DUnionFind\n\
    \ * @see https://github.com/tatyam-prime/kyopro_library/blob/master/UnionFind.cpp\n\
    \ */\n#line 4 \"test/ufpotential.test.cpp\"\nint main() {\n    int n, q;\n   \
    \ std::cin >> n >> q;\n    man::UFPotential uf(n);\n    while(q--) {\n       \
    \ int t, x, y;\n        std::cin >> t >> x >> y;\n        if(t) {\n          \
    \  if(uf[x] == uf[y]) {\n                std::cout << uf.dist(x, y) << '\\n';\n\
    \            }\n            else {\n                std::cout << \"?\\n\";\n \
    \           }\n        }\n        else {\n            int z;\n            std::cin\
    \ >> z;\n            uf.unite(x, y, z);\n        }\n    }\n}\n"
  code: "#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/1/DSL_1_B\"\
    \n#include <iostream>\n#include \"C++/ds/uf/UFPotential.hpp\"\nint main() {\n\
    \    int n, q;\n    std::cin >> n >> q;\n    man::UFPotential uf(n);\n    while(q--)\
    \ {\n        int t, x, y;\n        std::cin >> t >> x >> y;\n        if(t) {\n\
    \            if(uf[x] == uf[y]) {\n                std::cout << uf.dist(x, y)\
    \ << '\\n';\n            }\n            else {\n                std::cout << \"\
    ?\\n\";\n            }\n        }\n        else {\n            int z;\n      \
    \      std::cin >> z;\n            uf.unite(x, y, z);\n        }\n    }\n}"
  dependsOn:
  - C++/ds/uf/UFPotential.hpp
  isVerificationFile: true
  path: test/ufpotential.test.cpp
  requiredBy: []
  timestamp: '2025-06-06 22:43:22+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/ufpotential.test.cpp
layout: document
redirect_from:
- /verify/test/ufpotential.test.cpp
- /verify/test/ufpotential.test.cpp.html
title: test/ufpotential.test.cpp
---
