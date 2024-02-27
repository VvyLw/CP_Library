---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    document_title: MergeUnionFind
    links: []
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 401, in update\n    self.update(self._resolve(pathlib.Path(included), included_from=path))\n\
    \  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 260, in _resolve\n    raise BundleErrorAt(path, -1, \"no such header\"\
    )\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt: C++/structure/uf/UnionFind.hpp:\
    \ line -1: no such header\n"
  code: "#pragma once\n\n#include \"C++/structure/uf/UnionFind.hpp\"\ntemplate <class\
    \ T> struct MergeUF: UnionFind {\n    using UnionFind::par;\n    using UnionFind::operator[];\n\
    \    using UnionFind::size;\n    using UnionFind::groups;\n    MergeUF(const int\
    \ n): UnionFind(n){}\n    ~MergeUF(){}\n    virtual T get(const int i) = 0;\n\
    \    virtual void merge(const int i, const int j) = 0;\n    bool unite(int x,\
    \ int y) {\n\t\tx = (*this)[x], y = (*this)[y];\n        if(x == y) return false;\n\
    \        if(-par[x] < -par[y]) {\n            std::swap(x, y);\n        }\n  \
    \      par[x] += par[y], par[y] = x;\n\t\tmerge(x, y);\n\t\treturn true;\n\t}\n\
    };\n/**\n * @brief MergeUnionFind\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/ds/uf/MergeUF.hpp
  requiredBy: []
  timestamp: '1970-01-01 00:00:00+00:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/ds/uf/MergeUF.hpp
layout: document
redirect_from:
- /library/C++/ds/uf/MergeUF.hpp
- /library/C++/ds/uf/MergeUF.hpp.html
title: MergeUnionFind
---
