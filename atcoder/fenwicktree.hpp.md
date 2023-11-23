---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: atcoder/internal_type_traits.hpp
    title: atcoder/internal_type_traits.hpp
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    links:
    - https://en.wikipedia.org/wiki/Fenwick_tree
  bundledCode: "#line 1 \"atcoder/fenwicktree.hpp\"\n\n\n\n#include <atcoder/internal_type_traits>\n\
    #include <cassert>\n#include <vector>\n\nnamespace atcoder {\n\n// Reference:\
    \ https://en.wikipedia.org/wiki/Fenwick_tree\ntemplate <class T> struct fenwick_tree\
    \ {\n    using U = internal::to_unsigned_t<T>;\n\n  public:\n    fenwick_tree()\
    \ : _n(0) {}\n    fenwick_tree(int n) : _n(n), data(n) {}\n\n    void add(int\
    \ p, T x) {\n        assert(0 <= p && p < _n);\n        p++;\n        while (p\
    \ <= _n) {\n            data[p - 1] += U(x);\n            p += p & -p;\n     \
    \   }\n    }\n\n    T sum(int l, int r) {\n        assert(0 <= l && l <= r &&\
    \ r <= _n);\n        return sum(r) - sum(l);\n    }\n\n  private:\n    int _n;\n\
    \    std::vector<U> data;\n\n    U sum(int r) {\n        U s = 0;\n        while\
    \ (r > 0) {\n            s += data[r - 1];\n            r -= r & -r;\n       \
    \ }\n        return s;\n    }\n};\n\n}  // namespace atcoder\n\n\n"
  code: "#ifndef ATCODER_FENWICKTREE_HPP\n#define ATCODER_FENWICKTREE_HPP 1\n\n#include\
    \ <atcoder/internal_type_traits>\n#include <cassert>\n#include <vector>\n\nnamespace\
    \ atcoder {\n\n// Reference: https://en.wikipedia.org/wiki/Fenwick_tree\ntemplate\
    \ <class T> struct fenwick_tree {\n    using U = internal::to_unsigned_t<T>;\n\
    \n  public:\n    fenwick_tree() : _n(0) {}\n    fenwick_tree(int n) : _n(n), data(n)\
    \ {}\n\n    void add(int p, T x) {\n        assert(0 <= p && p < _n);\n      \
    \  p++;\n        while (p <= _n) {\n            data[p - 1] += U(x);\n       \
    \     p += p & -p;\n        }\n    }\n\n    T sum(int l, int r) {\n        assert(0\
    \ <= l && l <= r && r <= _n);\n        return sum(r) - sum(l);\n    }\n\n  private:\n\
    \    int _n;\n    std::vector<U> data;\n\n    U sum(int r) {\n        U s = 0;\n\
    \        while (r > 0) {\n            s += data[r - 1];\n            r -= r &\
    \ -r;\n        }\n        return s;\n    }\n};\n\n}  // namespace atcoder\n\n\
    #endif  // ATCODER_FENWICKTREE_HPP\n"
  dependsOn:
  - atcoder/internal_type_traits.hpp
  isVerificationFile: false
  path: atcoder/fenwicktree.hpp
  requiredBy: []
  timestamp: '2023-11-23 12:08:21+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: atcoder/fenwicktree.hpp
layout: document
redirect_from:
- /library/atcoder/fenwicktree.hpp
- /library/atcoder/fenwicktree.hpp.html
title: atcoder/fenwicktree.hpp
---
