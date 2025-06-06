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
    path: test/add128_2.test.cpp
    title: test/add128_2.test.cpp
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
    document_title: "\u51FA\u529B"
    links:
    - https://gist.github.com/naskya/1e5e5cd269cfe16a76988378a60e2ca3
  bundledCode: "#line 2 \"C++/core/io/output.hpp\"\n\n#include <iostream>\n#include\
    \ <vector>\n#include <utility>\n#include <map>\n#include <set>\n#include <deque>\n\
    namespace IO {\ninline std::ostream &operator<<(std::ostream &dest, const __int128_t\
    \ &value) noexcept {\n    std::ostream::sentry s(dest);\n    constexpr char dig[]\
    \ = \"0123456789\";\n    if(s) {\n        __uint128_t tmp = value < 0 ? -value\
    \ : value;\n        char buffer[128];\n        char *d = std::end(buffer);\n \
    \       do {\n            --d;\n            *d = dig[tmp % 10];\n            tmp\
    \ /= 10;\n        } while(tmp != 0);\n        if(value < 0) {\n            --d;\n\
    \            *d = '-';\n        }\n        const int len = std::end(buffer) -\
    \ d;\n        if(dest.rdbuf() -> sputn(d, len) != len) {\n            dest.setstate(std::ios_base::badbit);\n\
    \        }\n    }\n    return dest;\n}\ntemplate <class T, class U> inline std::ostream&\
    \ operator<<(std::ostream &os, const std::pair<T, U> &p) noexcept { os << p.first\
    \ << ' ' << p.second; return os; }\ntemplate <class T, size_t N> inline std::ostream&\
    \ operator<<(std::ostream &os, const std::array<T, N> &a) noexcept {\n    if(!a.empty())\
    \ {\n        os << a.front();\n        for(auto i = a.begin(); ++i != a.end();)\
    \ {\n            os << ' ' << *i;\n        }\n    }\n    return os;\n}\ntemplate\
    \ <class T> inline std::ostream& operator<<(std::ostream &os, const std::vector<T>\
    \ &v) noexcept {\n    if(!v.empty()) {\n        os << v.front();\n        for(auto\
    \ i = v.begin(); ++i != v.end();) {\n            os << ' ' << *i;\n        }\n\
    \    }\n    return os;\n}\ntemplate <class K, class V> inline std::ostream& operator<<(std::ostream\
    \ &os, const std::map<K, V> &m) noexcept {\n    if(!m.empty()) {\n        os <<\
    \ m.begin()->first << ' ' << m.begin()->second;\n        for(auto i = m.begin();\
    \ ++i != m.end();) {\n            os << '\\n' << i->first << ' ' << i->second;\n\
    \        }\n    }\n    return os;\n}\ntemplate <class T> inline std::ostream&\
    \ operator<<(std::ostream &os, const std::set<T> &st) noexcept {\n    if(!st.empty())\
    \ {\n        os << *st.begin();\n        for(auto i = st.begin(); ++i != st.end();)\
    \ {\n            os << ' ' << *i;\n        }\n    }\n    return os;\n}\ntemplate\
    \ <class T> inline std::ostream& operator<<(std::ostream &os, const std::multiset<T>\
    \ &ms) noexcept {\n    if(!ms.empty()) {\n        os << *ms.begin();\n       \
    \ for(auto i = ms.begin(); ++i != ms.end();) {\n            os << ' ' << *i;\n\
    \        }\n    }\n    return os;\n}\ntemplate <class T> inline std::ostream&\
    \ operator<<(std::ostream &os, const std::deque<T> &dq) noexcept {\n    if(!dq.empty())\
    \ {\n        os << dq.front();\n        for(auto i = dq.begin(); ++i != dq.end();)\
    \ {\n            os << ' ' << *i;\n        }\n    }\n    return os;\n}\n} // IO\n\
    \n#if local\n//https://gist.github.com/naskya/1e5e5cd269cfe16a76988378a60e2ca3\n\
    #include <C++/core/io/debug_print.hpp>\n#else\n#define dump(...) static_cast<void>(0)\n\
    #endif\n\n/**\n * @brief \u51FA\u529B\n */\n"
  code: "#pragma once\n\n#include <iostream>\n#include <vector>\n#include <utility>\n\
    #include <map>\n#include <set>\n#include <deque>\nnamespace IO {\ninline std::ostream\
    \ &operator<<(std::ostream &dest, const __int128_t &value) noexcept {\n    std::ostream::sentry\
    \ s(dest);\n    constexpr char dig[] = \"0123456789\";\n    if(s) {\n        __uint128_t\
    \ tmp = value < 0 ? -value : value;\n        char buffer[128];\n        char *d\
    \ = std::end(buffer);\n        do {\n            --d;\n            *d = dig[tmp\
    \ % 10];\n            tmp /= 10;\n        } while(tmp != 0);\n        if(value\
    \ < 0) {\n            --d;\n            *d = '-';\n        }\n        const int\
    \ len = std::end(buffer) - d;\n        if(dest.rdbuf() -> sputn(d, len) != len)\
    \ {\n            dest.setstate(std::ios_base::badbit);\n        }\n    }\n   \
    \ return dest;\n}\ntemplate <class T, class U> inline std::ostream& operator<<(std::ostream\
    \ &os, const std::pair<T, U> &p) noexcept { os << p.first << ' ' << p.second;\
    \ return os; }\ntemplate <class T, size_t N> inline std::ostream& operator<<(std::ostream\
    \ &os, const std::array<T, N> &a) noexcept {\n    if(!a.empty()) {\n        os\
    \ << a.front();\n        for(auto i = a.begin(); ++i != a.end();) {\n        \
    \    os << ' ' << *i;\n        }\n    }\n    return os;\n}\ntemplate <class T>\
    \ inline std::ostream& operator<<(std::ostream &os, const std::vector<T> &v) noexcept\
    \ {\n    if(!v.empty()) {\n        os << v.front();\n        for(auto i = v.begin();\
    \ ++i != v.end();) {\n            os << ' ' << *i;\n        }\n    }\n    return\
    \ os;\n}\ntemplate <class K, class V> inline std::ostream& operator<<(std::ostream\
    \ &os, const std::map<K, V> &m) noexcept {\n    if(!m.empty()) {\n        os <<\
    \ m.begin()->first << ' ' << m.begin()->second;\n        for(auto i = m.begin();\
    \ ++i != m.end();) {\n            os << '\\n' << i->first << ' ' << i->second;\n\
    \        }\n    }\n    return os;\n}\ntemplate <class T> inline std::ostream&\
    \ operator<<(std::ostream &os, const std::set<T> &st) noexcept {\n    if(!st.empty())\
    \ {\n        os << *st.begin();\n        for(auto i = st.begin(); ++i != st.end();)\
    \ {\n            os << ' ' << *i;\n        }\n    }\n    return os;\n}\ntemplate\
    \ <class T> inline std::ostream& operator<<(std::ostream &os, const std::multiset<T>\
    \ &ms) noexcept {\n    if(!ms.empty()) {\n        os << *ms.begin();\n       \
    \ for(auto i = ms.begin(); ++i != ms.end();) {\n            os << ' ' << *i;\n\
    \        }\n    }\n    return os;\n}\ntemplate <class T> inline std::ostream&\
    \ operator<<(std::ostream &os, const std::deque<T> &dq) noexcept {\n    if(!dq.empty())\
    \ {\n        os << dq.front();\n        for(auto i = dq.begin(); ++i != dq.end();)\
    \ {\n            os << ' ' << *i;\n        }\n    }\n    return os;\n}\n} // IO\n\
    \n#if local\n//https://gist.github.com/naskya/1e5e5cd269cfe16a76988378a60e2ca3\n\
    #include <C++/core/io/debug_print.hpp>\n#else\n#define dump(...) static_cast<void>(0)\n\
    #endif\n\n/**\n * @brief \u51FA\u529B\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/core/io/output.hpp
  requiredBy:
  - C++/template.hpp
  timestamp: '2025-06-07 07:29:34+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/aarray.test.cpp
  - test/m_add.test.cpp
  - test/sr_sum.test.cpp
  - test/uf.test.cpp
  - test/add128.test.cpp
  - test/parsum.test.cpp
  - test/add128_2.test.cpp
  - test/extgcd.test.cpp
  - test/stable.test.cpp
  - test/fwtree.test.cpp
  - test/segtree.test.cpp
  - test/add.test.cpp
  - test/s_rmq.test.cpp
documentation_of: C++/core/io/output.hpp
layout: document
redirect_from:
- /library/C++/core/io/output.hpp
- /library/C++/core/io/output.hpp.html
title: "\u51FA\u529B"
---
