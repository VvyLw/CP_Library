---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    document_title: "\u5165\u529B"
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
  code: "#pragma once\n\n#include <iostream>\n#include <cassert>\n#include <deque>\n\
    #include \"mypair.hpp\"\n#ifndef TEMPLATE\ntypedef unsigned long long ul;\ntypedef\
    \ __int128_t i128;\nnamespace zia_qu {\ninline bool isdigit(const char c){ return\
    \ std::isdigit(c); }\ninline bool isdigit(const std::string &s){ bool ok=1, neg=s.front()=='-';\
    \ for(const auto &el: s){ if(neg){ neg=0; continue; } ok&=isdigit(el); } return\
    \ ok; }\n}\n#endif\nnamespace IO {\ntemplate <class T, class U> std::istream&\
    \ operator>>(std::istream &is, pairs::P<T, U> &p){ is >> p.first >> p.second;\
    \ return is; }\ntemplate <class T, size_t N> std::istream& operator>>(std::istream\
    \ &is, std::array<T, N> &a){ for(auto &el: a) is >> el; return is; }\ntemplate\
    \ <class T> std::istream& operator>>(std::istream &is, vectors::V<T> &v){ for(auto\
    \ &el: v) is >> el; return is; }\ntemplate <class T> std::istream& operator>>(std::istream\
    \ &is, std::deque<T> &dq){ for(auto &el: dq) is >> el; return is; }\ntemplate\
    \ <class T> inline bool in(T& x){ std::cin >> x; return 1; }\ntemplate <class\
    \ Head, class... Tail> inline bool in(Head& head, Tail&... tail){ in(head); in(tail...);\
    \ return 1; }\n\ninline i128 to_i128(const std::string &s) {\n    assert(zia_qu::isdigit(s));\n\
    \    bool neg=s.front()=='-';\n    i128 ret = 0;\n    for(const auto &el: s) {\n\
    \        if(neg) {\n            neg=0;\n            continue;\n        }\n   \
    \     ret = 10 * ret + el - '0';\n    }\n    if(s.front()=='-') ret=-ret;\n  \
    \  return ret;\n}\n\n#define INT(...) int __VA_ARGS__; in(__VA_ARGS__)\n#define\
    \ LL(...) ll __VA_ARGS__; in(__VA_ARGS__)\n#define UL(...) ul __VA_ARGS__; in(__VA_ARGS__)\n\
    #define LD(...) ld __VA_ARGS__; in(__VA_ARGS__)\n#define CHR(...) char __VA_ARGS__;\
    \ in(__VA_ARGS__)\n#define STR(...) std::string __VA_ARGS__; in(__VA_ARGS__)\n\
    #define VEC(type,name,size) vectors::V<type> name(size); in(name)\n#define WEC(type,name,h,w)\
    \ vectors::V<vectors::V<type>> name(h,vectors::V<type>(w)); in(name)\n} // IO\n\
    \n/**\n * @brief \u5165\u529B\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/io/input.hpp
  requiredBy: []
  timestamp: '1970-01-01 00:00:00+00:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/io/input.hpp
layout: document
redirect_from:
- /library/C++/io/input.hpp
- /library/C++/io/input.hpp.html
title: "\u5165\u529B"
---
