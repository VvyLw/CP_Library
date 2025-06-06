---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    links: []
  bundledCode: "#line 2 \"C++/other/is_iterable.hpp\"\n\n#include <type_traits>\n\
    #include <concepts>\n#include <iterator>\n\ntemplate <class T> concept is_iterable\
    \ = requires(const T &a) {\n    { std::begin(a) } -> std::same_as<typename std::remove_reference<decltype(std::begin(a))>::type>;\n\
    \    { std::end(a) } -> std::same_as<typename std::remove_reference<decltype(std::end(a))>::type>;\n\
    };\n"
  code: "#pragma once\n\n#include <type_traits>\n#include <concepts>\n#include <iterator>\n\
    \ntemplate <class T> concept is_iterable = requires(const T &a) {\n    { std::begin(a)\
    \ } -> std::same_as<typename std::remove_reference<decltype(std::begin(a))>::type>;\n\
    \    { std::end(a) } -> std::same_as<typename std::remove_reference<decltype(std::end(a))>::type>;\n\
    };"
  dependsOn: []
  isVerificationFile: false
  path: C++/other/is_iterable.hpp
  requiredBy: []
  timestamp: '2025-06-06 22:43:06+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/other/is_iterable.hpp
layout: document
redirect_from:
- /library/C++/other/is_iterable.hpp
- /library/C++/other/is_iterable.hpp.html
title: C++/other/is_iterable.hpp
---
