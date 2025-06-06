---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':x:'
    path: test/scc.test.cpp
    title: test/scc.test.cpp
  - icon: ':x:'
    path: test/scc2.test.cpp
    title: test/scc2.test.cpp
  _isVerificationFailed: true
  _pathExtension: hpp
  _verificationStatusIcon: ':x:'
  attributes:
    document_title: "Strongly Connected Components(\u5F37\u9023\u7D50\u6210\u5206\u5206\
      \u89E3)"
    links:
    - https://ei1333.github.io/library/graph/connected-components/strongly-connected-components.hpp
  bundledCode: "#line 2 \"C++/graph/SCC.hpp\"\n\n#include <vector>\n#include <algorithm>\n\
    #include <ranges>\nnamespace man {\ntemplate <class G> struct SCC {\nprivate:\n\
    \tstd::vector<int> comp, order, used;\n\tstd::vector<std::vector<int>> group;\n\
    \tG g, rg, dag;\n\tinline void dfs(const int i) noexcept {\n\t\tif(used[i]) {\n\
    \t\t\treturn;\n\t\t}\n\t\tused[i] = true;\n\t\tfor(const auto &e: g[i]) {\n\t\t\
    \tdfs(e);\n\t\t}\n\t\torder.push_back(i);\n  \t}\n  \tconstexpr inline void rdfs(const\
    \ int i, const int cnt) noexcept {\n    \tif(comp[i] != -1) {\n\t\t\treturn;\n\
    \t\t}\n    \tcomp[i] = cnt;\n    \tfor(const auto &e: rg[i]) {\n\t\t\trdfs(e,\
    \ cnt);\n\t\t}\n  \t}\n\tinline void build() noexcept {\n\t\tconst int n = std::ssize(g);\n\
    \t\trg = G(n, 0);\n\t\tfor(const auto i: std::views::iota(0, n)) {\n\t\t\tfor(const\
    \ auto &e: g[i]) {\n\t\t\t\trg.add(e.to, e.src);\n\t\t\t}\n\t\t}\n\t\tused.assign(n,\
    \ 0);\n\t\tcomp.assign(n, -1);\n\t\tfor(const auto i: std::views::iota(0, n))\
    \ {\n\t\t\tdfs(i);\n\t\t}\n\t\tstd::ranges::reverse(order);\n\t\tint ptr = 0;\n\
    \t\tfor(const auto &i: order) {\n\t\t\tif(comp[i] == -1) {\n\t\t\t\trdfs(i, ptr++);\n\
    \t\t\t}\n\t\t}\n\t\tdag = G(ptr, 0);\n\t\tfor(const auto i: std::views::iota(0,\
    \ n)) {\n\t\t\tfor(const auto &e: g[i]) {\n\t\t\t\tconst int x = comp[e.src],\
    \ y = comp[e.to];\n\t\t\t\tif(x == y) {\n\t\t\t\t\tcontinue;\n\t\t\t\t}\n\t\t\t\
    \tdag.add(x, y);\n\t\t\t}\n\t\t}\n\t\tgroup.resize(ptr);\n\t\tfor(const auto i:\
    \ std::views::iota(0, n)) {\n\t\t\tgroup[comp[i]].emplace_back(i);\n\t\t}\n\t\
    }\npublic:\n    SCC(const G &g): g(g){ build(); }\n\tconstexpr inline int operator[](const\
    \ int i) const noexcept { return comp[i]; }\n\tinline std::vector<std::vector<int>>\
    \ groups() const noexcept { return group; }\n\tinline G DAG() const noexcept {\
    \ return dag; }\n};\n}\n\n/**\n * @brief Strongly Connected Components(\u5F37\u9023\
    \u7D50\u6210\u5206\u5206\u89E3)\n * @see https://ei1333.github.io/library/graph/connected-components/strongly-connected-components.hpp\n\
    \ */\n"
  code: "#pragma once\n\n#include <vector>\n#include <algorithm>\n#include <ranges>\n\
    namespace man {\ntemplate <class G> struct SCC {\nprivate:\n\tstd::vector<int>\
    \ comp, order, used;\n\tstd::vector<std::vector<int>> group;\n\tG g, rg, dag;\n\
    \tinline void dfs(const int i) noexcept {\n\t\tif(used[i]) {\n\t\t\treturn;\n\t\
    \t}\n\t\tused[i] = true;\n\t\tfor(const auto &e: g[i]) {\n\t\t\tdfs(e);\n\t\t\
    }\n\t\torder.push_back(i);\n  \t}\n  \tconstexpr inline void rdfs(const int i,\
    \ const int cnt) noexcept {\n    \tif(comp[i] != -1) {\n\t\t\treturn;\n\t\t}\n\
    \    \tcomp[i] = cnt;\n    \tfor(const auto &e: rg[i]) {\n\t\t\trdfs(e, cnt);\n\
    \t\t}\n  \t}\n\tinline void build() noexcept {\n\t\tconst int n = std::ssize(g);\n\
    \t\trg = G(n, 0);\n\t\tfor(const auto i: std::views::iota(0, n)) {\n\t\t\tfor(const\
    \ auto &e: g[i]) {\n\t\t\t\trg.add(e.to, e.src);\n\t\t\t}\n\t\t}\n\t\tused.assign(n,\
    \ 0);\n\t\tcomp.assign(n, -1);\n\t\tfor(const auto i: std::views::iota(0, n))\
    \ {\n\t\t\tdfs(i);\n\t\t}\n\t\tstd::ranges::reverse(order);\n\t\tint ptr = 0;\n\
    \t\tfor(const auto &i: order) {\n\t\t\tif(comp[i] == -1) {\n\t\t\t\trdfs(i, ptr++);\n\
    \t\t\t}\n\t\t}\n\t\tdag = G(ptr, 0);\n\t\tfor(const auto i: std::views::iota(0,\
    \ n)) {\n\t\t\tfor(const auto &e: g[i]) {\n\t\t\t\tconst int x = comp[e.src],\
    \ y = comp[e.to];\n\t\t\t\tif(x == y) {\n\t\t\t\t\tcontinue;\n\t\t\t\t}\n\t\t\t\
    \tdag.add(x, y);\n\t\t\t}\n\t\t}\n\t\tgroup.resize(ptr);\n\t\tfor(const auto i:\
    \ std::views::iota(0, n)) {\n\t\t\tgroup[comp[i]].emplace_back(i);\n\t\t}\n\t\
    }\npublic:\n    SCC(const G &g): g(g){ build(); }\n\tconstexpr inline int operator[](const\
    \ int i) const noexcept { return comp[i]; }\n\tinline std::vector<std::vector<int>>\
    \ groups() const noexcept { return group; }\n\tinline G DAG() const noexcept {\
    \ return dag; }\n};\n}\n\n/**\n * @brief Strongly Connected Components(\u5F37\u9023\
    \u7D50\u6210\u5206\u5206\u89E3)\n * @see https://ei1333.github.io/library/graph/connected-components/strongly-connected-components.hpp\n\
    \ */"
  dependsOn: []
  isVerificationFile: false
  path: C++/graph/SCC.hpp
  requiredBy: []
  timestamp: '2025-06-06 22:43:06+09:00'
  verificationStatus: LIBRARY_ALL_WA
  verifiedWith:
  - test/scc.test.cpp
  - test/scc2.test.cpp
documentation_of: C++/graph/SCC.hpp
layout: document
redirect_from:
- /library/C++/graph/SCC.hpp
- /library/C++/graph/SCC.hpp.html
title: "Strongly Connected Components(\u5F37\u9023\u7D50\u6210\u5206\u5206\u89E3)"
---
