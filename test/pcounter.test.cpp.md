---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/math/kthrooti.hpp
    title: "k\u4E57\u6839(\u6574\u6570)"
  - icon: ':heavy_check_mark:'
    path: C++/math/primecounter.hpp
    title: "\u7D20\u6570\u306E\u500B\u6570"
  - icon: ':heavy_check_mark:'
    path: C++/math/primetable.hpp
    title: Sieve of Eratosthenes
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://judge.yosupo.jp/problem/counting_primes
    links:
    - https://judge.yosupo.jp/problem/counting_primes
  bundledCode: "#line 1 \"test/pcounter.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/counting_primes\"\
    \n#include <iostream>\n#line 2 \"C++/math/primecounter.hpp\"\n\n#include <vector>\n\
    #line 2 \"C++/math/kthrooti.hpp\"\n\n#include <limits>\n#ifndef TEMPLATE\ntypedef\
    \ unsigned long long ul;\ntemplate <class T, class U> inline bool overflow_if_mul(const\
    \ T a, const U b){ return (std::numeric_limits<T>::max()/a)<b; }\n#endif\nnamespace\
    \ Heileden {\ninline ul kthrooti(const ul n, const int k) {\n    if(k==1) {\n\t\
    \treturn n;\n\t}\n\tconst auto chk=[&](const unsigned x) {\n\t\tul mul=1;\n\t\t\
    for(int i = 0; i < k; ++i) {\n            if(overflow_if_mul(mul, x)) {\n    \
    \            return false;\n            }\n            mul*=x;\n        }\n\t\t\
    return mul<=n;\n\t};\n\tul ret=0;\n\tfor(int i = 32; --i >= 0;) {\n\t\tif(chk(ret|(1U<<i)))\
    \ {\n\t\t\tret|=1U<<i;\n\t\t}\n\t}\n\treturn ret;\n}\n}\n\n/**\n * @brief k\u4E57\
    \u6839(\u6574\u6570)\n */\n#line 2 \"C++/math/primetable.hpp\"\n\n#line 4 \"C++/math/primetable.hpp\"\
    \nnamespace Heileden {\nstruct p_table {\n    std::vector<int> SoE;\n    p_table(const\
    \ int n): SoE(n + 1, 1) {\n        SoE[0] = SoE[1] = 0;\n        for(int64_t i\
    \ = 2; i <= n; ++i) {\n            if(!SoE[i]) {\n                continue;\n\
    \            }\n            for(int64_t j = i * i; j <= n; j += i) {\n       \
    \         SoE[j] = 0;\n            }\n        }\n    }\n    std::vector<int> get()\
    \ {\n        std::vector<int> p;\n        for(size_t i = 2; i < SoE.size(); ++i)\
    \ {\n            if(SoE[i]) {\n                p.emplace_back(i);\n          \
    \  }\n        }\n        return p;\n    }\n};\n}\n\n/**\n * @brief Sieve of Eratosthenes\n\
    \ */\n#line 6 \"C++/math/primecounter.hpp\"\n#ifndef TEMPLATE\ntypedef long long\
    \ ll;\nnamespace zia_qu {\ntemplate <class T> inline T sqr(const T x){ return\
    \ x*x; }\ntemplate <class T> inline T cub(const T x){ return x*x*x; }\n}\n#endif\n\
    struct p_count {\nprivate:\n    ll sq;\n    std::vector<int> prime;\n    std::vector<ll>\
    \ prime_sum, primes;\n    ll p2(const ll x, const ll y) {\n        if(x < 4) {\n\
    \            return 0;\n        }\n        const ll a = pi(y), b = pi(Heileden::kthrooti(x,\
    \ 2));\n        if(a >= b) {\n            return 0;\n        }\n        ll sum\
    \ = (a - 2) * (a + 1) / 2 - (b - 2) * (b + 1) / 2;\n        for(ll i = a; i <\
    \ b; ++i) {\n            sum += pi(x / primes[i]);\n        }\n        return\
    \ sum;\n    }\n    ll phi(const ll m, const ll n) {\n        if(m < 1) {\n   \
    \         return 0;\n        }\n        if(n > m) {\n            return 1;\n \
    \       }\n        if(n < 1) {\n            return m;\n        }\n        if(m\
    \ <= zia_qu::sqr(primes[n - 1])) {\n            return pi(m) - n + 1;\n      \
    \  }\n        if(m <= zia_qu::cub(primes[n - 1]) && m <= sq) {\n            const\
    \ ll sx = pi(Heileden::kthrooti(m, 2));\n            ll ans = pi(m) - (sx + n\
    \ - 2) * (sx - n + 1) / 2;\n            for(ll i = n; i < sx; ++i) {\n       \
    \         ans += pi(m / primes[i]);\n            }\n            return ans;\n\
    \        }\n        return phi(m, n - 1) - phi(m / primes[n - 1], n - 1);\n  \
    \  }\npublic:\n    p_count(const ll lim): sq(Heileden::kthrooti(lim, 2)), prime_sum(sq\
    \ + 1) {\n        prime = Heileden::p_table(sq).SoE;\n        for(int i = 1; i\
    \ <= sq; ++i) {\n            prime_sum[i] = prime_sum[i - 1] + prime[i];\n   \
    \     }\n        primes.reserve(prime_sum[sq]);\n        for(int i = 1; i <= sq;\
    \ ++i) {\n            if(prime[i]) {\n                primes.emplace_back(i);\n\
    \            }\n        }\n    }\n    ll pi(const ll n) {\n        if(n <= sq)\
    \ {\n            return prime_sum[n];\n        }\n        const ll m = Heileden::kthrooti(n,\
    \ 3);\n        const ll a = pi(m);\n        return phi(n, a) + a - 1 - p2(n, m);\n\
    \    }\n};\n\n/**\n * @brief \u7D20\u6570\u306E\u500B\u6570\n */\n#line 4 \"test/pcounter.test.cpp\"\
    \nint main() {\n    ll n;\n    std::cin >> n;\n    std::cout << p_count(ll(1e11)).pi(n)\
    \ << '\\n';\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/counting_primes\"\n#include\
    \ <iostream>\n#include \"C++/math/primecounter.hpp\"\nint main() {\n    ll n;\n\
    \    std::cin >> n;\n    std::cout << p_count(ll(1e11)).pi(n) << '\\n';\n}"
  dependsOn:
  - C++/math/primecounter.hpp
  - C++/math/kthrooti.hpp
  - C++/math/primetable.hpp
  isVerificationFile: true
  path: test/pcounter.test.cpp
  requiredBy: []
  timestamp: '2024-03-29 03:01:20+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/pcounter.test.cpp
layout: document
redirect_from:
- /verify/test/pcounter.test.cpp
- /verify/test/pcounter.test.cpp.html
title: test/pcounter.test.cpp
---
