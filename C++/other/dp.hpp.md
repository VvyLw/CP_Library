---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/knapsack.test.cpp
    title: test/knapsack.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/knapsack2.test.cpp
    title: test/knapsack2.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/knapsack3.test.cpp
    title: test/knapsack3.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/knapsack4.test.cpp
    title: test/knapsack4.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/knapsack5.test.cpp
    title: test/knapsack5.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/lcs.test.cpp
    title: test/lcs.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/lis.test.cpp
    title: test/lis.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/lis2.test.cpp
    title: test/lis2.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/max_rect.test.cpp
    title: test/max_rect.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: "DP(Knapsack, LCS, LIS, \u6700\u5927\u9577\u65B9\u5F62, coin)"
    links:
    - https://ei1333.github.io/library/dp/knapsack-01-2.hpp
    - https://ei1333.github.io/library/dp/knapsack-01.hpp
    - https://ei1333.github.io/library/dp/knapsack-limitations-2.hpp
    - https://ei1333.github.io/library/dp/knapsack-limitations.hpp
    - https://ei1333.github.io/library/dp/knapsack.hpp
    - https://ei1333.github.io/library/dp/largest-rectangle.hpp
    - https://maku.blog/p/a3jyhwd/
    - https://nyaannyaan.github.io/library/dp/longest-increasing-sequence.hpp
  bundledCode: "#line 2 \"C++/other/dp.hpp\"\n\n#include <vector>\n#include <utility>\n\
    #include <algorithm>\n#include <stack>\n#include <iterator>\n#include <limits>\n\
    #include <numeric>\n\ntemplate <class T> T knapsack01_v(const std::vector<int>\
    \ &a, const std::vector<T> &v, const int w) {\n    const int n = a.size();\n \
    \   std::vector dp(w + 1, std::numeric_limits<T>::min());\n    dp[0] = 0;\n  \
    \  for(int i = 0; i < n; i++) {\n        for(int j = w; j >= a[i]; j--) {\n  \
    \          if(dp[j - a[i]] != std::numeric_limits<T>::min()) {\n             \
    \   if(dp[j - a[i]] + v[i] > dp[j]) {\n                    dp[j] = dp[j - a[i]]\
    \ + v[i];\n                }\n            }\n        }\n    }\n    return *std::ranges::max_element(dp);\n\
    }\n/**\n * @see https://ei1333.github.io/library/dp/knapsack-01.hpp\n */\n\ntemplate\
    \ <class T> int knapsack01_w(const std::vector<T> &a, const std::vector<int> &v,\
    \ const T &w) {\n    const int n = a.size();\n    const int s = std::accumulate(v.begin(),\
    \ v.end(), 0);\n    std::vector dp(s + 1, w + 1);\n    dp[0] = 0;\n    for(int\
    \ i = 0; i < n; i++) {\n        for(int j = s; j >= v[i]; j--) {\n           \
    \ dp[j] = std::min(dp[j], dp[j - v[i]] + a[i]);\n        }\n    }\n    int res\
    \ = 0;\n    for(int i = 0; i <= s; i++) {\n        if(dp[i] <= w) {\n        \
    \    res = i;\n        }\n    }\n    return res;\n}\n/**\n * @see https://ei1333.github.io/library/dp/knapsack-01-2.hpp\n\
    \ */\n\ntemplate <class T> std::vector<T> knapsack_sup_v(const std::vector<int>\
    \ &a, const std::vector<T> &v, const std::vector<int> &m, const int w, const bool\
    \ less = false) {\n    const int n = a.size();\n    std::vector<T> dp(w + 1, std::numeric_limits<T>::min()),\
    \ deqv(w + 1);\n    dp[0] = 0;\n    std::vector<int> deq(w + 1);\n    for(int\
    \ i = 0; i < n; ++i) {\n        if(a[i] == 0) {\n            for(int j = 0; j\
    \ <= w; ++j) {\n                if(dp[j] != std::numeric_limits<T>::min() && (less\
    \ ? dp[j] + v[i] * m[i] < dp[j] : dp[j] + v[i] * m[i] > dp[j])) {\n          \
    \          dp[j] = dp[j] + v[i] * m[i];\n                }\n            }\n  \
    \      } else {\n            for(int k = 0; k < a[i]; ++k) {\n               \
    \ int s = 0, t = 0;\n                for(int j = 0; a[i] * j + k <= w; ++j) {\n\
    \                    if(dp[a[i] * j + k] != std::numeric_limits<T>::min()) {\n\
    \                        const T val = dp[a[i] * j + k] - j * v[i];\n        \
    \                while(s < t && (less ? val < deqv[t - 1] : val > deqv[t - 1]))\
    \ {\n                            t--;\n                        }\n           \
    \             deq[t] = j;\n                        deqv[t++] = val;\n        \
    \            }\n                    if(s < t) {\n                        dp[j\
    \ * a[i] + k] = deqv[s] + j * v[i];\n                        if(deq[s] == j -\
    \ m[i]) {\n                            s++;\n                        }\n     \
    \               }\n                }\n            }\n        }\n    }\n    return\
    \ dp;\n}\n/**\n * @see https://ei1333.github.io/library/dp/knapsack-limitations.hpp\n\
    \ */\n\ntemplate <class T> T knapsack_sup_w(const std::vector<T> &a, const std::vector<int>\
    \ &v, const std::vector<T> &m, const T &w) {\n    const int n = a.size();\n  \
    \  const int max = *std::ranges::max_element(v);\n    if(max == 0) {\n       \
    \ return 0;\n    }\n    std::vector<int> ma(n);\n    std::vector<T> mb(n);\n \
    \   for(int i = 0; i < n; i++) {\n        ma[i] = std::min<int>(m[i], max - 1);\n\
    \        mb[i] = m[i] - ma[i];\n    }\n    int sum = 0;\n    for(int i = 0; i\
    \ < n; ++i) {\n        sum += ma[i] * v[i];\n    }\n    std::vector dp = knapsack_sup_v(v,\
    \ a, ma, sum, true);\n    std::vector<int> id(n);\n    std::iota(id.begin(), id.end(),\
    \ 0);\n    std::stable_sort(id.begin(), id.end(), [&](const int i, const int j)\
    \ -> bool { return v[i] * a[j] > v[j] * a[i]; });\n    T res = T{};\n    for(size_t\
    \ i = 0; i < dp.size(); ++i) {\n        if(dp[i] > w || dp[i] == std::numeric_limits<T>::min())\
    \ {\n            continue;\n        }\n        T rest = w - dp[i], cost = i;\n\
    \        for(const int j: id) {\n            const T get = std::min(mb[j], rest\
    \ / a[j]);\n            if(get <= 0) {\n                continue;\n          \
    \  }\n            cost += get * v[j];\n            rest -= get * a[j];\n     \
    \   }\n        res = std::max(res, cost);\n    }\n    return res;\n}\n/**\n *\
    \ @see https://ei1333.github.io/library/dp/knapsack-limitations-2.hpp\n */\n\n\
    template <class T> T knapsack(const std::vector<int> &a, const std::vector<T>\
    \ &v, const int w) {\n    const int n = a.size();\n    std::vector dp(w + 1, std::numeric_limits<T>::min());\n\
    \    dp[0] = 0;\n    for(int i = 0; i < n; i++) {\n        for(int j = a[i]; j\
    \ <= w; j++) {\n            if(dp[j - a[i]] != std::numeric_limits<T>::min())\
    \ {\n                if(dp[j - a[i]] + v[i] > dp[j]) {\n                    dp[j]\
    \ = dp[j - a[i]] + v[i];\n                }\n            }\n        }\n    }\n\
    \    return *std::ranges::max_element(dp);\n}\n/**\n * @see https://ei1333.github.io/library/dp/knapsack.hpp\n\
    \ */\n\ntemplate <class T> inline long long max_rectangle(std::vector<T> h) {\n\
    \    h.resize(h.size() + 1);\n    std::stack<size_t> sk;\n    std::vector<int>\
    \ l(h.size());\n    long long res = 0;\n    for(size_t i = 0; i < h.size(); i++)\
    \ {\n        while(!sk.empty() && h[sk.top()] >= h[i]) {\n            res = std::max(res,\
    \ (long long) (i - l[sk.top()] - 1) * h[sk.top()]);\n            sk.pop();\n \
    \       }\n        l[i] = sk.empty() ? -1 : sk.top();\n        sk.emplace(i);\n\
    \    }\n    return res;\n}\n/**\n * @see https://ei1333.github.io/library/dp/largest-rectangle.hpp\n\
    \ */\n\ninline int lcs(const std::string &s, const std::string &t) {\n    const\
    \ int n = s.size();\n    std::vector<int> dp(n + 1), ndp(n + 1);\n    for(size_t\
    \ i = 0; i < t.size(); ++i) {\n        for(int j = 0; j < n; ++j) {\n        \
    \    if(s[j] == t[i]) {\n                ndp[j + 1] = dp[j] + 1;\n           \
    \ } else {\n                ndp[j + 1] = std::max(ndp[j], dp[j + 1]);\n      \
    \      }\n        }\n        dp.swap(ndp);\n    }\n    return dp[n];\n}\n/**\n\
    \ * @see https://maku.blog/p/a3jyhwd/\n */\n\ntemplate <class T> inline std::vector<int>\
    \ lis(const std::vector<T> &v) {\n    const int n = v.size();\n    std::vector<std::pair<T,\
    \ int>> dp;\n    std::vector<int> p(n, -1), res;\n    for(int i = 0; i < n; ++i)\
    \ {\n        const auto it = std::ranges::lower_bound(dp, std::make_pair(v[i],\
    \ -i));\n        if(it != dp.begin()) {\n            p[i] = -prev(it) -> second;\n\
    \        }\n        if(it == dp.end()) {\n            dp.emplace_back(std::make_pair(v[i],\
    \ -i));\n        } else {\n            *it = std::make_pair(v[i], -i);\n     \
    \   }\n    }\n    for(int i = -dp.back().second; i != -1; i = p[i]) {\n      \
    \  res.emplace_back(i);\n    }\n    std::ranges::reverse(res);\n    return res;\n\
    }\n/**\n * @see https://nyaannyaan.github.io/library/dp/longest-increasing-sequence.hpp\n\
    \ */\n\n/**\n * @brief DP(Knapsack, LCS, LIS, \u6700\u5927\u9577\u65B9\u5F62,\
    \ coin)\n */\n"
  code: "#pragma once\n\n#include <vector>\n#include <utility>\n#include <algorithm>\n\
    #include <stack>\n#include <iterator>\n#include <limits>\n#include <numeric>\n\
    \ntemplate <class T> T knapsack01_v(const std::vector<int> &a, const std::vector<T>\
    \ &v, const int w) {\n    const int n = a.size();\n    std::vector dp(w + 1, std::numeric_limits<T>::min());\n\
    \    dp[0] = 0;\n    for(int i = 0; i < n; i++) {\n        for(int j = w; j >=\
    \ a[i]; j--) {\n            if(dp[j - a[i]] != std::numeric_limits<T>::min())\
    \ {\n                if(dp[j - a[i]] + v[i] > dp[j]) {\n                    dp[j]\
    \ = dp[j - a[i]] + v[i];\n                }\n            }\n        }\n    }\n\
    \    return *std::ranges::max_element(dp);\n}\n/**\n * @see https://ei1333.github.io/library/dp/knapsack-01.hpp\n\
    \ */\n\ntemplate <class T> int knapsack01_w(const std::vector<T> &a, const std::vector<int>\
    \ &v, const T &w) {\n    const int n = a.size();\n    const int s = std::accumulate(v.begin(),\
    \ v.end(), 0);\n    std::vector dp(s + 1, w + 1);\n    dp[0] = 0;\n    for(int\
    \ i = 0; i < n; i++) {\n        for(int j = s; j >= v[i]; j--) {\n           \
    \ dp[j] = std::min(dp[j], dp[j - v[i]] + a[i]);\n        }\n    }\n    int res\
    \ = 0;\n    for(int i = 0; i <= s; i++) {\n        if(dp[i] <= w) {\n        \
    \    res = i;\n        }\n    }\n    return res;\n}\n/**\n * @see https://ei1333.github.io/library/dp/knapsack-01-2.hpp\n\
    \ */\n\ntemplate <class T> std::vector<T> knapsack_sup_v(const std::vector<int>\
    \ &a, const std::vector<T> &v, const std::vector<int> &m, const int w, const bool\
    \ less = false) {\n    const int n = a.size();\n    std::vector<T> dp(w + 1, std::numeric_limits<T>::min()),\
    \ deqv(w + 1);\n    dp[0] = 0;\n    std::vector<int> deq(w + 1);\n    for(int\
    \ i = 0; i < n; ++i) {\n        if(a[i] == 0) {\n            for(int j = 0; j\
    \ <= w; ++j) {\n                if(dp[j] != std::numeric_limits<T>::min() && (less\
    \ ? dp[j] + v[i] * m[i] < dp[j] : dp[j] + v[i] * m[i] > dp[j])) {\n          \
    \          dp[j] = dp[j] + v[i] * m[i];\n                }\n            }\n  \
    \      } else {\n            for(int k = 0; k < a[i]; ++k) {\n               \
    \ int s = 0, t = 0;\n                for(int j = 0; a[i] * j + k <= w; ++j) {\n\
    \                    if(dp[a[i] * j + k] != std::numeric_limits<T>::min()) {\n\
    \                        const T val = dp[a[i] * j + k] - j * v[i];\n        \
    \                while(s < t && (less ? val < deqv[t - 1] : val > deqv[t - 1]))\
    \ {\n                            t--;\n                        }\n           \
    \             deq[t] = j;\n                        deqv[t++] = val;\n        \
    \            }\n                    if(s < t) {\n                        dp[j\
    \ * a[i] + k] = deqv[s] + j * v[i];\n                        if(deq[s] == j -\
    \ m[i]) {\n                            s++;\n                        }\n     \
    \               }\n                }\n            }\n        }\n    }\n    return\
    \ dp;\n}\n/**\n * @see https://ei1333.github.io/library/dp/knapsack-limitations.hpp\n\
    \ */\n\ntemplate <class T> T knapsack_sup_w(const std::vector<T> &a, const std::vector<int>\
    \ &v, const std::vector<T> &m, const T &w) {\n    const int n = a.size();\n  \
    \  const int max = *std::ranges::max_element(v);\n    if(max == 0) {\n       \
    \ return 0;\n    }\n    std::vector<int> ma(n);\n    std::vector<T> mb(n);\n \
    \   for(int i = 0; i < n; i++) {\n        ma[i] = std::min<int>(m[i], max - 1);\n\
    \        mb[i] = m[i] - ma[i];\n    }\n    int sum = 0;\n    for(int i = 0; i\
    \ < n; ++i) {\n        sum += ma[i] * v[i];\n    }\n    std::vector dp = knapsack_sup_v(v,\
    \ a, ma, sum, true);\n    std::vector<int> id(n);\n    std::iota(id.begin(), id.end(),\
    \ 0);\n    std::stable_sort(id.begin(), id.end(), [&](const int i, const int j)\
    \ -> bool { return v[i] * a[j] > v[j] * a[i]; });\n    T res = T{};\n    for(size_t\
    \ i = 0; i < dp.size(); ++i) {\n        if(dp[i] > w || dp[i] == std::numeric_limits<T>::min())\
    \ {\n            continue;\n        }\n        T rest = w - dp[i], cost = i;\n\
    \        for(const int j: id) {\n            const T get = std::min(mb[j], rest\
    \ / a[j]);\n            if(get <= 0) {\n                continue;\n          \
    \  }\n            cost += get * v[j];\n            rest -= get * a[j];\n     \
    \   }\n        res = std::max(res, cost);\n    }\n    return res;\n}\n/**\n *\
    \ @see https://ei1333.github.io/library/dp/knapsack-limitations-2.hpp\n */\n\n\
    template <class T> T knapsack(const std::vector<int> &a, const std::vector<T>\
    \ &v, const int w) {\n    const int n = a.size();\n    std::vector dp(w + 1, std::numeric_limits<T>::min());\n\
    \    dp[0] = 0;\n    for(int i = 0; i < n; i++) {\n        for(int j = a[i]; j\
    \ <= w; j++) {\n            if(dp[j - a[i]] != std::numeric_limits<T>::min())\
    \ {\n                if(dp[j - a[i]] + v[i] > dp[j]) {\n                    dp[j]\
    \ = dp[j - a[i]] + v[i];\n                }\n            }\n        }\n    }\n\
    \    return *std::ranges::max_element(dp);\n}\n/**\n * @see https://ei1333.github.io/library/dp/knapsack.hpp\n\
    \ */\n\ntemplate <class T> inline long long max_rectangle(std::vector<T> h) {\n\
    \    h.resize(h.size() + 1);\n    std::stack<size_t> sk;\n    std::vector<int>\
    \ l(h.size());\n    long long res = 0;\n    for(size_t i = 0; i < h.size(); i++)\
    \ {\n        while(!sk.empty() && h[sk.top()] >= h[i]) {\n            res = std::max(res,\
    \ (long long) (i - l[sk.top()] - 1) * h[sk.top()]);\n            sk.pop();\n \
    \       }\n        l[i] = sk.empty() ? -1 : sk.top();\n        sk.emplace(i);\n\
    \    }\n    return res;\n}\n/**\n * @see https://ei1333.github.io/library/dp/largest-rectangle.hpp\n\
    \ */\n\ninline int lcs(const std::string &s, const std::string &t) {\n    const\
    \ int n = s.size();\n    std::vector<int> dp(n + 1), ndp(n + 1);\n    for(size_t\
    \ i = 0; i < t.size(); ++i) {\n        for(int j = 0; j < n; ++j) {\n        \
    \    if(s[j] == t[i]) {\n                ndp[j + 1] = dp[j] + 1;\n           \
    \ } else {\n                ndp[j + 1] = std::max(ndp[j], dp[j + 1]);\n      \
    \      }\n        }\n        dp.swap(ndp);\n    }\n    return dp[n];\n}\n/**\n\
    \ * @see https://maku.blog/p/a3jyhwd/\n */\n\ntemplate <class T> inline std::vector<int>\
    \ lis(const std::vector<T> &v) {\n    const int n = v.size();\n    std::vector<std::pair<T,\
    \ int>> dp;\n    std::vector<int> p(n, -1), res;\n    for(int i = 0; i < n; ++i)\
    \ {\n        const auto it = std::ranges::lower_bound(dp, std::make_pair(v[i],\
    \ -i));\n        if(it != dp.begin()) {\n            p[i] = -prev(it) -> second;\n\
    \        }\n        if(it == dp.end()) {\n            dp.emplace_back(std::make_pair(v[i],\
    \ -i));\n        } else {\n            *it = std::make_pair(v[i], -i);\n     \
    \   }\n    }\n    for(int i = -dp.back().second; i != -1; i = p[i]) {\n      \
    \  res.emplace_back(i);\n    }\n    std::ranges::reverse(res);\n    return res;\n\
    }\n/**\n * @see https://nyaannyaan.github.io/library/dp/longest-increasing-sequence.hpp\n\
    \ */\n\n/**\n * @brief DP(Knapsack, LCS, LIS, \u6700\u5927\u9577\u65B9\u5F62,\
    \ coin)\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/other/dp.hpp
  requiredBy: []
  timestamp: '2024-03-27 23:05:37+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/knapsack5.test.cpp
  - test/knapsack4.test.cpp
  - test/max_rect.test.cpp
  - test/lis2.test.cpp
  - test/knapsack2.test.cpp
  - test/lis.test.cpp
  - test/knapsack3.test.cpp
  - test/knapsack.test.cpp
  - test/lcs.test.cpp
documentation_of: C++/other/dp.hpp
layout: document
redirect_from:
- /library/C++/other/dp.hpp
- /library/C++/other/dp.hpp.html
title: "DP(Knapsack, LCS, LIS, \u6700\u5927\u9577\u65B9\u5F62, coin)"
---
