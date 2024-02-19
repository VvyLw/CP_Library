---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    links: []
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 401, in update\n    self.update(self._resolve(pathlib.Path(included), included_from=path))\n\
    \  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 260, in _resolve\n    raise BundleErrorAt(path, -1, \"no such header\"\
    )\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt: graph/mst/MST.hpp:\
    \ line -1: no such header\n"
  code: "#pragma once\n\n#include <cassert>\n#include <map>\n#include <numeric>\n\
    #include \"graph/mst/MST.hpp\"\ntemplate <class T> inline std::vector<edge> manhattan(std::vector<T>\
    \ x, std::vector<T> y) {\n    assert(x.size() == y.size());\n    std::vector<edge>\
    \ res;\n    std::vector<int> id(x.size());\n    std::iota(id.begin(), id.end(),\
    \ 0);\n    for(int s = 0; s < 2; ++s) {\n        for(int t = 0; t < 2; ++t) {\n\
    \            std::sort(id.begin(), id.end(), [&](const int i, const int j){ return\
    \ x[i] + y[i] < x[j] + y[j]; });\n            std::map<T, int> idx;\n        \
    \    for(const auto i: id) {\n                for(auto it = idx.lower_bound(-y[i]);\
    \ it != idx.end(); it = idx.erase(it)) {\n                    const int j = it\
    \ -> second;\n                    if(x[i] - x[j] < y[i] - y[j]) {\n          \
    \              break;\n                    }\n                    res.emplace_back(i,\
    \ j, -1, std::abs(x[i] - x[j]) + std::abs(y[i] - y[j]));\n                }\n\
    \                idx[-y[i]] = i;\n            }\n            x.swap(y);\n    \
    \    }\n        for(size_t i = 0; i < x.size(); ++i) {\n            x[i] *= -1;\n\
    \        }\n    }\n    return res;\n}"
  dependsOn: []
  isVerificationFile: false
  path: C++/graph/mst/manhattan.hpp
  requiredBy: []
  timestamp: '1970-01-01 00:00:00+00:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/graph/mst/manhattan.hpp
layout: document
redirect_from:
- /library/C++/graph/mst/manhattan.hpp
- /library/C++/graph/mst/manhattan.hpp.html
title: C++/graph/mst/manhattan.hpp
---
