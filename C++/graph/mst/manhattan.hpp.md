---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/graph/edge.hpp
    title: Edge
  - icon: ':heavy_check_mark:'
    path: C++/graph/mst/MST.hpp
    title: "\u6700\u5C0F\u5168\u57DF\u6728"
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    document_title: Manhattan MST
    links:
    - https://ei1333.github.io/library/graph/mst/manhattan-mst.hpp
  bundledCode: "#line 2 \"C++/graph/mst/manhattan.hpp\"\n\n#include <cassert>\n#include\
    \ <map>\n#include <numeric>\n#line 2 \"C++/graph/mst/MST.hpp\"\n\n#include <vector>\n\
    #line 2 \"C++/graph/edge.hpp\"\n\nstruct edge {\n    int src, to, id;\n    long\
    \ long cost;\n    edge(){}\n    edge(const int src_, const int to_, const int\
    \ id_ = -1, const long long cost_ = 0): src(src_), to(to_), id(id_), cost(cost_){}\n\
    \    operator int() const { return to; }\n};\n\n/**\n * @brief Edge\n */\n#line\
    \ 5 \"C++/graph/mst/MST.hpp\"\nstruct MST {\n    std::vector<edge> tree;\n   \
    \ long long cost;\n};\n\n/**\n * @brief \u6700\u5C0F\u5168\u57DF\u6728\n */\n\
    #line 7 \"C++/graph/mst/manhattan.hpp\"\ntemplate <class T> inline std::vector<edge>\
    \ manhattan(std::vector<T> x, std::vector<T> y) {\n    assert(x.size() == y.size());\n\
    \    std::vector<edge> res;\n    std::vector<int> id(x.size());\n    std::iota(id.begin(),\
    \ id.end(), 0);\n    for(int s = 0; s < 2; ++s) {\n        for(int t = 0; t <\
    \ 2; ++t) {\n            std::sort(id.begin(), id.end(), [&](const int i, const\
    \ int j){ return x[i] + y[i] < x[j] + y[j]; });\n            std::map<T, int>\
    \ idx;\n            for(const auto i: id) {\n                for(auto it = idx.lower_bound(-y[i]);\
    \ it != idx.end(); it = idx.erase(it)) {\n                    const int j = it\
    \ -> second;\n                    if(x[i] - x[j] < y[i] - y[j]) {\n          \
    \              break;\n                    }\n                    res.emplace_back(i,\
    \ j, -1, std::abs(x[i] - x[j]) + std::abs(y[i] - y[j]));\n                }\n\
    \                idx[-y[i]] = i;\n            }\n            x.swap(y);\n    \
    \    }\n        for(size_t i = 0; i < x.size(); ++i) {\n            x[i] *= -1;\n\
    \        }\n    }\n    return res;\n}\n\n/**\n * @brief Manhattan MST\n * @see\
    \ https://ei1333.github.io/library/graph/mst/manhattan-mst.hpp\n */\n"
  code: "#pragma once\n\n#include <cassert>\n#include <map>\n#include <numeric>\n\
    #include \"C++/graph/mst/MST.hpp\"\ntemplate <class T> inline std::vector<edge>\
    \ manhattan(std::vector<T> x, std::vector<T> y) {\n    assert(x.size() == y.size());\n\
    \    std::vector<edge> res;\n    std::vector<int> id(x.size());\n    std::iota(id.begin(),\
    \ id.end(), 0);\n    for(int s = 0; s < 2; ++s) {\n        for(int t = 0; t <\
    \ 2; ++t) {\n            std::sort(id.begin(), id.end(), [&](const int i, const\
    \ int j){ return x[i] + y[i] < x[j] + y[j]; });\n            std::map<T, int>\
    \ idx;\n            for(const auto i: id) {\n                for(auto it = idx.lower_bound(-y[i]);\
    \ it != idx.end(); it = idx.erase(it)) {\n                    const int j = it\
    \ -> second;\n                    if(x[i] - x[j] < y[i] - y[j]) {\n          \
    \              break;\n                    }\n                    res.emplace_back(i,\
    \ j, -1, std::abs(x[i] - x[j]) + std::abs(y[i] - y[j]));\n                }\n\
    \                idx[-y[i]] = i;\n            }\n            x.swap(y);\n    \
    \    }\n        for(size_t i = 0; i < x.size(); ++i) {\n            x[i] *= -1;\n\
    \        }\n    }\n    return res;\n}\n\n/**\n * @brief Manhattan MST\n * @see\
    \ https://ei1333.github.io/library/graph/mst/manhattan-mst.hpp\n */"
  dependsOn:
  - C++/graph/mst/MST.hpp
  - C++/graph/edge.hpp
  isVerificationFile: false
  path: C++/graph/mst/manhattan.hpp
  requiredBy: []
  timestamp: '2024-02-19 13:17:33+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/graph/mst/manhattan.hpp
layout: document
redirect_from:
- /library/C++/graph/mst/manhattan.hpp
- /library/C++/graph/mst/manhattan.hpp.html
title: Manhattan MST
---
