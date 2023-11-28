---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: C++/UnionFind.hpp
    title: C++/UnionFind.hpp
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':x:'
    path: test/lca.test.cpp
    title: test/lca.test.cpp
  _isVerificationFailed: true
  _pathExtension: hpp
  _verificationStatusIcon: ':x:'
  attributes:
    links: []
  bundledCode: "#line 2 \"C++/graph.hpp\"\n\r\n#include <iostream>\r\n#include <vector>\r\
    \n#include <queue>\r\nusing namespace std;\r\n//#include \"template.hpp\"\r\n\
    template <class T, class U> bool chmin(T& a, const U& b){ if(a>b){ a=b; return\
    \ 1; } return 0; }\r\nstruct edge {\r\nprivate:\r\n    int to;\r\npublic:\r\n\
    \    long long cost;\r\n    edge(int to_, long long cost_): to(to_), cost(cost_){}\r\
    \n    operator long long() const { return to; }\r\n};\r\ntemplate <bool undirected=1>\
    \ struct w_graph {\r\n    vector<vector<edge>> g;\r\n    vector<int> pr;\r\n \
    \   w_graph(int n): g(n), pr(n){}\r\n    vector<edge>& operator[](int x){ return\
    \ g[x]; }\r\n    const vector<edge>& operator[](int x) const { return g[x]; }\r\
    \n    operator vector<vector<edge>>&(){ return g; }\r\n    operator const vector<vector<edge>>&()\
    \ const { return g; }\r\n    auto begin() const { return g.cbegin(); }\r\n   \
    \ auto end() const { return g.cend(); }\r\n    int size() const { return g.size();\
    \ }\r\n    void add(int a, int b, long long cost, int indexed=1) {\r\n       \
    \ a-=indexed,b-=indexed;\r\n        g[a].emplace_back(b, cost);\r\n        pr[b]\
    \ = a;\r\n        if(undirected) g[b].emplace_back(a, cost);\r\n    }\r\n    void\
    \ input(int m, int indexed=1) {\r\n        for(int i = 0; i < m; ++i) {\r\n  \
    \          int a, b;\r\n            long long c;\r\n            cin >> a >> b\
    \ >> c;\r\n            add(a, b, c, indexed);\r\n        }\r\n    }\r\n    vector<edge>\
    \ par(int v){ return g[pr[v]]; }\r\n    vector<int> all_dist(int v) {\r\n    \
    \    vector<int> d(g.size(),-1);\r\n        queue<int> q;\r\n        d[v]=0;\r\
    \n        q.emplace(v);\r\n        while(q.size()) {\r\n            int tmp=q.front();\r\
    \n            q.pop();\r\n            for(const auto &el: g[tmp]) {\r\n      \
    \          if(d[el]!=-1) continue;\r\n                d[el]=d[tmp]+1;\r\n    \
    \            q.emplace(el);\r\n            }\r\n        }\r\n        return d;\r\
    \n    }\r\n    int dist(int u, int v) {\r\n        const auto d=all_dist(u);\r\
    \n        return d[v];\r\n    }\r\n    vector<long long> dijkstra(int v) {\r\n\
    \        vector<long long> cst(g.size(), 1LL << 60);\r\n        priority_queue<pair<long\
    \ long, int>, vector<pair<long long, int>>, greater<pair<long long, int>>> dj;\r\
    \n        cst[v]=0;\r\n        dj.emplace(cst[v],v);\r\n        while(dj.size())\
    \ {\r\n            const auto tmp=dj.top();\r\n            dj.pop();\r\n     \
    \       if(cst[tmp.second]<tmp.first) continue;\r\n            for(auto el: g[tmp.second])\
    \ if(chmin(cst[el],tmp.first+el.cost)) dj.emplace(cst[el],el);\r\n        }\r\n\
    \        return cst;\r\n    }\r\n    vector<vector<long long>> warshall_floyd()\
    \ {\r\n\t\tconst int n = g.size();\r\n\t\tvector cst(n, vector(n, (1LL << 61)\
    \ - 1));\r\n\t\tfor(int i = 0; i < n; ++i) cst[i][i]=0;\r\n\t\tfor(int i = 0;\
    \ i < n; ++i) for(const auto &j: g[i]) cst[i][j]=j.cost;\r\n\t\tfor(int k = 0\
    \ ; k < n; ++k) {\r\n            for(int i = 0; i < n; ++i) {\r\n            \
    \    for(int j = 0; j < n; ++j) chmin(cst[i][j],cst[i][k]+cst[k][j]);\r\n    \
    \        }\r\n        }\r\n\t\treturn cst;\r\n\t}\r\n};\r\ntemplate <bool undirected=1>\
    \ struct graph {\r\n    vector<vector<int>> g;\r\n    vector<int> pr;\r\n    graph(int\
    \ n): g(n), pr(n){}\r\n    vector<int>& operator[](int x){ return g[x]; }\r\n\
    \    const vector<int>& operator[](int x) const { return g[x]; }\r\n    operator\
    \ vector<vector<int>>&(){ return g; }\r\n    operator const vector<vector<int>>&()\
    \ const { return g; }\r\n    auto begin() const { return g.cbegin(); }\r\n   \
    \ auto end() const { return g.cend(); }\r\n    int size() const { return g.size();\
    \ }\r\n    void add(int a, int b, int indexed=1) {\r\n        a-=indexed,b-=indexed;\r\
    \n        g[a].emplace_back(b);\r\n        pr[b] = a;\r\n        if(undirected)\
    \ g[b].emplace_back(a);\r\n    }\r\n    void input(int m, int indexed=1) {\r\n\
    \        for(int i = 0; i < m; ++i) {\r\n            int a, b;\r\n           \
    \ cin >> a >> b;\r\n            add(a,b,indexed);\r\n        }\r\n    }\r\n  \
    \  vector<int> par(int v){ return g[pr[v]]; }\r\n    vector<int> all_dist(int\
    \ v) {\r\n        vector<int> d(g.size(),-1);\r\n        queue<int> q;\r\n   \
    \     d[v]=0;\r\n        q.emplace(v);\r\n        while(q.size()) {\r\n      \
    \      int tmp=q.front();\r\n            q.pop();\r\n            for(auto el:\
    \ g[tmp]) {\r\n                if(d[el]!=-1) continue;\r\n                d[el]=d[tmp]+1;\r\
    \n                q.emplace(el);\r\n            }\r\n        }\r\n        return\
    \ d;\r\n    }\r\n    int dist(int u, int v) {\r\n        const auto d=all_dist(u);\r\
    \n        return d[v];\r\n    }\r\n};\r\n#include <C++/UnionFind.hpp>\r\nstruct\
    \ Edge {\r\n\tlong long a, b, cost;\r\n\tbool operator<(const Edge& e) const {\r\
    \n\t\treturn cost < e.cost;\r\n\t}\r\n};\r\nstruct Graph {\r\n\tint n;\r\n\tvector<Edge>\
    \ edges;\r\n\tGraph(const int n_): n(n_){}\r\n\tvoid input(ll m, const uint indexed=1)\
    \ {\r\n\t\twhile(m--) {\r\n\t\t\tEdge e;\r\n            cin >> e.a >> e.b >> e.cost;\r\
    \n\t\t\te.a-=indexed, e.b-=indexed;\r\n\t\t\tedges.emplace_back(e);\r\n\t\t}\r\
    \n\t}\r\n\tll kruskal() {\r\n\t\tsort(edges.begin(), edges.end());\r\n\t\tUnionFind\
    \ uf(n);\r\n\t\tlong long res=0;\r\n\t\tfor(const auto &ed: edges) {\r\n\t\t\t\
    if(uf.unite(ed.a,ed.b)) res+=ed.cost;\r\n\t\t}\r\n\t\treturn res;\r\n\t}\r\n};\n"
  code: "#pragma once\r\n\r\n#include <iostream>\r\n#include <vector>\r\n#include\
    \ <queue>\r\nusing namespace std;\r\n//#include \"template.hpp\"\r\ntemplate <class\
    \ T, class U> bool chmin(T& a, const U& b){ if(a>b){ a=b; return 1; } return 0;\
    \ }\r\nstruct edge {\r\nprivate:\r\n    int to;\r\npublic:\r\n    long long cost;\r\
    \n    edge(int to_, long long cost_): to(to_), cost(cost_){}\r\n    operator long\
    \ long() const { return to; }\r\n};\r\ntemplate <bool undirected=1> struct w_graph\
    \ {\r\n    vector<vector<edge>> g;\r\n    vector<int> pr;\r\n    w_graph(int n):\
    \ g(n), pr(n){}\r\n    vector<edge>& operator[](int x){ return g[x]; }\r\n   \
    \ const vector<edge>& operator[](int x) const { return g[x]; }\r\n    operator\
    \ vector<vector<edge>>&(){ return g; }\r\n    operator const vector<vector<edge>>&()\
    \ const { return g; }\r\n    auto begin() const { return g.cbegin(); }\r\n   \
    \ auto end() const { return g.cend(); }\r\n    int size() const { return g.size();\
    \ }\r\n    void add(int a, int b, long long cost, int indexed=1) {\r\n       \
    \ a-=indexed,b-=indexed;\r\n        g[a].emplace_back(b, cost);\r\n        pr[b]\
    \ = a;\r\n        if(undirected) g[b].emplace_back(a, cost);\r\n    }\r\n    void\
    \ input(int m, int indexed=1) {\r\n        for(int i = 0; i < m; ++i) {\r\n  \
    \          int a, b;\r\n            long long c;\r\n            cin >> a >> b\
    \ >> c;\r\n            add(a, b, c, indexed);\r\n        }\r\n    }\r\n    vector<edge>\
    \ par(int v){ return g[pr[v]]; }\r\n    vector<int> all_dist(int v) {\r\n    \
    \    vector<int> d(g.size(),-1);\r\n        queue<int> q;\r\n        d[v]=0;\r\
    \n        q.emplace(v);\r\n        while(q.size()) {\r\n            int tmp=q.front();\r\
    \n            q.pop();\r\n            for(const auto &el: g[tmp]) {\r\n      \
    \          if(d[el]!=-1) continue;\r\n                d[el]=d[tmp]+1;\r\n    \
    \            q.emplace(el);\r\n            }\r\n        }\r\n        return d;\r\
    \n    }\r\n    int dist(int u, int v) {\r\n        const auto d=all_dist(u);\r\
    \n        return d[v];\r\n    }\r\n    vector<long long> dijkstra(int v) {\r\n\
    \        vector<long long> cst(g.size(), 1LL << 60);\r\n        priority_queue<pair<long\
    \ long, int>, vector<pair<long long, int>>, greater<pair<long long, int>>> dj;\r\
    \n        cst[v]=0;\r\n        dj.emplace(cst[v],v);\r\n        while(dj.size())\
    \ {\r\n            const auto tmp=dj.top();\r\n            dj.pop();\r\n     \
    \       if(cst[tmp.second]<tmp.first) continue;\r\n            for(auto el: g[tmp.second])\
    \ if(chmin(cst[el],tmp.first+el.cost)) dj.emplace(cst[el],el);\r\n        }\r\n\
    \        return cst;\r\n    }\r\n    vector<vector<long long>> warshall_floyd()\
    \ {\r\n\t\tconst int n = g.size();\r\n\t\tvector cst(n, vector(n, (1LL << 61)\
    \ - 1));\r\n\t\tfor(int i = 0; i < n; ++i) cst[i][i]=0;\r\n\t\tfor(int i = 0;\
    \ i < n; ++i) for(const auto &j: g[i]) cst[i][j]=j.cost;\r\n\t\tfor(int k = 0\
    \ ; k < n; ++k) {\r\n            for(int i = 0; i < n; ++i) {\r\n            \
    \    for(int j = 0; j < n; ++j) chmin(cst[i][j],cst[i][k]+cst[k][j]);\r\n    \
    \        }\r\n        }\r\n\t\treturn cst;\r\n\t}\r\n};\r\ntemplate <bool undirected=1>\
    \ struct graph {\r\n    vector<vector<int>> g;\r\n    vector<int> pr;\r\n    graph(int\
    \ n): g(n), pr(n){}\r\n    vector<int>& operator[](int x){ return g[x]; }\r\n\
    \    const vector<int>& operator[](int x) const { return g[x]; }\r\n    operator\
    \ vector<vector<int>>&(){ return g; }\r\n    operator const vector<vector<int>>&()\
    \ const { return g; }\r\n    auto begin() const { return g.cbegin(); }\r\n   \
    \ auto end() const { return g.cend(); }\r\n    int size() const { return g.size();\
    \ }\r\n    void add(int a, int b, int indexed=1) {\r\n        a-=indexed,b-=indexed;\r\
    \n        g[a].emplace_back(b);\r\n        pr[b] = a;\r\n        if(undirected)\
    \ g[b].emplace_back(a);\r\n    }\r\n    void input(int m, int indexed=1) {\r\n\
    \        for(int i = 0; i < m; ++i) {\r\n            int a, b;\r\n           \
    \ cin >> a >> b;\r\n            add(a,b,indexed);\r\n        }\r\n    }\r\n  \
    \  vector<int> par(int v){ return g[pr[v]]; }\r\n    vector<int> all_dist(int\
    \ v) {\r\n        vector<int> d(g.size(),-1);\r\n        queue<int> q;\r\n   \
    \     d[v]=0;\r\n        q.emplace(v);\r\n        while(q.size()) {\r\n      \
    \      int tmp=q.front();\r\n            q.pop();\r\n            for(auto el:\
    \ g[tmp]) {\r\n                if(d[el]!=-1) continue;\r\n                d[el]=d[tmp]+1;\r\
    \n                q.emplace(el);\r\n            }\r\n        }\r\n        return\
    \ d;\r\n    }\r\n    int dist(int u, int v) {\r\n        const auto d=all_dist(u);\r\
    \n        return d[v];\r\n    }\r\n};\r\n#include <C++/UnionFind.hpp>\r\nstruct\
    \ Edge {\r\n\tlong long a, b, cost;\r\n\tbool operator<(const Edge& e) const {\r\
    \n\t\treturn cost < e.cost;\r\n\t}\r\n};\r\nstruct Graph {\r\n\tint n;\r\n\tvector<Edge>\
    \ edges;\r\n\tGraph(const int n_): n(n_){}\r\n\tvoid input(ll m, const uint indexed=1)\
    \ {\r\n\t\twhile(m--) {\r\n\t\t\tEdge e;\r\n            cin >> e.a >> e.b >> e.cost;\r\
    \n\t\t\te.a-=indexed, e.b-=indexed;\r\n\t\t\tedges.emplace_back(e);\r\n\t\t}\r\
    \n\t}\r\n\tll kruskal() {\r\n\t\tsort(edges.begin(), edges.end());\r\n\t\tUnionFind\
    \ uf(n);\r\n\t\tlong long res=0;\r\n\t\tfor(const auto &ed: edges) {\r\n\t\t\t\
    if(uf.unite(ed.a,ed.b)) res+=ed.cost;\r\n\t\t}\r\n\t\treturn res;\r\n\t}\r\n};"
  dependsOn:
  - C++/UnionFind.hpp
  isVerificationFile: false
  path: C++/graph.hpp
  requiredBy: []
  timestamp: '2023-11-28 11:03:21+09:00'
  verificationStatus: LIBRARY_ALL_WA
  verifiedWith:
  - test/lca.test.cpp
documentation_of: C++/graph.hpp
layout: document
redirect_from:
- /library/C++/graph.hpp
- /library/C++/graph.hpp.html
title: C++/graph.hpp
---
