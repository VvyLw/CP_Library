---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    document_title: "\u7D04\u6570\u5217\u6319"
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
  code: "#pragma once\n\n#include <algorithm>\n#include \"myvector.hpp\"\n#ifndef\
    \ TEMPLATE\n#endif\nnamespace Heileden {\ntemplate <class T> inline vectors::V<T>\
    \ div(const T n) {\n    vectors::V<T> d;\n    for(long long i = 1; i * i <= n;\
    \ ++i) {\n        if(n%i==0) {\n            d.emplace_back(i);\n            if(i*i!=n)\
    \ d.emplace_back(n/i);\n        }\n    }\n    std::sort(d.begin(), d.end());\n\
    \    return d;\n}\n}\n\n/**\n * @brief \u7D04\u6570\u5217\u6319\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/divisor.hpp
  requiredBy: []
  timestamp: '1970-01-01 00:00:00+00:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/math/divisor.hpp
layout: document
redirect_from:
- /library/C++/math/divisor.hpp
- /library/C++/math/divisor.hpp.html
title: "\u7D04\u6570\u5217\u6319"
---
