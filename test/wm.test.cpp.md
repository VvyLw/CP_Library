---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: C++/ds/WM.hpp
    title: Wavelet Matrix
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://judge.yosupo.jp/problem/range_kth_smallest
    links:
    - https://judge.yosupo.jp/problem/range_kth_smallest
  bundledCode: "#line 1 \"test/wm.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/range_kth_smallest\"\
    \n#include <iostream>\n#line 2 \"C++/ds/WM.hpp\"\n\n#include <cassert>\n#include\
    \ <vector>\n#include <algorithm>\n#include <tuple>\n#include <ranges>\nnamespace\
    \ man {\nnamespace internal {\nstruct SIDict {\nprivate:\n    int blk;\n    std::vector<int>\
    \ bit, sum;\npublic:\n    SIDict(){}\n    SIDict(const int len): blk((len + 31)\
    \ >> 5), bit(blk), sum(blk){}\n    inline void set(const int k) noexcept { bit[k\
    \ >> 5] |= 1 << (k & 31); }\n    inline void build() noexcept {\n\t\tsum[0] =\
    \ 0;\n\t\tfor(const auto i: std::views::iota(0, blk - 1)) {\n\t\t\tsum[i + 1]\
    \ = sum[i] + __builtin_popcount(bit[i]);\n\t\t}\n\t}\n    inline int rank(const\
    \ int k) const noexcept { return (sum[k >> 5] + __builtin_popcount(bit[k >> 5]\
    \ & ((1 << (k & 31)) - 1))); }\n    inline int rank(const bool val, const int\
    \ k) const noexcept { return val ? rank(k) : k - rank(k); }\n    inline bool operator[](const\
    \ int k) noexcept { return (bit[k >> 5] >> (k & 31)) & 1; }\n};\n\ntemplate <class\
    \ T, int log> struct WMBeta {\nprivate:\n    SIDict matrix[log];\n    int mid[log];\n\
    \    constexpr inline T access(int k) const noexcept {\n        T ret = 0;\n \
    \       for(const auto level: std::views::iota(0, log) | std::views::reverse)\
    \ {\n            const bool f = matrix[level][k];\n            if(f) {\n     \
    \           ret |= (T) 1 << level;\n            }\n            k = matrix[level].rank(f,\
    \ k) + mid[level] * f;\n        }\n        return ret;\n    }\n    constexpr inline\
    \ std::pair<int, int> succ(const bool f, const int l, const int r, const int level)\
    \ const noexcept { return {matrix[level].rank(f, l) + mid[level] * f, matrix[level].rank(f,\
    \ r) + mid[level] * f}; }\npublic:\n    WMBeta(){}\n    WMBeta(std::vector<T>\
    \ v) {\n        const int len = std::ssize(v);\n        std::vector<T> l(len),\
    \ r(len);\n        for(const auto level: std::views::iota(0, log) | std::views::reverse)\
    \ {\n            matrix[level] = SIDict(len + 1);\n            int left = 0, right\
    \ = 0;\n            for(const auto i: std::views::iota(0, len)) {\n          \
    \      if((v[i] >> level) & 1) {\n                    matrix[level].set(i);\n\
    \                    r[right++] = v[i];\n                }\n                else\
    \ {\n                    l[left++] = v[i];\n                }\n            }\n\
    \            mid[level] = left;\n            matrix[level].build();\n        \
    \    v.swap(l);\n            for(const auto i: std::views::iota(0, right)) {\n\
    \                v[left + i] = r[i];\n            }\n        }\n    }\n    constexpr\
    \ inline T operator[](const int k) const noexcept { return access(k); }\n    constexpr\
    \ inline int rank(const T x, int r) const noexcept {\n        int l = 0;\n   \
    \     for(const auto level: std::views::iota(0, log) | std::views::reverse) {\n\
    \            std::tie(l, r) = succ((x >> level) & 1, l, r, level);\n        }\n\
    \        return r - l;\n    }\n    constexpr inline T kth_min(int l, int r, int\
    \ k) const noexcept {\n        assert(0 <= k && k < r - l);\n        T ret = 0;\n\
    \        for(const auto level: std::views::iota(0, log) | std::views::reverse)\
    \ {\n            const int cnt = matrix[level].rank(false, r) - matrix[level].rank(false,\
    \ l);\n            const bool f = cnt <= k;\n            if(f) {\n           \
    \     ret |= T(1) << level;\n                k -= cnt;\n            }\n      \
    \      std::tie(l, r) = succ(f, l, r, level);\n        }\n        return ret;\n\
    \    }\n    constexpr inline T kth_max(const int l, const int r, const int k)\
    \ const noexcept{ return kth_min(l, r, r - l - k - 1); }\n    constexpr inline\
    \ int range_freq(int l, int r, const T upper) const noexcept {\n        int ret\
    \ = 0;\n        for(const auto level: std::views::iota(0, log) | std::views::reverse)\
    \ {\n            const bool f = (upper >> level) & 1;\n            if(f) {\n \
    \               ret += matrix[level].rank(false, r) - matrix[level].rank(false,\
    \ l);\n            }\n            std::tie(l, r) = succ(f, l, r, level);\n   \
    \     }\n        return ret;\n    }\n    constexpr inline int range_freq(const\
    \ int l, const int r, const T lower, const T upper) const noexcept { return range_freq(l,\
    \ r, upper) - range_freq(l, r, lower); }\n    constexpr inline T prev(const int\
    \ l, const int r, const T upper) const noexcept {\n\t\tconst int cnt = range_freq(l,\
    \ r, upper);\n\t\treturn cnt == 0 ? (T)-1 : kth_min(l, r, cnt - 1);\n\t}\n   \
    \ constexpr inline T next(const int l, const int r, const T lower) const noexcept\
    \ {\n\t\tconst int cnt = range_freq(l, r, lower);\n\t\treturn cnt == r - l ? (T)-1\
    \ : kth_min(l, r, cnt);\n\t}\n};\n}\n\ntemplate <class T, int log = 20> struct\
    \ WaveletMatrix {\nprivate:\n    internal::WMBeta<int, log> mat;\n    std::vector<T>\
    \ ys;\n    constexpr inline int get(const T x) const noexcept { return std::ranges::lower_bound(ys,\
    \ x) - ys.cbegin(); }\n    constexpr inline T access(const int k) const noexcept\
    \ { return ys[mat[k]]; }\npublic:\n    WaveletMatrix(const std::vector<T> v):\
    \ ys(v) {\n        std::sort(ys.begin(), ys.end());\n        const auto it = std::ranges::unique(ys);\n\
    \        ys.erase(it.begin(), it.end());\n        std::vector<int> t(v.size());\n\
    \        for(int i = 0; auto &el: v) {\n            t[i++] = get(el);\n      \
    \  }\n        mat = internal::WMBeta<int, log>(t);\n    }\n    constexpr inline\
    \ T operator[](const int k) const noexcept { return access(k); }\n    constexpr\
    \ inline int rank(const int r, const T x) const noexcept {\n        const auto\
    \ pos = get(x);\n        if(pos == std::ssize(ys) || ys[pos] != x) {\n       \
    \     return 0;\n        }\n        return mat.rank(pos, r);\n    }\n    constexpr\
    \ inline int rank(const int l, const int r, const T x) const noexcept { return\
    \ rank(r, x) - rank(l, x); }\n    constexpr inline T kth_min(const int l, const\
    \ int r, const int k) const noexcept { return ys[mat.kth_min(l, r, k)]; }\n  \
    \  constexpr inline T kth_max(const int l, const int r, const int k) const noexcept\
    \ { return ys[mat.kth_max(l, r, k)]; }\n    constexpr inline int range_freq(const\
    \ int l, const int r, const T upper) const noexcept { return mat.range_freq(l,\
    \ r, get(upper)); }\n    constexpr inline int range_freq(const int l, const int\
    \ r, const T lower, const T upper) const noexcept { return mat.range_freq(l, r,\
    \ get(lower), get(upper)); }\n    constexpr inline T prev(const int l, const int\
    \ r, const T upper) noexcept {\n        const auto ret = mat.prev(l, r, get(upper));\n\
    \        return ret == -1 ? (T)-1 : ys[ret];\n    }\n    constexpr inline T next(const\
    \ int l, const int r, const T lower) noexcept {\n        const auto ret = mat.next(l,\
    \ r, get(lower));\n        return ret == -1 ? (T)-1 : ys[ret];\n    }\n};\n}\n\
    /**\n * @brief Wavelet Matrix\n * @see https://ei1333.github.io/library/structure/wavelet/wavelet-matrix.hpp\n\
    \ */\n#line 4 \"test/wm.test.cpp\"\nint main() {\n    int n, q;\n    std::cin\
    \ >> n >> q;\n    std::vector<int> a(n);\n    for(auto &el: a) {\n        std::cin\
    \ >> el;\n    }\n    man::WaveletMatrix<int> wm(a);\n    while(q--) {\n      \
    \  int l, r, k;\n        std::cin >> l >> r >> k;\n        std::cout << wm.kth_min(l,\
    \ r, k) << '\\n';\n    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/range_kth_smallest\"\n\
    #include <iostream>\n#include \"C++/ds/WM.hpp\"\nint main() {\n    int n, q;\n\
    \    std::cin >> n >> q;\n    std::vector<int> a(n);\n    for(auto &el: a) {\n\
    \        std::cin >> el;\n    }\n    man::WaveletMatrix<int> wm(a);\n    while(q--)\
    \ {\n        int l, r, k;\n        std::cin >> l >> r >> k;\n        std::cout\
    \ << wm.kth_min(l, r, k) << '\\n';\n    }\n}"
  dependsOn:
  - C++/ds/WM.hpp
  isVerificationFile: true
  path: test/wm.test.cpp
  requiredBy: []
  timestamp: '2025-06-06 22:43:22+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/wm.test.cpp
layout: document
redirect_from:
- /verify/test/wm.test.cpp
- /verify/test/wm.test.cpp.html
title: test/wm.test.cpp
---
