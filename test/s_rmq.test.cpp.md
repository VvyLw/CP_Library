---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: C++/core/alias.hpp
    title: "\u5B9A\u6570"
  - icon: ':question:'
    path: C++/core/io/input.hpp
    title: "\u5165\u529B"
  - icon: ':question:'
    path: C++/core/io/output.hpp
    title: "\u51FA\u529B"
  - icon: ':question:'
    path: C++/core/mypair.hpp
    title: C++/core/mypair.hpp
  - icon: ':question:'
    path: C++/core/myvector.hpp
    title: C++/core/myvector.hpp
  - icon: ':question:'
    path: C++/core/timer.hpp
    title: "\u30BF\u30A4\u30DE\u30FC"
  - icon: ':x:'
    path: C++/ds/SparseTable.hpp
    title: Sparse Table
  - icon: ':question:'
    path: C++/math/divisor.hpp
    title: "\u7D04\u6570\u5217\u6319"
  - icon: ':question:'
    path: C++/math/is_prime.hpp
    title: C++/math/is_prime.hpp
  - icon: ':question:'
    path: C++/math/kthrooti.hpp
    title: "k\u4E57\u6839(\u6574\u6570)"
  - icon: ':question:'
    path: C++/math/primefactor.hpp
    title: "\u7D20\u56E0\u6570\u5206\u89E3"
  - icon: ':question:'
    path: C++/math/primefactortable.hpp
    title: "\u7D20\u56E0\u6570\u5206\u89E3\u30C6\u30FC\u30D6\u30EB"
  - icon: ':question:'
    path: C++/math/primetable.hpp
    title: Sieve of Eratosthenes
  - icon: ':question:'
    path: C++/math/psum/psum.hpp
    title: "\u7D2F\u7A4D\u548C"
  - icon: ':question:'
    path: C++/other/press.hpp
    title: C++/other/press.hpp
  - icon: ':question:'
    path: C++/template.hpp
    title: "\u30C6\u30F3\u30D7\u30EC\u30FC\u30C8"
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: cpp
  _verificationStatusIcon: ':x:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://judge.yosupo.jp/problem/staticrmq
    links:
    - https://judge.yosupo.jp/problem/staticrmq
  bundledCode: "#line 1 \"test/s_rmq.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/staticrmq\"\
    \n/*#pragma GCC optimize(\"O3\")\n#pragma GCC optimize(\"unroll-loops\")//*/\n\
    //#pragma GCC target(\"sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native\"\
    )\n#line 2 \"C++/template.hpp\"\n#ifndef TEMPLATE\r\n#define TEMPLATE\r\n#endif\r\
    \n#pragma GCC diagnostic ignored \"-Wunused-parameter\"\r\n#pragma GCC diagnostic\
    \ ignored \"-Wsign-compare\"\r\n#pragma GCC diagnostic ignored \"-Wdeprecated-copy\"\
    \r\n#include <bits/stdc++.h>\r\nnamespace VvyLw {\r\ninline void wa_haya_exe()\
    \ noexcept { std::cin.tie(nullptr) -> sync_with_stdio(false); }\r\nvoid solve();\r\
    \n}\r\n\r\nnamespace man {\r\ninline bool isdigit(const std::string &s) noexcept;\r\
    \nstd::mt19937 EhaL(std::hash<std::string>()(\"Huitloxopetl\"));\r\ninline std::mt19937\
    \ rand() noexcept {\r\n\tstd::random_device seed_gen;\r\n\tconst std::mt19937\
    \ engine {seed_gen()};\r\n\treturn engine;\r\n}\r\n\r\ntemplate <class T, class\
    \ U> constexpr inline bool chmax(T& a, const U& b) noexcept { if(a < b){ a = b;\
    \ return true; } return false; }\r\ntemplate <class T, class U> constexpr inline\
    \ bool chmin(T& a, const U& b) noexcept { if(a > b){ a = b; return true; } return\
    \ false; }\r\ntemplate <class T, class U> constexpr inline bool overflow_if_add(const\
    \ T a, const U b) noexcept { return (std::numeric_limits<T>::max() - a) < b; }\r\
    \ntemplate <class T, class U> constexpr inline bool overflow_if_mul(const T a,\
    \ const U b) noexcept { return (std::numeric_limits<T>::max() / a) < b; }\r\n\
    inline void fix(const short x) noexcept { std::cout << std::fixed << std::setprecision(x);\
    \ }\r\n\r\ninline std::string string_replace(const std::string &s, const std::string\
    \ &a, const std::string &b) noexcept { return std::regex_replace(s, std::regex(a),\
    \ b); }\r\ninline bool regex_contains(const std::string &s, const std::string\
    \ &t) noexcept { return std::regex_search(s, std::regex(t)); }\r\nconstexpr inline\
    \ auto yes(const bool ok = true) noexcept { return ok ? \"Yes\" : \"No\"; }\r\n\
    template <class T> constexpr inline T sqr(const T x) noexcept { return x * x;\
    \ }\r\ntemplate <class T> constexpr inline T cub(const T x) noexcept { return\
    \ x * x * x; }\r\ntemplate <class T> constexpr inline T mod(T x, const T m) noexcept\
    \ {\r\n\tx %= m;\r\n\treturn x < 0 ? x + m : x;\r\n}\r\ntemplate <class T> constexpr\
    \ inline T pow(T a, T b, const T mod = 0) noexcept {\r\n\tT ret = 1;\r\n\tif(mod\
    \ != 0) {\r\n\t\tret %= mod;\r\n\t\ta %= mod;\r\n\t}\r\n\twhile(b > 0) {\r\n\t\
    \tif(b & 1) {\r\n\t\t\tret *= a;\r\n\t\t}\r\n\t\tif(mod != 0) {\r\n\t\t\tret %=\
    \ mod;\r\n\t\t}\r\n\t\ta *= a;\r\n\t\tif(mod) {\r\n\t\t\ta %= mod;\r\n\t\t}\r\n\
    \t\tb >>= 1;\r\n\t}\r\n\treturn ret;\r\n}\r\nconstexpr inline int64_t ceil(const\
    \ long double x, const int64_t m) noexcept { return std::ceil(x / m); }\r\nconstexpr\
    \ inline long double round(const long double x, const int64_t m, const short fx\
    \ = 0) noexcept {\r\n\tif(fx == 0) {\r\n\t\treturn std::round(x / m);\r\n\t}\r\
    \n\tconst uint64_t y = pow<uint64_t>(10, fx);\r\n\treturn std::round((x * y) /\
    \ m) / y;\r\n}\r\nconstexpr inline long double log(const int64_t x, const long\
    \ double base = 2) noexcept { return std::log2(x) / std::log2(base); }\r\nconstexpr\
    \ inline int bitdigit(const int64_t x) noexcept { return 64 - __builtin_clzll(x);\
    \ }\r\nconstexpr inline int popcnt(const int64_t x) noexcept { return __builtin_popcountll(x);\
    \ }\r\nconstexpr inline int fione(const int64_t x) noexcept { return __builtin_ffsll(x);\
    \ }\r\nconstexpr inline int zrcnt(const int64_t x) noexcept { return __builtin_ctzll(x);\
    \ }\r\ntemplate <class T = int64_t> constexpr inline bool scope(const T a, const\
    \ T x, const T b) noexcept { return a <= x && x <= b; }\r\nconstexpr inline bool\
    \ isupper(const char c) noexcept { return std::isupper(c); }\r\ninline bool isupper(const\
    \ std::string &s) noexcept {\r\n\tbool ok = true;\r\n\tfor(const auto &el: s)\
    \ {\r\n\t\tok &= isupper(el);\r\n\t}\r\n\treturn ok;\r\n}\r\nconstexpr inline\
    \ bool islower(const char c) noexcept { return std::islower(c); }\r\ninline bool\
    \ islower(const std::string &s) noexcept {\r\n\tbool ok = true;\r\n\tfor(const\
    \ auto &el: s) {\r\n\t\tok &= islower(el);\r\n\t}\r\n\treturn ok;\r\n}\r\nconstexpr\
    \ inline bool isalpha(const char c) noexcept { return std::isalpha(c); }\r\ninline\
    \ bool isalpha(const std::string &s) noexcept {\r\n\tbool ok = true;\r\n\tfor(const\
    \ auto &el: s) {\r\n\t\tok &= isalpha(el);\r\n\t}\r\n\treturn ok;\r\n}\r\nconstexpr\
    \ inline bool isdigit(const char c) noexcept { return std::isdigit(c); }\r\ninline\
    \ bool isdigit(const std::string &s) noexcept {\r\n\tbool ok = true, neg = s.front()\
    \ == '-';\r\n    for(const auto &el: s) {\r\n        if(neg) {\r\n           \
    \ neg = false;\r\n            continue;\r\n        }\r\n        ok &= isdigit(el);\r\
    \n    }\r\n    return ok;\r\n}\r\nconstexpr inline bool isalnum(const char c)\
    \ noexcept { return std::isalnum(c); }\r\ninline bool isalnum(const std::string\
    \ &s) noexcept {\r\n\tbool ok = true;\r\n\tfor(const auto &el: s) {\r\n\t\tok\
    \ &= isalnum(el);\r\n\t}\r\n\treturn ok;\r\n}\r\nconstexpr inline bool isspace(const\
    \ char c) noexcept { return std::isspace(c); }\r\ninline bool isspace(const std::string\
    \ &s) noexcept {\r\n\tbool ok = true;\r\n\tfor(const auto &el: s) {\r\n\t\tok\
    \ &= isspace(el);\r\n\t}\r\n\treturn ok;\r\n}\r\nconstexpr inline bool ispunct(const\
    \ char c) noexcept { return std::ispunct(c); }\r\ninline bool ispunct(const std::string\
    \ &s) noexcept {\r\n\tbool ok = true;\r\n\tfor(const auto &el: s) {\r\n\t\tok\
    \ &= ispunct(el);\r\n\t}\r\n\treturn ok;\r\n}\r\nconstexpr inline bool isprint(const\
    \ char c) noexcept { return std::isprint(c); }\r\ninline bool isprint(const std::string\
    \ &s) noexcept {\r\n\tbool ok = true;\r\n\tfor(const auto &el: s) {\r\n\t\tok\
    \ &= isprint(el);\r\n\t}\r\n\treturn ok;\r\n}\r\ninline auto strins(std::string\
    \ &s, const int id, const std::string &t) noexcept {\r\n\ts.insert(id, t);\r\n\
    \treturn std::ssize(s);\r\n}\r\ninline std::string toupper(std::string s) noexcept\
    \ {\r\n\tfor(auto &c: s) {\r\n\t\tc = std::toupper(c);\r\n\t}\r\n\treturn s;\r\
    \n}\r\ninline std::string tolower(std::string s) noexcept {\r\n\tfor(auto &c:\
    \ s) {\r\n\t\tc = std::tolower(c);\r\n\t}\r\n\treturn s;\r\n}\r\ninline std::vector<int>\
    \ ten_to_adic(int64_t n, const short base) noexcept {\r\n\tif(n == 0) {\r\n\t\t\
    return {0};\r\n\t}\r\n\tstd::vector<int> ret;\r\n\twhile(n > 0) {\r\n\t\tret.emplace_back(n\
    \ % base);\r\n\t\tn /= base;\r\n\t}\r\n\treturn ret;\r\n}\r\ninline int64_t adic_to_ten(const\
    \ std::vector<int> &v, const short base) {\r\n\tint64_t ret = 0;\r\n\tfor(const\
    \ auto &el: v) {\r\n\t\tret += pow<int64_t>(base, size_t(&el - &v[0])) * el;\r\
    \n\t}\r\n\treturn ret;\r\n}\r\ninline std::string to_hex(const int64_t x, const\
    \ bool upper = false) noexcept {\r\n\tstd::stringstream ss;\r\n\tss << std::hex\
    \ << x;\r\n\tconst std::string s = ss.str();\r\n\treturn upper ? toupper(s) :\
    \ s;\r\n}\r\ninline std::string to_oct(const int64_t x) noexcept {\r\n\tstd::stringstream\
    \ s;\r\n\ts << std::oct << x;\r\n\treturn s.str();\r\n}\r\ninline std::string\
    \ to_bin(const int64_t x) noexcept {\r\n\tstd::stringstream ss;\r\n\tss << std::bitset<64>(x);\r\
    \n\tstd::string s = ss.str();\r\n\tstd::ranges::reverse(s);\r\n\ts.resize(std::ssize(ten_to_adic(x,\
    \ 2)));\r\n\tstd::ranges::reverse(s);\r\n\treturn s;\r\n}\r\ninline int64_t to_ten(const\
    \ std::string &s, const short base) noexcept { return std::stoll(s, nullptr, base);\
    \ }\r\ntemplate <class... Ts> constexpr uint64_t sygcd(const Ts... a) noexcept\
    \ {\r\n\tstd::vector v = std::initializer_list<std::common_type_t<Ts...>>{a...};\r\
    \n\tuint64_t g = 0;\r\n\tfor(const auto &el: v) {\r\n\t\tg = std::gcd(g, el);\r\
    \n\t}\r\n\treturn g;\r\n}\r\ntemplate <class... Ts> constexpr uint64_t sylcm(const\
    \ Ts... a) noexcept {\r\n\tstd::vector v = std::initializer_list<std::common_type_t<Ts...>>{a...};\r\
    \n\tuint64_t l = 1;\r\n\tfor(const auto &el: v) {\r\n\t\tl = std::lcm(l, el);\r\
    \n\t}\r\n\treturn l;\r\n}\r\ntemplate <class... Ts> constexpr auto symin(const\
    \ Ts... a) noexcept { return std::min(std::initializer_list<std::common_type_t<Ts...>>{a...});\
    \ }\r\ntemplate <class... Ts> constexpr auto symax(const Ts... a) noexcept { return\
    \ std::max(std::initializer_list<std::common_type_t<Ts...>>{a...}); }\r\ntemplate\
    \ <class K, class V> inline std::vector<K> key_l(const std::map<K, V> &m, const\
    \ V val) noexcept {\r\n\tstd::vector<K> keys;\r\n\tfor(auto it = m.cbegin(); it\
    \ != m.cend(); ++it) {\r\n\t\tif(it->second == val) {\r\n\t\t\tkeys.emplace_back(it->first);\r\
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
    \ V> &y) -> bool { return x.second < y.second; });\r\n}\r\n\r\ntemplate <class\
    \ T> constexpr inline T min(const std::vector<T>& v) noexcept { return *std::ranges::min_element(v);\
    \ }\r\ntemplate <class T> constexpr inline T min(const std::vector<T>& v, const\
    \ int a, const int b) noexcept { return *std::min_element(v.cbegin() + a, v.cbegin()\
    \ + b + 1); }\r\ntemplate <class T> constexpr inline T max(const std::vector<T>&\
    \ v) noexcept { return *std::ranges::max_element(v); }\r\ntemplate <class T> constexpr\
    \ inline T max(const std::vector<T>& v, const int a, const int b) noexcept { return\
    \ *std::max_element(v.cbegin() + a, v.cbegin() + b + 1); }\r\ntemplate <class\
    \ T> constexpr inline int min_id(const std::vector<T>& v) noexcept { return std::ranges::min_element(v)\
    \ - v.cbegin(); }\r\ntemplate <class T> constexpr inline int max_id(const std::vector<T>&\
    \ v) noexcept { return std::ranges::max_element(v) - v.cbegin(); }\r\n\r\ntemplate\
    \ <class T> constexpr inline T count(std::vector<T> v, const T &x) noexcept {\r\
    \n\tif(!std::ranges::is_sorted(v)) {\r\n\t\tstd::ranges::sort(v);\r\n\t}\r\n\t\
    return std::ranges::upper_bound(v, x) - std::ranges::lower_bound(v, x);\r\n}\r\
    \ntemplate <class T> constexpr inline T inner_prod(const std::vector<T> &v, const\
    \ std::vector<T> &u, const T init) noexcept { return std::inner_product(v.cbegin(),\
    \ v.cend(), u.cbegin(), init); }\r\ninline std::vector<int> iota(const int n,\
    \ const int init = 0) noexcept {\r\n\tstd::vector<int> a(n);\r\n\tstd::iota(a.begin(),\
    \ a.end(), init);\r\n\treturn a;\r\n}\r\ntemplate <class T> constexpr inline int\
    \ uniq(T& v) noexcept {\r\n\tif(!std::ranges::is_sorted(v)) {\r\n\t\tstd::ranges::sort(v);\r\
    \n\t}\r\n\tconst auto it = std::ranges::unique(v);\r\n\tv.erase(it.begin(), it.end());\r\
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
    \ fn);\r\n\treturn s;\r\n}\r\ntemplate <class T> inline auto rand_extract(const\
    \ std::vector<T> &v, const int size = 1) noexcept {\r\n\tstd::vector<T> ret;\r\
    \n\tstd::ranges::sample(v, std::back_inserter(ret), size, rand());\r\n\treturn\
    \ std::ssize(ret) == 1 ? ret.front() : ret;\r\n}\r\ntemplate <class T = int64_t>\
    \ constexpr inline T sum(const std::vector<T> &v) noexcept { return std::accumulate(v.cbegin(),\
    \ v.cend(), T(0)); }\r\ntemplate <class T = int64_t> constexpr inline T sum(const\
    \ std::vector<T> &v, const int a, const int b) noexcept { return std::accumulate(v.cbegin()\
    \ + a, v.cbegin() + b, T(0)); }\r\n\r\ntemplate <class T, class Boolean = bool>\
    \ constexpr inline T bins(T ok, T ng, const Boolean &fn, const long double eps\
    \ = 1) noexcept {\r\n\twhile(std::abs(ok - ng) > eps) {\r\n\t\tconst T mid = (ok\
    \ + ng) / 2;\r\n\t\t(fn(mid) ? ok : ng) = mid;\r\n\t}\r\n\treturn ok;\r\n}\r\n\
    inline std::vector<std::string> rotate(const std::vector<std::string> &s) noexcept\
    \ {\r\n\tconst int h = std::ssize(s), w = std::ssize(s.front());\r\n\tstd::vector\
    \ t(w, std::string(h, {}));\r\n\tfor(const auto i: std::views::iota(0, h)) {\r\
    \n\t\tfor(const auto j: std::views::iota(0, w)) {\r\n\t\t\tt[j][i] = s[i][j];\r\
    \n\t\t}\r\n\t}\r\n\tfor(const auto i: std::views::iota(0, w)) {\r\n\t\tstd::ranges::reverse(t[i]);\r\
    \n\t}\r\n\treturn t;\r\n}\r\ntemplate <class T> inline std::vector<std::vector<T>>\
    \ rotate(const std::vector<std::vector<T>> &v) noexcept {\r\n\tconst int h = std::ssize(v),\
    \ w = std::ssize(v.front());\r\n\tstd::vector ret(w, std::vector<T>(h));\r\n\t\
    for(const auto i: std::views::iota(0, h)) {\r\n\t\tfor(const auto j: std::views::iota(0,\
    \ w)) {\r\n\t\t\tret[j][i] = v[i][j];\r\n\t\t}\r\n\t}\r\n\tfor(const auto i: std::views::iota(0,\
    \ w)) {\r\n\t\tstd::ranges::reverse(ret[i]);\r\n\t}\r\n\treturn ret;\r\n}\r\n\
    template <class T> constexpr inline T factor(T n, const T mod = 0) noexcept {\r\
    \n\tT ret = 1;\r\n\twhile(n > 0) {\r\n\t\tret *= n--;\r\n\t\tif(mod) {\r\n\t\t\
    \tret %= mod;\r\n\t\t}\r\n\t}\r\n\treturn ret;\r\n}\r\ntemplate <class T = int64_t>\
    \ constexpr inline T perm(T n, const T r, const T mod = 0) noexcept {\r\n\tconst\
    \ T tmp = n;\r\n\tT ret = 1;\r\n\twhile(n > tmp - r) {\r\n\t\tret *= n--;\r\n\t\
    \tif(mod) {\r\n\t\t\tret %= mod;\r\n\t\t}\r\n\t}\r\n\treturn ret;\r\n}\r\ntemplate\
    \ <class T = int64_t> constexpr inline T binom(T n, const T r, const T mod = 0)\
    \ noexcept {\r\n\tif(r < 0 || n < r) {\r\n\t\treturn 0;\r\n\t}\r\n\tT ret = 1;\r\
    \n\tfor(const auto i: std::views::iota(1) | std::views::take(r)) {\r\n\t\tret\
    \ *= n--;\r\n\t\tif(mod) {\r\n\t\t\tret %= mod;\r\n\t\t}\r\n\t\tret /= i;\r\n\t\
    \tif(mod) {\r\n\t\t\tret %= mod;\r\n\t\t}\r\n\t}\r\n\treturn ret;\r\n}\r\nconstexpr\
    \ inline bool is_int(const long double n) noexcept { return n == std::floor(n);\
    \ }\r\nconstexpr inline bool is_sqr(const int64_t n) noexcept { return is_int(std::sqrt(n));\
    \ }\r\n}\r\n\r\n#line 3 \"C++/other/press.hpp\"\n\nnamespace man {\ntemplate <class\
    \ T> inline std::vector<T> press(const std::vector<T> &v) noexcept {\n\tstd::vector<T>\
    \ ret, cp = v;\n\tuniq(cp);\n\tfor(const auto &el: v) {\n\t\tret.emplace_back(std::ranges::lower_bound(cp,\
    \ el) - cp.cbegin());\n\t}\n\treturn ret;\n}\ntemplate <class T> inline std::vector<T>\
    \ press(std::vector<T> &c1, std::vector<T> &c2) {\n\tstd::vector<T> ret;\n\tconst\
    \ int n = c1.size();\n\tfor(const auto i: std::views::iota(0, n)) {\n\t\tfor(const\
    \ auto d: std::views::iota(0, 1)) {\n\t\t\tT tc1 = c1[i] + d;\n\t\t\tT tc2 = c2[i]\
    \ + d;\n\t\t\tret.emplace_back(tc1);\n\t\t\tret.emplace_back(tc2);\n\t\t}\n\t\
    }\n\tuniq(ret);\n\tfor(const auto i: std::views::iota(0, n)) {\n\t\tc1[i] = std::ranges::lower_bound(ret,\
    \ c1[i]) - ret.cbegin();\n\t\tc2[i] = std::ranges::lower_bound(ret, c2[i]) - ret.cbegin();\n\
    \t}\n\treturn ret;\n}\n}\n#line 3 \"C++/math/is_prime.hpp\"\n\nnamespace man {\n\
    constexpr inline bool is_prime(const uint64_t n) noexcept {\n\tif(n <= 1) {\n\t\
    \treturn false;\n\t}\n\tif(n <= 3) {\n\t\treturn true;\n\t}\n\tif(n % 2 ==0 ||\
    \ n % 3 == 0) {\n\t\treturn false;\n\t}\n\tfor(int64_t i = 5; i * i <= n; i +=\
    \ 6) {\n\t\tif(n % i == 0 || n % (i + 2) == 0) {\n\t\t\treturn false;\n\t\t}\n\
    \t}\n\treturn true;\n}\n}\n#line 2 \"C++/math/divisor.hpp\"\n\n#line 5 \"C++/math/divisor.hpp\"\
    \nnamespace man {\ntemplate <class T> inline std::vector<T> div(const T n) noexcept\
    \ {\n    std::vector<T> d;\n    for(int64_t i = 1; i * i <= n; ++i) {\n      \
    \  if(n % i == 0) {\n            d.emplace_back(i);\n            if(i * i != n)\
    \ {\n                d.emplace_back(n / i);\n            }\n        }\n    }\n\
    \    std::ranges::sort(d);\n    return d;\n}\n}\n\n/**\n * @brief \u7D04\u6570\
    \u5217\u6319\n */\n#line 2 \"C++/math/primefactor.hpp\"\n\n#line 5 \"C++/math/primefactor.hpp\"\
    \nnamespace man {\ntemplate <class T> inline std::vector<std::pair<T, int>> prmfct(T\
    \ n) noexcept {\n    std::vector<std::pair<T, int>> ret;\n    for(int64_t i =\
    \ 2; i * i <= n; ++i) {\n        if(n % i != 0) {\n            continue;\n   \
    \     }\n        int tmp = 0;\n        while(n % i == 0) {\n            tmp++;\n\
    \            n /= i;\n        }\n        ret.emplace_back(i, tmp);\n    }\n  \
    \  if(n != 1) {\n        ret.emplace_back(n, 1);\n    }\n    return ret;\n}\n\
    }\n\n/**\n * @brief \u7D20\u56E0\u6570\u5206\u89E3\n */\n#line 2 \"C++/math/primetable.hpp\"\
    \n\n#line 4 \"C++/math/primetable.hpp\"\n#include <ranges>\nnamespace man {\n\
    struct p_table {\n    std::vector<int> SoE;\n    p_table(const int n): SoE(n +\
    \ 1, 1) {\n        SoE[0] = SoE[1] = 0;\n        for(const int64_t i: std::views::iota(2,\
    \ n + 1)) {\n            if(!SoE[i]) {\n                continue;\n          \
    \  }\n            for(int64_t j = i * i; j <= n; j += i) {\n                SoE[j]\
    \ = 0;\n            }\n        }\n    }\n    std::vector<int> get() {\n      \
    \  std::vector<int> p;\n        for(const auto i: std::views::iota(2, std::ssize(SoE)))\
    \ {\n            if(SoE[i]) {\n                p.emplace_back(i);\n          \
    \  }\n        }\n        return p;\n    }\n};\n}\n\n/**\n * @brief Sieve of Eratosthenes\n\
    \ */\n#line 2 \"C++/math/primefactortable.hpp\"\n\n#line 6 \"C++/math/primefactortable.hpp\"\
    \nnamespace man {\nstruct p_fact {\n    std::vector<int64_t> spf;\n    p_fact(const\
    \ int n): spf(n + 1){\n        std::iota(spf.begin(), spf.end(), 0);\n       \
    \ for(int64_t i = 2; i * i <= n; ++i) {\n            if(spf[i] == i) {\n     \
    \           for(int64_t j = i * i; j <= n; j += i) {\n                    if(spf[j]\
    \ == j) {\n                        spf[j] = i;\n                    }\n      \
    \          }\n            }\n        }\n    }\n    inline std::map<int, int> get(int\
    \ n) noexcept {\n        std::map<int, int> m;\n        while(n != 1) {\n    \
    \        m[spf[n]]++;\n            n /= spf[n];\n        }\n        return m;\n\
    \    }\n};\n}\n\n/**\n * @brief \u7D20\u56E0\u6570\u5206\u89E3\u30C6\u30FC\u30D6\
    \u30EB\n */\n#line 2 \"C++/math/psum/psum.hpp\"\n\n#line 5 \"C++/math/psum/psum.hpp\"\
    \nnamespace man {\ntemplate <class T = int64_t> struct psum {\nprivate:\n    int\
    \ n;\n    bool not_built;\n    std::vector<int64_t> s;\npublic:\n    psum(const\
    \ std::vector<T> &v): s{0} { std::partial_sum(v.cbegin(), v.cend(), std::back_inserter(s));\
    \ }\n    psum(const int n): n(n), not_built(true), s(n + 1){}\n    constexpr inline\
    \ std::vector<int64_t> get() const noexcept { return s; }\n    // [l, r]\n   \
    \ constexpr inline int64_t sum(const int l, const int r) const noexcept  { return\
    \ s[r] - s[l]; }\n    constexpr inline void add(const int l, const int r, const\
    \ int64_t x = 1) noexcept {\n        static_assert(not_built);\n        s[l] +=\
    \ x;\n        s[r] -= x;\n    }\n    constexpr inline std::vector<int64_t> build()\
    \ noexcept {\n        static_assert(not_built);\n        std::vector<int64_t>\
    \ res;\n        std::partial_sum(s.cbegin(), s.cend(), std::back_inserter(res));\n\
    \        not_built = false;\n        res.resize(n);\n        return res;\n   \
    \ }\n};\n}\n\n/**\n * @brief \u7D2F\u7A4D\u548C\n */\n#line 2 \"C++/math/kthrooti.hpp\"\
    \n\n#line 5 \"C++/math/kthrooti.hpp\"\n#ifndef TEMPLATE\nnamespace man {\ntemplate\
    \ <class T, class U> constexpr inline bool overflow_if_mul(const T a, const U\
    \ b) noexcept { return (std::numeric_limits<T>::max()/a)<b; }\n}\n#endif\nnamespace\
    \ man {\ninline uint64_t kthrooti(const uint64_t n, const int k) {\n    if(k ==\
    \ 1) {\n\t\treturn n;\n\t}\n\tconst auto chk = [&](const unsigned x) -> bool {\n\
    \t\tuint64_t mul = 1;\n\t\tfor([[maybe_unused]] const auto _: std::views::iota(0,\
    \ k)) {\n            if(man::overflow_if_mul(mul, x)) {\n                return\
    \ false;\n            }\n            mul *= x;\n        }\n\t\treturn mul <= n;\n\
    \t};\n\tuint64_t ret = 0;\n\tfor(const auto i: std::views::iota(0, 32) | std::views::reverse)\
    \ {\n\t\tif(chk(ret | (1U << i))) {\n\t\t\tret |= 1U << i;\n\t\t}\n\t}\n\treturn\
    \ ret;\n}\n}\n\n/**\n * @brief k\u4E57\u6839(\u6574\u6570)\n */\n#line 386 \"\
    C++/template.hpp\"\n\r\n#line 2 \"C++/core/timer.hpp\"\n\n#line 5 \"C++/core/timer.hpp\"\
    \nusing Timer = std::chrono::system_clock::time_point;\nTimer start, stop;\n#if\
    \ local\ninline void now(Timer &t) noexcept { t = std::chrono::system_clock::now();\
    \ }\ninline void time(const Timer &t1, const Timer &t2) noexcept { std::cerr <<\
    \ std::chrono::duration_cast<std::chrono::milliseconds>(t2 - t1).count() << \"\
    ms\\n\"; }\n#else\nvoid now(Timer &t){ void(0); }\nvoid time(const Timer &t1,\
    \ const Timer &t2){ void(0); }\n#endif\n\n/**\n * @brief \u30BF\u30A4\u30DE\u30FC\
    \n */\n#line 2 \"C++/core/mypair.hpp\"\n\n#line 2 \"C++/core/alias.hpp\"\n\n#ifndef\
    \ ALIAS\n#define ALIAS\n#endif\n\n#line 8 \"C++/core/alias.hpp\"\n#include <numbers>\n\
    #line 10 \"C++/core/alias.hpp\"\n#include <ext/pb_ds/assoc_container.hpp>\n#include\
    \ <ext/pb_ds/tree_policy.hpp>\n\nconstexpr int dx[] = {0, 0, 0, -1, 1, -1, -1,\
    \ 1, 1};\nconstexpr int dy[] = {0, -1, 1, 0, 0, -1, 1, -1, 1};\nconstexpr int\
    \ MOD = 0x3b800001;\nconstexpr int M0D = 1e9 + 7;\nconstexpr int INF = 1 << 30;\n\
    constexpr int64_t LINF = (1LL << 61) - 1;\nconstexpr long double DINF = std::numeric_limits<long\
    \ double>::infinity();\ntemplate <class T> constexpr T LIM = std::numeric_limits<T>::max();\n\
    constexpr long double PI = std::numbers::pi;\nconstexpr long double E = std::numbers::e;\n\
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
    /**\n * @brief \u5B9A\u6570\n */\n#line 2 \"C++/core/myvector.hpp\"\n\n#line 4\
    \ \"C++/core/myvector.hpp\"\n\nnamespace man {\nnamespace vec {\ntemplate <class\
    \ T> using V = std::vector<T>;\ntypedef V<int64_t> vi;\ntypedef V<uint64_t> vu;\n\
    typedef V<long double> vd;\ntypedef V<char> vc;\ntypedef V<std::string> vs;\n\
    typedef V<bool> vb;\ntypedef V<vi> wi;\ntypedef V<vu> wu;\ntypedef V<vd> wd;\n\
    typedef V<vc> wc;\ntypedef V<vs> ws;\ntypedef V<vb> wb;\n#ifdef EDGE\ntypedef\
    \ V<man::edge> ve;\ntypedef V<ve> we;\n#endif\ntemplate <class T, class U> inline\
    \ V<U> ndiv(T&& n, U&& v) noexcept {\n  return V<U>(std::forward<T>(n), std::forward<U>(v));\n\
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
    \ const U x) noexcept { V<T> res = v; res%=x; return res; }\n}\n}\n#line 10 \"\
    C++/core/mypair.hpp\"\nnamespace man {\nnamespace pav {\ntemplate <class T, class\
    \ U> using P = std::pair<T, U>;\ntemplate <class T> using PP = P<T, T>;\ntypedef\
    \ PP<int64_t> pi;\ntypedef PP<long double> pd;\ntypedef PP<char> pc;\ntypedef\
    \ PP<std::string> ps;\ntemplate <class T> constexpr PP<T> operator+(const PP<T>&\
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
    \    }\n    return ret;\n}\n}\n}\n#line 2 \"C++/core/io/input.hpp\"\n\n#line 8\
    \ \"C++/core/io/input.hpp\"\n#ifndef TEMPLATE\nnamespace man {\nconstexpr inline\
    \ bool isdigit(const char c) noexcept { return std::isdigit(c); }\ninline bool\
    \ isdigit(const std::string &s) noexcept {\n    bool ok = true, neg = s.front()\
    \ == '-';\n    for(const auto &el: s) {\n        if(neg) {\n            neg =\
    \ false;\n            continue;\n        }\n        ok &= isdigit(el);\n    }\n\
    \    return ok;\n}\n}\n#endif\nnamespace IO {\ninline std::istream& operator>>(std::istream\
    \ &is, __int128_t &val) noexcept {\n    std::string s;\n    std::cin >> s;\n \
    \   assert(man::isdigit(s));\n    bool neg = s.front() == '-';\n    val = 0;\n\
    \    for(const auto &el: s) {\n        if(neg) {\n            neg = false;\n \
    \           continue;\n        }\n        val = 10 * val + el - '0';\n    }\n\
    \    if(s.front()=='-') {\n        val = -val;\n    }\n    return is;\n}\ntemplate\
    \ <class T, class U> inline std::istream& operator>>(std::istream &is, std::pair<T,\
    \ U> &p) noexcept { is >> p.first >> p.second; return is; }\ntemplate <class T,\
    \ size_t N> inline std::istream& operator>>(std::istream &is, std::array<T, N>\
    \ &a) noexcept { for(auto &el: a){ is >> el; } return is; }\ntemplate <class T>\
    \ inline std::istream& operator>>(std::istream &is, std::vector<T> &v) noexcept\
    \ { for(auto &el: v){ is >> el; } return is; }\ntemplate <class T> inline std::istream&\
    \ operator>>(std::istream &is, std::deque<T> &dq) noexcept { for(auto &el: dq){\
    \ is >> el; } return is; }\n} // IO\n\n/**\n * @brief \u5165\u529B\n */\n#line\
    \ 2 \"C++/core/io/output.hpp\"\n\n#line 9 \"C++/core/io/output.hpp\"\nnamespace\
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
    \ << ' ' << p.second; return os; }\ntemplate <class T, size_t N> inline std::ostream&\
    \ operator<<(std::ostream &os, const std::array<T, N> &a) noexcept {\n    if(!a.empty())\
    \ {\n        os << a.front();\n        for(auto i = a.begin(); ++i != a.end();)\
    \ {\n            os << ' ' << *i;\n        }\n    }\n    return os;\n}\ntemplate\
    \ <class T> inline std::ostream& operator<<(std::ostream &os, const std::vector<T>\
    \ &v) noexcept {\n    if(!v.empty()) {\n        os << v.front();\n        for(auto\
    \ i = v.begin(); ++i != v.end();) {\n            os << ' ' << *i;\n        }\n\
    \    }\n    return os;\n}\ntemplate <class K, class V> inline std::ostream& operator<<(std::ostream\
    \ &os, const std::map<K, V> &m) noexcept {\n    if(!m.empty()) {\n        os <<\
    \ m.begin()->first << ' ' << m.begin()->second;\n        for(auto i = m.begin();\
    \ ++i != m.end();) {\n            os << '\\n' << i->first << ' ' << i->second;\n\
    \        }\n    }\n    return os;\n}\ntemplate <class T> inline std::ostream&\
    \ operator<<(std::ostream &os, const std::set<T> &st) noexcept {\n    if(st.size())\
    \ {\n        os << *st.begin();\n        for(auto i = st.begin(); ++i != st.end();)\
    \ {\n            os << ' ' << *i;\n        }\n    }\n    return os;\n}\ntemplate\
    \ <class T> inline std::ostream& operator<<(std::ostream &os, const std::multiset<T>\
    \ &ms) noexcept {\n    if(!ms.empty()) {\n        os << *ms.begin();\n       \
    \ for(auto i = ms.begin(); ++i != ms.end();) {\n            os << ' ' << *i;\n\
    \        }\n    }\n    return os;\n}\ntemplate <class T> inline std::ostream&\
    \ operator<<(std::ostream &os, const std::deque<T> &dq) noexcept {\n    if(!dq.empty())\
    \ {\n        os << dq.front();\n        for(auto i = dq.begin(); ++i != dq.end();)\
    \ {\n            os << ' ' << *i;\n        }\n    }\n    return os;\n}\n} // IO\n\
    \n#if local\n//https://gist.github.com/naskya/1e5e5cd269cfe16a76988378a60e2ca3\n\
    #include <C++/core/io/debug_print.hpp>\n#else\n#define dump(...) static_cast<void>(0)\n\
    #endif\n\n/**\n * @brief \u51FA\u529B\n */\n#line 391 \"C++/template.hpp\"\n\r\
    \n#define overload4(_1,_2,_3,_4,name,...) name\r\n#define REP1(n) for([[maybe_unused]]\
    \ const auto _: std::views::iota(0, (n)))\r\n#define REP2(i,n) for(const auto\
    \ i: std::views::iota(0, (n)))\r\n#define REP3(i,a,b) for(const auto i: std::views::iota((a),\
    \ (b) + 1))\r\n#define REP4(i,a,b,c) for(i64 i = (a); i <= (b); i += (c))\r\n\
    #define REP(...) overload4(__VA_ARGS__, REP4, REP3, REP2, REP1)(__VA_ARGS__)\r\
    \n\r\nusing namespace IO;\r\nusing namespace std::views;\r\nnamespace iter = std::ranges;\r\
    \n\r\n/**\r\n * @brief \u30C6\u30F3\u30D7\u30EC\u30FC\u30C8\r\n * @docs docs/template.md\r\
    \n */\n#line 2 \"C++/ds/SparseTable.hpp\"\n\r\n#line 5 \"C++/ds/SparseTable.hpp\"\
    \nnamespace man {\r\ntemplate <class T> struct SparseTable {\r\nprivate:\r\n \
    \   using F = std::function<T(T,T)>;\r\n    std::vector<std::vector<T>> st;\r\n\
    \    std::vector<T> lookup;\r\n    F f;\r\npublic:\r\n    SparseTable(const std::vector<T>\
    \ &v, const F &f_) : f(f_) {\r\n        int b = 0;\r\n        while((1 << b) <=\
    \ std::ssize(v)) {\r\n            ++b;\r\n        }\r\n        st.assign(b, std::vector<T>(1\
    \ << b));\r\n        for(const auto i: std::views::iota(0, std::ssize(v))) {\r\
    \n            st[0][i] = v[i];\r\n        }\r\n        for(const auto i: std::views::iota(1,\
    \ b)) {\r\n            for(int j = 0; j + (1 << i) <= (1 << b); j++) {\r\n   \
    \             st[i][j] = f(st[i - 1][j], st[i - 1][j + (1 << (i - 1))]);\r\n \
    \           }\r\n        }\r\n        lookup.resize(std::ssize(v) + 1);\r\n  \
    \      for(const auto i: std::views::iota(2, std::ssize(lookup))) {\r\n      \
    \      lookup[i] = lookup[i >> 1] + 1;\r\n        }\r\n    }\r\n    constexpr\
    \ inline T query(const T l, const T r) noexcept {\r\n        const int b = lookup[r\
    \ - l];\r\n        return f(st[b][l], st[b][r - (1 << b)]);\r\n    }\r\n    template\
    \ <class Boolean = bool> constexpr inline int min_left(const int x, const Boolean\
    \ &fn) noexcept {\r\n        if(x == 0) {\r\n            return 0;\r\n       \
    \ }\r\n        int ok = x, ng = -1;\r\n        while(std::abs(ok - ng) > 1) {\r\
    \n            const int mid = (ok + ng) / 2;\r\n            (fn(query(mid, x)\
    \ - 1) ? ok : ng) = mid;\r\n        }\r\n        return ok;\r\n    }\r\n    template\
    \ <class Boolean = bool> constexpr inline int max_right(const int x, const Boolean\
    \ &fn) noexcept {\r\n        if(x == std::ssize(lookup) - 1) {\r\n           \
    \ return std::ssize(lookup) - 1;\r\n        }\r\n        int ok = x, ng = std::ssize(lookup);\r\
    \n        while(std::abs(ok - ng) > 1) {\r\n            const int mid = (ok +\
    \ ng) / 2;\r\n            (fn(query(x, mid)) ? ok : ng) = mid;\r\n        }\r\n\
    \        return ok;\r\n    }\r\n};\r\n}\r\n/**\r\n * @brief Sparse Table\r\n *\
    \ @see https://ei1333.github.io/luzhiled/snippets/structure/sparse-table.html\r\
    \n */\n#line 7 \"test/s_rmq.test.cpp\"\nint main() {\n  \tVvyLw::wa_haya_exe();\n\
    \  \tnow(start);\n  \t//INT(t); while(t--)\n  \tVvyLw::solve();\n  \tnow(stop);\n\
    \  \ttime(start, stop);\n}\n\n// --------------------------------------------------------------------------------------------------------------\n\
    \nvoid VvyLw::solve() {\n    int n, q;\n    std::cin >> n >> q;\n    std::vector<int>\
    \ a(n);\n    std::cin >> a;\n    man::SparseTable<int> st(a, [](int a, int b)\
    \ -> int { return std::min(a, b); });\n    while(q--) {\n        int l, r;\n \
    \       std::cin >> l >> r;\n        std::cout << st.query(l, r) << '\\n';\n \
    \   }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/staticrmq\"\n/*#pragma\
    \ GCC optimize(\"O3\")\n#pragma GCC optimize(\"unroll-loops\")//*/\n//#pragma\
    \ GCC target(\"sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native\")\n#include\
    \ \"C++/template.hpp\"\n#include \"C++/ds/SparseTable.hpp\"\nint main() {\n  \t\
    VvyLw::wa_haya_exe();\n  \tnow(start);\n  \t//INT(t); while(t--)\n  \tVvyLw::solve();\n\
    \  \tnow(stop);\n  \ttime(start, stop);\n}\n\n// --------------------------------------------------------------------------------------------------------------\n\
    \nvoid VvyLw::solve() {\n    int n, q;\n    std::cin >> n >> q;\n    std::vector<int>\
    \ a(n);\n    std::cin >> a;\n    man::SparseTable<int> st(a, [](int a, int b)\
    \ -> int { return std::min(a, b); });\n    while(q--) {\n        int l, r;\n \
    \       std::cin >> l >> r;\n        std::cout << st.query(l, r) << '\\n';\n \
    \   }\n}"
  dependsOn:
  - C++/template.hpp
  - C++/other/press.hpp
  - C++/math/is_prime.hpp
  - C++/math/divisor.hpp
  - C++/math/primefactor.hpp
  - C++/math/primetable.hpp
  - C++/math/primefactortable.hpp
  - C++/math/psum/psum.hpp
  - C++/math/kthrooti.hpp
  - C++/core/timer.hpp
  - C++/core/mypair.hpp
  - C++/core/alias.hpp
  - C++/core/myvector.hpp
  - C++/core/io/input.hpp
  - C++/core/io/output.hpp
  - C++/ds/SparseTable.hpp
  isVerificationFile: true
  path: test/s_rmq.test.cpp
  requiredBy: []
  timestamp: '2025-06-06 22:43:22+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: test/s_rmq.test.cpp
layout: document
redirect_from:
- /verify/test/s_rmq.test.cpp
- /verify/test/s_rmq.test.cpp.html
title: test/s_rmq.test.cpp
---
