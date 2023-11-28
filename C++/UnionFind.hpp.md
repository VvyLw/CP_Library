---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
  - icon: ':warning:'
    path: C++/MST.hpp
    title: C++/MST.hpp
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/uf.test.cpp
    title: test/uf.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    links:
    - https://github.com/maspypy/library/blob/main/ds/unionfind/unionfind.hpp)
  bundledCode: "#line 1 \"C++/UnionFind.hpp\"\n// inspired by maspy(https://github.com/maspypy/library/blob/main/ds/unionfind/unionfind.hpp)\r\
    \n#include <cassert>\r\n#include <vector>\r\n#include <algorithm>\r\nstruct UnionFind\
    \ {\r\nprivate:\r\n    std::vector<int> par;\r\npublic:\r\n    UnionFind(const\
    \ int n): par(n, -1){}\r\n    int operator[](int i) {\r\n        while(par[i]\
    \ >= 0) {\r\n            const int p = par[par[i]];\r\n            if(p < 0) return\
    \ par[i];\r\n            i = par[i] = p;\r\n        }\r\n        return i;\r\n\
    \    }\r\n    bool unite(int x, int y) {\r\n        x = (*this)[x], y = (*this)[y];\r\
    \n        if(x == y) return false;\r\n        if(-par[x] < -par[y]) std::swap(x,\
    \ y);\r\n        par[x] += par[y], par[y] = x;\r\n        return true;\r\n   \
    \ }\r\n    int size(const int x) {\r\n        return -par[(*this)[x]];\r\n   \
    \ }\r\n#if __cplusplus >= 202101L\r\n    std::vector<std::vector<int>> groups()\
    \ {\r\n        const int n = std::ssize(par);\r\n        std::vector<std::vector<int>>\
    \ res(n);\r\n        for(int i = 0; i < n; ++i) {\r\n            res[(*this)[i]].emplace_back(i);\r\
    \n        }\r\n        const auto it = std::ranges::remove_if(res, [&](const std::vector<int>\
    \ &v){ return v.empty(); });\r\n        res.erase(it.begin(), it.end());\r\n \
    \       return res;\r\n    }\r\n#else\r\n    std::vector<std::vector<int>> groups()\
    \ {\r\n        const int n = par.size();\r\n        std::vector<std::vector<int>>\
    \ res(n);\r\n        for(int i = 0; i < n; ++i) {\r\n            res[(*this)[i]].emplace_back(i);\r\
    \n        }\r\n        res.erase(std::remove_if(res.begin(), res.end(), [&](const\
    \ std::vector<int> &v){ return v.empty(); }), res.end());\r\n        return res;\r\
    \n    }\r\n#endif\r\n    bool is_bipartite() {\r\n        const int n = par.size()\
    \ / 2;\r\n        bool ok = true;\r\n        for(int i = 0; i < n; ++i) {\r\n\
    \            ok &= (*this)[i] != (*this)[i + n];\r\n        }\r\n        return\
    \ ok;\r\n    }\r\n};\n"
  code: "// inspired by maspy(https://github.com/maspypy/library/blob/main/ds/unionfind/unionfind.hpp)\r\
    \n#include <cassert>\r\n#include <vector>\r\n#include <algorithm>\r\nstruct UnionFind\
    \ {\r\nprivate:\r\n    std::vector<int> par;\r\npublic:\r\n    UnionFind(const\
    \ int n): par(n, -1){}\r\n    int operator[](int i) {\r\n        while(par[i]\
    \ >= 0) {\r\n            const int p = par[par[i]];\r\n            if(p < 0) return\
    \ par[i];\r\n            i = par[i] = p;\r\n        }\r\n        return i;\r\n\
    \    }\r\n    bool unite(int x, int y) {\r\n        x = (*this)[x], y = (*this)[y];\r\
    \n        if(x == y) return false;\r\n        if(-par[x] < -par[y]) std::swap(x,\
    \ y);\r\n        par[x] += par[y], par[y] = x;\r\n        return true;\r\n   \
    \ }\r\n    int size(const int x) {\r\n        return -par[(*this)[x]];\r\n   \
    \ }\r\n#if __cplusplus >= 202101L\r\n    std::vector<std::vector<int>> groups()\
    \ {\r\n        const int n = std::ssize(par);\r\n        std::vector<std::vector<int>>\
    \ res(n);\r\n        for(int i = 0; i < n; ++i) {\r\n            res[(*this)[i]].emplace_back(i);\r\
    \n        }\r\n        const auto it = std::ranges::remove_if(res, [&](const std::vector<int>\
    \ &v){ return v.empty(); });\r\n        res.erase(it.begin(), it.end());\r\n \
    \       return res;\r\n    }\r\n#else\r\n    std::vector<std::vector<int>> groups()\
    \ {\r\n        const int n = par.size();\r\n        std::vector<std::vector<int>>\
    \ res(n);\r\n        for(int i = 0; i < n; ++i) {\r\n            res[(*this)[i]].emplace_back(i);\r\
    \n        }\r\n        res.erase(std::remove_if(res.begin(), res.end(), [&](const\
    \ std::vector<int> &v){ return v.empty(); }), res.end());\r\n        return res;\r\
    \n    }\r\n#endif\r\n    bool is_bipartite() {\r\n        const int n = par.size()\
    \ / 2;\r\n        bool ok = true;\r\n        for(int i = 0; i < n; ++i) {\r\n\
    \            ok &= (*this)[i] != (*this)[i + n];\r\n        }\r\n        return\
    \ ok;\r\n    }\r\n};"
  dependsOn: []
  isVerificationFile: false
  path: C++/UnionFind.hpp
  requiredBy:
  - C++/MST.hpp
  timestamp: '2023-11-28 11:12:59+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/uf.test.cpp
documentation_of: C++/UnionFind.hpp
layout: document
redirect_from:
- /library/C++/UnionFind.hpp
- /library/C++/UnionFind.hpp.html
title: C++/UnionFind.hpp
---
