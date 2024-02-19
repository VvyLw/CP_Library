---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    document_title: "Kruskal\u6CD5"
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
  code: "#pragma once\n\n#include <vector>\n#include \"graph/mst/MST.hpp\"\n#include\
    \ \"structure/uf/UnionFind.hpp\"\ninline MST kruskal(std::vector<edge> edges,\
    \ const int n) {\n    std::sort(edges.begin(), edges.end(), [&](const edge &e,\
    \ const edge &f){ return e.cost < f.cost; });\n    UnionFind uf(n);\n    std::vector<edge>\
    \ e;\n    long long res = 0;\n    for(const auto &ed: edges) {\n        if(uf.unite(ed.src,\
    \ ed)) {\n            e.emplace_back(ed);\n            res += ed.cost;\n     \
    \   }\n    }\n    return MST{e, res};\n}\n\n/**\n * @brief Kruskal\u6CD5\n */"
  dependsOn: []
  isVerificationFile: false
  path: C++/graph/mst/kruskal.hpp
  requiredBy: []
  timestamp: '1970-01-01 00:00:00+00:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/graph/mst/kruskal.hpp
layout: document
redirect_from:
- /library/C++/graph/mst/kruskal.hpp
- /library/C++/graph/mst/kruskal.hpp.html
title: "Kruskal\u6CD5"
---
