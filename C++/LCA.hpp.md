---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/lca.test.cpp
    title: test/lca.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    links:
    - https://ei1333.github.io/luzhiled/snippets/tree/doubling-lowest-common-ancestor.html
  bundledCode: "#line 2 \"C++/LCA.hpp\"\n\r\n// inspired by Luzhiled( https://ei1333.github.io/luzhiled/snippets/tree/doubling-lowest-common-ancestor.html\
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
    \ query(int u, int v) {\r\n        if(dep[u] > dep[v]) std::swap(u, v);\r\n  \
    \      v = climb(v, dep[v] - dep[u]);\r\n        if(u == v) {\r\n            return\
    \ u;\r\n        }\r\n        for(int i = LOG; --i >= 0;) {\r\n            if(table[i][u]\
    \ != table[i][v]) {\r\n                u = table[i][u];\r\n                v =\
    \ table[i][v];\r\n            }\r\n        }\r\n        return table[0][u];\r\n\
    \    }\r\n    int dist(int u, int v) const { return sum[u] + sum[v] - 2 * sum[query(u,\
    \ v)]; }\r\n};\n"
  code: "#pragma once\r\n\r\n// inspired by Luzhiled( https://ei1333.github.io/luzhiled/snippets/tree/doubling-lowest-common-ancestor.html\
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
    \ query(int u, int v) {\r\n        if(dep[u] > dep[v]) std::swap(u, v);\r\n  \
    \      v = climb(v, dep[v] - dep[u]);\r\n        if(u == v) {\r\n            return\
    \ u;\r\n        }\r\n        for(int i = LOG; --i >= 0;) {\r\n            if(table[i][u]\
    \ != table[i][v]) {\r\n                u = table[i][u];\r\n                v =\
    \ table[i][v];\r\n            }\r\n        }\r\n        return table[0][u];\r\n\
    \    }\r\n    int dist(int u, int v) const { return sum[u] + sum[v] - 2 * sum[query(u,\
    \ v)]; }\r\n};"
  dependsOn: []
  isVerificationFile: false
  path: C++/LCA.hpp
  requiredBy: []
  timestamp: '2023-12-16 20:41:25+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/lca.test.cpp
documentation_of: C++/LCA.hpp
layout: document
redirect_from:
- /library/C++/LCA.hpp
- /library/C++/LCA.hpp.html
title: C++/LCA.hpp
---
