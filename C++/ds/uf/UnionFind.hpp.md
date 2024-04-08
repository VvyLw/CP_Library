---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
  - icon: ':warning:'
    path: C++/ds/uf/MergeUF.hpp
    title: MergeUnionFind
  - icon: ':heavy_check_mark:'
    path: C++/graph/mst/kruskal.hpp
    title: "Kruskal\u6CD5"
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/manhattan.test.cpp
    title: test/manhattan.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/uf.test.cpp
    title: test/uf.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: UnionFind
    links:
    - https://github.com/maspypy/library/blob/main/ds/unionfind/unionfind.hpp
  bundledCode: "#line 2 \"C++/ds/uf/UnionFind.hpp\"\n\r\n#include <cassert>\r\n#include\
    \ <vector>\r\n#include <algorithm>\r\nstruct UnionFind {\r\nprotected:\r\n   \
    \ std::vector<int> par;\r\npublic:\r\n    UnionFind(const int n): par(n, -1){}\r\
    \n    int operator[](int i) {\r\n        while(par[i] >= 0) {\r\n            const\
    \ int p = par[par[i]];\r\n            if(p < 0) return par[i];\r\n           \
    \ i = par[i] = p;\r\n        }\r\n        return i;\r\n    }\r\n    bool unite(int\
    \ x, int y) {\r\n        x = (*this)[x], y = (*this)[y];\r\n        if(x == y)\
    \ return false;\r\n        if(-par[x] < -par[y]) {\r\n            std::swap(x,\
    \ y);\r\n        }\r\n        par[x] += par[y], par[y] = x;\r\n        return\
    \ true;\r\n    }\r\n    int size(const int x) {\r\n        return -par[(*this)[x]];\r\
    \n    }\r\n    int size() const { return par.size(); }\r\n#if __cplusplus >= 202101L\r\
    \n    std::vector<std::vector<int>> groups() {\r\n        const int n = std::ssize(par);\r\
    \n        std::vector<std::vector<int>> res(n);\r\n        for(int i = 0; i <\
    \ n; ++i) {\r\n            res[(*this)[i]].emplace_back(i);\r\n        }\r\n \
    \       const auto it = std::ranges::remove_if(res, [&](const std::vector<int>\
    \ &v){ return v.empty(); });\r\n        res.erase(it.begin(), it.end());\r\n \
    \       return res;\r\n    }\r\n#else\r\n    std::vector<std::vector<int>> groups()\
    \ {\r\n        const int n = par.size();\r\n        std::vector<std::vector<int>>\
    \ res(n);\r\n        for(int i = 0; i < n; ++i) {\r\n            res[(*this)[i]].emplace_back(i);\r\
    \n        }\r\n        res.erase(std::remove_if(res.begin(), res.end(), [&](const\
    \ std::vector<int> &v){ return v.empty(); }), res.end());\r\n        return res;\r\
    \n    }\r\n#endif\r\n};\r\n\r\ninline bool is_bipartite(UnionFind uf) {\r\n  \
    \  assert(uf.size() % 2 == 0);\r\n    const int n = uf.size() / 2;\r\n    bool\
    \ ok = true;\r\n    for(int i = 0; i < n; ++i) {\r\n        ok &= uf[i] != uf[i\
    \ + n];\r\n    }\r\n    return ok;\r\n}\r\n/**\r\n * @brief UnionFind\r\n * @see\
    \ https://github.com/maspypy/library/blob/main/ds/unionfind/unionfind.hpp\r\n\
    \ */\n"
  code: "#pragma once\r\n\r\n#include <cassert>\r\n#include <vector>\r\n#include <algorithm>\r\
    \nstruct UnionFind {\r\nprotected:\r\n    std::vector<int> par;\r\npublic:\r\n\
    \    UnionFind(const int n): par(n, -1){}\r\n    int operator[](int i) {\r\n \
    \       while(par[i] >= 0) {\r\n            const int p = par[par[i]];\r\n   \
    \         if(p < 0) return par[i];\r\n            i = par[i] = p;\r\n        }\r\
    \n        return i;\r\n    }\r\n    bool unite(int x, int y) {\r\n        x =\
    \ (*this)[x], y = (*this)[y];\r\n        if(x == y) return false;\r\n        if(-par[x]\
    \ < -par[y]) {\r\n            std::swap(x, y);\r\n        }\r\n        par[x]\
    \ += par[y], par[y] = x;\r\n        return true;\r\n    }\r\n    int size(const\
    \ int x) {\r\n        return -par[(*this)[x]];\r\n    }\r\n    int size() const\
    \ { return par.size(); }\r\n#if __cplusplus >= 202101L\r\n    std::vector<std::vector<int>>\
    \ groups() {\r\n        const int n = std::ssize(par);\r\n        std::vector<std::vector<int>>\
    \ res(n);\r\n        for(int i = 0; i < n; ++i) {\r\n            res[(*this)[i]].emplace_back(i);\r\
    \n        }\r\n        const auto it = std::ranges::remove_if(res, [&](const std::vector<int>\
    \ &v){ return v.empty(); });\r\n        res.erase(it.begin(), it.end());\r\n \
    \       return res;\r\n    }\r\n#else\r\n    std::vector<std::vector<int>> groups()\
    \ {\r\n        const int n = par.size();\r\n        std::vector<std::vector<int>>\
    \ res(n);\r\n        for(int i = 0; i < n; ++i) {\r\n            res[(*this)[i]].emplace_back(i);\r\
    \n        }\r\n        res.erase(std::remove_if(res.begin(), res.end(), [&](const\
    \ std::vector<int> &v){ return v.empty(); }), res.end());\r\n        return res;\r\
    \n    }\r\n#endif\r\n};\r\n\r\ninline bool is_bipartite(UnionFind uf) {\r\n  \
    \  assert(uf.size() % 2 == 0);\r\n    const int n = uf.size() / 2;\r\n    bool\
    \ ok = true;\r\n    for(int i = 0; i < n; ++i) {\r\n        ok &= uf[i] != uf[i\
    \ + n];\r\n    }\r\n    return ok;\r\n}\r\n/**\r\n * @brief UnionFind\r\n * @see\
    \ https://github.com/maspypy/library/blob/main/ds/unionfind/unionfind.hpp\r\n\
    \ */"
  dependsOn: []
  isVerificationFile: false
  path: C++/ds/uf/UnionFind.hpp
  requiredBy:
  - C++/ds/uf/MergeUF.hpp
  - C++/graph/mst/kruskal.hpp
  timestamp: '2024-02-27 10:38:23+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/uf.test.cpp
  - test/manhattan.test.cpp
documentation_of: C++/ds/uf/UnionFind.hpp
layout: document
redirect_from:
- /library/C++/ds/uf/UnionFind.hpp
- /library/C++/ds/uf/UnionFind.hpp.html
title: UnionFind
---