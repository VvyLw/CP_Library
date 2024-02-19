---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    document_title: "Tetration(a\u2191\u2191b)"
    links: []
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 401, in update\n    self.update(self._resolve(pathlib.Path(included), included_from=path))\n\
    \  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 260, in _resolve\n    raise BundleErrorAt(path, -1, \"no such header\"\
    )\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt: math/euler_phi.hpp:\
    \ line -1: no such header\n"
  code: "#pragma once\n\n#include \"math/euler_phi.hpp\"\n#ifndef TEMPLATE\nnamespace\
    \ zia_qu {\ntemplate <class T> inline T pow(T a, T b, const T mod=0) {\n\tT res=1;\n\
    \tif(mod) {\n\t\tres%=mod;\n\t\ta%=mod;\n\t}\n\twhile(b>0) {\n\t\tif(b&1) res*=a;\n\
    \t\tif(mod) res%=mod;\n\t\ta*=a;\n\t\tif(mod) a%=mod;\n\t\tb>>=1;\n\t}\n\treturn\
    \ res;\n}\n}\n#endif\ntemplate <class T> inline T tetration(const T a, const T\
    \ b, const T m) {\n    if(m == 1) {\n        return 0;\n    }\n    if(a == 0)\
    \ {\n        return (b & 1) ? 0 : 1;\n    }\n    if(b == 0) {\n        return\
    \ 1;\n    }\n    if(b == 1) {\n        return a % m;\n    }\n    if(b == 2) {\n\
    \        return zia_qu::pow(a, a, m);\n    }\n    const auto phi = euler_phi(m);\n\
    \    auto tmp = tetration(a, b - 1, phi);\n    if(!tmp) {\n        tmp += phi;\n\
    \    }\n    return zia_qu::pow(a, tmp, m);\n}\n\n/**\n * @brief Tetration(a\u2191\
    \u2191b)\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/tetration.hpp
  requiredBy: []
  timestamp: '1970-01-01 00:00:00+00:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/math/tetration.hpp
layout: document
redirect_from:
- /library/C++/math/tetration.hpp
- /library/C++/math/tetration.hpp.html
title: "Tetration(a\u2191\u2191b)"
---
