---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
  - icon: ':heavy_check_mark:'
    path: C++/MST.hpp
    title: C++/MST.hpp
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/kruskal.test.cpp
    title: test/kruskal.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/uf.test.cpp
    title: test/uf.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/ufpotential.test.cpp
    title: test/ufpotential.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    links:
    - https://ei1333.github.io/luzhiled/snippets/structure/union-find.html
    - https://github.com/maspypy/library/blob/main/ds/unionfind/unionfind.hpp)
    - https://github.com/tatyam-prime/kyopro_library/blob/master/UnionFind.cpp
  bundledCode: "#line 1 \"C++/UnionFind.hpp\"\n// inspired by maspy(https://github.com/maspypy/library/blob/main/ds/unionfind/unionfind.hpp)\r\
    \n#include <cassert>\r\n#include <vector>\r\n#include <algorithm>\r\n#include\
    \ <stack>\r\nstruct UnionFind {\r\nprivate:\r\n    std::vector<int> par;\r\npublic:\r\
    \n    UnionFind(const int n): par(n, -1){}\r\n    int operator[](int i) {\r\n\
    \        while(par[i] >= 0) {\r\n            const int p = par[par[i]];\r\n  \
    \          if(p < 0) return par[i];\r\n            i = par[i] = p;\r\n       \
    \ }\r\n        return i;\r\n    }\r\n    bool unite(int x, int y) {\r\n      \
    \  x = (*this)[x], y = (*this)[y];\r\n        if(x == y) return false;\r\n   \
    \     if(-par[x] < -par[y]) {\r\n            std::swap(x, y);\r\n        }\r\n\
    \        par[x] += par[y], par[y] = x;\r\n        return true;\r\n    }\r\n  \
    \  int size(const int x) {\r\n        return -par[(*this)[x]];\r\n    }\r\n#if\
    \ __cplusplus >= 202101L\r\n    std::vector<std::vector<int>> groups() {\r\n \
    \       const int n = std::ssize(par);\r\n        std::vector<std::vector<int>>\
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
    \ ok;\r\n    }\r\n};\r\n\r\n// inspired by tatyam( https://github.com/tatyam-prime/kyopro_library/blob/master/UnionFind.cpp\
    \ )\r\nstruct UFPotential {\r\nprivate:\r\n    std::vector<int> par;\r\n    std::vector<long\
    \ long> diff;\r\npublic:\r\n    UFPotential(const int n): par(n, -1), diff(n){}\r\
    \n    int root(const int i) {\r\n        if(par[i] < 0) {\r\n            return\
    \ i;\r\n        }\r\n        const int r = root(par[i]);\r\n        diff[i] +=\
    \ diff[par[i]];\r\n        return par[i] = r;\r\n    }\r\n    long long dist(const\
    \ int i) {\r\n        root(i);\r\n        return diff[i];\r\n    }\r\n    long\
    \ long dist(const int x, const int y){ return dist(y) - dist(x); }\r\n    int\
    \ unite(int x, int y, long long w) {\r\n        w += dist(y, x);\r\n        x\
    \ = root(x), y = root(y);\r\n        if(x == y) {\r\n            return w == 0\
    \ ? 0 : -1;\r\n        }\r\n        if(par[x] > par[y]) {\r\n            std::swap(x,\
    \ y);\r\n            w = -w;\r\n        }\r\n        par[x] += par[y];\r\n   \
    \     par[y] = x;\r\n        diff[y] = w;\r\n        return 1;\r\n    }\r\n  \
    \  int operator[](const int i) noexcept { return root(i); }\r\n};\r\n\r\n// inspired\
    \ by Luzhiled( https://ei1333.github.io/luzhiled/snippets/structure/union-find.html\
    \ )\r\nstruct UFUndo {\r\nprivate:\r\n    std::vector<int> par;\r\n\tstd::stack<std::pair<int,\
    \ int>> his;\r\npublic:\r\n\tUFUndo(const int n): par(n, -1){}\r\n    bool unite(int\
    \ x, int y) {\r\n\t\tx = root(x);\r\n\t\ty = root(y);\r\n\t\this.emplace(std::make_pair(x,\
    \ par[x]));\r\n\t\this.emplace(std::make_pair(y, par[y]));\r\n\t\tif(x == y) {\r\
    \n\t\t\treturn false;\r\n\t\t}\r\n\t\tif(par[x] > par[y]) {\r\n\t\t\tstd::swap(x,\
    \ y);\r\n\t\t}\r\n\t\tpar[x] += par[y];\r\n\t\tpar[y] = x;\r\n\t\treturn true;\r\
    \n\t}\r\n    int root(int k) {\r\n        if(par[k] < 0) {\r\n            return\
    \ k;\r\n        }\r\n        return root(par[k]);\r\n    }\r\n    int size(const\
    \ int i){ return -par[root(i)]; }\r\n    void undo() {\r\n\t\tpar[his.top().first]\
    \ = his.top().second;\r\n        his.pop();\r\n\t\tpar[his.top().first] = his.top().second;\r\
    \n        his.pop();\r\n\t}\r\n    void snapshot() {\r\n\t\twhile(his.size())\
    \ {\r\n\t\t\this.pop();\r\n\t\t}\r\n\t}\r\n\tvoid rollback() {\r\n\t\twhile(his.size())\
    \ {\r\n\t\t\tundo();\r\n\t\t}\r\n\t}\r\n};\n"
  code: "// inspired by maspy(https://github.com/maspypy/library/blob/main/ds/unionfind/unionfind.hpp)\r\
    \n#include <cassert>\r\n#include <vector>\r\n#include <algorithm>\r\n#include\
    \ <stack>\r\nstruct UnionFind {\r\nprivate:\r\n    std::vector<int> par;\r\npublic:\r\
    \n    UnionFind(const int n): par(n, -1){}\r\n    int operator[](int i) {\r\n\
    \        while(par[i] >= 0) {\r\n            const int p = par[par[i]];\r\n  \
    \          if(p < 0) return par[i];\r\n            i = par[i] = p;\r\n       \
    \ }\r\n        return i;\r\n    }\r\n    bool unite(int x, int y) {\r\n      \
    \  x = (*this)[x], y = (*this)[y];\r\n        if(x == y) return false;\r\n   \
    \     if(-par[x] < -par[y]) {\r\n            std::swap(x, y);\r\n        }\r\n\
    \        par[x] += par[y], par[y] = x;\r\n        return true;\r\n    }\r\n  \
    \  int size(const int x) {\r\n        return -par[(*this)[x]];\r\n    }\r\n#if\
    \ __cplusplus >= 202101L\r\n    std::vector<std::vector<int>> groups() {\r\n \
    \       const int n = std::ssize(par);\r\n        std::vector<std::vector<int>>\
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
    \ ok;\r\n    }\r\n};\r\n\r\n// inspired by tatyam( https://github.com/tatyam-prime/kyopro_library/blob/master/UnionFind.cpp\
    \ )\r\nstruct UFPotential {\r\nprivate:\r\n    std::vector<int> par;\r\n    std::vector<long\
    \ long> diff;\r\npublic:\r\n    UFPotential(const int n): par(n, -1), diff(n){}\r\
    \n    int root(const int i) {\r\n        if(par[i] < 0) {\r\n            return\
    \ i;\r\n        }\r\n        const int r = root(par[i]);\r\n        diff[i] +=\
    \ diff[par[i]];\r\n        return par[i] = r;\r\n    }\r\n    long long dist(const\
    \ int i) {\r\n        root(i);\r\n        return diff[i];\r\n    }\r\n    long\
    \ long dist(const int x, const int y){ return dist(y) - dist(x); }\r\n    int\
    \ unite(int x, int y, long long w) {\r\n        w += dist(y, x);\r\n        x\
    \ = root(x), y = root(y);\r\n        if(x == y) {\r\n            return w == 0\
    \ ? 0 : -1;\r\n        }\r\n        if(par[x] > par[y]) {\r\n            std::swap(x,\
    \ y);\r\n            w = -w;\r\n        }\r\n        par[x] += par[y];\r\n   \
    \     par[y] = x;\r\n        diff[y] = w;\r\n        return 1;\r\n    }\r\n  \
    \  int operator[](const int i) noexcept { return root(i); }\r\n};\r\n\r\n// inspired\
    \ by Luzhiled( https://ei1333.github.io/luzhiled/snippets/structure/union-find.html\
    \ )\r\nstruct UFUndo {\r\nprivate:\r\n    std::vector<int> par;\r\n\tstd::stack<std::pair<int,\
    \ int>> his;\r\npublic:\r\n\tUFUndo(const int n): par(n, -1){}\r\n    bool unite(int\
    \ x, int y) {\r\n\t\tx = root(x);\r\n\t\ty = root(y);\r\n\t\this.emplace(std::make_pair(x,\
    \ par[x]));\r\n\t\this.emplace(std::make_pair(y, par[y]));\r\n\t\tif(x == y) {\r\
    \n\t\t\treturn false;\r\n\t\t}\r\n\t\tif(par[x] > par[y]) {\r\n\t\t\tstd::swap(x,\
    \ y);\r\n\t\t}\r\n\t\tpar[x] += par[y];\r\n\t\tpar[y] = x;\r\n\t\treturn true;\r\
    \n\t}\r\n    int root(int k) {\r\n        if(par[k] < 0) {\r\n            return\
    \ k;\r\n        }\r\n        return root(par[k]);\r\n    }\r\n    int size(const\
    \ int i){ return -par[root(i)]; }\r\n    void undo() {\r\n\t\tpar[his.top().first]\
    \ = his.top().second;\r\n        his.pop();\r\n\t\tpar[his.top().first] = his.top().second;\r\
    \n        his.pop();\r\n\t}\r\n    void snapshot() {\r\n\t\twhile(his.size())\
    \ {\r\n\t\t\this.pop();\r\n\t\t}\r\n\t}\r\n\tvoid rollback() {\r\n\t\twhile(his.size())\
    \ {\r\n\t\t\tundo();\r\n\t\t}\r\n\t}\r\n};"
  dependsOn: []
  isVerificationFile: false
  path: C++/UnionFind.hpp
  requiredBy:
  - C++/MST.hpp
  timestamp: '2023-12-02 08:23:51+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/ufpotential.test.cpp
  - test/uf.test.cpp
  - test/kruskal.test.cpp
documentation_of: C++/UnionFind.hpp
layout: document
redirect_from:
- /library/C++/UnionFind.hpp
- /library/C++/UnionFind.hpp.html
title: C++/UnionFind.hpp
---