---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
  - icon: ':warning:'
    path: C++/MST.hpp
    title: "\u6700\u5C0F\u5168\u57DF\u6728"
  - icon: ':warning:'
    path: C++/graph.hpp
    title: "\u30B0\u30E9\u30D5\u30E9\u30A4\u30D6\u30E9\u30EA"
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
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
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/edge.hpp
layout: document
redirect_from:
- /library/C++/edge.hpp
- /library/C++/edge.hpp.html
title: C++/edge.hpp
---
