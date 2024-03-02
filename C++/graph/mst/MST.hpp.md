---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: C++/graph/edge.hpp
    title: Edge
  _extendedRequiredBy:
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
    path: test/C++/directed.test.cpp
    title: test/C++/directed.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/C++/manhattan.test.cpp
    title: test/C++/manhattan.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: "\u6700\u5C0F\u5168\u57DF\u6728"
    links: []
  bundledCode: "#line 2 \"C++/graph/mst/MST.hpp\"\n\n#include <vector>\n#line 2 \"\
    C++/graph/edge.hpp\"\n\nstruct edge {\n    int src, to, id;\n    long long cost;\n\
    \    edge(){}\n    edge(const int src_, const int to_, const int id_ = -1, const\
    \ long long cost_ = 0): src(src_), to(to_), id(id_), cost(cost_){}\n    operator\
    \ int() const { return to; }\n};\n\n/**\n * @brief Edge\n */\n#line 5 \"C++/graph/mst/MST.hpp\"\
    \nstruct MST {\n    std::vector<edge> tree;\n    long long cost;\n};\n\n/**\n\
    \ * @brief \u6700\u5C0F\u5168\u57DF\u6728\n */\n"
  code: "#pragma once\n\n#include <vector>\n#include \"C++/graph/edge.hpp\"\nstruct\
    \ MST {\n    std::vector<edge> tree;\n    long long cost;\n};\n\n/**\n * @brief\
    \ \u6700\u5C0F\u5168\u57DF\u6728\n */"
  dependsOn:
  - C++/graph/edge.hpp
  isVerificationFile: false
  path: C++/graph/mst/MST.hpp
  requiredBy:
  - C++/graph/mst/directed.hpp
  - C++/graph/mst/manhattan.hpp
  - C++/graph/mst/kruskal.hpp
  timestamp: '2024-02-19 13:17:33+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/C++/manhattan.test.cpp
  - test/C++/directed.test.cpp
documentation_of: C++/graph/mst/MST.hpp
layout: document
redirect_from:
- /library/C++/graph/mst/MST.hpp
- /library/C++/graph/mst/MST.hpp.html
title: "\u6700\u5C0F\u5168\u57DF\u6728"
---
