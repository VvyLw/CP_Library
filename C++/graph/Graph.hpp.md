---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/graph/edge.hpp
    title: Edge
  _extendedRequiredBy:
  - icon: ':heavy_check_mark:'
    path: C++/graph/WeightedGraph.hpp
    title: "\u91CD\u307F\u4ED8\u304D\u30B0\u30E9\u30D5\u30E9\u30A4\u30D6\u30E9\u30EA"
  - icon: ':heavy_check_mark:'
    path: C++/graph/diameter.hpp
    title: "\u6728\u306E\u76F4\u5F84"
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/cycledetector.test.cpp
    title: test/cycledetector.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/dag_check.test.cpp
    title: test/dag_check.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/dijkstra.test.cpp
    title: test/dijkstra.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/lca.test.cpp
    title: test/lca.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/scc.test.cpp
    title: test/scc.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/scc2.test.cpp
    title: test/scc2.test.cpp
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
    document_title: "\u30B0\u30E9\u30D5\u30E9\u30A4\u30D6\u30E9\u30EA"
    links: []
  bundledCode: "#line 2 \"C++/graph/Graph.hpp\"\n\r\n#include <iostream>\r\n#include\
    \ <vector>\r\n#include <algorithm>\r\n#include <queue>\r\n#include <stack>\r\n\
    #include <ranges>\r\n#ifndef TEMPLATE\r\nnamespace man {\r\ntemplate <class T,\
    \ class U> constexpr inline bool chmin(T& a, const U& b) noexcept { if(a > b){\
    \ a = b; return true; } return false; }\r\n}\r\n#endif\r\n#line 2 \"C++/graph/edge.hpp\"\
    \n#ifndef EDGE\n#define EDGE\n#endif\n\nnamespace man {\nstruct edge {\n    int\
    \ src, to, id;\n    int64_t cost;\n    edge(){}\n    edge(const int src_, const\
    \ int to_, const int id_ = -1, const int64_t cost_ = 0): src(src_), to(to_), id(id_),\
    \ cost(cost_){}\n    constexpr inline operator int() const noexcept { return to;\
    \ }\n};\n}\n\n/**\n * @brief Edge\n */\n#line 15 \"C++/graph/Graph.hpp\"\nnamespace\
    \ man {\r\ntemplate <bool undirected = true> struct graph: std::vector<std::vector<edge>>\
    \ {\r\nprotected:\r\n    int indexed, id;\r\n    std::vector<edge> edges;\r\n\
    public:\r\n    graph(){}\r\n    graph(const int n, const int indexed_ = 1): indexed(indexed_),\
    \ id(0){ this->resize(n); }\r\n    inline void add(int a, int b) noexcept {\r\n\
    \        a -= indexed, b-= indexed;\r\n        (*this)[a].emplace_back(a, b, id);\r\
    \n        edges.emplace_back(a, b, id++);\r\n        if(undirected) {\r\n    \
    \        (*this)[b].emplace_back(b, a, --id);\r\n            edges.emplace_back(b,\
    \ a, id++);\r\n        }\r\n    }\r\n    inline void input(const int m) noexcept\
    \ {\r\n        for([[maybe_unused]] const auto _: std::views::iota(0, m)) {\r\n\
    \            int a, b;\r\n            std::cin >> a >> b;\r\n            add(a,\
    \ b);\r\n        }\r\n    }\r\n    inline std::vector<edge> get_edge() const noexcept\
    \ { return edges; }\r\n    inline std::vector<int> all_dist(const int v) noexcept\
    \ {\r\n        std::vector<int> d(this -> size(), -1);\r\n        std::queue<int>\
    \ q;\r\n        d[v] = 0;\r\n        q.emplace(v);\r\n        while(!q.empty())\
    \ {\r\n            const int tmp = q.front();\r\n            q.pop();\r\n    \
    \        for(const auto &el: (*this)[tmp]) {\r\n                if(d[el] != -1)\
    \ {\r\n                    continue;\r\n                }\r\n                d[el]\
    \ = d[tmp] + 1;\r\n                q.emplace(el);\r\n            }\r\n       \
    \ }\r\n        return d;\r\n    }\r\n    inline int dist(const int u, const int\
    \ v) noexcept { return all_dist(u)[v]; }\r\n    inline std::vector<int> t_sort()\
    \ noexcept {\r\n        const int n = this->size();\r\n\t\tstd::vector<int> deg(n);\r\
    \n\t\tfor(const auto i: std::views::iota(0, n)) {\r\n\t\t\tfor(const auto ed:\
    \ (*this)[i]) {\r\n\t\t\t\tdeg[ed]++;\r\n\t\t\t}\r\n\t\t}\r\n\t\tstd::stack<int>\
    \ sk;\r\n\t\tfor(const auto i: std::views::iota(0, n)) {\r\n\t\t\tif(deg[i] ==\
    \ 0) {\r\n\t\t\t\tsk.emplace(i);\r\n\t\t\t}\r\n\t\t}\r\n\t\tstd::vector<int> ord;\r\
    \n\t\twhile(!sk.empty()) {\r\n\t\t\tconst auto tmp = sk.top();\r\n           \
    \ sk.pop();\r\n\t\t\tord.emplace_back(tmp);\r\n\t\t\tfor(const auto ed: (*this)[tmp])\
    \ {\r\n\t\t\t\tif(--deg[ed] == 0) {\r\n\t\t\t\t\tsk.emplace(ed);\r\n\t\t\t\t}\r\
    \n\t\t\t}\r\n\t\t}\r\n\t\treturn ord.size() == size() ? ord : std::vector<int>{};\r\
    \n\t}\r\n    inline std::vector<edge> cycle() noexcept {\r\n        const int\
    \ n = size();\r\n        std::vector<int> used(n);\r\n        std::vector<edge>\
    \ pre(n), cycle;\r\n        const auto dfs = [&](const auto &f, const int i) ->\
    \ bool {\r\n            used[i] = 1;\r\n\t\t\tfor(const auto &e: (*this)[i]) {\r\
    \n\t\t\t\tif(used[e] == 0) {\r\n\t\t\t\t\tpre[e] = e;\r\n\t\t\t\t\tif(f(f, e))\
    \ {\r\n\t\t\t\t\t\treturn true;\r\n\t\t\t\t\t}\r\n\t\t\t\t} else if(used[e] ==\
    \ 1) {\r\n\t\t\t\t\tint now = i;\r\n\t\t\t\t\twhile(now != e) {\r\n\t\t\t\t\t\t\
    cycle.emplace_back(pre[now]);\r\n\t\t\t\t\t\tnow = pre[now].src;\r\n\t\t\t\t\t\
    }\r\n\t\t\t\t\tcycle.emplace_back(e);\r\n\t\t\t\t\treturn true;\r\n\t\t\t\t}\r\
    \n\t\t\t}\r\n\t\t\tused[i] = 2;\r\n\t\t\treturn false;\r\n        };\r\n     \
    \   for(int i = 0; i < n; ++i) {\r\n\t\t\tif(used[i] == 0 && dfs(dfs, i)) {\r\n\
    \t\t\t\tstd::ranges::reverse(cycle);\r\n\t\t\t\treturn cycle;\r\n\t\t\t}\r\n\t\
    \t}\r\n\t\treturn {};\r\n    }\r\n};\r\n}\r\n\r\n/**\r\n * @brief \u30B0\u30E9\
    \u30D5\u30E9\u30A4\u30D6\u30E9\u30EA\r\n */\n"
  code: "#pragma once\r\n\r\n#include <iostream>\r\n#include <vector>\r\n#include\
    \ <algorithm>\r\n#include <queue>\r\n#include <stack>\r\n#include <ranges>\r\n\
    #ifndef TEMPLATE\r\nnamespace man {\r\ntemplate <class T, class U> constexpr inline\
    \ bool chmin(T& a, const U& b) noexcept { if(a > b){ a = b; return true; } return\
    \ false; }\r\n}\r\n#endif\r\n#include \"C++/graph/edge.hpp\"\r\nnamespace man\
    \ {\r\ntemplate <bool undirected = true> struct graph: std::vector<std::vector<edge>>\
    \ {\r\nprotected:\r\n    int indexed, id;\r\n    std::vector<edge> edges;\r\n\
    public:\r\n    graph(){}\r\n    graph(const int n, const int indexed_ = 1): indexed(indexed_),\
    \ id(0){ this->resize(n); }\r\n    inline void add(int a, int b) noexcept {\r\n\
    \        a -= indexed, b-= indexed;\r\n        (*this)[a].emplace_back(a, b, id);\r\
    \n        edges.emplace_back(a, b, id++);\r\n        if(undirected) {\r\n    \
    \        (*this)[b].emplace_back(b, a, --id);\r\n            edges.emplace_back(b,\
    \ a, id++);\r\n        }\r\n    }\r\n    inline void input(const int m) noexcept\
    \ {\r\n        for([[maybe_unused]] const auto _: std::views::iota(0, m)) {\r\n\
    \            int a, b;\r\n            std::cin >> a >> b;\r\n            add(a,\
    \ b);\r\n        }\r\n    }\r\n    inline std::vector<edge> get_edge() const noexcept\
    \ { return edges; }\r\n    inline std::vector<int> all_dist(const int v) noexcept\
    \ {\r\n        std::vector<int> d(this -> size(), -1);\r\n        std::queue<int>\
    \ q;\r\n        d[v] = 0;\r\n        q.emplace(v);\r\n        while(!q.empty())\
    \ {\r\n            const int tmp = q.front();\r\n            q.pop();\r\n    \
    \        for(const auto &el: (*this)[tmp]) {\r\n                if(d[el] != -1)\
    \ {\r\n                    continue;\r\n                }\r\n                d[el]\
    \ = d[tmp] + 1;\r\n                q.emplace(el);\r\n            }\r\n       \
    \ }\r\n        return d;\r\n    }\r\n    inline int dist(const int u, const int\
    \ v) noexcept { return all_dist(u)[v]; }\r\n    inline std::vector<int> t_sort()\
    \ noexcept {\r\n        const int n = this->size();\r\n\t\tstd::vector<int> deg(n);\r\
    \n\t\tfor(const auto i: std::views::iota(0, n)) {\r\n\t\t\tfor(const auto ed:\
    \ (*this)[i]) {\r\n\t\t\t\tdeg[ed]++;\r\n\t\t\t}\r\n\t\t}\r\n\t\tstd::stack<int>\
    \ sk;\r\n\t\tfor(const auto i: std::views::iota(0, n)) {\r\n\t\t\tif(deg[i] ==\
    \ 0) {\r\n\t\t\t\tsk.emplace(i);\r\n\t\t\t}\r\n\t\t}\r\n\t\tstd::vector<int> ord;\r\
    \n\t\twhile(!sk.empty()) {\r\n\t\t\tconst auto tmp = sk.top();\r\n           \
    \ sk.pop();\r\n\t\t\tord.emplace_back(tmp);\r\n\t\t\tfor(const auto ed: (*this)[tmp])\
    \ {\r\n\t\t\t\tif(--deg[ed] == 0) {\r\n\t\t\t\t\tsk.emplace(ed);\r\n\t\t\t\t}\r\
    \n\t\t\t}\r\n\t\t}\r\n\t\treturn ord.size() == size() ? ord : std::vector<int>{};\r\
    \n\t}\r\n    inline std::vector<edge> cycle() noexcept {\r\n        const int\
    \ n = size();\r\n        std::vector<int> used(n);\r\n        std::vector<edge>\
    \ pre(n), cycle;\r\n        const auto dfs = [&](const auto &f, const int i) ->\
    \ bool {\r\n            used[i] = 1;\r\n\t\t\tfor(const auto &e: (*this)[i]) {\r\
    \n\t\t\t\tif(used[e] == 0) {\r\n\t\t\t\t\tpre[e] = e;\r\n\t\t\t\t\tif(f(f, e))\
    \ {\r\n\t\t\t\t\t\treturn true;\r\n\t\t\t\t\t}\r\n\t\t\t\t} else if(used[e] ==\
    \ 1) {\r\n\t\t\t\t\tint now = i;\r\n\t\t\t\t\twhile(now != e) {\r\n\t\t\t\t\t\t\
    cycle.emplace_back(pre[now]);\r\n\t\t\t\t\t\tnow = pre[now].src;\r\n\t\t\t\t\t\
    }\r\n\t\t\t\t\tcycle.emplace_back(e);\r\n\t\t\t\t\treturn true;\r\n\t\t\t\t}\r\
    \n\t\t\t}\r\n\t\t\tused[i] = 2;\r\n\t\t\treturn false;\r\n        };\r\n     \
    \   for(int i = 0; i < n; ++i) {\r\n\t\t\tif(used[i] == 0 && dfs(dfs, i)) {\r\n\
    \t\t\t\tstd::ranges::reverse(cycle);\r\n\t\t\t\treturn cycle;\r\n\t\t\t}\r\n\t\
    \t}\r\n\t\treturn {};\r\n    }\r\n};\r\n}\r\n\r\n/**\r\n * @brief \u30B0\u30E9\
    \u30D5\u30E9\u30A4\u30D6\u30E9\u30EA\r\n */"
  dependsOn:
  - C++/graph/edge.hpp
  isVerificationFile: false
  path: C++/graph/Graph.hpp
  requiredBy:
  - C++/graph/WeightedGraph.hpp
  - C++/graph/diameter.hpp
  timestamp: '2025-06-12 17:15:04+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/spfa.test.cpp
  - test/dag_check.test.cpp
  - test/tree_diameter.test.cpp
  - test/dijkstra.test.cpp
  - test/scc.test.cpp
  - test/shortestpath.test.cpp
  - test/warshallfloyd.test.cpp
  - test/lca.test.cpp
  - test/cycledetector.test.cpp
  - test/scc2.test.cpp
documentation_of: C++/graph/Graph.hpp
layout: document
redirect_from:
- /library/C++/graph/Graph.hpp
- /library/C++/graph/Graph.hpp.html
title: "\u30B0\u30E9\u30D5\u30E9\u30A4\u30D6\u30E9\u30EA"
---
