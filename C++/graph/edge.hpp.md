---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
  - icon: ':question:'
    path: C++/graph/Graph.hpp
    title: "\u30B0\u30E9\u30D5\u30E9\u30A4\u30D6\u30E9\u30EA"
  - icon: ':x:'
    path: C++/graph/WeightedGraph.hpp
    title: "\u91CD\u307F\u4ED8\u304D\u30B0\u30E9\u30D5\u30E9\u30A4\u30D6\u30E9\u30EA"
  - icon: ':x:'
    path: C++/graph/mst/MST.hpp
    title: "\u6700\u5C0F\u5168\u57DF\u6728"
  - icon: ':x:'
    path: C++/graph/mst/directed.hpp
    title: Directed MST
  - icon: ':x:'
    path: C++/graph/mst/kruskal.hpp
    title: "Kruskal\u6CD5"
  - icon: ':x:'
    path: C++/graph/mst/manhattan.hpp
    title: Manhattan MST
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/C++/cycledetector.test.cpp
    title: test/C++/cycledetector.test.cpp
  - icon: ':x:'
    path: test/C++/dag_check.test.cpp
    title: test/C++/dag_check.test.cpp
  - icon: ':x:'
    path: test/C++/dijkstra.test.cpp
    title: test/C++/dijkstra.test.cpp
  - icon: ':x:'
    path: test/C++/directed.test.cpp
    title: test/C++/directed.test.cpp
  - icon: ':x:'
    path: test/C++/lca.test.cpp
    title: test/C++/lca.test.cpp
  - icon: ':x:'
    path: test/C++/manhattan.test.cpp
    title: test/C++/manhattan.test.cpp
  - icon: ':x:'
    path: test/C++/scc.test.cpp
    title: test/C++/scc.test.cpp
  - icon: ':x:'
    path: test/C++/scc2.test.cpp
    title: test/C++/scc2.test.cpp
  - icon: ':x:'
    path: test/C++/shortestpath.test.cpp
    title: test/C++/shortestpath.test.cpp
  - icon: ':x:'
    path: test/C++/spfa.test.cpp
    title: test/C++/spfa.test.cpp
  - icon: ':x:'
    path: test/C++/warshallfloyd.test.cpp
    title: test/C++/warshallfloyd.test.cpp
  _isVerificationFailed: true
  _pathExtension: hpp
  _verificationStatusIcon: ':question:'
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
  - C++/graph/mst/directed.hpp
  - C++/graph/mst/manhattan.hpp
  - C++/graph/mst/kruskal.hpp
  - C++/graph/mst/MST.hpp
  - C++/graph/WeightedGraph.hpp
  - C++/graph/Graph.hpp
  timestamp: '2024-02-19 12:47:06+09:00'
  verificationStatus: LIBRARY_SOME_WA
  verifiedWith:
  - test/C++/cycledetector.test.cpp
  - test/C++/scc.test.cpp
  - test/C++/manhattan.test.cpp
  - test/C++/dag_check.test.cpp
  - test/C++/scc2.test.cpp
  - test/C++/lca.test.cpp
  - test/C++/spfa.test.cpp
  - test/C++/warshallfloyd.test.cpp
  - test/C++/shortestpath.test.cpp
  - test/C++/dijkstra.test.cpp
  - test/C++/directed.test.cpp
documentation_of: C++/graph/edge.hpp
layout: document
redirect_from:
- /library/C++/graph/edge.hpp
- /library/C++/graph/edge.hpp.html
title: Edge
---
