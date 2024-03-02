---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: C++/constance.hpp
    title: "\u5B9A\u6570"
  - icon: ':question:'
    path: C++/mypair.hpp
    title: C++/mypair.hpp
  - icon: ':question:'
    path: C++/myvector.hpp
    title: C++/myvector.hpp
  _extendedRequiredBy:
  - icon: ':question:'
    path: C++/template.hpp
    title: "\u30C6\u30F3\u30D7\u30EC\u30FC\u30C8"
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/C++/aarray.test.cpp
    title: test/C++/aarray.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/C++/add.test.cpp
    title: test/C++/add.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/C++/add128.test.cpp
    title: test/C++/add128.test.cpp
  - icon: ':x:'
    path: test/C++/extgcd.test.cpp
    title: test/C++/extgcd.test.cpp
  - icon: ':x:'
    path: test/C++/fwtree.test.cpp
    title: test/C++/fwtree.test.cpp
  - icon: ':x:'
    path: test/C++/m_add.test.cpp
    title: test/C++/m_add.test.cpp
  - icon: ':x:'
    path: test/C++/parsum.test.cpp
    title: test/C++/parsum.test.cpp
  - icon: ':x:'
    path: test/C++/s_rmq.test.cpp
    title: test/C++/s_rmq.test.cpp
  - icon: ':x:'
    path: test/C++/segtree.test.cpp
    title: test/C++/segtree.test.cpp
  - icon: ':x:'
    path: test/C++/sr_sum.test.cpp
    title: test/C++/sr_sum.test.cpp
  - icon: ':x:'
    path: test/C++/stable.test.cpp
    title: test/C++/stable.test.cpp
  - icon: ':x:'
    path: test/C++/uf.test.cpp
    title: test/C++/uf.test.cpp
  _isVerificationFailed: true
  _pathExtension: hpp
  _verificationStatusIcon: ':question:'
  attributes:
    document_title: "\u7D20\u56E0\u6570\u5206\u89E3"
    links: []
  bundledCode: "#line 2 \"C++/math/primefactor.hpp\"\n\n#line 2 \"C++/mypair.hpp\"\
    \n\n#include <cassert>\n#include <utility>\n#include <tuple>\n#include <cmath>\n\
    #include <numeric>\n#line 2 \"C++/constance.hpp\"\n\n#include <limits>\n#ifndef\
    \ TEMPLATE\nusing ll = long long;\nusing ld = long double;\n#endif\ntemplate <class\
    \ T> using L = std::numeric_limits<T>;\nconstexpr int dx[] = {0, 0, 0, -1, 1,\
    \ -1, -1, 1, 1};\nconstexpr int dy[] = {0, -1, 1, 0, 0, -1, 1, -1, 1};\nconstexpr\
    \ int MOD = 0x3b800001;\nconstexpr int M0D = 1e9 + 7;\nconstexpr int INF = 1 <<\
    \ 30;\nconstexpr ll LINF = (1LL << 61) - 1;\nconstexpr ld DINF = L<ld>::infinity();\n\
    template <class T> constexpr T LIM = L<T>::max();\n#if __cplusplus >= 202100L\n\
    #include <numbers>\nconstexpr ld PI = std::numbers::pi;\nconstexpr ld E = std::numbers::e;\n\
    #else\n#line 23 \"C++/constance.hpp\"\nconst ld PI = std::acos(-1);\nconst ld\
    \ E = 2.718281828459045;\n#endif\n\n/**\n * @brief \u5B9A\u6570\n */\n#line 2\
    \ \"C++/myvector.hpp\"\n\n#include <vector>\n\n#ifndef TEMPLATE\ntypedef long\
    \ long ll;\ntypedef unsigned long long ul;\ntypedef long double ld;\n#endif\n\
    namespace vectors {\ntemplate <class T> using V = std::vector<T>;\nusing vi =\
    \ V<ll>;\nusing vu = V<ul>;\nusing vd = V<ld>;\nusing vc = V<char>;\nusing vs\
    \ = V<std::string>;\nusing vb = V<bool>;\nusing wi = V<vi>;\nusing wu = V<vu>;\n\
    using wd = V<vd>;\nusing wc = V<vc>;\nusing ws = V<vs>;\nusing wb = V<vb>;\ntemplate\
    \ <class T, class U> inline V<U> ndiv(T&& n, U&& v) noexcept {\n  return V<U>(std::forward<T>(n),\
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
    \ const U x) noexcept { V<T> res = v; res%=x; return res; }\n} // vectors\n#line\
    \ 10 \"C++/mypair.hpp\"\nnamespace pairs {\ntemplate <class T, class U> using\
    \ P = std::pair<T, U>;\ntemplate <class T> using PP = P<T,T>;\nusing pi = PP<ll>;\n\
    using pd = PP<ld>;\nusing pc = PP<char>;\nusing ps = PP<std::string>;\ntemplate\
    \ <class T> constexpr PP<T> operator+(const PP<T>& a, const PP<T>& b) noexcept\
    \ { return {a.first + b.first, a.second + b.second}; }\ntemplate <class T> constexpr\
    \ PP<T> operator-(const PP<T>& a, const PP<T>& b) noexcept { return {a.first -\
    \ b.first, a.second - b.second}; }\ntemplate <class T> constexpr PP<T> operator-(const\
    \ PP<T>& a) noexcept { return {-a.first, -a.second}; }\ntemplate <class T, class\
    \ U> constexpr PP<T> operator*(const PP<T>& a, const U& b) noexcept { return {a.first\
    \ * b, a.second * b}; }\ntemplate <class T, class U> constexpr PP<T> operator/(const\
    \ PP<T>& a, const U& b) noexcept { return {a.first / b, a.second / b}; }\ntemplate\
    \ <class T> constexpr PP<T>& operator+=(PP<T>& a, const PP<T>& b) noexcept { return\
    \ a = a + b; }\ntemplate <class T> constexpr PP<T>& operator-=(PP<T>& a, const\
    \ PP<T>& b) noexcept { return a = a - b; }\ntemplate <class T, class U> constexpr\
    \ PP<T>& operator*=(PP<T>& a, const U& b) noexcept { return a = a * b; }\ntemplate\
    \ <class T, class U> PP<T>& operator/=(PP<T>& a, const U& b) noexcept { return\
    \ a = a / b; }\ntemplate <class T> constexpr bool operator==(const PP<T> &p, const\
    \ PP<T> &q) noexcept { return p.first==q.first && p.second==q.second; }\ntemplate\
    \ <class T> constexpr bool operator!=(const PP<T> &p, const PP<T> &q) noexcept\
    \ { return !(p==q); }\ntemplate <class T> constexpr bool operator<(const PP<T>\
    \ &p, const PP<T> &q) noexcept { if(p.first==q.first) return p.second<q.second;\
    \ return p.first<q.first; }\ntemplate <class T> constexpr bool operator<=(const\
    \ PP<T> &p, const PP<T> &q) noexcept { if(p.first==q.first) return p.second<=q.second;\
    \ return p.first<q.first; }\ntemplate <class T> constexpr bool operator>(const\
    \ PP<T> &p, const PP<T> &q) noexcept { if(p.first==q.first) return p.second>q.second;\
    \ return p.first>q.first; }\ntemplate <class T> constexpr bool operator>=(const\
    \ PP<T> &p, const PP<T> &q) noexcept { if(p.first==q.first) return p.second>=q.second;\
    \ return p.first>q.first; }\ntemplate <class T, class U> constexpr bool operator==(const\
    \ P<T,U> &p, const P<T,U> &q) noexcept { return p.first==q.first && p.second==q.second;\
    \ }\ntemplate <class T, class U> constexpr bool operator!=(const P<T,U> &p, const\
    \ P<T,U> &q) noexcept { return !(p==q); }\ntemplate <class T, class U> constexpr\
    \ bool operator<(const P<T,U> &p, const P<T,U> &q) noexcept { if(p.first==q.first)\
    \ return p.second<q.second; return p.first<q.first; }\ntemplate <class T, class\
    \ U> constexpr bool operator<=(const P<T,U> &p, const P<T,U> &q) noexcept { if(p.first==q.first)\
    \ return p.second<=q.second; return p.first<q.first; }\ntemplate <class T, class\
    \ U> constexpr bool operator>(const P<T,U> &p, const P<T,U> &q) noexcept { if(p.first==q.first)\
    \ return p.second>q.second; return p.first>q.first; }\ntemplate <class T, class\
    \ U> constexpr bool operator>=(const P<T,U> &p, const P<T,U> &q) noexcept { if(p.first==q.first)\
    \ return p.second>=q.second; return p.first>q.first; }\ntemplate <class T> inline\
    \ PP<T> rotate(const PP<T>& a){ return {-a.second, a.first}; } // 90 degree ccw\n\
    template <class T> inline pd rotate(const PP<T>& a, const int ang) {\n    assert(0<=ang\
    \ && ang<360);\n    const ld rad=PI*ang/180;\n    return {a.first*std::cos(rad)-a.second*std::sin(rad),\
    \ a.first*std::sin(rad)+a.second*std::cos(rad)};\n}\ntemplate <class T> inline\
    \ T dot(const PP<T>& a, const PP<T>& b){ return a.first * b.first + a.second *\
    \ b.second; }\ntemplate <class T> inline T cross(const PP<T>& a, const PP<T>&\
    \ b){ return dot(rotate(a), b); }\ntemplate <class T> inline T square(const PP<T>&\
    \ a){ return dot(a, a); }\ntemplate <class T> inline ld grad(const PP<T>& a){\
    \ assert(a.first); return 1.0L * a.second / a.first; }\ntemplate <class T> inline\
    \ ld abs(const PP<T>& a){ return std::hypotl(a.first, a.second); }\ntemplate <class\
    \ T> inline T lcm(const PP<T>& a){ return std::lcm(a.first, a.second); }\ntemplate\
    \ <class T> inline T gcd(const PP<T>& a){ return std::gcd(a.first, a.second);\
    \ }\ntemplate <class T> inline PP<T> extgcd(const PP<T> &p) {\n    T x=1,y=0,t1=0,t2=0,t3=1,a,b;\n\
    \    std::tie(a,b)=p;\n    while(b) {\n        t1=a/b,a-=t1*b;\n        std::swap(a,b);\n\
    \        x-=t1*t2;\n        std::swap(x,t2);\n        y-=t1*t3;\n        std::swap(y,t3);\n\
    \    }\n    return {x,y};\n}\ntemplate <class T> inline PP<T> normalize(PP<T>\
    \ a) {\n    if(a == PP<T>{}) return a;\n    a /= gcd(a);\n    if(a < PP<T>{})\
    \ a = -a;\n    return a;\n}\ntemplate <class T, class U> inline P<U,T> swap(const\
    \ P<T,U> &p){ P<U,T> ret={p.second,p.first}; return ret; }\ntemplate <class T,\
    \ class U> inline vectors::V<P<U,T>> swap(const vectors::V<P<T,U>> &vp) {\n  \
    \  vectors::V<P<U,T>> ret;\n    for(const auto &el: vp) ret.emplace_back(swap(el));\n\
    \    return ret;\n}\ntemplate <class T, class U> inline vectors::V<T> first(const\
    \ vectors::V<P<T,U>> &vp) {\n    vectors::V<T> res;\n    for(const auto &el: vp)\
    \ res.emplace_back(el.first);\n    return res;\n}\ntemplate <class T, class U>\
    \ inline vectors::V<U> second(const vectors::V<P<T,U>> &vp) {\n    vectors::V<U>\
    \ res;\n    for(const auto &el: vp) res.emplace_back(el.second);\n    return res;\n\
    }\n} // pairs\n#line 4 \"C++/math/primefactor.hpp\"\nnamespace Heileden {\ntemplate\
    \ <class T> inline vectors::V<pairs::PP<T>> prmfct(T n) {\n    vectors::V<pairs::PP<T>>\
    \ res;\n    for(T i = 2; i * i <= n; ++i) {\n        if(n%i!=0) continue;\n  \
    \      T tmp=0;\n        while(n%i==0) {\n            tmp++;\n            n/=i;\n\
    \        }\n        res.emplace_back(i,tmp);\n    }\n    if(n!=1) res.emplace_back(n,1);\n\
    \    return res;\n}\n}\n\n/**\n * @brief \u7D20\u56E0\u6570\u5206\u89E3\n */\n"
  code: "#pragma once\n\n#include \"C++/mypair.hpp\"\nnamespace Heileden {\ntemplate\
    \ <class T> inline vectors::V<pairs::PP<T>> prmfct(T n) {\n    vectors::V<pairs::PP<T>>\
    \ res;\n    for(T i = 2; i * i <= n; ++i) {\n        if(n%i!=0) continue;\n  \
    \      T tmp=0;\n        while(n%i==0) {\n            tmp++;\n            n/=i;\n\
    \        }\n        res.emplace_back(i,tmp);\n    }\n    if(n!=1) res.emplace_back(n,1);\n\
    \    return res;\n}\n}\n\n/**\n * @brief \u7D20\u56E0\u6570\u5206\u89E3\n */"
  dependsOn:
  - C++/mypair.hpp
  - C++/constance.hpp
  - C++/myvector.hpp
  isVerificationFile: false
  path: C++/math/primefactor.hpp
  requiredBy:
  - C++/template.hpp
  timestamp: '2024-02-22 09:22:35+09:00'
  verificationStatus: LIBRARY_SOME_WA
  verifiedWith:
  - test/C++/sr_sum.test.cpp
  - test/C++/m_add.test.cpp
  - test/C++/add.test.cpp
  - test/C++/parsum.test.cpp
  - test/C++/segtree.test.cpp
  - test/C++/stable.test.cpp
  - test/C++/fwtree.test.cpp
  - test/C++/uf.test.cpp
  - test/C++/extgcd.test.cpp
  - test/C++/add128.test.cpp
  - test/C++/s_rmq.test.cpp
  - test/C++/aarray.test.cpp
documentation_of: C++/math/primefactor.hpp
layout: document
redirect_from:
- /library/C++/math/primefactor.hpp
- /library/C++/math/primefactor.hpp.html
title: "\u7D20\u56E0\u6570\u5206\u89E3"
---
