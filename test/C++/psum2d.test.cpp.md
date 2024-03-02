---
data:
  _extendedDependsOn:
  - icon: ':x:'
    path: C++/math/psum/psum2d.hpp
    title: "\u4E8C\u6B21\u5143\u7D2F\u7A4D\u548C"
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: cpp
  _verificationStatusIcon: ':x:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://onlinejudge.u-aizu.ac.jp/problems/DSL_5_B
    links:
    - https://onlinejudge.u-aizu.ac.jp/problems/DSL_5_B
  bundledCode: "#line 1 \"test/C++/psum2d.test.cpp\"\n#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/problems/DSL_5_B\"\
    \n#include <iostream>\n#include <algorithm>\n#line 2 \"C++/math/psum/psum2d.hpp\"\
    \n\n#include <vector>\ntemplate <class T> struct psum2d {\nprivate:\n    int h,\
    \ w;\n    std::vector<std::vector<T>> data;\npublic:\n    psum2d(const int h,\
    \ const int w): h(h + 3), w(w + 3), data(h + 3, std::vector<T>(w + 3)){}\n   \
    \ psum2d(const std::vector<std::vector<T>> &v): h(v.size() + 3), w(v[0].size()\
    \ + 3), data(v.size() + 3, std::vector<T>(v[0].size() + 3)) {\n        for(size_t\
    \ i = 0; i < v.size(); ++i) {\n            for(size_t j = 0; j < v[i].size();\
    \ ++j) {\n                add(i, j, v[i][j]);\n            }\n        }\n    }\n\
    \    void add(int i, int j, const T &x) {\n\t\ti++;\n\t\tj++;\n\t\tif(i >= h ||\
    \ j >= w) {\n\t\t\treturn;\n\t\t}\n\t\tdata[i][j] += x;\n\t}\n    void add(const\
    \ int i1, const int j1, const int i2, const int j2, const T &x) {\n\t\tadd(i1,\
    \ j1, x);\n\t\tadd(i1, j2, -x);\n\t\tadd(i2, j1, -x);\n\t\tadd(i2, j2, x);\n\t\
    }\n    void build() {\n\t\tfor(int i = 0; ++i < h;) {\n\t\t\tfor(int j = 0; ++j\
    \ < w;) {\n\t\t\t\tdata[i][j] += data[i][j - 1] + data[i - 1][j] - data[i - 1][j\
    \ - 1];\n\t\t\t}\n\t\t}\n\t}\n    T get(const int i1, const int j1, const int\
    \ i2, const int j2) const { return data[i2][j2] - data[i1][j2] - data[i2][j1]\
    \ + data[i1][j1]; }\n    T get(const int i, const int j) const { return data[i\
    \ + 1][j + 1]; }\n};\n\n/**\n * @brief \u4E8C\u6B21\u5143\u7D2F\u7A4D\u548C\n\
    \ */\n#line 5 \"test/C++/psum2d.test.cpp\"\nconstexpr int m = 1000;\nint main()\
    \ {\n    std::cin.tie(nullptr) -> sync_with_stdio(false);\n    int n;\n    std::cin\
    \ >> n;\n    psum2d<int64_t> p(m, m);\n    while(n--) {\n        int x1, y1, x2,\
    \ y2;\n        std::cin >> x1 >> y1 >> x2 >> y2;\n        p.add(x1, y1, x2, y2,\
    \ 1);\n    }\n    p.build();\n    int64_t ans = 0;\n    for(int i = 0; i < m;\
    \ ++i) {\n        for(int j = 0; j < m; ++j) {\n            ans = std::max(ans,\
    \ p.get(i, j));\n        }\n    }\n    std::cout << ans << '\\n';\n}\n"
  code: "#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/problems/DSL_5_B\"\n#include\
    \ <iostream>\n#include <algorithm>\n#include \"C++/math/psum/psum2d.hpp\"\nconstexpr\
    \ int m = 1000;\nint main() {\n    std::cin.tie(nullptr) -> sync_with_stdio(false);\n\
    \    int n;\n    std::cin >> n;\n    psum2d<int64_t> p(m, m);\n    while(n--)\
    \ {\n        int x1, y1, x2, y2;\n        std::cin >> x1 >> y1 >> x2 >> y2;\n\
    \        p.add(x1, y1, x2, y2, 1);\n    }\n    p.build();\n    int64_t ans = 0;\n\
    \    for(int i = 0; i < m; ++i) {\n        for(int j = 0; j < m; ++j) {\n    \
    \        ans = std::max(ans, p.get(i, j));\n        }\n    }\n    std::cout <<\
    \ ans << '\\n';\n}"
  dependsOn:
  - C++/math/psum/psum2d.hpp
  isVerificationFile: true
  path: test/C++/psum2d.test.cpp
  requiredBy: []
  timestamp: '2024-03-03 06:22:53+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: test/C++/psum2d.test.cpp
layout: document
redirect_from:
- /verify/test/C++/psum2d.test.cpp
- /verify/test/C++/psum2d.test.cpp.html
title: test/C++/psum2d.test.cpp
---
