---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    document_title: "\u30DD\u30C6\u30F3\u30B7\u30E3\u30EB\u4ED8\u304DUnionFind"
    links:
    - https://github.com/tatyam-prime/kyopro_library/blob/master/UnionFind.cpp
  bundledCode: "#line 2 \"C++/structure/uf/UFPotential.hpp\"\n\n#include <vector>\n\
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
    \ https://github.com/tatyam-prime/kyopro_library/blob/master/UnionFind.cpp\n */\n"
  code: "#pragma once\n\n#include <vector>\nstruct UFPotential {\nprivate:\n    std::vector<int>\
    \ par;\n    std::vector<long long> diff;\npublic:\n    UFPotential(const int n):\
    \ par(n, -1), diff(n){}\n    int root(const int i) {\n        if(par[i] < 0) {\n\
    \            return i;\n        }\n        const int r = root(par[i]);\n     \
    \   diff[i] += diff[par[i]];\n        return par[i] = r;\n    }\n    long long\
    \ dist(const int i) {\n        root(i);\n        return diff[i];\n    }\n    long\
    \ long dist(const int x, const int y){ return dist(y) - dist(x); }\n    int unite(int\
    \ x, int y, long long w) {\n        w += dist(y, x);\n        x = root(x), y =\
    \ root(y);\n        if(x == y) {\n            return w == 0 ? 0 : -1;\n      \
    \  }\n        if(par[x] > par[y]) {\n            std::swap(x, y);\n          \
    \  w = -w;\n        }\n        par[x] += par[y];\n        par[y] = x;\n      \
    \  diff[y] = w;\n        return 1;\n    }\n    int operator[](const int i) noexcept\
    \ { return root(i); }\n};\n/**\n * @brief \u30DD\u30C6\u30F3\u30B7\u30E3\u30EB\
    \u4ED8\u304DUnionFind\n * @see https://github.com/tatyam-prime/kyopro_library/blob/master/UnionFind.cpp\n\
    \ */"
  dependsOn: []
  isVerificationFile: false
  path: C++/structure/uf/UFPotential.hpp
  requiredBy: []
  timestamp: '2024-02-19 12:20:55+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/structure/uf/UFPotential.hpp
layout: document
redirect_from:
- /library/C++/structure/uf/UFPotential.hpp
- /library/C++/structure/uf/UFPotential.hpp.html
title: "\u30DD\u30C6\u30F3\u30B7\u30E3\u30EB\u4ED8\u304DUnionFind"
---
