---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: Java/all.java
    title: Java/all.java
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
    RuntimeError: bundler is not specified: Java/extension/AVLTree.java\n"
  code: "final class AVLTree<T extends Comparable<? super T>> {\n\tstatic final class\
    \ Node<T extends Comparable<? super T>> {\n\t\tT val;\n\t\t@SuppressWarnings(\"\
    unchecked\")\n\t\tNode<T>[] ch = new Node[2];\n\t\tint dep, size;\n\t\tNode(final\
    \ T val, Node<T> l, Node<T> r) {\n\t\t\tthis.val = val;\n\t\t\tdep = size = 1;\n\
    \t\t\tch[0] = l;\n\t\t\tch[1] = r;\n\t\t}\n\t}\n\tprivate Node<T> root;\n\tprivate\
    \ final int depth(final Node<T> t){ return t == null ? 0 : t.dep; }\n\tprivate\
    \ final int count(final Node<T> t){ return t == null ? 0 : t.size; }\n\tprivate\
    \ final Node<T> update(final Node<T> t) {\n\t\tt.dep = Math.max(depth(t.ch[0]),\
    \ depth(t.ch[1])) + 1;\n\t\tt.size = count(t.ch[0]) + count(t.ch[1]) + 1;\n\t\t\
    return t;\n\t}\n\tprivate final Node<T> rotate(Node<T> t, final int b) {\n\t\t\
    var s = t.ch[1 - b];\n\t\tt.ch[1 - b] = s.ch[b];\n\t\ts.ch[b] = t;\n\t\tt = update(t);\n\
    \t\ts = update(s);\n\t\treturn s;\n\t}\n\tprivate final Node<T> fetch(Node<T>\
    \ t) {\n\t\tif(t == null) {\n\t\t\treturn t;\n\t\t}\n\t\tif(depth(t.ch[0]) - depth(t.ch[1])\
    \ == 2) {\n\t\t\tif(depth(t.ch[0].ch[1]) > depth(t.ch[0].ch[0])) {\n\t\t\t\tt.ch[0]\
    \ = rotate(t.ch[0], 0);\n\t\t\t}\n\t\t\tt = rotate(t, 1);\n\t\t}\n\t\telse if(depth(t.ch[0])\
    \ - depth(t.ch[1]) == -2) {\n\t\t\tif (depth(t.ch[1].ch[0]) > depth(t.ch[1].ch[1]))\
    \ {\n\t\t\t\tt.ch[1] = rotate(t.ch[1], 1);\n\t\t\t}\n\t\t\tt = rotate(t, 0);\n\
    \t\t}\n\t\treturn t;\n\t}\n\tprivate final Node<T> insert(final Node<T> t, final\
    \ int k, final T v) {\n\t\tif(t == null) {\n\t\t\treturn new Node<T>(v, null,\
    \ null);\n\t\t}\n\t\tfinal int c = count(t.ch[0]), b = (k > c) ? 1 : 0;\n\t\t\
    t.ch[b] = insert(t.ch[b], k - (b == 1 ? (c + 1) : 0), v);\n\t\tupdate(t);\n\t\t\
    return fetch(t);\n\t}\n\tprivate final Node<T> erase(final Node<T> t) {\n\t\t\
    if(t == null || t.ch[0] == null && t.ch[1] == null) {\n\t\t\treturn null;\n\t\t\
    }\n\t\tif(t.ch[0] == null || t.ch[1] == null) {\n\t\t\treturn t.ch[t.ch[0] ==\
    \ null ? 1 : 0];\n\t\t}\n\t\treturn fetch(update(new Node<T>(find(t.ch[1], 0).val,\
    \ t.ch[0], erase(t.ch[1], 0))));\n\t}\n\tprivate final Node<T> erase(Node<T> t,\
    \ final int k) {\n\t\tif(t == null) {\n\t\t\treturn null;\n\t\t}\n\t\tfinal int\
    \ c = count(t.ch[0]);\n\t\tif(k < c) {\n\t\t\tt.ch[0] = erase(t.ch[0], k);\n\t\
    \t\tt = update(t);\n\t\t}\n\t\telse if(k > c) {\n\t\t\tt.ch[1] = erase(t.ch[1],\
    \ k - (c + 1));\n\t\t\tt = update(t);\n\t\t}\n\t\telse {\n\t\t\tt = erase(t);\n\
    \t\t}\n\t\treturn fetch(t);\n\t}\n\tprivate final Node<T> find(final Node<T> t,\
    \ final int k) {\n\t\tif(t == null) {\n\t\t\treturn t;\n\t\t}\n\t\tfinal int c\
    \ = count(t.ch[0]);\n\t\treturn k < c ? find(t.ch[0], k) : k == c ? t : find(t.ch[1],\
    \ k - (c + 1));\n\t}\n\tprivate final int cnt(final Node<T> t, final T v) {\n\t\
    \tif(t == null) {\n\t\t\treturn 0;\n\t\t}\n\t\tif(t.val.compareTo(v) < 0) {\n\t\
    \t\treturn count(t.ch[0]) + 1 + cnt(t.ch[1], v);\n\t\t}\n\t\tif(t.val.equals(v))\
    \ {\n\t\t\treturn count(t.ch[0]);\n\t\t}\n\t\treturn cnt(t.ch[0], v);\n\t}\n\t\
    AVLTree(){ root = null; }\n\tfinal void add(final T val){ root = insert(root,\
    \ cnt(root, val), val); }\n\tfinal void remove(final int k){ root = erase(root,\
    \ k); }\n\tfinal T get(final int k){ return find(root, k).val; }\n\tfinal int\
    \ count(final T val){ return cnt(root, val); }\n\tfinal int size(){ return root.size;\
    \ }\n\t@Override\n\tpublic final String toString() {\n\t\tfinal var sb = new StringBuilder();\n\
    \t\tsb.append(get(0));\n\t\tfor(int i = 0; ++i < root.size;) {\n\t\t\tsb.append(\"\
    \ \");\n\t\t\tsb.append(get(i));\n\t\t}\n\t\treturn \"[\" + sb.toString() + \"\
    ]\";\n\t}\n}"
  dependsOn:
  - Java/extension/SparseTable.java
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
  - Java/extension/Graph.java
  - Java/extension/Template.java
  - Java/all.java
  isVerificationFile: false
  path: Java/extension/AVLTree.java
  requiredBy:
  - Java/extension/SparseTable.java
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
  - Java/extension/Graph.java
  - Java/extension/Template.java
  - Java/all.java
  timestamp: '2024-01-01 16:04:30+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: Java/extension/AVLTree.java
layout: document
redirect_from:
- /library/Java/extension/AVLTree.java
- /library/Java/extension/AVLTree.java.html
title: Java/extension/AVLTree.java
---
