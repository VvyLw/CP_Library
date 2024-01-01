---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: Java/all.java
    title: Java/all.java
  - icon: ':warning:'
    path: Java/extension/AVLTree.java
    title: Java/extension/AVLTree.java
  - icon: ':warning:'
    path: Java/extension/Deque.java
    title: Java/extension/Deque.java
  - icon: ':warning:'
    path: Java/extension/DoubleEndedPriorityQueue.java
    title: Java/extension/DoubleEndedPriorityQueue.java
  - icon: ':warning:'
    path: Java/extension/EulerPhiTable.java
    title: Java/extension/EulerPhiTable.java
  - icon: ':warning:'
    path: Java/extension/FenwickTree.java
    title: Java/extension/FenwickTree.java
  - icon: ':warning:'
    path: Java/extension/Graph.java
    title: Java/extension/Graph.java
  - icon: ':warning:'
    path: Java/extension/Huitloxopetl.java
    title: Java/extension/Huitloxopetl.java
  - icon: ':warning:'
    path: Java/extension/LargePrime.java
    title: Java/extension/LargePrime.java
  - icon: ':warning:'
    path: Java/extension/LowestCommonAncestor.java
    title: Java/extension/LowestCommonAncestor.java
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
    path: Java/extension/UndoUnionFind.java
    title: Java/extension/UndoUnionFind.java
  - icon: ':warning:'
    path: Java/extension/UnionFind.java
    title: Java/extension/UnionFind.java
  - icon: ':warning:'
    path: Java/extension/WaveletMatrix.java
    title: Java/extension/WaveletMatrix.java
  - icon: ':warning:'
    path: Java/extension/WeightedGraph.java
    title: Java/extension/WeightedGraph.java
  - icon: ':warning:'
    path: Java/extension/WeightedUnionFind.java
    title: Java/extension/WeightedUnionFind.java
  _extendedRequiredBy:
  - icon: ':warning:'
    path: Java/all.java
    title: Java/all.java
  - icon: ':warning:'
    path: Java/extension/AVLTree.java
    title: Java/extension/AVLTree.java
  - icon: ':warning:'
    path: Java/extension/Deque.java
    title: Java/extension/Deque.java
  - icon: ':warning:'
    path: Java/extension/DoubleEndedPriorityQueue.java
    title: Java/extension/DoubleEndedPriorityQueue.java
  - icon: ':warning:'
    path: Java/extension/EulerPhiTable.java
    title: Java/extension/EulerPhiTable.java
  - icon: ':warning:'
    path: Java/extension/FenwickTree.java
    title: Java/extension/FenwickTree.java
  - icon: ':warning:'
    path: Java/extension/Graph.java
    title: Java/extension/Graph.java
  - icon: ':warning:'
    path: Java/extension/Huitloxopetl.java
    title: Java/extension/Huitloxopetl.java
  - icon: ':warning:'
    path: Java/extension/LargePrime.java
    title: Java/extension/LargePrime.java
  - icon: ':warning:'
    path: Java/extension/LowestCommonAncestor.java
    title: Java/extension/LowestCommonAncestor.java
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
    path: Java/extension/UndoUnionFind.java
    title: Java/extension/UndoUnionFind.java
  - icon: ':warning:'
    path: Java/extension/UnionFind.java
    title: Java/extension/UnionFind.java
  - icon: ':warning:'
    path: Java/extension/WaveletMatrix.java
    title: Java/extension/WaveletMatrix.java
  - icon: ':warning:'
    path: Java/extension/WeightedGraph.java
    title: Java/extension/WeightedGraph.java
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
    RuntimeError: bundler is not specified: Java/extension/PrefixSum.java\n"
  code: "package extension;\n\nimport java.util.Arrays;\nimport java.util.function.LongBinaryOperator;\n\
    \nclass InclusiveScan {\n\tprotected final int n;\n\tprotected long[] s;\n\tInclusiveScan(final\
    \ int[] a, final LongBinaryOperator op) {\n\t\tn = a.length;\n\t\ts = Arrays.stream(a).mapToLong(i\
    \ -> i).toArray();\n\t\tArrays.parallelPrefix(s, op);\n\t}\n\tInclusiveScan(final\
    \ long[] a, final LongBinaryOperator op) {\n\t\tn = a.length;\n\t\ts = a.clone();\n\
    \t\tArrays.parallelPrefix(s, op);\n\t}\n\tprotected long[] get(){ return s; }\n\
    \tprotected long query(final int l, final int r){ return s[r] - s[l]; }\n}\nfinal\
    \ class PrefixSum extends InclusiveScan {\n\tPrefixSum(final int[] a) {\n\t\t\
    super(a, (x, y) -> x + y);\n\t\ts = Utility.rotate(Arrays.copyOf(s, n + 1), 1);\n\
    \t}\n\tPrefixSum(final long[] a) {\n\t\tsuper(a, (x, y) -> x + y);\n\t\ts = Utility.rotate(Arrays.copyOf(s,\
    \ n + 1), 1);\n\t}\n}"
  dependsOn:
  - Java/extension/SparseTable.java
  - Java/extension/PrimeCounter.java
  - Java/extension/SegmentTree.java
  - Java/extension/DoubleEndedPriorityQueue.java
  - Java/extension/WeightedGraph.java
  - Java/extension/PrimeFactor.java
  - Java/extension/Deque.java
  - Java/extension/UnionFind.java
  - Java/extension/EulerPhiTable.java
  - Java/extension/PrimeTable.java
  - Java/extension/Huitloxopetl.java
  - Java/extension/LowestCommonAncestor.java
  - Java/extension/WaveletMatrix.java
  - Java/extension/WeightedUnionFind.java
  - Java/extension/UndoUnionFind.java
  - Java/extension/LargePrime.java
  - Java/extension/FenwickTree.java
  - Java/extension/SuffixArray.java
  - Java/extension/AVLTree.java
  - Java/extension/Graph.java
  - Java/extension/Template.java
  - Java/all.java
  isVerificationFile: false
  path: Java/extension/PrefixSum.java
  requiredBy:
  - Java/extension/SparseTable.java
  - Java/extension/PrimeCounter.java
  - Java/extension/SegmentTree.java
  - Java/extension/DoubleEndedPriorityQueue.java
  - Java/extension/WeightedGraph.java
  - Java/extension/PrimeFactor.java
  - Java/extension/Deque.java
  - Java/extension/UnionFind.java
  - Java/extension/EulerPhiTable.java
  - Java/extension/PrimeTable.java
  - Java/extension/Huitloxopetl.java
  - Java/extension/LowestCommonAncestor.java
  - Java/extension/WaveletMatrix.java
  - Java/extension/WeightedUnionFind.java
  - Java/extension/UndoUnionFind.java
  - Java/extension/LargePrime.java
  - Java/extension/FenwickTree.java
  - Java/extension/SuffixArray.java
  - Java/extension/AVLTree.java
  - Java/extension/Graph.java
  - Java/extension/Template.java
  - Java/all.java
  timestamp: '2024-01-01 09:21:51+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: Java/extension/PrefixSum.java
layout: document
redirect_from:
- /library/Java/extension/PrefixSum.java
- /library/Java/extension/PrefixSum.java.html
title: Java/extension/PrefixSum.java
---
