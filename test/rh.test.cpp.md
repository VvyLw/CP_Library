---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
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
    \ <chrono>\n#include <ranges>\nnamespace man {\n#ifndef ALIAS\nconstexpr long\
    \ long LINF = (1LL << 61) - 1;\n#endif\nconst unsigned long long base = std::chrono::duration_cast<std::chrono::microseconds>(std::chrono::system_clock::now().time_since_epoch()).count()\
    \ % LINF;\ntemplate <unsigned long long mod> struct RollingHash {\nprivate:\n\
    \    std::vector<unsigned long long> hashed, power;\n    static constexpr inline\
    \ unsigned long long mask(const long long a) noexcept { return (1ULL << a) - 1;\
    \ }\n    constexpr inline unsigned long long mul(const unsigned long long a, const\
    \ unsigned long long b) const noexcept {\n        __uint128_t ans = __uint128_t(a)\
    \ * b;\n        ans = (ans >> 61) + (ans & mod);\n        if(ans >= mod) {\n \
    \           ans -= mod;\n        }\n        return ans;\n    }\npublic:\n    RollingHash(const\
    \ std::string &s) {\n        const int n = std::ssize(s);\n        hashed.resize(n\
    \ + 1);\n        power.resize(n + 1);\n        power[0] = 1;\n        for(const\
    \ auto i: std::views::iota(0, n)) {\n            power[i + 1] = mul(power[i],\
    \ base);\n            hashed[i + 1] = mul(hashed[i], base) + s[i];\n         \
    \   if(hashed[i + 1] >= mod) {\n                hashed[i + 1] -= mod;\n      \
    \      }\n        }\n    }\n    constexpr inline unsigned long long get(const\
    \ long long l, const long long r) const noexcept {\n        unsigned long long\
    \ ret = hashed[r] + mod - mul(hashed[l], power[r - l]);\n        if(ret >= mod)\
    \ {\n            ret -= mod;\n        }\n        return ret;\n    }\n    constexpr\
    \ inline unsigned long long connect(const unsigned long long h1, const unsigned\
    \ long long h2, const long long h2len) const noexcept {\n        unsigned long\
    \ long ret = mul(h1, power[h2len]) + h2;\n        if(ret >= mod) {\n         \
    \   ret -= mod;\n        }\n        return ret;\n    }\n    constexpr inline long\
    \ long LCP(const RollingHash &b, long long l1, long long r1, long long l2, long\
    \ long r2) noexcept {\n        long long low = -1, high = std::min(r1 - l1, r2\
    \ - l2) + 1;\n        while(high - low > 1) {\n            const long long mid\
    \ = (low + high) / 2;\n            if(get(l1, l1 + mid) == b.get(l2, l2 + mid))\
    \ {\n                low = mid;\n            } else {\n                high =\
    \ mid;\n            }\n        }\n        return low;\n    }\n};\ntypedef RollingHash<LINF>\
    \ RH;\n}\n\n/**\n * @brief Rolling Hash\n * @see https://github.com/tatyam-prime/kyopro_library/blob/master/RollingHash.cpp\n\
    \ */\n#line 2 \"C++/core/alias.hpp\"\n\n#ifndef ALIAS\n#define ALIAS\n#endif\n\
    \n#include <limits>\n#include <numbers>\n#include <queue>\n#include <ext/pb_ds/assoc_container.hpp>\n\
    #include <ext/pb_ds/tree_policy.hpp>\n\nnamespace internal {\ntemplate <typename\
    \ T> concept num = std::integral<T> || std::floating_point<T>;\n}\n\nconstexpr\
    \ int dx[] = {0, 0, 0, -1, 1, -1, -1, 1, 1};\nconstexpr int dy[] = {0, -1, 1,\
    \ 0, 0, -1, 1, -1, 1};\nconstexpr int MOD = 0x3b800001;\nconstexpr int M0D = 1e9\
    \ + 7;\nconstexpr int INF = 1 << 30;\nconstexpr long long LINF = (1LL << 61) -\
    \ 1;\nconstexpr long double DINF = std::numeric_limits<long double>::infinity();\n\
    constexpr long double PI = std::numbers::pi;\nconstexpr long double E = std::numbers::e;\n\
    \ntypedef long long i64;\ntypedef long double ld;\ntypedef unsigned u32;\ntypedef\
    \ unsigned long long u64;\ntypedef __int128_t i128;\ntypedef __uint128_t u128;\n\
    namespace man {\ntemplate <size_t N> using ti = std::array<i64, N>;\ntypedef ti<3>\
    \ tri;\ntemplate <class T> using pq = std::priority_queue<T>;\ntemplate <class\
    \ T> using pqr = std::priority_queue<T, std::vector<T>, std::greater<T>>;\ntemplate\
    \ <class T> using Tree = __gnu_pbds::tree<T, __gnu_pbds::null_type, std::less<T>,\
    \ __gnu_pbds::rb_tree_tag, __gnu_pbds::tree_order_statistics_node_update>;\ntemplate\
    \ <class T> using TREE = __gnu_pbds::tree<T, __gnu_pbds::null_type, std::greater<T>,\
    \ __gnu_pbds::rb_tree_tag, __gnu_pbds::tree_order_statistics_node_update>;\n}\n\
    \n/**\n * @brief \u30A8\u30A4\u30EA\u30A2\u30B9\n */\n#line 5 \"test/rh.test.cpp\"\
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
  timestamp: '2025-09-02 10:21:41+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/rh.test.cpp
layout: document
redirect_from:
- /verify/test/rh.test.cpp
- /verify/test/rh.test.cpp.html
title: test/rh.test.cpp
---
