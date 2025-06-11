#pragma once
#ifndef TEMPLATE
#define TEMPLATE
#endif
#pragma GCC diagnostic ignored "-Wunused-parameter"
#pragma GCC diagnostic ignored "-Wsign-compare"
#pragma GCC diagnostic ignored "-Wdeprecated-copy"
#include <bits/stdc++.h>
namespace VvyLw {
inline void wa_haya_exe() noexcept { std::cin.tie(nullptr) -> sync_with_stdio(false); }
inline void dec_prec(const short x) noexcept { std::cout << std::fixed << std::setprecision(x); }
void solve();
}

namespace man {
inline bool isdigit(const std::string &s) noexcept;
std::mt19937 EhaL(std::hash<std::string>()("Huitloxopetl"));
inline std::mt19937 rand() noexcept {
	std::random_device seed_gen;
	std::mt19937 engine {seed_gen()};
	return engine;
}

template <class T, class U> constexpr inline bool chmax(T& a, const U& b) noexcept { if(a < b){ a = b; return true; } return false; }
template <class T, class U> constexpr inline bool chmin(T& a, const U& b) noexcept { if(a > b){ a = b; return true; } return false; }
template <class T, class U> constexpr inline bool overflow_if_add(const T a, const U b) noexcept { return (std::numeric_limits<T>::max() - a) < b; }
template <class T, class U> constexpr inline bool overflow_if_mul(const T a, const U b) noexcept { return (std::numeric_limits<T>::max() / a) < b; }

inline std::string string_replace(const std::string &s, const std::string &a, const std::string &b) noexcept { return std::regex_replace(s, std::regex(a), b); }
inline bool regex_contains(const std::string &s, const std::string &t) noexcept { return std::regex_search(s, std::regex(t)); }
constexpr inline auto yes(const bool ok = true) noexcept { return ok ? "Yes" : "No"; }
template <class T> constexpr inline T sqr(const T x) noexcept { return x * x; }
template <class T> constexpr inline T cub(const T x) noexcept { return x * x * x; }
template <class T> constexpr inline T mod(T x, const T m) noexcept {
	x %= m;
	return x < 0 ? x + m : x;
}
template <class T> constexpr inline T pow(T a, T b, const T mod = 0) noexcept {
	T ret = 1;
	if(mod != 0) {
		ret %= mod;
		a %= mod;
	}
	while(b > 0) {
		if(b & 1) {
			ret *= a;
		}
		if(mod != 0) {
			ret %= mod;
		}
		a *= a;
		if(mod) {
			a %= mod;
		}
		b >>= 1;
	}
	return ret;
}
constexpr inline int64_t ceil(const long double x, const int64_t m) noexcept { return std::ceil(x / m); }
constexpr inline long double round(const long double x, const int64_t m, const short fx = 0) noexcept {
	if(fx == 0) {
		return std::round(x / m);
	}
	const uint64_t y = pow<uint64_t>(10, fx);
	return std::round((x * y) / m) / y;
}
constexpr inline long double log(const int64_t x, const long double base = 2) noexcept { return std::log2(x) / std::log2(base); }
constexpr inline int bitdigit(const int64_t x) noexcept { return 64 - __builtin_clzll(x); }
constexpr inline int popcnt(const int64_t x) noexcept { return __builtin_popcountll(x); }
constexpr inline int fione(const int64_t x) noexcept { return __builtin_ffsll(x); }
constexpr inline int zrcnt(const int64_t x) noexcept { return __builtin_ctzll(x); }
template <class T = int64_t> constexpr inline bool scope(const T a, const T x, const T b) noexcept { return a <= x && x <= b; }
constexpr inline bool isupper(const char c) noexcept { return std::isupper(c); }
inline bool isupper(const std::string &s) noexcept {
	bool ok = true;
	for(const auto &el: s) {
		ok &= isupper(el);
	}
	return ok;
}
constexpr inline bool islower(const char c) noexcept { return std::islower(c); }
inline bool islower(const std::string &s) noexcept {
	bool ok = true;
	for(const auto &el: s) {
		ok &= islower(el);
	}
	return ok;
}
constexpr inline bool isalpha(const char c) noexcept { return std::isalpha(c); }
inline bool isalpha(const std::string &s) noexcept {
	bool ok = true;
	for(const auto &el: s) {
		ok &= isalpha(el);
	}
	return ok;
}
constexpr inline bool isdigit(const char c) noexcept { return std::isdigit(c); }
inline bool isdigit(const std::string &s) noexcept {
	bool ok = true, neg = s.front() == '-';
    for(const auto &el: s) {
        if(neg) {
            neg = false;
            continue;
        }
        ok &= isdigit(el);
    }
    return ok;
}
constexpr inline bool isalnum(const char c) noexcept { return std::isalnum(c); }
inline bool isalnum(const std::string &s) noexcept {
	bool ok = true;
	for(const auto &el: s) {
		ok &= isalnum(el);
	}
	return ok;
}
constexpr inline bool isspace(const char c) noexcept { return std::isspace(c); }
inline bool isspace(const std::string &s) noexcept {
	bool ok = true;
	for(const auto &el: s) {
		ok &= isspace(el);
	}
	return ok;
}
constexpr inline bool ispunct(const char c) noexcept { return std::ispunct(c); }
inline bool ispunct(const std::string &s) noexcept {
	bool ok = true;
	for(const auto &el: s) {
		ok &= ispunct(el);
	}
	return ok;
}
constexpr inline bool isprint(const char c) noexcept { return std::isprint(c); }
inline bool isprint(const std::string &s) noexcept {
	bool ok = true;
	for(const auto &el: s) {
		ok &= isprint(el);
	}
	return ok;
}
inline auto strins(std::string &s, const int id, const std::string &t) noexcept {
	s.insert(id, t);
	return std::ssize(s);
}
inline std::string toupper(std::string s) noexcept {
	for(auto &c: s) {
		c = std::toupper(c);
	}
	return s;
}
inline std::string tolower(std::string s) noexcept {
	for(auto &c: s) {
		c = std::tolower(c);
	}
	return s;
}
inline std::vector<int> ten_to_adic(int64_t n, const short base) noexcept {
	if(n == 0) {
		return {0};
	}
	std::vector<int> ret;
	while(n > 0) {
		ret.emplace_back(n % base);
		n /= base;
	}
	return ret;
}
inline int64_t adic_to_ten(const std::vector<int> &v, const short base) {
	int64_t ret = 0;
	for(const auto &el: v) {
		ret += pow<int64_t>(base, size_t(&el - &v[0])) * el;
	}
	return ret;
}
inline std::string to_hex(const int64_t x, const bool upper = false) noexcept {
	std::stringstream ss;
	ss << std::hex << x;
	const std::string s = ss.str();
	return upper ? toupper(s) : s;
}
inline std::string to_oct(const int64_t x) noexcept {
	std::stringstream s;
	s << std::oct << x;
	return s.str();
}
inline std::string to_bin(const int64_t x) noexcept {
	std::stringstream ss;
	ss << std::bitset<64>(x);
	std::string s = ss.str();
	std::ranges::reverse(s);
	s.resize(std::ssize(ten_to_adic(x, 2)));
	std::ranges::reverse(s);
	return s;
}
inline int64_t to_ten(const std::string &s, const short base = 10) noexcept { return std::stoll(s, nullptr, base); }
template <class... Ts> constexpr uint64_t sygcd(const Ts... a) noexcept {
	std::vector v = std::initializer_list<std::common_type_t<Ts...>>{a...};
	uint64_t g = 0;
	for(const auto &el: v) {
		g = std::gcd(g, el);
	}
	return g;
}
template <class... Ts> constexpr uint64_t sylcm(const Ts... a) noexcept {
	std::vector v = std::initializer_list<std::common_type_t<Ts...>>{a...};
	uint64_t l = 1;
	for(const auto &el: v) {
		l = std::lcm(l, el);
	}
	return l;
}
template <class... Ts> constexpr auto min(const Ts... a) noexcept { return std::min(std::initializer_list<std::common_type_t<Ts...>>{a...}); }
template <class... Ts> constexpr auto max(const Ts... a) noexcept { return std::max(std::initializer_list<std::common_type_t<Ts...>>{a...}); }
template <class K, class V> inline std::vector<K> key_l(const std::map<K, V> &m, const V val) noexcept {
	std::vector<K> keys;
	for(auto it = m.cbegin(); it != m.cend(); ++it) {
		if(it->second == val) {
			keys.emplace_back(it->first);
		}
	}
	return keys;
}
template <class K, class V> constexpr inline K key_min(const std::map<K, V> &m) noexcept { return m.begin()->first; }
template <class K, class V> constexpr inline K key_max(const std::map<K, V> &m) noexcept { return m.rbegin()->first; }
template <class K, class V> constexpr inline V key_min_v(const std::map<K, V> &m) noexcept { return m.begin()->second; }
template <class K, class V> constexpr inline V key_max_v(const std::map<K, V> &m) noexcept { return m.rbegin()->second; }
template <class K, class V> constexpr inline auto val_min(const std::map<K, V> &m) noexcept {
	return *std::ranges::min_element(m, [](const std::pair<K, V> &x, const std::pair<K, V> &y) -> bool { return x.second < y.second; });
}
template <class K, class V> constexpr inline auto val_max(const std::map<K, V> &m) noexcept {
	return *std::ranges::max_element(m, [](const std::pair<K, V> &x, const std::pair<K, V> &y) -> bool { return x.second < y.second; });
}

template <class T> constexpr inline T count(std::vector<T> v, const T &x) noexcept {
	if(!std::ranges::is_sorted(v)) {
		std::ranges::sort(v);
	}
	return std::ranges::upper_bound(v, x) - std::ranges::lower_bound(v, x);
}
template <class T> constexpr inline T inner_prod(const std::vector<T> &v, const std::vector<T> &u, const T init) noexcept { return std::inner_product(v.cbegin(), v.cend(), u.cbegin(), init); }
inline std::vector<int> iota(const int n, const int init = 0) noexcept {
	std::vector<int> a(n);
	std::iota(a.begin(), a.end(), init);
	return a;
}
template <class T> constexpr inline int uniq(T& v) noexcept {
	if(!std::ranges::is_sorted(v)) {
		std::ranges::sort(v);
	}
	const auto it = std::ranges::unique(v);
	v.erase(it.begin(), it.end());
	return std::ssize(v);
}
template <class T> constexpr inline void rotate(T& s, const int idx) noexcept {
	const int id = mod<int>(idx, std::ssize(s));
	std::ranges::rotate(s, s.begin() + id);
}
template <class T> constexpr inline T set_diff(const T& s, const T& t) noexcept {
	assert(std::ranges::is_sorted(s) && std::ranges::is_sorted(t));
	T ret;
	std::ranges::set_difference(s, t, std::inserter(ret, std::end(ret)));
	return ret;
}
template <class T> constexpr inline T set_sum(const T& s, const T& t) noexcept {
	assert(std::ranges::is_sorted(s) && std::ranges::is_sorted(t));
	T ret;
	std::ranges::set_union(s, t, std::inserter(ret, std::end(ret)));
	return ret;
}
template <class T> constexpr inline T set_mul(const T& s, const T& t) noexcept {
	assert(std::ranges::is_sorted(s) && std::ranges::is_sorted(t));
	T ret;
	std::ranges::set_intersection(s, t, std::inserter(ret, std::end(ret)));
	return ret;
}
template <class T> inline std::vector<T> adj_diff(const std::vector<T> &v) noexcept {
	std::vector<T> a;
	std::adjacent_difference(v.cbegin(), v.cend(), std::back_inserter(a));
	rotate(a, 1);
	a.pop_back();
	return a;
}
template <class T, class F> inline std::vector<T> isum(const std::vector<T> &v, const F &fn) noexcept {
	std::vector<T> s{0};
	std::inclusive_scan(v.cbegin(), v.cend(), std::back_inserter(s), fn);
	return s;
}
template <class T> inline std::vector<T> rand_extract(const std::vector<T> &v, const int size) noexcept {
	std::vector<T> ret;
	std::ranges::sample(v, std::back_inserter(ret), size, rand());
	return ret;
}
template <class T> inline T rand_extract(const std::vector<T> &v) noexcept {
	std::vector<T> ret;
	std::ranges::sample(v, std::back_inserter(ret), 1, rand());
	return ret.front();
}
template <class T = int64_t> constexpr inline T sum(const std::vector<T> &v) noexcept { return std::accumulate(v.cbegin(), v.cend(), T(0)); }
template <class T = int64_t> constexpr inline T sum(const std::vector<T> &v, const int a, const int b) noexcept { return std::accumulate(v.cbegin() + a, v.cbegin() + b, T(0)); }
template <class T = int64_t, class Boolean = bool> constexpr inline T sum(const std::vector<T> &v, const Boolean &fn) noexcept { return std::accumulate(v.cbegin(), v.cend(), T(0), fn); }
template <class T = int64_t, class Boolean = bool> constexpr inline T sum(const std::vector<T> &v, const int a, const int b, const Boolean &fn) noexcept { return std::accumulate(v.cbegin() + a, v.cbegin() + b, T(0), fn); }

template <class T, class Boolean = bool> constexpr inline T bins(T ok, T ng, const Boolean &fn, const long double eps = 1) noexcept {
	while(std::abs(ok - ng) > eps) {
		const T mid = (ok + ng) / 2;
		(fn(mid) ? ok : ng) = mid;
	}
	return ok;
}
inline std::vector<std::string> rotate(const std::vector<std::string> &s) noexcept {
	const int h = std::ssize(s), w = std::ssize(s.front());
	std::vector t(w, std::string(h, {}));
	for(const auto i: std::views::iota(0, h)) {
		for(const auto j: std::views::iota(0, w)) {
			t[j][i] = s[i][j];
		}
	}
	for(const auto i: std::views::iota(0, w)) {
		std::ranges::reverse(t[i]);
	}
	return t;
}
template <class T> inline std::vector<std::vector<T>> rotate(const std::vector<std::vector<T>> &v) noexcept {
	const int h = std::ssize(v), w = std::ssize(v.front());
	std::vector ret(w, std::vector<T>(h));
	for(const auto i: std::views::iota(0, h)) {
		for(const auto j: std::views::iota(0, w)) {
			ret[j][i] = v[i][j];
		}
	}
	for(const auto i: std::views::iota(0, w)) {
		std::ranges::reverse(ret[i]);
	}
	return ret;
}
template <class T> constexpr inline T factor(T n, const T mod = 0) noexcept {
	T ret = 1;
	while(n > 0) {
		ret *= n--;
		if(mod) {
			ret %= mod;
		}
	}
	return ret;
}
template <class T = int64_t> constexpr inline T perm(T n, const T r, const T mod = 0) noexcept {
	const T tmp = n;
	T ret = 1;
	while(n > tmp - r) {
		ret *= n--;
		if(mod) {
			ret %= mod;
		}
	}
	return ret;
}
template <class T = int64_t> constexpr inline T binom(T n, const T r, const T mod = 0) noexcept {
	if(r < 0 || n < r) {
		return 0;
	}
	T ret = 1;
	for(const auto i: std::views::iota(1) | std::views::take(r)) {
		ret *= n--;
		if(mod) {
			ret %= mod;
		}
		ret /= i;
		if(mod) {
			ret %= mod;
		}
	}
	return ret;
}
constexpr inline bool is_int(const long double n) noexcept { return n == std::floor(n); }
constexpr inline bool is_sqr(const int64_t n) noexcept { return is_int(std::sqrt(n)); }
}

#include "C++/core/timer.hpp"
#include "C++/core/mypair.hpp"
#include "C++/core/io/input.hpp"
#include "C++/core/io/output.hpp"

#define overload4(_1,_2,_3,_4,name,...) name
#define REP1(n) for([[maybe_unused]] const auto _: std::views::iota(0, (n)))
#define REP2(i,n) for(const auto i: std::views::iota(0, (n)))
#define REP3(i,a,b) for(const auto i: std::views::iota((a), (b) + 1))
#define REP4(i,a,b,c) for(i64 i = (a); i <= (b); i += (c))
#define REP(...) overload4(__VA_ARGS__, REP4, REP3, REP2, REP1)(__VA_ARGS__)

using namespace IO;
using namespace std::views;
namespace iter = std::ranges;

/**
 * @brief テンプレート
 * @docs docs/template.md
 */