---
data:
  _extendedDependsOn:
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
    PROBLEM: https://onlinejudge.u-aizu.ac.jp/courses/library/5/GRL/all/GRL_2_A
    links:
    - https://onlinejudge.u-aizu.ac.jp/courses/library/5/GRL/all/GRL_2_A
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 401, in update\n    self.update(self._resolve(pathlib.Path(included), included_from=path))\n\
    \  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 401, in update\n    self.update(self._resolve(pathlib.Path(included), included_from=path))\n\
    \  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 312, in update\n    raise BundleErrorAt(path, i + 1, \"#pragma once found\
    \ in a non-first line\")\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt:\
    \ C++/UnionFind.hpp: line 3: #pragma once found in a non-first line\n"
  code: "#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/library/5/GRL/all/GRL_2_A\"\
    \n#include \"C++/graph.hpp\"\nint main() {\n    std::cin.tie(nullptr) -> sync_with_stdio(false);\n\
    \    int n, m;\n    std::cin >> n >> m;\n    tree g(n, 0);\n    g.input(m);\n\
    \    std::cout << g.kruskal() << '\\n';\n}"
  dependsOn:
  - C++/graph.hpp
  - C++/UnionFind.hpp
  isVerificationFile: true
  path: test/kruskal.test.cpp
  requiredBy: []
  timestamp: '2023-12-11 21:29:48+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/kruskal.test.cpp
layout: document
redirect_from:
- /verify/test/kruskal.test.cpp
- /verify/test/kruskal.test.cpp.html
title: test/kruskal.test.cpp
---
