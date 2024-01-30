---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/pf.test.cpp
    title: test/pf.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    _deprecated_at_docs: docs/Pollards_rho.md
    document_title: Pollard's rho
    links: []
  bundledCode: "#line 2 \"C++/Pollards_rho.hpp\"\n\r\n#include <vector>\r\n#include\
    \ <algorithm>\r\n#include <numeric>\r\n#include <functional>\r\ntypedef long long\
    \ ll;\r\ntypedef unsigned long long ul;\r\ntypedef __int128_t i128;\r\nll gcd(const\
    \ ll _a, const ll _b) {\r\n    ul a = std::abs(_a), b = std::abs(_b);\r\n    if(a\
    \ == 0) return b;\r\n    if(b == 0) return a;\r\n    const int shift = __builtin_ctzll(a\
    \ | b);\r\n    a >>= __builtin_ctzll(a);\r\n    do {\r\n        b >>= __builtin_ctzll(b);\r\
    \n        if(a > b) std::swap(a, b);\r\n        b -= a;\r\n    } while(b);\r\n\
    \    return a << shift;\r\n}\r\ntemplate <class T, class U> T pow_mod(T x, U n,\
    \ T md) {\r\n    T r = 1 % md;\r\n    x %= md;\r\n    while(n) {\r\n        if(n\
    \ & 1) r = (r * x) % md;\r\n        x = (x * x) % md;\r\n        n >>= 1;\r\n\
    \    }\r\n    return r;\r\n}\r\nbool is_prime(const ll n) {\r\n    if(n <= 1)\
    \ return false;\r\n    if(n == 2) return true;\r\n    if(n % 2 == 0) return false;\r\
    \n    ll d = n - 1;\r\n    while(d % 2 == 0) d /= 2;\r\n    for(const ll a : {2,\
    \ 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37}) {\r\n        if(n <= a) break;\r\n\
    \        ll t = d;\r\n        ll y = pow_mod<i128>(a, t, n);\r\n        while\
    \ (t != n - 1 && y != 1 && y != n - 1) {\r\n            y = i128(y) * y % n;\r\
    \n            t <<= 1;\r\n        }\r\n        if (y != n - 1 && t % 2 == 0) {\r\
    \n            return false;\r\n        }\r\n    }\r\n    return true;\r\n}\r\n\
    ll find(const ll n) {\r\n    if(is_prime(n)) return n;\r\n    if(n % 2 == 0) return\
    \ 2;\r\n    int st = 0;\r\n    const std::function<ll(ll)> f = [&](const ll x){\
    \ return (i128(x) * x + st) % n; };\r\n    while(true) {\r\n        st++;\r\n\
    \        ll x = st, y = f(x);\r\n        while (true) {\r\n            ll p =\
    \ gcd((y - x + n), n);\r\n            if(p == 0 || p == n) break;\r\n        \
    \    if(p != 1) return p;\r\n            x = f(x);\r\n            y = f(f(y));\r\
    \n        }\r\n    }\r\n}\r\n\r\nstd::vector<ll> rho(const ll n) {\r\n    if(n\
    \ == 1) return {};\r\n    const ll x = find(n);\r\n    if(x == n) return {x};\r\
    \n    std::vector<ll> le = rho(x);\r\n    const std::vector<ll> ri = rho(n / x);\r\
    \n    le.insert(le.end(), ri.begin(), ri.end());\r\n    return le;\r\n}\r\n/**\r\
    \n * @brief Pollard's rho\r\n * @docs docs/Pollards_rho.md\r\n */\n"
  code: "#pragma once\r\n\r\n#include <vector>\r\n#include <algorithm>\r\n#include\
    \ <numeric>\r\n#include <functional>\r\ntypedef long long ll;\r\ntypedef unsigned\
    \ long long ul;\r\ntypedef __int128_t i128;\r\nll gcd(const ll _a, const ll _b)\
    \ {\r\n    ul a = std::abs(_a), b = std::abs(_b);\r\n    if(a == 0) return b;\r\
    \n    if(b == 0) return a;\r\n    const int shift = __builtin_ctzll(a | b);\r\n\
    \    a >>= __builtin_ctzll(a);\r\n    do {\r\n        b >>= __builtin_ctzll(b);\r\
    \n        if(a > b) std::swap(a, b);\r\n        b -= a;\r\n    } while(b);\r\n\
    \    return a << shift;\r\n}\r\ntemplate <class T, class U> T pow_mod(T x, U n,\
    \ T md) {\r\n    T r = 1 % md;\r\n    x %= md;\r\n    while(n) {\r\n        if(n\
    \ & 1) r = (r * x) % md;\r\n        x = (x * x) % md;\r\n        n >>= 1;\r\n\
    \    }\r\n    return r;\r\n}\r\nbool is_prime(const ll n) {\r\n    if(n <= 1)\
    \ return false;\r\n    if(n == 2) return true;\r\n    if(n % 2 == 0) return false;\r\
    \n    ll d = n - 1;\r\n    while(d % 2 == 0) d /= 2;\r\n    for(const ll a : {2,\
    \ 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37}) {\r\n        if(n <= a) break;\r\n\
    \        ll t = d;\r\n        ll y = pow_mod<i128>(a, t, n);\r\n        while\
    \ (t != n - 1 && y != 1 && y != n - 1) {\r\n            y = i128(y) * y % n;\r\
    \n            t <<= 1;\r\n        }\r\n        if (y != n - 1 && t % 2 == 0) {\r\
    \n            return false;\r\n        }\r\n    }\r\n    return true;\r\n}\r\n\
    ll find(const ll n) {\r\n    if(is_prime(n)) return n;\r\n    if(n % 2 == 0) return\
    \ 2;\r\n    int st = 0;\r\n    const std::function<ll(ll)> f = [&](const ll x){\
    \ return (i128(x) * x + st) % n; };\r\n    while(true) {\r\n        st++;\r\n\
    \        ll x = st, y = f(x);\r\n        while (true) {\r\n            ll p =\
    \ gcd((y - x + n), n);\r\n            if(p == 0 || p == n) break;\r\n        \
    \    if(p != 1) return p;\r\n            x = f(x);\r\n            y = f(f(y));\r\
    \n        }\r\n    }\r\n}\r\n\r\nstd::vector<ll> rho(const ll n) {\r\n    if(n\
    \ == 1) return {};\r\n    const ll x = find(n);\r\n    if(x == n) return {x};\r\
    \n    std::vector<ll> le = rho(x);\r\n    const std::vector<ll> ri = rho(n / x);\r\
    \n    le.insert(le.end(), ri.begin(), ri.end());\r\n    return le;\r\n}\r\n/**\r\
    \n * @brief Pollard's rho\r\n * @docs docs/Pollards_rho.md\r\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/Pollards_rho.hpp
  requiredBy: []
  timestamp: '2024-01-30 14:40:09+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/pf.test.cpp
documentation_of: C++/Pollards_rho.hpp
layout: document
redirect_from:
- /library/C++/Pollards_rho.hpp
- /library/C++/Pollards_rho.hpp.html
title: Pollard's rho
---
たまにオーバーフローで死ぬ  
後で修正予定