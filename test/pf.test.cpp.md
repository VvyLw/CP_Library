---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: cpp
  _verificationStatusIcon: ':x:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 401, in update\n    self.update(self._resolve(pathlib.Path(included), included_from=path))\n\
    \  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 260, in _resolve\n    raise BundleErrorAt(path, -1, \"no such header\"\
    )\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt: Pollards_rho.hpp:\
    \ line -1: no such header\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/factorize\"\n#include <iostream>\n\
    #include <map>\n#include \"Pollards_rho.hpp\"\nint main() {\n    std::cin.tie(nullptr)\
    \ -> sync_with_stdio(false);\n    int q;\n    std::cin >> q;\n    std::map<ll,\
    \ std::vector<ll>> m;\n    const auto solve = [&]{\n        ll n;\n        std::cin\
    \ >> n;\n        if(m.find(n) == m.end()) {\n            auto p = rho(n);\n  \
    \          std::sort(p.begin(), p.end());\n            m.try_emplace(n, p);\n\
    \        }\n        const auto ans = m[n];\n        std::cout << ans.size();\n\
    \        if(ans.size()) {\n            std::cout << ' ' << ans.front();\n    \
    \        for(auto i = ans.begin(); ++i != ans.end();) {\n                std::cout\
    \ << ' ' << *i;\n            }\n        }\n        std::cout << '\\n';\n    };\n\
    \    while(q--) {\n        solve();\n    }\n}"
  dependsOn: []
  isVerificationFile: true
  path: test/pf.test.cpp
  requiredBy: []
  timestamp: '1970-01-01 00:00:00+00:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: test/pf.test.cpp
layout: document
redirect_from:
- /verify/test/pf.test.cpp
- /verify/test/pf.test.cpp.html
title: test/pf.test.cpp
---
