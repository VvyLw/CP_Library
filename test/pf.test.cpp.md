---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/math/Pollards_rho.hpp
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
    \n#include <iostream>\n#include <map>\n#line 2 \"C++/math/Pollards_rho.hpp\"\n\
    \r\n#include <vector>\r\n#include <algorithm>\r\n#include <numeric>\r\n#include\
    \ <functional>\r\ntypedef long long ll;\r\ntypedef unsigned long long ul;\r\n\
    typedef __int128_t i128;\r\nll gcd(const ll _a, const ll _b) {\r\n    ul a = std::abs(_a),\
    \ b = std::abs(_b);\r\n    if(a == 0) return b;\r\n    if(b == 0) return a;\r\n\
    \    const int shift = __builtin_ctzll(a | b);\r\n    a >>= __builtin_ctzll(a);\r\
    \n    do {\r\n        b >>= __builtin_ctzll(b);\r\n        if(a > b) std::swap(a,\
    \ b);\r\n        b -= a;\r\n    } while(b);\r\n    return a << shift;\r\n}\r\n\
    template <class T, class U> T pow_mod(T x, U n, T md) {\r\n    T r = 1 % md;\r\
    \n    x %= md;\r\n    while(n) {\r\n        if(n & 1) r = (r * x) % md;\r\n  \
    \      x = (x * x) % md;\r\n        n >>= 1;\r\n    }\r\n    return r;\r\n}\r\n\
    bool is_prime(const ll n) {\r\n    if(n <= 1) return false;\r\n    if(n == 2)\
    \ return true;\r\n    if(n % 2 == 0) return false;\r\n    ll d = n - 1;\r\n  \
    \  while(d % 2 == 0) d /= 2;\r\n    for(const ll a : {2, 3, 5, 7, 11, 13, 17,\
    \ 19, 23, 29, 31, 37}) {\r\n        if(n <= a) break;\r\n        ll t = d;\r\n\
    \        ll y = pow_mod<i128>(a, t, n);\r\n        while (t != n - 1 && y != 1\
    \ && y != n - 1) {\r\n            y = i128(y) * y % n;\r\n            t <<= 1;\r\
    \n        }\r\n        if (y != n - 1 && t % 2 == 0) {\r\n            return false;\r\
    \n        }\r\n    }\r\n    return true;\r\n}\r\nll find(const ll n) {\r\n   \
    \ if(is_prime(n)) return n;\r\n    if(n % 2 == 0) return 2;\r\n    int st = 0;\r\
    \n    const std::function<ll(ll)> f = [&](const ll x){ return (i128(x) * x + st)\
    \ % n; };\r\n    while(true) {\r\n        st++;\r\n        ll x = st, y = f(x);\r\
    \n        while (true) {\r\n            ll p = gcd((y - x + n), n);\r\n      \
    \      if(p == 0 || p == n) break;\r\n            if(p != 1) return p;\r\n   \
    \         x = f(x);\r\n            y = f(f(y));\r\n        }\r\n    }\r\n}\r\n\
    \r\nstd::vector<ll> rho(const ll n) {\r\n    if(n == 1) return {};\r\n    const\
    \ ll x = find(n);\r\n    if(x == n) return {x};\r\n    std::vector<ll> le = rho(x);\r\
    \n    const std::vector<ll> ri = rho(n / x);\r\n    le.insert(le.end(), ri.begin(),\
    \ ri.end());\r\n    return le;\r\n}\r\n/**\r\n * @brief Pollard's Rho\r\n * @docs\
    \ docs/Pollards_rho.md\r\n */\n#line 5 \"test/pf.test.cpp\"\nint main() {\n  \
    \  std::cin.tie(nullptr) -> sync_with_stdio(false);\n    int q;\n    std::cin\
    \ >> q;\n    std::map<ll, std::vector<ll>> m;\n    const auto solve = [&]{\n \
    \       ll n;\n        std::cin >> n;\n        if(m.find(n) == m.end()) {\n  \
    \          auto p = rho(n);\n            std::sort(p.begin(), p.end());\n    \
    \        m.try_emplace(n, p);\n        }\n        const auto ans = m[n];\n   \
    \     std::cout << ans.size();\n        if(ans.size()) {\n            std::cout\
    \ << ' ' << ans.front();\n            for(auto i = ans.begin(); ++i != ans.end();)\
    \ {\n                std::cout << ' ' << *i;\n            }\n        }\n     \
    \   std::cout << '\\n';\n    };\n    while(q--) {\n        solve();\n    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/factorize\"\n#include <iostream>\n\
    #include <map>\n#include \"C++/math/Pollards_rho.hpp\"\nint main() {\n    std::cin.tie(nullptr)\
    \ -> sync_with_stdio(false);\n    int q;\n    std::cin >> q;\n    std::map<ll,\
    \ std::vector<ll>> m;\n    const auto solve = [&]{\n        ll n;\n        std::cin\
    \ >> n;\n        if(m.find(n) == m.end()) {\n            auto p = rho(n);\n  \
    \          std::sort(p.begin(), p.end());\n            m.try_emplace(n, p);\n\
    \        }\n        const auto ans = m[n];\n        std::cout << ans.size();\n\
    \        if(ans.size()) {\n            std::cout << ' ' << ans.front();\n    \
    \        for(auto i = ans.begin(); ++i != ans.end();) {\n                std::cout\
    \ << ' ' << *i;\n            }\n        }\n        std::cout << '\\n';\n    };\n\
    \    while(q--) {\n        solve();\n    }\n}"
  dependsOn:
  - C++/math/Pollards_rho.hpp
  isVerificationFile: true
  path: test/pf.test.cpp
  requiredBy: []
  timestamp: '2024-02-19 12:58:12+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/pf.test.cpp
layout: document
redirect_from:
- /verify/test/pf.test.cpp
- /verify/test/pf.test.cpp.html
title: test/pf.test.cpp
---
