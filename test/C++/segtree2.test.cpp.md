---
data:
  _extendedDependsOn:
  - icon: ':x:'
    path: C++/ds/SegmentTree.hpp
    title: "\u30BB\u30B0\u30E1\u30F3\u30C8\u6728"
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: cpp
  _verificationStatusIcon: ':x:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/2/DSL_2_A
    links:
    - https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/2/DSL_2_A
  bundledCode: "#line 1 \"test/C++/segtree2.test.cpp\"\n#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/2/DSL_2_A\"\
    \n#include <iostream>\n#include <limits>\n#line 2 \"C++/ds/SegmentTree.hpp\"\n\
    \r\n#pragma GCC diagnostic ignored \"-Wreorder\"\r\n\r\n#include <vector>\r\n\
    #include <functional>\r\ntemplate <class T> struct SegTree {\r\nprivate:\r\n \
    \   using F = std::function<T(T, T)>;\r\n    int n, rank, fine;\r\n    const F\
    \ f;\r\n    const T e;\r\n    std::vector<T> dat;\r\npublic:\r\n    SegTree(const\
    \ int n_, const F f_, const T& e_): f(f_), e(e_), fine(n_) {\r\n        n=1,rank=0;\r\
    \n        while(fine>n) n<<=1LL,rank++;\r\n        dat.assign(2*n,e_);\r\n   \
    \ }\r\n    T operator[](int i) const { return dat[i+n]; }\r\n    void update(int\
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
    \n */\n#line 5 \"test/C++/segtree2.test.cpp\"\nint main() {\n    int n, q;\n \
    \   std::cin >> n >> q;\n    SegTree<int> seg(n, [](const int x, const int y)\
    \ -> int { return std::min(x, y); }, std::numeric_limits<int>::max());\n    while(q--)\
    \ {\n        int com, x, y;\n        std::cin >> com >> x >> y;\n        if(com\
    \ == 0) {\n            seg.update(x, y);\n        } else {\n            std::cout\
    \ << seg.query(x, y + 1) << '\\n';\n        }\n    }\n}\n"
  code: "#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/library/3/DSL/2/DSL_2_A\"\
    \n#include <iostream>\n#include <limits>\n#include \"C++/ds/SegmentTree.hpp\"\n\
    int main() {\n    int n, q;\n    std::cin >> n >> q;\n    SegTree<int> seg(n,\
    \ [](const int x, const int y) -> int { return std::min(x, y); }, std::numeric_limits<int>::max());\n\
    \    while(q--) {\n        int com, x, y;\n        std::cin >> com >> x >> y;\n\
    \        if(com == 0) {\n            seg.update(x, y);\n        } else {\n   \
    \         std::cout << seg.query(x, y + 1) << '\\n';\n        }\n    }\n}"
  dependsOn:
  - C++/ds/SegmentTree.hpp
  isVerificationFile: true
  path: test/C++/segtree2.test.cpp
  requiredBy: []
  timestamp: '2024-03-02 19:12:32+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: test/C++/segtree2.test.cpp
layout: document
redirect_from:
- /verify/test/C++/segtree2.test.cpp
- /verify/test/C++/segtree2.test.cpp.html
title: test/C++/segtree2.test.cpp
---
