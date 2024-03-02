---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':x:'
    path: test/C++/scc.test.cpp
    title: test/C++/scc.test.cpp
  - icon: ':x:'
    path: test/C++/scc2.test.cpp
    title: test/C++/scc2.test.cpp
  _isVerificationFailed: true
  _pathExtension: hpp
  _verificationStatusIcon: ':x:'
  attributes:
    document_title: SCC
    links:
    - https://ei1333.github.io/library/graph/connected-components/strongly-connected-components.hpp
  bundledCode: "#line 2 \"C++/graph/SCC.hpp\"\n\n#include <vector>\n#include <algorithm>\n\
    template <class G> struct SCC {\nprivate:\n\tstd::vector<int> comp, order, used;\n\
    \tstd::vector<std::vector<int>> group;\n\tG g, rg, dag;\n\tvoid dfs(const int\
    \ i) {\n\t\tif(used[i]) {\n\t\t\treturn;\n\t\t}\n\t\tused[i] = true;\n\t\tfor(const\
    \ auto &e: g[i]) {\n\t\t\tdfs(e);\n\t\t}\n\t\torder.push_back(i);\n  \t}\n  \t\
    void rdfs(const int i, const int cnt) {\n    \tif(comp[i] != -1) {\n\t\t\treturn;\n\
    \t\t}\n    \tcomp[i] = cnt;\n    \tfor(const auto &e: rg[i]) {\n\t\t\trdfs(e,\
    \ cnt);\n\t\t}\n  \t}\n\tvoid build() {\n\t\tconst int n = g.size();\n\t\trg =\
    \ G(n, 0);\n\t\tfor(int i = 0; i < n; ++i) {\n\t\t\tfor(const auto &e: g[i]) {\n\
    \t\t\t\trg.add(e.to, e.src);\n\t\t\t}\n\t\t}\n\t\tused.assign(n, 0);\n\t\tcomp.assign(n,\
    \ -1);\n\t\tfor(int i = 0; i < n; ++i) {\n\t\t\tdfs(i);\n\t\t}\n\t\tstd::reverse(order.begin(),\
    \ order.end());\n\t\tint ptr = 0;\n\t\tfor(const auto &i: order) {\n\t\t\tif(comp[i]\
    \ == -1) {\n\t\t\t\trdfs(i, ptr++);\n\t\t\t}\n\t\t}\n\t\tdag = G(ptr, 0);\n\t\t\
    for(int i = 0; i < n; ++i) {\n\t\t\tfor(const auto &e: g[i]) {\n\t\t\t\tconst\
    \ int x = comp[e.src], y = comp[e.to];\n\t\t\t\tif(x == y) {\n\t\t\t\t\tcontinue;\n\
    \t\t\t\t}\n\t\t\t\tdag.add(x, y);\n\t\t\t}\n\t\t}\n\t\tgroup.resize(ptr);\n\t\t\
    for(int i = 0; i < n; ++i) {\n\t\t\tgroup[comp[i]].emplace_back(i);\n\t\t}\n\t\
    }\npublic:\n    SCC(const G &g): g(g){ build(); }\n\tint operator[](const int\
    \ i) const { return comp[i]; }\n\tstd::vector<std::vector<int>> groups() const\
    \ { return group; }\n\tG DAG() const { return dag; }\n};\n\n/**\n * @brief SCC\n\
    \ * @see https://ei1333.github.io/library/graph/connected-components/strongly-connected-components.hpp\n\
    \ */\n"
  code: "#pragma once\n\n#include <vector>\n#include <algorithm>\ntemplate <class\
    \ G> struct SCC {\nprivate:\n\tstd::vector<int> comp, order, used;\n\tstd::vector<std::vector<int>>\
    \ group;\n\tG g, rg, dag;\n\tvoid dfs(const int i) {\n\t\tif(used[i]) {\n\t\t\t\
    return;\n\t\t}\n\t\tused[i] = true;\n\t\tfor(const auto &e: g[i]) {\n\t\t\tdfs(e);\n\
    \t\t}\n\t\torder.push_back(i);\n  \t}\n  \tvoid rdfs(const int i, const int cnt)\
    \ {\n    \tif(comp[i] != -1) {\n\t\t\treturn;\n\t\t}\n    \tcomp[i] = cnt;\n \
    \   \tfor(const auto &e: rg[i]) {\n\t\t\trdfs(e, cnt);\n\t\t}\n  \t}\n\tvoid build()\
    \ {\n\t\tconst int n = g.size();\n\t\trg = G(n, 0);\n\t\tfor(int i = 0; i < n;\
    \ ++i) {\n\t\t\tfor(const auto &e: g[i]) {\n\t\t\t\trg.add(e.to, e.src);\n\t\t\
    \t}\n\t\t}\n\t\tused.assign(n, 0);\n\t\tcomp.assign(n, -1);\n\t\tfor(int i = 0;\
    \ i < n; ++i) {\n\t\t\tdfs(i);\n\t\t}\n\t\tstd::reverse(order.begin(), order.end());\n\
    \t\tint ptr = 0;\n\t\tfor(const auto &i: order) {\n\t\t\tif(comp[i] == -1) {\n\
    \t\t\t\trdfs(i, ptr++);\n\t\t\t}\n\t\t}\n\t\tdag = G(ptr, 0);\n\t\tfor(int i =\
    \ 0; i < n; ++i) {\n\t\t\tfor(const auto &e: g[i]) {\n\t\t\t\tconst int x = comp[e.src],\
    \ y = comp[e.to];\n\t\t\t\tif(x == y) {\n\t\t\t\t\tcontinue;\n\t\t\t\t}\n\t\t\t\
    \tdag.add(x, y);\n\t\t\t}\n\t\t}\n\t\tgroup.resize(ptr);\n\t\tfor(int i = 0; i\
    \ < n; ++i) {\n\t\t\tgroup[comp[i]].emplace_back(i);\n\t\t}\n\t}\npublic:\n  \
    \  SCC(const G &g): g(g){ build(); }\n\tint operator[](const int i) const { return\
    \ comp[i]; }\n\tstd::vector<std::vector<int>> groups() const { return group; }\n\
    \tG DAG() const { return dag; }\n};\n\n/**\n * @brief SCC\n * @see https://ei1333.github.io/library/graph/connected-components/strongly-connected-components.hpp\n\
    \ */"
  dependsOn: []
  isVerificationFile: false
  path: C++/graph/SCC.hpp
  requiredBy: []
  timestamp: '2024-02-22 08:54:27+09:00'
  verificationStatus: LIBRARY_ALL_WA
  verifiedWith:
  - test/C++/scc.test.cpp
  - test/C++/scc2.test.cpp
documentation_of: C++/graph/SCC.hpp
layout: document
redirect_from:
- /library/C++/graph/SCC.hpp
- /library/C++/graph/SCC.hpp.html
title: SCC
---
