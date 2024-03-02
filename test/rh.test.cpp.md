---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/string/RH.hpp
    title: Rolling Hash
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/14/ALDS1_14_B
    links:
    - https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/14/ALDS1_14_B
  bundledCode: "#line 1 \"test/rh.test.cpp\"\n#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/14/ALDS1_14_B\"\
    \n#include <iostream>\n#line 2 \"C++/string/RH.hpp\"\n\n#include <vector>\n#include\
    \ <chrono>\n#ifndef TEMPLATE\ntypedef long long ll;\ntypedef unsigned long long\
    \ ul;\ntypedef __uint128_t u128;\nconstexpr ul LINF = (1LL << 61) - 1;\n#endif\n\
    const ul base = std::chrono::duration_cast<std::chrono::microseconds>(std::chrono::system_clock::now().time_since_epoch()).count()\
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
    \ */\n#line 4 \"test/rh.test.cpp\"\nint main() {\n    std::string t, p;\n    std::cin\
    \ >> t >> p;\n    RH rh1(t), rh2(p);\n    for(size_t i = 0; i + p.size() <= t.size();\
    \ ++i) {\n        if(rh1.get(i, i + p.size()) == rh2.get(0, p.size())) {\n   \
    \         std::cout << i << '\\n';\n        }\n    }\n}\n"
  code: "#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/14/ALDS1_14_B\"\
    \n#include <iostream>\n#include \"C++/string/RH.hpp\"\nint main() {\n    std::string\
    \ t, p;\n    std::cin >> t >> p;\n    RH rh1(t), rh2(p);\n    for(size_t i = 0;\
    \ i + p.size() <= t.size(); ++i) {\n        if(rh1.get(i, i + p.size()) == rh2.get(0,\
    \ p.size())) {\n            std::cout << i << '\\n';\n        }\n    }\n}"
  dependsOn:
  - C++/string/RH.hpp
  isVerificationFile: true
  path: test/rh.test.cpp
  requiredBy: []
  timestamp: '2024-03-03 06:51:22+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/rh.test.cpp
layout: document
redirect_from:
- /verify/test/rh.test.cpp
- /verify/test/rh.test.cpp.html
title: test/rh.test.cpp
---
