---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
  - icon: ':heavy_check_mark:'
    path: C++/graph/WeightedGraph.hpp
    title: "\u91CD\u307F\u4ED8\u304D\u30B0\u30E9\u30D5\u30E9\u30A4\u30D6\u30E9\u30EA"
  - icon: ':heavy_check_mark:'
    path: C++/graph/diameter.hpp
    title: "\u6728\u306E\u76F4\u5F84"
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/dijkstra.test.cpp
    title: test/dijkstra.test.cpp
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
    document_title: "\u6700\u77ED\u8DEF"
    links: []
  bundledCode: "#line 2 \"C++/graph/ShortestPath.hpp\"\n\n#pragma GCC diagnostic ignored\
    \ \"-Wreorder\"\n\n#include <vector>\n#include <algorithm>\nnamespace man {\n\
    struct ShortestPath {\nprivate:\n    const std::vector<long long> cost;\n    const\
    \ std::vector<int> src;\npublic:\n    ShortestPath(const std::vector<long long>\
    \ &cost, const std::vector<int> &src): cost(cost), src(src){}\n    inline bool\
    \ is_thru(const int i) const noexcept { return src[i] != -1; }\n    inline std::vector<int>\
    \ path(int i) noexcept {\n        std::vector<int> ret;\n        for(; i != -1;\
    \ i = src[i]) {\n            ret.emplace_back(i);\n        }\n        std::ranges::reverse(ret);\n\
    \        return ret;\n    }\n    inline std::vector<long long> get() const noexcept\
    \ { return cost; }\n};\n}\n\n/**\n * @brief \u6700\u77ED\u8DEF\n */\n"
  code: "#pragma once\n\n#pragma GCC diagnostic ignored \"-Wreorder\"\n\n#include\
    \ <vector>\n#include <algorithm>\nnamespace man {\nstruct ShortestPath {\nprivate:\n\
    \    const std::vector<long long> cost;\n    const std::vector<int> src;\npublic:\n\
    \    ShortestPath(const std::vector<long long> &cost, const std::vector<int> &src):\
    \ cost(cost), src(src){}\n    inline bool is_thru(const int i) const noexcept\
    \ { return src[i] != -1; }\n    inline std::vector<int> path(int i) noexcept {\n\
    \        std::vector<int> ret;\n        for(; i != -1; i = src[i]) {\n       \
    \     ret.emplace_back(i);\n        }\n        std::ranges::reverse(ret);\n  \
    \      return ret;\n    }\n    inline std::vector<long long> get() const noexcept\
    \ { return cost; }\n};\n}\n\n/**\n * @brief \u6700\u77ED\u8DEF\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/graph/ShortestPath.hpp
  requiredBy:
  - C++/graph/diameter.hpp
  - C++/graph/WeightedGraph.hpp
  timestamp: '2025-06-14 01:07:36+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/warshallfloyd.test.cpp
  - test/tree_diameter.test.cpp
  - test/dijkstra.test.cpp
  - test/shortestpath.test.cpp
  - test/spfa.test.cpp
documentation_of: C++/graph/ShortestPath.hpp
layout: document
redirect_from:
- /library/C++/graph/ShortestPath.hpp
- /library/C++/graph/ShortestPath.hpp.html
title: "\u6700\u77ED\u8DEF"
---
