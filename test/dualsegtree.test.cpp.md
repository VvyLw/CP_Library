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
    , line 260, in _resolve\n    raise BundleErrorAt(path, -1, \"no such header\"\
    )\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt: C++/structure/DualSegmentTree.hpp:\
    \ line -1: no such header\n"
  code: "#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/2/DSL_2_D\"\
    \n#include <iostream>\n#include \"C++/structure/DualSegmentTree.hpp\"\nint main()\
    \ {\n    int n, q;\n    std::cin >> n >> q;\n    DualSegTree<int> seg(n, [](const\
    \ int a, const int b) -> int { return b; }, INT32_MAX);\n    while(q--) {\n  \
    \      int h;\n        std::cin >> h;\n        if(h == 0) {\n            int s,\
    \ t, x;\n            std::cin >> s >> t >> x;\n            seg.apply(s, ++t, x);\n\
    \        } else {\n            int i;\n            std::cin >> i;\n          \
    \  std::cout << seg[i] << '\\n';\n        }\n    }\n}"
  dependsOn: []
  isVerificationFile: true
  path: test/dualsegtree.test.cpp
  requiredBy: []
  timestamp: '1970-01-01 00:00:00+00:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: test/dualsegtree.test.cpp
layout: document
redirect_from:
- /verify/test/dualsegtree.test.cpp
- /verify/test/dualsegtree.test.cpp.html
title: test/dualsegtree.test.cpp
---
