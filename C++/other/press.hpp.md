---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    document_title: "\u5EA7\u6A19\u5727\u7E2E"
    links: []
  bundledCode: "#line 2 \"C++/other/press.hpp\"\n#include <vector>\n#include <concepts>\n\
    \nnamespace man {\ntemplate <std::integral T> inline std::vector<T> press(const\
    \ std::vector<T> &v) noexcept {\n\tstd::vector<T> ret, cp = v;\n\tuniq(cp);\n\t\
    for(const auto &el: v) {\n\t\tret.emplace_back(std::ranges::lower_bound(cp, el)\
    \ - cp.cbegin());\n\t}\n\treturn ret;\n}\ntemplate <std::integral T> inline std::vector<T>\
    \ press(std::vector<T> &c1, std::vector<T> &c2) {\n\tstd::vector<T> ret;\n\tconst\
    \ int n = std::ssize(c1);\n\tfor(const auto i: std::views::iota(0, n)) {\n\t\t\
    ret.emplace_back(c1[i]);\n\t\tret.emplace_back(c2[i]);\n\t}\n\tuniq(ret);\n\t\
    for(const auto i: std::views::iota(0, n)) {\n\t\tc1[i] = std::ranges::lower_bound(ret,\
    \ c1[i]) - ret.cbegin();\n\t\tc2[i] = std::ranges::lower_bound(ret, c2[i]) - ret.cbegin();\n\
    \t}\n\treturn ret;\n}\n}\n/**\n * @brief \u5EA7\u6A19\u5727\u7E2E\n */\n"
  code: "#pragma once\n#include <vector>\n#include <concepts>\n\nnamespace man {\n\
    template <std::integral T> inline std::vector<T> press(const std::vector<T> &v)\
    \ noexcept {\n\tstd::vector<T> ret, cp = v;\n\tuniq(cp);\n\tfor(const auto &el:\
    \ v) {\n\t\tret.emplace_back(std::ranges::lower_bound(cp, el) - cp.cbegin());\n\
    \t}\n\treturn ret;\n}\ntemplate <std::integral T> inline std::vector<T> press(std::vector<T>\
    \ &c1, std::vector<T> &c2) {\n\tstd::vector<T> ret;\n\tconst int n = std::ssize(c1);\n\
    \tfor(const auto i: std::views::iota(0, n)) {\n\t\tret.emplace_back(c1[i]);\n\t\
    \tret.emplace_back(c2[i]);\n\t}\n\tuniq(ret);\n\tfor(const auto i: std::views::iota(0,\
    \ n)) {\n\t\tc1[i] = std::ranges::lower_bound(ret, c1[i]) - ret.cbegin();\n\t\t\
    c2[i] = std::ranges::lower_bound(ret, c2[i]) - ret.cbegin();\n\t}\n\treturn ret;\n\
    }\n}\n/**\n * @brief \u5EA7\u6A19\u5727\u7E2E\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/other/press.hpp
  requiredBy: []
  timestamp: '2025-06-11 17:30:11+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/other/press.hpp
layout: document
redirect_from:
- /library/C++/other/press.hpp
- /library/C++/other/press.hpp.html
title: "\u5EA7\u6A19\u5727\u7E2E"
---
