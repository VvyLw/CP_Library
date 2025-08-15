---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
  - icon: ':heavy_check_mark:'
    path: C++/math/primecounter.hpp
    title: "\u7D20\u6570\u306E\u500B\u6570"
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/kthrooti.test.cpp
    title: test/kthrooti.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/pcounter.test.cpp
    title: test/pcounter.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: "k\u4E57\u6839(\u6574\u6570)"
    links: []
  bundledCode: "#line 2 \"C++/math/kthrooti.hpp\"\n\n#include <cstdint>\n#include\
    \ <limits>\n#include <ranges>\n#ifndef TEMPLATE\nnamespace man {\ntemplate <std::integral\
    \ T, std::integral U> constexpr inline bool overflow_if_mul(const T a, const U\
    \ b) noexcept { return (std::numeric_limits<T>::max()/a)<b; }\n}\n#endif\nnamespace\
    \ man {\ninline unsigned long long kthrooti(const unsigned long long n, const\
    \ int k) {\n    if(k == 1) {\n\t\treturn n;\n\t}\n\tconst auto chk = [&](const\
    \ unsigned x) -> bool {\n\t\tunsigned long long mul = 1;\n\t\tfor([[maybe_unused]]\
    \ const auto _: std::views::iota(0, k)) {\n            if(man::overflow_if_mul(mul,\
    \ x)) {\n                return false;\n            }\n            mul *= x;\n\
    \        }\n\t\treturn mul <= n;\n\t};\n\tunsigned long long ret = 0;\n\tfor(const\
    \ auto i: std::views::iota(0, 32) | std::views::reverse) {\n\t\tif(chk(ret | (1U\
    \ << i))) {\n\t\t\tret |= 1U << i;\n\t\t}\n\t}\n\treturn ret;\n}\n}\n\n/**\n *\
    \ @brief k\u4E57\u6839(\u6574\u6570)\n */\n"
  code: "#pragma once\n\n#include <cstdint>\n#include <limits>\n#include <ranges>\n\
    #ifndef TEMPLATE\nnamespace man {\ntemplate <std::integral T, std::integral U>\
    \ constexpr inline bool overflow_if_mul(const T a, const U b) noexcept { return\
    \ (std::numeric_limits<T>::max()/a)<b; }\n}\n#endif\nnamespace man {\ninline unsigned\
    \ long long kthrooti(const unsigned long long n, const int k) {\n    if(k == 1)\
    \ {\n\t\treturn n;\n\t}\n\tconst auto chk = [&](const unsigned x) -> bool {\n\t\
    \tunsigned long long mul = 1;\n\t\tfor([[maybe_unused]] const auto _: std::views::iota(0,\
    \ k)) {\n            if(man::overflow_if_mul(mul, x)) {\n                return\
    \ false;\n            }\n            mul *= x;\n        }\n\t\treturn mul <= n;\n\
    \t};\n\tunsigned long long ret = 0;\n\tfor(const auto i: std::views::iota(0, 32)\
    \ | std::views::reverse) {\n\t\tif(chk(ret | (1U << i))) {\n\t\t\tret |= 1U <<\
    \ i;\n\t\t}\n\t}\n\treturn ret;\n}\n}\n\n/**\n * @brief k\u4E57\u6839(\u6574\u6570\
    )\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/kthrooti.hpp
  requiredBy:
  - C++/math/primecounter.hpp
  timestamp: '2025-06-14 01:07:36+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/pcounter.test.cpp
  - test/kthrooti.test.cpp
documentation_of: C++/math/kthrooti.hpp
layout: document
redirect_from:
- /library/C++/math/kthrooti.hpp
- /library/C++/math/kthrooti.hpp.html
title: "k\u4E57\u6839(\u6574\u6570)"
---
