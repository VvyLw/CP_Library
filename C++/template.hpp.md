---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
  - icon: ':warning:'
    path: C++/Modint.hpp
    title: C++/Modint.hpp
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
    path: test/ftree.test.cpp
    title: test/ftree.test.cpp
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
    links:
    - https://gist.github.com/naskya/1e5e5cd269cfe16a76988378a60e2ca3
  bundledCode: "#line 1 \"C++/template.hpp\"\n#pragma GCC diagnostic ignored \"-Wunused-parameter\"\
    \r\n#pragma GCC diagnostic ignored \"-Wsign-compare\"\r\n#pragma GCC diagnostic\
    \ ignored \"-Wdeprecated-copy\"\r\n#include <bits/stdc++.h>\r\n#include <ext/pb_ds/assoc_container.hpp>\r\
    \n#include <ext/pb_ds/tree_policy.hpp>\r\nusing namespace std;\r\nusing namespace\
    \ __gnu_pbds;\r\nnamespace VvyLw {\r\ninline void wa_haya_exe() noexcept { cin.tie(nullptr)\
    \ -> sync_with_stdio(false); }\r\nvoid solve();\r\n} // VvyLw\r\nmt19937 EhaL(hash<string>()(\"\
    Huitloxopetl\"));\r\nmt19937 Random() {\r\n  random_device seed_gen;\r\n  mt19937\
    \ engine {seed_gen()};\r\n  return engine;\r\n}\r\nusing Timer = chrono::system_clock::time_point;\r\
    \n[[maybe_unused]] Timer start, stop;\r\n#if local\r\nvoid now(Timer &t){ t =\
    \ chrono::system_clock::now(); }\r\nvoid time(const Timer &t1, const Timer &t2){\
    \ cerr << chrono::duration_cast<chrono::milliseconds>(t2-t1).count() << \"ms\\\
    n\"; }\r\n#else\r\n[[maybe_unused]] void now(Timer &t){ void(0); }\r\n[[maybe_unused]]\
    \ void time(const Timer &t1, const Timer &t2){ void(0); }\r\n#endif\r\n\r\n//\
    \ --------------------------------------------------------------------------------------------------------------\r\
    \n\r\n#define overload4(_1,_2,_3,_4,name,...) name\r\n#define overload3(_1,_2,_3,name,...)\
    \ name\r\n#define rep1(n) for(ll i=0; i<(n); ++i)\r\n#define rep2(i,n) for(ll\
    \ i=0; i<(n); ++i)\r\n#define rep3(i,a,b) for(ll i=(a); i<=(b); ++i)\r\n#define\
    \ rep4(i,a,b,c) for(ll i=(a); i<=(b); i+=(c))\r\n#define rep(...) overload4(__VA_ARGS__,rep4,rep3,rep2,rep1)(__VA_ARGS__)\r\
    \n#define rvp1(n) for(ll i=(n)-1; i>=0; i--)\r\n#define rvp2(i,n) for(ll i=(n)-1;\
    \ i>=0; i--)\r\n#define rvp3(i,a,b) for(ll i=(a); i>=(b); i--)\r\n#define rvp4(i,a,b,c)\
    \ for(ll i=(a); i>=(b); i-=(c))\r\n#define rvp(...) overload4(__VA_ARGS__,rvp4,rvp3,rvp2,rvp1)(__VA_ARGS__)\r\
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
    \ntemplate <class T> using L = numeric_limits<T>;\r\nconstexpr int dx[]={0,0,0,-1,1,-1,-1,1,1};\r\
    \nconstexpr int dy[]={0,-1,1,0,0,-1,1,-1,1};\r\nconstexpr int MOD = 0x3b800001;\r\
    \nconstexpr int M0D = 1e9+7;\r\nconstexpr int INF = 1<<30;\r\nconstexpr ll LINF\
    \ = (1LL<<61)-1;\r\nconstexpr ld DINF = L<ld>::infinity();\r\ntemplate <class\
    \ T> constexpr T LIM = L<T>::max();\r\n#if __cplusplus >= 202100L\r\nconstexpr\
    \ ld PI = numbers::pi;\r\nconstexpr ld E = numbers::e;\r\n#else\r\nconst ld PI\
    \ = acos(-1);\r\nconst ld E = 2.718281828459045;\r\n#endif\r\nnamespace vectors\
    \ {\r\ntemplate <class T> using V = vector<T>;\r\nusing vi = V<ll>;\r\nusing vu\
    \ = V<ul>;\r\nusing vd = V<ld>;\r\nusing vc = V<char>;\r\nusing vs = V<string>;\r\
    \nusing vb = V<bool>;\r\nusing wi = V<vi>;\r\nusing wu = V<vu>;\r\nusing wd =\
    \ V<vd>;\r\nusing wc = V<vc>;\r\nusing ws = V<vs>;\r\nusing wb = V<vb>;\r\ntemplate\
    \ <class T, class U> inline V<U> ndiv(T&& n, U&& v) noexcept {\r\n  return V<U>(forward<T>(n),\
    \ forward<U>(v));\r\n}\r\ntemplate <class T, class... Ts> inline decltype(auto)\
    \ ndiv(T&& n, Ts&&... v) noexcept {\r\n  return V<decltype(ndiv(forward<Ts>(v)...))>(forward<T>(n),\
    \ ndiv(forward<Ts>(v)...));\r\n}\r\ntemplate <class T> constexpr V<T>& operator++(V<T>&\
    \ v) noexcept { each(el,v) el++; return v; }\r\ntemplate <class T> constexpr V<T>&\
    \ operator--(V<T>& v) noexcept { each(el,v) el--; return v; }\r\ntemplate <class\
    \ T, class U> constexpr V<T>& operator+=(V<T>& v, const U x) noexcept { each(el,v)\
    \ el+=x; return v; }\r\ntemplate <class T, class U> constexpr V<T>& operator-=(V<T>&\
    \ v, const U x) noexcept { each(el,v) el-=x; return v; }\r\ntemplate <class T,\
    \ class U> constexpr V<T>& operator*=(V<T>& v, const U x) noexcept { each(el,v)\
    \ el*=x; return v; }\r\ntemplate <class T, class U> constexpr V<T>& operator/=(V<T>&\
    \ v, const U x) noexcept { each(el,v) el/=x; return v; }\r\ntemplate <class T,\
    \ class U> constexpr V<T>& operator%=(V<T>& v, const U x) noexcept { each(el,v)\
    \ el%=x; return v; }\r\ntemplate <class T, class U> constexpr V<T> operator+(const\
    \ V<T>& v, const U x) noexcept { V<T> res = v; res+=x; return res; }\r\ntemplate\
    \ <class T, class U> constexpr V<T> operator-(const V<T>& v, const U x) noexcept\
    \ { V<T> res = v; res-=x; return res; }\r\ntemplate <class T, class U> constexpr\
    \ V<T> operator*(const V<T>& v, const U x) noexcept { V<T> res = v; res*=x; return\
    \ res; }\r\ntemplate <class T, class U> constexpr V<T> operator/(const V<T>& v,\
    \ const U x) noexcept { V<T> res = v; res/=x; return res; }\r\ntemplate <class\
    \ T, class U> constexpr V<T> operator%(const V<T>& v, const U x) noexcept { V<T>\
    \ res = v; res%=x; return res; }\r\n} // vectors\r\nusing namespace vectors;\r\
    \nnamespace pairs {\r\ntemplate <class T, class U> using P = pair<T, U>;\r\ntemplate\
    \ <class T> using PP = P<T,T>;\r\nusing pi = PP<ll>;\r\nusing pd = PP<ld>;\r\n\
    using pc = PP<char>;\r\nusing ps = PP<string>;\r\ntemplate <class T> constexpr\
    \ PP<T> operator+(const PP<T>& a, const PP<T>& b) noexcept { return {a.first +\
    \ b.first, a.second + b.second}; }\r\ntemplate <class T> constexpr PP<T> operator-(const\
    \ PP<T>& a, const PP<T>& b) noexcept { return {a.first - b.first, a.second - b.second};\
    \ }\r\ntemplate <class T> constexpr PP<T> operator-(const PP<T>& a) noexcept {\
    \ return {-a.first, -a.second}; }\r\ntemplate <class T, class U> constexpr PP<T>\
    \ operator*(const PP<T>& a, const U& b) noexcept { return {a.first * b, a.second\
    \ * b}; }\r\ntemplate <class T, class U> constexpr PP<T> operator/(const PP<T>&\
    \ a, const U& b) noexcept { return {a.first / b, a.second / b}; }\r\ntemplate\
    \ <class T> constexpr PP<T>& operator+=(PP<T>& a, const PP<T>& b) noexcept { return\
    \ a = a + b; }\r\ntemplate <class T> constexpr PP<T>& operator-=(PP<T>& a, const\
    \ PP<T>& b) noexcept { return a = a - b; }\r\ntemplate <class T, class U> constexpr\
    \ PP<T>& operator*=(PP<T>& a, const U& b) noexcept { return a = a * b; }\r\ntemplate\
    \ <class T, class U> PP<T>& operator/=(PP<T>& a, const U& b) noexcept { return\
    \ a = a / b; }\r\ntemplate <class T> constexpr bool operator==(const PP<T> &p,\
    \ const PP<T> &q) noexcept { return p.first==q.first && p.second==q.second; }\r\
    \ntemplate <class T> constexpr bool operator!=(const PP<T> &p, const PP<T> &q)\
    \ noexcept { return !(p==q); }\r\ntemplate <class T> constexpr bool operator<(const\
    \ PP<T> &p, const PP<T> &q) noexcept { if(p.first==q.first) return p.second<q.second;\
    \ return p.first<q.first; }\r\ntemplate <class T> constexpr bool operator<=(const\
    \ PP<T> &p, const PP<T> &q) noexcept { if(p.first==q.first) return p.second<=q.second;\
    \ return p.first<q.first; }\r\ntemplate <class T> constexpr bool operator>(const\
    \ PP<T> &p, const PP<T> &q) noexcept { if(p.first==q.first) return p.second>q.second;\
    \ return p.first>q.first; }\r\ntemplate <class T> constexpr bool operator>=(const\
    \ PP<T> &p, const PP<T> &q) noexcept { if(p.first==q.first) return p.second>=q.second;\
    \ return p.first>q.first; }\r\ntemplate <class T, class U> constexpr bool operator==(const\
    \ P<T,U> &p, const P<T,U> &q) noexcept { return p.first==q.first && p.second==q.second;\
    \ }\r\ntemplate <class T, class U> constexpr bool operator!=(const P<T,U> &p,\
    \ const P<T,U> &q) noexcept { return !(p==q); }\r\ntemplate <class T, class U>\
    \ constexpr bool operator<(const P<T,U> &p, const P<T,U> &q) noexcept { if(p.first==q.first)\
    \ return p.second<q.second; return p.first<q.first; }\r\ntemplate <class T, class\
    \ U> constexpr bool operator<=(const P<T,U> &p, const P<T,U> &q) noexcept { if(p.first==q.first)\
    \ return p.second<=q.second; return p.first<q.first; }\r\ntemplate <class T, class\
    \ U> constexpr bool operator>(const P<T,U> &p, const P<T,U> &q) noexcept { if(p.first==q.first)\
    \ return p.second>q.second; return p.first>q.first; }\r\ntemplate <class T, class\
    \ U> constexpr bool operator>=(const P<T,U> &p, const P<T,U> &q) noexcept { if(p.first==q.first)\
    \ return p.second>=q.second; return p.first>q.first; }\r\ntemplate <class T> inline\
    \ PP<T> rotate(const PP<T>& a){ return {-a.second, a.first}; } // 90 degree ccw\r\
    \ntemplate <class T> inline pd rotate(const PP<T>& a, const int ang) {\r\n  assert(0<=ang\
    \ && ang<360);\r\n  const ld rad=PI*ang/180;\r\n  return {a.first*cosl(rad)-a.second*sinl(rad),\
    \ a.first*sinl(rad)+a.second*cosl(rad)};\r\n}\r\ntemplate <class T> inline T dot(const\
    \ PP<T>& a, const PP<T>& b){ return a.first * b.first + a.second * b.second; }\r\
    \ntemplate <class T> inline T cross(const PP<T>& a, const PP<T>& b){ return dot(rotate(a),\
    \ b); }\r\ntemplate <class T> inline T square(const PP<T>& a){ return dot(a, a);\
    \ }\r\ntemplate <class T> inline ld grad(const PP<T>& a){ assert(a.first); return\
    \ 1.0L * a.second / a.first; }\r\ntemplate <class T> inline ld abs(const PP<T>&\
    \ a){ return hypotl(a.first, a.second); }\r\ntemplate <class T> inline T lcm(const\
    \ PP<T>& a){ return std::lcm(a.first, a.second); }\r\ntemplate <class T> inline\
    \ T gcd(const PP<T>& a){ return std::gcd(a.first, a.second); }\r\ntemplate <class\
    \ T> inline PP<T> extgcd(const PP<T> &p) {\r\n  T x=1,y=0,t1=0,t2=0,t3=1,a,b;\r\
    \n  tie(a,b)=p;\r\n  while(b) {\r\n    t1=a/b,a-=t1*b;\r\n    swap(a,b);\r\n \
    \   x-=t1*t2;\r\n    swap(x,t2);\r\n    y-=t1*t3;\r\n    swap(y,t3);\r\n  }\r\n\
    \  return {x,y};\r\n}\r\ntemplate <class T> inline PP<T> normalize(PP<T> a) {\r\
    \n  if(a == PP<T>{}) return a;\r\n  a /= gcd(a);\r\n  if(a < PP<T>{}) a = -a;\r\
    \n  return a;\r\n}\r\ntemplate <class T, class U> inline P<U,T> swap(const P<T,U>\
    \ &p){ P<U,T> ret={p.second,p.first}; return ret; }\r\ntemplate <class T, class\
    \ U> inline V<P<U,T>> swap(const V<P<T,U>> &vp) {\r\n  V<P<U,T>> ret;\r\n  each(el,vp)\
    \ ret.emplace_back(swap(el));\r\n  return ret;\r\n}\r\ntemplate <class T, class\
    \ U> inline V<T> first(const V<P<T,U>> &vp) {\r\n  V<T> res;\r\n  each(el,vp)\
    \ res.emplace_back(el.first);\r\n  return res;\r\n}\r\ntemplate <class T, class\
    \ U> inline V<U> second(const V<P<T,U>> &vp) {\r\n  V<U> res;\r\n  each(el,vp)\
    \ res.emplace_back(el.second);\r\n  return res;\r\n}\r\n} // pairs\r\nusing namespace\
    \ pairs;\r\ntemplate <size_t N> using ti = array<ll, N>;\r\nusing tri = ti<3>;\r\
    \ntemplate <class T> using pq = priority_queue<T>;\r\ntemplate <class T> using\
    \ pqr = priority_queue<T,V<T>,greater<T>>;\r\ntemplate <class T> using Tree =\
    \ tree<T,null_type,less<T>,rb_tree_tag,tree_order_statistics_node_update>;\r\n\
    template <class T> using TREE = tree<T,null_type,greater<T>,rb_tree_tag,tree_order_statistics_node_update>;\r\
    \ntemplate <class T, class U> inline bool chmax(T& a, const U& b){ if(a<b){ a=b;\
    \ return 1; } return 0; }\r\ntemplate <class T, class U> inline bool chmin(T&\
    \ a, const U& b){ if(a>b){ a=b; return 1; } return 0; }\r\ntemplate <class T,\
    \ class U> inline bool overflow_if_add(const T a, const U b){ return (LIM<T>-a)<b;\
    \ }\r\ntemplate <class T, class U> inline bool overflow_if_mul(const T a, const\
    \ U b){ return (LIM<T>/a)<b; }\r\n\r\nnamespace IO {\r\nostream &operator<<(ostream\
    \ &dest, i128 value) {\r\n  ostream::sentry s(dest);\r\n  if(s) {\r\n    u128\
    \ tmp = value < 0 ? -value : value;\r\n    char buffer[128];\r\n    char *d =\
    \ end(buffer);\r\n    do {\r\n      --d;\r\n      *d = \"0123456789\"[tmp % 10];\r\
    \n      tmp /= 10;\r\n    } while(tmp != 0);\r\n    if(value < 0) {\r\n      --d;\r\
    \n      *d = '-';\r\n    }\r\n    int len = end(buffer) - d;\r\n    if(dest.rdbuf()->sputn(d,\
    \ len) != len) {\r\n      dest.setstate(ios_base::badbit);\r\n    }\r\n  }\r\n\
    \  return dest;\r\n}\r\ntemplate <class T, class U> istream& operator>>(istream\
    \ &is, P<T, U> &p){ is >> p.first >> p.second; return is; }\r\ntemplate <class\
    \ T, size_t N> istream& operator>>(istream &is, array<T, N> &a){ each(el,a) is\
    \ >> el; return is; }\r\ntemplate <class T> istream& operator>>(istream &is, V<T>\
    \ &v){ each(el,v) is >> el; return is; }\r\ntemplate <class T> istream& operator>>(istream\
    \ &is, deque<T> &dq){ each(el,dq) is >> el; return is; }\r\ntemplate <class T>\
    \ inline bool in(T& x){ cin >> x; return 1; }\r\ntemplate <class Head, class...\
    \ Tail> inline bool in(Head& head, Tail&... tail){ in(head); in(tail...); return\
    \ 1; }\r\ntemplate <class T, class U> ostream& operator<<(ostream &os, const P<T,\
    \ U> &p){ os << p.first << ' ' << p.second; return os; }\r\ntemplate <class T,\
    \ size_t N> ostream& operator<<(ostream &os, const array<T, N> &a){ if(a.size()){\
    \ os << a.front(); for(auto i=a.begin(); ++i!=a.end();){ os << ' ' << *i; } }\
    \ return os; }\r\ntemplate <class T> ostream& operator<<(ostream &os, const V<T>\
    \ &v){ if(v.size()){ os << v.front(); for(auto i=v.begin(); ++i!=v.end();){ os\
    \ << ' ' << *i; } } return os; }\r\ntemplate <class K, class V> ostream& operator<<(ostream\
    \ &os, const map<K, V> &m){ if(m.size()){ os << m.begin()->first << ' ' << m.begin()->second;\
    \ for(auto i=m.begin(); ++i!=m.end();){ os << '\\n' << i->first << ' ' << i->second;\
    \ } } return os; }\r\ntemplate <class T> ostream& operator<<(ostream &os, const\
    \ set<T> &st){ if(st.size()){ os << *st.begin(); for(auto i=st.begin(); ++i!=st.end();){\
    \ os << ' ' << *i; } } return os; }\r\ntemplate <class T> ostream& operator<<(ostream\
    \ &os, const multiset<T> &ms){ if(ms.size()){ os << *ms.begin(); for(auto i=ms.begin();\
    \ ++i!=ms.end();){ os << ' ' << *i; } } return os; }\r\ntemplate <class T> ostream&\
    \ operator<<(ostream &os, const deque<T> &dq){ if(dq.size()){ os << dq.front();\
    \ for(auto i=dq.begin(); ++i!=dq.end();){ os << ' ' << *i; } } return os; }\r\n\
    inline void out(){ cout << '\\n'; }\r\ntemplate <bool flush=false, class T> inline\
    \ void out(const T& x){ cout << x << '\\n'; if(flush) cout.flush(); }\r\ntemplate\
    \ <bool flush=false, class Head, class... Tail> inline void out(const Head& head,\
    \ const Tail&... tail){ cout << head << ' '; out<flush>(tail...); }\r\ntemplate\
    \ <bool flush=false, class T> inline void vout(const T& v){ cout << v << '\\n';\
    \ if(flush) cout.flush(); }\r\ntemplate <bool flush=false, class T> inline void\
    \ vout(const V<T>& v){ rep(v.size()) cout << v[i] << '\\n'; if(flush) cout.flush();\
    \ }\r\ntemplate <bool flush=false, class Head, class... Tail> inline void vout(const\
    \ Head& head, const Tail&... tail){ cout << head << '\\n'; vout<flush>(tail...);\
    \ }\r\ninline void fix(const short x){ cout << fixed << setprecision(x); }\r\n\
    inline void alpha(){ cout << boolalpha; }\r\n#define INT(...) int __VA_ARGS__;\
    \ in(__VA_ARGS__)\r\n#define LL(...) ll __VA_ARGS__; in(__VA_ARGS__)\r\n#define\
    \ UL(...) ul __VA_ARGS__; in(__VA_ARGS__)\r\n#define LD(...) ld __VA_ARGS__; in(__VA_ARGS__)\r\
    \n#define CHR(...) char __VA_ARGS__; in(__VA_ARGS__)\r\n#define STR(...) string\
    \ __VA_ARGS__; in(__VA_ARGS__)\r\n#define VEC(type,name,size) V<type> name(size);\
    \ in(name)\r\n#define WEC(type,name,h,w) V<V<type>> name(h,V<type>(w)); in(name)\r\
    \n#define fin(...) do{ out(__VA_ARGS__); return; }while(false)\r\n} // IO\r\n\
    using namespace IO;\r\n\r\nnamespace zia_qu {\r\n#ifdef local\r\n//https://gist.github.com/naskya/1e5e5cd269cfe16a76988378a60e2ca3\r\
    \n#include <../debug_print.hpp>\r\n#define debug(...) debug_print::multi_print(#__VA_ARGS__,\
    \ __VA_ARGS__)\r\n#else\r\n#define debug(...) static_cast<void>(0)\r\n#endif\r\
    \n#define elif else if\r\n#define eid(el,v) size_t(&el-&v[0])\r\n#define bif(bit,tar)\
    \ if(((bit)>>(tar))&1)\r\n#define nxp(x) next_permutation(all(x))\r\n#define prp(x)\
    \ prev_permutation(all(x))\r\n#define strpl(s,a,b) regex_replace(s,regex(a),b)\r\
    \n#define rgxsr(s,rgx) regex_search(s,regex(rgx))\r\ninline void YES(const bool\
    \ ok=1){ out(ok?\"YES\":\"NO\"); }\r\ninline void NO(const bool ok=1){ YES(!ok);\
    \ }\r\ninline void Yes(const bool ok=1){ out(ok?\"Yes\":\"No\"); }\r\ninline void\
    \ No(const bool ok=1){ Yes(!ok); }\r\ninline void yes(const bool ok=1){ out(ok?\"\
    yes\":\"no\"); }\r\ninline void no(const bool ok=1){ yes(!ok); }\r\ntemplate <class\
    \ T> inline T sqr(const T x){ return x*x; }\r\ntemplate <class T> inline T cub(const\
    \ T x){ return x*x*x; }\r\ntemplate <class T> inline T Mod(const T x, const T\
    \ m){ return (x+m)%m; }\r\ntemplate <class T> inline T Pow(T a, T b, const T mod=0)\
    \ {\r\n  T res=1;\r\n  if(mod) {\r\n    res%=mod;\r\n    a%=mod;\r\n  }\r\n  while(b>0)\
    \ {\r\n    if(b&1) res*=a;\r\n    if(mod) res%=mod;\r\n    a*=a;\r\n    if(mod)\
    \ a%=mod;\r\n    b>>=1;\r\n  }\r\n  return res;\r\n}\r\ninline ll Ceil(const ld\
    \ x, const ll m){ return ceil(x/m); }\r\ninline ld Round(const ld x, const ll\
    \ m, const short fx=0){ if(!fx) return round(x/m); const ul y=Pow<ul>(10,fx);\
    \ return round((x*y)/m)/y; }\r\ninline ld Log(const ll x, const ld base=2){ return\
    \ log2(x)/log2(base); }\r\ninline int bitdigit(const ll x){ return 64-__builtin_clzll(x);\
    \ }\r\ninline int popcnt(const ll x){ return __builtin_popcountll(x); }\r\ninline\
    \ int fione(const ll x){ return __builtin_ffsll(x); }\r\ninline int zrcnt(const\
    \ ll x){ return __builtin_ctzll(x); }\r\ntemplate <class T=ll> inline bool scope(const\
    \ T a, const T x, const T b){ return a <= x && x <= b; }\r\ninline bool isupper(const\
    \ char c){ return std::isupper(c); }\r\ninline bool isupper(const string &s){\
    \ bool ok=1; each(el,s) ok&=isupper(el); return ok; }\r\ninline bool islower(const\
    \ char c){ return std::islower(c); }\r\ninline bool islower(const string &s){\
    \ bool ok=1; each(el,s) ok&=islower(el); return ok; }\r\ninline bool isalpha(const\
    \ char c){ return std::isalpha(c); }\r\ninline bool isalpha(const string &s){\
    \ bool ok=1; each(el,s) ok&=isalpha(el); return ok; }\r\ninline bool isdigit(const\
    \ char c){ return std::isdigit(c); }\r\ninline bool isdigit(const string &s){\
    \ bool ok=1, neg=s.front()=='-'; each(el,s){ if(neg){ neg=0; continue; } ok&=isdigit(el);\
    \ } return ok; }\r\ninline bool isalnum(const char c){ return std::isalnum(c);\
    \ }\r\ninline bool isalnum(const string &s){ bool ok=1; each(el,s) ok&=isalnum(el);\
    \ return ok; }\r\ninline bool isspace(const char c){ return std::isspace(c); }\r\
    \ninline bool isspace(const string &s){ bool ok=1; each(el,s) ok&=isspace(el);\
    \ return ok; }\r\ninline bool ispunct(const char c){ return std::ispunct(c); }\r\
    \ninline bool ispunct(const string &s){ bool ok=1; each(el,s) ok&=ispunct(el);\
    \ return ok; }\r\ninline bool isprint(const char c){ return std::isprint(c); }\r\
    \ninline bool isprint(const string &s){ bool ok=1; each(el,s) ok&=isprint(el);\
    \ return ok; }\r\ninline ll strins(string &s, const ll id, const string &t){ s.insert(id,t);\
    \ return s.size(); }\r\ninline string toupper(string s){ each(c,s) c=std::toupper(c);\
    \ return s; }\r\ninline string tolower(string s){ each(c,s) c=std::tolower(c);\
    \ return s; }\r\ninline vi ten_to_adic(ll n, const short base) {\r\n  vi res;\r\
    \n  while(n) {\r\n    res.emplace_back(n%base);\r\n    n/=base;\r\n  }\r\n  return\
    \ res;\r\n}\r\ninline ll adic_to_ten(const vi &v, const short base) {\r\n  ll\
    \ res=0;\r\n  each(el,v) {\r\n    res+=Pow<ll>(base,eid(el,v))*el;\r\n  }\r\n\
    \  return res;\r\n}\r\ninline string to_hex(const ll x) {\r\n  stringstream ss;\r\
    \n  ss<<hex<<x;\r\n  string s=ss.str();\r\n  //s=toupper(s);\r\n  return s;\r\n\
    }\r\ninline string to_oct(const ll x) {\r\n  stringstream s;\r\n  s<<oct<<x;\r\
    \n  return s.str();\r\n}\r\ninline string to_bin(const ll x) {\r\n  stringstream\
    \ ss;\r\n  ss<<bitset<64>(x);\r\n  string s=ss.str();\r\n  reverse(all(s));\r\n\
    \  s.resize(ten_to_adic(x,2).size());\r\n  reverse(all(s));\r\n  return s;\r\n\
    }\r\ninline ll to_ten(const string &s, const short base){ return stoll(s,nullptr,base);\
    \ }\r\ninline i128 stoL(const string &s) {\r\n  assert(isdigit(s));\r\n  bool\
    \ neg=s.front()=='-';\r\n  i128 ret = 0;\r\n  each(el,s) {\r\n    if(neg) {\r\n\
    \      neg=0;\r\n      continue;\r\n    }\r\n    ret = 10 * ret + el - '0';\r\n\
    \  }\r\n  if(s.front()=='-') ret=-ret;\r\n  return ret;\r\n}\r\ntemplate <class...\
    \ Ts> constexpr ul sygcd(const Ts... a) noexcept { vector v=initializer_list<common_type_t<Ts...>>{a...};\
    \ ul g=0; each(el,v) g=gcd(g,el); return g; }\r\ntemplate <class... Ts> constexpr\
    \ ul sylcm(const Ts... a) noexcept { vector v=initializer_list<common_type_t<Ts...>>{a...};\
    \ ul l=1; each(el,v) l=lcm(l,el); return l; }\r\ntemplate <class... Ts> constexpr\
    \ auto symin(const Ts... a) noexcept { return min(initializer_list<common_type_t<Ts...>>{a...});\
    \ }\r\ntemplate <class... Ts> constexpr auto symax(const Ts... a) noexcept { return\
    \ max(initializer_list<common_type_t<Ts...>>{a...}); }\r\ntemplate <class K, class\
    \ U> inline V<K> kyl(const map<K,U> &m, const U val) {\r\n  V<K> keys;\r\n  for(auto\
    \ it=m.cbegin(); it!=m.cend(); ++it) {\r\n    if(it->second==val) keys.emplace_back(it->first);\r\
    \n  }\r\n  return keys;\r\n}\r\ntemplate <class K, class V> inline K kymin(const\
    \ map<K,V> &m){ return m.begin()->first; }\r\ntemplate <class K, class V> inline\
    \ K kymax(const map<K,V> &m){ return m.rbegin()->first; }\r\ntemplate <class K,\
    \ class V> inline V kymin_v(const map<K,V> &m){ return m.begin()->second; }\r\n\
    template <class K, class V> inline V kymax_v(const map<K,V> &m){ return m.rbegin()->second;\
    \ }\r\ntemplate <class K, class V> inline V vlmin(const map<K,V> &m){\r\n  const\
    \ auto pr = *min_element(all(m),[](P<K,V> const &x, P<K,V> const &y){ return x.second\
    \ < y.second; });\r\n  return pr.second;\r\n}\r\ntemplate <class K, class V> inline\
    \ V vlmax(const map<K,V> &m){\r\n  const auto pr = *max_element(all(m),[](P<K,V>\
    \ const &x, P<K,V> const &y){ return x.second < y.second; });\r\n  return pr.second;\r\
    \n}\r\ntemplate <class K, class V> inline K vlmin_k(const map<K,V> &m){\r\n  const\
    \ auto pr = *min_element(all(m),[](P<K,V> const &x, P<K,V> const &y){ return x.second\
    \ < y.second; });\r\n  return pr.first;\r\n}\r\ntemplate <class K, class V> inline\
    \ K vlmax_k(const map<K,V> &m){\r\n  const auto pr = *max_element(all(m),[](P<K,V>\
    \ const &x, P<K,V> const &y){ return x.second < y.second; });\r\n  return pr.first;\r\
    \n}\r\n} // zia qu\r\n\r\nnamespace Lady_sANDy {\r\ntemplate <class T> inline\
    \ void rev(T& v){ reverse(all(v)); }\r\ntemplate <class T> inline void rev(T&\
    \ v, const int a, const int b){ reverse(all(v,a,b+1)); }\r\ntemplate <class T>\
    \ inline T revd(const T& v){ auto c=v; rev(c); return c; }\r\ntemplate <class\
    \ T> inline T revd(const T& v, const int a, const int b){ auto c=v; rev(c,a,b);\
    \ return c; }\r\ntemplate <class T> inline void Sort(T& v){ sort(all(v)); }\r\n\
    template <class T> inline void Sort(T& v, const int a, const int b){ sort(all(v,a,b+1));\
    \ }\r\ntemplate <class T> inline T sorted(const T& v){ auto c=v; Sort(c); return\
    \ c; }\r\ntemplate <class T> inline T sorted(const T& v, const int a, const int\
    \ b){ auto c=v; Sort(c,a,b); return c; }\r\ntemplate <class T> inline void Sortt(T&\
    \ v){ sort(rall(v)); }\r\ntemplate <class T> inline void Sortt(T& v, const int\
    \ a, const int b){ sort(rall(v,v.size()-b-1,v.size()-a)); }\r\ntemplate <class\
    \ T> inline T Sorted(const T& v){ auto c=v; Sortt(c); return c; }\r\ntemplate\
    \ <class T> inline T Sorted(const T& v, const int a, const int b){ auto c=v; Sortt(c,a,b);\
    \ return c; }\r\ntemplate <class T> inline void Sorth(T& v){ make_heap(all(v));\
    \ sort_heap(all(v)); }\r\ntemplate <class T> inline T mrg(const T& a, const T&\
    \ b){ T res; merge(all(a),all(b),back_inserter(res)); return res; }\r\ntemplate\
    \ <class T> inline T Min(const V<T>& v){ return *min_element(all(v)); }\r\ntemplate\
    \ <class T> inline T Min(const V<T>& v, const int a, const int b){ return *min_element(all(v,a,b+1));\
    \ }\r\ntemplate <class T> inline T Max(const V<T>& v){ return *max_element(all(v));\
    \ }\r\ntemplate <class T> inline T Max(const V<T>& v, const int a, const int b){\
    \ return *max_element(all(v,a,b+1)); }\r\ntemplate <class T> inline int Min_i(const\
    \ T& v){ return min_element(all(v))-v.begin(); }\r\ntemplate <class T> inline\
    \ int Max_i(const T& v){ return max_element(all(v))-v.begin(); }\r\ntemplate <class\
    \ T, class U> inline int LB(const T& v, const U x){ return lower_bound(all(v),x)-v.begin();\
    \ }\r\ntemplate <class T, class U> inline int UB(const T& v, const U x){ return\
    \ upper_bound(all(v),x)-v.begin(); }\r\ntemplate <class T, class U> inline bool\
    \ BS(const T& v, const U x){ return binary_search(all(v),x); }\r\ntemplate <class\
    \ T, class U, class Boolean=bool> inline bool BS(const T& v, const U x, const\
    \ Boolean &fn){ return binary_search(all(v),x,fn); }\r\ntemplate <class T, class\
    \ Boolean=bool> inline bool All(const T& v, const Boolean &fn){ return all_of(all(v),fn);\
    \ }\r\ntemplate <class T, class Boolean=bool> inline bool Exist(const T& v, const\
    \ Boolean &fn){ return any_of(all(v),fn); }\r\ntemplate <class T, class Boolean=bool>\
    \ inline int pt(T& v, const Boolean &fn){ auto p=partition(all(v),fn); return\
    \ p-v.begin(); }\r\ntemplate <class T, class Boolean=bool> inline int ptp(const\
    \ T& v, const Boolean &fn){ return partition_point(all(v),fn)-v.begin(); }\r\n\
    template <class T, class U> inline int fnd(const T& v, const U x){ auto itr=find(all(v),x);\
    \ return itr!=v.end()?itr-v.begin():-1; }\r\ntemplate <class T> inline int src(const\
    \ T& s, const T& t){ auto itr=search(all(s),all(t)); return itr!=s.end()?itr-s.begin():-1;\
    \ }\r\ntemplate <class T, class U> inline void rpl(T& v, const U fn, const U r){\
    \ replace(all(v),fn,r); }\r\ntemplate <class T, class U, class Boolean=bool> inline\
    \ void rplif(T& v, const Boolean &fn, const U r){ replace_if(all(v),fn,r); }\r\
    \ntemplate <class T, class Boolean=bool> inline ul cntif(const T& v, const Boolean\
    \ &fn){ return count_if(all(v),fn); }\r\ntemplate <class T> inline T Count(V<T>&\
    \ v, ll x){ if(!is_sorted(all(v))) Sort(v); return UB(v,x)-LB(v,x); }\r\ntemplate\
    \ <class T> inline T IP(const V<T>& v, const V<T>& u, T init){ return inner_product(all(v),u.begin(),init);\
    \ }\r\ninline vi iot(int n, ll init=0){ vi a(n); iota(all(a),init); return a;\
    \ }\r\ntemplate <class T, class U, class F> inline V<T> trans(const V<U>& v, const\
    \ F &fn){ V<T> res; transform(all(v),back_inserter(res),fn); return res; }\r\n\
    template <class T, class U> inline int ers(T& v, const U x){ v.erase(remove(all(v),x),v.end());\
    \ return v.size(); }\r\ntemplate <class T, class Boolean=bool> int ersif(T& v,\
    \ const Boolean &fn){ v.erase(remove_if(all(v),fn),v.end()); return v.size();\
    \ }\r\ntemplate <class T> inline int unq(T& v){ if(!is_sorted(all(v))) Sort(v);\
    \ v.erase(unique(all(v)),v.end()); return v.size(); }\r\ntemplate <class T> inline\
    \ T cp(const T& v){ T res; copy(all(v),back_inserter(res)); return res; }\r\n\
    template <class T> inline T cp(const T& v, const int a, const int b){ T res; copy(all(v,a,b),back_inserter(res));\
    \ return res; }\r\ntemplate <class T> inline void rtt(T& s, const int idx){ const\
    \ int id=zia_qu::Mod<int>(idx,s.size()); rotate(all(s,id),s.end()); }\r\ntemplate\
    \ <class T> inline void rtt(T& s, const int a, const int b, const int c){ rotate(all(s,a,b),s.end()-c);\
    \ }\r\ntemplate <class T> inline T setdif(const T& s, const T& t){ assert(is_sorted(all(s))&&is_sorted(all(t)));\
    \ T res; set_difference(all(s),all(t),inserter(res,end(res))); return res; }\r\
    \ntemplate <class T> inline T setsum(const T& s, const T& t){ assert(is_sorted(all(s))&&is_sorted(all(t)));\
    \ T res; set_union(all(s),all(t),inserter(res,end(res))); return res; }\r\ntemplate\
    \ <class T> inline T setmul(const T& s, const T& t){ assert(is_sorted(all(s))&&is_sorted(all(t)));\
    \ T res; set_intersection(all(s),all(t),inserter(res,end(res))); return res; }\r\
    \ntemplate <class T> inline V<T> adf(const V<T>& v){ V<T> a; adjacent_difference(all(v),back_inserter(a));\
    \ rtt(a,1); a.pop_back(); return a; }\r\ntemplate <class T, class F> inline V<T>\
    \ isum(const V<T> &v, const F &fn){ V<T> s{0}; inclusive_scan(all(v),back_inserter(s),fn);\
    \ return s; }\r\ntemplate <class T> inline V<T> rext(const V<T>& v, const int\
    \ size){ V<T> res; sample(all(v),back_inserter(res),size,Random()); return res;\
    \ }\r\ntemplate <class T> inline T rext(const V<T>& v){ V<T> res; sample(all(v),back_inserter(res),1,Random());\
    \ return res.front(); }\r\ntemplate <class T> inline ll vsum(const T &v){ return\
    \ accumulate(all(v),0LL); }\r\ntemplate <class T> inline ll vsum(const T &v, ll\
    \ a, ll b){ return accumulate(all(v,a,b),0LL); }\r\ntemplate <class T> inline\
    \ ld vdsum(const T &v){ return accumulate(all(v),0.0L); }\r\ntemplate <class T>\
    \ inline ld vdsum(const T &v, ll a, ll b){ return accumulate(all(v,a,b),0.0L);\
    \ }\r\ntemplate <class T> inline ll vmul(const T &v){ return accumulate(all(v),1LL,[](ll\
    \ acc,ll i){ return acc*i; }); }\r\ntemplate <class T> inline ll vmul(const T\
    \ &v, ll a, ll b){ return accumulate(all(v,a,b),1LL,[](ll acc,ll i){ return acc*i;\
    \ }); }\r\ntemplate <class T> inline ld vdmul(const T &v){ return accumulate(all(v),1.0L,[](ll\
    \ acc,ll i){ return acc*i; }); }\r\ntemplate <class T> inline ld vdmul(const T\
    \ &v, ll a, ll b){ return accumulate(all(v,a,b),1.0L,[](ll acc,ll i){ return acc*i;\
    \ }); }\r\n} // Lady s&y\r\n\r\nnamespace Heileden {\r\ntemplate <class T> inline\
    \ V<T> div(const T n) {\r\n  V<T> d;\r\n  sqrp(i,1,n) {\r\n    if(n%i==0) {\r\n\
    \      d.emplace_back(i);\r\n      if(i*i!=n) d.emplace_back(n/i);\r\n    }\r\n\
    \  }\r\n  Lady_sANDy::Sort(d);\r\n  return d;\r\n}\r\ntemplate <class T> inline\
    \ V<PP<T>> prmfct(T n) {\r\n  V<PP<T>> res;\r\n  sqrp(i,2,n) {\r\n    if(n%i!=0)\
    \ continue;\r\n    T tmp=0;\r\n    while(n%i==0) {\r\n      tmp++;\r\n      n/=i;\r\
    \n    }\r\n    res.emplace_back(i,tmp);\r\n  }\r\n  if(n!=1) res.emplace_back(n,1);\r\
    \n  return res;\r\n}\r\nstruct p_table {\r\n  vb SoE;\r\n  p_table(int n): SoE(n+1,1){\r\
    \n    SoE[0]=SoE[1]=0;\r\n    rep(i,2,n) {\r\n      if(!SoE[i]) continue;\r\n\
    \      rep(j,i*i,n,i) SoE[j] = 0;\r\n    }\r\n  }\r\n  vi get() {\r\n    vi p;\r\
    \n    rep(i,2,SoE.size()-1) if(SoE[i]) p.emplace_back(i);\r\n    return p;\r\n\
    \  }\r\n};\r\nstruct p_fact {\r\n  vi spf;\r\n  p_fact(int n): spf(n + 1){\r\n\
    \    iota(all(spf),0);\r\n    sqrp(i,2,n) {\r\n      if(spf[i]==i) {\r\n     \
    \   rep(j,i*i,n,i) {\r\n          if(spf[j]==j) spf[j]=i;\r\n        }\r\n   \
    \   }\r\n    }\r\n  }\r\n  map<int,int> get(int n) {\r\n    map<int,int> m;\r\n\
    \    while(n!=1) {\r\n      m[spf[n]]++;\r\n      n/=spf[n];\r\n    }\r\n    return\
    \ m;\r\n  }\r\n};\r\nstruct asum {\r\n  vi s;\r\n  asum(const vi& v): s{0} { partial_sum(all(v),back_inserter(s));\
    \ }\r\n  vi get() const { return s; }\r\n  // [l, r]\r\n  ll query(int l, int\
    \ r) const { return s[r]-s[l]; }\r\n};\r\ntemplate <class T, class Boolean=bool>\
    \ inline T bins(T ok, T ng, const Boolean &fn, const ld eps = 1) {\r\n  while(abs(ok-ng)>eps)\
    \ {\r\n    T mid=(ok+ng)/2;\r\n    (fn(mid)?ok:ng) = mid;\r\n  }\r\n  return ok;\r\
    \n}\r\ntemplate <class T> inline V<T> press(const V<T>& v) {\r\n  V<T> res,cp=v;\r\
    \n  Lady_sANDy::unq(cp);\r\n  each(el,v) res.emplace_back(Lady_sANDy::LB(cp,el));\r\
    \n  return res;\r\n}\r\ntemplate <class T> inline V<T> press(V<T> &c1, V<T> &c2)\
    \ {\r\n  V<T> res;\r\n  const int n = c1.size();\r\n  rep(n) {\r\n    for(T d\
    \ = 0; d < 1; d++) {\r\n      T tc1 = c1[i]+d;\r\n      T tc2 = c2[i]+d;\r\n \
    \     res.emplace_back(tc1);\r\n      res.emplace_back(tc2);\r\n    }\r\n  }\r\
    \n  Lady_sANDy::unq(res);\r\n  rep(n) {\r\n    c1[i]=Lady_sANDy::LB(res,c1[i]);\r\
    \n    c2[i]=Lady_sANDy::LB(res,c2[i]);\r\n  }\r\n  return res;\r\n}\r\ninline\
    \ vs rtt(const vs &s) {\r\n  const int h=s.size(), w=s.front().size();\r\n  vs\
    \ t(w,string(h,{}));\r\n  rep(h) rep(j,w) t[j][i]=s[i][j];\r\n  rep(w) Lady_sANDy::rev(t[i]);\r\
    \n  return t;\r\n}\r\ntemplate <class T> inline V<V<T>> rtt(const V<V<T>>& v)\
    \ {\r\n  const int h=v.size(), w=v.front().size();\r\n  V<V<T>> res(w,V<T>(h));\r\
    \n  rep(h) rep(j,w) res[j][i]=v[i][j];\r\n  rep(w) Lady_sANDy::rev(res[i]);\r\n\
    \  return res;\r\n}\r\ntemplate <class T> inline T factor(T n, const T mod=0)\
    \ {\r\n  T res=1;\r\n  while(n>0) {\r\n    res*=n--;\r\n    if(mod) res%=mod;\r\
    \n  }\r\n  return res;\r\n}\r\ntemplate <class T=ll> inline T perm(T n, const\
    \ T r, const T mod=0) {\r\n  const T tmp=n;\r\n  T res=1;\r\n  while(n>tmp-r)\
    \ {\r\n    res*=n--;\r\n    if(mod) res%=mod;\r\n  }\r\n  return res;\r\n}\r\n\
    template <class T=ll> inline T binom(T n, const T r, const T mod=0) {\r\n  if(r\
    \ < 0 || n < r) return 0;\r\n  T res = 1;\r\n  rep(i,1,r) {\r\n    res*=n--;\r\
    \n    if(mod) res%=mod;\r\n    res/=i;\r\n    if(mod) res%=mod;\r\n  }\r\n  return\
    \ res;\r\n}\r\ninline bool is_prime(const ul n) {\r\n  if(n==1) return 0;\r\n\
    \  sqrp(i,2,n) if(n%i==0) return 0;\r\n  return 1;\r\n}\r\ninline bool is_int(const\
    \ ld n){ ll r=floor(n); return r==n; }\r\ninline bool is_sqr(const ll n){ return\
    \ is_int(sqrtl(n)); }\r\n} // Heileden\n"
  code: "#pragma GCC diagnostic ignored \"-Wunused-parameter\"\r\n#pragma GCC diagnostic\
    \ ignored \"-Wsign-compare\"\r\n#pragma GCC diagnostic ignored \"-Wdeprecated-copy\"\
    \r\n#include <bits/stdc++.h>\r\n#include <ext/pb_ds/assoc_container.hpp>\r\n#include\
    \ <ext/pb_ds/tree_policy.hpp>\r\nusing namespace std;\r\nusing namespace __gnu_pbds;\r\
    \nnamespace VvyLw {\r\ninline void wa_haya_exe() noexcept { cin.tie(nullptr) ->\
    \ sync_with_stdio(false); }\r\nvoid solve();\r\n} // VvyLw\r\nmt19937 EhaL(hash<string>()(\"\
    Huitloxopetl\"));\r\nmt19937 Random() {\r\n  random_device seed_gen;\r\n  mt19937\
    \ engine {seed_gen()};\r\n  return engine;\r\n}\r\nusing Timer = chrono::system_clock::time_point;\r\
    \n[[maybe_unused]] Timer start, stop;\r\n#if local\r\nvoid now(Timer &t){ t =\
    \ chrono::system_clock::now(); }\r\nvoid time(const Timer &t1, const Timer &t2){\
    \ cerr << chrono::duration_cast<chrono::milliseconds>(t2-t1).count() << \"ms\\\
    n\"; }\r\n#else\r\n[[maybe_unused]] void now(Timer &t){ void(0); }\r\n[[maybe_unused]]\
    \ void time(const Timer &t1, const Timer &t2){ void(0); }\r\n#endif\r\n\r\n//\
    \ --------------------------------------------------------------------------------------------------------------\r\
    \n\r\n#define overload4(_1,_2,_3,_4,name,...) name\r\n#define overload3(_1,_2,_3,name,...)\
    \ name\r\n#define rep1(n) for(ll i=0; i<(n); ++i)\r\n#define rep2(i,n) for(ll\
    \ i=0; i<(n); ++i)\r\n#define rep3(i,a,b) for(ll i=(a); i<=(b); ++i)\r\n#define\
    \ rep4(i,a,b,c) for(ll i=(a); i<=(b); i+=(c))\r\n#define rep(...) overload4(__VA_ARGS__,rep4,rep3,rep2,rep1)(__VA_ARGS__)\r\
    \n#define rvp1(n) for(ll i=(n)-1; i>=0; i--)\r\n#define rvp2(i,n) for(ll i=(n)-1;\
    \ i>=0; i--)\r\n#define rvp3(i,a,b) for(ll i=(a); i>=(b); i--)\r\n#define rvp4(i,a,b,c)\
    \ for(ll i=(a); i>=(b); i-=(c))\r\n#define rvp(...) overload4(__VA_ARGS__,rvp4,rvp3,rvp2,rvp1)(__VA_ARGS__)\r\
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
    \ntemplate <class T> using L = numeric_limits<T>;\r\nconstexpr int dx[]={0,0,0,-1,1,-1,-1,1,1};\r\
    \nconstexpr int dy[]={0,-1,1,0,0,-1,1,-1,1};\r\nconstexpr int MOD = 0x3b800001;\r\
    \nconstexpr int M0D = 1e9+7;\r\nconstexpr int INF = 1<<30;\r\nconstexpr ll LINF\
    \ = (1LL<<61)-1;\r\nconstexpr ld DINF = L<ld>::infinity();\r\ntemplate <class\
    \ T> constexpr T LIM = L<T>::max();\r\n#if __cplusplus >= 202100L\r\nconstexpr\
    \ ld PI = numbers::pi;\r\nconstexpr ld E = numbers::e;\r\n#else\r\nconst ld PI\
    \ = acos(-1);\r\nconst ld E = 2.718281828459045;\r\n#endif\r\nnamespace vectors\
    \ {\r\ntemplate <class T> using V = vector<T>;\r\nusing vi = V<ll>;\r\nusing vu\
    \ = V<ul>;\r\nusing vd = V<ld>;\r\nusing vc = V<char>;\r\nusing vs = V<string>;\r\
    \nusing vb = V<bool>;\r\nusing wi = V<vi>;\r\nusing wu = V<vu>;\r\nusing wd =\
    \ V<vd>;\r\nusing wc = V<vc>;\r\nusing ws = V<vs>;\r\nusing wb = V<vb>;\r\ntemplate\
    \ <class T, class U> inline V<U> ndiv(T&& n, U&& v) noexcept {\r\n  return V<U>(forward<T>(n),\
    \ forward<U>(v));\r\n}\r\ntemplate <class T, class... Ts> inline decltype(auto)\
    \ ndiv(T&& n, Ts&&... v) noexcept {\r\n  return V<decltype(ndiv(forward<Ts>(v)...))>(forward<T>(n),\
    \ ndiv(forward<Ts>(v)...));\r\n}\r\ntemplate <class T> constexpr V<T>& operator++(V<T>&\
    \ v) noexcept { each(el,v) el++; return v; }\r\ntemplate <class T> constexpr V<T>&\
    \ operator--(V<T>& v) noexcept { each(el,v) el--; return v; }\r\ntemplate <class\
    \ T, class U> constexpr V<T>& operator+=(V<T>& v, const U x) noexcept { each(el,v)\
    \ el+=x; return v; }\r\ntemplate <class T, class U> constexpr V<T>& operator-=(V<T>&\
    \ v, const U x) noexcept { each(el,v) el-=x; return v; }\r\ntemplate <class T,\
    \ class U> constexpr V<T>& operator*=(V<T>& v, const U x) noexcept { each(el,v)\
    \ el*=x; return v; }\r\ntemplate <class T, class U> constexpr V<T>& operator/=(V<T>&\
    \ v, const U x) noexcept { each(el,v) el/=x; return v; }\r\ntemplate <class T,\
    \ class U> constexpr V<T>& operator%=(V<T>& v, const U x) noexcept { each(el,v)\
    \ el%=x; return v; }\r\ntemplate <class T, class U> constexpr V<T> operator+(const\
    \ V<T>& v, const U x) noexcept { V<T> res = v; res+=x; return res; }\r\ntemplate\
    \ <class T, class U> constexpr V<T> operator-(const V<T>& v, const U x) noexcept\
    \ { V<T> res = v; res-=x; return res; }\r\ntemplate <class T, class U> constexpr\
    \ V<T> operator*(const V<T>& v, const U x) noexcept { V<T> res = v; res*=x; return\
    \ res; }\r\ntemplate <class T, class U> constexpr V<T> operator/(const V<T>& v,\
    \ const U x) noexcept { V<T> res = v; res/=x; return res; }\r\ntemplate <class\
    \ T, class U> constexpr V<T> operator%(const V<T>& v, const U x) noexcept { V<T>\
    \ res = v; res%=x; return res; }\r\n} // vectors\r\nusing namespace vectors;\r\
    \nnamespace pairs {\r\ntemplate <class T, class U> using P = pair<T, U>;\r\ntemplate\
    \ <class T> using PP = P<T,T>;\r\nusing pi = PP<ll>;\r\nusing pd = PP<ld>;\r\n\
    using pc = PP<char>;\r\nusing ps = PP<string>;\r\ntemplate <class T> constexpr\
    \ PP<T> operator+(const PP<T>& a, const PP<T>& b) noexcept { return {a.first +\
    \ b.first, a.second + b.second}; }\r\ntemplate <class T> constexpr PP<T> operator-(const\
    \ PP<T>& a, const PP<T>& b) noexcept { return {a.first - b.first, a.second - b.second};\
    \ }\r\ntemplate <class T> constexpr PP<T> operator-(const PP<T>& a) noexcept {\
    \ return {-a.first, -a.second}; }\r\ntemplate <class T, class U> constexpr PP<T>\
    \ operator*(const PP<T>& a, const U& b) noexcept { return {a.first * b, a.second\
    \ * b}; }\r\ntemplate <class T, class U> constexpr PP<T> operator/(const PP<T>&\
    \ a, const U& b) noexcept { return {a.first / b, a.second / b}; }\r\ntemplate\
    \ <class T> constexpr PP<T>& operator+=(PP<T>& a, const PP<T>& b) noexcept { return\
    \ a = a + b; }\r\ntemplate <class T> constexpr PP<T>& operator-=(PP<T>& a, const\
    \ PP<T>& b) noexcept { return a = a - b; }\r\ntemplate <class T, class U> constexpr\
    \ PP<T>& operator*=(PP<T>& a, const U& b) noexcept { return a = a * b; }\r\ntemplate\
    \ <class T, class U> PP<T>& operator/=(PP<T>& a, const U& b) noexcept { return\
    \ a = a / b; }\r\ntemplate <class T> constexpr bool operator==(const PP<T> &p,\
    \ const PP<T> &q) noexcept { return p.first==q.first && p.second==q.second; }\r\
    \ntemplate <class T> constexpr bool operator!=(const PP<T> &p, const PP<T> &q)\
    \ noexcept { return !(p==q); }\r\ntemplate <class T> constexpr bool operator<(const\
    \ PP<T> &p, const PP<T> &q) noexcept { if(p.first==q.first) return p.second<q.second;\
    \ return p.first<q.first; }\r\ntemplate <class T> constexpr bool operator<=(const\
    \ PP<T> &p, const PP<T> &q) noexcept { if(p.first==q.first) return p.second<=q.second;\
    \ return p.first<q.first; }\r\ntemplate <class T> constexpr bool operator>(const\
    \ PP<T> &p, const PP<T> &q) noexcept { if(p.first==q.first) return p.second>q.second;\
    \ return p.first>q.first; }\r\ntemplate <class T> constexpr bool operator>=(const\
    \ PP<T> &p, const PP<T> &q) noexcept { if(p.first==q.first) return p.second>=q.second;\
    \ return p.first>q.first; }\r\ntemplate <class T, class U> constexpr bool operator==(const\
    \ P<T,U> &p, const P<T,U> &q) noexcept { return p.first==q.first && p.second==q.second;\
    \ }\r\ntemplate <class T, class U> constexpr bool operator!=(const P<T,U> &p,\
    \ const P<T,U> &q) noexcept { return !(p==q); }\r\ntemplate <class T, class U>\
    \ constexpr bool operator<(const P<T,U> &p, const P<T,U> &q) noexcept { if(p.first==q.first)\
    \ return p.second<q.second; return p.first<q.first; }\r\ntemplate <class T, class\
    \ U> constexpr bool operator<=(const P<T,U> &p, const P<T,U> &q) noexcept { if(p.first==q.first)\
    \ return p.second<=q.second; return p.first<q.first; }\r\ntemplate <class T, class\
    \ U> constexpr bool operator>(const P<T,U> &p, const P<T,U> &q) noexcept { if(p.first==q.first)\
    \ return p.second>q.second; return p.first>q.first; }\r\ntemplate <class T, class\
    \ U> constexpr bool operator>=(const P<T,U> &p, const P<T,U> &q) noexcept { if(p.first==q.first)\
    \ return p.second>=q.second; return p.first>q.first; }\r\ntemplate <class T> inline\
    \ PP<T> rotate(const PP<T>& a){ return {-a.second, a.first}; } // 90 degree ccw\r\
    \ntemplate <class T> inline pd rotate(const PP<T>& a, const int ang) {\r\n  assert(0<=ang\
    \ && ang<360);\r\n  const ld rad=PI*ang/180;\r\n  return {a.first*cosl(rad)-a.second*sinl(rad),\
    \ a.first*sinl(rad)+a.second*cosl(rad)};\r\n}\r\ntemplate <class T> inline T dot(const\
    \ PP<T>& a, const PP<T>& b){ return a.first * b.first + a.second * b.second; }\r\
    \ntemplate <class T> inline T cross(const PP<T>& a, const PP<T>& b){ return dot(rotate(a),\
    \ b); }\r\ntemplate <class T> inline T square(const PP<T>& a){ return dot(a, a);\
    \ }\r\ntemplate <class T> inline ld grad(const PP<T>& a){ assert(a.first); return\
    \ 1.0L * a.second / a.first; }\r\ntemplate <class T> inline ld abs(const PP<T>&\
    \ a){ return hypotl(a.first, a.second); }\r\ntemplate <class T> inline T lcm(const\
    \ PP<T>& a){ return std::lcm(a.first, a.second); }\r\ntemplate <class T> inline\
    \ T gcd(const PP<T>& a){ return std::gcd(a.first, a.second); }\r\ntemplate <class\
    \ T> inline PP<T> extgcd(const PP<T> &p) {\r\n  T x=1,y=0,t1=0,t2=0,t3=1,a,b;\r\
    \n  tie(a,b)=p;\r\n  while(b) {\r\n    t1=a/b,a-=t1*b;\r\n    swap(a,b);\r\n \
    \   x-=t1*t2;\r\n    swap(x,t2);\r\n    y-=t1*t3;\r\n    swap(y,t3);\r\n  }\r\n\
    \  return {x,y};\r\n}\r\ntemplate <class T> inline PP<T> normalize(PP<T> a) {\r\
    \n  if(a == PP<T>{}) return a;\r\n  a /= gcd(a);\r\n  if(a < PP<T>{}) a = -a;\r\
    \n  return a;\r\n}\r\ntemplate <class T, class U> inline P<U,T> swap(const P<T,U>\
    \ &p){ P<U,T> ret={p.second,p.first}; return ret; }\r\ntemplate <class T, class\
    \ U> inline V<P<U,T>> swap(const V<P<T,U>> &vp) {\r\n  V<P<U,T>> ret;\r\n  each(el,vp)\
    \ ret.emplace_back(swap(el));\r\n  return ret;\r\n}\r\ntemplate <class T, class\
    \ U> inline V<T> first(const V<P<T,U>> &vp) {\r\n  V<T> res;\r\n  each(el,vp)\
    \ res.emplace_back(el.first);\r\n  return res;\r\n}\r\ntemplate <class T, class\
    \ U> inline V<U> second(const V<P<T,U>> &vp) {\r\n  V<U> res;\r\n  each(el,vp)\
    \ res.emplace_back(el.second);\r\n  return res;\r\n}\r\n} // pairs\r\nusing namespace\
    \ pairs;\r\ntemplate <size_t N> using ti = array<ll, N>;\r\nusing tri = ti<3>;\r\
    \ntemplate <class T> using pq = priority_queue<T>;\r\ntemplate <class T> using\
    \ pqr = priority_queue<T,V<T>,greater<T>>;\r\ntemplate <class T> using Tree =\
    \ tree<T,null_type,less<T>,rb_tree_tag,tree_order_statistics_node_update>;\r\n\
    template <class T> using TREE = tree<T,null_type,greater<T>,rb_tree_tag,tree_order_statistics_node_update>;\r\
    \ntemplate <class T, class U> inline bool chmax(T& a, const U& b){ if(a<b){ a=b;\
    \ return 1; } return 0; }\r\ntemplate <class T, class U> inline bool chmin(T&\
    \ a, const U& b){ if(a>b){ a=b; return 1; } return 0; }\r\ntemplate <class T,\
    \ class U> inline bool overflow_if_add(const T a, const U b){ return (LIM<T>-a)<b;\
    \ }\r\ntemplate <class T, class U> inline bool overflow_if_mul(const T a, const\
    \ U b){ return (LIM<T>/a)<b; }\r\n\r\nnamespace IO {\r\nostream &operator<<(ostream\
    \ &dest, i128 value) {\r\n  ostream::sentry s(dest);\r\n  if(s) {\r\n    u128\
    \ tmp = value < 0 ? -value : value;\r\n    char buffer[128];\r\n    char *d =\
    \ end(buffer);\r\n    do {\r\n      --d;\r\n      *d = \"0123456789\"[tmp % 10];\r\
    \n      tmp /= 10;\r\n    } while(tmp != 0);\r\n    if(value < 0) {\r\n      --d;\r\
    \n      *d = '-';\r\n    }\r\n    int len = end(buffer) - d;\r\n    if(dest.rdbuf()->sputn(d,\
    \ len) != len) {\r\n      dest.setstate(ios_base::badbit);\r\n    }\r\n  }\r\n\
    \  return dest;\r\n}\r\ntemplate <class T, class U> istream& operator>>(istream\
    \ &is, P<T, U> &p){ is >> p.first >> p.second; return is; }\r\ntemplate <class\
    \ T, size_t N> istream& operator>>(istream &is, array<T, N> &a){ each(el,a) is\
    \ >> el; return is; }\r\ntemplate <class T> istream& operator>>(istream &is, V<T>\
    \ &v){ each(el,v) is >> el; return is; }\r\ntemplate <class T> istream& operator>>(istream\
    \ &is, deque<T> &dq){ each(el,dq) is >> el; return is; }\r\ntemplate <class T>\
    \ inline bool in(T& x){ cin >> x; return 1; }\r\ntemplate <class Head, class...\
    \ Tail> inline bool in(Head& head, Tail&... tail){ in(head); in(tail...); return\
    \ 1; }\r\ntemplate <class T, class U> ostream& operator<<(ostream &os, const P<T,\
    \ U> &p){ os << p.first << ' ' << p.second; return os; }\r\ntemplate <class T,\
    \ size_t N> ostream& operator<<(ostream &os, const array<T, N> &a){ if(a.size()){\
    \ os << a.front(); for(auto i=a.begin(); ++i!=a.end();){ os << ' ' << *i; } }\
    \ return os; }\r\ntemplate <class T> ostream& operator<<(ostream &os, const V<T>\
    \ &v){ if(v.size()){ os << v.front(); for(auto i=v.begin(); ++i!=v.end();){ os\
    \ << ' ' << *i; } } return os; }\r\ntemplate <class K, class V> ostream& operator<<(ostream\
    \ &os, const map<K, V> &m){ if(m.size()){ os << m.begin()->first << ' ' << m.begin()->second;\
    \ for(auto i=m.begin(); ++i!=m.end();){ os << '\\n' << i->first << ' ' << i->second;\
    \ } } return os; }\r\ntemplate <class T> ostream& operator<<(ostream &os, const\
    \ set<T> &st){ if(st.size()){ os << *st.begin(); for(auto i=st.begin(); ++i!=st.end();){\
    \ os << ' ' << *i; } } return os; }\r\ntemplate <class T> ostream& operator<<(ostream\
    \ &os, const multiset<T> &ms){ if(ms.size()){ os << *ms.begin(); for(auto i=ms.begin();\
    \ ++i!=ms.end();){ os << ' ' << *i; } } return os; }\r\ntemplate <class T> ostream&\
    \ operator<<(ostream &os, const deque<T> &dq){ if(dq.size()){ os << dq.front();\
    \ for(auto i=dq.begin(); ++i!=dq.end();){ os << ' ' << *i; } } return os; }\r\n\
    inline void out(){ cout << '\\n'; }\r\ntemplate <bool flush=false, class T> inline\
    \ void out(const T& x){ cout << x << '\\n'; if(flush) cout.flush(); }\r\ntemplate\
    \ <bool flush=false, class Head, class... Tail> inline void out(const Head& head,\
    \ const Tail&... tail){ cout << head << ' '; out<flush>(tail...); }\r\ntemplate\
    \ <bool flush=false, class T> inline void vout(const T& v){ cout << v << '\\n';\
    \ if(flush) cout.flush(); }\r\ntemplate <bool flush=false, class T> inline void\
    \ vout(const V<T>& v){ rep(v.size()) cout << v[i] << '\\n'; if(flush) cout.flush();\
    \ }\r\ntemplate <bool flush=false, class Head, class... Tail> inline void vout(const\
    \ Head& head, const Tail&... tail){ cout << head << '\\n'; vout<flush>(tail...);\
    \ }\r\ninline void fix(const short x){ cout << fixed << setprecision(x); }\r\n\
    inline void alpha(){ cout << boolalpha; }\r\n#define INT(...) int __VA_ARGS__;\
    \ in(__VA_ARGS__)\r\n#define LL(...) ll __VA_ARGS__; in(__VA_ARGS__)\r\n#define\
    \ UL(...) ul __VA_ARGS__; in(__VA_ARGS__)\r\n#define LD(...) ld __VA_ARGS__; in(__VA_ARGS__)\r\
    \n#define CHR(...) char __VA_ARGS__; in(__VA_ARGS__)\r\n#define STR(...) string\
    \ __VA_ARGS__; in(__VA_ARGS__)\r\n#define VEC(type,name,size) V<type> name(size);\
    \ in(name)\r\n#define WEC(type,name,h,w) V<V<type>> name(h,V<type>(w)); in(name)\r\
    \n#define fin(...) do{ out(__VA_ARGS__); return; }while(false)\r\n} // IO\r\n\
    using namespace IO;\r\n\r\nnamespace zia_qu {\r\n#ifdef local\r\n//https://gist.github.com/naskya/1e5e5cd269cfe16a76988378a60e2ca3\r\
    \n#include <../debug_print.hpp>\r\n#define debug(...) debug_print::multi_print(#__VA_ARGS__,\
    \ __VA_ARGS__)\r\n#else\r\n#define debug(...) static_cast<void>(0)\r\n#endif\r\
    \n#define elif else if\r\n#define eid(el,v) size_t(&el-&v[0])\r\n#define bif(bit,tar)\
    \ if(((bit)>>(tar))&1)\r\n#define nxp(x) next_permutation(all(x))\r\n#define prp(x)\
    \ prev_permutation(all(x))\r\n#define strpl(s,a,b) regex_replace(s,regex(a),b)\r\
    \n#define rgxsr(s,rgx) regex_search(s,regex(rgx))\r\ninline void YES(const bool\
    \ ok=1){ out(ok?\"YES\":\"NO\"); }\r\ninline void NO(const bool ok=1){ YES(!ok);\
    \ }\r\ninline void Yes(const bool ok=1){ out(ok?\"Yes\":\"No\"); }\r\ninline void\
    \ No(const bool ok=1){ Yes(!ok); }\r\ninline void yes(const bool ok=1){ out(ok?\"\
    yes\":\"no\"); }\r\ninline void no(const bool ok=1){ yes(!ok); }\r\ntemplate <class\
    \ T> inline T sqr(const T x){ return x*x; }\r\ntemplate <class T> inline T cub(const\
    \ T x){ return x*x*x; }\r\ntemplate <class T> inline T Mod(const T x, const T\
    \ m){ return (x+m)%m; }\r\ntemplate <class T> inline T Pow(T a, T b, const T mod=0)\
    \ {\r\n  T res=1;\r\n  if(mod) {\r\n    res%=mod;\r\n    a%=mod;\r\n  }\r\n  while(b>0)\
    \ {\r\n    if(b&1) res*=a;\r\n    if(mod) res%=mod;\r\n    a*=a;\r\n    if(mod)\
    \ a%=mod;\r\n    b>>=1;\r\n  }\r\n  return res;\r\n}\r\ninline ll Ceil(const ld\
    \ x, const ll m){ return ceil(x/m); }\r\ninline ld Round(const ld x, const ll\
    \ m, const short fx=0){ if(!fx) return round(x/m); const ul y=Pow<ul>(10,fx);\
    \ return round((x*y)/m)/y; }\r\ninline ld Log(const ll x, const ld base=2){ return\
    \ log2(x)/log2(base); }\r\ninline int bitdigit(const ll x){ return 64-__builtin_clzll(x);\
    \ }\r\ninline int popcnt(const ll x){ return __builtin_popcountll(x); }\r\ninline\
    \ int fione(const ll x){ return __builtin_ffsll(x); }\r\ninline int zrcnt(const\
    \ ll x){ return __builtin_ctzll(x); }\r\ntemplate <class T=ll> inline bool scope(const\
    \ T a, const T x, const T b){ return a <= x && x <= b; }\r\ninline bool isupper(const\
    \ char c){ return std::isupper(c); }\r\ninline bool isupper(const string &s){\
    \ bool ok=1; each(el,s) ok&=isupper(el); return ok; }\r\ninline bool islower(const\
    \ char c){ return std::islower(c); }\r\ninline bool islower(const string &s){\
    \ bool ok=1; each(el,s) ok&=islower(el); return ok; }\r\ninline bool isalpha(const\
    \ char c){ return std::isalpha(c); }\r\ninline bool isalpha(const string &s){\
    \ bool ok=1; each(el,s) ok&=isalpha(el); return ok; }\r\ninline bool isdigit(const\
    \ char c){ return std::isdigit(c); }\r\ninline bool isdigit(const string &s){\
    \ bool ok=1, neg=s.front()=='-'; each(el,s){ if(neg){ neg=0; continue; } ok&=isdigit(el);\
    \ } return ok; }\r\ninline bool isalnum(const char c){ return std::isalnum(c);\
    \ }\r\ninline bool isalnum(const string &s){ bool ok=1; each(el,s) ok&=isalnum(el);\
    \ return ok; }\r\ninline bool isspace(const char c){ return std::isspace(c); }\r\
    \ninline bool isspace(const string &s){ bool ok=1; each(el,s) ok&=isspace(el);\
    \ return ok; }\r\ninline bool ispunct(const char c){ return std::ispunct(c); }\r\
    \ninline bool ispunct(const string &s){ bool ok=1; each(el,s) ok&=ispunct(el);\
    \ return ok; }\r\ninline bool isprint(const char c){ return std::isprint(c); }\r\
    \ninline bool isprint(const string &s){ bool ok=1; each(el,s) ok&=isprint(el);\
    \ return ok; }\r\ninline ll strins(string &s, const ll id, const string &t){ s.insert(id,t);\
    \ return s.size(); }\r\ninline string toupper(string s){ each(c,s) c=std::toupper(c);\
    \ return s; }\r\ninline string tolower(string s){ each(c,s) c=std::tolower(c);\
    \ return s; }\r\ninline vi ten_to_adic(ll n, const short base) {\r\n  vi res;\r\
    \n  while(n) {\r\n    res.emplace_back(n%base);\r\n    n/=base;\r\n  }\r\n  return\
    \ res;\r\n}\r\ninline ll adic_to_ten(const vi &v, const short base) {\r\n  ll\
    \ res=0;\r\n  each(el,v) {\r\n    res+=Pow<ll>(base,eid(el,v))*el;\r\n  }\r\n\
    \  return res;\r\n}\r\ninline string to_hex(const ll x) {\r\n  stringstream ss;\r\
    \n  ss<<hex<<x;\r\n  string s=ss.str();\r\n  //s=toupper(s);\r\n  return s;\r\n\
    }\r\ninline string to_oct(const ll x) {\r\n  stringstream s;\r\n  s<<oct<<x;\r\
    \n  return s.str();\r\n}\r\ninline string to_bin(const ll x) {\r\n  stringstream\
    \ ss;\r\n  ss<<bitset<64>(x);\r\n  string s=ss.str();\r\n  reverse(all(s));\r\n\
    \  s.resize(ten_to_adic(x,2).size());\r\n  reverse(all(s));\r\n  return s;\r\n\
    }\r\ninline ll to_ten(const string &s, const short base){ return stoll(s,nullptr,base);\
    \ }\r\ninline i128 stoL(const string &s) {\r\n  assert(isdigit(s));\r\n  bool\
    \ neg=s.front()=='-';\r\n  i128 ret = 0;\r\n  each(el,s) {\r\n    if(neg) {\r\n\
    \      neg=0;\r\n      continue;\r\n    }\r\n    ret = 10 * ret + el - '0';\r\n\
    \  }\r\n  if(s.front()=='-') ret=-ret;\r\n  return ret;\r\n}\r\ntemplate <class...\
    \ Ts> constexpr ul sygcd(const Ts... a) noexcept { vector v=initializer_list<common_type_t<Ts...>>{a...};\
    \ ul g=0; each(el,v) g=gcd(g,el); return g; }\r\ntemplate <class... Ts> constexpr\
    \ ul sylcm(const Ts... a) noexcept { vector v=initializer_list<common_type_t<Ts...>>{a...};\
    \ ul l=1; each(el,v) l=lcm(l,el); return l; }\r\ntemplate <class... Ts> constexpr\
    \ auto symin(const Ts... a) noexcept { return min(initializer_list<common_type_t<Ts...>>{a...});\
    \ }\r\ntemplate <class... Ts> constexpr auto symax(const Ts... a) noexcept { return\
    \ max(initializer_list<common_type_t<Ts...>>{a...}); }\r\ntemplate <class K, class\
    \ U> inline V<K> kyl(const map<K,U> &m, const U val) {\r\n  V<K> keys;\r\n  for(auto\
    \ it=m.cbegin(); it!=m.cend(); ++it) {\r\n    if(it->second==val) keys.emplace_back(it->first);\r\
    \n  }\r\n  return keys;\r\n}\r\ntemplate <class K, class V> inline K kymin(const\
    \ map<K,V> &m){ return m.begin()->first; }\r\ntemplate <class K, class V> inline\
    \ K kymax(const map<K,V> &m){ return m.rbegin()->first; }\r\ntemplate <class K,\
    \ class V> inline V kymin_v(const map<K,V> &m){ return m.begin()->second; }\r\n\
    template <class K, class V> inline V kymax_v(const map<K,V> &m){ return m.rbegin()->second;\
    \ }\r\ntemplate <class K, class V> inline V vlmin(const map<K,V> &m){\r\n  const\
    \ auto pr = *min_element(all(m),[](P<K,V> const &x, P<K,V> const &y){ return x.second\
    \ < y.second; });\r\n  return pr.second;\r\n}\r\ntemplate <class K, class V> inline\
    \ V vlmax(const map<K,V> &m){\r\n  const auto pr = *max_element(all(m),[](P<K,V>\
    \ const &x, P<K,V> const &y){ return x.second < y.second; });\r\n  return pr.second;\r\
    \n}\r\ntemplate <class K, class V> inline K vlmin_k(const map<K,V> &m){\r\n  const\
    \ auto pr = *min_element(all(m),[](P<K,V> const &x, P<K,V> const &y){ return x.second\
    \ < y.second; });\r\n  return pr.first;\r\n}\r\ntemplate <class K, class V> inline\
    \ K vlmax_k(const map<K,V> &m){\r\n  const auto pr = *max_element(all(m),[](P<K,V>\
    \ const &x, P<K,V> const &y){ return x.second < y.second; });\r\n  return pr.first;\r\
    \n}\r\n} // zia qu\r\n\r\nnamespace Lady_sANDy {\r\ntemplate <class T> inline\
    \ void rev(T& v){ reverse(all(v)); }\r\ntemplate <class T> inline void rev(T&\
    \ v, const int a, const int b){ reverse(all(v,a,b+1)); }\r\ntemplate <class T>\
    \ inline T revd(const T& v){ auto c=v; rev(c); return c; }\r\ntemplate <class\
    \ T> inline T revd(const T& v, const int a, const int b){ auto c=v; rev(c,a,b);\
    \ return c; }\r\ntemplate <class T> inline void Sort(T& v){ sort(all(v)); }\r\n\
    template <class T> inline void Sort(T& v, const int a, const int b){ sort(all(v,a,b+1));\
    \ }\r\ntemplate <class T> inline T sorted(const T& v){ auto c=v; Sort(c); return\
    \ c; }\r\ntemplate <class T> inline T sorted(const T& v, const int a, const int\
    \ b){ auto c=v; Sort(c,a,b); return c; }\r\ntemplate <class T> inline void Sortt(T&\
    \ v){ sort(rall(v)); }\r\ntemplate <class T> inline void Sortt(T& v, const int\
    \ a, const int b){ sort(rall(v,v.size()-b-1,v.size()-a)); }\r\ntemplate <class\
    \ T> inline T Sorted(const T& v){ auto c=v; Sortt(c); return c; }\r\ntemplate\
    \ <class T> inline T Sorted(const T& v, const int a, const int b){ auto c=v; Sortt(c,a,b);\
    \ return c; }\r\ntemplate <class T> inline void Sorth(T& v){ make_heap(all(v));\
    \ sort_heap(all(v)); }\r\ntemplate <class T> inline T mrg(const T& a, const T&\
    \ b){ T res; merge(all(a),all(b),back_inserter(res)); return res; }\r\ntemplate\
    \ <class T> inline T Min(const V<T>& v){ return *min_element(all(v)); }\r\ntemplate\
    \ <class T> inline T Min(const V<T>& v, const int a, const int b){ return *min_element(all(v,a,b+1));\
    \ }\r\ntemplate <class T> inline T Max(const V<T>& v){ return *max_element(all(v));\
    \ }\r\ntemplate <class T> inline T Max(const V<T>& v, const int a, const int b){\
    \ return *max_element(all(v,a,b+1)); }\r\ntemplate <class T> inline int Min_i(const\
    \ T& v){ return min_element(all(v))-v.begin(); }\r\ntemplate <class T> inline\
    \ int Max_i(const T& v){ return max_element(all(v))-v.begin(); }\r\ntemplate <class\
    \ T, class U> inline int LB(const T& v, const U x){ return lower_bound(all(v),x)-v.begin();\
    \ }\r\ntemplate <class T, class U> inline int UB(const T& v, const U x){ return\
    \ upper_bound(all(v),x)-v.begin(); }\r\ntemplate <class T, class U> inline bool\
    \ BS(const T& v, const U x){ return binary_search(all(v),x); }\r\ntemplate <class\
    \ T, class U, class Boolean=bool> inline bool BS(const T& v, const U x, const\
    \ Boolean &fn){ return binary_search(all(v),x,fn); }\r\ntemplate <class T, class\
    \ Boolean=bool> inline bool All(const T& v, const Boolean &fn){ return all_of(all(v),fn);\
    \ }\r\ntemplate <class T, class Boolean=bool> inline bool Exist(const T& v, const\
    \ Boolean &fn){ return any_of(all(v),fn); }\r\ntemplate <class T, class Boolean=bool>\
    \ inline int pt(T& v, const Boolean &fn){ auto p=partition(all(v),fn); return\
    \ p-v.begin(); }\r\ntemplate <class T, class Boolean=bool> inline int ptp(const\
    \ T& v, const Boolean &fn){ return partition_point(all(v),fn)-v.begin(); }\r\n\
    template <class T, class U> inline int fnd(const T& v, const U x){ auto itr=find(all(v),x);\
    \ return itr!=v.end()?itr-v.begin():-1; }\r\ntemplate <class T> inline int src(const\
    \ T& s, const T& t){ auto itr=search(all(s),all(t)); return itr!=s.end()?itr-s.begin():-1;\
    \ }\r\ntemplate <class T, class U> inline void rpl(T& v, const U fn, const U r){\
    \ replace(all(v),fn,r); }\r\ntemplate <class T, class U, class Boolean=bool> inline\
    \ void rplif(T& v, const Boolean &fn, const U r){ replace_if(all(v),fn,r); }\r\
    \ntemplate <class T, class Boolean=bool> inline ul cntif(const T& v, const Boolean\
    \ &fn){ return count_if(all(v),fn); }\r\ntemplate <class T> inline T Count(V<T>&\
    \ v, ll x){ if(!is_sorted(all(v))) Sort(v); return UB(v,x)-LB(v,x); }\r\ntemplate\
    \ <class T> inline T IP(const V<T>& v, const V<T>& u, T init){ return inner_product(all(v),u.begin(),init);\
    \ }\r\ninline vi iot(int n, ll init=0){ vi a(n); iota(all(a),init); return a;\
    \ }\r\ntemplate <class T, class U, class F> inline V<T> trans(const V<U>& v, const\
    \ F &fn){ V<T> res; transform(all(v),back_inserter(res),fn); return res; }\r\n\
    template <class T, class U> inline int ers(T& v, const U x){ v.erase(remove(all(v),x),v.end());\
    \ return v.size(); }\r\ntemplate <class T, class Boolean=bool> int ersif(T& v,\
    \ const Boolean &fn){ v.erase(remove_if(all(v),fn),v.end()); return v.size();\
    \ }\r\ntemplate <class T> inline int unq(T& v){ if(!is_sorted(all(v))) Sort(v);\
    \ v.erase(unique(all(v)),v.end()); return v.size(); }\r\ntemplate <class T> inline\
    \ T cp(const T& v){ T res; copy(all(v),back_inserter(res)); return res; }\r\n\
    template <class T> inline T cp(const T& v, const int a, const int b){ T res; copy(all(v,a,b),back_inserter(res));\
    \ return res; }\r\ntemplate <class T> inline void rtt(T& s, const int idx){ const\
    \ int id=zia_qu::Mod<int>(idx,s.size()); rotate(all(s,id),s.end()); }\r\ntemplate\
    \ <class T> inline void rtt(T& s, const int a, const int b, const int c){ rotate(all(s,a,b),s.end()-c);\
    \ }\r\ntemplate <class T> inline T setdif(const T& s, const T& t){ assert(is_sorted(all(s))&&is_sorted(all(t)));\
    \ T res; set_difference(all(s),all(t),inserter(res,end(res))); return res; }\r\
    \ntemplate <class T> inline T setsum(const T& s, const T& t){ assert(is_sorted(all(s))&&is_sorted(all(t)));\
    \ T res; set_union(all(s),all(t),inserter(res,end(res))); return res; }\r\ntemplate\
    \ <class T> inline T setmul(const T& s, const T& t){ assert(is_sorted(all(s))&&is_sorted(all(t)));\
    \ T res; set_intersection(all(s),all(t),inserter(res,end(res))); return res; }\r\
    \ntemplate <class T> inline V<T> adf(const V<T>& v){ V<T> a; adjacent_difference(all(v),back_inserter(a));\
    \ rtt(a,1); a.pop_back(); return a; }\r\ntemplate <class T, class F> inline V<T>\
    \ isum(const V<T> &v, const F &fn){ V<T> s{0}; inclusive_scan(all(v),back_inserter(s),fn);\
    \ return s; }\r\ntemplate <class T> inline V<T> rext(const V<T>& v, const int\
    \ size){ V<T> res; sample(all(v),back_inserter(res),size,Random()); return res;\
    \ }\r\ntemplate <class T> inline T rext(const V<T>& v){ V<T> res; sample(all(v),back_inserter(res),1,Random());\
    \ return res.front(); }\r\ntemplate <class T> inline ll vsum(const T &v){ return\
    \ accumulate(all(v),0LL); }\r\ntemplate <class T> inline ll vsum(const T &v, ll\
    \ a, ll b){ return accumulate(all(v,a,b),0LL); }\r\ntemplate <class T> inline\
    \ ld vdsum(const T &v){ return accumulate(all(v),0.0L); }\r\ntemplate <class T>\
    \ inline ld vdsum(const T &v, ll a, ll b){ return accumulate(all(v,a,b),0.0L);\
    \ }\r\ntemplate <class T> inline ll vmul(const T &v){ return accumulate(all(v),1LL,[](ll\
    \ acc,ll i){ return acc*i; }); }\r\ntemplate <class T> inline ll vmul(const T\
    \ &v, ll a, ll b){ return accumulate(all(v,a,b),1LL,[](ll acc,ll i){ return acc*i;\
    \ }); }\r\ntemplate <class T> inline ld vdmul(const T &v){ return accumulate(all(v),1.0L,[](ll\
    \ acc,ll i){ return acc*i; }); }\r\ntemplate <class T> inline ld vdmul(const T\
    \ &v, ll a, ll b){ return accumulate(all(v,a,b),1.0L,[](ll acc,ll i){ return acc*i;\
    \ }); }\r\n} // Lady s&y\r\n\r\nnamespace Heileden {\r\ntemplate <class T> inline\
    \ V<T> div(const T n) {\r\n  V<T> d;\r\n  sqrp(i,1,n) {\r\n    if(n%i==0) {\r\n\
    \      d.emplace_back(i);\r\n      if(i*i!=n) d.emplace_back(n/i);\r\n    }\r\n\
    \  }\r\n  Lady_sANDy::Sort(d);\r\n  return d;\r\n}\r\ntemplate <class T> inline\
    \ V<PP<T>> prmfct(T n) {\r\n  V<PP<T>> res;\r\n  sqrp(i,2,n) {\r\n    if(n%i!=0)\
    \ continue;\r\n    T tmp=0;\r\n    while(n%i==0) {\r\n      tmp++;\r\n      n/=i;\r\
    \n    }\r\n    res.emplace_back(i,tmp);\r\n  }\r\n  if(n!=1) res.emplace_back(n,1);\r\
    \n  return res;\r\n}\r\nstruct p_table {\r\n  vb SoE;\r\n  p_table(int n): SoE(n+1,1){\r\
    \n    SoE[0]=SoE[1]=0;\r\n    rep(i,2,n) {\r\n      if(!SoE[i]) continue;\r\n\
    \      rep(j,i*i,n,i) SoE[j] = 0;\r\n    }\r\n  }\r\n  vi get() {\r\n    vi p;\r\
    \n    rep(i,2,SoE.size()-1) if(SoE[i]) p.emplace_back(i);\r\n    return p;\r\n\
    \  }\r\n};\r\nstruct p_fact {\r\n  vi spf;\r\n  p_fact(int n): spf(n + 1){\r\n\
    \    iota(all(spf),0);\r\n    sqrp(i,2,n) {\r\n      if(spf[i]==i) {\r\n     \
    \   rep(j,i*i,n,i) {\r\n          if(spf[j]==j) spf[j]=i;\r\n        }\r\n   \
    \   }\r\n    }\r\n  }\r\n  map<int,int> get(int n) {\r\n    map<int,int> m;\r\n\
    \    while(n!=1) {\r\n      m[spf[n]]++;\r\n      n/=spf[n];\r\n    }\r\n    return\
    \ m;\r\n  }\r\n};\r\nstruct asum {\r\n  vi s;\r\n  asum(const vi& v): s{0} { partial_sum(all(v),back_inserter(s));\
    \ }\r\n  vi get() const { return s; }\r\n  // [l, r]\r\n  ll query(int l, int\
    \ r) const { return s[r]-s[l]; }\r\n};\r\ntemplate <class T, class Boolean=bool>\
    \ inline T bins(T ok, T ng, const Boolean &fn, const ld eps = 1) {\r\n  while(abs(ok-ng)>eps)\
    \ {\r\n    T mid=(ok+ng)/2;\r\n    (fn(mid)?ok:ng) = mid;\r\n  }\r\n  return ok;\r\
    \n}\r\ntemplate <class T> inline V<T> press(const V<T>& v) {\r\n  V<T> res,cp=v;\r\
    \n  Lady_sANDy::unq(cp);\r\n  each(el,v) res.emplace_back(Lady_sANDy::LB(cp,el));\r\
    \n  return res;\r\n}\r\ntemplate <class T> inline V<T> press(V<T> &c1, V<T> &c2)\
    \ {\r\n  V<T> res;\r\n  const int n = c1.size();\r\n  rep(n) {\r\n    for(T d\
    \ = 0; d < 1; d++) {\r\n      T tc1 = c1[i]+d;\r\n      T tc2 = c2[i]+d;\r\n \
    \     res.emplace_back(tc1);\r\n      res.emplace_back(tc2);\r\n    }\r\n  }\r\
    \n  Lady_sANDy::unq(res);\r\n  rep(n) {\r\n    c1[i]=Lady_sANDy::LB(res,c1[i]);\r\
    \n    c2[i]=Lady_sANDy::LB(res,c2[i]);\r\n  }\r\n  return res;\r\n}\r\ninline\
    \ vs rtt(const vs &s) {\r\n  const int h=s.size(), w=s.front().size();\r\n  vs\
    \ t(w,string(h,{}));\r\n  rep(h) rep(j,w) t[j][i]=s[i][j];\r\n  rep(w) Lady_sANDy::rev(t[i]);\r\
    \n  return t;\r\n}\r\ntemplate <class T> inline V<V<T>> rtt(const V<V<T>>& v)\
    \ {\r\n  const int h=v.size(), w=v.front().size();\r\n  V<V<T>> res(w,V<T>(h));\r\
    \n  rep(h) rep(j,w) res[j][i]=v[i][j];\r\n  rep(w) Lady_sANDy::rev(res[i]);\r\n\
    \  return res;\r\n}\r\ntemplate <class T> inline T factor(T n, const T mod=0)\
    \ {\r\n  T res=1;\r\n  while(n>0) {\r\n    res*=n--;\r\n    if(mod) res%=mod;\r\
    \n  }\r\n  return res;\r\n}\r\ntemplate <class T=ll> inline T perm(T n, const\
    \ T r, const T mod=0) {\r\n  const T tmp=n;\r\n  T res=1;\r\n  while(n>tmp-r)\
    \ {\r\n    res*=n--;\r\n    if(mod) res%=mod;\r\n  }\r\n  return res;\r\n}\r\n\
    template <class T=ll> inline T binom(T n, const T r, const T mod=0) {\r\n  if(r\
    \ < 0 || n < r) return 0;\r\n  T res = 1;\r\n  rep(i,1,r) {\r\n    res*=n--;\r\
    \n    if(mod) res%=mod;\r\n    res/=i;\r\n    if(mod) res%=mod;\r\n  }\r\n  return\
    \ res;\r\n}\r\ninline bool is_prime(const ul n) {\r\n  if(n==1) return 0;\r\n\
    \  sqrp(i,2,n) if(n%i==0) return 0;\r\n  return 1;\r\n}\r\ninline bool is_int(const\
    \ ld n){ ll r=floor(n); return r==n; }\r\ninline bool is_sqr(const ll n){ return\
    \ is_int(sqrtl(n)); }\r\n} // Heileden"
  dependsOn: []
  isVerificationFile: false
  path: C++/template.hpp
  requiredBy:
  - C++/Modint.hpp
  timestamp: '2023-11-09 16:48:01+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/m_add.test.cpp
  - test/parsum.test.cpp
  - test/uf.test.cpp
  - test/ftree.test.cpp
  - test/add128.test.cpp
  - test/aarray.test.cpp
  - test/sr_sum.test.cpp
  - test/segtree.test.cpp
  - test/s_rmq.test.cpp
  - test/stable.test.cpp
  - test/add.test.cpp
documentation_of: C++/template.hpp
layout: document
redirect_from:
- /library/C++/template.hpp
- /library/C++/template.hpp.html
title: C++/template.hpp
---