---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: C++/myvector.hpp
    title: C++/myvector.hpp
  _extendedRequiredBy:
  - icon: ':x:'
    path: C++/math/primecounter.hpp
    title: "\u7D20\u6570\u306E\u500B\u6570"
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
    path: test/C++/pcounter.test.cpp
    title: test/C++/pcounter.test.cpp
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
  verificationStatus: LIBRARY_SOME_WA
  verifiedWith:
  - test/C++/sr_sum.test.cpp
  - test/C++/m_add.test.cpp
  - test/C++/add.test.cpp
  - test/C++/parsum.test.cpp
  - test/C++/segtree.test.cpp
  - test/C++/stable.test.cpp
  - test/C++/pcounter.test.cpp
  - test/C++/fwtree.test.cpp
  - test/C++/uf.test.cpp
  - test/C++/extgcd.test.cpp
  - test/C++/add128.test.cpp
  - test/C++/s_rmq.test.cpp
  - test/C++/aarray.test.cpp
documentation_of: C++/math/primetable.hpp
layout: document
redirect_from:
- /library/C++/math/primetable.hpp
- /library/C++/math/primetable.hpp.html
title: Sieve of Eratosthenes
---
