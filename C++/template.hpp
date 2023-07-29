#if !__INCLUDE_LEVEL__
#include __FILE__

void VvyLw::solve() {
  
}

// --------------------------------------------------------------------------------------------------------------

#else

#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>
using namespace std;
using namespace __gnu_pbds;

// --------------------------------------------------------------------------------------------------------------

/*#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")//*/
//#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
#pragma GCC diagnostic ignored "-Wunused-parameter"
#pragma GCC diagnostic ignored "-Wsign-compare"
#pragma GCC diagnostic ignored "-Wdeprecated-copy"

namespace VvyLw {
void wa_haya_exe(){ cin.tie(nullptr) -> sync_with_stdio(false); }
void solve();
} // VvyLw

mt19937 EhaL(hash<string>()("Huitloxopetl"));
mt19937 Random() {
  random_device seed_gen;
  mt19937 engine {seed_gen()};
  return engine;
}

using Timer = chrono::system_clock::time_point;
[[maybe_unused]] Timer start, stop;
#if local
void now(Timer &t){ t = chrono::system_clock::now(); }
void time(const Timer &t1, const Timer &t2){ auto tm = chrono::duration_cast<chrono::milliseconds>(t2-t1).count(); cout << tm << "ms\n"; }
#else
[[maybe_unused]] void now(Timer &t){ void(0); }
[[maybe_unused]] void time(const Timer &t1, const Timer &t2){ void(0); }
#endif

// --------------------------------------------------------------------------------------------------------------

#define overload4(_1,_2,_3,_4,name,...) name
#define overload3(_1,_2,_3,name,...) name
#define rep1(n) for(ll i=0; i<(n); ++i)
#define rep2(i,n) for(ll i=0; i<(n); ++i)
#define rep3(i,a,b) for(ll i=(a); i<=(b); ++i)
#define rep4(i,a,b,c) for(ll i=(a); i<=(b); i+=(c))
#define rep(...) overload4(__VA_ARGS__,rep4,rep3,rep2,rep1)(__VA_ARGS__)
#define rvp1(n) for(ll i=(n)-1; i>=0; i--)
#define rvp2(i,n) for(ll i=(n)-1; i>=0; i--)
#define rvp3(i,a,b) for(ll i=(a); i>=(b); i--)
#define rvp4(i,a,b,c) for(ll i=(a); i>=(b); i-=(c))
#define rvp(...) overload4(__VA_ARGS__,rvp4,rvp3,rvp2,rvp1)(__VA_ARGS__)
#define all1(v) v.begin(),v.end()
#define all2(v,a) v.begin(),v.begin()+a
#define all3(v,a,b) v.begin()+a,v.begin()+b
#define all(...) overload3(__VA_ARGS__,all3,all2,all1)(__VA_ARGS__)
#define rall1(v) v.rbegin(),v.rend()
#define rall2(v,a) v.rbegin(),v.rbegin()+a
#define rall3(v,a,b) v.rbegin()+a,v.rbegin()+b
#define rall(...) overload3(__VA_ARGS__,rall3,rall2,rall1)(__VA_ARGS__)
#define each1(elem,v) for(auto &elem: v)
#define each2(x,y,v) for(auto &[x,y]: v)
#define each3(x,y,z,v) for(auto &[x,y,z]: v)
#define each(...) overload4(__VA_ARGS__,each3,each2,each1)(__VA_ARGS__)
#define sqrp1(n) for(ll i=0; i*i<(n); ++i)
#define sqrp2(i,n) for(ll i=0; i*i<(n); ++i)
#define sqrp3(i,a,b) for(ll i=(a); i*i<=(b); ++i)
#define sqrp(...) overload3(__VA_ARGS__,sqrp3,sqrp2,sqrp1)(__VA_ARGS__)
#define irp(it,v) for(auto it=v.begin(); it!=v.end(); ++it)
#define ir(it,v) for(auto it=v.begin(); it!=v.end();)

