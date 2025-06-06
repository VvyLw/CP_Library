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
    path: test/add128_2.test.cpp
    title: test/add128_2.test.cpp
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
    document_title: "\u5165\u529B"
    links: []
  bundledCode: "#line 2 \"C++/core/io/input.hpp\"\n\n#include <iostream>\n#include\
    \ <cassert>\n#include <array>\n#include <vector>\n#include <deque>\n#ifndef TEMPLATE\n\
    namespace man {\nconstexpr inline bool isdigit(const char c) noexcept { return\
    \ std::isdigit(c); }\ninline bool isdigit(const std::string &s) noexcept {\n \
    \   bool ok = true, neg = s.front() == '-';\n    for(const auto &el: s) {\n  \
    \      if(neg) {\n            neg = false;\n            continue;\n        }\n\
    \        ok &= isdigit(el);\n    }\n    return ok;\n}\n}\n#endif\nnamespace IO\
    \ {\ninline std::istream& operator>>(std::istream &is, __int128_t &val) noexcept\
    \ {\n    std::string s;\n    std::cin >> s;\n    assert(man::isdigit(s));\n  \
    \  bool neg = s.front() == '-';\n    val = 0;\n    for(const auto &el: s) {\n\
    \        if(neg) {\n            neg = false;\n            continue;\n        }\n\
    \        val = 10 * val + el - '0';\n    }\n    if(s.front()=='-') {\n       \
    \ val = -val;\n    }\n    return is;\n}\ntemplate <class T, class U> inline std::istream&\
    \ operator>>(std::istream &is, std::pair<T, U> &p) noexcept { is >> p.first >>\
    \ p.second; return is; }\ntemplate <class T, size_t N> inline std::istream& operator>>(std::istream\
    \ &is, std::array<T, N> &a) noexcept { for(auto &el: a){ is >> el; } return is;\
    \ }\ntemplate <class T> inline std::istream& operator>>(std::istream &is, std::vector<T>\
    \ &v) noexcept { for(auto &el: v){ is >> el; } return is; }\ntemplate <class T>\
    \ inline std::istream& operator>>(std::istream &is, std::deque<T> &dq) noexcept\
    \ { for(auto &el: dq){ is >> el; } return is; }\n} // IO\n\n/**\n * @brief \u5165\
    \u529B\n */\n"
  code: "#pragma once\n\n#include <iostream>\n#include <cassert>\n#include <array>\n\
    #include <vector>\n#include <deque>\n#ifndef TEMPLATE\nnamespace man {\nconstexpr\
    \ inline bool isdigit(const char c) noexcept { return std::isdigit(c); }\ninline\
    \ bool isdigit(const std::string &s) noexcept {\n    bool ok = true, neg = s.front()\
    \ == '-';\n    for(const auto &el: s) {\n        if(neg) {\n            neg =\
    \ false;\n            continue;\n        }\n        ok &= isdigit(el);\n    }\n\
    \    return ok;\n}\n}\n#endif\nnamespace IO {\ninline std::istream& operator>>(std::istream\
    \ &is, __int128_t &val) noexcept {\n    std::string s;\n    std::cin >> s;\n \
    \   assert(man::isdigit(s));\n    bool neg = s.front() == '-';\n    val = 0;\n\
    \    for(const auto &el: s) {\n        if(neg) {\n            neg = false;\n \
    \           continue;\n        }\n        val = 10 * val + el - '0';\n    }\n\
    \    if(s.front()=='-') {\n        val = -val;\n    }\n    return is;\n}\ntemplate\
    \ <class T, class U> inline std::istream& operator>>(std::istream &is, std::pair<T,\
    \ U> &p) noexcept { is >> p.first >> p.second; return is; }\ntemplate <class T,\
    \ size_t N> inline std::istream& operator>>(std::istream &is, std::array<T, N>\
    \ &a) noexcept { for(auto &el: a){ is >> el; } return is; }\ntemplate <class T>\
    \ inline std::istream& operator>>(std::istream &is, std::vector<T> &v) noexcept\
    \ { for(auto &el: v){ is >> el; } return is; }\ntemplate <class T> inline std::istream&\
    \ operator>>(std::istream &is, std::deque<T> &dq) noexcept { for(auto &el: dq){\
    \ is >> el; } return is; }\n} // IO\n\n/**\n * @brief \u5165\u529B\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/core/io/input.hpp
  requiredBy:
  - C++/template.hpp
  timestamp: '2025-06-06 22:43:06+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/aarray.test.cpp
  - test/m_add.test.cpp
  - test/sr_sum.test.cpp
  - test/uf.test.cpp
  - test/add128.test.cpp
  - test/parsum.test.cpp
  - test/add128_2.test.cpp
  - test/extgcd.test.cpp
  - test/stable.test.cpp
  - test/fwtree.test.cpp
  - test/segtree.test.cpp
  - test/add.test.cpp
  - test/s_rmq.test.cpp
documentation_of: C++/core/io/input.hpp
layout: document
redirect_from:
- /library/C++/core/io/input.hpp
- /library/C++/core/io/input.hpp.html
title: "\u5165\u529B"
---
