---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/edge.hpp
    title: C++/edge.hpp
  - icon: ':heavy_check_mark:'
    path: C++/graph.hpp
    title: "\u30B0\u30E9\u30D5\u30E9\u30A4\u30D6\u30E9\u30EA"
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://judge.yosupo.jp/problem/cycle_detection
    links:
    - https://judge.yosupo.jp/problem/cycle_detection
  bundledCode: "#line 1 \"test/cycledetector.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/cycle_detection\"\
    \n#include <iostream>\n#line 2 \"C++/graph.hpp\"\n\r\n#line 4 \"C++/graph.hpp\"\
    \n#include <vector>\r\n#include <queue>\r\n#include <stack>\r\n#include <limits>\r\
    \n#ifndef TEMPLATE\r\ntemplate <class T, class U> bool chmin(T& a, const U& b){\
    \ if(a>b){ a=b; return 1; } return 0; }\r\n#endif\r\n#line 2 \"C++/edge.hpp\"\n\
    \nstruct edge {\n    int src, to, id;\n    long long cost;\n    edge(){}\n   \
    \ edge(const int src_, const int to_, const int id_ = -1, const long long cost_\
    \ = 0): src(src_), to(to_), id(id_), cost(cost_){}\n    operator int() const {\
    \ return to; }\n};\n#line 12 \"C++/graph.hpp\"\ntemplate <bool undirected = true>\
    \ struct graph: public std::vector<std::vector<edge>> {\r\n    const int indexed;\r\
    \n    int id;\r\n    std::vector<edge> edges;\r\n    graph(const int n, const\
    \ int indexed_ = 1): indexed(indexed_), id(0){ this -> resize(n); }\r\n    void\
    \ add(int a, int b) {\r\n        a -= indexed, b-= indexed;\r\n        (*this)[a].emplace_back(a,\
    \ b, id);\r\n        edges.emplace_back(a, b, id++);\r\n        if(undirected)\
    \ {\r\n            (*this)[b].emplace_back(b, a, --id);\r\n            edges.emplace_back(b,\
    \ a, id++);\r\n        }\r\n    }\r\n    void input(const int m) {\r\n       \
    \ for(int i = 0; i < m; ++i) {\r\n            int a, b;\r\n            std::cin\
    \ >> a >> b;\r\n            add(a, b);\r\n        }\r\n    }\r\n    std::vector<int>\
    \ all_dist(const int v) {\r\n        std::vector<int> d(this -> size(), -1);\r\
    \n        std::queue<int> q;\r\n        d[v] = 0;\r\n        q.emplace(v);\r\n\
    \        while(q.size()) {\r\n            const int tmp = q.front();\r\n     \
    \       q.pop();\r\n            for(const auto &el: (*this)[tmp]) {\r\n      \
    \          if(d[el] != -1) {\r\n                    continue;\r\n            \
    \    }\r\n                d[el] = d[tmp] + 1;\r\n                q.emplace(el);\r\
    \n            }\r\n        }\r\n        return d;\r\n    }\r\n    int dist(const\
    \ int u, const int v) const { return all_dist(u)[v]; }\r\n    std::vector<int>\
    \ t_sort() {\r\n        const int n = this -> size();\r\n\t\tstd::vector<int>\
    \ deg(n);\r\n\t\tfor(int i = 0; i < n; ++i) {\r\n\t\t\tfor(const auto ed: (*this)[i])\
    \ {\r\n\t\t\t\tdeg[ed]++;\r\n\t\t\t}\r\n\t\t}\r\n\t\tstd::stack<int> sk;\r\n\t\
    \tfor(int i = 0; i < n; ++i) {\r\n\t\t\tif(deg[i] == 0) {\r\n\t\t\t\tsk.emplace(i);\r\
    \n\t\t\t}\r\n\t\t}\r\n\t\tstd::vector<int> ord;\r\n\t\twhile(sk.size()) {\r\n\t\
    \t\tconst auto tmp = sk.top();\r\n            sk.pop();\r\n\t\t\tord.emplace_back(tmp);\r\
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
    \n\t\t\t}\r\n\t\t}\r\n\t\treturn {};\r\n    }\r\n};\r\ntemplate <bool undirected\
    \ = true> struct w_graph: public graph<undirected> {\r\nprivate:\r\n    using\
    \ graph<undirected>::indexed;\r\n    using graph<undirected>::id;\r\n    using\
    \ graph<undirected>::edges;\r\npublic:\r\n    w_graph(const int n, const int indexed_\
    \ = 1): graph<undirected>(n, indexed_){}\r\n    using graph<undirected>::all_dist;\r\
    \n    using graph<undirected>::dist;\r\n    using graph<undirected>::t_sort;\r\
    \n    void add(int a, int b, const long long cost) {\r\n        a -= indexed,\
    \ b -= indexed;\r\n        (*this)[a].emplace_back(a, b, id, cost);\r\n      \
    \  edges.emplace_back(a, b, id++, cost);\r\n        if(undirected) {\r\n     \
    \       (*this)[b].emplace_back(b, a, --id, cost);\r\n            edges.emplace_back(b,\
    \ a, id++, cost);\r\n        }\r\n    }\r\n    void input(const int m) {\r\n \
    \       for(int i = 0; i < m; ++i) {\r\n            int a, b;\r\n            long\
    \ long c;\r\n            std::cin >> a >> b >> c;\r\n            add(a, b, c);\r\
    \n        }\r\n    }\r\n    std::vector<long long> dijkstra(const int v) {\r\n\
    \        std::vector<long long> cst(this -> size(), (1LL << 61) - 1);\r\n    \
    \    std::priority_queue<std::pair<long long, int>, std::vector<std::pair<long\
    \ long, int>>, std::greater<std::pair<long long, int>>> dj;\r\n        cst[v]\
    \ = 0;\r\n        dj.emplace(cst[v], v);\r\n        while(dj.size()) {\r\n   \
    \         const auto tmp = dj.top();\r\n            dj.pop();\r\n            if(cst[tmp.second]\
    \ < tmp.first) {\r\n                continue;\r\n            }\r\n           \
    \ for(const auto &el: (*this)[tmp.second]) {\r\n                if(chmin(cst[el],\
    \ tmp.first + el.cost)) {\r\n                    dj.emplace(cst[el], el);\r\n\
    \                }\r\n            }\r\n        }\r\n        return cst;\r\n  \
    \  }\r\n    std::vector<long long> bellman_ford(const int v) {\r\n        const\
    \ long long lim = std::numeric_limits<long long>::max();\r\n        std::vector<long\
    \ long> cst(this -> size(), lim);\r\n        cst[v] = 0;\r\n        for(size_t\
    \ i = 0; i < this -> size() - 1; ++i) {\r\n\t\t\tfor(const auto &e: edges) {\r\
    \n\t\t\t\tif(cst[e.src] == lim) {\r\n\t\t\t\t\tcontinue;\r\n\t\t\t\t}\r\n\t\t\t\
    \tchmin(cst[e], cst[e.src] + e.cost);\r\n\t\t\t}\r\n\t\t}\r\n\t\tfor(const auto\
    \ &e: edges) {\r\n\t\t\tif(cst[e.src] == lim) {\r\n\t\t\t\tcontinue;\r\n\t\t\t\
    }\r\n\t\t\tif(cst[e.src] + e.cost < cst[e]) {\r\n\t\t\t\treturn std::vector<long\
    \ long>{};\r\n\t\t\t}\r\n\t\t}\r\n\t\treturn cst;\r\n    }\r\n    std::vector<std::vector<long\
    \ long>> warshall_floyd() {\r\n\t\tconst int n = this -> size();\r\n        const\
    \ long long lim = (1LL << 61) - 1;\r\n\t\tstd::vector cst(n, std::vector(n, lim));\r\
    \n\t\tfor(int i = 0; i < n; ++i) {\r\n            cst[i][i] = 0;\r\n        }\r\
    \n\t\tfor(int i = 0; i < n; ++i) {\r\n            for(const auto &j: (*this)[i])\
    \ {\r\n                cst[i][j] = j.cost;\r\n            }\r\n        }\r\n\t\
    \tfor(int k = 0; k < n; ++k) {\r\n            for(int i = 0; i < n; ++i) {\r\n\
    \                for(int j = 0; j < n; ++j) {\r\n                    if(cst[i][k]\
    \ == lim || cst[k][j] == lim) {\r\n                        continue;\r\n     \
    \               }\r\n                    chmin(cst[i][j], cst[i][k] + cst[k][j]);\r\
    \n                }\r\n            }\r\n        }\r\n\t\treturn cst;\r\n\t}\r\n\
    };\r\ntypedef std::vector<edge> ve;\r\ntypedef std::vector<ve> we;\r\n/**\r\n\
    \ * @brief \u30B0\u30E9\u30D5\u30E9\u30A4\u30D6\u30E9\u30EA\r\n */\n#line 4 \"\
    test/cycledetector.test.cpp\"\nint main() {\n    int n, m;\n    std::cin >> n\
    \ >> m;\n    graph<false> g(n, 0);\n    g.input(m);\n    const auto res = g.cycle();\n\
    \    if(res.empty()) {\n        std::cout << -1 << '\\n';\n    } else {\n    \
    \    std::cout << res.size() << '\\n';\n        for(const auto &e: res) {\n  \
    \          std::cout << e.id << '\\n';\n        }\n    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/cycle_detection\"\n#include\
    \ <iostream>\n#include \"C++/graph.hpp\"\nint main() {\n    int n, m;\n    std::cin\
    \ >> n >> m;\n    graph<false> g(n, 0);\n    g.input(m);\n    const auto res =\
    \ g.cycle();\n    if(res.empty()) {\n        std::cout << -1 << '\\n';\n    }\
    \ else {\n        std::cout << res.size() << '\\n';\n        for(const auto &e:\
    \ res) {\n            std::cout << e.id << '\\n';\n        }\n    }\n}"
  dependsOn:
  - C++/graph.hpp
  - C++/edge.hpp
  isVerificationFile: true
  path: test/cycledetector.test.cpp
  requiredBy: []
  timestamp: '2024-02-17 11:08:09+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/cycledetector.test.cpp
layout: document
redirect_from:
- /verify/test/cycledetector.test.cpp
- /verify/test/cycledetector.test.cpp.html
title: test/cycledetector.test.cpp
---
