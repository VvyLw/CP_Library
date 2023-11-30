---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/manacher.test.cpp
    title: test/manacher.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/rh.test.cpp
    title: test/rh.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/zalgo.test.cpp
    title: test/zalgo.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    links:
    - https://github.com/tatyam-prime/kyopro_library/blob/master/RollingHash.cpp)
  bundledCode: "#line 2 \"C++/Strings.hpp\"\n#include <cassert>\n#include <vector>\n\
    #include <algorithm>\n#include <chrono>\ntypedef long long ll;\ntypedef unsigned\
    \ long long ul;\ntypedef __uint128_t u128;\n\nstd::vector<int> manacher(std::string\
    \ s, const bool calc_even = true) {\n    int n = s.size();\n    if(calc_even)\
    \ {\n        assert(n > 0);\n        s.resize(2 * n - 1);\n        for(int i =\
    \ n; --i >= 0;) {\n            s[2 * i] = s[i];\n        }\n        const auto\
    \ d = *std::min_element(s.begin(), s.end());\n        for(int i = 0; i < n - 1;\
    \ ++i) {\n            s[2 * i + 1] = d;\n        }\n    }\n    n = s.size();\n\
    \    std::vector<int> rad(n);\n    for(int i = 0, j = 0; i < n;) {\n        while(i\
    \ - j >= 0 && i + j < n && s[i - j] == s[i + j]) {\n            ++j;\n       \
    \ }\n        rad[i] = j;\n        int k = 1;\n        while(i - k >= 0 && i +\
    \ k < n && k + rad[i - k] < j) {\n            rad[i + k] = rad[i - k];\n     \
    \       ++k;\n        }\n        i += k, j -= k;\n    }\n    if(calc_even) {\n\
    \        for(int i = 0; i < n; ++i) {\n            if(((i ^ rad[i]) & 1) == 0)\
    \ {\n                rad[i]--;\n            }\n        }\n    }\n    else {\n\
    \        for(auto &x: rad) x = 2 * x - 1;\n    }\n    return rad;\n}\n\nstd::vector<ll>\
    \ zalg(const std::string &s) {\n    const ll n = s.size();\n    ll j = 0;\n  \
    \  std::vector<ll> pre(n);\n    for(ll i = 1; i < n; ++i) {\n        if(i + pre[i\
    \ - j] < j + pre[j]) pre[i] = pre[i - j];\n        else {\n            ll k =\
    \ std::max(0LL, j + pre[j] - i);\n            while(i + k < n && s[k] == s[i +\
    \ k]) ++k;\n            pre[i] = k;\n            j = i;\n        }\n    }\n  \
    \  pre.front() = n;\n    return pre;\n}\n\n/*vector<ll> SA(const string &s) {\n\
    \    const ll n = s.size();\n    sort(s.begin(), s.end());\n}//*/\n\n// inspired\
    \ by tatyam(https://github.com/tatyam-prime/kyopro_library/blob/master/RollingHash.cpp)\n\
    const ul LINF = (1LL << 61) - 1, base = std::chrono::duration_cast<std::chrono::microseconds>(std::chrono::system_clock::now().time_since_epoch()).count()\
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
    \        return low;\n    }\n};\nusing RH = RollingHash<LINF>;\n"
  code: "#pragma once\n#include <cassert>\n#include <vector>\n#include <algorithm>\n\
    #include <chrono>\ntypedef long long ll;\ntypedef unsigned long long ul;\ntypedef\
    \ __uint128_t u128;\n\nstd::vector<int> manacher(std::string s, const bool calc_even\
    \ = true) {\n    int n = s.size();\n    if(calc_even) {\n        assert(n > 0);\n\
    \        s.resize(2 * n - 1);\n        for(int i = n; --i >= 0;) {\n         \
    \   s[2 * i] = s[i];\n        }\n        const auto d = *std::min_element(s.begin(),\
    \ s.end());\n        for(int i = 0; i < n - 1; ++i) {\n            s[2 * i + 1]\
    \ = d;\n        }\n    }\n    n = s.size();\n    std::vector<int> rad(n);\n  \
    \  for(int i = 0, j = 0; i < n;) {\n        while(i - j >= 0 && i + j < n && s[i\
    \ - j] == s[i + j]) {\n            ++j;\n        }\n        rad[i] = j;\n    \
    \    int k = 1;\n        while(i - k >= 0 && i + k < n && k + rad[i - k] < j)\
    \ {\n            rad[i + k] = rad[i - k];\n            ++k;\n        }\n     \
    \   i += k, j -= k;\n    }\n    if(calc_even) {\n        for(int i = 0; i < n;\
    \ ++i) {\n            if(((i ^ rad[i]) & 1) == 0) {\n                rad[i]--;\n\
    \            }\n        }\n    }\n    else {\n        for(auto &x: rad) x = 2\
    \ * x - 1;\n    }\n    return rad;\n}\n\nstd::vector<ll> zalg(const std::string\
    \ &s) {\n    const ll n = s.size();\n    ll j = 0;\n    std::vector<ll> pre(n);\n\
    \    for(ll i = 1; i < n; ++i) {\n        if(i + pre[i - j] < j + pre[j]) pre[i]\
    \ = pre[i - j];\n        else {\n            ll k = std::max(0LL, j + pre[j] -\
    \ i);\n            while(i + k < n && s[k] == s[i + k]) ++k;\n            pre[i]\
    \ = k;\n            j = i;\n        }\n    }\n    pre.front() = n;\n    return\
    \ pre;\n}\n\n/*vector<ll> SA(const string &s) {\n    const ll n = s.size();\n\
    \    sort(s.begin(), s.end());\n}//*/\n\n// inspired by tatyam(https://github.com/tatyam-prime/kyopro_library/blob/master/RollingHash.cpp)\n\
    const ul LINF = (1LL << 61) - 1, base = std::chrono::duration_cast<std::chrono::microseconds>(std::chrono::system_clock::now().time_since_epoch()).count()\
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
    \        return low;\n    }\n};\nusing RH = RollingHash<LINF>;"
  dependsOn: []
  isVerificationFile: false
  path: C++/Strings.hpp
  requiredBy: []
  timestamp: '2023-12-01 00:51:30+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/manacher.test.cpp
  - test/rh.test.cpp
  - test/zalgo.test.cpp
documentation_of: C++/Strings.hpp
layout: document
redirect_from:
- /library/C++/Strings.hpp
- /library/C++/Strings.hpp.html
title: C++/Strings.hpp
---
