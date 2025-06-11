---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/sr_sum.test.cpp
    title: test/sr_sum.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: "\u7D2F\u7A4D\u548C"
    links: []
  bundledCode: "#line 2 \"C++/math/psum/psum.hpp\"\n\n#include <vector>\n#include\
    \ <numeric>\nnamespace man {\ntemplate <std::integral T> struct psum {\nprivate:\n\
    \    int n;\n    bool not_built;\n    std::vector<int64_t> s;\npublic:\n    psum(const\
    \ std::vector<T> &v): s{0} { std::partial_sum(v.cbegin(), v.cend(), std::back_inserter(s));\
    \ }\n    psum(const int n): n(n), not_built(true), s(n + 1){}\n    constexpr inline\
    \ std::vector<int64_t> get() const noexcept { return s; }\n    // [l, r]\n   \
    \ constexpr inline int64_t sum(const int l, const int r) const noexcept  { return\
    \ s[r] - s[l]; }\n    constexpr inline void add(const int l, const int r, const\
    \ int64_t x = 1) noexcept {\n        static_assert(not_built);\n        s[l] +=\
    \ x;\n        s[r] -= x;\n    }\n    constexpr inline std::vector<int64_t> build()\
    \ noexcept {\n        static_assert(not_built);\n        std::vector<int64_t>\
    \ res;\n        std::partial_sum(s.cbegin(), s.cend(), std::back_inserter(res));\n\
    \        not_built = false;\n        res.resize(n);\n        return res;\n   \
    \ }\n};\n}\n\n/**\n * @brief \u7D2F\u7A4D\u548C\n */\n"
  code: "#pragma once\n\n#include <vector>\n#include <numeric>\nnamespace man {\n\
    template <std::integral T> struct psum {\nprivate:\n    int n;\n    bool not_built;\n\
    \    std::vector<int64_t> s;\npublic:\n    psum(const std::vector<T> &v): s{0}\
    \ { std::partial_sum(v.cbegin(), v.cend(), std::back_inserter(s)); }\n    psum(const\
    \ int n): n(n), not_built(true), s(n + 1){}\n    constexpr inline std::vector<int64_t>\
    \ get() const noexcept { return s; }\n    // [l, r]\n    constexpr inline int64_t\
    \ sum(const int l, const int r) const noexcept  { return s[r] - s[l]; }\n    constexpr\
    \ inline void add(const int l, const int r, const int64_t x = 1) noexcept {\n\
    \        static_assert(not_built);\n        s[l] += x;\n        s[r] -= x;\n \
    \   }\n    constexpr inline std::vector<int64_t> build() noexcept {\n        static_assert(not_built);\n\
    \        std::vector<int64_t> res;\n        std::partial_sum(s.cbegin(), s.cend(),\
    \ std::back_inserter(res));\n        not_built = false;\n        res.resize(n);\n\
    \        return res;\n    }\n};\n}\n\n/**\n * @brief \u7D2F\u7A4D\u548C\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/psum/psum.hpp
  requiredBy: []
  timestamp: '2025-06-11 17:30:11+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/sr_sum.test.cpp
documentation_of: C++/math/psum/psum.hpp
layout: document
redirect_from:
- /library/C++/math/psum/psum.hpp
- /library/C++/math/psum/psum.hpp.html
title: "\u7D2F\u7A4D\u548C"
---
