---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/rh.test.cpp
    title: test/rh.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: Rolling Hash
    links:
    - https://github.com/tatyam-prime/kyopro_library/blob/master/RollingHash.cpp
  bundledCode: "#line 2 \"C++/string/RH.hpp\"\n\n#include <vector>\n#include <chrono>\n\
    #include <ranges>\nnamespace man {\n#ifndef ALIAS\nconstexpr long long LINF =\
    \ (1LL << 61) - 1;\n#endif\nconst unsigned long long base = std::chrono::duration_cast<std::chrono::microseconds>(std::chrono::system_clock::now().time_since_epoch()).count()\
    \ % LINF;\ntemplate <unsigned long long mod> struct RollingHash {\nprivate:\n\
    \    std::vector<unsigned long long> hashed, power;\n    static constexpr inline\
    \ unsigned long long mask(const long long a) noexcept { return (1ULL << a) - 1;\
    \ }\n    constexpr inline unsigned long long mul(const unsigned long long a, const\
    \ unsigned long long b) const noexcept {\n        __uint128_t ans = __uint128_t(a)\
    \ * b;\n        ans = (ans >> 61) + (ans & mod);\n        if(ans >= mod) {\n \
    \           ans -= mod;\n        }\n        return ans;\n    }\npublic:\n    RollingHash(const\
    \ std::string &s) {\n        const int n = std::ssize(s);\n        hashed.resize(n\
    \ + 1);\n        power.resize(n + 1);\n        power[0] = 1;\n        for(const\
    \ auto i: std::views::iota(0, n)) {\n            power[i + 1] = mul(power[i],\
    \ base);\n            hashed[i + 1] = mul(hashed[i], base) + s[i];\n         \
    \   if(hashed[i + 1] >= mod) {\n                hashed[i + 1] -= mod;\n      \
    \      }\n        }\n    }\n    constexpr inline unsigned long long get(const\
    \ long long l, const long long r) const noexcept {\n        unsigned long long\
    \ ret = hashed[r] + mod - mul(hashed[l], power[r - l]);\n        if(ret >= mod)\
    \ {\n            ret -= mod;\n        }\n        return ret;\n    }\n    constexpr\
    \ inline unsigned long long connect(const unsigned long long h1, const unsigned\
    \ long long h2, const long long h2len) const noexcept {\n        unsigned long\
    \ long ret = mul(h1, power[h2len]) + h2;\n        if(ret >= mod) {\n         \
    \   ret -= mod;\n        }\n        return ret;\n    }\n    constexpr inline long\
    \ long LCP(const RollingHash &b, long long l1, long long r1, long long l2, long\
    \ long r2) noexcept {\n        long long low = -1, high = std::min(r1 - l1, r2\
    \ - l2) + 1;\n        while(high - low > 1) {\n            const long long mid\
    \ = (low + high) / 2;\n            if(get(l1, l1 + mid) == b.get(l2, l2 + mid))\
    \ {\n                low = mid;\n            } else {\n                high =\
    \ mid;\n            }\n        }\n        return low;\n    }\n};\ntypedef RollingHash<LINF>\
    \ RH;\n}\n\n/**\n * @brief Rolling Hash\n * @see https://github.com/tatyam-prime/kyopro_library/blob/master/RollingHash.cpp\n\
    \ */\n"
  code: "#pragma once\n\n#include <vector>\n#include <chrono>\n#include <ranges>\n\
    namespace man {\n#ifndef ALIAS\nconstexpr long long LINF = (1LL << 61) - 1;\n\
    #endif\nconst unsigned long long base = std::chrono::duration_cast<std::chrono::microseconds>(std::chrono::system_clock::now().time_since_epoch()).count()\
    \ % LINF;\ntemplate <unsigned long long mod> struct RollingHash {\nprivate:\n\
    \    std::vector<unsigned long long> hashed, power;\n    static constexpr inline\
    \ unsigned long long mask(const long long a) noexcept { return (1ULL << a) - 1;\
    \ }\n    constexpr inline unsigned long long mul(const unsigned long long a, const\
    \ unsigned long long b) const noexcept {\n        __uint128_t ans = __uint128_t(a)\
    \ * b;\n        ans = (ans >> 61) + (ans & mod);\n        if(ans >= mod) {\n \
    \           ans -= mod;\n        }\n        return ans;\n    }\npublic:\n    RollingHash(const\
    \ std::string &s) {\n        const int n = std::ssize(s);\n        hashed.resize(n\
    \ + 1);\n        power.resize(n + 1);\n        power[0] = 1;\n        for(const\
    \ auto i: std::views::iota(0, n)) {\n            power[i + 1] = mul(power[i],\
    \ base);\n            hashed[i + 1] = mul(hashed[i], base) + s[i];\n         \
    \   if(hashed[i + 1] >= mod) {\n                hashed[i + 1] -= mod;\n      \
    \      }\n        }\n    }\n    constexpr inline unsigned long long get(const\
    \ long long l, const long long r) const noexcept {\n        unsigned long long\
    \ ret = hashed[r] + mod - mul(hashed[l], power[r - l]);\n        if(ret >= mod)\
    \ {\n            ret -= mod;\n        }\n        return ret;\n    }\n    constexpr\
    \ inline unsigned long long connect(const unsigned long long h1, const unsigned\
    \ long long h2, const long long h2len) const noexcept {\n        unsigned long\
    \ long ret = mul(h1, power[h2len]) + h2;\n        if(ret >= mod) {\n         \
    \   ret -= mod;\n        }\n        return ret;\n    }\n    constexpr inline long\
    \ long LCP(const RollingHash &b, long long l1, long long r1, long long l2, long\
    \ long r2) noexcept {\n        long long low = -1, high = std::min(r1 - l1, r2\
    \ - l2) + 1;\n        while(high - low > 1) {\n            const long long mid\
    \ = (low + high) / 2;\n            if(get(l1, l1 + mid) == b.get(l2, l2 + mid))\
    \ {\n                low = mid;\n            } else {\n                high =\
    \ mid;\n            }\n        }\n        return low;\n    }\n};\ntypedef RollingHash<LINF>\
    \ RH;\n}\n\n/**\n * @brief Rolling Hash\n * @see https://github.com/tatyam-prime/kyopro_library/blob/master/RollingHash.cpp\n\
    \ */"
  dependsOn: []
  isVerificationFile: false
  path: C++/string/RH.hpp
  requiredBy: []
  timestamp: '2025-06-14 01:07:36+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/rh.test.cpp
documentation_of: C++/string/RH.hpp
layout: document
redirect_from:
- /library/C++/string/RH.hpp
- /library/C++/string/RH.hpp.html
title: Rolling Hash
---
