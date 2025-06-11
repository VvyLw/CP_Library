---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
  - icon: ':heavy_check_mark:'
    path: C++/core/mypair.hpp
    title: C++/core/mypair.hpp
  - icon: ':heavy_check_mark:'
    path: C++/template.hpp
    title: "\u30C6\u30F3\u30D7\u30EC\u30FC\u30C8"
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/aarray.test.cpp
    title: test/aarray.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/add.test.cpp
    title: test/add.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/add128.test.cpp
    title: test/add128.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/extgcd.test.cpp
    title: test/extgcd.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/fwtree.test.cpp
    title: test/fwtree.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/m_add.test.cpp
    title: test/m_add.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/parsum.test.cpp
    title: test/parsum.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/s_rmq.test.cpp
    title: test/s_rmq.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/segtree.test.cpp
    title: test/segtree.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/sr_sum.test.cpp
    title: test/sr_sum.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/stable.test.cpp
    title: test/stable.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/uf.test.cpp
    title: test/uf.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    links: []
  bundledCode: "#line 2 \"C++/core/myvector.hpp\"\n\n#include <vector>\n\nnamespace\
    \ man {\nnamespace vec {\ntemplate <class T> using V = std::vector<T>;\ntypedef\
    \ V<int64_t> vi;\ntypedef V<uint64_t> vu;\ntypedef V<long double> vd;\ntypedef\
    \ V<char> vc;\ntypedef V<std::string> vs;\ntypedef V<bool> vb;\ntypedef V<vi>\
    \ wi;\ntypedef V<vu> wu;\ntypedef V<vd> wd;\ntypedef V<vc> wc;\ntypedef V<vs>\
    \ ws;\ntypedef V<vb> wb;\n#ifdef EDGE\ntypedef V<man::edge> ve;\ntypedef V<ve>\
    \ we;\n#endif\ntemplate <class T, class U> inline V<U> ndiv(T&& n, U&& v) noexcept\
    \ {\n  return V<U>(std::forward<T>(n), std::forward<U>(v));\n}\ntemplate <class\
    \ T, class... Ts> inline decltype(auto) ndiv(T&& n, Ts&&... v) noexcept {\n  return\
    \ V<decltype(ndiv(std::forward<Ts>(v)...))>(std::forward<T>(n), ndiv(std::forward<Ts>(v)...));\n\
    }\ntemplate <class T> constexpr V<T>& operator++(V<T>& v) noexcept { for(auto\
    \ &el: v) el++; return v; }\ntemplate <class T> constexpr V<T>& operator--(V<T>&\
    \ v) noexcept { for(auto &el: v) el--; return v; }\ntemplate <class T, class U>\
    \ constexpr V<T>& operator+=(V<T>& v, const U x) noexcept { for(auto &el: v) el+=x;\
    \ return v; }\ntemplate <class T, class U> constexpr V<T>& operator-=(V<T>& v,\
    \ const U x) noexcept { for(auto &el: v) el-=x; return v; }\ntemplate <class T,\
    \ class U> constexpr V<T>& operator*=(V<T>& v, const U x) noexcept { for(auto\
    \ &el: v) el*=x; return v; }\ntemplate <class T, class U> constexpr V<T>& operator/=(V<T>&\
    \ v, const U x) noexcept { for(auto &el: v) el/=x; return v; }\ntemplate <class\
    \ T, class U> constexpr V<T>& operator%=(V<T>& v, const U x) noexcept { for(auto\
    \ &el: v) el%=x; return v; }\ntemplate <class T, class U> constexpr V<T> operator+(const\
    \ V<T>& v, const U x) noexcept { V<T> res = v; res+=x; return res; }\ntemplate\
    \ <class T, class U> constexpr V<T> operator-(const V<T>& v, const U x) noexcept\
    \ { V<T> res = v; res-=x; return res; }\ntemplate <class T, class U> constexpr\
    \ V<T> operator*(const V<T>& v, const U x) noexcept { V<T> res = v; res*=x; return\
    \ res; }\ntemplate <class T, class U> constexpr V<T> operator/(const V<T>& v,\
    \ const U x) noexcept { V<T> res = v; res/=x; return res; }\ntemplate <class T,\
    \ class U> constexpr V<T> operator%(const V<T>& v, const U x) noexcept { V<T>\
    \ res = v; res%=x; return res; }\n}\n}\n"
  code: "#pragma once\n\n#include <vector>\n\nnamespace man {\nnamespace vec {\ntemplate\
    \ <class T> using V = std::vector<T>;\ntypedef V<int64_t> vi;\ntypedef V<uint64_t>\
    \ vu;\ntypedef V<long double> vd;\ntypedef V<char> vc;\ntypedef V<std::string>\
    \ vs;\ntypedef V<bool> vb;\ntypedef V<vi> wi;\ntypedef V<vu> wu;\ntypedef V<vd>\
    \ wd;\ntypedef V<vc> wc;\ntypedef V<vs> ws;\ntypedef V<vb> wb;\n#ifdef EDGE\n\
    typedef V<man::edge> ve;\ntypedef V<ve> we;\n#endif\ntemplate <class T, class\
    \ U> inline V<U> ndiv(T&& n, U&& v) noexcept {\n  return V<U>(std::forward<T>(n),\
    \ std::forward<U>(v));\n}\ntemplate <class T, class... Ts> inline decltype(auto)\
    \ ndiv(T&& n, Ts&&... v) noexcept {\n  return V<decltype(ndiv(std::forward<Ts>(v)...))>(std::forward<T>(n),\
    \ ndiv(std::forward<Ts>(v)...));\n}\ntemplate <class T> constexpr V<T>& operator++(V<T>&\
    \ v) noexcept { for(auto &el: v) el++; return v; }\ntemplate <class T> constexpr\
    \ V<T>& operator--(V<T>& v) noexcept { for(auto &el: v) el--; return v; }\ntemplate\
    \ <class T, class U> constexpr V<T>& operator+=(V<T>& v, const U x) noexcept {\
    \ for(auto &el: v) el+=x; return v; }\ntemplate <class T, class U> constexpr V<T>&\
    \ operator-=(V<T>& v, const U x) noexcept { for(auto &el: v) el-=x; return v;\
    \ }\ntemplate <class T, class U> constexpr V<T>& operator*=(V<T>& v, const U x)\
    \ noexcept { for(auto &el: v) el*=x; return v; }\ntemplate <class T, class U>\
    \ constexpr V<T>& operator/=(V<T>& v, const U x) noexcept { for(auto &el: v) el/=x;\
    \ return v; }\ntemplate <class T, class U> constexpr V<T>& operator%=(V<T>& v,\
    \ const U x) noexcept { for(auto &el: v) el%=x; return v; }\ntemplate <class T,\
    \ class U> constexpr V<T> operator+(const V<T>& v, const U x) noexcept { V<T>\
    \ res = v; res+=x; return res; }\ntemplate <class T, class U> constexpr V<T> operator-(const\
    \ V<T>& v, const U x) noexcept { V<T> res = v; res-=x; return res; }\ntemplate\
    \ <class T, class U> constexpr V<T> operator*(const V<T>& v, const U x) noexcept\
    \ { V<T> res = v; res*=x; return res; }\ntemplate <class T, class U> constexpr\
    \ V<T> operator/(const V<T>& v, const U x) noexcept { V<T> res = v; res/=x; return\
    \ res; }\ntemplate <class T, class U> constexpr V<T> operator%(const V<T>& v,\
    \ const U x) noexcept { V<T> res = v; res%=x; return res; }\n}\n}"
  dependsOn: []
  isVerificationFile: false
  path: C++/core/myvector.hpp
  requiredBy:
  - C++/core/mypair.hpp
  - C++/template.hpp
  timestamp: '2025-06-06 22:43:06+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/add.test.cpp
  - test/uf.test.cpp
  - test/s_rmq.test.cpp
  - test/sr_sum.test.cpp
  - test/stable.test.cpp
  - test/m_add.test.cpp
  - test/add128.test.cpp
  - test/parsum.test.cpp
  - test/fwtree.test.cpp
  - test/aarray.test.cpp
  - test/extgcd.test.cpp
  - test/segtree.test.cpp
documentation_of: C++/core/myvector.hpp
layout: document
redirect_from:
- /library/C++/core/myvector.hpp
- /library/C++/core/myvector.hpp.html
title: C++/core/myvector.hpp
---
