---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    _deprecated_at_docs: docs/merge_sort.md
    document_title: "\u30DE\u30FC\u30B8\u30BD\u30FC\u30C8"
    links: []
  bundledCode: "#line 2 \"C++/other/merge_sort.hpp\"\n\n#include <vector>\n#include\
    \ <limits>\n#include <ranges>\nnamespace man {\ntemplate <std::integral T> constexpr\
    \ inline void merge(std::vector<T>& v, const int left, const int mid, const int\
    \ right) noexcept {\n    const int n1 = mid - left, n2 = right - mid;\n    std::vector<T>\
    \ l(n1 + 1), r(n2 + 1);\n    for(int i = 0; i < n1; ++i) {\n        l[i] = v[left\
    \ + i];\n    }\n    for(int i = 0; i < n2; ++i) {\n        r[i] = v[mid + i];\n\
    \    }\n    l[n1] = r[n2] = std::numeric_limits<T>::max();\n    int i = 0, j =\
    \ 0;\n    for(int k = left; k < right; ++k) {\n        if(l[i] <= r[j]) {\n  \
    \          v[k] = l[i++];\n        } else {\n            v[k] = r[j++];\n    \
    \    }\n    }\n}\ntemplate <std::integral T> constexpr inline void merge_sort(std::vector<T>\
    \ &v, const int l, const int r) noexcept {\n    if(l + 1 < r) {\n        const\
    \ int mid = (l + r) / 2;\n        merge_sort(v, l, mid);\n        merge_sort(v,\
    \ mid, r);\n        merge(v, l, mid, r);\n    }\n}\n}\n\n/**\n * @brief \u30DE\
    \u30FC\u30B8\u30BD\u30FC\u30C8\n * @docs docs/merge_sort.md\n */\n"
  code: "#pragma once\n\n#include <vector>\n#include <limits>\n#include <ranges>\n\
    namespace man {\ntemplate <std::integral T> constexpr inline void merge(std::vector<T>&\
    \ v, const int left, const int mid, const int right) noexcept {\n    const int\
    \ n1 = mid - left, n2 = right - mid;\n    std::vector<T> l(n1 + 1), r(n2 + 1);\n\
    \    for(int i = 0; i < n1; ++i) {\n        l[i] = v[left + i];\n    }\n    for(int\
    \ i = 0; i < n2; ++i) {\n        r[i] = v[mid + i];\n    }\n    l[n1] = r[n2]\
    \ = std::numeric_limits<T>::max();\n    int i = 0, j = 0;\n    for(int k = left;\
    \ k < right; ++k) {\n        if(l[i] <= r[j]) {\n            v[k] = l[i++];\n\
    \        } else {\n            v[k] = r[j++];\n        }\n    }\n}\ntemplate <std::integral\
    \ T> constexpr inline void merge_sort(std::vector<T> &v, const int l, const int\
    \ r) noexcept {\n    if(l + 1 < r) {\n        const int mid = (l + r) / 2;\n \
    \       merge_sort(v, l, mid);\n        merge_sort(v, mid, r);\n        merge(v,\
    \ l, mid, r);\n    }\n}\n}\n\n/**\n * @brief \u30DE\u30FC\u30B8\u30BD\u30FC\u30C8\
    \n * @docs docs/merge_sort.md\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/other/merge_sort.hpp
  requiredBy: []
  timestamp: '2025-06-11 17:30:11+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/other/merge_sort.hpp
layout: document
redirect_from:
- /library/C++/other/merge_sort.hpp
- /library/C++/other/merge_sort.hpp.html
title: "\u30DE\u30FC\u30B8\u30BD\u30FC\u30C8"
---
verified: [027 - Sorting](https://atcoder.jp/contests/math-and-algorithm/submissions/51201111)