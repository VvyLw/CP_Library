---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/core/alias.hpp
    title: "\u30A8\u30A4\u30EA\u30A2\u30B9"
  - icon: ':heavy_check_mark:'
    path: C++/core/io/input.hpp
    title: "\u5165\u529B"
  - icon: ':heavy_check_mark:'
    path: C++/core/io/output.hpp
    title: "\u51FA\u529B"
  - icon: ':heavy_check_mark:'
    path: C++/core/mypair.hpp
    title: C++/core/mypair.hpp
  - icon: ':heavy_check_mark:'
    path: C++/core/myvector.hpp
    title: C++/core/myvector.hpp
  - icon: ':heavy_check_mark:'
    path: C++/core/timer.hpp
    title: "\u30BF\u30A4\u30DE\u30FC"
  - icon: ':heavy_check_mark:'
    path: C++/template.hpp
    title: "\u30C6\u30F3\u30D7\u30EC\u30FC\u30C8"
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://onlinejudge.u-aizu.ac.jp/courses/library/6/NTL/1/NTL_1_E
    links:
    - https://onlinejudge.u-aizu.ac.jp/courses/library/6/NTL/1/NTL_1_E
  bundledCode: "#line 1 \"test/extgcd.test.cpp\"\n#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/library/6/NTL/1/NTL_1_E\"\
    \n/*#pragma GCC optimize(\"O3\")\n#pragma GCC optimize(\"unroll-loops\")//*/\n\
    //#pragma GCC target(\"sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native\"\
    )\n#line 2 \"C++/template.hpp\"\n#ifndef TEMPLATE\r\n#define TEMPLATE\r\n#endif\r\
    \n#pragma GCC diagnostic ignored \"-Wunused-parameter\"\r\n#pragma GCC diagnostic\
    \ ignored \"-Wsign-compare\"\r\n#pragma GCC diagnostic ignored \"-Wdeprecated-copy\"\
    \r\n#include <bits/stdc++.h>\r\nnamespace VvyLw {\r\nenum TestCase { single, multi\
    \ };\r\ninline void solve() noexcept;\r\ntemplate <TestCase tc = single, int x\
    \ = 12> constexpr inline void wa_haya_exe() noexcept {\r\n\tstd::cin.tie(nullptr)\
    \ -> sync_with_stdio(false);\r\n\tstd::cout << std::fixed << std::setprecision(x);\r\
    \n\tint t = 1;\r\n\tif constexpr (tc == multi) {\r\n\t\tstd::cin >> t;\r\n\t}\r\
    \n\tfor([[maybe_unused]] const auto _: std::views::iota(0, t)) {\r\n\t\tsolve();\r\
    \n\t}\r\n}\r\n}\r\n\r\nusing enum VvyLw::TestCase;\r\n\r\n#line 2 \"C++/core/alias.hpp\"\
    \n\n#ifndef ALIAS\n#define ALIAS\n#endif\n\n#line 8 \"C++/core/alias.hpp\"\n#include\
    \ <numbers>\n#line 10 \"C++/core/alias.hpp\"\n#include <ext/pb_ds/assoc_container.hpp>\n\
    #include <ext/pb_ds/tree_policy.hpp>\n\nnamespace internal {\ntemplate <typename\
    \ T> concept num = std::integral<T> || std::floating_point<T>;\n}\n\nconstexpr\
    \ int dx[] = {0, 0, 0, -1, 1, -1, -1, 1, 1};\nconstexpr int dy[] = {0, -1, 1,\
    \ 0, 0, -1, 1, -1, 1};\nconstexpr int MOD = 0x3b800001;\nconstexpr int M0D = 1e9\
    \ + 7;\nconstexpr int INF = 1 << 30;\nconstexpr long long LINF = (1LL << 61) -\
    \ 1;\nconstexpr long double DINF = std::numeric_limits<long double>::infinity();\n\
    template <internal::num T> constexpr T LIM = std::numeric_limits<T>::max();\n\
    constexpr long double PI = std::numbers::pi;\nconstexpr long double E = std::numbers::e;\n\
    \ntypedef long long i64;\ntypedef long double ld;\ntypedef unsigned u32;\ntypedef\
    \ unsigned long long u64;\ntypedef __int128_t i128;\ntypedef __uint128_t u128;\n\
    template <size_t N> using ti = std::array<i64, N>;\ntypedef ti<3> tri;\ntemplate\
    \ <class T> using pq = std::priority_queue<T>;\ntemplate <class T> using pqr =\
    \ std::priority_queue<T, std::vector<T>, std::greater<T>>;\ntemplate <class T>\
    \ using Tree = __gnu_pbds::tree<T, __gnu_pbds::null_type, std::less<T>, __gnu_pbds::rb_tree_tag,\
    \ __gnu_pbds::tree_order_statistics_node_update>;\ntemplate <class T> using TREE\
    \ = __gnu_pbds::tree<T, __gnu_pbds::null_type, std::greater<T>, __gnu_pbds::rb_tree_tag,\
    \ __gnu_pbds::tree_order_statistics_node_update>;\n\n/**\n * @brief \u30A8\u30A4\
    \u30EA\u30A2\u30B9\n */\n#line 28 \"C++/template.hpp\"\n\r\nnamespace man {\r\n\
    inline bool isdigit(const std::string &s) noexcept;\r\nstd::mt19937 EhaL(std::hash<std::string>()(\"\
    Huitloxopetl\"));\r\ninline std::mt19937 rand() noexcept {\r\n\tstd::random_device\
    \ seed_gen;\r\n\tstd::mt19937 engine {seed_gen()};\r\n\treturn engine;\r\n}\r\n\
    \r\ntemplate <class T, class U> constexpr inline bool chmax(T& a, const U& b)\
    \ noexcept { if(a < b){ a = b; return true; } return false; }\r\ntemplate <class\
    \ T, class U> constexpr inline bool chmin(T& a, const U& b) noexcept { if(a >\
    \ b){ a = b; return true; } return false; }\r\ntemplate <internal::num T, internal::num\
    \ U> constexpr inline bool overflow_if_add(const T a, const U b) noexcept { return\
    \ (std::numeric_limits<T>::max() - a) < b; }\r\ntemplate <internal::num T, internal::num\
    \ U> constexpr inline bool overflow_if_mul(const T a, const U b) noexcept { return\
    \ (std::numeric_limits<T>::max() / a) < b; }\r\n\r\ninline std::string string_replace(const\
    \ std::string &s, const std::string &a, const std::string &b) noexcept { return\
    \ std::regex_replace(s, std::regex(a), b); }\r\ninline bool regex_contains(const\
    \ std::string &s, const std::string &t) noexcept { return std::regex_search(s,\
    \ std::regex(t)); }\r\nconstexpr inline auto yes(const bool ok) noexcept { return\
    \ ok ? \"Yes\" : \"No\"; }\r\ntemplate <internal::num T> constexpr inline T sqr(const\
    \ T x) noexcept { return x * x; }\r\ntemplate <internal::num T> constexpr inline\
    \ T cub(const T x) noexcept { return x * x * x; }\r\ntemplate <std::integral T>\
    \ constexpr inline T mod(T x, const T m) noexcept {\r\n\tx %= m;\r\n\treturn x\
    \ < 0 ? x + m : x;\r\n}\r\ntemplate <std::integral T> constexpr inline T pow(T\
    \ a, T b, const T mod = 0) noexcept {\r\n\tT ret = 1;\r\n\tif(mod != 0) {\r\n\t\
    \tret %= mod;\r\n\t\ta %= mod;\r\n\t}\r\n\twhile(b > 0) {\r\n\t\tif(b & 1) {\r\
    \n\t\t\tret *= a;\r\n\t\t}\r\n\t\tif(mod != 0) {\r\n\t\t\tret %= mod;\r\n\t\t\
    }\r\n\t\ta *= a;\r\n\t\tif(mod) {\r\n\t\t\ta %= mod;\r\n\t\t}\r\n\t\tb >>= 1;\r\
    \n\t}\r\n\treturn ret;\r\n}\r\nconstexpr inline long long ceil(const long double\
    \ x, const long long m) noexcept { return std::ceil(x / m); }\r\nconstexpr inline\
    \ long double round(const long double x, const long long m, const short fx = 0)\
    \ noexcept {\r\n\tif(fx == 0) {\r\n\t\treturn std::round(x / m);\r\n\t}\r\n\t\
    const unsigned long long y = pow<unsigned long long>(10, fx);\r\n\treturn std::round((x\
    \ * y) / m) / y;\r\n}\r\nconstexpr inline long double log(const long long x, const\
    \ long double base = 2) noexcept { return std::log2(x) / std::log2(base); }\r\n\
    template <internal::num T> constexpr inline bool scope(const T a, const T x, const\
    \ T b) noexcept { return a <= x && x <= b; }\r\nconstexpr inline bool isupper(const\
    \ char c) noexcept { return std::isupper(c); }\r\ninline bool isupper(const std::string\
    \ &s) noexcept {\r\n\tbool ok = true;\r\n\tfor(const auto &el: s) {\r\n\t\tok\
    \ &= isupper(el);\r\n\t}\r\n\treturn ok;\r\n}\r\nconstexpr inline bool islower(const\
    \ char c) noexcept { return std::islower(c); }\r\ninline bool islower(const std::string\
    \ &s) noexcept {\r\n\tbool ok = true;\r\n\tfor(const auto &el: s) {\r\n\t\tok\
    \ &= islower(el);\r\n\t}\r\n\treturn ok;\r\n}\r\nconstexpr inline bool isalpha(const\
    \ char c) noexcept { return std::isalpha(c); }\r\ninline bool isalpha(const std::string\
    \ &s) noexcept {\r\n\tbool ok = true;\r\n\tfor(const auto &el: s) {\r\n\t\tok\
    \ &= isalpha(el);\r\n\t}\r\n\treturn ok;\r\n}\r\nconstexpr inline bool isdigit(const\
    \ char c) noexcept { return std::isdigit(c); }\r\ninline bool isdigit(const std::string\
    \ &s) noexcept {\r\n\tbool ok = true, neg = s.front() == '-';\r\n    for(const\
    \ auto &el: s) {\r\n        if(neg) {\r\n            neg = false;\r\n        \
    \    continue;\r\n        }\r\n        ok &= isdigit(el);\r\n    }\r\n    return\
    \ ok;\r\n}\r\nconstexpr inline bool isalnum(const char c) noexcept { return std::isalnum(c);\
    \ }\r\ninline bool isalnum(const std::string &s) noexcept {\r\n\tbool ok = true;\r\
    \n\tfor(const auto &el: s) {\r\n\t\tok &= isalnum(el);\r\n\t}\r\n\treturn ok;\r\
    \n}\r\nconstexpr inline bool isspace(const char c) noexcept { return std::isspace(c);\
    \ }\r\ninline bool isspace(const std::string &s) noexcept {\r\n\tbool ok = true;\r\
    \n\tfor(const auto &el: s) {\r\n\t\tok &= isspace(el);\r\n\t}\r\n\treturn ok;\r\
    \n}\r\nconstexpr inline bool ispunct(const char c) noexcept { return std::ispunct(c);\
    \ }\r\ninline bool ispunct(const std::string &s) noexcept {\r\n\tbool ok = true;\r\
    \n\tfor(const auto &el: s) {\r\n\t\tok &= ispunct(el);\r\n\t}\r\n\treturn ok;\r\
    \n}\r\nconstexpr inline bool isprint(const char c) noexcept { return std::isprint(c);\
    \ }\r\ninline bool isprint(const std::string &s) noexcept {\r\n\tbool ok = true;\r\
    \n\tfor(const auto &el: s) {\r\n\t\tok &= isprint(el);\r\n\t}\r\n\treturn ok;\r\
    \n}\r\ninline auto strins(std::string &s, const int id, const std::string &t)\
    \ noexcept {\r\n\ts.insert(id, t);\r\n\treturn std::ssize(s);\r\n}\r\ninline std::string\
    \ toupper(std::string s) noexcept {\r\n\tfor(auto &c: s) {\r\n\t\tc = std::toupper(c);\r\
    \n\t}\r\n\treturn s;\r\n}\r\ninline std::string tolower(std::string s) noexcept\
    \ {\r\n\tfor(auto &c: s) {\r\n\t\tc = std::tolower(c);\r\n\t}\r\n\treturn s;\r\
    \n}\r\ninline std::string ten_to(long long n, const int base, const bool upper\
    \ = true) noexcept {\r\n\tassert(base <= 10 || base == 16);\r\n\tif(base == 16)\
    \ {\r\n\t\tstd::stringstream ss;\r\n\t\tss << std::hex << n;\r\n\t\tconst std::string\
    \ s = ss.str();\r\n\t\treturn upper ? toupper(s) : s;\r\n\t}\r\n\tif(n == 0 ||\
    \ base == 0) {\r\n\t\treturn \"0\";\r\n\t}\r\n\tstd::vector<int> ret;\r\n\twhile(n\
    \ > 0) {\r\n\t\tret.emplace_back(n % base);\r\n\t\tn /= base;\r\n\t}\r\n\tstd::string\
    \ s;\r\n\tfor(const auto &e: ret | std::views::reverse) {\r\n\t\ts += std::to_string(e);\r\
    \n\t}\r\n\treturn s;\r\n}\r\ninline long long to_ten(const std::string &s, const\
    \ int base = 10) noexcept { return std::stoll(s, nullptr, base); }\r\ntemplate\
    \ <std::integral... Ts> constexpr unsigned long long gcd(const Ts... a) noexcept\
    \ {\r\n\tstd::vector v = std::initializer_list<std::common_type_t<Ts...>>{a...};\r\
    \n\tunsigned long long g = 0;\r\n\tfor(const auto &el: v) {\r\n\t\tg = std::gcd(g,\
    \ el);\r\n\t}\r\n\treturn g;\r\n}\r\ntemplate <std::integral... Ts> constexpr\
    \ unsigned long long lcm(const Ts... a) noexcept {\r\n\tstd::vector v = std::initializer_list<std::common_type_t<Ts...>>{a...};\r\
    \n\tunsigned long long l = 1;\r\n\tfor(const auto &el: v) {\r\n\t\tl = std::lcm(l,\
    \ el);\r\n\t}\r\n\treturn l;\r\n}\r\ntemplate <internal::num... Ts> constexpr\
    \ auto min(const Ts... a) noexcept { return std::min(std::initializer_list<std::common_type_t<Ts...>>{a...});\
    \ }\r\ntemplate <internal::num... Ts> constexpr auto max(const Ts... a) noexcept\
    \ { return std::max(std::initializer_list<std::common_type_t<Ts...>>{a...}); }\r\
    \ntemplate <class K, class V> inline std::vector<K> key_l(const std::map<K, V>\
    \ &m, const V val) noexcept {\r\n\tstd::vector<K> keys;\r\n\tfor(auto it = m.cbegin();\
    \ it != m.cend(); ++it) {\r\n\t\tif(it->second == val) {\r\n\t\t\tkeys.emplace_back(it->first);\r\
    \n\t\t}\r\n\t}\r\n\treturn keys;\r\n}\r\ntemplate <class K, class V> constexpr\
    \ inline K key_min(const std::map<K, V> &m) noexcept { return m.begin()->first;\
    \ }\r\ntemplate <class K, class V> constexpr inline K key_max(const std::map<K,\
    \ V> &m) noexcept { return m.rbegin()->first; }\r\ntemplate <class K, class V>\
    \ constexpr inline V key_min_v(const std::map<K, V> &m) noexcept { return m.begin()->second;\
    \ }\r\ntemplate <class K, class V> constexpr inline V key_max_v(const std::map<K,\
    \ V> &m) noexcept { return m.rbegin()->second; }\r\ntemplate <class K, class V>\
    \ constexpr inline auto val_min(const std::map<K, V> &m) noexcept {\r\n\treturn\
    \ *std::ranges::min_element(m, [](const std::pair<K, V> &x, const std::pair<K,\
    \ V> &y) -> bool { return x.second < y.second; });\r\n}\r\ntemplate <class K,\
    \ class V> constexpr inline auto val_max(const std::map<K, V> &m) noexcept {\r\
    \n\treturn *std::ranges::max_element(m, [](const std::pair<K, V> &x, const std::pair<K,\
    \ V> &y) -> bool { return x.second < y.second; });\r\n}\r\n\r\ntemplate <std::integral\
    \ T> constexpr inline T count(std::vector<T> v, const T &x) noexcept {\r\n\tif(!std::ranges::is_sorted(v))\
    \ {\r\n\t\tstd::ranges::sort(v);\r\n\t}\r\n\treturn std::ranges::upper_bound(v,\
    \ x) - std::ranges::lower_bound(v, x);\r\n}\r\ntemplate <class T> constexpr inline\
    \ T inner_prod(const std::vector<T> &v, const std::vector<T> &u, const T init)\
    \ noexcept { return std::inner_product(v.cbegin(), v.cend(), u.cbegin(), init);\
    \ }\r\ninline std::vector<int> iota(const int n, const int init = 0) noexcept\
    \ {\r\n\tstd::vector<int> a(n);\r\n\tstd::iota(a.begin(), a.end(), init);\r\n\t\
    return a;\r\n}\r\ntemplate <class T> constexpr inline int uniq(T& v) noexcept\
    \ {\r\n\tif(!std::ranges::is_sorted(v)) {\r\n\t\tstd::ranges::sort(v);\r\n\t}\r\
    \n\tconst auto it = std::ranges::unique(v);\r\n\tv.erase(it.begin(), it.end());\r\
    \n\treturn std::ssize(v);\r\n}\r\ntemplate <class T> constexpr inline void rotate(T&\
    \ s, const int idx) noexcept {\r\n\tconst int id = mod<int>(idx, std::ssize(s));\r\
    \n\tstd::ranges::rotate(s, s.begin() + id);\r\n}\r\ntemplate <class T> constexpr\
    \ inline T set_diff(const T& s, const T& t) noexcept {\r\n\tassert(std::ranges::is_sorted(s)\
    \ && std::ranges::is_sorted(t));\r\n\tT ret;\r\n\tstd::ranges::set_difference(s,\
    \ t, std::inserter(ret, std::end(ret)));\r\n\treturn ret;\r\n}\r\ntemplate <class\
    \ T> constexpr inline T set_sum(const T& s, const T& t) noexcept {\r\n\tassert(std::ranges::is_sorted(s)\
    \ && std::ranges::is_sorted(t));\r\n\tT ret;\r\n\tstd::ranges::set_union(s, t,\
    \ std::inserter(ret, std::end(ret)));\r\n\treturn ret;\r\n}\r\ntemplate <class\
    \ T> constexpr inline T set_mul(const T& s, const T& t) noexcept {\r\n\tassert(std::ranges::is_sorted(s)\
    \ && std::ranges::is_sorted(t));\r\n\tT ret;\r\n\tstd::ranges::set_intersection(s,\
    \ t, std::inserter(ret, std::end(ret)));\r\n\treturn ret;\r\n}\r\ntemplate <class\
    \ T> inline std::vector<T> adj_diff(const std::vector<T> &v) noexcept {\r\n\t\
    std::vector<T> a;\r\n\tstd::adjacent_difference(v.cbegin(), v.cend(), std::back_inserter(a));\r\
    \n\trotate(a, 1);\r\n\ta.pop_back();\r\n\treturn a;\r\n}\r\ntemplate <class T,\
    \ class F> inline std::vector<T> isum(const std::vector<T> &v, const F &fn) noexcept\
    \ {\r\n\tstd::vector<T> s{0};\r\n\tstd::inclusive_scan(v.cbegin(), v.cend(), std::back_inserter(s),\
    \ fn);\r\n\treturn s;\r\n}\r\ntemplate <class T> inline std::vector<T> rand_extract(const\
    \ std::vector<T> &v, const int size) noexcept {\r\n\tstd::vector<T> ret;\r\n\t\
    std::ranges::sample(v, std::back_inserter(ret), size, rand());\r\n\treturn ret;\r\
    \n}\r\ntemplate <class T> inline T rand_extract(const std::vector<T> &v) noexcept\
    \ {\r\n\tstd::vector<T> ret;\r\n\tstd::ranges::sample(v, std::back_inserter(ret),\
    \ 1, rand());\r\n\treturn ret.front();\r\n}\r\ntemplate <std::ranges::random_access_range\
    \ T> inline auto sum(const T &v) noexcept { return std::accumulate(v.cbegin(),\
    \ v.cend(), decltype(v.front())(0)); }\r\ntemplate <std::ranges::random_access_range\
    \ T> inline auto sum(const T &v, const int a, const int b) noexcept { return std::accumulate(v.cbegin()\
    \ + a, v.cbegin() + b, decltype(v.front())(0)); }\r\ntemplate <std::ranges::random_access_range\
    \ T, class Boolean = bool> inline auto sum(const T &v, const Boolean &fn) noexcept\
    \ { return std::accumulate(v.cbegin(), v.cend(), decltype(v.front())(0), fn);\
    \ }\r\ntemplate <std::ranges::random_access_range T, class Boolean = bool> inline\
    \ auto sum(const T &v, const int a, const int b, const Boolean &fn) noexcept {\
    \ return std::accumulate(v.cbegin() + a, v.cbegin() + b, decltype(v.front())(0),\
    \ fn); }\r\n\r\ntemplate <internal::num T, class Boolean = bool> constexpr inline\
    \ T bins(T ok, T ng, const Boolean &fn, const long double eps = 1) noexcept {\r\
    \n\twhile(std::abs(ok - ng) > eps) {\r\n\t\tconst T mid = (ok + ng) / 2;\r\n\t\
    \t(fn(mid) ? ok : ng) = mid;\r\n\t}\r\n\treturn ok;\r\n}\r\ninline std::vector<std::string>\
    \ rotate(const std::vector<std::string> &s) noexcept {\r\n\tconst int h = std::ssize(s),\
    \ w = std::ssize(s.front());\r\n\tstd::vector t(w, std::string(h, {}));\r\n\t\
    for(const auto i: std::views::iota(0, h)) {\r\n\t\tfor(const auto j: std::views::iota(0,\
    \ w)) {\r\n\t\t\tt[j][i] = s[i][j];\r\n\t\t}\r\n\t}\r\n\tfor(const auto i: std::views::iota(0,\
    \ w)) {\r\n\t\tstd::ranges::reverse(t[i]);\r\n\t}\r\n\treturn t;\r\n}\r\ntemplate\
    \ <internal::num T> inline std::vector<std::vector<T>> rotate(const std::vector<std::vector<T>>\
    \ &v) noexcept {\r\n\tconst int h = std::ssize(v), w = std::ssize(v.front());\r\
    \n\tstd::vector ret(w, std::vector<T>(h));\r\n\tfor(const auto i: std::views::iota(0,\
    \ h)) {\r\n\t\tfor(const auto j: std::views::iota(0, w)) {\r\n\t\t\tret[j][i]\
    \ = v[i][j];\r\n\t\t}\r\n\t}\r\n\tfor(const auto i: std::views::iota(0, w)) {\r\
    \n\t\tstd::ranges::reverse(ret[i]);\r\n\t}\r\n\treturn ret;\r\n}\r\ntemplate <std::integral\
    \ T> constexpr inline T factor(T n, const T mod = 0) noexcept {\r\n\tT ret = 1;\r\
    \n\twhile(n > 0) {\r\n\t\tret *= n--;\r\n\t\tif(mod) {\r\n\t\t\tret %= mod;\r\n\
    \t\t}\r\n\t}\r\n\treturn ret;\r\n}\r\ntemplate <std::integral T> constexpr inline\
    \ T perm(T n, const T r, const T mod = 0) noexcept {\r\n\tconst T tmp = n;\r\n\
    \tT ret = 1;\r\n\twhile(n > tmp - r) {\r\n\t\tret *= n--;\r\n\t\tif(mod) {\r\n\
    \t\t\tret %= mod;\r\n\t\t}\r\n\t}\r\n\treturn ret;\r\n}\r\ntemplate <std::integral\
    \ T> constexpr inline T binom(T n, const T r, const T mod = 0) noexcept {\r\n\t\
    if(r < 0 || n < r) {\r\n\t\treturn 0;\r\n\t}\r\n\tT ret = 1;\r\n\tfor(const auto\
    \ i: std::views::iota(1) | std::views::take(r)) {\r\n\t\tret *= n--;\r\n\t\tif(mod)\
    \ {\r\n\t\t\tret %= mod;\r\n\t\t}\r\n\t\tret /= i;\r\n\t\tif(mod) {\r\n\t\t\t\
    ret %= mod;\r\n\t\t}\r\n\t}\r\n\treturn ret;\r\n}\r\nconstexpr inline bool is_int(const\
    \ long double n) noexcept { return n == std::floor(n); }\r\nconstexpr inline bool\
    \ is_sqr(const long long n) noexcept { return is_int(std::sqrt(n)); }\r\n}\r\n\
    \r\n#line 2 \"C++/core/timer.hpp\"\n\n#line 5 \"C++/core/timer.hpp\"\ntypedef\
    \ std::chrono::system_clock::time_point Timer;\nTimer start, stop;\n#if local\n\
    inline void now(Timer &t) noexcept { t = std::chrono::system_clock::now(); }\n\
    inline void time(const Timer &t1, const Timer &t2) noexcept { std::cerr << std::chrono::duration_cast<std::chrono::milliseconds>(t2\
    \ - t1).count() << \"ms\\n\"; }\n#else\nvoid now(Timer &t){ void(0); }\nvoid time(const\
    \ Timer &t1, const Timer &t2){ void(0); }\n#endif\n\n/**\n * @brief \u30BF\u30A4\
    \u30DE\u30FC\n */\n#line 2 \"C++/core/myvector.hpp\"\n\n#line 4 \"C++/core/myvector.hpp\"\
    \n\n#ifndef ALIAS\nnamespace internal {\ntemplate <typename T> concept num = std::integral<T>\
    \ || std::floating_point<T>;\n}\n#endif\n\nnamespace man {\nnamespace vec {\n\
    template <class T> using V = std::vector<T>;\ntypedef V<long long> zhl;\ntypedef\
    \ V<unsigned long long> uzhl;\ntypedef V<long double> dec;\ntypedef V<char> chr;\n\
    typedef V<std::string> str;\ntypedef V<bool> bol;\ntypedef V<zhl> zhl2;\ntypedef\
    \ V<uzhl> uzhl2;\ntypedef V<dec> dec2;\ntypedef V<chr> chr2;\ntypedef V<str> str2;\n\
    typedef V<bol> bol2;\n#ifdef EDGE\ntypedef V<man::edge> edg;\ntypedef V<edg> edg2;\n\
    #endif\ntemplate <class T, class U> inline V<U> ndiv(T&& n, U&& v) noexcept {\n\
    \  return V<U>(std::forward<T>(n), std::forward<U>(v));\n}\ntemplate <class T,\
    \ class... Ts> inline decltype(auto) ndiv(T&& n, Ts&&... v) noexcept {\n  return\
    \ V<decltype(ndiv(std::forward<Ts>(v)...))>(std::forward<T>(n), ndiv(std::forward<Ts>(v)...));\n\
    }\ntemplate <internal::num T> constexpr V<T>& operator++(V<T>& v) noexcept { for(auto\
    \ &el: v){ el++; } return v; }\ntemplate <internal::num T> constexpr V<T>& operator--(V<T>&\
    \ v) noexcept { for(auto &el: v){ el--; } return v; }\ntemplate <internal::num\
    \ T, internal::num U> constexpr V<T>& operator+=(V<T>& v, const U x) noexcept\
    \ { for(auto &el: v){ el += x; } return v; }\ntemplate <internal::num T, internal::num\
    \ U> constexpr V<T>& operator-=(V<T>& v, const U x) noexcept { for(auto &el: v){\
    \ el -= x; } return v; }\ntemplate <internal::num T, internal::num U> constexpr\
    \ V<T>& operator*=(V<T>& v, const U x) noexcept { for(auto &el: v){ el *= x; }\
    \ return v; }\ntemplate <internal::num T, internal::num U> constexpr V<T>& operator/=(V<T>&\
    \ v, const U x) noexcept { for(auto &el: v){ el /= x; } return v; }\ntemplate\
    \ <std::integral T, std::integral U> constexpr V<T>& operator%=(V<T>& v, const\
    \ U x) noexcept { for(auto &el: v){ el %= x; } return v; }\ntemplate <internal::num\
    \ T, internal::num U> constexpr V<T> operator+(const V<T>& v, const U x) noexcept\
    \ { V<T> ret = v; ret += x; return ret; }\ntemplate <internal::num T, internal::num\
    \ U> constexpr V<T> operator-(const V<T>& v, const U x) noexcept { V<T> ret =\
    \ v; ret -= x; return ret; }\ntemplate <internal::num T, internal::num U> constexpr\
    \ V<T> operator*(const V<T>& v, const U x) noexcept { V<T> ret = v; ret *= x;\
    \ return ret; }\ntemplate <internal::num T, internal::num U> constexpr V<T> operator/(const\
    \ V<T>& v, const U x) noexcept { V<T> ret = v; ret /= x; return ret; }\ntemplate\
    \ <std::integral T, std::integral U> constexpr V<T> operator%(const V<T>& v, const\
    \ U x) noexcept { V<T> ret = v; ret %= x; return ret; }\n}\n}\n#line 2 \"C++/core/mypair.hpp\"\
    \n\n#line 8 \"C++/core/mypair.hpp\"\n\n#ifndef ALIAS\nnamespace internal {\ntemplate\
    \ <typename T> concept num = std::integral<T> || std::floating_point<T>;\n}\n\
    #endif\n\nnamespace man {\nnamespace pav {\ntemplate <class T, class U> using\
    \ P = std::pair<T, U>;\ntemplate <class T> using PP = P<T, T>;\ntypedef PP<long\
    \ long> zhl;\ntypedef PP<long double> dec;\ntypedef PP<char> chr;\ntypedef PP<std::string>\
    \ str;\ntemplate <internal::num T> constexpr PP<T> operator+(const PP<T>& a, const\
    \ PP<T>& b) noexcept { return {a.first + b.first, a.second + b.second}; }\ntemplate\
    \ <internal::num T> constexpr PP<T> operator-(const PP<T>& a, const PP<T>& b)\
    \ noexcept { return {a.first - b.first, a.second - b.second}; }\ntemplate <internal::num\
    \ T> constexpr PP<T> operator-(const PP<T>& a) noexcept { return {-a.first, -a.second};\
    \ }\ntemplate <internal::num T, class U> constexpr PP<T> operator*(const PP<T>&\
    \ a, const U& b) noexcept { return {a.first * b, a.second * b}; }\ntemplate <internal::num\
    \ T, class U> constexpr PP<T> operator/(const PP<T>& a, const U& b) noexcept {\
    \ return {a.first / b, a.second / b}; }\ntemplate <internal::num T> constexpr\
    \ PP<T>& operator+=(PP<T>& a, const PP<T>& b) noexcept { return a = a + b; }\n\
    template <internal::num T> constexpr PP<T>& operator-=(PP<T>& a, const PP<T>&\
    \ b) noexcept { return a = a - b; }\ntemplate <internal::num T, internal::num\
    \ U> constexpr PP<T>& operator*=(PP<T>& a, const U& b) noexcept { return a = a\
    \ * b; }\ntemplate <internal::num T, internal::num U> PP<T>& operator/=(PP<T>&\
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
    \ <internal::num T> constexpr inline PP<T> rotate(const PP<T>& a) noexcept { return\
    \ {-a.second, a.first}; } // 90 degree ccw\ntemplate <internal::num T> constexpr\
    \ inline dec rotate(const PP<T>& a, const int ang) noexcept {\n    assert(0 <=\
    \ ang && ang < 360);\n    const long double rad = PI * ang / 180;\n    return\
    \ {a.first * std::cos(rad) - a.second * std::sin(rad), a.first * std::sin(rad)\
    \ + a.second * std::cos(rad)};\n}\ntemplate <internal::num T> constexpr inline\
    \ T dot(const PP<T>& a, const PP<T>& b) noexcept { return a.first * b.first +\
    \ a.second * b.second; }\ntemplate <internal::num T> constexpr inline T cross(const\
    \ PP<T>& a, const PP<T>& b) noexcept { return dot(rotate(a), b); }\ntemplate <internal::num\
    \ T> constexpr inline T square(const PP<T>& a) noexcept { return dot(a, a); }\n\
    template <internal::num T> constexpr inline long double grad(const PP<T>& a) noexcept\
    \ { assert(a.first != 0); return 1.0L * a.second / a.first; }\ntemplate <internal::num\
    \ T> constexpr inline long double abs(const PP<T>& a) noexcept { return std::hypotl(a.first,\
    \ a.second); }\ntemplate <std::integral T> constexpr inline T lcm(const PP<T>&\
    \ a) noexcept { return std::lcm(a.first, a.second); }\ntemplate <std::integral\
    \ T> constexpr inline T gcd(const PP<T>& a) noexcept { return std::gcd(a.first,\
    \ a.second); }\ntemplate <std::integral T> constexpr inline PP<T> extgcd(const\
    \ PP<T> &p) noexcept {\n    T x = 1, y = 0, t1 = 0, t2 = 0, t3 = 1, a, b;\n  \
    \  std::tie(a,b) = p;\n    while(b > 0) {\n        t1 = a / b, a -= t1 * b;\n\
    \        std::swap(a, b);\n        x -= t1 * t2;\n        std::swap(x, t2);\n\
    \        y -= t1 * t3;\n        std::swap(y, t3);\n    }\n    return {x, y};\n\
    }\ntemplate <std::integral T> constexpr inline PP<T> normalize(PP<T> a) noexcept\
    \ {\n    if(a == PP<T>{}) {\n        return a;\n    }\n    a /= gcd(a);\n    if(a\
    \ < PP<T>{}) {\n        a = -a;\n    }\n    return a;\n}\ntemplate <class T, class\
    \ U> constexpr inline P<U, T> swap(const P<T, U> &p) noexcept { const P<U, T>\
    \ ret = {p.second, p.first}; return ret; }\ntemplate <class T, class U> inline\
    \ std::vector<P<U, T>> swap(const std::vector<P<T, U>> &vp) noexcept {\n    std::vector<P<U,\
    \ T>> ret;\n    for(const auto &el: vp) {\n        ret.emplace_back(swap(el));\n\
    \    }\n    return ret;\n}\ntemplate <class T, class U> inline std::vector<T>\
    \ first(const std::vector<P<T, U>> &vp) noexcept {\n    std::vector<T> ret;\n\
    \    for(const auto &el: vp) {\n        ret.emplace_back(el.first);\n    }\n \
    \   return ret;\n}\ntemplate <class T, class U> inline std::vector<U> second(const\
    \ std::vector<P<T, U>> &vp) noexcept {\n    std::vector<U> ret;\n    for(const\
    \ auto &el: vp) {\n        ret.emplace_back(el.second);\n    }\n    return ret;\n\
    }\n}\n}\n#line 2 \"C++/core/io/input.hpp\"\n\n#line 8 \"C++/core/io/input.hpp\"\
    \n#ifndef TEMPLATE\nnamespace man {\nconstexpr inline bool isdigit(const char\
    \ c) noexcept { return std::isdigit(c); }\ninline bool isdigit(const std::string\
    \ &s) noexcept {\n    bool ok = true, neg = s.front() == '-';\n    for(const auto\
    \ &el: s) {\n        if(neg) {\n            neg = false;\n            continue;\n\
    \        }\n        ok &= isdigit(el);\n    }\n    return ok;\n}\n}\n#endif\n\
    namespace IO {\ninline std::istream& operator>>(std::istream &is, __int128_t &val)\
    \ noexcept {\n    std::string s;\n    std::cin >> s;\n    assert(man::isdigit(s));\n\
    \    bool neg = s.front() == '-';\n    val = 0;\n    for(const auto &el: s) {\n\
    \        if(neg) {\n            neg = false;\n            continue;\n        }\n\
    \        val = 10 * val + el - '0';\n    }\n    if(s.front()=='-') {\n       \
    \ val = -val;\n    }\n    return is;\n}\ntemplate <class T, class U> inline std::istream&\
    \ operator>>(std::istream &is, std::pair<T, U> &p) noexcept { is >> p.first >>\
    \ p.second; return is; }\ntemplate <std::ranges::random_access_range T> requires\
    \ (!std::same_as<std::remove_cvref_t<T>, std::string> && !std::same_as<std::remove_cvref_t<T>,\
    \ std::string_view> && !std::is_array_v<std::remove_cvref_t<T>>) inline std::istream&\
    \ operator>>(std::istream &is, T &v) noexcept { for(auto &el: v){ is >> el; }\
    \ return is; }\ntemplate <class Head, class... Tail> inline bool input(Head &head,\
    \ Tail &...tail) noexcept {\n    if(!(std::cin >> head)) {\n        return false;\n\
    \    }\n    if constexpr(sizeof...(Tail) > 0) {\n        input(tail...);\n   \
    \ }\n    return true;\n}\n} // IO\n\n/**\n * @brief \u5165\u529B\n */\n#line 2\
    \ \"C++/core/io/output.hpp\"\n\n#line 6 \"C++/core/io/output.hpp\"\nnamespace\
    \ IO {\ninline std::ostream &operator<<(std::ostream &dest, const __int128_t &value)\
    \ noexcept {\n    std::ostream::sentry s(dest);\n    constexpr char dig[] = \"\
    0123456789\";\n    if(s) {\n        __uint128_t tmp = value < 0 ? -value : value;\n\
    \        char buffer[128];\n        char *d = std::end(buffer);\n        do {\n\
    \            --d;\n            *d = dig[tmp % 10];\n            tmp /= 10;\n \
    \       } while(tmp != 0);\n        if(value < 0) {\n            --d;\n      \
    \      *d = '-';\n        }\n        const int len = std::end(buffer) - d;\n \
    \       if(dest.rdbuf() -> sputn(d, len) != len) {\n            dest.setstate(std::ios_base::badbit);\n\
    \        }\n    }\n    return dest;\n}\ntemplate <class T, class U> inline std::ostream&\
    \ operator<<(std::ostream &os, const std::pair<T, U> &p) noexcept { os << p.first\
    \ << ' ' << p.second; return os; }\ntemplate <class K, class V> inline std::ostream&\
    \ operator<<(std::ostream &os, const std::map<K, V> &m) noexcept {\n    if(!m.empty())\
    \ {\n        os << m.begin()->first << ' ' << m.begin()->second;\n        for(auto\
    \ i = m.begin(); ++i != m.end();) {\n            os << '\\n' << i->first << '\
    \ ' << i->second;\n        }\n    }\n    return os;\n}\ntemplate <std::ranges::range\
    \ T> requires (!std::same_as<std::remove_cvref_t<T>, std::string> && !std::same_as<std::remove_cvref_t<T>,\
    \ std::string_view> && !std::is_array_v<std::remove_cvref_t<T>>) inline std::ostream&\
    \ operator<<(std::ostream &os, const T &v) noexcept {\n    if(!v.empty()) {\n\
    \        os << *v.cbegin();\n        for(auto i = v.cbegin(); ++i != v.cend();)\
    \ {\n            os << ' ' << *i;\n        }\n    }\n    return os;\n}\nenum Flash\
    \ { non_flush, flush };\ntemplate <Flash f = non_flush, class Head, class... Tail>\
    \ inline void print(const Head& head, const Tail& ...tail) noexcept {\n    std::cout\
    \ << head;\n    if constexpr(sizeof...(Tail) > 0) {\n        std::cout << ' ';\n\
    \        print<f>(tail...);\n    } else {\n        if constexpr(f == flush) {\n\
    \            std::cout.flush();\n        }\n    }\n}\ninline void println() noexcept\
    \ { std::cout << '\\n'; }\ntemplate <Flash f = non_flush, class Head, class...\
    \ Tail> inline void println(const Head& head, const Tail& ...tail) noexcept {\
    \ print<f>(head, tail...); std::cout << '\\n'; }\n} // IO\n\nusing enum IO::Flash;\n\
    \n#if local\n//https://gist.github.com/naskya/1e5e5cd269cfe16a76988378a60e2ca3\n\
    #include <C++/core/io/debug_print.hpp>\n#else\n#define dump(...) static_cast<void>(0)\n\
    #endif\n\n/**\n * @brief \u51FA\u529B\n */\n#line 377 \"C++/template.hpp\"\n\r\
    \n#define REP(n) for([[maybe_unused]] const auto _: std::views::iota(0, (n)))\r\
    \n\r\nusing namespace IO;\r\nusing namespace std::views;\r\nnamespace iter = std::ranges;\r\
    \n\r\n/**\r\n * @brief \u30C6\u30F3\u30D7\u30EC\u30FC\u30C8\r\n * @docs docs/template.md\r\
    \n */\n#line 6 \"test/extgcd.test.cpp\"\n\nint main() {\n    now(start);\n   \
    \ VvyLw::wa_haya_exe();\n    now(stop);\n    time(start, stop);\n}\n\n// --------------------------------------------------------------------------------------------------------------\n\
    \n\ninline void VvyLw::solve() noexcept {\n    int a, b;\n    std::cin >> a >>\
    \ b;\n    std::cout << man::pav::extgcd(std::make_pair(a,b)) << '\\n';\n}\n"
  code: "#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/library/6/NTL/1/NTL_1_E\"\
    \n/*#pragma GCC optimize(\"O3\")\n#pragma GCC optimize(\"unroll-loops\")//*/\n\
    //#pragma GCC target(\"sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native\"\
    )\n#include \"C++/template.hpp\"\n\nint main() {\n    now(start);\n    VvyLw::wa_haya_exe();\n\
    \    now(stop);\n    time(start, stop);\n}\n\n// --------------------------------------------------------------------------------------------------------------\n\
    \n\ninline void VvyLw::solve() noexcept {\n    int a, b;\n    std::cin >> a >>\
    \ b;\n    std::cout << man::pav::extgcd(std::make_pair(a,b)) << '\\n';\n}"
  dependsOn:
  - C++/template.hpp
  - C++/core/alias.hpp
  - C++/core/timer.hpp
  - C++/core/myvector.hpp
  - C++/core/mypair.hpp
  - C++/core/io/input.hpp
  - C++/core/io/output.hpp
  isVerificationFile: true
  path: test/extgcd.test.cpp
  requiredBy: []
  timestamp: '2025-06-14 01:07:36+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/extgcd.test.cpp
layout: document
redirect_from:
- /verify/test/extgcd.test.cpp
- /verify/test/extgcd.test.cpp.html
title: test/extgcd.test.cpp
---
