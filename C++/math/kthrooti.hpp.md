---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
  - icon: ':x:'
    path: C++/math/primecounter.hpp
    title: "\u7D20\u6570\u306E\u500B\u6570"
  - icon: ':question:'
    path: C++/template.hpp
    title: "\u30C6\u30F3\u30D7\u30EC\u30FC\u30C8"
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/C++/aarray.test.cpp
    title: test/C++/aarray.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/C++/add.test.cpp
    title: test/C++/add.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/C++/add128.test.cpp
    title: test/C++/add128.test.cpp
  - icon: ':x:'
    path: test/C++/extgcd.test.cpp
    title: test/C++/extgcd.test.cpp
  - icon: ':x:'
    path: test/C++/fwtree.test.cpp
    title: test/C++/fwtree.test.cpp
  - icon: ':x:'
    path: test/C++/kthrooti.test.cpp
    title: test/C++/kthrooti.test.cpp
  - icon: ':x:'
    path: test/C++/m_add.test.cpp
    title: test/C++/m_add.test.cpp
  - icon: ':x:'
    path: test/C++/parsum.test.cpp
    title: test/C++/parsum.test.cpp
  - icon: ':x:'
    path: test/C++/pcounter.test.cpp
    title: test/C++/pcounter.test.cpp
  - icon: ':x:'
    path: test/C++/s_rmq.test.cpp
    title: test/C++/s_rmq.test.cpp
  - icon: ':x:'
    path: test/C++/segtree.test.cpp
    title: test/C++/segtree.test.cpp
  - icon: ':x:'
    path: test/C++/sr_sum.test.cpp
    title: test/C++/sr_sum.test.cpp
  - icon: ':x:'
    path: test/C++/stable.test.cpp
    title: test/C++/stable.test.cpp
  - icon: ':x:'
    path: test/C++/uf.test.cpp
    title: test/C++/uf.test.cpp
  _isVerificationFailed: true
  _pathExtension: hpp
  _verificationStatusIcon: ':question:'
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
  requiredBy:
  - C++/math/primecounter.hpp
  - C++/template.hpp
  timestamp: '2024-02-19 12:20:55+09:00'
  verificationStatus: LIBRARY_SOME_WA
  verifiedWith:
  - test/C++/sr_sum.test.cpp
  - test/C++/m_add.test.cpp
  - test/C++/add.test.cpp
  - test/C++/parsum.test.cpp
  - test/C++/segtree.test.cpp
  - test/C++/kthrooti.test.cpp
  - test/C++/stable.test.cpp
  - test/C++/pcounter.test.cpp
  - test/C++/fwtree.test.cpp
  - test/C++/uf.test.cpp
  - test/C++/extgcd.test.cpp
  - test/C++/add128.test.cpp
  - test/C++/s_rmq.test.cpp
  - test/C++/aarray.test.cpp
documentation_of: C++/math/kthrooti.hpp
layout: document
redirect_from:
- /library/C++/math/kthrooti.hpp
- /library/C++/math/kthrooti.hpp.html
title: "k\u4E57\u6839(\u6574\u6570)"
---
