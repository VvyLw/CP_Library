---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/MST.hpp
    title: C++/MST.hpp
  - icon: ':heavy_check_mark:'
    path: C++/UnionFind.hpp
    title: C++/UnionFind.hpp
  - icon: ':heavy_check_mark:'
    path: C++/edge.hpp
    title: C++/edge.hpp
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://judge.yosupo.jp/problem/manhattanmst
    links:
    - https://judge.yosupo.jp/problem/manhattanmst
  bundledCode: "#line 1 \"test/manhattan.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/manhattanmst\"\
    \n#include <iostream>\n#line 2 \"C++/MST.hpp\"\n\n#include <cassert>\n#include\
    \ <map>\n#include <numeric>\n#line 2 \"C++/edge.hpp\"\n\nstruct edge {\n    int\
    \ src, to;\n    long long cost;\n    edge(){}\n    edge(const int to_): to(to_){}\n\
    \    edge(const int to_, const long long cost_): to(to_), cost(cost_){}\n    edge(const\
    \ int src_, const int to_, const long long cost_): src(src_), to(to_), cost(cost_){}\n\
    };\n#line 2 \"C++/UnionFind.hpp\"\n\r\n// inspired by maspy(https://github.com/maspypy/library/blob/main/ds/unionfind/unionfind.hpp)\r\
    \n#line 5 \"C++/UnionFind.hpp\"\n#include <vector>\r\n#include <algorithm>\r\n\
    struct UnionFind {\r\nprivate:\r\n    std::vector<int> par;\r\npublic:\r\n   \
    \ UnionFind(const int n): par(n, -1){}\r\n    int operator[](int i) {\r\n    \
    \    while(par[i] >= 0) {\r\n            const int p = par[par[i]];\r\n      \
    \      if(p < 0) return par[i];\r\n            i = par[i] = p;\r\n        }\r\n\
    \        return i;\r\n    }\r\n    bool unite(int x, int y) {\r\n        x = (*this)[x],\
    \ y = (*this)[y];\r\n        if(x == y) return false;\r\n        if(-par[x] <\
    \ -par[y]) {\r\n            std::swap(x, y);\r\n        }\r\n        par[x] +=\
    \ par[y], par[y] = x;\r\n        return true;\r\n    }\r\n    int size(const int\
    \ x) {\r\n        return -par[(*this)[x]];\r\n    }\r\n#if __cplusplus >= 202101L\r\
    \n    std::vector<std::vector<int>> groups() {\r\n        const int n = std::ssize(par);\r\
    \n        std::vector<std::vector<int>> res(n);\r\n        for(int i = 0; i <\
    \ n; ++i) {\r\n            res[(*this)[i]].emplace_back(i);\r\n        }\r\n \
    \       const auto it = std::ranges::remove_if(res, [&](const std::vector<int>\
    \ &v){ return v.empty(); });\r\n        res.erase(it.begin(), it.end());\r\n \
    \       return res;\r\n    }\r\n#else\r\n    std::vector<std::vector<int>> groups()\
    \ {\r\n        const int n = par.size();\r\n        std::vector<std::vector<int>>\
    \ res(n);\r\n        for(int i = 0; i < n; ++i) {\r\n            res[(*this)[i]].emplace_back(i);\r\
    \n        }\r\n        res.erase(std::remove_if(res.begin(), res.end(), [&](const\
    \ std::vector<int> &v){ return v.empty(); }), res.end());\r\n        return res;\r\
    \n    }\r\n#endif\r\n    bool is_bipartite() {\r\n        const int n = par.size()\
    \ / 2;\r\n        bool ok = true;\r\n        for(int i = 0; i < n; ++i) {\r\n\
    \            ok &= (*this)[i] != (*this)[i + n];\r\n        }\r\n        return\
    \ ok;\r\n    }\r\n};\n#line 8 \"C++/MST.hpp\"\n\nstruct MST {\n    std::vector<edge>\
    \ tree;\n    long long cost;\n};\n\ninline MST kruskal(std::vector<edge> edges,\
    \ const int n) {\n    std::sort(edges.begin(), edges.end(), [&](const edge &e,\
    \ const edge &f){ return e.cost < f.cost; });\n    UnionFind uf(n);\n    std::vector<edge>\
    \ e;\n    long long res = 0;\n    for(const auto &ed: edges) {\n        if(uf.unite(ed.src,\
    \ ed.to)) {\n            e.emplace_back(ed);\n            res += ed.cost;\n  \
    \      }\n    }\n    return MST{e, res};\n}\ntemplate <class T> inline std::vector<edge>\
    \ manhattan(std::vector<T> x, std::vector<T> y) {\n    assert(x.size() == y.size());\n\
    \    std::vector<edge> res;\n    std::vector<int> id(x.size());\n    std::iota(id.begin(),\
    \ id.end(), 0);\n    for(int s = 0; s < 2; ++s) {\n        for(int t = 0; t <\
    \ 2; ++t) {\n            std::sort(id.begin(), id.end(), [&](const int i, const\
    \ int j){ return x[i] + y[i] < x[j] + y[j]; });\n            std::map<T, int>\
    \ idx;\n            for(const auto i: id) {\n                for(auto it = idx.lower_bound(-y[i]);\
    \ it != idx.end(); it = idx.erase(it)) {\n                    const int j = it\
    \ -> second;\n                    if(x[i] - x[j] < y[i] - y[j]) {\n          \
    \              break;\n                    }\n                    res.emplace_back(i,\
    \ j, std::abs(x[i] - x[j]) + std::abs(y[i] - y[j]));\n                }\n    \
    \            idx[-y[i]] = i;\n            }\n            x.swap(y);\n        }\n\
    \        for(size_t i = 0; i < x.size(); ++i) {\n            x[i] *= -1;\n   \
    \     }\n    }\n    return res;\n}\n#line 4 \"test/manhattan.test.cpp\"\nint main()\
    \ {\n    int n;\n    std::cin >> n;\n    std::vector<int> x(n), y(n);\n    for(int\
    \ i = 0; i < n; ++i) {\n        std::cin >> x[i] >> y[i];\n    }\n    const auto\
    \ ans = kruskal(manhattan(x, y), n);\n    std::cout << ans.cost << '\\n';\n  \
    \  for(const auto &e: ans.tree) {\n        std::cout << e.src << ' ' << e.to <<\
    \ '\\n';\n    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/manhattanmst\"\n#include\
    \ <iostream>\n#include \"C++/MST.hpp\"\nint main() {\n    int n;\n    std::cin\
    \ >> n;\n    std::vector<int> x(n), y(n);\n    for(int i = 0; i < n; ++i) {\n\
    \        std::cin >> x[i] >> y[i];\n    }\n    const auto ans = kruskal(manhattan(x,\
    \ y), n);\n    std::cout << ans.cost << '\\n';\n    for(const auto &e: ans.tree)\
    \ {\n        std::cout << e.src << ' ' << e.to << '\\n';\n    }\n}"
  dependsOn:
  - C++/MST.hpp
  - C++/edge.hpp
  - C++/UnionFind.hpp
  isVerificationFile: true
  path: test/manhattan.test.cpp
  requiredBy: []
  timestamp: '2023-12-12 02:56:10+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/manhattan.test.cpp
layout: document
redirect_from:
- /verify/test/manhattan.test.cpp
- /verify/test/manhattan.test.cpp.html
title: test/manhattan.test.cpp
---
