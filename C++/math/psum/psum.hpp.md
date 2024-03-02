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
    path: test/aarray.test.cpp
    title: test/aarray.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/add.test.cpp
    title: test/add.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/add128.test.cpp
    title: test/add128.test.cpp
  - icon: ':x:'
    path: test/extgcd.test.cpp
    title: test/extgcd.test.cpp
  - icon: ':x:'
    path: test/fwtree.test.cpp
    title: test/fwtree.test.cpp
  - icon: ':x:'
    path: test/m_add.test.cpp
    title: test/m_add.test.cpp
  - icon: ':x:'
    path: test/parsum.test.cpp
    title: test/parsum.test.cpp
  - icon: ':x:'
    path: test/s_rmq.test.cpp
    title: test/s_rmq.test.cpp
  - icon: ':x:'
    path: test/segtree.test.cpp
    title: test/segtree.test.cpp
  - icon: ':x:'
    path: test/sr_sum.test.cpp
    title: test/sr_sum.test.cpp
  - icon: ':x:'
    path: test/stable.test.cpp
    title: test/stable.test.cpp
  - icon: ':x:'
    path: test/uf.test.cpp
    title: test/uf.test.cpp
  _isVerificationFailed: true
  _pathExtension: hpp
  _verificationStatusIcon: ':question:'
  attributes:
    document_title: "\u7D2F\u7A4D\u548C"
    links: []
  bundledCode: "#line 2 \"C++/math/psum/psum.hpp\"\n\n#include <cassert>\n#include\
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
    \ 6 \"C++/math/psum/psum.hpp\"\nnamespace Heileden {\nstruct psum {\nprivate:\n\
    \    int n;\n    bool not_built;\n    vectors::vi s, imos;\npublic:\n    psum(const\
    \ vectors::vi& v): s{0} { std::partial_sum(v.begin(), v.end(), std::back_inserter(s));\
    \ }\n    psum(const int n): n(n), not_built(true), imos(n + 1){}\n    vectors::vi\
    \ get() const { return s; }\n    // [l, r]\n    ll query(const int l, const int\
    \ r) const { return s[r] - s[l]; }\n    void add(const int l, const int r, const\
    \ ll x = 1) {\n\t\tassert(not_built);\n\t\timos[l] += x;\n\t\timos[r] -= x;\n\t\
    }\n    vectors::vi build() {\n\t\tassert(not_built);\n        vectors::vi res;\n\
    \t\tstd::partial_sum(imos.begin(), imos.end(), std::back_inserter(res));\n\t\t\
    not_built = false;\n        res.resize(n);\n\t\treturn res;\n\t}\n};\n}\n\n/**\n\
    \ * @brief \u7D2F\u7A4D\u548C\n */\n"
  code: "#pragma once\n\n#include <cassert>\n#include <numeric>\n#include \"C++/myvector.hpp\"\
    \nnamespace Heileden {\nstruct psum {\nprivate:\n    int n;\n    bool not_built;\n\
    \    vectors::vi s, imos;\npublic:\n    psum(const vectors::vi& v): s{0} { std::partial_sum(v.begin(),\
    \ v.end(), std::back_inserter(s)); }\n    psum(const int n): n(n), not_built(true),\
    \ imos(n + 1){}\n    vectors::vi get() const { return s; }\n    // [l, r]\n  \
    \  ll query(const int l, const int r) const { return s[r] - s[l]; }\n    void\
    \ add(const int l, const int r, const ll x = 1) {\n\t\tassert(not_built);\n\t\t\
    imos[l] += x;\n\t\timos[r] -= x;\n\t}\n    vectors::vi build() {\n\t\tassert(not_built);\n\
    \        vectors::vi res;\n\t\tstd::partial_sum(imos.begin(), imos.end(), std::back_inserter(res));\n\
    \t\tnot_built = false;\n        res.resize(n);\n\t\treturn res;\n\t}\n};\n}\n\n\
    /**\n * @brief \u7D2F\u7A4D\u548C\n */"
  dependsOn:
  - C++/myvector.hpp
  isVerificationFile: false
  path: C++/math/psum/psum.hpp
  requiredBy:
  - C++/template.hpp
  timestamp: '2024-02-29 11:00:00+09:00'
  verificationStatus: LIBRARY_SOME_WA
  verifiedWith:
  - test/sr_sum.test.cpp
  - test/m_add.test.cpp
  - test/add.test.cpp
  - test/parsum.test.cpp
  - test/segtree.test.cpp
  - test/stable.test.cpp
  - test/fwtree.test.cpp
  - test/uf.test.cpp
  - test/extgcd.test.cpp
  - test/add128.test.cpp
  - test/s_rmq.test.cpp
  - test/aarray.test.cpp
documentation_of: C++/math/psum/psum.hpp
layout: document
redirect_from:
- /library/C++/math/psum/psum.hpp
- /library/C++/math/psum/psum.hpp.html
title: "\u7D2F\u7A4D\u548C"
---
