---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/depq.test.cpp
    title: test/depq.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    links:
    - https://natsugiri.hatenablog.com/entry/2016/10/10/035445
  bundledCode: "#line 2 \"C++/depq.hpp\"\n\n// inspired by natsugiri( https://natsugiri.hatenablog.com/entry/2016/10/10/035445\
    \ )\n#include <vector>\n#include <algorithm>\ntemplate <class T> struct depq {\n\
    private:\n    std::vector<T> d;\n    inline int parent(int k) const { return ((k\
    \ >> 1) - 1) & ~1; }\n    int down(int k) {\n\t    const int n = d.size();\n\t\
    \    if(k & 1) {\n    \t    while(2 * k + 1 < n) {\n\t\t        int c = 2 * k\
    \ + 3;\n\t\t        if(n <= c || d[c - 2] < d[c]) {\n                    c -=\
    \ 2;\n                }\n\t\t        if(c < n && d[c] < d[k]) {\n            \
    \        std::swap(d[k], d[c]);\n                    k = c;\n                }\n\
    \t\t        else {\n                    break;\n                }\n\t        }\n\
    \t    } else {\n    \t    while(2 * k + 2 < n) {\n    \t\t    int c = 2 * k +\
    \ 4;\n\t\t        if(n <= c || d[c] < d[c - 2]) {\n                    c -= 2;\n\
    \                }\n\t\t        if(c < n && d[k] < d[c]) {\n                 \
    \   std::swap(d[k], d[c]);\n                    k = c;\n                }\n  \
    \  \t\t    else {\n                    break;\n                }\n\t        }\n\
    \t    }\n\t    return k;\n    }\n    int up(int k, const int root = 1) {\n\t \
    \   if((k | 1) < std::ssize(d) && d[k & ~1] < d[k | 1]) {\n    \t    std::swap(d[k\
    \ & ~1], d[k | 1]);\n\t        k ^= 1;\n\t    }\n\t    int p;\n\t    while(root\
    \ < k && d[p = parent(k)] < d[k]) {\n\t        std::swap(d[p], d[k]);\n\t    \
    \    k = p;\n\t    }\n\t    while(root < k && d[k] < d[p = parent(k) | 1]) {\n\
    \t        std::swap(d[p], d[k]);\n\t        k = p;\n\t    }\n\t    return k;\n\
    \    }\npublic:\n    depq(const std::vector<T> &d_): d(d_) {\n\t    for(int i\
    \ = d.size(); i--;) {\n\t        if(i & 1 && d[i - 1] < d[i]) {\n            \
    \    std::swap(d[i - 1], d[i]);\n            }\n\t        up(down(i), i);\n\t\
    \    }\n    }\n    void push(const T &x) {\n\t    const int k = d.size();\n  \
    \  \td.emplace_back(x);\n    \tup(k);\n    }\n    T pop_min() {\n        const\
    \ auto res = get_min();\n\t    if(d.size() < 3) {\n\t        d.pop_back(); \n\t\
    \    } else {\n\t        std::swap(d[1], d.back());\n            d.pop_back();\n\
    \t        up(down(1));\n\t    }\n        return res;\n    }\n    T pop_max() {\n\
    \        const auto res = get_max();\n        if(d.size() < 2) { \n          \
    \  d.pop_back();\n        } else {\n            std::swap(d[0], d.back());\n \
    \           d.pop_back();\n            up(down(0));\n        }\n        return\
    \ res;\n    }\n    T get_min() const { return d.size() < 2 ? d[0] : d[1]; }\n\
    \    T get_max() const { return d[0]; }\n    int size() const { return d.size();\
    \ }\n    bool empty() const { return d.empty(); }\n};\n"
  code: "#pragma once\n\n// inspired by natsugiri( https://natsugiri.hatenablog.com/entry/2016/10/10/035445\
    \ )\n#include <vector>\n#include <algorithm>\ntemplate <class T> struct depq {\n\
    private:\n    std::vector<T> d;\n    inline int parent(int k) const { return ((k\
    \ >> 1) - 1) & ~1; }\n    int down(int k) {\n\t    const int n = d.size();\n\t\
    \    if(k & 1) {\n    \t    while(2 * k + 1 < n) {\n\t\t        int c = 2 * k\
    \ + 3;\n\t\t        if(n <= c || d[c - 2] < d[c]) {\n                    c -=\
    \ 2;\n                }\n\t\t        if(c < n && d[c] < d[k]) {\n            \
    \        std::swap(d[k], d[c]);\n                    k = c;\n                }\n\
    \t\t        else {\n                    break;\n                }\n\t        }\n\
    \t    } else {\n    \t    while(2 * k + 2 < n) {\n    \t\t    int c = 2 * k +\
    \ 4;\n\t\t        if(n <= c || d[c] < d[c - 2]) {\n                    c -= 2;\n\
    \                }\n\t\t        if(c < n && d[k] < d[c]) {\n                 \
    \   std::swap(d[k], d[c]);\n                    k = c;\n                }\n  \
    \  \t\t    else {\n                    break;\n                }\n\t        }\n\
    \t    }\n\t    return k;\n    }\n    int up(int k, const int root = 1) {\n\t \
    \   if((k | 1) < std::ssize(d) && d[k & ~1] < d[k | 1]) {\n    \t    std::swap(d[k\
    \ & ~1], d[k | 1]);\n\t        k ^= 1;\n\t    }\n\t    int p;\n\t    while(root\
    \ < k && d[p = parent(k)] < d[k]) {\n\t        std::swap(d[p], d[k]);\n\t    \
    \    k = p;\n\t    }\n\t    while(root < k && d[k] < d[p = parent(k) | 1]) {\n\
    \t        std::swap(d[p], d[k]);\n\t        k = p;\n\t    }\n\t    return k;\n\
    \    }\npublic:\n    depq(const std::vector<T> &d_): d(d_) {\n\t    for(int i\
    \ = d.size(); i--;) {\n\t        if(i & 1 && d[i - 1] < d[i]) {\n            \
    \    std::swap(d[i - 1], d[i]);\n            }\n\t        up(down(i), i);\n\t\
    \    }\n    }\n    void push(const T &x) {\n\t    const int k = d.size();\n  \
    \  \td.emplace_back(x);\n    \tup(k);\n    }\n    T pop_min() {\n        const\
    \ auto res = get_min();\n\t    if(d.size() < 3) {\n\t        d.pop_back(); \n\t\
    \    } else {\n\t        std::swap(d[1], d.back());\n            d.pop_back();\n\
    \t        up(down(1));\n\t    }\n        return res;\n    }\n    T pop_max() {\n\
    \        const auto res = get_max();\n        if(d.size() < 2) { \n          \
    \  d.pop_back();\n        } else {\n            std::swap(d[0], d.back());\n \
    \           d.pop_back();\n            up(down(0));\n        }\n        return\
    \ res;\n    }\n    T get_min() const { return d.size() < 2 ? d[0] : d[1]; }\n\
    \    T get_max() const { return d[0]; }\n    int size() const { return d.size();\
    \ }\n    bool empty() const { return d.empty(); }\n};"
  dependsOn: []
  isVerificationFile: false
  path: C++/depq.hpp
  requiredBy: []
  timestamp: '2023-12-11 21:48:09+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/depq.test.cpp
documentation_of: C++/depq.hpp
layout: document
redirect_from:
- /library/C++/depq.hpp
- /library/C++/depq.hpp.html
title: C++/depq.hpp
---
