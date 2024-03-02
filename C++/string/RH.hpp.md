---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':x:'
    path: test/C++/rh.test.cpp
    title: test/C++/rh.test.cpp
  _isVerificationFailed: true
  _pathExtension: hpp
  _verificationStatusIcon: ':x:'
  attributes:
    document_title: Rolling Hash
    links:
    - https://github.com/tatyam-prime/kyopro_library/blob/master/RollingHash.cpp
  bundledCode: "#line 2 \"C++/string/RH.hpp\"\n\n#include <vector>\n#include <chrono>\n\
    #ifndef TEMPLATE\ntypedef long long ll;\ntypedef unsigned long long ul;\ntypedef\
    \ __uint128_t u128;\nconstexpr ul LINF = (1LL << 61) - 1;\n#endif\nconst ul base\
    \ = std::chrono::duration_cast<std::chrono::microseconds>(std::chrono::system_clock::now().time_since_epoch()).count()\
    \ % LINF;\ntemplate <ul mod> struct RollingHash {\nprivate:\n    std::vector<ul>\
    \ hashed, power;\n    static constexpr ul mask(const ll a){ return (1ULL << a)\
    \ - 1; }\n    inline ul mul(const ul a, const ul b) const {\n        u128 ans\
    \ = u128(a) * b;\n        ans = (ans >> 61) + (ans & mod);\n        if(ans >=\
    \ mod) ans -= mod;\n        return ans;\n    }\npublic:\n    RollingHash(const\
    \ std::string &s) {\n        const ll n = s.size();\n        hashed.resize(n +\
    \ 1);\n        power.resize(n + 1);\n        power[0] = 1;\n        for(ll i =\
    \ 0; i < n; ++i) {\n            power[i + 1] = mul(power[i], base);\n        \
    \    hashed[i + 1] = mul(hashed[i], base) + s[i];\n            if(hashed[i + 1]\
    \ >= mod) hashed[i + 1] -= mod;\n        }\n    }\n    ul get(const ll l, const\
    \ ll r) const {\n        ul ret = hashed[r] + mod - mul(hashed[l], power[r - l]);\n\
    \        if(ret >= mod) ret -= mod;\n        return ret;\n    }\n    ul connect(const\
    \ ul h1, const ul h2, const ll h2len) const {\n        ul ret = mul(h1, power[h2len])\
    \ + h2;\n        if(ret >= mod) ret -= mod;\n        return ret;\n    }\n    ll\
    \ LCP(const RollingHash &b, ll l1, ll r1, ll l2, ll r2) {\n        ll low = -1,\
    \ high = std::min(r1 - l1, r2 - l2) + 1;\n        while(high - low > 1) {\n  \
    \          const ll mid = (low + high) / 2;\n            if(get(l1, l1 + mid)\
    \ == b.get(l2, l2 + mid)) low = mid;\n            else high = mid;\n        }\n\
    \        return low;\n    }\n};\nusing RH = RollingHash<LINF>;\n\n/**\n * @brief\
    \ Rolling Hash\n * @see https://github.com/tatyam-prime/kyopro_library/blob/master/RollingHash.cpp\n\
    \ */\n"
  code: "#pragma once\n\n#include <vector>\n#include <chrono>\n#ifndef TEMPLATE\n\
    typedef long long ll;\ntypedef unsigned long long ul;\ntypedef __uint128_t u128;\n\
    constexpr ul LINF = (1LL << 61) - 1;\n#endif\nconst ul base = std::chrono::duration_cast<std::chrono::microseconds>(std::chrono::system_clock::now().time_since_epoch()).count()\
    \ % LINF;\ntemplate <ul mod> struct RollingHash {\nprivate:\n    std::vector<ul>\
    \ hashed, power;\n    static constexpr ul mask(const ll a){ return (1ULL << a)\
    \ - 1; }\n    inline ul mul(const ul a, const ul b) const {\n        u128 ans\
    \ = u128(a) * b;\n        ans = (ans >> 61) + (ans & mod);\n        if(ans >=\
    \ mod) ans -= mod;\n        return ans;\n    }\npublic:\n    RollingHash(const\
    \ std::string &s) {\n        const ll n = s.size();\n        hashed.resize(n +\
    \ 1);\n        power.resize(n + 1);\n        power[0] = 1;\n        for(ll i =\
    \ 0; i < n; ++i) {\n            power[i + 1] = mul(power[i], base);\n        \
    \    hashed[i + 1] = mul(hashed[i], base) + s[i];\n            if(hashed[i + 1]\
    \ >= mod) hashed[i + 1] -= mod;\n        }\n    }\n    ul get(const ll l, const\
    \ ll r) const {\n        ul ret = hashed[r] + mod - mul(hashed[l], power[r - l]);\n\
    \        if(ret >= mod) ret -= mod;\n        return ret;\n    }\n    ul connect(const\
    \ ul h1, const ul h2, const ll h2len) const {\n        ul ret = mul(h1, power[h2len])\
    \ + h2;\n        if(ret >= mod) ret -= mod;\n        return ret;\n    }\n    ll\
    \ LCP(const RollingHash &b, ll l1, ll r1, ll l2, ll r2) {\n        ll low = -1,\
    \ high = std::min(r1 - l1, r2 - l2) + 1;\n        while(high - low > 1) {\n  \
    \          const ll mid = (low + high) / 2;\n            if(get(l1, l1 + mid)\
    \ == b.get(l2, l2 + mid)) low = mid;\n            else high = mid;\n        }\n\
    \        return low;\n    }\n};\nusing RH = RollingHash<LINF>;\n\n/**\n * @brief\
    \ Rolling Hash\n * @see https://github.com/tatyam-prime/kyopro_library/blob/master/RollingHash.cpp\n\
    \ */"
  dependsOn: []
  isVerificationFile: false
  path: C++/string/RH.hpp
  requiredBy: []
  timestamp: '2024-02-19 12:20:55+09:00'
  verificationStatus: LIBRARY_ALL_WA
  verifiedWith:
  - test/C++/rh.test.cpp
documentation_of: C++/string/RH.hpp
layout: document
redirect_from:
- /library/C++/string/RH.hpp
- /library/C++/string/RH.hpp.html
title: Rolling Hash
---