using ll = long long;
using ld = long double;
using uint = unsigned;
using ul = unsigned long long;
using i128 = __int128_t;
using u128 = __uint128_t;
namespace vectors {
template <class T> using V = vector<T>;
using vi = V<ll>;
using vu = V<ul>;
using vd = V<ld>;
using vc = V<char>;
using vs = V<string>;
using vb = V<bool>;
using wi = V<vi>;
using wu = V<vu>;
using wd = V<vd>;
using wc = V<vc>;
using ws = V<vs>;
using wb = V<vb>;
template <class T, class U> inline V<U> ndiv_v(T&& n, U&& v) noexcept {
  return V<U>(forward<T>(n), forward<U>(v));
}
template <class T, class... Ts> inline decltype(auto) ndiv_v(T&& n, Ts&&... v) noexcept {
  return V<decltype(ndiv_v(forward<Ts>(v)...))>(forward<T>(n), ndiv_v(forward<Ts>(v)...));
}
template <class T> V<T>& operator++(V<T>& v){ each(el,v) el++; return v; }
template <class T> V<T>& operator--(V<T>& v){ each(el,v) el--; return v; }
template <class T, class U> V<T>& operator+=(V<T>& v, const U x){ each(el,v) el+=x; return v; }
template <class T, class U> V<T>& operator-=(V<T>& v, const U x){ each(el,v) el-=x; return v; }
template <class T, class U> V<T>& operator*=(V<T>& v, const U x){ each(el,v) el*=x; return v; }
template <class T, class U> V<T>& operator/=(V<T>& v, const U x){ each(el,v) el/=x; return v; }
template <class T, class U> V<T>& operator%=(V<T>& v, const U x){ each(el,v) el%=x; return v; }
template <class T, class U> V<T> operator+(const V<T>& v, const U x){ V<T> res = v; res+=x; return res; }
template <class T, class U> V<T> operator-(const V<T>& v, const U x){ V<T> res = v; res-=x; return res; }
template <class T, class U> V<T> operator*(const V<T>& v, const U x){ V<T> res = v; res*=x; return res; }
template <class T, class U> V<T> operator/(const V<T>& v, const U x){ V<T> res = v; res/=x; return res; }
template <class T, class U> V<T> operator%(const V<T>& v, const U x){ V<T> res = v; res%=x; return res; }
} // vectors
using namespace vectors;
namespace pairs {
template <class T, class U> using P = pair<T, U>;
template <class T> using PP = P<T,T>;
using pi = PP<ll>;
using pd = PP<ld>;
using pc = PP<char>;
using ps = PP<string>;
template <class T> PP<T> operator+(const PP<T>& a, const PP<T>& b){ return {a.first + b.first, a.second + b.second}; }
template <class T> PP<T> operator-(const PP<T>& a, const PP<T>& b){ return {a.first - b.first, a.second - b.second}; }
template <class T> PP<T> operator-(const PP<T>& a){ return {-a.first, -a.second}; }
template <class T, class U> PP<T> operator*(const PP<T>& a, const U& b){ return {a.first * b, a.second * b}; }
template <class T, class U> PP<T> operator/(const PP<T>& a, const U& b){ return {a.first / b, a.second / b}; }
template <class T> PP<T>& operator+=(PP<T>& a, const PP<T>& b){ return a = a + b; }
template <class T> PP<T>& operator-=(PP<T>& a, const PP<T>& b){ return a = a - b; }
template <class T, class U> PP<T>& operator*=(PP<T>& a, const U& b){ return a = a * b; }
template <class T, class U> PP<T>& operator/=(PP<T>& a, const U& b){ return a = a / b; }
template <class T> bool operator==(const PP<T> &p, const PP<T> &q){ return p.first==q.first && p.second==q.second; }
template <class T> bool operator!=(const PP<T> &p, const PP<T> &q){ return !(p==q); }
template <class T> bool operator<(const PP<T> &p, const PP<T> &q){ if(p.first==q.first) return p.second<q.second; return p.first<q.first; }
template <class T> bool operator<=(const PP<T> &p, const PP<T> &q){ if(p.first==q.first) return p.second<=q.second; return p.first<q.first; }
template <class T> bool operator>(const PP<T> &p, const PP<T> &q){ if(p.first==q.first) return p.second>q.second; return p.first>q.first; }
template <class T> bool operator>=(const PP<T> &p, const PP<T> &q){ if(p.first==q.first) return p.second>=q.second; return p.first>q.first; }
template <class T, class U> bool operator==(const P<T,U> &p, const P<T,U> &q){ return p.first==q.first && p.second==q.second; }
template <class T, class U> bool operator!=(const P<T,U> &p, const P<T,U> &q){ return !(p==q); }
template <class T, class U> bool operator<(const P<T,U> &p, const P<T,U> &q){ if(p.first==q.first) return p.second<q.second; return p.first<q.first; }
template <class T, class U> bool operator<=(const P<T,U> &p, const P<T,U> &q){ if(p.first==q.first) return p.second<=q.second; return p.first<q.first; }
template <class T, class U> bool operator>(const P<T,U> &p, const P<T,U> &q){ if(p.first==q.first) return p.second>q.second; return p.first>q.first; }
template <class T, class U> bool operator>=(const P<T,U> &p, const P<T,U> &q){ if(p.first==q.first) return p.second>=q.second; return p.first>q.first; }
template <class T> PP<T> rotate(const PP<T>& a){ return {-a.second, a.first}; } // 90 degree ccw
template <class T> T dot(const PP<T>& a, const PP<T>& b){ return a.first * b.first + a.second * b.second; }
template <class T> T cross(const PP<T>& a, const PP<T>& b){ return dot(rotate(a), b); }
template <class T> T square(const PP<T>& a){ return dot(a, a); }
template <class T> ld grad(const PP<T>& a){ assert(a.first); return 1.0L * a.second / a.first; }
template <class T> ld abs(const PP<T>& a){ return hypotl(a.first, a.second); }
template <class T> T gcd(const PP<T>& a){ return gcd(a.first, a.second); }
template <class T> PP<T> normalize(PP<T> a) {
  if(a == PP<T>{}) return a;
  a /= gcd(a);
  if(a < PP<T>{}) a = -a;
  return a;
}
template <class T, class U> P<U,T> swap(const P<T,U> &p){ P<U,T> ret={p.second,p.first}; return ret; }
template <class T, class U> V<P<U,T>> swap(const V<P<T,U>> &vp) {
  V<P<U,T>> ret;
  each(el,vp) ret.emplace_back(swap(el));
  return ret;
}
template <class T, class U> V<T> first(const V<P<T,U>> &vp) {
  V<T> res;
  each(el,vp) res.emplace_back(el.first);
  return res;
}
template <class T, class U> V<U> second(const V<P<T,U>> &vp) {
  V<U> res;
  each(el,vp) res.emplace_back(el.second);
  return res;
}
} // pairs
using namespace pairs;
template <class T> using pq = priority_queue<T>;
template <class T> using pqr = priority_queue<T,V<T>,greater<T>>;
template <class T> using Tree = tree<T,null_type,less<T>,rb_tree_tag,tree_order_statistics_node_update>;
template <class T> using TREE = tree<T,null_type,greater<T>,rb_tree_tag,tree_order_statistics_node_update>;
template <class T, class U> bool chmax(T& a, const U& b){ if(a<b){ a=b; return 1; } return 0; }
template <class T, class U> bool chmin(T& a, const U& b){ if(a>b){ a=b; return 1; } return 0; }
template <class T, class U> inline bool overflow_if_add(T a, U b){ return (numeric_limits<T>::max()-a)<b; }
template <class T, class U> inline bool overflow_if_mul(T a, U b){ return (numeric_limits<T>::max()/a)<b; }
const int dx[]={0,0,0,-1,1,-1,-1,1,1};
const int dy[]={0,-1,1,0,0,-1,1,-1,1};
const int MOD = 0x3b800001;
const int M0D = 1e9+7;
const int INF = 0x3fffffff;
const ll LINF = 0x1fffffffffffffff;
const ld DINF = numeric_limits<ld>::infinity();
const double PI = acos(-1);
const double E = 2.718281828459045;

