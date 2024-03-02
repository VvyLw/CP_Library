---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/lcpa.test.cpp
    title: test/lcpa.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/sa.test.cpp
    title: test/sa.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: Suffix Array
    links:
    - https://ei1333.github.io/library/string/suffix-array.hpp
  bundledCode: "#line 2 \"C++/string/SA.hpp\"\n\n#include <iostream>\n#include <vector>\n\
    #include <algorithm>\n#include <numeric>\nstruct SuffixArray: std::vector<int>\
    \ {\nprivate:\n    std::vector<int> sa_is(const std::vector<int> &s) const {\n\
    \    \tconst int n = s.size();\n    \tstd::vector<int> ret(n), is_s(n), is_lms(n);;\n\
    \    \tint m = 0;\n    \tfor(int i = n - 2; i >= 0; i--) {\n      \t\tis_s[i]\
    \ = (s[i] > s[i + 1]) || (s[i] == s[i + 1] && is_s[i + 1]);\n      \t\tm += is_lms[i\
    \ + 1] = is_s[i] && !is_s[i + 1];\n    \t}\n    \tconst auto induced_sort = [&](const\
    \ std::vector<int> &lms) -> void {\n      \t\tconst int upper = *std::max_element(s.begin(),\
    \ s.end());\n      \t\tstd::vector<int> l(upper + 2), r(upper + 2);\n\t\t\tfor(const\
    \ auto &v: s) {\n\t\t\t\t++l[v + 1];\n\t\t\t\t++r[v];\n\t\t\t}\n\t\t\tstd::partial_sum(l.begin(),\
    \ l.end(), l.begin());\n\t\t\tstd::partial_sum(r.begin(), r.end(), r.begin());\n\
    \t\t\tret.assign(ret.size(), -1);\n\t\t\tfor(int i = std::ssize(lms); --i >= 0;)\
    \ {\n\t\t\t\tret[--r[s[lms[i]]]] = lms[i];\n\t\t\t}\n\t\t\tfor(const auto &v:\
    \ ret) {\n\t\t\t\tif(v >= 1 && is_s[v - 1]) {\n\t\t\t\t\tret[l[s[v - 1]]++] =\
    \ v - 1;\n\t\t\t\t}\n\t\t\t}\n\t\t\tr.assign(r.size(), 0);\n\t\t\tfor(const auto\
    \ &v: s) {\n\t\t\t\t++r[v];\n\t\t\t}\n\t\t\tstd::partial_sum(r.begin(), r.end(),\
    \ r.begin());\n\t\t\tfor(int k = std::ssize(ret) - 1, i = ret[k]; k >= 1; i =\
    \ ret[--k]) {\n\t\t\t\tif(i >= 1 && !is_s[i - 1]) {\n\t\t\t\t\tret[--r[s[i - 1]]]\
    \ = i - 1;\n\t\t\t\t}\n\t\t\t}\n\t\t};\n\t\tstd::vector<int> lms, new_lms;\n\t\
    \tlms.reserve(m);\n\t\tfor(int i = 0; ++i < n;) {\n\t\t\tif(is_lms[i]) {\n\t\t\
    \t\tlms.emplace_back(i);\n\t\t\t}\n\t\t}\n\t\tinduced_sort(lms);\n\t\tnew_lms.reserve(m);\n\
    \t\tfor(int i = 0; i < n; ++i) {\n\t\t\tif(!is_s[ret[i]] && ret[i] > 0 && is_s[ret[i]\
    \ - 1]) {\n\t\t\t\tnew_lms.emplace_back(ret[i]);\n\t\t\t}\n\t\t}\n\t\tconst auto\
    \ same = [&](int a, int b) -> bool {\n\t\t\tif(s[a++] != s[b++]) {\n\t\t\t\treturn\
    \ false;\n\t\t\t}\n\t\t\twhile(1) {\n\t\t\t\tif(s[a] != s[b]) {\n\t\t\t\t\treturn\
    \ false;\n\t\t\t\t}\n\t\t\t\tif(is_lms[a] || is_lms[b]) {\n\t\t\t\t\treturn is_lms[a]\
    \ && is_lms[b];\n\t\t\t\t}\n\t\t\t\ta++, b++;\n\t\t\t}\n\t\t};\n\t\tint rank =\
    \ 0;\n\t\tret[n - 1] = 0;\n\t\tfor(int i = 0; ++i < m;) {\n\t\t\tif(!same(new_lms[i\
    \ - 1], new_lms[i])) {\n\t\t\t\t++rank;\n\t\t\t}\n\t\t\tret[new_lms[i]] = rank;\n\
    \t\t}\n\t\tif(rank + 1 < m) {\n\t\t\tstd::vector<int> new_s(m);\n\t\t\tfor(int\
    \ i = 0; i < m; ++i) {\n\t\t\t\tnew_s[i] = ret[lms[i]];\n\t\t\t}\n\t\t\tconst\
    \ auto lms_sa = sa_is(new_s);\n\t\t\tfor(int i = 0; i < m; ++i) {\n\t\t\t\tnew_lms[i]\
    \ = lms[lms_sa[i]];\n\t\t\t}\n\t\t}\n\t\tinduced_sort(new_lms);\n\t\treturn ret;\n\
    \t}\npublic:\n\tstd::string vs;\n\texplicit SuffixArray(const std::string &vs,\
    \ bool compress = false): vs(vs) {\n\t\tstd::vector<int> new_vs(vs.size() + 1);\n\
    \t\tif(compress) {\n            std::string xs = vs;\n            std::sort(xs.begin(),\
    \ xs.end());\n            xs.erase(std::unique(xs.begin(), xs.end()), xs.end());\n\
    \            for(size_t i = 0; i < vs.size(); ++i) {\n                new_vs[i]\
    \ = std::lower_bound(xs.begin(), xs.end(), vs[i]) - xs.begin() + 1;\n        \
    \    }\n\t\t} else {\n            const auto d = *std::min_element(vs.begin(),\
    \ vs.end());\n            for(size_t i = 0; i < vs.size(); ++i) {\n          \
    \      new_vs[i] = vs[i] - d + 1;\n            }\n\t\t}\n\t\tconst auto ret =\
    \ sa_is(new_vs);\n\t\tassign(ret.begin(), ret.end());\n\t}\n\tvoid output() const\
    \ {\n\t\tfor(size_t i = 0; i < size(); ++i) {\n            std::cout << i << \"\
    :[\" << (*this)[i] << \"]\";\n            for(size_t j = (*this)[i]; j < vs.size();\
    \ ++j) {\n                std::cout << \" \" << vs[j];\n            }\n      \
    \      std::cout << \"\\n\";\n\t\t}\n\t}\n\tbool lt_substr(const std::string &t,\
    \ int si = 0, int ti = 0) {\n\t\tconst int sn = vs.size(), tn = t.size();\n\t\t\
    while(si < sn && ti < tn) {\n            if(vs[si] < t[ti]) {\n              \
    \  return true;\n            }\n            if(vs[si] > t[ti]) {\n           \
    \     return false;\n            }\n            ++si, ++ti;\n\t\t}\n\t\treturn\
    \ si >= sn && ti < tn;\n\t}\n\tint lower_bound(const std::string &t) {\n\t\tint\
    \ ng = 0, ok = size();\n\t\twhile(ok - ng > 1) {\n            const int mid =\
    \ (ok + ng) / 2;\n            (lt_substr(t, (*this)[mid]) ? ng : ok) = mid;\n\t\
    \t}\n\t\treturn ok;\n\t}\n\tstd::pair<int, int> equal_range(std::string t) {\n\
    \t\tconst int low = lower_bound(t);\n\t\tint ng = low - 1, ok = size();\n\t\t\
    t.back()++;\n\t\twhile(ok - ng > 1) {\n            int mid = (ok + ng) / 2;\n\
    \            (lt_substr(t, (*this)[mid]) ? ng : ok) = mid;\n\t\t}\n\t\tt.back()--;\n\
    \t\treturn {low, ok};\n\t}\n\tstd::vector<int> lcp_array() const {\n\t\tconst\
    \ int n = size() - 1;\n\t\tstd::vector<int> lcp(n + 1), rank(n + 1);\n\t\tfor(int\
    \ i = 0; i <= n; ++i) {\n\t\t    rank[(*this)[i]] = i;\n\t\t}\n\t\tint h = 0;\n\
    \t\tfor(int i = 0; i <= n; ++i) {\n            if(rank[i] < n) {\n           \
    \     const int j = (*this)[rank[i] + 1];\n                for(; j + h < n &&\
    \ i + h < n; ++h) {\n                    if(vs[j + h] != vs[i + h]) {\n      \
    \                  break;\n                    }\n                }\n        \
    \        lcp[rank[i] + 1] = h;\n                if(h > 0) {\n                \
    \    h--;\n                }\n            }\n\t\t}\n\t\treturn lcp;\n\t}\n};\n\
    \n/**\n * @brief Suffix Array\n * @see https://ei1333.github.io/library/string/suffix-array.hpp\n\
    \ */\n"
  code: "#pragma once\n\n#include <iostream>\n#include <vector>\n#include <algorithm>\n\
    #include <numeric>\nstruct SuffixArray: std::vector<int> {\nprivate:\n    std::vector<int>\
    \ sa_is(const std::vector<int> &s) const {\n    \tconst int n = s.size();\n  \
    \  \tstd::vector<int> ret(n), is_s(n), is_lms(n);;\n    \tint m = 0;\n    \tfor(int\
    \ i = n - 2; i >= 0; i--) {\n      \t\tis_s[i] = (s[i] > s[i + 1]) || (s[i] ==\
    \ s[i + 1] && is_s[i + 1]);\n      \t\tm += is_lms[i + 1] = is_s[i] && !is_s[i\
    \ + 1];\n    \t}\n    \tconst auto induced_sort = [&](const std::vector<int> &lms)\
    \ -> void {\n      \t\tconst int upper = *std::max_element(s.begin(), s.end());\n\
    \      \t\tstd::vector<int> l(upper + 2), r(upper + 2);\n\t\t\tfor(const auto\
    \ &v: s) {\n\t\t\t\t++l[v + 1];\n\t\t\t\t++r[v];\n\t\t\t}\n\t\t\tstd::partial_sum(l.begin(),\
    \ l.end(), l.begin());\n\t\t\tstd::partial_sum(r.begin(), r.end(), r.begin());\n\
    \t\t\tret.assign(ret.size(), -1);\n\t\t\tfor(int i = std::ssize(lms); --i >= 0;)\
    \ {\n\t\t\t\tret[--r[s[lms[i]]]] = lms[i];\n\t\t\t}\n\t\t\tfor(const auto &v:\
    \ ret) {\n\t\t\t\tif(v >= 1 && is_s[v - 1]) {\n\t\t\t\t\tret[l[s[v - 1]]++] =\
    \ v - 1;\n\t\t\t\t}\n\t\t\t}\n\t\t\tr.assign(r.size(), 0);\n\t\t\tfor(const auto\
    \ &v: s) {\n\t\t\t\t++r[v];\n\t\t\t}\n\t\t\tstd::partial_sum(r.begin(), r.end(),\
    \ r.begin());\n\t\t\tfor(int k = std::ssize(ret) - 1, i = ret[k]; k >= 1; i =\
    \ ret[--k]) {\n\t\t\t\tif(i >= 1 && !is_s[i - 1]) {\n\t\t\t\t\tret[--r[s[i - 1]]]\
    \ = i - 1;\n\t\t\t\t}\n\t\t\t}\n\t\t};\n\t\tstd::vector<int> lms, new_lms;\n\t\
    \tlms.reserve(m);\n\t\tfor(int i = 0; ++i < n;) {\n\t\t\tif(is_lms[i]) {\n\t\t\
    \t\tlms.emplace_back(i);\n\t\t\t}\n\t\t}\n\t\tinduced_sort(lms);\n\t\tnew_lms.reserve(m);\n\
    \t\tfor(int i = 0; i < n; ++i) {\n\t\t\tif(!is_s[ret[i]] && ret[i] > 0 && is_s[ret[i]\
    \ - 1]) {\n\t\t\t\tnew_lms.emplace_back(ret[i]);\n\t\t\t}\n\t\t}\n\t\tconst auto\
    \ same = [&](int a, int b) -> bool {\n\t\t\tif(s[a++] != s[b++]) {\n\t\t\t\treturn\
    \ false;\n\t\t\t}\n\t\t\twhile(1) {\n\t\t\t\tif(s[a] != s[b]) {\n\t\t\t\t\treturn\
    \ false;\n\t\t\t\t}\n\t\t\t\tif(is_lms[a] || is_lms[b]) {\n\t\t\t\t\treturn is_lms[a]\
    \ && is_lms[b];\n\t\t\t\t}\n\t\t\t\ta++, b++;\n\t\t\t}\n\t\t};\n\t\tint rank =\
    \ 0;\n\t\tret[n - 1] = 0;\n\t\tfor(int i = 0; ++i < m;) {\n\t\t\tif(!same(new_lms[i\
    \ - 1], new_lms[i])) {\n\t\t\t\t++rank;\n\t\t\t}\n\t\t\tret[new_lms[i]] = rank;\n\
    \t\t}\n\t\tif(rank + 1 < m) {\n\t\t\tstd::vector<int> new_s(m);\n\t\t\tfor(int\
    \ i = 0; i < m; ++i) {\n\t\t\t\tnew_s[i] = ret[lms[i]];\n\t\t\t}\n\t\t\tconst\
    \ auto lms_sa = sa_is(new_s);\n\t\t\tfor(int i = 0; i < m; ++i) {\n\t\t\t\tnew_lms[i]\
    \ = lms[lms_sa[i]];\n\t\t\t}\n\t\t}\n\t\tinduced_sort(new_lms);\n\t\treturn ret;\n\
    \t}\npublic:\n\tstd::string vs;\n\texplicit SuffixArray(const std::string &vs,\
    \ bool compress = false): vs(vs) {\n\t\tstd::vector<int> new_vs(vs.size() + 1);\n\
    \t\tif(compress) {\n            std::string xs = vs;\n            std::sort(xs.begin(),\
    \ xs.end());\n            xs.erase(std::unique(xs.begin(), xs.end()), xs.end());\n\
    \            for(size_t i = 0; i < vs.size(); ++i) {\n                new_vs[i]\
    \ = std::lower_bound(xs.begin(), xs.end(), vs[i]) - xs.begin() + 1;\n        \
    \    }\n\t\t} else {\n            const auto d = *std::min_element(vs.begin(),\
    \ vs.end());\n            for(size_t i = 0; i < vs.size(); ++i) {\n          \
    \      new_vs[i] = vs[i] - d + 1;\n            }\n\t\t}\n\t\tconst auto ret =\
    \ sa_is(new_vs);\n\t\tassign(ret.begin(), ret.end());\n\t}\n\tvoid output() const\
    \ {\n\t\tfor(size_t i = 0; i < size(); ++i) {\n            std::cout << i << \"\
    :[\" << (*this)[i] << \"]\";\n            for(size_t j = (*this)[i]; j < vs.size();\
    \ ++j) {\n                std::cout << \" \" << vs[j];\n            }\n      \
    \      std::cout << \"\\n\";\n\t\t}\n\t}\n\tbool lt_substr(const std::string &t,\
    \ int si = 0, int ti = 0) {\n\t\tconst int sn = vs.size(), tn = t.size();\n\t\t\
    while(si < sn && ti < tn) {\n            if(vs[si] < t[ti]) {\n              \
    \  return true;\n            }\n            if(vs[si] > t[ti]) {\n           \
    \     return false;\n            }\n            ++si, ++ti;\n\t\t}\n\t\treturn\
    \ si >= sn && ti < tn;\n\t}\n\tint lower_bound(const std::string &t) {\n\t\tint\
    \ ng = 0, ok = size();\n\t\twhile(ok - ng > 1) {\n            const int mid =\
    \ (ok + ng) / 2;\n            (lt_substr(t, (*this)[mid]) ? ng : ok) = mid;\n\t\
    \t}\n\t\treturn ok;\n\t}\n\tstd::pair<int, int> equal_range(std::string t) {\n\
    \t\tconst int low = lower_bound(t);\n\t\tint ng = low - 1, ok = size();\n\t\t\
    t.back()++;\n\t\twhile(ok - ng > 1) {\n            int mid = (ok + ng) / 2;\n\
    \            (lt_substr(t, (*this)[mid]) ? ng : ok) = mid;\n\t\t}\n\t\tt.back()--;\n\
    \t\treturn {low, ok};\n\t}\n\tstd::vector<int> lcp_array() const {\n\t\tconst\
    \ int n = size() - 1;\n\t\tstd::vector<int> lcp(n + 1), rank(n + 1);\n\t\tfor(int\
    \ i = 0; i <= n; ++i) {\n\t\t    rank[(*this)[i]] = i;\n\t\t}\n\t\tint h = 0;\n\
    \t\tfor(int i = 0; i <= n; ++i) {\n            if(rank[i] < n) {\n           \
    \     const int j = (*this)[rank[i] + 1];\n                for(; j + h < n &&\
    \ i + h < n; ++h) {\n                    if(vs[j + h] != vs[i + h]) {\n      \
    \                  break;\n                    }\n                }\n        \
    \        lcp[rank[i] + 1] = h;\n                if(h > 0) {\n                \
    \    h--;\n                }\n            }\n\t\t}\n\t\treturn lcp;\n\t}\n};\n\
    \n/**\n * @brief Suffix Array\n * @see https://ei1333.github.io/library/string/suffix-array.hpp\n\
    \ */"
  dependsOn: []
  isVerificationFile: false
  path: C++/string/SA.hpp
  requiredBy: []
  timestamp: '2024-02-19 12:20:55+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/sa.test.cpp
  - test/lcpa.test.cpp
documentation_of: C++/string/SA.hpp
layout: document
redirect_from:
- /library/C++/string/SA.hpp
- /library/C++/string/SA.hpp.html
title: Suffix Array
---
