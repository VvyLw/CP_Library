---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/ftree.test.cpp
    title: test/ftree.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/parsum.test.cpp
    title: test/parsum.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    links:
    - https://github.com/NyaanNyaan/library/blob/master/data-structure/binary-indexed-tree.hpp
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 312, in update\n    raise BundleErrorAt(path, i + 1, \"#pragma once found\
    \ in a non-first line\")\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt:\
    \ C++/FenwickTree.hpp: line 2: #pragma once found in a non-first line\n"
  code: "// inspired by Nyaan( https://github.com/NyaanNyaan/library/blob/master/data-structure/binary-indexed-tree.hpp\
    \ )\r\n#pragma once\r\n\r\n#include <vector>\r\ntemplate <class T> struct FenwickTree\
    \ {\r\nprivate:\r\n    int N;\r\n    std::vector<T> data;\r\npublic:\r\n    FenwickTree(){}\r\
    \n    FenwickTree(int size){ init(size); }\r\n    void init(int size) {\r\n  \
    \      N = size + 2;\r\n        data.assign(N + 1, {});\r\n    }\r\n    // get\
    \ sum of [0,k]\r\n    T sum(int k) const {\r\n        if(k < 0) return T{};  //\
    \ return 0 if k < 0\r\n        T ret{};\r\n        for(++k; k > 0; k -= k & -k)\
    \ ret += data[k];\r\n        return ret;\r\n    }\r\n    // getsum of [l,r]\r\n\
    \    inline T sum(int l, int r) const { return sum(r) - sum(l - 1); }\r\n    //\
    \ get value of k\r\n    inline T operator[](int k) const { return sum(k) - sum(k\
    \ - 1); }\r\n    // data[k] += x\r\n    void add(int k, T x) {\r\n        for(++k;\
    \ k < N; k += k & -k) data[k] += x;\r\n    }\r\n    // range add x to [l,r]\r\n\
    \    void imos(int l, int r, T x) {\r\n        add(l, x);\r\n        add(r + 1,\
    \ -x);\r\n    }\r\n    // minimize i s.t. sum(i) >= w\r\n    int lower_bound(T\
    \ w) {\r\n        if(w <= 0) return 0;\r\n        int x = 0;\r\n        for(int\
    \ k = 1 << std::__lg(N); k; k >>= 1) {\r\n            if(x + k <= N - 1 && data[x\
    \ + k] < w) {\r\n                w -= data[x + k];\r\n                x += k;\r\
    \n            }\r\n        }\r\n        return x;\r\n    }\r\n    // minimize\
    \ i s.t. sum(i) > w\r\n    int upper_bound(T w) {\r\n        if(w < 0) return\
    \ 0;\r\n        int x = 0;\r\n        for(int k = 1 << std::__lg(N); k; k >>=\
    \ 1) {\r\n            if(x + k <= N - 1 && data[x + k] <= w) {\r\n           \
    \     w -= data[x + k];\r\n                x += k;\r\n            }\r\n      \
    \  }\r\n        return x;\r\n    }\r\n};\r\n\r\ntemplate <class T> inline int\
    \ inv_num(const std::vector<T> &a) {\r\n    FenwickTree<T> bit(a.size());\r\n\
    \    int res = 0;\r\n    for(size_t i = 0; i < a.size(); ++i) {\r\n        res\
    \ += i - bit.sum(a[i]);\r\n        bit.add(a[i], 1);\r\n    }\r\n    return res;\r\
    \n}"
  dependsOn: []
  isVerificationFile: false
  path: C++/FenwickTree.hpp
  requiredBy: []
  timestamp: '2023-12-10 23:52:59+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/ftree.test.cpp
  - test/parsum.test.cpp
documentation_of: C++/FenwickTree.hpp
layout: document
redirect_from:
- /library/C++/FenwickTree.hpp
- /library/C++/FenwickTree.hpp.html
title: C++/FenwickTree.hpp
---
