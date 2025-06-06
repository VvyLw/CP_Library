---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/lcpa.test.cpp
    title: test/lcpa.test.cpp
  - icon: ':x:'
    path: test/sa.test.cpp
    title: test/sa.test.cpp
  _isVerificationFailed: true
  _pathExtension: hpp
  _verificationStatusIcon: ':question:'
  attributes:
    document_title: Suffix Array
    links:
    - https://ei1333.github.io/library/string/suffix-array.hpp
  bundledCode: "#line 2 \"C++/string/SA.hpp\"\n\n#include <iostream>\n#include <vector>\n\
    #include <algorithm>\n#include <numeric>\n#include <ranges>\nnamespace man {\n\
    struct SuffixArray: std::vector<int> {\nprivate:\n    inline std::vector<int>\
    \ sa_is(const std::vector<int> &s) const noexcept {\n    \tconst int n = std::ssize(s);\n\
    \    \tstd::vector<int> ret(n), is_s(n), is_lms(n);\n    \tint m = 0;\n    \t\
    for(const auto i: std::views::iota(0, n - 1) | std::views::reverse) {\n      \t\
    \tis_s[i] = (s[i] > s[i + 1]) || (s[i] == s[i + 1] && is_s[i + 1]);\n      \t\t\
    m += is_lms[i + 1] = is_s[i] && !is_s[i + 1];\n    \t}\n    \tconst auto induced_sort\
    \ = [&](const std::vector<int> &lms) -> void {\n      \t\tconst int upper = *std::ranges::max_element(s);\n\
    \      \t\tstd::vector<int> l(upper + 2), r(upper + 2);\n\t\t\tfor(const auto\
    \ &v: s) {\n\t\t\t\t++l[v + 1];\n\t\t\t\t++r[v];\n\t\t\t}\n\t\t\tstd::partial_sum(l.begin(),\
    \ l.end(), l.begin());\n\t\t\tstd::partial_sum(r.begin(), r.end(), r.begin());\n\
    \t\t\tret.assign(std::ssize(ret), -1);\n\t\t\tfor(const auto i: std::views::iota(0,\
    \ std::ssize(lms)) | std::views::reverse) {\n\t\t\t\tret[--r[s[lms[i]]]] = lms[i];\n\
    \t\t\t}\n\t\t\tfor(const auto &v: ret) {\n\t\t\t\tif(v >= 1 && is_s[v - 1]) {\n\
    \t\t\t\t\tret[l[s[v - 1]]++] = v - 1;\n\t\t\t\t}\n\t\t\t}\n\t\t\tr.assign(std::ssize(r),\
    \ 0);\n\t\t\tfor(const auto &v: s) {\n\t\t\t\t++r[v];\n\t\t\t}\n\t\t\tstd::partial_sum(r.begin(),\
    \ r.end(), r.begin());\n\t\t\tfor(int k = std::ssize(ret) - 1, i = ret[k]; k >=\
    \ 1; i = ret[--k]) {\n\t\t\t\tif(i >= 1 && !is_s[i - 1]) {\n\t\t\t\t\tret[--r[s[i\
    \ - 1]]] = i - 1;\n\t\t\t\t}\n\t\t\t}\n\t\t};\n\t\tstd::vector<int> lms, new_lms;\n\
    \t\tlms.reserve(m);\n\t\tfor(const auto i: std::views::iota(1, n)) {\n\t\t\tif(is_lms[i])\
    \ {\n\t\t\t\tlms.emplace_back(i);\n\t\t\t}\n\t\t}\n\t\tinduced_sort(lms);\n\t\t\
    new_lms.reserve(m);\n\t\tfor(const auto i: std::views::iota(0, n)) {\n\t\t\tif(!is_s[ret[i]]\
    \ && ret[i] > 0 && is_s[ret[i] - 1]) {\n\t\t\t\tnew_lms.emplace_back(ret[i]);\n\
    \t\t\t}\n\t\t}\n\t\tconst auto same = [&](int a, int b) -> bool {\n\t\t\tif(s[a++]\
    \ != s[b++]) {\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\twhile(true) {\n\t\t\t\t\
    if(s[a] != s[b]) {\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\tif(is_lms[a] ||\
    \ is_lms[b]) {\n\t\t\t\t\treturn is_lms[a] && is_lms[b];\n\t\t\t\t}\n\t\t\t\t\
    a++, b++;\n\t\t\t}\n\t\t};\n\t\tint rank = 0;\n\t\tret[n - 1] = 0;\n\t\tfor(const\
    \ auto i: std::views::iota(1, m)) {\n\t\t\tif(!same(new_lms[i - 1], new_lms[i]))\
    \ {\n\t\t\t\t++rank;\n\t\t\t}\n\t\t\tret[new_lms[i]] = rank;\n\t\t}\n\t\tif(rank\
    \ + 1 < m) {\n\t\t\tstd::vector<int> new_s(m);\n\t\t\tfor(const auto i: std::views::iota(0,\
    \ m)) {\n\t\t\t\tnew_s[i] = ret[lms[i]];\n\t\t\t}\n\t\t\tconst auto lms_sa = sa_is(new_s);\n\
    \t\t\tfor(const auto i: std::views::iota(0, m)) {\n\t\t\t\tnew_lms[i] = lms[lms_sa[i]];\n\
    \t\t\t}\n\t\t}\n\t\tinduced_sort(new_lms);\n\t\treturn ret;\n\t}\npublic:\n\t\
    std::string vs;\n\texplicit SuffixArray(const std::string &vs, bool compress =\
    \ false): vs(vs) {\n\t\tstd::vector<int> new_vs(std::ssize(vs) + 1);\n\t\tif(compress)\
    \ {\n            std::string xs = vs;\n            std::ranges::sort(xs);\n\t\t\
    \tconst auto it = std::ranges::unique(xs);\n            xs.erase(it.begin(), it.end());\n\
    \            for(const auto i: std::views::iota(0, std::ssize(vs))) {\n      \
    \          new_vs[i] = std::ranges::lower_bound(xs, vs[i]) - xs.cbegin() + 1;\n\
    \            }\n\t\t} else {\n            const auto d = *std::ranges::min_element(vs);\n\
    \            for(const auto i: std::views::iota(0, std::ssize(vs))) {\n      \
    \          new_vs[i] = vs[i] - d + 1;\n            }\n\t\t}\n\t\tconst auto ret\
    \ = sa_is(new_vs);\n\t\tassign(ret.cbegin(), ret.cend());\n\t}\n\tinline void\
    \ output() const noexcept {\n\t\tfor(const auto i: std::views::iota(0U, size()))\
    \ {\n            std::cout << i << \":[\" << (*this)[i] << \"]\";\n          \
    \  for(const auto j: std::views::iota((*this)[i], std::ssize(vs))) {\n       \
    \         std::cout << \" \" << vs[j];\n            }\n            std::cout <<\
    \ \"\\n\";\n\t\t}\n\t}\n\tconstexpr inline bool lt_substr(const std::string &t,\
    \ int si = 0, int ti = 0) noexcept {\n\t\tconst int sn = std::ssize(vs), tn =\
    \ std::ssize(t);\n\t\twhile(si < sn && ti < tn) {\n            if(vs[si] < t[ti])\
    \ {\n                return true;\n            }\n            if(vs[si] > t[ti])\
    \ {\n                return false;\n            }\n            ++si, ++ti;\n\t\
    \t}\n\t\treturn si >= sn && ti < tn;\n\t}\n\tinline int lower_bound(const std::string\
    \ &t) noexcept {\n\t\tint ng = 0, ok = size();\n\t\twhile(ok - ng > 1) {\n   \
    \         const int mid = (ok + ng) / 2;\n            (lt_substr(t, (*this)[mid])\
    \ ? ng : ok) = mid;\n\t\t}\n\t\treturn ok;\n\t}\n\tinline std::pair<int, int>\
    \ equal_range(std::string t) noexcept {\n\t\tconst int low = lower_bound(t);\n\
    \t\tint ng = low - 1, ok = size();\n\t\tt.back()++;\n\t\twhile(ok - ng > 1) {\n\
    \            int mid = (ok + ng) / 2;\n            (lt_substr(t, (*this)[mid])\
    \ ? ng : ok) = mid;\n\t\t}\n\t\tt.back()--;\n\t\treturn {low, ok};\n\t}\n\tinline\
    \ std::vector<int> lcp_array() const noexcept {\n\t\tconst int n = size() - 1;\n\
    \t\tstd::vector<int> lcp(n + 1), rank(n + 1);\n\t\tfor(const auto i: std::views::iota(0,\
    \ n + 1)) {\n\t\t    rank[(*this)[i]] = i;\n\t\t}\n\t\tint h = 0;\n\t\tfor(const\
    \ auto i: std::views::iota(0, n + 1)) {\n            if(rank[i] < n) {\n     \
    \           const int j = (*this)[rank[i] + 1];\n                for(; j + h <\
    \ n && i + h < n; ++h) {\n                    if(vs[j + h] != vs[i + h]) {\n \
    \                       break;\n                    }\n                }\n   \
    \             lcp[rank[i] + 1] = h;\n                if(h > 0) {\n           \
    \         h--;\n                }\n            }\n\t\t}\n\t\treturn lcp;\n\t}\n\
    };\n}\n\n/**\n * @brief Suffix Array\n * @see https://ei1333.github.io/library/string/suffix-array.hpp\n\
    \ */\n"
  code: "#pragma once\n\n#include <iostream>\n#include <vector>\n#include <algorithm>\n\
    #include <numeric>\n#include <ranges>\nnamespace man {\nstruct SuffixArray: std::vector<int>\
    \ {\nprivate:\n    inline std::vector<int> sa_is(const std::vector<int> &s) const\
    \ noexcept {\n    \tconst int n = std::ssize(s);\n    \tstd::vector<int> ret(n),\
    \ is_s(n), is_lms(n);\n    \tint m = 0;\n    \tfor(const auto i: std::views::iota(0,\
    \ n - 1) | std::views::reverse) {\n      \t\tis_s[i] = (s[i] > s[i + 1]) || (s[i]\
    \ == s[i + 1] && is_s[i + 1]);\n      \t\tm += is_lms[i + 1] = is_s[i] && !is_s[i\
    \ + 1];\n    \t}\n    \tconst auto induced_sort = [&](const std::vector<int> &lms)\
    \ -> void {\n      \t\tconst int upper = *std::ranges::max_element(s);\n     \
    \ \t\tstd::vector<int> l(upper + 2), r(upper + 2);\n\t\t\tfor(const auto &v: s)\
    \ {\n\t\t\t\t++l[v + 1];\n\t\t\t\t++r[v];\n\t\t\t}\n\t\t\tstd::partial_sum(l.begin(),\
    \ l.end(), l.begin());\n\t\t\tstd::partial_sum(r.begin(), r.end(), r.begin());\n\
    \t\t\tret.assign(std::ssize(ret), -1);\n\t\t\tfor(const auto i: std::views::iota(0,\
    \ std::ssize(lms)) | std::views::reverse) {\n\t\t\t\tret[--r[s[lms[i]]]] = lms[i];\n\
    \t\t\t}\n\t\t\tfor(const auto &v: ret) {\n\t\t\t\tif(v >= 1 && is_s[v - 1]) {\n\
    \t\t\t\t\tret[l[s[v - 1]]++] = v - 1;\n\t\t\t\t}\n\t\t\t}\n\t\t\tr.assign(std::ssize(r),\
    \ 0);\n\t\t\tfor(const auto &v: s) {\n\t\t\t\t++r[v];\n\t\t\t}\n\t\t\tstd::partial_sum(r.begin(),\
    \ r.end(), r.begin());\n\t\t\tfor(int k = std::ssize(ret) - 1, i = ret[k]; k >=\
    \ 1; i = ret[--k]) {\n\t\t\t\tif(i >= 1 && !is_s[i - 1]) {\n\t\t\t\t\tret[--r[s[i\
    \ - 1]]] = i - 1;\n\t\t\t\t}\n\t\t\t}\n\t\t};\n\t\tstd::vector<int> lms, new_lms;\n\
    \t\tlms.reserve(m);\n\t\tfor(const auto i: std::views::iota(1, n)) {\n\t\t\tif(is_lms[i])\
    \ {\n\t\t\t\tlms.emplace_back(i);\n\t\t\t}\n\t\t}\n\t\tinduced_sort(lms);\n\t\t\
    new_lms.reserve(m);\n\t\tfor(const auto i: std::views::iota(0, n)) {\n\t\t\tif(!is_s[ret[i]]\
    \ && ret[i] > 0 && is_s[ret[i] - 1]) {\n\t\t\t\tnew_lms.emplace_back(ret[i]);\n\
    \t\t\t}\n\t\t}\n\t\tconst auto same = [&](int a, int b) -> bool {\n\t\t\tif(s[a++]\
    \ != s[b++]) {\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\twhile(true) {\n\t\t\t\t\
    if(s[a] != s[b]) {\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\tif(is_lms[a] ||\
    \ is_lms[b]) {\n\t\t\t\t\treturn is_lms[a] && is_lms[b];\n\t\t\t\t}\n\t\t\t\t\
    a++, b++;\n\t\t\t}\n\t\t};\n\t\tint rank = 0;\n\t\tret[n - 1] = 0;\n\t\tfor(const\
    \ auto i: std::views::iota(1, m)) {\n\t\t\tif(!same(new_lms[i - 1], new_lms[i]))\
    \ {\n\t\t\t\t++rank;\n\t\t\t}\n\t\t\tret[new_lms[i]] = rank;\n\t\t}\n\t\tif(rank\
    \ + 1 < m) {\n\t\t\tstd::vector<int> new_s(m);\n\t\t\tfor(const auto i: std::views::iota(0,\
    \ m)) {\n\t\t\t\tnew_s[i] = ret[lms[i]];\n\t\t\t}\n\t\t\tconst auto lms_sa = sa_is(new_s);\n\
    \t\t\tfor(const auto i: std::views::iota(0, m)) {\n\t\t\t\tnew_lms[i] = lms[lms_sa[i]];\n\
    \t\t\t}\n\t\t}\n\t\tinduced_sort(new_lms);\n\t\treturn ret;\n\t}\npublic:\n\t\
    std::string vs;\n\texplicit SuffixArray(const std::string &vs, bool compress =\
    \ false): vs(vs) {\n\t\tstd::vector<int> new_vs(std::ssize(vs) + 1);\n\t\tif(compress)\
    \ {\n            std::string xs = vs;\n            std::ranges::sort(xs);\n\t\t\
    \tconst auto it = std::ranges::unique(xs);\n            xs.erase(it.begin(), it.end());\n\
    \            for(const auto i: std::views::iota(0, std::ssize(vs))) {\n      \
    \          new_vs[i] = std::ranges::lower_bound(xs, vs[i]) - xs.cbegin() + 1;\n\
    \            }\n\t\t} else {\n            const auto d = *std::ranges::min_element(vs);\n\
    \            for(const auto i: std::views::iota(0, std::ssize(vs))) {\n      \
    \          new_vs[i] = vs[i] - d + 1;\n            }\n\t\t}\n\t\tconst auto ret\
    \ = sa_is(new_vs);\n\t\tassign(ret.cbegin(), ret.cend());\n\t}\n\tinline void\
    \ output() const noexcept {\n\t\tfor(const auto i: std::views::iota(0U, size()))\
    \ {\n            std::cout << i << \":[\" << (*this)[i] << \"]\";\n          \
    \  for(const auto j: std::views::iota((*this)[i], std::ssize(vs))) {\n       \
    \         std::cout << \" \" << vs[j];\n            }\n            std::cout <<\
    \ \"\\n\";\n\t\t}\n\t}\n\tconstexpr inline bool lt_substr(const std::string &t,\
    \ int si = 0, int ti = 0) noexcept {\n\t\tconst int sn = std::ssize(vs), tn =\
    \ std::ssize(t);\n\t\twhile(si < sn && ti < tn) {\n            if(vs[si] < t[ti])\
    \ {\n                return true;\n            }\n            if(vs[si] > t[ti])\
    \ {\n                return false;\n            }\n            ++si, ++ti;\n\t\
    \t}\n\t\treturn si >= sn && ti < tn;\n\t}\n\tinline int lower_bound(const std::string\
    \ &t) noexcept {\n\t\tint ng = 0, ok = size();\n\t\twhile(ok - ng > 1) {\n   \
    \         const int mid = (ok + ng) / 2;\n            (lt_substr(t, (*this)[mid])\
    \ ? ng : ok) = mid;\n\t\t}\n\t\treturn ok;\n\t}\n\tinline std::pair<int, int>\
    \ equal_range(std::string t) noexcept {\n\t\tconst int low = lower_bound(t);\n\
    \t\tint ng = low - 1, ok = size();\n\t\tt.back()++;\n\t\twhile(ok - ng > 1) {\n\
    \            int mid = (ok + ng) / 2;\n            (lt_substr(t, (*this)[mid])\
    \ ? ng : ok) = mid;\n\t\t}\n\t\tt.back()--;\n\t\treturn {low, ok};\n\t}\n\tinline\
    \ std::vector<int> lcp_array() const noexcept {\n\t\tconst int n = size() - 1;\n\
    \t\tstd::vector<int> lcp(n + 1), rank(n + 1);\n\t\tfor(const auto i: std::views::iota(0,\
    \ n + 1)) {\n\t\t    rank[(*this)[i]] = i;\n\t\t}\n\t\tint h = 0;\n\t\tfor(const\
    \ auto i: std::views::iota(0, n + 1)) {\n            if(rank[i] < n) {\n     \
    \           const int j = (*this)[rank[i] + 1];\n                for(; j + h <\
    \ n && i + h < n; ++h) {\n                    if(vs[j + h] != vs[i + h]) {\n \
    \                       break;\n                    }\n                }\n   \
    \             lcp[rank[i] + 1] = h;\n                if(h > 0) {\n           \
    \         h--;\n                }\n            }\n\t\t}\n\t\treturn lcp;\n\t}\n\
    };\n}\n\n/**\n * @brief Suffix Array\n * @see https://ei1333.github.io/library/string/suffix-array.hpp\n\
    \ */"
  dependsOn: []
  isVerificationFile: false
  path: C++/string/SA.hpp
  requiredBy: []
  timestamp: '2025-06-06 22:43:06+09:00'
  verificationStatus: LIBRARY_SOME_WA
  verifiedWith:
  - test/lcpa.test.cpp
  - test/sa.test.cpp
documentation_of: C++/string/SA.hpp
layout: document
redirect_from:
- /library/C++/string/SA.hpp
- /library/C++/string/SA.hpp.html
title: Suffix Array
---
