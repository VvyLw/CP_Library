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
    )\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt: graph.hpp: line\
    \ -1: no such header\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/cycle_detection\"\n#include\
    \ <iostream>\n#include \"graph.hpp\"\nint main() {\n    int n, m;\n    std::cin\
    \ >> n >> m;\n    graph<false> g(n, 0);\n    g.input(m);\n    const auto res =\
    \ g.cycle();\n    if(res.empty()) {\n        std::cout << -1 << '\\n';\n    }\
    \ else {\n        std::cout << res.size() << '\\n';\n        for(const auto &e:\
    \ res) {\n            std::cout << e.id << '\\n';\n        }\n    }\n}"
  dependsOn: []
  isVerificationFile: true
  path: test/cycledetector.test.cpp
  requiredBy: []
  timestamp: '1970-01-01 00:00:00+00:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: test/cycledetector.test.cpp
layout: document
redirect_from:
- /verify/test/cycledetector.test.cpp
- /verify/test/cycledetector.test.cpp.html
title: test/cycledetector.test.cpp
---
