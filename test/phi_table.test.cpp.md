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
    )\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt: math/phitable.hpp:\
    \ line -1: no such header\n"
  code: "#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/problems/2286\"\n#include\
    \ <iostream>\n#include \"math/phitable.hpp\"\nconstexpr int n = 1e6;\nint main()\
    \ {\n    const auto phi = phi_table(n).get();\n    std::vector<int64_t> ret(n\
    \ + 1);\n    ret[1] = 2;\n    for(int i = 2; i <= n; ++i) {\n        ret[i] =\
    \ ret[i - 1] + phi[i];\n    }\n    int t;\n    std::cin >> t;\n    while(t--)\
    \ {\n        int i;\n        std::cin >> i;\n        std::cout << ret[i] << '\\\
    n';\n    }\n}"
  dependsOn: []
  isVerificationFile: true
  path: test/phi_table.test.cpp
  requiredBy: []
  timestamp: '1970-01-01 00:00:00+00:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: test/phi_table.test.cpp
layout: document
redirect_from:
- /verify/test/phi_table.test.cpp
- /verify/test/phi_table.test.cpp.html
title: test/phi_table.test.cpp
---
