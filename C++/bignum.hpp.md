---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/add128_2.test.cpp
    title: test/add128_2.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    links:
    - https://kenkoooo.hatenablog.com/entry/2016/11/30/163533
  bundledCode: "#line 2 \"C++/bignum.hpp\"\n\r\n// inspired by kenkoooo( https://kenkoooo.hatenablog.com/entry/2016/11/30/163533\
    \ )\r\n#include <iostream>\r\ntypedef __int128_t i128;\r\ntypedef __uint128_t\
    \ u128;\r\nstd::ostream &operator<<(std::ostream &dest, i128 value) {\r\n    std::ostream::sentry\
    \ s(dest);\r\n    if(s) {\r\n        u128 tmp = value < 0 ? -value : value;\r\n\
    \        char buffer[128];\r\n        char *d = std::end(buffer);\r\n        do\
    \ {\r\n            --d;\r\n            *d = \"0123456789\"[tmp % 10];\r\n    \
    \        tmp /= 10;\r\n        } while(tmp);\r\n        if(value < 0) {\r\n  \
    \          --d;\r\n            *d = '-';\r\n        }\r\n        const int len\
    \ = std::end(buffer) - d;\r\n        if(dest.rdbuf()->sputn(d, len) != len) {\r\
    \n            dest.setstate(std::ios_base::badbit);\r\n        }\r\n    }\r\n\
    \    return dest;\r\n}\r\ninline i128 stoL(const std::string &s) {\r\n    i128\
    \ ret = 0;\r\n    for(const auto &el: s) {\r\n        if(isdigit(el)) ret = 10\
    \ * ret + el - '0';\r\n    }\r\n    if(s.front() == '-') ret = -ret;\r\n    return\
    \ ret;\r\n}\r\n"
  code: "#pragma once\r\n\r\n// inspired by kenkoooo( https://kenkoooo.hatenablog.com/entry/2016/11/30/163533\
    \ )\r\n#include <iostream>\r\ntypedef __int128_t i128;\r\ntypedef __uint128_t\
    \ u128;\r\nstd::ostream &operator<<(std::ostream &dest, i128 value) {\r\n    std::ostream::sentry\
    \ s(dest);\r\n    if(s) {\r\n        u128 tmp = value < 0 ? -value : value;\r\n\
    \        char buffer[128];\r\n        char *d = std::end(buffer);\r\n        do\
    \ {\r\n            --d;\r\n            *d = \"0123456789\"[tmp % 10];\r\n    \
    \        tmp /= 10;\r\n        } while(tmp);\r\n        if(value < 0) {\r\n  \
    \          --d;\r\n            *d = '-';\r\n        }\r\n        const int len\
    \ = std::end(buffer) - d;\r\n        if(dest.rdbuf()->sputn(d, len) != len) {\r\
    \n            dest.setstate(std::ios_base::badbit);\r\n        }\r\n    }\r\n\
    \    return dest;\r\n}\r\ninline i128 stoL(const std::string &s) {\r\n    i128\
    \ ret = 0;\r\n    for(const auto &el: s) {\r\n        if(isdigit(el)) ret = 10\
    \ * ret + el - '0';\r\n    }\r\n    if(s.front() == '-') ret = -ret;\r\n    return\
    \ ret;\r\n}\r\n"
  dependsOn: []
  isVerificationFile: false
  path: C++/bignum.hpp
  requiredBy: []
  timestamp: '2023-12-11 21:48:09+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/add128_2.test.cpp
documentation_of: C++/bignum.hpp
layout: document
redirect_from:
- /library/C++/bignum.hpp
- /library/C++/bignum.hpp.html
title: C++/bignum.hpp
---
