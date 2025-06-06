---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/math/pollard_rho.hpp
    title: Pollard's Rho
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://judge.yosupo.jp/problem/factorize
    links:
    - https://judge.yosupo.jp/problem/factorize
  bundledCode: "#line 1 \"test/pf.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/factorize\"\
    \n#include <iostream>\n#include <algorithm>\n#include <unordered_map>\n#line 2\
    \ \"C++/math/pollard_rho.hpp\"\n\r\n#include <vector>\r\n#include <cstdint>\r\n\
    namespace man {\r\nconstexpr inline bool miller(const uint64_t n) noexcept;\r\n\
    namespace internal {\r\nconstexpr inline uint bsf(const uint64_t n) noexcept {\
    \ return __builtin_ctzll(n); }\r\nconstexpr inline uint64_t gcd(uint64_t a, uint64_t\
    \ b) noexcept {\r\n    if(a == 0) {\r\n        return b;\r\n    }\r\n    if(b\
    \ == 0) {\r\n        return a;\r\n    }\r\n    const uint shift = internal::bsf(a\
    \ | b);\r\n    a >>= internal::bsf(a);\r\n    do {\r\n        b >>= internal::bsf(b);\r\
    \n        if(a > b) {\r\n            std::swap(a, b);\r\n        }\r\n       \
    \ b -= a;\r\n    } while(b > 0);\r\n    return a << shift;\r\n}\r\nconstexpr inline\
    \ uint64_t mod_pow(const uint64_t a, uint64_t b, const uint64_t mod) noexcept\
    \ {\r\n    uint64_t r = 1;\r\n    __uint128_t x = a % mod;\r\n    while(b > 0)\
    \ {\r\n        if(b & 1) {\r\n            r = (__uint128_t(r) * x) % mod;\r\n\
    \        }\r\n        x = (__uint128_t(x) * x) % mod;\r\n        b >>= 1;\r\n\
    \    }\r\n    return r;\r\n}\r\nconstexpr inline uint64_t find(const uint64_t\
    \ n) noexcept {\r\n    if(miller(n)) {\r\n        return n;\r\n    }\r\n    if(n\
    \ % 2 == 0) {\r\n        return 2;\r\n    }\r\n    int st = 0;\r\n    const auto\
    \ f = [&](const uint64_t x) -> uint64_t { return (__uint128_t(x) * x + st) % n;\
    \ };\r\n    while(true) {\r\n        st++;\r\n        uint64_t x = st, y = f(x);\r\
    \n        while(true) {\r\n            const uint64_t p = gcd(y - x + n, n);\r\
    \n            if(p == 0 || p == n) {\r\n                break;\r\n           \
    \ }\r\n            if(p != 1) {\r\n                return p;\r\n            }\r\
    \n            x = f(x);\r\n            y = f(f(y));\r\n        }\r\n    }\r\n\
    }\r\n}\r\nconstexpr inline bool miller(const uint64_t n) noexcept {\r\n    if(n\
    \ <= 1) {\r\n        return false;\r\n    }\r\n    if(n == 2) {\r\n        return\
    \ true;\r\n    }\r\n    if(n % 2 == 0) {\r\n        return false;\r\n    }\r\n\
    \    uint64_t d = n - 1;\r\n    while(d % 2 == 0) {\r\n        d /= 2;\r\n   \
    \ }\r\n    for(const uint a: {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37}) {\r\
    \n        if(n <= a) {\r\n            break;\r\n        }\r\n        uint64_t\
    \ t = d, y = internal::mod_pow(a, t, n);\r\n        while(t != n - 1 && y != 1\
    \ && y != n - 1) {\r\n            y = internal::mod_pow(y, 2, n);\r\n        \
    \    t <<= 1;\r\n        }\r\n        if(y != n - 1 && t % 2 == 0) {\r\n     \
    \       return false;\r\n        }\r\n    }\r\n    return true;\r\n}\r\ninline\
    \ std::vector<uint64_t> rho(const uint64_t n) noexcept {\r\n    if(n == 1) {\r\
    \n        return {};\r\n    }\r\n    const uint64_t x = internal::find(n);\r\n\
    \    if(x == n) {\r\n        return {x};\r\n    }\r\n    std::vector<uint64_t>\
    \ le = rho(x);\r\n    const std::vector<uint64_t> ri = rho(n / x);\r\n    le.insert(le.end(),\
    \ ri.begin(), ri.end());\r\n    return le;\r\n}\r\n}\r\n/**\r\n * @brief Pollard's\
    \ Rho\r\n * @docs docs/pollard_rho.md\r\n */\n#line 6 \"test/pf.test.cpp\"\nint\
    \ main() {\n    std::cin.tie(nullptr) -> sync_with_stdio(false);\n    int q;\n\
    \    std::cin >> q;\n    std::unordered_map<int64_t, std::vector<uint64_t>> m;\n\
    \    const auto solve = [&]{\n        int64_t n;\n        std::cin >> n;\n   \
    \     if(!m.contains(n)) {\n            auto p = man::rho(n);\n            std::ranges::sort(p);\n\
    \            m.try_emplace(n, p);\n        }\n        const auto ans = m[n];\n\
    \        std::cout << ans.size();\n        if(ans.size()) {\n            std::cout\
    \ << ' ' << ans.front();\n            for(size_t i = 0; ++i < ans.size();) {\n\
    \                std::cout << ' ' << ans[i];\n            }\n        }\n     \
    \   std::cout << '\\n';\n    };\n    while(q--) {\n        solve();\n    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/factorize\"\n#include <iostream>\n\
    #include <algorithm>\n#include <unordered_map>\n#include \"C++/math/pollard_rho.hpp\"\
    \nint main() {\n    std::cin.tie(nullptr) -> sync_with_stdio(false);\n    int\
    \ q;\n    std::cin >> q;\n    std::unordered_map<int64_t, std::vector<uint64_t>>\
    \ m;\n    const auto solve = [&]{\n        int64_t n;\n        std::cin >> n;\n\
    \        if(!m.contains(n)) {\n            auto p = man::rho(n);\n           \
    \ std::ranges::sort(p);\n            m.try_emplace(n, p);\n        }\n       \
    \ const auto ans = m[n];\n        std::cout << ans.size();\n        if(ans.size())\
    \ {\n            std::cout << ' ' << ans.front();\n            for(size_t i =\
    \ 0; ++i < ans.size();) {\n                std::cout << ' ' << ans[i];\n     \
    \       }\n        }\n        std::cout << '\\n';\n    };\n    while(q--) {\n\
    \        solve();\n    }\n}"
  dependsOn:
  - C++/math/pollard_rho.hpp
  isVerificationFile: true
  path: test/pf.test.cpp
  requiredBy: []
  timestamp: '2025-06-06 23:25:25+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/pf.test.cpp
layout: document
redirect_from:
- /verify/test/pf.test.cpp
- /verify/test/pf.test.cpp.html
title: test/pf.test.cpp
---
