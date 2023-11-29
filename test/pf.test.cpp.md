---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/Pollards_rho.hpp
    title: C++/Pollards_rho.hpp
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://judge.yosupo.jp/problem/factorize
    links:
    - https://judge.yosupo.jp/problem/factorize
  bundledCode: "#line 1 \"test/pf.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/factorize\"\
    \n#include <iostream>\n#include <map>\n#include <C++/Pollards_rho.hpp>\nint main()\
    \ {\n    std::cin.tie(nullptr) -> sync_with_stdio(false);\n    int q;\n    std::cin\
    \ >> q;\n    std::map<ll, std::vector<ll>> m;\n    const auto solve = [&]{\n \
    \       ll n;\n        std::cin >> n;\n        if(m.find(n) == m.end()) {\n  \
    \          auto p = rho(n);\n            std::sort(p.begin(), p.end());\n    \
    \        m.try_emplace(n, p);\n        }\n        const auto ans = m[n];\n   \
    \     std::cout << ans.size();\n        if(ans.size()) {\n            std::cout\
    \ << ' ' << ans.front();\n            for(auto i = ans.begin(); ++i != ans.end();)\
    \ {\n                std::cout << ' ' << *i;\n            }\n        }\n     \
    \   std::cout << '\\n';\n    };\n    while(q--) {\n        solve();\n    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/factorize\"\n#include <iostream>\n\
    #include <map>\n#include <C++/Pollards_rho.hpp>\nint main() {\n    std::cin.tie(nullptr)\
    \ -> sync_with_stdio(false);\n    int q;\n    std::cin >> q;\n    std::map<ll,\
    \ std::vector<ll>> m;\n    const auto solve = [&]{\n        ll n;\n        std::cin\
    \ >> n;\n        if(m.find(n) == m.end()) {\n            auto p = rho(n);\n  \
    \          std::sort(p.begin(), p.end());\n            m.try_emplace(n, p);\n\
    \        }\n        const auto ans = m[n];\n        std::cout << ans.size();\n\
    \        if(ans.size()) {\n            std::cout << ' ' << ans.front();\n    \
    \        for(auto i = ans.begin(); ++i != ans.end();) {\n                std::cout\
    \ << ' ' << *i;\n            }\n        }\n        std::cout << '\\n';\n    };\n\
    \    while(q--) {\n        solve();\n    }\n}"
  dependsOn:
  - C++/Pollards_rho.hpp
  isVerificationFile: true
  path: test/pf.test.cpp
  requiredBy: []
  timestamp: '2023-11-29 21:29:14+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/pf.test.cpp
layout: document
redirect_from:
- /verify/test/pf.test.cpp
- /verify/test/pf.test.cpp.html
title: test/pf.test.cpp
---
