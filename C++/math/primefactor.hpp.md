---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    document_title: "\u7D20\u56E0\u6570\u5206\u89E3"
    links: []
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 401, in update\n    self.update(self._resolve(pathlib.Path(included), included_from=path))\n\
    \  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 260, in _resolve\n    raise BundleErrorAt(path, -1, \"no such header\"\
    )\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt: mypair.hpp: line\
    \ -1: no such header\n"
  code: "#pragma once\n\n#include \"mypair.hpp\"\n#ifndef TEMPLATE\n#define sqrp(i,a,b)\
    \ for(long long i = (a); i * i <= (b); ++i)\n#endif\nnamespace Heileden {\ntemplate\
    \ <class T> inline vectors::V<pairs::PP<T>> prmfct(T n) {\n    vectors::V<pairs::PP<T>>\
    \ res;\n    for(T i = 2; i * i <= n; ++i) {\n        if(n%i!=0) continue;\n  \
    \      T tmp=0;\n        while(n%i==0) {\n            tmp++;\n            n/=i;\n\
    \        }\n        res.emplace_back(i,tmp);\n    }\n    if(n!=1) res.emplace_back(n,1);\n\
    \    return res;\n}\n}\n\n/**\n * @brief \u7D20\u56E0\u6570\u5206\u89E3\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/primefactor.hpp
  requiredBy: []
  timestamp: '1970-01-01 00:00:00+00:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/math/primefactor.hpp
layout: document
redirect_from:
- /library/C++/math/primefactor.hpp
- /library/C++/math/primefactor.hpp.html
title: "\u7D20\u56E0\u6570\u5206\u89E3"
---
