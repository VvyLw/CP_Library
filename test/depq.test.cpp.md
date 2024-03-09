---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/ds/depq.hpp
    title: "Double-Ended Priority Queue(\u4E21\u7AEF\u512A\u5148\u5EA6\u4ED8\u304D\
      \u30AD\u30E5\u30FC)"
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://judge.yosupo.jp/problem/double_ended_priority_queue
    links:
    - https://judge.yosupo.jp/problem/double_ended_priority_queue
  bundledCode: "#line 1 \"test/depq.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/double_ended_priority_queue\"\
    \n#include <iostream>\n#line 2 \"C++/ds/depq.hpp\"\n\n#include <vector>\n#include\
    \ <algorithm>\ntemplate <class T> struct depq {\nprivate:\n    std::vector<T>\
    \ d;\n    inline int parent(int k) const { return ((k >> 1) - 1) & ~1; }\n   \
    \ int down(int k) {\n\t    const int n = d.size();\n\t    if(k & 1) {\n    \t\
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
    \    }\n    int up(int k, const int root = 1) {\n\t    if((k | 1) < std::ssize(d)\
    \ && d[k & ~1] < d[k | 1]) {\n    \t    std::swap(d[k & ~1], d[k | 1]);\n\t  \
    \      k ^= 1;\n\t    }\n\t    int p;\n\t    while(root < k && d[p = parent(k)]\
    \ < d[k]) {\n\t        std::swap(d[p], d[k]);\n\t        k = p;\n\t    }\n\t \
    \   while(root < k && d[k] < d[p = parent(k) | 1]) {\n\t        std::swap(d[p],\
    \ d[k]);\n\t        k = p;\n\t    }\n\t    return k;\n    }\npublic:\n    depq(const\
    \ std::vector<T> &d_): d(d_) {\n\t    for(int i = d.size(); i--;) {\n\t      \
    \  if(i & 1 && d[i - 1] < d[i]) {\n                std::swap(d[i - 1], d[i]);\n\
    \            }\n\t        up(down(i), i);\n\t    }\n    }\n    void push(const\
    \ T &x) {\n\t    const int k = d.size();\n    \td.emplace_back(x);\n    \tup(k);\n\
    \    }\n    T pop_min() {\n        const auto res = get_min();\n\t    if(d.size()\
    \ < 3) {\n\t        d.pop_back(); \n\t    } else {\n\t        std::swap(d[1],\
    \ d.back());\n            d.pop_back();\n\t        up(down(1));\n\t    }\n   \
    \     return res;\n    }\n    T pop_max() {\n        const auto res = get_max();\n\
    \        if(d.size() < 2) { \n            d.pop_back();\n        } else {\n  \
    \          std::swap(d[0], d.back());\n            d.pop_back();\n           \
    \ up(down(0));\n        }\n        return res;\n    }\n    T get_min() const {\
    \ return d.size() < 2 ? d[0] : d[1]; }\n    T get_max() const { return d[0]; }\n\
    \    int size() const { return d.size(); }\n    bool empty() const { return d.empty();\
    \ }\n};\n/**\n * @brief Double-Ended Priority Queue(\u4E21\u7AEF\u512A\u5148\u5EA6\
    \u4ED8\u304D\u30AD\u30E5\u30FC)\n * @see https://natsugiri.hatenablog.com/entry/2016/10/10/035445\n\
    \ */\n#line 4 \"test/depq.test.cpp\"\nint main() {\n    int n, q;\n    std::cin\
    \ >> n >> q;\n    std::vector<int> s(n);\n    for(auto &el: s) {\n        std::cin\
    \ >> el;\n    }\n    depq<int> depq(s);\n    while(q--) {\n        int t;\n  \
    \      std::cin >> t;\n        if(t == 0) {\n            int x;\n            std::cin\
    \ >> x;\n            depq.push(x);\n        }\n        else if(t == 1) {\n   \
    \         std::cout << depq.pop_min() << '\\n';\n        }\n        else {\n \
    \           std::cout << depq.pop_max() << '\\n';\n        }\n    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/double_ended_priority_queue\"\
    \n#include <iostream>\n#include \"C++/ds/depq.hpp\"\nint main() {\n    int n,\
    \ q;\n    std::cin >> n >> q;\n    std::vector<int> s(n);\n    for(auto &el: s)\
    \ {\n        std::cin >> el;\n    }\n    depq<int> depq(s);\n    while(q--) {\n\
    \        int t;\n        std::cin >> t;\n        if(t == 0) {\n            int\
    \ x;\n            std::cin >> x;\n            depq.push(x);\n        }\n     \
    \   else if(t == 1) {\n            std::cout << depq.pop_min() << '\\n';\n   \
    \     }\n        else {\n            std::cout << depq.pop_max() << '\\n';\n \
    \       }\n    }\n}"
  dependsOn:
  - C++/ds/depq.hpp
  isVerificationFile: true
  path: test/depq.test.cpp
  requiredBy: []
  timestamp: '2024-03-09 13:04:52+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/depq.test.cpp
layout: document
redirect_from:
- /verify/test/depq.test.cpp
- /verify/test/depq.test.cpp.html
title: test/depq.test.cpp
---
