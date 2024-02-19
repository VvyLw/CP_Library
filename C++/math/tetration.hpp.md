---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/math/euler_phi.hpp
    title: Euler's Phi-function
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/tetration.test.cpp
    title: test/tetration.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: "Tetration(a\u2191\u2191b)"
    links: []
  bundledCode: "#line 2 \"C++/math/tetration.hpp\"\n\n#line 2 \"C++/math/euler_phi.hpp\"\
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
    b)\n */\n"
  code: "#pragma once\n\n#include \"C++/math/euler_phi.hpp\"\n#ifndef TEMPLATE\nnamespace\
    \ zia_qu {\ntemplate <class T> inline T pow(T a, T b, const T mod=0) {\n\tT res=1;\n\
    \tif(mod) {\n\t\tres%=mod;\n\t\ta%=mod;\n\t}\n\twhile(b>0) {\n\t\tif(b&1) res*=a;\n\
    \t\tif(mod) res%=mod;\n\t\ta*=a;\n\t\tif(mod) a%=mod;\n\t\tb>>=1;\n\t}\n\treturn\
    \ res;\n}\n}\n#endif\ntemplate <class T> inline T tetration(const T a, const T\
    \ b, const T m) {\n    if(m == 1) {\n        return 0;\n    }\n    if(a == 0)\
    \ {\n        return (b & 1) ? 0 : 1;\n    }\n    if(b == 0) {\n        return\
    \ 1;\n    }\n    if(b == 1) {\n        return a % m;\n    }\n    if(b == 2) {\n\
    \        return zia_qu::pow(a, a, m);\n    }\n    const auto phi = euler_phi(m);\n\
    \    auto tmp = tetration(a, b - 1, phi);\n    if(!tmp) {\n        tmp += phi;\n\
    \    }\n    return zia_qu::pow(a, tmp, m);\n}\n\n/**\n * @brief Tetration(a\u2191\
    \u2191b)\n */"
  dependsOn:
  - C++/math/euler_phi.hpp
  isVerificationFile: false
  path: C++/math/tetration.hpp
  requiredBy: []
  timestamp: '2024-02-19 13:17:33+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/tetration.test.cpp
documentation_of: C++/math/tetration.hpp
layout: document
redirect_from:
- /library/C++/math/tetration.hpp
- /library/C++/math/tetration.hpp.html
title: "Tetration(a\u2191\u2191b)"
---