namespace IO {
ostream &operator<<(ostream &dest, i128 value) {
  ostream::sentry s(dest);
  if(s) {
    u128 tmp = value < 0 ? -value : value;
    char buffer[128];
    char *d = end(buffer);
    do {
      --d;
      *d = "0123456789"[tmp % 10];
      tmp /= 10;
    } while(tmp != 0);
    if(value < 0) {
      --d;
      *d = '-';
    }
    int len = end(buffer) - d;
    if(dest.rdbuf()->sputn(d, len) != len) {
      dest.setstate(ios_base::badbit);
    }
  }
  return dest;
}
template <class T> void scan(T& a){ cin >> a; }
template <class T, class U> void scan(P<T,U>& p){ scan(p.first); scan(p.second); }
template <size_t id=0, class T> void scan_t(T &t) {
  if constexpr (id<tuple_size<T>::value) {
    scan(get<id>(t));
    scan_t<id+1>(t);
  }
}
template <class... Ts> void scan(tuple<Ts...> &t){ scan_t(t); }
template <class T> void scan(V<T>& a){ each(i,a) scan(i); }
template <class T> void lin(T& a){ getline(cin, a); }
[[maybe_unused]] void in(){}
template <class Head, class... Tail> void in(Head& head, Tail&... tail){ scan(head); in(tail...); }
template <class T> void print(const T& a){ cout << a; }
template <class T> void println(const T& a){ cout << a; }
template <class T, class U> void print(const P<T,U>& p){ print(p.first); cout<<" "; print(p.second); }
template <size_t id=0, class T> void print_t(const T& t) {
  if constexpr (id<tuple_size<T>::value) {
    if constexpr (id>0) cout << ' ';
    print(get<id>(t));
    print_t<id+1>(t);
  }
}
template <class... T> void print(const tuple<T...>& tpl){ print_t(tpl); }
template <class T> void print(const V<T>& a){ if(!a.empty()){ print(a[0]); for(auto i=a.begin(); ++i!=a.end();){ cout<<' '; print(*i); } } }
template <class T> void println(const V<T>& a){ if(!a.empty()){ print(a[0]); for(auto i=a.begin(); ++i!=a.end();){ cout<<'\n'; print(*i); } } }
template <class T, class U> void print(const map<T,U> &m){ if(!m.empty()){ print(m.begin()->first); cout<<' '; print(m.begin()->second); for(auto i=m.begin(); ++i!=m.end();){ cout<<", "; print(i->first); cout<<' '; print(i->second); } } }
template <class T> void print(const set<T> &st){ print(*st.begin()); for(auto i=st.begin(); ++i!=st.end();){ cout<<' '; print(*i); } }
template <class T> void print(queue<T> que){ print(que.front()); while(que.size()){ cout<<' '; que.pop(); if(!que.empty()) print(que.front()); } }
template <class T> void print(const deque<T> &dq){ if(!dq.empty()){ print(dq[0]); for(auto i=dq.begin(); ++i!=dq.end();){ cout<<' '; print(*i); } } }
template <class T> void println(const deque<T> &dq){ if(!dq.empty()){ print(dq[0]); for(auto i=dq.begin(); ++i!=dq.end();){ cout<<'\n'; print(*i); } } }
template <class T> void print(stack<T> sk){ print(sk.top()); while(sk.size()){ cout<<' '; sk.pop(); if(!sk.empty()) print(sk.top()); } }
template <class T, class Container, class Compare> void print(priority_queue<T, Container, Compare> pq){ print(pq.top()); while(pq.size()){ pq.pop(); cout<<' '; if(!pq.empty()) print(pq.top()); } }
void bl(){ cout<<' '; }
void out(){ cout<<'\n'; }
template <class T> void out(const T& t){ print(t); cout<<'\n'; }
template <class T> void vout(const T& t){ println(t); cout<<'\n'; }
template <class Head, class... Tail> void out(const Head& head, const Tail&... tail){ print(head); cout<<' '; out(tail...); }
template <class Head, class... Tail> void vout(const Head& head, const Tail&... tail){ println(head); cout<<'\n'; vout(tail...); }
void fix(short x){ cout << fixed << setprecision(x); }
void Alpha(){ cout << boolalpha; }
void Flush(){ flush(cout); }
#define INT(...) int __VA_ARGS__; in(__VA_ARGS__)
#define LL(...) ll __VA_ARGS__; in(__VA_ARGS__)
#define UL(...) ul __VA_ARGS__; in(__VA_ARGS__)
#define DBL(...) double __VA_ARGS__; in(__VA_ARGS__)
#define LD(...) ld __VA_ARGS__; in(__VA_ARGS__)
#define CHR(...) char __VA_ARGS__; in(__VA_ARGS__)
#define STR(...) string __VA_ARGS__; in(__VA_ARGS__)
#define LIN(str) string str; lin(str)
#define VEC(type,name,size) V<type> name(size); in(name)
#define WEC(type,name,h,w) V<V<type>> name(h,V<type>(w)); in(name)
#define fin(...) do{ out(__VA_ARGS__); return; }while(false)
} // IO
using namespace IO;

