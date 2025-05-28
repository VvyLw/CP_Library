---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/core/constance.hpp
    title: "\u5B9A\u6570"
  - icon: ':heavy_check_mark:'
    path: C++/core/mypair.hpp
    title: C++/core/mypair.hpp
  - icon: ':heavy_check_mark:'
    path: C++/core/myvector.hpp
    title: C++/core/myvector.hpp
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
    path: test/add128_2.test.cpp
    title: test/add128_2.test.cpp
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
    document_title: "\u5165\u529B"
    links: []
  bundledCode: "#line 2 \"C++/core/io/input.hpp\"\n\n#include <iostream>\n#include\
    \ <cassert>\n#include <deque>\n#line 2 \"C++/core/mypair.hpp\"\n\n#line 4 \"C++/core/mypair.hpp\"\
    \n#include <utility>\n#include <tuple>\n#include <cmath>\n#include <numeric>\n\
    #line 2 \"C++/core/constance.hpp\"\n\n#include <limits>\n#ifndef TEMPLATE\nusing\
    \ ll = long long;\nusing ld = long double;\n#endif\ntemplate <class T> using L\
    \ = std::numeric_limits<T>;\nconstexpr int dx[] = {0, 0, 0, -1, 1, -1, -1, 1,\
    \ 1};\nconstexpr int dy[] = {0, -1, 1, 0, 0, -1, 1, -1, 1};\nconstexpr int MOD\
    \ = 0x3b800001;\nconstexpr int M0D = 1e9 + 7;\nconstexpr int INF = 1 << 30;\n\
    constexpr ll LINF = (1LL << 61) - 1;\nconstexpr ld DINF = L<ld>::infinity();\n\
    template <class T> constexpr T LIM = L<T>::max();\n#if __cplusplus >= 202100L\n\
    #include <numbers>\nconstexpr ld PI = std::numbers::pi;\nconstexpr ld E = std::numbers::e;\n\
    #else\n#line 23 \"C++/core/constance.hpp\"\nconst ld PI = std::acos(-1);\nconst\
    \ ld E = 2.718281828459045;\n#endif\n\n/**\n * @brief \u5B9A\u6570\n */\n#line\
    \ 2 \"C++/core/myvector.hpp\"\n\n#include <vector>\n\n#ifndef TEMPLATE\ntypedef\
    \ long long ll;\ntypedef unsigned long long ul;\ntypedef long double ld;\n#endif\n\
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
    \ 10 \"C++/core/mypair.hpp\"\nnamespace pairs {\ntemplate <class T, class U> using\
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
    }\n} // pairs\n#line 7 \"C++/core/io/input.hpp\"\n#ifndef TEMPLATE\ntypedef unsigned\
    \ long long ul;\ntypedef __int128_t i128;\nnamespace zia_qu {\ninline bool isdigit(const\
    \ char c){ return std::isdigit(c); }\ninline bool isdigit(const std::string &s){\
    \ bool ok=1, neg=s.front()=='-'; for(const auto &el: s){ if(neg){ neg=0; continue;\
    \ } ok&=isdigit(el); } return ok; }\n}\n#endif\nnamespace IO {\ntemplate <class\
    \ T, class U> std::istream& operator>>(std::istream &is, pairs::P<T, U> &p){ is\
    \ >> p.first >> p.second; return is; }\ntemplate <class T, size_t N> std::istream&\
    \ operator>>(std::istream &is, std::array<T, N> &a){ for(auto &el: a) is >> el;\
    \ return is; }\ntemplate <class T> std::istream& operator>>(std::istream &is,\
    \ vectors::V<T> &v){ for(auto &el: v) is >> el; return is; }\ntemplate <class\
    \ T> std::istream& operator>>(std::istream &is, std::deque<T> &dq){ for(auto &el:\
    \ dq) is >> el; return is; }\ntemplate <class T> inline bool in(T& x){ std::cin\
    \ >> x; return 1; }\ntemplate <class Head, class... Tail> inline bool in(Head&\
    \ head, Tail&... tail){ in(head); in(tail...); return 1; }\n\ninline i128 to_i128(const\
    \ std::string &s) noexcept {\n    assert(zia_qu::isdigit(s));\n    bool neg=s.front()=='-';\n\
    \    i128 ret = 0;\n    for(const auto &el: s) {\n        if(neg) {\n        \
    \    neg=0;\n            continue;\n        }\n        ret = 10 * ret + el - '0';\n\
    \    }\n    if(s.front()=='-') ret=-ret;\n    return ret;\n}\n\n#define INT(...)\
    \ int __VA_ARGS__; in(__VA_ARGS__)\n#define LL(...) ll __VA_ARGS__; in(__VA_ARGS__)\n\
    #define UL(...) ul __VA_ARGS__; in(__VA_ARGS__)\n#define LD(...) ld __VA_ARGS__;\
    \ in(__VA_ARGS__)\n#define CHR(...) char __VA_ARGS__; in(__VA_ARGS__)\n#define\
    \ STR(...) std::string __VA_ARGS__; in(__VA_ARGS__)\n#define VEC(type,name,size)\
    \ vectors::V<type> name(size); in(name)\n#define WEC(type,name,h,w) vectors::V<vectors::V<type>>\
    \ name(h,vectors::V<type>(w)); in(name)\n} // IO\n\n/**\n * @brief \u5165\u529B\
    \n */\n"
  code: "#pragma once\n\n#include <iostream>\n#include <cassert>\n#include <deque>\n\
    #include \"C++/core/mypair.hpp\"\n#ifndef TEMPLATE\ntypedef unsigned long long\
    \ ul;\ntypedef __int128_t i128;\nnamespace zia_qu {\ninline bool isdigit(const\
    \ char c){ return std::isdigit(c); }\ninline bool isdigit(const std::string &s){\
    \ bool ok=1, neg=s.front()=='-'; for(const auto &el: s){ if(neg){ neg=0; continue;\
    \ } ok&=isdigit(el); } return ok; }\n}\n#endif\nnamespace IO {\ntemplate <class\
    \ T, class U> std::istream& operator>>(std::istream &is, pairs::P<T, U> &p){ is\
    \ >> p.first >> p.second; return is; }\ntemplate <class T, size_t N> std::istream&\
    \ operator>>(std::istream &is, std::array<T, N> &a){ for(auto &el: a) is >> el;\
    \ return is; }\ntemplate <class T> std::istream& operator>>(std::istream &is,\
    \ vectors::V<T> &v){ for(auto &el: v) is >> el; return is; }\ntemplate <class\
    \ T> std::istream& operator>>(std::istream &is, std::deque<T> &dq){ for(auto &el:\
    \ dq) is >> el; return is; }\ntemplate <class T> inline bool in(T& x){ std::cin\
    \ >> x; return 1; }\ntemplate <class Head, class... Tail> inline bool in(Head&\
    \ head, Tail&... tail){ in(head); in(tail...); return 1; }\n\ninline i128 to_i128(const\
    \ std::string &s) noexcept {\n    assert(zia_qu::isdigit(s));\n    bool neg=s.front()=='-';\n\
    \    i128 ret = 0;\n    for(const auto &el: s) {\n        if(neg) {\n        \
    \    neg=0;\n            continue;\n        }\n        ret = 10 * ret + el - '0';\n\
    \    }\n    if(s.front()=='-') ret=-ret;\n    return ret;\n}\n\n#define INT(...)\
    \ int __VA_ARGS__; in(__VA_ARGS__)\n#define LL(...) ll __VA_ARGS__; in(__VA_ARGS__)\n\
    #define UL(...) ul __VA_ARGS__; in(__VA_ARGS__)\n#define LD(...) ld __VA_ARGS__;\
    \ in(__VA_ARGS__)\n#define CHR(...) char __VA_ARGS__; in(__VA_ARGS__)\n#define\
    \ STR(...) std::string __VA_ARGS__; in(__VA_ARGS__)\n#define VEC(type,name,size)\
    \ vectors::V<type> name(size); in(name)\n#define WEC(type,name,h,w) vectors::V<vectors::V<type>>\
    \ name(h,vectors::V<type>(w)); in(name)\n} // IO\n\n/**\n * @brief \u5165\u529B\
    \n */"
  dependsOn:
  - C++/core/mypair.hpp
  - C++/core/constance.hpp
  - C++/core/myvector.hpp
  isVerificationFile: false
  path: C++/core/io/input.hpp
  requiredBy:
  - C++/template.hpp
  timestamp: '2024-08-31 20:28:31+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/aarray.test.cpp
  - test/m_add.test.cpp
  - test/sr_sum.test.cpp
  - test/uf.test.cpp
  - test/add128.test.cpp
  - test/parsum.test.cpp
  - test/add128_2.test.cpp
  - test/extgcd.test.cpp
  - test/stable.test.cpp
  - test/fwtree.test.cpp
  - test/segtree.test.cpp
  - test/add.test.cpp
  - test/s_rmq.test.cpp
documentation_of: C++/core/io/input.hpp
layout: document
redirect_from:
- /library/C++/core/io/input.hpp
- /library/C++/core/io/input.hpp.html
title: "\u5165\u529B"
---
