---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    document_title: "\u51FA\u529B"
    links: []
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 401, in update\n    self.update(self._resolve(pathlib.Path(included), included_from=path))\n\
    \  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 260, in _resolve\n    raise BundleErrorAt(path, -1, \"no such header\"\
    )\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt: mypair.hpp: line\
    \ -1: no such header\n"
  code: "#pragma once\n\n#include <iostream>\n#include <map>\n#include <set>\n#include\
    \ <deque>\n#include \"mypair.hpp\"\n#ifndef TEMPLATE\nusing i128 = __int128_t;\n\
    using u128 = __uint128_t;\n#define rep(n) for(size_t i = 0; i < n; ++i)\n#endif\n\
    namespace IO {\nstd::ostream &operator<<(std::ostream &dest, const i128 &value)\
    \ {\n    std::ostream::sentry s(dest);\n    if(s) {\n        u128 tmp = value\
    \ < 0 ? -value : value;\n        char buffer[128];\n        char *d = std::end(buffer);\n\
    \        do {\n            --d;\n            *d = \"0123456789\"[tmp % 10];\n\
    \            tmp /= 10;\n        } while(tmp != 0);\n        if(value < 0) {\n\
    \            --d;\n            *d = '-';\n        }\n        int len = std::end(buffer)\
    \ - d;\n        if(dest.rdbuf() -> sputn(d, len) != len) {\n            dest.setstate(std::ios_base::badbit);\n\
    \        }\n    }\n    return dest;\n}\ntemplate <class T, class U> std::ostream&\
    \ operator<<(std::ostream &os, const pairs::P<T, U> &p){ os << p.first << ' '\
    \ << p.second; return os; }\ntemplate <class T, size_t N> std::ostream& operator<<(std::ostream\
    \ &os, const std::array<T, N> &a){ if(a.size()){ os << a.front(); for(auto i=a.begin();\
    \ ++i!=a.end();){ os << ' ' << *i; } } return os; }\ntemplate <class T> std::ostream&\
    \ operator<<(std::ostream &os, const vectors::V<T> &v){ if(v.size()){ os << v.front();\
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
    \ }\ntemplate <bool flush=false, class T> inline void vout(const vectors::V<T>&\
    \ v){ rep(v.size()) std::cout << v[i] << '\\n'; if(flush) std::cout.flush(); }\n\
    template <bool flush=false, class Head, class... Tail> inline void vout(const\
    \ Head& head, const Tail&... tail){ std::cout << head << '\\n'; vout<flush>(tail...);\
    \ }\n\n#define fin(...) do{ out(__VA_ARGS__); return; }while(false)\n} // IO\n\
    \n/**\n * @brief \u51FA\u529B\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/io/output.hpp
  requiredBy: []
  timestamp: '1970-01-01 00:00:00+00:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/io/output.hpp
layout: document
redirect_from:
- /library/C++/io/output.hpp
- /library/C++/io/output.hpp.html
title: "\u51FA\u529B"
---