namespace zia_qu {
#ifdef local
#define debug(...) do { print(#__VA_ARGS__); print(':'); out(__VA_ARGS__); } while(false)
#else
#define debug(...) void(0)
#endif
#define elif else if
#define eid(el,v) &el-&v[0]
#define bif(bit,tar) if(((tar)>>(bit))&1)
#define nxp(x) next_permutation(all(x))
#define prp(x) prev_permutation(all(x))
#define strpl(s,a,b) regex_replace(s,regex(a),b)
#define rgxmt(s,rgx) regex_match(s,regex(rgx))
inline void YES(bool ok=1){ out(ok?"YES":"NO"); }
inline void NO(bool ok=1){ YES(!ok); }
inline void Yes(bool ok=1){ out(ok?"Yes":"No"); }
inline void No(bool ok=1){ Yes(!ok); }
inline void yes(bool ok=1){ print(ok?"yes":"no"); }
inline void no(bool ok=1){ yes(!ok); }
template <class T> inline T sqr(T x){ return x*x; }
template <class T> inline T cub(T x){ return x*x*x; }
template <class T> inline T Mod(T x, T m){ return (x+m)%m; }
template <class T> inline T Pow(T a, T b, T mod=0) {
  T res=1;
  if(mod) {
    res%=mod;
    a%=mod;
  }
  while(b>0) {
    if(b&1) res*=a;
    if(mod) res%=mod;
    a*=a;
    if(mod) a%=mod;
    b>>=1;
  }
  return res;
}
inline ll Ceil(ld x, ll m){ return ceil(x/m); }
inline ll Round(ld x, ll m, short fx=0){ if(fx==0) return round(x/m); else { ul y=Pow<ul>(10,fx); return round((x/y)/m)*y; } }
inline ld Log(ll x, double base=2){ return log2(x)/log2(base); }
inline int bitdigit(ll x){ return 64-__builtin_clzll(x); }
inline int popcnt(ll x){ return __builtin_popcountll(x); }
inline int fione(ll x){ return __builtin_ffsll(x); }
inline int zrcnt(ll x){ return __builtin_ctzll(x); }
template <class T=ll> inline bool out_of_scope(T min, T cod, T max){ return cod < min || cod >= max; }
template <class T=ll> inline bool scope(T a, T x, T b){ return a <= x && x <= b; }
inline bool isupper(char c){ return std::isupper(c); }
inline bool isupper(const string &s){ bool ok=1; each(el,s) ok&=isupper(el); return ok; }
inline bool islower(char c){ return std::islower(c); }
inline bool islower(const string &s){ bool ok=1; each(el,s) ok&=islower(el); return ok; }
inline bool isalpha(char c){ return std::isalpha(c); }
inline bool isalpha(const string &s){ bool ok=1; each(el,s) ok&=isalpha(el); return ok; }
inline bool isdigit(char c){ return std::isdigit(c); }
inline bool isdigit(const string &s){ bool ok=1; each(el,s) ok&=isdigit(el); return ok; }
inline bool isalnum(char c){ return std::isalnum(c); }
inline bool isalnum(const string &s){ bool ok=1; each(el,s) ok&=isalnum(el); return ok; }
inline bool isspace(char c){ return std::isspace(c); }
inline bool isspace(const string &s){ bool ok=1; each(el,s) ok&=isspace(el); return ok; }
inline bool ispunct(char c){ return std::ispunct(c); }
inline bool ispunct(const string &s){ bool ok=1; each(el,s) ok&=ispunct(el); return ok; }
inline bool isprint(char c){ return std::isprint(c); }
inline bool isprint(const string &s){ bool ok=1; each(el,s) ok&=isprint(el); return ok; }
inline ll strins(string &s, ll id, const string &t){ s.insert(id,t); return s.size(); }
inline string toupper(string s){ each(c,s) c=std::toupper(c); return s; }
inline string tolower(string s){ each(c,s) c=std::tolower(c); return s; }
inline vi ten_to_adic(ll m, ll n) {
  vi res;
  ll now=m;
  while(now!=0) {
    res.emplace_back(now%n);
    now/=n;
  }
  //rev(res);
  return res;
}
inline ll adic_to_ten(vi &v, ll u) {
  ll res=0;
  //rev(v);
  each(el,v) {
    ll idx=eid(el,v);
    res+=Pow(u,idx)*el;
  }
  return res;
}
inline string to_hex(ll x) {
  stringstream ss;
  ss<<hex<<x;
  string s=ss.str();
  //s=toupper(s);
  return s;
}
inline string to_oct(ll x) {
  stringstream s;
  s<<oct<<x;
  return s.str();
}
inline string to_bin(ll x) {
  stringstream ss;
  ss<<bitset<64>(x);
  string s=ss.str();
  reverse(all(s));
  s.resize(ten_to_adic(x,2).size());
  reverse(all(s));
  return s;
}
inline ll to_ten(string s, short base){ return stoll(s,nullptr,base); }
inline i128 stoL(string &s) {
  i128 ret = 0;
  each(el,s) {
    if(isdigit(el)) ret = 10 * ret + el - '0';
  }
  if(s.front()=='-') ret=-ret;
  return ret;
}
template <class... Ts> constexpr auto symin(Ts... a){ return min(initializer_list<common_type_t<Ts...>>{a...}); }
template <class... Ts> constexpr auto symax(Ts... a){ return max(initializer_list<common_type_t<Ts...>>{a...}); }
template <class K, class U> inline V<K> kyl(const map<K,U> m, const U val) {
  V<K> keys;
  irp(it,m) {
    if(it->second==val) keys.emplace_back(it->first);
  }
  return keys;
}
template <class K, class V> inline K kymin(const map<K,V> &m){ return m.begin()->first; }
template <class K, class V> inline K kymax(const map<K,V> &m){ return m.rbegin()->first; }
template <class K, class V> inline V kymin_v(const map<K,V> &m){ return m.begin()->second; }
template <class K, class V> inline V kymax_v(const map<K,V> &m){ return m.rbegin()->second; }
template <class K, class V> inline V vlmin(const map<K,V> &m){
  auto pr = *min_element(all(m),[](P<K,V> const &x, P<K,V> const &y){ return x.second > y.second; });
  return pr.second;
}
template <class K, class V> inline V vlmax(const map<K,V> &m){
  auto pr = *max_element(all(m),[](P<K,V> const &x, P<K,V> const &y){ return x.second < y.second; });
  return pr.second;
}
template <class K, class V> inline K vlmin_k(const map<K,V> &m){
  auto pr = *min_element(all(m),[](P<K,V> const &x, P<K,V> const &y){ return x.second > y.second; });
  return pr.first;
}
template <class K, class V> inline K vlmax_k(const map<K,V> &m){
  auto pr = *max_element(all(m),[](P<K,V> const &x, P<K,V> const &y){ return x.second < y.second; });
  return pr.first;
}
template <class T> inline T stmin(const set<T> &s){ return *s.begin(); }
template <class T> inline T stmax(const set<T> &s){ return *s.rbegin(); }
} // zia qu

