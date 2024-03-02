---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: C++/myvector.hpp
    title: C++/myvector.hpp
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
  - icon: ':heavy_check_mark:'
    path: test/C++/extgcd.test.cpp
    title: test/C++/extgcd.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/C++/fwtree.test.cpp
    title: test/C++/fwtree.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/C++/m_add.test.cpp
    title: test/C++/m_add.test.cpp
  - icon: ':heavy_check_mark:'
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
    document_title: "\u7D20\u56E0\u6570\u5206\u89E3\u30C6\u30FC\u30D6\u30EB"
    links: []
  bundledCode: "#line 2 \"C++/math/primefactortable.hpp\"\n\n#include <map>\n#include\
    \ <numeric>\n#line 2 \"C++/myvector.hpp\"\n\n#include <vector>\n\n#ifndef TEMPLATE\n\
    typedef long long ll;\ntypedef unsigned long long ul;\ntypedef long double ld;\n\
    #endif\nnamespace vectors {\ntemplate <class T> using V = std::vector<T>;\nusing\
    \ vi = V<ll>;\nusing vu = V<ul>;\nusing vd = V<ld>;\nusing vc = V<char>;\nusing\
    \ vs = V<std::string>;\nusing vb = V<bool>;\nusing wi = V<vi>;\nusing wu = V<vu>;\n\
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
    \ 6 \"C++/math/primefactortable.hpp\"\nnamespace Heileden {\nstruct p_fact {\n\
    \    vectors::vi spf;\n    p_fact(const int n): spf(n + 1){\n        std::iota(spf.begin(),\
    \ spf.end(), 0);\n        for(int64_t i = 2; i * i <= n; ++i) {\n            if(spf[i]==i)\
    \ {\n                for(int64_t j = i * i; j <= n; j += i) {\n              \
    \      if(spf[j]==j) spf[j]=i;\n                }\n            }\n        }\n\
    \    }\n    std::map<int,int> get(int n) {\n        std::map<int,int> m;\n   \
    \     while(n!=1) {\n            m[spf[n]]++;\n            n/=spf[n];\n      \
    \  }\n        return m;\n    }\n};\n}\n\n/**\n * @brief \u7D20\u56E0\u6570\u5206\
    \u89E3\u30C6\u30FC\u30D6\u30EB\n */\n"
  code: "#pragma once\n\n#include <map>\n#include <numeric>\n#include \"C++/myvector.hpp\"\
    \nnamespace Heileden {\nstruct p_fact {\n    vectors::vi spf;\n    p_fact(const\
    \ int n): spf(n + 1){\n        std::iota(spf.begin(), spf.end(), 0);\n       \
    \ for(int64_t i = 2; i * i <= n; ++i) {\n            if(spf[i]==i) {\n       \
    \         for(int64_t j = i * i; j <= n; j += i) {\n                    if(spf[j]==j)\
    \ spf[j]=i;\n                }\n            }\n        }\n    }\n    std::map<int,int>\
    \ get(int n) {\n        std::map<int,int> m;\n        while(n!=1) {\n        \
    \    m[spf[n]]++;\n            n/=spf[n];\n        }\n        return m;\n    }\n\
    };\n}\n\n/**\n * @brief \u7D20\u56E0\u6570\u5206\u89E3\u30C6\u30FC\u30D6\u30EB\
    \n */"
  dependsOn:
  - C++/myvector.hpp
  isVerificationFile: false
  path: C++/math/primefactortable.hpp
  requiredBy:
  - C++/template.hpp
  timestamp: '2024-02-19 13:17:33+09:00'
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
documentation_of: C++/math/primefactortable.hpp
layout: document
redirect_from:
- /library/C++/math/primefactortable.hpp
- /library/C++/math/primefactortable.hpp.html
title: "\u7D20\u56E0\u6570\u5206\u89E3\u30C6\u30FC\u30D6\u30EB"
---
