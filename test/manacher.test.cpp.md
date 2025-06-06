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
    #include <vector>\n#include <algorithm>\n#include <ranges>\nnamespace man {\n\
    inline std::vector<int> manacher(std::string s, const bool calc_even = true) noexcept\
    \ {\n    int n = std::ssize(s);\n    if(calc_even) {\n        assert(n > 0);\n\
    \        s.resize(2 * n - 1);\n        for(const auto i: std::views::iota(0, n)\
    \ | std::views::reverse) {\n            s[2 * i] = s[i];\n        }\n        const\
    \ auto d = *std::ranges::min_element(s);\n        for(const auto i: std::views::iota(0,\
    \ n - 1)) {\n            s[2 * i + 1] = d;\n        }\n    }\n    n = std::ssize(s);\n\
    \    std::vector<int> rad(n);\n    for(int i = 0, j = 0; i < n;) {\n        while(i\
    \ - j >= 0 && i + j < n && s[i - j] == s[i + j]) {\n            ++j;\n       \
    \ }\n        rad[i] = j;\n        int k = 1;\n        while(i - k >= 0 && i +\
    \ k < n && k + rad[i - k] < j) {\n            rad[i + k] = rad[i - k];\n     \
    \       ++k;\n        }\n        i += k, j -= k;\n    }\n    if(calc_even) {\n\
    \        for(int i = 0; i < n; ++i) {\n            if(((i ^ rad[i]) & 1) == 0)\
    \ {\n                rad[i]--;\n            }\n        }\n    } else {\n     \
    \   for(auto &x: rad) {\n            x = 2 * x - 1;\n        }\n    }\n    return\
    \ rad;\n}\n}\n\n/**\n * @brief Manacher\n * @see https://ei1333.github.io/library/string/manacher.hpp\n\
    \ */\n#line 4 \"test/manacher.test.cpp\"\nint main() {\n    std::string s;\n \
    \   std::cin >> s;\n    const auto res = man::manacher(s);\n    for(size_t i =\
    \ 0; i < res.size(); ++i) {\n        std::cout << res[i] << \" \\n\"[i + 1 ==\
    \ res.size()];\n    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/enumerate_palindromes\"\
    \n#include <iostream>\n#include \"C++/string/manacher.hpp\"\nint main() {\n  \
    \  std::string s;\n    std::cin >> s;\n    const auto res = man::manacher(s);\n\
    \    for(size_t i = 0; i < res.size(); ++i) {\n        std::cout << res[i] <<\
    \ \" \\n\"[i + 1 == res.size()];\n    }\n}"
  dependsOn:
  - C++/string/manacher.hpp
  isVerificationFile: true
  path: test/manacher.test.cpp
  requiredBy: []
  timestamp: '2025-06-06 22:43:22+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/manacher.test.cpp
layout: document
redirect_from:
- /verify/test/manacher.test.cpp
- /verify/test/manacher.test.cpp.html
title: test/manacher.test.cpp
---
