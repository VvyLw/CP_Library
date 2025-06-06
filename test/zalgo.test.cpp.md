---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/string/z-algo.hpp
    title: Z-Algorithm
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://judge.yosupo.jp/problem/zalgorithm
    links:
    - https://judge.yosupo.jp/problem/zalgorithm
  bundledCode: "#line 1 \"test/zalgo.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/zalgorithm\"\
    \n#include <iostream>\n#line 2 \"C++/string/z-algo.hpp\"\n\n#include <vector>\n\
    #include <ranges>\nnamespace man {\ninline std::vector<int> zalg(const std::string\
    \ &s) noexcept {\n    const int n = std::ssize(s);\n    int j = 0;\n    std::vector<int>\
    \ pre(n);\n    for(const auto i: std::views::iota(1, n)) {\n        if(i + pre[i\
    \ - j] < j + pre[j]) {\n            pre[i] = pre[i - j];\n        } else {\n \
    \           int k = std::max(0, j + pre[j] - i);\n            while(i + k < n\
    \ && s[k] == s[i + k]) {\n                ++k;\n            }\n            pre[i]\
    \ = k;\n            j = i;\n        }\n    }\n    pre.front() = n;\n    return\
    \ pre;\n}\n}\n\n/**\n * @brief Z-Algorithm\n */\n#line 4 \"test/zalgo.test.cpp\"\
    \nint main() {\n    std::string s;\n    std::cin >> s;\n    const auto res = man::zalg(s);\n\
    \    for(size_t i = 0; i < s.size(); ++i) {\n        std::cout << res[i] << \"\
    \ \\n\"[i + 1 == s.size()];\n    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/zalgorithm\"\n#include\
    \ <iostream>\n#include \"C++/string/z-algo.hpp\"\nint main() {\n    std::string\
    \ s;\n    std::cin >> s;\n    const auto res = man::zalg(s);\n    for(size_t i\
    \ = 0; i < s.size(); ++i) {\n        std::cout << res[i] << \" \\n\"[i + 1 ==\
    \ s.size()];\n    }\n}"
  dependsOn:
  - C++/string/z-algo.hpp
  isVerificationFile: true
  path: test/zalgo.test.cpp
  requiredBy: []
  timestamp: '2025-06-06 22:43:22+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/zalgo.test.cpp
layout: document
redirect_from:
- /verify/test/zalgo.test.cpp
- /verify/test/zalgo.test.cpp.html
title: test/zalgo.test.cpp
---
