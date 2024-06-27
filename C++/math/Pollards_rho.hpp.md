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
    document_title: Pollard's Rho
    links: []
  bundledCode: "#line 2 \"C++/math/Pollards_rho.hpp\"\n\r\n#include <vector>\r\n#include\
    \ <algorithm>\r\n#ifndef TEMPLATE\r\ntypedef __uint128_t u128;\r\n#endif\r\nbool\
    \ miller(const uint64_t n);\r\nnamespace internal {\r\nuint bsf(const uint64_t\
    \ n){ return __builtin_ctzll(n); }\r\nuint64_t gcd(uint64_t a, uint64_t b) {\r\
    \n    if(a == 0) {\r\n        return b;\r\n    }\r\n    if(b == 0) {\r\n     \
    \   return a;\r\n    }\r\n    const uint shift = internal::bsf(a | b);\r\n   \
    \ a >>= internal::bsf(a);\r\n    do {\r\n        b >>= internal::bsf(b);\r\n \
    \       if(a > b) {\r\n            std::swap(a, b);\r\n        }\r\n        b\
    \ -= a;\r\n    } while(b > 0);\r\n    return a << shift;\r\n}\r\nuint64_t mod_pow(const\
    \ uint64_t a, uint64_t b, const uint64_t mod) {\r\n    uint64_t r = 1;\r\n   \
    \ u128 x = a % mod;\r\n    while(b > 0) {\r\n        if(b & 1) {\r\n         \
    \   r = (u128(r) * x) % mod;\r\n        }\r\n        x = (u128(x) * x) % mod;\r\
    \n        b >>= 1;\r\n    }\r\n    return r;\r\n}\r\nuint64_t find(const uint64_t\
    \ n) {\r\n    if(miller(n)) {\r\n        return n;\r\n    }\r\n    if(n % 2 ==\
    \ 0) {\r\n        return 2;\r\n    }\r\n    int st = 0;\r\n    const auto f =\
    \ [&](const uint64_t x) -> uint64_t { return (u128(x) * x + st) % n; };\r\n  \
    \  while(true) {\r\n        st++;\r\n        uint64_t x = st, y = f(x);\r\n  \
    \      while(true) {\r\n            const uint64_t p = gcd(y - x + n, n);\r\n\
    \            if(p == 0 || p == n) {\r\n                break;\r\n            }\r\
    \n            if(p != 1) {\r\n                return p;\r\n            }\r\n \
    \           x = f(x);\r\n            y = f(f(y));\r\n        }\r\n    }\r\n}\r\
    \n}\r\nbool miller(const uint64_t n) {\r\n    if(n <= 1) {\r\n        return false;\r\
    \n    }\r\n    if(n == 2) {\r\n        return true;\r\n    }\r\n    if(n % 2 ==\
    \ 0) {\r\n        return false;\r\n    }\r\n    uint64_t d = n - 1;\r\n    while(d\
    \ % 2 == 0) {\r\n        d /= 2;\r\n    }\r\n    for(const uint a: {2, 3, 5, 7,\
    \ 11, 13, 17, 19, 23, 29, 31, 37}) {\r\n        if(n <= a) {\r\n            break;\r\
    \n        }\r\n        uint64_t t = d, y = internal::mod_pow(a, t, n);\r\n   \
    \     while(t != n - 1 && y != 1 && y != n - 1) {\r\n            y = internal::mod_pow(y,\
    \ 2, n);\r\n            t <<= 1;\r\n        }\r\n        if(y != n - 1 && t %\
    \ 2 == 0) {\r\n            return false;\r\n        }\r\n    }\r\n    return true;\r\
    \n}\r\nstd::vector<uint64_t> rho(const uint64_t n) {\r\n    if(n == 1) {\r\n \
    \       return {};\r\n    }\r\n    const uint64_t x = internal::find(n);\r\n \
    \   if(x == n) {\r\n        return {x};\r\n    }\r\n    std::vector<uint64_t>\
    \ le = rho(x);\r\n    const std::vector<uint64_t> ri = rho(n / x);\r\n    le.insert(le.end(),\
    \ ri.begin(), ri.end());\r\n    std::sort(le.begin(), le.end());\r\n    return\
    \ le;\r\n}\r\n/**\r\n * @brief Pollard's Rho\r\n * @docs docs/Pollards_rho.md\r\
    \n */\n"
  code: "#pragma once\r\n\r\n#include <vector>\r\n#include <algorithm>\r\n#ifndef\
    \ TEMPLATE\r\ntypedef __uint128_t u128;\r\n#endif\r\nbool miller(const uint64_t\
    \ n);\r\nnamespace internal {\r\nuint bsf(const uint64_t n){ return __builtin_ctzll(n);\
    \ }\r\nuint64_t gcd(uint64_t a, uint64_t b) {\r\n    if(a == 0) {\r\n        return\
    \ b;\r\n    }\r\n    if(b == 0) {\r\n        return a;\r\n    }\r\n    const uint\
    \ shift = internal::bsf(a | b);\r\n    a >>= internal::bsf(a);\r\n    do {\r\n\
    \        b >>= internal::bsf(b);\r\n        if(a > b) {\r\n            std::swap(a,\
    \ b);\r\n        }\r\n        b -= a;\r\n    } while(b > 0);\r\n    return a <<\
    \ shift;\r\n}\r\nuint64_t mod_pow(const uint64_t a, uint64_t b, const uint64_t\
    \ mod) {\r\n    uint64_t r = 1;\r\n    u128 x = a % mod;\r\n    while(b > 0) {\r\
    \n        if(b & 1) {\r\n            r = (u128(r) * x) % mod;\r\n        }\r\n\
    \        x = (u128(x) * x) % mod;\r\n        b >>= 1;\r\n    }\r\n    return r;\r\
    \n}\r\nuint64_t find(const uint64_t n) {\r\n    if(miller(n)) {\r\n        return\
    \ n;\r\n    }\r\n    if(n % 2 == 0) {\r\n        return 2;\r\n    }\r\n    int\
    \ st = 0;\r\n    const auto f = [&](const uint64_t x) -> uint64_t { return (u128(x)\
    \ * x + st) % n; };\r\n    while(true) {\r\n        st++;\r\n        uint64_t\
    \ x = st, y = f(x);\r\n        while(true) {\r\n            const uint64_t p =\
    \ gcd(y - x + n, n);\r\n            if(p == 0 || p == n) {\r\n               \
    \ break;\r\n            }\r\n            if(p != 1) {\r\n                return\
    \ p;\r\n            }\r\n            x = f(x);\r\n            y = f(f(y));\r\n\
    \        }\r\n    }\r\n}\r\n}\r\nbool miller(const uint64_t n) {\r\n    if(n <=\
    \ 1) {\r\n        return false;\r\n    }\r\n    if(n == 2) {\r\n        return\
    \ true;\r\n    }\r\n    if(n % 2 == 0) {\r\n        return false;\r\n    }\r\n\
    \    uint64_t d = n - 1;\r\n    while(d % 2 == 0) {\r\n        d /= 2;\r\n   \
    \ }\r\n    for(const uint a: {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37}) {\r\
    \n        if(n <= a) {\r\n            break;\r\n        }\r\n        uint64_t\
    \ t = d, y = internal::mod_pow(a, t, n);\r\n        while(t != n - 1 && y != 1\
    \ && y != n - 1) {\r\n            y = internal::mod_pow(y, 2, n);\r\n        \
    \    t <<= 1;\r\n        }\r\n        if(y != n - 1 && t % 2 == 0) {\r\n     \
    \       return false;\r\n        }\r\n    }\r\n    return true;\r\n}\r\nstd::vector<uint64_t>\
    \ rho(const uint64_t n) {\r\n    if(n == 1) {\r\n        return {};\r\n    }\r\
    \n    const uint64_t x = internal::find(n);\r\n    if(x == n) {\r\n        return\
    \ {x};\r\n    }\r\n    std::vector<uint64_t> le = rho(x);\r\n    const std::vector<uint64_t>\
    \ ri = rho(n / x);\r\n    le.insert(le.end(), ri.begin(), ri.end());\r\n    std::sort(le.begin(),\
    \ le.end());\r\n    return le;\r\n}\r\n/**\r\n * @brief Pollard's Rho\r\n * @docs\
    \ docs/Pollards_rho.md\r\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/Pollards_rho.hpp
  requiredBy: []
  timestamp: '2024-06-27 16:02:11+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/pf.test.cpp
documentation_of: C++/math/Pollards_rho.hpp
layout: document
redirect_from:
- /library/C++/math/Pollards_rho.hpp
- /library/C++/math/Pollards_rho.hpp.html
title: Pollard's Rho
---
たまにオーバーフローで死ぬ  
後で修正予定