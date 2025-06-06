---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: C++/graph/edge.hpp
    title: Edge
  - icon: ':heavy_check_mark:'
    path: C++/graph/mst/MST.hpp
    title: "\u6700\u5C0F\u5168\u57DF\u6728"
  - icon: ':heavy_check_mark:'
    path: C++/graph/mst/directed.hpp
    title: Directed MST
  - icon: ':heavy_check_mark:'
    path: C++/other/SkewHeap.hpp
    title: SkewHeap
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://onlinejudge.u-aizu.ac.jp/problems/GRL_2_B
    links:
    - https://onlinejudge.u-aizu.ac.jp/problems/GRL_2_B
  bundledCode: "#line 1 \"test/directed.test.cpp\"\n#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/problems/GRL_2_B\"\
    \n#include <iostream>\n#line 2 \"C++/graph/mst/directed.hpp\"\n\n#include <ranges>\n\
    #line 2 \"C++/graph/mst/MST.hpp\"\n\n#include <vector>\n#line 2 \"C++/graph/edge.hpp\"\
    \n#ifndef EDGE\n#define EDGE\n#endif\n\nnamespace man {\nstruct edge {\n    int\
    \ src, to, id;\n    int64_t cost;\n    edge(){}\n    edge(const int src_, const\
    \ int to_, const int id_ = -1, const int64_t cost_ = 0): src(src_), to(to_), id(id_),\
    \ cost(cost_){}\n    constexpr inline operator int() const noexcept { return to;\
    \ }\n};\n}\n\n/**\n * @brief Edge\n */\n#line 5 \"C++/graph/mst/MST.hpp\"\nstruct\
    \ MST {\n    std::vector<man::edge> tree;\n    int64_t cost;\n};\n\n/**\n * @brief\
    \ \u6700\u5C0F\u5168\u57DF\u6728\n */\n#line 2 \"C++/other/SkewHeap.hpp\"\n\n\
    #pragma GCC diagnostic ignored \"-Wreorder\"\n\n#include <cassert>\n#include <algorithm>\n\
    namespace man {\nnamespace internal {\ntemplate <bool is_min = true> struct SkewHeap\
    \ {\n    struct Node {\n        long long key, lazy;\n        Node *l, *r;\n \
    \       int idx;\n        explicit Node(const long long &key, const int idx):\
    \ key(key), idx(idx), lazy(0), l(nullptr), r(nullptr){}\n    };\nprivate:\n  \
    \  Node *alloc(const long long &key, int idx = -1) {\n        return new Node(key,\
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
    \ propagate(t);\n        }\n        return t;\n    }\n};\n}\n}\n\n/**\n * @brief\
    \ SkewHeap\n * @see https://ei1333.github.io/library/structure/heap/skew-heap.hpp\n\
    \ */\n#line 6 \"C++/graph/mst/directed.hpp\"\nnamespace man {\ninline MST directed(std::vector<man::edge>\
    \ edges, const int n, const int v) noexcept {\n    for(const auto i: std::views::iota(0,\
    \ n)) {\n        if(i != v) {\n            edges.emplace_back(i, v, 0);\n    \
    \    }\n    }\n    int x = 0;\n    std::vector<int> par(2 * n, -1), vis(par),\
    \ link(par), st;\n    using Node = typename internal::SkewHeap<>::Node;\n    internal::SkewHeap\
    \ heap;\n    std::vector<Node*> ins(2 * n, nullptr);\n    for(const auto i: std::views::iota(0,\
    \ std::ssize(edges))) {\n        const auto &e = edges[i];\n        ins[e] = heap.push(ins[e],\
    \ e.cost, i);\n    }\n    const auto go = [&](int z) -> int {\n        z = edges[ins[z]->idx].src;\n\
    \        while(link[z] != -1) {\n            st.emplace_back(z);\n           \
    \ z = link[z];\n        }\n        for(const auto &p: st) {\n            link[p]\
    \ = z;\n        }\n        st.clear();\n        return z;\n    };\n    for(int\
    \ i = n; ins[x] != 0; ++i) {\n        while(vis[x] == -1) {\n            vis[x]\
    \ = 0;\n            x = go(x);\n        }\n        while(x != i) {\n         \
    \   const auto w = ins[x] -> key;\n            auto z = heap.pop(ins[x]);\n  \
    \          z = heap.add(z, -w);\n            ins[i] = heap.meld(ins[i], z);\n\
    \            par[x] = i;\n            link[x] = i;\n            x = go(x);\n \
    \       }\n        while(ins[x] && go(x) == x) {\n            ins[x] = heap.pop(ins[x]);\n\
    \        }\n    }\n    for(int i = v; i != -1; i = par[i]) {\n\t\tvis[i] = 1;\n\
    \t}\n    int64_t cost = 0;\n    std::vector<man::edge> e;\n    for(int i = x;\
    \ i >= 0; i--) {\n\t\tif(vis[i] == 1) {\n\t\t\tcontinue;\n\t\t}\n        cost\
    \ += edges[ins[i] -> idx].cost;\n        e.emplace_back(edges[ins[i] -> idx]);\n\
    \        for(int j = edges[ins[i] -> idx]; j != -1 && vis[j] == 0; j = par[j])\
    \ {\n            vis[j] = 1;\n        }\n    }\n    return {e, cost};\n}\n}\n\n\
    /**\n * @brief Directed MST\n * @see https://ei1333.github.io/library/graph/mst/directed-mst.hpp\n\
    \ */\n#line 4 \"test/directed.test.cpp\"\nint main() {\n    int v, e, r;\n   \
    \ std::cin >> v >> e >> r;\n    std::vector<man::edge> edges;\n    while(e--)\
    \ {\n        int s, t, w;\n        std::cin >> s >> t >> w;\n        edges.emplace_back(s,\
    \ t, -1, w);\n    }\n    std::cout << man::directed(edges, v, r).cost << '\\n';\n\
    }\n"
  code: "#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/problems/GRL_2_B\"\n#include\
    \ <iostream>\n#include \"C++/graph/mst/directed.hpp\"\nint main() {\n    int v,\
    \ e, r;\n    std::cin >> v >> e >> r;\n    std::vector<man::edge> edges;\n   \
    \ while(e--) {\n        int s, t, w;\n        std::cin >> s >> t >> w;\n     \
    \   edges.emplace_back(s, t, -1, w);\n    }\n    std::cout << man::directed(edges,\
    \ v, r).cost << '\\n';\n}"
  dependsOn:
  - C++/graph/mst/directed.hpp
  - C++/graph/mst/MST.hpp
  - C++/graph/edge.hpp
  - C++/other/SkewHeap.hpp
  isVerificationFile: true
  path: test/directed.test.cpp
  requiredBy: []
  timestamp: '2025-06-06 22:43:22+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/directed.test.cpp
layout: document
redirect_from:
- /verify/test/directed.test.cpp
- /verify/test/directed.test.cpp.html
title: test/directed.test.cpp
---
