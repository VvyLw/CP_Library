---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: C++/graph/Graph.hpp
    title: "\u30B0\u30E9\u30D5\u30E9\u30A4\u30D6\u30E9\u30EA"
  - icon: ':x:'
    path: C++/graph/SCC.hpp
    title: "Strongly Connected Components(\u5F37\u9023\u7D50\u6210\u5206\u5206\u89E3\
      )"
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
    PROBLEM: https://judge.yosupo.jp/problem/scc
    links:
    - https://judge.yosupo.jp/problem/scc
  bundledCode: "#line 1 \"test/scc2.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/scc\"\
    \n#include <iostream>\n#line 2 \"C++/graph/Graph.hpp\"\n\r\n#line 4 \"C++/graph/Graph.hpp\"\
    \n#include <vector>\r\n#include <algorithm>\r\n#include <queue>\r\n#include <stack>\r\
    \n#include <ranges>\r\n#ifndef TEMPLATE\r\nnamespace man {\r\ntemplate <class\
    \ T, class U> bool chmin(T& a, const U& b){ if(a>b){ a=b; return 1; } return 0;\
    \ }\r\n}\r\n#endif\r\n#line 2 \"C++/graph/edge.hpp\"\n#ifndef EDGE\n#define EDGE\n\
    #endif\n\nnamespace man {\nstruct edge {\n    int src, to, id;\n    int64_t cost;\n\
    \    edge(){}\n    edge(const int src_, const int to_, const int id_ = -1, const\
    \ int64_t cost_ = 0): src(src_), to(to_), id(id_), cost(cost_){}\n    constexpr\
    \ inline operator int() const noexcept { return to; }\n};\n}\n\n/**\n * @brief\
    \ Edge\n */\n#line 15 \"C++/graph/Graph.hpp\"\nnamespace man {\r\ntemplate <bool\
    \ undirected = true> struct graph: std::vector<std::vector<edge>> {\r\nprotected:\r\
    \n    int indexed, id;\r\n    std::vector<edge> edges;\r\npublic:\r\n    graph(){}\r\
    \n    graph(const int n, const int indexed_ = 1): indexed(indexed_), id(0){ this->resize(n);\
    \ }\r\n    inline void add(int a, int b) noexcept {\r\n        a -= indexed, b-=\
    \ indexed;\r\n        (*this)[a].emplace_back(a, b, id);\r\n        edges.emplace_back(a,\
    \ b, id++);\r\n        if(undirected) {\r\n            (*this)[b].emplace_back(b,\
    \ a, --id);\r\n            edges.emplace_back(b, a, id++);\r\n        }\r\n  \
    \  }\r\n    inline void input(const int m) noexcept {\r\n        for([[maybe_unused]]\
    \ const auto _: std::views::iota(0, m)) {\r\n            int a, b;\r\n       \
    \     std::cin >> a >> b;\r\n            add(a, b);\r\n        }\r\n    }\r\n\
    \    inline std::vector<edge> get_edge() const noexcept { return edges; }\r\n\
    \    inline std::vector<int> all_dist(const int v) noexcept {\r\n        std::vector<int>\
    \ d(this -> size(), -1);\r\n        std::queue<int> q;\r\n        d[v] = 0;\r\n\
    \        q.emplace(v);\r\n        while(!q.empty()) {\r\n            const int\
    \ tmp = q.front();\r\n            q.pop();\r\n            for(const auto &el:\
    \ (*this)[tmp]) {\r\n                if(d[el] != -1) {\r\n                   \
    \ continue;\r\n                }\r\n                d[el] = d[tmp] + 1;\r\n  \
    \              q.emplace(el);\r\n            }\r\n        }\r\n        return\
    \ d;\r\n    }\r\n    inline int dist(const int u, const int v) noexcept { return\
    \ all_dist(u)[v]; }\r\n    inline std::vector<int> t_sort() noexcept {\r\n   \
    \     const int n = this->size();\r\n\t\tstd::vector<int> deg(n);\r\n\t\tfor(const\
    \ auto i: std::views::iota(0, n)) {\r\n\t\t\tfor(const auto ed: (*this)[i]) {\r\
    \n\t\t\t\tdeg[ed]++;\r\n\t\t\t}\r\n\t\t}\r\n\t\tstd::stack<int> sk;\r\n\t\tfor(const\
    \ auto i: std::views::iota(0, n)) {\r\n\t\t\tif(deg[i] == 0) {\r\n\t\t\t\tsk.emplace(i);\r\
    \n\t\t\t}\r\n\t\t}\r\n\t\tstd::vector<int> ord;\r\n\t\twhile(!sk.empty()) {\r\n\
    \t\t\tconst auto tmp = sk.top();\r\n            sk.pop();\r\n\t\t\tord.emplace_back(tmp);\r\
    \n\t\t\tfor(const auto ed: (*this)[tmp]) {\r\n\t\t\t\tif(--deg[ed] == 0) {\r\n\
    \t\t\t\t\tsk.emplace(ed);\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t}\r\n\t\treturn ord.size()\
    \ == size() ? ord : std::vector<int>{};\r\n\t}\r\n    inline std::vector<edge>\
    \ cycle() noexcept {\r\n        const int n = size();\r\n        std::vector<int>\
    \ used(n);\r\n        std::vector<edge> pre(n), cycle;\r\n        const auto dfs\
    \ = [&](const auto &f, const int i) -> bool {\r\n            used[i] = 1;\r\n\t\
    \t\tfor(const auto &e: (*this)[i]) {\r\n\t\t\t\tif(used[e] == 0) {\r\n\t\t\t\t\
    \tpre[e] = e;\r\n\t\t\t\t\tif(f(f, e)) {\r\n\t\t\t\t\t\treturn true;\r\n\t\t\t\
    \t\t}\r\n\t\t\t\t} else if(used[e] == 1) {\r\n\t\t\t\t\tint now = i;\r\n\t\t\t\
    \t\twhile(now != e) {\r\n\t\t\t\t\t\tcycle.emplace_back(pre[now]);\r\n\t\t\t\t\
    \t\tnow = pre[now].src;\r\n\t\t\t\t\t}\r\n\t\t\t\t\tcycle.emplace_back(e);\r\n\
    \t\t\t\t\treturn true;\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t\tused[i] = 2;\r\n\t\t\t\
    return false;\r\n        };\r\n        for(int i = 0; i < n; ++i) {\r\n\t\t\t\
    if(used[i] == 0 && dfs(dfs, i)) {\r\n\t\t\t\tstd::ranges::reverse(cycle);\r\n\t\
    \t\t\treturn cycle;\r\n\t\t\t}\r\n\t\t}\r\n\t\treturn {};\r\n    }\r\n};\r\n}\r\
    \n\r\n/**\r\n * @brief \u30B0\u30E9\u30D5\u30E9\u30A4\u30D6\u30E9\u30EA\r\n */\n\
    #line 2 \"C++/graph/SCC.hpp\"\n\n#line 6 \"C++/graph/SCC.hpp\"\nnamespace man\
    \ {\ntemplate <class G> struct SCC {\nprivate:\n\tstd::vector<int> comp, order,\
    \ used;\n\tstd::vector<std::vector<int>> group;\n\tG g, rg, dag;\n\tinline void\
    \ dfs(const int i) noexcept {\n\t\tif(used[i]) {\n\t\t\treturn;\n\t\t}\n\t\tused[i]\
    \ = true;\n\t\tfor(const auto &e: g[i]) {\n\t\t\tdfs(e);\n\t\t}\n\t\torder.push_back(i);\n\
    \  \t}\n  \tconstexpr inline void rdfs(const int i, const int cnt) noexcept {\n\
    \    \tif(comp[i] != -1) {\n\t\t\treturn;\n\t\t}\n    \tcomp[i] = cnt;\n    \t\
    for(const auto &e: rg[i]) {\n\t\t\trdfs(e, cnt);\n\t\t}\n  \t}\n\tinline void\
    \ build() noexcept {\n\t\tconst int n = std::ssize(g);\n\t\trg = G(n, 0);\n\t\t\
    for(const auto i: std::views::iota(0, n)) {\n\t\t\tfor(const auto &e: g[i]) {\n\
    \t\t\t\trg.add(e.to, e.src);\n\t\t\t}\n\t\t}\n\t\tused.assign(n, 0);\n\t\tcomp.assign(n,\
    \ -1);\n\t\tfor(const auto i: std::views::iota(0, n)) {\n\t\t\tdfs(i);\n\t\t}\n\
    \t\tstd::ranges::reverse(order);\n\t\tint ptr = 0;\n\t\tfor(const auto &i: order)\
    \ {\n\t\t\tif(comp[i] == -1) {\n\t\t\t\trdfs(i, ptr++);\n\t\t\t}\n\t\t}\n\t\t\
    dag = G(ptr, 0);\n\t\tfor(const auto i: std::views::iota(0, n)) {\n\t\t\tfor(const\
    \ auto &e: g[i]) {\n\t\t\t\tconst int x = comp[e.src], y = comp[e.to];\n\t\t\t\
    \tif(x == y) {\n\t\t\t\t\tcontinue;\n\t\t\t\t}\n\t\t\t\tdag.add(x, y);\n\t\t\t\
    }\n\t\t}\n\t\tgroup.resize(ptr);\n\t\tfor(const auto i: std::views::iota(0, n))\
    \ {\n\t\t\tgroup[comp[i]].emplace_back(i);\n\t\t}\n\t}\npublic:\n    SCC(const\
    \ G &g): g(g){ build(); }\n\tconstexpr inline int operator[](const int i) const\
    \ noexcept { return comp[i]; }\n\tinline std::vector<std::vector<int>> groups()\
    \ const noexcept { return group; }\n\tinline G DAG() const noexcept { return dag;\
    \ }\n};\n}\n\n/**\n * @brief Strongly Connected Components(\u5F37\u9023\u7D50\u6210\
    \u5206\u5206\u89E3)\n * @see https://ei1333.github.io/library/graph/connected-components/strongly-connected-components.hpp\n\
    \ */\n#line 5 \"test/scc2.test.cpp\"\nint main() {\n    int n, m;\n    std::cin\
    \ >> n >> m;\n    man::graph<false> g(n, 0);\n    g.input(m);\n    man::SCC scc(g);\n\
    \    const auto res = scc.groups();\n    std::cout << res.size() << '\\n';\n \
    \   for(const auto &el: res) {\n        const int len = el.size();\n        std::cout\
    \ << len << ' ';\n        for(int i = 0; i < len; ++i) {\n            std::cout\
    \ << el[i] << \" \\n\"[i + 1 == len];\n        }\n    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/scc\"\n#include <iostream>\n\
    #include \"C++/graph/Graph.hpp\"\n#include \"C++/graph/SCC.hpp\"\nint main() {\n\
    \    int n, m;\n    std::cin >> n >> m;\n    man::graph<false> g(n, 0);\n    g.input(m);\n\
    \    man::SCC scc(g);\n    const auto res = scc.groups();\n    std::cout << res.size()\
    \ << '\\n';\n    for(const auto &el: res) {\n        const int len = el.size();\n\
    \        std::cout << len << ' ';\n        for(int i = 0; i < len; ++i) {\n  \
    \          std::cout << el[i] << \" \\n\"[i + 1 == len];\n        }\n    }\n}"
  dependsOn:
  - C++/graph/Graph.hpp
  - C++/graph/edge.hpp
  - C++/graph/SCC.hpp
  isVerificationFile: true
  path: test/scc2.test.cpp
  requiredBy: []
  timestamp: '2025-06-06 22:43:22+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: test/scc2.test.cpp
layout: document
redirect_from:
- /verify/test/scc2.test.cpp
- /verify/test/scc2.test.cpp.html
title: test/scc2.test.cpp
---
