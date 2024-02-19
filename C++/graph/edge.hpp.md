---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
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
  requiredBy: []
  timestamp: '2024-02-19 12:47:06+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/graph/edge.hpp
layout: document
redirect_from:
- /library/C++/graph/edge.hpp
- /library/C++/graph/edge.hpp.html
title: Edge
---
