---
data:
  _extendedDependsOn:
  - icon: ':x:'
    path: C++/math/phitable.hpp
    title: Euler's Phi-function(table)
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: cpp
  _verificationStatusIcon: ':x:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://onlinejudge.u-aizu.ac.jp/problems/2286
    links:
    - https://onlinejudge.u-aizu.ac.jp/problems/2286
  bundledCode: "#line 1 \"test/C++/phi_table.test.cpp\"\n#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/problems/2286\"\
    \n#include <iostream>\n#line 2 \"C++/math/phitable.hpp\"\n\n#include <vector>\n\
    #include <numeric>\nstruct phi_table {\nprivate:\n    int n;\n\tstd::vector<int>\
    \ euler;\npublic:\n\tphi_table(const int n_): n(n_), euler(n_ + 1) {\n\t\tstd::iota(euler.begin(),\
    \ euler.end(), 0);\n\t\tfor(int i = 2; i <= n; ++i) {\n\t\t\tif(euler[i] == i)\
    \ {\n\t\t\t\tfor(int j = i; j <= n; j += i) {\n\t\t\t\t\teuler[j] = euler[j] /\
    \ i * (i - 1);\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\tstd::vector<int> get() const\
    \ { return euler; }\n};\n\n/**\n * @brief Euler's Phi-function(table)\n */\n#line\
    \ 4 \"test/C++/phi_table.test.cpp\"\nconstexpr int n = 1e6;\nint main() {\n  \
    \  const auto phi = phi_table(n).get();\n    std::vector<int64_t> ret(n + 1);\n\
    \    ret[1] = 2;\n    for(int i = 2; i <= n; ++i) {\n        ret[i] = ret[i -\
    \ 1] + phi[i];\n    }\n    int t;\n    std::cin >> t;\n    while(t--) {\n    \
    \    int i;\n        std::cin >> i;\n        std::cout << ret[i] << '\\n';\n \
    \   }\n}\n"
  code: "#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/problems/2286\"\n#include\
    \ <iostream>\n#include \"C++/math/phitable.hpp\"\nconstexpr int n = 1e6;\nint\
    \ main() {\n    const auto phi = phi_table(n).get();\n    std::vector<int64_t>\
    \ ret(n + 1);\n    ret[1] = 2;\n    for(int i = 2; i <= n; ++i) {\n        ret[i]\
    \ = ret[i - 1] + phi[i];\n    }\n    int t;\n    std::cin >> t;\n    while(t--)\
    \ {\n        int i;\n        std::cin >> i;\n        std::cout << ret[i] << '\\\
    n';\n    }\n}"
  dependsOn:
  - C++/math/phitable.hpp
  isVerificationFile: true
  path: test/C++/phi_table.test.cpp
  requiredBy: []
  timestamp: '2024-03-02 19:12:32+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: test/C++/phi_table.test.cpp
layout: document
redirect_from:
- /verify/test/C++/phi_table.test.cpp
- /verify/test/C++/phi_table.test.cpp.html
title: test/C++/phi_table.test.cpp
---
