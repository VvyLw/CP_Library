---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
  - icon: ':question:'
    path: C++/template.hpp
    title: "\u30C6\u30F3\u30D7\u30EC\u30FC\u30C8"
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/C++/aarray.test.cpp
    title: test/C++/aarray.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/C++/add.test.cpp
    title: test/C++/add.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/C++/add128.test.cpp
    title: test/C++/add128.test.cpp
  - icon: ':x:'
    path: test/C++/extgcd.test.cpp
    title: test/C++/extgcd.test.cpp
  - icon: ':x:'
    path: test/C++/fwtree.test.cpp
    title: test/C++/fwtree.test.cpp
  - icon: ':x:'
    path: test/C++/m_add.test.cpp
    title: test/C++/m_add.test.cpp
  - icon: ':x:'
    path: test/C++/parsum.test.cpp
    title: test/C++/parsum.test.cpp
  - icon: ':x:'
    path: test/C++/s_rmq.test.cpp
    title: test/C++/s_rmq.test.cpp
  - icon: ':x:'
    path: test/C++/segtree.test.cpp
    title: test/C++/segtree.test.cpp
  - icon: ':x:'
    path: test/C++/sr_sum.test.cpp
    title: test/C++/sr_sum.test.cpp
  - icon: ':x:'
    path: test/C++/stable.test.cpp
    title: test/C++/stable.test.cpp
  - icon: ':x:'
    path: test/C++/uf.test.cpp
    title: test/C++/uf.test.cpp
  _isVerificationFailed: true
  _pathExtension: hpp
  _verificationStatusIcon: ':question:'
  attributes:
    document_title: "\u30BF\u30A4\u30DE\u30FC"
    links: []
  bundledCode: "#line 2 \"C++/timer.hpp\"\n\n#include <ostream>\n#include <chrono>\n\
    using Timer = std::chrono::system_clock::time_point;\n[[maybe_unused]] Timer start,\
    \ stop;\n#if local\nvoid now(Timer &t){ t = std::chrono::system_clock::now();\
    \ }\nvoid time(const Timer &t1, const Timer &t2){ std::cerr << std::chrono::duration_cast<std::chrono::milliseconds>(t2\
    \ - t1).count() << \"ms\\n\"; }\n#else\n[[maybe_unused]] void now(Timer &t){ void(0);\
    \ }\n[[maybe_unused]] void time(const Timer &t1, const Timer &t2){ void(0); }\n\
    #endif\n\n/**\n * @brief \u30BF\u30A4\u30DE\u30FC\n */\n"
  code: "#pragma once\n\n#include <ostream>\n#include <chrono>\nusing Timer = std::chrono::system_clock::time_point;\n\
    [[maybe_unused]] Timer start, stop;\n#if local\nvoid now(Timer &t){ t = std::chrono::system_clock::now();\
    \ }\nvoid time(const Timer &t1, const Timer &t2){ std::cerr << std::chrono::duration_cast<std::chrono::milliseconds>(t2\
    \ - t1).count() << \"ms\\n\"; }\n#else\n[[maybe_unused]] void now(Timer &t){ void(0);\
    \ }\n[[maybe_unused]] void time(const Timer &t1, const Timer &t2){ void(0); }\n\
    #endif\n\n/**\n * @brief \u30BF\u30A4\u30DE\u30FC\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/timer.hpp
  requiredBy:
  - C++/template.hpp
  timestamp: '2024-02-19 12:20:55+09:00'
  verificationStatus: LIBRARY_SOME_WA
  verifiedWith:
  - test/C++/sr_sum.test.cpp
  - test/C++/m_add.test.cpp
  - test/C++/add.test.cpp
  - test/C++/parsum.test.cpp
  - test/C++/segtree.test.cpp
  - test/C++/stable.test.cpp
  - test/C++/fwtree.test.cpp
  - test/C++/uf.test.cpp
  - test/C++/extgcd.test.cpp
  - test/C++/add128.test.cpp
  - test/C++/s_rmq.test.cpp
  - test/C++/aarray.test.cpp
documentation_of: C++/timer.hpp
layout: document
redirect_from:
- /library/C++/timer.hpp
- /library/C++/timer.hpp.html
title: "\u30BF\u30A4\u30DE\u30FC"
---
