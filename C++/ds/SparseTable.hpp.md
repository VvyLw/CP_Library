---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/s_rmq.test.cpp
    title: test/s_rmq.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: Sparse Table
    links:
    - https://ei1333.github.io/luzhiled/snippets/structure/sparse-table.html
  bundledCode: "#line 2 \"C++/ds/SparseTable.hpp\"\n\r\n#include <vector>\r\n#include\
    \ <functional>\r\n#include <ranges>\r\nnamespace man {\r\ntemplate <class T> struct\
    \ SparseTable {\r\nprivate:\r\n    using F = std::function<T(T,T)>;\r\n    std::vector<std::vector<T>>\
    \ st;\r\n    std::vector<T> lookup;\r\n    F f;\r\npublic:\r\n    SparseTable(const\
    \ std::vector<T> &v, const F &f_) : f(f_) {\r\n        int b = 0;\r\n        while((1\
    \ << b) <= std::ssize(v)) {\r\n            ++b;\r\n        }\r\n        st.assign(b,\
    \ std::vector<T>(1 << b));\r\n        for(const auto i: std::views::iota(0, std::ssize(v)))\
    \ {\r\n            st[0][i] = v[i];\r\n        }\r\n        for(const auto i:\
    \ std::views::iota(1, b)) {\r\n            for(int j = 0; j + (1 << i) <= (1 <<\
    \ b); j++) {\r\n                st[i][j] = f(st[i - 1][j], st[i - 1][j + (1 <<\
    \ (i - 1))]);\r\n            }\r\n        }\r\n        lookup.resize(std::ssize(v)\
    \ + 1);\r\n        for(const auto i: std::views::iota(2, std::ssize(lookup)))\
    \ {\r\n            lookup[i] = lookup[i >> 1] + 1;\r\n        }\r\n    }\r\n \
    \   constexpr inline T query(const T l, const T r) noexcept {\r\n        const\
    \ int b = lookup[r - l];\r\n        return f(st[b][l], st[b][r - (1 << b)]);\r\
    \n    }\r\n    template <class Boolean = bool> constexpr inline int min_left(const\
    \ int x, const Boolean &fn) noexcept {\r\n        if(x == 0) {\r\n           \
    \ return 0;\r\n        }\r\n        int ok = x, ng = -1;\r\n        while(std::abs(ok\
    \ - ng) > 1) {\r\n            const int mid = (ok + ng) / 2;\r\n            (fn(query(mid,\
    \ x) - 1) ? ok : ng) = mid;\r\n        }\r\n        return ok;\r\n    }\r\n  \
    \  template <class Boolean = bool> constexpr inline int max_right(const int x,\
    \ const Boolean &fn) noexcept {\r\n        if(x == std::ssize(lookup) - 1) {\r\
    \n            return std::ssize(lookup) - 1;\r\n        }\r\n        int ok =\
    \ x, ng = std::ssize(lookup);\r\n        while(std::abs(ok - ng) > 1) {\r\n  \
    \          const int mid = (ok + ng) / 2;\r\n            (fn(query(x, mid)) ?\
    \ ok : ng) = mid;\r\n        }\r\n        return ok;\r\n    }\r\n};\r\n}\r\n/**\r\
    \n * @brief Sparse Table\r\n * @see https://ei1333.github.io/luzhiled/snippets/structure/sparse-table.html\r\
    \n */\n"
  code: "#pragma once\r\n\r\n#include <vector>\r\n#include <functional>\r\n#include\
    \ <ranges>\r\nnamespace man {\r\ntemplate <class T> struct SparseTable {\r\nprivate:\r\
    \n    using F = std::function<T(T,T)>;\r\n    std::vector<std::vector<T>> st;\r\
    \n    std::vector<T> lookup;\r\n    F f;\r\npublic:\r\n    SparseTable(const std::vector<T>\
    \ &v, const F &f_) : f(f_) {\r\n        int b = 0;\r\n        while((1 << b) <=\
    \ std::ssize(v)) {\r\n            ++b;\r\n        }\r\n        st.assign(b, std::vector<T>(1\
    \ << b));\r\n        for(const auto i: std::views::iota(0, std::ssize(v))) {\r\
    \n            st[0][i] = v[i];\r\n        }\r\n        for(const auto i: std::views::iota(1,\
    \ b)) {\r\n            for(int j = 0; j + (1 << i) <= (1 << b); j++) {\r\n   \
    \             st[i][j] = f(st[i - 1][j], st[i - 1][j + (1 << (i - 1))]);\r\n \
    \           }\r\n        }\r\n        lookup.resize(std::ssize(v) + 1);\r\n  \
    \      for(const auto i: std::views::iota(2, std::ssize(lookup))) {\r\n      \
    \      lookup[i] = lookup[i >> 1] + 1;\r\n        }\r\n    }\r\n    constexpr\
    \ inline T query(const T l, const T r) noexcept {\r\n        const int b = lookup[r\
    \ - l];\r\n        return f(st[b][l], st[b][r - (1 << b)]);\r\n    }\r\n    template\
    \ <class Boolean = bool> constexpr inline int min_left(const int x, const Boolean\
    \ &fn) noexcept {\r\n        if(x == 0) {\r\n            return 0;\r\n       \
    \ }\r\n        int ok = x, ng = -1;\r\n        while(std::abs(ok - ng) > 1) {\r\
    \n            const int mid = (ok + ng) / 2;\r\n            (fn(query(mid, x)\
    \ - 1) ? ok : ng) = mid;\r\n        }\r\n        return ok;\r\n    }\r\n    template\
    \ <class Boolean = bool> constexpr inline int max_right(const int x, const Boolean\
    \ &fn) noexcept {\r\n        if(x == std::ssize(lookup) - 1) {\r\n           \
    \ return std::ssize(lookup) - 1;\r\n        }\r\n        int ok = x, ng = std::ssize(lookup);\r\
    \n        while(std::abs(ok - ng) > 1) {\r\n            const int mid = (ok +\
    \ ng) / 2;\r\n            (fn(query(x, mid)) ? ok : ng) = mid;\r\n        }\r\n\
    \        return ok;\r\n    }\r\n};\r\n}\r\n/**\r\n * @brief Sparse Table\r\n *\
    \ @see https://ei1333.github.io/luzhiled/snippets/structure/sparse-table.html\r\
    \n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/ds/SparseTable.hpp
  requiredBy: []
  timestamp: '2025-06-12 12:50:02+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/s_rmq.test.cpp
documentation_of: C++/ds/SparseTable.hpp
layout: document
redirect_from:
- /library/C++/ds/SparseTable.hpp
- /library/C++/ds/SparseTable.hpp.html
title: Sparse Table
---
