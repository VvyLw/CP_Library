---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    document_title: "k\u4E57\u6839(\u6574\u6570)"
    links: []
  bundledCode: "#line 2 \"C++/math/kthrooti.hpp\"\n\n#include <limits>\n#ifndef TEMPLATE\n\
    typedef unsigned long long ul;\ntemplate <class T, class U> inline bool overflow_if_mul(const\
    \ T a, const U b){ return (std::numeric_limits<T>::max()/a)<b; }\n#endif\nnamespace\
    \ Heileden {\ninline ul kthrooti(const ul n, const int k) {\n    if(k==1) {\n\t\
    \treturn n;\n\t}\n\tconst auto chk=[&](const unsigned x) {\n\t\tul mul=1;\n\t\t\
    for(int i = 0; i < k; ++i) {\n            if(overflow_if_mul(mul, x)) {\n    \
    \            return false;\n            }\n            mul*=x;\n        }\n\t\t\
    return mul<=n;\n\t};\n\tul ret=0;\n\tfor(int i = 32; --i >= 0;) {\n\t\tif(chk(ret|(1U<<i)))\
    \ {\n\t\t\tret|=1U<<i;\n\t\t}\n\t}\n\treturn ret;\n}\n}\n\n/**\n * @brief k\u4E57\
    \u6839(\u6574\u6570)\n */\n"
  code: "#pragma once\n\n#include <limits>\n#ifndef TEMPLATE\ntypedef unsigned long\
    \ long ul;\ntemplate <class T, class U> inline bool overflow_if_mul(const T a,\
    \ const U b){ return (std::numeric_limits<T>::max()/a)<b; }\n#endif\nnamespace\
    \ Heileden {\ninline ul kthrooti(const ul n, const int k) {\n    if(k==1) {\n\t\
    \treturn n;\n\t}\n\tconst auto chk=[&](const unsigned x) {\n\t\tul mul=1;\n\t\t\
    for(int i = 0; i < k; ++i) {\n            if(overflow_if_mul(mul, x)) {\n    \
    \            return false;\n            }\n            mul*=x;\n        }\n\t\t\
    return mul<=n;\n\t};\n\tul ret=0;\n\tfor(int i = 32; --i >= 0;) {\n\t\tif(chk(ret|(1U<<i)))\
    \ {\n\t\t\tret|=1U<<i;\n\t\t}\n\t}\n\treturn ret;\n}\n}\n\n/**\n * @brief k\u4E57\
    \u6839(\u6574\u6570)\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/kthrooti.hpp
  requiredBy: []
  timestamp: '2024-02-19 12:20:55+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/math/kthrooti.hpp
layout: document
redirect_from:
- /library/C++/math/kthrooti.hpp
- /library/C++/math/kthrooti.hpp.html
title: "k\u4E57\u6839(\u6574\u6570)"
---
