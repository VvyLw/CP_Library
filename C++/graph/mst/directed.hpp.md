---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/SkewHeap.hpp
    title: SkewHeap
  - icon: ':heavy_check_mark:'
    path: C++/graph/edge.hpp
    title: Edge
  - icon: ':heavy_check_mark:'
    path: C++/graph/mst/MST.hpp
    title: "\u6700\u5C0F\u5168\u57DF\u6728"
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/directed.test.cpp
    title: test/directed.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: Directed MST
    links:
    - https://ei1333.github.io/library/graph/mst/directed-mst.hpp
  bundledCode: "#line 2 \"C++/graph/mst/directed.hpp\"\n\n#line 2 \"C++/graph/mst/MST.hpp\"\
    \n\n#include <vector>\n#line 2 \"C++/graph/edge.hpp\"\n\nstruct edge {\n    int\
    \ src, to, id;\n    long long cost;\n    edge(){}\n    edge(const int src_, const\
    \ int to_, const int id_ = -1, const long long cost_ = 0): src(src_), to(to_),\
    \ id(id_), cost(cost_){}\n    operator int() const { return to; }\n};\n\n/**\n\
    \ * @brief Edge\n */\n#line 5 \"C++/graph/mst/MST.hpp\"\nstruct MST {\n    std::vector<edge>\
    \ tree;\n    long long cost;\n};\n\n/**\n * @brief \u6700\u5C0F\u5168\u57DF\u6728\
    \n */\n#line 2 \"C++/SkewHeap.hpp\"\n\n#pragma GCC diagnostic ignored \"-Wreorder\"\
    \n\n#include <cassert>\n#include <algorithm>\ntemplate <bool is_min = true> struct\
    \ SkewHeap {\n    struct Node {\n        long long key, lazy;\n        Node *l,\
    \ *r;\n        int idx;\n        explicit Node(const long long &key, const int\
    \ idx): key(key), idx(idx), lazy(0), l(nullptr), r(nullptr){}\n    };\nprivate:\n\
    \    Node *alloc(const long long &key, int idx = -1) {\n        return new Node(key,\
    \ idx);\n    }\n    Node *propagate(Node *t) {\n        if(t && t -> lazy != 0)\
    \ {\n            if(t -> l) {\n                t -> l -> lazy += t -> lazy;\n\
    \            }\n            if(t -> r) {\n                t -> r -> lazy += t\
    \ -> lazy;\n            }\n            t -> key += t -> lazy;\n            t ->\
    \ lazy = 0;\n        }\n        return t;\n    }\npublic:\n    SkewHeap(){}\n\
    \    Node *meld(Node *x, Node *y) {\n        propagate(x), propagate(y);\n   \
    \     if(!x || !y) {\n            return x ? x : y;\n        }\n        if((x\
    \ -> key < y -> key) ^ is_min) {\n            std::swap(x, y);\n        }\n  \
    \      x -> r = meld(y, x -> r);\n        std::swap(x -> l, x -> r);\n       \
    \ return x;\n    }\n    Node *push(Node *t, const long long &key, int idx = -1){\
    \ return meld(t, alloc(key, idx)); }\n    Node *pop(Node *t) {\n        assert(t);\n\
    \        return meld(t -> l, t -> r);\n    }\n    Node *add(Node *t, const long\
    \ long &lazy) {\n        if(t) {\n            t -> lazy += lazy;\n           \
    \ propagate(t);\n        }\n        return t;\n    }\n};\n\n/**\n * @brief SkewHeap\n\
    \ * @see https://ei1333.github.io/library/structure/heap/skew-heap.hpp\n */\n\
    #line 5 \"C++/graph/mst/directed.hpp\"\ninline MST directed(std::vector<edge>\
    \ edges, const int n, const int v) {\n    for(int i = 0; i < n; ++i) {\n     \
    \   if(i != v) {\n            edges.emplace_back(i, v, 0);\n        }\n    }\n\
    \    int x = 0;\n    std::vector<int> par(2 * n, -1), vis(par), link(par), st;\n\
    \    using Node = typename SkewHeap<>::Node;\n    SkewHeap heap;\n    std::vector<Node*>\
    \ ins(2 * n, nullptr);\n    for(size_t i = 0; i < edges.size(); ++i) {\n     \
    \   const auto &e = edges[i];\n        ins[e] = heap.push(ins[e], e.cost, i);\n\
    \    }\n    const auto go = [&](int z) -> int {\n        z = edges[ins[z] -> idx].src;\n\
    \        while(link[z] != -1) {\n            st.emplace_back(z);\n           \
    \ z = link[z];\n        }\n        for(const auto &p : st) {\n            link[p]\
    \ = z;\n        }\n        st.clear();\n        return z;\n    };\n    for(int\
    \ i = n; ins[x]; ++i) {\n        while(vis[x] == -1) {\n            vis[x] = 0;\n\
    \            x = go(x);\n        }\n        while(x != i) {\n            const\
    \ auto w = ins[x] -> key;\n            auto z = heap.pop(ins[x]);\n          \
    \  z = heap.add(z, -w);\n            ins[i] = heap.meld(ins[i], z);\n        \
    \    par[x] = i;\n            link[x] = i;\n            x = go(x);\n        }\n\
    \        while(ins[x] && go(x) == x) {\n            ins[x] = heap.pop(ins[x]);\n\
    \        }\n    }\n    for(int i = v; i != -1; i = par[i]) {\n\t\tvis[i] = 1;\n\
    \t}\n    long long cost = 0;\n    std::vector<edge> e;\n    for(int i = x; i >=\
    \ 0; i--) {\n\t\tif(vis[i] == 1) {\n\t\t\tcontinue;\n\t\t}\n        cost += edges[ins[i]\
    \ -> idx].cost;\n        e.emplace_back(edges[ins[i] -> idx]);\n        for(int\
    \ j = edges[ins[i] -> idx]; j != -1 && vis[j] == 0; j = par[j]) {\n          \
    \  vis[j] = 1;\n        }\n    }\n    return {e, cost};\n}\n\n/**\n * @brief Directed\
    \ MST\n * @see https://ei1333.github.io/library/graph/mst/directed-mst.hpp\n */\n"
  code: "#pragma once\n\n#include \"C++/graph/mst/MST.hpp\"\n#include \"C++/SkewHeap.hpp\"\
    \ninline MST directed(std::vector<edge> edges, const int n, const int v) {\n \
    \   for(int i = 0; i < n; ++i) {\n        if(i != v) {\n            edges.emplace_back(i,\
    \ v, 0);\n        }\n    }\n    int x = 0;\n    std::vector<int> par(2 * n, -1),\
    \ vis(par), link(par), st;\n    using Node = typename SkewHeap<>::Node;\n    SkewHeap\
    \ heap;\n    std::vector<Node*> ins(2 * n, nullptr);\n    for(size_t i = 0; i\
    \ < edges.size(); ++i) {\n        const auto &e = edges[i];\n        ins[e] =\
    \ heap.push(ins[e], e.cost, i);\n    }\n    const auto go = [&](int z) -> int\
    \ {\n        z = edges[ins[z] -> idx].src;\n        while(link[z] != -1) {\n \
    \           st.emplace_back(z);\n            z = link[z];\n        }\n       \
    \ for(const auto &p : st) {\n            link[p] = z;\n        }\n        st.clear();\n\
    \        return z;\n    };\n    for(int i = n; ins[x]; ++i) {\n        while(vis[x]\
    \ == -1) {\n            vis[x] = 0;\n            x = go(x);\n        }\n     \
    \   while(x != i) {\n            const auto w = ins[x] -> key;\n            auto\
    \ z = heap.pop(ins[x]);\n            z = heap.add(z, -w);\n            ins[i]\
    \ = heap.meld(ins[i], z);\n            par[x] = i;\n            link[x] = i;\n\
    \            x = go(x);\n        }\n        while(ins[x] && go(x) == x) {\n  \
    \          ins[x] = heap.pop(ins[x]);\n        }\n    }\n    for(int i = v; i\
    \ != -1; i = par[i]) {\n\t\tvis[i] = 1;\n\t}\n    long long cost = 0;\n    std::vector<edge>\
    \ e;\n    for(int i = x; i >= 0; i--) {\n\t\tif(vis[i] == 1) {\n\t\t\tcontinue;\n\
    \t\t}\n        cost += edges[ins[i] -> idx].cost;\n        e.emplace_back(edges[ins[i]\
    \ -> idx]);\n        for(int j = edges[ins[i] -> idx]; j != -1 && vis[j] == 0;\
    \ j = par[j]) {\n            vis[j] = 1;\n        }\n    }\n    return {e, cost};\n\
    }\n\n/**\n * @brief Directed MST\n * @see https://ei1333.github.io/library/graph/mst/directed-mst.hpp\n\
    \ */"
  dependsOn:
  - C++/graph/mst/MST.hpp
  - C++/graph/edge.hpp
  - C++/SkewHeap.hpp
  isVerificationFile: false
  path: C++/graph/mst/directed.hpp
  requiredBy: []
  timestamp: '2024-02-29 01:03:52+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/directed.test.cpp
documentation_of: C++/graph/mst/directed.hpp
layout: document
redirect_from:
- /library/C++/graph/mst/directed.hpp
- /library/C++/graph/mst/directed.hpp.html
title: Directed MST
---