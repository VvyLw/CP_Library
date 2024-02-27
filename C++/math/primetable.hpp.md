---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/myvector.hpp
    title: C++/myvector.hpp
  _extendedRequiredBy:
  - icon: ':heavy_check_mark:'
    path: C++/math/primecounter.hpp
    title: "\u7D20\u6570\u306E\u500B\u6570"
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
    path: test/pcounter.test.cpp
    title: test/pcounter.test.cpp
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
    document_title: Sieve of Eratosthenes
    links: []
  bundledCode: "#line 2 \"C++/math/primetable.hpp\"\n\n#line 2 \"C++/myvector.hpp\"\
    \n\n#include <vector>\n\n#ifndef TEMPLATE\ntypedef long long ll;\ntypedef unsigned\
    \ long long ul;\ntypedef long double ld;\n#endif\nnamespace vectors {\ntemplate\
    \ <class T> using V = std::vector<T>;\nusing vi = V<ll>;\nusing vu = V<ul>;\n\
    using vd = V<ld>;\nusing vc = V<char>;\nusing vs = V<std::string>;\nusing vb =\
    \ V<bool>;\nusing wi = V<vi>;\nusing wu = V<vu>;\nusing wd = V<vd>;\nusing wc\
    \ = V<vc>;\nusing ws = V<vs>;\nusing wb = V<vb>;\ntemplate <class T, class U>\
    \ inline V<U> ndiv(T&& n, U&& v) noexcept {\n  return V<U>(std::forward<T>(n),\
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
    \ 4 \"C++/math/primetable.hpp\"\nnamespace Heileden {\nstruct p_table {\n    vectors::vb\
    \ SoE;\n    p_table(const int n): SoE(n+1,1){\n        SoE[0]=SoE[1]=0;\n    \
    \    for(int64_t i = 2; i <= n; ++i) {\n            if(!SoE[i]) continue;\n  \
    \          for(int64_t j = i * i; j <= n; j += i) SoE[j] = 0;\n        }\n   \
    \ }\n    vectors::vi get() {\n        vectors::vi p;\n        for(size_t i = 2;\
    \ i < SoE.size(); ++i) if(SoE[i]) p.emplace_back(i);\n        return p;\n    }\n\
    };\n}\n\n/**\n * @brief Sieve of Eratosthenes\n */\n"
  code: "#pragma once\n\n#include \"C++/myvector.hpp\"\nnamespace Heileden {\nstruct\
    \ p_table {\n    vectors::vb SoE;\n    p_table(const int n): SoE(n+1,1){\n   \
    \     SoE[0]=SoE[1]=0;\n        for(int64_t i = 2; i <= n; ++i) {\n          \
    \  if(!SoE[i]) continue;\n            for(int64_t j = i * i; j <= n; j += i) SoE[j]\
    \ = 0;\n        }\n    }\n    vectors::vi get() {\n        vectors::vi p;\n  \
    \      for(size_t i = 2; i < SoE.size(); ++i) if(SoE[i]) p.emplace_back(i);\n\
    \        return p;\n    }\n};\n}\n\n/**\n * @brief Sieve of Eratosthenes\n */"
  dependsOn:
  - C++/myvector.hpp
  isVerificationFile: false
  path: C++/math/primetable.hpp
  requiredBy:
  - C++/math/primecounter.hpp
  - C++/template.hpp
  timestamp: '2024-02-19 13:17:33+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/sr_sum.test.cpp
  - test/m_add.test.cpp
  - test/add.test.cpp
  - test/parsum.test.cpp
  - test/segtree.test.cpp
  - test/stable.test.cpp
  - test/pcounter.test.cpp
  - test/fwtree.test.cpp
  - test/uf.test.cpp
  - test/extgcd.test.cpp
  - test/add128.test.cpp
  - test/s_rmq.test.cpp
  - test/aarray.test.cpp
documentation_of: C++/math/primetable.hpp
layout: document
redirect_from:
- /library/C++/math/primetable.hpp
- /library/C++/math/primetable.hpp.html
title: Sieve of Eratosthenes
---
