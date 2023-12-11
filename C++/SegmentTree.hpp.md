---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/segtree.test.cpp
    title: test/segtree.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    links:
    - https://github.com/tatyam-prime/kyopro_library/blob/master/SegmentTree.cpp
  bundledCode: "#line 2 \"C++/SegmentTree.hpp\"\n\r\n// inspired by tatyam( https://github.com/tatyam-prime/kyopro_library/blob/master/SegmentTree.cpp\
    \ )\r\n#include <vector>\r\n#include <functional>\r\ntypedef long long ll;\r\n\
    template <class T> struct SegTree {\r\nprivate:\r\n    using F = std::function<T(T,\
    \ T)>;\r\n    ll n, rank, fine;\r\n    const F f;\r\n    const T e;\r\n    std::vector<T>\
    \ dat;\r\npublic:\r\n    SegTree(const ll n_, const F f_, const T& e_): f(f_),\
    \ e(e_), fine(n_) {\r\n        n=1,rank=0;\r\n        while(fine>n) n<<=1LL,rank++;\r\
    \n        dat.assign(2*n,e_);\r\n    }\r\n    T operator[](ll i) const { return\
    \ dat[i+n]; }\r\n    void update(ll i, const T& x) {\r\n        i+=n;\r\n    \
    \    dat[i]=x;\r\n        while(i>>=1LL) dat[i]=f(dat[2*i],dat[2*i+1]);\r\n  \
    \  }\r\n    void add(ll i, const T& x) {\r\n        i+=n;\r\n        dat[i]+=x;\r\
    \n        while(i>>=1LL) dat[i]=f(dat[2*i],dat[2*i+1]);\r\n    }\r\n    T query(ll\
    \ a, ll b) const {\r\n        T l=e,r=e;\r\n        for(a+=n, b+=n; a<b; a>>=1LL,b>>=1LL)\
    \ {\r\n            if(a&1) l=f(l,dat[a++]);\r\n            if(b&1) r=f(dat[--b],r);\r\
    \n        }\r\n        return f(l,r);\r\n    }\r\n    template <class Boolean=bool>\
    \ inline int find_left(ll r, const Boolean &fn) {\r\n        if(!r) return 0;\r\
    \n        ll h=0,i=r+n;\r\n        T val=e;\r\n        for(; h <= rank; h++) if(i>>h&1){\r\
    \n            T val2=f(val,dat[i>>h^1]);\r\n            if(fn(val2)){\r\n    \
    \            i -= 1<<h;\r\n                if(i==n) return 0;\r\n            \
    \    val=val2;\r\n            }\r\n            else break;\r\n        }\r\n  \
    \      for(; h--;){\r\n            T val2 = f(val,dat[(i>>h)-1]);\r\n        \
    \    if(fn(val2)){\r\n                i-=1<<h;\r\n                if(i==n) return\
    \ 0;\r\n                val=val2;\r\n            }\r\n        }\r\n        return\
    \ i-n;\r\n    }\r\n    template <class Boolean=bool> inline int find_right(ll\
    \ l, const Boolean &fn) {\r\n        if(l==fine) return fine;\r\n        ll h=0,i=l+n;\r\
    \n        T val=e;\r\n        for(; h<=rank; h++) if(i>>h&1){\r\n            T\
    \ val2=f(val,dat[i>>h]);\r\n            if(fn(val2)){\r\n                i+=1LL<<h;\r\
    \n                if(i==n*2) return fine;\r\n                val=val2;\r\n   \
    \         }\r\n            else break;\r\n        }\r\n        for(; h--;){\r\n\
    \            T val2=f(val, dat[i>>h]);\r\n            if(fn(val2)){\r\n      \
    \          i+=1LL<<h;\r\n                if(i==n*2) return fine;\r\n         \
    \       val=val2;\r\n            }\r\n        }\r\n        return std::min(i-n,fine);\r\
    \n    }\r\n};\r\n"
  code: "#pragma once\r\n\r\n// inspired by tatyam( https://github.com/tatyam-prime/kyopro_library/blob/master/SegmentTree.cpp\
    \ )\r\n#include <vector>\r\n#include <functional>\r\ntypedef long long ll;\r\n\
    template <class T> struct SegTree {\r\nprivate:\r\n    using F = std::function<T(T,\
    \ T)>;\r\n    ll n, rank, fine;\r\n    const F f;\r\n    const T e;\r\n    std::vector<T>\
    \ dat;\r\npublic:\r\n    SegTree(const ll n_, const F f_, const T& e_): f(f_),\
    \ e(e_), fine(n_) {\r\n        n=1,rank=0;\r\n        while(fine>n) n<<=1LL,rank++;\r\
    \n        dat.assign(2*n,e_);\r\n    }\r\n    T operator[](ll i) const { return\
    \ dat[i+n]; }\r\n    void update(ll i, const T& x) {\r\n        i+=n;\r\n    \
    \    dat[i]=x;\r\n        while(i>>=1LL) dat[i]=f(dat[2*i],dat[2*i+1]);\r\n  \
    \  }\r\n    void add(ll i, const T& x) {\r\n        i+=n;\r\n        dat[i]+=x;\r\
    \n        while(i>>=1LL) dat[i]=f(dat[2*i],dat[2*i+1]);\r\n    }\r\n    T query(ll\
    \ a, ll b) const {\r\n        T l=e,r=e;\r\n        for(a+=n, b+=n; a<b; a>>=1LL,b>>=1LL)\
    \ {\r\n            if(a&1) l=f(l,dat[a++]);\r\n            if(b&1) r=f(dat[--b],r);\r\
    \n        }\r\n        return f(l,r);\r\n    }\r\n    template <class Boolean=bool>\
    \ inline int find_left(ll r, const Boolean &fn) {\r\n        if(!r) return 0;\r\
    \n        ll h=0,i=r+n;\r\n        T val=e;\r\n        for(; h <= rank; h++) if(i>>h&1){\r\
    \n            T val2=f(val,dat[i>>h^1]);\r\n            if(fn(val2)){\r\n    \
    \            i -= 1<<h;\r\n                if(i==n) return 0;\r\n            \
    \    val=val2;\r\n            }\r\n            else break;\r\n        }\r\n  \
    \      for(; h--;){\r\n            T val2 = f(val,dat[(i>>h)-1]);\r\n        \
    \    if(fn(val2)){\r\n                i-=1<<h;\r\n                if(i==n) return\
    \ 0;\r\n                val=val2;\r\n            }\r\n        }\r\n        return\
    \ i-n;\r\n    }\r\n    template <class Boolean=bool> inline int find_right(ll\
    \ l, const Boolean &fn) {\r\n        if(l==fine) return fine;\r\n        ll h=0,i=l+n;\r\
    \n        T val=e;\r\n        for(; h<=rank; h++) if(i>>h&1){\r\n            T\
    \ val2=f(val,dat[i>>h]);\r\n            if(fn(val2)){\r\n                i+=1LL<<h;\r\
    \n                if(i==n*2) return fine;\r\n                val=val2;\r\n   \
    \         }\r\n            else break;\r\n        }\r\n        for(; h--;){\r\n\
    \            T val2=f(val, dat[i>>h]);\r\n            if(fn(val2)){\r\n      \
    \          i+=1LL<<h;\r\n                if(i==n*2) return fine;\r\n         \
    \       val=val2;\r\n            }\r\n        }\r\n        return std::min(i-n,fine);\r\
    \n    }\r\n};\r\n"
  dependsOn: []
  isVerificationFile: false
  path: C++/SegmentTree.hpp
  requiredBy: []
  timestamp: '2023-12-11 21:48:09+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/segtree.test.cpp
documentation_of: C++/SegmentTree.hpp
layout: document
redirect_from:
- /library/C++/SegmentTree.hpp
- /library/C++/SegmentTree.hpp.html
title: C++/SegmentTree.hpp
---
