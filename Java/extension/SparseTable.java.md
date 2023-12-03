---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: Java/all.java
    title: Java/all.java
  - icon: ':warning:'
    path: Java/extension/DoubleEndedPriorityQueue.java
    title: Java/extension/DoubleEndedPriorityQueue.java
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
    path: Java/extension/WeightedUnionFind.java
    title: Java/extension/WeightedUnionFind.java
  _extendedRequiredBy:
  - icon: ':warning:'
    path: Java/all.java
    title: Java/all.java
  - icon: ':warning:'
    path: Java/extension/DoubleEndedPriorityQueue.java
    title: Java/extension/DoubleEndedPriorityQueue.java
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
  code: "package extension;\n\nimport java.util.function.BinaryOperator;\nimport java.util.function.Predicate;\n\
    \nclass SparseTable {\n\tprivate long[][] st;\n\tprivate int[] lookup;\n\tprivate\
    \ BinaryOperator<Long> op;\n\tSparseTable(final int[] a, final BinaryOperator<Long>\
    \ op) {\n\t\tthis.op = op;\n\t\tint b = 0;\n\t\twhile((1 << b) <= a.length) {\n\
    \t\t\t++b;\n\t\t}\n\t\tst = new long[b][1 << b];\n\t\tfor(int i = 0; i < a.length;\
    \ i++) {\n\t\t\tst[0][i] = a[i];\n\t\t}\n\t\tfor(int i = 1; i < b; i++) {\n\t\t\
    \tfor(int j = 0; j + (1 << i) <= (1 << b); j++) {\n\t\t\t\tst[i][j] = op.apply(st[i\
    \ - 1][j], st[i - 1][j + (1 << (i - 1))]);\n\t\t\t}\n\t\t}\n\t\tlookup = new int[a.length\
    \ + 1];\n\t\tfor(int i = 2; i < lookup.length; i++) {\n\t\t\tlookup[i] = lookup[i\
    \ >> 1] + 1;\n\t\t}\n\t}\n\tSparseTable(final long[] a, final BinaryOperator<Long>\
    \ op) {\n\t\tthis.op = op;\n\t\tint b = 0;\n\t\twhile((1 << b) <= a.length) {\n\
    \t\t\t++b;\n\t\t}\n\t\tst = new long[b][1 << b];\n\t\tfor(int i = 0; i < a.length;\
    \ i++) {\n\t\t\tst[0][i] = a[i];\n\t\t}\n\t\tfor(int i = 1; i < b; i++) {\n\t\t\
    \tfor(int j = 0; j + (1 << i) <= (1 << b); j++) {\n\t\t\t\tst[i][j] = op.apply(st[i\
    \ - 1][j], st[i - 1][j + (1 << (i - 1))]);\n\t\t\t}\n\t\t}\n\t\tlookup = new int[a.length\
    \ + 1];\n\t\tfor(int i = 2; i < lookup.length; i++) {\n\t\t\tlookup[i] = lookup[i\
    \ >> 1] + 1;\n\t\t}\n\t}\n\tlong query(final int l, final int r) {\n\t\tfinal\
    \ int b = lookup[r - l];\n\t\treturn op.apply(st[b][l], st[b][r - (1 << b)]);\n\
    \t}\n\tint minLeft(final int x, final Predicate<Long> fn) {\n\t\tif(x == 0) {\n\
    \t\t\treturn 0;\n\t\t}\n\t\tint ok = x, ng = -1;\n\t\twhile(Math.abs(ok - ng)\
    \ > 1) {\n\t\t\tfinal int mid = (ok + ng) / 2;\n\t\t\tif(fn.test(query(mid, x)\
    \ - 1)) {\n\t\t\t\tok = mid;\n\t\t\t}\n\t\t\telse {\n\t\t\t\tng = mid;\n\t\t\t\
    }\n\t\t}\n\t\treturn ok;\n\t}\n\tint maxRight(final int x, final Predicate<Long>\
    \ fn) {\n\t\tif(x == lookup.length - 1) {\n\t\t\treturn lookup.length - 1;\n\t\
    \t}\n\t\tint ok = x, ng = lookup.length;\n\t\twhile(Math.abs(ok - ng) > 1) {\n\
    \t\t\tint mid = (ok + ng) / 2;\n\t\t\tif(fn.test(query(x, mid))) {\n\t\t\t\tok\
    \ = mid;\n\t\t\t}\n\t\t\telse {\n\t\t\t\tng = mid;\n\t\t\t}\n\t\t}\n\t\treturn\
    \ ok;\n\t}\n}"
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
  - Java/extension/DoubleEndedPriorityQueue.java
  - Java/extension/PrimeTable.java
  - Java/extension/Graph.java
  - Java/extension/PrimeFactor.java
  - Java/extension/PrimeCounter.java
  - Java/extension/SegmentTree.java
  - Java/extension/UndoUnionFind.java
  - Java/extension/Template.java
  - Java/all.java
  isVerificationFile: false
  path: Java/extension/SparseTable.java
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
  - Java/extension/DoubleEndedPriorityQueue.java
  - Java/extension/PrimeTable.java
  - Java/extension/Graph.java
  - Java/extension/PrimeFactor.java
  - Java/extension/PrimeCounter.java
  - Java/extension/SegmentTree.java
  - Java/extension/UndoUnionFind.java
  - Java/extension/Template.java
  - Java/all.java
  timestamp: '2023-12-03 22:45:45+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: Java/extension/SparseTable.java
layout: document
redirect_from:
- /library/Java/extension/SparseTable.java
- /library/Java/extension/SparseTable.java.html
title: Java/extension/SparseTable.java
---
