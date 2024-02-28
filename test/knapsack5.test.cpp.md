---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/dp.hpp
    title: Longest Increasing Subsequence
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://onlinejudge.u-aizu.ac.jp/problems/DPL_1_C
    links:
    - https://onlinejudge.u-aizu.ac.jp/problems/DPL_1_C
  bundledCode: "#line 1 \"test/knapsack5.test.cpp\"\n#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/problems/DPL_1_C\"\
    \n#include <iostream>\n#line 2 \"C++/dp.hpp\"\n\n#include <vector>\n#include <utility>\n\
    #include <algorithm>\n#include <iterator>\n#include <limits>\n#include <numeric>\n\
    \ntemplate <class T> T knapsack01_v(const std::vector<int> &a, const std::vector<T>\
    \ &v, const int w) {\n    const int n = a.size();\n    std::vector dp(w + 1, std::numeric_limits<T>::min());\n\
    \    dp[0] = 0;\n    for(int i = 0; i < n; i++) {\n        for(int j = w; j >=\
    \ a[i]; j--) {\n            if(dp[j - a[i]] != std::numeric_limits<T>::min())\
    \ {\n                if(dp[j - a[i]] + v[i] > dp[j]) {\n                    dp[j]\
    \ = dp[j - a[i]] + v[i];\n                }\n            }\n        }\n    }\n\
    \    return *std::ranges::max_element(dp);\n}\n\ntemplate <class T> int knapsack01_w(const\
    \ std::vector<T> &a, const std::vector<int> &v, const T &w) {\n    const int n\
    \ = a.size();\n    const int s = std::accumulate(v.begin(), v.end(), 0);\n   \
    \ std::vector dp(s + 1, w + 1);\n    dp[0] = 0;\n    for(int i = 0; i < n; i++)\
    \ {\n        for(int j = s; j >= v[i]; j--) {\n            dp[j] = std::min(dp[j],\
    \ dp[j - v[i]] + a[i]);\n        }\n    }\n    int res = 0;\n    for(int i = 0;\
    \ i <= s; i++) {\n        if(dp[i] <= w) {\n            res = i;\n        }\n\
    \    }\n    return res;\n}\n\ntemplate <class T> std::vector<T> knapsack_sup_v(const\
    \ std::vector<int> &a, const std::vector<T> &v, const std::vector<int> &m, const\
    \ int w, const bool less = false) {\n    const int n = a.size();\n    std::vector<T>\
    \ dp(w + 1, std::numeric_limits<T>::min()), deqv(w + 1);\n    dp[0] = 0;\n   \
    \ std::vector<int> deq(w + 1);\n    for(int i = 0; i < n; ++i) {\n        if(a[i]\
    \ == 0) {\n            for(int j = 0; j <= w; ++j) {\n                if(dp[j]\
    \ != std::numeric_limits<T>::min() && (less ? dp[j] + v[i] * m[i] < dp[j] : dp[j]\
    \ + v[i] * m[i] > dp[j])) {\n                    dp[j] = dp[j] + v[i] * m[i];\n\
    \                }\n            }\n        } else {\n            for(int k = 0;\
    \ k < a[i]; ++k) {\n                int s = 0, t = 0;\n                for(int\
    \ j = 0; a[i] * j + k <= w; ++j) {\n                    if(dp[a[i] * j + k] !=\
    \ std::numeric_limits<T>::min()) {\n                        const T val = dp[a[i]\
    \ * j + k] - j * v[i];\n                        while(s < t && (less ? val < deqv[t\
    \ - 1] : val > deqv[t - 1])) {\n                            t--;\n           \
    \             }\n                        deq[t] = j;\n                       \
    \ deqv[t++] = val;\n                    }\n                    if(s < t) {\n \
    \                       dp[j * a[i] + k] = deqv[s] + j * v[i];\n             \
    \           if(deq[s] == j - m[i]) {\n                            s++;\n     \
    \                   }\n                    }\n                }\n            }\n\
    \        }\n    }\n    return dp;\n}\n\ntemplate <class T> T knapsack_sup_w(const\
    \ std::vector<T> &a, const std::vector<int> &v, const std::vector<T> &m, const\
    \ T &w) {\n    const int n = a.size();\n    const int max = *std::ranges::max_element(v);\n\
    \    if(max == 0) {\n        return 0;\n    }\n    std::vector<int> ma(n);\n \
    \   std::vector<T> mb(n);\n    for(int i = 0; i < n; i++) {\n        ma[i] = std::min<int>(m[i],\
    \ max - 1);\n        mb[i] = m[i] - ma[i];\n    }\n    int sum = 0;\n    for(int\
    \ i = 0; i < n; ++i) {\n        sum += ma[i] * v[i];\n    }\n    std::vector dp\
    \ = knapsack_sup_v(v, a, ma, sum, true);\n    std::vector<int> id(n);\n    std::iota(id.begin(),\
    \ id.end(), 0);\n    std::stable_sort(id.begin(), id.end(), [&](const int i, const\
    \ int j) -> bool { return v[i] * a[j] > v[j] * a[i]; });\n    T res = T{};\n \
    \   for(size_t i = 0; i < dp.size(); ++i) {\n        if(dp[i] > w || dp[i] ==\
    \ std::numeric_limits<T>::min()) {\n            continue;\n        }\n       \
    \ T rest = w - dp[i], cost = i;\n        for(const int j: id) {\n            const\
    \ T get = std::min(mb[j], rest / a[j]);\n            if(get <= 0) {\n        \
    \        continue;\n            }\n            cost += get * v[j];\n         \
    \   rest -= get * a[j];\n        }\n        res = std::max(res, cost);\n    }\n\
    \    return res;\n}\n\ntemplate <class T> T knapsack(const std::vector<int> &a,\
    \ const std::vector<T> &v, const int w) {\n    const int n = a.size();\n    std::vector\
    \ dp(w + 1, std::numeric_limits<T>::min());\n    dp[0] = 0;\n    for(int i = 0;\
    \ i < n; i++) {\n        for(int j = a[i]; j <= w; j++) {\n            if(dp[j\
    \ - a[i]] != std::numeric_limits<T>::min()) {\n                if(dp[j - a[i]]\
    \ + v[i] > dp[j]) {\n                    dp[j] = dp[j - a[i]] + v[i];\n      \
    \          }\n            }\n        }\n    }\n    return *std::ranges::max_element(dp);\n\
    }\n\ntemplate <class T> inline std::vector<int> lis(const std::vector<T> &v) {\n\
    \    const int n = v.size();\n    std::vector<std::pair<T, int>> dp;\n    std::vector<int>\
    \ p(n, -1), res;\n    for(int i = 0; i < n; ++i) {\n        const auto it = std::ranges::lower_bound(dp,\
    \ std::make_pair(v[i], -i));\n        if(it != dp.begin()) {\n            p[i]\
    \ = -prev(it) -> second;\n        }\n        if(it == dp.end()) {\n          \
    \  dp.emplace_back(std::make_pair(v[i], -i));\n        } else {\n            *it\
    \ = std::make_pair(v[i], -i);\n        }\n    }\n    for(int i = -dp.back().second;\
    \ i != -1; i = p[i]) {\n        res.emplace_back(i);\n    }\n    std::ranges::reverse(res);\n\
    \    return res;\n}\n/**\n * @brief Longest Increasing Subsequence\n * @see https://nyaannyaan.github.io/library/dp/longest-increasing-sequence.hpp\n\
    \ */\n#line 4 \"test/knapsack5.test.cpp\"\nint main() {\n    int n, wg;\n    std::cin\
    \ >> n >> wg;\n    std::vector<int> v(n), w(n);\n    for(int i = 0; i < n; ++i)\
    \ {\n        std::cin >> v[i] >> w[i];\n    }\n    std::cout << knapsack(w, v,\
    \ wg) << '\\n';\n}\n"
  code: "#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/problems/DPL_1_C\"\n#include\
    \ <iostream>\n#include \"C++/dp.hpp\"\nint main() {\n    int n, wg;\n    std::cin\
    \ >> n >> wg;\n    std::vector<int> v(n), w(n);\n    for(int i = 0; i < n; ++i)\
    \ {\n        std::cin >> v[i] >> w[i];\n    }\n    std::cout << knapsack(w, v,\
    \ wg) << '\\n';\n}"
  dependsOn:
  - C++/dp.hpp
  isVerificationFile: true
  path: test/knapsack5.test.cpp
  requiredBy: []
  timestamp: '2024-02-28 19:59:53+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/knapsack5.test.cpp
layout: document
redirect_from:
- /verify/test/knapsack5.test.cpp
- /verify/test/knapsack5.test.cpp.html
title: test/knapsack5.test.cpp
---
