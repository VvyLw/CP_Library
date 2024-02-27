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
    )\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt: C++/structure/depq.hpp:\
    \ line -1: no such header\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/double_ended_priority_queue\"\
    \n#include <iostream>\n#include \"C++/structure/depq.hpp\"\nint main() {\n   \
    \ int n, q;\n    std::cin >> n >> q;\n    std::vector<int> s(n);\n    for(auto\
    \ &el: s) {\n        std::cin >> el;\n    }\n    depq<int> depq(s);\n    while(q--)\
    \ {\n        int t;\n        std::cin >> t;\n        if(t == 0) {\n          \
    \  int x;\n            std::cin >> x;\n            depq.push(x);\n        }\n\
    \        else if(t == 1) {\n            std::cout << depq.pop_min() << '\\n';\n\
    \        }\n        else {\n            std::cout << depq.pop_max() << '\\n';\n\
    \        }\n    }\n}"
  dependsOn: []
  isVerificationFile: true
  path: test/depq.test.cpp
  requiredBy: []
  timestamp: '1970-01-01 00:00:00+00:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: test/depq.test.cpp
layout: document
redirect_from:
- /verify/test/depq.test.cpp
- /verify/test/depq.test.cpp.html
title: test/depq.test.cpp
---
