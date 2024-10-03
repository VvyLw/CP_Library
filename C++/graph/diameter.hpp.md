---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: C++/graph/Graph.hpp
    title: "\u30B0\u30E9\u30D5\u30E9\u30A4\u30D6\u30E9\u30EA"
  - icon: ':question:'
    path: C++/graph/ShortestPath.hpp
    title: "\u6700\u77ED\u8DEF"
  - icon: ':question:'
    path: C++/graph/WeightedGraph.hpp
    title: "\u91CD\u307F\u4ED8\u304D\u30B0\u30E9\u30D5\u30E9\u30A4\u30D6\u30E9\u30EA"
  - icon: ':question:'
    path: C++/graph/edge.hpp
    title: Edge
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/tree_diameter.test.cpp
    title: test/tree_diameter.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: "\u6728\u306E\u76F4\u5F84"
    links:
    - https://ei1333.github.io/library/graph/tree/tree-diameter.hpp
  bundledCode: "#line 2 \"C++/graph/diameter.hpp\"\n\n#line 2 \"C++/graph/WeightedGraph.hpp\"\
    \n\n#line 2 \"C++/graph/Graph.hpp\"\n\r\n#include <iostream>\r\n#include <vector>\r\
    \n#include <algorithm>\r\n#include <queue>\r\n#include <stack>\r\n#ifndef TEMPLATE\r\
    \ntemplate <class T, class U> bool chmin(T& a, const U& b){ if(a>b){ a=b; return\
    \ 1; } return 0; }\r\n#endif\r\n#line 2 \"C++/graph/edge.hpp\"\n\nstruct edge\
    \ {\n    int src, to, id;\n    long long cost;\n    edge(){}\n    edge(const int\
    \ src_, const int to_, const int id_ = -1, const long long cost_ = 0): src(src_),\
    \ to(to_), id(id_), cost(cost_){}\n    operator int() const { return to; }\n};\n\
    \n/**\n * @brief Edge\n */\n#line 12 \"C++/graph/Graph.hpp\"\ntemplate <bool undirected\
    \ = true> struct graph: std::vector<std::vector<edge>> {\r\nprotected:\r\n   \
    \ int indexed, id;\r\n    std::vector<edge> edges;\r\npublic:\r\n    graph(){}\r\
    \n    graph(const int n, const int indexed_ = 1): indexed(indexed_), id(0){ this\
    \ -> resize(n); }\r\n    void add(int a, int b) {\r\n        a -= indexed, b-=\
    \ indexed;\r\n        (*this)[a].emplace_back(a, b, id);\r\n        edges.emplace_back(a,\
    \ b, id++);\r\n        if(undirected) {\r\n            (*this)[b].emplace_back(b,\
    \ a, --id);\r\n            edges.emplace_back(b, a, id++);\r\n        }\r\n  \
    \  }\r\n    void input(const int m) {\r\n        for(int i = 0; i < m; ++i) {\r\
    \n            int a, b;\r\n            std::cin >> a >> b;\r\n            add(a,\
    \ b);\r\n        }\r\n    }\r\n    std::vector<edge> get_edge() const { return\
    \ edges; }\r\n    std::vector<int> all_dist(const int v) {\r\n        std::vector<int>\
    \ d(this -> size(), -1);\r\n        std::queue<int> q;\r\n        d[v] = 0;\r\n\
    \        q.emplace(v);\r\n        while(q.size()) {\r\n            const int tmp\
    \ = q.front();\r\n            q.pop();\r\n            for(const auto &el: (*this)[tmp])\
    \ {\r\n                if(d[el] != -1) {\r\n                    continue;\r\n\
    \                }\r\n                d[el] = d[tmp] + 1;\r\n                q.emplace(el);\r\
    \n            }\r\n        }\r\n        return d;\r\n    }\r\n    int dist(const\
    \ int u, const int v){ return all_dist(u)[v]; }\r\n    std::vector<int> t_sort()\
    \ {\r\n        const int n = this -> size();\r\n\t\tstd::vector<int> deg(n);\r\
    \n\t\tfor(int i = 0; i < n; ++i) {\r\n\t\t\tfor(const auto ed: (*this)[i]) {\r\
    \n\t\t\t\tdeg[ed]++;\r\n\t\t\t}\r\n\t\t}\r\n\t\tstd::stack<int> sk;\r\n\t\tfor(int\
    \ i = 0; i < n; ++i) {\r\n\t\t\tif(deg[i] == 0) {\r\n\t\t\t\tsk.emplace(i);\r\n\
    \t\t\t}\r\n\t\t}\r\n\t\tstd::vector<int> ord;\r\n\t\twhile(sk.size()) {\r\n\t\t\
    \tconst auto tmp = sk.top();\r\n            sk.pop();\r\n\t\t\tord.emplace_back(tmp);\r\
    \n\t\t\tfor(const auto ed: (*this)[tmp]) {\r\n\t\t\t\tif(--deg[ed] == 0) {\r\n\
    \t\t\t\t\tsk.emplace(ed);\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t}\r\n\t\treturn ord.size()\
    \ == size() ? ord : std::vector<int>{};\r\n\t}\r\n    std::vector<edge> cycle()\
    \ {\r\n        const int n = size();\r\n        std::vector<int> used(n);\r\n\
    \        std::vector<edge> pre(n), cycle;\r\n        const auto dfs = [&](const\
    \ auto &f, const int i) -> bool {\r\n            used[i] = 1;\r\n\t\t\tfor(const\
    \ auto &e: (*this)[i]) {\r\n\t\t\t\tif(used[e] == 0) {\r\n\t\t\t\t\tpre[e] = e;\r\
    \n\t\t\t\t\tif(f(f, e)) {\r\n\t\t\t\t\t\treturn true;\r\n\t\t\t\t\t}\r\n\t\t\t\
    \t} else if(used[e] == 1) {\r\n\t\t\t\t\tint now = i;\r\n\t\t\t\t\twhile(now !=\
    \ e) {\r\n\t\t\t\t\t\tcycle.emplace_back(pre[now]);\r\n\t\t\t\t\t\tnow = pre[now].src;\r\
    \n\t\t\t\t\t}\r\n\t\t\t\t\tcycle.emplace_back(e);\r\n\t\t\t\t\treturn true;\r\n\
    \t\t\t\t}\r\n\t\t\t}\r\n\t\t\tused[i] = 2;\r\n\t\t\treturn false;\r\n        };\r\
    \n        for(int i = 0; i < n; ++i) {\r\n\t\t\tif(used[i] == 0 && dfs(dfs, i))\
    \ {\r\n\t\t\t\tstd::reverse(cycle.begin(), cycle.end());\r\n\t\t\t\treturn cycle;\r\
    \n\t\t\t}\r\n\t\t}\r\n\t\treturn {};\r\n    }\r\n};\r\ntypedef std::vector<edge>\
    \ ve;\r\ntypedef std::vector<ve> we;\r\n\r\n/**\r\n * @brief \u30B0\u30E9\u30D5\
    \u30E9\u30A4\u30D6\u30E9\u30EA\r\n */\n#line 2 \"C++/graph/ShortestPath.hpp\"\n\
    \n#pragma GCC diagnostic ignored \"-Wreorder\"\n\n#line 7 \"C++/graph/ShortestPath.hpp\"\
    \nstruct ShortestPath {\nprivate:\n    const std::vector<long long> cost;\n  \
    \  const std::vector<int> src;\npublic:\n    ShortestPath(const std::vector<long\
    \ long> &cost, const std::vector<int> &src): cost(cost), src(src){}\n    bool\
    \ is_thru(const int i){ return src[i] != -1; }\n    std::vector<int> path(int\
    \ i) {\n        std::vector<int> res;\n        for(; i != -1; i = src[i]) {\n\
    \            res.emplace_back(i);\n        }\n        std::ranges::reverse(res);\n\
    \        return res;\n    }\n    std::vector<long long> get() const { return cost;\
    \ }\n};\n\n/**\n * @brief \u6700\u77ED\u8DEF\n */\n#line 5 \"C++/graph/WeightedGraph.hpp\"\
    \ntemplate <bool undirected = true> struct w_graph: graph<undirected> {\nprotected:\n\
    \    using graph<undirected>::indexed;\n    using graph<undirected>::id;\n   \
    \ using graph<undirected>::edges;\npublic:\n    w_graph(const int n, const int\
    \ indexed_ = 1): graph<undirected>(n, indexed_){}\n    using graph<undirected>::get_edge;\n\
    \    using graph<undirected>::all_dist;\n    using graph<undirected>::dist;\n\
    \    using graph<undirected>::t_sort;\n    using graph<undirected>::cycle;\n \
    \   void add(int a, int b, const long long cost) {\n        a -= indexed, b -=\
    \ indexed;\n        (*this)[a].emplace_back(a, b, id, cost);\n        edges.emplace_back(a,\
    \ b, id++, cost);\n        if(undirected) {\n            (*this)[b].emplace_back(b,\
    \ a, --id, cost);\n            edges.emplace_back(b, a, id++, cost);\n       \
    \ }\n    }\n    void input(const int m) {\n        for(int i = 0; i < m; ++i)\
    \ {\n            int a, b;\n            long long c;\n            std::cin >>\
    \ a >> b >> c;\n            add(a, b, c);\n        }\n    }\n    ShortestPath\
    \ dijkstra(const int v) {\n        std::vector<long long> cst(this -> size(),\
    \ (1LL << 61) - 1);\n        std::vector<int> src(this -> size(), -1);\n     \
    \   std::priority_queue<std::pair<long long, int>, std::vector<std::pair<long\
    \ long, int>>, std::greater<std::pair<long long, int>>> dj;\n        cst[v] =\
    \ 0;\n        dj.emplace(cst[v], v);\n        while(dj.size()) {\n           \
    \ const auto tmp = dj.top();\n            dj.pop();\n            if(cst[tmp.second]\
    \ < tmp.first) {\n                continue;\n            }\n            for(const\
    \ auto &el: (*this)[tmp.second]) {\n                if(chmin(cst[el], tmp.first\
    \ + el.cost)) {\n                    src[el] = tmp.second;\n                 \
    \   dj.emplace(cst[el], el);\n                }\n            }\n        }\n  \
    \      return {cst, src};\n    }\n    std::vector<long long> spfa(const int v)\
    \ {\n        const int n = this -> size();\n        std::vector<long long> cst(n,\
    \ (1LL << 61) - 1);\n        std::vector<int> pending(n), times(n);\n        std::queue<int>\
    \ q;\n        q.emplace(v);\n        pending[v] = 1;\n        ++times[v];\n  \
    \      cst[v] = 0;\n        while(!q.empty()) {\n            const int p = q.front();\n\
    \            q.pop();\n            pending[p] = 0;\n            for(const auto\
    \ &e : (*this)[p]) {\n                const long long next = cst[p] + e.cost;\n\
    \                if(next >= cst[e]) {\n                    continue;\n       \
    \         }\n                cst[e] = next;\n                if(!pending[e]) {\n\
    \                    if(++times[e] >= n) {\n                        cst.clear();\n\
    \                        return cst;\n                    }\n                \
    \    pending[e] = 1;\n                    q.emplace(e);\n                }\n \
    \           }\n        }\n\t\treturn cst;\n    }\n    std::vector<std::vector<long\
    \ long>> warshall_floyd() {\n\t\tconst int n = this -> size();\n        const\
    \ long long lim = (1LL << 61) - 1;\n\t\tstd::vector cst(n, std::vector(n, lim));\n\
    \t\tfor(int i = 0; i < n; ++i) {\n            cst[i][i] = 0;\n        }\n\t\t\
    for(int i = 0; i < n; ++i) {\n            for(const auto &j: (*this)[i]) {\n \
    \               cst[i][j] = j.cost;\n            }\n        }\n\t\tfor(int k =\
    \ 0; k < n; ++k) {\n            for(int i = 0; i < n; ++i) {\n               \
    \ for(int j = 0; j < n; ++j) {\n                    if(cst[i][k] == lim || cst[k][j]\
    \ == lim) {\n                        continue;\n                    }\n      \
    \              chmin(cst[i][j], cst[i][k] + cst[k][j]);\n                }\n \
    \           }\n        }\n\t\treturn cst;\n\t}\n};\n\n/**\n * @brief \u91CD\u307F\
    \u4ED8\u304D\u30B0\u30E9\u30D5\u30E9\u30A4\u30D6\u30E9\u30EA\n */\n#line 4 \"\
    C++/graph/diameter.hpp\"\n#ifndef TEMPLATE\ntemplate <class T, class U> inline\
    \ bool chmax(T& a, const U& b){ if(a<b){ a=b; return 1; } return 0; }\n#endif\n\
    template <bool undirected=true> struct diameter: w_graph<undirected> {\nprivate:\n\
    \    using w_graph<undirected>::indexed;\n    using w_graph<undirected>::id;\n\
    \    using w_graph<undirected>::edges;\n    std::vector<int> to;\n    std::vector<edge>\
    \ path;\n    std::pair<int64_t, int> dfs(const int i, const int par) {\n     \
    \   std::pair<int64_t, int> ret(0, i);\n        for(const auto &e: (*this)[i])\
    \ {\n            if(e == par) {\n                continue;\n            }\n  \
    \          auto cost = dfs(e, i);\n            cost.first += e.cost;\n       \
    \     if(chmax(ret, cost)) {\n                to[i] = e;\n            }\n    \
    \    }\n        return ret;\n    }\npublic:\n    diameter(const int n, const int\
    \ id = 1): w_graph<undirected>(n, id), to(n, -1){}\n    using w_graph<undirected>::add;\n\
    \    using w_graph<undirected>::input;\n    using w_graph<undirected>::get_edge;\
    \    \n    int64_t build() {\n        const auto p = dfs(0, -1);\n        const\
    \ auto q = dfs(p.second, -1);\n        int now = p.second;\n        while(now\
    \ != q.second) {\n            for(const auto &e: (*this)[now]) {\n           \
    \     if(to[now] == e) {\n                    path.emplace_back(e);\n        \
    \        }\n            }\n            now = to[now];\n        }\n        return\
    \ q.first;\n    }\n    std::vector<edge> get_path() const { return path; }\n};\n\
    \n/**\n * @brief \u6728\u306E\u76F4\u5F84\n * @see https://ei1333.github.io/library/graph/tree/tree-diameter.hpp\n\
    \ */\n"
  code: "#pragma once\n\n#include \"C++/graph/WeightedGraph.hpp\"\n#ifndef TEMPLATE\n\
    template <class T, class U> inline bool chmax(T& a, const U& b){ if(a<b){ a=b;\
    \ return 1; } return 0; }\n#endif\ntemplate <bool undirected=true> struct diameter:\
    \ w_graph<undirected> {\nprivate:\n    using w_graph<undirected>::indexed;\n \
    \   using w_graph<undirected>::id;\n    using w_graph<undirected>::edges;\n  \
    \  std::vector<int> to;\n    std::vector<edge> path;\n    std::pair<int64_t, int>\
    \ dfs(const int i, const int par) {\n        std::pair<int64_t, int> ret(0, i);\n\
    \        for(const auto &e: (*this)[i]) {\n            if(e == par) {\n      \
    \          continue;\n            }\n            auto cost = dfs(e, i);\n    \
    \        cost.first += e.cost;\n            if(chmax(ret, cost)) {\n         \
    \       to[i] = e;\n            }\n        }\n        return ret;\n    }\npublic:\n\
    \    diameter(const int n, const int id = 1): w_graph<undirected>(n, id), to(n,\
    \ -1){}\n    using w_graph<undirected>::add;\n    using w_graph<undirected>::input;\n\
    \    using w_graph<undirected>::get_edge;    \n    int64_t build() {\n       \
    \ const auto p = dfs(0, -1);\n        const auto q = dfs(p.second, -1);\n    \
    \    int now = p.second;\n        while(now != q.second) {\n            for(const\
    \ auto &e: (*this)[now]) {\n                if(to[now] == e) {\n             \
    \       path.emplace_back(e);\n                }\n            }\n            now\
    \ = to[now];\n        }\n        return q.first;\n    }\n    std::vector<edge>\
    \ get_path() const { return path; }\n};\n\n/**\n * @brief \u6728\u306E\u76F4\u5F84\
    \n * @see https://ei1333.github.io/library/graph/tree/tree-diameter.hpp\n */"
  dependsOn:
  - C++/graph/WeightedGraph.hpp
  - C++/graph/Graph.hpp
  - C++/graph/edge.hpp
  - C++/graph/ShortestPath.hpp
  isVerificationFile: false
  path: C++/graph/diameter.hpp
  requiredBy: []
  timestamp: '2024-10-03 19:03:34+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/tree_diameter.test.cpp
documentation_of: C++/graph/diameter.hpp
layout: document
redirect_from:
- /library/C++/graph/diameter.hpp
- /library/C++/graph/diameter.hpp.html
title: "\u6728\u306E\u76F4\u5F84"
---