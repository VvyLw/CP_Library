---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    _deprecated_at_docs: docs/template.md
    document_title: "\u30C6\u30F3\u30D7\u30EC\u30FC\u30C8"
    links:
    - https://gist.github.com/naskya/1e5e5cd269cfe16a76988378a60e2ca3
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 401, in update\n    self.update(self._resolve(pathlib.Path(included), included_from=path))\n\
    \  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 401, in update\n    self.update(self._resolve(pathlib.Path(included), included_from=path))\n\
    \  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 260, in _resolve\n    raise BundleErrorAt(path, -1, \"no such header\"\
    )\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt: mypair.hpp: line\
    \ -1: no such header\n"
  code: "#pragma once\r\n#ifndef TEMPLATE\r\n#define TEMPLATE\r\n#endif\r\n#pragma\
    \ GCC diagnostic ignored \"-Wunused-parameter\"\r\n#pragma GCC diagnostic ignored\
    \ \"-Wsign-compare\"\r\n#pragma GCC diagnostic ignored \"-Wdeprecated-copy\"\r\
    \n#include <bits/stdc++.h>\r\n#include <ext/pb_ds/assoc_container.hpp>\r\n#include\
    \ <ext/pb_ds/tree_policy.hpp>\r\nnamespace VvyLw {\r\ninline void wa_haya_exe()\
    \ noexcept { std::cin.tie(nullptr) -> sync_with_stdio(false); }\r\nvoid solve();\r\
    \n} // VvyLw\r\nnamespace zia_qu {\r\ninline bool isdigit(const std::string &s);\r\
    \n}\r\nstd::mt19937 EhaL(std::hash<std::string>()(\"Huitloxopetl\"));\r\nstd::mt19937\
    \ Random() {\r\n\tstd::random_device seed_gen;\r\n\tstd::mt19937 engine {seed_gen()};\r\
    \n\treturn engine;\r\n}\r\n\r\n#include \"timer.hpp\"\r\n\r\n#define overload4(_1,_2,_3,_4,name,...)\
    \ name\r\n#define overload3(_1,_2,_3,name,...) name\r\n#define rep1(n) for(ll\
    \ i=0; i<(n); ++i)\r\n#define rep2(i,n) for(ll i=0; i<(n); ++i)\r\n#define rep3(i,a,b)\
    \ for(ll i=(a); i<=(b); ++i)\r\n#define rep4(i,a,b,c) for(ll i=(a); i<=(b); i+=(c))\r\
    \n#define rep(...) overload4(__VA_ARGS__,rep4,rep3,rep2,rep1)(__VA_ARGS__)\r\n\
    #define rvp1(n) for(ll i=(n); --i>=0;)\r\n#define rvp2(i,n) for(ll i=(n); --i>=0;)\r\
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
    \n\r\n#include \"mypair.hpp\"\r\n\r\nusing namespace vectors;\r\nusing namespace\
    \ pairs;\r\n\r\ntemplate <size_t N> using ti = std::array<ll, N>;\r\nusing tri\
    \ = ti<3>;\r\ntemplate <class T> using pq = std::priority_queue<T>;\r\ntemplate\
    \ <class T> using pqr = std::priority_queue<T,V<T>,std::greater<T>>;\r\ntemplate\
    \ <class T> using Tree = __gnu_pbds::tree<T,__gnu_pbds::null_type,std::less<T>,__gnu_pbds::rb_tree_tag,__gnu_pbds::tree_order_statistics_node_update>;\r\
    \ntemplate <class T> using TREE = __gnu_pbds::tree<T,__gnu_pbds::null_type,std::greater<T>,__gnu_pbds::rb_tree_tag,__gnu_pbds::tree_order_statistics_node_update>;\r\
    \ntemplate <class T, class U> inline bool chmax(T& a, const U& b){ if(a<b){ a=b;\
    \ return 1; } return 0; }\r\ntemplate <class T, class U> inline bool chmin(T&\
    \ a, const U& b){ if(a>b){ a=b; return 1; } return 0; }\r\ntemplate <class T,\
    \ class U> inline bool overflow_if_add(const T a, const U b){ return (LIM<T>-a)<b;\
    \ }\r\ntemplate <class T, class U> inline bool overflow_if_mul(const T a, const\
    \ U b){ return (LIM<T>/a)<b; }\r\ninline void fix(const short x){ std::cout <<\
    \ std::fixed << std::setprecision(x); }\r\ninline void alpha(){ std::cout << std::boolalpha;\
    \ }\r\n\r\n#include \"io/input.hpp\"\r\n#include \"io/output.hpp\"\r\n\r\nusing\
    \ namespace IO;\r\n\r\n#ifdef local\r\n//https://gist.github.com/naskya/1e5e5cd269cfe16a76988378a60e2ca3\r\
    \n#include <io/debug_print.hpp>\r\n#define debug(...) debug_print::multi_print(#__VA_ARGS__,\
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
    \ acc*i; }); }\r\n} // Lady s&y\r\n\r\n#include \"math/divisor.hpp\"\r\n#include\
    \ \"math/primefactor.hpp\"\r\n#include \"math/primetable.hpp\"\r\n#include \"\
    math/primefactortable.hpp\"\r\n#include \"math/prefixsum.hpp\"\r\n#include \"\
    math/kthrooti.hpp\"\r\n\r\nnamespace Heileden {\r\ntemplate <class T, class Boolean=bool>\
    \ inline T bins(T ok, T ng, const Boolean &fn, const ld eps = 1) {\r\n\twhile(std::abs(ok-ng)>eps)\
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
    \r\n * @docs docs/template.md\r\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/template.hpp
  requiredBy: []
  timestamp: '1970-01-01 00:00:00+00:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/template.hpp
layout: document
redirect_from:
- /library/C++/template.hpp
- /library/C++/template.hpp.html
title: "\u30C6\u30F3\u30D7\u30EC\u30FC\u30C8"
---
## 最初に貼る
[詳しい話(前半)](https://vvylw.hatenablog.com/entry/2023/11/09/165722)  
後半はおいおい書きます。