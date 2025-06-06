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
  bundledCode: "#line 2 \"C++/ds/DualSegmentTree.hpp\"\n\n#pragma GCC diagnostic ignored\
    \ \"-Wreorder\"\n\n#include <vector>\n#include <functional>\nnamespace man {\n\
    template <class T> struct DualSegTree {\nprivate:\n    using F = std::function<T(T,\
    \ T)>;\n    int sz, h;\n    std::vector<T> lazy;\n    const T id;\n    const F\
    \ ap;\n    constexpr inline void propagate(const int k) noexcept {\n        if(lazy[k]\
    \ != id) {\n            lazy[2 * k] = ap(lazy[2 * k], lazy[k]);\n            lazy[2\
    \ * k + 1] = ap(lazy[2 * k + 1], lazy[k]);\n            lazy[k] = id;\n      \
    \  }\n    }\n    constexpr inline void thrust(const int k) noexcept {\n      \
    \  for(int i = h; i > 0; i--) {\n            propagate(k >> i);\n        }\n \
    \   }\npublic:\n    DualSegTree(const int n, const F &ap, const T &id): ap(ap),\
    \ id(id) {\n        sz = 1;\n        h = 0;\n        while(sz < n) {\n       \
    \     sz <<= 1;\n            h++;\n        }\n        lazy.assign(2 * sz, id);\n\
    \    }\n    constexpr inline void apply(int a, int b, const T &x) noexcept {\n\
    \        thrust(a += sz);\n        thrust(b += sz - 1);\n        for(int l = a,\
    \ r = b + 1; l < r; l >>= 1, r >>= 1) {\n            if(l & 1) {\n           \
    \     lazy[l] = ap(lazy[l], x);\n                l++;\n            }\n       \
    \     if(r & 1) {\n                r--;\n                lazy[r] = ap(lazy[r],\
    \ x);\n            }\n        }\n    }\n    constexpr inline T operator[](int\
    \ k) noexcept {\n        thrust(k += sz);\n        return lazy[k];\n    }\n};\n\
    }\n\n/**\n * @brief \u53CC\u5BFE\u30BB\u30B0\u6728\n * @see https://ei1333.github.io/library/structure/segment-tree/dual-segment-tree.hpp\n\
    \ */\n"
  code: "#pragma once\n\n#pragma GCC diagnostic ignored \"-Wreorder\"\n\n#include\
    \ <vector>\n#include <functional>\nnamespace man {\ntemplate <class T> struct\
    \ DualSegTree {\nprivate:\n    using F = std::function<T(T, T)>;\n    int sz,\
    \ h;\n    std::vector<T> lazy;\n    const T id;\n    const F ap;\n    constexpr\
    \ inline void propagate(const int k) noexcept {\n        if(lazy[k] != id) {\n\
    \            lazy[2 * k] = ap(lazy[2 * k], lazy[k]);\n            lazy[2 * k +\
    \ 1] = ap(lazy[2 * k + 1], lazy[k]);\n            lazy[k] = id;\n        }\n \
    \   }\n    constexpr inline void thrust(const int k) noexcept {\n        for(int\
    \ i = h; i > 0; i--) {\n            propagate(k >> i);\n        }\n    }\npublic:\n\
    \    DualSegTree(const int n, const F &ap, const T &id): ap(ap), id(id) {\n  \
    \      sz = 1;\n        h = 0;\n        while(sz < n) {\n            sz <<= 1;\n\
    \            h++;\n        }\n        lazy.assign(2 * sz, id);\n    }\n    constexpr\
    \ inline void apply(int a, int b, const T &x) noexcept {\n        thrust(a +=\
    \ sz);\n        thrust(b += sz - 1);\n        for(int l = a, r = b + 1; l < r;\
    \ l >>= 1, r >>= 1) {\n            if(l & 1) {\n                lazy[l] = ap(lazy[l],\
    \ x);\n                l++;\n            }\n            if(r & 1) {\n        \
    \        r--;\n                lazy[r] = ap(lazy[r], x);\n            }\n    \
    \    }\n    }\n    constexpr inline T operator[](int k) noexcept {\n        thrust(k\
    \ += sz);\n        return lazy[k];\n    }\n};\n}\n\n/**\n * @brief \u53CC\u5BFE\
    \u30BB\u30B0\u6728\n * @see https://ei1333.github.io/library/structure/segment-tree/dual-segment-tree.hpp\n\
    \ */"
  dependsOn: []
  isVerificationFile: false
  path: C++/ds/DualSegmentTree.hpp
  requiredBy: []
  timestamp: '2025-06-06 22:43:06+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/dualsegtree.test.cpp
documentation_of: C++/ds/DualSegmentTree.hpp
layout: document
redirect_from:
- /library/C++/ds/DualSegmentTree.hpp
- /library/C++/ds/DualSegmentTree.hpp.html
title: "\u53CC\u5BFE\u30BB\u30B0\u6728"
---
