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
    RuntimeError: bundler is not specified: Java/extension/Graph.java\n"
  code: "package extension;\n\nimport java.util.ArrayDeque;\nimport java.util.ArrayList;\n\
    import java.util.Arrays;\nimport java.util.Collections;\nimport java.util.Comparator;\n\
    import java.util.PriorityQueue;\nimport java.util.Queue;\nimport java.util.stream.IntStream;\n\
    \nclass Edge {\n\tpublic int src;\n\tpublic int to;\n\tpublic long cost;\n\tEdge(final\
    \ int to) {\n\t\tthis.to = to;\n\t}\n\tEdge(final int to, final long cost) {\n\
    \t\tthis.to = to;\n\t\tthis.cost = cost;\n\t}\n\tEdge(final int src, final int\
    \ to, final long cost) {\n\t\tthis.src = src;\n\t\tthis.to = to;\n\t\tthis.cost\
    \ = cost;\n\t}\n\t@Override\n\tpublic boolean equals(final Object o) {\n\t\tif(this\
    \ == o) {\n\t\t\treturn true;\n\t\t}\n\t\tif(o == null || getClass() != o.getClass())\
    \ {\n\t\t\treturn false;\n\t\t}\n\t\tfinal Edge e = (Edge) o;\n\t\tif(src != e.src)\
    \ {\n\t\t\treturn false;\n\t\t}\n\t\tif(to != e.to) {\n\t\t\treturn false;\n\t\
    \t}\n\t\treturn cost == e.cost;\n\t}\n\t@Override\n\tpublic int hashCode() {\n\
    \t\tint result = 17;\n\t\tresult = 31 * result + src;\n\t\tresult = 31 * result\
    \ + to;\n\t\tresult = 31 * result + (int) (cost ^ (cost >>> 32)); // XOR for long\
    \ values\n\t\treturn result;\n\t}\n\t@Override\n\tpublic String toString(){ return\
    \ src + \" \" + to + \" \" + cost; }\n}\nclass Graph extends ArrayList<ArrayList<Edge>>\
    \ {\n\tprotected boolean undirected;\n\tprotected int n, indexed;\n\tGraph(final\
    \ int n, final int indexed, final boolean undirected) {\n\t\tthis.n = n;\n\t\t\
    this.indexed = indexed;\n\t\tthis.undirected = undirected;\n\t\tIntStream.range(0,\
    \ n).forEach(i -> this.add(new ArrayList<>()));\n\t}\n\tvoid addEdge(int a, int\
    \ b) {\n\t\ta -= indexed;\n\t\tb -= indexed;\n\t\tthis.get(a).add(new Edge(b));\n\
    \t\tif(undirected) {\n\t\t\tthis.get(b).add(new Edge(a));\n\t\t}\n\t}\n\tprotected\
    \ int[] allDist(final int v) {\n\t\tint[] d = new int[n];\n\t\tArrays.fill(d,\
    \ -1);\n\t\tQueue<Integer> q = new ArrayDeque<>();\n\t\td[v] = 0;\n\t\tq.add(v);\n\
    \t\twhile(!q.isEmpty()) {\n\t\t\tfinal int tmp = q.poll();\n\t\t\tfor(final var\
    \ el: this.get(tmp)) {\n\t\t\t\tif(d[el.to] != -1) {\n\t\t\t\t\tcontinue;\n\t\t\
    \t\t}\n\t\t\t\td[el.to]=d[tmp]+1;\n\t\t\t\tq.add(el.to);\n\t\t\t}\n\t\t}\n\t\t\
    return d;\n\t}\n\tprotected int dist(final int u, final int v){ return allDist(u)[v];\
    \ }\n}\nclass WeightedGraph extends Graph {\n\tWeightedGraph(final int n, final\
    \ int indexed, final boolean undirected) {\n\t\tsuper(n, indexed, undirected);\n\
    \t}\n\tvoid addEdge(int a, int b, final long cost) {\n\t\ta -= indexed;\n\t\t\
    b -= indexed;\n\t\tthis.get(a).add(new Edge(b, cost));\n\t\tif(undirected) {\n\
    \t\t\tthis.get(b).add(new Edge(a, cost));\n\t\t}\n\t}\n\tlong[] dijkstra(final\
    \ int v) {\n\t\tlong[] cost = new long[n];\n\t\tArrays.fill(cost, Long.MAX_VALUE);\n\
    \t\tQueue<NumPair> dj = new PriorityQueue<>(Collections.reverseOrder());\n\t\t\
    cost[v] = 0;\n\t\tdj.add(new NumPair(cost[v], v));\n\t\twhile(!dj.isEmpty()) {\n\
    \t\t\tfinal var tmp = dj.poll();\n\t\t\tif(cost[tmp.second.intValue()] < tmp.first.longValue())\
    \ {\n\t\t\t\tcontinue;\n\t\t\t}\n\t\t\tfor(final var el: this.get(tmp.second.intValue()))\
    \ {\n\t\t\t\tif(cost[el.to] > tmp.first.longValue() + el.cost) {\n\t\t\t\t\tcost[el.to]\
    \ = tmp.first.longValue() + el.cost;\n\t\t\t\t\tdj.add(new NumPair(cost[el.to],\
    \ el.to));\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\treturn cost;\n\t}\n\tlong[][] warshallFloyd()\
    \ {\n\t\tlong[][] cost = new long[n][n];\n\t\tIntStream.range(0, n).forEach(i\
    \ -> Arrays.fill(cost[i], Long.MAX_VALUE));\n\t\tIntStream.range(0, n).forEach(i\
    \ -> cost[i][i] = 0);\n\t\tfor(int i = 0; i < n; ++i) {\n\t\t\tfor(final var j:\
    \ this.get(i)) {\n\t\t\t\tcost[i][j.to] = j.cost;\n\t\t\t}\n\t\t}\n\t\tfor(int\
    \ k = 0 ; k < n; ++k) {\n\t\t\tfor(int i = 0; i < n; ++i) {\n\t\t\t\tfor(int j\
    \ = 0; j < n; ++j) {\n\t\t\t\t\tif(cost[i][j] > cost[i][k] + cost[k][j]) {\n\t\
    \t\t\t\t\tcost[i][j] = cost[i][k] + cost[k][j];\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\
    }\n\t\t}\n\t\treturn cost;\n\t}\n}\nclass Tree {\n\tprivate ArrayList<Edge> edge;\n\
    \tprivate int n, indexed;\n\tTree(final int n, final int indexed) {\n\t\tedge\
    \ = new ArrayList<>(n);\n\t\tthis.n = n;\n\t\tthis.indexed = indexed;\n\t}\n\t\
    void addEdge(final int a, final int b, final long cost){ edge.add(new Edge(a -\
    \ indexed, b - indexed, cost)); }\n\tlong kruskal() {\n\t\tCollections.sort(edge,\
    \ Comparator.comparing(e -> e.cost));\n\t\tUnionFind uf = new UnionFind(n);\n\t\
    \tlong res = 0;\n\t\tfor(final var ed: edge) {\n\t\t\tif(uf.unite(ed.src, ed.to))\
    \ {\n\t\t\t\tres += ed.cost;\n\t\t\t}\n\t\t}\n\t\treturn res;\n\t}\n}"
  dependsOn:
  - Java/extension/MyScanner.java
  - Java/extension/LowestCommonAncestor.java
  - Java/extension/WeightedUnionFind.java
  - Java/extension/FenwickTree.java
  - Java/extension/Pair.java
  - Java/extension/MyPrinter.java
  - Java/extension/WaveletMatrix.java
  - Java/extension/PrefixSum.java
  - Java/extension/UnionFind.java
  - Java/extension/SuffixArray.java
  - Java/extension/LargePrime.java
  - Java/extension/DoubleEndedPriorityQueue.java
  - Java/extension/SparseTable.java
  - Java/extension/PrimeTable.java
  - Java/extension/PrimeFactor.java
  - Java/extension/PrimeCounter.java
  - Java/extension/SegmentTree.java
  - Java/extension/UndoUnionFind.java
  - Java/extension/Template.java
  - Java/all.java
  isVerificationFile: false
  path: Java/extension/Graph.java
  requiredBy:
  - Java/extension/MyScanner.java
  - Java/extension/LowestCommonAncestor.java
  - Java/extension/WeightedUnionFind.java
  - Java/extension/FenwickTree.java
  - Java/extension/Pair.java
  - Java/extension/MyPrinter.java
  - Java/extension/WaveletMatrix.java
  - Java/extension/PrefixSum.java
  - Java/extension/UnionFind.java
  - Java/extension/SuffixArray.java
  - Java/extension/LargePrime.java
  - Java/extension/DoubleEndedPriorityQueue.java
  - Java/extension/SparseTable.java
  - Java/extension/PrimeTable.java
  - Java/extension/PrimeFactor.java
  - Java/extension/PrimeCounter.java
  - Java/extension/SegmentTree.java
  - Java/extension/UndoUnionFind.java
  - Java/extension/Template.java
  - Java/all.java
  timestamp: '2023-12-05 14:30:22+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: Java/extension/Graph.java
layout: document
redirect_from:
- /library/Java/extension/Graph.java
- /library/Java/extension/Graph.java.html
title: Java/extension/Graph.java
---
