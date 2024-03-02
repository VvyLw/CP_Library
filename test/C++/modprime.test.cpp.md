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
    PROBLEM: https://judge.yosupo.jp/problem/binomial_coefficient_prime_mod
    links:
    - https://judge.yosupo.jp/problem/binomial_coefficient_prime_mod
  bundledCode: "#line 1 \"test/C++/modprime.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/binomial_coefficient_prime_mod\"\
    \n#include <iostream>\n#line 2 \"C++/math/ModPrime.hpp\"\n#include <array>\n#include\
    \ <algorithm>\n#ifndef TEMPLATE\ntemplate <class T> inline T sqr(const T x){ return\
    \ x * x; }\ntemplate <class T> inline T Mod(T x, const T m) {\n    x %= m;\n \
    \   return x < 0 ? x + m : x;\n}\n#else\nusing namespace zia_qu;\n#endif\ntemplate\
    \ <int lim> struct ModPrime {\nprivate:\n    const int64_t mod;\n\tstd::array<int64_t,\
    \ lim> f{}, rf{};\n\tconst int len = std::min(mod, (int64_t) lim);\n    int64_t\
    \ inv(int64_t x) {\n        int64_t res = 1, k = mod - 2;\n\t\twhile(k) {\n\t\t\
    \tif(k & 1) {\n\t\t\t\tres = Mod(res * x, mod);\n\t\t\t}\n\t\t\tx = Mod(sqr(x),\
    \ mod);\n\t\t\tk >>= 1;\n\t\t}\n\t\treturn res;\n    }\npublic:\n    ModPrime(const\
    \ int64_t mod_): mod(mod_) {\n\t\tf[0] = 1;\n\t\tfor(int i = 0; ++i < len;) {\n\
    \t\t\tf[i] = Mod(f[i - 1] * i, mod);\n\t\t}\n\t\trf[len - 1] = inv(f[len - 1]);\n\
    \t\tfor(int i = len; --i > 0;) {\n\t\t\trf[i - 1] = Mod(rf[i] * i, mod);\n\t\t\
    }\n    }\n    int64_t C(const int n, const int k) const {\n\t\tif(k < 0 || n <\
    \ k) {\n\t\t\treturn 0;\n\t\t}\n\t\tconst int64_t a = f[n], b = rf[n - k], c =\
    \ rf[k], bc = Mod(b * c, mod);\n\t\treturn Mod(a * bc, mod);\n\t}\n\tint64_t P(const\
    \ int n, const int k) const {\n\t\tif (k < 0 || n < k) {\n\t\t\treturn 0;\n\t\t\
    }\n\t\tconst int64_t a = f[n], b = rf[n - k];\n\t\treturn Mod(a * b, mod);\n\t\
    }\n\tint64_t H(const int n, const int k) const {\n\t\tif (n == 0 && k == 0) {\n\
    \t\t\treturn 1;\n\t\t}\n\t\treturn C(n + k - 1, k);\n\t}\n};\n/**\n * @brief ModPrime\n\
    \ */\n#line 4 \"test/C++/modprime.test.cpp\"\nint main() {\n    std::cin.tie(nullptr)\
    \ -> sync_with_stdio(false);\n    int t, m;\n    std::cin >> t >> m;\n    ModPrime<(int)\
    \ 1e7> mp(m);\n    while(t--) {\n        int n, k;\n        std::cin >> n >> k;\n\
    \        std::cout << mp.C(n, k) << '\\n';\n    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/binomial_coefficient_prime_mod\"\
    \n#include <iostream>\n#include \"C++/math/ModPrime.hpp\"\nint main() {\n    std::cin.tie(nullptr)\
    \ -> sync_with_stdio(false);\n    int t, m;\n    std::cin >> t >> m;\n    ModPrime<(int)\
    \ 1e7> mp(m);\n    while(t--) {\n        int n, k;\n        std::cin >> n >> k;\n\
    \        std::cout << mp.C(n, k) << '\\n';\n    }\n}"
  dependsOn:
  - C++/math/ModPrime.hpp
  isVerificationFile: true
  path: test/C++/modprime.test.cpp
  requiredBy: []
  timestamp: '2024-03-03 06:22:53+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/C++/modprime.test.cpp
layout: document
redirect_from:
- /verify/test/C++/modprime.test.cpp
- /verify/test/C++/modprime.test.cpp.html
title: test/C++/modprime.test.cpp
---
