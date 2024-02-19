#pragma once
#ifndef TEMPLATE
#define TEMPLATE
#endif
#pragma GCC diagnostic ignored "-Wunused-parameter"
#pragma GCC diagnostic ignored "-Wsign-compare"
#pragma GCC diagnostic ignored "-Wdeprecated-copy"
#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>
namespace VvyLw {
inline void wa_haya_exe() noexcept { std::cin.tie(nullptr) -> sync_with_stdio(false); }
void solve();
} // VvyLw
namespace zia_qu {
inline bool isdigit(const std::string &s);
}
std::mt19937 EhaL(std::hash<std::string>()("Huitloxopetl"));
std::mt19937 Random() {
	std::random_device seed_gen;
	std::mt19937 engine {seed_gen()};
	return engine;
}

#include "timer.hpp"

#define overload4(_1,_2,_3,_4,name,...) name
#define overload3(_1,_2,_3,name,...) name
#define rep1(n) for(ll i=0; i<(n); ++i)
#define rep2(i,n) for(ll i=0; i<(n); ++i)
#define rep3(i,a,b) for(ll i=(a); i<=(b); ++i)
#define rep4(i,a,b,c) for(ll i=(a); i<=(b); i+=(c))
#define rep(...) overload4(__VA_ARGS__,rep4,rep3,rep2,rep1)(__VA_ARGS__)
#define rvp1(n) for(ll i=(n); --i>=0;)
#define rvp2(i,n) for(ll i=(n); --i>=0;)
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

using ll = long long;
using ld = long double;
using uint = unsigned;
using ul = unsigned long long;
using i128 = __int128_t;
using u128 = __uint128_t;

#include "mypair.hpp"

using namespace vectors;
using namespace pairs;

template <size_t N> using ti = std::array<ll, N>;
using tri = ti<3>;
template <class T> using pq = std::priority_queue<T>;
template <class T> using pqr = std::priority_queue<T,V<T>,std::greater<T>>;
template <class T> using Tree = __gnu_pbds::tree<T,__gnu_pbds::null_type,std::less<T>,__gnu_pbds::rb_tree_tag,__gnu_pbds::tree_order_statistics_node_update>;
template <class T> using TREE = __gnu_pbds::tree<T,__gnu_pbds::null_type,std::greater<T>,__gnu_pbds::rb_tree_tag,__gnu_pbds::tree_order_statistics_node_update>;
template <class T, class U> inline bool chmax(T& a, const U& b){ if(a<b){ a=b; return 1; } return 0; }
template <class T, class U> inline bool chmin(T& a, const U& b){ if(a>b){ a=b; return 1; } return 0; }
template <class T, class U> inline bool overflow_if_add(const T a, const U b){ return (LIM<T>-a)<b; }
template <class T, class U> inline bool overflow_if_mul(const T a, const U b){ return (LIM<T>/a)<b; }
inline void fix(const short x){ std::cout << std::fixed << std::setprecision(x); }
inline void alpha(){ std::cout << std::boolalpha; }

#include "io/input.hpp"
#include "io/output.hpp"

using namespace IO;

#ifdef local
//https://gist.github.com/naskya/1e5e5cd269cfe16a76988378a60e2ca3
#include <io/debug_print.hpp>
#define debug(...) debug_print::multi_print(#__VA_ARGS__, __VA_ARGS__)
#else
#define debug(...) static_cast<void>(0)
#endif

