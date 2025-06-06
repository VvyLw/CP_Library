---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: C++/ds/uf/UnionFind.hpp
    title: UnionFind
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    document_title: MergeUnionFind
    links: []
  bundledCode: "#line 2 \"C++/ds/uf/MergeUF.hpp\"\n\n#line 2 \"C++/ds/uf/UnionFind.hpp\"\
    \n\r\n#include <cassert>\r\n#include <vector>\r\n#include <algorithm>\r\nnamespace\
    \ man {\r\nstruct UnionFind {\r\nprotected:\r\n    std::vector<int> par;\r\npublic:\r\
    \n    UnionFind(const int n): par(n, -1){}\r\n    inline int operator[](int i)\
    \ noexcept {\r\n        while(par[i] >= 0) {\r\n            const int p = par[par[i]];\r\
    \n            if(p < 0) return par[i];\r\n            i = par[i] = p;\r\n    \
    \    }\r\n        return i;\r\n    }\r\n    inline bool unite(int x, int y) noexcept\
    \ {\r\n        x = (*this)[x], y = (*this)[y];\r\n        if(x == y) return false;\r\
    \n        if(-par[x] < -par[y]) {\r\n            std::swap(x, y);\r\n        }\r\
    \n        par[x] += par[y], par[y] = x;\r\n        return true;\r\n    }\r\n \
    \   inline int size(const int x) noexcept {\r\n        return -par[(*this)[x]];\r\
    \n    }\r\n    inline int size() const noexcept { return par.size(); }\r\n   \
    \ inline std::vector<std::vector<int>> groups() noexcept {\r\n        const int\
    \ n = std::ssize(par);\r\n        std::vector<std::vector<int>> res(n);\r\n  \
    \      for(int i = 0; i < n; ++i) {\r\n            res[(*this)[i]].emplace_back(i);\r\
    \n        }\r\n        const auto it = std::ranges::remove_if(res, [&](const std::vector<int>\
    \ &v){ return v.empty(); });\r\n        res.erase(it.begin(), it.end());\r\n \
    \       return res;\r\n    }\r\n};\r\n\r\ninline bool is_bipartite(UnionFind uf)\
    \ noexcept {\r\n    assert(uf.size() % 2 == 0);\r\n    const int n = uf.size()\
    \ / 2;\r\n    bool ok = true;\r\n    for(int i = 0; i < n; ++i) {\r\n        ok\
    \ &= uf[i] != uf[i + n];\r\n    }\r\n    return ok;\r\n}\r\n}\r\n/**\r\n * @brief\
    \ UnionFind\r\n * @see https://github.com/maspypy/library/blob/main/ds/unionfind/unionfind.hpp\r\
    \n */\n#line 4 \"C++/ds/uf/MergeUF.hpp\"\nnamespace man {\ntemplate <class T>\
    \ struct MergeUF: UnionFind {\n    using UnionFind::par;\n    using UnionFind::operator[];\n\
    \    using UnionFind::size;\n    using UnionFind::groups;\n    MergeUF(const int\
    \ n): UnionFind(n){}\n    ~MergeUF(){}\n    virtual T get(const int i) = 0;\n\
    \    virtual void merge(const int i, const int j) = 0;\n    bool unite(int x,\
    \ int y) {\n        x = (*this)[x], y = (*this)[y];\n        if(x == y) return\
    \ false;\n        if(-par[x] < -par[y]) {\n            std::swap(x, y);\n    \
    \    }\n        par[x] += par[y], par[y] = x;\n\t\tmerge(x, y);\n\t\treturn true;\n\
    \t}\n};\n}\n/**\n * @brief MergeUnionFind\n */\n"
  code: "#pragma once\n\n#include \"C++/ds/uf/UnionFind.hpp\"\nnamespace man {\ntemplate\
    \ <class T> struct MergeUF: UnionFind {\n    using UnionFind::par;\n    using\
    \ UnionFind::operator[];\n    using UnionFind::size;\n    using UnionFind::groups;\n\
    \    MergeUF(const int n): UnionFind(n){}\n    ~MergeUF(){}\n    virtual T get(const\
    \ int i) = 0;\n    virtual void merge(const int i, const int j) = 0;\n    bool\
    \ unite(int x, int y) {\n        x = (*this)[x], y = (*this)[y];\n        if(x\
    \ == y) return false;\n        if(-par[x] < -par[y]) {\n            std::swap(x,\
    \ y);\n        }\n        par[x] += par[y], par[y] = x;\n\t\tmerge(x, y);\n\t\t\
    return true;\n\t}\n};\n}\n/**\n * @brief MergeUnionFind\n */"
  dependsOn:
  - C++/ds/uf/UnionFind.hpp
  isVerificationFile: false
  path: C++/ds/uf/MergeUF.hpp
  requiredBy: []
  timestamp: '2025-06-06 22:43:06+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/ds/uf/MergeUF.hpp
layout: document
redirect_from:
- /library/C++/ds/uf/MergeUF.hpp
- /library/C++/ds/uf/MergeUF.hpp.html
title: MergeUnionFind
---
