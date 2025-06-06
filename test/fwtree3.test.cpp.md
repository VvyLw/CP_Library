---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/ds/fwtree/FenwickTree.hpp
    title: Binary Indexed Tree
  - icon: ':heavy_check_mark:'
    path: C++/ds/fwtree/RangeBIT.hpp
    title: Range BIT
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/2/DSL_2_G
    links:
    - https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/2/DSL_2_G
  bundledCode: "#line 1 \"test/fwtree3.test.cpp\"\n#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/2/DSL_2_G\"\
    \n#include <iostream>\n#line 2 \"C++/ds/fwtree/RangeBIT.hpp\"\n\n#line 2 \"C++/ds/fwtree/FenwickTree.hpp\"\
    \n\r\n#include <vector>\r\n#include <ranges>\r\nnamespace man {\r\ntemplate <class\
    \ T> struct FenwickTree {\r\nprivate:\r\n    int n;\r\n    std::vector<T> data;\r\
    \n    inline void init(const size_t size) noexcept {\r\n        n = size + 2;\r\
    \n        data.resize(n + 1);\r\n    }\r\npublic:\r\n    FenwickTree(){}\r\n \
    \   FenwickTree(const size_t size){ init(size); }\r\n    FenwickTree(const std::vector<T>\
    \ &a) {\r\n        init(a.size());\r\n        for(const auto i: std::views::iota(0,\
    \ std::ssize(a))) {\r\n            add(i, a[i]);\r\n        }\r\n    }\r\n   \
    \ constexpr inline T sum(int k) const noexcept {\r\n        if(k < 0) {\r\n  \
    \          return 0;\r\n        }\r\n        T ret = 0;\r\n        for(++k; k\
    \ > 0; k -= k & -k) {\r\n            ret += data[k];\r\n        }\r\n        return\
    \ ret;\r\n    }\r\n    constexpr inline T sum(int l, int r) const noexcept { return\
    \ sum(r) - sum(l - 1); }\r\n    constexpr inline T operator[](int k) const noexcept\
    \ { return sum(k) - sum(k - 1); }\r\n    constexpr inline void add(int k, const\
    \ T &x) noexcept {\r\n        for(++k; k < n; k += k & -k) {\r\n            data[k]\
    \ += x;\r\n        }\r\n    }\r\n    constexpr inline void add(const int l, const\
    \ int r, const T& x) noexcept {\r\n        add(l, x);\r\n        add(r + 1, -x);\r\
    \n    }\r\n    constexpr inline int lower_bound(T w) noexcept {\r\n        if(w\
    \ <= 0) {\r\n            return 0;\r\n        }\r\n        int x = 0;\r\n    \
    \    for(int k = 1 << std::__lg(n); k > 0; k >>= 1) {\r\n            if(x + k\
    \ <= n - 1 && data[x + k] < w) {\r\n                w -= data[x + k];\r\n    \
    \            x += k;\r\n            }\r\n        }\r\n        return x;\r\n  \
    \  }\r\n    constexpr inline int upper_bound(T w) noexcept {\r\n        if(w <\
    \ 0) {\r\n            return 0;\r\n        }\r\n        int x = 0;\r\n       \
    \ for(int k = 1 << std::__lg(n); k > 0; k >>= 1) {\r\n            if(x + k <=\
    \ n - 1 && data[x + k] <= w) {\r\n                w -= data[x + k];\r\n      \
    \          x += k;\r\n            }\r\n        }\r\n        return x;\r\n    }\r\
    \n};\r\n}\r\n\r\n/**\r\n * @brief Binary Indexed Tree\r\n * @see https://nyaannyaan.github.io/library/data-structure/binary-indexed-tree.hpp\r\
    \n */\n#line 4 \"C++/ds/fwtree/RangeBIT.hpp\"\nnamespace man {\ntemplate <class\
    \ T> struct RangeBIT {\nprivate:\n    FenwickTree<T> a, b;\npublic:\n    RangeBIT(const\
    \ int n): a(n + 1), b(n + 1){}\n    RangeBIT(const std::vector<T> &v) {\n    \
    \    this(v.size());\n        for(size_t i = 0; i < v.size(); ++i) {\n       \
    \     add(i, i + 1, v[i]);\n        }\n    }\n    constexpr inline void add(const\
    \ int l, const int r, const T &x) noexcept {\n        a.add(l, x);\n        a.add(r,\
    \ -x);\n        b.add(l, x * (1 - l));\n        b.add(r, x * (r - 1));\n    }\n\
    \    constexpr inline T operator[](const int i) const noexcept { return sum(i,\
    \ i + 1); }\n    constexpr inline T sum(int l, int r) noexcept {\n        l--,\
    \ r--;\n        return a.sum(r) * r + b.sum(r) - a.sum(l) * l - b.sum(l);\n  \
    \  }\n};\n}\n\n/**\n * @brief Range BIT\n */\n#line 4 \"test/fwtree3.test.cpp\"\
    \nint main() {\n    int n, q;\n    std::cin >> n >> q;\n    man::RangeBIT<int64_t>\
    \ bit(n);\n    while(q--) {\n        int h, s, t;\n        std::cin >> h >> s\
    \ >> t;\n        s--;\n        if(h == 0) {\n            int x;\n            std::cin\
    \ >> x;\n            bit.add(s, t, x);\n        } else {\n            std::cout\
    \ << bit.sum(s, t) << '\\n';\n        }\n    }\n}\n"
  code: "#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/2/DSL_2_G\"\
    \n#include <iostream>\n#include \"C++/ds/fwtree/RangeBIT.hpp\"\nint main() {\n\
    \    int n, q;\n    std::cin >> n >> q;\n    man::RangeBIT<int64_t> bit(n);\n\
    \    while(q--) {\n        int h, s, t;\n        std::cin >> h >> s >> t;\n  \
    \      s--;\n        if(h == 0) {\n            int x;\n            std::cin >>\
    \ x;\n            bit.add(s, t, x);\n        } else {\n            std::cout <<\
    \ bit.sum(s, t) << '\\n';\n        }\n    }\n}"
  dependsOn:
  - C++/ds/fwtree/RangeBIT.hpp
  - C++/ds/fwtree/FenwickTree.hpp
  isVerificationFile: true
  path: test/fwtree3.test.cpp
  requiredBy: []
  timestamp: '2025-06-06 22:43:22+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/fwtree3.test.cpp
layout: document
redirect_from:
- /verify/test/fwtree3.test.cpp
- /verify/test/fwtree3.test.cpp.html
title: test/fwtree3.test.cpp
---
