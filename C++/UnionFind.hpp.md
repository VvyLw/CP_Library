---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
  - icon: ':x:'
    path: C++/graph.hpp
    title: C++/graph.hpp
  _extendedVerifiedWith:
  - icon: ':x:'
    path: test/lca.test.cpp
    title: test/lca.test.cpp
  - icon: ':x:'
    path: test/uf.test.cpp
    title: test/uf.test.cpp
  _isVerificationFailed: true
  _pathExtension: hpp
  _verificationStatusIcon: ':x:'
  attributes:
    links:
    - https://github.com/maspypy/library/blob/main/ds/unionfind/unionfind.hpp)
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 312, in update\n    raise BundleErrorAt(path, i + 1, \"#pragma once found\
    \ in a non-first line\")\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt:\
    \ C++/UnionFind.hpp: line 2: #pragma once found in a non-first line\n"
  code: "// inspired by maspy(https://github.com/maspypy/library/blob/main/ds/unionfind/unionfind.hpp)\r\
    \n#pragma once\r\n#include <cassert>\r\n#include <vector>\r\n#include <algorithm>\r\
    \nstruct UnionFind {\r\nprivate:\r\n    std::vector<int> par;\r\npublic:\r\n \
    \   UnionFind(const int n): par(n, -1){}\r\n    int operator[](int i) {\r\n  \
    \      while(par[i] >= 0) {\r\n            const int p = par[par[i]];\r\n    \
    \        if(p < 0) return par[];\r\n            i = par[a] = p;\r\n        }\r\
    \n        return i;\r\n    }\r\n    bool unite(int x, int y) {\r\n        x =\
    \ (*this)[x], y = (*this)[y];\r\n        if(x == y) return false;\r\n        if(-par[x]\
    \ < -par[y]) std::swap(x, y);\r\n        par[x] += par[y], par[y] = x;\r\n   \
    \     return true;\r\n    }\r\n    int size(const int x){ return -par[(*this)[x]];\
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
    \n    }\r\n#endif\r\n};\r\n"
  dependsOn: []
  isVerificationFile: false
  path: C++/UnionFind.hpp
  requiredBy:
  - C++/graph.hpp
  timestamp: '2023-11-28 10:57:12+09:00'
  verificationStatus: LIBRARY_ALL_WA
  verifiedWith:
  - test/uf.test.cpp
  - test/lca.test.cpp
documentation_of: C++/UnionFind.hpp
layout: document
redirect_from:
- /library/C++/UnionFind.hpp
- /library/C++/UnionFind.hpp.html
title: C++/UnionFind.hpp
---
