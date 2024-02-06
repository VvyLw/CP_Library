---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/ftree.test.cpp
    title: test/ftree.test.cpp
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
    - https://github.com/NyaanNyaan/library/blob/master/data-structure/binary-indexed-tree.hpp
  bundledCode: "#line 2 \"C++/FenwickTree.hpp\"\n\r\n#include <vector>\r\ntemplate\
    \ <class T> struct FenwickTree {\r\nprivate:\r\n    int N;\r\n    std::vector<T>\
    \ data;\r\n    void init(const size_t size) {\r\n        N = size + 2;\r\n   \
    \     data.assign(N + 1, {});\r\n    }\r\npublic:\r\n    FenwickTree(){}\r\n \
    \   FenwickTree(size_t size){ init(size); }\r\n    FenwickTree(const std::vector<T>\
    \ &a) {\r\n        init(a.size());\r\n        for(size_t i = 0; i < a.size();\
    \ ++i) {\r\n            add(i, a[i]);\r\n        }\r\n    }\r\n    // get sum\
    \ of [0,k]\r\n    T sum(int k) const {\r\n        if(k < 0) return T{};  // return\
    \ 0 if k < 0\r\n        T ret{};\r\n        for(++k; k > 0; k -= k & -k) ret +=\
    \ data[k];\r\n        return ret;\r\n    }\r\n    // getsum of [l,r]\r\n    inline\
    \ T sum(int l, int r) const { return sum(r) - sum(l - 1); }\r\n    // get value\
    \ of k\r\n    inline T operator[](int k) const { return sum(k) - sum(k - 1); }\r\
    \n    // data[k] += x\r\n    void add(int k, T x) {\r\n        for(++k; k < N;\
    \ k += k & -k) data[k] += x;\r\n    }\r\n    // range add x to [l,r]\r\n    void\
    \ imos(int l, int r, T x) {\r\n        add(l, x);\r\n        add(r + 1, -x);\r\
    \n    }\r\n    // minimize i s.t. sum(i) >= w\r\n    int lower_bound(T w) {\r\n\
    \        if(w <= 0) return 0;\r\n        int x = 0;\r\n        for(int k = 1 <<\
    \ std::__lg(N); k; k >>= 1) {\r\n            if(x + k <= N - 1 && data[x + k]\
    \ < w) {\r\n                w -= data[x + k];\r\n                x += k;\r\n \
    \           }\r\n        }\r\n        return x;\r\n    }\r\n    // minimize i\
    \ s.t. sum(i) > w\r\n    int upper_bound(T w) {\r\n        if(w < 0) return 0;\r\
    \n        int x = 0;\r\n        for(int k = 1 << std::__lg(N); k; k >>= 1) {\r\
    \n            if(x + k <= N - 1 && data[x + k] <= w) {\r\n                w -=\
    \ data[x + k];\r\n                x += k;\r\n            }\r\n        }\r\n  \
    \      return x;\r\n    }\r\n};\r\n\r\n#include <algorithm>\r\ntemplate <class\
    \ T> inline long long inv_num(const std::vector<T> &a) {\r\n    std::vector<std::pair<T,\
    \ int>> p(a.size());\r\n    for(size_t i = 0; i < a.size(); ++i) {\r\n       \
    \ p[i] = {a[i], i};\r\n    }\r\n    std::sort(p.begin(), p.end());\r\n    std::vector<int>\
    \ id(a.size());\r\n    for(int i = 0; i < a.size(); ++i) {\r\n        id[p[i].second]\
    \ = i;\r\n    }\r\n    FenwickTree<T> bit(a.size());\r\n    long long res = 0;\r\
    \n    for(size_t i = 0; i < a.size(); ++i) {\r\n        res += i - bit.sum(id[i]);\r\
    \n        bit.add(id[i], 1);\r\n    }\r\n    return res;\r\n}\r\n/**\r\n * @brief\
    \ Binary Indexed Tree\r\n * @see https://github.com/NyaanNyaan/library/blob/master/data-structure/binary-indexed-tree.hpp\r\
    \n */\n"
  code: "#pragma once\r\n\r\n#include <vector>\r\ntemplate <class T> struct FenwickTree\
    \ {\r\nprivate:\r\n    int N;\r\n    std::vector<T> data;\r\n    void init(const\
    \ size_t size) {\r\n        N = size + 2;\r\n        data.assign(N + 1, {});\r\
    \n    }\r\npublic:\r\n    FenwickTree(){}\r\n    FenwickTree(size_t size){ init(size);\
    \ }\r\n    FenwickTree(const std::vector<T> &a) {\r\n        init(a.size());\r\
    \n        for(size_t i = 0; i < a.size(); ++i) {\r\n            add(i, a[i]);\r\
    \n        }\r\n    }\r\n    // get sum of [0,k]\r\n    T sum(int k) const {\r\n\
    \        if(k < 0) return T{};  // return 0 if k < 0\r\n        T ret{};\r\n \
    \       for(++k; k > 0; k -= k & -k) ret += data[k];\r\n        return ret;\r\n\
    \    }\r\n    // getsum of [l,r]\r\n    inline T sum(int l, int r) const { return\
    \ sum(r) - sum(l - 1); }\r\n    // get value of k\r\n    inline T operator[](int\
    \ k) const { return sum(k) - sum(k - 1); }\r\n    // data[k] += x\r\n    void\
    \ add(int k, T x) {\r\n        for(++k; k < N; k += k & -k) data[k] += x;\r\n\
    \    }\r\n    // range add x to [l,r]\r\n    void imos(int l, int r, T x) {\r\n\
    \        add(l, x);\r\n        add(r + 1, -x);\r\n    }\r\n    // minimize i s.t.\
    \ sum(i) >= w\r\n    int lower_bound(T w) {\r\n        if(w <= 0) return 0;\r\n\
    \        int x = 0;\r\n        for(int k = 1 << std::__lg(N); k; k >>= 1) {\r\n\
    \            if(x + k <= N - 1 && data[x + k] < w) {\r\n                w -= data[x\
    \ + k];\r\n                x += k;\r\n            }\r\n        }\r\n        return\
    \ x;\r\n    }\r\n    // minimize i s.t. sum(i) > w\r\n    int upper_bound(T w)\
    \ {\r\n        if(w < 0) return 0;\r\n        int x = 0;\r\n        for(int k\
    \ = 1 << std::__lg(N); k; k >>= 1) {\r\n            if(x + k <= N - 1 && data[x\
    \ + k] <= w) {\r\n                w -= data[x + k];\r\n                x += k;\r\
    \n            }\r\n        }\r\n        return x;\r\n    }\r\n};\r\n\r\n#include\
    \ <algorithm>\r\ntemplate <class T> inline long long inv_num(const std::vector<T>\
    \ &a) {\r\n    std::vector<std::pair<T, int>> p(a.size());\r\n    for(size_t i\
    \ = 0; i < a.size(); ++i) {\r\n        p[i] = {a[i], i};\r\n    }\r\n    std::sort(p.begin(),\
    \ p.end());\r\n    std::vector<int> id(a.size());\r\n    for(int i = 0; i < a.size();\
    \ ++i) {\r\n        id[p[i].second] = i;\r\n    }\r\n    FenwickTree<T> bit(a.size());\r\
    \n    long long res = 0;\r\n    for(size_t i = 0; i < a.size(); ++i) {\r\n   \
    \     res += i - bit.sum(id[i]);\r\n        bit.add(id[i], 1);\r\n    }\r\n  \
    \  return res;\r\n}\r\n/**\r\n * @brief Binary Indexed Tree\r\n * @see https://github.com/NyaanNyaan/library/blob/master/data-structure/binary-indexed-tree.hpp\r\
    \n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/FenwickTree.hpp
  requiredBy: []
  timestamp: '2024-01-30 14:40:09+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/inv_num.test.cpp
  - test/ftree.test.cpp
  - test/parsum.test.cpp
documentation_of: C++/FenwickTree.hpp
layout: document
redirect_from:
- /library/C++/FenwickTree.hpp
- /library/C++/FenwickTree.hpp.html
title: Binary Indexed Tree
---
