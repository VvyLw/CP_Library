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
    RuntimeError: bundler is not specified: Java/extension/SegmentTree.java\n"
  code: "package extension;\n\nimport java.util.Arrays;\nimport java.util.function.BinaryOperator;\n\
    import java.util.function.Predicate;\n\nfinal class SegmentTree<T extends Number>\
    \ {\n\tprivate int n = 1, rank = 0, fini;\n\tprivate final BinaryOperator<T> op;\n\
    \tprivate final T e;\n\tprivate final Object[] dat;\n\tSegmentTree(final int fini,\
    \ final BinaryOperator<T> op, final T e) {\n\t\tthis.fini = fini;\n\t\tthis.op\
    \ = op;\n\t\tthis.e = e;\n\t\twhile(this.fini > n) {\n\t\t\tn <<= 1;\n\t\t\trank++;\n\
    \t\t}\n\t\tdat = new Object[2 * n];\n\t\tArrays.fill(dat, e);\n\t}\n\t@SuppressWarnings(\"\
    unchecked\")\n\tfinal void update(int i, final T x) {\n\t\ti += n;\n\t\tdat[i]\
    \ = x;\n\t\tdo {\n\t\t\ti >>= 1;\n\t\t\tdat[i] = op.apply((T) dat[2 * i], (T)\
    \ dat[2 * i + 1]);\n\t\t} while(i > 0);\n\t}\n\t@SuppressWarnings(\"unchecked\"\
    )\n\tfinal T query(int a, int b) {\n\t\tT l = e, r = e;\n\t\tfor(a += n, b +=\
    \ n; a < b; a >>= 1, b >>= 1) {\n\t\t\tif(a % 2 == 1) {\n\t\t\t\tl = op.apply(l,\
    \ (T) dat[a++]);\n\t\t\t}\n\t\t\tif(b % 2 == 1) {\n\t\t\t\tr = op.apply((T) dat[--b],\
    \ r);\n\t\t\t}\n\t\t}\n\t\treturn op.apply(l, r);\n\t}\n\t@SuppressWarnings(\"\
    unchecked\")\n\tfinal int findLeft(final int r, final Predicate<T> fn) {\n\t\t\
    if(r == 0) {\n\t\t\treturn 0;\n\t\t}\n\t\tint h = 0, i = r + n;\n\t\tT val = e;\n\
    \t\tfor(; h <= rank; h++) {\n\t\t\tif(i >> (h & 1) > 0) {\n\t\t\t\tfinal T val2\
    \ = op.apply(val, (T) dat[i >> (h ^ 1)]);\n\t\t\t\tif(fn.test(val2)){\n\t\t\t\t\
    \ti -= 1 << h;\n\t\t\t\t\tif(i == n) {\n\t\t\t\t\t\treturn 0;\n\t\t\t\t\t}\n\t\
    \t\t\t\tval = val2;\n\t\t\t\t}\n\t\t\t\telse {\n\t\t\t\t\tbreak;\n\t\t\t\t}\n\t\
    \t\t}\n\t\t}\n\t\tfor(; h-- > 0;) {\n\t\t\tfinal T val2 = op.apply(val, (T) dat[(i\
    \ >> h) - 1]);\n\t\t\tif(fn.test(val2)){\n\t\t\t\ti -= 1 << h;\n\t\t\t\tif(i ==\
    \ n) {\n\t\t\t\t\treturn 0;\n\t\t\t\t}\n\t\t\t\tval = val2;\n\t\t\t}\n\t\t}\n\t\
    \treturn i - n;\n\t}\n\t@SuppressWarnings(\"unchecked\")\n\tfinal int findRight(final\
    \ int l, final Predicate<T> fn) {\n\t\tif(l == fini) {\n\t\t\treturn fini;\n\t\
    \t}\n\t\tint h = 0, i = l + n;\n\t\tT val = e;\n\t\tfor(; h <= rank; h++) {\n\t\
    \t\tif(i >> (h & 1) > 0){\n\t\t\t\tfinal T val2 = op.apply(val, (T) dat[i >> h]);\n\
    \t\t\t\tif(fn.test(val2)){\n\t\t\t\t\ti += 1 << h;\n\t\t\t\t\tif(i == n * 2) {\n\
    \t\t\t\t\t\treturn fini;\n\t\t\t\t\t}\n\t\t\t\t\tval = val2;\n\t\t\t\t}\n\t\t\t\
    \telse {\n\t\t\t\t\tbreak;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tfor(; h-- > 0;) {\n\
    \t\t\tfinal T val2 = op.apply(val, (T) dat[i>>h]);\n\t\t\tif(fn.test(val2)) {\n\
    \t\t\t\ti += 1 << h;\n\t\t\t\tif(i == n * 2) {\n\t\t\t\t\treturn fini;\n\t\t\t\
    \t}\n\t\t\t\tval = val2;\n\t\t\t}\n\t\t}\n\t\treturn Math.min(i - n, fini);\n\t\
    }\n}"
  dependsOn:
  - Java/extension/SparseTable.java
  - Java/extension/PrimeCounter.java
  - Java/extension/PrefixSum.java
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
  path: Java/extension/SegmentTree.java
  requiredBy:
  - Java/extension/SparseTable.java
  - Java/extension/PrimeCounter.java
  - Java/extension/PrefixSum.java
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
  timestamp: '2023-12-27 13:59:23+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: Java/extension/SegmentTree.java
layout: document
redirect_from:
- /library/Java/extension/SegmentTree.java
- /library/Java/extension/SegmentTree.java.html
title: Java/extension/SegmentTree.java
---
