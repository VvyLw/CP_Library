---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: C++/ds/uf/UnionFind.hpp
    title: UnionFind
  - icon: ':question:'
    path: C++/graph/edge.hpp
    title: Edge
  - icon: ':heavy_check_mark:'
    path: C++/graph/mst/MST.hpp
    title: "\u6700\u5C0F\u5168\u57DF\u6728"
  - icon: ':heavy_check_mark:'
    path: C++/graph/mst/kruskal.hpp
    title: "Kruskal\u6CD5"
  - icon: ':heavy_check_mark:'
    path: C++/graph/mst/manhattan.hpp
    title: Manhattan MST
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
    \n#include <iostream>\n#line 2 \"C++/graph/mst/kruskal.hpp\"\n\n#include <vector>\n\
    #line 2 \"C++/graph/mst/MST.hpp\"\n\n#line 2 \"C++/graph/edge.hpp\"\n#ifndef EDGE\n\
    #define EDGE\n#endif\n\nnamespace man {\nstruct edge {\n    int src, to, id;\n\
    \    long long cost;\n    edge(){}\n    edge(const int src_, const int to_, const\
    \ int id_ = -1, const long long cost_ = 0): src(src_), to(to_), id(id_), cost(cost_){}\n\
    \    constexpr inline operator int() const noexcept { return to; }\n};\n}\n\n\
    /**\n * @brief Edge\n */\n#line 5 \"C++/graph/mst/MST.hpp\"\nstruct MST {\n  \
    \  std::vector<man::edge> tree;\n    long long cost;\n};\n\n/**\n * @brief \u6700\
    \u5C0F\u5168\u57DF\u6728\n */\n#line 2 \"C++/ds/uf/UnionFind.hpp\"\n\r\n#include\
    \ <cassert>\r\n#line 5 \"C++/ds/uf/UnionFind.hpp\"\n#include <algorithm>\r\nnamespace\
    \ man {\r\nstruct UnionFind {\r\nprotected:\r\n    std::vector<int> par;\r\npublic:\r\
    \n    UnionFind(const int n): par(n, -1){}\r\n    inline int operator[](int i)\
    \ noexcept {\r\n        while(par[i] >= 0) {\r\n            const int p = par[par[i]];\r\
    \n            if(p < 0) return par[i];\r\n            i = par[i] = p;\r\n    \
    \    }\r\n        return i;\r\n    }\r\n    inline bool unite(int x, int y) noexcept\
    \ {\r\n        x = (*this)[x], y = (*this)[y];\r\n        if(x == y) return false;\r\
    \n        if(-par[x] < -par[y]) {\r\n            std::swap(x, y);\r\n        }\r\
    \n        par[x] += par[y], par[y] = x;\r\n        return true;\r\n    }\r\n \
    \   inline int size(const int x) noexcept {\r\n        return -par[(*this)[x]];\r\
    \n    }\r\n    inline int size() const noexcept { return par.size(); }\r\n   \
    \ inline std::vector<std::vector<int>> groups() noexcept {\r\n        const int\
    \ n = std::ssize(par);\r\n        std::vector<std::vector<int>> res(n);\r\n  \
    \      for(int i = 0; i < n; ++i) {\r\n            res[(*this)[i]].emplace_back(i);\r\
    \n        }\r\n        const auto it = std::ranges::remove_if(res, [&](const std::vector<int>\
    \ &v){ return v.empty(); });\r\n        res.erase(it.begin(), it.end());\r\n \
    \       return res;\r\n    }\r\n};\r\n\r\ninline bool is_bipartite(UnionFind uf)\
    \ noexcept {\r\n    assert(uf.size() % 2 == 0);\r\n    const int n = uf.size()\
    \ / 2;\r\n    bool ok = true;\r\n    for(int i = 0; i < n; ++i) {\r\n        ok\
    \ &= uf[i] != uf[i + n];\r\n    }\r\n    return ok;\r\n}\r\n}\r\n/**\r\n * @brief\
    \ UnionFind\r\n * @see https://github.com/maspypy/library/blob/main/ds/unionfind/unionfind.hpp\r\
    \n */\n#line 6 \"C++/graph/mst/kruskal.hpp\"\nnamespace man {\ninline MST kruskal(std::vector<edge>\
    \ edges, const int n) noexcept {\n    std::ranges::sort(edges, [&](const edge\
    \ &e, const edge &f) -> bool { return e.cost < f.cost; });\n    UnionFind uf(n);\n\
    \    std::vector<edge> e;\n    long long ret = 0;\n    for(const auto &ed: edges)\
    \ {\n        if(uf.unite(ed.src, ed)) {\n            e.emplace_back(ed);\n   \
    \         ret += ed.cost;\n        }\n    }\n    return {e, ret};\n}\n}\n\n/**\n\
    \ * @brief Kruskal\u6CD5\n */\n#line 2 \"C++/graph/mst/manhattan.hpp\"\n\n#line\
    \ 4 \"C++/graph/mst/manhattan.hpp\"\n#include <map>\n#include <numeric>\n#include\
    \ <ranges>\n#line 8 \"C++/graph/mst/manhattan.hpp\"\nnamespace man {\ntemplate\
    \ <std::integral T> inline std::vector<edge> manhattan(std::vector<T> x, std::vector<T>\
    \ y) noexcept {\n    assert(std::ssize(x) == std::ssize(y));\n    std::vector<edge>\
    \ ret;\n    std::vector<int> id(std::ssize(x));\n    std::iota(id.begin(), id.end(),\
    \ 0);\n    for([[maybe_unused]] const auto _: std::views::iota(0, 2)) {\n    \
    \    for([[maybe_unused]] const auto _: std::views::iota(0, 2)) {\n          \
    \  std::ranges::sort(id, [&](const int i, const int j) -> bool { return x[i] +\
    \ y[i] < x[j] + y[j]; });\n            std::map<T, int> idx;\n            for(const\
    \ auto i: id) {\n                for(auto it = idx.lower_bound(-y[i]); it != idx.end();\
    \ it = idx.erase(it)) {\n                    const int j = it->second;\n     \
    \               if(x[i] - x[j] < y[i] - y[j]) {\n                        break;\n\
    \                    }\n                    ret.emplace_back(i, j, -1, std::abs(x[i]\
    \ - x[j]) + std::abs(y[i] - y[j]));\n                }\n                idx[-y[i]]\
    \ = i;\n            }\n            x.swap(y);\n        }\n        for(const auto\
    \ i: std::views::iota(0, std::ssize(x))) {\n            x[i] *= -1;\n        }\n\
    \    }\n    return ret;\n}\n}\n\n/**\n * @brief Manhattan MST\n * @see https://ei1333.github.io/library/graph/mst/manhattan-mst.hpp\n\
    \ */\n#line 5 \"test/manhattan.test.cpp\"\nint main() {\n    int n;\n    std::cin\
    \ >> n;\n    std::vector<int> x(n), y(n);\n    for(int i = 0; i < n; ++i) {\n\
    \        std::cin >> x[i] >> y[i];\n    }\n    const auto ans = man::kruskal(man::manhattan(x,\
    \ y), n);\n    std::cout << ans.cost << '\\n';\n    for(const auto &e: ans.tree)\
    \ {\n        std::cout << e.src << ' ' << e.to << '\\n';\n    }\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/manhattanmst\"\n#include\
    \ <iostream>\n#include \"C++/graph/mst/kruskal.hpp\"\n#include \"C++/graph/mst/manhattan.hpp\"\
    \nint main() {\n    int n;\n    std::cin >> n;\n    std::vector<int> x(n), y(n);\n\
    \    for(int i = 0; i < n; ++i) {\n        std::cin >> x[i] >> y[i];\n    }\n\
    \    const auto ans = man::kruskal(man::manhattan(x, y), n);\n    std::cout <<\
    \ ans.cost << '\\n';\n    for(const auto &e: ans.tree) {\n        std::cout <<\
    \ e.src << ' ' << e.to << '\\n';\n    }\n}"
  dependsOn:
  - C++/graph/mst/kruskal.hpp
  - C++/graph/mst/MST.hpp
  - C++/graph/edge.hpp
  - C++/ds/uf/UnionFind.hpp
  - C++/graph/mst/manhattan.hpp
  isVerificationFile: true
  path: test/manhattan.test.cpp
  requiredBy: []
  timestamp: '2025-06-14 01:07:36+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/manhattan.test.cpp
layout: document
redirect_from:
- /verify/test/manhattan.test.cpp
- /verify/test/manhattan.test.cpp.html
title: test/manhattan.test.cpp
---
