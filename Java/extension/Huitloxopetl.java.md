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
    RuntimeError: bundler is not specified: Java/extension/Huitloxopetl.java\n"
  code: "//package extension;\n\nimport java.util.ArrayList;\nimport java.util.Arrays;\n\
    import java.util.Collections;\nimport java.util.Comparator;\nimport java.util.HashMap;\n\
    import java.util.TreeMap;\n\nclass Huitloxopetl {\n\tfinal long invNum(final int[]\
    \ a) {\n\t\tfinal var b = Utility.sorted(a);\n\t\tfinal var id = new int[a.length];\n\
    \t\tfor(int i = 0; i < a.length; ++i) {\n\t\t\tid[b[i]] = i;\n\t\t}\n\t\tfinal\
    \ var bit = new FenwickTree(a.length);\n\t\tlong res = 0;\n\t\tfor(int i = 0;\
    \ i < a.length; ++i) {\n\t\t\tres += i - bit.sum(id[a[i]]);\n\t\t\tbit.add(id[a[i]],\
    \ 1);\n\t\t}\n\t\treturn res;\n\t}\n\tfinal long invNum(final long[] a) {\n\t\t\
    final var b = Utility.sorted(a);\n\t\tfinal var id = new HashMap<Long, Integer>();\n\
    \t\tfor(int i = 0; i < a.length; ++i) {\n\t\t\tid.put(b[i], i);\n\t\t}\n\t\tfinal\
    \ var bit = new FenwickTree(a.length);\n\t\tlong res = 0;\n\t\tfor(int i = 0;\
    \ i < a.length; ++i) {\n\t\t\tres += i - bit.sum(id.get(a[i]));\n\t\t\tbit.add(id.get(a[i]),\
    \ 1);\n\t\t}\n\t\treturn res;\n\t}\n\tfinal MST kruskal(final ArrayList<Edge>\
    \ edge, final int n) {\n\t\tCollections.sort(edge, Comparator.comparing(e -> e.cost));\n\
    \t\tfinal UnionFind uf = new UnionFind(n);\n\t\tfinal var e = new ArrayList<Edge>();\n\
    \t\tlong res = 0;\n\t\tfor(final var ed: edge) {\n\t\t\tif(uf.unite(ed.src, ed.to))\
    \ {\n\t\t\t\te.add(ed);\n\t\t\t\tres += ed.cost;\n\t\t\t}\n\t\t}\n\t\treturn new\
    \ MST(e, res);\n\t}\n\t// DO NOT USE\n\tfinal ArrayList<Edge> manhattan(int[]\
    \ x, int[] y) {\n\t\tif(x.length != y.length) {\n\t\t\tthrow new AssertionError(\"\
    x.length != y.length\");\n\t\t}\n\t\tfinal var res = new ArrayList<Edge>();\n\t\
    \tint[] id = Utility.iota(x.length);\n\t\tfor(int s = 0; s < 2; ++s) {\n\t\t\t\
    for(int t = 0; t < 2; ++t) {\n\t\t\t\tid = Arrays.stream(id).boxed().sorted((i,\
    \ j) -> Integer.compare(x[i] + y[i], x[j] + y[j])).mapToInt(i -> i).toArray();\n\
    \t\t\t\tfinal var idx = new TreeMap<Integer, Integer>();\n\t\t\t\tfor(final var\
    \ i: id) {\n\t\t\t\t\tfinal var it = idx.tailMap(y[i]).entrySet().iterator();\n\
    \t\t\t\t\twhile(it.hasNext()) {\n\t\t\t\t\t\tfinal int j = it.next().getValue();\n\
    \t\t\t\t\t\tSystem.err.println(j);\n\t\t\t\t\t\tif(x[i] - x[j] < y[i] - y[j])\
    \ {\n\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tres.add(new Edge(i, j, Math.abs(x[i]\
    \ - x[j]) + Math.abs(y[i] - y[j])));\n\t\t\t\t\t\tit.remove();\n\t\t\t\t\t}\n\t\
    \t\t\t\tidx.put(-y[i], i);\n\t\t\t\t}\n\t\t\t\tfinal var tmp = y;\n\t\t\t\tSystem.arraycopy(x,\
    \ 0, y, 0, x.length);\n\t\t\t\tSystem.arraycopy(tmp, 0, x, 0, x.length);\n\t\t\
    \t}\n\t\t\tfor(int i = 0; i < x.length; ++i) {\n\t\t\t\tx[i] = -x[i];\n\t\t\t\
    }\n\t\t}\n\t\treturn res;\n\t}\n\tfinal ArrayList<Edge> manhattan(long[] x, long[]\
    \ y) {\n\t\tif(x.length != y.length) {\n\t\t\tthrow new AssertionError(\"x.length\
    \ != y.length\");\n\t\t}\n\t\tfinal var res = new ArrayList<Edge>();\n\t\tint[]\
    \ id = Utility.iota(x.length);\n\t\tfor(int s = 0; s < 2; ++s) {\n\t\t\tfor(int\
    \ t = 0; t < 2; ++t) {\n\t\t\t\tid = Arrays.stream(id).boxed().sorted((i, j) ->\
    \ Long.compare(x[i] + y[i], x[j] + y[j])).mapToInt(i -> i).toArray();\n\t\t\t\t\
    final var idx = new TreeMap<Long, Integer>();\n\t\t\t\tfor(final var i: id) {\n\
    \t\t\t\t\tfinal var it = idx.tailMap(y[i]).entrySet().iterator();\n\t\t\t\t\t\
    while(it.hasNext()) {\n\t\t\t\t\t\tfinal int j = it.next().getValue();\n\t\t\t\
    \t\t\tif(x[i] - x[j] < y[i] - y[j]) {\n\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t}\n\t\
    \t\t\t\t\tres.add(new Edge(i, j, Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j])));\n\
    \t\t\t\t\t\tit.remove();\n\t\t\t\t\t}\n\t\t\t\t\tidx.put(-y[i], i);\n\t\t\t\t\
    }\n\t\t\t\tfinal var tmp = y;\n\t\t\t\tSystem.arraycopy(x, 0, y, 0, x.length);\n\
    \t\t\t\tSystem.arraycopy(tmp, 0, x, 0, x.length);\n\t\t\t}\n\t\t\tfor(int i =\
    \ 0; i < x.length; ++i) {\n\t\t\t\tx[i] = -x[i];\n\t\t\t}\n\t\t}\n\t\treturn res;\n\
    \t}\n}"
  dependsOn:
  - Java/extension/SparseTable.java
  - Java/extension/PrimeTable.java
  - Java/extension/PrefixSum.java
  - Java/extension/PrimeFactor.java
  - Java/extension/LargePrime.java
  - Java/extension/LowestCommonAncestor.java
  - Java/extension/UndoUnionFind.java
  - Java/extension/Template.java
  - Java/extension/SuffixArray.java
  - Java/extension/WaveletMatrix.java
  - Java/extension/SegmentTree.java
  - Java/extension/FenwickTree.java
  - Java/extension/WeightedUnionFind.java
  - Java/extension/DoubleEndedPriorityQueue.java
  - Java/extension/Graph.java
  - Java/extension/UnionFind.java
  - Java/extension/PrimeCounter.java
  - Java/all.java
  isVerificationFile: false
  path: Java/extension/Huitloxopetl.java
  requiredBy:
  - Java/extension/SparseTable.java
  - Java/extension/PrimeTable.java
  - Java/extension/PrefixSum.java
  - Java/extension/PrimeFactor.java
  - Java/extension/LargePrime.java
  - Java/extension/LowestCommonAncestor.java
  - Java/extension/UndoUnionFind.java
  - Java/extension/Template.java
  - Java/extension/SuffixArray.java
  - Java/extension/WaveletMatrix.java
  - Java/extension/SegmentTree.java
  - Java/extension/FenwickTree.java
  - Java/extension/WeightedUnionFind.java
  - Java/extension/DoubleEndedPriorityQueue.java
  - Java/extension/Graph.java
  - Java/extension/UnionFind.java
  - Java/extension/PrimeCounter.java
  - Java/all.java
  timestamp: '2023-12-12 02:56:10+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: Java/extension/Huitloxopetl.java
layout: document
redirect_from:
- /library/Java/extension/Huitloxopetl.java
- /library/Java/extension/Huitloxopetl.java.html
title: Java/extension/Huitloxopetl.java
---
