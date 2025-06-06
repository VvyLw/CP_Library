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
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: cpp
  _verificationStatusIcon: ':x:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://onlinejudge.u-aizu.ac.jp/courses/library/5/GRL/1/GRL_1_B
    links:
    - https://onlinejudge.u-aizu.ac.jp/courses/library/5/GRL/1/GRL_1_B
  bundledCode: "#line 1 \"test/spfa.test.cpp\"\n#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/library/5/GRL/1/GRL_1_B\"\
    \n#line 2 \"C++/graph/WeightedGraph.hpp\"\n\n#line 2 \"C++/graph/Graph.hpp\"\n\
    \r\n#include <iostream>\r\n#include <vector>\r\n#include <algorithm>\r\n#include\
    \ <queue>\r\n#include <stack>\r\n#include <ranges>\r\n#ifndef TEMPLATE\r\nnamespace\
    \ man {\r\ntemplate <class T, class U> bool chmin(T& a, const U& b){ if(a>b){\
    \ a=b; return 1; } return 0; }\r\n}\r\n#endif\r\n#line 2 \"C++/graph/edge.hpp\"\
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
    \u30D5\u30E9\u30A4\u30D6\u30E9\u30EA\r\n */\n#line 2 \"C++/graph/ShortestPath.hpp\"\
    \n\n#pragma GCC diagnostic ignored \"-Wreorder\"\n\n#line 7 \"C++/graph/ShortestPath.hpp\"\
    \nnamespace man {\nstruct ShortestPath {\nprivate:\n    const std::vector<int64_t>\
    \ cost;\n    const std::vector<int> src;\npublic:\n    ShortestPath(const std::vector<int64_t>\
    \ &cost, const std::vector<int> &src): cost(cost), src(src){}\n    inline bool\
    \ is_thru(const int i) const noexcept { return src[i] != -1; }\n    inline std::vector<int>\
    \ path(int i) noexcept {\n        std::vector<int> ret;\n        for(; i != -1;\
    \ i = src[i]) {\n            ret.emplace_back(i);\n        }\n        std::ranges::reverse(ret);\n\
    \        return ret;\n    }\n    inline std::vector<int64_t> get() const noexcept\
    \ { return cost; }\n};\n}\n\n/**\n * @brief \u6700\u77ED\u8DEF\n */\n#line 5 \"\
    C++/graph/WeightedGraph.hpp\"\nnamespace man {\ntemplate <bool undirected = true>\
    \ struct w_graph: graph<undirected> {\nprotected:\n    using graph<undirected>::indexed;\n\
    \    using graph<undirected>::id;\n    using graph<undirected>::edges;\npublic:\n\
    \    w_graph(const int n, const int indexed_ = 1): graph<undirected>(n, indexed_){}\n\
    \    using graph<undirected>::get_edge;\n    using graph<undirected>::all_dist;\n\
    \    using graph<undirected>::dist;\n    using graph<undirected>::t_sort;\n  \
    \  using graph<undirected>::cycle;\n    inline void add(int a, int b, const int64_t\
    \ cost) noexcept {\n        a -= indexed, b -= indexed;\n        (*this)[a].emplace_back(a,\
    \ b, id, cost);\n        edges.emplace_back(a, b, id++, cost);\n        if(undirected)\
    \ {\n            (*this)[b].emplace_back(b, a, --id, cost);\n            edges.emplace_back(b,\
    \ a, id++, cost);\n        }\n    }\n    inline void input(const int m) noexcept\
    \ {\n        for([[maybe_unused]] const auto _: std::views::iota(0, m)) {\n  \
    \          int a, b;\n            int64_t c;\n            std::cin >> a >> b >>\
    \ c;\n            add(a, b, c);\n        }\n    }\n    inline ShortestPath dijkstra(const\
    \ int v) noexcept {\n        std::vector<int64_t> cst(this->size(), (1LL << 61)\
    \ - 1);\n        std::vector<int> src(this->size(), -1);\n        std::priority_queue<std::pair<int64_t,\
    \ int>, std::vector<std::pair<int64_t, int>>, std::greater<std::pair<int64_t,\
    \ int>>> dj;\n        cst[v] = 0;\n        dj.emplace(cst[v], v);\n        while(!dj.empty())\
    \ {\n            const auto tmp = dj.top();\n            dj.pop();\n         \
    \   if(cst[tmp.second] < tmp.first) {\n                continue;\n           \
    \ }\n            for(const auto &el: (*this)[tmp.second]) {\n                if(chmin(cst[el],\
    \ tmp.first + el.cost)) {\n                    src[el] = tmp.second;\n       \
    \             dj.emplace(cst[el], el);\n                }\n            }\n   \
    \     }\n        return {cst, src};\n    }\n    inline std::vector<int64_t> spfa(const\
    \ int v) noexcept {\n        const int n = this -> size();\n        std::vector<int64_t>\
    \ cst(n, (1LL << 61) - 1);\n        std::vector<int> pending(n), times(n);\n \
    \       std::queue<int> q;\n        q.emplace(v);\n        pending[v] = 1;\n \
    \       ++times[v];\n        cst[v] = 0;\n        while(!q.empty()) {\n      \
    \      const int p = q.front();\n            q.pop();\n            pending[p]\
    \ = 0;\n            for(const auto &e : (*this)[p]) {\n                const int64_t\
    \ next = cst[p] + e.cost;\n                if(next >= cst[e]) {\n            \
    \        continue;\n                }\n                cst[e] = next;\n      \
    \          if(!pending[e]) {\n                    if(++times[e] >= n) {\n    \
    \                    cst.clear();\n                        return cst;\n     \
    \               }\n                    pending[e] = 1;\n                    q.emplace(e);\n\
    \                }\n            }\n        }\n\t\treturn cst;\n    }\n    std::vector<std::vector<int64_t>>\
    \ warshall_floyd() {\n\t\tconst int n = this -> size();\n        const int64_t\
    \ lim = (1LL << 61) - 1;\n\t\tstd::vector cst(n, std::vector(n, lim));\n\t\tfor(const\
    \ auto i: std::views::iota(0, n)) {\n            cst[i][i] = 0;\n        }\n\t\
    \tfor(const auto i: std::views::iota(0, n)) {\n            for(const auto &j:\
    \ (*this)[i]) {\n                cst[i][j] = j.cost;\n            }\n        }\n\
    \t\tfor(const auto k: std::views::iota(0, n)) {\n            for(const auto i:\
    \ std::views::iota(0, n)) {\n                for(const auto j: std::views::iota(0,\
    \ n)) {\n                    if(cst[i][k] == lim || cst[k][j] == lim) {\n    \
    \                    continue;\n                    }\n                    chmin(cst[i][j],\
    \ cst[i][k] + cst[k][j]);\n                }\n            }\n        }\n\t\treturn\
    \ cst;\n\t}\n};\n}\n\n/**\n * @brief \u91CD\u307F\u4ED8\u304D\u30B0\u30E9\u30D5\
    \u30E9\u30A4\u30D6\u30E9\u30EA\n */\n#line 3 \"test/spfa.test.cpp\"\nconstexpr\
    \ auto LIM = (1LL << 61) - 1;\nint main() {\n    int v, e, r;\n    std::cin >>\
    \ v >> e >> r;\n    man::w_graph<false> g(v, 0);\n    g.input(e);\n    const auto\
    \ res = g.spfa(r);\n    if(res.empty()) {\n        std::cout << \"NEGATIVE CYCLE\\\
    n\";\n        std::exit(0);\n    }\n    for(const auto &el: res) {\n        if(el\
    \ == LIM) {\n            std::cout << \"INF\\n\";\n        }\n        else {\n\
    \            std::cout << el << '\\n';\n        }\n    }\n}\n"
  code: "#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/library/5/GRL/1/GRL_1_B\"\
    \n#include \"C++/graph/WeightedGraph.hpp\"\nconstexpr auto LIM = (1LL << 61) -\
    \ 1;\nint main() {\n    int v, e, r;\n    std::cin >> v >> e >> r;\n    man::w_graph<false>\
    \ g(v, 0);\n    g.input(e);\n    const auto res = g.spfa(r);\n    if(res.empty())\
    \ {\n        std::cout << \"NEGATIVE CYCLE\\n\";\n        std::exit(0);\n    }\n\
    \    for(const auto &el: res) {\n        if(el == LIM) {\n            std::cout\
    \ << \"INF\\n\";\n        }\n        else {\n            std::cout << el << '\\\
    n';\n        }\n    }\n}"
  dependsOn:
  - C++/graph/WeightedGraph.hpp
  - C++/graph/Graph.hpp
  - C++/graph/edge.hpp
  - C++/graph/ShortestPath.hpp
  isVerificationFile: true
  path: test/spfa.test.cpp
  requiredBy: []
  timestamp: '2025-06-06 22:43:22+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: test/spfa.test.cpp
layout: document
redirect_from:
- /verify/test/spfa.test.cpp
- /verify/test/spfa.test.cpp.html
title: test/spfa.test.cpp
---