namespace zia_qu {
#define elif else if
#define eid(el,v) size_t(&el-&v[0])
#define bif(bit,tar) if(((bit)>>(tar))&1)
#define nxp(x) std::next_permutation(all(x))
#define prp(x) std::prev_permutation(all(x))
#define strpl(s,a,b) std::regex_replace(s,std::regex(a),b)
#define rgxsr(s,rgx) std::regex_search(s,std::regex(rgx))
inline void YES(const bool ok=1){ out(ok?"YES":"NO"); }
inline void NO(const bool ok=1){ YES(!ok); }
inline void Yes(const bool ok=1){ out(ok?"Yes":"No"); }
inline void No(const bool ok=1){ Yes(!ok); }
inline void yes(const bool ok=1){ out(ok?"yes":"no"); }
inline void no(const bool ok=1){ yes(!ok); }
template <class T> inline T sqr(const T x){ return x*x; }
template <class T> inline T cub(const T x){ return x*x*x; }
template <class T> inline T mod(T x, const T m) {
	x %= m;
	return x < 0 ? x + m : x;
}
template <class T> inline T pow(T a, T b, const T mod=0) {
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
inline ll ceil(const ld x, const ll m){ return std::ceil(x/m); }
inline ld round(const ld x, const ll m, const short fx=0){ if(!fx) return std::round(x/m); const ul y=pow<ul>(10,fx); return std::round((x*y)/m)/y; }
inline ld log(const ll x, const ld base=2){ return std::log2(x)/std::log2(base); }
inline int bitdigit(const ll x){ return 64-__builtin_clzll(x); }
inline int popcnt(const ll x){ return __builtin_popcountll(x); }
inline int fione(const ll x){ return __builtin_ffsll(x); }
inline int zrcnt(const ll x){ return __builtin_ctzll(x); }
template <class T=ll> inline bool scope(const T a, const T x, const T b){ return a <= x && x <= b; }
inline bool isupper(const char c){ return std::isupper(c); }
inline bool isupper(const std::string &s){ bool ok=1; each(el,s) ok&=isupper(el); return ok; }
inline bool islower(const char c){ return std::islower(c); }
inline bool islower(const std::string &s){ bool ok=1; each(el,s) ok&=islower(el); return ok; }
inline bool isalpha(const char c){ return std::isalpha(c); }
inline bool isalpha(const std::string &s){ bool ok=1; each(el,s) ok&=isalpha(el); return ok; }
inline bool isdigit(const char c){ return std::isdigit(c); }
inline bool isdigit(const std::string &s){ bool ok=1, neg=s.front()=='-'; each(el,s){ if(neg){ neg=0; continue; } ok&=isdigit(el); } return ok; }
inline bool isalnum(const char c){ return std::isalnum(c); }
inline bool isalnum(const std::string &s){ bool ok=1; each(el,s) ok&=isalnum(el); return ok; }
inline bool isspace(const char c){ return std::isspace(c); }
inline bool isspace(const std::string &s){ bool ok=1; each(el,s) ok&=isspace(el); return ok; }
inline bool ispunct(const char c){ return std::ispunct(c); }
inline bool ispunct(const std::string &s){ bool ok=1; each(el,s) ok&=ispunct(el); return ok; }
inline bool isprint(const char c){ return std::isprint(c); }
inline bool isprint(const std::string &s){ bool ok=1; each(el,s) ok&=isprint(el); return ok; }
inline ll strins(std::string &s, const int id, const std::string &t){ s.insert(id,t); return s.size(); }
inline std::string toupper(std::string s){ each(c,s) c=std::toupper(c); return s; }
inline std::string tolower(std::string s){ each(c,s) c=std::tolower(c); return s; }
inline vi ten_to_adic(ll n, const short base) {
	if(n==0) {
		return {0};
	}
	vi res;
	while(n) {
		res.emplace_back(n%base);
		n/=base;
	}
	return res;
}
inline ll adic_to_ten(const vi &v, const short base) {
	ll res=0;
	each(el,v) {
		res+=pow<ll>(base,eid(el,v))*el;
	}
	return res;
}
inline std::string to_hex(const ll x, const bool upper = false) {
	std::stringstream ss;
	ss << std::hex << x;
	std::string s = ss.str();
	if(upper) s=toupper(s);
	return s;
}
inline std::string to_oct(const ll x) {
	std::stringstream s;
	s << std::oct <<x;
	return s.str();
}
inline std::string to_bin(const ll x) {
	std::stringstream ss;
	ss<<std::bitset<64>(x);
	std::string s=ss.str();
	std::reverse(all(s));
	s.resize(ten_to_adic(x,2).size());
	std::reverse(all(s));
	return s;
}
inline ll to_ten(const std::string &s, const short base){ return std::stoll(s,nullptr,base); }
template <class... Ts> constexpr ul sygcd(const Ts... a) noexcept { std::vector v=std::initializer_list<std::common_type_t<Ts...>>{a...}; ul g=0; each(el,v) g=std::gcd(g,el); return g; }
template <class... Ts> constexpr ul sylcm(const Ts... a) noexcept { std::vector v=std::initializer_list<std::common_type_t<Ts...>>{a...}; ul l=1; each(el,v) l=std::lcm(l,el); return l; }
template <class... Ts> constexpr auto symin(const Ts... a) noexcept { return std::min(std::initializer_list<std::common_type_t<Ts...>>{a...}); }
template <class... Ts> constexpr auto symax(const Ts... a) noexcept { return std::max(std::initializer_list<std::common_type_t<Ts...>>{a...}); }
template <class K, class U> inline V<K> kyl(const std::map<K,U> &m, const U val) {
	V<K> keys;
	for(auto it=m.cbegin(); it!=m.cend(); ++it) {
		if(it->second==val) keys.emplace_back(it->first);
	}
	return keys;
}
template <class K, class V> inline K kymin(const std::map<K,V> &m){ return m.begin()->first; }
template <class K, class V> inline K kymax(const std::map<K,V> &m){ return m.rbegin()->first; }
template <class K, class V> inline V kymin_v(const std::map<K,V> &m){ return m.begin()->second; }
template <class K, class V> inline V kymax_v(const std::map<K,V> &m){ return m.rbegin()->second; }
template <class K, class V> inline V vlmin(const std::map<K,V> &m){
	const auto pr = *std::min_element(all(m),[](P<K,V> const &x, P<K,V> const &y){ return x.second < y.second; });
	return pr.second;
}
template <class K, class V> inline V vlmax(const std::map<K,V> &m){
	const auto pr = *std::max_element(all(m),[](P<K,V> const &x, P<K,V> const &y){ return x.second < y.second; });
	return pr.second;
}
template <class K, class V> inline K vlmin_k(const std::map<K,V> &m){
	const auto pr = *std::min_element(all(m),[](P<K,V> const &x, P<K,V> const &y){ return x.second < y.second; });
	return pr.first;
}
template <class K, class V> inline K vlmax_k(const std::map<K,V> &m){
	const auto pr = *std::max_element(all(m),[](P<K,V> const &x, P<K,V> const &y){ return x.second < y.second; });
	return pr.first;
}
} // zia qu

namespace Lady_sANDy {
template <class T> inline void rev(T& v){ std::reverse(all(v)); }
template <class T> inline void rev(T& v, const int a, const int b){ std::reverse(all(v,a,b+1)); }
template <class T> inline T revd(const T& v){ auto c=v; rev(c); return c; }
template <class T> inline T revd(const T& v, const int a, const int b){ auto c=v; rev(c,a,b); return c; }
template <class T> inline void Sort(T& v){ std::sort(all(v)); }
template <class T> inline void Sort(T& v, const int a, const int b){ std::sort(all(v,a,b+1)); }
template <class T> inline T sorted(const T& v){ auto c=v; Sort(c); return c; }
template <class T> inline T sorted(const T& v, const int a, const int b){ auto c=v; Sort(c,a,b); return c; }
template <class T> inline void Sortt(T& v){ std::sort(rall(v)); }
template <class T> inline void Sortt(T& v, const int a, const int b){ std::sort(rall(v,v.size()-b-1,v.size()-a)); }
template <class T> inline T Sorted(const T& v){ auto c=v; Sortt(c); return c; }
template <class T> inline T Sorted(const T& v, const int a, const int b){ auto c=v; Sortt(c,a,b); return c; }
template <class T> inline void Sorth(T& v){ std::make_heap(all(v)); std::sort_heap(all(v)); }
template <class T> inline T mrg(const T& a, const T& b){ T res; std::merge(all(a),all(b),std::back_inserter(res)); return res; }
template <class T> inline T Min(const V<T>& v){ return *std::min_element(all(v)); }
template <class T> inline T Min(const V<T>& v, const int a, const int b){ return *std::min_element(all(v,a,b+1)); }
template <class T> inline T Max(const V<T>& v){ return *std::max_element(all(v)); }
template <class T> inline T Max(const V<T>& v, const int a, const int b){ return *std::max_element(all(v,a,b+1)); }
template <class T> inline int Min_i(const T& v){ return std::min_element(all(v))-v.begin(); }
template <class T> inline int Max_i(const T& v){ return std::max_element(all(v))-v.begin(); }
template <class T, class U> inline int LB(const T& v, const U x){ return std::lower_bound(all(v),x)-v.begin(); }
template <class T, class U> inline int UB(const T& v, const U x){ return std::upper_bound(all(v),x)-v.begin(); }
template <class T, class U> inline bool BS(const T& v, const U x){ return std::binary_search(all(v),x); }
template <class T, class U, class Boolean=bool> inline bool BS(const T& v, const U x, const Boolean &fn){ return std::binary_search(all(v),x,fn); }
template <class T, class Boolean=bool> inline bool All(const T& v, const Boolean &fn){ return std::all_of(all(v),fn); }
template <class T, class Boolean=bool> inline bool Exist(const T& v, const Boolean &fn){ return std::any_of(all(v),fn); }
template <class T, class Boolean=bool> inline int pt(T& v, const Boolean &fn){ auto p=std::partition(all(v),fn); return p-v.begin(); }
template <class T, class Boolean=bool> inline int ptp(const T& v, const Boolean &fn){ return std::partition_point(all(v),fn)-v.begin(); }
template <class T, class U> inline int fnd(const T& v, const U x){ auto itr=std::find(all(v),x); return itr!=v.end()?itr-v.begin():-1; }
template <class T> inline int src(const T& s, const T& t){ auto itr=std::search(all(s),all(t)); return itr!=s.end()?itr-s.begin():-1; }
template <class T, class U> inline void rpl(T& v, const U fn, const U r){ std::replace(all(v),fn,r); }
template <class T, class U, class Boolean=bool> inline void rplif(T& v, const Boolean &fn, const U r){ std::replace_if(all(v),fn,r); }
template <class T, class Boolean=bool> inline ul cntif(const T& v, const Boolean &fn){ return std::count_if(all(v),fn); }
template <class T> inline T Count(V<T>& v, ll x){ if(!std::is_sorted(all(v))) Sort(v); return UB(v,x)-LB(v,x); }
template <class T> inline T IP(const V<T>& v, const V<T>& u, T init){ return std::inner_product(all(v),u.begin(),init); }
inline vi iot(int n, ll init=0){ vi a(n); std::iota(all(a),init); return a; }
template <class T, class U, class F> inline V<T> trans(const V<U>& v, const F &fn){ V<T> res; std::transform(all(v),std::back_inserter(res),fn); return res; }
template <class T, class U> inline int ers(T& v, const U x){ v.erase(std::remove(all(v),x),v.end()); return v.size(); }
template <class T, class Boolean=bool> int ersif(T& v, const Boolean &fn){ v.erase(std::remove_if(all(v),fn),v.end()); return v.size(); }
template <class T> inline int unq(T& v){ if(!std::is_sorted(all(v))) Sort(v); v.erase(unique(all(v)),v.end()); return v.size(); }
template <class T> inline T cp(const T& v){ T res; copy(all(v),back_inserter(res)); return res; }
template <class T> inline T cp(const T& v, const int a, const int b){ T res; std::copy(all(v,a,b),std::back_inserter(res)); return res; }
template <class T> inline void rtt(T& s, const int idx){ const int id=zia_qu::mod<int>(idx,s.size()); std::rotate(all(s,id),s.end()); }
template <class T> inline void rtt(T& s, const int a, const int b, const int c){ std::rotate(all(s,a,b),s.end()-c); }
template <class T> inline T setdif(const T& s, const T& t){ assert(std::is_sorted(all(s))&&std::is_sorted(all(t))); T res; std::set_difference(all(s),all(t),std::inserter(res,std::end(res))); return res; }
template <class T> inline T setsum(const T& s, const T& t){ assert(std::is_sorted(all(s))&&std::is_sorted(all(t))); T res; std::set_union(all(s),all(t),std::inserter(res,std::end(res))); return res; }
template <class T> inline T setmul(const T& s, const T& t){ assert(std::is_sorted(all(s))&&std::is_sorted(all(t))); T res; std::set_intersection(all(s),all(t),std::inserter(res,std::end(res))); return res; }
template <class T> inline V<T> adf(const V<T>& v){ V<T> a; std::adjacent_difference(all(v),std::back_inserter(a)); rtt(a,1); a.pop_back(); return a; }
template <class T, class F> inline V<T> isum(const V<T> &v, const F &fn){ V<T> s{0}; std::inclusive_scan(all(v),std::back_inserter(s),fn); return s; }
template <class T> inline V<T> rext(const V<T>& v, const int size){ V<T> res; std::sample(all(v),std::back_inserter(res),size,Random()); return res; }
template <class T> inline T rext(const V<T>& v){ V<T> res; std::sample(all(v),std::back_inserter(res),1,Random()); return res.front(); }
template <class T> inline ll vsum(const T &v){ return std::accumulate(all(v),0LL); }
template <class T> inline ll vsum(const T &v, ll a, ll b){ return std::accumulate(all(v,a,b),0LL); }
template <class T> inline ld vdsum(const T &v){ return std::accumulate(all(v),0.0L); }
template <class T> inline ld vdsum(const T &v, ll a, ll b){ return std::accumulate(all(v,a,b),0.0L); }
template <class T> inline ll vmul(const T &v){ return std::accumulate(all(v),1LL,[](ll acc,ll i){ return acc*i; }); }
template <class T> inline ll vmul(const T &v, ll a, ll b){ return std::accumulate(all(v,a,b),1LL,[](ll acc,ll i){ return acc*i; }); }
template <class T> inline ld vdmul(const T &v){ return std::accumulate(all(v),1.0L,[](ll acc,ll i){ return acc*i; }); }
template <class T> inline ld vdmul(const T &v, ll a, ll b){ return std::accumulate(all(v,a,b),1.0L,[](ll acc,ll i){ return acc*i; }); }
} // Lady s&y

#include "math/divisor.hpp"
#include "math/primefactor.hpp"
#include "math/primetable.hpp"
#include "math/primefactortable.hpp"
#include "math/prefixsum.hpp"
#include "math/kthrooti.hpp"

namespace Heileden {
template <class T, class Boolean=bool> inline T bins(T ok, T ng, const Boolean &fn, const ld eps = 1) {
	while(std::abs(ok-ng)>eps) {
		T mid=(ok+ng)/2;
		(fn(mid)?ok:ng) = mid;
	}
	return ok;
}
template <class T> inline V<T> press(const V<T>& v) {
	V<T> res,cp=v;
	Lady_sANDy::unq(cp);
	each(el,v) res.emplace_back(Lady_sANDy::LB(cp,el));
	return res;
}
template <class T> inline V<T> press(V<T> &c1, V<T> &c2) {
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
inline vs rtt(const vs &s) {
	const int h=s.size(), w=s.front().size();
	vs t(w,std::string(h,{}));
	rep(h) rep(j,w) t[j][i]=s[i][j];
	rep(w) Lady_sANDy::rev(t[i]);
	return t;
}
template <class T> inline V<V<T>> rtt(const V<V<T>>& v) {
	const int h=v.size(), w=v.front().size();
	V<V<T>> res(w,V<T>(h));
	rep(h) rep(j,w) res[j][i]=v[i][j];
	rep(w) Lady_sANDy::rev(res[i]);
	return res;
}
template <class T> inline T factor(T n, const T mod=0) {
	T res=1;
	while(n>0) {
		res*=n--;
		if(mod) res%=mod;
	}
	return res;
}
template <class T=ll> inline T perm(T n, const T r, const T mod=0) {
	const T tmp=n;
	T res=1;
	while(n>tmp-r) {
		res*=n--;
		if(mod) res%=mod;
	}
	return res;
}
template <class T=ll> inline T binom(T n, const T r, const T mod=0) {
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
inline bool is_prime(const ul n) {
	if(n==1) return 0;
	sqrp(i,2,n) if(n%i==0) return 0;
	return 1;
}
inline bool is_int(const ld n){ return n == std::floor(n); }
inline bool is_sqr(const ll n){ return is_int(std::sqrt(n)); }
} // Heileden

/**
 * @brief テンプレート
 * @docs docs/template.md
 */