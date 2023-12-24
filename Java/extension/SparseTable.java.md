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
    RuntimeError: bundler is not specified: Java/extension/SparseTable.java\n"
  code: "package extension;\n\nimport java.util.function.LongBinaryOperator;\nimport\
    \ java.util.function.LongPredicate;\n\nfinal class SparseTable {\n\tprivate final\
    \ long[][] st;\n\tprivate final int[] lookup;\n\tprivate final LongBinaryOperator\
    \ op;\n\tSparseTable(final int[] a, final LongBinaryOperator op) {\n\t\tthis.op\
    \ = op;\n\t\tint b = 0;\n\t\twhile((1 << b) <= a.length) {\n\t\t\t++b;\n\t\t}\n\
    \t\tst = new long[b][1 << b];\n\t\tfor(int i = 0; i < a.length; i++) {\n\t\t\t\
    st[0][i] = a[i];\n\t\t}\n\t\tfor(int i = 1; i < b; i++) {\n\t\t\tfor(int j = 0;\
    \ j + (1 << i) <= (1 << b); j++) {\n\t\t\t\tst[i][j] = op.applyAsLong(st[i - 1][j],\
    \ st[i - 1][j + (1 << (i - 1))]);\n\t\t\t}\n\t\t}\n\t\tlookup = new int[a.length\
    \ + 1];\n\t\tfor(int i = 2; i < lookup.length; i++) {\n\t\t\tlookup[i] = lookup[i\
    \ >> 1] + 1;\n\t\t}\n\t}\n\tSparseTable(final long[] a, final LongBinaryOperator\
    \ op) {\n\t\tthis.op = op;\n\t\tint b = 0;\n\t\twhile((1 << b) <= a.length) {\n\
    \t\t\t++b;\n\t\t}\n\t\tst = new long[b][1 << b];\n\t\tfor(int i = 0; i < a.length;\
    \ i++) {\n\t\t\tst[0][i] = a[i];\n\t\t}\n\t\tfor(int i = 1; i < b; i++) {\n\t\t\
    \tfor(int j = 0; j + (1 << i) <= (1 << b); j++) {\n\t\t\t\tst[i][j] = op.applyAsLong(st[i\
    \ - 1][j], st[i - 1][j + (1 << (i - 1))]);\n\t\t\t}\n\t\t}\n\t\tlookup = new int[a.length\
    \ + 1];\n\t\tfor(int i = 2; i < lookup.length; i++) {\n\t\t\tlookup[i] = lookup[i\
    \ >> 1] + 1;\n\t\t}\n\t}\n\tfinal long query(final int l, final int r) {\n\t\t\
    final int b = lookup[r - l];\n\t\treturn op.applyAsLong(st[b][l], st[b][r - (1\
    \ << b)]);\n\t}\n\tfinal int minLeft(final int x, final LongPredicate fn) {\n\t\
    \tif(x == 0) {\n\t\t\treturn 0;\n\t\t}\n\t\tint ok = x, ng = -1;\n\t\twhile(Math.abs(ok\
    \ - ng) > 1) {\n\t\t\tfinal int mid = (ok + ng) / 2;\n\t\t\tif(fn.test(query(mid,\
    \ x) - 1)) {\n\t\t\t\tok = mid;\n\t\t\t}\n\t\t\telse {\n\t\t\t\tng = mid;\n\t\t\
    \t}\n\t\t}\n\t\treturn ok;\n\t}\n\tfinal int maxRight(final int x, final LongPredicate\
    \ fn) {\n\t\tif(x == lookup.length - 1) {\n\t\t\treturn lookup.length - 1;\n\t\
    \t}\n\t\tint ok = x, ng = lookup.length;\n\t\twhile(Math.abs(ok - ng) > 1) {\n\
    \t\t\tint mid = (ok + ng) / 2;\n\t\t\tif(fn.test(query(x, mid))) {\n\t\t\t\tok\
    \ = mid;\n\t\t\t}\n\t\t\telse {\n\t\t\t\tng = mid;\n\t\t\t}\n\t\t}\n\t\treturn\
    \ ok;\n\t}\n}"
  dependsOn:
  - Java/extension/PrimeCounter.java
  - Java/extension/PrefixSum.java
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
  path: Java/extension/SparseTable.java
  requiredBy:
  - Java/extension/PrimeCounter.java
  - Java/extension/PrefixSum.java
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
  timestamp: '2023-12-24 20:52:08+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: Java/extension/SparseTable.java
layout: document
redirect_from:
- /library/Java/extension/SparseTable.java
- /library/Java/extension/SparseTable.java.html
title: Java/extension/SparseTable.java
---
