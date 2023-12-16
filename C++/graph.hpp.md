---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: C++/edge.hpp
    title: C++/edge.hpp
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':x:'
    path: test/bermanford.test.cpp
    title: test/bermanford.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/dag_check.test.cpp
    title: test/dag_check.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/lca.test.cpp
    title: test/lca.test.cpp
  - icon: ':x:'
    path: test/warshallfloyd.test.cpp
    title: test/warshallfloyd.test.cpp
  _isVerificationFailed: true
  _pathExtension: hpp
  _verificationStatusIcon: ':question:'
  attributes:
    links: []
  bundledCode: "#line 2 \"C++/graph.hpp\"\n\r\n#include <iostream>\r\n#include <vector>\r\
    \n#include <queue>\r\n#include <stack>\r\n#include <limits>\r\n#if !__has_include(\"\
    C++/template.hpp\")\r\ntemplate <class T, class U> bool chmin(T& a, const U& b){\
    \ if(a>b){ a=b; return 1; } return 0; }\r\n#endif\r\n#line 2 \"C++/edge.hpp\"\n\
    \nstruct edge {\n    int src, to;\n    long long cost;\n    edge(){}\n    edge(const\
    \ int to_): to(to_){}\n    edge(const int to_, const long long cost_): to(to_),\
    \ cost(cost_){}\n    edge(const int src_, const int to_, const long long cost_):\
    \ src(src_), to(to_), cost(cost_){}\n};\n#line 12 \"C++/graph.hpp\"\ntemplate\
    \ <bool undirected = true> struct graph: public std::vector<std::vector<edge>>\
    \ {\r\n    const int indexed;\r\n    std::vector<edge> edges;\r\n    graph(const\
    \ int n, const int indexed_ = 1): indexed(indexed_){ this -> resize(n); }\r\n\
    \    void add(int a, int b) {\r\n        a -= indexed, b-= indexed;\r\n      \
    \  (*this)[a].emplace_back(b);\r\n        edges.emplace_back(a, b, 0);\r\n   \
    \     if(undirected) {\r\n            (*this)[b].emplace_back(a);\r\n        \
    \    edges.emplace_back(b, a, 0);\r\n        }\r\n    }\r\n    void input(const\
    \ int m) {\r\n        for(int i = 0; i < m; ++i) {\r\n            int a, b;\r\n\
    \            std::cin >> a >> b;\r\n            add(a, b);\r\n        }\r\n  \
    \  }\r\n    std::vector<int> all_dist(const int v) {\r\n        std::vector<int>\
    \ d(this -> size(), -1);\r\n        std::queue<int> q;\r\n        d[v] = 0;\r\n\
    \        q.emplace(v);\r\n        while(q.size()) {\r\n            const int tmp\
    \ = q.front();\r\n            q.pop();\r\n            for(const auto &el: (*this)[tmp])\
    \ {\r\n                if(d[el.to] != -1) {\r\n                    continue;\r\
    \n                }\r\n                d[el.to] = d[tmp] + 1;\r\n            \
    \    q.emplace(el.to);\r\n            }\r\n        }\r\n        return d;\r\n\
    \    }\r\n    int dist(const int u, const int v) const { return all_dist(u)[v];\
    \ }\r\n    std::vector<int> t_sort() {\r\n        const int n = this -> size();\r\
    \n\t\tstd::vector<int> deg(n);\r\n\t\tfor(int i = 0; i < n; ++i) {\r\n\t\t\tfor(const\
    \ auto ed: (*this)[i]) {\r\n\t\t\t\tdeg[ed.to]++;\r\n\t\t\t}\r\n\t\t}\r\n\t\t\
    std::stack<int> sk;\r\n\t\tfor(int i = 0; i < n; ++i) {\r\n\t\t\tif(deg[i] ==\
    \ 0) {\r\n\t\t\t\tsk.emplace(i);\r\n\t\t\t}\r\n\t\t}\r\n\t\tstd::vector<int> ord;\r\
    \n\t\twhile(sk.size()) {\r\n\t\t\tconst auto tmp = sk.top();\r\n            sk.pop();\r\
    \n\t\t\tord.emplace_back(tmp);\r\n\t\t\tfor(const auto ed: (*this)[tmp]) {\r\n\
    \t\t\t\tif(--deg[ed.to] == 0) {\r\n\t\t\t\t\tsk.emplace(ed.to);\r\n\t\t\t\t}\r\
    \n\t\t\t}\r\n\t\t}\r\n\t\treturn ord.size() == size() ? ord : std::vector<int>{};\r\
    \n\t}\r\n};\r\ntemplate <bool undirected = true> struct w_graph: public graph<undirected>\
    \ {\r\nprivate:\r\n    using graph<undirected>::indexed;\r\n    using graph<undirected>::edges;\r\
    \npublic:\r\n    w_graph(const int n, const int indexed_ = 1): graph<undirected>(n,\
    \ indexed_){}\r\n    using graph<undirected>::all_dist;\r\n    using graph<undirected>::dist;\r\
    \n    using graph<undirected>::t_sort;\r\n    void add(int a, int b, const long\
    \ long cost) {\r\n        a -= indexed, b -= indexed;\r\n        (*this)[a].emplace_back(b,\
    \ cost);\r\n        edges.emplace_back(a, b, cost);\r\n        if(undirected)\
    \ {\r\n            (*this)[b].emplace_back(a, cost);\r\n            edges.emplace_back(b,\
    \ a, cost);\r\n        }\r\n    }\r\n    void input(const int m) {\r\n       \
    \ for(int i = 0; i < m; ++i) {\r\n            int a, b;\r\n            long long\
    \ c;\r\n            std::cin >> a >> b >> c;\r\n            add(a, b, c);\r\n\
    \        }\r\n    }\r\n    std::vector<long long> dijkstra(const int v) {\r\n\
    \        std::vector<long long> cst(this -> size(), (1LL << 61) - 1);\r\n    \
    \    std::priority_queue<std::pair<long long, int>, std::vector<std::pair<long\
    \ long, int>>, std::greater<std::pair<long long, int>>> dj;\r\n        cst[v]\
    \ = 0;\r\n        dj.emplace(cst[v], v);\r\n        while(dj.size()) {\r\n   \
    \         const auto tmp = dj.top();\r\n            dj.pop();\r\n            if(cst[tmp.second]\
    \ < tmp.first) {\r\n                continue;\r\n            }\r\n           \
    \ for(const auto &el: (*this)[tmp.second]) {\r\n                if(chmin(cst[el],\
    \ tmp.first + el.cost)) {\r\n                    dj.emplace(cst[el.to], el.to);\r\
    \n                }\r\n            }\r\n        }\r\n        return cst;\r\n \
    \   }\r\n    std::vector<long long> bellman_ford(const int v) {\r\n        const\
    \ long long lim = std::numeric_limits<long long>::max();\r\n        std::vector<long\
    \ long> cst(this -> size(), lim);\r\n        cst[v] = 0;\r\n        for(size_t\
    \ i = 0; i < this -> size() - 1; ++i) {\r\n\t\t\tfor(const auto &e: edges) {\r\
    \n\t\t\t\tif(cst[e.src] == lim) {\r\n\t\t\t\t\tcontinue;\r\n\t\t\t\t}\r\n\t\t\t\
    \tchmin(cst[e.to], cst[e.src] + e.cost);\r\n\t\t\t}\r\n\t\t}\r\n\t\tfor(const\
    \ auto &e: edges) {\r\n\t\t\tif(cst[e.src] == lim) {\r\n\t\t\t\tcontinue;\r\n\t\
    \t\t}\r\n\t\t\tif(cst[e.src] + e.cost < cst[e.to]) {\r\n\t\t\t\treturn std::vector<long\
    \ long>{};\r\n\t\t\t}\r\n\t\t}\r\n\t\treturn cst;\r\n    }\r\n    std::vector<std::vector<long\
    \ long>> warshall_floyd() {\r\n\t\tconst int n = this -> size();\r\n        const\
    \ long long lim = (1LL << 61) - 1;\r\n\t\tstd::vector cst(n, std::vector(n, lim));\r\
    \n\t\tfor(int i = 0; i < n; ++i) {\r\n            cst[i][i] = 0;\r\n        }\r\
    \n\t\tfor(int i = 0; i < n; ++i) {\r\n            for(const auto &j: (*this)[i])\
    \ {\r\n                cst[i][j.to] = j.cost;\r\n            }\r\n        }\r\n\
    \t\tfor(int k = 0; k < n; ++k) {\r\n            for(int i = 0; i < n; ++i) {\r\
    \n                for(int j = 0; j < n; ++j) {\r\n                    if(cst[i][k]\
    \ == lim || cst[k][j] == lim) {\r\n                        continue;\r\n     \
    \               }\r\n                    chmin(cst[i][j], cst[i][k] + cst[k][j]);\r\
    \n                }\r\n            }\r\n        }\r\n\t\treturn cst;\r\n\t}\r\n\
    };\n"
  code: "#pragma once\r\n\r\n#include <iostream>\r\n#include <vector>\r\n#include\
    \ <queue>\r\n#include <stack>\r\n#include <limits>\r\n#if !__has_include(\"C++/template.hpp\"\
    )\r\ntemplate <class T, class U> bool chmin(T& a, const U& b){ if(a>b){ a=b; return\
    \ 1; } return 0; }\r\n#endif\r\n#include \"C++/edge.hpp\"\r\ntemplate <bool undirected\
    \ = true> struct graph: public std::vector<std::vector<edge>> {\r\n    const int\
    \ indexed;\r\n    std::vector<edge> edges;\r\n    graph(const int n, const int\
    \ indexed_ = 1): indexed(indexed_){ this -> resize(n); }\r\n    void add(int a,\
    \ int b) {\r\n        a -= indexed, b-= indexed;\r\n        (*this)[a].emplace_back(b);\r\
    \n        edges.emplace_back(a, b, 0);\r\n        if(undirected) {\r\n       \
    \     (*this)[b].emplace_back(a);\r\n            edges.emplace_back(b, a, 0);\r\
    \n        }\r\n    }\r\n    void input(const int m) {\r\n        for(int i = 0;\
    \ i < m; ++i) {\r\n            int a, b;\r\n            std::cin >> a >> b;\r\n\
    \            add(a, b);\r\n        }\r\n    }\r\n    std::vector<int> all_dist(const\
    \ int v) {\r\n        std::vector<int> d(this -> size(), -1);\r\n        std::queue<int>\
    \ q;\r\n        d[v] = 0;\r\n        q.emplace(v);\r\n        while(q.size())\
    \ {\r\n            const int tmp = q.front();\r\n            q.pop();\r\n    \
    \        for(const auto &el: (*this)[tmp]) {\r\n                if(d[el.to] !=\
    \ -1) {\r\n                    continue;\r\n                }\r\n            \
    \    d[el.to] = d[tmp] + 1;\r\n                q.emplace(el.to);\r\n         \
    \   }\r\n        }\r\n        return d;\r\n    }\r\n    int dist(const int u,\
    \ const int v) const { return all_dist(u)[v]; }\r\n    std::vector<int> t_sort()\
    \ {\r\n        const int n = this -> size();\r\n\t\tstd::vector<int> deg(n);\r\
    \n\t\tfor(int i = 0; i < n; ++i) {\r\n\t\t\tfor(const auto ed: (*this)[i]) {\r\
    \n\t\t\t\tdeg[ed.to]++;\r\n\t\t\t}\r\n\t\t}\r\n\t\tstd::stack<int> sk;\r\n\t\t\
    for(int i = 0; i < n; ++i) {\r\n\t\t\tif(deg[i] == 0) {\r\n\t\t\t\tsk.emplace(i);\r\
    \n\t\t\t}\r\n\t\t}\r\n\t\tstd::vector<int> ord;\r\n\t\twhile(sk.size()) {\r\n\t\
    \t\tconst auto tmp = sk.top();\r\n            sk.pop();\r\n\t\t\tord.emplace_back(tmp);\r\
    \n\t\t\tfor(const auto ed: (*this)[tmp]) {\r\n\t\t\t\tif(--deg[ed.to] == 0) {\r\
    \n\t\t\t\t\tsk.emplace(ed.to);\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t}\r\n\t\treturn\
    \ ord.size() == size() ? ord : std::vector<int>{};\r\n\t}\r\n};\r\ntemplate <bool\
    \ undirected = true> struct w_graph: public graph<undirected> {\r\nprivate:\r\n\
    \    using graph<undirected>::indexed;\r\n    using graph<undirected>::edges;\r\
    \npublic:\r\n    w_graph(const int n, const int indexed_ = 1): graph<undirected>(n,\
    \ indexed_){}\r\n    using graph<undirected>::all_dist;\r\n    using graph<undirected>::dist;\r\
    \n    using graph<undirected>::t_sort;\r\n    void add(int a, int b, const long\
    \ long cost) {\r\n        a -= indexed, b -= indexed;\r\n        (*this)[a].emplace_back(b,\
    \ cost);\r\n        edges.emplace_back(a, b, cost);\r\n        if(undirected)\
    \ {\r\n            (*this)[b].emplace_back(a, cost);\r\n            edges.emplace_back(b,\
    \ a, cost);\r\n        }\r\n    }\r\n    void input(const int m) {\r\n       \
    \ for(int i = 0; i < m; ++i) {\r\n            int a, b;\r\n            long long\
    \ c;\r\n            std::cin >> a >> b >> c;\r\n            add(a, b, c);\r\n\
    \        }\r\n    }\r\n    std::vector<long long> dijkstra(const int v) {\r\n\
    \        std::vector<long long> cst(this -> size(), (1LL << 61) - 1);\r\n    \
    \    std::priority_queue<std::pair<long long, int>, std::vector<std::pair<long\
    \ long, int>>, std::greater<std::pair<long long, int>>> dj;\r\n        cst[v]\
    \ = 0;\r\n        dj.emplace(cst[v], v);\r\n        while(dj.size()) {\r\n   \
    \         const auto tmp = dj.top();\r\n            dj.pop();\r\n            if(cst[tmp.second]\
    \ < tmp.first) {\r\n                continue;\r\n            }\r\n           \
    \ for(const auto &el: (*this)[tmp.second]) {\r\n                if(chmin(cst[el],\
    \ tmp.first + el.cost)) {\r\n                    dj.emplace(cst[el.to], el.to);\r\
    \n                }\r\n            }\r\n        }\r\n        return cst;\r\n \
    \   }\r\n    std::vector<long long> bellman_ford(const int v) {\r\n        const\
    \ long long lim = std::numeric_limits<long long>::max();\r\n        std::vector<long\
    \ long> cst(this -> size(), lim);\r\n        cst[v] = 0;\r\n        for(size_t\
    \ i = 0; i < this -> size() - 1; ++i) {\r\n\t\t\tfor(const auto &e: edges) {\r\
    \n\t\t\t\tif(cst[e.src] == lim) {\r\n\t\t\t\t\tcontinue;\r\n\t\t\t\t}\r\n\t\t\t\
    \tchmin(cst[e.to], cst[e.src] + e.cost);\r\n\t\t\t}\r\n\t\t}\r\n\t\tfor(const\
    \ auto &e: edges) {\r\n\t\t\tif(cst[e.src] == lim) {\r\n\t\t\t\tcontinue;\r\n\t\
    \t\t}\r\n\t\t\tif(cst[e.src] + e.cost < cst[e.to]) {\r\n\t\t\t\treturn std::vector<long\
    \ long>{};\r\n\t\t\t}\r\n\t\t}\r\n\t\treturn cst;\r\n    }\r\n    std::vector<std::vector<long\
    \ long>> warshall_floyd() {\r\n\t\tconst int n = this -> size();\r\n        const\
    \ long long lim = (1LL << 61) - 1;\r\n\t\tstd::vector cst(n, std::vector(n, lim));\r\
    \n\t\tfor(int i = 0; i < n; ++i) {\r\n            cst[i][i] = 0;\r\n        }\r\
    \n\t\tfor(int i = 0; i < n; ++i) {\r\n            for(const auto &j: (*this)[i])\
    \ {\r\n                cst[i][j.to] = j.cost;\r\n            }\r\n        }\r\n\
    \t\tfor(int k = 0; k < n; ++k) {\r\n            for(int i = 0; i < n; ++i) {\r\
    \n                for(int j = 0; j < n; ++j) {\r\n                    if(cst[i][k]\
    \ == lim || cst[k][j] == lim) {\r\n                        continue;\r\n     \
    \               }\r\n                    chmin(cst[i][j], cst[i][k] + cst[k][j]);\r\
    \n                }\r\n            }\r\n        }\r\n\t\treturn cst;\r\n\t}\r\n\
    };"
  dependsOn:
  - C++/edge.hpp
  isVerificationFile: false
  path: C++/graph.hpp
  requiredBy: []
  timestamp: '2023-12-16 23:45:11+09:00'
  verificationStatus: LIBRARY_SOME_WA
  verifiedWith:
  - test/bermanford.test.cpp
  - test/dag_check.test.cpp
  - test/lca.test.cpp
  - test/warshallfloyd.test.cpp
documentation_of: C++/graph.hpp
layout: document
redirect_from:
- /library/C++/graph.hpp
- /library/C++/graph.hpp.html
title: C++/graph.hpp
---
