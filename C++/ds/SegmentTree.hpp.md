---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':x:'
    path: test/segtree.test.cpp
    title: test/segtree.test.cpp
  - icon: ':x:'
    path: test/segtree2.test.cpp
    title: test/segtree2.test.cpp
  _isVerificationFailed: true
  _pathExtension: hpp
  _verificationStatusIcon: ':x:'
  attributes:
    document_title: "\u30BB\u30B0\u30E1\u30F3\u30C8\u6728"
    links:
    - https://github.com/tatyam-prime/kyopro_library/blob/master/SegmentTree.cpp
  bundledCode: "#line 2 \"C++/ds/SegmentTree.hpp\"\n\r\n#pragma GCC diagnostic ignored\
    \ \"-Wreorder\"\r\n\r\n#include <vector>\r\n#include <functional>\r\n#include\
    \ <ranges>\r\nnamespace man {\r\ntemplate <class T> struct SegTree {\r\nprivate:\r\
    \n    using F = std::function<T(T, T)>;\r\n    int n, rank, fine;\r\n    const\
    \ F f;\r\n    const T e;\r\n    std::vector<T> dat;\r\npublic:\r\n    SegTree(const\
    \ int n_, const F f_, const T& e_): f(f_), e(e_), fine(n_) {\r\n        n = 1,\
    \ rank = 0;\r\n        while(fine > n) {\r\n            n <<= 1LL, rank++;\r\n\
    \        }\r\n        dat.assign(n << 1, e_);\r\n    }\r\n    SegTree(const std::vector<T>\
    \ &v, const F f_, const T e_): f(f_), e(e_), fine(std::ssize(v)) {\r\n       \
    \ n = 1, rank = 0;\r\n        while(fine > n) {\r\n            n <<= 1LL, rank++;\r\
    \n        }\r\n        dat.assign(n << 1, e_);\r\n        for(const auto i: std::views::iota(0,\
    \ std::ssize(v))) {\r\n            update(i, v[i]);\r\n        }\r\n    }\r\n\
    \    constexpr inline T operator[](int i) const noexcept { return dat[i + n];\
    \ }\r\n    constexpr inline void update(int i, const T& x) noexcept {\r\n    \
    \    i += n;\r\n        dat[i] = x;\r\n        while(i >>= 1LL) {\r\n        \
    \    dat[i] = f(dat[2 * i], dat[2 * i + 1]);\r\n        }\r\n    }\r\n    constexpr\
    \ inline void add(int i, const T& x) noexcept {\r\n        i += n;\r\n       \
    \ dat[i] += x;\r\n        while(i >>= 1LL) {\r\n            dat[i] = f(dat[2 *\
    \ i], dat[2 * i + 1]);\r\n        }\r\n    }\r\n    constexpr inline T query(int\
    \ a, int b) const noexcept {\r\n        T l = e, r = e;\r\n        for(a += n,\
    \ b += n; a < b; a >>= 1LL, b >>= 1LL) {\r\n            if(a & 1) {\r\n      \
    \          l = f(l, dat[a++]);\r\n            }\r\n            if(b & 1) {\r\n\
    \                r = f(dat[--b], r);\r\n            }\r\n        }\r\n       \
    \ return f(l, r);\r\n    }\r\n    constexpr inline T all() const noexcept { return\
    \ dat[1]; }\r\n    template <class Boolean = bool> constexpr inline int find_left(int\
    \ r, const Boolean &fn) noexcept{\r\n        if(r == 0) {\r\n            return\
    \ 0;\r\n        }\r\n        int h = 0, i = r + n;\r\n        T val = e;\r\n \
    \       for(; h <= rank; h++) {\r\n            if(i >> h & 1){\r\n           \
    \     T val2 = f(val, dat[i >> h ^ 1]);\r\n                if(fn(val2)) {\r\n\
    \                    i -= 1 << h;\r\n                    if(i == n) {\r\n    \
    \                    return 0;\r\n                    }\r\n                  \
    \  val = val2;\r\n                } else {\r\n                    break;\r\n \
    \               }\r\n            }\r\n        }\r\n        for(; h--;) {\r\n \
    \           T val2 = f(val, dat[(i >> h) - 1]);\r\n            if(fn(val2)) {\r\
    \n                i -= 1 << h;\r\n                if(i == n) {\r\n           \
    \         return 0;\r\n                }\r\n                val = val2;\r\n  \
    \          }\r\n        }\r\n        return i - n;\r\n    }\r\n    template <class\
    \ Boolean = bool> constexpr inline int find_right(int l, const Boolean &fn) noexcept\
    \ {\r\n        if(l == fine) {\r\n            return fine;\r\n        }\r\n  \
    \      int h = 0, i = l + n;\r\n        T val = e;\r\n        for(; h <= rank;\
    \ h++) {\r\n            if(i >> h & 1) {\r\n                const T val2 = f(val,\
    \ dat[i >> h]);\r\n                if(fn(val2)) {\r\n                    i +=\
    \ 1LL << h;\r\n                    if(i == n * 2) {\r\n                      \
    \  return fine;\r\n                    }\r\n                    val = val2;\r\n\
    \                } else {\r\n                    break;\r\n                }\r\
    \n            }\r\n        }\r\n        for(; h--;) {\r\n            const T val2\
    \ = f(val, dat[i >> h]);\r\n            if(fn(val2)) {\r\n                i +=\
    \ 1LL << h;\r\n                if(i == n * 2) {\r\n                    return\
    \ fine;\r\n                }\r\n                val = val2;\r\n            }\r\
    \n        }\r\n        return std::min(i - n, fine);\r\n    }\r\n};\r\n}\r\n/**\r\
    \n * @brief \u30BB\u30B0\u30E1\u30F3\u30C8\u6728\r\n * @see https://github.com/tatyam-prime/kyopro_library/blob/master/SegmentTree.cpp\r\
    \n */\n"
  code: "#pragma once\r\n\r\n#pragma GCC diagnostic ignored \"-Wreorder\"\r\n\r\n\
    #include <vector>\r\n#include <functional>\r\n#include <ranges>\r\nnamespace man\
    \ {\r\ntemplate <class T> struct SegTree {\r\nprivate:\r\n    using F = std::function<T(T,\
    \ T)>;\r\n    int n, rank, fine;\r\n    const F f;\r\n    const T e;\r\n    std::vector<T>\
    \ dat;\r\npublic:\r\n    SegTree(const int n_, const F f_, const T& e_): f(f_),\
    \ e(e_), fine(n_) {\r\n        n = 1, rank = 0;\r\n        while(fine > n) {\r\
    \n            n <<= 1LL, rank++;\r\n        }\r\n        dat.assign(n << 1, e_);\r\
    \n    }\r\n    SegTree(const std::vector<T> &v, const F f_, const T e_): f(f_),\
    \ e(e_), fine(std::ssize(v)) {\r\n        n = 1, rank = 0;\r\n        while(fine\
    \ > n) {\r\n            n <<= 1LL, rank++;\r\n        }\r\n        dat.assign(n\
    \ << 1, e_);\r\n        for(const auto i: std::views::iota(0, std::ssize(v)))\
    \ {\r\n            update(i, v[i]);\r\n        }\r\n    }\r\n    constexpr inline\
    \ T operator[](int i) const noexcept { return dat[i + n]; }\r\n    constexpr inline\
    \ void update(int i, const T& x) noexcept {\r\n        i += n;\r\n        dat[i]\
    \ = x;\r\n        while(i >>= 1LL) {\r\n            dat[i] = f(dat[2 * i], dat[2\
    \ * i + 1]);\r\n        }\r\n    }\r\n    constexpr inline void add(int i, const\
    \ T& x) noexcept {\r\n        i += n;\r\n        dat[i] += x;\r\n        while(i\
    \ >>= 1LL) {\r\n            dat[i] = f(dat[2 * i], dat[2 * i + 1]);\r\n      \
    \  }\r\n    }\r\n    constexpr inline T query(int a, int b) const noexcept {\r\
    \n        T l = e, r = e;\r\n        for(a += n, b += n; a < b; a >>= 1LL, b >>=\
    \ 1LL) {\r\n            if(a & 1) {\r\n                l = f(l, dat[a++]);\r\n\
    \            }\r\n            if(b & 1) {\r\n                r = f(dat[--b], r);\r\
    \n            }\r\n        }\r\n        return f(l, r);\r\n    }\r\n    constexpr\
    \ inline T all() const noexcept { return dat[1]; }\r\n    template <class Boolean\
    \ = bool> constexpr inline int find_left(int r, const Boolean &fn) noexcept{\r\
    \n        if(r == 0) {\r\n            return 0;\r\n        }\r\n        int h\
    \ = 0, i = r + n;\r\n        T val = e;\r\n        for(; h <= rank; h++) {\r\n\
    \            if(i >> h & 1){\r\n                T val2 = f(val, dat[i >> h ^ 1]);\r\
    \n                if(fn(val2)) {\r\n                    i -= 1 << h;\r\n     \
    \               if(i == n) {\r\n                        return 0;\r\n        \
    \            }\r\n                    val = val2;\r\n                } else {\r\
    \n                    break;\r\n                }\r\n            }\r\n       \
    \ }\r\n        for(; h--;) {\r\n            T val2 = f(val, dat[(i >> h) - 1]);\r\
    \n            if(fn(val2)) {\r\n                i -= 1 << h;\r\n             \
    \   if(i == n) {\r\n                    return 0;\r\n                }\r\n   \
    \             val = val2;\r\n            }\r\n        }\r\n        return i -\
    \ n;\r\n    }\r\n    template <class Boolean = bool> constexpr inline int find_right(int\
    \ l, const Boolean &fn) noexcept {\r\n        if(l == fine) {\r\n            return\
    \ fine;\r\n        }\r\n        int h = 0, i = l + n;\r\n        T val = e;\r\n\
    \        for(; h <= rank; h++) {\r\n            if(i >> h & 1) {\r\n         \
    \       const T val2 = f(val, dat[i >> h]);\r\n                if(fn(val2)) {\r\
    \n                    i += 1LL << h;\r\n                    if(i == n * 2) {\r\
    \n                        return fine;\r\n                    }\r\n          \
    \          val = val2;\r\n                } else {\r\n                    break;\r\
    \n                }\r\n            }\r\n        }\r\n        for(; h--;) {\r\n\
    \            const T val2 = f(val, dat[i >> h]);\r\n            if(fn(val2)) {\r\
    \n                i += 1LL << h;\r\n                if(i == n * 2) {\r\n     \
    \               return fine;\r\n                }\r\n                val = val2;\r\
    \n            }\r\n        }\r\n        return std::min(i - n, fine);\r\n    }\r\
    \n};\r\n}\r\n/**\r\n * @brief \u30BB\u30B0\u30E1\u30F3\u30C8\u6728\r\n * @see\
    \ https://github.com/tatyam-prime/kyopro_library/blob/master/SegmentTree.cpp\r\
    \n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/ds/SegmentTree.hpp
  requiredBy: []
  timestamp: '2025-06-06 22:43:06+09:00'
  verificationStatus: LIBRARY_ALL_WA
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
