---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    links:
    - https://github.com/tatyam-prime/kyopro_library/blob/master/RollingHash.cpp)
  bundledCode: "#line 2 \"C++/Strings.hpp\"\n#include <vector>\n#include <algorithm>\n\
    #include <chrono>\nusing namespace std;\ntypedef long long ll;\ntypedef unsigned\
    \ long long ul;\ntypedef __uint128_t u128;\n\nvector<ll> manacher(const string\
    \ &s) {\n    const ll n = s.size();\n    vector<ll> rad(n);\n    ll i=0,j=0;\n\
    \    while(i < n) {\n        while(i - j >= 0 && i +j < n && s[i - j] == s[i +\
    \ j]) ++j;\n        rad[i] = j;\n        ll k = 1;\n        while(i- k >= 0 &&\
    \ i + k < n && k + rad[i - k] < j) {\n            rad[i + k] = rad[i - k];\n \
    \           ++k;\n        }\n        i += k;\n        j -= k;\n    }\n    return\
    \ rad;\n}\n\nvector<ll> zalg(const string &s) {\n    const ll n = s.size();\n\
    \    ll j = 0;\n    vector<ll> pre(n);\n    for(ll i = 1; i < n; ++i) {\n    \
    \    if(i + pre[i - j] < j + pre[j]) pre[i] = pre[i - j];\n        else {\n  \
    \          ll k = max(0LL, j + pre[j] - i);\n            while(i + k < n && s[k]\
    \ == s[i + k]) ++k;\n            pre[i] = k;\n            j = i;\n        }\n\
    \    }\n    pre.front() = n;\n    return pre;\n}\n\n/*vector<ll> SA(const string\
    \ &s) {\n    const ll n = s.size();\n    sort(s.begin(), s.end());\n}//*/\n\n\
    // inspired by tatyam(https://github.com/tatyam-prime/kyopro_library/blob/master/RollingHash.cpp)\n\
    const ul LINF = (1LL << 61) - 1, base = chrono::duration_cast<chrono::microseconds>(chrono::system_clock::now().time_since_epoch()).count()\
    \ % LINF;\ntemplate <ul mod> struct RollingHash {\n    vector<ul> hashed, power;\n\
    \    static constexpr ul mask(const ll a){ return (1ULL << a) - 1; }\n    inline\
    \ ul mul(const ul a, const ul b) const {\n        u128 ans = u128(a) * b;\n  \
    \      ans = (ans >> 61) + (ans & mod);\n        if(ans >= mod) ans -= mod;\n\
    \        return ans;\n    }\n    RollingHash(const string &s) {\n        const\
    \ ll n = s.size();\n        hashed.resize(n + 1);\n        power.resize(n + 1);\n\
    \        power[0] = 1;\n        for(ll i = 0; i < n; ++i) {\n            power[i\
    \ + 1] = mul(power[i], base);\n            hashed[i + 1] = mul(hashed[i], base)\
    \ + s[i];\n            if(hashed[i + 1] >= mod) hashed[i + 1] -= mod;\n      \
    \  }\n    }\n    ul get(const ll l, const ll r) const {\n        ul ret = hashed[r]\
    \ + mod - mul(hashed[l], power[r - l]);\n        if(ret >= mod) ret -= mod;\n\
    \        return ret;\n    }\n    ul connect(const ul h1, const ul h2, const ll\
    \ h2len) const {\n        ul ret = mul(h1, power[h2len]) + h2;\n        if(ret\
    \ >= mod) ret -= mod;\n        return ret;\n    }\n    void connect(const string\
    \ &s){\n        const ll n = hashed.size() - 1, m = s.size();\n        hashed.resize(n\
    \ + m + 1);\n        power.resize(n + m + 1);\n        for(ll i = n; i < n + m;\
    \ ++i) {\n            power[i + 1] = mul(power[i], base);\n            hashed[i\
    \ + 1] = mul(hashed[i], base) + s[i - n];\n            if(hashed[i + 1] >= mod)\
    \ hashed[i + 1] -= mod;\n        }\n    }\n    ll LCP(const RollingHash &b, ll\
    \ l1, ll r1, ll l2, ll r2) {\n        ll low = -1, high = min(r1 - l1, r2 - l2)\
    \ + 1;\n        while(high - low > 1) {\n            const ll mid = (low + high)\
    \ / 2;\n            if(get(l1, l1 + mid) == b.get(l2, l2 + mid)) low = mid;\n\
    \            else high = mid;\n        }\n        return low;\n    }\n};\nusing\
    \ RH = RollingHash<LINF>;\n"
  code: "#pragma once\n#include <vector>\n#include <algorithm>\n#include <chrono>\n\
    using namespace std;\ntypedef long long ll;\ntypedef unsigned long long ul;\n\
    typedef __uint128_t u128;\n\nvector<ll> manacher(const string &s) {\n    const\
    \ ll n = s.size();\n    vector<ll> rad(n);\n    ll i=0,j=0;\n    while(i < n)\
    \ {\n        while(i - j >= 0 && i +j < n && s[i - j] == s[i + j]) ++j;\n    \
    \    rad[i] = j;\n        ll k = 1;\n        while(i- k >= 0 && i + k < n && k\
    \ + rad[i - k] < j) {\n            rad[i + k] = rad[i - k];\n            ++k;\n\
    \        }\n        i += k;\n        j -= k;\n    }\n    return rad;\n}\n\nvector<ll>\
    \ zalg(const string &s) {\n    const ll n = s.size();\n    ll j = 0;\n    vector<ll>\
    \ pre(n);\n    for(ll i = 1; i < n; ++i) {\n        if(i + pre[i - j] < j + pre[j])\
    \ pre[i] = pre[i - j];\n        else {\n            ll k = max(0LL, j + pre[j]\
    \ - i);\n            while(i + k < n && s[k] == s[i + k]) ++k;\n            pre[i]\
    \ = k;\n            j = i;\n        }\n    }\n    pre.front() = n;\n    return\
    \ pre;\n}\n\n/*vector<ll> SA(const string &s) {\n    const ll n = s.size();\n\
    \    sort(s.begin(), s.end());\n}//*/\n\n// inspired by tatyam(https://github.com/tatyam-prime/kyopro_library/blob/master/RollingHash.cpp)\n\
    const ul LINF = (1LL << 61) - 1, base = chrono::duration_cast<chrono::microseconds>(chrono::system_clock::now().time_since_epoch()).count()\
    \ % LINF;\ntemplate <ul mod> struct RollingHash {\n    vector<ul> hashed, power;\n\
    \    static constexpr ul mask(const ll a){ return (1ULL << a) - 1; }\n    inline\
    \ ul mul(const ul a, const ul b) const {\n        u128 ans = u128(a) * b;\n  \
    \      ans = (ans >> 61) + (ans & mod);\n        if(ans >= mod) ans -= mod;\n\
    \        return ans;\n    }\n    RollingHash(const string &s) {\n        const\
    \ ll n = s.size();\n        hashed.resize(n + 1);\n        power.resize(n + 1);\n\
    \        power[0] = 1;\n        for(ll i = 0; i < n; ++i) {\n            power[i\
    \ + 1] = mul(power[i], base);\n            hashed[i + 1] = mul(hashed[i], base)\
    \ + s[i];\n            if(hashed[i + 1] >= mod) hashed[i + 1] -= mod;\n      \
    \  }\n    }\n    ul get(const ll l, const ll r) const {\n        ul ret = hashed[r]\
    \ + mod - mul(hashed[l], power[r - l]);\n        if(ret >= mod) ret -= mod;\n\
    \        return ret;\n    }\n    ul connect(const ul h1, const ul h2, const ll\
    \ h2len) const {\n        ul ret = mul(h1, power[h2len]) + h2;\n        if(ret\
    \ >= mod) ret -= mod;\n        return ret;\n    }\n    void connect(const string\
    \ &s){\n        const ll n = hashed.size() - 1, m = s.size();\n        hashed.resize(n\
    \ + m + 1);\n        power.resize(n + m + 1);\n        for(ll i = n; i < n + m;\
    \ ++i) {\n            power[i + 1] = mul(power[i], base);\n            hashed[i\
    \ + 1] = mul(hashed[i], base) + s[i - n];\n            if(hashed[i + 1] >= mod)\
    \ hashed[i + 1] -= mod;\n        }\n    }\n    ll LCP(const RollingHash &b, ll\
    \ l1, ll r1, ll l2, ll r2) {\n        ll low = -1, high = min(r1 - l1, r2 - l2)\
    \ + 1;\n        while(high - low > 1) {\n            const ll mid = (low + high)\
    \ / 2;\n            if(get(l1, l1 + mid) == b.get(l2, l2 + mid)) low = mid;\n\
    \            else high = mid;\n        }\n        return low;\n    }\n};\nusing\
    \ RH = RollingHash<LINF>;"
  dependsOn: []
  isVerificationFile: false
  path: C++/Strings.hpp
  requiredBy: []
  timestamp: '2023-10-28 18:32:30+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/Strings.hpp
layout: document
redirect_from:
- /library/C++/Strings.hpp
- /library/C++/Strings.hpp.html
title: C++/Strings.hpp
---
