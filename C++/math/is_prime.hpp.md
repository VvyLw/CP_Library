---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    links: []
  bundledCode: "#line 2 \"C++/math/is_prime.hpp\"\n#include <cstdint>\n\nnamespace\
    \ man {\nconstexpr inline bool is_prime(const uint64_t n) noexcept {\n\tif(n <=\
    \ 1) {\n\t\treturn false;\n\t}\n\tif(n <= 3) {\n\t\treturn true;\n\t}\n\tif(n\
    \ % 2 ==0 || n % 3 == 0) {\n\t\treturn false;\n\t}\n\tfor(int64_t i = 5; i * i\
    \ <= n; i += 6) {\n\t\tif(n % i == 0 || n % (i + 2) == 0) {\n\t\t\treturn false;\n\
    \t\t}\n\t}\n\treturn true;\n}\n}\n"
  code: "#pragma once\n#include <cstdint>\n\nnamespace man {\nconstexpr inline bool\
    \ is_prime(const uint64_t n) noexcept {\n\tif(n <= 1) {\n\t\treturn false;\n\t\
    }\n\tif(n <= 3) {\n\t\treturn true;\n\t}\n\tif(n % 2 ==0 || n % 3 == 0) {\n\t\t\
    return false;\n\t}\n\tfor(int64_t i = 5; i * i <= n; i += 6) {\n\t\tif(n % i ==\
    \ 0 || n % (i + 2) == 0) {\n\t\t\treturn false;\n\t\t}\n\t}\n\treturn true;\n\
    }\n}"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/is_prime.hpp
  requiredBy: []
  timestamp: '2025-06-06 22:43:06+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/math/is_prime.hpp
layout: document
redirect_from:
- /library/C++/math/is_prime.hpp
- /library/C++/math/is_prime.hpp.html
title: C++/math/is_prime.hpp
---
