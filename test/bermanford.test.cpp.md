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
  code: "#define PROBLEM \"https://onlinejudge.u-aizu.ac.jp/courses/library/5/GRL/1/GRL_1_B\"\
    \n#include \"graph.hpp\"\nconstexpr long long lim = std::numeric_limits<long long>::max();\n\
    int main() {\n    int v, e, r;\n    std::cin >> v >> e >> r;\n    w_graph<false>\
    \ g(v, 0);\n    g.input(e);\n    const auto res = g.bellman_ford(r);\n    if(res.empty())\
    \ {\n        std::cout << \"NEGATIVE CYCLE\\n\";\n        std::exit(0);\n    }\n\
    \    for(const auto &el: res) {\n        if(el == lim) {\n            std::cout\
    \ << \"INF\\n\";\n        }\n        else {\n            std::cout << el << '\\\
    n';\n        }\n    }\n}"
  dependsOn: []
  isVerificationFile: true
  path: test/bermanford.test.cpp
  requiredBy: []
  timestamp: '1970-01-01 00:00:00+00:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: test/bermanford.test.cpp
layout: document
redirect_from:
- /verify/test/bermanford.test.cpp
- /verify/test/bermanford.test.cpp.html
title: test/bermanford.test.cpp
---
