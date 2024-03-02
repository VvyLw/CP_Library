---
data:
  _extendedDependsOn:
  - icon: ':x:'
    path: C++/math/euler_phi.hpp
    title: Euler's Phi-function
  - icon: ':x:'
    path: C++/math/tetration.hpp
    title: "Tetration(a\u2191\u2191b)"
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: cpp
  _verificationStatusIcon: ':x:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://judge.yosupo.jp/problem/tetration_mod
    links:
    - https://judge.yosupo.jp/problem/tetration_mod
  bundledCode: "#line 1 \"test/C++/tetration.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/tetration_mod\"\
    \n#include <iostream>\n#line 2 \"C++/math/tetration.hpp\"\n\n#line 2 \"C++/math/euler_phi.hpp\"\
    \ntemplate <class T> inline T euler_phi(T n) {\n\tT res = n;\n\tfor(T i = 2; i\
    \ * i <= n; ++i) {\n\t    if(n % i == 0) {\n\t\t\tres -= res / i;\n\t\t\twhile(n\
    \ % i == 0) {\n\t\t\t\tn /= i;\n\t\t\t}\n\t\t}\n\t}\n\tif(n > 1) {\n\t\tres -=\
    \ res / n;\n\t}\n\treturn res;\n}\n\n/**\n * @brief Euler's Phi-function\n */\n\
    #line 4 \"C++/math/tetration.hpp\"\n#ifndef TEMPLATE\nnamespace zia_qu {\ntemplate\
    \ <class T> inline T pow(T a, T b, const T mod=0) {\n\tT res=1;\n\tif(mod) {\n\
    \t\tres%=mod;\n\t\ta%=mod;\n\t}\n\twhile(b>0) {\n\t\tif(b&1) res*=a;\n\t\tif(mod)\
    \ res%=mod;\n\t\ta*=a;\n\t\tif(mod) a%=mod;\n\t\tb>>=1;\n\t}\n\treturn res;\n\
    }\n}\n#endif\ntemplate <class T> inline T tetration(const T a, const T b, const\
    \ T m) {\n    if(m == 1) {\n        return 0;\n    }\n    if(a == 0) {\n     \
    \   return (b & 1) ? 0 : 1;\n    }\n    if(b == 0) {\n        return 1;\n    }\n\
    \    if(b == 1) {\n        return a % m;\n    }\n    if(b == 2) {\n        return\
    \ zia_qu::pow(a, a, m);\n    }\n    const auto phi = euler_phi(m);\n    auto tmp\
    \ = tetration(a, b - 1, phi);\n    if(!tmp) {\n        tmp += phi;\n    }\n  \
    \  return zia_qu::pow(a, tmp, m);\n}\n\n/**\n * @brief Tetration(a\u2191\u2191\
    b)\n */\n#line 4 \"test/C++/tetration.test.cpp\"\nvoid solve() {\n    long long\
    \ a, b, m;\n    std::cin >> a >> b >> m;\n    std::cout << tetration(a, b, m)\
    \ << '\\n';\n}\nint main() {\n    int t;\n    std::cin >> t;\n    while(t--) {\n\
    \        solve();\n    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/tetration_mod\"\n#include\
    \ <iostream>\n#include \"C++/math/tetration.hpp\"\nvoid solve() {\n    long long\
    \ a, b, m;\n    std::cin >> a >> b >> m;\n    std::cout << tetration(a, b, m)\
    \ << '\\n';\n}\nint main() {\n    int t;\n    std::cin >> t;\n    while(t--) {\n\
    \        solve();\n    }\n}"
  dependsOn:
  - C++/math/tetration.hpp
  - C++/math/euler_phi.hpp
  isVerificationFile: true
  path: test/C++/tetration.test.cpp
  requiredBy: []
  timestamp: '2024-03-02 19:12:32+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: test/C++/tetration.test.cpp
layout: document
redirect_from:
- /verify/test/C++/tetration.test.cpp
- /verify/test/C++/tetration.test.cpp.html
title: test/C++/tetration.test.cpp
---
