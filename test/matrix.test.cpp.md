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
    )\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt: math/Matrix.hpp:\
    \ line -1: no such header\n"
  code: "#define PROBLEM \"https://yukicoder.me/problems/no/2441\"\n#include <iostream>\n\
    #include \"math/Matrix.hpp\"\nint main() {\n    int a, b, c, d;\n    std::cin\
    \ >> a >> b >> c >> d;\n    Matrix<int64_t> m(2);\n    m[0][0] = a;\n    m[0][1]\
    \ = b;\n    m[1][0] = c;\n    m[1][1] = d;\n    m ^= 3;\n    for(int i = 0; i\
    \ < 2; ++i) {\n        std::cout << m[i][0] << ' ' << m[i][1] << '\\n';\n    }\n\
    }"
  dependsOn: []
  isVerificationFile: true
  path: test/matrix.test.cpp
  requiredBy: []
  timestamp: '1970-01-01 00:00:00+00:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: test/matrix.test.cpp
layout: document
redirect_from:
- /verify/test/matrix.test.cpp
- /verify/test/matrix.test.cpp.html
title: test/matrix.test.cpp
---
