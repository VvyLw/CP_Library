---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/UnionFind.hpp
    title: C++/UnionFind.hpp
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/kruskal.test.cpp
    title: test/kruskal.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    links: []
  bundledCode: "#line 1 \"C++/MST.hpp\"\n#include <iostream>\n#include <C++/UnionFind.hpp>\n\
    struct Edge {\n\tlong long a, b, cost;\n\tbool operator<(const Edge& e) const\
    \ {\n\t\treturn cost < e.cost;\n\t}\n};\nstruct Graph {\n\tint n;\n\tstd::vector<Edge>\
    \ edges;\n\tGraph(const int n_): n(n_){}\n\tvoid input(int m, const uint indexed=1)\
    \ {\n\t\twhile(m--) {\n\t\t\tEdge e;\n            std::cin >> e.a >> e.b >> e.cost;\n\
    \t\t\te.a-=indexed, e.b-=indexed;\n\t\t\tedges.emplace_back(e);\n\t\t}\n\t}\n\t\
    long long kruskal() {\n#if __cplusplus >= 202101L\n\t\tstd::ranges::sort(edges);\n\
    #else\n        std::sort(edges.begin(), edges.end());\n#endif\n\t\tUnionFind uf(n);\n\
    \t\tlong long res = 0;\n\t\tfor(const auto &ed: edges) {\n\t\t\tif(uf.unite(ed.a,\
    \ ed.b)) res += ed.cost;\n\t\t}\n\t\treturn res;\n\t}\n};\n"
  code: "#include <iostream>\n#include <C++/UnionFind.hpp>\nstruct Edge {\n\tlong\
    \ long a, b, cost;\n\tbool operator<(const Edge& e) const {\n\t\treturn cost <\
    \ e.cost;\n\t}\n};\nstruct Graph {\n\tint n;\n\tstd::vector<Edge> edges;\n\tGraph(const\
    \ int n_): n(n_){}\n\tvoid input(int m, const uint indexed=1) {\n\t\twhile(m--)\
    \ {\n\t\t\tEdge e;\n            std::cin >> e.a >> e.b >> e.cost;\n\t\t\te.a-=indexed,\
    \ e.b-=indexed;\n\t\t\tedges.emplace_back(e);\n\t\t}\n\t}\n\tlong long kruskal()\
    \ {\n#if __cplusplus >= 202101L\n\t\tstd::ranges::sort(edges);\n#else\n      \
    \  std::sort(edges.begin(), edges.end());\n#endif\n\t\tUnionFind uf(n);\n\t\t\
    long long res = 0;\n\t\tfor(const auto &ed: edges) {\n\t\t\tif(uf.unite(ed.a,\
    \ ed.b)) res += ed.cost;\n\t\t}\n\t\treturn res;\n\t}\n};"
  dependsOn:
  - C++/UnionFind.hpp
  isVerificationFile: false
  path: C++/MST.hpp
  requiredBy: []
  timestamp: '2023-12-02 08:23:51+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/kruskal.test.cpp
documentation_of: C++/MST.hpp
layout: document
redirect_from:
- /library/C++/MST.hpp
- /library/C++/MST.hpp.html
title: C++/MST.hpp
---
