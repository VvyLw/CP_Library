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
    #include <ranges>\nnamespace man {\n#ifndef ALIAS\nconstexpr int64_t LINF = (1LL\
    \ << 61) - 1;\n#endif\nconst uint64_t base = std::chrono::duration_cast<std::chrono::microseconds>(std::chrono::system_clock::now().time_since_epoch()).count()\
    \ % LINF;\ntemplate <uint64_t mod> struct RollingHash {\nprivate:\n    std::vector<uint64_t>\
    \ hashed, power;\n    static constexpr inline uint64_t mask(const int64_t a) noexcept\
    \ { return (1ULL << a) - 1; }\n    constexpr inline uint64_t mul(const uint64_t\
    \ a, const uint64_t b) const noexcept {\n        __uint128_t ans = __uint128_t(a)\
    \ * b;\n        ans = (ans >> 61) + (ans & mod);\n        if(ans >= mod) {\n \
    \           ans -= mod;\n        }\n        return ans;\n    }\npublic:\n    RollingHash(const\
    \ std::string &s) {\n        const int n = std::ssize(s);\n        hashed.resize(n\
    \ + 1);\n        power.resize(n + 1);\n        power[0] = 1;\n        for(const\
    \ auto i: std::views::iota(0, n)) {\n            power[i + 1] = mul(power[i],\
    \ base);\n            hashed[i + 1] = mul(hashed[i], base) + s[i];\n         \
    \   if(hashed[i + 1] >= mod) {\n                hashed[i + 1] -= mod;\n      \
    \      }\n        }\n    }\n    constexpr inline uint64_t get(const int64_t l,\
    \ const int64_t r) const noexcept {\n        uint64_t ret = hashed[r] + mod -\
    \ mul(hashed[l], power[r - l]);\n        if(ret >= mod) {\n            ret -=\
    \ mod;\n        }\n        return ret;\n    }\n    constexpr inline uint64_t connect(const\
    \ uint64_t h1, const uint64_t h2, const int64_t h2len) const noexcept {\n    \
    \    uint64_t ret = mul(h1, power[h2len]) + h2;\n        if(ret >= mod) {\n  \
    \          ret -= mod;\n        }\n        return ret;\n    }\n    constexpr inline\
    \ int64_t LCP(const RollingHash &b, int64_t l1, int64_t r1, int64_t l2, int64_t\
    \ r2) noexcept {\n        int64_t low = -1, high = std::min(r1 - l1, r2 - l2)\
    \ + 1;\n        while(high - low > 1) {\n            const int64_t mid = (low\
    \ + high) / 2;\n            if(get(l1, l1 + mid) == b.get(l2, l2 + mid)) {\n \
    \               low = mid;\n            } else {\n                high = mid;\n\
    \            }\n        }\n        return low;\n    }\n};\ntypedef RollingHash<LINF>\
    \ RH;\n}\n\n/**\n * @brief Rolling Hash\n * @see https://github.com/tatyam-prime/kyopro_library/blob/master/RollingHash.cpp\n\
    \ */\n"
  code: "#pragma once\n\n#include <vector>\n#include <chrono>\n#include <ranges>\n\
    namespace man {\n#ifndef ALIAS\nconstexpr int64_t LINF = (1LL << 61) - 1;\n#endif\n\
    const uint64_t base = std::chrono::duration_cast<std::chrono::microseconds>(std::chrono::system_clock::now().time_since_epoch()).count()\
    \ % LINF;\ntemplate <uint64_t mod> struct RollingHash {\nprivate:\n    std::vector<uint64_t>\
    \ hashed, power;\n    static constexpr inline uint64_t mask(const int64_t a) noexcept\
    \ { return (1ULL << a) - 1; }\n    constexpr inline uint64_t mul(const uint64_t\
    \ a, const uint64_t b) const noexcept {\n        __uint128_t ans = __uint128_t(a)\
    \ * b;\n        ans = (ans >> 61) + (ans & mod);\n        if(ans >= mod) {\n \
    \           ans -= mod;\n        }\n        return ans;\n    }\npublic:\n    RollingHash(const\
    \ std::string &s) {\n        const int n = std::ssize(s);\n        hashed.resize(n\
    \ + 1);\n        power.resize(n + 1);\n        power[0] = 1;\n        for(const\
    \ auto i: std::views::iota(0, n)) {\n            power[i + 1] = mul(power[i],\
    \ base);\n            hashed[i + 1] = mul(hashed[i], base) + s[i];\n         \
    \   if(hashed[i + 1] >= mod) {\n                hashed[i + 1] -= mod;\n      \
    \      }\n        }\n    }\n    constexpr inline uint64_t get(const int64_t l,\
    \ const int64_t r) const noexcept {\n        uint64_t ret = hashed[r] + mod -\
    \ mul(hashed[l], power[r - l]);\n        if(ret >= mod) {\n            ret -=\
    \ mod;\n        }\n        return ret;\n    }\n    constexpr inline uint64_t connect(const\
    \ uint64_t h1, const uint64_t h2, const int64_t h2len) const noexcept {\n    \
    \    uint64_t ret = mul(h1, power[h2len]) + h2;\n        if(ret >= mod) {\n  \
    \          ret -= mod;\n        }\n        return ret;\n    }\n    constexpr inline\
    \ int64_t LCP(const RollingHash &b, int64_t l1, int64_t r1, int64_t l2, int64_t\
    \ r2) noexcept {\n        int64_t low = -1, high = std::min(r1 - l1, r2 - l2)\
    \ + 1;\n        while(high - low > 1) {\n            const int64_t mid = (low\
    \ + high) / 2;\n            if(get(l1, l1 + mid) == b.get(l2, l2 + mid)) {\n \
    \               low = mid;\n            } else {\n                high = mid;\n\
    \            }\n        }\n        return low;\n    }\n};\ntypedef RollingHash<LINF>\
    \ RH;\n}\n\n/**\n * @brief Rolling Hash\n * @see https://github.com/tatyam-prime/kyopro_library/blob/master/RollingHash.cpp\n\
    \ */"
  dependsOn: []
  isVerificationFile: false
  path: C++/string/RH.hpp
  requiredBy: []
  timestamp: '2025-06-11 17:30:11+09:00'
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
