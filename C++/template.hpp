#pragma once
#ifndef TEMPLATE
#define TEMPLATE
#endif
#pragma GCC diagnostic ignored "-Wunused-parameter"
#pragma GCC diagnostic ignored "-Wsign-compare"
#pragma GCC diagnostic ignored "-Wdeprecated-copy"
#include <bits/stdc++.h>
namespace VvyLw {
enum TestCase { single, multi };
inline void solve() noexcept;
template <TestCase tc = single, int x = 12> constexpr inline void wa_haya_exe() noexcept {
	std::cin.tie(nullptr) -> sync_with_stdio(false);
	std::cout << std::fixed << std::setprecision(x);
	int t = 1;
	if constexpr (tc == multi) {
		std::cin >> t;
	}
	for([[maybe_unused]] const auto _: std::views::iota(0, t)) {
		solve();
	}
}
}

using enum VvyLw::TestCase;

#include "C++/core/alias.hpp"

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
template <internal::num T, internal::num U> constexpr inline bool overflow_if_add(const T a, const U b) noexcept { return (std::numeric_limits<T>::max() - a) < b; }
template <internal::num T, internal::num U> constexpr inline bool overflow_if_mul(const T a, const U b) noexcept { return (std::numeric_limits<T>::max() / a) < b; }

