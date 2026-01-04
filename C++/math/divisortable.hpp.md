---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/math/primetable.hpp
    title: Sieve of Eratosthenes
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    document_title: "\u7D04\u6570\u306E\u500B\u6570(\u7DDA\u5F62\u7BE9)"
    links: []
  bundledCode: "#line 2 \"C++/math/divisortable.hpp\"\n\n#line 2 \"C++/math/primetable.hpp\"\
    \n\n#include <vector>\n#include <ranges>\nnamespace man {\nstruct p_table {\n\
    \    std::vector<int> SoE;\n    p_table(const int n): SoE(n + 1, 1) {\n      \
    \  SoE[0] = SoE[1] = 0;\n        for(const long long i: std::views::iota(2, n\
    \ + 1)) {\n            if(!SoE[i]) {\n                continue;\n            }\n\
    \            for(long long j = i * i; j <= n; j += i) {\n                SoE[j]\
    \ = 0;\n            }\n        }\n    }\n    std::vector<int> get() {\n      \
    \  std::vector<int> p;\n        for(const auto i: std::views::iota(2, std::ssize(SoE)))\
    \ {\n            if(SoE[i]) {\n                p.emplace_back(i);\n          \
    \  }\n        }\n        return p;\n    }\n};\n}\n\n/**\n * @brief Sieve of Eratosthenes\n\
    \ */\n#line 4 \"C++/math/divisortable.hpp\"\nnamespace man {\nstruct d_table {\n\
    private:\n    std::vector<int> ret, cnt;\n    p_table pt;\npublic:\n    d_table(const\
    \ int n): ret(n + 1), cnt(n + 1), pt(n){\n        const auto is_prime = pt.SoE;\n\
    \        const auto primes = pt.get();\n        for(const auto i: std::views::iota(2,\
    \ n + 1)) {\n            if(is_prime[i]) {\n                ret[i] = 2;\n    \
    \            cnt[i] = 1;\n            }\n            for(const auto &p: primes)\
    \ {\n                if(static_cast<long long>(i) * p > n) {\n               \
    \     break;\n                }\n                if(i % p == 0) {\n          \
    \          cnt[i * p] = cnt[i] + 1;\n\t\t\t\t\tret[i * p] = ret[i] / (cnt[i] +\
    \ 1) * (cnt[i * p] + 1);\n\t\t\t\t\tbreak;\n\t\t\t\t} else {\n\t\t\t\t\tcnt[i\
    \ * p] = 1;\n\t\t\t\t\tret[i * p] = ret[i] * 2;\n\t\t\t\t}\n            }\n  \
    \      }\n    }\n    inline std::vector<int> get() noexcept { return ret; }\n\
    \    inline int get(const int i) noexcept { return ret[i]; }\n};\n}\n\n/**\n *\
    \ @brief \u7D04\u6570\u306E\u500B\u6570(\u7DDA\u5F62\u7BE9)\n */\n"
  code: "#pragma once\n\n#include \"C++/math/primetable.hpp\"\nnamespace man {\nstruct\
    \ d_table {\nprivate:\n    std::vector<int> ret, cnt;\n    p_table pt;\npublic:\n\
    \    d_table(const int n): ret(n + 1), cnt(n + 1), pt(n){\n        const auto\
    \ is_prime = pt.SoE;\n        const auto primes = pt.get();\n        for(const\
    \ auto i: std::views::iota(2, n + 1)) {\n            if(is_prime[i]) {\n     \
    \           ret[i] = 2;\n                cnt[i] = 1;\n            }\n        \
    \    for(const auto &p: primes) {\n                if(static_cast<long long>(i)\
    \ * p > n) {\n                    break;\n                }\n                if(i\
    \ % p == 0) {\n                    cnt[i * p] = cnt[i] + 1;\n\t\t\t\t\tret[i *\
    \ p] = ret[i] / (cnt[i] + 1) * (cnt[i * p] + 1);\n\t\t\t\t\tbreak;\n\t\t\t\t}\
    \ else {\n\t\t\t\t\tcnt[i * p] = 1;\n\t\t\t\t\tret[i * p] = ret[i] * 2;\n\t\t\t\
    \t}\n            }\n        }\n    }\n    inline std::vector<int> get() noexcept\
    \ { return ret; }\n    inline int get(const int i) noexcept { return ret[i]; }\n\
    };\n}\n\n/**\n * @brief \u7D04\u6570\u306E\u500B\u6570(\u7DDA\u5F62\u7BE9)\n */"
  dependsOn:
  - C++/math/primetable.hpp
  isVerificationFile: false
  path: C++/math/divisortable.hpp
  requiredBy: []
  timestamp: '2026-01-04 19:34:02+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/math/divisortable.hpp
layout: document
redirect_from:
- /library/C++/math/divisortable.hpp
- /library/C++/math/divisortable.hpp.html
title: "\u7D04\u6570\u306E\u500B\u6570(\u7DDA\u5F62\u7BE9)"
---
