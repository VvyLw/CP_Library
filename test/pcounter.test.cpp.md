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
    #line 2 \"C++/math/kthrooti.hpp\"\n\n#include <cstdint>\n#include <limits>\n#include\
    \ <ranges>\n#ifndef TEMPLATE\nnamespace man {\ntemplate <class T, class U> constexpr\
    \ inline bool overflow_if_mul(const T a, const U b) noexcept { return (std::numeric_limits<T>::max()/a)<b;\
    \ }\n}\n#endif\nnamespace man {\ninline uint64_t kthrooti(const uint64_t n, const\
    \ int k) {\n    if(k == 1) {\n\t\treturn n;\n\t}\n\tconst auto chk = [&](const\
    \ unsigned x) -> bool {\n\t\tuint64_t mul = 1;\n\t\tfor([[maybe_unused]] const\
    \ auto _: std::views::iota(0, k)) {\n            if(man::overflow_if_mul(mul,\
    \ x)) {\n                return false;\n            }\n            mul *= x;\n\
    \        }\n\t\treturn mul <= n;\n\t};\n\tuint64_t ret = 0;\n\tfor(const auto\
    \ i: std::views::iota(0, 32) | std::views::reverse) {\n\t\tif(chk(ret | (1U <<\
    \ i))) {\n\t\t\tret |= 1U << i;\n\t\t}\n\t}\n\treturn ret;\n}\n}\n\n/**\n * @brief\
    \ k\u4E57\u6839(\u6574\u6570)\n */\n#line 2 \"C++/math/primetable.hpp\"\n\n#line\
    \ 5 \"C++/math/primetable.hpp\"\nnamespace man {\nstruct p_table {\n    std::vector<int>\
    \ SoE;\n    p_table(const int n): SoE(n + 1, 1) {\n        SoE[0] = SoE[1] = 0;\n\
    \        for(const int64_t i: std::views::iota(2, n + 1)) {\n            if(!SoE[i])\
    \ {\n                continue;\n            }\n            for(int64_t j = i *\
    \ i; j <= n; j += i) {\n                SoE[j] = 0;\n            }\n        }\n\
    \    }\n    std::vector<int> get() {\n        std::vector<int> p;\n        for(const\
    \ auto i: std::views::iota(2, std::ssize(SoE))) {\n            if(SoE[i]) {\n\
    \                p.emplace_back(i);\n            }\n        }\n        return\
    \ p;\n    }\n};\n}\n\n/**\n * @brief Sieve of Eratosthenes\n */\n#line 6 \"C++/math/primecounter.hpp\"\
    \n#ifndef TEMPLATE\nnamespace man {\ntemplate <class T> constexpr inline T sqr(const\
    \ T x) noexcept { return x * x; }\ntemplate <class T> constexpr inline T cub(const\
    \ T x) noexcept { return x * x * x; }\n}\n#endif\nnamespace man {\nstruct p_count\
    \ {\nprivate:\n    int64_t sq;\n    std::vector<int> prime;\n    std::vector<int64_t>\
    \ prime_sum, primes;\n    constexpr inline int64_t p2(const int64_t x, const int64_t\
    \ y) noexcept {\n        if(x < 4) {\n            return 0;\n        }\n     \
    \   const int64_t a = pi(y), b = pi(kthrooti(x, 2));\n        if(a >= b) {\n \
    \           return 0;\n        }\n        int64_t sum = (a - 2) * (a + 1) / 2\
    \ - (b - 2) * (b + 1) / 2;\n        for(const auto i: std::views::iota(a, b))\
    \ {\n            sum += pi(x / primes[i]);\n        }\n        return sum;\n \
    \   }\n    constexpr inline int64_t phi(const int64_t m, const int64_t n) noexcept\
    \ {\n        if(m < 1) {\n            return 0;\n        }\n        if(n > m)\
    \ {\n            return 1;\n        }\n        if(n < 1) {\n            return\
    \ m;\n        }\n        if(m <= sqr(primes[n - 1])) {\n            return pi(m)\
    \ - n + 1;\n        }\n        if(m <= cub(primes[n - 1]) && m <= sq) {\n    \
    \        const int64_t sx = pi(kthrooti(m, 2));\n            int64_t ans = pi(m)\
    \ - (sx + n - 2) * (sx - n + 1) / 2;\n            for(const auto i: std::views::iota(n,\
    \ sx)) {\n                ans += pi(m / primes[i]);\n            }\n         \
    \   return ans;\n        }\n        return phi(m, n - 1) - phi(m / primes[n -\
    \ 1], n - 1);\n    }\npublic:\n    p_count(const int64_t lim): sq(kthrooti(lim,\
    \ 2)), prime_sum(sq + 1) {\n        prime = p_table(sq).SoE;\n        for(const\
    \ auto i: std::views::iota(1) | std::views::take(sq)) {\n            prime_sum[i]\
    \ = prime_sum[i - 1] + prime[i];\n        }\n        primes.reserve(prime_sum[sq]);\n\
    \        for(const auto i: std::views::iota(1) | std::views::take(sq)) {\n   \
    \         if(prime[i]) {\n                primes.emplace_back(i);\n          \
    \  }\n        }\n    }\n    inline int64_t pi(const int64_t n) noexcept {\n  \
    \      if(n <= sq) {\n            return prime_sum[n];\n        }\n        const\
    \ int64_t m = kthrooti(n, 3);\n        const int64_t a = pi(m);\n        return\
    \ phi(n, a) + a - 1 - p2(n, m);\n    }\n};\n}\n\n/**\n * @brief \u7D20\u6570\u306E\
    \u500B\u6570\n */\n#line 4 \"test/pcounter.test.cpp\"\nint main() {\n    int64_t\
    \ n;\n    std::cin >> n;\n    std::cout << man::p_count(int64_t(1e11)).pi(n) <<\
    \ '\\n';\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/counting_primes\"\n#include\
    \ <iostream>\n#include \"C++/math/primecounter.hpp\"\nint main() {\n    int64_t\
    \ n;\n    std::cin >> n;\n    std::cout << man::p_count(int64_t(1e11)).pi(n) <<\
    \ '\\n';\n}"
  dependsOn:
  - C++/math/primecounter.hpp
  - C++/math/kthrooti.hpp
  - C++/math/primetable.hpp
  isVerificationFile: true
  path: test/pcounter.test.cpp
  requiredBy: []
  timestamp: '2025-06-06 23:25:25+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/pcounter.test.cpp
layout: document
redirect_from:
- /verify/test/pcounter.test.cpp
- /verify/test/pcounter.test.cpp.html
title: test/pcounter.test.cpp
---
