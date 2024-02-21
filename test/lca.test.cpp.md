---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/graph/Graph.hpp
    title: "\u30B0\u30E9\u30D5\u30E9\u30A4\u30D6\u30E9\u30EA"
  - icon: ':heavy_check_mark:'
    path: C++/graph/LCA.hpp
    title: "\u6700\u5C0F\u5171\u901A\u7956\u5148"
  - icon: ':heavy_check_mark:'
    path: C++/graph/edge.hpp
    title: Edge
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
    \n#line 2 \"C++/graph/Graph.hpp\"\n\r\n#include <iostream>\r\n#include <vector>\r\
    \n#include <queue>\r\n#include <stack>\r\n#ifndef TEMPLATE\r\ntemplate <class\
    \ T, class U> bool chmin(T& a, const U& b){ if(a>b){ a=b; return 1; } return 0;\
    \ }\r\n#endif\r\n#line 2 \"C++/graph/edge.hpp\"\n\nstruct edge {\n    int src,\
    \ to, id;\n    long long cost;\n    edge(){}\n    edge(const int src_, const int\
    \ to_, const int id_ = -1, const long long cost_ = 0): src(src_), to(to_), id(id_),\
    \ cost(cost_){}\n    operator int() const { return to; }\n};\n\n/**\n * @brief\
    \ Edge\n */\n#line 11 \"C++/graph/Graph.hpp\"\ntemplate <bool undirected = true>\
    \ struct graph: std::vector<std::vector<edge>> {\r\nprotected:\r\n    const int\
    \ indexed;\r\n    int id;\r\n    std::vector<edge> edges;\r\npublic:\r\n    graph(const\
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
    \u30E9\u30A4\u30D6\u30E9\u30EA\r\n */\n#line 2 \"C++/graph/LCA.hpp\"\n\r\n#pragma\
    \ GCC diagnostic ignored \"-Wreorder\"\r\n\r\n#line 6 \"C++/graph/LCA.hpp\"\n\
    template <class G> struct LowestCommonAncestor {\r\nprivate:\r\n    const int\
    \ LOG;\r\n    std::vector<int> dep, sum;\r\n    const G &g;\r\n    std::vector<std::vector<int>>\
    \ table;\r\n    void dfs(const int idx, const int par, const int d) {\r\n    \
    \    table[0][idx] = par;\r\n        dep[idx] = d;\r\n        for(const auto &el:\
    \ g[idx]) {\r\n            if(el != par) {\r\n                sum[el] = sum[idx]\
    \ + el.cost;\r\n                dfs(el, idx, d + 1);\r\n            }\r\n    \
    \    }\r\n    }\r\n    void build() {\r\n        dfs(0, -1, 0);\r\n        for(int\
    \ k = 0; k < LOG - 1; ++k) {\r\n            for(size_t i = 0; i < table[k].size();\
    \ ++i) {\r\n                if(table[k][i] == -1) {\r\n                    table[k\
    \ + 1][i] = -1;\r\n                }\r\n                else {\r\n           \
    \         table[k + 1][i] = table[k][table[k][i]];\r\n                }\r\n  \
    \          }\r\n        }\r\n    }\r\npublic:\r\n    LowestCommonAncestor(const\
    \ G &g_) : g(g_), dep(g_.size()), sum(g_.size()), LOG(std::__lg(g_.size()) + 1)\
    \ {\r\n        table.assign(LOG, std::vector<int>(g_.size(), -1));\r\n       \
    \ build();\r\n    }\r\n    int climb(int u, const int k) {\r\n\t\tif(dep[u] <\
    \ k) {\r\n\t\t\treturn -1;\r\n\t\t}\r\n\t\tfor(int i = LOG; --i >= 0;) {\r\n\t\
    \t\tif((k >> i) & 1) {\r\n                u = table[i][u];\r\n            }\r\n\
    \t\t}\r\n\t\treturn u;\r\n\t}\r\n    int query(int u, int v) {\r\n        if(dep[u]\
    \ > dep[v]) {\r\n            std::swap(u, v);\r\n        }\r\n        v = climb(v,\
    \ dep[v] - dep[u]);\r\n        if(u == v) {\r\n            return u;\r\n     \
    \   }\r\n        for(int i = LOG; --i >= 0;) {\r\n            if(table[i][u] !=\
    \ table[i][v]) {\r\n                u = table[i][u];\r\n                v = table[i][v];\r\
    \n            }\r\n        }\r\n        return table[0][u];\r\n    }\r\n    int\
    \ dist(const int u, const int v){ return sum[u] + sum[v] - 2 * sum[query(u, v)];\
    \ }\r\n};\r\n/**\r\n * @brief \u6700\u5C0F\u5171\u901A\u7956\u5148\r\n * @docs\
    \ docs/LCA.md\r\n * @see https://ei1333.github.io/luzhiled/snippets/tree/doubling-lowest-common-ancestor.html\r\
    \n */\n#line 4 \"test/lca.test.cpp\"\nint main() {\n    std::cin.tie(nullptr)\
    \ -> sync_with_stdio(false);\n    int n, q;\n    std::cin >> n >> q;\n    graph<false>\
    \ g(n, 0);\n    for(int i = 1; i < n; ++i) {\n        int p;\n        std::cin\
    \ >> p;\n        g.add(p, i);\n    }\n    LowestCommonAncestor lca(g);\n    while(q--)\
    \ {\n        int u, v;\n        std::cin >> u >> v;\n        std::cout << lca.query(u,\
    \ v) << '\\n';\n    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/lca\"\n#include \"C++/graph/Graph.hpp\"\
    \n#include \"C++/graph/LCA.hpp\"\nint main() {\n    std::cin.tie(nullptr) -> sync_with_stdio(false);\n\
    \    int n, q;\n    std::cin >> n >> q;\n    graph<false> g(n, 0);\n    for(int\
    \ i = 1; i < n; ++i) {\n        int p;\n        std::cin >> p;\n        g.add(p,\
    \ i);\n    }\n    LowestCommonAncestor lca(g);\n    while(q--) {\n        int\
    \ u, v;\n        std::cin >> u >> v;\n        std::cout << lca.query(u, v) <<\
    \ '\\n';\n    }\n}"
  dependsOn:
  - C++/graph/Graph.hpp
  - C++/graph/edge.hpp
  - C++/graph/LCA.hpp
  isVerificationFile: true
  path: test/lca.test.cpp
  requiredBy: []
  timestamp: '2024-02-21 13:55:49+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/lca.test.cpp
layout: document
redirect_from:
- /verify/test/lca.test.cpp
- /verify/test/lca.test.cpp.html
title: test/lca.test.cpp
---
