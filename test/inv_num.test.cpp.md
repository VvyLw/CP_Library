---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/ds/fwtree/FenwickTree.hpp
    title: Binary Indexed Tree
  - icon: ':heavy_check_mark:'
    path: C++/math/inverse_num.hpp
    title: "\u8EE2\u5012\u6570"
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://onlinejudge.u-aizu.ac.jp/problems/ALDS1_5_D
    links:
    - https://onlinejudge.u-aizu.ac.jp/problems/ALDS1_5_D
  bundledCode: "#line 1 \"test/inv_num.test.cpp\"\n#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/problems/ALDS1_5_D\"\
    \n#include <iostream>\n#line 2 \"C++/math/inverse_num.hpp\"\n\n#include <algorithm>\n\
    #line 2 \"C++/ds/fwtree/FenwickTree.hpp\"\n\r\n#include <vector>\r\n#include <ranges>\r\
    \nnamespace man {\r\ntemplate <std::integral T> struct FenwickTree {\r\nprivate:\r\
    \n    int n;\r\n    std::vector<T> data;\r\n    inline void init(const size_t\
    \ size) noexcept {\r\n        n = size + 2;\r\n        data.resize(n + 1);\r\n\
    \    }\r\npublic:\r\n    FenwickTree(){}\r\n    FenwickTree(const size_t size){\
    \ init(size); }\r\n    FenwickTree(const std::vector<T> &a) {\r\n        init(std::ssize(a));\r\
    \n        for(const auto i: std::views::iota(0, std::ssize(a))) {\r\n        \
    \    add(i, a[i]);\r\n        }\r\n    }\r\n    constexpr inline T sum(int k)\
    \ const noexcept {\r\n        if(k < 0) {\r\n            return 0;\r\n       \
    \ }\r\n        T ret = 0;\r\n        for(++k; k > 0; k -= k & -k) {\r\n      \
    \      ret += data[k];\r\n        }\r\n        return ret;\r\n    }\r\n    constexpr\
    \ inline T sum(int l, int r) const noexcept { return sum(r) - sum(l - 1); }\r\n\
    \    constexpr inline T operator[](int k) const noexcept { return sum(k) - sum(k\
    \ - 1); }\r\n    constexpr inline void add(int k, const T &x) noexcept {\r\n \
    \       for(++k; k < n; k += k & -k) {\r\n            data[k] += x;\r\n      \
    \  }\r\n    }\r\n    constexpr inline void add(const int l, const int r, const\
    \ T& x) noexcept {\r\n        add(l, x);\r\n        add(r + 1, -x);\r\n    }\r\
    \n    constexpr inline int lower_bound(T w) noexcept {\r\n        if(w <= 0) {\r\
    \n            return 0;\r\n        }\r\n        int x = 0;\r\n        for(int\
    \ k = 1 << std::__lg(n); k > 0; k >>= 1) {\r\n            if(x + k <= n - 1 &&\
    \ data[x + k] < w) {\r\n                w -= data[x + k];\r\n                x\
    \ += k;\r\n            }\r\n        }\r\n        return x;\r\n    }\r\n    constexpr\
    \ inline int upper_bound(T w) noexcept {\r\n        if(w < 0) {\r\n          \
    \  return 0;\r\n        }\r\n        int x = 0;\r\n        for(int k = 1 << std::__lg(n);\
    \ k > 0; k >>= 1) {\r\n            if(x + k <= n - 1 && data[x + k] <= w) {\r\n\
    \                w -= data[x + k];\r\n                x += k;\r\n            }\r\
    \n        }\r\n        return x;\r\n    }\r\n};\r\n}\r\n\r\n/**\r\n * @brief Binary\
    \ Indexed Tree\r\n * @see https://nyaannyaan.github.io/library/data-structure/binary-indexed-tree.hpp\r\
    \n */\n#line 5 \"C++/math/inverse_num.hpp\"\nnamespace man {\ntemplate <std::integral\
    \ T> constexpr inline int64_t inv_num(const std::vector<T> &a) noexcept {\n  \
    \  const int n = std::ssize(a);\n    std::vector<std::pair<T, int>> p(n);\n  \
    \  for(const auto i: std::views::iota(0, n)) {\n        p[i] = {a[i], i};\n  \
    \  }\n    std::ranges::sort(p);\n    std::vector<int> id(n);\n    for(const auto\
    \ i: std::views::iota(0, n)) {\n        id[p[i].second] = i;\n    }\n    FenwickTree<T>\
    \ bit(n);\n    int64_t ret = 0;\n    for(const auto i: std::views::iota(0, n))\
    \ {\n        ret += i - bit.sum(id[i]);\n        bit.add(id[i], 1);\n    }\n \
    \   return ret;\n}\n}\n\n/**\n * @brief \u8EE2\u5012\u6570\n */\n#line 4 \"test/inv_num.test.cpp\"\
    \nint main() {\n    int n;\n    std::cin >> n;\n    std::vector<int> a(n);\n \
    \   for(auto &el: a) {\n        std::cin >> el;\n    }\n    std::cout << man::inv_num(a)\
    \ << '\\n';\n}\n"
  code: "#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/problems/ALDS1_5_D\"\n\
    #include <iostream>\n#include \"C++/math/inverse_num.hpp\"\nint main() {\n   \
    \ int n;\n    std::cin >> n;\n    std::vector<int> a(n);\n    for(auto &el: a)\
    \ {\n        std::cin >> el;\n    }\n    std::cout << man::inv_num(a) << '\\n';\n\
    }"
  dependsOn:
  - C++/math/inverse_num.hpp
  - C++/ds/fwtree/FenwickTree.hpp
  isVerificationFile: true
  path: test/inv_num.test.cpp
  requiredBy: []
  timestamp: '2025-06-11 17:30:11+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/inv_num.test.cpp
layout: document
redirect_from:
- /verify/test/inv_num.test.cpp
- /verify/test/inv_num.test.cpp.html
title: test/inv_num.test.cpp
---
