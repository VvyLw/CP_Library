---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: C++/template.hpp
    title: C++/template.hpp
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    links:
    - https://atcoder.jp/contests/arc151/submissions/35526971)
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 312, in update\n    raise BundleErrorAt(path, i + 1, \"#pragma once found\
    \ in a non-first line\")\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt:\
    \ C++/Modint.hpp: line 2: #pragma once found in a non-first line\n"
  code: "// inspired by tatyam(https://atcoder.jp/contests/arc151/submissions/35526971)\n\
    #pragma once\n\n#include <iostream>\n#include <cassert>\n#include <vector>\n#include\
    \ <utility>\n#include <type_traits>\nusing namespace std;\ntypedef long long ll;\n\
    typedef unsigned uint;\ntypedef unsigned long long ul;\ntemplate <uint mod> struct\
    \ Modint{\n    uint num = 0;\n    constexpr Modint() noexcept {}\n    constexpr\
    \ Modint(const Modint &x) noexcept : num(x.num){}\n    constexpr operator ll()\
    \ const noexcept { return num; }\n    constexpr static uint get_mod(){ return\
    \ mod; }\n    constexpr Modint& operator+=(Modint x) noexcept { num += x.num;\
    \ if(num >= mod) num -= mod; return *this; }\n    constexpr Modint& operator++()\
    \ noexcept { if(num == mod - 1) num = 0; else num++; return *this; }\n    constexpr\
    \ Modint operator++(int) noexcept { Modint ans(*this); operator++(); return ans;\
    \ }\n    constexpr Modint operator-() const noexcept { return Modint(0) -= *this;\
    \ }\n    constexpr Modint& operator-=(Modint x) noexcept { if(num < x.num) num\
    \ += mod; num -= x.num; return *this; }\n    constexpr Modint& operator--() noexcept\
    \ { if(num == 0) num = mod - 1; else num--; return *this; }\n    constexpr Modint\
    \ operator--(int) noexcept { Modint ans(*this); operator--(); return ans; }\n\
    \    constexpr Modint& operator*=(Modint x) noexcept { num = ul(num) * x.num %\
    \ mod; return *this; }\n    constexpr Modint& operator/=(Modint x) noexcept {\
    \ return operator*=(x.inv()); }\n    constexpr void operator%=(Modint x) noexcept\
    \ { void(0); }\n    template <class T> constexpr Modint(T x) noexcept {\n    \
    \    using U = typename conditional<sizeof(T)>= 4, T, int>::type;\n        U y\
    \ = x; y %= U(mod); if(y < 0) y += mod; num = uint(y);\n    }\n    template <class\
    \ T> constexpr Modint operator+(T x) const noexcept { return Modint(*this) +=\
    \ x; }\n    template <class T> constexpr Modint& operator+=(T x) noexcept { return\
    \ operator+=(Modint(x)); }\n    template <class T> constexpr Modint operator-(T\
    \ x) const noexcept { return Modint(*this) -= x; }\n    template <class T> constexpr\
    \ Modint& operator-=(T x) noexcept { return operator-=(Modint(x)); }\n    template\
    \ <class T> constexpr Modint operator*(T x) const noexcept { return Modint(*this)\
    \ *= x; }\n    template <class T> constexpr Modint& operator*=(T x) noexcept {\
    \ return operator*=(Modint(x)); }\n    template <class T> constexpr Modint operator/(T\
    \ x) const noexcept { return Modint(*this) /= x; }\n    template <class T> constexpr\
    \ Modint& operator/=(T x) noexcept { return operator/=(Modint(x)); }\n    constexpr\
    \ Modint inv() const noexcept { ll x = 0, y = 0; extgcd(num, mod, x, y); return\
    \ x; }\n    static constexpr ll extgcd(ll a, ll b, ll &x, ll &y) noexcept { ll\
    \ g = a; x = 1; y = 0; if(b){ g = extgcd(b, a % b, y, x); y -= a / b * x; } return\
    \ g; }\n    constexpr Modint pow(ul x) const noexcept { Modint ans = 1, cnt =\
    \ *this; while(x){ if(x & 1) ans *= cnt; cnt *= cnt; x /= 2; } return ans; }\n\
    \    friend ostream& operator<<(ostream& os, const Modint& m){ os << m.num; return\
    \ os; }\n    friend istream &operator>>(istream &is, Modint &a) {\n        ll\
    \ t;\n        is >> t;\n        a=Modint(t);\n        return (is);\n    }\n};\n\
    using mint = Modint<998244353>;\n//using mint = Modint<1000000007>;\n#include\
    \ <C++/template.hpp>\n#define MINT(...) mint __VA_ARGS__; in(__VA_ARGS__)\nusing\
    \ vm = V<mint>;\nusing wm = V<vm>;\nusing pm = PP<mint>;\ntemplate <class T> inline\
    \ T msum(const V<T> &v){ return accumulate(all(v), mint(0)); }\ntemplate <class\
    \ T> inline T msum(const V<T> &v, ll a, ll b){ return accumulate(all(v,a,b), mint(0));\
    \ }\ntemplate <class T> inline T mmul(const V<T> &v){ return accumulate(all(v),\
    \ mint(1), [](T acc, T i){ return acc*i; }); }\ntemplate <class T> inline T mmul(const\
    \ V<T> &v, ll a, ll b){ return accumulate(all(v,a,b), mint(1), [](T acc, T i){\
    \ return acc*i; }); }\nvm fac(1,1),inv(1,1);\nvoid reserve(ll a){\n    if(fac.size()>=a)\
    \ return;\n    if(a<fac.size()*2) a=fac.size()*2;\n    if(a>=mint::get_mod())\
    \ a=mint::get_mod();\n    while(fac.size()<a) fac.emplace_back(fac.back()*mint(fac.size()));\n\
    \    inv.resize(fac.size());\n    inv.back()=fac.back().inv();\n    for(ll i=inv.size()-1;\
    \ !inv[i-1]; i--) inv[i-1]=inv[i]*i;\n}\nmint fact(ll n){ if(n<0) return 0; reserve(n\
    \ + 1); return fac[n]; }\nmint nPr(ll n,ll r){\n    if(r<0 || n<r) return 0;\n\
    \    if(n>>24){ mint ans=1; rep(r) ans*=n--; return ans; }\n    reserve(n+1);\
    \ return fac[n]*inv[n-r];\n}\nmint nCr(ll n,ll r){ if(r<0 || n<r) return 0; r=min(r,n-r);\
    \ reserve(r+1); return nPr(n,r)*inv[r]; }\nmint nHr(ll n,ll r){ if(!n && !r) return\
    \ 1; if(n<=0 || r<0) return 0; return nCr(n+r-1,r); }\n\nstruct a_mint {\n   \
    \ int val;\n    a_mint() : val(0){}\n    a_mint(ll x) : val(x >= 0 ? x % get_mod()\
    \ : (get_mod() - (-x) % get_mod()) % get_mod()){}\n    int getmod() { return get_mod();\
    \ }\n    static int &get_mod() {\n        static int mod = 0;\n        return\
    \ mod;\n    }\n    static void set_mod(int md) { assert(md>0); get_mod() = md;\
    \ }\n    a_mint &operator+=(const a_mint &p) {\n        if ((val += p.val) >=\
    \ get_mod()) val -= get_mod();\n        return *this;\n    }\n    a_mint &operator-=(const\
    \ a_mint &p) {\n        if((val += get_mod() - p.val) >= get_mod()) val -= get_mod();\n\
    \        return *this;\n    }\n    a_mint &operator*=(const a_mint &p) {\n   \
    \     val = (int)(1LL * val * p.val % get_mod());\n        return *this;\n   \
    \ }\n    a_mint &operator/=(const a_mint &p) {\n        *this *= p.inv();\n  \
    \      return *this;\n    }\n    a_mint operator-() const { return a_mint(-val);\
    \ }\n    a_mint operator+(const a_mint &p) const { return a_mint(*this) += p;\
    \ }\n    a_mint operator-(const a_mint &p) const { return a_mint(*this) -= p;\
    \ }\n    a_mint operator*(const a_mint &p) const { return a_mint(*this) *= p;\
    \ }\n    a_mint operator/(const a_mint &p) const { return a_mint(*this) /= p;\
    \ }\n    a_mint& operator++() noexcept { if(val == get_mod() - 1) val = 0; else\
    \ val++; return *this; }\n    a_mint operator++(int) noexcept { a_mint ans(*this);\
    \ operator++(); return ans; }\n    a_mint& operator--() noexcept { if(val == 0)\
    \ val = get_mod() - 1; else val--; return *this; }\n    a_mint operator--(int)\
    \ noexcept { a_mint ans(*this); operator--(); return ans; }\n    bool operator==(const\
    \ a_mint &p) const { return val == p.val; }\n    bool operator!=(const a_mint\
    \ &p) const { return val != p.val; }\n    bool operator!() const { return val\
    \ == 0; }\n    bool operator<=(const a_mint &p) const { return val <= p.val; }\n\
    \    bool operator>=(const a_mint &p) const { return val >= p.val; }\n    bool\
    \ operator<(const a_mint &p) const { return val < p.val; }\n    bool operator>(const\
    \ a_mint &p) const { return val > p.val; }\n    a_mint inv() const {\n       \
    \ int a=val, b=get_mod(), u=1, v=0, t;\n        while(b>0) {\n            t=a/b;\n\
    \            swap(a -= t*b,b);\n            swap(u -= t*v,v);\n        }\n   \
    \     return a_mint(u);\n    }\n    a_mint pow(ll n) const {\n        a_mint res(1),\
    \ mul(val);\n        while(n>0) {\n            if(n & 1) res *= mul;\n       \
    \     mul *= mul;\n            n >>= 1;\n        }\n        return res;\n    }\n\
    \    friend ostream &operator<<(ostream &os, const a_mint &p) { return os << p.val;\
    \ }\n    friend istream &operator>>(istream &is, a_mint &a) {\n        ll t;\n\
    \        is >> t;\n        a=a_mint(t);\n        return is;\n    }\n};\n//#include\
    \ \"template.hpp\"\n#define AINT(...) a_mint __VA_ARGS__; in(__VA_ARGS__)\nusing\
    \ va = V<a_mint>;\nusing wa = V<va>;\nusing pa = PP<a_mint>;\n"
  dependsOn:
  - C++/template.hpp
  isVerificationFile: false
  path: C++/Modint.hpp
  requiredBy: []
  timestamp: '2023-11-25 04:23:36+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/Modint.hpp
layout: document
redirect_from:
- /library/C++/Modint.hpp
- /library/C++/Modint.hpp.html
title: C++/Modint.hpp
---
