---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
  - icon: ':heavy_check_mark:'
    path: C++/graph/Graph.hpp
    title: "\u30B0\u30E9\u30D5\u30E9\u30A4\u30D6\u30E9\u30EA"
  - icon: ':heavy_check_mark:'
    path: C++/graph/WeightedGraph.hpp
    title: "\u91CD\u307F\u4ED8\u304D\u30B0\u30E9\u30D5\u30E9\u30A4\u30D6\u30E9\u30EA"
  - icon: ':heavy_check_mark:'
    path: C++/graph/diameter.hpp
    title: "\u6728\u306E\u76F4\u5F84"
  - icon: ':heavy_check_mark:'
    path: C++/graph/mst/MST.hpp
    title: "\u6700\u5C0F\u5168\u57DF\u6728"
  - icon: ':heavy_check_mark:'
    path: C++/graph/mst/directed.hpp
    title: Directed MST
  - icon: ':heavy_check_mark:'
    path: C++/graph/mst/kruskal.hpp
    title: "Kruskal\u6CD5"
  - icon: ':heavy_check_mark:'
    path: C++/graph/mst/manhattan.hpp
    title: Manhattan MST
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/cycledetector.test.cpp
    title: test/cycledetector.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/dag_check.test.cpp
    title: test/dag_check.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/dijkstra.test.cpp
    title: test/dijkstra.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/directed.test.cpp
    title: test/directed.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/lca.test.cpp
    title: test/lca.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/manhattan.test.cpp
    title: test/manhattan.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/scc.test.cpp
    title: test/scc.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/scc2.test.cpp
    title: test/scc2.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/shortestpath.test.cpp
    title: test/shortestpath.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/spfa.test.cpp
    title: test/spfa.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/tree_diameter.test.cpp
    title: test/tree_diameter.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/warshallfloyd.test.cpp
    title: test/warshallfloyd.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: Edge
    links: []
  bundledCode: "#line 2 \"C++/graph/edge.hpp\"\n\nstruct edge {\n    int src, to,\
    \ id;\n    long long cost;\n    edge(){}\n    edge(const int src_, const int to_,\
    \ const int id_ = -1, const long long cost_ = 0): src(src_), to(to_), id(id_),\
    \ cost(cost_){}\n    operator int() const { return to; }\n};\n\n/**\n * @brief\
    \ Edge\n */\n"
  code: "#pragma once\n\nstruct edge {\n    int src, to, id;\n    long long cost;\n\
    \    edge(){}\n    edge(const int src_, const int to_, const int id_ = -1, const\
    \ long long cost_ = 0): src(src_), to(to_), id(id_), cost(cost_){}\n    operator\
    \ int() const { return to; }\n};\n\n/**\n * @brief Edge\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/graph/edge.hpp
  requiredBy:
  - C++/graph/mst/MST.hpp
  - C++/graph/mst/kruskal.hpp
  - C++/graph/mst/manhattan.hpp
  - C++/graph/mst/directed.hpp
  - C++/graph/WeightedGraph.hpp
  - C++/graph/Graph.hpp
  - C++/graph/diameter.hpp
  timestamp: '2024-02-19 12:47:06+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/manhattan.test.cpp
  - test/directed.test.cpp
  - test/dijkstra.test.cpp
  - test/lca.test.cpp
  - test/warshallfloyd.test.cpp
  - test/scc.test.cpp
  - test/scc2.test.cpp
  - test/spfa.test.cpp
  - test/dag_check.test.cpp
  - test/cycledetector.test.cpp
  - test/tree_diameter.test.cpp
  - test/shortestpath.test.cpp
documentation_of: C++/graph/edge.hpp
layout: document
redirect_from:
- /library/C++/graph/edge.hpp
- /library/C++/graph/edge.hpp.html
title: Edge
---
