---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    document_title: "\u7D20\u56E0\u6570\u5206\u89E3\u30C6\u30FC\u30D6\u30EB"
    links: []
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 401, in update\n    self.update(self._resolve(pathlib.Path(included), included_from=path))\n\
    \  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 260, in _resolve\n    raise BundleErrorAt(path, -1, \"no such header\"\
    )\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt: myvector.hpp:\
    \ line -1: no such header\n"
  code: "#pragma once\n\n#include <map>\n#include <numeric>\n#include \"myvector.hpp\"\
    \nnamespace Heileden {\nstruct p_fact {\n    vectors::vi spf;\n    p_fact(const\
    \ int n): spf(n + 1){\n        std::iota(spf.begin(), spf.end(), 0);\n       \
    \ for(int i = 2; i * i <= n; ++i) {\n            if(spf[i]==i) {\n           \
    \     for(int j = i * i; j <= n; j += i) {\n                    if(spf[j]==j)\
    \ spf[j]=i;\n                }\n            }\n        }\n    }\n    std::map<int,int>\
    \ get(int n) {\n        std::map<int,int> m;\n        while(n!=1) {\n        \
    \    m[spf[n]]++;\n            n/=spf[n];\n        }\n        return m;\n    }\n\
    };\n}\n\n/**\n * @brief \u7D20\u56E0\u6570\u5206\u89E3\u30C6\u30FC\u30D6\u30EB\
    \n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/primefactortable.hpp
  requiredBy: []
  timestamp: '1970-01-01 00:00:00+00:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/math/primefactortable.hpp
layout: document
redirect_from:
- /library/C++/math/primefactortable.hpp
- /library/C++/math/primefactortable.hpp.html
title: "\u7D20\u56E0\u6570\u5206\u89E3\u30C6\u30FC\u30D6\u30EB"
---
