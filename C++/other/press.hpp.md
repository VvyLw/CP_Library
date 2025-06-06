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
    document_title: "\u5EA7\u6A19\u5727\u7E2E"
    links: []
  bundledCode: "#line 2 \"C++/other/press.hpp\"\n#include <vector>\n\nnamespace man\
    \ {\ntemplate <class T> inline std::vector<T> press(const std::vector<T> &v) noexcept\
    \ {\n\tstd::vector<T> ret, cp = v;\n\tuniq(cp);\n\tfor(const auto &el: v) {\n\t\
    \tret.emplace_back(std::ranges::lower_bound(cp, el) - cp.cbegin());\n\t}\n\treturn\
    \ ret;\n}\ntemplate <class T> inline std::vector<T> press(std::vector<T> &c1,\
    \ std::vector<T> &c2) {\n\tstd::vector<T> ret;\n\tconst int n = c1.size();\n\t\
    for(const auto i: std::views::iota(0, n)) {\n\t\tfor(const auto d: std::views::iota(0,\
    \ 1)) {\n\t\t\tT tc1 = c1[i] + d;\n\t\t\tT tc2 = c2[i] + d;\n\t\t\tret.emplace_back(tc1);\n\
    \t\t\tret.emplace_back(tc2);\n\t\t}\n\t}\n\tuniq(ret);\n\tfor(const auto i: std::views::iota(0,\
    \ n)) {\n\t\tc1[i] = std::ranges::lower_bound(ret, c1[i]) - ret.cbegin();\n\t\t\
    c2[i] = std::ranges::lower_bound(ret, c2[i]) - ret.cbegin();\n\t}\n\treturn ret;\n\
    }\n}\n/**\n * @brief \u5EA7\u6A19\u5727\u7E2E\n */\n"
  code: "#pragma once\n#include <vector>\n\nnamespace man {\ntemplate <class T> inline\
    \ std::vector<T> press(const std::vector<T> &v) noexcept {\n\tstd::vector<T> ret,\
    \ cp = v;\n\tuniq(cp);\n\tfor(const auto &el: v) {\n\t\tret.emplace_back(std::ranges::lower_bound(cp,\
    \ el) - cp.cbegin());\n\t}\n\treturn ret;\n}\ntemplate <class T> inline std::vector<T>\
    \ press(std::vector<T> &c1, std::vector<T> &c2) {\n\tstd::vector<T> ret;\n\tconst\
    \ int n = c1.size();\n\tfor(const auto i: std::views::iota(0, n)) {\n\t\tfor(const\
    \ auto d: std::views::iota(0, 1)) {\n\t\t\tT tc1 = c1[i] + d;\n\t\t\tT tc2 = c2[i]\
    \ + d;\n\t\t\tret.emplace_back(tc1);\n\t\t\tret.emplace_back(tc2);\n\t\t}\n\t\
    }\n\tuniq(ret);\n\tfor(const auto i: std::views::iota(0, n)) {\n\t\tc1[i] = std::ranges::lower_bound(ret,\
    \ c1[i]) - ret.cbegin();\n\t\tc2[i] = std::ranges::lower_bound(ret, c2[i]) - ret.cbegin();\n\
    \t}\n\treturn ret;\n}\n}\n/**\n * @brief \u5EA7\u6A19\u5727\u7E2E\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/other/press.hpp
  requiredBy:
  - C++/template.hpp
  timestamp: '2025-06-06 22:58:51+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/aarray.test.cpp
  - test/m_add.test.cpp
  - test/sr_sum.test.cpp
  - test/uf.test.cpp
  - test/add128.test.cpp
  - test/parsum.test.cpp
  - test/extgcd.test.cpp
  - test/stable.test.cpp
  - test/fwtree.test.cpp
  - test/segtree.test.cpp
  - test/add.test.cpp
  - test/s_rmq.test.cpp
documentation_of: C++/other/press.hpp
layout: document
redirect_from:
- /library/C++/other/press.hpp
- /library/C++/other/press.hpp.html
title: "\u5EA7\u6A19\u5727\u7E2E"
---
