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
    RuntimeError: bundler is not specified: Java/extension/WeightedGraph.java\n"
  code: "package extension;\n\nimport java.util.ArrayList;\nimport java.util.Arrays;\n\
    import java.util.Comparator;\nimport java.util.PriorityQueue;\nimport java.util.Queue;\n\
    import java.util.function.Function;\nimport java.util.stream.Collectors;\nimport\
    \ java.util.stream.IntStream;\n\nfinal class MST {\n\tpublic final ArrayList<Edge>\
    \ tree;\n\tpublic final long cost;\n\tMST(final ArrayList<Edge> tree, final long\
    \ cost) {\n\t\tthis.tree = tree;\n\t\tthis.cost = cost;\n\t}\n}\nfinal class WeightedGraph\
    \ extends Graph {\n\tWeightedGraph(final int n, final int indexed, final boolean\
    \ undirected){ super(n, indexed, undirected); }\n\tfinal void addEdge(int a, int\
    \ b, final long cost) {\n\t\ta -= indexed;\n\t\tb -= indexed;\n\t\tthis.get(a).add(new\
    \ Edge(b, cost));\n\t\tedge.add(new Edge(a, b, cost));\n\t\tif(undirected) {\n\
    \t\t\tthis.get(b).add(new Edge(a, cost));\n\t\t\tedge.add(new Edge(b, a, cost));\n\
    \t\t}\n\t}\n\tfinal void input(final int m){ IntStream.range(0, m).forEach(i ->\
    \ addEdge(VvyLw.sc.ni(), VvyLw.sc.ni(), VvyLw.sc.ni())); }\n\tfinal long[] dijkstra(final\
    \ int v) {\n\t\tfinal long[] cost = new long[n];\n\t\tArrays.fill(cost, Long.MAX_VALUE);\n\
    \t\tfinal Queue<NumPair> dj = new PriorityQueue<>();\n\t\tcost[v] = 0;\n\t\tdj.add(new\
    \ NumPair(cost[v], v));\n\t\twhile(!dj.isEmpty()) {\n\t\t\tfinal var tmp = dj.poll();\n\
    \t\t\tif(cost[tmp.second.intValue()] < tmp.first.longValue()) {\n\t\t\t\tcontinue;\n\
    \t\t\t}\n\t\t\tfor(final var el: this.get(tmp.second.intValue())) {\n\t\t\t\t\
    if(cost[el.to] > tmp.first.longValue() + el.cost) {\n\t\t\t\t\tcost[el.to] = tmp.first.longValue()\
    \ + el.cost;\n\t\t\t\t\tdj.add(new NumPair(cost[el.to], el.to));\n\t\t\t\t}\n\t\
    \t\t}\n\t\t}\n\t\treturn cost;\n\t}\n\tfinal long[] bellmanFord(final int v) {\n\
    \t\tfinal long[] cost = new long[n];\n\t\tArrays.fill(cost, Long.MAX_VALUE);\n\
    \t\tcost[v] = 0;\n\t\tfor(int i = 0; i < edge.size() - 1; ++i) {\n\t\t\tfor(final\
    \ var e: edge) {\n\t\t\t\tif(cost[e.src] == Long.MAX_VALUE) {\n\t\t\t\t\tcontinue;\n\
    \t\t\t\t}\n\t\t\t\tcost[e.to] = Math.min(cost[e.to], cost[e.src] + e.cost);\n\t\
    \t\t}\n\t\t}\n\t\tfor(final var e: edge) {\n\t\t\tif(cost[e.src] == Long.MAX_VALUE)\
    \ {\n\t\t\t\tcontinue;\n\t\t\t}\n\t\t\tif(cost[e.src] + e.cost < cost[e.to]) {\n\
    \t\t\t\treturn null;\n\t\t\t}\n\t\t}\n\t\treturn cost;\n\t}\n\tfinal long[][]\
    \ warshallFloyd() {\n\t\tfinal long[][] cost = new long[n][n];\n\t\tIntStream.range(0,\
    \ n).forEach(i -> Arrays.fill(cost[i], Long.MAX_VALUE));\n\t\tIntStream.range(0,\
    \ n).forEach(i -> cost[i][i] = 0);\n\t\tfor(int i = 0; i < n; ++i) {\n\t\t\tfor(final\
    \ var j: this.get(i)) {\n\t\t\t\tcost[i][j.to] = j.cost;\n\t\t\t}\n\t\t}\n\t\t\
    for(int k = 0; k < n; ++k) {\n\t\t\tfor(int i = 0; i < n; ++i) {\n\t\t\t\tfor(int\
    \ j = 0; j < n; ++j) {\n\t\t\t\t\tif(cost[i][j] > cost[i][k] + cost[k][j]) {\n\
    \t\t\t\t\t\tcost[i][j] = cost[i][k] + cost[k][j];\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\
    \t}\n\t\t}\n\t\treturn cost;\n\t}\n\tfinal MST kruskal() {\n\t\tfinal UnionFind\
    \ uf = new UnionFind(n);\n\t\tfinal var e = new ArrayList<Edge>();\n\t\tlong res\
    \ = 0;\n\t\tfor(final var ed: edge.stream().sorted(Comparator.comparing(ed ->\
    \ ed.cost)).collect(Collectors.toList())) {\n\t\t\tif(uf.unite(ed.src, ed.to))\
    \ {\n\t\t\t\te.add(ed);\n\t\t\t\tres += ed.cost;\n\t\t\t}\n\t\t}\n\t\treturn new\
    \ MST(e, res);\n\t}\n\tfinal MST directed(final int v) {\n\t\t@SuppressWarnings(\"\
    unchecked\")\n\t\tfinal var ed = (ArrayList<Edge>) edge.clone();\n\t\tfor(int\
    \ i = 0; i < n; ++i) {\n\t\t\tif(i != v) {\n\t\t\t\ted.add(new Edge(i, v, 0));\n\
    \t\t\t}\n\t\t}\n\t\tint x = 0;\n\t\tfinal int[] par = new int[2 * n], vis = new\
    \ int[2 * n], link = new int[2 * n];\n\t\tArrays.fill(par, -1);\n\t\tArrays.fill(vis,\
    \ -1);\n\t\tArrays.fill(link, -1);\n\t\tfinal var heap = new SkewHeap(true);\n\
    \t\tfinal var ins = new SkewHeap.Node[2 * n];\n\t\tArrays.fill(ins, null);\n\t\
    \tfor(int i = 0; i < ed.size(); i++) {\n\t\t\tfinal var e = ed.get(i);\n\t\t\t\
    ins[e.to] = heap.push(ins[e.to], e.cost, i);\n\t\t}\n\t\tfinal var st = new ArrayList<Integer>();\n\
    \t\tfinal Function<Integer, Integer> go = z -> {\n\t\t\tz = ed.get(ins[z].idx).src;\n\
    \t\t\twhile(link[z] != -1) {\n\t\t\t\tst.add(z);\n\t\t\t\tz = link[z];\n\t\t\t\
    }\n\t\t\tfor(final var p: st) {\n\t\t\t\tlink[p] = z;\n\t\t\t}\n\t\t\tst.clear();\n\
    \t\t\treturn z;\n\t\t};\n\t\tfor(int i = n; ins[x] != null; ++i) {\n\t\t\twhile(vis[x]\
    \ == -1) {\n\t\t\t\tvis[x] = 0;\n\t\t\t\tx = go.apply(x);\n\t\t\t}\n\t\t\twhile(x\
    \ != i) {\n\t\t\t\tfinal var w = ins[x].key;\n\t\t\t\tvar z = heap.pop(ins[x]);\n\
    \t\t\t\tz = heap.add(z, -w);\n\t\t\t\tins[i] = heap.meld(ins[i], z);\n\t\t\t\t\
    par[x] = i;\n\t\t\t\tlink[x] = i;\n\t\t\t\tx = go.apply(x);\n\t\t\t}\n\t\t\twhile(ins[x]\
    \ != null && go.apply(x) == x) {\n\t\t\t\tins[x] = heap.pop(ins[x]);\n\t\t\t}\n\
    \t\t}\n\t\tfor(int i = v; i != -1; i = par[i]) {\n\t\t\tvis[i] = 1;\n\t\t}\n\t\
    \tlong cost = 0;\n\t\tArrayList<Edge> e = new ArrayList<>();\n\t\tfor(int i =\
    \ x; i >= 0; i--) {\n\t\t\tif(vis[i] == 1) {\n\t\t\t\tcontinue;\n\t\t\t}\n\t\t\
    \tcost += ed.get(ins[i].idx).cost;\n\t\t\te.add(ed.get(ins[i].idx));\n\t\t\tfor(int\
    \ j = ed.get(ins[i].idx).to; j != -1 && vis[j] == 0; j = par[j]) {\n\t\t\t\tvis[j]\
    \ = 1;\n\t\t\t}\n\t\t}\n\t\treturn new MST(e, cost);\n\t}\n}\nfinal class SkewHeap\
    \ {\n\tstatic final class Node {\n\t\tlong key, lazy;\n\t\tNode l, r;\n\t\tfinal\
    \ int idx;\n\t\tNode(final long key, final int idx) {\n\t\t\tthis.key = key;\n\
    \t\t\tthis.idx = idx;\n\t\t\tlazy = 0;\n\t\t\tl = null;\n\t\t\tr = null;\n\t\t\
    }\n\t}\n\tprivate final boolean isMin;\n\tSkewHeap(final boolean isMin){ this.isMin\
    \ = isMin; }\n\tprivate final Node alloc(final long key, final int idx){ return\
    \ new Node(key, idx); }\n\tprivate final Node propagate(final Node t) {\n\t\t\
    if(t != null && t.lazy != 0) {\n\t\t\tif(t.l != null) {\n\t\t\t\tt.l.lazy += t.lazy;\n\
    \t\t\t}\n\t\t\tif(t.r != null) {\n\t\t\t\tt.r.lazy += t.lazy;\n\t\t\t}\n\t\t\t\
    t.key += t.lazy;\n\t\t\tt.lazy = 0;\n\t\t}\n\t\treturn t;\n\t}\n\tfinal Node meld(Node\
    \ x, Node y) {\n\t\tpropagate(x);\n\t\tpropagate(y);\n\t\tif(x == null || y ==\
    \ null) {\n\t\t\treturn x != null ? x : y;\n\t\t}\n\t\tif((x.key < y.key) ^ isMin)\
    \ {\n\t\t\tfinal var tmp = x;\n\t\t\tx = y;\n\t\t\ty = tmp;\n\t\t}\n\t\tx.r =\
    \ meld(y, x.r);\n\t\tfinal var tmp = x.l;\n\t\tx.l = x.r;\n\t\tx.r = tmp;\n\t\t\
    return x;\n\t}\n\tfinal Node push(final Node t, final long key, int idx){ return\
    \ meld(t, alloc(key, idx)); }\n\tfinal Node pop(final Node t) {\n\t\tif(t == null)\
    \ {\n\t\t\tthrow new NullPointerException();\n\t\t}\n\t\treturn meld(t.l, t.r);\n\
    \t}\n\tfinal Node add(Node t, final long lazy) {\n\t\tif(t != null) {\n\t\t\t\
    t.lazy += lazy;\n\t\t\tpropagate(t);\n\t\t}\n\t\treturn t;\n\t}\n}\n"
  dependsOn:
  - Java/extension/SparseTable.java
  - Java/extension/PrimeCounter.java
  - Java/extension/PrefixSum.java
  - Java/extension/SegmentTree.java
  - Java/extension/DoubleEndedPriorityQueue.java
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
  path: Java/extension/WeightedGraph.java
  requiredBy:
  - Java/extension/SparseTable.java
  - Java/extension/PrimeCounter.java
  - Java/extension/PrefixSum.java
  - Java/extension/SegmentTree.java
  - Java/extension/DoubleEndedPriorityQueue.java
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
  timestamp: '2024-01-01 09:37:52+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: Java/extension/WeightedGraph.java
layout: document
redirect_from:
- /library/Java/extension/WeightedGraph.java
- /library/Java/extension/WeightedGraph.java.html
title: Java/extension/WeightedGraph.java
---
