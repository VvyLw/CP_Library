---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':x:'
    path: test/rangeaffine.test.cpp
    title: test/rangeaffine.test.cpp
  _isVerificationFailed: true
  _pathExtension: hpp
  _verificationStatusIcon: ':x:'
  attributes:
    _deprecated_at_docs: docs/Modint.md
    document_title: Modint
    links:
    - https://atcoder.jp/contests/arc151/submissions/35526971
  bundledCode: "#line 2 \"C++/math/Modint.hpp\"\n\n#pragma GCC diagnostic ignored\
    \ \"-Wdeprecated-copy\"\n\n#ifndef MODINT\n#define MODINT\n#endif\n\n#include\
    \ <iostream>\n#include <cassert>\n#include <cstdint>\n#include <vector>\n#include\
    \ <utility>\n#include <type_traits>\n#include <numeric>\n#include <ranges>\nnamespace\
    \ man {\ntemplate <uint mod> struct Modint {\n    uint num = 0;\n    constexpr\
    \ Modint() noexcept {}\n    constexpr Modint(const Modint &x) noexcept : num(x.num){}\n\
    \    constexpr operator int64_t() const noexcept { return num; }\n    constexpr\
    \ static unsigned get_mod(){ return mod; }\n    constexpr Modint& operator+=(Modint\
    \ x) noexcept { num += x.num; if(num >= mod) num -= mod; return *this; }\n   \
    \ constexpr Modint& operator++() noexcept { if(num == mod - 1) num = 0; else num++;\
    \ return *this; }\n    constexpr Modint operator++(int) noexcept { Modint ans(*this);\
    \ operator++(); return ans; }\n    constexpr Modint operator-() const noexcept\
    \ { return Modint(0) -= *this; }\n    constexpr Modint& operator-=(Modint x) noexcept\
    \ { if(num < x.num) num += mod; num -= x.num; return *this; }\n    constexpr Modint&\
    \ operator--() noexcept { if(num == 0) num = mod - 1; else num--; return *this;\
    \ }\n    constexpr Modint operator--(int) noexcept { Modint ans(*this); operator--();\
    \ return ans; }\n    constexpr Modint& operator*=(Modint x) noexcept { num = uint64_t(num)\
    \ * x.num % mod; return *this; }\n    constexpr Modint& operator/=(Modint x) noexcept\
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
    \        return (is);\n    }\n};\n\n#ifndef ALIAS\nconstexpr int MOD = 0x3b800001;\n\
    constexpr int M0D = 1e9 + 7;\n#endif\n\ntypedef man::Modint<MOD> mint;\ntypedef\
    \ man::Modint<M0D> Mint;\n\ntemplate <class mint> struct Comb {\nprivate:\n  \
    \  std::vector<mint> fac{1}, inv{1};\n    inline void reserve(uint64_t a) noexcept\
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
    \ */\n"
  code: "#pragma once\n\n#pragma GCC diagnostic ignored \"-Wdeprecated-copy\"\n\n\
    #ifndef MODINT\n#define MODINT\n#endif\n\n#include <iostream>\n#include <cassert>\n\
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
    \        return (is);\n    }\n};\n\n#ifndef ALIAS\nconstexpr int MOD = 0x3b800001;\n\
    constexpr int M0D = 1e9 + 7;\n#endif\n\ntypedef man::Modint<MOD> mint;\ntypedef\
    \ man::Modint<M0D> Mint;\n\ntemplate <class mint> struct Comb {\nprivate:\n  \
    \  std::vector<mint> fac{1}, inv{1};\n    inline void reserve(uint64_t a) noexcept\
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
    \ */"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/Modint.hpp
  requiredBy: []
  timestamp: '2025-06-12 17:15:04+09:00'
  verificationStatus: LIBRARY_ALL_WA
  verifiedWith:
  - test/rangeaffine.test.cpp
documentation_of: C++/math/Modint.hpp
layout: document
redirect_from:
- /library/C++/math/Modint.hpp
- /library/C++/math/Modint.hpp.html
title: Modint
---
前半がModint\<定数\>, 後半が任意Modintです。