---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/MST.hpp
    title: "\u6700\u5C0F\u5168\u57DF\u6728"
  - icon: ':heavy_check_mark:'
    path: C++/UnionFind.hpp
    title: UnionFind
  - icon: ':heavy_check_mark:'
    path: C++/edge.hpp
    title: C++/edge.hpp
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://judge.yosupo.jp/problem/manhattanmst
    links:
    - https://judge.yosupo.jp/problem/manhattanmst
  bundledCode: "#line 1 \"test/manhattan.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/manhattanmst\"\
    \n#include <iostream>\n#line 2 \"C++/MST.hpp\"\n\n#include <cassert>\n#include\
    \ <map>\n#include <numeric>\n#line 2 \"C++/edge.hpp\"\n\nstruct edge {\n    int\
    \ src, to;\n    long long cost;\n    edge(){}\n    edge(const int to_): to(to_){}\n\
    \    edge(const int to_, const long long cost_): to(to_), cost(cost_){}\n    edge(const\
    \ int src_, const int to_, const long long cost_): src(src_), to(to_), cost(cost_){}\n\
    };\n#line 2 \"C++/UnionFind.hpp\"\n\r\n#line 4 \"C++/UnionFind.hpp\"\n#include\
    \ <vector>\r\n#include <algorithm>\r\nstruct UnionFind {\r\nprivate:\r\n    std::vector<int>\
    \ par;\r\npublic:\r\n    UnionFind(const int n): par(n, -1){}\r\n    int operator[](int\
    \ i) {\r\n        while(par[i] >= 0) {\r\n            const int p = par[par[i]];\r\
    \n            if(p < 0) return par[i];\r\n            i = par[i] = p;\r\n    \
    \    }\r\n        return i;\r\n    }\r\n    bool unite(int x, int y) {\r\n   \
    \     x = (*this)[x], y = (*this)[y];\r\n        if(x == y) return false;\r\n\
    \        if(-par[x] < -par[y]) {\r\n            std::swap(x, y);\r\n        }\r\
    \n        par[x] += par[y], par[y] = x;\r\n        return true;\r\n    }\r\n \
    \   int size(const int x) {\r\n        return -par[(*this)[x]];\r\n    }\r\n#if\
    \ __cplusplus >= 202101L\r\n    std::vector<std::vector<int>> groups() {\r\n \
    \       const int n = std::ssize(par);\r\n        std::vector<std::vector<int>>\
    \ res(n);\r\n        for(int i = 0; i < n; ++i) {\r\n            res[(*this)[i]].emplace_back(i);\r\
    \n        }\r\n        const auto it = std::ranges::remove_if(res, [&](const std::vector<int>\
    \ &v){ return v.empty(); });\r\n        res.erase(it.begin(), it.end());\r\n \
    \       return res;\r\n    }\r\n#else\r\n    std::vector<std::vector<int>> groups()\
    \ {\r\n        const int n = par.size();\r\n        std::vector<std::vector<int>>\
    \ res(n);\r\n        for(int i = 0; i < n; ++i) {\r\n            res[(*this)[i]].emplace_back(i);\r\
    \n        }\r\n        res.erase(std::remove_if(res.begin(), res.end(), [&](const\
    \ std::vector<int> &v){ return v.empty(); }), res.end());\r\n        return res;\r\
    \n    }\r\n#endif\r\n    bool is_bipartite() {\r\n        const int n = par.size()\
    \ / 2;\r\n        bool ok = true;\r\n        for(int i = 0; i < n; ++i) {\r\n\
    \            ok &= (*this)[i] != (*this)[i + n];\r\n        }\r\n        return\
    \ ok;\r\n    }\r\n};\r\n/**\r\n * @brief UnionFind\r\n * @see https://github.com/maspypy/library/blob/main/ds/unionfind/unionfind.hpp\r\
    \n */\n#line 8 \"C++/MST.hpp\"\n\nstruct MST {\n    std::vector<edge> tree;\n\
    \    long long cost;\n};\n\ninline MST kruskal(std::vector<edge> edges, const\
    \ int n) {\n    std::sort(edges.begin(), edges.end(), [&](const edge &e, const\
    \ edge &f){ return e.cost < f.cost; });\n    UnionFind uf(n);\n    std::vector<edge>\
    \ e;\n    long long res = 0;\n    for(const auto &ed: edges) {\n        if(uf.unite(ed.src,\
    \ ed.to)) {\n            e.emplace_back(ed);\n            res += ed.cost;\n  \
    \      }\n    }\n    return MST{e, res};\n}\ntemplate<bool is_min = true> struct\
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
    \ propagate(t);\n        }\n        return t;\n    }\n};\ninline MST directed(std::vector<edge>\
    \ edges, const int n, const int v) {\n    for(int i = 0; i < n; ++i) {\n     \
    \   if(i != v) {\n            edges.emplace_back(i, v, 0);\n        }\n    }\n\
    \    int x = 0;\n    std::vector<int> par(2 * n, -1), vis(par), link(par), st;\n\
    \    using Node = typename SkewHeap<>::Node;\n    SkewHeap heap;\n    std::vector<Node*>\
    \ ins(2 * n, nullptr);\n    for(size_t i = 0; i < edges.size(); ++i) {\n     \
    \   const auto &e = edges[i];\n        ins[e.to] = heap.push(ins[e.to], e.cost,\
    \ i);\n    }\n    const auto go = [&](int z) -> int {\n        z = edges[ins[z]\
    \ -> idx].src;\n        while(link[z] != -1) {\n            st.emplace_back(z);\n\
    \            z = link[z];\n        }\n        for(const auto &p : st) {\n    \
    \        link[p] = z;\n        }\n        st.clear();\n        return z;\n   \
    \ };\n    for(int i = n; ins[x]; ++i) {\n        while(vis[x] == -1) {\n     \
    \       vis[x] = 0;\n            x = go(x);\n        }\n        while(x != i)\
    \ {\n            const auto w = ins[x] -> key;\n            auto z = heap.pop(ins[x]);\n\
    \            z = heap.add(z, -w);\n            ins[i] = heap.meld(ins[i], z);\n\
    \            par[x] = i;\n            link[x] = i;\n            x = go(x);\n \
    \       }\n        while(ins[x] && go(x) == x) {\n            ins[x] = heap.pop(ins[x]);\n\
    \        }\n    }\n    for(int i = v; i != -1; i = par[i]) {\n\t\tvis[i] = 1;\n\
    \t}\n    long long cost = 0;\n    std::vector<edge> e;\n    for(int i = x; i >=\
    \ 0; i--) {\n\t\tif(vis[i] == 1) {\n\t\t\tcontinue;\n\t\t}\n        cost += edges[ins[i]\
    \ -> idx].cost;\n        e.emplace_back(edges[ins[i] -> idx]);\n        for(int\
    \ j = edges[ins[i] -> idx].to; j != -1 && vis[j] == 0; j = par[j]) {\n       \
    \     vis[j] = 1;\n        }\n    }\n    return MST{e, cost};\n}\ntemplate <class\
    \ T> inline std::vector<edge> manhattan(std::vector<T> x, std::vector<T> y) {\n\
    \    assert(x.size() == y.size());\n    std::vector<edge> res;\n    std::vector<int>\
    \ id(x.size());\n    std::iota(id.begin(), id.end(), 0);\n    for(int s = 0; s\
    \ < 2; ++s) {\n        for(int t = 0; t < 2; ++t) {\n            std::sort(id.begin(),\
    \ id.end(), [&](const int i, const int j){ return x[i] + y[i] < x[j] + y[j]; });\n\
    \            std::map<T, int> idx;\n            for(const auto i: id) {\n    \
    \            for(auto it = idx.lower_bound(-y[i]); it != idx.end(); it = idx.erase(it))\
    \ {\n                    const int j = it -> second;\n                    if(x[i]\
    \ - x[j] < y[i] - y[j]) {\n                        break;\n                  \
    \  }\n                    res.emplace_back(i, j, std::abs(x[i] - x[j]) + std::abs(y[i]\
    \ - y[j]));\n                }\n                idx[-y[i]] = i;\n            }\n\
    \            x.swap(y);\n        }\n        for(size_t i = 0; i < x.size(); ++i)\
    \ {\n            x[i] *= -1;\n        }\n    }\n    return res;\n}\n/**\n * @brief\
    \ \u6700\u5C0F\u5168\u57DF\u6728\n */\n#line 4 \"test/manhattan.test.cpp\"\nint\
    \ main() {\n    int n;\n    std::cin >> n;\n    std::vector<int> x(n), y(n);\n\
    \    for(int i = 0; i < n; ++i) {\n        std::cin >> x[i] >> y[i];\n    }\n\
    \    const auto ans = kruskal(manhattan(x, y), n);\n    std::cout << ans.cost\
    \ << '\\n';\n    for(const auto &e: ans.tree) {\n        std::cout << e.src <<\
    \ ' ' << e.to << '\\n';\n    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/manhattanmst\"\n#include\
    \ <iostream>\n#include \"C++/MST.hpp\"\nint main() {\n    int n;\n    std::cin\
    \ >> n;\n    std::vector<int> x(n), y(n);\n    for(int i = 0; i < n; ++i) {\n\
    \        std::cin >> x[i] >> y[i];\n    }\n    const auto ans = kruskal(manhattan(x,\
    \ y), n);\n    std::cout << ans.cost << '\\n';\n    for(const auto &e: ans.tree)\
    \ {\n        std::cout << e.src << ' ' << e.to << '\\n';\n    }\n}"
  dependsOn:
  - C++/MST.hpp
  - C++/edge.hpp
  - C++/UnionFind.hpp
  isVerificationFile: true
  path: test/manhattan.test.cpp
  requiredBy: []
  timestamp: '2024-01-30 14:40:09+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/manhattan.test.cpp
layout: document
redirect_from:
- /verify/test/manhattan.test.cpp
- /verify/test/manhattan.test.cpp.html
title: test/manhattan.test.cpp
---
