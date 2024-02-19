---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    document_title: "\u8EE2\u5012\u6570"
    links: []
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 401, in update\n    self.update(self._resolve(pathlib.Path(included), included_from=path))\n\
    \  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 260, in _resolve\n    raise BundleErrorAt(path, -1, \"no such header\"\
    )\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt: structure/fwtree/FenwickTree.hpp:\
    \ line -1: no such header\n"
  code: "#pragma once\n\n#include <algorithm>\n#include \"structure/fwtree/FenwickTree.hpp\"\
    \ntemplate <class T> inline long long inv_num(const std::vector<T> &a) {\n   \
    \ std::vector<std::pair<T, int>> p(a.size());\n    for(size_t i = 0; i < a.size();\
    \ ++i) {\n        p[i] = {a[i], i};\n    }\n    std::sort(p.begin(), p.end());\n\
    \    std::vector<int> id(a.size());\n    for(size_t i = 0; i < a.size(); ++i)\
    \ {\n        id[p[i].second] = i;\n    }\n    FenwickTree<T> bit(a.size());\n\
    \    long long res = 0;\n    for(size_t i = 0; i < a.size(); ++i) {\n        res\
    \ += i - bit.sum(id[i]);\n        bit.add(id[i], 1);\n    }\n    return res;\n\
    }\n\n/**\n * @brief \u8EE2\u5012\u6570\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/inverse_num.hpp
  requiredBy: []
  timestamp: '1970-01-01 00:00:00+00:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/math/inverse_num.hpp
layout: document
redirect_from:
- /library/C++/math/inverse_num.hpp
- /library/C++/math/inverse_num.hpp.html
title: "\u8EE2\u5012\u6570"
---
