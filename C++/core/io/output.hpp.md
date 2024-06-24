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
    #ifndef TEMPLATE\nusing i128 = __int128_t;\nusing u128 = __uint128_t;\n#endif\n\
    namespace IO {\nstd::ostream &operator<<(std::ostream &dest, const i128 &value)\
    \ {\n    std::ostream::sentry s(dest);\n    if(s) {\n        u128 tmp = value\
    \ < 0 ? -value : value;\n        char buffer[128];\n        char *d = std::end(buffer);\n\
    \        do {\n            --d;\n            *d = \"0123456789\"[tmp % 10];\n\
    \            tmp /= 10;\n        } while(tmp != 0);\n        if(value < 0) {\n\
    \            --d;\n            *d = '-';\n        }\n        int len = std::end(buffer)\
    \ - d;\n        if(dest.rdbuf() -> sputn(d, len) != len) {\n            dest.setstate(std::ios_base::badbit);\n\
    \        }\n    }\n    return dest;\n}\ntemplate <class T, class U> std::ostream&\
    \ operator<<(std::ostream &os, const std::pair<T, U> &p){ os << p.first << ' '\
    \ << p.second; return os; }\ntemplate <class T, size_t N> std::ostream& operator<<(std::ostream\
    \ &os, const std::array<T, N> &a){ if(a.size()){ os << a.front(); for(auto i=a.begin();\
    \ ++i!=a.end();){ os << ' ' << *i; } } return os; }\ntemplate <class T> std::ostream&\
    \ operator<<(std::ostream &os, const std::vector<T> &v){ if(v.size()){ os << v.front();\
    \ for(auto i=v.begin(); ++i!=v.end();){ os << ' ' << *i; } } return os; }\ntemplate\
    \ <class K, class V> std::ostream& operator<<(std::ostream &os, const std::map<K,\
    \ V> &m){ if(m.size()){ os << m.begin()->first << ' ' << m.begin()->second; for(auto\
    \ i=m.begin(); ++i!=m.end();){ os << '\\n' << i->first << ' ' << i->second; }\
    \ } return os; }\ntemplate <class T> std::ostream& operator<<(std::ostream &os,\
    \ const std::set<T> &st){ if(st.size()){ os << *st.begin(); for(auto i=st.begin();\
    \ ++i!=st.end();){ os << ' ' << *i; } } return os; }\ntemplate <class T> std::ostream&\
    \ operator<<(std::ostream &os, const std::multiset<T> &ms){ if(ms.size()){ os\
    \ << *ms.begin(); for(auto i=ms.begin(); ++i!=ms.end();){ os << ' ' << *i; } }\
    \ return os; }\ntemplate <class T> std::ostream& operator<<(std::ostream &os,\
    \ const std::deque<T> &dq){ if(dq.size()){ os << dq.front(); for(auto i=dq.begin();\
    \ ++i!=dq.end();){ os << ' ' << *i; } } return os; }\ninline void out(){ std::cout\
    \ << '\\n'; }\ntemplate <bool flush=false, class T> inline void out(const T& x){\
    \ std::cout << x << '\\n'; if(flush) std::cout.flush(); }\ntemplate <bool flush=false,\
    \ class Head, class... Tail> inline void out(const Head& head, const Tail&...\
    \ tail){ std::cout << head << ' '; out<flush>(tail...); }\ntemplate <bool flush=false,\
    \ class T> inline void vout(const T& v){ std::cout << v << '\\n'; if(flush) std::cout.flush();\
    \ }\ntemplate <bool flush=false, class T> inline void vout(const std::vector<T>&\
    \ v){ for(const auto &el: v) std::cout << el << '\\n'; if(flush) std::cout.flush();\
    \ }\ntemplate <bool flush=false, class Head, class... Tail> inline void vout(const\
    \ Head& head, const Tail&... tail){ std::cout << head << '\\n'; vout<flush>(tail...);\
    \ }\n\n#define fin(...) do{ out(__VA_ARGS__); return; }while(false)\n} // IO\n\
    \n#if local\n//https://gist.github.com/naskya/1e5e5cd269cfe16a76988378a60e2ca3\n\
    #include <C++/core/io/debug_print.hpp>\n#else\n#define dump(...) static_cast<void>(0)\n\
    #endif\n\n/**\n * @brief \u51FA\u529B\n */\n"
  code: "#pragma once\n\n#include <iostream>\n#include <vector>\n#include <utility>\n\
    #include <map>\n#include <set>\n#include <deque>\n#ifndef TEMPLATE\nusing i128\
    \ = __int128_t;\nusing u128 = __uint128_t;\n#endif\nnamespace IO {\nstd::ostream\
    \ &operator<<(std::ostream &dest, const i128 &value) {\n    std::ostream::sentry\
    \ s(dest);\n    if(s) {\n        u128 tmp = value < 0 ? -value : value;\n    \
    \    char buffer[128];\n        char *d = std::end(buffer);\n        do {\n  \
    \          --d;\n            *d = \"0123456789\"[tmp % 10];\n            tmp /=\
    \ 10;\n        } while(tmp != 0);\n        if(value < 0) {\n            --d;\n\
    \            *d = '-';\n        }\n        int len = std::end(buffer) - d;\n \
    \       if(dest.rdbuf() -> sputn(d, len) != len) {\n            dest.setstate(std::ios_base::badbit);\n\
    \        }\n    }\n    return dest;\n}\ntemplate <class T, class U> std::ostream&\
    \ operator<<(std::ostream &os, const std::pair<T, U> &p){ os << p.first << ' '\
    \ << p.second; return os; }\ntemplate <class T, size_t N> std::ostream& operator<<(std::ostream\
    \ &os, const std::array<T, N> &a){ if(a.size()){ os << a.front(); for(auto i=a.begin();\
    \ ++i!=a.end();){ os << ' ' << *i; } } return os; }\ntemplate <class T> std::ostream&\
    \ operator<<(std::ostream &os, const std::vector<T> &v){ if(v.size()){ os << v.front();\
    \ for(auto i=v.begin(); ++i!=v.end();){ os << ' ' << *i; } } return os; }\ntemplate\
    \ <class K, class V> std::ostream& operator<<(std::ostream &os, const std::map<K,\
    \ V> &m){ if(m.size()){ os << m.begin()->first << ' ' << m.begin()->second; for(auto\
    \ i=m.begin(); ++i!=m.end();){ os << '\\n' << i->first << ' ' << i->second; }\
    \ } return os; }\ntemplate <class T> std::ostream& operator<<(std::ostream &os,\
    \ const std::set<T> &st){ if(st.size()){ os << *st.begin(); for(auto i=st.begin();\
    \ ++i!=st.end();){ os << ' ' << *i; } } return os; }\ntemplate <class T> std::ostream&\
    \ operator<<(std::ostream &os, const std::multiset<T> &ms){ if(ms.size()){ os\
    \ << *ms.begin(); for(auto i=ms.begin(); ++i!=ms.end();){ os << ' ' << *i; } }\
    \ return os; }\ntemplate <class T> std::ostream& operator<<(std::ostream &os,\
    \ const std::deque<T> &dq){ if(dq.size()){ os << dq.front(); for(auto i=dq.begin();\
    \ ++i!=dq.end();){ os << ' ' << *i; } } return os; }\ninline void out(){ std::cout\
    \ << '\\n'; }\ntemplate <bool flush=false, class T> inline void out(const T& x){\
    \ std::cout << x << '\\n'; if(flush) std::cout.flush(); }\ntemplate <bool flush=false,\
    \ class Head, class... Tail> inline void out(const Head& head, const Tail&...\
    \ tail){ std::cout << head << ' '; out<flush>(tail...); }\ntemplate <bool flush=false,\
    \ class T> inline void vout(const T& v){ std::cout << v << '\\n'; if(flush) std::cout.flush();\
    \ }\ntemplate <bool flush=false, class T> inline void vout(const std::vector<T>&\
    \ v){ for(const auto &el: v) std::cout << el << '\\n'; if(flush) std::cout.flush();\
    \ }\ntemplate <bool flush=false, class Head, class... Tail> inline void vout(const\
    \ Head& head, const Tail&... tail){ std::cout << head << '\\n'; vout<flush>(tail...);\
    \ }\n\n#define fin(...) do{ out(__VA_ARGS__); return; }while(false)\n} // IO\n\
    \n#if local\n//https://gist.github.com/naskya/1e5e5cd269cfe16a76988378a60e2ca3\n\
    #include <C++/core/io/debug_print.hpp>\n#else\n#define dump(...) static_cast<void>(0)\n\
    #endif\n\n/**\n * @brief \u51FA\u529B\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/core/io/output.hpp
  requiredBy:
  - C++/template.hpp
  timestamp: '2024-03-15 15:33:57+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/extgcd.test.cpp
  - test/segtree.test.cpp
  - test/add128.test.cpp
  - test/add128_2.test.cpp
  - test/uf.test.cpp
  - test/add.test.cpp
  - test/m_add.test.cpp
  - test/s_rmq.test.cpp
  - test/fwtree.test.cpp
  - test/sr_sum.test.cpp
  - test/parsum.test.cpp
  - test/stable.test.cpp
  - test/aarray.test.cpp
documentation_of: C++/core/io/output.hpp
layout: document
redirect_from:
- /library/C++/core/io/output.hpp
- /library/C++/core/io/output.hpp.html
title: "\u51FA\u529B"
---
