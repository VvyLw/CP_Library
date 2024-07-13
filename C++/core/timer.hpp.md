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
    path: test/s_rmq.test.cpp
    title: test/s_rmq.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/segtree.test.cpp
    title: test/segtree.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/sr_sum.test.cpp
    title: test/sr_sum.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/stable.test.cpp
    title: test/stable.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/uf.test.cpp
    title: test/uf.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: "\u30BF\u30A4\u30DE\u30FC"
    links: []
  bundledCode: "#line 2 \"C++/core/timer.hpp\"\n\n#include <ostream>\n#include <chrono>\n\
    using Timer = std::chrono::system_clock::time_point;\nTimer start, stop;\n#if\
    \ local\nvoid now(Timer &t){ t = std::chrono::system_clock::now(); }\nvoid time(const\
    \ Timer &t1, const Timer &t2){ std::cerr << std::chrono::duration_cast<std::chrono::milliseconds>(t2\
    \ - t1).count() << \"ms\\n\"; }\n#else\nvoid now(Timer &t){ void(0); }\nvoid time(const\
    \ Timer &t1, const Timer &t2){ void(0); }\n#endif\n\n/**\n * @brief \u30BF\u30A4\
    \u30DE\u30FC\n */\n"
  code: "#pragma once\n\n#include <ostream>\n#include <chrono>\nusing Timer = std::chrono::system_clock::time_point;\n\
    Timer start, stop;\n#if local\nvoid now(Timer &t){ t = std::chrono::system_clock::now();\
    \ }\nvoid time(const Timer &t1, const Timer &t2){ std::cerr << std::chrono::duration_cast<std::chrono::milliseconds>(t2\
    \ - t1).count() << \"ms\\n\"; }\n#else\nvoid now(Timer &t){ void(0); }\nvoid time(const\
    \ Timer &t1, const Timer &t2){ void(0); }\n#endif\n\n/**\n * @brief \u30BF\u30A4\
    \u30DE\u30FC\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/core/timer.hpp
  requiredBy:
  - C++/template.hpp
  timestamp: '2024-06-16 14:19:50+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/add.test.cpp
  - test/s_rmq.test.cpp
  - test/aarray.test.cpp
  - test/segtree.test.cpp
  - test/sr_sum.test.cpp
  - test/extgcd.test.cpp
  - test/fwtree.test.cpp
  - test/uf.test.cpp
  - test/add128.test.cpp
  - test/stable.test.cpp
  - test/m_add.test.cpp
  - test/parsum.test.cpp
documentation_of: C++/core/timer.hpp
layout: document
redirect_from:
- /library/C++/core/timer.hpp
- /library/C++/core/timer.hpp.html
title: "\u30BF\u30A4\u30DE\u30FC"
---
