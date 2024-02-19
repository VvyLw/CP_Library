---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    document_title: "\u7D20\u6570\u306E\u500B\u6570"
    links: []
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 401, in update\n    self.update(self._resolve(pathlib.Path(included), included_from=path))\n\
    \  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 260, in _resolve\n    raise BundleErrorAt(path, -1, \"no such header\"\
    )\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt: math/kthrooti.hpp:\
    \ line -1: no such header\n"
  code: "#pragma once\n\n#include <vector>\n#include \"math/kthrooti.hpp\"\n#include\
    \ \"math/primetable.hpp\"\n#ifndef TEMPLATE\ntypedef long long ll;\nnamespace\
    \ zia_qu {\ntemplate <class T> inline T sqr(const T x){ return x*x; }\ntemplate\
    \ <class T> inline T cub(const T x){ return x*x*x; }\n}\n#endif\nstruct p_count\
    \ {\nprivate:\n    ll sq;\n    std::vector<bool> prime;\n    std::vector<ll> prime_sum,\
    \ primes;\n    ll p2(const ll x, const ll y) {\n        if(x < 4) {\n        \
    \    return 0;\n        }\n        const ll a = pi(y), b = pi(Heileden::kthrooti(x,\
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
    \            }\n        }\n    }\n\n    ll pi(const ll n) {\n        if(n <= sq)\
    \ {\n            return prime_sum[n];\n        }\n        const ll m = Heileden::kthrooti(n,\
    \ 3);\n        const ll a = pi(m);\n        return phi(n, a) + a - 1 - p2(n, m);\n\
    \    }\n};\n\n/**\n * @brief \u7D20\u6570\u306E\u500B\u6570\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/primecounter.hpp
  requiredBy: []
  timestamp: '1970-01-01 00:00:00+00:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/math/primecounter.hpp
layout: document
redirect_from:
- /library/C++/math/primecounter.hpp
- /library/C++/math/primecounter.hpp.html
title: "\u7D20\u6570\u306E\u500B\u6570"
---
