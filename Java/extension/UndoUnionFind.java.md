---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: Java/all.java
    title: Java/all.java
  - icon: ':warning:'
    path: Java/extension/FenwickTree.java
    title: Java/extension/FenwickTree.java
  - icon: ':warning:'
    path: Java/extension/Graph.java
    title: Java/extension/Graph.java
  - icon: ':warning:'
    path: Java/extension/LargePrime.java
    title: Java/extension/LargePrime.java
  - icon: ':warning:'
    path: Java/extension/LowestCommonAncestor.java
    title: Java/extension/LowestCommonAncestor.java
  - icon: ':warning:'
    path: Java/extension/MyPrinter.java
    title: Java/extension/MyPrinter.java
  - icon: ':warning:'
    path: Java/extension/MyScanner.java
    title: Java/extension/MyScanner.java
  - icon: ':warning:'
    path: Java/extension/Pair.java
    title: Java/extension/Pair.java
  - icon: ':warning:'
    path: Java/extension/PrefixSum.java
    title: Java/extension/PrefixSum.java
  - icon: ':warning:'
    path: Java/extension/PrimeCounter.java
    title: Java/extension/PrimeCounter.java
  - icon: ':warning:'
    path: Java/extension/PrimeFactor.java
    title: Java/extension/PrimeFactor.java
  - icon: ':warning:'
    path: Java/extension/PrimeTable.java
    title: Java/extension/PrimeTable.java
  - icon: ':warning:'
    path: Java/extension/SegmentTree.java
    title: Java/extension/SegmentTree.java
  - icon: ':warning:'
    path: Java/extension/SparseTable.java
    title: Java/extension/SparseTable.java
  - icon: ':warning:'
    path: Java/extension/SuffixArray.java
    title: Java/extension/SuffixArray.java
  - icon: ':warning:'
    path: Java/extension/Template.java
    title: Java/extension/Template.java
  - icon: ':warning:'
    path: Java/extension/UnionFind.java
    title: Java/extension/UnionFind.java
  - icon: ':warning:'
    path: Java/extension/WeightedUnionFind.java
    title: Java/extension/WeightedUnionFind.java
  _extendedRequiredBy:
  - icon: ':warning:'
    path: Java/all.java
    title: Java/all.java
  - icon: ':warning:'
    path: Java/extension/FenwickTree.java
    title: Java/extension/FenwickTree.java
  - icon: ':warning:'
    path: Java/extension/Graph.java
    title: Java/extension/Graph.java
  - icon: ':warning:'
    path: Java/extension/LargePrime.java
    title: Java/extension/LargePrime.java
  - icon: ':warning:'
    path: Java/extension/LowestCommonAncestor.java
    title: Java/extension/LowestCommonAncestor.java
  - icon: ':warning:'
    path: Java/extension/MyPrinter.java
    title: Java/extension/MyPrinter.java
  - icon: ':warning:'
    path: Java/extension/MyScanner.java
    title: Java/extension/MyScanner.java
  - icon: ':warning:'
    path: Java/extension/Pair.java
    title: Java/extension/Pair.java
  - icon: ':warning:'
    path: Java/extension/PrefixSum.java
    title: Java/extension/PrefixSum.java
  - icon: ':warning:'
    path: Java/extension/PrimeCounter.java
    title: Java/extension/PrimeCounter.java
  - icon: ':warning:'
    path: Java/extension/PrimeFactor.java
    title: Java/extension/PrimeFactor.java
  - icon: ':warning:'
    path: Java/extension/PrimeTable.java
    title: Java/extension/PrimeTable.java
  - icon: ':warning:'
    path: Java/extension/SegmentTree.java
    title: Java/extension/SegmentTree.java
  - icon: ':warning:'
    path: Java/extension/SparseTable.java
    title: Java/extension/SparseTable.java
  - icon: ':warning:'
    path: Java/extension/SuffixArray.java
    title: Java/extension/SuffixArray.java
  - icon: ':warning:'
    path: Java/extension/Template.java
    title: Java/extension/Template.java
  - icon: ':warning:'
    path: Java/extension/UnionFind.java
    title: Java/extension/UnionFind.java
  - icon: ':warning:'
    path: Java/extension/WeightedUnionFind.java
    title: Java/extension/WeightedUnionFind.java
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':warning:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: Java/extension/UndoUnionFind.java\n"
  code: "package extension;\n\nimport java.util.Arrays;\nimport java.util.Stack;\n\
    \nclass UndoUnionFind {\n\tprivate int[] par;\n\tprivate Stack<Pair<Integer, Integer>>\
    \ his;\n\tUndoUnionFind(final int n) {\n\t    par = new int[n];\n\t    Arrays.fill(par,\
    \ -1);\n\t    his = new Stack<>();\n\t}\n\tboolean unite(int x, int y) {\n\t\t\
    x = root(x);\n\t\ty = root(y);\n\t\this.add(Pair.of(x, par[x]));\n\t\this.add(Pair.of(y,\
    \ par[y]));\n\t\tif(x == y) {\n\t\t\treturn false;\n\t\t}\n\t\tif(par[x] > par[y])\
    \ {\n\t\t\tx ^= y;\n\t\t\ty ^= x;\n\t\t\tx ^= y;\n\t\t}\n\t\tpar[x] += par[y];\n\
    \t\tpar[y] = x;\n\t\treturn true;\n\t}\n\tint root(final int i) {\n\t\tif(par[i]\
    \ < 0) {\n\t\t\treturn i;\n\t\t}\n\t\treturn root(par[i]);\n\t}\n\tint size(final\
    \ int i){ return -par[root(i)]; }\n\tvoid undo() {\n\t\tfinal Pair<Integer, Integer>\
    \ pop1 = his.pop(), pop2 = his.pop();\n\t\tpar[pop1.first] = pop1.second;\n\t\t\
    par[pop2.first] = pop2.second;\n\t}\n\tvoid snapshot() {\n\t\twhile(!his.empty())\
    \ {\n\t\t\this.pop();\n\t\t}\n\t}\n\tvoid rollback() {\n\t\twhile(!his.empty())\
    \ {\n\t\t\tundo();\n\t\t}\n\t}\n}"
  dependsOn:
  - Java/extension/MyScanner.java
  - Java/extension/LowestCommonAncestor.java
  - Java/extension/WeightedUnionFind.java
  - Java/extension/FenwickTree.java
  - Java/extension/Pair.java
  - Java/extension/MyPrinter.java
  - Java/extension/PrefixSum.java
  - Java/extension/UnionFind.java
  - Java/extension/SuffixArray.java
  - Java/extension/LargePrime.java
  - Java/extension/SparseTable.java
  - Java/extension/PrimeTable.java
  - Java/extension/Graph.java
  - Java/extension/PrimeFactor.java
  - Java/extension/PrimeCounter.java
  - Java/extension/SegmentTree.java
  - Java/extension/Template.java
  - Java/all.java
  isVerificationFile: false
  path: Java/extension/UndoUnionFind.java
  requiredBy:
  - Java/extension/MyScanner.java
  - Java/extension/LowestCommonAncestor.java
  - Java/extension/WeightedUnionFind.java
  - Java/extension/FenwickTree.java
  - Java/extension/Pair.java
  - Java/extension/MyPrinter.java
  - Java/extension/PrefixSum.java
  - Java/extension/UnionFind.java
  - Java/extension/SuffixArray.java
  - Java/extension/LargePrime.java
  - Java/extension/SparseTable.java
  - Java/extension/PrimeTable.java
  - Java/extension/Graph.java
  - Java/extension/PrimeFactor.java
  - Java/extension/PrimeCounter.java
  - Java/extension/SegmentTree.java
  - Java/extension/Template.java
  - Java/all.java
  timestamp: '2023-12-03 17:45:27+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: Java/extension/UndoUnionFind.java
layout: document
redirect_from:
- /library/Java/extension/UndoUnionFind.java
- /library/Java/extension/UndoUnionFind.java.html
title: Java/extension/UndoUnionFind.java
---
