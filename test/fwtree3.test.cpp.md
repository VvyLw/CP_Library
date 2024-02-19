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
    )\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt: structure/fwtree/RangeBIT.hpp:\
    \ line -1: no such header\n"
  code: "#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/2/DSL_2_G\"\
    \n#include <iostream>\n#include \"structure/fwtree/RangeBIT.hpp\"\nint main()\
    \ {\n    int n, q;\n    std::cin >> n >> q;\n    RangeBIT<int64_t> bit(n);\n \
    \   while(q--) {\n        int h, s, t;\n        std::cin >> h >> s >> t;\n   \
    \     s--;\n        if(h == 0) {\n            int x;\n            std::cin >>\
    \ x;\n            bit.add(s, t, x);\n        } else {\n            std::cout <<\
    \ bit.sum(s, t) << '\\n';\n        }\n    }\n}"
  dependsOn: []
  isVerificationFile: true
  path: test/fwtree3.test.cpp
  requiredBy: []
  timestamp: '1970-01-01 00:00:00+00:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: test/fwtree3.test.cpp
layout: document
redirect_from:
- /verify/test/fwtree3.test.cpp
- /verify/test/fwtree3.test.cpp.html
title: test/fwtree3.test.cpp
---
