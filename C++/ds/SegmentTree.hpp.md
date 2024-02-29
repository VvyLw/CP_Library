---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/segtree.test.cpp
    title: test/segtree.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/segtree2.test.cpp
    title: test/segtree2.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: "\u30BB\u30B0\u30E1\u30F3\u30C8\u6728"
    links:
    - https://github.com/tatyam-prime/kyopro_library/blob/master/SegmentTree.cpp
  bundledCode: "#line 2 \"C++/ds/SegmentTree.hpp\"\n\r\n#pragma GCC diagnostic ignored\
    \ \"-Wreorder\"\r\n\r\n#include <vector>\r\n#include <functional>\r\ntemplate\
    \ <class T> struct SegTree {\r\nprivate:\r\n    using F = std::function<T(T, T)>;\r\
    \n    int n, rank, fine;\r\n    const F f;\r\n    const T e;\r\n    std::vector<T>\
    \ dat;\r\npublic:\r\n    SegTree(const int n_, const F f_, const T& e_): f(f_),\
    \ e(e_), fine(n_) {\r\n        n=1,rank=0;\r\n        while(fine>n) n<<=1LL,rank++;\r\
    \n        dat.assign(2*n,e_);\r\n    }\r\n    T operator[](int i) const { return\
    \ dat[i+n]; }\r\n    void update(int i, const T& x) {\r\n        i+=n;\r\n   \
    \     dat[i]=x;\r\n        while(i>>=1LL) dat[i]=f(dat[2*i],dat[2*i+1]);\r\n \
    \   }\r\n    void add(int i, const T& x) {\r\n        i+=n;\r\n        dat[i]+=x;\r\
    \n        while(i>>=1LL) dat[i]=f(dat[2*i],dat[2*i+1]);\r\n    }\r\n    T query(int\
    \ a, int b) const {\r\n        T l=e,r=e;\r\n        for(a+=n, b+=n; a<b; a>>=1LL,b>>=1LL)\
    \ {\r\n            if(a&1) l=f(l,dat[a++]);\r\n            if(b&1) r=f(dat[--b],r);\r\
    \n        }\r\n        return f(l,r);\r\n    }\r\n    T alle() const { return\
    \ dat[1]; }\r\n    template <class Boolean=bool> inline int find_left(int r, const\
    \ Boolean &fn) {\r\n        if(!r) return 0;\r\n        int h=0,i=r+n;\r\n   \
    \     T val=e;\r\n        for(; h <= rank; h++) if(i>>h&1){\r\n            T val2=f(val,dat[i>>h^1]);\r\
    \n            if(fn(val2)){\r\n                i -= 1<<h;\r\n                if(i==n)\
    \ return 0;\r\n                val=val2;\r\n            }\r\n            else\
    \ break;\r\n        }\r\n        for(; h--;){\r\n            T val2 = f(val,dat[(i>>h)-1]);\r\
    \n            if(fn(val2)){\r\n                i-=1<<h;\r\n                if(i==n)\
    \ return 0;\r\n                val=val2;\r\n            }\r\n        }\r\n   \
    \     return i-n;\r\n    }\r\n    template <class Boolean=bool> inline int find_right(int\
    \ l, const Boolean &fn) {\r\n        if(l==fine) return fine;\r\n        int h=0,i=l+n;\r\
    \n        T val=e;\r\n        for(; h<=rank; h++) if(i>>h&1){\r\n            T\
    \ val2=f(val,dat[i>>h]);\r\n            if(fn(val2)){\r\n                i+=1LL<<h;\r\
    \n                if(i==n*2) return fine;\r\n                val=val2;\r\n   \
    \         }\r\n            else break;\r\n        }\r\n        for(; h--;){\r\n\
    \            T val2=f(val, dat[i>>h]);\r\n            if(fn(val2)){\r\n      \
    \          i+=1LL<<h;\r\n                if(i==n*2) return fine;\r\n         \
    \       val=val2;\r\n            }\r\n        }\r\n        return std::min(i-n,fine);\r\
    \n    }\r\n};\r\n/**\r\n * @brief \u30BB\u30B0\u30E1\u30F3\u30C8\u6728\r\n * @see\
    \ https://github.com/tatyam-prime/kyopro_library/blob/master/SegmentTree.cpp\r\
    \n */\n"
  code: "#pragma once\r\n\r\n#pragma GCC diagnostic ignored \"-Wreorder\"\r\n\r\n\
    #include <vector>\r\n#include <functional>\r\ntemplate <class T> struct SegTree\
    \ {\r\nprivate:\r\n    using F = std::function<T(T, T)>;\r\n    int n, rank, fine;\r\
    \n    const F f;\r\n    const T e;\r\n    std::vector<T> dat;\r\npublic:\r\n \
    \   SegTree(const int n_, const F f_, const T& e_): f(f_), e(e_), fine(n_) {\r\
    \n        n=1,rank=0;\r\n        while(fine>n) n<<=1LL,rank++;\r\n        dat.assign(2*n,e_);\r\
    \n    }\r\n    T operator[](int i) const { return dat[i+n]; }\r\n    void update(int\
    \ i, const T& x) {\r\n        i+=n;\r\n        dat[i]=x;\r\n        while(i>>=1LL)\
    \ dat[i]=f(dat[2*i],dat[2*i+1]);\r\n    }\r\n    void add(int i, const T& x) {\r\
    \n        i+=n;\r\n        dat[i]+=x;\r\n        while(i>>=1LL) dat[i]=f(dat[2*i],dat[2*i+1]);\r\
    \n    }\r\n    T query(int a, int b) const {\r\n        T l=e,r=e;\r\n       \
    \ for(a+=n, b+=n; a<b; a>>=1LL,b>>=1LL) {\r\n            if(a&1) l=f(l,dat[a++]);\r\
    \n            if(b&1) r=f(dat[--b],r);\r\n        }\r\n        return f(l,r);\r\
    \n    }\r\n    T alle() const { return dat[1]; }\r\n    template <class Boolean=bool>\
    \ inline int find_left(int r, const Boolean &fn) {\r\n        if(!r) return 0;\r\
    \n        int h=0,i=r+n;\r\n        T val=e;\r\n        for(; h <= rank; h++)\
    \ if(i>>h&1){\r\n            T val2=f(val,dat[i>>h^1]);\r\n            if(fn(val2)){\r\
    \n                i -= 1<<h;\r\n                if(i==n) return 0;\r\n       \
    \         val=val2;\r\n            }\r\n            else break;\r\n        }\r\
    \n        for(; h--;){\r\n            T val2 = f(val,dat[(i>>h)-1]);\r\n     \
    \       if(fn(val2)){\r\n                i-=1<<h;\r\n                if(i==n)\
    \ return 0;\r\n                val=val2;\r\n            }\r\n        }\r\n   \
    \     return i-n;\r\n    }\r\n    template <class Boolean=bool> inline int find_right(int\
    \ l, const Boolean &fn) {\r\n        if(l==fine) return fine;\r\n        int h=0,i=l+n;\r\
    \n        T val=e;\r\n        for(; h<=rank; h++) if(i>>h&1){\r\n            T\
    \ val2=f(val,dat[i>>h]);\r\n            if(fn(val2)){\r\n                i+=1LL<<h;\r\
    \n                if(i==n*2) return fine;\r\n                val=val2;\r\n   \
    \         }\r\n            else break;\r\n        }\r\n        for(; h--;){\r\n\
    \            T val2=f(val, dat[i>>h]);\r\n            if(fn(val2)){\r\n      \
    \          i+=1LL<<h;\r\n                if(i==n*2) return fine;\r\n         \
    \       val=val2;\r\n            }\r\n        }\r\n        return std::min(i-n,fine);\r\
    \n    }\r\n};\r\n/**\r\n * @brief \u30BB\u30B0\u30E1\u30F3\u30C8\u6728\r\n * @see\
    \ https://github.com/tatyam-prime/kyopro_library/blob/master/SegmentTree.cpp\r\
    \n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/ds/SegmentTree.hpp
  requiredBy: []
  timestamp: '2024-02-27 10:38:23+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/segtree2.test.cpp
  - test/segtree.test.cpp
documentation_of: C++/ds/SegmentTree.hpp
layout: document
redirect_from:
- /library/C++/ds/SegmentTree.hpp
- /library/C++/ds/SegmentTree.hpp.html
title: "\u30BB\u30B0\u30E1\u30F3\u30C8\u6728"
---