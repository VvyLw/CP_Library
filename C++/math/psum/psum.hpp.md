---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
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
    path: test/m_add.test.cpp
    title: test/m_add.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/parsum.test.cpp
    title: test/parsum.test.cpp
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
    document_title: "\u7D2F\u7A4D\u548C"
    links: []
  bundledCode: "#line 2 \"C++/math/psum/psum.hpp\"\n\n#include <vector>\n#include\
    \ <numeric>\nnamespace Heileden {\ntemplate <class T = int64_t> struct psum {\n\
    private:\n    int n;\n    bool not_built;\n    std::vector<int64_t> s;\npublic:\n\
    \    psum(const std::vector<T> &v): s{0} { std::partial_sum(v.cbegin(), v.cend(),\
    \ std::back_inserter(s)); }\n    psum(const int n): n(n), not_built(true), s(n\
    \ + 1){}\n    constexpr inline std::vector<int64_t> get() const noexcept { return\
    \ s; }\n    // [l, r]\n    constexpr inline int64_t sum(const int l, const int\
    \ r) const noexcept  { return s[r] - s[l]; }\n    constexpr inline void add(const\
    \ int l, const int r, const int64_t x = 1) noexcept {\n        static_assert(not_built);\n\
    \        s[l] += x;\n        s[r] -= x;\n    }\n    constexpr inline std::vector<int64_t>\
    \ build() noexcept {\n        static_assert(not_built);\n        std::vector<int64_t>\
    \ res;\n        std::partial_sum(s.cbegin(), s.cend(), std::back_inserter(res));\n\
    \        not_built = false;\n        res.resize(n);\n        return res;\n   \
    \ }\n};\n}\n\n/**\n * @brief \u7D2F\u7A4D\u548C\n */\n"
  code: "#pragma once\n\n#include <vector>\n#include <numeric>\nnamespace Heileden\
    \ {\ntemplate <class T = int64_t> struct psum {\nprivate:\n    int n;\n    bool\
    \ not_built;\n    std::vector<int64_t> s;\npublic:\n    psum(const std::vector<T>\
    \ &v): s{0} { std::partial_sum(v.cbegin(), v.cend(), std::back_inserter(s)); }\n\
    \    psum(const int n): n(n), not_built(true), s(n + 1){}\n    constexpr inline\
    \ std::vector<int64_t> get() const noexcept { return s; }\n    // [l, r]\n   \
    \ constexpr inline int64_t sum(const int l, const int r) const noexcept  { return\
    \ s[r] - s[l]; }\n    constexpr inline void add(const int l, const int r, const\
    \ int64_t x = 1) noexcept {\n        static_assert(not_built);\n        s[l] +=\
    \ x;\n        s[r] -= x;\n    }\n    constexpr inline std::vector<int64_t> build()\
    \ noexcept {\n        static_assert(not_built);\n        std::vector<int64_t>\
    \ res;\n        std::partial_sum(s.cbegin(), s.cend(), std::back_inserter(res));\n\
    \        not_built = false;\n        res.resize(n);\n        return res;\n   \
    \ }\n};\n}\n\n/**\n * @brief \u7D2F\u7A4D\u548C\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/psum/psum.hpp
  requiredBy:
  - C++/template.hpp
  timestamp: '2024-10-14 23:23:03+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/add128.test.cpp
  - test/parsum.test.cpp
  - test/uf.test.cpp
  - test/fwtree.test.cpp
  - test/add.test.cpp
  - test/s_rmq.test.cpp
  - test/stable.test.cpp
  - test/aarray.test.cpp
  - test/sr_sum.test.cpp
  - test/m_add.test.cpp
  - test/segtree.test.cpp
  - test/extgcd.test.cpp
documentation_of: C++/math/psum/psum.hpp
layout: document
redirect_from:
- /library/C++/math/psum/psum.hpp
- /library/C++/math/psum/psum.hpp.html
title: "\u7D2F\u7A4D\u548C"
---
