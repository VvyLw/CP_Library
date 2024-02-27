---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    document_title: "Undo\u53EF\u80FDUnionFind"
    links:
    - https://ei1333.github.io/luzhiled/snippets/structure/union-find.html
  bundledCode: "#line 2 \"C++/ds/uf/UFUndo.hpp\"\n\n#include <vector>\n#include <stack>\n\
    struct UFUndo {\nprivate:\n    std::vector<int> par;\n\tstd::stack<std::pair<int,\
    \ int>> his;\npublic:\n\tUFUndo(const int n): par(n, -1){}\n    bool unite(int\
    \ x, int y) {\n\t\tx = root(x);\n\t\ty = root(y);\n\t\this.emplace(std::make_pair(x,\
    \ par[x]));\n\t\this.emplace(std::make_pair(y, par[y]));\n\t\tif(x == y) {\n\t\
    \t\treturn false;\n\t\t}\n\t\tif(par[x] > par[y]) {\n\t\t\tstd::swap(x, y);\n\t\
    \t}\n\t\tpar[x] += par[y];\n\t\tpar[y] = x;\n\t\treturn true;\n\t}\n    int root(int\
    \ k) {\n        if(par[k] < 0) {\n            return k;\n        }\n        return\
    \ root(par[k]);\n    }\n    int size(const int i){ return -par[root(i)]; }\n \
    \   void undo() {\n\t\tpar[his.top().first] = his.top().second;\n        his.pop();\n\
    \t\tpar[his.top().first] = his.top().second;\n        his.pop();\n\t}\n    void\
    \ snapshot() {\n\t\twhile(his.size()) {\n\t\t\this.pop();\n\t\t}\n\t}\n\tvoid\
    \ rollback() {\n\t\twhile(his.size()) {\n\t\t\tundo();\n\t\t}\n\t}\n};\n/**\n\
    \ * @brief Undo\u53EF\u80FDUnionFind\n * @see https://ei1333.github.io/luzhiled/snippets/structure/union-find.html\n\
    \ */\n"
  code: "#pragma once\n\n#include <vector>\n#include <stack>\nstruct UFUndo {\nprivate:\n\
    \    std::vector<int> par;\n\tstd::stack<std::pair<int, int>> his;\npublic:\n\t\
    UFUndo(const int n): par(n, -1){}\n    bool unite(int x, int y) {\n\t\tx = root(x);\n\
    \t\ty = root(y);\n\t\this.emplace(std::make_pair(x, par[x]));\n\t\this.emplace(std::make_pair(y,\
    \ par[y]));\n\t\tif(x == y) {\n\t\t\treturn false;\n\t\t}\n\t\tif(par[x] > par[y])\
    \ {\n\t\t\tstd::swap(x, y);\n\t\t}\n\t\tpar[x] += par[y];\n\t\tpar[y] = x;\n\t\
    \treturn true;\n\t}\n    int root(int k) {\n        if(par[k] < 0) {\n       \
    \     return k;\n        }\n        return root(par[k]);\n    }\n    int size(const\
    \ int i){ return -par[root(i)]; }\n    void undo() {\n\t\tpar[his.top().first]\
    \ = his.top().second;\n        his.pop();\n\t\tpar[his.top().first] = his.top().second;\n\
    \        his.pop();\n\t}\n    void snapshot() {\n\t\twhile(his.size()) {\n\t\t\
    \this.pop();\n\t\t}\n\t}\n\tvoid rollback() {\n\t\twhile(his.size()) {\n\t\t\t\
    undo();\n\t\t}\n\t}\n};\n/**\n * @brief Undo\u53EF\u80FDUnionFind\n * @see https://ei1333.github.io/luzhiled/snippets/structure/union-find.html\n\
    \ */"
  dependsOn: []
  isVerificationFile: false
  path: C++/ds/uf/UFUndo.hpp
  requiredBy: []
  timestamp: '2024-02-27 10:38:23+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/ds/uf/UFUndo.hpp
layout: document
redirect_from:
- /library/C++/ds/uf/UFUndo.hpp
- /library/C++/ds/uf/UFUndo.hpp.html
title: "Undo\u53EF\u80FDUnionFind"
---
