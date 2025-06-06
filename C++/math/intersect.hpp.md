---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    _deprecated_at_docs: docs/intersect.md
    document_title: "\u4EA4\u70B9"
    links: []
  bundledCode: "#line 2 \"C++/math/intersect.hpp\"\n\n#include <cassert>\n#include\
    \ <utility>\n#include <limits>\nnamespace man {\ntemplate <class T> constexpr\
    \ inline std::pair<long double, long double> intersection(const std::pair<T, T>\
    \ &a, const T sec1, const std::pair<T, T> &b, const T sec2) noexcept {\n    long\
    \ double m1, m2, b1, b2;\n    if(a.first == 0 && b.first == 0) {\n        return\
    \ {std::numeric_limits<T>::min(), std::numeric_limits<T>::max()};\n    } else\
    \ if(a.second == 0) {\n        m2 = (long double) -b.first / b.second;\n     \
    \   b2 = (long double) -sec2 / b.second;\n        const long double x = (long\
    \ double) -sec1 / a.first, y = b2 + m2 * x; \n        return {x, y};\n    } else\
    \ if(b.second == 0) {\n        m1 = (long double) -a.first / a.second;\n     \
    \   b1 = (long double) -sec1 / a.second;\n        const long double x = (long\
    \ double) -sec2 / b.first, y = b1 + m1 * x;\n        return {x, y};\n    }\n \
    \   m1 = (long double) -a.first / a.second;\n    m2 = (long double) -b.first /\
    \ b.second;\n    b1 = (long double) -sec1 / a.second;\n    b2 = (long double)\
    \ -sec2 / b.second;\n    assert(m1 != m2);\n    const long double x = (b1 - b2)\
    \ / (m2 - m1), y = m1 * x + b1;\n    return {x, y};\n}\n}\n\n/**\n * @brief \u4EA4\
    \u70B9\n * @docs docs/intersect.md\n */\n"
  code: "#pragma once\n\n#include <cassert>\n#include <utility>\n#include <limits>\n\
    namespace man {\ntemplate <class T> constexpr inline std::pair<long double, long\
    \ double> intersection(const std::pair<T, T> &a, const T sec1, const std::pair<T,\
    \ T> &b, const T sec2) noexcept {\n    long double m1, m2, b1, b2;\n    if(a.first\
    \ == 0 && b.first == 0) {\n        return {std::numeric_limits<T>::min(), std::numeric_limits<T>::max()};\n\
    \    } else if(a.second == 0) {\n        m2 = (long double) -b.first / b.second;\n\
    \        b2 = (long double) -sec2 / b.second;\n        const long double x = (long\
    \ double) -sec1 / a.first, y = b2 + m2 * x; \n        return {x, y};\n    } else\
    \ if(b.second == 0) {\n        m1 = (long double) -a.first / a.second;\n     \
    \   b1 = (long double) -sec1 / a.second;\n        const long double x = (long\
    \ double) -sec2 / b.first, y = b1 + m1 * x;\n        return {x, y};\n    }\n \
    \   m1 = (long double) -a.first / a.second;\n    m2 = (long double) -b.first /\
    \ b.second;\n    b1 = (long double) -sec1 / a.second;\n    b2 = (long double)\
    \ -sec2 / b.second;\n    assert(m1 != m2);\n    const long double x = (b1 - b2)\
    \ / (m2 - m1), y = m1 * x + b1;\n    return {x, y};\n}\n}\n\n/**\n * @brief \u4EA4\
    \u70B9\n * @docs docs/intersect.md\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/math/intersect.hpp
  requiredBy: []
  timestamp: '2025-06-06 22:43:06+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/math/intersect.hpp
layout: document
redirect_from:
- /library/C++/math/intersect.hpp
- /library/C++/math/intersect.hpp.html
title: "\u4EA4\u70B9"
---
verified: [ABC145 D - Knight](https://atcoder.jp/contests/math-and-algorithm/submissions/51261855)