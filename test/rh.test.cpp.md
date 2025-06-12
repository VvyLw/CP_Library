---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: C++/core/alias.hpp
    title: "\u30A8\u30A4\u30EA\u30A2\u30B9"
  - icon: ':heavy_check_mark:'
    path: C++/string/RH.hpp
    title: Rolling Hash
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/14/ALDS1_14_B
    links:
    - https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/14/ALDS1_14_B
  bundledCode: "#line 1 \"test/rh.test.cpp\"\n#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/14/ALDS1_14_B\"\
    \n#include <iostream>\n#line 2 \"C++/string/RH.hpp\"\n\n#include <vector>\n#include\
    \ <chrono>\n#include <ranges>\nnamespace man {\n#ifndef ALIAS\nconstexpr int64_t\
    \ LINF = (1LL << 61) - 1;\n#endif\nconst uint64_t base = std::chrono::duration_cast<std::chrono::microseconds>(std::chrono::system_clock::now().time_since_epoch()).count()\
    \ % LINF;\ntemplate <uint64_t mod> struct RollingHash {\nprivate:\n    std::vector<uint64_t>\
    \ hashed, power;\n    static constexpr inline uint64_t mask(const int64_t a) noexcept\
    \ { return (1ULL << a) - 1; }\n    constexpr inline uint64_t mul(const uint64_t\
    \ a, const uint64_t b) const noexcept {\n        __uint128_t ans = __uint128_t(a)\
    \ * b;\n        ans = (ans >> 61) + (ans & mod);\n        if(ans >= mod) {\n \
    \           ans -= mod;\n        }\n        return ans;\n    }\npublic:\n    RollingHash(const\
    \ std::string &s) {\n        const int n = std::ssize(s);\n        hashed.resize(n\
    \ + 1);\n        power.resize(n + 1);\n        power[0] = 1;\n        for(const\
    \ auto i: std::views::iota(0, n)) {\n            power[i + 1] = mul(power[i],\
    \ base);\n            hashed[i + 1] = mul(hashed[i], base) + s[i];\n         \
    \   if(hashed[i + 1] >= mod) {\n                hashed[i + 1] -= mod;\n      \
    \      }\n        }\n    }\n    constexpr inline uint64_t get(const int64_t l,\
    \ const int64_t r) const noexcept {\n        uint64_t ret = hashed[r] + mod -\
    \ mul(hashed[l], power[r - l]);\n        if(ret >= mod) {\n            ret -=\
    \ mod;\n        }\n        return ret;\n    }\n    constexpr inline uint64_t connect(const\
    \ uint64_t h1, const uint64_t h2, const int64_t h2len) const noexcept {\n    \
    \    uint64_t ret = mul(h1, power[h2len]) + h2;\n        if(ret >= mod) {\n  \
    \          ret -= mod;\n        }\n        return ret;\n    }\n    constexpr inline\
    \ int64_t LCP(const RollingHash &b, int64_t l1, int64_t r1, int64_t l2, int64_t\
    \ r2) noexcept {\n        int64_t low = -1, high = std::min(r1 - l1, r2 - l2)\
    \ + 1;\n        while(high - low > 1) {\n            const int64_t mid = (low\
    \ + high) / 2;\n            if(get(l1, l1 + mid) == b.get(l2, l2 + mid)) {\n \
    \               low = mid;\n            } else {\n                high = mid;\n\
    \            }\n        }\n        return low;\n    }\n};\ntypedef RollingHash<LINF>\
    \ RH;\n}\n\n/**\n * @brief Rolling Hash\n * @see https://github.com/tatyam-prime/kyopro_library/blob/master/RollingHash.cpp\n\
    \ */\n#line 2 \"C++/core/alias.hpp\"\n\n#ifndef ALIAS\n#define ALIAS\n#endif\n\
    \n#include <limits>\n#include <numbers>\n#include <queue>\n#include <ext/pb_ds/assoc_container.hpp>\n\
    #include <ext/pb_ds/tree_policy.hpp>\n\nnamespace internal {\ntemplate <typename\
    \ T> concept num = std::integral<T> || std::floating_point<T>;\n}\n\nconstexpr\
    \ int dx[] = {0, 0, 0, -1, 1, -1, -1, 1, 1};\nconstexpr int dy[] = {0, -1, 1,\
    \ 0, 0, -1, 1, -1, 1};\nconstexpr int MOD = 0x3b800001;\nconstexpr int M0D = 1e9\
    \ + 7;\nconstexpr int INF = 1 << 30;\nconstexpr int64_t LINF = (1LL << 61) - 1;\n\
    constexpr long double DINF = std::numeric_limits<long double>::infinity();\ntemplate\
    \ <internal::num T> constexpr T LIM = std::numeric_limits<T>::max();\nconstexpr\
    \ long double PI = std::numbers::pi;\nconstexpr long double E = std::numbers::e;\n\
    \ntypedef int64_t i64;\ntypedef long double ld;\ntypedef uint32_t u32;\ntypedef\
    \ uint64_t u64;\ntypedef __int128_t i128;\ntypedef __uint128_t u128;\ntemplate\
    \ <size_t N> using ti = std::array<i64, N>;\ntypedef ti<3> tri;\ntemplate <class\
    \ T> using pq = std::priority_queue<T>;\ntemplate <class T> using pqr = std::priority_queue<T,\
    \ std::vector<T>, std::greater<T>>;\ntemplate <class T> using Tree = __gnu_pbds::tree<T,\
    \ __gnu_pbds::null_type, std::less<T>, __gnu_pbds::rb_tree_tag, __gnu_pbds::tree_order_statistics_node_update>;\n\
    template <class T> using TREE = __gnu_pbds::tree<T, __gnu_pbds::null_type, std::greater<T>,\
    \ __gnu_pbds::rb_tree_tag, __gnu_pbds::tree_order_statistics_node_update>;\n\n\
    /**\n * @brief \u30A8\u30A4\u30EA\u30A2\u30B9\n */\n#line 5 \"test/rh.test.cpp\"\
    \nint main() {\n    std::string t, p;\n    std::cin >> t >> p;\n    man::RH rh1(t),\
    \ rh2(p);\n    for(size_t i = 0; i + p.size() <= t.size(); ++i) {\n        if(rh1.get(i,\
    \ i + p.size()) == rh2.get(0, p.size())) {\n            std::cout << i << '\\\
    n';\n        }\n    }\n}\n"
  code: "#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/14/ALDS1_14_B\"\
    \n#include <iostream>\n#include \"C++/string/RH.hpp\"\n#include \"C++/core/alias.hpp\"\
    \nint main() {\n    std::string t, p;\n    std::cin >> t >> p;\n    man::RH rh1(t),\
    \ rh2(p);\n    for(size_t i = 0; i + p.size() <= t.size(); ++i) {\n        if(rh1.get(i,\
    \ i + p.size()) == rh2.get(0, p.size())) {\n            std::cout << i << '\\\
    n';\n        }\n    }\n}"
  dependsOn:
  - C++/string/RH.hpp
  - C++/core/alias.hpp
  isVerificationFile: true
  path: test/rh.test.cpp
  requiredBy: []
  timestamp: '2025-06-12 17:15:04+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/rh.test.cpp
layout: document
redirect_from:
- /verify/test/rh.test.cpp
- /verify/test/rh.test.cpp.html
title: test/rh.test.cpp
---
