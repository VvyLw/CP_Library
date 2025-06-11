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
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.12/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n          \
    \         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\
    \  File \"/home/runner/.local/lib/python3.12/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.12/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 401, in update\n    self.update(self._resolve(pathlib.Path(included), included_from=path))\n\
    \                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n \
    \ File \"/home/runner/.local/lib/python3.12/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 260, in _resolve\n    raise BundleErrorAt(path, -1, \"no such header\"\
    )\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt: C++/core/concept.hpp:\
    \ line -1: no such header\n"
  code: "#pragma once\n\n#include <cassert>\n#include <utility>\n#include <limits>\n\
    #include \"C++/core/concept.hpp\"\nnamespace man {\ntemplate <internal::num T>\
    \ constexpr inline std::pair<long double, long double> intersection(const std::pair<T,\
    \ T> &a, const T sec1, const std::pair<T, T> &b, const T sec2) noexcept {\n  \
    \  long double m1, m2, b1, b2;\n    if(a.first == 0 && b.first == 0) {\n     \
    \   return {std::numeric_limits<T>::min(), std::numeric_limits<T>::max()};\n \
    \   } else if(a.second == 0) {\n        m2 = (long double) -b.first / b.second;\n\
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
  timestamp: '1970-01-01 00:00:00+00:00'
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