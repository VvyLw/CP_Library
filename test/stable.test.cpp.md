---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/constance.hpp
    title: "\u5B9A\u6570"
  - icon: ':heavy_check_mark:'
    path: C++/io/input.hpp
    title: "\u5165\u529B"
  - icon: ':heavy_check_mark:'
    path: C++/io/output.hpp
    title: "\u51FA\u529B"
  - icon: ':heavy_check_mark:'
    path: C++/math/divisor.hpp
    title: "\u7D04\u6570\u5217\u6319"
  - icon: ':heavy_check_mark:'
    path: C++/math/kthrooti.hpp
    title: "k\u4E57\u6839(\u6574\u6570)"
  - icon: ':heavy_check_mark:'
    path: C++/math/prefixsum.hpp
    title: "\u7D2F\u7A4D\u548C"
  - icon: ':heavy_check_mark:'
    path: C++/math/primefactor.hpp
    title: "\u7D20\u56E0\u6570\u5206\u89E3"
  - icon: ':heavy_check_mark:'
    path: C++/math/primefactortable.hpp
    title: "\u7D20\u56E0\u6570\u5206\u89E3\u30C6\u30FC\u30D6\u30EB"
  - icon: ':heavy_check_mark:'
    path: C++/math/primetable.hpp
    title: Sieve of Eratosthenes
  - icon: ':heavy_check_mark:'
    path: C++/mypair.hpp
    title: C++/mypair.hpp
  - icon: ':heavy_check_mark:'
    path: C++/myvector.hpp
    title: C++/myvector.hpp
  - icon: ':heavy_check_mark:'
    path: C++/structure/SparseTable.hpp
    title: Sparse Table
  - icon: ':heavy_check_mark:'
    path: C++/template.hpp
    title: "\u30C6\u30F3\u30D7\u30EC\u30FC\u30C8"
  - icon: ':heavy_check_mark:'
    path: C++/timer.hpp
    title: "\u30BF\u30A4\u30DE\u30FC"
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://judge.yosupo.jp/problem/staticrmq
    links:
    - https://judge.yosupo.jp/problem/staticrmq
  bundledCode: "#line 1 \"test/stable.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/staticrmq\"\
    \n/*#pragma GCC optimize(\"O3\")\n#pragma GCC optimize(\"unroll-loops\")//*/\n\
    //#pragma GCC target(\"sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native\"\
    )\n#line 2 \"C++/template.hpp\"\n#ifndef TEMPLATE\r\n#define TEMPLATE\r\n#endif\r\
    \n#pragma GCC diagnostic ignored \"-Wunused-parameter\"\r\n#pragma GCC diagnostic\
    \ ignored \"-Wsign-compare\"\r\n#pragma GCC diagnostic ignored \"-Wdeprecated-copy\"\
    \r\n#include <bits/stdc++.h>\r\n#include <ext/pb_ds/assoc_container.hpp>\r\n#include\
    \ <ext/pb_ds/tree_policy.hpp>\r\nnamespace VvyLw {\r\ninline void wa_haya_exe()\
    \ noexcept { std::cin.tie(nullptr) -> sync_with_stdio(false); }\r\nvoid solve();\r\
    \n} // VvyLw\r\nnamespace zia_qu {\r\ninline bool isdigit(const std::string &s);\r\
    \n}\r\nstd::mt19937 EhaL(std::hash<std::string>()(\"Huitloxopetl\"));\r\nstd::mt19937\
    \ Random() {\r\n\tstd::random_device seed_gen;\r\n\tstd::mt19937 engine {seed_gen()};\r\
    \n\treturn engine;\r\n}\r\n\r\n#line 2 \"C++/timer.hpp\"\n\n#line 5 \"C++/timer.hpp\"\
    \nusing Timer = std::chrono::system_clock::time_point;\n[[maybe_unused]] Timer\
    \ start, stop;\n#if local\nvoid now(Timer &t){ t = std::chrono::system_clock::now();\
    \ }\nvoid time(const Timer &t1, const Timer &t2){ std::cerr << std::chrono::duration_cast<std::chrono::milliseconds>(t2\
    \ - t1).count() << \"ms\\n\"; }\n#else\n[[maybe_unused]] void now(Timer &t){ void(0);\
    \ }\n[[maybe_unused]] void time(const Timer &t1, const Timer &t2){ void(0); }\n\
    #endif\n\n/**\n * @brief \u30BF\u30A4\u30DE\u30FC\n */\n#line 26 \"C++/template.hpp\"\
    \n\r\n#define overload4(_1,_2,_3,_4,name,...) name\r\n#define overload3(_1,_2,_3,name,...)\
    \ name\r\n#define rep1(n) for(ll i=0; i<(n); ++i)\r\n#define rep2(i,n) for(ll\
    \ i=0; i<(n); ++i)\r\n#define rep3(i,a,b) for(ll i=(a); i<=(b); ++i)\r\n#define\
    \ rep4(i,a,b,c) for(ll i=(a); i<=(b); i+=(c))\r\n#define rep(...) overload4(__VA_ARGS__,rep4,rep3,rep2,rep1)(__VA_ARGS__)\r\
    \n#define rvp1(n) for(ll i=(n); --i>=0;)\r\n#define rvp2(i,n) for(ll i=(n); --i>=0;)\r\
    \n#define rvp3(i,a,b) for(ll i=(a); i>=(b); i--)\r\n#define rvp4(i,a,b,c) for(ll\
    \ i=(a); i>=(b); i-=(c))\r\n#define rvp(...) overload4(__VA_ARGS__,rvp4,rvp3,rvp2,rvp1)(__VA_ARGS__)\r\
    \n#define all1(v) v.begin(),v.end()\r\n#define all2(v,a) v.begin(),v.begin()+a\r\
    \n#define all3(v,a,b) v.begin()+a,v.begin()+b\r\n#define all(...) overload3(__VA_ARGS__,all3,all2,all1)(__VA_ARGS__)\r\
    \n#define rall1(v) v.rbegin(),v.rend()\r\n#define rall2(v,a) v.rbegin(),v.rbegin()+a\r\
    \n#define rall3(v,a,b) v.rbegin()+a,v.rbegin()+b\r\n#define rall(...) overload3(__VA_ARGS__,rall3,rall2,rall1)(__VA_ARGS__)\r\
    \n#define each1(elem,v) for(auto &elem: v)\r\n#define each2(x,y,v) for(auto &[x,y]:\
    \ v)\r\n#define each3(x,y,z,v) for(auto &[x,y,z]: v)\r\n#define each(...) overload4(__VA_ARGS__,each3,each2,each1)(__VA_ARGS__)\r\
    \n#define sqrp1(n) for(ll i=0; i*i<(n); ++i)\r\n#define sqrp2(i,n) for(ll i=0;\
    \ i*i<(n); ++i)\r\n#define sqrp3(i,a,b) for(ll i=(a); i*i<=(b); ++i)\r\n#define\
    \ sqrp(...) overload3(__VA_ARGS__,sqrp3,sqrp2,sqrp1)(__VA_ARGS__)\r\n\r\nusing\
    \ ll = long long;\r\nusing ld = long double;\r\nusing uint = unsigned;\r\nusing\
    \ ul = unsigned long long;\r\nusing i128 = __int128_t;\r\nusing u128 = __uint128_t;\r\
    \n\r\n#line 2 \"C++/mypair.hpp\"\n\n#line 2 \"C++/constance.hpp\"\n\n#line 4 \"\
    C++/constance.hpp\"\n#ifndef TEMPLATE\nusing ll = long long;\nusing ld = long\
    \ double;\n#endif\ntemplate <class T> using L = std::numeric_limits<T>;\nconstexpr\
    \ int dx[] = {0, 0, 0, -1, 1, -1, -1, 1, 1};\nconstexpr int dy[] = {0, -1, 1,\
    \ 0, 0, -1, 1, -1, 1};\nconstexpr int MOD = 0x3b800001;\nconstexpr int M0D = 1e9\
    \ + 7;\nconstexpr int INF = 1 << 30;\nconstexpr ll LINF = (1LL << 61) - 1;\nconstexpr\
    \ ld DINF = L<ld>::infinity();\ntemplate <class T> constexpr T LIM = L<T>::max();\n\
    #if __cplusplus >= 202100L\n#include <numbers>\nconstexpr ld PI = std::numbers::pi;\n\
    constexpr ld E = std::numbers::e;\n#else\n#include <cmath>\nconst ld PI = std::acos(-1);\n\
    const ld E = 2.718281828459045;\n#endif\n\n/**\n * @brief \u5B9A\u6570\n */\n\
    #line 2 \"C++/myvector.hpp\"\n\n#line 4 \"C++/myvector.hpp\"\n\n#ifndef TEMPLATE\n\
    typedef long long ll;\ntypedef unsigned long long ul;\ntypedef long double ld;\n\
    #endif\nnamespace vectors {\ntemplate <class T> using V = std::vector<T>;\nusing\
    \ vi = V<ll>;\nusing vu = V<ul>;\nusing vd = V<ld>;\nusing vc = V<char>;\nusing\
    \ vs = V<std::string>;\nusing vb = V<bool>;\nusing wi = V<vi>;\nusing wu = V<vu>;\n\
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
    }\n} // pairs\n#line 64 \"C++/template.hpp\"\n\r\nusing namespace vectors;\r\n\
    using namespace pairs;\r\n\r\ntemplate <size_t N> using ti = std::array<ll, N>;\r\
    \nusing tri = ti<3>;\r\ntemplate <class T> using pq = std::priority_queue<T>;\r\
    \ntemplate <class T> using pqr = std::priority_queue<T,V<T>,std::greater<T>>;\r\
    \ntemplate <class T> using Tree = __gnu_pbds::tree<T,__gnu_pbds::null_type,std::less<T>,__gnu_pbds::rb_tree_tag,__gnu_pbds::tree_order_statistics_node_update>;\r\
    \ntemplate <class T> using TREE = __gnu_pbds::tree<T,__gnu_pbds::null_type,std::greater<T>,__gnu_pbds::rb_tree_tag,__gnu_pbds::tree_order_statistics_node_update>;\r\
    \ntemplate <class T, class U> inline bool chmax(T& a, const U& b){ if(a<b){ a=b;\
    \ return 1; } return 0; }\r\ntemplate <class T, class U> inline bool chmin(T&\
    \ a, const U& b){ if(a>b){ a=b; return 1; } return 0; }\r\ntemplate <class T,\
    \ class U> inline bool overflow_if_add(const T a, const U b){ return (LIM<T>-a)<b;\
    \ }\r\ntemplate <class T, class U> inline bool overflow_if_mul(const T a, const\
    \ U b){ return (LIM<T>/a)<b; }\r\ninline void fix(const short x){ std::cout <<\
    \ std::fixed << std::setprecision(x); }\r\ninline void alpha(){ std::cout << std::boolalpha;\
    \ }\r\n\r\n#line 2 \"C++/io/input.hpp\"\n\n#line 7 \"C++/io/input.hpp\"\n#ifndef\
    \ TEMPLATE\ntypedef unsigned long long ul;\ntypedef __int128_t i128;\nnamespace\
    \ zia_qu {\ninline bool isdigit(const char c){ return std::isdigit(c); }\ninline\
    \ bool isdigit(const std::string &s){ bool ok=1, neg=s.front()=='-'; for(const\
    \ auto &el: s){ if(neg){ neg=0; continue; } ok&=isdigit(el); } return ok; }\n\
    }\n#endif\nnamespace IO {\ntemplate <class T, class U> std::istream& operator>>(std::istream\
    \ &is, pairs::P<T, U> &p){ is >> p.first >> p.second; return is; }\ntemplate <class\
    \ T, size_t N> std::istream& operator>>(std::istream &is, std::array<T, N> &a){\
    \ for(auto &el: a) is >> el; return is; }\ntemplate <class T> std::istream& operator>>(std::istream\
    \ &is, vectors::V<T> &v){ for(auto &el: v) is >> el; return is; }\ntemplate <class\
    \ T> std::istream& operator>>(std::istream &is, std::deque<T> &dq){ for(auto &el:\
    \ dq) is >> el; return is; }\ntemplate <class T> inline bool in(T& x){ std::cin\
    \ >> x; return 1; }\ntemplate <class Head, class... Tail> inline bool in(Head&\
    \ head, Tail&... tail){ in(head); in(tail...); return 1; }\n\ninline i128 to_i128(const\
    \ std::string &s) {\n    assert(zia_qu::isdigit(s));\n    bool neg=s.front()=='-';\n\
    \    i128 ret = 0;\n    for(const auto &el: s) {\n        if(neg) {\n        \
    \    neg=0;\n            continue;\n        }\n        ret = 10 * ret + el - '0';\n\
    \    }\n    if(s.front()=='-') ret=-ret;\n    return ret;\n}\n\n#define INT(...)\
    \ int __VA_ARGS__; in(__VA_ARGS__)\n#define LL(...) ll __VA_ARGS__; in(__VA_ARGS__)\n\
    #define UL(...) ul __VA_ARGS__; in(__VA_ARGS__)\n#define LD(...) ld __VA_ARGS__;\
    \ in(__VA_ARGS__)\n#define CHR(...) char __VA_ARGS__; in(__VA_ARGS__)\n#define\
    \ STR(...) std::string __VA_ARGS__; in(__VA_ARGS__)\n#define VEC(type,name,size)\
    \ vectors::V<type> name(size); in(name)\n#define WEC(type,name,h,w) vectors::V<vectors::V<type>>\
    \ name(h,vectors::V<type>(w)); in(name)\n} // IO\n\n/**\n * @brief \u5165\u529B\
    \n */\n#line 2 \"C++/io/output.hpp\"\n\n#line 8 \"C++/io/output.hpp\"\n#ifndef\
    \ TEMPLATE\nusing i128 = __int128_t;\nusing u128 = __uint128_t;\n#define rep(n)\
    \ for(size_t i = 0; i < n; ++i)\n#endif\nnamespace IO {\nstd::ostream &operator<<(std::ostream\
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
    \ v){ rep(v.size()) std::cout << v[i] << '\\n'; if(flush) std::cout.flush(); }\n\
    template <bool flush=false, class Head, class... Tail> inline void vout(const\
    \ Head& head, const Tail&... tail){ std::cout << head << '\\n'; vout<flush>(tail...);\
    \ }\n\n#define fin(...) do{ out(__VA_ARGS__); return; }while(false)\n} // IO\n\
    \n/**\n * @brief \u51FA\u529B\n */\n#line 83 \"C++/template.hpp\"\n\r\nusing namespace\
    \ IO;\r\n\r\n#ifdef local\r\n//https://gist.github.com/naskya/1e5e5cd269cfe16a76988378a60e2ca3\r\
    \n#include <C++/io/debug_print.hpp>\r\n#define debug(...) debug_print::multi_print(#__VA_ARGS__,\
    \ __VA_ARGS__)\r\n#else\r\n#define debug(...) static_cast<void>(0)\r\n#endif\r\
    \n\r\nnamespace zia_qu {\r\n#define elif else if\r\n#define eid(el,v) size_t(&el-&v[0])\r\
    \n#define bif(bit,tar) if(((bit)>>(tar))&1)\r\n#define nxp(x) std::next_permutation(all(x))\r\
    \n#define prp(x) std::prev_permutation(all(x))\r\n#define strpl(s,a,b) std::regex_replace(s,std::regex(a),b)\r\
    \n#define rgxsr(s,rgx) std::regex_search(s,std::regex(rgx))\r\ninline void YES(const\
    \ bool ok=1){ out(ok?\"YES\":\"NO\"); }\r\ninline void NO(const bool ok=1){ YES(!ok);\
    \ }\r\ninline void Yes(const bool ok=1){ out(ok?\"Yes\":\"No\"); }\r\ninline void\
    \ No(const bool ok=1){ Yes(!ok); }\r\ninline void yes(const bool ok=1){ out(ok?\"\
    yes\":\"no\"); }\r\ninline void no(const bool ok=1){ yes(!ok); }\r\ntemplate <class\
    \ T> inline T sqr(const T x){ return x*x; }\r\ntemplate <class T> inline T cub(const\
    \ T x){ return x*x*x; }\r\ntemplate <class T> inline T mod(T x, const T m) {\r\
    \n\tx %= m;\r\n\treturn x < 0 ? x + m : x;\r\n}\r\ntemplate <class T> inline T\
    \ pow(T a, T b, const T mod=0) {\r\n\tT res=1;\r\n\tif(mod) {\r\n\t\tres%=mod;\r\
    \n\t\ta%=mod;\r\n\t}\r\n\twhile(b>0) {\r\n\t\tif(b&1) res*=a;\r\n\t\tif(mod) res%=mod;\r\
    \n\t\ta*=a;\r\n\t\tif(mod) a%=mod;\r\n\t\tb>>=1;\r\n\t}\r\n\treturn res;\r\n}\r\
    \ninline ll ceil(const ld x, const ll m){ return std::ceil(x/m); }\r\ninline ld\
    \ round(const ld x, const ll m, const short fx=0){ if(!fx) return std::round(x/m);\
    \ const ul y=pow<ul>(10,fx); return std::round((x*y)/m)/y; }\r\ninline ld log(const\
    \ ll x, const ld base=2){ return std::log2(x)/std::log2(base); }\r\ninline int\
    \ bitdigit(const ll x){ return 64-__builtin_clzll(x); }\r\ninline int popcnt(const\
    \ ll x){ return __builtin_popcountll(x); }\r\ninline int fione(const ll x){ return\
    \ __builtin_ffsll(x); }\r\ninline int zrcnt(const ll x){ return __builtin_ctzll(x);\
    \ }\r\ntemplate <class T=ll> inline bool scope(const T a, const T x, const T b){\
    \ return a <= x && x <= b; }\r\ninline bool isupper(const char c){ return std::isupper(c);\
    \ }\r\ninline bool isupper(const std::string &s){ bool ok=1; each(el,s) ok&=isupper(el);\
    \ return ok; }\r\ninline bool islower(const char c){ return std::islower(c); }\r\
    \ninline bool islower(const std::string &s){ bool ok=1; each(el,s) ok&=islower(el);\
    \ return ok; }\r\ninline bool isalpha(const char c){ return std::isalpha(c); }\r\
    \ninline bool isalpha(const std::string &s){ bool ok=1; each(el,s) ok&=isalpha(el);\
    \ return ok; }\r\ninline bool isdigit(const char c){ return std::isdigit(c); }\r\
    \ninline bool isdigit(const std::string &s){ bool ok=1, neg=s.front()=='-'; each(el,s){\
    \ if(neg){ neg=0; continue; } ok&=isdigit(el); } return ok; }\r\ninline bool isalnum(const\
    \ char c){ return std::isalnum(c); }\r\ninline bool isalnum(const std::string\
    \ &s){ bool ok=1; each(el,s) ok&=isalnum(el); return ok; }\r\ninline bool isspace(const\
    \ char c){ return std::isspace(c); }\r\ninline bool isspace(const std::string\
    \ &s){ bool ok=1; each(el,s) ok&=isspace(el); return ok; }\r\ninline bool ispunct(const\
    \ char c){ return std::ispunct(c); }\r\ninline bool ispunct(const std::string\
    \ &s){ bool ok=1; each(el,s) ok&=ispunct(el); return ok; }\r\ninline bool isprint(const\
    \ char c){ return std::isprint(c); }\r\ninline bool isprint(const std::string\
    \ &s){ bool ok=1; each(el,s) ok&=isprint(el); return ok; }\r\ninline ll strins(std::string\
    \ &s, const int id, const std::string &t){ s.insert(id,t); return s.size(); }\r\
    \ninline std::string toupper(std::string s){ each(c,s) c=std::toupper(c); return\
    \ s; }\r\ninline std::string tolower(std::string s){ each(c,s) c=std::tolower(c);\
    \ return s; }\r\ninline vi ten_to_adic(ll n, const short base) {\r\n\tif(n==0)\
    \ {\r\n\t\treturn {0};\r\n\t}\r\n\tvi res;\r\n\twhile(n) {\r\n\t\tres.emplace_back(n%base);\r\
    \n\t\tn/=base;\r\n\t}\r\n\treturn res;\r\n}\r\ninline ll adic_to_ten(const vi\
    \ &v, const short base) {\r\n\tll res=0;\r\n\teach(el,v) {\r\n\t\tres+=pow<ll>(base,eid(el,v))*el;\r\
    \n\t}\r\n\treturn res;\r\n}\r\ninline std::string to_hex(const ll x, const bool\
    \ upper = false) {\r\n\tstd::stringstream ss;\r\n\tss << std::hex << x;\r\n\t\
    std::string s = ss.str();\r\n\tif(upper) s=toupper(s);\r\n\treturn s;\r\n}\r\n\
    inline std::string to_oct(const ll x) {\r\n\tstd::stringstream s;\r\n\ts << std::oct\
    \ <<x;\r\n\treturn s.str();\r\n}\r\ninline std::string to_bin(const ll x) {\r\n\
    \tstd::stringstream ss;\r\n\tss<<std::bitset<64>(x);\r\n\tstd::string s=ss.str();\r\
    \n\tstd::reverse(all(s));\r\n\ts.resize(ten_to_adic(x,2).size());\r\n\tstd::reverse(all(s));\r\
    \n\treturn s;\r\n}\r\ninline ll to_ten(const std::string &s, const short base){\
    \ return std::stoll(s,nullptr,base); }\r\ntemplate <class... Ts> constexpr ul\
    \ sygcd(const Ts... a) noexcept { std::vector v=std::initializer_list<std::common_type_t<Ts...>>{a...};\
    \ ul g=0; each(el,v) g=std::gcd(g,el); return g; }\r\ntemplate <class... Ts> constexpr\
    \ ul sylcm(const Ts... a) noexcept { std::vector v=std::initializer_list<std::common_type_t<Ts...>>{a...};\
    \ ul l=1; each(el,v) l=std::lcm(l,el); return l; }\r\ntemplate <class... Ts> constexpr\
    \ auto symin(const Ts... a) noexcept { return std::min(std::initializer_list<std::common_type_t<Ts...>>{a...});\
    \ }\r\ntemplate <class... Ts> constexpr auto symax(const Ts... a) noexcept { return\
    \ std::max(std::initializer_list<std::common_type_t<Ts...>>{a...}); }\r\ntemplate\
    \ <class K, class U> inline V<K> kyl(const std::map<K,U> &m, const U val) {\r\n\
    \tV<K> keys;\r\n\tfor(auto it=m.cbegin(); it!=m.cend(); ++it) {\r\n\t\tif(it->second==val)\
    \ keys.emplace_back(it->first);\r\n\t}\r\n\treturn keys;\r\n}\r\ntemplate <class\
    \ K, class V> inline K kymin(const std::map<K,V> &m){ return m.begin()->first;\
    \ }\r\ntemplate <class K, class V> inline K kymax(const std::map<K,V> &m){ return\
    \ m.rbegin()->first; }\r\ntemplate <class K, class V> inline V kymin_v(const std::map<K,V>\
    \ &m){ return m.begin()->second; }\r\ntemplate <class K, class V> inline V kymax_v(const\
    \ std::map<K,V> &m){ return m.rbegin()->second; }\r\ntemplate <class K, class\
    \ V> inline V vlmin(const std::map<K,V> &m){\r\n\tconst auto pr = *std::min_element(all(m),[](P<K,V>\
    \ const &x, P<K,V> const &y){ return x.second < y.second; });\r\n\treturn pr.second;\r\
    \n}\r\ntemplate <class K, class V> inline V vlmax(const std::map<K,V> &m){\r\n\
    \tconst auto pr = *std::max_element(all(m),[](P<K,V> const &x, P<K,V> const &y){\
    \ return x.second < y.second; });\r\n\treturn pr.second;\r\n}\r\ntemplate <class\
    \ K, class V> inline K vlmin_k(const std::map<K,V> &m){\r\n\tconst auto pr = *std::min_element(all(m),[](P<K,V>\
    \ const &x, P<K,V> const &y){ return x.second < y.second; });\r\n\treturn pr.first;\r\
    \n}\r\ntemplate <class K, class V> inline K vlmax_k(const std::map<K,V> &m){\r\
    \n\tconst auto pr = *std::max_element(all(m),[](P<K,V> const &x, P<K,V> const\
    \ &y){ return x.second < y.second; });\r\n\treturn pr.first;\r\n}\r\n} // zia\
    \ qu\r\n\r\nnamespace Lady_sANDy {\r\ntemplate <class T> inline void rev(T& v){\
    \ std::reverse(all(v)); }\r\ntemplate <class T> inline void rev(T& v, const int\
    \ a, const int b){ std::reverse(all(v,a,b+1)); }\r\ntemplate <class T> inline\
    \ T revd(const T& v){ auto c=v; rev(c); return c; }\r\ntemplate <class T> inline\
    \ T revd(const T& v, const int a, const int b){ auto c=v; rev(c,a,b); return c;\
    \ }\r\ntemplate <class T> inline void Sort(T& v){ std::sort(all(v)); }\r\ntemplate\
    \ <class T> inline void Sort(T& v, const int a, const int b){ std::sort(all(v,a,b+1));\
    \ }\r\ntemplate <class T> inline T sorted(const T& v){ auto c=v; Sort(c); return\
    \ c; }\r\ntemplate <class T> inline T sorted(const T& v, const int a, const int\
    \ b){ auto c=v; Sort(c,a,b); return c; }\r\ntemplate <class T> inline void Sortt(T&\
    \ v){ std::sort(rall(v)); }\r\ntemplate <class T> inline void Sortt(T& v, const\
    \ int a, const int b){ std::sort(rall(v,v.size()-b-1,v.size()-a)); }\r\ntemplate\
    \ <class T> inline T Sorted(const T& v){ auto c=v; Sortt(c); return c; }\r\ntemplate\
    \ <class T> inline T Sorted(const T& v, const int a, const int b){ auto c=v; Sortt(c,a,b);\
    \ return c; }\r\ntemplate <class T> inline void Sorth(T& v){ std::make_heap(all(v));\
    \ std::sort_heap(all(v)); }\r\ntemplate <class T> inline T mrg(const T& a, const\
    \ T& b){ T res; std::merge(all(a),all(b),std::back_inserter(res)); return res;\
    \ }\r\ntemplate <class T> inline T Min(const V<T>& v){ return *std::min_element(all(v));\
    \ }\r\ntemplate <class T> inline T Min(const V<T>& v, const int a, const int b){\
    \ return *std::min_element(all(v,a,b+1)); }\r\ntemplate <class T> inline T Max(const\
    \ V<T>& v){ return *std::max_element(all(v)); }\r\ntemplate <class T> inline T\
    \ Max(const V<T>& v, const int a, const int b){ return *std::max_element(all(v,a,b+1));\
    \ }\r\ntemplate <class T> inline int Min_i(const T& v){ return std::min_element(all(v))-v.begin();\
    \ }\r\ntemplate <class T> inline int Max_i(const T& v){ return std::max_element(all(v))-v.begin();\
    \ }\r\ntemplate <class T, class U> inline int LB(const T& v, const U x){ return\
    \ std::lower_bound(all(v),x)-v.begin(); }\r\ntemplate <class T, class U> inline\
    \ int UB(const T& v, const U x){ return std::upper_bound(all(v),x)-v.begin();\
    \ }\r\ntemplate <class T, class U> inline bool BS(const T& v, const U x){ return\
    \ std::binary_search(all(v),x); }\r\ntemplate <class T, class U, class Boolean=bool>\
    \ inline bool BS(const T& v, const U x, const Boolean &fn){ return std::binary_search(all(v),x,fn);\
    \ }\r\ntemplate <class T, class Boolean=bool> inline bool All(const T& v, const\
    \ Boolean &fn){ return std::all_of(all(v),fn); }\r\ntemplate <class T, class Boolean=bool>\
    \ inline bool Exist(const T& v, const Boolean &fn){ return std::any_of(all(v),fn);\
    \ }\r\ntemplate <class T, class Boolean=bool> inline int pt(T& v, const Boolean\
    \ &fn){ auto p=std::partition(all(v),fn); return p-v.begin(); }\r\ntemplate <class\
    \ T, class Boolean=bool> inline int ptp(const T& v, const Boolean &fn){ return\
    \ std::partition_point(all(v),fn)-v.begin(); }\r\ntemplate <class T, class U>\
    \ inline int fnd(const T& v, const U x){ auto itr=std::find(all(v),x); return\
    \ itr!=v.end()?itr-v.begin():-1; }\r\ntemplate <class T> inline int src(const\
    \ T& s, const T& t){ auto itr=std::search(all(s),all(t)); return itr!=s.end()?itr-s.begin():-1;\
    \ }\r\ntemplate <class T, class U> inline void rpl(T& v, const U fn, const U r){\
    \ std::replace(all(v),fn,r); }\r\ntemplate <class T, class U, class Boolean=bool>\
    \ inline void rplif(T& v, const Boolean &fn, const U r){ std::replace_if(all(v),fn,r);\
    \ }\r\ntemplate <class T, class Boolean=bool> inline ul cntif(const T& v, const\
    \ Boolean &fn){ return std::count_if(all(v),fn); }\r\ntemplate <class T> inline\
    \ T Count(V<T>& v, ll x){ if(!std::is_sorted(all(v))) Sort(v); return UB(v,x)-LB(v,x);\
    \ }\r\ntemplate <class T> inline T IP(const V<T>& v, const V<T>& u, T init){ return\
    \ std::inner_product(all(v),u.begin(),init); }\r\ninline vi iot(int n, ll init=0){\
    \ vi a(n); std::iota(all(a),init); return a; }\r\ntemplate <class T, class U,\
    \ class F> inline V<T> trans(const V<U>& v, const F &fn){ V<T> res; std::transform(all(v),std::back_inserter(res),fn);\
    \ return res; }\r\ntemplate <class T, class U> inline int ers(T& v, const U x){\
    \ v.erase(std::remove(all(v),x),v.end()); return v.size(); }\r\ntemplate <class\
    \ T, class Boolean=bool> int ersif(T& v, const Boolean &fn){ v.erase(std::remove_if(all(v),fn),v.end());\
    \ return v.size(); }\r\ntemplate <class T> inline int unq(T& v){ if(!std::is_sorted(all(v)))\
    \ Sort(v); v.erase(unique(all(v)),v.end()); return v.size(); }\r\ntemplate <class\
    \ T> inline T cp(const T& v){ T res; copy(all(v),back_inserter(res)); return res;\
    \ }\r\ntemplate <class T> inline T cp(const T& v, const int a, const int b){ T\
    \ res; std::copy(all(v,a,b),std::back_inserter(res)); return res; }\r\ntemplate\
    \ <class T> inline void rtt(T& s, const int idx){ const int id=zia_qu::mod<int>(idx,s.size());\
    \ std::rotate(all(s,id),s.end()); }\r\ntemplate <class T> inline void rtt(T& s,\
    \ const int a, const int b, const int c){ std::rotate(all(s,a,b),s.end()-c); }\r\
    \ntemplate <class T> inline T setdif(const T& s, const T& t){ assert(std::is_sorted(all(s))&&std::is_sorted(all(t)));\
    \ T res; std::set_difference(all(s),all(t),std::inserter(res,std::end(res)));\
    \ return res; }\r\ntemplate <class T> inline T setsum(const T& s, const T& t){\
    \ assert(std::is_sorted(all(s))&&std::is_sorted(all(t))); T res; std::set_union(all(s),all(t),std::inserter(res,std::end(res)));\
    \ return res; }\r\ntemplate <class T> inline T setmul(const T& s, const T& t){\
    \ assert(std::is_sorted(all(s))&&std::is_sorted(all(t))); T res; std::set_intersection(all(s),all(t),std::inserter(res,std::end(res)));\
    \ return res; }\r\ntemplate <class T> inline V<T> adf(const V<T>& v){ V<T> a;\
    \ std::adjacent_difference(all(v),std::back_inserter(a)); rtt(a,1); a.pop_back();\
    \ return a; }\r\ntemplate <class T, class F> inline V<T> isum(const V<T> &v, const\
    \ F &fn){ V<T> s{0}; std::inclusive_scan(all(v),std::back_inserter(s),fn); return\
    \ s; }\r\ntemplate <class T> inline V<T> rext(const V<T>& v, const int size){\
    \ V<T> res; std::sample(all(v),std::back_inserter(res),size,Random()); return\
    \ res; }\r\ntemplate <class T> inline T rext(const V<T>& v){ V<T> res; std::sample(all(v),std::back_inserter(res),1,Random());\
    \ return res.front(); }\r\ntemplate <class T> inline ll vsum(const T &v){ return\
    \ std::accumulate(all(v),0LL); }\r\ntemplate <class T> inline ll vsum(const T\
    \ &v, ll a, ll b){ return std::accumulate(all(v,a,b),0LL); }\r\ntemplate <class\
    \ T> inline ld vdsum(const T &v){ return std::accumulate(all(v),0.0L); }\r\ntemplate\
    \ <class T> inline ld vdsum(const T &v, ll a, ll b){ return std::accumulate(all(v,a,b),0.0L);\
    \ }\r\ntemplate <class T> inline ll vmul(const T &v){ return std::accumulate(all(v),1LL,[](ll\
    \ acc,ll i){ return acc*i; }); }\r\ntemplate <class T> inline ll vmul(const T\
    \ &v, ll a, ll b){ return std::accumulate(all(v,a,b),1LL,[](ll acc,ll i){ return\
    \ acc*i; }); }\r\ntemplate <class T> inline ld vdmul(const T &v){ return std::accumulate(all(v),1.0L,[](ll\
    \ acc,ll i){ return acc*i; }); }\r\ntemplate <class T> inline ld vdmul(const T\
    \ &v, ll a, ll b){ return std::accumulate(all(v,a,b),1.0L,[](ll acc,ll i){ return\
    \ acc*i; }); }\r\n} // Lady s&y\r\n\r\n#line 2 \"C++/math/divisor.hpp\"\n\n#line\
    \ 5 \"C++/math/divisor.hpp\"\n#ifndef TEMPLATE\n#endif\nnamespace Heileden {\n\
    template <class T> inline vectors::V<T> div(const T n) {\n    vectors::V<T> d;\n\
    \    for(long long i = 1; i * i <= n; ++i) {\n        if(n%i==0) {\n         \
    \   d.emplace_back(i);\n            if(i*i!=n) d.emplace_back(n/i);\n        }\n\
    \    }\n    std::sort(d.begin(), d.end());\n    return d;\n}\n}\n\n/**\n * @brief\
    \ \u7D04\u6570\u5217\u6319\n */\n#line 2 \"C++/math/primefactor.hpp\"\n\n#line\
    \ 4 \"C++/math/primefactor.hpp\"\n#ifndef TEMPLATE\n#define sqrp(i,a,b) for(long\
    \ long i = (a); i * i <= (b); ++i)\n#endif\nnamespace Heileden {\ntemplate <class\
    \ T> inline vectors::V<pairs::PP<T>> prmfct(T n) {\n    vectors::V<pairs::PP<T>>\
    \ res;\n    for(T i = 2; i * i <= n; ++i) {\n        if(n%i!=0) continue;\n  \
    \      T tmp=0;\n        while(n%i==0) {\n            tmp++;\n            n/=i;\n\
    \        }\n        res.emplace_back(i,tmp);\n    }\n    if(n!=1) res.emplace_back(n,1);\n\
    \    return res;\n}\n}\n\n/**\n * @brief \u7D20\u56E0\u6570\u5206\u89E3\n */\n\
    #line 2 \"C++/math/primetable.hpp\"\n\n#line 4 \"C++/math/primetable.hpp\"\nnamespace\
    \ Heileden {\nstruct p_table {\n    vectors::vb SoE;\n    p_table(const int n):\
    \ SoE(n+1,1){\n        SoE[0]=SoE[1]=0;\n        for(int64_t i = 2; i <= n; ++i)\
    \ {\n            if(!SoE[i]) continue;\n            for(int64_t j = i * i; j <=\
    \ n; j += i) SoE[j] = 0;\n        }\n    }\n    vectors::vi get() {\n        vectors::vi\
    \ p;\n        for(size_t i = 2; i < SoE.size(); ++i) if(SoE[i]) p.emplace_back(i);\n\
    \        return p;\n    }\n};\n}\n\n/**\n * @brief Sieve of Eratosthenes\n */\n\
    #line 2 \"C++/math/primefactortable.hpp\"\n\n#line 6 \"C++/math/primefactortable.hpp\"\
    \nnamespace Heileden {\nstruct p_fact {\n    vectors::vi spf;\n    p_fact(const\
    \ int n): spf(n + 1){\n        std::iota(spf.begin(), spf.end(), 0);\n       \
    \ for(int64_t i = 2; i * i <= n; ++i) {\n            if(spf[i]==i) {\n       \
    \         for(int64_t j = i * i; j <= n; j += i) {\n                    if(spf[j]==j)\
    \ spf[j]=i;\n                }\n            }\n        }\n    }\n    std::map<int,int>\
    \ get(int n) {\n        std::map<int,int> m;\n        while(n!=1) {\n        \
    \    m[spf[n]]++;\n            n/=spf[n];\n        }\n        return m;\n    }\n\
    };\n}\n\n/**\n * @brief \u7D20\u56E0\u6570\u5206\u89E3\u30C6\u30FC\u30D6\u30EB\
    \n */\n#line 2 \"C++/math/prefixsum.hpp\"\n\n#line 5 \"C++/math/prefixsum.hpp\"\
    \nnamespace Heileden {\nstruct psum {\nprivate:\n    vectors::vi s;\npublic:\n\
    \    psum(const vectors::vi& v): s{0} { std::partial_sum(v.begin(), v.end(), std::back_inserter(s));\
    \ }\n    vectors::vi get() const { return s; }\n    // [l, r]\n    ll query(const\
    \ int l, const int r) const { return s[r]-s[l]; }\n};\n}\n\n/**\n * @brief \u7D2F\
    \u7A4D\u548C\n */\n#line 2 \"C++/math/kthrooti.hpp\"\n\n#line 4 \"C++/math/kthrooti.hpp\"\
    \n#ifndef TEMPLATE\ntypedef unsigned long long ul;\ntemplate <class T, class U>\
    \ inline bool overflow_if_mul(const T a, const U b){ return (std::numeric_limits<T>::max()/a)<b;\
    \ }\n#endif\nnamespace Heileden {\ninline ul kthrooti(const ul n, const int k)\
    \ {\n    if(k==1) {\n\t\treturn n;\n\t}\n\tconst auto chk=[&](const unsigned x)\
    \ {\n\t\tul mul=1;\n\t\tfor(int i = 0; i < k; ++i) {\n            if(overflow_if_mul(mul,\
    \ x)) {\n                return false;\n            }\n            mul*=x;\n \
    \       }\n\t\treturn mul<=n;\n\t};\n\tul ret=0;\n\tfor(int i = 32; --i >= 0;)\
    \ {\n\t\tif(chk(ret|(1U<<i))) {\n\t\t\tret|=1U<<i;\n\t\t}\n\t}\n\treturn ret;\n\
    }\n}\n\n/**\n * @brief k\u4E57\u6839(\u6574\u6570)\n */\n#line 297 \"C++/template.hpp\"\
    \n\r\nnamespace Heileden {\r\ntemplate <class T, class Boolean=bool> inline T\
    \ bins(T ok, T ng, const Boolean &fn, const ld eps = 1) {\r\n\twhile(std::abs(ok-ng)>eps)\
    \ {\r\n\t\tT mid=(ok+ng)/2;\r\n\t\t(fn(mid)?ok:ng) = mid;\r\n\t}\r\n\treturn ok;\r\
    \n}\r\ntemplate <class T> inline V<T> press(const V<T>& v) {\r\n\tV<T> res,cp=v;\r\
    \n\tLady_sANDy::unq(cp);\r\n\teach(el,v) res.emplace_back(Lady_sANDy::LB(cp,el));\r\
    \n\treturn res;\r\n}\r\ntemplate <class T> inline V<T> press(V<T> &c1, V<T> &c2)\
    \ {\r\n\tV<T> res;\r\n\tconst int n = c1.size();\r\n\trep(n) {\r\n\t\tfor(T d\
    \ = 0; d < 1; d++) {\r\n\t\t\tT tc1 = c1[i]+d;\r\n\t\t\tT tc2 = c2[i]+d;\r\n\t\
    \t\tres.emplace_back(tc1);\r\n\t\t\tres.emplace_back(tc2);\r\n\t\t}\r\n\t}\r\n\
    \tLady_sANDy::unq(res);\r\n\trep(n) {\r\n\t\tc1[i]=Lady_sANDy::LB(res,c1[i]);\r\
    \n\t\tc2[i]=Lady_sANDy::LB(res,c2[i]);\r\n\t}\r\n\treturn res;\r\n}\r\ninline\
    \ vs rtt(const vs &s) {\r\n\tconst int h=s.size(), w=s.front().size();\r\n\tvs\
    \ t(w,std::string(h,{}));\r\n\trep(h) rep(j,w) t[j][i]=s[i][j];\r\n\trep(w) Lady_sANDy::rev(t[i]);\r\
    \n\treturn t;\r\n}\r\ntemplate <class T> inline V<V<T>> rtt(const V<V<T>>& v)\
    \ {\r\n\tconst int h=v.size(), w=v.front().size();\r\n\tV<V<T>> res(w,V<T>(h));\r\
    \n\trep(h) rep(j,w) res[j][i]=v[i][j];\r\n\trep(w) Lady_sANDy::rev(res[i]);\r\n\
    \treturn res;\r\n}\r\ntemplate <class T> inline T factor(T n, const T mod=0) {\r\
    \n\tT res=1;\r\n\twhile(n>0) {\r\n\t\tres*=n--;\r\n\t\tif(mod) res%=mod;\r\n\t\
    }\r\n\treturn res;\r\n}\r\ntemplate <class T=ll> inline T perm(T n, const T r,\
    \ const T mod=0) {\r\n\tconst T tmp=n;\r\n\tT res=1;\r\n\twhile(n>tmp-r) {\r\n\
    \t\tres*=n--;\r\n\t\tif(mod) res%=mod;\r\n\t}\r\n\treturn res;\r\n}\r\ntemplate\
    \ <class T=ll> inline T binom(T n, const T r, const T mod=0) {\r\n\tif(r < 0 ||\
    \ n < r) return 0;\r\n\tT res = 1;\r\n\trep(i,1,r) {\r\n\t\tres*=n--;\r\n\t\t\
    if(mod) res%=mod;\r\n\t\tres/=i;\r\n\t\tif(mod) res%=mod;\r\n\t}\r\n\treturn res;\r\
    \n}\r\ninline bool is_prime(const ul n) {\r\n\tif(n==1) return 0;\r\n\tsqrp(i,2,n)\
    \ if(n%i==0) return 0;\r\n\treturn 1;\r\n}\r\ninline bool is_int(const ld n){\
    \ return n == std::floor(n); }\r\ninline bool is_sqr(const ll n){ return is_int(std::sqrt(n));\
    \ }\r\n} // Heileden\r\n\r\n/**\r\n * @brief \u30C6\u30F3\u30D7\u30EC\u30FC\u30C8\
    \r\n * @docs docs/template.md\r\n */\n#line 2 \"C++/structure/SparseTable.hpp\"\
    \n\r\n#line 5 \"C++/structure/SparseTable.hpp\"\ntemplate <class T> struct SparseTable\
    \ {\r\nprivate:\r\n    using F = std::function<T(T,T)>;\r\n    std::vector<std::vector<T>>\
    \ st;\r\n    std::vector<T> lookup;\r\n    F f;\r\npublic:\r\n    SparseTable(const\
    \ std::vector<T> &v, const F &f_) : f(f_) {\r\n        int b = 0;\r\n        while((1\
    \ << b) <= v.size()) ++b;\r\n        st.assign(b, std::vector<T>(1 << b));\r\n\
    \        for(size_t i = 0; i < v.size(); i++) {\r\n            st[0][i] = v[i];\r\
    \n        }\r\n        for(int i = 1; i < b; i++) {\r\n            for(int j =\
    \ 0; j + (1 << i) <= (1 << b); j++) {\r\n                st[i][j] = f(st[i - 1][j],\
    \ st[i - 1][j + (1 << (i - 1))]);\r\n            }\r\n        }\r\n        lookup.resize(v.size()\
    \ + 1);\r\n        for(int i = 2; i < lookup.size(); i++) {\r\n            lookup[i]\
    \ = lookup[i >> 1] + 1;\r\n        }\r\n    }\r\n    inline T query(const T l,\
    \ const T r) {\r\n        int b = lookup[r - l];\r\n        return f(st[b][l],\
    \ st[b][r - (1 << b)]);\r\n    }\r\n    template <class Boolean=bool> inline int\
    \ min_left(const int x, const Boolean &fn) {\r\n        if(!x) return 0;\r\n \
    \       int ok=x, ng=-1;\r\n        while(abs(ok-ng)>1) {\r\n            int mid=(ok+ng)/2;\r\
    \n            (fn(query(mid,x)-1)?ok:ng)=mid;\r\n        }\r\n        return ok;\r\
    \n    }\r\n    template <class Boolean=bool> inline int max_right(const int x,\
    \ const Boolean &fn) {\r\n        if(x==lookup.size()-1) return lookup.size()-1;\r\
    \n        int ok=x, ng=lookup.size();\r\n        while(abs(ok-ng)>1) {\r\n   \
    \         int mid=(ok+ng)/2;\r\n            (fn(query(x,mid))?ok:ng)=mid;\r\n\
    \        }\r\n        return ok;\r\n    }\r\n};\r\n/**\r\n * @brief Sparse Table\r\
    \n * @see https://ei1333.github.io/luzhiled/snippets/structure/sparse-table.html\r\
    \n */\n#line 7 \"test/stable.test.cpp\"\nusing namespace std;\nusing namespace\
    \ zia_qu;\nusing namespace Lady_sANDy;\nusing namespace Heileden;\nint main()\
    \ {\n\tVvyLw::wa_haya_exe();\n\tnow(start);\n\t/*INT(t); while(t--)//*/\n\tVvyLw::solve();\n\
    \tnow(stop);\n\ttime(start, stop);\n}\n\n// --------------------------------------------------------------------------------------------------------------\n\
    \n\nvoid VvyLw::solve() {\n\tINT(n,q);\n    VEC(int,a,n);\n    SparseTable<int>\
    \ st(a,[](int a, int b){ return min(a,b); });\n    while(q--) {\n        INT(l,r);\n\
    \        out(st.query(l,r));\n    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/staticrmq\"\n/*#pragma\
    \ GCC optimize(\"O3\")\n#pragma GCC optimize(\"unroll-loops\")//*/\n//#pragma\
    \ GCC target(\"sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native\")\n#include\
    \ \"C++/template.hpp\"\n#include \"C++/structure/SparseTable.hpp\"\nusing namespace\
    \ std;\nusing namespace zia_qu;\nusing namespace Lady_sANDy;\nusing namespace\
    \ Heileden;\nint main() {\n\tVvyLw::wa_haya_exe();\n\tnow(start);\n\t/*INT(t);\
    \ while(t--)//*/\n\tVvyLw::solve();\n\tnow(stop);\n\ttime(start, stop);\n}\n\n\
    // --------------------------------------------------------------------------------------------------------------\n\
    \n\nvoid VvyLw::solve() {\n\tINT(n,q);\n    VEC(int,a,n);\n    SparseTable<int>\
    \ st(a,[](int a, int b){ return min(a,b); });\n    while(q--) {\n        INT(l,r);\n\
    \        out(st.query(l,r));\n    }\n}"
  dependsOn:
  - C++/template.hpp
  - C++/timer.hpp
  - C++/mypair.hpp
  - C++/constance.hpp
  - C++/myvector.hpp
  - C++/io/input.hpp
  - C++/io/output.hpp
  - C++/math/divisor.hpp
  - C++/math/primefactor.hpp
  - C++/math/primetable.hpp
  - C++/math/primefactortable.hpp
  - C++/math/prefixsum.hpp
  - C++/math/kthrooti.hpp
  - C++/structure/SparseTable.hpp
  isVerificationFile: true
  path: test/stable.test.cpp
  requiredBy: []
  timestamp: '2024-02-19 13:17:33+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/stable.test.cpp
layout: document
redirect_from:
- /verify/test/stable.test.cpp
- /verify/test/stable.test.cpp.html
title: test/stable.test.cpp
---
