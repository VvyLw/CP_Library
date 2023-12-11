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
    path: Java/extension/Graph.java
    title: Java/extension/Graph.java
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
    path: Java/extension/Graph.java
    title: Java/extension/Graph.java
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
  code: "package extension;\n\nimport java.util.stream.IntStream;\n\nfinal class PrefixSum\
    \ {\n\tprivate final int n;\n\tprivate final long[] s;\n\tPrefixSum(final int[]\
    \ a) {\n\t\tn = a.length;\n\t\ts = new long[n + 1];\n\t\tIntStream.range(0, n).forEach(i\
    \ -> s[i + 1] = s[i] + a[i]);\n\t}\n\tPrefixSum(final long[] a) {\n\t\tn = a.length;\n\
    \t\ts = new long[n + 1];\n\t\tIntStream.range(0, n).forEach(i -> s[i + 1] = s[i]\
    \ + a[i]);\n\t}\n\tfinal long[] get(){ return s; }\n\tfinal long query(final int\
    \ l, final int r){ return s[r] - s[l]; }\n}"
  dependsOn:
  - Java/extension/SparseTable.java
  - Java/extension/PrimeTable.java
  - Java/extension/PrimeFactor.java
  - Java/extension/LargePrime.java
  - Java/extension/LowestCommonAncestor.java
  - Java/extension/UndoUnionFind.java
  - Java/extension/Template.java
  - Java/extension/SuffixArray.java
  - Java/extension/WaveletMatrix.java
  - Java/extension/SegmentTree.java
  - Java/extension/WeightedUnionFind.java
  - Java/extension/DoubleEndedPriorityQueue.java
  - Java/extension/Graph.java
  - Java/extension/UnionFind.java
  - Java/extension/PrimeCounter.java
  - Java/all.java
  isVerificationFile: false
  path: Java/extension/PrefixSum.java
  requiredBy:
  - Java/extension/SparseTable.java
  - Java/extension/PrimeTable.java
  - Java/extension/PrimeFactor.java
  - Java/extension/LargePrime.java
  - Java/extension/LowestCommonAncestor.java
  - Java/extension/UndoUnionFind.java
  - Java/extension/Template.java
  - Java/extension/SuffixArray.java
  - Java/extension/WaveletMatrix.java
  - Java/extension/SegmentTree.java
  - Java/extension/WeightedUnionFind.java
  - Java/extension/DoubleEndedPriorityQueue.java
  - Java/extension/Graph.java
  - Java/extension/UnionFind.java
  - Java/extension/PrimeCounter.java
  - Java/all.java
  timestamp: '2023-12-11 13:07:12+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: Java/extension/PrefixSum.java
layout: document
redirect_from:
- /library/Java/extension/PrefixSum.java
- /library/Java/extension/PrefixSum.java.html
title: Java/extension/PrefixSum.java
---
