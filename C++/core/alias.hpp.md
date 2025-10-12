---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
  - icon: ':heavy_check_mark:'
    path: C++/template.hpp
    title: "\u30C6\u30F3\u30D7\u30EC\u30FC\u30C8"
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/aarray.test.cpp
    title: test/aarray.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/add.test.cpp
    title: test/add.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/add128.test.cpp
    title: test/add128.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/extgcd.test.cpp
    title: test/extgcd.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/fwtree.test.cpp
    title: test/fwtree.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/m_add.test.cpp
    title: test/m_add.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/parsum.test.cpp
    title: test/parsum.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/rh.test.cpp
    title: test/rh.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/s_rmq.test.cpp
    title: test/s_rmq.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/segtree.test.cpp
    title: test/segtree.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/sr_sum.test.cpp
    title: test/sr_sum.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/uf.test.cpp
    title: test/uf.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: "\u30A8\u30A4\u30EA\u30A2\u30B9"
    links: []
  bundledCode: "#line 2 \"C++/core/alias.hpp\"\n\n#ifndef ALIAS\n#define ALIAS\n#endif\n\
    \n#include <limits>\n#include <numbers>\n#include <queue>\n#include <ext/pb_ds/assoc_container.hpp>\n\
    #include <ext/pb_ds/tree_policy.hpp>\n\nnamespace internal {\ntemplate <typename\
    \ T> concept num = std::integral<T> || std::floating_point<T>;\n}\n\nconstexpr\
    \ int dx[] = {0, 0, 0, -1, 1, -1, -1, 1, 1};\nconstexpr int dy[] = {0, -1, 1,\
    \ 0, 0, -1, 1, -1, 1};\nconstexpr int MOD = 0x3b800001;\nconstexpr int M0D = 1e9\
    \ + 7;\nconstexpr int INF = 1 << 30;\nconstexpr long long LINF = (1LL << 61) -\
    \ 1;\nconstexpr long double DINF = std::numeric_limits<long double>::infinity();\n\
    constexpr long double PI = std::numbers::pi;\nconstexpr long double E = std::numbers::e;\n\
    \ntypedef long long i64;\ntypedef long double ld;\ntypedef unsigned u32;\ntypedef\
    \ unsigned long long u64;\ntypedef __int128_t i128;\ntypedef __uint128_t u128;\n\
    namespace man {\ntemplate <size_t N> using ti = std::array<i64, N>;\ntypedef ti<3>\
    \ tri;\ntemplate <class T> using pq = std::priority_queue<T>;\ntemplate <class\
    \ T> using pqr = std::priority_queue<T, std::vector<T>, std::greater<T>>;\ntemplate\
    \ <class T> using Tree = __gnu_pbds::tree<T, __gnu_pbds::null_type, std::less<T>,\
    \ __gnu_pbds::rb_tree_tag, __gnu_pbds::tree_order_statistics_node_update>;\ntemplate\
    \ <class T> using TREE = __gnu_pbds::tree<T, __gnu_pbds::null_type, std::greater<T>,\
    \ __gnu_pbds::rb_tree_tag, __gnu_pbds::tree_order_statistics_node_update>;\n}\n\
    \n/**\n * @brief \u30A8\u30A4\u30EA\u30A2\u30B9\n */\n"
  code: "#pragma once\n\n#ifndef ALIAS\n#define ALIAS\n#endif\n\n#include <limits>\n\
    #include <numbers>\n#include <queue>\n#include <ext/pb_ds/assoc_container.hpp>\n\
    #include <ext/pb_ds/tree_policy.hpp>\n\nnamespace internal {\ntemplate <typename\
    \ T> concept num = std::integral<T> || std::floating_point<T>;\n}\n\nconstexpr\
    \ int dx[] = {0, 0, 0, -1, 1, -1, -1, 1, 1};\nconstexpr int dy[] = {0, -1, 1,\
    \ 0, 0, -1, 1, -1, 1};\nconstexpr int MOD = 0x3b800001;\nconstexpr int M0D = 1e9\
    \ + 7;\nconstexpr int INF = 1 << 30;\nconstexpr long long LINF = (1LL << 61) -\
    \ 1;\nconstexpr long double DINF = std::numeric_limits<long double>::infinity();\n\
    constexpr long double PI = std::numbers::pi;\nconstexpr long double E = std::numbers::e;\n\
    \ntypedef long long i64;\ntypedef long double ld;\ntypedef unsigned u32;\ntypedef\
    \ unsigned long long u64;\ntypedef __int128_t i128;\ntypedef __uint128_t u128;\n\
    namespace man {\ntemplate <size_t N> using ti = std::array<i64, N>;\ntypedef ti<3>\
    \ tri;\ntemplate <class T> using pq = std::priority_queue<T>;\ntemplate <class\
    \ T> using pqr = std::priority_queue<T, std::vector<T>, std::greater<T>>;\ntemplate\
    \ <class T> using Tree = __gnu_pbds::tree<T, __gnu_pbds::null_type, std::less<T>,\
    \ __gnu_pbds::rb_tree_tag, __gnu_pbds::tree_order_statistics_node_update>;\ntemplate\
    \ <class T> using TREE = __gnu_pbds::tree<T, __gnu_pbds::null_type, std::greater<T>,\
    \ __gnu_pbds::rb_tree_tag, __gnu_pbds::tree_order_statistics_node_update>;\n}\n\
    \n/**\n * @brief \u30A8\u30A4\u30EA\u30A2\u30B9\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/core/alias.hpp
  requiredBy:
  - C++/template.hpp
  timestamp: '2025-09-02 10:21:41+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/parsum.test.cpp
  - test/aarray.test.cpp
  - test/uf.test.cpp
  - test/segtree.test.cpp
  - test/s_rmq.test.cpp
  - test/rh.test.cpp
  - test/extgcd.test.cpp
  - test/m_add.test.cpp
  - test/add.test.cpp
  - test/add128.test.cpp
  - test/sr_sum.test.cpp
  - test/fwtree.test.cpp
documentation_of: C++/core/alias.hpp
layout: document
redirect_from:
- /library/C++/core/alias.hpp
- /library/C++/core/alias.hpp.html
title: "\u30A8\u30A4\u30EA\u30A2\u30B9"
---
