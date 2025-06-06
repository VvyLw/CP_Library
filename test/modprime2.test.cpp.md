---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/math/ModPrime.hpp
    title: ModPrime
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://yukicoder.me/problems/no/117
    links:
    - https://yukicoder.me/problems/no/117
  bundledCode: "#line 1 \"test/modprime2.test.cpp\"\n#define PROBLEM \"https://yukicoder.me/problems/no/117\"\
    \n#include <iostream>\n#line 2 \"C++/math/ModPrime.hpp\"\n#include <array>\n#include\
    \ <algorithm>\n#include <ranges>\n#ifndef TEMPLATE\nnamespace man {\ntemplate\
    \ <class T> constexpr inline T sqr(const T x) noexcept { return x * x; }\ntemplate\
    \ <class T> constexpr inline T mod(T x, const T m) noexcept {\n    x %= m;\n \
    \   return x < 0 ? x + m : x;\n}\n}\n#endif\nnamespace man {\ntemplate <int lim>\
    \ struct ModPrime {\nprivate:\n    const int64_t m;\n\tstd::array<int64_t, lim>\
    \ f{}, rf{};\n\tconst int len = std::min(m, (int64_t) lim);\n    constexpr inline\
    \ int64_t inv(int64_t x) noexcept {\n        int64_t ret = 1, k = m - 2;\n\t\t\
    while(k > 0) {\n\t\t\tif(k & 1) {\n\t\t\t\tret = mod(ret * x, m);\n\t\t\t}\n\t\
    \t\tx = mod(sqr(x), m);\n\t\t\tk >>= 1;\n\t\t}\n\t\treturn ret;\n    }\npublic:\n\
    \    ModPrime(const int64_t mod_): m(mod_) {\n\t\tf[0] = 1;\n\t\tfor(const auto\
    \ i: std::views::iota(1, len)) {\n\t\t\tf[i] = mod(f[i - 1] * i, m);\n\t\t}\n\t\
    \trf[len - 1] = inv(f[len - 1]);\n\t\tfor(const auto i: std::views::iota(1, len)\
    \ | std::views::reverse) {\n\t\t\trf[i - 1] = mod(rf[i] * i, m);\n\t\t}\n    }\n\
    \    constexpr inline int64_t C(const int n, const int k) const noexcept {\n\t\
    \tif(k < 0 || n < k) {\n\t\t\treturn 0;\n\t\t}\n\t\tconst int64_t a = f[n], b\
    \ = rf[n - k], c = rf[k], bc = mod(b * c, m);\n\t\treturn mod(a * bc, m);\n\t\
    }\n\tconstexpr inline int64_t P(const int n, const int k) const noexcept {\n\t\
    \tif(k < 0 || n < k) {\n\t\t\treturn 0;\n\t\t}\n\t\tconst int64_t a = f[n], b\
    \ = rf[n - k];\n\t\treturn mod(a * b, m);\n\t}\n\tconstexpr inline int64_t H(const\
    \ int n, const int k) const noexcept {\n\t\tif(n == 0 && k == 0) {\n\t\t\treturn\
    \ 1;\n\t\t}\n\t\treturn C(n + k - 1, k);\n\t}\n};\n}\n/**\n * @brief ModPrime\n\
    \ */\n#line 4 \"test/modprime2.test.cpp\"\nconstexpr int mod = 1e9 + 7;\nman::ModPrime<(int)\
    \ 2e7 + 1> mp(mod);\nint main() {\n    std::cin.tie(nullptr) -> sync_with_stdio(false);\n\
    \    int t;\n    std::cin >> t;\n    while(t--) {\n        char c, tmp;\n    \
    \    int n, k;\n        std::cin >> c >> tmp >> n >> tmp >> k >> tmp;\n      \
    \  std::cout << (c == 'C' ? mp.C(n, k) : c == 'P' ? mp.P(n, k) : mp.H(n, k)) <<\
    \ '\\n';\n    }\n}\n"
  code: "#define PROBLEM \"https://yukicoder.me/problems/no/117\"\n#include <iostream>\n\
    #include \"C++/math/ModPrime.hpp\"\nconstexpr int mod = 1e9 + 7;\nman::ModPrime<(int)\
    \ 2e7 + 1> mp(mod);\nint main() {\n    std::cin.tie(nullptr) -> sync_with_stdio(false);\n\
    \    int t;\n    std::cin >> t;\n    while(t--) {\n        char c, tmp;\n    \
    \    int n, k;\n        std::cin >> c >> tmp >> n >> tmp >> k >> tmp;\n      \
    \  std::cout << (c == 'C' ? mp.C(n, k) : c == 'P' ? mp.P(n, k) : mp.H(n, k)) <<\
    \ '\\n';\n    }\n}"
  dependsOn:
  - C++/math/ModPrime.hpp
  isVerificationFile: true
  path: test/modprime2.test.cpp
  requiredBy: []
  timestamp: '2025-06-06 22:43:22+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/modprime2.test.cpp
layout: document
redirect_from:
- /verify/test/modprime2.test.cpp
- /verify/test/modprime2.test.cpp.html
title: test/modprime2.test.cpp
---
