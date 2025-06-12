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
  - icon: ':x:'
    path: test/uf.test.cpp
    title: test/uf.test.cpp
  _isVerificationFailed: true
  _pathExtension: hpp
  _verificationStatusIcon: ':question:'
  attributes:
    document_title: UnionFind
    links:
    - https://github.com/maspypy/library/blob/main/ds/unionfind/unionfind.hpp
  bundledCode: "#line 2 \"C++/ds/uf/UnionFind.hpp\"\n\r\n#include <cassert>\r\n#include\
    \ <vector>\r\n#include <algorithm>\r\nnamespace man {\r\nstruct UnionFind {\r\n\
    protected:\r\n    std::vector<int> par;\r\npublic:\r\n    UnionFind(const int\
    \ n): par(n, -1){}\r\n    inline int operator[](int i) noexcept {\r\n        while(par[i]\
    \ >= 0) {\r\n            const int p = par[par[i]];\r\n            if(p < 0) return\
    \ par[i];\r\n            i = par[i] = p;\r\n        }\r\n        return i;\r\n\
    \    }\r\n    inline bool unite(int x, int y) noexcept {\r\n        x = (*this)[x],\
    \ y = (*this)[y];\r\n        if(x == y) return false;\r\n        if(-par[x] <\
    \ -par[y]) {\r\n            std::swap(x, y);\r\n        }\r\n        par[x] +=\
    \ par[y], par[y] = x;\r\n        return true;\r\n    }\r\n    inline int size(const\
    \ int x) noexcept {\r\n        return -par[(*this)[x]];\r\n    }\r\n    inline\
    \ int size() const noexcept { return par.size(); }\r\n    inline std::vector<std::vector<int>>\
    \ groups() noexcept {\r\n        const int n = std::ssize(par);\r\n        std::vector<std::vector<int>>\
    \ res(n);\r\n        for(int i = 0; i < n; ++i) {\r\n            res[(*this)[i]].emplace_back(i);\r\
    \n        }\r\n        const auto it = std::ranges::remove_if(res, [&](const std::vector<int>\
    \ &v){ return v.empty(); });\r\n        res.erase(it.begin(), it.end());\r\n \
    \       return res;\r\n    }\r\n};\r\n\r\ninline bool is_bipartite(UnionFind uf)\
    \ noexcept {\r\n    assert(uf.size() % 2 == 0);\r\n    const int n = uf.size()\
    \ / 2;\r\n    bool ok = true;\r\n    for(int i = 0; i < n; ++i) {\r\n        ok\
    \ &= uf[i] != uf[i + n];\r\n    }\r\n    return ok;\r\n}\r\n}\r\n/**\r\n * @brief\
    \ UnionFind\r\n * @see https://github.com/maspypy/library/blob/main/ds/unionfind/unionfind.hpp\r\
    \n */\n"
  code: "#pragma once\r\n\r\n#include <cassert>\r\n#include <vector>\r\n#include <algorithm>\r\
    \nnamespace man {\r\nstruct UnionFind {\r\nprotected:\r\n    std::vector<int>\
    \ par;\r\npublic:\r\n    UnionFind(const int n): par(n, -1){}\r\n    inline int\
    \ operator[](int i) noexcept {\r\n        while(par[i] >= 0) {\r\n           \
    \ const int p = par[par[i]];\r\n            if(p < 0) return par[i];\r\n     \
    \       i = par[i] = p;\r\n        }\r\n        return i;\r\n    }\r\n    inline\
    \ bool unite(int x, int y) noexcept {\r\n        x = (*this)[x], y = (*this)[y];\r\
    \n        if(x == y) return false;\r\n        if(-par[x] < -par[y]) {\r\n    \
    \        std::swap(x, y);\r\n        }\r\n        par[x] += par[y], par[y] = x;\r\
    \n        return true;\r\n    }\r\n    inline int size(const int x) noexcept {\r\
    \n        return -par[(*this)[x]];\r\n    }\r\n    inline int size() const noexcept\
    \ { return par.size(); }\r\n    inline std::vector<std::vector<int>> groups()\
    \ noexcept {\r\n        const int n = std::ssize(par);\r\n        std::vector<std::vector<int>>\
    \ res(n);\r\n        for(int i = 0; i < n; ++i) {\r\n            res[(*this)[i]].emplace_back(i);\r\
    \n        }\r\n        const auto it = std::ranges::remove_if(res, [&](const std::vector<int>\
    \ &v){ return v.empty(); });\r\n        res.erase(it.begin(), it.end());\r\n \
    \       return res;\r\n    }\r\n};\r\n\r\ninline bool is_bipartite(UnionFind uf)\
    \ noexcept {\r\n    assert(uf.size() % 2 == 0);\r\n    const int n = uf.size()\
    \ / 2;\r\n    bool ok = true;\r\n    for(int i = 0; i < n; ++i) {\r\n        ok\
    \ &= uf[i] != uf[i + n];\r\n    }\r\n    return ok;\r\n}\r\n}\r\n/**\r\n * @brief\
    \ UnionFind\r\n * @see https://github.com/maspypy/library/blob/main/ds/unionfind/unionfind.hpp\r\
    \n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/ds/uf/UnionFind.hpp
  requiredBy:
  - C++/graph/mst/kruskal.hpp
  - C++/ds/uf/MergeUF.hpp
  timestamp: '2025-06-06 22:43:06+09:00'
  verificationStatus: LIBRARY_SOME_WA
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
