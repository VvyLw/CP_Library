---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/ufpotential.test.cpp
    title: test/ufpotential.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    links:
    - https://github.com/tatyam-prime/kyopro_library/blob/master/UnionFind.cpp
  bundledCode: "#line 2 \"C++/UFPotential.hpp\"\n\n// inspired by tatyam( https://github.com/tatyam-prime/kyopro_library/blob/master/UnionFind.cpp\
    \ )\n#include <vector>\nstruct UFPotential {\nprivate:\n    std::vector<int> par;\n\
    \    std::vector<long long> diff;\npublic:\n    UFPotential(const int n): par(n,\
    \ -1), diff(n){}\n    int root(const int i) {\n        if(par[i] < 0) {\n    \
    \        return i;\n        }\n        const int r = root(par[i]);\n        diff[i]\
    \ += diff[par[i]];\n        return par[i] = r;\n    }\n    long long dist(const\
    \ int i) {\n        root(i);\n        return diff[i];\n    }\n    long long dist(const\
    \ int x, const int y){ return dist(y) - dist(x); }\n    int unite(int x, int y,\
    \ long long w) {\n        w += dist(y, x);\n        x = root(x), y = root(y);\n\
    \        if(x == y) {\n            return w == 0 ? 0 : -1;\n        }\n      \
    \  if(par[x] > par[y]) {\n            std::swap(x, y);\n            w = -w;\n\
    \        }\n        par[x] += par[y];\n        par[y] = x;\n        diff[y] =\
    \ w;\n        return 1;\n    }\n    int operator[](const int i) noexcept { return\
    \ root(i); }\n};\n"
  code: "#pragma once\n\n// inspired by tatyam( https://github.com/tatyam-prime/kyopro_library/blob/master/UnionFind.cpp\
    \ )\n#include <vector>\nstruct UFPotential {\nprivate:\n    std::vector<int> par;\n\
    \    std::vector<long long> diff;\npublic:\n    UFPotential(const int n): par(n,\
    \ -1), diff(n){}\n    int root(const int i) {\n        if(par[i] < 0) {\n    \
    \        return i;\n        }\n        const int r = root(par[i]);\n        diff[i]\
    \ += diff[par[i]];\n        return par[i] = r;\n    }\n    long long dist(const\
    \ int i) {\n        root(i);\n        return diff[i];\n    }\n    long long dist(const\
    \ int x, const int y){ return dist(y) - dist(x); }\n    int unite(int x, int y,\
    \ long long w) {\n        w += dist(y, x);\n        x = root(x), y = root(y);\n\
    \        if(x == y) {\n            return w == 0 ? 0 : -1;\n        }\n      \
    \  if(par[x] > par[y]) {\n            std::swap(x, y);\n            w = -w;\n\
    \        }\n        par[x] += par[y];\n        par[y] = x;\n        diff[y] =\
    \ w;\n        return 1;\n    }\n    int operator[](const int i) noexcept { return\
    \ root(i); }\n};"
  dependsOn: []
  isVerificationFile: false
  path: C++/UFPotential.hpp
  requiredBy: []
  timestamp: '2023-12-12 02:56:10+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/ufpotential.test.cpp
documentation_of: C++/UFPotential.hpp
layout: document
redirect_from:
- /library/C++/UFPotential.hpp
- /library/C++/UFPotential.hpp.html
title: C++/UFPotential.hpp
---
