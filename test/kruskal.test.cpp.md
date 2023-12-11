---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/UnionFind.hpp
    title: C++/UnionFind.hpp
  - icon: ':heavy_check_mark:'
    path: C++/graph.hpp
    title: C++/graph.hpp
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://onlinejudge.u-aizu.ac.jp/courses/library/5/GRL/all/GRL_2_A
    links:
    - https://onlinejudge.u-aizu.ac.jp/courses/library/5/GRL/all/GRL_2_A
  bundledCode: "#line 1 \"test/kruskal.test.cpp\"\n#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/library/5/GRL/all/GRL_2_A\"\
    \n#line 2 \"C++/graph.hpp\"\n\r\n#include <iostream>\r\n#include <vector>\r\n\
    #include <queue>\r\nusing namespace std;\r\n//#include \"template.hpp\"\r\ntemplate\
    \ <class T, class U> bool chmin(T& a, const U& b){ if(a>b){ a=b; return 1; } return\
    \ 0; }\r\nstruct edge {\r\n    int src, to;\r\n    long long cost;\r\n    edge(){}\r\
    \n    edge(const int to_): to(to_){}\r\n    edge(const int to_, const long long\
    \ cost_): to(to_), cost(cost_){}\r\n    edge(const int src_, const int to_, const\
    \ long long cost_): src(src_), to(to_), cost(cost_){}\r\n};\r\ntemplate <bool\
    \ undirected = true> struct graph: std::vector<std::vector<edge>> {\r\nprivate:\r\
    \n    const int indexed;\r\npublic:\r\n    graph(const int n, const int indexed_\
    \ = 1): indexed(indexed_) {\r\n        this -> resize(n);\r\n    }\r\n    void\
    \ add(int a, int b) {\r\n        a -= indexed, b-= indexed;\r\n        (*this)[a].emplace_back(edge(b));\r\
    \n        if(undirected) {\r\n            (*this)[b].emplace_back(edge(a));\r\n\
    \        }\r\n    }\r\n    void input(const int m) {\r\n        for(int i = 0;\
    \ i < m; ++i) {\r\n            int a, b;\r\n            std::cin >> a >> b;\r\n\
    \            add(a, b);\r\n        }\r\n    }\r\nprotected:\r\n    std::vector<int>\
    \ all_dist(const int v) {\r\n        std::vector<int> d(this -> size(), -1);\r\
    \n        std::queue<int> q;\r\n        d[v] = 0;\r\n        q.emplace(v);\r\n\
    \        while(q.size()) {\r\n            const int tmp = q.front();\r\n     \
    \       q.pop();\r\n            for(const auto &el: (*this)[tmp]) {\r\n      \
    \          if(d[el.to] != -1) {\r\n                    continue;\r\n         \
    \       }\r\n                d[el.to] = d[tmp] + 1;\r\n                q.emplace(el.to);\r\
    \n            }\r\n        }\r\n        return d;\r\n    }\r\n    int dist(const\
    \ int u, const int v) const { return all_dist(u)[v]; }\r\n};\r\ntemplate <bool\
    \ undirected = true> struct w_graph: graph<undirected> {\r\nprivate:\r\n    const\
    \ int indexed;\r\npublic:\r\n    w_graph(const int n, const int indexed_ = 1):\
    \ graph<undirected>(n, indexed_){}\r\n    void add(int a, int b, const long long\
    \ cost) {\r\n        a -= indexed, b -= indexed;\r\n        (*this)[a].emplace_back(edge(b,\
    \ cost));\r\n        if(undirected) {\r\n            (*this)[b].emplace_back(edge(a,\
    \ cost));\r\n        }\r\n    }\r\n    void input(const int m) {\r\n        for(int\
    \ i = 0; i < m; ++i) {\r\n            int a, b;\r\n            long long c;\r\n\
    \            std::cin >> a >> b >> c;\r\n            add(a, b, c);\r\n       \
    \ }\r\n    }\r\n    std::vector<long long> dijkstra(const int v) {\r\n       \
    \ std::vector<long long> cst(this -> size(), (1LL << 61) - 1);\r\n        std::priority_queue<std::pair<long\
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
    };\r\n\r\n#line 2 \"C++/UnionFind.hpp\"\n\r\n// inspired by maspy(https://github.com/maspypy/library/blob/main/ds/unionfind/unionfind.hpp)\r\
    \n#include <cassert>\r\n#line 6 \"C++/UnionFind.hpp\"\n#include <algorithm>\r\n\
    #include <stack>\r\nstruct UnionFind {\r\nprivate:\r\n    std::vector<int> par;\r\
    \npublic:\r\n    UnionFind(const int n): par(n, -1){}\r\n    int operator[](int\
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
    \ ok;\r\n    }\r\n};\r\n\r\n// inspired by tatyam( https://github.com/tatyam-prime/kyopro_library/blob/master/UnionFind.cpp\
    \ )\r\nstruct UFPotential {\r\nprivate:\r\n    std::vector<int> par;\r\n    std::vector<long\
    \ long> diff;\r\npublic:\r\n    UFPotential(const int n): par(n, -1), diff(n){}\r\
    \n    int root(const int i) {\r\n        if(par[i] < 0) {\r\n            return\
    \ i;\r\n        }\r\n        const int r = root(par[i]);\r\n        diff[i] +=\
    \ diff[par[i]];\r\n        return par[i] = r;\r\n    }\r\n    long long dist(const\
    \ int i) {\r\n        root(i);\r\n        return diff[i];\r\n    }\r\n    long\
    \ long dist(const int x, const int y){ return dist(y) - dist(x); }\r\n    int\
    \ unite(int x, int y, long long w) {\r\n        w += dist(y, x);\r\n        x\
    \ = root(x), y = root(y);\r\n        if(x == y) {\r\n            return w == 0\
    \ ? 0 : -1;\r\n        }\r\n        if(par[x] > par[y]) {\r\n            std::swap(x,\
    \ y);\r\n            w = -w;\r\n        }\r\n        par[x] += par[y];\r\n   \
    \     par[y] = x;\r\n        diff[y] = w;\r\n        return 1;\r\n    }\r\n  \
    \  int operator[](const int i) noexcept { return root(i); }\r\n};\r\n\r\n// inspired\
    \ by Luzhiled( https://ei1333.github.io/luzhiled/snippets/structure/union-find.html\
    \ )\r\nstruct UFUndo {\r\nprivate:\r\n    std::vector<int> par;\r\n\tstd::stack<std::pair<int,\
    \ int>> his;\r\npublic:\r\n\tUFUndo(const int n): par(n, -1){}\r\n    bool unite(int\
    \ x, int y) {\r\n\t\tx = root(x);\r\n\t\ty = root(y);\r\n\t\this.emplace(std::make_pair(x,\
    \ par[x]));\r\n\t\this.emplace(std::make_pair(y, par[y]));\r\n\t\tif(x == y) {\r\
    \n\t\t\treturn false;\r\n\t\t}\r\n\t\tif(par[x] > par[y]) {\r\n\t\t\tstd::swap(x,\
    \ y);\r\n\t\t}\r\n\t\tpar[x] += par[y];\r\n\t\tpar[y] = x;\r\n\t\treturn true;\r\
    \n\t}\r\n    int root(int k) {\r\n        if(par[k] < 0) {\r\n            return\
    \ k;\r\n        }\r\n        return root(par[k]);\r\n    }\r\n    int size(const\
    \ int i){ return -par[root(i)]; }\r\n    void undo() {\r\n\t\tpar[his.top().first]\
    \ = his.top().second;\r\n        his.pop();\r\n\t\tpar[his.top().first] = his.top().second;\r\
    \n        his.pop();\r\n\t}\r\n    void snapshot() {\r\n\t\twhile(his.size())\
    \ {\r\n\t\t\this.pop();\r\n\t\t}\r\n\t}\r\n\tvoid rollback() {\r\n\t\twhile(his.size())\
    \ {\r\n\t\t\tundo();\r\n\t\t}\r\n\t}\r\n};\n#line 121 \"C++/graph.hpp\"\nstruct\
    \ tree {\r\nprivate:\r\n\tint n, indexed;\r\n\tstd::vector<edge> edges;\r\npublic:\r\
    \n\ttree(const int n_, const int indexed_ = 1): n(n_), indexed(indexed_){}\r\n\
    \tvoid input(int m) {\r\n\t\twhile(m--) {\r\n            edge e;\r\n         \
    \   std::cin >> e.src >> e.to >> e.cost;\r\n\t\t\te.src -= indexed, e.to -= indexed;\r\
    \n\t\t\tedges.emplace_back(e);\r\n\t\t}\r\n\t}\r\n\tlong long kruskal() {\r\n\
    \        std::sort(edges.begin(), edges.end(), [&](const edge &e, const edge &f){\
    \ return e.cost < f.cost; });\r\n\t\tUnionFind uf(n);\r\n\t\tlong long res = 0;\r\
    \n\t\tfor(const auto &ed: edges) {\r\n\t\t\tif(uf.unite(ed.src, ed.to)) {\r\n\
    \                res += ed.cost;\r\n            }\r\n\t\t}\r\n\t\treturn res;\r\
    \n\t}\r\n};\n#line 3 \"test/kruskal.test.cpp\"\nint main() {\n    std::cin.tie(nullptr)\
    \ -> sync_with_stdio(false);\n    int n, m;\n    std::cin >> n >> m;\n    tree\
    \ g(n, 0);\n    g.input(m);\n    std::cout << g.kruskal() << '\\n';\n}\n"
  code: "#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/library/5/GRL/all/GRL_2_A\"\
    \n#include \"C++/graph.hpp\"\nint main() {\n    std::cin.tie(nullptr) -> sync_with_stdio(false);\n\
    \    int n, m;\n    std::cin >> n >> m;\n    tree g(n, 0);\n    g.input(m);\n\
    \    std::cout << g.kruskal() << '\\n';\n}"
  dependsOn:
  - C++/graph.hpp
  - C++/UnionFind.hpp
  isVerificationFile: true
  path: test/kruskal.test.cpp
  requiredBy: []
  timestamp: '2023-12-11 21:48:09+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/kruskal.test.cpp
layout: document
redirect_from:
- /verify/test/kruskal.test.cpp
- /verify/test/kruskal.test.cpp.html
title: test/kruskal.test.cpp
---
