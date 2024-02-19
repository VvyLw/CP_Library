---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/string/manacher.hpp
    title: Manacher
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://judge.yosupo.jp/problem/enumerate_palindromes
    links:
    - https://judge.yosupo.jp/problem/enumerate_palindromes
  bundledCode: "#line 1 \"test/manacher.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/enumerate_palindromes\"\
    \n#include <iostream>\n#line 2 \"C++/string/manacher.hpp\"\n\n#include <cassert>\n\
    #include <vector>\n#include <algorithm>\nstd::vector<int> manacher(std::string\
    \ s, const bool calc_even = true) {\n    int n = s.size();\n    if(calc_even)\
    \ {\n        assert(n > 0);\n        s.resize(2 * n - 1);\n        for(int i =\
    \ n; --i >= 0;) {\n            s[2 * i] = s[i];\n        }\n        const auto\
    \ d = *std::min_element(s.begin(), s.end());\n        for(int i = 0; i < n - 1;\
    \ ++i) {\n            s[2 * i + 1] = d;\n        }\n    }\n    n = s.size();\n\
    \    std::vector<int> rad(n);\n    for(int i = 0, j = 0; i < n;) {\n        while(i\
    \ - j >= 0 && i + j < n && s[i - j] == s[i + j]) {\n            ++j;\n       \
    \ }\n        rad[i] = j;\n        int k = 1;\n        while(i - k >= 0 && i +\
    \ k < n && k + rad[i - k] < j) {\n            rad[i + k] = rad[i - k];\n     \
    \       ++k;\n        }\n        i += k, j -= k;\n    }\n    if(calc_even) {\n\
    \        for(int i = 0; i < n; ++i) {\n            if(((i ^ rad[i]) & 1) == 0)\
    \ {\n                rad[i]--;\n            }\n        }\n    }\n    else {\n\
    \        for(auto &x: rad) x = 2 * x - 1;\n    }\n    return rad;\n}\n\n/**\n\
    \ * @brief Manacher\n * @see https://ei1333.github.io/library/string/manacher.hpp\n\
    \ */\n#line 4 \"test/manacher.test.cpp\"\nint main() {\n    std::string s;\n \
    \   std::cin >> s;\n    const auto res = manacher(s);\n    for(size_t i = 0; i\
    \ < res.size(); ++i) {\n        std::cout << res[i] << \" \\n\"[i + 1 == res.size()];\n\
    \    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/enumerate_palindromes\"\
    \n#include <iostream>\n#include \"C++/string/manacher.hpp\"\nint main() {\n  \
    \  std::string s;\n    std::cin >> s;\n    const auto res = manacher(s);\n   \
    \ for(size_t i = 0; i < res.size(); ++i) {\n        std::cout << res[i] << \"\
    \ \\n\"[i + 1 == res.size()];\n    }\n}"
  dependsOn:
  - C++/string/manacher.hpp
  isVerificationFile: true
  path: test/manacher.test.cpp
  requiredBy: []
  timestamp: '2024-02-19 12:58:12+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/manacher.test.cpp
layout: document
redirect_from:
- /verify/test/manacher.test.cpp
- /verify/test/manacher.test.cpp.html
title: test/manacher.test.cpp
---
