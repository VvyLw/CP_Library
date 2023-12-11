---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/UnionFind.hpp
    title: C++/UnionFind.hpp
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/1/DSL_1_B
    links:
    - https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/1/DSL_1_B
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 401, in update\n    self.update(self._resolve(pathlib.Path(included), included_from=path))\n\
    \  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 312, in update\n    raise BundleErrorAt(path, i + 1, \"#pragma once found\
    \ in a non-first line\")\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt:\
    \ C++/UnionFind.hpp: line 3: #pragma once found in a non-first line\n"
  code: "#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/1/DSL_1_B\"\
    \n#include <iostream>\n#include \"C++/UnionFind.hpp\"\nint main() {\n    int n,\
    \ q;\n    std::cin >> n >> q;\n    UFPotential uf(n);\n    while(q--) {\n    \
    \    int t, x, y;\n        std::cin >> t >> x >> y;\n        if(t) {\n       \
    \     if(uf[x] == uf[y]) {\n                std::cout << uf.dist(x, y) << '\\\
    n';\n            }\n            else {\n                std::cout << \"?\\n\"\
    ;\n            }\n        }\n        else {\n            int z;\n            std::cin\
    \ >> z;\n            uf.unite(x, y, z);\n        }\n    }\n}"
  dependsOn:
  - C++/UnionFind.hpp
  isVerificationFile: true
  path: test/ufpotential.test.cpp
  requiredBy: []
  timestamp: '2023-12-11 21:29:48+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/ufpotential.test.cpp
layout: document
redirect_from:
- /verify/test/ufpotential.test.cpp
- /verify/test/ufpotential.test.cpp.html
title: test/ufpotential.test.cpp
---
