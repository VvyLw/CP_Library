---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/graph/Graph.hpp
    title: "\u30B0\u30E9\u30D5\u30E9\u30A4\u30D6\u30E9\u30EA"
  - icon: ':heavy_check_mark:'
    path: C++/graph/edge.hpp
    title: Edge
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/bermanford.test.cpp
    title: test/bermanford.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/warshallfloyd.test.cpp
    title: test/warshallfloyd.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: "\u91CD\u307F\u4ED8\u304D\u30B0\u30E9\u30D5\u30E9\u30A4\u30D6\u30E9\
      \u30EA"
    links: []
  bundledCode: "#line 2 \"C++/graph/WeightedGraph.hpp\"\n\n#include <limits>\n#line\
    \ 2 \"C++/graph/Graph.hpp\"\n\r\n#include <iostream>\r\n#include <vector>\r\n\
    #include <queue>\r\n#include <stack>\r\n#ifndef TEMPLATE\r\ntemplate <class T,\
    \ class U> bool chmin(T& a, const U& b){ if(a>b){ a=b; return 1; } return 0; }\r\
    \n#endif\r\n#line 2 \"C++/graph/edge.hpp\"\n\nstruct edge {\n    int src, to,\
    \ id;\n    long long cost;\n    edge(){}\n    edge(const int src_, const int to_,\
    \ const int id_ = -1, const long long cost_ = 0): src(src_), to(to_), id(id_),\
    \ cost(cost_){}\n    operator int() const { return to; }\n};\n\n/**\n * @brief\
    \ Edge\n */\n#line 11 \"C++/graph/Graph.hpp\"\ntemplate <bool undirected = true>\
    \ struct graph: std::vector<std::vector<edge>> {\r\nprotected:\r\n    int indexed,\
    \ id;\r\n    std::vector<edge> edges;\r\npublic:\r\n    graph(){}\r\n    graph(const\
    \ int n, const int indexed_ = 1): indexed(indexed_), id(0){ this -> resize(n);\
    \ }\r\n    void add(int a, int b) {\r\n        a -= indexed, b-= indexed;\r\n\
    \        (*this)[a].emplace_back(a, b, id);\r\n        edges.emplace_back(a, b,\
    \ id++);\r\n        if(undirected) {\r\n            (*this)[b].emplace_back(b,\
    \ a, --id);\r\n            edges.emplace_back(b, a, id++);\r\n        }\r\n  \
    \  }\r\n    void input(const int m) {\r\n        for(int i = 0; i < m; ++i) {\r\
    \n            int a, b;\r\n            std::cin >> a >> b;\r\n            add(a,\
    \ b);\r\n        }\r\n    }\r\n    std::vector<int> all_dist(const int v) {\r\n\
    \        std::vector<int> d(this -> size(), -1);\r\n        std::queue<int> q;\r\
    \n        d[v] = 0;\r\n        q.emplace(v);\r\n        while(q.size()) {\r\n\
    \            const int tmp = q.front();\r\n            q.pop();\r\n          \
    \  for(const auto &el: (*this)[tmp]) {\r\n                if(d[el] != -1) {\r\n\
    \                    continue;\r\n                }\r\n                d[el] =\
    \ d[tmp] + 1;\r\n                q.emplace(el);\r\n            }\r\n        }\r\
    \n        return d;\r\n    }\r\n    int dist(const int u, const int v) const {\
    \ return all_dist(u)[v]; }\r\n    std::vector<int> t_sort() {\r\n        const\
    \ int n = this -> size();\r\n\t\tstd::vector<int> deg(n);\r\n\t\tfor(int i = 0;\
    \ i < n; ++i) {\r\n\t\t\tfor(const auto ed: (*this)[i]) {\r\n\t\t\t\tdeg[ed]++;\r\
    \n\t\t\t}\r\n\t\t}\r\n\t\tstd::stack<int> sk;\r\n\t\tfor(int i = 0; i < n; ++i)\
    \ {\r\n\t\t\tif(deg[i] == 0) {\r\n\t\t\t\tsk.emplace(i);\r\n\t\t\t}\r\n\t\t}\r\
    \n\t\tstd::vector<int> ord;\r\n\t\twhile(sk.size()) {\r\n\t\t\tconst auto tmp\
    \ = sk.top();\r\n            sk.pop();\r\n\t\t\tord.emplace_back(tmp);\r\n\t\t\
    \tfor(const auto ed: (*this)[tmp]) {\r\n\t\t\t\tif(--deg[ed] == 0) {\r\n\t\t\t\
    \t\tsk.emplace(ed);\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t}\r\n\t\treturn ord.size()\
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
    \u30E9\u30A4\u30D6\u30E9\u30EA\r\n */\n#line 5 \"C++/graph/WeightedGraph.hpp\"\
    \ntemplate <bool undirected = true> struct w_graph: public graph<undirected> {\n\
    private:\n    using graph<undirected>::indexed;\n    using graph<undirected>::id;\n\
    \    using graph<undirected>::edges;\npublic:\n    w_graph(const int n, const\
    \ int indexed_ = 1): graph<undirected>(n, indexed_){}\n    using graph<undirected>::all_dist;\n\
    \    using graph<undirected>::dist;\n    using graph<undirected>::t_sort;\n  \
    \  using graph<undirected>::cycle;\n    void add(int a, int b, const long long\
    \ cost) {\n        a -= indexed, b -= indexed;\n        (*this)[a].emplace_back(a,\
    \ b, id, cost);\n        edges.emplace_back(a, b, id++, cost);\n        if(undirected)\
    \ {\n            (*this)[b].emplace_back(b, a, --id, cost);\n            edges.emplace_back(b,\
    \ a, id++, cost);\n        }\n    }\n    void input(const int m) {\n        for(int\
    \ i = 0; i < m; ++i) {\n            int a, b;\n            long long c;\n    \
    \        std::cin >> a >> b >> c;\n            add(a, b, c);\n        }\n    }\n\
    \    std::vector<long long> dijkstra(const int v) {\n        std::vector<long\
    \ long> cst(this -> size(), (1LL << 61) - 1);\n        std::priority_queue<std::pair<long\
    \ long, int>, std::vector<std::pair<long long, int>>, std::greater<std::pair<long\
    \ long, int>>> dj;\n        cst[v] = 0;\n        dj.emplace(cst[v], v);\n    \
    \    while(dj.size()) {\n            const auto tmp = dj.top();\n            dj.pop();\n\
    \            if(cst[tmp.second] < tmp.first) {\n                continue;\n  \
    \          }\n            for(const auto &el: (*this)[tmp.second]) {\n       \
    \         if(chmin(cst[el], tmp.first + el.cost)) {\n                    dj.emplace(cst[el],\
    \ el);\n                }\n            }\n        }\n        return cst;\n   \
    \ }\n    std::vector<long long> bellman_ford(const int v) {\n        const long\
    \ long lim = std::numeric_limits<long long>::max();\n        std::vector<long\
    \ long> cst(this -> size(), lim);\n        cst[v] = 0;\n        for(size_t i =\
    \ 0; i < this -> size() - 1; ++i) {\n\t\t\tfor(const auto &e: edges) {\n\t\t\t\
    \tif(cst[e.src] == lim) {\n\t\t\t\t\tcontinue;\n\t\t\t\t}\n\t\t\t\tchmin(cst[e],\
    \ cst[e.src] + e.cost);\n\t\t\t}\n\t\t}\n\t\tfor(const auto &e: edges) {\n\t\t\
    \tif(cst[e.src] == lim) {\n\t\t\t\tcontinue;\n\t\t\t}\n\t\t\tif(cst[e.src] + e.cost\
    \ < cst[e]) {\n\t\t\t\treturn std::vector<long long>{};\n\t\t\t}\n\t\t}\n\t\t\
    return cst;\n    }\n    std::vector<std::vector<long long>> warshall_floyd() {\n\
    \t\tconst int n = this -> size();\n        const long long lim = (1LL << 61) -\
    \ 1;\n\t\tstd::vector cst(n, std::vector(n, lim));\n\t\tfor(int i = 0; i < n;\
    \ ++i) {\n            cst[i][i] = 0;\n        }\n\t\tfor(int i = 0; i < n; ++i)\
    \ {\n            for(const auto &j: (*this)[i]) {\n                cst[i][j] =\
    \ j.cost;\n            }\n        }\n\t\tfor(int k = 0; k < n; ++k) {\n      \
    \      for(int i = 0; i < n; ++i) {\n                for(int j = 0; j < n; ++j)\
    \ {\n                    if(cst[i][k] == lim || cst[k][j] == lim) {\n        \
    \                continue;\n                    }\n                    chmin(cst[i][j],\
    \ cst[i][k] + cst[k][j]);\n                }\n            }\n        }\n\t\treturn\
    \ cst;\n\t}\n};\n\n/**\n * @brief \u91CD\u307F\u4ED8\u304D\u30B0\u30E9\u30D5\u30E9\
    \u30A4\u30D6\u30E9\u30EA\n */\n"
  code: "#pragma once\n\n#include <limits>\n#include \"C++/graph/Graph.hpp\"\ntemplate\
    \ <bool undirected = true> struct w_graph: public graph<undirected> {\nprivate:\n\
    \    using graph<undirected>::indexed;\n    using graph<undirected>::id;\n   \
    \ using graph<undirected>::edges;\npublic:\n    w_graph(const int n, const int\
    \ indexed_ = 1): graph<undirected>(n, indexed_){}\n    using graph<undirected>::all_dist;\n\
    \    using graph<undirected>::dist;\n    using graph<undirected>::t_sort;\n  \
    \  using graph<undirected>::cycle;\n    void add(int a, int b, const long long\
    \ cost) {\n        a -= indexed, b -= indexed;\n        (*this)[a].emplace_back(a,\
    \ b, id, cost);\n        edges.emplace_back(a, b, id++, cost);\n        if(undirected)\
    \ {\n            (*this)[b].emplace_back(b, a, --id, cost);\n            edges.emplace_back(b,\
    \ a, id++, cost);\n        }\n    }\n    void input(const int m) {\n        for(int\
    \ i = 0; i < m; ++i) {\n            int a, b;\n            long long c;\n    \
    \        std::cin >> a >> b >> c;\n            add(a, b, c);\n        }\n    }\n\
    \    std::vector<long long> dijkstra(const int v) {\n        std::vector<long\
    \ long> cst(this -> size(), (1LL << 61) - 1);\n        std::priority_queue<std::pair<long\
    \ long, int>, std::vector<std::pair<long long, int>>, std::greater<std::pair<long\
    \ long, int>>> dj;\n        cst[v] = 0;\n        dj.emplace(cst[v], v);\n    \
    \    while(dj.size()) {\n            const auto tmp = dj.top();\n            dj.pop();\n\
    \            if(cst[tmp.second] < tmp.first) {\n                continue;\n  \
    \          }\n            for(const auto &el: (*this)[tmp.second]) {\n       \
    \         if(chmin(cst[el], tmp.first + el.cost)) {\n                    dj.emplace(cst[el],\
    \ el);\n                }\n            }\n        }\n        return cst;\n   \
    \ }\n    std::vector<long long> bellman_ford(const int v) {\n        const long\
    \ long lim = std::numeric_limits<long long>::max();\n        std::vector<long\
    \ long> cst(this -> size(), lim);\n        cst[v] = 0;\n        for(size_t i =\
    \ 0; i < this -> size() - 1; ++i) {\n\t\t\tfor(const auto &e: edges) {\n\t\t\t\
    \tif(cst[e.src] == lim) {\n\t\t\t\t\tcontinue;\n\t\t\t\t}\n\t\t\t\tchmin(cst[e],\
    \ cst[e.src] + e.cost);\n\t\t\t}\n\t\t}\n\t\tfor(const auto &e: edges) {\n\t\t\
    \tif(cst[e.src] == lim) {\n\t\t\t\tcontinue;\n\t\t\t}\n\t\t\tif(cst[e.src] + e.cost\
    \ < cst[e]) {\n\t\t\t\treturn std::vector<long long>{};\n\t\t\t}\n\t\t}\n\t\t\
    return cst;\n    }\n    std::vector<std::vector<long long>> warshall_floyd() {\n\
    \t\tconst int n = this -> size();\n        const long long lim = (1LL << 61) -\
    \ 1;\n\t\tstd::vector cst(n, std::vector(n, lim));\n\t\tfor(int i = 0; i < n;\
    \ ++i) {\n            cst[i][i] = 0;\n        }\n\t\tfor(int i = 0; i < n; ++i)\
    \ {\n            for(const auto &j: (*this)[i]) {\n                cst[i][j] =\
    \ j.cost;\n            }\n        }\n\t\tfor(int k = 0; k < n; ++k) {\n      \
    \      for(int i = 0; i < n; ++i) {\n                for(int j = 0; j < n; ++j)\
    \ {\n                    if(cst[i][k] == lim || cst[k][j] == lim) {\n        \
    \                continue;\n                    }\n                    chmin(cst[i][j],\
    \ cst[i][k] + cst[k][j]);\n                }\n            }\n        }\n\t\treturn\
    \ cst;\n\t}\n};\n\n/**\n * @brief \u91CD\u307F\u4ED8\u304D\u30B0\u30E9\u30D5\u30E9\
    \u30A4\u30D6\u30E9\u30EA\n */"
  dependsOn:
  - C++/graph/Graph.hpp
  - C++/graph/edge.hpp
  isVerificationFile: false
  path: C++/graph/WeightedGraph.hpp
  requiredBy: []
  timestamp: '2024-02-22 06:53:31+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/warshallfloyd.test.cpp
  - test/bermanford.test.cpp
documentation_of: C++/graph/WeightedGraph.hpp
layout: document
redirect_from:
- /library/C++/graph/WeightedGraph.hpp
- /library/C++/graph/WeightedGraph.hpp.html
title: "\u91CD\u307F\u4ED8\u304D\u30B0\u30E9\u30D5\u30E9\u30A4\u30D6\u30E9\u30EA"
---