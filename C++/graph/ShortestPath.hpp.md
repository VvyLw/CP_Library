---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
  - icon: ':x:'
    path: C++/graph/WeightedGraph.hpp
    title: "\u91CD\u307F\u4ED8\u304D\u30B0\u30E9\u30D5\u30E9\u30A4\u30D6\u30E9\u30EA"
  _extendedVerifiedWith:
  - icon: ':x:'
    path: test/dijkstra.test.cpp
    title: test/dijkstra.test.cpp
  - icon: ':x:'
    path: test/shortestpath.test.cpp
    title: test/shortestpath.test.cpp
  - icon: ':x:'
    path: test/spfa.test.cpp
    title: test/spfa.test.cpp
  - icon: ':x:'
    path: test/warshallfloyd.test.cpp
    title: test/warshallfloyd.test.cpp
  _isVerificationFailed: true
  _pathExtension: hpp
  _verificationStatusIcon: ':x:'
  attributes:
    document_title: "\u6700\u77ED\u8DEF"
    links: []
  bundledCode: "#line 2 \"C++/graph/ShortestPath.hpp\"\n\n#pragma GCC diagnostic ignored\
    \ \"-Wreorder\"\n\n#include <vector>\n#include <algorithm>\nstruct ShortestPath\
    \ {\nprivate:\n    const std::vector<long long> cost;\n    const std::vector<int>\
    \ src;\npublic:\n    ShortestPath(const std::vector<long long> &cost, const std::vector<int>\
    \ &src): cost(cost), src(src){}\n    bool is_thru(const int i){ return src[i]\
    \ != -1; }\n    std::vector<int> path(int i) {\n        std::vector<int> res;\n\
    \        for(; i != -1; i = src[i]) {\n            res.emplace_back(i);\n    \
    \    }\n        std::ranges::reverse(res);\n        return res;\n    }\n    std::vector<long\
    \ long> get() const { return cost; }\n};\n\n/**\n * @brief \u6700\u77ED\u8DEF\n\
    \ */\n"
  code: "#pragma once\n\n#pragma GCC diagnostic ignored \"-Wreorder\"\n\n#include\
    \ <vector>\n#include <algorithm>\nstruct ShortestPath {\nprivate:\n    const std::vector<long\
    \ long> cost;\n    const std::vector<int> src;\npublic:\n    ShortestPath(const\
    \ std::vector<long long> &cost, const std::vector<int> &src): cost(cost), src(src){}\n\
    \    bool is_thru(const int i){ return src[i] != -1; }\n    std::vector<int> path(int\
    \ i) {\n        std::vector<int> res;\n        for(; i != -1; i = src[i]) {\n\
    \            res.emplace_back(i);\n        }\n        std::ranges::reverse(res);\n\
    \        return res;\n    }\n    std::vector<long long> get() const { return cost;\
    \ }\n};\n\n/**\n * @brief \u6700\u77ED\u8DEF\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/graph/ShortestPath.hpp
  requiredBy:
  - C++/graph/WeightedGraph.hpp
  timestamp: '2024-02-29 11:41:45+09:00'
  verificationStatus: LIBRARY_ALL_WA
  verifiedWith:
  - test/spfa.test.cpp
  - test/warshallfloyd.test.cpp
  - test/shortestpath.test.cpp
  - test/dijkstra.test.cpp
documentation_of: C++/graph/ShortestPath.hpp
layout: document
redirect_from:
- /library/C++/graph/ShortestPath.hpp
- /library/C++/graph/ShortestPath.hpp.html
title: "\u6700\u77ED\u8DEF"
---
