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
    document_title: "Double-Ended Priority Queue(\u4E21\u7AEF\u512A\u5148\u5EA6\u4ED8\
      \u304D\u30AD\u30E5\u30FC)"
    links:
    - https://natsugiri.hatenablog.com/entry/2016/10/10/035445
  bundledCode: "#line 2 \"C++/ds/depq.hpp\"\n\n#include <vector>\n#include <algorithm>\n\
    #include <ranges>\nnamespace man {\ntemplate <std::integral T> struct depq {\n\
    private:\n    std::vector<T> d;\n    constexpr inline int parent(int k) const\
    \ noexcept { return ((k >> 1) - 1) & ~1; }\n    constexpr inline int down(int\
    \ k) noexcept {\n\t    const int n = std::ssize(d);\n\t    if(k & 1) {\n    \t\
    \    while(2 * k + 1 < n) {\n\t\t        int c = 2 * k + 3;\n\t\t        if(n\
    \ <= c || d[c - 2] < d[c]) {\n                    c -= 2;\n                }\n\
    \t\t        if(c < n && d[c] < d[k]) {\n                    std::swap(d[k], d[c]);\n\
    \                    k = c;\n                }\n\t\t        else {\n         \
    \           break;\n                }\n\t        }\n\t    } else {\n    \t   \
    \ while(2 * k + 2 < n) {\n    \t\t    int c = 2 * k + 4;\n\t\t        if(n <=\
    \ c || d[c] < d[c - 2]) {\n                    c -= 2;\n                }\n\t\t\
    \        if(c < n && d[k] < d[c]) {\n                    std::swap(d[k], d[c]);\n\
    \                    k = c;\n                }\n    \t\t    else {\n         \
    \           break;\n                }\n\t        }\n\t    }\n\t    return k;\n\
    \    }\n    constexpr inline int up(int k, const int root = 1) noexcept {\n\t\
    \    if((k | 1) < std::ssize(d) && d[k & ~1] < d[k | 1]) {\n    \t    std::swap(d[k\
    \ & ~1], d[k | 1]);\n\t        k ^= 1;\n\t    }\n\t    int p;\n\t    while(root\
    \ < k && d[p = parent(k)] < d[k]) {\n\t        std::swap(d[p], d[k]);\n\t    \
    \    k = p;\n\t    }\n\t    while(root < k && d[k] < d[p = parent(k) | 1]) {\n\
    \t        std::swap(d[p], d[k]);\n\t        k = p;\n\t    }\n\t    return k;\n\
    \    }\npublic:\n    depq(const std::vector<T> &d_): d(d_) {\n\t    for(const\
    \ auto i: std::views::iota(0, std::ssize(d)) | std::views::reverse) {\n\t    \
    \    if(i & 1 && d[i - 1] < d[i]) {\n                std::swap(d[i - 1], d[i]);\n\
    \            }\n\t        up(down(i), i);\n\t    }\n    }\n    constexpr inline\
    \ void push(const T &x) noexcept {\n\t    const int k = std::ssize(d);\n    \t\
    d.emplace_back(x);\n    \tup(k);\n    }\n    constexpr inline T pop_min() noexcept\
    \ {\n        const auto res = get_min();\n\t    if(std::ssize(d) < 3) {\n\t  \
    \      d.pop_back(); \n\t    } else {\n\t        std::swap(d[1], d.back());\n\
    \            d.pop_back();\n\t        up(down(1));\n\t    }\n        return res;\n\
    \    }\n    constexpr inline T pop_max() noexcept {\n        const auto res =\
    \ get_max();\n        if(std::ssize(d) < 2) { \n            d.pop_back();\n  \
    \      } else {\n            std::swap(d.front(), d.back());\n            d.pop_back();\n\
    \            up(down(0));\n        }\n        return res;\n    }\n    constexpr\
    \ inline T get_min() const noexcept { return std::ssize(d) < 2 ? d[0] : d[1];\
    \ }\n    constexpr inline T get_max() const noexcept { return d.front(); }\n \
    \   constexpr inline int size() const noexcept { return std::ssize(d); }\n   \
    \ constexpr inline bool empty() const noexcept { return d.empty(); }\n};\n}\n\
    /**\n * @brief Double-Ended Priority Queue(\u4E21\u7AEF\u512A\u5148\u5EA6\u4ED8\
    \u304D\u30AD\u30E5\u30FC)\n * @see https://natsugiri.hatenablog.com/entry/2016/10/10/035445\n\
    \ */\n"
  code: "#pragma once\n\n#include <vector>\n#include <algorithm>\n#include <ranges>\n\
    namespace man {\ntemplate <std::integral T> struct depq {\nprivate:\n    std::vector<T>\
    \ d;\n    constexpr inline int parent(int k) const noexcept { return ((k >> 1)\
    \ - 1) & ~1; }\n    constexpr inline int down(int k) noexcept {\n\t    const int\
    \ n = std::ssize(d);\n\t    if(k & 1) {\n    \t    while(2 * k + 1 < n) {\n\t\t\
    \        int c = 2 * k + 3;\n\t\t        if(n <= c || d[c - 2] < d[c]) {\n   \
    \                 c -= 2;\n                }\n\t\t        if(c < n && d[c] < d[k])\
    \ {\n                    std::swap(d[k], d[c]);\n                    k = c;\n\
    \                }\n\t\t        else {\n                    break;\n         \
    \       }\n\t        }\n\t    } else {\n    \t    while(2 * k + 2 < n) {\n   \
    \ \t\t    int c = 2 * k + 4;\n\t\t        if(n <= c || d[c] < d[c - 2]) {\n  \
    \                  c -= 2;\n                }\n\t\t        if(c < n && d[k] <\
    \ d[c]) {\n                    std::swap(d[k], d[c]);\n                    k =\
    \ c;\n                }\n    \t\t    else {\n                    break;\n    \
    \            }\n\t        }\n\t    }\n\t    return k;\n    }\n    constexpr inline\
    \ int up(int k, const int root = 1) noexcept {\n\t    if((k | 1) < std::ssize(d)\
    \ && d[k & ~1] < d[k | 1]) {\n    \t    std::swap(d[k & ~1], d[k | 1]);\n\t  \
    \      k ^= 1;\n\t    }\n\t    int p;\n\t    while(root < k && d[p = parent(k)]\
    \ < d[k]) {\n\t        std::swap(d[p], d[k]);\n\t        k = p;\n\t    }\n\t \
    \   while(root < k && d[k] < d[p = parent(k) | 1]) {\n\t        std::swap(d[p],\
    \ d[k]);\n\t        k = p;\n\t    }\n\t    return k;\n    }\npublic:\n    depq(const\
    \ std::vector<T> &d_): d(d_) {\n\t    for(const auto i: std::views::iota(0, std::ssize(d))\
    \ | std::views::reverse) {\n\t        if(i & 1 && d[i - 1] < d[i]) {\n       \
    \         std::swap(d[i - 1], d[i]);\n            }\n\t        up(down(i), i);\n\
    \t    }\n    }\n    constexpr inline void push(const T &x) noexcept {\n\t    const\
    \ int k = std::ssize(d);\n    \td.emplace_back(x);\n    \tup(k);\n    }\n    constexpr\
    \ inline T pop_min() noexcept {\n        const auto res = get_min();\n\t    if(std::ssize(d)\
    \ < 3) {\n\t        d.pop_back(); \n\t    } else {\n\t        std::swap(d[1],\
    \ d.back());\n            d.pop_back();\n\t        up(down(1));\n\t    }\n   \
    \     return res;\n    }\n    constexpr inline T pop_max() noexcept {\n      \
    \  const auto res = get_max();\n        if(std::ssize(d) < 2) { \n           \
    \ d.pop_back();\n        } else {\n            std::swap(d.front(), d.back());\n\
    \            d.pop_back();\n            up(down(0));\n        }\n        return\
    \ res;\n    }\n    constexpr inline T get_min() const noexcept { return std::ssize(d)\
    \ < 2 ? d[0] : d[1]; }\n    constexpr inline T get_max() const noexcept { return\
    \ d.front(); }\n    constexpr inline int size() const noexcept { return std::ssize(d);\
    \ }\n    constexpr inline bool empty() const noexcept { return d.empty(); }\n\
    };\n}\n/**\n * @brief Double-Ended Priority Queue(\u4E21\u7AEF\u512A\u5148\u5EA6\
    \u4ED8\u304D\u30AD\u30E5\u30FC)\n * @see https://natsugiri.hatenablog.com/entry/2016/10/10/035445\n\
    \ */"
  dependsOn: []
  isVerificationFile: false
  path: C++/ds/depq.hpp
  requiredBy: []
  timestamp: '2025-06-11 17:30:11+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/depq.test.cpp
documentation_of: C++/ds/depq.hpp
layout: document
redirect_from:
- /library/C++/ds/depq.hpp
- /library/C++/ds/depq.hpp.html
title: "Double-Ended Priority Queue(\u4E21\u7AEF\u512A\u5148\u5EA6\u4ED8\u304D\u30AD\
  \u30E5\u30FC)"
---
