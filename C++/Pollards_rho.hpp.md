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
    - https://atcoder.jp/contests/abc284/submissions/37807522)
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 312, in update\n    raise BundleErrorAt(path, i + 1, \"#pragma once found\
    \ in a non-first line\")\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt:\
    \ C++/Pollards_rho.hpp: line 2: #pragma once found in a non-first line\n"
  code: "// inspired by Plato_(https://atcoder.jp/contests/abc284/submissions/37807522)\r\
    \n#pragma once\r\n\r\n#include <vector>\r\n#include <algorithm>\r\n#include <numeric>\r\
    \ntypedef long long ll;\r\ntypedef unsigned long long ul;\r\nusing namespace std;\r\
    \nusing vu = vector<ul>;\r\nul modmul(ul a, ul b, ul M) {\r\n    ll ret = a *\
    \ b - M * ul(1.L / M * a * b);\r\n    return ret + M * (ret < 0) - M * (ret >=\
    \ (ll)M);\r\n}\r\nul modpow(ul b, ul e, ul mod) {\r\n    ul ans = 1;\r\n    for(;\
    \ e; b = modmul(b, b, mod), e /= 2)\r\n        if(e & 1) ans = modmul(ans, b,\
    \ mod);\r\n    return ans;\r\n}\r\nbool isp(ul n) {\r\n    if(n < 2 || n % 6 %\
    \ 4 != 1) return (n | 1) == 3;\r\n    ul A[] = {2, 325, 9375, 28178, 450775, 9780504,\
    \ 1795265022};\r\n    ul s = __builtin_ctzll(n - 1), d = n >> s;\r\n    for(auto\
    \ a: A) {\r\n        ul p = modpow(a % n, d, n), i = s;\r\n        while(p !=\
    \ 1 && p != n - 1 && a % n && i--) p = modmul(p, p, n);\r\n        if(p != n -\
    \ 1 && i != s) return 0;\r\n    }\r\n    return 1;\r\n}\r\nul pollard(ul n) {\r\
    \n    auto f = [n](ul x){ return modmul(x, x, n) + 1; };\r\n    ul x = 0, y(0),\
    \ t(30), prd(2), i(1), q;\r\n    while(t++ % 40 || gcd(prd, n) == 1) {\r\n   \
    \     if(x == y) x = ++i, y = f(x);\r\n        if((q = modmul(prd, max(x, y) -\
    \ min(x, y), n))) prd = q;\r\n        x = f(x), y = f(f(y));\r\n    }\r\n    return\
    \ gcd(prd, n);\r\n}\r\nvu rho(ul n) {\r\n    if(n == 1) return {};\r\n    if(isp(n))\
    \ return {n};\r\n    ll x = pollard(n);\r\n    auto l = rho(x), r = rho(n / x);\r\
    \n    l.insert(l.end(), r.begin(), r.end());\r\n    sort(l.begin(), l.end());\r\
    \n    return l;\r\n}\r\n"
  dependsOn: []
  isVerificationFile: false
  path: C++/Pollards_rho.hpp
  requiredBy: []
  timestamp: '2023-11-23 12:08:21+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/Pollards_rho.hpp
layout: document
redirect_from:
- /library/C++/Pollards_rho.hpp
- /library/C++/Pollards_rho.hpp.html
title: C++/Pollards_rho.hpp
---
