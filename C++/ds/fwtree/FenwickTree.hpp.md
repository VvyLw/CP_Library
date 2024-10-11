---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
  - icon: ':heavy_check_mark:'
    path: C++/ds/fwtree/RangeBIT.hpp
    title: Range BIT
  - icon: ':heavy_check_mark:'
    path: C++/math/inverse_num.hpp
    title: "\u8EE2\u5012\u6570"
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/fwtree.test.cpp
    title: test/fwtree.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/fwtree2.test.cpp
    title: test/fwtree2.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/fwtree3.test.cpp
    title: test/fwtree3.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/inv_num.test.cpp
    title: test/inv_num.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/parsum.test.cpp
    title: test/parsum.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: Binary Indexed Tree
    links:
    - https://nyaannyaan.github.io/library/data-structure/binary-indexed-tree.hpp
  bundledCode: "#line 2 \"C++/ds/fwtree/FenwickTree.hpp\"\n\r\n#include <vector>\r\
    \ntemplate <class T> struct FenwickTree {\r\nprivate:\r\n    int n;\r\n    std::vector<T>\
    \ data;\r\n    void init(const size_t size) {\r\n        n = size + 2;\r\n   \
    \     data.resize(n + 1);\r\n    }\r\npublic:\r\n    FenwickTree(){}\r\n    FenwickTree(const\
    \ size_t size){ init(size); }\r\n    FenwickTree(const std::vector<T> &a) {\r\n\
    \        init(a.size());\r\n        for(size_t i = 0; i < a.size(); ++i) {\r\n\
    \            add(i, a[i]);\r\n        }\r\n    }\r\n    T sum(int k) const {\r\
    \n        if(k < 0) {\r\n            return 0;\r\n        }\r\n        T ret =\
    \ 0;\r\n        for(++k; k > 0; k -= k & -k) {\r\n            ret += data[k];\r\
    \n        }\r\n        return ret;\r\n    }\r\n    inline T sum(int l, int r)\
    \ const { return sum(r) - sum(l - 1); }\r\n    inline T operator[](int k) const\
    \ { return sum(k) - sum(k - 1); }\r\n    void add(int k, const T &x) {\r\n   \
    \     for(++k; k < n; k += k & -k) {\r\n            data[k] += x;\r\n        }\r\
    \n    }\r\n    void add(const int l, const int r, const T& x) {\r\n        add(l,\
    \ x);\r\n        add(r + 1, -x);\r\n    }\r\n    int lower_bound(T w) {\r\n  \
    \      if(w <= 0) {\r\n            return 0;\r\n        }\r\n        int x = 0;\r\
    \n        for(int k = 1 << std::__lg(n); k; k >>= 1) {\r\n            if(x + k\
    \ <= n - 1 && data[x + k] < w) {\r\n                w -= data[x + k];\r\n    \
    \            x += k;\r\n            }\r\n        }\r\n        return x;\r\n  \
    \  }\r\n    int upper_bound(T w) {\r\n        if(w < 0) {\r\n            return\
    \ 0;\r\n        }\r\n        int x = 0;\r\n        for(int k = 1 << std::__lg(n);\
    \ k; k >>= 1) {\r\n            if(x + k <= n - 1 && data[x + k] <= w) {\r\n  \
    \              w -= data[x + k];\r\n                x += k;\r\n            }\r\
    \n        }\r\n        return x;\r\n    }\r\n};\r\n\r\n/**\r\n * @brief Binary\
    \ Indexed Tree\r\n * @see https://nyaannyaan.github.io/library/data-structure/binary-indexed-tree.hpp\r\
    \n */\n"
  code: "#pragma once\r\n\r\n#include <vector>\r\ntemplate <class T> struct FenwickTree\
    \ {\r\nprivate:\r\n    int n;\r\n    std::vector<T> data;\r\n    void init(const\
    \ size_t size) {\r\n        n = size + 2;\r\n        data.resize(n + 1);\r\n \
    \   }\r\npublic:\r\n    FenwickTree(){}\r\n    FenwickTree(const size_t size){\
    \ init(size); }\r\n    FenwickTree(const std::vector<T> &a) {\r\n        init(a.size());\r\
    \n        for(size_t i = 0; i < a.size(); ++i) {\r\n            add(i, a[i]);\r\
    \n        }\r\n    }\r\n    T sum(int k) const {\r\n        if(k < 0) {\r\n  \
    \          return 0;\r\n        }\r\n        T ret = 0;\r\n        for(++k; k\
    \ > 0; k -= k & -k) {\r\n            ret += data[k];\r\n        }\r\n        return\
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
    \n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/ds/fwtree/FenwickTree.hpp
  requiredBy:
  - C++/math/inverse_num.hpp
  - C++/ds/fwtree/RangeBIT.hpp
  timestamp: '2024-02-27 10:38:23+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/inv_num.test.cpp
  - test/parsum.test.cpp
  - test/fwtree2.test.cpp
  - test/fwtree3.test.cpp
  - test/fwtree.test.cpp
documentation_of: C++/ds/fwtree/FenwickTree.hpp
layout: document
redirect_from:
- /library/C++/ds/fwtree/FenwickTree.hpp
- /library/C++/ds/fwtree/FenwickTree.hpp.html
title: Binary Indexed Tree
---
