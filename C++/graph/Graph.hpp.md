---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    document_title: "\u30B0\u30E9\u30D5\u30E9\u30A4\u30D6\u30E9\u30EA"
    links: []
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 401, in update\n    self.update(self._resolve(pathlib.Path(included), included_from=path))\n\
    \  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 260, in _resolve\n    raise BundleErrorAt(path, -1, \"no such header\"\
    )\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt: graph/edge.hpp:\
    \ line -1: no such header\n"
  code: "#pragma once\r\n\r\n#include <iostream>\r\n#include <vector>\r\n#include\
    \ <queue>\r\n#include <stack>\r\n#ifndef TEMPLATE\r\ntemplate <class T, class\
    \ U> bool chmin(T& a, const U& b){ if(a>b){ a=b; return 1; } return 0; }\r\n#endif\r\
    \n#include \"graph/edge.hpp\"\r\ntemplate <bool undirected = true> struct graph:\
    \ public std::vector<std::vector<edge>> {\r\n    const int indexed;\r\n    int\
    \ id;\r\n    std::vector<edge> edges;\r\n    graph(const int n, const int indexed_\
    \ = 1): indexed(indexed_), id(0){ this -> resize(n); }\r\n    void add(int a,\
    \ int b) {\r\n        a -= indexed, b-= indexed;\r\n        (*this)[a].emplace_back(a,\
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
    \n\t\t\t}\r\n\t\t}\r\n\t\treturn {};\r\n    }\r\n};\r\ntypedef std::vector<edge>\
    \ ve;\r\ntypedef std::vector<ve> we;\r\n/**\r\n * @brief \u30B0\u30E9\u30D5\u30E9\
    \u30A4\u30D6\u30E9\u30EA\r\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/graph/Graph.hpp
  requiredBy: []
  timestamp: '1970-01-01 00:00:00+00:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/graph/Graph.hpp
layout: document
redirect_from:
- /library/C++/graph/Graph.hpp
- /library/C++/graph/Graph.hpp.html
title: "\u30B0\u30E9\u30D5\u30E9\u30A4\u30D6\u30E9\u30EA"
---
