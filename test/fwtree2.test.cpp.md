---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/FenwickTree.hpp
    title: Binary Indexed Tree
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://onlinejudge.u-aizu.ac.jp/problems/DSL_2_E
    links:
    - https://onlinejudge.u-aizu.ac.jp/problems/DSL_2_E
  bundledCode: "#line 1 \"test/fwtree2.test.cpp\"\n#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/problems/DSL_2_E\"\
    \n#include <iostream>\n#line 2 \"C++/FenwickTree.hpp\"\n\r\n#include <vector>\r\
    \ntemplate <class T> struct FenwickTree {\r\nprivate:\r\n    int N;\r\n    std::vector<T>\
    \ data;\r\n    void init(const size_t size) {\r\n        N = size + 2;\r\n   \
    \     data.assign(N + 1, {});\r\n    }\r\npublic:\r\n    FenwickTree(){}\r\n \
    \   FenwickTree(size_t size){ init(size); }\r\n    FenwickTree(const std::vector<T>\
    \ &a) {\r\n        init(a.size());\r\n        for(size_t i = 0; i < a.size();\
    \ ++i) {\r\n            add(i, a[i]);\r\n        }\r\n    }\r\n    // get sum\
    \ of [0,k]\r\n    T sum(int k) const {\r\n        if(k < 0) return T{};  // return\
    \ 0 if k < 0\r\n        T ret{};\r\n        for(++k; k > 0; k -= k & -k) ret +=\
    \ data[k];\r\n        return ret;\r\n    }\r\n    // getsum of [l,r]\r\n    inline\
    \ T sum(int l, int r) const { return sum(r) - sum(l - 1); }\r\n    // get value\
    \ of k\r\n    inline T operator[](int k) const { return sum(k) - sum(k - 1); }\r\
    \n    // data[k] += x\r\n    void add(int k, T x) {\r\n        for(++k; k < N;\
    \ k += k & -k) data[k] += x;\r\n    }\r\n    // range add x to [l,r]\r\n    void\
    \ add(int l, int r, T x) {\r\n        add(l, x);\r\n        add(r + 1, -x);\r\n\
    \    }\r\n    // minimize i s.t. sum(i) >= w\r\n    int lower_bound(T w) {\r\n\
    \        if(w <= 0) return 0;\r\n        int x = 0;\r\n        for(int k = 1 <<\
    \ std::__lg(N); k; k >>= 1) {\r\n            if(x + k <= N - 1 && data[x + k]\
    \ < w) {\r\n                w -= data[x + k];\r\n                x += k;\r\n \
    \           }\r\n        }\r\n        return x;\r\n    }\r\n    // minimize i\
    \ s.t. sum(i) > w\r\n    int upper_bound(T w) {\r\n        if(w < 0) return 0;\r\
    \n        int x = 0;\r\n        for(int k = 1 << std::__lg(N); k; k >>= 1) {\r\
    \n            if(x + k <= N - 1 && data[x + k] <= w) {\r\n                w -=\
    \ data[x + k];\r\n                x += k;\r\n            }\r\n        }\r\n  \
    \      return x;\r\n    }\r\n};\r\n\r\n#include <algorithm>\r\ntemplate <class\
    \ T> inline long long inv_num(const std::vector<T> &a) {\r\n    std::vector<std::pair<T,\
    \ int>> p(a.size());\r\n    for(size_t i = 0; i < a.size(); ++i) {\r\n       \
    \ p[i] = {a[i], i};\r\n    }\r\n    std::sort(p.begin(), p.end());\r\n    std::vector<int>\
    \ id(a.size());\r\n    for(int i = 0; i < a.size(); ++i) {\r\n        id[p[i].second]\
    \ = i;\r\n    }\r\n    FenwickTree<T> bit(a.size());\r\n    long long res = 0;\r\
    \n    for(size_t i = 0; i < a.size(); ++i) {\r\n        res += i - bit.sum(id[i]);\r\
    \n        bit.add(id[i], 1);\r\n    }\r\n    return res;\r\n}\r\n/**\r\n * @brief\
    \ Binary Indexed Tree\r\n * @see https://github.com/NyaanNyaan/library/blob/master/data-structure/binary-indexed-tree.hpp\r\
    \n */\n#line 4 \"test/fwtree2.test.cpp\"\nint main() {\n    std::cin.tie(nullptr)\
    \ -> sync_with_stdio(false);\n    int n, q;\n    std::cin >> n >> q;\n    FenwickTree<int64_t>\
    \ bit(n);\n    while(q--) {\n        int h;\n        std::cin >> h;\n        if(h\
    \ == 0) {\n            int s, t, x;\n            std::cin >> s >> t >> x;\n  \
    \          bit.add(--s, --t, x);\n        } else {\n            int i;\n     \
    \       std::cin >> i;\n            std::cout << bit.sum(--i) << '\\n';\n    \
    \    }\n    }\n}\n"
  code: "#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/problems/DSL_2_E\"\n#include\
    \ <iostream>\n#include \"C++/FenwickTree.hpp\"\nint main() {\n    std::cin.tie(nullptr)\
    \ -> sync_with_stdio(false);\n    int n, q;\n    std::cin >> n >> q;\n    FenwickTree<int64_t>\
    \ bit(n);\n    while(q--) {\n        int h;\n        std::cin >> h;\n        if(h\
    \ == 0) {\n            int s, t, x;\n            std::cin >> s >> t >> x;\n  \
    \          bit.add(--s, --t, x);\n        } else {\n            int i;\n     \
    \       std::cin >> i;\n            std::cout << bit.sum(--i) << '\\n';\n    \
    \    }\n    }\n}"
  dependsOn:
  - C++/FenwickTree.hpp
  isVerificationFile: true
  path: test/fwtree2.test.cpp
  requiredBy: []
  timestamp: '2024-02-15 21:15:45+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/fwtree2.test.cpp
layout: document
redirect_from:
- /verify/test/fwtree2.test.cpp
- /verify/test/fwtree2.test.cpp.html
title: test/fwtree2.test.cpp
---
