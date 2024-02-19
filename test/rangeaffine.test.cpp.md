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
    )\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt: math/Modint.hpp:\
    \ line -1: no such header\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/range_affine_range_sum\"\
    \n#include \"math/Modint.hpp\"\n#include \"structure/LazySegmentTree.hpp\"\nusing\
    \ Z = zwei<mint>;\nint main() {\n    int n, q;\n    std::cin >> n >> q;\n    LazySegTree<Z,\
    \ Z> seg(n, [](const Z &a, const Z &b) -> Z { return Z(a.first + b.first, a.second\
    \ + b.second); }, [](const Z &a, const Z &b) -> Z { return Z(a.first * b.first\
    \ + a.second * b.second, a.second); }, [](const Z &a, const Z &b) -> Z { return\
    \ Z(a.first * b.first, a.second * b.first + b.second); }, Z(0, 0), Z(1, 0));\n\
    \tstd::vector<Z> a(n);\n    for(int i = 0; i < n; ++i) {\n        int x;\n   \
    \     std::cin >> x;\n        a[i] = Z(x, 1);\n    }\n    seg.build(a);\n    while(q--)\
    \ {\n        int t, l, r;\n        std::cin >> t >> l >> r;\n        if(t == 0)\
    \ {\n            int p, q;\n            std::cin >> p >> q;\n            seg.apply(l,\
    \ r, Z(p, q));\n        } else {\n            std::cout << seg.query(l, r) <<\
    \ '\\n';\n        }\n    }\n}\n\n// verified but actually failed(slowest: 9.000372\
    \ sec.)"
  dependsOn: []
  isVerificationFile: true
  path: test/rangeaffine.test.cpp
  requiredBy: []
  timestamp: '1970-01-01 00:00:00+00:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: test/rangeaffine.test.cpp
layout: document
redirect_from:
- /verify/test/rangeaffine.test.cpp
- /verify/test/rangeaffine.test.cpp.html
title: test/rangeaffine.test.cpp
---
