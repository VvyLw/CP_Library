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
    \ <array>\n#include <map>\nnamespace IO {\ninline std::ostream &operator<<(std::ostream\
    \ &dest, const __int128_t &value) noexcept {\n    std::ostream::sentry s(dest);\n\
    \    constexpr char dig[] = \"0123456789\";\n    if(s) {\n        __uint128_t\
    \ tmp = value < 0 ? -value : value;\n        char buffer[128];\n        char *d\
    \ = std::end(buffer);\n        do {\n            --d;\n            *d = dig[tmp\
    \ % 10];\n            tmp /= 10;\n        } while(tmp != 0);\n        if(value\
    \ < 0) {\n            --d;\n            *d = '-';\n        }\n        const int\
    \ len = std::end(buffer) - d;\n        if(dest.rdbuf() -> sputn(d, len) != len)\
    \ {\n            dest.setstate(std::ios_base::badbit);\n        }\n    }\n   \
    \ return dest;\n}\ntemplate <class T, class U> inline std::ostream& operator<<(std::ostream\
    \ &os, const std::pair<T, U> &p) noexcept { os << p.first << ' ' << p.second;\
    \ return os; }\ntemplate <class K, class V> inline std::ostream& operator<<(std::ostream\
    \ &os, const std::map<K, V> &m) noexcept {\n    if(!m.empty()) {\n        os <<\
    \ m.begin()->first << ' ' << m.begin()->second;\n        for(auto i = m.begin();\
    \ ++i != m.end();) {\n            os << '\\n' << i->first << ' ' << i->second;\n\
    \        }\n    }\n    return os;\n}\ntemplate <std::ranges::range T> requires\
    \ (!std::convertible_to<T, std::string_view>) inline std::ostream& operator<<(std::ostream\
    \ &os, const T &v) noexcept {\n    if(!v.empty()) {\n        os << *v.cbegin();\n\
    \        for(auto i = v.cbegin(); ++i != v.cend();) {\n            os << ' ' <<\
    \ *i;\n        }\n    }\n    return os;\n}\n} // IO\n\nnamespace man {\ninline\
    \ void print() noexcept { std::cout << '\\n'; }\ntemplate <class Head, class...\
    \ Tail> inline void print(const Head& head, const Tail& ...tail) noexcept {\n\
    \    std::cout << head;\n    if constexpr(sizeof...(Tail) > 0) {\n        std::cout\
    \ << ' ';\n        print(tail...);\n    } else {\n        std::cout << '\\n';\n\
    \    }\n}\n}\n\n#if local\n//https://gist.github.com/naskya/1e5e5cd269cfe16a76988378a60e2ca3\n\
    #include <C++/core/io/debug_print.hpp>\n#else\n#define dump(...) static_cast<void>(0)\n\
    #endif\n\n/**\n * @brief \u51FA\u529B\n */\n"
  code: "#pragma once\n\n#include <iostream>\n#include <array>\n#include <map>\nnamespace\
    \ IO {\ninline std::ostream &operator<<(std::ostream &dest, const __int128_t &value)\
    \ noexcept {\n    std::ostream::sentry s(dest);\n    constexpr char dig[] = \"\
    0123456789\";\n    if(s) {\n        __uint128_t tmp = value < 0 ? -value : value;\n\
    \        char buffer[128];\n        char *d = std::end(buffer);\n        do {\n\
    \            --d;\n            *d = dig[tmp % 10];\n            tmp /= 10;\n \
    \       } while(tmp != 0);\n        if(value < 0) {\n            --d;\n      \
    \      *d = '-';\n        }\n        const int len = std::end(buffer) - d;\n \
    \       if(dest.rdbuf() -> sputn(d, len) != len) {\n            dest.setstate(std::ios_base::badbit);\n\
    \        }\n    }\n    return dest;\n}\ntemplate <class T, class U> inline std::ostream&\
    \ operator<<(std::ostream &os, const std::pair<T, U> &p) noexcept { os << p.first\
    \ << ' ' << p.second; return os; }\ntemplate <class K, class V> inline std::ostream&\
    \ operator<<(std::ostream &os, const std::map<K, V> &m) noexcept {\n    if(!m.empty())\
    \ {\n        os << m.begin()->first << ' ' << m.begin()->second;\n        for(auto\
    \ i = m.begin(); ++i != m.end();) {\n            os << '\\n' << i->first << '\
    \ ' << i->second;\n        }\n    }\n    return os;\n}\ntemplate <std::ranges::range\
    \ T> requires (!std::convertible_to<T, std::string_view>) inline std::ostream&\
    \ operator<<(std::ostream &os, const T &v) noexcept {\n    if(!v.empty()) {\n\
    \        os << *v.cbegin();\n        for(auto i = v.cbegin(); ++i != v.cend();)\
    \ {\n            os << ' ' << *i;\n        }\n    }\n    return os;\n}\n} // IO\n\
    \nnamespace man {\ninline void print() noexcept { std::cout << '\\n'; }\ntemplate\
    \ <class Head, class... Tail> inline void print(const Head& head, const Tail&\
    \ ...tail) noexcept {\n    std::cout << head;\n    if constexpr(sizeof...(Tail)\
    \ > 0) {\n        std::cout << ' ';\n        print(tail...);\n    } else {\n \
    \       std::cout << '\\n';\n    }\n}\n}\n\n#if local\n//https://gist.github.com/naskya/1e5e5cd269cfe16a76988378a60e2ca3\n\
    #include <C++/core/io/debug_print.hpp>\n#else\n#define dump(...) static_cast<void>(0)\n\
    #endif\n\n/**\n * @brief \u51FA\u529B\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/core/io/output.hpp
  requiredBy:
  - C++/template.hpp
  timestamp: '2025-06-11 17:47:26+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/add.test.cpp
  - test/uf.test.cpp
  - test/s_rmq.test.cpp
  - test/sr_sum.test.cpp
  - test/stable.test.cpp
  - test/m_add.test.cpp
  - test/add128_2.test.cpp
  - test/add128.test.cpp
  - test/parsum.test.cpp
  - test/fwtree.test.cpp
  - test/aarray.test.cpp
  - test/extgcd.test.cpp
  - test/segtree.test.cpp
documentation_of: C++/core/io/output.hpp
layout: document
redirect_from:
- /library/C++/core/io/output.hpp
- /library/C++/core/io/output.hpp.html
title: "\u51FA\u529B"
---
