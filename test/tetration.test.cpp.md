---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/math/euler_phi.hpp
    title: Euler's Phi-function
  - icon: ':heavy_check_mark:'
    path: C++/math/tetration.hpp
    title: "Tetration(a\u2191\u2191b)"
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://judge.yosupo.jp/problem/tetration_mod
    links:
    - https://judge.yosupo.jp/problem/tetration_mod
  bundledCode: "#line 1 \"test/tetration.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/tetration_mod\"\
    \n#include <iostream>\n#line 2 \"C++/math/tetration.hpp\"\n\n#line 2 \"C++/math/euler_phi.hpp\"\
    \nnamespace man {\ntemplate <class T> constexpr inline T euler_phi(T n) noexcept\
    \ {\n\tT ret = n;\n\tfor(T i = 2; i * i <= n; ++i) {\n\t    if(n % i == 0) {\n\
    \t\t\tret -= ret / i;\n\t\t\twhile(n % i == 0) {\n\t\t\t\tn /= i;\n\t\t\t}\n\t\
    \t}\n\t}\n\tif(n > 1) {\n\t\tret -= ret / n;\n\t}\n\treturn ret;\n}\n}\n\n/**\n\
    \ * @brief Euler's Phi-function\n */\n#line 4 \"C++/math/tetration.hpp\"\n#ifndef\
    \ TEMPLATE\nnamespace man {\ntemplate <class T> constexpr inline T pow(T a, T\
    \ b, const T mod = 0) noexcept {\n\tT ret = 1;\n\tif(mod != 0) {\n\t\tret %= mod;\n\
    \t\ta %= mod;\n\t}\n\twhile(b > 0) {\n\t\tif(b & 1) {\n\t\t\tret *= a;\n\t\t}\n\
    \t\tif(mod != 0) {\n\t\t\tret %= mod;\n\t\t}\n\t\ta *= a;\n\t\tif(mod) {\n\t\t\
    \ta %= mod;\n\t\t}\n\t\tb >>= 1;\n\t}\n\treturn ret;\n}\n}\n#endif\nnamespace\
    \ man {\ntemplate <class T> constexpr inline T tetration(const T a, const T b,\
    \ const T m) noexcept {\n    if(m == 1) {\n        return 0;\n    }\n    if(a\
    \ == 0) {\n        return (b & 1) ? 0 : 1;\n    }\n    if(b == 0) {\n        return\
    \ 1;\n    }\n    if(b == 1) {\n        return a % m;\n    }\n    if(b == 2) {\n\
    \        return pow(a, a, m);\n    }\n    const auto phi = euler_phi(m);\n   \
    \ auto tmp = tetration(a, b - 1, phi);\n    if(!tmp) {\n        tmp += phi;\n\
    \    }\n    return pow(a, tmp, m);\n}\n}\n\n/**\n * @brief Tetration(a\u2191\u2191\
    b)\n */\n#line 4 \"test/tetration.test.cpp\"\nvoid solve() {\n    int64_t a, b,\
    \ m;\n    std::cin >> a >> b >> m;\n    std::cout << man::tetration(a, b, m) <<\
    \ '\\n';\n}\nint main() {\n    int t;\n    std::cin >> t;\n    while(t--) {\n\
    \        solve();\n    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/tetration_mod\"\n#include\
    \ <iostream>\n#include \"C++/math/tetration.hpp\"\nvoid solve() {\n    int64_t\
    \ a, b, m;\n    std::cin >> a >> b >> m;\n    std::cout << man::tetration(a, b,\
    \ m) << '\\n';\n}\nint main() {\n    int t;\n    std::cin >> t;\n    while(t--)\
    \ {\n        solve();\n    }\n}"
  dependsOn:
  - C++/math/tetration.hpp
  - C++/math/euler_phi.hpp
  isVerificationFile: true
  path: test/tetration.test.cpp
  requiredBy: []
  timestamp: '2025-06-06 22:43:22+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/tetration.test.cpp
layout: document
redirect_from:
- /verify/test/tetration.test.cpp
- /verify/test/tetration.test.cpp.html
title: test/tetration.test.cpp
---
