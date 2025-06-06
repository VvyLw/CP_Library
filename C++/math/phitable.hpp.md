---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/phi_table.test.cpp
    title: test/phi_table.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: Euler's Phi-function(table)
    links: []
  bundledCode: "#line 2 \"C++/math/phitable.hpp\"\n\n#include <vector>\n#include <numeric>\n\
    #include <ranges>\nnamespace man {\nstruct phi_table {\nprivate:\n    int n;\n\
    \tstd::vector<int> euler;\npublic:\n\tphi_table(const int n_): n(n_), euler(n_\
    \ + 1) {\n\t\tstd::iota(euler.begin(), euler.end(), 0);\n\t\tfor(const auto i:\
    \ std::views::iota(2, n + 1)) {\n\t\t\tif(euler[i] == i) {\n\t\t\t\tfor(int j\
    \ = i; j <= n; j += i) {\n\t\t\t\t\teuler[j] = euler[j] / i * (i - 1);\n\t\t\t\
    \t}\n\t\t\t}\n\t\t}\n\t}\n\tinline std::vector<int> get() const noexcept { return\
    \ euler; }\n};\n}\n\n/**\n * @brief Euler's Phi-function(table)\n */\n"
  code: "#pragma once\n\n#include <vector>\n#include <numeric>\n#include <ranges>\n\
    namespace man {\nstruct phi_table {\nprivate:\n    int n;\n\tstd::vector<int>\
    \ euler;\npublic:\n\tphi_table(const int n_): n(n_), euler(n_ + 1) {\n\t\tstd::iota(euler.begin(),\
    \ euler.end(), 0);\n\t\tfor(const auto i: std::views::iota(2, n + 1)) {\n\t\t\t\
    if(euler[i] == i) {\n\t\t\t\tfor(int j = i; j <= n; j += i) {\n\t\t\t\t\teuler[j]\
    \ = euler[j] / i * (i - 1);\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\tinline std::vector<int>\
    \ get() const noexcept { return euler; }\n};\n}\n\n/**\n * @brief Euler's Phi-function(table)\n\
    \ */"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/phitable.hpp
  requiredBy: []
  timestamp: '2025-06-06 22:43:06+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/phi_table.test.cpp
documentation_of: C++/math/phitable.hpp
layout: document
redirect_from:
- /library/C++/math/phitable.hpp
- /library/C++/math/phitable.hpp.html
title: Euler's Phi-function(table)
---
