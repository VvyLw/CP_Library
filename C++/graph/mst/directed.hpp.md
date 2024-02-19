---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    document_title: Directed MST
    links:
    - https://ei1333.github.io/library/graph/mst/directed-mst.hpp
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus.py\"\
    , line 187, in bundle\n    bundler.update(path)\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 401, in update\n    self.update(self._resolve(pathlib.Path(included), included_from=path))\n\
    \  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/cplusplus_bundle.py\"\
    , line 260, in _resolve\n    raise BundleErrorAt(path, -1, \"no such header\"\
    )\nonlinejudge_verify.languages.cplusplus_bundle.BundleErrorAt: graph/mst/MST.hpp:\
    \ line -1: no such header\n"
  code: "#pragma once\n\n#include \"graph/mst/MST.hpp\"\n#include \"SkewHeap.hpp\"\
    \ninline MST directed(std::vector<edge> edges, const int n, const int v) {\n \
    \   for(int i = 0; i < n; ++i) {\n        if(i != v) {\n            edges.emplace_back(i,\
    \ v, 0);\n        }\n    }\n    int x = 0;\n    std::vector<int> par(2 * n, -1),\
    \ vis(par), link(par), st;\n    using Node = typename SkewHeap<>::Node;\n    SkewHeap\
    \ heap;\n    std::vector<Node*> ins(2 * n, nullptr);\n    for(size_t i = 0; i\
    \ < edges.size(); ++i) {\n        const auto &e = edges[i];\n        ins[e] =\
    \ heap.push(ins[e], e.cost, i);\n    }\n    const auto go = [&](int z) -> int\
    \ {\n        z = edges[ins[z] -> idx].src;\n        while(link[z] != -1) {\n \
    \           st.emplace_back(z);\n            z = link[z];\n        }\n       \
    \ for(const auto &p : st) {\n            link[p] = z;\n        }\n        st.clear();\n\
    \        return z;\n    };\n    for(int i = n; ins[x]; ++i) {\n        while(vis[x]\
    \ == -1) {\n            vis[x] = 0;\n            x = go(x);\n        }\n     \
    \   while(x != i) {\n            const auto w = ins[x] -> key;\n            auto\
    \ z = heap.pop(ins[x]);\n            z = heap.add(z, -w);\n            ins[i]\
    \ = heap.meld(ins[i], z);\n            par[x] = i;\n            link[x] = i;\n\
    \            x = go(x);\n        }\n        while(ins[x] && go(x) == x) {\n  \
    \          ins[x] = heap.pop(ins[x]);\n        }\n    }\n    for(int i = v; i\
    \ != -1; i = par[i]) {\n\t\tvis[i] = 1;\n\t}\n    long long cost = 0;\n    std::vector<edge>\
    \ e;\n    for(int i = x; i >= 0; i--) {\n\t\tif(vis[i] == 1) {\n\t\t\tcontinue;\n\
    \t\t}\n        cost += edges[ins[i] -> idx].cost;\n        e.emplace_back(edges[ins[i]\
    \ -> idx]);\n        for(int j = edges[ins[i] -> idx]; j != -1 && vis[j] == 0;\
    \ j = par[j]) {\n            vis[j] = 1;\n        }\n    }\n    return MST{e,\
    \ cost};\n}\n\n/**\n * @brief Directed MST\n * @see https://ei1333.github.io/library/graph/mst/directed-mst.hpp\n\
    \ */"
  dependsOn: []
  isVerificationFile: false
  path: C++/graph/mst/directed.hpp
  requiredBy: []
  timestamp: '1970-01-01 00:00:00+00:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/graph/mst/directed.hpp
layout: document
redirect_from:
- /library/C++/graph/mst/directed.hpp
- /library/C++/graph/mst/directed.hpp.html
title: Directed MST
---
