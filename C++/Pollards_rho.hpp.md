---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    links: []
  bundledCode: "#line 2 \"C++/Pollards_rho.hpp\"\n\r\n#include <vector>\r\n#include\
    \ <algorithm>\r\n#include <numeric>\r\ntypedef long long ll;\r\ntypedef unsigned\
    \ long long ul;\r\nll gcd(ll _a, ll _b) {\r\n    ull a = abs(_a), b = abs(_b);\r\
    \n    if(a == 0) return b;\r\n    if(b == 0) return a;\r\n    const int shift\
    \ = __builtin_ctzll(a|b);\r\n    a >>= __builtin_ctzll(a);\r\n    do {\r\n   \
    \     b >>= bsf(b);\r\n        if (a > b) swap(a, b);\r\n        b -= a;\r\n \
    \   } while (b);\r\n    return (a << shift);\r\n}\r\n\r\ntemplate<class T, class\
    \ U>\r\nT pow_mod(T x, U n, T md) {\r\n    T r = 1 % md;\r\n    x %= md;\r\n \
    \   while (n) {\r\n        if (n & 1) r = (r * x) % md;\r\n        x = (x * x)\
    \ % md;\r\n        n >>= 1;\r\n    }\r\n    return r;\r\n}\r\n\r\nbool is_prime(ll\
    \ n) {\r\n    if (n <= 1) return false;\r\n    if (n == 2) return true;\r\n  \
    \  if (n % 2 == 0) return false;\r\n    ll d = n - 1;\r\n    while (d % 2 == 0)\
    \ d /= 2;\r\n    for (ll a : {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37}) {\r\
    \n        if (n <= a) break;\r\n        ll t = d;\r\n        ll y = pow_mod<__int128_t>(a,\
    \ t, n);  // over\r\n        while (t != n - 1 && y != 1 && y != n - 1) {\r\n\
    \            y = __int128_t(y) * y % n;  // flow\r\n            t <<= 1;\r\n \
    \       }\r\n        if (y != n - 1 && t % 2 == 0) {\r\n            return false;\r\
    \n        }\r\n    }\r\n    return true;\r\n}\r\n\r\nll pollard_single(ll n) {\r\
    \n    if (is_prime(n)) return n;\r\n    if (n % 2 == 0) return 2;\r\n    ll st\
    \ = 0;\r\n    auto f = [&](ll x) { return (__int128_t(x) * x + st) % n; };\r\n\
    \    while (true) {\r\n        st++;\r\n        ll x = st, y = f(x);\r\n     \
    \   while (true) {\r\n            ll p = gcd((y - x + n), n);\r\n            if\
    \ (p == 0 || p == n) break;\r\n            if (p != 1) return p;\r\n         \
    \   x = f(x);\r\n            y = f(f(y));\r\n        }\r\n    }\r\n}\r\n\r\nV<ll>\
    \ pollard(ll n) {\r\n    if (n == 1) return {};\r\n    ll x = pollard_single(n);\r\
    \n    if (x == n) return {x};\r\n    V<ll> le = pollard(x);\r\n    V<ll> ri =\
    \ pollard(n / x);\r\n    le.insert(le.end(), ri.begin(), ri.end());\r\n    return\
    \ le;\r\n}\n"
  code: "#pragma once\r\n\r\n#include <vector>\r\n#include <algorithm>\r\n#include\
    \ <numeric>\r\ntypedef long long ll;\r\ntypedef unsigned long long ul;\r\nll gcd(ll\
    \ _a, ll _b) {\r\n    ull a = abs(_a), b = abs(_b);\r\n    if(a == 0) return b;\r\
    \n    if(b == 0) return a;\r\n    const int shift = __builtin_ctzll(a|b);\r\n\
    \    a >>= __builtin_ctzll(a);\r\n    do {\r\n        b >>= bsf(b);\r\n      \
    \  if (a > b) swap(a, b);\r\n        b -= a;\r\n    } while (b);\r\n    return\
    \ (a << shift);\r\n}\r\n\r\ntemplate<class T, class U>\r\nT pow_mod(T x, U n,\
    \ T md) {\r\n    T r = 1 % md;\r\n    x %= md;\r\n    while (n) {\r\n        if\
    \ (n & 1) r = (r * x) % md;\r\n        x = (x * x) % md;\r\n        n >>= 1;\r\
    \n    }\r\n    return r;\r\n}\r\n\r\nbool is_prime(ll n) {\r\n    if (n <= 1)\
    \ return false;\r\n    if (n == 2) return true;\r\n    if (n % 2 == 0) return\
    \ false;\r\n    ll d = n - 1;\r\n    while (d % 2 == 0) d /= 2;\r\n    for (ll\
    \ a : {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37}) {\r\n        if (n <= a) break;\r\
    \n        ll t = d;\r\n        ll y = pow_mod<__int128_t>(a, t, n);  // over\r\
    \n        while (t != n - 1 && y != 1 && y != n - 1) {\r\n            y = __int128_t(y)\
    \ * y % n;  // flow\r\n            t <<= 1;\r\n        }\r\n        if (y != n\
    \ - 1 && t % 2 == 0) {\r\n            return false;\r\n        }\r\n    }\r\n\
    \    return true;\r\n}\r\n\r\nll pollard_single(ll n) {\r\n    if (is_prime(n))\
    \ return n;\r\n    if (n % 2 == 0) return 2;\r\n    ll st = 0;\r\n    auto f =\
    \ [&](ll x) { return (__int128_t(x) * x + st) % n; };\r\n    while (true) {\r\n\
    \        st++;\r\n        ll x = st, y = f(x);\r\n        while (true) {\r\n \
    \           ll p = gcd((y - x + n), n);\r\n            if (p == 0 || p == n) break;\r\
    \n            if (p != 1) return p;\r\n            x = f(x);\r\n            y\
    \ = f(f(y));\r\n        }\r\n    }\r\n}\r\n\r\nV<ll> pollard(ll n) {\r\n    if\
    \ (n == 1) return {};\r\n    ll x = pollard_single(n);\r\n    if (x == n) return\
    \ {x};\r\n    V<ll> le = pollard(x);\r\n    V<ll> ri = pollard(n / x);\r\n   \
    \ le.insert(le.end(), ri.begin(), ri.end());\r\n    return le;\r\n}"
  dependsOn: []
  isVerificationFile: false
  path: C++/Pollards_rho.hpp
  requiredBy: []
  timestamp: '2023-11-29 20:40:26+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/Pollards_rho.hpp
layout: document
redirect_from:
- /library/C++/Pollards_rho.hpp
- /library/C++/Pollards_rho.hpp.html
title: C++/Pollards_rho.hpp
---
