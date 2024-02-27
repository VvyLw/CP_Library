---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/myvector.hpp
    title: C++/myvector.hpp
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
    path: test/m_add.test.cpp
    title: test/m_add.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/sr_sum.test.cpp
    title: test/sr_sum.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: "\u7D04\u6570\u5217\u6319"
    links: []
  bundledCode: "#line 2 \"C++/math/divisor.hpp\"\n\n#include <algorithm>\n#line 2\
    \ \"C++/myvector.hpp\"\n\n#include <vector>\n\n#ifndef TEMPLATE\ntypedef long\
    \ long ll;\ntypedef unsigned long long ul;\ntypedef long double ld;\n#endif\n\
    namespace vectors {\ntemplate <class T> using V = std::vector<T>;\nusing vi =\
    \ V<ll>;\nusing vu = V<ul>;\nusing vd = V<ld>;\nusing vc = V<char>;\nusing vs\
    \ = V<std::string>;\nusing vb = V<bool>;\nusing wi = V<vi>;\nusing wu = V<vu>;\n\
    using wd = V<vd>;\nusing wc = V<vc>;\nusing ws = V<vs>;\nusing wb = V<vb>;\ntemplate\
    \ <class T, class U> inline V<U> ndiv(T&& n, U&& v) noexcept {\n  return V<U>(std::forward<T>(n),\
    \ std::forward<U>(v));\n}\ntemplate <class T, class... Ts> inline decltype(auto)\
    \ ndiv(T&& n, Ts&&... v) noexcept {\n  return V<decltype(ndiv(std::forward<Ts>(v)...))>(std::forward<T>(n),\
    \ ndiv(std::forward<Ts>(v)...));\n}\ntemplate <class T> constexpr V<T>& operator++(V<T>&\
    \ v) noexcept { for(auto &el: v) el++; return v; }\ntemplate <class T> constexpr\
    \ V<T>& operator--(V<T>& v) noexcept { for(auto &el: v) el--; return v; }\ntemplate\
    \ <class T, class U> constexpr V<T>& operator+=(V<T>& v, const U x) noexcept {\
    \ for(auto &el: v) el+=x; return v; }\ntemplate <class T, class U> constexpr V<T>&\
    \ operator-=(V<T>& v, const U x) noexcept { for(auto &el: v) el-=x; return v;\
    \ }\ntemplate <class T, class U> constexpr V<T>& operator*=(V<T>& v, const U x)\
    \ noexcept { for(auto &el: v) el*=x; return v; }\ntemplate <class T, class U>\
    \ constexpr V<T>& operator/=(V<T>& v, const U x) noexcept { for(auto &el: v) el/=x;\
    \ return v; }\ntemplate <class T, class U> constexpr V<T>& operator%=(V<T>& v,\
    \ const U x) noexcept { for(auto &el: v) el%=x; return v; }\ntemplate <class T,\
    \ class U> constexpr V<T> operator+(const V<T>& v, const U x) noexcept { V<T>\
    \ res = v; res+=x; return res; }\ntemplate <class T, class U> constexpr V<T> operator-(const\
    \ V<T>& v, const U x) noexcept { V<T> res = v; res-=x; return res; }\ntemplate\
    \ <class T, class U> constexpr V<T> operator*(const V<T>& v, const U x) noexcept\
    \ { V<T> res = v; res*=x; return res; }\ntemplate <class T, class U> constexpr\
    \ V<T> operator/(const V<T>& v, const U x) noexcept { V<T> res = v; res/=x; return\
    \ res; }\ntemplate <class T, class U> constexpr V<T> operator%(const V<T>& v,\
    \ const U x) noexcept { V<T> res = v; res%=x; return res; }\n} // vectors\n#line\
    \ 5 \"C++/math/divisor.hpp\"\nnamespace Heileden {\ntemplate <class T> inline\
    \ vectors::V<T> div(const T n) {\n    vectors::V<T> d;\n    for(long long i =\
    \ 1; i * i <= n; ++i) {\n        if(n%i==0) {\n            d.emplace_back(i);\n\
    \            if(i*i!=n) d.emplace_back(n/i);\n        }\n    }\n    std::sort(d.begin(),\
    \ d.end());\n    return d;\n}\n}\n\n/**\n * @brief \u7D04\u6570\u5217\u6319\n\
    \ */\n"
  code: "#pragma once\n\n#include <algorithm>\n#include \"C++/myvector.hpp\"\nnamespace\
    \ Heileden {\ntemplate <class T> inline vectors::V<T> div(const T n) {\n    vectors::V<T>\
    \ d;\n    for(long long i = 1; i * i <= n; ++i) {\n        if(n%i==0) {\n    \
    \        d.emplace_back(i);\n            if(i*i!=n) d.emplace_back(n/i);\n   \
    \     }\n    }\n    std::sort(d.begin(), d.end());\n    return d;\n}\n}\n\n/**\n\
    \ * @brief \u7D04\u6570\u5217\u6319\n */"
  dependsOn:
  - C++/myvector.hpp
  isVerificationFile: false
  path: C++/math/divisor.hpp
  requiredBy:
  - C++/template.hpp
  timestamp: '2024-02-22 09:22:35+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/sr_sum.test.cpp
  - test/m_add.test.cpp
  - test/add.test.cpp
  - test/extgcd.test.cpp
  - test/add128.test.cpp
  - test/aarray.test.cpp
documentation_of: C++/math/divisor.hpp
layout: document
redirect_from:
- /library/C++/math/divisor.hpp
- /library/C++/math/divisor.hpp.html
title: "\u7D04\u6570\u5217\u6319"
---
