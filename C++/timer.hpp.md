---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
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
  requiredBy: []
  timestamp: '2024-02-19 12:20:55+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/timer.hpp
layout: document
redirect_from:
- /library/C++/timer.hpp
- /library/C++/timer.hpp.html
title: "\u30BF\u30A4\u30DE\u30FC"
---
