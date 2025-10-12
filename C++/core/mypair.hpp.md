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
  bundledCode: "#line 2 \"C++/core/mypair.hpp\"\n\n#include <cassert>\n#include <utility>\n\
    #include <tuple>\n#include <cmath>\n#include <numeric>\n\n#ifndef ALIAS\nnamespace\
    \ internal {\ntemplate <typename T> concept num = std::integral<T> || std::floating_point<T>;\n\
    }\n#endif\n\nnamespace man {\nnamespace pav {\ntemplate <class T, class U> using\
    \ P = std::pair<T, U>;\ntemplate <class T> using PP = P<T, T>;\ntypedef PP<long\
    \ long> zhl;\ntypedef PP<long double> dec;\ntypedef PP<char> chr;\ntypedef PP<std::string>\
    \ str;\ntemplate <internal::num T> constexpr PP<T> operator+(const PP<T>& a, const\
    \ PP<T>& b) noexcept { return {a.first + b.first, a.second + b.second}; }\ntemplate\
    \ <internal::num T> constexpr PP<T> operator-(const PP<T>& a, const PP<T>& b)\
    \ noexcept { return {a.first - b.first, a.second - b.second}; }\ntemplate <internal::num\
    \ T> constexpr PP<T> operator-(const PP<T>& a) noexcept { return {-a.first, -a.second};\
    \ }\ntemplate <internal::num T, class U> constexpr PP<T> operator*(const PP<T>&\
    \ a, const U& b) noexcept { return {a.first * b, a.second * b}; }\ntemplate <internal::num\
    \ T, class U> constexpr PP<T> operator/(const PP<T>& a, const U& b) noexcept {\
    \ return {a.first / b, a.second / b}; }\ntemplate <internal::num T> constexpr\
    \ PP<T>& operator+=(PP<T>& a, const PP<T>& b) noexcept { return a = a + b; }\n\
    template <internal::num T> constexpr PP<T>& operator-=(PP<T>& a, const PP<T>&\
    \ b) noexcept { return a = a - b; }\ntemplate <internal::num T, internal::num\
    \ U> constexpr PP<T>& operator*=(PP<T>& a, const U& b) noexcept { return a = a\
    \ * b; }\ntemplate <internal::num T, internal::num U> PP<T>& operator/=(PP<T>&\
    \ a, const U& b) noexcept { return a = a / b; }\ntemplate <class T> constexpr\
    \ bool operator==(const PP<T> &p, const PP<T> &q) noexcept { return p.first ==\
    \ q.first && p.second == q.second; }\ntemplate <class T> constexpr bool operator!=(const\
    \ PP<T> &p, const PP<T> &q) noexcept { return !(p == q); }\ntemplate <class T>\
    \ constexpr bool operator<(const PP<T> &p, const PP<T> &q) noexcept { if(p.first\
    \ == q.first){ return p.second < q.second; } return p.first < q.first; }\ntemplate\
    \ <class T> constexpr bool operator<=(const PP<T> &p, const PP<T> &q) noexcept\
    \ { if(p.first == q.first){ return p.second <= q.second; } return p.first < q.first;\
    \ }\ntemplate <class T> constexpr bool operator>(const PP<T> &p, const PP<T> &q)\
    \ noexcept { if(p.first == q.first){ return p.second > q.second; } return p.first\
    \ > q.first; }\ntemplate <class T> constexpr bool operator>=(const PP<T> &p, const\
    \ PP<T> &q) noexcept { if(p.first == q.first){ return p.second >= q.second; }\
    \ return p.first > q.first; }\ntemplate <class T, class U> constexpr bool operator==(const\
    \ P<T, U> &p, const P<T, U> &q) noexcept { return p.first == q.first && p.second\
    \ == q.second; }\ntemplate <class T, class U> constexpr bool operator!=(const\
    \ P<T, U> &p, const P<T, U> &q) noexcept { return !(p == q); }\ntemplate <class\
    \ T, class U> constexpr bool operator<(const P<T, U> &p, const P<T, U> &q) noexcept\
    \ { if(p.first == q.first){ return p.second < q.second; } return p.first < q.first;\
    \ }\ntemplate <class T, class U> constexpr bool operator<=(const P<T, U> &p, const\
    \ P<T, U> &q) noexcept { if(p.first == q.first){ return p.second <= q.second;\
    \ } return p.first < q.first; }\ntemplate <class T, class U> constexpr bool operator>(const\
    \ P<T, U> &p, const P<T, U> &q) noexcept { if(p.first == q.first){ return p.second\
    \ > q.second; } return p.first > q.first; }\ntemplate <class T, class U> constexpr\
    \ bool operator>=(const P<T, U> &p, const P<T, U> &q) noexcept { if(p.first ==\
    \ q.first){ return p.second >= q.second; } return p.first > q.first; }\ntemplate\
    \ <internal::num T> constexpr inline PP<T> rotate(const PP<T>& a) noexcept { return\
    \ {-a.second, a.first}; } // 90 degree ccw\ntemplate <internal::num T> constexpr\
    \ inline dec rotate(const PP<T>& a, const int ang) noexcept {\n    assert(0 <=\
    \ ang && ang < 360);\n    const long double rad = PI * ang / 180;\n    return\
    \ {a.first * std::cos(rad) - a.second * std::sin(rad), a.first * std::sin(rad)\
    \ + a.second * std::cos(rad)};\n}\ntemplate <internal::num T> constexpr inline\
    \ T dot(const PP<T>& a, const PP<T>& b) noexcept { return a.first * b.first +\
    \ a.second * b.second; }\ntemplate <internal::num T> constexpr inline T cross(const\
    \ PP<T>& a, const PP<T>& b) noexcept { return dot(rotate(a), b); }\ntemplate <internal::num\
    \ T> constexpr inline T square(const PP<T>& a) noexcept { return dot(a, a); }\n\
    template <internal::num T> constexpr inline long double grad(const PP<T>& a) noexcept\
    \ { assert(a.first != 0); return 1.0L * a.second / a.first; }\ntemplate <internal::num\
    \ T> constexpr inline long double abs(const PP<T>& a) noexcept { return std::hypotl(a.first,\
    \ a.second); }\ntemplate <std::integral T> constexpr inline T lcm(const PP<T>&\
    \ a) noexcept { return std::lcm(a.first, a.second); }\ntemplate <std::integral\
    \ T> constexpr inline T gcd(const PP<T>& a) noexcept { return std::gcd(a.first,\
    \ a.second); }\ntemplate <std::integral T> constexpr inline PP<T> extgcd(const\
    \ PP<T> &p) noexcept {\n    T x = 1, y = 0, t1 = 0, t2 = 0, t3 = 1, a, b;\n  \
    \  std::tie(a,b) = p;\n    while(b > 0) {\n        t1 = a / b, a -= t1 * b;\n\
    \        std::swap(a, b);\n        x -= t1 * t2;\n        std::swap(x, t2);\n\
    \        y -= t1 * t3;\n        std::swap(y, t3);\n    }\n    return {x, y};\n\
    }\ntemplate <std::integral T> constexpr inline PP<T> normalize(PP<T> a) noexcept\
    \ {\n    if(a == PP<T>{}) {\n        return a;\n    }\n    a /= gcd(a);\n    if(a\
    \ < PP<T>{}) {\n        a = -a;\n    }\n    return a;\n}\ntemplate <class T, class\
    \ U> constexpr inline P<U, T> swap(const P<T, U> &p) noexcept { const P<U, T>\
    \ ret = {p.second, p.first}; return ret; }\ntemplate <class T, class U> inline\
    \ std::vector<P<U, T>> swap(const std::vector<P<T, U>> &vp) noexcept {\n    std::vector<P<U,\
    \ T>> ret;\n    for(const auto &el: vp) {\n        ret.emplace_back(swap(el));\n\
    \    }\n    return ret;\n}\ntemplate <class T, class U> inline std::vector<T>\
    \ first(const std::vector<P<T, U>> &vp) noexcept {\n    std::vector<T> ret;\n\
    \    for(const auto &el: vp) {\n        ret.emplace_back(el.first);\n    }\n \
    \   return ret;\n}\ntemplate <class T, class U> inline std::vector<U> second(const\
    \ std::vector<P<T, U>> &vp) noexcept {\n    std::vector<U> ret;\n    for(const\
    \ auto &el: vp) {\n        ret.emplace_back(el.second);\n    }\n    return ret;\n\
    }\n}\n}\n"
  code: "#pragma once\n\n#include <cassert>\n#include <utility>\n#include <tuple>\n\
    #include <cmath>\n#include <numeric>\n\n#ifndef ALIAS\nnamespace internal {\n\
    template <typename T> concept num = std::integral<T> || std::floating_point<T>;\n\
    }\n#endif\n\nnamespace man {\nnamespace pav {\ntemplate <class T, class U> using\
    \ P = std::pair<T, U>;\ntemplate <class T> using PP = P<T, T>;\ntypedef PP<long\
    \ long> zhl;\ntypedef PP<long double> dec;\ntypedef PP<char> chr;\ntypedef PP<std::string>\
    \ str;\ntemplate <internal::num T> constexpr PP<T> operator+(const PP<T>& a, const\
    \ PP<T>& b) noexcept { return {a.first + b.first, a.second + b.second}; }\ntemplate\
    \ <internal::num T> constexpr PP<T> operator-(const PP<T>& a, const PP<T>& b)\
    \ noexcept { return {a.first - b.first, a.second - b.second}; }\ntemplate <internal::num\
    \ T> constexpr PP<T> operator-(const PP<T>& a) noexcept { return {-a.first, -a.second};\
    \ }\ntemplate <internal::num T, class U> constexpr PP<T> operator*(const PP<T>&\
    \ a, const U& b) noexcept { return {a.first * b, a.second * b}; }\ntemplate <internal::num\
    \ T, class U> constexpr PP<T> operator/(const PP<T>& a, const U& b) noexcept {\
    \ return {a.first / b, a.second / b}; }\ntemplate <internal::num T> constexpr\
    \ PP<T>& operator+=(PP<T>& a, const PP<T>& b) noexcept { return a = a + b; }\n\
    template <internal::num T> constexpr PP<T>& operator-=(PP<T>& a, const PP<T>&\
    \ b) noexcept { return a = a - b; }\ntemplate <internal::num T, internal::num\
    \ U> constexpr PP<T>& operator*=(PP<T>& a, const U& b) noexcept { return a = a\
    \ * b; }\ntemplate <internal::num T, internal::num U> PP<T>& operator/=(PP<T>&\
    \ a, const U& b) noexcept { return a = a / b; }\ntemplate <class T> constexpr\
    \ bool operator==(const PP<T> &p, const PP<T> &q) noexcept { return p.first ==\
    \ q.first && p.second == q.second; }\ntemplate <class T> constexpr bool operator!=(const\
    \ PP<T> &p, const PP<T> &q) noexcept { return !(p == q); }\ntemplate <class T>\
    \ constexpr bool operator<(const PP<T> &p, const PP<T> &q) noexcept { if(p.first\
    \ == q.first){ return p.second < q.second; } return p.first < q.first; }\ntemplate\
    \ <class T> constexpr bool operator<=(const PP<T> &p, const PP<T> &q) noexcept\
    \ { if(p.first == q.first){ return p.second <= q.second; } return p.first < q.first;\
    \ }\ntemplate <class T> constexpr bool operator>(const PP<T> &p, const PP<T> &q)\
    \ noexcept { if(p.first == q.first){ return p.second > q.second; } return p.first\
    \ > q.first; }\ntemplate <class T> constexpr bool operator>=(const PP<T> &p, const\
    \ PP<T> &q) noexcept { if(p.first == q.first){ return p.second >= q.second; }\
    \ return p.first > q.first; }\ntemplate <class T, class U> constexpr bool operator==(const\
    \ P<T, U> &p, const P<T, U> &q) noexcept { return p.first == q.first && p.second\
    \ == q.second; }\ntemplate <class T, class U> constexpr bool operator!=(const\
    \ P<T, U> &p, const P<T, U> &q) noexcept { return !(p == q); }\ntemplate <class\
    \ T, class U> constexpr bool operator<(const P<T, U> &p, const P<T, U> &q) noexcept\
    \ { if(p.first == q.first){ return p.second < q.second; } return p.first < q.first;\
    \ }\ntemplate <class T, class U> constexpr bool operator<=(const P<T, U> &p, const\
    \ P<T, U> &q) noexcept { if(p.first == q.first){ return p.second <= q.second;\
    \ } return p.first < q.first; }\ntemplate <class T, class U> constexpr bool operator>(const\
    \ P<T, U> &p, const P<T, U> &q) noexcept { if(p.first == q.first){ return p.second\
    \ > q.second; } return p.first > q.first; }\ntemplate <class T, class U> constexpr\
    \ bool operator>=(const P<T, U> &p, const P<T, U> &q) noexcept { if(p.first ==\
    \ q.first){ return p.second >= q.second; } return p.first > q.first; }\ntemplate\
    \ <internal::num T> constexpr inline PP<T> rotate(const PP<T>& a) noexcept { return\
    \ {-a.second, a.first}; } // 90 degree ccw\ntemplate <internal::num T> constexpr\
    \ inline dec rotate(const PP<T>& a, const int ang) noexcept {\n    assert(0 <=\
    \ ang && ang < 360);\n    const long double rad = PI * ang / 180;\n    return\
    \ {a.first * std::cos(rad) - a.second * std::sin(rad), a.first * std::sin(rad)\
    \ + a.second * std::cos(rad)};\n}\ntemplate <internal::num T> constexpr inline\
    \ T dot(const PP<T>& a, const PP<T>& b) noexcept { return a.first * b.first +\
    \ a.second * b.second; }\ntemplate <internal::num T> constexpr inline T cross(const\
    \ PP<T>& a, const PP<T>& b) noexcept { return dot(rotate(a), b); }\ntemplate <internal::num\
    \ T> constexpr inline T square(const PP<T>& a) noexcept { return dot(a, a); }\n\
    template <internal::num T> constexpr inline long double grad(const PP<T>& a) noexcept\
    \ { assert(a.first != 0); return 1.0L * a.second / a.first; }\ntemplate <internal::num\
    \ T> constexpr inline long double abs(const PP<T>& a) noexcept { return std::hypotl(a.first,\
    \ a.second); }\ntemplate <std::integral T> constexpr inline T lcm(const PP<T>&\
    \ a) noexcept { return std::lcm(a.first, a.second); }\ntemplate <std::integral\
    \ T> constexpr inline T gcd(const PP<T>& a) noexcept { return std::gcd(a.first,\
    \ a.second); }\ntemplate <std::integral T> constexpr inline PP<T> extgcd(const\
    \ PP<T> &p) noexcept {\n    T x = 1, y = 0, t1 = 0, t2 = 0, t3 = 1, a, b;\n  \
    \  std::tie(a,b) = p;\n    while(b > 0) {\n        t1 = a / b, a -= t1 * b;\n\
    \        std::swap(a, b);\n        x -= t1 * t2;\n        std::swap(x, t2);\n\
    \        y -= t1 * t3;\n        std::swap(y, t3);\n    }\n    return {x, y};\n\
    }\ntemplate <std::integral T> constexpr inline PP<T> normalize(PP<T> a) noexcept\
    \ {\n    if(a == PP<T>{}) {\n        return a;\n    }\n    a /= gcd(a);\n    if(a\
    \ < PP<T>{}) {\n        a = -a;\n    }\n    return a;\n}\ntemplate <class T, class\
    \ U> constexpr inline P<U, T> swap(const P<T, U> &p) noexcept { const P<U, T>\
    \ ret = {p.second, p.first}; return ret; }\ntemplate <class T, class U> inline\
    \ std::vector<P<U, T>> swap(const std::vector<P<T, U>> &vp) noexcept {\n    std::vector<P<U,\
    \ T>> ret;\n    for(const auto &el: vp) {\n        ret.emplace_back(swap(el));\n\
    \    }\n    return ret;\n}\ntemplate <class T, class U> inline std::vector<T>\
    \ first(const std::vector<P<T, U>> &vp) noexcept {\n    std::vector<T> ret;\n\
    \    for(const auto &el: vp) {\n        ret.emplace_back(el.first);\n    }\n \
    \   return ret;\n}\ntemplate <class T, class U> inline std::vector<U> second(const\
    \ std::vector<P<T, U>> &vp) noexcept {\n    std::vector<U> ret;\n    for(const\
    \ auto &el: vp) {\n        ret.emplace_back(el.second);\n    }\n    return ret;\n\
    }\n}\n}"
  dependsOn: []
  isVerificationFile: false
  path: C++/core/mypair.hpp
  requiredBy:
  - C++/template.hpp
  timestamp: '2025-06-14 01:07:36+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/parsum.test.cpp
  - test/aarray.test.cpp
  - test/uf.test.cpp
  - test/segtree.test.cpp
  - test/s_rmq.test.cpp
  - test/extgcd.test.cpp
  - test/m_add.test.cpp
  - test/add.test.cpp
  - test/add128.test.cpp
  - test/sr_sum.test.cpp
  - test/fwtree.test.cpp
documentation_of: C++/core/mypair.hpp
layout: document
redirect_from:
- /library/C++/core/mypair.hpp
- /library/C++/core/mypair.hpp.html
title: C++/core/mypair.hpp
---
