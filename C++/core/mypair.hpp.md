---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: C++/core/alias.hpp
    title: "\u30A8\u30A4\u30EA\u30A2\u30B9"
  - icon: ':x:'
    path: C++/core/myvector.hpp
    title: C++/core/myvector.hpp
  _extendedRequiredBy:
  - icon: ':x:'
    path: C++/template.hpp
    title: "\u30C6\u30F3\u30D7\u30EC\u30FC\u30C8"
  _extendedVerifiedWith:
  - icon: ':x:'
    path: test/aarray.test.cpp
    title: test/aarray.test.cpp
  - icon: ':x:'
    path: test/add.test.cpp
    title: test/add.test.cpp
  - icon: ':x:'
    path: test/add128.test.cpp
    title: test/add128.test.cpp
  - icon: ':x:'
    path: test/extgcd.test.cpp
    title: test/extgcd.test.cpp
  - icon: ':x:'
    path: test/fwtree.test.cpp
    title: test/fwtree.test.cpp
  - icon: ':x:'
    path: test/m_add.test.cpp
    title: test/m_add.test.cpp
  - icon: ':x:'
    path: test/parsum.test.cpp
    title: test/parsum.test.cpp
  - icon: ':x:'
    path: test/s_rmq.test.cpp
    title: test/s_rmq.test.cpp
  - icon: ':x:'
    path: test/segtree.test.cpp
    title: test/segtree.test.cpp
  - icon: ':x:'
    path: test/sr_sum.test.cpp
    title: test/sr_sum.test.cpp
  - icon: ':x:'
    path: test/stable.test.cpp
    title: test/stable.test.cpp
  - icon: ':x:'
    path: test/uf.test.cpp
    title: test/uf.test.cpp
  _isVerificationFailed: true
  _pathExtension: hpp
  _verificationStatusIcon: ':x:'
  attributes:
    links: []
  bundledCode: "#line 2 \"C++/core/mypair.hpp\"\n\n#include <cassert>\n#include <utility>\n\
    #include <tuple>\n#include <cmath>\n#include <numeric>\n#line 2 \"C++/core/alias.hpp\"\
    \n\n#ifndef ALIAS\n#define ALIAS\n#endif\n\n#include <limits>\n#include <numbers>\n\
    #include <queue>\n#include <ext/pb_ds/assoc_container.hpp>\n#include <ext/pb_ds/tree_policy.hpp>\n\
    \nconstexpr int dx[] = {0, 0, 0, -1, 1, -1, -1, 1, 1};\nconstexpr int dy[] = {0,\
    \ -1, 1, 0, 0, -1, 1, -1, 1};\nconstexpr int MOD = 0x3b800001;\nconstexpr int\
    \ M0D = 1e9 + 7;\nconstexpr int INF = 1 << 30;\nconstexpr int64_t LINF = (1LL\
    \ << 61) - 1;\nconstexpr long double DINF = std::numeric_limits<long double>::infinity();\n\
    template <class T> constexpr T LIM = std::numeric_limits<T>::max();\nconstexpr\
    \ long double PI = std::numbers::pi;\nconstexpr long double E = std::numbers::e;\n\
    \ntypedef int64_t i64;\ntypedef long double ld;\ntypedef uint32_t u32;\ntypedef\
    \ uint64_t u64;\ntypedef __int128_t i128;\ntypedef __uint128_t u128;\n#ifdef MODINT\n\
    typedef man::Modint<MOD> mint;\ntypedef man::Modint<M0D> Mint;\n#endif\n#ifdef\
    \ ROLLING_HASH\ntypedef man::RollingHash<LINF> RH;\n#endif\ntemplate <size_t N>\
    \ using ti = std::array<i64, N>;\ntypedef ti<3> tri;\ntemplate <class T> using\
    \ pq = std::priority_queue<T>;\ntemplate <class T> using pqr = std::priority_queue<T,\
    \ std::vector<T>, std::greater<T>>;\ntemplate <class T> using Tree = __gnu_pbds::tree<T,\
    \ __gnu_pbds::null_type, std::less<T>, __gnu_pbds::rb_tree_tag, __gnu_pbds::tree_order_statistics_node_update>;\n\
    template <class T> using TREE = __gnu_pbds::tree<T, __gnu_pbds::null_type, std::greater<T>,\
    \ __gnu_pbds::rb_tree_tag, __gnu_pbds::tree_order_statistics_node_update>;\n\n\
    /**\n * @brief \u30A8\u30A4\u30EA\u30A2\u30B9\n */\n#line 2 \"C++/core/myvector.hpp\"\
    \n\n#include <vector>\n\nnamespace man {\nnamespace vec {\ntemplate <class T>\
    \ using V = std::vector<T>;\ntypedef V<int64_t> zhl;\ntypedef V<uint64_t> uzhl;\n\
    typedef V<long double> dec;\ntypedef V<char> chr;\ntypedef V<std::string> str;\n\
    typedef V<bool> bol;\ntypedef V<vi> zhl2;\ntypedef V<vu> uzhl2;\ntypedef V<vd>\
    \ dec2;\ntypedef V<vc> chr2;\ntypedef V<vs> str2;\ntypedef V<vb> bol2;\n#ifdef\
    \ EDGE\ntypedef V<man::edge> edg;\ntypedef V<ve> edg2;\n#endif\ntemplate <class\
    \ T, class U> inline V<U> ndiv(T&& n, U&& v) noexcept {\n  return V<U>(std::forward<T>(n),\
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
    \ const U x) noexcept { V<T> res = v; res%=x; return res; }\n}\n}\n#line 10 \"\
    C++/core/mypair.hpp\"\nnamespace man {\nnamespace pav {\ntemplate <class T, class\
    \ U> using P = std::pair<T, U>;\ntemplate <class T> using PP = P<T, T>;\ntypedef\
    \ PP<int64_t> zhl;\ntypedef PP<long double> dec;\ntypedef PP<char> chr;\ntypedef\
    \ PP<std::string> str;\ntemplate <class T> constexpr PP<T> operator+(const PP<T>&\
    \ a, const PP<T>& b) noexcept { return {a.first + b.first, a.second + b.second};\
    \ }\ntemplate <class T> constexpr PP<T> operator-(const PP<T>& a, const PP<T>&\
    \ b) noexcept { return {a.first - b.first, a.second - b.second}; }\ntemplate <class\
    \ T> constexpr PP<T> operator-(const PP<T>& a) noexcept { return {-a.first, -a.second};\
    \ }\ntemplate <class T, class U> constexpr PP<T> operator*(const PP<T>& a, const\
    \ U& b) noexcept { return {a.first * b, a.second * b}; }\ntemplate <class T, class\
    \ U> constexpr PP<T> operator/(const PP<T>& a, const U& b) noexcept { return {a.first\
    \ / b, a.second / b}; }\ntemplate <class T> constexpr PP<T>& operator+=(PP<T>&\
    \ a, const PP<T>& b) noexcept { return a = a + b; }\ntemplate <class T> constexpr\
    \ PP<T>& operator-=(PP<T>& a, const PP<T>& b) noexcept { return a = a - b; }\n\
    template <class T, class U> constexpr PP<T>& operator*=(PP<T>& a, const U& b)\
    \ noexcept { return a = a * b; }\ntemplate <class T, class U> PP<T>& operator/=(PP<T>&\
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
    \ <class T> constexpr inline PP<T> rotate(const PP<T>& a) noexcept { return {-a.second,\
    \ a.first}; } // 90 degree ccw\ntemplate <class T> constexpr inline pd rotate(const\
    \ PP<T>& a, const int ang) noexcept {\n    assert(0 <= ang && ang < 360);\n  \
    \  const long double rad = PI * ang / 180;\n    return {a.first * std::cos(rad)\
    \ - a.second * std::sin(rad), a.first * std::sin(rad) + a.second * std::cos(rad)};\n\
    }\ntemplate <class T> constexpr inline T dot(const PP<T>& a, const PP<T>& b) noexcept\
    \ { return a.first * b.first + a.second * b.second; }\ntemplate <class T> constexpr\
    \ inline T cross(const PP<T>& a, const PP<T>& b) noexcept { return dot(rotate(a),\
    \ b); }\ntemplate <class T> constexpr inline T square(const PP<T>& a) noexcept\
    \ { return dot(a, a); }\ntemplate <class T> constexpr inline long double grad(const\
    \ PP<T>& a) noexcept { assert(a.first != 0); return 1.0L * a.second / a.first;\
    \ }\ntemplate <class T> constexpr inline long double abs(const PP<T>& a) noexcept\
    \ { return std::hypotl(a.first, a.second); }\ntemplate <class T> constexpr inline\
    \ T lcm(const PP<T>& a) noexcept { return std::lcm(a.first, a.second); }\ntemplate\
    \ <class T> constexpr inline T gcd(const PP<T>& a) noexcept { return std::gcd(a.first,\
    \ a.second); }\ntemplate <class T> constexpr inline PP<T> extgcd(const PP<T> &p)\
    \ noexcept {\n    T x = 1, y = 0, t1 = 0, t2 = 0, t3 = 1, a, b;\n    std::tie(a,b)\
    \ = p;\n    while(b > 0) {\n        t1 = a / b, a -= t1 * b;\n        std::swap(a,\
    \ b);\n        x -= t1 * t2;\n        std::swap(x, t2);\n        y -= t1 * t3;\n\
    \        std::swap(y, t3);\n    }\n    return {x, y};\n}\ntemplate <class T> constexpr\
    \ inline PP<T> normalize(PP<T> a) noexcept {\n    if(a == PP<T>{}) {\n       \
    \ return a;\n    }\n    a /= gcd(a);\n    if(a < PP<T>{}) {\n        a = -a;\n\
    \    }\n    return a;\n}\ntemplate <class T, class U> constexpr inline P<U, T>\
    \ swap(const P<T, U> &p) noexcept { const P<U, T> ret = {p.second, p.first}; return\
    \ ret; }\ntemplate <class T, class U> inline std::vector<P<U, T>> swap(const std::vector<P<T,\
    \ U>> &vp) noexcept {\n    std::vector<P<U, T>> ret;\n    for(const auto &el:\
    \ vp) {\n        ret.emplace_back(swap(el));\n    }\n    return ret;\n}\ntemplate\
    \ <class T, class U> inline std::vector<T> first(const std::vector<P<T, U>> &vp)\
    \ noexcept {\n    std::vector<T> ret;\n    for(const auto &el: vp) {\n       \
    \ ret.emplace_back(el.first);\n    }\n    return ret;\n}\ntemplate <class T, class\
    \ U> inline std::vector<U> second(const std::vector<P<T, U>> &vp) noexcept {\n\
    \    std::vector<U> ret;\n    for(const auto &el: vp) {\n        ret.emplace_back(el.second);\n\
    \    }\n    return ret;\n}\n}\n}\n"
  code: "#pragma once\n\n#include <cassert>\n#include <utility>\n#include <tuple>\n\
    #include <cmath>\n#include <numeric>\n#include \"C++/core/alias.hpp\"\n#include\
    \ \"C++/core/myvector.hpp\"\nnamespace man {\nnamespace pav {\ntemplate <class\
    \ T, class U> using P = std::pair<T, U>;\ntemplate <class T> using PP = P<T, T>;\n\
    typedef PP<int64_t> zhl;\ntypedef PP<long double> dec;\ntypedef PP<char> chr;\n\
    typedef PP<std::string> str;\ntemplate <class T> constexpr PP<T> operator+(const\
    \ PP<T>& a, const PP<T>& b) noexcept { return {a.first + b.first, a.second + b.second};\
    \ }\ntemplate <class T> constexpr PP<T> operator-(const PP<T>& a, const PP<T>&\
    \ b) noexcept { return {a.first - b.first, a.second - b.second}; }\ntemplate <class\
    \ T> constexpr PP<T> operator-(const PP<T>& a) noexcept { return {-a.first, -a.second};\
    \ }\ntemplate <class T, class U> constexpr PP<T> operator*(const PP<T>& a, const\
    \ U& b) noexcept { return {a.first * b, a.second * b}; }\ntemplate <class T, class\
    \ U> constexpr PP<T> operator/(const PP<T>& a, const U& b) noexcept { return {a.first\
    \ / b, a.second / b}; }\ntemplate <class T> constexpr PP<T>& operator+=(PP<T>&\
    \ a, const PP<T>& b) noexcept { return a = a + b; }\ntemplate <class T> constexpr\
    \ PP<T>& operator-=(PP<T>& a, const PP<T>& b) noexcept { return a = a - b; }\n\
    template <class T, class U> constexpr PP<T>& operator*=(PP<T>& a, const U& b)\
    \ noexcept { return a = a * b; }\ntemplate <class T, class U> PP<T>& operator/=(PP<T>&\
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
    \ <class T> constexpr inline PP<T> rotate(const PP<T>& a) noexcept { return {-a.second,\
    \ a.first}; } // 90 degree ccw\ntemplate <class T> constexpr inline pd rotate(const\
    \ PP<T>& a, const int ang) noexcept {\n    assert(0 <= ang && ang < 360);\n  \
    \  const long double rad = PI * ang / 180;\n    return {a.first * std::cos(rad)\
    \ - a.second * std::sin(rad), a.first * std::sin(rad) + a.second * std::cos(rad)};\n\
    }\ntemplate <class T> constexpr inline T dot(const PP<T>& a, const PP<T>& b) noexcept\
    \ { return a.first * b.first + a.second * b.second; }\ntemplate <class T> constexpr\
    \ inline T cross(const PP<T>& a, const PP<T>& b) noexcept { return dot(rotate(a),\
    \ b); }\ntemplate <class T> constexpr inline T square(const PP<T>& a) noexcept\
    \ { return dot(a, a); }\ntemplate <class T> constexpr inline long double grad(const\
    \ PP<T>& a) noexcept { assert(a.first != 0); return 1.0L * a.second / a.first;\
    \ }\ntemplate <class T> constexpr inline long double abs(const PP<T>& a) noexcept\
    \ { return std::hypotl(a.first, a.second); }\ntemplate <class T> constexpr inline\
    \ T lcm(const PP<T>& a) noexcept { return std::lcm(a.first, a.second); }\ntemplate\
    \ <class T> constexpr inline T gcd(const PP<T>& a) noexcept { return std::gcd(a.first,\
    \ a.second); }\ntemplate <class T> constexpr inline PP<T> extgcd(const PP<T> &p)\
    \ noexcept {\n    T x = 1, y = 0, t1 = 0, t2 = 0, t3 = 1, a, b;\n    std::tie(a,b)\
    \ = p;\n    while(b > 0) {\n        t1 = a / b, a -= t1 * b;\n        std::swap(a,\
    \ b);\n        x -= t1 * t2;\n        std::swap(x, t2);\n        y -= t1 * t3;\n\
    \        std::swap(y, t3);\n    }\n    return {x, y};\n}\ntemplate <class T> constexpr\
    \ inline PP<T> normalize(PP<T> a) noexcept {\n    if(a == PP<T>{}) {\n       \
    \ return a;\n    }\n    a /= gcd(a);\n    if(a < PP<T>{}) {\n        a = -a;\n\
    \    }\n    return a;\n}\ntemplate <class T, class U> constexpr inline P<U, T>\
    \ swap(const P<T, U> &p) noexcept { const P<U, T> ret = {p.second, p.first}; return\
    \ ret; }\ntemplate <class T, class U> inline std::vector<P<U, T>> swap(const std::vector<P<T,\
    \ U>> &vp) noexcept {\n    std::vector<P<U, T>> ret;\n    for(const auto &el:\
    \ vp) {\n        ret.emplace_back(swap(el));\n    }\n    return ret;\n}\ntemplate\
    \ <class T, class U> inline std::vector<T> first(const std::vector<P<T, U>> &vp)\
    \ noexcept {\n    std::vector<T> ret;\n    for(const auto &el: vp) {\n       \
    \ ret.emplace_back(el.first);\n    }\n    return ret;\n}\ntemplate <class T, class\
    \ U> inline std::vector<U> second(const std::vector<P<T, U>> &vp) noexcept {\n\
    \    std::vector<U> ret;\n    for(const auto &el: vp) {\n        ret.emplace_back(el.second);\n\
    \    }\n    return ret;\n}\n}\n}"
  dependsOn:
  - C++/core/alias.hpp
  - C++/core/myvector.hpp
  isVerificationFile: false
  path: C++/core/mypair.hpp
  requiredBy:
  - C++/template.hpp
  timestamp: '2025-06-11 14:22:09+09:00'
  verificationStatus: LIBRARY_ALL_WA
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
documentation_of: C++/core/mypair.hpp
layout: document
redirect_from:
- /library/C++/core/mypair.hpp
- /library/C++/core/mypair.hpp.html
title: C++/core/mypair.hpp
---
