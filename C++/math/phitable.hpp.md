---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':x:'
    path: test/C++/phi_table.test.cpp
    title: test/C++/phi_table.test.cpp
  _isVerificationFailed: true
  _pathExtension: hpp
  _verificationStatusIcon: ':x:'
  attributes:
    document_title: Euler's Phi-function(table)
    links: []
  bundledCode: "#line 2 \"C++/math/phitable.hpp\"\n\n#include <vector>\n#include <numeric>\n\
    struct phi_table {\nprivate:\n    int n;\n\tstd::vector<int> euler;\npublic:\n\
    \tphi_table(const int n_): n(n_), euler(n_ + 1) {\n\t\tstd::iota(euler.begin(),\
    \ euler.end(), 0);\n\t\tfor(int i = 2; i <= n; ++i) {\n\t\t\tif(euler[i] == i)\
    \ {\n\t\t\t\tfor(int j = i; j <= n; j += i) {\n\t\t\t\t\teuler[j] = euler[j] /\
    \ i * (i - 1);\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\tstd::vector<int> get() const\
    \ { return euler; }\n};\n\n/**\n * @brief Euler's Phi-function(table)\n */\n"
  code: "#pragma once\n\n#include <vector>\n#include <numeric>\nstruct phi_table {\n\
    private:\n    int n;\n\tstd::vector<int> euler;\npublic:\n\tphi_table(const int\
    \ n_): n(n_), euler(n_ + 1) {\n\t\tstd::iota(euler.begin(), euler.end(), 0);\n\
    \t\tfor(int i = 2; i <= n; ++i) {\n\t\t\tif(euler[i] == i) {\n\t\t\t\tfor(int\
    \ j = i; j <= n; j += i) {\n\t\t\t\t\teuler[j] = euler[j] / i * (i - 1);\n\t\t\
    \t\t}\n\t\t\t}\n\t\t}\n\t}\n\tstd::vector<int> get() const { return euler; }\n\
    };\n\n/**\n * @brief Euler's Phi-function(table)\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/phitable.hpp
  requiredBy: []
  timestamp: '2024-02-19 12:20:55+09:00'
  verificationStatus: LIBRARY_ALL_WA
  verifiedWith:
  - test/C++/phi_table.test.cpp
documentation_of: C++/math/phitable.hpp
layout: document
redirect_from:
- /library/C++/math/phitable.hpp
- /library/C++/math/phitable.hpp.html
title: Euler's Phi-function(table)
---
