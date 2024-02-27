---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/constance.hpp
    title: "\u5B9A\u6570"
  - icon: ':heavy_check_mark:'
    path: C++/mypair.hpp
    title: C++/mypair.hpp
  - icon: ':heavy_check_mark:'
    path: C++/myvector.hpp
    title: C++/myvector.hpp
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
    path: test/m_add.test.cpp
    title: test/m_add.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/sr_sum.test.cpp
    title: test/sr_sum.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: "\u51FA\u529B"
    links: []
  bundledCode: "#line 2 \"C++/io/output.hpp\"\n\n#include <iostream>\n#include <map>\n\
    #include <set>\n#include <deque>\n#line 2 \"C++/mypair.hpp\"\n\n#include <cassert>\n\
    #include <utility>\n#include <tuple>\n#include <cmath>\n#include <numeric>\n#line\
    \ 2 \"C++/constance.hpp\"\n\n#include <limits>\n#ifndef TEMPLATE\nusing ll = long\
    \ long;\nusing ld = long double;\n#endif\ntemplate <class T> using L = std::numeric_limits<T>;\n\
    constexpr int dx[] = {0, 0, 0, -1, 1, -1, -1, 1, 1};\nconstexpr int dy[] = {0,\
    \ -1, 1, 0, 0, -1, 1, -1, 1};\nconstexpr int MOD = 0x3b800001;\nconstexpr int\
    \ M0D = 1e9 + 7;\nconstexpr int INF = 1 << 30;\nconstexpr ll LINF = (1LL << 61)\
    \ - 1;\nconstexpr ld DINF = L<ld>::infinity();\ntemplate <class T> constexpr T\
    \ LIM = L<T>::max();\n#if __cplusplus >= 202100L\n#include <numbers>\nconstexpr\
    \ ld PI = std::numbers::pi;\nconstexpr ld E = std::numbers::e;\n#else\n#line 23\
    \ \"C++/constance.hpp\"\nconst ld PI = std::acos(-1);\nconst ld E = 2.718281828459045;\n\
    #endif\n\n/**\n * @brief \u5B9A\u6570\n */\n#line 2 \"C++/myvector.hpp\"\n\n#include\
    \ <vector>\n\n#ifndef TEMPLATE\ntypedef long long ll;\ntypedef unsigned long long\
    \ ul;\ntypedef long double ld;\n#endif\nnamespace vectors {\ntemplate <class T>\
    \ using V = std::vector<T>;\nusing vi = V<ll>;\nusing vu = V<ul>;\nusing vd =\
    \ V<ld>;\nusing vc = V<char>;\nusing vs = V<std::string>;\nusing vb = V<bool>;\n\
    using wi = V<vi>;\nusing wu = V<vu>;\nusing wd = V<vd>;\nusing wc = V<vc>;\nusing\
    \ ws = V<vs>;\nusing wb = V<vb>;\ntemplate <class T, class U> inline V<U> ndiv(T&&\
    \ n, U&& v) noexcept {\n  return V<U>(std::forward<T>(n), std::forward<U>(v));\n\
    }\ntemplate <class T, class... Ts> inline decltype(auto) ndiv(T&& n, Ts&&... v)\
    \ noexcept {\n  return V<decltype(ndiv(std::forward<Ts>(v)...))>(std::forward<T>(n),\
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
    }\n} // pairs\n#line 8 \"C++/io/output.hpp\"\n#ifndef TEMPLATE\nusing i128 = __int128_t;\n\
    using u128 = __uint128_t;\n#endif\nnamespace IO {\nstd::ostream &operator<<(std::ostream\
    \ &dest, const i128 &value) {\n    std::ostream::sentry s(dest);\n    if(s) {\n\
    \        u128 tmp = value < 0 ? -value : value;\n        char buffer[128];\n \
    \       char *d = std::end(buffer);\n        do {\n            --d;\n        \
    \    *d = \"0123456789\"[tmp % 10];\n            tmp /= 10;\n        } while(tmp\
    \ != 0);\n        if(value < 0) {\n            --d;\n            *d = '-';\n \
    \       }\n        int len = std::end(buffer) - d;\n        if(dest.rdbuf() ->\
    \ sputn(d, len) != len) {\n            dest.setstate(std::ios_base::badbit);\n\
    \        }\n    }\n    return dest;\n}\ntemplate <class T, class U> std::ostream&\
    \ operator<<(std::ostream &os, const pairs::P<T, U> &p){ os << p.first << ' '\
    \ << p.second; return os; }\ntemplate <class T, size_t N> std::ostream& operator<<(std::ostream\
    \ &os, const std::array<T, N> &a){ if(a.size()){ os << a.front(); for(auto i=a.begin();\
    \ ++i!=a.end();){ os << ' ' << *i; } } return os; }\ntemplate <class T> std::ostream&\
    \ operator<<(std::ostream &os, const vectors::V<T> &v){ if(v.size()){ os << v.front();\
    \ for(auto i=v.begin(); ++i!=v.end();){ os << ' ' << *i; } } return os; }\ntemplate\
    \ <class K, class V> std::ostream& operator<<(std::ostream &os, const std::map<K,\
    \ V> &m){ if(m.size()){ os << m.begin()->first << ' ' << m.begin()->second; for(auto\
    \ i=m.begin(); ++i!=m.end();){ os << '\\n' << i->first << ' ' << i->second; }\
    \ } return os; }\ntemplate <class T> std::ostream& operator<<(std::ostream &os,\
    \ const std::set<T> &st){ if(st.size()){ os << *st.begin(); for(auto i=st.begin();\
    \ ++i!=st.end();){ os << ' ' << *i; } } return os; }\ntemplate <class T> std::ostream&\
    \ operator<<(std::ostream &os, const std::multiset<T> &ms){ if(ms.size()){ os\
    \ << *ms.begin(); for(auto i=ms.begin(); ++i!=ms.end();){ os << ' ' << *i; } }\
    \ return os; }\ntemplate <class T> std::ostream& operator<<(std::ostream &os,\
    \ const std::deque<T> &dq){ if(dq.size()){ os << dq.front(); for(auto i=dq.begin();\
    \ ++i!=dq.end();){ os << ' ' << *i; } } return os; }\ninline void out(){ std::cout\
    \ << '\\n'; }\ntemplate <bool flush=false, class T> inline void out(const T& x){\
    \ std::cout << x << '\\n'; if(flush) std::cout.flush(); }\ntemplate <bool flush=false,\
    \ class Head, class... Tail> inline void out(const Head& head, const Tail&...\
    \ tail){ std::cout << head << ' '; out<flush>(tail...); }\ntemplate <bool flush=false,\
    \ class T> inline void vout(const T& v){ std::cout << v << '\\n'; if(flush) std::cout.flush();\
    \ }\ntemplate <bool flush=false, class T> inline void vout(const vectors::V<T>&\
    \ v){ for(const auto &el: v) std::cout << el << '\\n'; if(flush) std::cout.flush();\
    \ }\ntemplate <bool flush=false, class Head, class... Tail> inline void vout(const\
    \ Head& head, const Tail&... tail){ std::cout << head << '\\n'; vout<flush>(tail...);\
    \ }\n\n#define fin(...) do{ out(__VA_ARGS__); return; }while(false)\n} // IO\n\
    \n/**\n * @brief \u51FA\u529B\n */\n"
  code: "#pragma once\n\n#include <iostream>\n#include <map>\n#include <set>\n#include\
    \ <deque>\n#include \"C++/mypair.hpp\"\n#ifndef TEMPLATE\nusing i128 = __int128_t;\n\
    using u128 = __uint128_t;\n#endif\nnamespace IO {\nstd::ostream &operator<<(std::ostream\
    \ &dest, const i128 &value) {\n    std::ostream::sentry s(dest);\n    if(s) {\n\
    \        u128 tmp = value < 0 ? -value : value;\n        char buffer[128];\n \
    \       char *d = std::end(buffer);\n        do {\n            --d;\n        \
    \    *d = \"0123456789\"[tmp % 10];\n            tmp /= 10;\n        } while(tmp\
    \ != 0);\n        if(value < 0) {\n            --d;\n            *d = '-';\n \
    \       }\n        int len = std::end(buffer) - d;\n        if(dest.rdbuf() ->\
    \ sputn(d, len) != len) {\n            dest.setstate(std::ios_base::badbit);\n\
    \        }\n    }\n    return dest;\n}\ntemplate <class T, class U> std::ostream&\
    \ operator<<(std::ostream &os, const pairs::P<T, U> &p){ os << p.first << ' '\
    \ << p.second; return os; }\ntemplate <class T, size_t N> std::ostream& operator<<(std::ostream\
    \ &os, const std::array<T, N> &a){ if(a.size()){ os << a.front(); for(auto i=a.begin();\
    \ ++i!=a.end();){ os << ' ' << *i; } } return os; }\ntemplate <class T> std::ostream&\
    \ operator<<(std::ostream &os, const vectors::V<T> &v){ if(v.size()){ os << v.front();\
    \ for(auto i=v.begin(); ++i!=v.end();){ os << ' ' << *i; } } return os; }\ntemplate\
    \ <class K, class V> std::ostream& operator<<(std::ostream &os, const std::map<K,\
    \ V> &m){ if(m.size()){ os << m.begin()->first << ' ' << m.begin()->second; for(auto\
    \ i=m.begin(); ++i!=m.end();){ os << '\\n' << i->first << ' ' << i->second; }\
    \ } return os; }\ntemplate <class T> std::ostream& operator<<(std::ostream &os,\
    \ const std::set<T> &st){ if(st.size()){ os << *st.begin(); for(auto i=st.begin();\
    \ ++i!=st.end();){ os << ' ' << *i; } } return os; }\ntemplate <class T> std::ostream&\
    \ operator<<(std::ostream &os, const std::multiset<T> &ms){ if(ms.size()){ os\
    \ << *ms.begin(); for(auto i=ms.begin(); ++i!=ms.end();){ os << ' ' << *i; } }\
    \ return os; }\ntemplate <class T> std::ostream& operator<<(std::ostream &os,\
    \ const std::deque<T> &dq){ if(dq.size()){ os << dq.front(); for(auto i=dq.begin();\
    \ ++i!=dq.end();){ os << ' ' << *i; } } return os; }\ninline void out(){ std::cout\
    \ << '\\n'; }\ntemplate <bool flush=false, class T> inline void out(const T& x){\
    \ std::cout << x << '\\n'; if(flush) std::cout.flush(); }\ntemplate <bool flush=false,\
    \ class Head, class... Tail> inline void out(const Head& head, const Tail&...\
    \ tail){ std::cout << head << ' '; out<flush>(tail...); }\ntemplate <bool flush=false,\
    \ class T> inline void vout(const T& v){ std::cout << v << '\\n'; if(flush) std::cout.flush();\
    \ }\ntemplate <bool flush=false, class T> inline void vout(const vectors::V<T>&\
    \ v){ for(const auto &el: v) std::cout << el << '\\n'; if(flush) std::cout.flush();\
    \ }\ntemplate <bool flush=false, class Head, class... Tail> inline void vout(const\
    \ Head& head, const Tail&... tail){ std::cout << head << '\\n'; vout<flush>(tail...);\
    \ }\n\n#define fin(...) do{ out(__VA_ARGS__); return; }while(false)\n} // IO\n\
    \n/**\n * @brief \u51FA\u529B\n */"
  dependsOn:
  - C++/mypair.hpp
  - C++/constance.hpp
  - C++/myvector.hpp
  isVerificationFile: false
  path: C++/io/output.hpp
  requiredBy:
  - C++/template.hpp
  timestamp: '2024-02-22 09:22:35+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/sr_sum.test.cpp
  - test/m_add.test.cpp
  - test/add.test.cpp
  - test/extgcd.test.cpp
  - test/add128_2.test.cpp
  - test/add128.test.cpp
  - test/aarray.test.cpp
documentation_of: C++/io/output.hpp
layout: document
redirect_from:
- /library/C++/io/output.hpp
- /library/C++/io/output.hpp.html
title: "\u51FA\u529B"
---
