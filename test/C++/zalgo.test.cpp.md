---
data:
  _extendedDependsOn:
  - icon: ':x:'
    path: C++/string/z-algo.hpp
    title: Z-Algorithm
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: cpp
  _verificationStatusIcon: ':x:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://judge.yosupo.jp/problem/zalgorithm
    links:
    - https://judge.yosupo.jp/problem/zalgorithm
  bundledCode: "#line 1 \"test/C++/zalgo.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/zalgorithm\"\
    \n#include <iostream>\n#line 2 \"C++/string/z-algo.hpp\"\n\n#include <vector>\n\
    std::vector<int> zalg(const std::string &s) {\n    const int n = s.size();\n \
    \   int j = 0;\n    std::vector<int> pre(n);\n    for(int i = 1; i < n; ++i) {\n\
    \        if(i + pre[i - j] < j + pre[j]) pre[i] = pre[i - j];\n        else {\n\
    \            int k = std::max(0, j + pre[j] - i);\n            while(i + k < n\
    \ && s[k] == s[i + k]) ++k;\n            pre[i] = k;\n            j = i;\n   \
    \     }\n    }\n    pre.front() = n;\n    return pre;\n}\n\n/**\n * @brief Z-Algorithm\n\
    \ */\n#line 4 \"test/C++/zalgo.test.cpp\"\nint main() {\n    std::string s;\n\
    \    std::cin >> s;\n    const auto res = zalg(s);\n    for(size_t i = 0; i <\
    \ s.size(); ++i) {\n        std::cout << res[i] << \" \\n\"[i + 1 == s.size()];\n\
    \    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/zalgorithm\"\n#include\
    \ <iostream>\n#include \"C++/string/z-algo.hpp\"\nint main() {\n    std::string\
    \ s;\n    std::cin >> s;\n    const auto res = zalg(s);\n    for(size_t i = 0;\
    \ i < s.size(); ++i) {\n        std::cout << res[i] << \" \\n\"[i + 1 == s.size()];\n\
    \    }\n}"
  dependsOn:
  - C++/string/z-algo.hpp
  isVerificationFile: true
  path: test/C++/zalgo.test.cpp
  requiredBy: []
  timestamp: '2024-03-03 06:22:53+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: test/C++/zalgo.test.cpp
layout: document
redirect_from:
- /verify/test/C++/zalgo.test.cpp
- /verify/test/C++/zalgo.test.cpp.html
title: test/C++/zalgo.test.cpp
---
