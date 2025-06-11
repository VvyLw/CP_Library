---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/ds/fwtree/FenwickTree.hpp
    title: Binary Indexed Tree
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/fwtree3.test.cpp
    title: test/fwtree3.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: Range BIT
    links: []
  bundledCode: "#line 2 \"C++/ds/fwtree/RangeBIT.hpp\"\n\n#line 2 \"C++/ds/fwtree/FenwickTree.hpp\"\
    \n\r\n#include <vector>\r\n#include <ranges>\r\nnamespace man {\r\ntemplate <std::integral\
    \ T> struct FenwickTree {\r\nprivate:\r\n    int n;\r\n    std::vector<T> data;\r\
    \n    inline void init(const size_t size) noexcept {\r\n        n = size + 2;\r\
    \n        data.resize(n + 1);\r\n    }\r\npublic:\r\n    FenwickTree(){}\r\n \
    \   FenwickTree(const size_t size){ init(size); }\r\n    FenwickTree(const std::vector<T>\
    \ &a) {\r\n        init(std::ssize(a));\r\n        for(const auto i: std::views::iota(0,\
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
    \n */\n#line 4 \"C++/ds/fwtree/RangeBIT.hpp\"\nnamespace man {\ntemplate <std::integral\
    \ T> struct RangeBIT {\nprivate:\n    FenwickTree<T> a, b;\npublic:\n    RangeBIT(const\
    \ int n): a(n + 1), b(n + 1){}\n    RangeBIT(const std::vector<T> &v) {\n    \
    \    this(std::ssize(v));\n        for(const auto i: std::views::iota(0, std::ssize(v)))\
    \ {\n            add(i, i + 1, v[i]);\n        }\n    }\n    constexpr inline\
    \ void add(const int l, const int r, const T &x) noexcept {\n        a.add(l,\
    \ x);\n        a.add(r, -x);\n        b.add(l, x * (1 - l));\n        b.add(r,\
    \ x * (r - 1));\n    }\n    constexpr inline T operator[](const int i) const noexcept\
    \ { return sum(i, i + 1); }\n    constexpr inline T sum(int l, int r) noexcept\
    \ {\n        l--, r--;\n        return a.sum(r) * r + b.sum(r) - a.sum(l) * l\
    \ - b.sum(l);\n    }\n};\n}\n\n/**\n * @brief Range BIT\n */\n"
  code: "#pragma once\n\n#include \"C++/ds/fwtree/FenwickTree.hpp\"\nnamespace man\
    \ {\ntemplate <std::integral T> struct RangeBIT {\nprivate:\n    FenwickTree<T>\
    \ a, b;\npublic:\n    RangeBIT(const int n): a(n + 1), b(n + 1){}\n    RangeBIT(const\
    \ std::vector<T> &v) {\n        this(std::ssize(v));\n        for(const auto i:\
    \ std::views::iota(0, std::ssize(v))) {\n            add(i, i + 1, v[i]);\n  \
    \      }\n    }\n    constexpr inline void add(const int l, const int r, const\
    \ T &x) noexcept {\n        a.add(l, x);\n        a.add(r, -x);\n        b.add(l,\
    \ x * (1 - l));\n        b.add(r, x * (r - 1));\n    }\n    constexpr inline T\
    \ operator[](const int i) const noexcept { return sum(i, i + 1); }\n    constexpr\
    \ inline T sum(int l, int r) noexcept {\n        l--, r--;\n        return a.sum(r)\
    \ * r + b.sum(r) - a.sum(l) * l - b.sum(l);\n    }\n};\n}\n\n/**\n * @brief Range\
    \ BIT\n */"
  dependsOn:
  - C++/ds/fwtree/FenwickTree.hpp
  isVerificationFile: false
  path: C++/ds/fwtree/RangeBIT.hpp
  requiredBy: []
  timestamp: '2025-06-11 17:30:11+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/fwtree3.test.cpp
documentation_of: C++/ds/fwtree/RangeBIT.hpp
layout: document
redirect_from:
- /library/C++/ds/fwtree/RangeBIT.hpp
- /library/C++/ds/fwtree/RangeBIT.hpp.html
title: Range BIT
---
