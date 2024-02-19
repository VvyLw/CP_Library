---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    document_title: "\u7D2F\u7A4D\u548C"
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
  code: "#pragma once\n\n#include <numeric>\n#include \"myvector.hpp\"\nnamespace\
    \ Heileden {\nstruct psum {\nprivate:\n    vectors::vi s;\npublic:\n    psum(const\
    \ vectors::vi& v): s{0} { std::partial_sum(v.begin(), v.end(), std::back_inserter(s));\
    \ }\n    vectors::vi get() const { return s; }\n    // [l, r]\n    ll query(const\
    \ int l, const int r) const { return s[r]-s[l]; }\n};\n}\n\n/**\n * @brief \u7D2F\
    \u7A4D\u548C\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/prefixsum.hpp
  requiredBy: []
  timestamp: '1970-01-01 00:00:00+00:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/math/prefixsum.hpp
layout: document
redirect_from:
- /library/C++/math/prefixsum.hpp
- /library/C++/math/prefixsum.hpp.html
title: "\u7D2F\u7A4D\u548C"
---
