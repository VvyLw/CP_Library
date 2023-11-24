---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
  - icon: ':heavy_check_mark:'
    path: C++/graph.hpp
    title: C++/graph.hpp
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/lca.test.cpp
    title: test/lca.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/uf.test.cpp
    title: test/uf.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    links:
    - https://github.com/maspypy/library/blob/main/ds/unionfind/unionfind.hpp)
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 312, in update\n    raise BundleErrorAt(path, i + 1, \"#pragma once found\
    \ in a non-first line\")\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt:\
    \ C++/UnionFind.hpp: line 2: #pragma once found in a non-first line\n"
  code: "// inspired by maspy(https://github.com/maspypy/library/blob/main/ds/unionfind/unionfind.hpp)\r\
    \n#pragma once\r\n\r\n#include <vector>\n#include <algorithm>\r\nusing namespace\
    \ std;\r\ntypedef long long ll;\r\nstruct UnionFind {\r\nprivate:\r\n    vector<ll>\
    \ par;\r\npublic:\r\n    UnionFind(ll n): par(n, -1){}\r\n    ll operator[](ll\
    \ a) {\r\n        while(par[a] >= 0) {\r\n            ll p = par[par[a]];\r\n\
    \            if(p < 0) return par[a];\r\n            a = par[a] = p;\r\n     \
    \   }\r\n        return a;\r\n    }\r\n    bool unite(ll x, ll y) {\r\n      \
    \  x = (*this)[x], y = (*this)[y];\r\n        if(x == y) return 0;\r\n       \
    \ if(-par[x] < -par[y]) swap(x, y);\r\n        par[x] += par[y], par[y] = x;\r\
    \n        return 1;\r\n    }\r\n    ll size(ll x) {\r\n        x = (*this)[x];\r\
    \n        return -par[x];\r\n    }\r\n    vector<vector<ll>> groups() {\r\n  \
    \      const int n = par.size();\r\n        vector<vector<ll>> res(n);\r\n   \
    \     for(int i = 0; i < n; ++i) res[(*this)[i]].emplace_back(i);\r\n        res.erase(remove_if(res.begin(),\
    \ res.end(), [&](const vector<ll> &v){ return v.empty(); }), res.end());\r\n \
    \       return res;\r\n    }\r\n};\r\n"
  dependsOn: []
  isVerificationFile: false
  path: C++/UnionFind.hpp
  requiredBy:
  - C++/graph.hpp
  timestamp: '2023-09-10 15:30:23+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/uf.test.cpp
  - test/lca.test.cpp
documentation_of: C++/UnionFind.hpp
layout: document
redirect_from:
- /library/C++/UnionFind.hpp
- /library/C++/UnionFind.hpp.html
title: C++/UnionFind.hpp
---
