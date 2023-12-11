---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/LCA.hpp
    title: C++/LCA.hpp
  - icon: ':heavy_check_mark:'
    path: C++/UnionFind.hpp
    title: C++/UnionFind.hpp
  - icon: ':heavy_check_mark:'
    path: C++/graph.hpp
    title: C++/graph.hpp
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://judge.yosupo.jp/problem/lca
    links:
    - https://judge.yosupo.jp/problem/lca
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 401, in update\n    self.update(self._resolve(pathlib.Path(included), included_from=path))\n\
    \  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 312, in update\n    raise BundleErrorAt(path, i + 1, \"#pragma once found\
    \ in a non-first line\")\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt:\
    \ C++/LCA.hpp: line 2: #pragma once found in a non-first line\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/lca\"\n#include <iostream>\n\
    #include \"C++/LCA.hpp\"\n#include \"C++/graph.hpp\"\nint main() {\n    cin.tie(nullptr)\
    \ -> sync_with_stdio(false);\n    int n, q;\n    cin >> n >> q;\n    graph<false>\
    \ g(n, 0);\n    for(int i = 1; i < n; ++i) {\n        int p;\n        cin >> p;\n\
    \        g.add(p, i);\n    }\n    LowestCommonAncestor lca(g);\n    while(q--)\
    \ {\n        int u, v;\n        std::cin >> u >> v;\n        std::cout << lca.query(u,\
    \ v) << '\\n';\n    }\n}"
  dependsOn:
  - C++/LCA.hpp
  - C++/graph.hpp
  - C++/UnionFind.hpp
  isVerificationFile: true
  path: test/lca.test.cpp
  requiredBy: []
  timestamp: '2023-12-11 21:08:07+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/lca.test.cpp
layout: document
redirect_from:
- /verify/test/lca.test.cpp
- /verify/test/lca.test.cpp.html
title: test/lca.test.cpp
---
