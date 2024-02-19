---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    links: []
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 401, in update\n    self.update(self._resolve(pathlib.Path(included), included_from=path))\n\
    \  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 260, in _resolve\n    raise BundleErrorAt(path, -1, \"no such header\"\
    )\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt: graph/Graph.hpp:\
    \ line -1: no such header\n"
  code: "#pragma once\n\n#include <limits>\n#include \"graph/Graph.hpp\"\ntemplate\
    \ <bool undirected = true> struct w_graph: public graph<undirected> {\nprivate:\n\
    \    using graph<undirected>::indexed;\n    using graph<undirected>::id;\n   \
    \ using graph<undirected>::edges;\npublic:\n    w_graph(const int n, const int\
    \ indexed_ = 1): graph<undirected>(n, indexed_){}\n    using graph<undirected>::all_dist;\n\
    \    using graph<undirected>::dist;\n    using graph<undirected>::t_sort;\n  \
    \  using graph<undirected>::cycle;\n    void add(int a, int b, const long long\
    \ cost) {\n        a -= indexed, b -= indexed;\n        (*this)[a].emplace_back(a,\
    \ b, id, cost);\n        edges.emplace_back(a, b, id++, cost);\n        if(undirected)\
    \ {\n            (*this)[b].emplace_back(b, a, --id, cost);\n            edges.emplace_back(b,\
    \ a, id++, cost);\n        }\n    }\n    void input(const int m) {\n        for(int\
    \ i = 0; i < m; ++i) {\n            int a, b;\n            long long c;\n    \
    \        std::cin >> a >> b >> c;\n            add(a, b, c);\n        }\n    }\n\
    \    std::vector<long long> dijkstra(const int v) {\n        std::vector<long\
    \ long> cst(this -> size(), (1LL << 61) - 1);\n        std::priority_queue<std::pair<long\
    \ long, int>, std::vector<std::pair<long long, int>>, std::greater<std::pair<long\
    \ long, int>>> dj;\n        cst[v] = 0;\n        dj.emplace(cst[v], v);\n    \
    \    while(dj.size()) {\n            const auto tmp = dj.top();\n            dj.pop();\n\
    \            if(cst[tmp.second] < tmp.first) {\n                continue;\n  \
    \          }\n            for(const auto &el: (*this)[tmp.second]) {\n       \
    \         if(chmin(cst[el], tmp.first + el.cost)) {\n                    dj.emplace(cst[el],\
    \ el);\n                }\n            }\n        }\n        return cst;\n   \
    \ }\n    std::vector<long long> bellman_ford(const int v) {\n        const long\
    \ long lim = std::numeric_limits<long long>::max();\n        std::vector<long\
    \ long> cst(this -> size(), lim);\n        cst[v] = 0;\n        for(size_t i =\
    \ 0; i < this -> size() - 1; ++i) {\n\t\t\tfor(const auto &e: edges) {\n\t\t\t\
    \tif(cst[e.src] == lim) {\n\t\t\t\t\tcontinue;\n\t\t\t\t}\n\t\t\t\tchmin(cst[e],\
    \ cst[e.src] + e.cost);\n\t\t\t}\n\t\t}\n\t\tfor(const auto &e: edges) {\n\t\t\
    \tif(cst[e.src] == lim) {\n\t\t\t\tcontinue;\n\t\t\t}\n\t\t\tif(cst[e.src] + e.cost\
    \ < cst[e]) {\n\t\t\t\treturn std::vector<long long>{};\n\t\t\t}\n\t\t}\n\t\t\
    return cst;\n    }\n    std::vector<std::vector<long long>> warshall_floyd() {\n\
    \t\tconst int n = this -> size();\n        const long long lim = (1LL << 61) -\
    \ 1;\n\t\tstd::vector cst(n, std::vector(n, lim));\n\t\tfor(int i = 0; i < n;\
    \ ++i) {\n            cst[i][i] = 0;\n        }\n\t\tfor(int i = 0; i < n; ++i)\
    \ {\n            for(const auto &j: (*this)[i]) {\n                cst[i][j] =\
    \ j.cost;\n            }\n        }\n\t\tfor(int k = 0; k < n; ++k) {\n      \
    \      for(int i = 0; i < n; ++i) {\n                for(int j = 0; j < n; ++j)\
    \ {\n                    if(cst[i][k] == lim || cst[k][j] == lim) {\n        \
    \                continue;\n                    }\n                    chmin(cst[i][j],\
    \ cst[i][k] + cst[k][j]);\n                }\n            }\n        }\n\t\treturn\
    \ cst;\n\t}\n};"
  dependsOn: []
  isVerificationFile: false
  path: C++/graph/WeightedGraph.hpp
  requiredBy: []
  timestamp: '1970-01-01 00:00:00+00:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/graph/WeightedGraph.hpp
layout: document
redirect_from:
- /library/C++/graph/WeightedGraph.hpp
- /library/C++/graph/WeightedGraph.hpp.html
title: C++/graph/WeightedGraph.hpp
---
