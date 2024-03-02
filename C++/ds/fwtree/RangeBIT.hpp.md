---
data:
  _extendedDependsOn:
  - icon: ':x:'
    path: C++/ds/fwtree/FenwickTree.hpp
    title: Binary Indexed Tree
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':x:'
    path: test/fwtree3.test.cpp
    title: test/fwtree3.test.cpp
  _isVerificationFailed: true
  _pathExtension: hpp
  _verificationStatusIcon: ':x:'
  attributes:
    document_title: Range BIT
    links: []
  bundledCode: "#line 2 \"C++/ds/fwtree/RangeBIT.hpp\"\n\n#line 2 \"C++/ds/fwtree/FenwickTree.hpp\"\
    \n\r\n#include <vector>\r\ntemplate <class T> struct FenwickTree {\r\nprivate:\r\
    \n    int n;\r\n    std::vector<T> data;\r\n    void init(const size_t size) {\r\
    \n        n = size + 2;\r\n        data.resize(n + 1);\r\n    }\r\npublic:\r\n\
    \    FenwickTree(){}\r\n    FenwickTree(const size_t size){ init(size); }\r\n\
    \    FenwickTree(const std::vector<T> &a) {\r\n        init(a.size());\r\n   \
    \     for(size_t i = 0; i < a.size(); ++i) {\r\n            add(i, a[i]);\r\n\
    \        }\r\n    }\r\n    T sum(int k) const {\r\n        if(k < 0) {\r\n   \
    \         return 0;\r\n        }\r\n        T ret = 0;\r\n        for(++k; k >\
    \ 0; k -= k & -k) {\r\n            ret += data[k];\r\n        }\r\n        return\
    \ ret;\r\n    }\r\n    inline T sum(int l, int r) const { return sum(r) - sum(l\
    \ - 1); }\r\n    inline T operator[](int k) const { return sum(k) - sum(k - 1);\
    \ }\r\n    void add(int k, const T &x) {\r\n        for(++k; k < n; k += k & -k)\
    \ {\r\n            data[k] += x;\r\n        }\r\n    }\r\n    void add(const int\
    \ l, const int r, const T& x) {\r\n        add(l, x);\r\n        add(r + 1, -x);\r\
    \n    }\r\n    int lower_bound(T w) {\r\n        if(w <= 0) {\r\n            return\
    \ 0;\r\n        }\r\n        int x = 0;\r\n        for(int k = 1 << std::__lg(n);\
    \ k; k >>= 1) {\r\n            if(x + k <= n - 1 && data[x + k] < w) {\r\n   \
    \             w -= data[x + k];\r\n                x += k;\r\n            }\r\n\
    \        }\r\n        return x;\r\n    }\r\n    int upper_bound(T w) {\r\n   \
    \     if(w < 0) {\r\n            return 0;\r\n        }\r\n        int x = 0;\r\
    \n        for(int k = 1 << std::__lg(n); k; k >>= 1) {\r\n            if(x + k\
    \ <= n - 1 && data[x + k] <= w) {\r\n                w -= data[x + k];\r\n   \
    \             x += k;\r\n            }\r\n        }\r\n        return x;\r\n \
    \   }\r\n};\r\n\r\n/**\r\n * @brief Binary Indexed Tree\r\n * @see https://nyaannyaan.github.io/library/data-structure/binary-indexed-tree.hpp\r\
    \n */\n#line 4 \"C++/ds/fwtree/RangeBIT.hpp\"\ntemplate <class T> struct RangeBIT\
    \ {\nprivate:\n    FenwickTree<T> a, b;\npublic:\n    RangeBIT(const int n): a(n\
    \ + 1), b(n + 1){}\n    RangeBIT(const std::vector<T> &v) {\n        this(v.size());\n\
    \        for(size_t i = 0; i < v.size(); ++i) {\n            add(i, i + 1, v[i]);\n\
    \        }\n    }\n    void add(const int l, const int r, const T &x) {\n    \
    \    a.add(l, x);\n        a.add(r, -x);\n        b.add(l, x * (1 - l));\n   \
    \     b.add(r, x * (r - 1));\n    }\n    inline T operator[](const int i) const\
    \ { return sum(i, i + 1); }\n    inline T sum(int l, int r) {\n        l--, r--;\n\
    \        return a.sum(r) * r + b.sum(r) - a.sum(l) * l - b.sum(l);\n    }\n};\n\
    \n/**\n * @brief Range BIT\n */\n"
  code: "#pragma once\n\n#include \"C++/ds/fwtree/FenwickTree.hpp\"\ntemplate <class\
    \ T> struct RangeBIT {\nprivate:\n    FenwickTree<T> a, b;\npublic:\n    RangeBIT(const\
    \ int n): a(n + 1), b(n + 1){}\n    RangeBIT(const std::vector<T> &v) {\n    \
    \    this(v.size());\n        for(size_t i = 0; i < v.size(); ++i) {\n       \
    \     add(i, i + 1, v[i]);\n        }\n    }\n    void add(const int l, const\
    \ int r, const T &x) {\n        a.add(l, x);\n        a.add(r, -x);\n        b.add(l,\
    \ x * (1 - l));\n        b.add(r, x * (r - 1));\n    }\n    inline T operator[](const\
    \ int i) const { return sum(i, i + 1); }\n    inline T sum(int l, int r) {\n \
    \       l--, r--;\n        return a.sum(r) * r + b.sum(r) - a.sum(l) * l - b.sum(l);\n\
    \    }\n};\n\n/**\n * @brief Range BIT\n */"
  dependsOn:
  - C++/ds/fwtree/FenwickTree.hpp
  isVerificationFile: false
  path: C++/ds/fwtree/RangeBIT.hpp
  requiredBy: []
  timestamp: '2024-02-27 11:03:02+09:00'
  verificationStatus: LIBRARY_ALL_WA
  verifiedWith:
  - test/fwtree3.test.cpp
documentation_of: C++/ds/fwtree/RangeBIT.hpp
layout: document
redirect_from:
- /library/C++/ds/fwtree/RangeBIT.hpp
- /library/C++/ds/fwtree/RangeBIT.hpp.html
title: Range BIT
---
