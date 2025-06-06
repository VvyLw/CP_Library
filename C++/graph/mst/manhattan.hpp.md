---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: C++/graph/edge.hpp
    title: Edge
  - icon: ':heavy_check_mark:'
    path: C++/graph/mst/MST.hpp
    title: "\u6700\u5C0F\u5168\u57DF\u6728"
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/manhattan.test.cpp
    title: test/manhattan.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: Manhattan MST
    links:
    - https://ei1333.github.io/library/graph/mst/manhattan-mst.hpp
  bundledCode: "#line 2 \"C++/graph/mst/manhattan.hpp\"\n\n#include <cassert>\n#include\
    \ <map>\n#include <numeric>\n#include <ranges>\n#line 2 \"C++/graph/mst/MST.hpp\"\
    \n\n#include <vector>\n#line 2 \"C++/graph/edge.hpp\"\n#ifndef EDGE\n#define EDGE\n\
    #endif\n\nnamespace man {\nstruct edge {\n    int src, to, id;\n    int64_t cost;\n\
    \    edge(){}\n    edge(const int src_, const int to_, const int id_ = -1, const\
    \ int64_t cost_ = 0): src(src_), to(to_), id(id_), cost(cost_){}\n    constexpr\
    \ inline operator int() const noexcept { return to; }\n};\n}\n\n/**\n * @brief\
    \ Edge\n */\n#line 5 \"C++/graph/mst/MST.hpp\"\nstruct MST {\n    std::vector<man::edge>\
    \ tree;\n    int64_t cost;\n};\n\n/**\n * @brief \u6700\u5C0F\u5168\u57DF\u6728\
    \n */\n#line 8 \"C++/graph/mst/manhattan.hpp\"\nnamespace man {\ntemplate <class\
    \ T> inline std::vector<edge> manhattan(std::vector<T> x, std::vector<T> y) noexcept\
    \ {\n    assert(std::ssize(x) == std::ssize(y));\n    std::vector<edge> ret;\n\
    \    std::vector<int> id(std::ssize(x));\n    std::iota(id.begin(), id.end(),\
    \ 0);\n    for([[maybe_unused]] const auto _: std::views::iota(0, 2)) {\n    \
    \    for([[maybe_unused]] const auto _: std::views::iota(0, 2)) {\n          \
    \  std::ranges::sort(id, [&](const int i, const int j) -> bool { return x[i] +\
    \ y[i] < x[j] + y[j]; });\n            std::map<T, int> idx;\n            for(const\
    \ auto i: id) {\n                for(auto it = idx.lower_bound(-y[i]); it != idx.end();\
    \ it = idx.erase(it)) {\n                    const int j = it->second;\n     \
    \               if(x[i] - x[j] < y[i] - y[j]) {\n                        break;\n\
    \                    }\n                    ret.emplace_back(i, j, -1, std::abs(x[i]\
    \ - x[j]) + std::abs(y[i] - y[j]));\n                }\n                idx[-y[i]]\
    \ = i;\n            }\n            x.swap(y);\n        }\n        for(const auto\
    \ i: std::views::iota(0, std::ssize(x))) {\n            x[i] *= -1;\n        }\n\
    \    }\n    return ret;\n}\n}\n\n/**\n * @brief Manhattan MST\n * @see https://ei1333.github.io/library/graph/mst/manhattan-mst.hpp\n\
    \ */\n"
  code: "#pragma once\n\n#include <cassert>\n#include <map>\n#include <numeric>\n\
    #include <ranges>\n#include \"C++/graph/mst/MST.hpp\"\nnamespace man {\ntemplate\
    \ <class T> inline std::vector<edge> manhattan(std::vector<T> x, std::vector<T>\
    \ y) noexcept {\n    assert(std::ssize(x) == std::ssize(y));\n    std::vector<edge>\
    \ ret;\n    std::vector<int> id(std::ssize(x));\n    std::iota(id.begin(), id.end(),\
    \ 0);\n    for([[maybe_unused]] const auto _: std::views::iota(0, 2)) {\n    \
    \    for([[maybe_unused]] const auto _: std::views::iota(0, 2)) {\n          \
    \  std::ranges::sort(id, [&](const int i, const int j) -> bool { return x[i] +\
    \ y[i] < x[j] + y[j]; });\n            std::map<T, int> idx;\n            for(const\
    \ auto i: id) {\n                for(auto it = idx.lower_bound(-y[i]); it != idx.end();\
    \ it = idx.erase(it)) {\n                    const int j = it->second;\n     \
    \               if(x[i] - x[j] < y[i] - y[j]) {\n                        break;\n\
    \                    }\n                    ret.emplace_back(i, j, -1, std::abs(x[i]\
    \ - x[j]) + std::abs(y[i] - y[j]));\n                }\n                idx[-y[i]]\
    \ = i;\n            }\n            x.swap(y);\n        }\n        for(const auto\
    \ i: std::views::iota(0, std::ssize(x))) {\n            x[i] *= -1;\n        }\n\
    \    }\n    return ret;\n}\n}\n\n/**\n * @brief Manhattan MST\n * @see https://ei1333.github.io/library/graph/mst/manhattan-mst.hpp\n\
    \ */"
  dependsOn:
  - C++/graph/mst/MST.hpp
  - C++/graph/edge.hpp
  isVerificationFile: false
  path: C++/graph/mst/manhattan.hpp
  requiredBy: []
  timestamp: '2025-06-06 22:43:06+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/manhattan.test.cpp
documentation_of: C++/graph/mst/manhattan.hpp
layout: document
redirect_from:
- /library/C++/graph/mst/manhattan.hpp
- /library/C++/graph/mst/manhattan.hpp.html
title: Manhattan MST
---
