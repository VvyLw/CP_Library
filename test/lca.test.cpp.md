---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/LCA.hpp
    title: C++/LCA.hpp
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
  bundledCode: "#line 1 \"test/lca.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/lca\"\
    \n#include <iostream>\n#include <C++/LCA.hpp>\n#include <C++/graph.hpp>\nint main()\
    \ {\n    cin.tie(nullptr) -> sync_with_stdio(false);\n    int n, q;\n    cin >>\
    \ n >> q;\n    graph<false> g(n);\n    for(int i = 1; i < n; ++i) {\n        int\
    \ p;\n        cin >> p;\n        g.add(p, i, 0);\n    }\n    LowestCommonAncestor\
    \ lca(g);\n    lca.build();\n    while(q--) {\n        int u, v;\n        std::cin\
    \ >> u >> v;\n        std::cout << lca.query(u, v) << '\\n';\n    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/lca\"\n#include <iostream>\n\
    #include <C++/LCA.hpp>\n#include <C++/graph.hpp>\nint main() {\n    cin.tie(nullptr)\
    \ -> sync_with_stdio(false);\n    int n, q;\n    cin >> n >> q;\n    graph<false>\
    \ g(n);\n    for(int i = 1; i < n; ++i) {\n        int p;\n        cin >> p;\n\
    \        g.add(p, i, 0);\n    }\n    LowestCommonAncestor lca(g);\n    lca.build();\n\
    \    while(q--) {\n        int u, v;\n        std::cin >> u >> v;\n        std::cout\
    \ << lca.query(u, v) << '\\n';\n    }\n}"
  dependsOn:
  - C++/LCA.hpp
  - C++/graph.hpp
  isVerificationFile: true
  path: test/lca.test.cpp
  requiredBy: []
  timestamp: '2023-12-02 08:23:51+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/lca.test.cpp
layout: document
redirect_from:
- /verify/test/lca.test.cpp
- /verify/test/lca.test.cpp.html
title: test/lca.test.cpp
---
