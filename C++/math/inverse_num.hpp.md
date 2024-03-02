---
data:
  _extendedDependsOn:
  - icon: ':x:'
    path: C++/ds/fwtree/FenwickTree.hpp
    title: Binary Indexed Tree
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':x:'
    path: test/C++/inv_num.test.cpp
    title: test/C++/inv_num.test.cpp
  _isVerificationFailed: true
  _pathExtension: hpp
  _verificationStatusIcon: ':x:'
  attributes:
    document_title: "\u8EE2\u5012\u6570"
    links: []
  bundledCode: "#line 2 \"C++/math/inverse_num.hpp\"\n\n#include <algorithm>\n#line\
    \ 2 \"C++/ds/fwtree/FenwickTree.hpp\"\n\r\n#include <vector>\r\ntemplate <class\
    \ T> struct FenwickTree {\r\nprivate:\r\n    int n;\r\n    std::vector<T> data;\r\
    \n    void init(const size_t size) {\r\n        n = size + 2;\r\n        data.resize(n\
    \ + 1);\r\n    }\r\npublic:\r\n    FenwickTree(){}\r\n    FenwickTree(const size_t\
    \ size){ init(size); }\r\n    FenwickTree(const std::vector<T> &a) {\r\n     \
    \   init(a.size());\r\n        for(size_t i = 0; i < a.size(); ++i) {\r\n    \
    \        add(i, a[i]);\r\n        }\r\n    }\r\n    T sum(int k) const {\r\n \
    \       if(k < 0) {\r\n            return 0;\r\n        }\r\n        T ret = 0;\r\
    \n        for(++k; k > 0; k -= k & -k) {\r\n            ret += data[k];\r\n  \
    \      }\r\n        return ret;\r\n    }\r\n    inline T sum(int l, int r) const\
    \ { return sum(r) - sum(l - 1); }\r\n    inline T operator[](int k) const { return\
    \ sum(k) - sum(k - 1); }\r\n    void add(int k, const T &x) {\r\n        for(++k;\
    \ k < n; k += k & -k) {\r\n            data[k] += x;\r\n        }\r\n    }\r\n\
    \    void add(const int l, const int r, const T& x) {\r\n        add(l, x);\r\n\
    \        add(r + 1, -x);\r\n    }\r\n    int lower_bound(T w) {\r\n        if(w\
    \ <= 0) {\r\n            return 0;\r\n        }\r\n        int x = 0;\r\n    \
    \    for(int k = 1 << std::__lg(n); k; k >>= 1) {\r\n            if(x + k <= n\
    \ - 1 && data[x + k] < w) {\r\n                w -= data[x + k];\r\n         \
    \       x += k;\r\n            }\r\n        }\r\n        return x;\r\n    }\r\n\
    \    int upper_bound(T w) {\r\n        if(w < 0) {\r\n            return 0;\r\n\
    \        }\r\n        int x = 0;\r\n        for(int k = 1 << std::__lg(n); k;\
    \ k >>= 1) {\r\n            if(x + k <= n - 1 && data[x + k] <= w) {\r\n     \
    \           w -= data[x + k];\r\n                x += k;\r\n            }\r\n\
    \        }\r\n        return x;\r\n    }\r\n};\r\n\r\n/**\r\n * @brief Binary\
    \ Indexed Tree\r\n * @see https://nyaannyaan.github.io/library/data-structure/binary-indexed-tree.hpp\r\
    \n */\n#line 5 \"C++/math/inverse_num.hpp\"\ntemplate <class T> inline long long\
    \ inv_num(const std::vector<T> &a) {\n    std::vector<std::pair<T, int>> p(a.size());\n\
    \    for(size_t i = 0; i < a.size(); ++i) {\n        p[i] = {a[i], i};\n    }\n\
    \    std::sort(p.begin(), p.end());\n    std::vector<int> id(a.size());\n    for(size_t\
    \ i = 0; i < a.size(); ++i) {\n        id[p[i].second] = i;\n    }\n    FenwickTree<T>\
    \ bit(a.size());\n    long long res = 0;\n    for(size_t i = 0; i < a.size();\
    \ ++i) {\n        res += i - bit.sum(id[i]);\n        bit.add(id[i], 1);\n   \
    \ }\n    return res;\n}\n\n/**\n * @brief \u8EE2\u5012\u6570\n */\n"
  code: "#pragma once\n\n#include <algorithm>\n#include \"C++/ds/fwtree/FenwickTree.hpp\"\
    \ntemplate <class T> inline long long inv_num(const std::vector<T> &a) {\n   \
    \ std::vector<std::pair<T, int>> p(a.size());\n    for(size_t i = 0; i < a.size();\
    \ ++i) {\n        p[i] = {a[i], i};\n    }\n    std::sort(p.begin(), p.end());\n\
    \    std::vector<int> id(a.size());\n    for(size_t i = 0; i < a.size(); ++i)\
    \ {\n        id[p[i].second] = i;\n    }\n    FenwickTree<T> bit(a.size());\n\
    \    long long res = 0;\n    for(size_t i = 0; i < a.size(); ++i) {\n        res\
    \ += i - bit.sum(id[i]);\n        bit.add(id[i], 1);\n    }\n    return res;\n\
    }\n\n/**\n * @brief \u8EE2\u5012\u6570\n */"
  dependsOn:
  - C++/ds/fwtree/FenwickTree.hpp
  isVerificationFile: false
  path: C++/math/inverse_num.hpp
  requiredBy: []
  timestamp: '2024-02-27 11:03:02+09:00'
  verificationStatus: LIBRARY_ALL_WA
  verifiedWith:
  - test/C++/inv_num.test.cpp
documentation_of: C++/math/inverse_num.hpp
layout: document
redirect_from:
- /library/C++/math/inverse_num.hpp
- /library/C++/math/inverse_num.hpp.html
title: "\u8EE2\u5012\u6570"
---
