---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/modprime.test.cpp
    title: test/modprime.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/modprime2.test.cpp
    title: test/modprime2.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: ModPrime
    links: []
  bundledCode: "#line 1 \"C++/math/ModPrime.hpp\"\n#include <iostream>\n#include <array>\n\
    #include <algorithm>\n#ifndef TEMPLATE\ntemplate <class T> inline T sqr(const\
    \ T x){ return x * x; }\ntemplate <class T> inline T Mod(T x, const T m) {\n \
    \   x %= m;\n    return x < 0 ? x + m : x;\n}\n#else\nusing namespace zia_qu;\n\
    #endif\ntemplate <int lim> struct ModPrime {\nprivate:\n    const int64_t mod;\n\
    \tstd::array<int64_t, lim> f{}, rf{};\n\tconst int len = std::min(mod, (int64_t)\
    \ lim);\n    int64_t inv(int64_t x) {\n        int64_t res = 1, k = mod - 2;\n\
    \t\twhile(k) {\n\t\t\tif(k & 1) {\n\t\t\t\tres = Mod(res * x, mod);\n\t\t\t}\n\
    \t\t\tx = Mod(sqr(x), mod);\n\t\t\tk >>= 1;\n\t\t}\n\t\treturn res;\n    }\npublic:\n\
    \    ModPrime(const int64_t mod_): mod(mod_) {\n\t\tf[0] = 1;\n\t\tfor(int i =\
    \ 0; ++i < len;) {\n\t\t\tf[i] = Mod(f[i - 1] * i, mod);\n\t\t}\n\t\trf[len -\
    \ 1] = inv(f[len - 1]);\n\t\tfor(int i = len; --i > 0;) {\n\t\t\trf[i - 1] = Mod(rf[i]\
    \ * i, mod);\n\t\t}\n    }\n    int64_t C(const int n, const int k) const {\n\t\
    \tif(k < 0 || n < k) {\n\t\t\treturn 0;\n\t\t}\n\t\tconst int64_t a = f[n], b\
    \ = rf[n - k], c = rf[k], bc = Mod(b * c, mod);\n\t\treturn Mod(a * bc, mod);\n\
    \t}\n\tint64_t P(const int n, const int k) const {\n\t\tif (k < 0 || n < k) {\n\
    \t\t\treturn 0;\n\t\t}\n\t\tconst int64_t a = f[n], b = rf[n - k];\n\t\treturn\
    \ Mod(a * b, mod);\n\t}\n\tint64_t H(const int n, const int k) const {\n\t\tif\
    \ (n == 0 && k == 0) {\n\t\t\treturn 1;\n\t\t}\n\t\treturn C(n + k - 1, k);\n\t\
    }\n};\n/**\n * @brief ModPrime\n */\n"
  code: "#include <iostream>\n#include <array>\n#include <algorithm>\n#ifndef TEMPLATE\n\
    template <class T> inline T sqr(const T x){ return x * x; }\ntemplate <class T>\
    \ inline T Mod(T x, const T m) {\n    x %= m;\n    return x < 0 ? x + m : x;\n\
    }\n#else\nusing namespace zia_qu;\n#endif\ntemplate <int lim> struct ModPrime\
    \ {\nprivate:\n    const int64_t mod;\n\tstd::array<int64_t, lim> f{}, rf{};\n\
    \tconst int len = std::min(mod, (int64_t) lim);\n    int64_t inv(int64_t x) {\n\
    \        int64_t res = 1, k = mod - 2;\n\t\twhile(k) {\n\t\t\tif(k & 1) {\n\t\t\
    \t\tres = Mod(res * x, mod);\n\t\t\t}\n\t\t\tx = Mod(sqr(x), mod);\n\t\t\tk >>=\
    \ 1;\n\t\t}\n\t\treturn res;\n    }\npublic:\n    ModPrime(const int64_t mod_):\
    \ mod(mod_) {\n\t\tf[0] = 1;\n\t\tfor(int i = 0; ++i < len;) {\n\t\t\tf[i] = Mod(f[i\
    \ - 1] * i, mod);\n\t\t}\n\t\trf[len - 1] = inv(f[len - 1]);\n\t\tfor(int i =\
    \ len; --i > 0;) {\n\t\t\trf[i - 1] = Mod(rf[i] * i, mod);\n\t\t}\n    }\n   \
    \ int64_t C(const int n, const int k) const {\n\t\tif(k < 0 || n < k) {\n\t\t\t\
    return 0;\n\t\t}\n\t\tconst int64_t a = f[n], b = rf[n - k], c = rf[k], bc = Mod(b\
    \ * c, mod);\n\t\treturn Mod(a * bc, mod);\n\t}\n\tint64_t P(const int n, const\
    \ int k) const {\n\t\tif (k < 0 || n < k) {\n\t\t\treturn 0;\n\t\t}\n\t\tconst\
    \ int64_t a = f[n], b = rf[n - k];\n\t\treturn Mod(a * b, mod);\n\t}\n\tint64_t\
    \ H(const int n, const int k) const {\n\t\tif (n == 0 && k == 0) {\n\t\t\treturn\
    \ 1;\n\t\t}\n\t\treturn C(n + k - 1, k);\n\t}\n};\n/**\n * @brief ModPrime\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/ModPrime.hpp
  requiredBy: []
  timestamp: '2024-02-19 12:20:55+09:00'
  verificationStatus: LIBRARY_ALL_AC
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
