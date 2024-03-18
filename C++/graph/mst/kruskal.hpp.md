---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/ds/uf/UnionFind.hpp
    title: UnionFind
  - icon: ':heavy_check_mark:'
    path: C++/graph/edge.hpp
    title: Edge
  - icon: ':heavy_check_mark:'
    path: C++/graph/mst/MST.hpp
    title: "\u6700\u5C0F\u5168\u57DF\u6728"
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/manhattan.test.cpp
    title: test/manhattan.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: "Kruskal\u6CD5"
    links: []
  bundledCode: "#line 2 \"C++/graph/mst/kruskal.hpp\"\n\n#include <vector>\n#line\
    \ 2 \"C++/graph/mst/MST.hpp\"\n\n#line 2 \"C++/graph/edge.hpp\"\n\nstruct edge\
    \ {\n    int src, to, id;\n    long long cost;\n    edge(){}\n    edge(const int\
    \ src_, const int to_, const int id_ = -1, const long long cost_ = 0): src(src_),\
    \ to(to_), id(id_), cost(cost_){}\n    operator int() const { return to; }\n};\n\
    \n/**\n * @brief Edge\n */\n#line 5 \"C++/graph/mst/MST.hpp\"\nstruct MST {\n\
    \    std::vector<edge> tree;\n    long long cost;\n};\n\n/**\n * @brief \u6700\
    \u5C0F\u5168\u57DF\u6728\n */\n#line 2 \"C++/ds/uf/UnionFind.hpp\"\n\r\n#include\
    \ <cassert>\r\n#line 5 \"C++/ds/uf/UnionFind.hpp\"\n#include <algorithm>\r\nstruct\
    \ UnionFind {\r\nprotected:\r\n    std::vector<int> par;\r\npublic:\r\n    UnionFind(const\
    \ int n): par(n, -1){}\r\n    int operator[](int i) {\r\n        while(par[i]\
    \ >= 0) {\r\n            const int p = par[par[i]];\r\n            if(p < 0) return\
    \ par[i];\r\n            i = par[i] = p;\r\n        }\r\n        return i;\r\n\
    \    }\r\n    bool unite(int x, int y) {\r\n        x = (*this)[x], y = (*this)[y];\r\
    \n        if(x == y) return false;\r\n        if(-par[x] < -par[y]) {\r\n    \
    \        std::swap(x, y);\r\n        }\r\n        par[x] += par[y], par[y] = x;\r\
    \n        return true;\r\n    }\r\n    int size(const int x) {\r\n        return\
    \ -par[(*this)[x]];\r\n    }\r\n    int size() const { return par.size(); }\r\n\
    #if __cplusplus >= 202101L\r\n    std::vector<std::vector<int>> groups() {\r\n\
    \        const int n = std::ssize(par);\r\n        std::vector<std::vector<int>>\
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
    \ */\n#line 6 \"C++/graph/mst/kruskal.hpp\"\ninline MST kruskal(std::vector<edge>\
    \ edges, const int n) {\n    std::sort(edges.begin(), edges.end(), [&](const edge\
    \ &e, const edge &f){ return e.cost < f.cost; });\n    UnionFind uf(n);\n    std::vector<edge>\
    \ e;\n    long long res = 0;\n    for(const auto &ed: edges) {\n        if(uf.unite(ed.src,\
    \ ed)) {\n            e.emplace_back(ed);\n            res += ed.cost;\n     \
    \   }\n    }\n    return {e, res};\n}\n\n/**\n * @brief Kruskal\u6CD5\n */\n"
  code: "#pragma once\n\n#include <vector>\n#include \"C++/graph/mst/MST.hpp\"\n#include\
    \ \"C++/ds/uf/UnionFind.hpp\"\ninline MST kruskal(std::vector<edge> edges, const\
    \ int n) {\n    std::sort(edges.begin(), edges.end(), [&](const edge &e, const\
    \ edge &f){ return e.cost < f.cost; });\n    UnionFind uf(n);\n    std::vector<edge>\
    \ e;\n    long long res = 0;\n    for(const auto &ed: edges) {\n        if(uf.unite(ed.src,\
    \ ed)) {\n            e.emplace_back(ed);\n            res += ed.cost;\n     \
    \   }\n    }\n    return {e, res};\n}\n\n/**\n * @brief Kruskal\u6CD5\n */"
  dependsOn:
  - C++/graph/mst/MST.hpp
  - C++/graph/edge.hpp
  - C++/ds/uf/UnionFind.hpp
  isVerificationFile: false
  path: C++/graph/mst/kruskal.hpp
  requiredBy: []
  timestamp: '2024-02-29 01:03:52+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/manhattan.test.cpp
documentation_of: C++/graph/mst/kruskal.hpp
layout: document
redirect_from:
- /library/C++/graph/mst/kruskal.hpp
- /library/C++/graph/mst/kruskal.hpp.html
title: "Kruskal\u6CD5"
---