---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/math/psum/psum2d.hpp
    title: "\u4E8C\u6B21\u5143\u7D2F\u7A4D\u548C"
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://onlinejudge.u-aizu.ac.jp/problems/DSL_5_B
    links:
    - https://onlinejudge.u-aizu.ac.jp/problems/DSL_5_B
  bundledCode: "#line 1 \"test/psum2d.test.cpp\"\n#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/problems/DSL_5_B\"\
    \n#include <iostream>\n#include <algorithm>\n#line 2 \"C++/math/psum/psum2d.hpp\"\
    \n\n#include <vector>\n#include <ranges>\nnamespace man {\ntemplate <class T>\
    \ struct psum2d {\nprivate:\n    int h, w;\n    std::vector<std::vector<T>> data;\n\
    public:\n    psum2d(const int h, const int w): h(h + 3), w(w + 3), data(h + 3,\
    \ std::vector<T>(w + 3)){}\n    psum2d(const std::vector<std::vector<T>> &v):\
    \ h(std::ssize(v) + 3), w(std::ssize(v.front()) + 3), data(std::ssize(v) + 3,\
    \ std::vector<T>(std::ssize(v.front()) + 3)) {\n        for(const auto i: std::views::iota(0,\
    \ std::ssize(v))) {\n            for(const auto j: std::views::iota(0, std::ssize(v[i])))\
    \ {\n                add(i, j, v[i][j]);\n            }\n        }\n    }\n  \
    \  constexpr inline void add(int i, int j, const T &x) noexcept {\n\t\ti++;\n\t\
    \tj++;\n\t\tif(i >= h || j >= w) {\n\t\t\treturn;\n\t\t}\n\t\tdata[i][j] += x;\n\
    \t}\n    constexpr inline void add(const int i1, const int j1, const int i2, const\
    \ int j2, const T &x) noexcept {\n\t\tadd(i1, j1, x);\n\t\tadd(i1, j2, -x);\n\t\
    \tadd(i2, j1, -x);\n\t\tadd(i2, j2, x);\n\t}\n    constexpr inline void build()\
    \ noexcept {\n\t\tfor(const auto i: std::views::iota(1, h)) {\n\t\t\tfor(const\
    \ auto j: std::views::iota(1, w)) {\n\t\t\t\tdata[i][j] += data[i][j - 1] + data[i\
    \ - 1][j] - data[i - 1][j - 1];\n\t\t\t}\n\t\t}\n\t}\n    constexpr inline T get(const\
    \ int i1, const int j1, const int i2, const int j2) const noexcept { return data[i2][j2]\
    \ - data[i1][j2] - data[i2][j1] + data[i1][j1]; }\n    constexpr inline T get(const\
    \ int i, const int j) const noexcept { return data[i + 1][j + 1]; }\n};\n}\n\n\
    /**\n * @brief \u4E8C\u6B21\u5143\u7D2F\u7A4D\u548C\n */\n#line 5 \"test/psum2d.test.cpp\"\
    \nconstexpr int m = 1000;\nint main() {\n    std::cin.tie(nullptr) -> sync_with_stdio(false);\n\
    \    int n;\n    std::cin >> n;\n    man::psum2d<int64_t> p(m, m);\n    while(n--)\
    \ {\n        int x1, y1, x2, y2;\n        std::cin >> x1 >> y1 >> x2 >> y2;\n\
    \        p.add(x1, y1, x2, y2, 1);\n    }\n    p.build();\n    int64_t ans = 0;\n\
    \    for(int i = 0; i < m; ++i) {\n        for(int j = 0; j < m; ++j) {\n    \
    \        ans = std::max(ans, p.get(i, j));\n        }\n    }\n    std::cout <<\
    \ ans << '\\n';\n}\n"
  code: "#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/problems/DSL_5_B\"\n#include\
    \ <iostream>\n#include <algorithm>\n#include \"C++/math/psum/psum2d.hpp\"\nconstexpr\
    \ int m = 1000;\nint main() {\n    std::cin.tie(nullptr) -> sync_with_stdio(false);\n\
    \    int n;\n    std::cin >> n;\n    man::psum2d<int64_t> p(m, m);\n    while(n--)\
    \ {\n        int x1, y1, x2, y2;\n        std::cin >> x1 >> y1 >> x2 >> y2;\n\
    \        p.add(x1, y1, x2, y2, 1);\n    }\n    p.build();\n    int64_t ans = 0;\n\
    \    for(int i = 0; i < m; ++i) {\n        for(int j = 0; j < m; ++j) {\n    \
    \        ans = std::max(ans, p.get(i, j));\n        }\n    }\n    std::cout <<\
    \ ans << '\\n';\n}"
  dependsOn:
  - C++/math/psum/psum2d.hpp
  isVerificationFile: true
  path: test/psum2d.test.cpp
  requiredBy: []
  timestamp: '2025-06-06 22:43:22+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/psum2d.test.cpp
layout: document
redirect_from:
- /verify/test/psum2d.test.cpp
- /verify/test/psum2d.test.cpp.html
title: test/psum2d.test.cpp
---