namespace Lady_sANDy {
template <class T> inline void rev(T& v){ reverse(all(v)); }
template <class T> inline void rev(T& v, ll a, ll b){ reverse(all(v,a,b)); }
template <class T> inline T revd(const T& v){ auto c=v; rev(c); return c; }
template <class T> inline T revd(const T& v, ll a, ll b){ auto c=v; rev(c,a,b); return c; }
template <class T> inline void Sort(T& v){ sort(all(v)); }
template <class T> inline void Sort(T& v, ll a, ll b){ sort(all(v,a,b)); }
template <class T> inline T sorted(T& v){ auto c=v; Sort(c); return c; }
template <class T> inline T sorted(T& v, ll a, ll b){ auto c=v; Sort(c,a,b); return c; }
template <class T> inline void Sortt(T& v){ sort(rall(v)); }
template <class T> inline void Sortt(T& v, ll a, ll b){ sort(rall(v,a,b)); }
template <class T> inline T Sorted(T& v){ auto c=v; Sortt(c); return c; }
template <class T> inline T Sorted(T& v, ll a, ll b){ auto c=v; Sortt(c,a,b); return c; }
template <class T> inline void Sorth(T& v){ make_heap(all(v)); sort_heap(all(v)); }
template <class T> inline T mrg(T& a, T& b){ T res; merge(all(a),all(b),back_inserter(res)); return res; }
template <class T> inline T Min(const V<T>& v){ return *min_element(all(v)); }
template <class T> inline T Max(const V<T>& v){ return *max_element(all(v)); }
template <class T> inline ll Min_i(const T& v){ return min_element(all(v))-v.begin(); }
template <class T> inline ll Max_i(const T& v){ return max_element(all(v))-v.begin(); }
template <class T, class U> inline ll LB(const T& v, const U x){ return lower_bound(all(v),x)-v.begin(); }
template <class T, class U> inline ll UB(const T& v, const U x){ return upper_bound(all(v),x)-v.begin(); }
template <class T, class U> inline bool BS(const T& v, const U x){ return binary_search(all(v),x); }
template <class T, class U, class Boolean=bool> inline bool BS(const T& v, const U x, Boolean fn){ return binary_search(all(v),x,fn); }
template <class T, class Boolean=bool> inline bool All(const T& v, Boolean fn){ return all_of(all(v),fn); }
template <class T, class Boolean=bool> inline bool Exist(const T& v, Boolean fn){ return any_of(all(v),fn); }
template <class T, class Boolean=bool> inline ll pt(T& v, Boolean fn){ auto p=partition(all(v),fn); return p-v.begin(); }
template <class T, class Boolean=bool> inline ll ptp(const T& v, Boolean fn){ return partition_point(all(v),fn)-v.begin(); }
template <class T, class U> inline ll Find(T& v, const U x){ auto itr=find(all(v),x); if(itr==v.end()) return -1LL; return itr-v.begin(); }
template <class T, class U> inline void rpl(T& v, const U fn, const U r){ replace(all(v),fn,r); }
template <class T, class U, class Boolean=bool> inline void rplif(T& v, Boolean fn, const U r){ replace_if(all(v),fn,r); }
template <class T, class Boolean=bool> inline ul cntif(const T& v, Boolean fn){ return count_if(all(v),fn); }
template <class T> inline T Count(V<T>& v, ll x){ /*Sort(v);//*/ return UB(v,x)-LB(v,x); }
template <class T> inline T IP(const V<T>& v, const V<T>& u, T init){ return inner_product(all(v),u.begin(),init); }
template <class T> inline V<T> iot(T n, ll init=0){ V<T> a(n); iota(all(a),init); return a;}
template <class T, class U> inline ll ers(T& v, U x){ v.erase(remove(all(v),x),v.end()); return v.size(); }
template <class T, class Boolean=bool> ll ersif(T& v, Boolean x){ v.erase(remove_if(all(v),x),v.end()); return v.size(); }
template <class T> inline ll unq(T& v){ Sort(v); v.erase(unique(all(v)),v.end()); return v.size(); }
template <class T> inline T cp(const T& v){ T res; copy(all(v),back_inserter(res)); return res; }
template <class T> inline T cp(const T& v, ll a, ll b){ T res; copy(all(v,a,b),back_inserter(res)); return res; }
template <class T> inline void rtt(T& s, ll idx){ ll id=zia_qu::Mod<ll>(idx,s.size()); rotate(all(s,id),s.end());  }
template <class T> inline void rtt(T& s, ll a, ll b, ll c){ rotate(all(s,a,b),s.end()-c);  }
template <class T> inline V<T> psum(const V<T>& v){ V<T> s{0}; partial_sum(all(v),back_inserter(s)); return s; }
template <class T> inline V<T> adf(const V<T>& v){ V<T> a; adjacent_difference(all(v),back_inserter(a)); rtt(a,1); a.pop_back(); return a; }
template <class T> inline V<T> rext(V<T>& v, mt19937 eng, ll size){ V<T> res; sample(all(v),back_inserter(res),size,eng); return res; }
template <class T> inline T rext(V<T>& v, mt19937 eng){ V<T> res; sample(all(v),back_inserter(res),1,eng); return res.front(); }
template <class T> inline ll vsum(V<T> &v){ return reduce(all(v),0LL); }
template <class T> inline ll vsum(V<T> &v, ll a, ll b){ return reduce(all(v,a,b),0LL); }
template <class T> inline ld vdsum(V<T> &v){ return reduce(all(v),0.0L); }
template <class T> inline ld vdsum(V<T> &v, ll a, ll b){ return reduce(all(v,a,b),0.0L); }
template <class T> inline ll vmul(V<T> &v){ return reduce(all(v),1LL,[](ll acc,ll i){ return acc*i; }); }
template <class T> inline ll vmul(V<T> &v, ll a, ll b){ return reduce(all(v,a,b),1LL,[](ll acc,ll i){ return acc*i; }); }
template <class T> inline ld vdmul(V<T> &v){ return reduce(all(v),1.0L,[](ll acc,ll i){ return acc*i; }); }
template <class T> inline ld vdmul(V<T> &v, ll a, ll b){ return reduce(all(v,a,b),1.0L,[](ll acc,ll i){ return acc*i; }); }
} // Lady s&y

