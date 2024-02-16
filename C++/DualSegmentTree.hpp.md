---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/dualsegtree.test.cpp
    title: test/dualsegtree.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: "\u53CC\u5BFE\u30BB\u30B0\u6728"
    links:
    - https://ei1333.github.io/library/structure/segment-tree/dual-segment-tree.hpp
  bundledCode: "#line 2 \"C++/DualSegmentTree.hpp\"\n\n#pragma GCC diagnostic ignored\
    \ \"-Wreorder\"\n\n#include <vector>\n#include <functional>\ntemplate <class T>\
    \ struct DualSegTree {\nprivate:\n    using F = std::function<T(T, T)>;\n    int\
    \ sz, h;\n    std::vector<T> lazy;\n    const T id;\n    const F ap;\n    inline\
    \ void propagate(const int k) {\n        if(lazy[k] != id) {\n            lazy[2\
    \ * k] = ap(lazy[2 * k], lazy[k]);\n            lazy[2 * k + 1] = ap(lazy[2 *\
    \ k + 1], lazy[k]);\n            lazy[k] = id;\n        }\n    }\n    inline void\
    \ thrust(const int k) {\n        for(int i = h; i > 0; i--) {\n            propagate(k\
    \ >> i);\n        }\n    }\npublic:\n    DualSegTree(const int n, const F &ap,\
    \ const T &id): ap(ap), id(id) {\n        sz = 1;\n        h = 0;\n        while(sz\
    \ < n) {\n            sz <<= 1;\n            h++;\n        }\n        lazy.assign(2\
    \ * sz, id);\n    }\n    void apply(int a, int b, const T &x) {\n        thrust(a\
    \ += sz);\n        thrust(b += sz - 1);\n        for(int l = a, r = b + 1; l <\
    \ r; l >>= 1, r >>= 1) {\n            if(l & 1) {\n                lazy[l] = ap(lazy[l],\
    \ x);\n                l++;\n            }\n            if(r & 1) {\n        \
    \        r--;\n                lazy[r] = ap(lazy[r], x);\n            }\n    \
    \    }\n    }\n    inline T operator[](int k) {\n        thrust(k += sz);\n  \
    \      return lazy[k];\n    }\n};\n\n/**\n * @brief \u53CC\u5BFE\u30BB\u30B0\u6728\
    \n * @see https://ei1333.github.io/library/structure/segment-tree/dual-segment-tree.hpp\n\
    \ */\n"
  code: "#pragma once\n\n#pragma GCC diagnostic ignored \"-Wreorder\"\n\n#include\
    \ <vector>\n#include <functional>\ntemplate <class T> struct DualSegTree {\nprivate:\n\
    \    using F = std::function<T(T, T)>;\n    int sz, h;\n    std::vector<T> lazy;\n\
    \    const T id;\n    const F ap;\n    inline void propagate(const int k) {\n\
    \        if(lazy[k] != id) {\n            lazy[2 * k] = ap(lazy[2 * k], lazy[k]);\n\
    \            lazy[2 * k + 1] = ap(lazy[2 * k + 1], lazy[k]);\n            lazy[k]\
    \ = id;\n        }\n    }\n    inline void thrust(const int k) {\n        for(int\
    \ i = h; i > 0; i--) {\n            propagate(k >> i);\n        }\n    }\npublic:\n\
    \    DualSegTree(const int n, const F &ap, const T &id): ap(ap), id(id) {\n  \
    \      sz = 1;\n        h = 0;\n        while(sz < n) {\n            sz <<= 1;\n\
    \            h++;\n        }\n        lazy.assign(2 * sz, id);\n    }\n    void\
    \ apply(int a, int b, const T &x) {\n        thrust(a += sz);\n        thrust(b\
    \ += sz - 1);\n        for(int l = a, r = b + 1; l < r; l >>= 1, r >>= 1) {\n\
    \            if(l & 1) {\n                lazy[l] = ap(lazy[l], x);\n        \
    \        l++;\n            }\n            if(r & 1) {\n                r--;\n\
    \                lazy[r] = ap(lazy[r], x);\n            }\n        }\n    }\n\
    \    inline T operator[](int k) {\n        thrust(k += sz);\n        return lazy[k];\n\
    \    }\n};\n\n/**\n * @brief \u53CC\u5BFE\u30BB\u30B0\u6728\n * @see https://ei1333.github.io/library/structure/segment-tree/dual-segment-tree.hpp\n\
    \ */"
  dependsOn: []
  isVerificationFile: false
  path: C++/DualSegmentTree.hpp
  requiredBy: []
  timestamp: '2024-02-16 10:50:37+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/dualsegtree.test.cpp
documentation_of: C++/DualSegmentTree.hpp
layout: document
redirect_from:
- /library/C++/DualSegmentTree.hpp
- /library/C++/DualSegmentTree.hpp.html
title: "\u53CC\u5BFE\u30BB\u30B0\u6728"
---
