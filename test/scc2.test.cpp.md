---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: C++/graph/Graph.hpp
    title: "\u30B0\u30E9\u30D5\u30E9\u30A4\u30D6\u30E9\u30EA"
  - icon: ':heavy_check_mark:'
    path: C++/graph/SCC.hpp
    title: "Strongly Connected Components(\u5F37\u9023\u7D50\u6210\u5206\u5206\u89E3\
      )"
  - icon: ':question:'
    path: C++/graph/edge.hpp
    title: Edge
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://judge.yosupo.jp/problem/scc
    links:
    - https://judge.yosupo.jp/problem/scc
  bundledCode: "#line 1 \"test/scc2.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/scc\"\
    \n#include <iostream>\n#line 2 \"C++/graph/Graph.hpp\"\n\r\n#line 4 \"C++/graph/Graph.hpp\"\
    \n#include <vector>\r\n#include <algorithm>\r\n#include <queue>\r\n#include <stack>\r\
    \n#ifndef TEMPLATE\r\ntemplate <class T, class U> bool chmin(T& a, const U& b){\
    \ if(a>b){ a=b; return 1; } return 0; }\r\n#endif\r\n#line 2 \"C++/graph/edge.hpp\"\
    \n\nstruct edge {\n    int src, to, id;\n    long long cost;\n    edge(){}\n \
    \   edge(const int src_, const int to_, const int id_ = -1, const long long cost_\
    \ = 0): src(src_), to(to_), id(id_), cost(cost_){}\n    operator int() const {\
    \ return to; }\n};\n\n/**\n * @brief Edge\n */\n#line 12 \"C++/graph/Graph.hpp\"\
    \ntemplate <bool undirected = true> struct graph: std::vector<std::vector<edge>>\
    \ {\r\nprotected:\r\n    int indexed, id;\r\n    std::vector<edge> edges;\r\n\
    public:\r\n    graph(){}\r\n    graph(const int n, const int indexed_ = 1): indexed(indexed_),\
    \ id(0){ this -> resize(n); }\r\n    void add(int a, int b) {\r\n        a -=\
    \ indexed, b-= indexed;\r\n        (*this)[a].emplace_back(a, b, id);\r\n    \
    \    edges.emplace_back(a, b, id++);\r\n        if(undirected) {\r\n         \
    \   (*this)[b].emplace_back(b, a, --id);\r\n            edges.emplace_back(b,\
    \ a, id++);\r\n        }\r\n    }\r\n    void input(const int m) {\r\n       \
    \ for(int i = 0; i < m; ++i) {\r\n            int a, b;\r\n            std::cin\
    \ >> a >> b;\r\n            add(a, b);\r\n        }\r\n    }\r\n    std::vector<edge>\
    \ get_edge() const { return edges; }\r\n    std::vector<int> all_dist(const int\
    \ v) {\r\n        std::vector<int> d(this -> size(), -1);\r\n        std::queue<int>\
    \ q;\r\n        d[v] = 0;\r\n        q.emplace(v);\r\n        while(q.size())\
    \ {\r\n            const int tmp = q.front();\r\n            q.pop();\r\n    \
    \        for(const auto &el: (*this)[tmp]) {\r\n                if(d[el] != -1)\
    \ {\r\n                    continue;\r\n                }\r\n                d[el]\
    \ = d[tmp] + 1;\r\n                q.emplace(el);\r\n            }\r\n       \
    \ }\r\n        return d;\r\n    }\r\n    int dist(const int u, const int v){ return\
    \ all_dist(u)[v]; }\r\n    std::vector<int> t_sort() {\r\n        const int n\
    \ = this -> size();\r\n\t\tstd::vector<int> deg(n);\r\n\t\tfor(int i = 0; i <\
    \ n; ++i) {\r\n\t\t\tfor(const auto ed: (*this)[i]) {\r\n\t\t\t\tdeg[ed]++;\r\n\
    \t\t\t}\r\n\t\t}\r\n\t\tstd::stack<int> sk;\r\n\t\tfor(int i = 0; i < n; ++i)\
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
    \u30E9\u30A4\u30D6\u30E9\u30EA\r\n */\n#line 2 \"C++/graph/SCC.hpp\"\n\n#line\
    \ 5 \"C++/graph/SCC.hpp\"\ntemplate <class G> struct SCC {\nprivate:\n\tstd::vector<int>\
    \ comp, order, used;\n\tstd::vector<std::vector<int>> group;\n\tG g, rg, dag;\n\
    \tvoid dfs(const int i) {\n\t\tif(used[i]) {\n\t\t\treturn;\n\t\t}\n\t\tused[i]\
    \ = true;\n\t\tfor(const auto &e: g[i]) {\n\t\t\tdfs(e);\n\t\t}\n\t\torder.push_back(i);\n\
    \  \t}\n  \tvoid rdfs(const int i, const int cnt) {\n    \tif(comp[i] != -1) {\n\
    \t\t\treturn;\n\t\t}\n    \tcomp[i] = cnt;\n    \tfor(const auto &e: rg[i]) {\n\
    \t\t\trdfs(e, cnt);\n\t\t}\n  \t}\n\tvoid build() {\n\t\tconst int n = g.size();\n\
    \t\trg = G(n, 0);\n\t\tfor(int i = 0; i < n; ++i) {\n\t\t\tfor(const auto &e:\
    \ g[i]) {\n\t\t\t\trg.add(e.to, e.src);\n\t\t\t}\n\t\t}\n\t\tused.assign(n, 0);\n\
    \t\tcomp.assign(n, -1);\n\t\tfor(int i = 0; i < n; ++i) {\n\t\t\tdfs(i);\n\t\t\
    }\n\t\tstd::reverse(order.begin(), order.end());\n\t\tint ptr = 0;\n\t\tfor(const\
    \ auto &i: order) {\n\t\t\tif(comp[i] == -1) {\n\t\t\t\trdfs(i, ptr++);\n\t\t\t\
    }\n\t\t}\n\t\tdag = G(ptr, 0);\n\t\tfor(int i = 0; i < n; ++i) {\n\t\t\tfor(const\
    \ auto &e: g[i]) {\n\t\t\t\tconst int x = comp[e.src], y = comp[e.to];\n\t\t\t\
    \tif(x == y) {\n\t\t\t\t\tcontinue;\n\t\t\t\t}\n\t\t\t\tdag.add(x, y);\n\t\t\t\
    }\n\t\t}\n\t\tgroup.resize(ptr);\n\t\tfor(int i = 0; i < n; ++i) {\n\t\t\tgroup[comp[i]].emplace_back(i);\n\
    \t\t}\n\t}\npublic:\n    SCC(const G &g): g(g){ build(); }\n\tint operator[](const\
    \ int i) const { return comp[i]; }\n\tstd::vector<std::vector<int>> groups() const\
    \ { return group; }\n\tG DAG() const { return dag; }\n};\n\n/**\n * @brief Strongly\
    \ Connected Components(\u5F37\u9023\u7D50\u6210\u5206\u5206\u89E3)\n * @see https://ei1333.github.io/library/graph/connected-components/strongly-connected-components.hpp\n\
    \ */\n#line 5 \"test/scc2.test.cpp\"\nint main() {\n    int n, m;\n    std::cin\
    \ >> n >> m;\n    graph<false> g(n, 0);\n    g.input(m);\n    SCC scc(g);\n  \
    \  const auto res = scc.groups();\n    std::cout << res.size() << '\\n';\n   \
    \ for(const auto &el: res) {\n        const int len = el.size();\n        std::cout\
    \ << len << ' ';\n        for(int i = 0; i < len; ++i) {\n            std::cout\
    \ << el[i] << \" \\n\"[i + 1 == len];\n        }\n    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/scc\"\n#include <iostream>\n\
    #include \"C++/graph/Graph.hpp\"\n#include \"C++/graph/SCC.hpp\"\nint main() {\n\
    \    int n, m;\n    std::cin >> n >> m;\n    graph<false> g(n, 0);\n    g.input(m);\n\
    \    SCC scc(g);\n    const auto res = scc.groups();\n    std::cout << res.size()\
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
  timestamp: '2024-07-08 16:24:06+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/scc2.test.cpp
layout: document
redirect_from:
- /verify/test/scc2.test.cpp
- /verify/test/scc2.test.cpp.html
title: test/scc2.test.cpp
---
