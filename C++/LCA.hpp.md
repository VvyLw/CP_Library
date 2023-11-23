---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    links:
    - https://ei1333.github.io/luzhiled/snippets/tree/doubling-lowest-common-ancestor.html)
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 312, in update\n    raise BundleErrorAt(path, i + 1, \"#pragma once found\
    \ in a non-first line\")\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt:\
    \ C++/LCA.hpp: line 2: #pragma once found in a non-first line\n"
  code: "// inspired by Luzhiled(https://ei1333.github.io/luzhiled/snippets/tree/doubling-lowest-common-ancestor.html)\r\
    \n#pragma once\r\n\r\n#include <vector>\r\nusing namespace std;\r\ntemplate <class\
    \ G> struct LowestCommonAncestor {\r\n    const int LOG;\r\n    vi dep;\r\n  \
    \  const G &g;\r\n    wi table;\r\n    LowestCommonAncestor(const G &g_) : g(g_),\
    \ dep(g_.size()), LOG(zia_qu::bitdigit(g_.size())) {\r\n        table.assign(LOG,\
    \ vi(g_.size(), -1));\r\n    }\r\n    void dfs(ll idx, ll par, ll d) {\r\n   \
    \     table[0][idx] = par;\r\n        dep[idx] = d;\r\n        each(to,g[idx])\
    \ {\r\n            if(to != par) dfs(to, idx, d + 1);\r\n        }\r\n    }\r\n\
    \    void build() {\r\n        dfs(0, -1, 0);\r\n        rep(k,LOG-1) {\r\n  \
    \          rep(table[k].size()) {\r\n                if(table[k][i] == -1) table[k\
    \ + 1][i] = -1;\r\n                else table[k + 1][i] = table[k][table[k][i]];\r\
    \n            }\r\n        }\r\n    }\r\n    ll query(ll u, ll v) {\r\n      \
    \  if(dep[u] > dep[v]) swap(u, v);\r\n        rvp(LOG) {\r\n            if(((dep[v]\
    \ - dep[u]) >> i) & 1) v = table[i][v];\r\n        }\r\n        if(u == v) return\
    \ u;\r\n            rvp(LOG) {\r\n            if(table[i][u] != table[i][v]) {\r\
    \n                u = table[i][u];\r\n                v = table[i][v];\r\n   \
    \         }\r\n        }\r\n        return table[0][u];\r\n    }\r\n    ll dist(ll\
    \ u, ll v){ return dep[u] + dep[v] - 2 * query(u, v); }\r\n};"
  dependsOn: []
  isVerificationFile: false
  path: C++/LCA.hpp
  requiredBy: []
  timestamp: '2023-08-28 23:58:42+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/LCA.hpp
layout: document
redirect_from:
- /library/C++/LCA.hpp
- /library/C++/LCA.hpp.html
title: C++/LCA.hpp
---