template <int num> constexpr inline void setfill(const char c) noexcept { std::cout << std::setw(num) << std::setfill(c); }
inline std::string string_replace(const std::string &s, const std::string &a, const std::string &b) noexcept { return std::regex_replace(s, std::regex(a), b); }
inline bool regex_contains(const std::string &s, const std::string &t) noexcept { return std::regex_search(s, std::regex(t)); }
constexpr inline auto yes(const bool ok) noexcept { return ok ? "Yes" : "No"; }
template <internal::num T> constexpr inline T sqr(const T x) noexcept { return x * x; }
template <internal::num T> constexpr inline T cub(const T x) noexcept { return x * x * x; }
template <std::integral T> constexpr inline T mod(T x, const T m) noexcept {
	x %= m;
	return x < 0 ? x + m : x;
}
template <std::integral T> constexpr inline T pow(T a, T b, const T mod = 0) noexcept {
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
constexpr inline long long ceil(const long double x, const long long m) noexcept { return std::ceil(x / m); }
constexpr inline long double round(const long double x, const long long m, const short fx = 0) noexcept {
	if(fx == 0) {
		return std::round(x / m);
	}
	const unsigned long long y = pow<unsigned long long>(10, fx);
	return std::round((x * y) / m) / y;
}
constexpr inline long double log(const long long x, const long double base = 2) noexcept { return std::log2(x) / std::log2(base); }
template <internal::num T> constexpr inline bool scope(const T a, const T x, const T b) noexcept { return a <= x && x <= b; }
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
inline std::string ten_to(long long n, const int base, const bool upper = true) noexcept {
	assert(base <= 10 || base == 16);
	if(base == 16) {
		std::stringstream ss;
		ss << std::hex << n;
		const std::string s = ss.str();
		return upper ? toupper(s) : s;
	}
	if(n == 0 || base == 0) {
		return "0";
	}
	std::vector<int> ret;
	while(n > 0) {
		ret.emplace_back(n % base);
		n /= base;
	}
	std::string s;
	for(const auto &e: ret | std::views::reverse) {
		s += std::to_string(e);
	}
	return s;
}
inline long long to_ten(const std::string &s, const int base = 10) noexcept { return std::stoll(s, nullptr, base); }
template <std::integral... Ts> constexpr unsigned long long gcd(const Ts... a) noexcept {
	std::vector v = std::initializer_list<std::common_type_t<Ts...>>{a...};
	unsigned long long g = 0;
	for(const auto &el: v) {
		g = std::gcd(g, el);
	}
	return g;
}
template <std::integral... Ts> constexpr unsigned long long lcm(const Ts... a) noexcept {
	std::vector v = std::initializer_list<std::common_type_t<Ts...>>{a...};
	unsigned long long l = 1;
	for(const auto &el: v) {
		l = std::lcm(l, el);
	}
	return l;
}
template <internal::num... Ts> constexpr auto min(const Ts... a) noexcept { return std::min(std::initializer_list<std::common_type_t<Ts...>>{a...}); }
template <internal::num... Ts> constexpr auto max(const Ts... a) noexcept { return std::max(std::initializer_list<std::common_type_t<Ts...>>{a...}); }
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
template <std::integral T> constexpr inline T count(const std::vector<T> &v, const T &x) noexcept {
	return std::ranges::upper_bound(v, x) - std::ranges::lower_bound(v, x);
}
template <class T> constexpr inline T inner_prod(const std::vector<T> &v, const std::vector<T> &u, const T init) noexcept { return std::inner_product(v.cbegin(), v.cend(), u.cbegin(), init); }
inline std::vector<int> iota(const int n, const int init = 0) noexcept {
	std::vector<int> a(n);
	std::iota(a.begin(), a.end(), init);
	return a;
}
template <class T> constexpr inline int uniq(T& v) noexcept {
	std::ranges::sort(v);
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
template <std::ranges::input_range T> inline auto sum(const T &v) noexcept { return std::accumulate(v.cbegin(), v.cend(), std::ranges::range_value_t<T>{}); }
template <std::ranges::input_range T> inline auto sum(const T &v, const int a, const int b) noexcept { return std::accumulate(v.cbegin() + a, v.cbegin() + b, std::ranges::range_value_t<T>{}); }
template <std::ranges::input_range T, class Boolean = bool> inline auto sum(const T &v, const Boolean &fn) noexcept { return std::accumulate(v.cbegin(), v.cend(), std::ranges::range_value_t<T>{}, fn); }
template <std::ranges::input_range T, class Boolean = bool> inline auto sum(const T &v, const int a, const int b, const Boolean &fn) noexcept { return std::accumulate(v.cbegin() + a, v.cbegin() + b, std::ranges::range_value_t<T>{}, fn); }

template <internal::num T, class Boolean = bool> constexpr inline T bins(T ok, T ng, const Boolean &fn, const long double eps = 1) noexcept {
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
template <internal::num T> inline std::vector<std::vector<T>> rotate(const std::vector<std::vector<T>> &v) noexcept {
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
template <std::integral T> constexpr inline T factor(T n, const T mod = 0) noexcept {
	T ret = 1;
	while(n > 0) {
		ret *= n--;
		if(mod) {
			ret %= mod;
		}
	}
	return ret;
}
template <std::integral T> constexpr inline T perm(T n, const T r, const T mod = 0) noexcept {
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
template <std::integral T> constexpr inline T binom(T n, const T r, const T mod = 0) noexcept {
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
constexpr inline bool is_sqr(const long long n) noexcept { return is_int(std::sqrt(n)); }
constexpr inline bool is_prime(const unsigned long long n) noexcept {
	if(n <= 1) {
		return false;
	}
	if(n <= 3) {
		return true;
	}
	if(n % 2 ==0 || n % 3 == 0) {
		return false;
	}
	for(long long i = 5; i * i <= n; i += 6) {
		if(n % i == 0 || n % (i + 2) == 0) {
			return false;
		}
	}
	return true;
}
inline bool is_palindrome(const std::string &s) noexcept {
	auto t = s;
	std::ranges::reverse(t);
	return s == t;
}
}

#include "C++/core/timer.hpp"
#include "C++/core/myvector.hpp"
#include "C++/core/mypair.hpp"
#include "C++/core/io/input.hpp"
#include "C++/core/io/output.hpp"

#define REP(n) for([[maybe_unused]] const auto _: std::views::iota(0, (n)))

using namespace IO;
using namespace std::views;
namespace iter = std::ranges;

/**
 * @brief テンプレート
 * @docs docs/template.md
 */