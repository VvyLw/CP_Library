---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    document_title: "\u30E9\u30F3\u30EC\u30F3\u30B0\u30B9\u5727\u7E2E"
    links: []
  bundledCode: "#line 2 \"C++/string/runlength.hpp\"\n\n#include <string>\nstd::string\
    \ rle(const std::string &s) {\n\tconst int n = s.size();\n\tstd::string t;\n\t\
    for(int l = 0; l < n;) {\n\t\tint r = l + 1;\n\t\tfor(; r < n && s[l] == s[r];\
    \ ++r){}\n\t\tt += s[l];\n\t\tt += std::to_string(r - l);\n\t\tl = r;\n\t}\n\t\
    return t;\n}\n\nstd::string rle_rev(const std::string &s) {\n\tconst int n = s.size();\n\
    \tstd::string t;\n\tfor(int l = 0; l < n;) {\n\t\tint r = l + 1;\n\t\tfor(; r\
    \ < n && '0' <= s[r] && s[r] <= '9'; ++r){}\n\t\tt += std::string(std::stoi(s.substr(l\
    \ + 1, r - l)), s[l]);\n\t\tl = r;\n\t}\n\treturn t;\n}\n\n/**\n * @brief \u30E9\
    \u30F3\u30EC\u30F3\u30B0\u30B9\u5727\u7E2E\n */\n"
  code: "#pragma once\n\n#include <string>\nstd::string rle(const std::string &s)\
    \ {\n\tconst int n = s.size();\n\tstd::string t;\n\tfor(int l = 0; l < n;) {\n\
    \t\tint r = l + 1;\n\t\tfor(; r < n && s[l] == s[r]; ++r){}\n\t\tt += s[l];\n\t\
    \tt += std::to_string(r - l);\n\t\tl = r;\n\t}\n\treturn t;\n}\n\nstd::string\
    \ rle_rev(const std::string &s) {\n\tconst int n = s.size();\n\tstd::string t;\n\
    \tfor(int l = 0; l < n;) {\n\t\tint r = l + 1;\n\t\tfor(; r < n && '0' <= s[r]\
    \ && s[r] <= '9'; ++r){}\n\t\tt += std::string(std::stoi(s.substr(l + 1, r - l)),\
    \ s[l]);\n\t\tl = r;\n\t}\n\treturn t;\n}\n\n/**\n * @brief \u30E9\u30F3\u30EC\
    \u30F3\u30B0\u30B9\u5727\u7E2E\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/string/runlength.hpp
  requiredBy: []
  timestamp: '2024-02-19 12:47:06+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/string/runlength.hpp
layout: document
redirect_from:
- /library/C++/string/runlength.hpp
- /library/C++/string/runlength.hpp.html
title: "\u30E9\u30F3\u30EC\u30F3\u30B0\u30B9\u5727\u7E2E"
---
