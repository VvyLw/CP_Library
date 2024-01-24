---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
  - icon: ':heavy_check_mark:'
    path: C++/MST.hpp
    title: C++/MST.hpp
  - icon: ':heavy_check_mark:'
    path: C++/graph.hpp
    title: C++/graph.hpp
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/bermanford.test.cpp
    title: test/bermanford.test.cpp
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
  bundledCode: "#line 2 \"C++/edge.hpp\"\n\nstruct edge {\n    int src, to;\n    long\
    \ long cost;\n    edge(){}\n    edge(const int to_): to(to_){}\n    edge(const\
    \ int to_, const long long cost_): to(to_), cost(cost_){}\n    edge(const int\
    \ src_, const int to_, const long long cost_): src(src_), to(to_), cost(cost_){}\n\
    };\n"
  code: "#pragma once\n\nstruct edge {\n    int src, to;\n    long long cost;\n  \
    \  edge(){}\n    edge(const int to_): to(to_){}\n    edge(const int to_, const\
    \ long long cost_): to(to_), cost(cost_){}\n    edge(const int src_, const int\
    \ to_, const long long cost_): src(src_), to(to_), cost(cost_){}\n};"
  dependsOn: []
  isVerificationFile: false
  path: C++/edge.hpp
  requiredBy:
  - C++/MST.hpp
  - C++/graph.hpp
  timestamp: '2023-12-12 00:31:50+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/kruskal.test.cpp
  - test/dag_check.test.cpp
  - test/warshallfloyd.test.cpp
  - test/manhattan.test.cpp
  - test/directed.test.cpp
  - test/bermanford.test.cpp
  - test/lca.test.cpp
documentation_of: C++/edge.hpp
layout: document
redirect_from:
- /library/C++/edge.hpp
- /library/C++/edge.hpp.html
title: C++/edge.hpp
---