namespace Heileden {
template <class T> inline V<T> div(T n) {
  V<T> d;
  sqrp(i,1,n) {
    if(n%i==0) {
      d.emplace_back(i);
      if(i*i!=n) d.emplace_back(n/i);
    }
  }
  Lady_sANDy::Sort(d);
  return d;
}
template <class T> inline V<PP<T>> prmfct(T n) {
  V<PP<T>> res;
  sqrp(i,2,n) {
    if(n%i!=0) continue;
    T tmp=0;
    while(n%i==0) {
      tmp++;
      n/=i;
    }
    res.emplace_back(i,tmp);
  }
  if(n!=1) res.emplace_back(n,1);
  return res;
}
struct p_table {
  vb SoE;
  p_table(int n): SoE(n+1,1){
    SoE[0]=SoE[1]=0;
    rep(i,2,n) {
      if(!SoE[i]) continue;
      rep(j,i*i,n,i) SoE[j] = 0;
    }
  }
  vi table(int n) {
    vi p;
    rep(i,2,n) if(SoE[i]) p.emplace_back(i);
    return p;
  }
};
struct p_fact {
  vi spf;
  p_fact(int n): spf(n + 1){
    iota(all(spf),0);
    sqrp(i,2,n) {
      if(spf[i]==i) {
        rep(j,i*i,n,i) {
          if(spf[j]==j) spf[j]=i;
        }
      }
    }
  }
  map<int,int> get(int n) {
    map<int,int> m;
    while(n!=1) {
      m[spf[n]]++;
      n/=spf[n];
    }
    return m;
  }
};
template <class T, class Boolean=bool> inline T bins(T ok, T ng, Boolean fn, ld eps = 1) {
  while(abs(ok-ng)>eps) {
    T mid=(ok+ng)/2;
    (fn(mid)?ok:ng) = mid;
  }
  return ok;
}
template <class T> inline V<T> cmp(const V<T>& v) {
  V<T> res,cp=v;
  Lady_sANDy::unq(cp);
  each(el,v) res.emplace_back(Lady_sANDy::LB(cp,el));
  return res;
}
template <class T> inline V<T> cmp2(V<T> &c1, V<T> &c2) {
  V<T> res;
  const int n = c1.size();
  rep(n) {
    for(T d = 0; d < 1; d++) {
      T tc1 = c1[i]+d;
      T tc2 = c2[i]+d;
      res.emplace_back(tc1);
      res.emplace_back(tc2);
    }
  }
  Lady_sANDy::unq(res);
  rep(n) {
    c1[i]=Lady_sANDy::LB(res,c1[i]);
    c2[i]=Lady_sANDy::LB(res,c2[i]);
  }
  return res;
}
vi manacher(const string &s) {
  const int n = s.size();
  vi radius(n);
  ll i = 0, j = 0;
  while(i < n) {
    while(i - j >= 0 && i + j < n && s[i - j] == s[i + j]) ++j;
    radius[i] = j;
    ll k = 1;
    while(i - k >= 0 && i + k < n && k + radius[i - k] < j) {
      radius[i + k] = radius[i - k];
      ++k;
    }
    i += k;
    j -= k;
  }
  return radius;
}
template <class T> T factor(T n, T mod=0) {
  T res=1;
  while(n>0) {
    res*=n--;
    if(mod) res%=mod;
  }
  return res;
}
template <class T=ll> T perm(T n, T r, T mod=0) {
  const T tmp=n;
  T res=1;
  while(n>tmp-r) {
    res*=n--;
    if(mod) res%=mod;
  }
  return res;
}
template <class T=ll> T binom(T n, T r, T mod=0) {
  if(r < 0 || n < r) return 0;
  T res = 1;
  rep(i,1,r) {
    res*=n--;
    if(mod) res%=mod;
    res/=i;
    if(mod) res%=mod;
  }
  return res;
}
inline bool is_int(ld n){ ll r=floor(n); return r==n; }
inline bool is_sqr(ll n){ return is_int(sqrt(n)); }
/* grundy sample
template <class T> inline bool grundy(V<T> v) {
  ll res=0;
  each(el,v) res^=el;
  return res!=0;
}//*/
} // Heileden


// --------------------------------------------------------------------------------------------------------------

using namespace zia_qu;
using namespace Lady_sANDy;
using namespace Heileden;

int main() {
  VvyLw::wa_haya_exe();
  now(start);
  /*INT(t); while(t--)//*/
  VvyLw::solve();
  now(stop);
  time(start, stop);
}

#endif
