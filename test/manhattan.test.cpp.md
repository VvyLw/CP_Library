---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: cpp
  _verificationStatusIcon: ':x:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 401, in update\n    self.update(self._resolve(pathlib.Path(included), included_from=path))\n\
    \  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 401, in update\n    self.update(self._resolve(pathlib.Path(included), included_from=path))\n\
    \  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 260, in _resolve\n    raise BundleErrorAt(path, -1, \"no such header\"\
    )\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt: C++/structure/uf/UnionFind.hpp:\
    \ line -1: no such header\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/manhattanmst\"\n#include\
    \ <iostream>\n#include \"C++/graph/mst/kruskal.hpp\"\n#include \"C++/graph/mst/manhattan.hpp\"\
    \nint main() {\n    int n;\n    std::cin >> n;\n    std::vector<int> x(n), y(n);\n\
    \    for(int i = 0; i < n; ++i) {\n        std::cin >> x[i] >> y[i];\n    }\n\
    \    const auto ans = kruskal(manhattan(x, y), n);\n    std::cout << ans.cost\
    \ << '\\n';\n    for(const auto &e: ans.tree) {\n        std::cout << e.src <<\
    \ ' ' << e.to << '\\n';\n    }\n}"
  dependsOn: []
  isVerificationFile: true
  path: test/manhattan.test.cpp
  requiredBy: []
  timestamp: '1970-01-01 00:00:00+00:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: test/manhattan.test.cpp
layout: document
redirect_from:
- /verify/test/manhattan.test.cpp
- /verify/test/manhattan.test.cpp.html
title: test/manhattan.test.cpp
---
