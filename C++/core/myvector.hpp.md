---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
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
    path: test/uf.test.cpp
    title: test/uf.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    links: []
  bundledCode: "#line 2 \"C++/core/myvector.hpp\"\n\n#include <vector>\n\n#ifndef\
    \ ALIAS\nnamespace internal {\ntemplate <typename T> concept num = std::integral<T>\
    \ || std::floating_point<T>;\n}\n#endif\n\nnamespace man {\nnamespace vec {\n\
    template <class T> using V = std::vector<T>;\ntypedef V<int64_t> zhl;\ntypedef\
    \ V<uint64_t> uzhl;\ntypedef V<long double> dec;\ntypedef V<char> chr;\ntypedef\
    \ V<std::string> str;\ntypedef V<bool> bol;\ntypedef V<zhl> zhl2;\ntypedef V<uzhl>\
    \ uzhl2;\ntypedef V<dec> dec2;\ntypedef V<chr> chr2;\ntypedef V<str> str2;\ntypedef\
    \ V<bol> bol2;\n#ifdef EDGE\ntypedef V<man::edge> edg;\ntypedef V<edg> edg2;\n\
    #endif\ntemplate <class T, class U> inline V<U> ndiv(T&& n, U&& v) noexcept {\n\
    \  return V<U>(std::forward<T>(n), std::forward<U>(v));\n}\ntemplate <class T,\
    \ class... Ts> inline decltype(auto) ndiv(T&& n, Ts&&... v) noexcept {\n  return\
    \ V<decltype(ndiv(std::forward<Ts>(v)...))>(std::forward<T>(n), ndiv(std::forward<Ts>(v)...));\n\
    }\ntemplate <internal::num T> constexpr V<T>& operator++(V<T>& v) noexcept { for(auto\
    \ &el: v){ el++; } return v; }\ntemplate <internal::num T> constexpr V<T>& operator--(V<T>&\
    \ v) noexcept { for(auto &el: v){ el--; } return v; }\ntemplate <internal::num\
    \ T, internal::num U> constexpr V<T>& operator+=(V<T>& v, const U x) noexcept\
    \ { for(auto &el: v){ el += x; } return v; }\ntemplate <internal::num T, internal::num\
    \ U> constexpr V<T>& operator-=(V<T>& v, const U x) noexcept { for(auto &el: v){\
    \ el -= x; } return v; }\ntemplate <internal::num T, internal::num U> constexpr\
    \ V<T>& operator*=(V<T>& v, const U x) noexcept { for(auto &el: v){ el *= x; }\
    \ return v; }\ntemplate <internal::num T, internal::num U> constexpr V<T>& operator/=(V<T>&\
    \ v, const U x) noexcept { for(auto &el: v){ el /= x; } return v; }\ntemplate\
    \ <std::integral T, std::integral U> constexpr V<T>& operator%=(V<T>& v, const\
    \ U x) noexcept { for(auto &el: v){ el %= x; } return v; }\ntemplate <internal::num\
    \ T, internal::num U> constexpr V<T> operator+(const V<T>& v, const U x) noexcept\
    \ { V<T> ret = v; ret += x; return ret; }\ntemplate <internal::num T, internal::num\
    \ U> constexpr V<T> operator-(const V<T>& v, const U x) noexcept { V<T> ret =\
    \ v; ret -= x; return ret; }\ntemplate <internal::num T, internal::num U> constexpr\
    \ V<T> operator*(const V<T>& v, const U x) noexcept { V<T> ret = v; ret *= x;\
    \ return ret; }\ntemplate <internal::num T, internal::num U> constexpr V<T> operator/(const\
    \ V<T>& v, const U x) noexcept { V<T> ret = v; ret /= x; return ret; }\ntemplate\
    \ <std::integral T, std::integral U> constexpr V<T> operator%(const V<T>& v, const\
    \ U x) noexcept { V<T> ret = v; ret %= x; return ret; }\n}\n}\n"
  code: "#pragma once\n\n#include <vector>\n\n#ifndef ALIAS\nnamespace internal {\n\
    template <typename T> concept num = std::integral<T> || std::floating_point<T>;\n\
    }\n#endif\n\nnamespace man {\nnamespace vec {\ntemplate <class T> using V = std::vector<T>;\n\
    typedef V<int64_t> zhl;\ntypedef V<uint64_t> uzhl;\ntypedef V<long double> dec;\n\
    typedef V<char> chr;\ntypedef V<std::string> str;\ntypedef V<bool> bol;\ntypedef\
    \ V<zhl> zhl2;\ntypedef V<uzhl> uzhl2;\ntypedef V<dec> dec2;\ntypedef V<chr> chr2;\n\
    typedef V<str> str2;\ntypedef V<bol> bol2;\n#ifdef EDGE\ntypedef V<man::edge>\
    \ edg;\ntypedef V<edg> edg2;\n#endif\ntemplate <class T, class U> inline V<U>\
    \ ndiv(T&& n, U&& v) noexcept {\n  return V<U>(std::forward<T>(n), std::forward<U>(v));\n\
    }\ntemplate <class T, class... Ts> inline decltype(auto) ndiv(T&& n, Ts&&... v)\
    \ noexcept {\n  return V<decltype(ndiv(std::forward<Ts>(v)...))>(std::forward<T>(n),\
    \ ndiv(std::forward<Ts>(v)...));\n}\ntemplate <internal::num T> constexpr V<T>&\
    \ operator++(V<T>& v) noexcept { for(auto &el: v){ el++; } return v; }\ntemplate\
    \ <internal::num T> constexpr V<T>& operator--(V<T>& v) noexcept { for(auto &el:\
    \ v){ el--; } return v; }\ntemplate <internal::num T, internal::num U> constexpr\
    \ V<T>& operator+=(V<T>& v, const U x) noexcept { for(auto &el: v){ el += x; }\
    \ return v; }\ntemplate <internal::num T, internal::num U> constexpr V<T>& operator-=(V<T>&\
    \ v, const U x) noexcept { for(auto &el: v){ el -= x; } return v; }\ntemplate\
    \ <internal::num T, internal::num U> constexpr V<T>& operator*=(V<T>& v, const\
    \ U x) noexcept { for(auto &el: v){ el *= x; } return v; }\ntemplate <internal::num\
    \ T, internal::num U> constexpr V<T>& operator/=(V<T>& v, const U x) noexcept\
    \ { for(auto &el: v){ el /= x; } return v; }\ntemplate <std::integral T, std::integral\
    \ U> constexpr V<T>& operator%=(V<T>& v, const U x) noexcept { for(auto &el: v){\
    \ el %= x; } return v; }\ntemplate <internal::num T, internal::num U> constexpr\
    \ V<T> operator+(const V<T>& v, const U x) noexcept { V<T> ret = v; ret += x;\
    \ return ret; }\ntemplate <internal::num T, internal::num U> constexpr V<T> operator-(const\
    \ V<T>& v, const U x) noexcept { V<T> ret = v; ret -= x; return ret; }\ntemplate\
    \ <internal::num T, internal::num U> constexpr V<T> operator*(const V<T>& v, const\
    \ U x) noexcept { V<T> ret = v; ret *= x; return ret; }\ntemplate <internal::num\
    \ T, internal::num U> constexpr V<T> operator/(const V<T>& v, const U x) noexcept\
    \ { V<T> ret = v; ret /= x; return ret; }\ntemplate <std::integral T, std::integral\
    \ U> constexpr V<T> operator%(const V<T>& v, const U x) noexcept { V<T> ret =\
    \ v; ret %= x; return ret; }\n}\n}"
  dependsOn: []
  isVerificationFile: false
  path: C++/core/myvector.hpp
  requiredBy:
  - C++/template.hpp
  timestamp: '2025-06-11 19:04:20+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/add.test.cpp
  - test/uf.test.cpp
  - test/s_rmq.test.cpp
  - test/sr_sum.test.cpp
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
