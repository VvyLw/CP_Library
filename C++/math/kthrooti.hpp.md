---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
  - icon: ':heavy_check_mark:'
    path: C++/math/primecounter.hpp
    title: "\u7D20\u6570\u306E\u500B\u6570"
  - icon: ':heavy_check_mark:'
    path: C++/template.hpp
    title: "\u30C6\u30F3\u30D7\u30EC\u30FC\u30C8"
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/aarray.test.cpp
    title: test/aarray.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/add.test.cpp
    title: test/add.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/add128.test.cpp
    title: test/add128.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/extgcd.test.cpp
    title: test/extgcd.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/fwtree.test.cpp
    title: test/fwtree.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/kthrooti.test.cpp
    title: test/kthrooti.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/m_add.test.cpp
    title: test/m_add.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/parsum.test.cpp
    title: test/parsum.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/pcounter.test.cpp
    title: test/pcounter.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/s_rmq.test.cpp
    title: test/s_rmq.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/segtree.test.cpp
    title: test/segtree.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/sr_sum.test.cpp
    title: test/sr_sum.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/stable.test.cpp
    title: test/stable.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/uf.test.cpp
    title: test/uf.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: "k\u4E57\u6839(\u6574\u6570)"
    links: []
  bundledCode: "#line 2 \"C++/math/kthrooti.hpp\"\n\n#include <cstdint>\n#include\
    \ <limits>\n#include <ranges>\n#ifndef TEMPLATE\nnamespace man {\ntemplate <class\
    \ T, class U> constexpr inline bool overflow_if_mul(const T a, const U b) noexcept\
    \ { return (std::numeric_limits<T>::max()/a)<b; }\n}\n#endif\nnamespace man {\n\
    inline uint64_t kthrooti(const uint64_t n, const int k) {\n    if(k == 1) {\n\t\
    \treturn n;\n\t}\n\tconst auto chk = [&](const unsigned x) -> bool {\n\t\tuint64_t\
    \ mul = 1;\n\t\tfor([[maybe_unused]] const auto _: std::views::iota(0, k)) {\n\
    \            if(man::overflow_if_mul(mul, x)) {\n                return false;\n\
    \            }\n            mul *= x;\n        }\n\t\treturn mul <= n;\n\t};\n\
    \tuint64_t ret = 0;\n\tfor(const auto i: std::views::iota(0, 32) | std::views::reverse)\
    \ {\n\t\tif(chk(ret | (1U << i))) {\n\t\t\tret |= 1U << i;\n\t\t}\n\t}\n\treturn\
    \ ret;\n}\n}\n\n/**\n * @brief k\u4E57\u6839(\u6574\u6570)\n */\n"
  code: "#pragma once\n\n#include <cstdint>\n#include <limits>\n#include <ranges>\n\
    #ifndef TEMPLATE\nnamespace man {\ntemplate <class T, class U> constexpr inline\
    \ bool overflow_if_mul(const T a, const U b) noexcept { return (std::numeric_limits<T>::max()/a)<b;\
    \ }\n}\n#endif\nnamespace man {\ninline uint64_t kthrooti(const uint64_t n, const\
    \ int k) {\n    if(k == 1) {\n\t\treturn n;\n\t}\n\tconst auto chk = [&](const\
    \ unsigned x) -> bool {\n\t\tuint64_t mul = 1;\n\t\tfor([[maybe_unused]] const\
    \ auto _: std::views::iota(0, k)) {\n            if(man::overflow_if_mul(mul,\
    \ x)) {\n                return false;\n            }\n            mul *= x;\n\
    \        }\n\t\treturn mul <= n;\n\t};\n\tuint64_t ret = 0;\n\tfor(const auto\
    \ i: std::views::iota(0, 32) | std::views::reverse) {\n\t\tif(chk(ret | (1U <<\
    \ i))) {\n\t\t\tret |= 1U << i;\n\t\t}\n\t}\n\treturn ret;\n}\n}\n\n/**\n * @brief\
    \ k\u4E57\u6839(\u6574\u6570)\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/kthrooti.hpp
  requiredBy:
  - C++/template.hpp
  - C++/math/primecounter.hpp
  timestamp: '2025-06-06 23:25:25+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/aarray.test.cpp
  - test/kthrooti.test.cpp
  - test/m_add.test.cpp
  - test/sr_sum.test.cpp
  - test/uf.test.cpp
  - test/pcounter.test.cpp
  - test/add128.test.cpp
  - test/parsum.test.cpp
  - test/extgcd.test.cpp
  - test/stable.test.cpp
  - test/fwtree.test.cpp
  - test/segtree.test.cpp
  - test/add.test.cpp
  - test/s_rmq.test.cpp
documentation_of: C++/math/kthrooti.hpp
layout: document
redirect_from:
- /library/C++/math/kthrooti.hpp
- /library/C++/math/kthrooti.hpp.html
title: "k\u4E57\u6839(\u6574\u6570)"
---
