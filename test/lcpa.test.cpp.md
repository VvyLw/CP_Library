---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/Strings.hpp
    title: C++/Strings.hpp
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://judge.yosupo.jp/problem/number_of_substrings
    links:
    - https://judge.yosupo.jp/problem/number_of_substrings
  bundledCode: "#line 1 \"test/lcpa.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/number_of_substrings\"\
    \n#include <C++/Strings.hpp>\nint main() {\n    std::string s;\n    std::cin >>\
    \ s;\n    SuffixArray sa(s);\n    const ll n = s.size();\n    const auto lcp =\
    \ sa.lcp_array();\n    std::cout << n * (n + 1) / 2 - std::accumulate(lcp.begin(),\
    \ lcp.end(), 0LL) << '\\n';\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/number_of_substrings\"\n\
    #include <C++/Strings.hpp>\nint main() {\n    std::string s;\n    std::cin >>\
    \ s;\n    SuffixArray sa(s);\n    const ll n = s.size();\n    const auto lcp =\
    \ sa.lcp_array();\n    std::cout << n * (n + 1) / 2 - std::accumulate(lcp.begin(),\
    \ lcp.end(), 0LL) << '\\n';\n}"
  dependsOn:
  - C++/Strings.hpp
  isVerificationFile: true
  path: test/lcpa.test.cpp
  requiredBy: []
  timestamp: '2023-12-02 12:10:55+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/lcpa.test.cpp
layout: document
redirect_from:
- /verify/test/lcpa.test.cpp
- /verify/test/lcpa.test.cpp.html
title: test/lcpa.test.cpp
---
