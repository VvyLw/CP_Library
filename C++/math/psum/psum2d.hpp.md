---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':x:'
    path: test/psum2d.test.cpp
    title: test/psum2d.test.cpp
  _isVerificationFailed: true
  _pathExtension: hpp
  _verificationStatusIcon: ':x:'
  attributes:
    document_title: "\u4E8C\u6B21\u5143\u7D2F\u7A4D\u548C"
    links: []
  bundledCode: "#line 2 \"C++/math/psum/psum2d.hpp\"\n\n#include <vector>\n#include\
    \ <ranges>\nnamespace man {\ntemplate <class T> struct psum2d {\nprivate:\n  \
    \  int h, w;\n    std::vector<std::vector<T>> data;\npublic:\n    psum2d(const\
    \ int h, const int w): h(h + 3), w(w + 3), data(h + 3, std::vector<T>(w + 3)){}\n\
    \    psum2d(const std::vector<std::vector<T>> &v): h(std::ssize(v) + 3), w(std::ssize(v.front())\
    \ + 3), data(std::ssize(v) + 3, std::vector<T>(std::ssize(v.front()) + 3)) {\n\
    \        for(const auto i: std::views::iota(0, std::ssize(v))) {\n           \
    \ for(const auto j: std::views::iota(0, std::ssize(v[i]))) {\n               \
    \ add(i, j, v[i][j]);\n            }\n        }\n    }\n    constexpr inline void\
    \ add(int i, int j, const T &x) noexcept {\n\t\ti++;\n\t\tj++;\n\t\tif(i >= h\
    \ || j >= w) {\n\t\t\treturn;\n\t\t}\n\t\tdata[i][j] += x;\n\t}\n    constexpr\
    \ inline void add(const int i1, const int j1, const int i2, const int j2, const\
    \ T &x) noexcept {\n\t\tadd(i1, j1, x);\n\t\tadd(i1, j2, -x);\n\t\tadd(i2, j1,\
    \ -x);\n\t\tadd(i2, j2, x);\n\t}\n    constexpr inline void build() noexcept {\n\
    \t\tfor(const auto i: std::views::iota(1, h)) {\n\t\t\tfor(const auto j: std::views::iota(1,\
    \ w)) {\n\t\t\t\tdata[i][j] += data[i][j - 1] + data[i - 1][j] - data[i - 1][j\
    \ - 1];\n\t\t\t}\n\t\t}\n\t}\n    constexpr inline T get(const int i1, const int\
    \ j1, const int i2, const int j2) const noexcept { return data[i2][j2] - data[i1][j2]\
    \ - data[i2][j1] + data[i1][j1]; }\n    constexpr inline T get(const int i, const\
    \ int j) const noexcept { return data[i + 1][j + 1]; }\n};\n}\n\n/**\n * @brief\
    \ \u4E8C\u6B21\u5143\u7D2F\u7A4D\u548C\n */\n"
  code: "#pragma once\n\n#include <vector>\n#include <ranges>\nnamespace man {\ntemplate\
    \ <class T> struct psum2d {\nprivate:\n    int h, w;\n    std::vector<std::vector<T>>\
    \ data;\npublic:\n    psum2d(const int h, const int w): h(h + 3), w(w + 3), data(h\
    \ + 3, std::vector<T>(w + 3)){}\n    psum2d(const std::vector<std::vector<T>>\
    \ &v): h(std::ssize(v) + 3), w(std::ssize(v.front()) + 3), data(std::ssize(v)\
    \ + 3, std::vector<T>(std::ssize(v.front()) + 3)) {\n        for(const auto i:\
    \ std::views::iota(0, std::ssize(v))) {\n            for(const auto j: std::views::iota(0,\
    \ std::ssize(v[i]))) {\n                add(i, j, v[i][j]);\n            }\n \
    \       }\n    }\n    constexpr inline void add(int i, int j, const T &x) noexcept\
    \ {\n\t\ti++;\n\t\tj++;\n\t\tif(i >= h || j >= w) {\n\t\t\treturn;\n\t\t}\n\t\t\
    data[i][j] += x;\n\t}\n    constexpr inline void add(const int i1, const int j1,\
    \ const int i2, const int j2, const T &x) noexcept {\n\t\tadd(i1, j1, x);\n\t\t\
    add(i1, j2, -x);\n\t\tadd(i2, j1, -x);\n\t\tadd(i2, j2, x);\n\t}\n    constexpr\
    \ inline void build() noexcept {\n\t\tfor(const auto i: std::views::iota(1, h))\
    \ {\n\t\t\tfor(const auto j: std::views::iota(1, w)) {\n\t\t\t\tdata[i][j] +=\
    \ data[i][j - 1] + data[i - 1][j] - data[i - 1][j - 1];\n\t\t\t}\n\t\t}\n\t}\n\
    \    constexpr inline T get(const int i1, const int j1, const int i2, const int\
    \ j2) const noexcept { return data[i2][j2] - data[i1][j2] - data[i2][j1] + data[i1][j1];\
    \ }\n    constexpr inline T get(const int i, const int j) const noexcept { return\
    \ data[i + 1][j + 1]; }\n};\n}\n\n/**\n * @brief \u4E8C\u6B21\u5143\u7D2F\u7A4D\
    \u548C\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/psum/psum2d.hpp
  requiredBy: []
  timestamp: '2025-06-06 22:43:06+09:00'
  verificationStatus: LIBRARY_ALL_WA
  verifiedWith:
  - test/psum2d.test.cpp
documentation_of: C++/math/psum/psum2d.hpp
layout: document
redirect_from:
- /library/C++/math/psum/psum2d.hpp
- /library/C++/math/psum/psum2d.hpp.html
title: "\u4E8C\u6B21\u5143\u7D2F\u7A4D\u548C"
---
