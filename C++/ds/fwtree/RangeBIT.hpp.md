---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    document_title: Range BIT
    links: []
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 401, in update\n    self.update(self._resolve(pathlib.Path(included), included_from=path))\n\
    \  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 260, in _resolve\n    raise BundleErrorAt(path, -1, \"no such header\"\
    )\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt: C++/structure/fwtree/FenwickTree.hpp:\
    \ line -1: no such header\n"
  code: "#pragma once\n\n#include \"C++/structure/fwtree/FenwickTree.hpp\"\ntemplate\
    \ <class T> struct RangeBIT {\nprivate:\n    FenwickTree<T> a, b;\npublic:\n \
    \   RangeBIT(const int n): a(n + 1), b(n + 1){}\n    RangeBIT(const std::vector<T>\
    \ &v) {\n        this(v.size());\n        for(size_t i = 0; i < v.size(); ++i)\
    \ {\n            add(i, i + 1, v[i]);\n        }\n    }\n    void add(const int\
    \ l, const int r, const T &x) {\n        a.add(l, x);\n        a.add(r, -x);\n\
    \        b.add(l, x * (1 - l));\n        b.add(r, x * (r - 1));\n    }\n    inline\
    \ T operator[](const int i) const { return sum(i, i + 1); }\n    inline T sum(int\
    \ l, int r) {\n        l--, r--;\n        return a.sum(r) * r + b.sum(r) - a.sum(l)\
    \ * l - b.sum(l);\n    }\n};\n\n/**\n * @brief Range BIT\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/ds/fwtree/RangeBIT.hpp
  requiredBy: []
  timestamp: '1970-01-01 00:00:00+00:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/ds/fwtree/RangeBIT.hpp
layout: document
redirect_from:
- /library/C++/ds/fwtree/RangeBIT.hpp
- /library/C++/ds/fwtree/RangeBIT.hpp.html
title: Range BIT
---
