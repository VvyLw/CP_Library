---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/core/alias.hpp
    title: "\u30A8\u30A4\u30EA\u30A2\u30B9"
  - icon: ':heavy_check_mark:'
    path: C++/ds/LazySegmentTree.hpp
    title: "\u9045\u5EF6\u30BB\u30B0\u6728"
  - icon: ':heavy_check_mark:'
    path: C++/math/Modint.hpp
    title: Modint
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://judge.yosupo.jp/problem/range_affine_range_sum
    links:
    - https://judge.yosupo.jp/problem/range_affine_range_sum
  bundledCode: "#line 1 \"test/rangeaffine.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/range_affine_range_sum\"\
    \n#line 2 \"C++/math/Modint.hpp\"\n\n#pragma GCC diagnostic ignored \"-Wdeprecated-copy\"\
    \n\n#ifndef MODINT\n#define MODINT\n#endif\n\n#include <iostream>\n#include <cassert>\n\
    #include <cstdint>\n#include <vector>\n#include <utility>\n#include <type_traits>\n\
    #include <numeric>\n#include <ranges>\nnamespace man {\ntemplate <uint mod> struct\
    \ Modint {\n    uint num = 0;\n    constexpr Modint() noexcept {}\n    constexpr\
    \ Modint(const Modint &x) noexcept : num(x.num){}\n    constexpr operator int64_t()\
    \ const noexcept { return num; }\n    constexpr static unsigned get_mod(){ return\
    \ mod; }\n    constexpr Modint& operator+=(Modint x) noexcept { num += x.num;\
    \ if(num >= mod) num -= mod; return *this; }\n    constexpr Modint& operator++()\
    \ noexcept { if(num == mod - 1) num = 0; else num++; return *this; }\n    constexpr\
    \ Modint operator++(int) noexcept { Modint ans(*this); operator++(); return ans;\
    \ }\n    constexpr Modint operator-() const noexcept { return Modint(0) -= *this;\
    \ }\n    constexpr Modint& operator-=(Modint x) noexcept { if(num < x.num) num\
    \ += mod; num -= x.num; return *this; }\n    constexpr Modint& operator--() noexcept\
    \ { if(num == 0) num = mod - 1; else num--; return *this; }\n    constexpr Modint\
    \ operator--(int) noexcept { Modint ans(*this); operator--(); return ans; }\n\
    \    constexpr Modint& operator*=(Modint x) noexcept { num = uint64_t(num) * x.num\
    \ % mod; return *this; }\n    constexpr Modint& operator/=(Modint x) noexcept\
    \ { return operator*=(x.inv()); }\n    constexpr void operator%=(Modint x) noexcept\
    \ { void(0); }\n    template <class T> constexpr Modint(T x) noexcept {\n    \
    \    using U = typename std::conditional<sizeof(T)>= 4, T, int>::type;\n     \
    \   U y = x; y %= U(mod); if(y < 0) y += mod; num = unsigned(y);\n    }\n    template\
    \ <class T> constexpr Modint operator+(T x) const noexcept { return Modint(*this)\
    \ += x; }\n    template <class T> constexpr Modint& operator+=(T x) noexcept {\
    \ return operator+=(Modint(x)); }\n    template <class T> constexpr Modint operator-(T\
    \ x) const noexcept { return Modint(*this) -= x; }\n    template <class T> constexpr\
    \ Modint& operator-=(T x) noexcept { return operator-=(Modint(x)); }\n    template\
    \ <class T> constexpr Modint operator*(T x) const noexcept { return Modint(*this)\
    \ *= x; }\n    template <class T> constexpr Modint& operator*=(T x) noexcept {\
    \ return operator*=(Modint(x)); }\n    template <class T> constexpr Modint operator/(T\
    \ x) const noexcept { return Modint(*this) /= x; }\n    template <class T> constexpr\
    \ Modint& operator/=(T x) noexcept { return operator/=(Modint(x)); }\n    constexpr\
    \ Modint inv() const noexcept { int64_t x = 0, y = 0; extgcd(num, mod, x, y);\
    \ return x; }\n    static constexpr int64_t extgcd(int64_t a, int64_t b, int64_t\
    \ &x, int64_t &y) noexcept { int64_t g = a; x = 1; y = 0; if(b){ g = extgcd(b,\
    \ a % b, y, x); y -= a / b * x; } return g; }\n    constexpr Modint pow(uint64_t\
    \ x) const noexcept { Modint ans = 1, cnt = *this; while(x){ if(x & 1) ans *=\
    \ cnt; cnt *= cnt; x /= 2; } return ans; }\n    friend std::ostream& operator<<(std::ostream&\
    \ os, const Modint& m){ os << m.num; return os; }\n    friend std::istream &operator>>(std::istream\
    \ &is, Modint &a) {\n        int64_t t;\n        is >> t;\n        a = Modint(t);\n\
    \        return (is);\n    }\n};\ntemplate <class mint> struct Comb {\nprivate:\n\
    \    std::vector<mint> fac{1}, inv{1};\n    inline void reserve(uint64_t a) noexcept\
    \ {\n        if(std::ssize(fac) >= a) {\n            return;\n        }\n    \
    \    if(a < std::ssize(fac) * 2) {\n            a = std::ssize(fac) * 2;\n   \
    \     }\n        if(a >= mint::get_mod()) {\n            a = mint::get_mod();\n\
    \        }\n        while(std::ssize(fac) < a) {\n            fac.emplace_back(fac.back()\
    \ * mint(std::ssize(fac)));\n        }\n        inv.resize(std::ssize(fac));\n\
    \        inv.back() = fac.back().inv();\n        for(const auto i: std::views::iota(0,\
    \ std::ssize(inv)) | std::views::reverse) {\n            inv[i - 1] = inv[i] *\
    \ i;\n        }\n    }\npublic:\n    inline mint fact(const int64_t n) noexcept\
    \ {\n        if(n < 0) {\n            return 0;\n        }\n        reserve(n\
    \ + 1);\n        return fac[n];\n    }\n    inline mint nPr(int64_t n, const int64_t\
    \ r) noexcept {\n        if(r < 0 || n < r) {\n            return 0;\n       \
    \ }\n        if(n >> 24) {\n            mint ans = 1;\n            for(const auto\
    \ i: std::views::iota(0, r)) {\n                ans *= n--;\n            }\n \
    \           return ans;\n        }\n        reserve(n + 1);\n        return fac[n]\
    \ * inv[n - r];\n    }\n    inline mint nCr(const int64_t n, int64_t r) noexcept\
    \ {\n        if(r < 0 || n < r) {\n            return 0;\n        }\n        r\
    \ = std::min(r, n - r);\n        reserve(r + 1);\n        return nPr(n, r) * inv[r];\n\
    \    }\n    inline mint nHr(const int64_t n, const int64_t r) noexcept {\n   \
    \     if(n == 0 && r == 0) {\n            return 1;\n        }\n        if(n <=\
    \ 0 || r < 0) {\n            return 0;\n        }\n        return nCr(n + r -\
    \ 1, r);\n    }\n};\n\nstruct a_mint {\n    int val;\n    a_mint() : val(0){}\n\
    \    a_mint(const int64_t x) : val(x >= 0 ? x % get_mod() : (get_mod() - (-x)\
    \ % get_mod()) % get_mod()){}\n    int getmod() { return get_mod(); }\n    static\
    \ int &get_mod() {\n        static int mod = 0;\n        return mod;\n    }\n\
    \    static void set_mod(int md) { assert(md>0); get_mod() = md; }\n    a_mint\
    \ &operator+=(const a_mint &p) noexcept {\n        if((val += p.val) >= get_mod())\
    \ {\n            val -= get_mod();\n        }\n        return *this;\n    }\n\
    \    a_mint &operator-=(const a_mint &p) noexcept {\n        if((val += get_mod()\
    \ - p.val) >= get_mod()) {\n            val -= get_mod();\n        }\n       \
    \ return *this;\n    }\n    a_mint &operator*=(const a_mint &p) noexcept {\n \
    \       val = (int)(1LL * val * p.val % get_mod());\n        return *this;\n \
    \   }\n    a_mint &operator/=(const a_mint &p) noexcept {\n        *this *= p.inv();\n\
    \        return *this;\n    }\n    a_mint operator-() const noexcept { return\
    \ a_mint(-val); }\n    a_mint operator+(const a_mint &p) const noexcept { return\
    \ a_mint(*this) += p; }\n    a_mint operator-(const a_mint &p) const noexcept\
    \ { return a_mint(*this) -= p; }\n    a_mint operator*(const a_mint &p) const\
    \ noexcept { return a_mint(*this) *= p; }\n    a_mint operator/(const a_mint &p)\
    \ const noexcept { return a_mint(*this) /= p; }\n    a_mint& operator++() noexcept\
    \ { if(val == get_mod() - 1){ val = 0; } else { val++; } return *this; }\n   \
    \ a_mint operator++(int) noexcept { a_mint ans(*this); operator++(); return ans;\
    \ }\n    a_mint& operator--() noexcept { if(val == 0){ val = get_mod() - 1; }\
    \ else { val--; } return *this; }\n    a_mint operator--(int) noexcept { a_mint\
    \ ans(*this); operator--(); return ans; }\n    constexpr inline bool operator==(const\
    \ a_mint &p) const noexcept { return val == p.val; }\n    constexpr inline bool\
    \ operator!=(const a_mint &p) const noexcept { return val != p.val; }\n    constexpr\
    \ inline bool operator!() const noexcept { return val == 0; }\n    constexpr inline\
    \ bool operator<=(const a_mint &p) const noexcept { return val <= p.val; }\n \
    \   constexpr inline bool operator>=(const a_mint &p) const noexcept { return\
    \ val >= p.val; }\n    constexpr inline bool operator<(const a_mint &p) const\
    \ noexcept { return val < p.val; }\n    constexpr inline bool operator>(const\
    \ a_mint &p) const noexcept { return val > p.val; }\n    inline a_mint inv() const\
    \ noexcept {\n        int a = val, b = get_mod(), u = 1, v = 0, t;\n        while(b\
    \ > 0) {\n            t = a / b;\n            ::std::swap(a -= t * b, b);\n  \
    \          ::std::swap(u -= t * v, v);\n        }\n        return a_mint(u);\n\
    \    }\n    inline a_mint pow(int64_t n) const noexcept {\n        a_mint ret(1),\
    \ mul(val);\n        while(n > 0) {\n            if(n & 1) {\n               \
    \ ret *= mul;\n            }\n            mul *= mul;\n            n >>= 1;\n\
    \        }\n        return ret;\n    }\n    inline friend ::std::ostream &operator<<(::std::ostream\
    \ &os, const a_mint &p) noexcept { return os << p.val; }\n    inline friend ::std::istream\
    \ &operator>>(::std::istream &is, a_mint &a) noexcept {\n        int64_t t;\n\
    \        is >> t;\n        a = a_mint(t);\n        return is;\n    }\n};\n}\n\n\
    /**\n * @brief Modint\n * @docs docs/Modint.md\n * @see https://atcoder.jp/contests/arc151/submissions/35526971\n\
    \ */\n#line 2 \"C++/ds/LazySegmentTree.hpp\"\n\n#include <ostream>\n#line 6 \"\
    C++/ds/LazySegmentTree.hpp\"\n#include <algorithm>\n#include <functional>\n#include\
    \ <cmath>\n#include <limits>\n#line 11 \"C++/ds/LazySegmentTree.hpp\"\nnamespace\
    \ man {\ntemplate <class T, class U> struct LazySegTree {\nprivate:\n    using\
    \ F = std::function<T(T, T)>;\n    using M = std::function<T(T, U)>;\n    using\
    \ C = std::function<U(U, U)>;\n    int n, sz, h;\n    std::vector<T> data;\n \
    \   std::vector<U> lazy;\n    const F f;\n    const M map;\n    const C comp;\n\
    \    const T e;\n    const U id;\n    inline void update(const int k){ data[k]\
    \ = f(data[2 * k], data[2 * k + 1]); }\n    inline void all_apply(const int k,\
    \ const U &x) {\n        data[k] = map(data[k], x);\n        if(k < sz) {\n  \
    \          lazy[k] = comp(lazy[k], x);\n        }\n    }\n    inline void propagate(const\
    \ int k) {\n        if(lazy[k] != id) {\n            all_apply(2 * k, lazy[k]);\n\
    \            all_apply(2 * k + 1, lazy[k]);\n            lazy[k] = id;\n     \
    \   }\n    }\npublic:\n    LazySegTree(const int n, const F &f, const M &map,\
    \ const C &comp, const T &e, const U &id): n(n), f(f), map(map), comp(comp), e(e),\
    \ id(id) {\n        sz = 1;\n        h = 0;\n        while(sz < n) {\n       \
    \     sz <<= 1;\n            h++;\n        }\n        data.assign(2 * sz, e);\n\
    \        lazy.assign(2 * sz, id);\n    }\n    LazySegTree(const std::vector<T>\
    \ &v, const F &f, const M &map, const C &comp, const T &e, const U &id): LazySegTree(std::ssize(v),\
    \ f, map, comp, e, id){ build(v); }\n    void build(const std::vector<T> &v) {\n\
    \        assert(n == std::ssize(v));\n        for(const auto k: std::views::iota(0,\
    \ n)) {\n            data[k + sz] = v[k];\n        }\n        for(const auto k:\
    \ std::views::iota(1, sz) | std::views::reverse) {\n            update(k);\n \
    \       }\n    }\n    void set(int k, const T &x) {\n        k += sz;\n      \
    \  for(const auto i: std::views::iota(1) | std::views::take(h) | std::views::reverse)\
    \ {\n            propagate(k >> i);\n        }\n        data[k] = x;\n       \
    \ for(const auto i: std::views::iota(1) | std::views::take(h)) {\n           \
    \ update(k >> i);\n        }\n    }\n    inline T &operator[](int k) noexcept\
    \ {\n        k += sz;\n        for(const auto i: std::views::iota(1) | std::views::take(h)\
    \ | std::views::reverse) {\n            propagate(k >> i);\n        }\n      \
    \  return data[k];\n    }\n    inline T const& operator[](const int k) const noexcept\
    \ { return data[k + sz]; }\n    inline T query(int l, int r) noexcept {\n    \
    \    if(l >= r) {\n            return e;\n        }\n        l += sz;\n      \
    \  r += sz;\n        for(const auto i: std::views::iota(1) | std::views::take(h)\
    \ | std::views::reverse) {\n            if(((l >> i) << i) != l) {\n         \
    \       propagate(l >> i);\n            }\n            if(((r >> i) << i) != r)\
    \ {\n                propagate((r - 1) >> i);\n            }\n        }\n    \
    \    T L = e, R = e;\n        for(; l < r; l >>= 1, r >>= 1) {\n            if(l\
    \ & 1) {\n                L = f(L, data[l++]);\n            }\n            if(r\
    \ & 1) {\n                R = f(data[--r], R);\n            }\n        }\n   \
    \     return f(L, R);\n    }\n    constexpr inline T all() const noexcept { return\
    \ data[1]; }\n    constexpr inline void apply(int k, const U &x) noexcept {\n\
    \        k += sz;\n        for(const auto i: std::views::iota(1) | std::views::take(h)\
    \ | std::views::reverse) {\n            propagate(k >> i);\n        }\n      \
    \  data[k] = map(data[k], x);\n        for(const auto i: std::views::iota(1) |\
    \ std::views::take(h)) {\n            update(k >> i);\n        }\n    }\n    constexpr\
    \ inline void apply(int l, int r, const U &x) noexcept {\n        if(l >= r) {\n\
    \            return;\n        }\n        l += sz;\n        r += sz;\n        for(const\
    \ auto i: std::views::iota(1) | std::views::take(h) | std::views::reverse) {\n\
    \            if(((l >> i) << i) != l) {\n                propagate(l >> i);\n\
    \            }\n            if(((r >> i) << i) != r) {\n                propagate((r\
    \ - 1) >> i);\n            }\n        }\n        int l2 = l, r2 = r;\n       \
    \ for(; l < r; l >>= 1, r >>= 1) {\n            if(l & 1) {\n                all_apply(l++,\
    \ x);\n            }\n            if(r & 1) {\n                all_apply(--r,\
    \ x);\n            }\n        }\n        l = l2, r = r2;\n        for(const auto\
    \ i: std::views::iota(1) | std::views::take(h)) {\n            if(((l >> i) <<\
    \ i) != l) {\n                update(l >> i);\n            }\n            if(((r\
    \ >> i) << i) != r) {\n                update((r - 1) >> i);\n            }\n\
    \        }\n    }\n    constexpr inline int size() const noexcept { return n;\
    \ }\n    template <class Boolean = bool> constexpr inline int find_first(int l,\
    \ const Boolean &fn) noexcept {\n        if(l >= n) {\n            return n;\n\
    \        }\n        l += sz;\n        for(const auto i: std::views::iota(1) |\
    \ std::views::take(h) | std::views::reverse) {\n            propagate(l >> i);\n\
    \        }\n        T sum = e;\n        do {\n            while((l & 1) == 0)\
    \ {\n                l >>= 1;\n            }\n            if(fn(f(sum, data[l])))\
    \ {\n                while(l < sz) {\n                    propagate(l);\n    \
    \                l <<= 1;\n                    const auto nxt = f(sum, data[l]);\n\
    \                    if(!fn(nxt)) {\n                        sum = nxt;\n    \
    \                    l++;\n                    }\n                }\n        \
    \        return l + 1 - sz;\n            }\n            sum = f(sum, data[l++]);\n\
    \        } while((l & -l) != l);\n        return n;\n    }\n    template <class\
    \ Boolean = bool> constexpr inline int find_last(int r, const Boolean &fn) noexcept\
    \ {\n        if(r <= 0) {\n            return -1;\n        }\n        r += sz;\n\
    \        for(const auto i: std::views::iota(1) | std::views::take(h) | std::views::reverse)\
    \ {\n            propagate((r - 1) >> i);\n        }\n        T sum = e;\n   \
    \     do {\n            r--;\n            while(r > 1 && r & 1) {\n          \
    \      r >>= 1;\n            }\n            if(fn(f(data[r], sum))) {\n      \
    \          while(r < sz) {\n                    propagate(r);\n              \
    \      r = (r << 1) + 1;\n                    const auto nxt = f(data[r], sum);\n\
    \                    if(!fn(nxt)) {\n                        sum = nxt;\n    \
    \                    r--;\n                    }\n                }\n        \
    \        return r - sz;\n            }\n            sum = f(data[r], sum);\n \
    \       } while((r & -r) != r);\n        return -1;\n    }\n    constexpr inline\
    \ void clear() noexcept { std::ranges::fill(data, e); }\n    inline friend std::ostream\
    \ &operator<<(std::ostream &os, const LazySegTree &seg) noexcept {\n        os\
    \ << seg[0];\n        for(int i = 0; ++i < seg.size();) {\n            os << '\
    \ ' << seg[i];\n        }\n        return os;\n    }\n};\n\ntemplate <class T>\
    \ struct zwei {\n    T first, second;\n    zwei(){}\n    zwei(const T &f, const\
    \ T &s): first(f), second(s){}\n    constexpr bool operator!=(const zwei<T> &z)\
    \ noexcept { return first != z.first || second != z.second; }\n    operator T()\
    \ const { return first; }\n    friend std::ostream &operator<<(std::ostream &os,\
    \ const zwei &z) {\n        os << z.first;\n        return os;\n    }\n};\n\n\
    template <class T> struct RAMX: LazySegTree<T, T> {    \n    RAMX(const std::vector<T>\
    \ &v): LazySegTree<T, T>(v, [](const T a, const T b){ return std::max(a, b); },\
    \ [](const T a, const T b){ return a + b; }, [](const T a, const T b){ return\
    \ a + b; }, std::numeric_limits<T>::min(), 0){}\n};\ntemplate <class T> struct\
    \ RAMN: LazySegTree<T, T> {\n    RAMN(const std::vector<T> &v): LazySegTree<T,\
    \ T>(v, [](const T a, const T b){ return std::min(a, b); }, [](const T a, const\
    \ T b){ return a + b; }, [](const T a, const T b){ return a + b; }, std::numeric_limits<T>::max(),\
    \ 0){}\n};\ntemplate <class T> struct RASM: LazySegTree<zwei<T>, T> {\n    RASM(const\
    \ std::vector<T> &v): LazySegTree<zwei<T>, T>(std::ssize(v), [](const zwei<T>\
    \ a, const zwei<T> b){ return zwei<T>(a.first + b.first, a.second + b.second);\
    \ }, [](const zwei<T> a, const T b){ return zwei<T>(a.first + a.second * b, a.second);\
    \ }, [](const T a, const T b){ return a + b; }, zwei<T>(0, 0), 0) {\n        std::vector<zwei<T>>\
    \ w(std::ssize(v));\n        for(const auto i: std::views::iota(0, std::ssize(v)))\
    \ {\n            w[i] = zwei<T>(v[i], 1);\n        }\n        LazySegTree<zwei<T>,\
    \ T>::build(w);\n    }\n};\ntemplate <class T> struct RUMX: LazySegTree<T, T>\
    \ {    \n    RUMX(const std::vector<T> &v): LazySegTree<T, T>(v, [](const T a,\
    \ const T b){ return std::max(a, b); }, [](const T, const T b){ return b; }, [](const\
    \ T, const T b){ return b; }, std::numeric_limits<T>::min(), std::numeric_limits<T>::min()){}\n\
    };\ntemplate <class T> struct RUMN: LazySegTree<T, T> {\n    RUMN(const std::vector<T>\
    \ &v): LazySegTree<T, T>(v, [](const T a, const T b){ return std::min(a, b); },\
    \ [](const T, const T b){ return b; }, [](const T, const T b){ return b; }, std::numeric_limits<T>::max(),\
    \ std::numeric_limits<T>::max()){}\n};\ntemplate <class T> struct RUSM: LazySegTree<zwei<T>,\
    \ T> {\n    RUSM(const std::vector<T> &v): LazySegTree<zwei<T>, T>(std::ssize(v),\
    \ [](const zwei<T> a, const zwei<T> b){ return zwei<T>(a.first + b.first, a.second\
    \ + b.second); }, [](const zwei<T> a, const T b){ return zwei<T>(a.second * b,\
    \ a.second); }, [](const T a, const T b){ return b; }, zwei<T>(0, 0), std::numeric_limits<T>::min())\
    \ {\n        std::vector<zwei<T>> w(std::ssize(v));\n        for(const auto i:\
    \ std::views::iota(0, std::ssize(v))) {\n            w[i] = zwei<T>(v[i], 1);\n\
    \        }\n        LazySegTree<zwei<T>, T>::build(w);\n    }\n};\n}\n\n/**\n\
    \ * @brief \u9045\u5EF6\u30BB\u30B0\u6728\n * @see https://ei1333.github.io/library/structure/segment-tree/lazy-segment-tree.hpp\n\
    \ */\n#line 2 \"C++/core/alias.hpp\"\n\n#ifndef ALIAS\n#define ALIAS\n#endif\n\
    \n#line 8 \"C++/core/alias.hpp\"\n#include <numbers>\n#include <queue>\n#include\
    \ <ext/pb_ds/assoc_container.hpp>\n#include <ext/pb_ds/tree_policy.hpp>\n\nnamespace\
    \ internal {\ntemplate <typename T> concept num = std::integral<T> || std::floating_point<T>;\n\
    }\n\nconstexpr int dx[] = {0, 0, 0, -1, 1, -1, -1, 1, 1};\nconstexpr int dy[]\
    \ = {0, -1, 1, 0, 0, -1, 1, -1, 1};\nconstexpr int MOD = 0x3b800001;\nconstexpr\
    \ int M0D = 1e9 + 7;\nconstexpr int INF = 1 << 30;\nconstexpr int64_t LINF = (1LL\
    \ << 61) - 1;\nconstexpr long double DINF = std::numeric_limits<long double>::infinity();\n\
    template <internal::num T> constexpr T LIM = std::numeric_limits<T>::max();\n\
    constexpr long double PI = std::numbers::pi;\nconstexpr long double E = std::numbers::e;\n\
    \ntypedef int64_t i64;\ntypedef long double ld;\ntypedef uint32_t u32;\ntypedef\
    \ uint64_t u64;\ntypedef __int128_t i128;\ntypedef __uint128_t u128;\n#ifdef MODINT\n\
    typedef man::Modint<MOD> mint;\ntypedef man::Modint<M0D> Mint;\n#endif\ntemplate\
    \ <size_t N> using ti = std::array<i64, N>;\ntypedef ti<3> tri;\ntemplate <class\
    \ T> using pq = std::priority_queue<T>;\ntemplate <class T> using pqr = std::priority_queue<T,\
    \ std::vector<T>, std::greater<T>>;\ntemplate <class T> using Tree = __gnu_pbds::tree<T,\
    \ __gnu_pbds::null_type, std::less<T>, __gnu_pbds::rb_tree_tag, __gnu_pbds::tree_order_statistics_node_update>;\n\
    template <class T> using TREE = __gnu_pbds::tree<T, __gnu_pbds::null_type, std::greater<T>,\
    \ __gnu_pbds::rb_tree_tag, __gnu_pbds::tree_order_statistics_node_update>;\n\n\
    /**\n * @brief \u30A8\u30A4\u30EA\u30A2\u30B9\n */\n#line 5 \"test/rangeaffine.test.cpp\"\
    \nusing Z = man::zwei<mint>;\nint main() {\n    int n, q;\n    std::cin >> n >>\
    \ q;\n    man::LazySegTree<Z, Z> seg(n, [](const Z &a, const Z &b) -> Z { return\
    \ Z(a.first + b.first, a.second + b.second); }, [](const Z &a, const Z &b) ->\
    \ Z { return Z(a.first * b.first + a.second * b.second, a.second); }, [](const\
    \ Z &a, const Z &b) -> Z { return Z(a.first * b.first, a.second * b.first + b.second);\
    \ }, Z(0, 0), Z(1, 0));\n\tstd::vector<Z> a(n);\n    for(int i = 0; i < n; ++i)\
    \ {\n        int x;\n        std::cin >> x;\n        a[i] = Z(x, 1);\n    }\n\
    \    seg.build(a);\n    while(q--) {\n        int t, l, r;\n        std::cin >>\
    \ t >> l >> r;\n        if(t == 0) {\n            int p, q;\n            std::cin\
    \ >> p >> q;\n            seg.apply(l, r, Z(p, q));\n        } else {\n      \
    \      std::cout << seg.query(l, r) << '\\n';\n        }\n    }\n}\n\n// verified\
    \ but actually failed(slowest: 9.000372 sec.)\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/range_affine_range_sum\"\
    \n#include \"C++/math/Modint.hpp\"\n#include \"C++/ds/LazySegmentTree.hpp\"\n\
    #include \"C++/core/alias.hpp\"\nusing Z = man::zwei<mint>;\nint main() {\n  \
    \  int n, q;\n    std::cin >> n >> q;\n    man::LazySegTree<Z, Z> seg(n, [](const\
    \ Z &a, const Z &b) -> Z { return Z(a.first + b.first, a.second + b.second); },\
    \ [](const Z &a, const Z &b) -> Z { return Z(a.first * b.first + a.second * b.second,\
    \ a.second); }, [](const Z &a, const Z &b) -> Z { return Z(a.first * b.first,\
    \ a.second * b.first + b.second); }, Z(0, 0), Z(1, 0));\n\tstd::vector<Z> a(n);\n\
    \    for(int i = 0; i < n; ++i) {\n        int x;\n        std::cin >> x;\n  \
    \      a[i] = Z(x, 1);\n    }\n    seg.build(a);\n    while(q--) {\n        int\
    \ t, l, r;\n        std::cin >> t >> l >> r;\n        if(t == 0) {\n         \
    \   int p, q;\n            std::cin >> p >> q;\n            seg.apply(l, r, Z(p,\
    \ q));\n        } else {\n            std::cout << seg.query(l, r) << '\\n';\n\
    \        }\n    }\n}\n\n// verified but actually failed(slowest: 9.000372 sec.)"
  dependsOn:
  - C++/math/Modint.hpp
  - C++/ds/LazySegmentTree.hpp
  - C++/core/alias.hpp
  isVerificationFile: true
  path: test/rangeaffine.test.cpp
  requiredBy: []
  timestamp: '2025-06-11 17:30:11+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/rangeaffine.test.cpp
layout: document
redirect_from:
- /verify/test/rangeaffine.test.cpp
- /verify/test/rangeaffine.test.cpp.html
title: test/rangeaffine.test.cpp
---
