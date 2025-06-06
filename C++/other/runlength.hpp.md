---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    document_title: "\u30E9\u30F3\u30EC\u30F3\u30B0\u30B9\u5727\u7E2E"
    links: []
  bundledCode: "#line 2 \"C++/other/runlength.hpp\"\n\n#include <vector>\n#include\
    \ <type_traits>\n#include <ranges>\nnamespace man {\ntemplate <class T> requires\
    \ std::ranges::random_access_range<T> constexpr inline auto rle(const T& a) noexcept\
    \ {\n\tstd::vector<std::pair<std::decay_t<decltype(a.front())>, int>> ret;\n\t\
    for(const auto &e: a) {\n\t\tif(ret.empty() || ret.back().first != e) {\n\t\t\t\
    ret.emplace_back(e, 1);\n\t\t} else {\n\t\t\tret.back().second++;\n\t\t}\n\t}\n\
    \treturn ret;\n}\n\ntemplate <class T> constexpr inline auto rle_rev(const std::vector<std::pair<T,\
    \ int>> &a) noexcept {\n\tstd::vector<T> ret;\n\tfor(const auto &[f, s]: a) {\n\
    \t\tfor([[maybe_unused]] const auto _: std::views::iota(0, s)) {\n\t\t\tret.emplace_back(f);\n\
    \t\t}\n\t}\n\tif constexpr (std::is_same_v<T, char>) {\n\t\treturn std::string(ret.cbegin(),\
    \ ret.cend());\n\t} else {\n\t\treturn ret;\n\t}\n}\n}\n\n/**\n * @brief \u30E9\
    \u30F3\u30EC\u30F3\u30B0\u30B9\u5727\u7E2E\n */\n"
  code: "#pragma once\n\n#include <vector>\n#include <type_traits>\n#include <ranges>\n\
    namespace man {\ntemplate <class T> requires std::ranges::random_access_range<T>\
    \ constexpr inline auto rle(const T& a) noexcept {\n\tstd::vector<std::pair<std::decay_t<decltype(a.front())>,\
    \ int>> ret;\n\tfor(const auto &e: a) {\n\t\tif(ret.empty() || ret.back().first\
    \ != e) {\n\t\t\tret.emplace_back(e, 1);\n\t\t} else {\n\t\t\tret.back().second++;\n\
    \t\t}\n\t}\n\treturn ret;\n}\n\ntemplate <class T> constexpr inline auto rle_rev(const\
    \ std::vector<std::pair<T, int>> &a) noexcept {\n\tstd::vector<T> ret;\n\tfor(const\
    \ auto &[f, s]: a) {\n\t\tfor([[maybe_unused]] const auto _: std::views::iota(0,\
    \ s)) {\n\t\t\tret.emplace_back(f);\n\t\t}\n\t}\n\tif constexpr (std::is_same_v<T,\
    \ char>) {\n\t\treturn std::string(ret.cbegin(), ret.cend());\n\t} else {\n\t\t\
    return ret;\n\t}\n}\n}\n\n/**\n * @brief \u30E9\u30F3\u30EC\u30F3\u30B0\u30B9\u5727\
    \u7E2E\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/other/runlength.hpp
  requiredBy: []
  timestamp: '2025-06-06 22:43:06+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/other/runlength.hpp
layout: document
redirect_from:
- /library/C++/other/runlength.hpp
- /library/C++/other/runlength.hpp.html
title: "\u30E9\u30F3\u30EC\u30F3\u30B0\u30B9\u5727\u7E2E"
---
