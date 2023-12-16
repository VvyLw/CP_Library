---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/LCA.hpp
    title: C++/LCA.hpp
  - icon: ':question:'
    path: C++/edge.hpp
    title: C++/edge.hpp
  - icon: ':question:'
    path: C++/graph.hpp
    title: C++/graph.hpp
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://judge.yosupo.jp/problem/lca
    links:
    - https://judge.yosupo.jp/problem/lca
  bundledCode: "#line 1 \"test/lca.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/lca\"\
    \n#line 2 \"C++/LCA.hpp\"\n\r\n// inspired by Luzhiled( https://ei1333.github.io/luzhiled/snippets/tree/doubling-lowest-common-ancestor.html\
    \ )\r\n#include <vector>\r\ntemplate <class G> struct LowestCommonAncestor {\r\
    \nprivate:\r\n    const int LOG;\r\n    std::vector<int> dep, sum;\r\n    const\
    \ G &g;\r\n    std::vector<std::vector<int>> table;\r\n    void dfs(const int\
    \ idx, const int par, const int d) {\r\n        table[0][idx] = par;\r\n     \
    \   dep[idx] = d;\r\n        for(const auto &el: g[idx]) {\r\n            if(el.to\
    \ != par) {\r\n                sum[el.to] = sum[idx] + el.cost;\r\n          \
    \      dfs(el.to, idx, d + 1);\r\n            }\r\n        }\r\n    }\r\n    void\
    \ build() {\r\n        dfs(0, -1, 0);\r\n        for(int k = 0; k < LOG - 1; ++k)\
    \ {\r\n            for(size_t i = 0; i < table[k].size(); ++i) {\r\n         \
    \       if(table[k][i] == -1) {\r\n                    table[k + 1][i] = -1;\r\
    \n                }\r\n                else {\r\n                    table[k +\
    \ 1][i] = table[k][table[k][i]];\r\n                }\r\n            }\r\n   \
    \     }\r\n    }\r\npublic:\r\n    LowestCommonAncestor(const G &g_) : g(g_),\
    \ dep(g_.size()), sum(g_.size()), LOG(std::__lg(g_.size()) + 1) {\r\n        table.assign(LOG,\
    \ std::vector<int>(g_.size(), -1));\r\n        build();\r\n    }\r\n    int climb(int\
    \ u, const int k) {\r\n\t\tif(dep[u] < k) {\r\n\t\t\treturn -1;\r\n\t\t}\r\n\t\
    \tfor(int i = LOG; --i >= 0;) {\r\n\t\t\tif((k >> i) & 1) {\r\n              \
    \  u = table[i][u];\r\n            }\r\n\t\t}\r\n\t\treturn u;\r\n\t}\r\n    int\
    \ query(int u, int v) {\r\n        if(dep[u] > dep[v]) {\r\n            std::swap(u,\
    \ v);\r\n        }\r\n        v = climb(v, dep[v] - dep[u]);\r\n        if(u ==\
    \ v) {\r\n            return u;\r\n        }\r\n        for(int i = LOG; --i >=\
    \ 0;) {\r\n            if(table[i][u] != table[i][v]) {\r\n                u =\
    \ table[i][u];\r\n                v = table[i][v];\r\n            }\r\n      \
    \  }\r\n        return table[0][u];\r\n    }\r\n    int dist(const int u, const\
    \ int v){ return sum[u] + sum[v] - 2 * sum[query(u, v)]; }\r\n};\n#line 2 \"C++/graph.hpp\"\
    \n\r\n#include <iostream>\r\n#line 5 \"C++/graph.hpp\"\n#include <queue>\r\n#include\
    \ <stack>\r\n#include <limits>\r\n#if !__has_include(\"C++/template.hpp\")\r\n\
    template <class T, class U> bool chmin(T& a, const U& b){ if(a>b){ a=b; return\
    \ 1; } return 0; }\r\n#endif\r\n#line 2 \"C++/edge.hpp\"\n\nstruct edge {\n  \
    \  int src, to;\n    long long cost;\n    edge(){}\n    edge(const int to_): to(to_){}\n\
    \    edge(const int to_, const long long cost_): to(to_), cost(cost_){}\n    edge(const\
    \ int src_, const int to_, const long long cost_): src(src_), to(to_), cost(cost_){}\n\
    };\n#line 12 \"C++/graph.hpp\"\ntemplate <bool undirected = true> struct graph:\
    \ public std::vector<std::vector<edge>> {\r\n    const int indexed;\r\n    std::vector<edge>\
    \ edges;\r\n    graph(const int n, const int indexed_ = 1): indexed(indexed_){\
    \ this -> resize(n); }\r\n    void add(int a, int b) {\r\n        a -= indexed,\
    \ b-= indexed;\r\n        (*this)[a].emplace_back(b);\r\n        edges.emplace_back(a,\
    \ b, 0);\r\n        if(undirected) {\r\n            (*this)[b].emplace_back(a);\r\
    \n            edges.emplace_back(b, a, 0);\r\n        }\r\n    }\r\n    void input(const\
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
    };\n#line 4 \"test/lca.test.cpp\"\nint main() {\n    std::cin.tie(nullptr) ->\
    \ sync_with_stdio(false);\n    int n, q;\n    std::cin >> n >> q;\n    graph<false>\
    \ g(n, 0);\n    for(int i = 1; i < n; ++i) {\n        int p;\n        std::cin\
    \ >> p;\n        g.add(p, i);\n    }\n    LowestCommonAncestor lca(g);\n    while(q--)\
    \ {\n        int u, v;\n        std::cin >> u >> v;\n        std::cout << lca.query(u,\
    \ v) << '\\n';\n    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/lca\"\n#include \"C++/LCA.hpp\"\
    \n#include \"C++/graph.hpp\"\nint main() {\n    std::cin.tie(nullptr) -> sync_with_stdio(false);\n\
    \    int n, q;\n    std::cin >> n >> q;\n    graph<false> g(n, 0);\n    for(int\
    \ i = 1; i < n; ++i) {\n        int p;\n        std::cin >> p;\n        g.add(p,\
    \ i);\n    }\n    LowestCommonAncestor lca(g);\n    while(q--) {\n        int\
    \ u, v;\n        std::cin >> u >> v;\n        std::cout << lca.query(u, v) <<\
    \ '\\n';\n    }\n}"
  dependsOn:
  - C++/LCA.hpp
  - C++/graph.hpp
  - C++/edge.hpp
  isVerificationFile: true
  path: test/lca.test.cpp
  requiredBy: []
  timestamp: '2023-12-16 23:45:11+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/lca.test.cpp
layout: document
redirect_from:
- /verify/test/lca.test.cpp
- /verify/test/lca.test.cpp.html
title: test/lca.test.cpp
---
