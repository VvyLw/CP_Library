---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/edge.hpp
    title: C++/edge.hpp
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/lca.test.cpp
    title: test/lca.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    links: []
  bundledCode: "#line 2 \"C++/graph.hpp\"\n\r\n#include <iostream>\r\n#include <vector>\r\
    \n#include <queue>\r\n//#include \"template.hpp\"\r\ntemplate <class T, class\
    \ U> bool chmin(T& a, const U& b){ if(a>b){ a=b; return 1; } return 0; }\r\n#line\
    \ 2 \"C++/edge.hpp\"\n\nstruct edge {\n    int src, to;\n    long long cost;\n\
    \    edge(){}\n    edge(const int to_): to(to_){}\n    edge(const int to_, const\
    \ long long cost_): to(to_), cost(cost_){}\n    edge(const int src_, const int\
    \ to_, const long long cost_): src(src_), to(to_), cost(cost_){}\n};\n#line 9\
    \ \"C++/graph.hpp\"\ntemplate <bool undirected = true> struct graph: std::vector<std::vector<edge>>\
    \ {\r\nprivate:\r\n    const int indexed;\r\npublic:\r\n    graph(const int n,\
    \ const int indexed_ = 1): indexed(indexed_) {\r\n        this -> resize(n);\r\
    \n    }\r\n    void add(int a, int b) {\r\n        a -= indexed, b-= indexed;\r\
    \n        (*this)[a].emplace_back(edge(b));\r\n        if(undirected) {\r\n  \
    \          (*this)[b].emplace_back(edge(a));\r\n        }\r\n    }\r\n    void\
    \ input(const int m) {\r\n        for(int i = 0; i < m; ++i) {\r\n           \
    \ int a, b;\r\n            std::cin >> a >> b;\r\n            add(a, b);\r\n \
    \       }\r\n    }\r\nprotected:\r\n    std::vector<int> all_dist(const int v)\
    \ {\r\n        std::vector<int> d(this -> size(), -1);\r\n        std::queue<int>\
    \ q;\r\n        d[v] = 0;\r\n        q.emplace(v);\r\n        while(q.size())\
    \ {\r\n            const int tmp = q.front();\r\n            q.pop();\r\n    \
    \        for(const auto &el: (*this)[tmp]) {\r\n                if(d[el.to] !=\
    \ -1) {\r\n                    continue;\r\n                }\r\n            \
    \    d[el.to] = d[tmp] + 1;\r\n                q.emplace(el.to);\r\n         \
    \   }\r\n        }\r\n        return d;\r\n    }\r\n    int dist(const int u,\
    \ const int v) const { return all_dist(u)[v]; }\r\n};\r\ntemplate <bool undirected\
    \ = true> struct w_graph: graph<undirected> {\r\nprivate:\r\n    const int indexed;\r\
    \npublic:\r\n    w_graph(const int n, const int indexed_ = 1): graph<undirected>(n,\
    \ indexed_){}\r\n    void add(int a, int b, const long long cost) {\r\n      \
    \  a -= indexed, b -= indexed;\r\n        (*this)[a].emplace_back(edge(b, cost));\r\
    \n        if(undirected) {\r\n            (*this)[b].emplace_back(edge(a, cost));\r\
    \n        }\r\n    }\r\n    void input(const int m) {\r\n        for(int i = 0;\
    \ i < m; ++i) {\r\n            int a, b;\r\n            long long c;\r\n     \
    \       std::cin >> a >> b >> c;\r\n            add(a, b, c);\r\n        }\r\n\
    \    }\r\n    std::vector<long long> dijkstra(const int v) {\r\n        std::vector<long\
    \ long> cst(this -> size(), (1LL << 61) - 1);\r\n        std::priority_queue<std::pair<long\
    \ long, int>, std::vector<std::pair<long long, int>>, std::greater<std::pair<long\
    \ long, int>>> dj;\r\n        cst[v] = 0;\r\n        dj.emplace(cst[v], v);\r\n\
    \        while(dj.size()) {\r\n            const auto tmp = dj.top();\r\n    \
    \        dj.pop();\r\n            if(cst[tmp.second] < tmp.first) {\r\n      \
    \          continue;\r\n            }\r\n            for(const auto &el: (*this)[tmp.second])\
    \ {\r\n                if(chmin(cst[el], tmp.first + el.cost)) {\r\n         \
    \           dj.emplace(cst[el.to], el.to);\r\n                }\r\n          \
    \  }\r\n        }\r\n        return cst;\r\n    }\r\n    std::vector<std::vector<long\
    \ long>> warshall_floyd() {\r\n\t\tconst int n = this -> size();\r\n\t\tstd::vector\
    \ cst(n, std::vector(n, (1LL << 61) - 1));\r\n\t\tfor(int i = 0; i < n; ++i) {\r\
    \n            cst[i][i] = 0;\r\n        }\r\n\t\tfor(int i = 0; i < n; ++i) {\r\
    \n            for(const auto &j: (*this)[i]) {\r\n                cst[i][j] =\
    \ j.cost;\r\n            }\r\n        }\r\n\t\tfor(int k = 0 ; k < n; ++k) {\r\
    \n            for(int i = 0; i < n; ++i) {\r\n                for(int j = 0; j\
    \ < n; ++j) {\r\n                    chmin(cst[i][j], cst[i][k] + cst[k][j]);\r\
    \n                }\r\n            }\r\n        }\r\n\t\treturn cst;\r\n\t}\r\n\
    };\n"
  code: "#pragma once\r\n\r\n#include <iostream>\r\n#include <vector>\r\n#include\
    \ <queue>\r\n//#include \"template.hpp\"\r\ntemplate <class T, class U> bool chmin(T&\
    \ a, const U& b){ if(a>b){ a=b; return 1; } return 0; }\r\n#include \"C++/edge.hpp\"\
    \r\ntemplate <bool undirected = true> struct graph: std::vector<std::vector<edge>>\
    \ {\r\nprivate:\r\n    const int indexed;\r\npublic:\r\n    graph(const int n,\
    \ const int indexed_ = 1): indexed(indexed_) {\r\n        this -> resize(n);\r\
    \n    }\r\n    void add(int a, int b) {\r\n        a -= indexed, b-= indexed;\r\
    \n        (*this)[a].emplace_back(edge(b));\r\n        if(undirected) {\r\n  \
    \          (*this)[b].emplace_back(edge(a));\r\n        }\r\n    }\r\n    void\
    \ input(const int m) {\r\n        for(int i = 0; i < m; ++i) {\r\n           \
    \ int a, b;\r\n            std::cin >> a >> b;\r\n            add(a, b);\r\n \
    \       }\r\n    }\r\nprotected:\r\n    std::vector<int> all_dist(const int v)\
    \ {\r\n        std::vector<int> d(this -> size(), -1);\r\n        std::queue<int>\
    \ q;\r\n        d[v] = 0;\r\n        q.emplace(v);\r\n        while(q.size())\
    \ {\r\n            const int tmp = q.front();\r\n            q.pop();\r\n    \
    \        for(const auto &el: (*this)[tmp]) {\r\n                if(d[el.to] !=\
    \ -1) {\r\n                    continue;\r\n                }\r\n            \
    \    d[el.to] = d[tmp] + 1;\r\n                q.emplace(el.to);\r\n         \
    \   }\r\n        }\r\n        return d;\r\n    }\r\n    int dist(const int u,\
    \ const int v) const { return all_dist(u)[v]; }\r\n};\r\ntemplate <bool undirected\
    \ = true> struct w_graph: graph<undirected> {\r\nprivate:\r\n    const int indexed;\r\
    \npublic:\r\n    w_graph(const int n, const int indexed_ = 1): graph<undirected>(n,\
    \ indexed_){}\r\n    void add(int a, int b, const long long cost) {\r\n      \
    \  a -= indexed, b -= indexed;\r\n        (*this)[a].emplace_back(edge(b, cost));\r\
    \n        if(undirected) {\r\n            (*this)[b].emplace_back(edge(a, cost));\r\
    \n        }\r\n    }\r\n    void input(const int m) {\r\n        for(int i = 0;\
    \ i < m; ++i) {\r\n            int a, b;\r\n            long long c;\r\n     \
    \       std::cin >> a >> b >> c;\r\n            add(a, b, c);\r\n        }\r\n\
    \    }\r\n    std::vector<long long> dijkstra(const int v) {\r\n        std::vector<long\
    \ long> cst(this -> size(), (1LL << 61) - 1);\r\n        std::priority_queue<std::pair<long\
    \ long, int>, std::vector<std::pair<long long, int>>, std::greater<std::pair<long\
    \ long, int>>> dj;\r\n        cst[v] = 0;\r\n        dj.emplace(cst[v], v);\r\n\
    \        while(dj.size()) {\r\n            const auto tmp = dj.top();\r\n    \
    \        dj.pop();\r\n            if(cst[tmp.second] < tmp.first) {\r\n      \
    \          continue;\r\n            }\r\n            for(const auto &el: (*this)[tmp.second])\
    \ {\r\n                if(chmin(cst[el], tmp.first + el.cost)) {\r\n         \
    \           dj.emplace(cst[el.to], el.to);\r\n                }\r\n          \
    \  }\r\n        }\r\n        return cst;\r\n    }\r\n    std::vector<std::vector<long\
    \ long>> warshall_floyd() {\r\n\t\tconst int n = this -> size();\r\n\t\tstd::vector\
    \ cst(n, std::vector(n, (1LL << 61) - 1));\r\n\t\tfor(int i = 0; i < n; ++i) {\r\
    \n            cst[i][i] = 0;\r\n        }\r\n\t\tfor(int i = 0; i < n; ++i) {\r\
    \n            for(const auto &j: (*this)[i]) {\r\n                cst[i][j] =\
    \ j.cost;\r\n            }\r\n        }\r\n\t\tfor(int k = 0 ; k < n; ++k) {\r\
    \n            for(int i = 0; i < n; ++i) {\r\n                for(int j = 0; j\
    \ < n; ++j) {\r\n                    chmin(cst[i][j], cst[i][k] + cst[k][j]);\r\
    \n                }\r\n            }\r\n        }\r\n\t\treturn cst;\r\n\t}\r\n\
    };"
  dependsOn:
  - C++/edge.hpp
  isVerificationFile: false
  path: C++/graph.hpp
  requiredBy: []
  timestamp: '2023-12-12 00:31:50+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/lca.test.cpp
documentation_of: C++/graph.hpp
layout: document
redirect_from:
- /library/C++/graph.hpp
- /library/C++/graph.hpp.html
title: C++/graph.hpp
---
