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
    path: Java/extension/DoubleEndedPriorityQueue.java
    title: Java/extension/DoubleEndedPriorityQueue.java
  - icon: ':warning:'
    path: Java/extension/EulerPhiTable.java
    title: Java/extension/EulerPhiTable.java
  - icon: ':warning:'
    path: Java/extension/FenwickTree.java
    title: Java/extension/FenwickTree.java
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
    RuntimeError: bundler is not specified: Java/extension/Graph.java\n"
  code: "package extension;\n\nimport java.util.ArrayDeque;\nimport java.util.ArrayList;\n\
    import java.util.Arrays;\nimport java.util.Queue;\nimport java.util.Stack;\nimport\
    \ java.util.stream.IntStream;\n\nfinal class Edge {\n\tpublic int src;\n\tpublic\
    \ int to;\n\tpublic long cost;\n\tEdge(final int to) {\n\t\tthis.to = to;\n\t\
    }\n\tEdge(final int to, final long cost) {\n\t\tthis.to = to;\n\t\tthis.cost =\
    \ cost;\n\t}\n\tEdge(final int src, final int to, final long cost) {\n\t\tthis.src\
    \ = src;\n\t\tthis.to = to;\n\t\tthis.cost = cost;\n\t}\n\t@Override\n\tpublic\
    \ final boolean equals(final Object o) {\n\t\tif(this == o) {\n\t\t\treturn true;\n\
    \t\t}\n\t\tif(o == null || getClass() != o.getClass()) {\n\t\t\treturn false;\n\
    \t\t}\n\t\tfinal Edge e = (Edge) o;\n\t\tif(src != e.src) {\n\t\t\treturn false;\n\
    \t\t}\n\t\tif(to != e.to) {\n\t\t\treturn false;\n\t\t}\n\t\treturn cost == e.cost;\n\
    \t}\n\t@Override\n\tpublic final int hashCode() {\n\t\tint result = 17;\n\t\t\
    result = 31 * result + src;\n\t\tresult = 31 * result + to;\n\t\tresult = 31 *\
    \ result + (int) (cost ^ (cost >>> 32)); // XOR for long values\n\t\treturn result;\n\
    \t}\n\t@Override\n\tpublic final String toString(){ return \"(\" + src + \", \"\
    \ + to + \", \" + cost + \")\"; }\n}\nclass Graph extends ArrayList<ArrayList<Edge>>\
    \ {\n\tprotected final boolean undirected;\n\tprotected final int n, indexed;\n\
    \tprotected final ArrayList<Edge> edge;\n\tGraph(final int n, final int indexed,\
    \ final boolean undirected) {\n\t\tthis.n = n;\n\t\tthis.indexed = indexed;\n\t\
    \tthis.undirected = undirected;\n\t\tedge = new ArrayList<>();\n\t\tIntStream.range(0,\
    \ n).forEach(i -> this.add(new ArrayList<>()));\n\t}\n\tfinal void addEdge(int\
    \ a, int b) {\n\t\ta -= indexed;\n\t\tb -= indexed;\n\t\tthis.get(a).add(new Edge(b));\n\
    \t\tedge.add(new Edge(a, b, 0));\n\t\tif(undirected) {\n\t\t\tthis.get(b).add(new\
    \ Edge(a));\n\t\t\tedge.add(new Edge(b, a, 0));\n\t\t}\n\t}\n\tvoid input(final\
    \ int m){ IntStream.range(0, m).forEach(i -> addEdge(VvyLw.sc.ni(), VvyLw.sc.ni()));\
    \ }\n\tprotected final int[] allDist(final int v) {\n\t\tfinal int[] d = new int[n];\n\
    \t\tArrays.fill(d, -1);\n\t\tfinal Queue<Integer> q = new ArrayDeque<>();\n\t\t\
    d[v] = 0;\n\t\tq.add(v);\n\t\twhile(!q.isEmpty()) {\n\t\t\tfinal int tmp = q.poll();\n\
    \t\t\tfor(final Edge el: this.get(tmp)) {\n\t\t\t\tif(d[el.to] != -1) {\n\t\t\t\
    \t\tcontinue;\n\t\t\t\t}\n\t\t\t\td[el.to] = d[tmp] + 1;\n\t\t\t\tq.add(el.to);\n\
    \t\t\t}\n\t\t}\n\t\treturn d;\n\t}\n\tprotected final int dist(final int u, final\
    \ int v){ return allDist(u)[v]; }\n\tprotected final ArrayList<Integer> topologicalSort()\
    \ {\n\t\tfinal int[] deg = new int[n];\n\t\tfor(int i = 0; i < n; ++i) {\n\t\t\
    \tfor(final Edge ed: this.get(i)) {\n\t\t\t\tdeg[ed.to]++;\n\t\t\t}\n\t\t}\n\t\
    \tfinal Stack<Integer> sk = new Stack<>();\n\t\tfor(int i = 0; i < n; ++i) {\n\
    \t\t\tif(deg[i] == 0) {\n\t\t\t\tsk.add(i);\n\t\t\t}\n\t\t}\n\t\tfinal ArrayList<Integer>\
    \ ord = new ArrayList<>();\n\t\twhile(!sk.isEmpty()) {\n\t\t\tfinal int tmp =\
    \ sk.pop();\n\t\t\tord.add(tmp);\n\t\t\tfor(final Edge ed: this.get(tmp)) {\n\t\
    \t\t\tif(--deg[ed.to] == 0) {\n\t\t\t\t\tsk.add(ed.to);\n\t\t\t\t}\n\t\t\t}\n\t\
    \t}\n\t\treturn ord.size() == size() ? ord : new ArrayList<>();\n\t}\n}\n"
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
  - Java/extension/AVLTree.java
  - Java/extension/Template.java
  - Java/all.java
  isVerificationFile: false
  path: Java/extension/Graph.java
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
  - Java/extension/AVLTree.java
  - Java/extension/Template.java
  - Java/all.java
  timestamp: '2024-01-05 18:01:21+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: Java/extension/Graph.java
layout: document
redirect_from:
- /library/Java/extension/Graph.java
- /library/Java/extension/Graph.java.html
title: Java/extension/Graph.java
---
