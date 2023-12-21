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
    RuntimeError: bundler is not specified: Java/extension/DoubleEndedPriorityQueue.java\n"
  code: "package extension;\n\nimport java.util.ArrayList;\nimport java.util.Collections;\n\
    \nfinal class DoubleEndedPriorityQueue<T extends Number> {\n\tprivate final ArrayList<T>\
    \ d;\n\tDoubleEndedPriorityQueue(final ArrayList<T> d) {\n\t\tthis.d = d;\n\t\t\
    makeHeap();\n\t}\n\tprivate final void makeHeap() {\n\t\tfor(int i = d.size();\
    \ i-- > 0;) {\n\t\t\tif (i % 2 == 1 && d.get(i - 1).longValue() < d.get(i).longValue())\
    \ {\n\t\t\t\tCollections.swap(d, i - 1, i);\n\t\t\t}\n\t\t\tup(down(i), i);\n\t\
    \t}\n\t}\n\tprivate final int down(int k) {\n\t\tfinal int n = d.size();\n\t\t\
    if(k % 2 == 1) {\n\t\t\twhile(2 * k + 1 < n) {\n\t\t\t\tint c = 2 * k + 3;\n\t\
    \t\t\tif(n <= c || d.get(c - 2).longValue() < d.get(c).longValue()) {\n\t\t\t\t\
    \t c -= 2;\n\t\t\t\t}\n\t\t\t\tif(c < n && d.get(c).longValue() < d.get(k).longValue())\
    \ {\n\t\t\t\t\tCollections.swap(d, k, c);\n\t\t\t\t\tk = c;\n\t\t\t\t}\n\t\t\t\
    \telse {\n\t\t\t\t\tbreak;\n\t\t\t\t}\n\t\t\t}\n\t\t} else {\n\t\t\twhile(2 *\
    \ k + 2 < n) {\n\t\t\t\tint c = 2 * k + 4;\n\t\t\t\tif(n <= c || d.get(c).longValue()\
    \ < d.get(c - 2).longValue()) {\n\t\t\t\t\tc -= 2;\n\t\t\t\t}\n\t\t\t\tif(c <\
    \ n && d.get(k).longValue() < d.get(c).longValue()) {\n\t\t\t\t\tCollections.swap(d,\
    \ k, c);\n\t\t\t\t\tk = c;\n\t\t\t\t}\n\t\t\t\telse {\n\t\t\t\t\tbreak;\n\t\t\t\
    \t}\n\t\t\t}\n\t\t}\n\t\treturn k;\n\t}\n\tprivate final int up(int k, final int\
    \ root) {\n\t\tif((k | 1) < d.size() && d.get(k & ~1).longValue() < d.get(k |\
    \ 1).longValue()) {\n\t\t\tCollections.swap(d, k & ~1, k | 1);\n\t\t\tk ^= 1;\n\
    \t\t}\n\t\tint p;\n\t\twhile(root < k && d.get(p = parent(k)).longValue() < d.get(k).longValue())\
    \ {\n\t\t\tCollections.swap(d, p, k);\n\t\t\tk = p;\n\t\t}\n\t\twhile(root < k\
    \ && d.get(k).longValue() < d.get(p = parent(k) | 1).longValue()) {\n\t\t\tCollections.swap(d,\
    \ p, k);\n\t\t\tk = p;\n\t\t}\n\t\treturn k;\n\t}\n\tprivate final int parent(final\
    \ int k){ return ((k >> 1) - 1) & ~1; }\n\tprivate final void popBack(final ArrayList<T>\
    \ d){ d.remove(d.size() - 1); } \n\tfinal void push(final T x) {\n\t\tfinal int\
    \ k = d.size();\n\t\td.add(x);\n\t\tup(k, 1);\n\t}\n\tfinal T popMin() {\n\t\t\
    final var res = getMin();\n\t\tif(d.size() < 3) {\n\t\t\tpopBack(d); \n\t\t} else\
    \ {\n\t\t\tCollections.swap(d, 1, d.size() - 1);\n\t\t\tpopBack(d);\n\t\t\tup(down(1),\
    \ 1);\n\t\t}\n\t\treturn res;\n\t}\n\tfinal T popMax() {\n\t\tfinal var res =\
    \ getMax();\n\t\tif(d.size() < 2) { \n\t\t\tpopBack(d);\n\t\t} else {\n\t\t\t\
    Collections.swap(d, 0, d.size() - 1);\n\t\t\tpopBack(d);\n\t\t\tup(down(0), 1);\n\
    \t\t}\n\t\treturn res;\n\t}\n\tfinal T getMin(){ return d.size() < 2 ? d.get(0)\
    \ : d.get(1); }\n\tfinal T getMax(){ return d.get(0); }\n\tfinal int size(){ return\
    \ d.size(); }\n\tfinal boolean isEmpty(){ return d.isEmpty(); }\n}"
  dependsOn:
  - Java/extension/SparseTable.java
  - Java/extension/PrimeCounter.java
  - Java/extension/PrefixSum.java
  - Java/extension/SegmentTree.java
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
  path: Java/extension/DoubleEndedPriorityQueue.java
  requiredBy:
  - Java/extension/SparseTable.java
  - Java/extension/PrimeCounter.java
  - Java/extension/PrefixSum.java
  - Java/extension/SegmentTree.java
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
  timestamp: '2023-12-22 06:49:28+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: Java/extension/DoubleEndedPriorityQueue.java
layout: document
redirect_from:
- /library/Java/extension/DoubleEndedPriorityQueue.java
- /library/Java/extension/DoubleEndedPriorityQueue.java.html
title: Java/extension/DoubleEndedPriorityQueue.java
---
