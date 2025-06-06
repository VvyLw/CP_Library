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
    _deprecated_at_docs: docs/LCA.md
    document_title: "Lowest Common Ancestor(\u6700\u5C0F\u5171\u901A\u7956\u5148)"
    links:
    - https://ei1333.github.io/luzhiled/snippets/tree/doubling-lowest-common-ancestor.html
  bundledCode: "#line 2 \"C++/graph/LCA.hpp\"\n\r\n#pragma GCC diagnostic ignored\
    \ \"-Wreorder\"\r\n\r\n#include <vector>\r\n#include <ranges>\r\nnamespace man\
    \ {\r\ntemplate <class G> struct LowestCommonAncestor {\r\nprivate:\r\n    const\
    \ int LOG;\r\n    std::vector<int> dep, sum;\r\n    const G &g;\r\n    std::vector<std::vector<int>>\
    \ table;\r\n    constexpr inline void dfs(const int idx, const int par, const\
    \ int d) noexcept {\r\n        table[0][idx] = par;\r\n        dep[idx] = d;\r\
    \n        for(const auto &el: g[idx]) {\r\n            if(el != par) {\r\n   \
    \             sum[el] = sum[idx] + el.cost;\r\n                dfs(el, idx, d\
    \ + 1);\r\n            }\r\n        }\r\n    }\r\n    constexpr inline void build()\
    \ noexcept{\r\n        dfs(0, -1, 0);\r\n        for(const auto k: std::views::iota(0,\
    \ LOG - 1)) {\r\n            for(const auto i: std::views::iota(0, std::ssize(table[k])))\
    \ {\r\n                if(table[k][i] == -1) {\r\n                    table[k\
    \ + 1][i] = -1;\r\n                } else {\r\n                    table[k + 1][i]\
    \ = table[k][table[k][i]];\r\n                }\r\n            }\r\n        }\r\
    \n    }\r\npublic:\r\n    LowestCommonAncestor(const G &g_): g(g_), dep(std::ssize(g_)),\
    \ sum(std::ssize(g_)), LOG(std::__lg(std::ssize(g_)) + 1) {\r\n        table.assign(LOG,\
    \ std::vector<int>(std::ssize(g_), -1));\r\n        build();\r\n    }\r\n    constexpr\
    \ inline int climb(int u, const int k) noexcept {\r\n\t\tif(dep[u] < k) {\r\n\t\
    \t\treturn -1;\r\n\t\t}\r\n\t\tfor(const auto i: std::views::iota(0, LOG) | std::views::reverse)\
    \ {\r\n\t\t\tif((k >> i) & 1) {\r\n                u = table[i][u];\r\n      \
    \      }\r\n\t\t}\r\n\t\treturn u;\r\n\t}\r\n    constexpr inline int query(int\
    \ u, int v) noexcept {\r\n        if(dep[u] > dep[v]) {\r\n            std::swap(u,\
    \ v);\r\n        }\r\n        v = climb(v, dep[v] - dep[u]);\r\n        if(u ==\
    \ v) {\r\n            return u;\r\n        }\r\n        for(int i = LOG; --i >=\
    \ 0;) {\r\n            if(table[i][u] != table[i][v]) {\r\n                u =\
    \ table[i][u];\r\n                v = table[i][v];\r\n            }\r\n      \
    \  }\r\n        return table[0][u];\r\n    }\r\n    constexpr inline int dist(const\
    \ int u, const int v) const noexcept { return sum[u] + sum[v] - 2 * sum[query(u,\
    \ v)]; }\r\n};\r\n}\r\n/**\r\n * @brief Lowest Common Ancestor(\u6700\u5C0F\u5171\
    \u901A\u7956\u5148)\r\n * @docs docs/LCA.md\r\n * @see https://ei1333.github.io/luzhiled/snippets/tree/doubling-lowest-common-ancestor.html\r\
    \n */\n"
  code: "#pragma once\r\n\r\n#pragma GCC diagnostic ignored \"-Wreorder\"\r\n\r\n\
    #include <vector>\r\n#include <ranges>\r\nnamespace man {\r\ntemplate <class G>\
    \ struct LowestCommonAncestor {\r\nprivate:\r\n    const int LOG;\r\n    std::vector<int>\
    \ dep, sum;\r\n    const G &g;\r\n    std::vector<std::vector<int>> table;\r\n\
    \    constexpr inline void dfs(const int idx, const int par, const int d) noexcept\
    \ {\r\n        table[0][idx] = par;\r\n        dep[idx] = d;\r\n        for(const\
    \ auto &el: g[idx]) {\r\n            if(el != par) {\r\n                sum[el]\
    \ = sum[idx] + el.cost;\r\n                dfs(el, idx, d + 1);\r\n          \
    \  }\r\n        }\r\n    }\r\n    constexpr inline void build() noexcept{\r\n\
    \        dfs(0, -1, 0);\r\n        for(const auto k: std::views::iota(0, LOG -\
    \ 1)) {\r\n            for(const auto i: std::views::iota(0, std::ssize(table[k])))\
    \ {\r\n                if(table[k][i] == -1) {\r\n                    table[k\
    \ + 1][i] = -1;\r\n                } else {\r\n                    table[k + 1][i]\
    \ = table[k][table[k][i]];\r\n                }\r\n            }\r\n        }\r\
    \n    }\r\npublic:\r\n    LowestCommonAncestor(const G &g_): g(g_), dep(std::ssize(g_)),\
    \ sum(std::ssize(g_)), LOG(std::__lg(std::ssize(g_)) + 1) {\r\n        table.assign(LOG,\
    \ std::vector<int>(std::ssize(g_), -1));\r\n        build();\r\n    }\r\n    constexpr\
    \ inline int climb(int u, const int k) noexcept {\r\n\t\tif(dep[u] < k) {\r\n\t\
    \t\treturn -1;\r\n\t\t}\r\n\t\tfor(const auto i: std::views::iota(0, LOG) | std::views::reverse)\
    \ {\r\n\t\t\tif((k >> i) & 1) {\r\n                u = table[i][u];\r\n      \
    \      }\r\n\t\t}\r\n\t\treturn u;\r\n\t}\r\n    constexpr inline int query(int\
    \ u, int v) noexcept {\r\n        if(dep[u] > dep[v]) {\r\n            std::swap(u,\
    \ v);\r\n        }\r\n        v = climb(v, dep[v] - dep[u]);\r\n        if(u ==\
    \ v) {\r\n            return u;\r\n        }\r\n        for(int i = LOG; --i >=\
    \ 0;) {\r\n            if(table[i][u] != table[i][v]) {\r\n                u =\
    \ table[i][u];\r\n                v = table[i][v];\r\n            }\r\n      \
    \  }\r\n        return table[0][u];\r\n    }\r\n    constexpr inline int dist(const\
    \ int u, const int v) const noexcept { return sum[u] + sum[v] - 2 * sum[query(u,\
    \ v)]; }\r\n};\r\n}\r\n/**\r\n * @brief Lowest Common Ancestor(\u6700\u5C0F\u5171\
    \u901A\u7956\u5148)\r\n * @docs docs/LCA.md\r\n * @see https://ei1333.github.io/luzhiled/snippets/tree/doubling-lowest-common-ancestor.html\r\
    \n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/graph/LCA.hpp
  requiredBy: []
  timestamp: '2025-06-06 22:43:06+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/lca.test.cpp
documentation_of: C++/graph/LCA.hpp
layout: document
redirect_from:
- /library/C++/graph/LCA.hpp
- /library/C++/graph/LCA.hpp.html
title: "Lowest Common Ancestor(\u6700\u5C0F\u5171\u901A\u7956\u5148)"
---
queryのみverify  
もしかしたら間違っている