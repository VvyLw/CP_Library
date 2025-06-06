---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/modprime.test.cpp
    title: test/modprime.test.cpp
  - icon: ':x:'
    path: test/modprime2.test.cpp
    title: test/modprime2.test.cpp
  _isVerificationFailed: true
  _pathExtension: hpp
  _verificationStatusIcon: ':question:'
  attributes:
    document_title: ModPrime
    links: []
  bundledCode: "#line 1 \"C++/math/ModPrime.hpp\"\n#include <iostream>\n#include <array>\n\
    #include <algorithm>\n#include <ranges>\n#ifndef TEMPLATE\nnamespace man {\ntemplate\
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
    \ */\n"
  code: "#include <iostream>\n#include <array>\n#include <algorithm>\n#include <ranges>\n\
    #ifndef TEMPLATE\nnamespace man {\ntemplate <class T> constexpr inline T sqr(const\
    \ T x) noexcept { return x * x; }\ntemplate <class T> constexpr inline T mod(T\
    \ x, const T m) noexcept {\n    x %= m;\n    return x < 0 ? x + m : x;\n}\n}\n\
    #endif\nnamespace man {\ntemplate <int lim> struct ModPrime {\nprivate:\n    const\
    \ int64_t m;\n\tstd::array<int64_t, lim> f{}, rf{};\n\tconst int len = std::min(m,\
    \ (int64_t) lim);\n    constexpr inline int64_t inv(int64_t x) noexcept {\n  \
    \      int64_t ret = 1, k = m - 2;\n\t\twhile(k > 0) {\n\t\t\tif(k & 1) {\n\t\t\
    \t\tret = mod(ret * x, m);\n\t\t\t}\n\t\t\tx = mod(sqr(x), m);\n\t\t\tk >>= 1;\n\
    \t\t}\n\t\treturn ret;\n    }\npublic:\n    ModPrime(const int64_t mod_): m(mod_)\
    \ {\n\t\tf[0] = 1;\n\t\tfor(const auto i: std::views::iota(1, len)) {\n\t\t\t\
    f[i] = mod(f[i - 1] * i, m);\n\t\t}\n\t\trf[len - 1] = inv(f[len - 1]);\n\t\t\
    for(const auto i: std::views::iota(1, len) | std::views::reverse) {\n\t\t\trf[i\
    \ - 1] = mod(rf[i] * i, m);\n\t\t}\n    }\n    constexpr inline int64_t C(const\
    \ int n, const int k) const noexcept {\n\t\tif(k < 0 || n < k) {\n\t\t\treturn\
    \ 0;\n\t\t}\n\t\tconst int64_t a = f[n], b = rf[n - k], c = rf[k], bc = mod(b\
    \ * c, m);\n\t\treturn mod(a * bc, m);\n\t}\n\tconstexpr inline int64_t P(const\
    \ int n, const int k) const noexcept {\n\t\tif(k < 0 || n < k) {\n\t\t\treturn\
    \ 0;\n\t\t}\n\t\tconst int64_t a = f[n], b = rf[n - k];\n\t\treturn mod(a * b,\
    \ m);\n\t}\n\tconstexpr inline int64_t H(const int n, const int k) const noexcept\
    \ {\n\t\tif(n == 0 && k == 0) {\n\t\t\treturn 1;\n\t\t}\n\t\treturn C(n + k -\
    \ 1, k);\n\t}\n};\n}\n/**\n * @brief ModPrime\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/ModPrime.hpp
  requiredBy: []
  timestamp: '2025-06-06 22:43:06+09:00'
  verificationStatus: LIBRARY_SOME_WA
  verifiedWith:
  - test/modprime2.test.cpp
  - test/modprime.test.cpp
documentation_of: C++/math/ModPrime.hpp
layout: document
redirect_from:
- /library/C++/math/ModPrime.hpp
- /library/C++/math/ModPrime.hpp.html
title: ModPrime
---
