---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/WM.test.cpp
    title: test/WM.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/WM2.test.cpp
    title: test/WM2.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    _deprecated_at_docs: docs/WM.md
    document_title: Wavelet Matrix
    links:
    - https://ei1333.github.io/library/structure/wavelet/wavelet-matrix.hpp
  bundledCode: "#line 2 \"C++/ds/WM.hpp\"\n\n#include <cassert>\n#include <vector>\n\
    #include <algorithm>\n#include <tuple>\nstruct SIDict {\nprivate:\n    int blk;\n\
    \    std::vector<int> bit, sum;\npublic:\n    SIDict(){}\n    SIDict(const int\
    \ len): blk((len + 31) >> 5), bit(blk), sum(blk){}\n    void set(const int k){\
    \ bit[k >> 5] |= 1 << (k & 31); }\n    void build() {\n\t\tsum[0] = 0;\n\t\tfor(int\
    \ i = 0; ++i < blk;) {\n\t\t\tsum[i] = sum[i - 1] + __builtin_popcount(bit[i -\
    \ 1]);\n\t\t}\n\t}\n    int rank(const int k) const { return (sum[k >> 5] + __builtin_popcount(bit[k\
    \ >> 5] & ((1 << (k & 31)) - 1))); }\n    int rank(const bool val, const int k)\
    \ const { return val ? rank(k) : k - rank(k); }\n    bool operator[](const int\
    \ k) noexcept { return (bit[k >> 5] >> (k & 31)) & 1; }\n};\n\ntemplate <class\
    \ T, int log = 18> struct WMBeta {\nprivate:\n    SIDict matrix[log];\n    int\
    \ mid[log];\n    T access(int k) const {\n        T ret = 0;\n        for(int\
    \ level = log; --level >= 0;) {\n            const bool f = matrix[level][k];\n\
    \            if(f) {\n                ret |= (T)1 << level;\n            }\n \
    \           k = matrix[level].rank(f, k) + mid[level] * f;\n        }\n      \
    \  return ret;\n    }\n    std::pair<int, int> succ(const bool f, const int l,\
    \ const int r, const int level) const { return {matrix[level].rank(f, l) + mid[level]\
    \ * f, matrix[level].rank(f, r) + mid[level] * f}; }\npublic:\n    WMBeta(){}\n\
    \    WMBeta(std::vector<T> v) {\n        const int len = v.size();\n        std::vector<T>\
    \ l(len), r(len);\n        for(int level = log; --level >= 0;) {\n           \
    \ matrix[level] = SIDict(len + 1);\n            int left = 0, right = 0;\n   \
    \         for(int i = 0; i < len; ++i) {\n                if((v[i] >> level) &\
    \ 1) {\n                    matrix[level].set(i);\n                    r[right++]\
    \ = v[i];\n                }\n                else {\n                    l[left++]\
    \ = v[i];\n                }\n            }\n            mid[level] = left;\n\
    \            matrix[level].build();\n            v.swap(l);\n            for(int\
    \ i = 0; i < right; ++i) {\n                v[left + i] = r[i];\n            }\n\
    \        }\n    }\n    T operator[](const int k) noexcept { return access(k);\
    \ }\n    int rank(const T x, int r) const {\n        int l = 0;\n        for(int\
    \ level = log; --level >= 0;) {\n            std::tie(l, r) = succ((x >> level)\
    \ & 1, l, r, level);\n        }\n        return r - l;\n    }\n    T kth_min(int\
    \ l, int r, int k) const {\n        assert(0 <= k && k < r - l);\n        T ret\
    \ = 0;\n        for(int level = log; --level >= 0;) {\n            const int cnt\
    \ = matrix[level].rank(false, r) - matrix[level].rank(false, l);\n           \
    \ const bool f = cnt <= k;\n            if(f) {\n                ret |= T(1) <<\
    \ level;\n                k -= cnt;\n            }\n            std::tie(l, r)\
    \ = succ(f, l, r, level);\n        }\n        return ret;\n    }\n    T kth_max(const\
    \ int l, const int r, const int k) const { return kth_min(l, r, r - l - k - 1);\
    \ }\n    int range_freq(int l, int r, const T upper) const {\n        int ret\
    \ = 0;\n        for(int level = log; --level;) {\n            const bool f = (upper\
    \ >> level) & 1;\n            if(f) {\n                ret += matrix[level].rank(false,\
    \ r) - matrix[level].rank(false, l);\n            }\n            std::tie(l, r)\
    \ = succ(f, l, r, level);\n        }\n        return ret;\n    }\n    int range_freq(const\
    \ int l, const int r, const T lower, const T upper) const { return range_freq(l,\
    \ r, upper) - range_freq(l, r, lower); }\n    T prev(const int l, const int r,\
    \ const T upper) const {\n\t\tconst int cnt = range_freq(l, r, upper);\n\t\treturn\
    \ cnt == 0 ? (T)-1 : kth_min(l, r, cnt - 1);\n\t}\n    T next(const int l, const\
    \ int r, const T lower) const {\n\t\tconst int cnt = range_freq(l, r, lower);\n\
    \t\treturn cnt == r - l ? (T)-1 : kth_min(l, r, cnt);\n\t}\n};\n\ntemplate <class\
    \ T, int log = 18> struct WaveletMatrix {\nprivate:\n    WMBeta<int, log> mat;\n\
    \    std::vector<T> ys;\n    inline int get(const T x) const { return std::lower_bound(ys.cbegin(),\
    \ ys.cend(), x) - ys.cbegin(); }\n    T access(const int k) const { return ys[mat[k]];\
    \ }\npublic:\n    WaveletMatrix(const std::vector<T> v): ys(v) {\n        std::sort(ys.begin(),\
    \ ys.end());\n        ys.erase(std::unique(ys.begin(), ys.end()), ys.end());\n\
    \        std::vector<int> t(v.size());\n        for(int i = 0; auto &el: v) {\n\
    \            t[i++] = get(el);\n        }\n        mat = WMBeta<int, log>(t);\n\
    \    }\n    T operator[](const int k) noexcept { return access(k); }\n    int\
    \ rank(const T x, const int r) const {\n        const auto pos = get(x);\n   \
    \     if(pos == std::ssize(ys) || ys[pos] != x) {\n            return 0;\n   \
    \     }\n        return mat.rank(pos, r);\n    }\n    T kth_min(const int l, const\
    \ int r, const int k) const { return ys[mat.kth_min(l, r, k)]; }\n    T kth_max(const\
    \ int l, const int r, const int k) const { return ys[mat.kth_max(l, r, k)]; }\n\
    \    int range_freq(const int l, const int r, const T upper) const { return mat.range_freq(l,\
    \ r, get(upper)); }\n    int range_freq(const int l, const int r, const T lower,\
    \ const T upper) const { return mat.range_freq(l, r, get(lower), get(upper));\
    \ }\n    T prev(const int l, const int r, const T upper) {\n        const auto\
    \ ret = mat.prev(l, r, get(upper));\n        return ret == -1 ? (T)-1 : ys[ret];\n\
    \    }\n    T next(const int l, const int r, const T lower) {\n        const auto\
    \ ret = mat.next(l, r, get(lower));\n        return ret == -1 ? (T)-1 : ys[ret];\n\
    \    }\n};\n/**\n * @brief Wavelet Matrix\n * @docs docs/WM.md\n * @see https://ei1333.github.io/library/structure/wavelet/wavelet-matrix.hpp\n\
    \ */\n"
  code: "#pragma once\n\n#include <cassert>\n#include <vector>\n#include <algorithm>\n\
    #include <tuple>\nstruct SIDict {\nprivate:\n    int blk;\n    std::vector<int>\
    \ bit, sum;\npublic:\n    SIDict(){}\n    SIDict(const int len): blk((len + 31)\
    \ >> 5), bit(blk), sum(blk){}\n    void set(const int k){ bit[k >> 5] |= 1 <<\
    \ (k & 31); }\n    void build() {\n\t\tsum[0] = 0;\n\t\tfor(int i = 0; ++i < blk;)\
    \ {\n\t\t\tsum[i] = sum[i - 1] + __builtin_popcount(bit[i - 1]);\n\t\t}\n\t}\n\
    \    int rank(const int k) const { return (sum[k >> 5] + __builtin_popcount(bit[k\
    \ >> 5] & ((1 << (k & 31)) - 1))); }\n    int rank(const bool val, const int k)\
    \ const { return val ? rank(k) : k - rank(k); }\n    bool operator[](const int\
    \ k) noexcept { return (bit[k >> 5] >> (k & 31)) & 1; }\n};\n\ntemplate <class\
    \ T, int log = 18> struct WMBeta {\nprivate:\n    SIDict matrix[log];\n    int\
    \ mid[log];\n    T access(int k) const {\n        T ret = 0;\n        for(int\
    \ level = log; --level >= 0;) {\n            const bool f = matrix[level][k];\n\
    \            if(f) {\n                ret |= (T)1 << level;\n            }\n \
    \           k = matrix[level].rank(f, k) + mid[level] * f;\n        }\n      \
    \  return ret;\n    }\n    std::pair<int, int> succ(const bool f, const int l,\
    \ const int r, const int level) const { return {matrix[level].rank(f, l) + mid[level]\
    \ * f, matrix[level].rank(f, r) + mid[level] * f}; }\npublic:\n    WMBeta(){}\n\
    \    WMBeta(std::vector<T> v) {\n        const int len = v.size();\n        std::vector<T>\
    \ l(len), r(len);\n        for(int level = log; --level >= 0;) {\n           \
    \ matrix[level] = SIDict(len + 1);\n            int left = 0, right = 0;\n   \
    \         for(int i = 0; i < len; ++i) {\n                if((v[i] >> level) &\
    \ 1) {\n                    matrix[level].set(i);\n                    r[right++]\
    \ = v[i];\n                }\n                else {\n                    l[left++]\
    \ = v[i];\n                }\n            }\n            mid[level] = left;\n\
    \            matrix[level].build();\n            v.swap(l);\n            for(int\
    \ i = 0; i < right; ++i) {\n                v[left + i] = r[i];\n            }\n\
    \        }\n    }\n    T operator[](const int k) noexcept { return access(k);\
    \ }\n    int rank(const T x, int r) const {\n        int l = 0;\n        for(int\
    \ level = log; --level >= 0;) {\n            std::tie(l, r) = succ((x >> level)\
    \ & 1, l, r, level);\n        }\n        return r - l;\n    }\n    T kth_min(int\
    \ l, int r, int k) const {\n        assert(0 <= k && k < r - l);\n        T ret\
    \ = 0;\n        for(int level = log; --level >= 0;) {\n            const int cnt\
    \ = matrix[level].rank(false, r) - matrix[level].rank(false, l);\n           \
    \ const bool f = cnt <= k;\n            if(f) {\n                ret |= T(1) <<\
    \ level;\n                k -= cnt;\n            }\n            std::tie(l, r)\
    \ = succ(f, l, r, level);\n        }\n        return ret;\n    }\n    T kth_max(const\
    \ int l, const int r, const int k) const { return kth_min(l, r, r - l - k - 1);\
    \ }\n    int range_freq(int l, int r, const T upper) const {\n        int ret\
    \ = 0;\n        for(int level = log; --level;) {\n            const bool f = (upper\
    \ >> level) & 1;\n            if(f) {\n                ret += matrix[level].rank(false,\
    \ r) - matrix[level].rank(false, l);\n            }\n            std::tie(l, r)\
    \ = succ(f, l, r, level);\n        }\n        return ret;\n    }\n    int range_freq(const\
    \ int l, const int r, const T lower, const T upper) const { return range_freq(l,\
    \ r, upper) - range_freq(l, r, lower); }\n    T prev(const int l, const int r,\
    \ const T upper) const {\n\t\tconst int cnt = range_freq(l, r, upper);\n\t\treturn\
    \ cnt == 0 ? (T)-1 : kth_min(l, r, cnt - 1);\n\t}\n    T next(const int l, const\
    \ int r, const T lower) const {\n\t\tconst int cnt = range_freq(l, r, lower);\n\
    \t\treturn cnt == r - l ? (T)-1 : kth_min(l, r, cnt);\n\t}\n};\n\ntemplate <class\
    \ T, int log = 18> struct WaveletMatrix {\nprivate:\n    WMBeta<int, log> mat;\n\
    \    std::vector<T> ys;\n    inline int get(const T x) const { return std::lower_bound(ys.cbegin(),\
    \ ys.cend(), x) - ys.cbegin(); }\n    T access(const int k) const { return ys[mat[k]];\
    \ }\npublic:\n    WaveletMatrix(const std::vector<T> v): ys(v) {\n        std::sort(ys.begin(),\
    \ ys.end());\n        ys.erase(std::unique(ys.begin(), ys.end()), ys.end());\n\
    \        std::vector<int> t(v.size());\n        for(int i = 0; auto &el: v) {\n\
    \            t[i++] = get(el);\n        }\n        mat = WMBeta<int, log>(t);\n\
    \    }\n    T operator[](const int k) noexcept { return access(k); }\n    int\
    \ rank(const T x, const int r) const {\n        const auto pos = get(x);\n   \
    \     if(pos == std::ssize(ys) || ys[pos] != x) {\n            return 0;\n   \
    \     }\n        return mat.rank(pos, r);\n    }\n    T kth_min(const int l, const\
    \ int r, const int k) const { return ys[mat.kth_min(l, r, k)]; }\n    T kth_max(const\
    \ int l, const int r, const int k) const { return ys[mat.kth_max(l, r, k)]; }\n\
    \    int range_freq(const int l, const int r, const T upper) const { return mat.range_freq(l,\
    \ r, get(upper)); }\n    int range_freq(const int l, const int r, const T lower,\
    \ const T upper) const { return mat.range_freq(l, r, get(lower), get(upper));\
    \ }\n    T prev(const int l, const int r, const T upper) {\n        const auto\
    \ ret = mat.prev(l, r, get(upper));\n        return ret == -1 ? (T)-1 : ys[ret];\n\
    \    }\n    T next(const int l, const int r, const T lower) {\n        const auto\
    \ ret = mat.next(l, r, get(lower));\n        return ret == -1 ? (T)-1 : ys[ret];\n\
    \    }\n};\n/**\n * @brief Wavelet Matrix\n * @docs docs/WM.md\n * @see https://ei1333.github.io/library/structure/wavelet/wavelet-matrix.hpp\n\
    \ */"
  dependsOn: []
  isVerificationFile: false
  path: C++/ds/WM.hpp
  requiredBy: []
  timestamp: '2024-03-04 00:36:37+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/WM.test.cpp
  - test/WM2.test.cpp
documentation_of: C++/ds/WM.hpp
layout: document
redirect_from:
- /library/C++/ds/WM.hpp
- /library/C++/ds/WM.hpp.html
title: Wavelet Matrix
---
[mojaで作った問題](https://mojacoder.app/users/VvyLw/problems/range_k-th_largest_query)で答えが他の人と合わなかったので、もしかしたら間違っているかもしれません。