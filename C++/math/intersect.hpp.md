---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    document_title: "\u4EA4\u70B9"
    links: []
  bundledCode: "#line 2 \"C++/math/intersect.hpp\"\n\n#include <cassert>\n#include\
    \ <utility>\n#include <limits>\n#ifndef TEMPLATE\ntypedef long double ld;\n#endif\n\
    template <class T> inline std::pair<ld, ld> intersection(const std::pair<T, T>\
    \ &a, const T sec1, const std::pair<T, T> &b, const T sec2) {\n    ld m1, m2,\
    \ b1, b2;\n    if(a.first == 0 && b.first == 0) {\n        return {std::numeric_limits<T>::min(),\
    \ std::numeric_limits<T>::max()};\n    } else if(a.second == 0) {\n        m2\
    \ = (ld) -b.first / b.second;\n        b2 = (ld) -sec2 / b.second;\n        const\
    \ ld x = (ld) -sec1 / a.first, y = b2 + m2 * x; \n        return {x, y};\n   \
    \ } else if(b.second == 0) {\n        m1 = (ld) -a.first / a.second;\n       \
    \ b1 = (ld) -sec1 / a.second;\n        const ld x = (ld) -sec2 / b.first, y =\
    \ b1 + m1 * x;\n        return {x, y};\n    }\n    m1 = (ld) -a.first / a.second;\n\
    \    m2 = (ld) -b.first / b.second;\n    b1 = (ld) -sec1 / a.second;\n    b2 =\
    \ (ld) -sec2 / b.second;\n    assert(m1 != m2);\n    const ld x = (b1 - b2) /\
    \ (m2 - m1), y = m1 * x + b1;\n    return {x, y};\n}\n\n/**\n * @brief \u4EA4\u70B9\
    \n */\n"
  code: "#pragma once\n\n#include <cassert>\n#include <utility>\n#include <limits>\n\
    #ifndef TEMPLATE\ntypedef long double ld;\n#endif\ntemplate <class T> inline std::pair<ld,\
    \ ld> intersection(const std::pair<T, T> &a, const T sec1, const std::pair<T,\
    \ T> &b, const T sec2) {\n    ld m1, m2, b1, b2;\n    if(a.first == 0 && b.first\
    \ == 0) {\n        return {std::numeric_limits<T>::min(), std::numeric_limits<T>::max()};\n\
    \    } else if(a.second == 0) {\n        m2 = (ld) -b.first / b.second;\n    \
    \    b2 = (ld) -sec2 / b.second;\n        const ld x = (ld) -sec1 / a.first, y\
    \ = b2 + m2 * x; \n        return {x, y};\n    } else if(b.second == 0) {\n  \
    \      m1 = (ld) -a.first / a.second;\n        b1 = (ld) -sec1 / a.second;\n \
    \       const ld x = (ld) -sec2 / b.first, y = b1 + m1 * x;\n        return {x,\
    \ y};\n    }\n    m1 = (ld) -a.first / a.second;\n    m2 = (ld) -b.first / b.second;\n\
    \    b1 = (ld) -sec1 / a.second;\n    b2 = (ld) -sec2 / b.second;\n    assert(m1\
    \ != m2);\n    const ld x = (b1 - b2) / (m2 - m1), y = m1 * x + b1;\n    return\
    \ {x, y};\n}\n\n/**\n * @brief \u4EA4\u70B9\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/intersect.hpp
  requiredBy: []
  timestamp: '2024-03-15 15:34:04+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/math/intersect.hpp
layout: document
redirect_from:
- /library/C++/math/intersect.hpp
- /library/C++/math/intersect.hpp.html
title: "\u4EA4\u70B9"
---
