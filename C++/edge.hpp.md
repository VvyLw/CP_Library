---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
  - icon: ':heavy_check_mark:'
    path: C++/MST.hpp
    title: "\u6700\u5C0F\u5168\u57DF\u6728"
  - icon: ':heavy_check_mark:'
    path: C++/graph.hpp
    title: "\u30B0\u30E9\u30D5\u30E9\u30A4\u30D6\u30E9\u30EA"
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/bermanford.test.cpp
    title: test/bermanford.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/cycledetector.test.cpp
    title: test/cycledetector.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/dag_check.test.cpp
    title: test/dag_check.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/directed.test.cpp
    title: test/directed.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/kruskal.test.cpp
    title: test/kruskal.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/lca.test.cpp
    title: test/lca.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/manhattan.test.cpp
    title: test/manhattan.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/warshallfloyd.test.cpp
    title: test/warshallfloyd.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    links: []
  bundledCode: "#line 2 \"C++/edge.hpp\"\n\nstruct edge {\n    int src, to, id;\n\
    \    long long cost;\n    edge(){}\n    edge(const int src_, const int to_, const\
    \ int id_ = -1, const long long cost_ = 0): src(src_), to(to_), id(id_), cost(cost_){}\n\
    \    operator int() const { return to; }\n};\n"
  code: "#pragma once\n\nstruct edge {\n    int src, to, id;\n    long long cost;\n\
    \    edge(){}\n    edge(const int src_, const int to_, const int id_ = -1, const\
    \ long long cost_ = 0): src(src_), to(to_), id(id_), cost(cost_){}\n    operator\
    \ int() const { return to; }\n};"
  dependsOn: []
  isVerificationFile: false
  path: C++/edge.hpp
  requiredBy:
  - C++/graph.hpp
  - C++/MST.hpp
  timestamp: '2024-02-17 11:08:09+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/cycledetector.test.cpp
  - test/manhattan.test.cpp
  - test/kruskal.test.cpp
  - test/dag_check.test.cpp
  - test/lca.test.cpp
  - test/warshallfloyd.test.cpp
  - test/bermanford.test.cpp
  - test/directed.test.cpp
documentation_of: C++/edge.hpp
layout: document
redirect_from:
- /library/C++/edge.hpp
- /library/C++/edge.hpp.html
title: C++/edge.hpp
---
