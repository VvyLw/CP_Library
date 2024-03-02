---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/ds/DualSegmentTree.hpp
    title: "\u53CC\u5BFE\u30BB\u30B0\u6728"
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/2/DSL_2_D
    links:
    - https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/2/DSL_2_D
  bundledCode: "#line 1 \"test/C++/dualsegtree.test.cpp\"\n#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/2/DSL_2_D\"\
    \n#include <iostream>\n#line 2 \"C++/ds/DualSegmentTree.hpp\"\n\n#pragma GCC diagnostic\
    \ ignored \"-Wreorder\"\n\n#include <vector>\n#include <functional>\ntemplate\
    \ <class T> struct DualSegTree {\nprivate:\n    using F = std::function<T(T, T)>;\n\
    \    int sz, h;\n    std::vector<T> lazy;\n    const T id;\n    const F ap;\n\
    \    inline void propagate(const int k) {\n        if(lazy[k] != id) {\n     \
    \       lazy[2 * k] = ap(lazy[2 * k], lazy[k]);\n            lazy[2 * k + 1] =\
    \ ap(lazy[2 * k + 1], lazy[k]);\n            lazy[k] = id;\n        }\n    }\n\
    \    inline void thrust(const int k) {\n        for(int i = h; i > 0; i--) {\n\
    \            propagate(k >> i);\n        }\n    }\npublic:\n    DualSegTree(const\
    \ int n, const F &ap, const T &id): ap(ap), id(id) {\n        sz = 1;\n      \
    \  h = 0;\n        while(sz < n) {\n            sz <<= 1;\n            h++;\n\
    \        }\n        lazy.assign(2 * sz, id);\n    }\n    void apply(int a, int\
    \ b, const T &x) {\n        thrust(a += sz);\n        thrust(b += sz - 1);\n \
    \       for(int l = a, r = b + 1; l < r; l >>= 1, r >>= 1) {\n            if(l\
    \ & 1) {\n                lazy[l] = ap(lazy[l], x);\n                l++;\n  \
    \          }\n            if(r & 1) {\n                r--;\n                lazy[r]\
    \ = ap(lazy[r], x);\n            }\n        }\n    }\n    inline T operator[](int\
    \ k) {\n        thrust(k += sz);\n        return lazy[k];\n    }\n};\n\n/**\n\
    \ * @brief \u53CC\u5BFE\u30BB\u30B0\u6728\n * @see https://ei1333.github.io/library/structure/segment-tree/dual-segment-tree.hpp\n\
    \ */\n#line 4 \"test/C++/dualsegtree.test.cpp\"\nint main() {\n    int n, q;\n\
    \    std::cin >> n >> q;\n    DualSegTree<int> seg(n, [](const int a, const int\
    \ b) -> int { return b; }, INT32_MAX);\n    while(q--) {\n        int h;\n   \
    \     std::cin >> h;\n        if(h == 0) {\n            int s, t, x;\n       \
    \     std::cin >> s >> t >> x;\n            seg.apply(s, ++t, x);\n        } else\
    \ {\n            int i;\n            std::cin >> i;\n            std::cout <<\
    \ seg[i] << '\\n';\n        }\n    }\n}\n"
  code: "#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/2/DSL_2_D\"\
    \n#include <iostream>\n#include \"C++/ds/DualSegmentTree.hpp\"\nint main() {\n\
    \    int n, q;\n    std::cin >> n >> q;\n    DualSegTree<int> seg(n, [](const\
    \ int a, const int b) -> int { return b; }, INT32_MAX);\n    while(q--) {\n  \
    \      int h;\n        std::cin >> h;\n        if(h == 0) {\n            int s,\
    \ t, x;\n            std::cin >> s >> t >> x;\n            seg.apply(s, ++t, x);\n\
    \        } else {\n            int i;\n            std::cin >> i;\n          \
    \  std::cout << seg[i] << '\\n';\n        }\n    }\n}"
  dependsOn:
  - C++/ds/DualSegmentTree.hpp
  isVerificationFile: true
  path: test/C++/dualsegtree.test.cpp
  requiredBy: []
  timestamp: '2024-03-03 06:22:53+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/C++/dualsegtree.test.cpp
layout: document
redirect_from:
- /verify/test/C++/dualsegtree.test.cpp
- /verify/test/C++/dualsegtree.test.cpp.html
title: test/C++/dualsegtree.test.cpp
---
