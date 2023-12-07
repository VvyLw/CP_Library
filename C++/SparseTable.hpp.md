---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/s_rmq.test.cpp
    title: test/s_rmq.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/stable.test.cpp
    title: test/stable.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    links:
    - https://ei1333.github.io/luzhiled/snippets/structure/sparse-table.html
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 312, in update\n    raise BundleErrorAt(path, i + 1, \"#pragma once found\
    \ in a non-first line\")\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt:\
    \ C++/SparseTable.hpp: line 2: #pragma once found in a non-first line\n"
  code: "// inspired by Luzhiled( https://ei1333.github.io/luzhiled/snippets/structure/sparse-table.html\
    \ )\r\n#pragma once\r\n\r\n#include <vector>\r\n#include <functional>\r\ntemplate\
    \ <class T> struct SparseTable {\r\nprivate:\r\n    using F = std::function<T(T,T)>;\r\
    \n    std::vector<std::vector<T>> st;\r\n    std::vector<T> lookup;\r\n    F f;\r\
    \npublic:\r\n    SparseTable(const std::vector<T> &v, const F &f_) : f(f_) {\r\
    \n        int b = 0;\r\n        while((1 << b) <= v.size()) ++b;\r\n        st.assign(b,\
    \ std::vector<T>(1 << b));\r\n        for(size_t i = 0; i < v.size(); i++) {\r\
    \n            st[0][i] = v[i];\r\n        }\r\n        for(int i = 1; i < b; i++)\
    \ {\r\n            for(int j = 0; j + (1 << i) <= (1 << b); j++) {\r\n       \
    \         st[i][j] = f(st[i - 1][j], st[i - 1][j + (1 << (i - 1))]);\r\n     \
    \       }\r\n        }\r\n        lookup.resize(v.size() + 1);\r\n        for(int\
    \ i = 2; i < lookup.size(); i++) {\r\n            lookup[i] = lookup[i >> 1] +\
    \ 1;\r\n        }\r\n    }\r\n    inline T query(const T l, const T r) {\r\n \
    \       int b = lookup[r - l];\r\n        return f(st[b][l], st[b][r - (1 << b)]);\r\
    \n    }\r\n    template <class Boolean=bool> inline int min_left(const int x,\
    \ const Boolean &fn) {\r\n        if(!x) return 0;\r\n        int ok=x, ng=-1;\r\
    \n        while(abs(ok-ng)>1) {\r\n            int mid=(ok+ng)/2;\r\n        \
    \    (fn(query(mid,x)-1)?ok:ng)=mid;\r\n        }\r\n        return ok;\r\n  \
    \  }\r\n    template <class Boolean=bool> inline int max_right(const int x, const\
    \ Boolean &fn) {\r\n        if(x==lookup.size()-1) return lookup.size()-1;\r\n\
    \        int ok=x, ng=lookup.size();\r\n        while(abs(ok-ng)>1) {\r\n    \
    \        int mid=(ok+ng)/2;\r\n            (fn(query(x,mid))?ok:ng)=mid;\r\n \
    \       }\r\n        return ok;\r\n    }\r\n};\r\n"
  dependsOn: []
  isVerificationFile: false
  path: C++/SparseTable.hpp
  requiredBy: []
  timestamp: '2023-12-08 03:06:39+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/s_rmq.test.cpp
  - test/stable.test.cpp
documentation_of: C++/SparseTable.hpp
layout: document
redirect_from:
- /library/C++/SparseTable.hpp
- /library/C++/SparseTable.hpp.html
title: C++/SparseTable.hpp
---
