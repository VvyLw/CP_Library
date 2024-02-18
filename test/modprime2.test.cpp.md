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
    )\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt: ModPrime.hpp:\
    \ line -1: no such header\n"
  code: "#define PROBLEM \"https://yukicoder.me/problems/no/117\"\n#include <iostream>\n\
    #include \"ModPrime.hpp\"\nconstexpr int mod = 1e9 + 7;\nModPrime<(int) 2e7 +\
    \ 1> mp(mod);\nint main() {\n    std::cin.tie(nullptr) -> sync_with_stdio(false);\n\
    \    int t;\n    std::cin >> t;\n    while(t--) {\n        char c, tmp;\n    \
    \    int n, k;\n        std::cin >> c >> tmp >> n >> tmp >> k >> tmp;\n      \
    \  std::cout << (c == 'C' ? mp.C(n, k) : c == 'P' ? mp.P(n, k) : mp.H(n, k)) <<\
    \ '\\n';\n    }\n}"
  dependsOn: []
  isVerificationFile: true
  path: test/modprime2.test.cpp
  requiredBy: []
  timestamp: '1970-01-01 00:00:00+00:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: test/modprime2.test.cpp
layout: document
redirect_from:
- /verify/test/modprime2.test.cpp
- /verify/test/modprime2.test.cpp.html
title: test/modprime2.test.cpp
---
