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
    path: Java/extension/SparseTable.java
    title: Java/extension/SparseTable.java
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
    RuntimeError: bundler is not specified: Java/extension/SuffixArray.java\n"
  code: "package extension;\n\nimport java.util.ArrayList;\nimport java.util.Arrays;\n\
    import java.util.function.BiPredicate;\nimport java.util.function.Consumer;\n\
    import java.util.stream.Collectors;\nimport java.util.stream.IntStream;\n\nfinal\
    \ class SuffixArray extends ArrayList<Integer> {\n\tprivate final String vs;\n\
    \tSuffixArray(final String vs, final boolean compress) {\n\t\tthis.vs = vs;\n\t\
    \tint[] newVS = new int[vs.length() + 1];\n\t\tif(compress) {\n\t\t\tfinal var\
    \ xs = vs.chars().sorted().distinct().boxed().collect(Collectors.toList());\n\t\
    \t\tfor(int i = 0; i < vs.length(); ++i) {\n\t\t\t\tnewVS[i] = Utility.lowerBound(xs,\
    \ (int) vs.charAt(i)) + 1;\n\t\t\t}\n\t\t} else {\n\t\t\tfinal int d = vs.chars().min().getAsInt();\n\
    \t\t\tfor(int i = 0; i < vs.length(); ++i) {\n\t\t\t\tnewVS[i] = vs.charAt(i)\
    \ - d + 1;\n\t\t\t}\n\t\t}\n\t\tthis.addAll(Arrays.stream(SAIS(newVS)).boxed().collect(Collectors.toList()));\n\
    \t}\n\tprivate final int[] SAIS(final int[] s) {\n\t\tfinal int n = s.length;\n\
    \t\tfinal int[] ret = new int[n];\n\t\tfinal boolean[] isS = new boolean[n], isLMS\
    \ = new boolean[n];\n\t\tint m = 0;\n\t\tfor(int i = n - 2; i >= 0; i--) {\n\t\
    \t\tisS[i] = (s[i] > s[i + 1]) || (s[i] == s[i + 1] && isS[i + 1]);\n\t\t\tm +=\
    \ (isLMS[i + 1] = isS[i] && !isS[i + 1]) ? 1 : 0;\n\t\t}\n\t\tfinal Consumer<ArrayList<Integer>>\
    \ inducedSort = (lms) -> {\n\t\t\tfinal int upper = Arrays.stream(s).max().getAsInt();\n\
    \t\t\tint[] l = new int[upper + 2], r = new int[upper + 2];\n\t\t\tfor(final var\
    \ v: s) {\n\t\t\t\t++l[v + 1];\n\t\t\t\t++r[v];\n\t\t\t}\n\t\t\tArrays.parallelPrefix(l,\
    \ (x, y) -> x + y);\n\t\t\tArrays.parallelPrefix(r, (x, y) -> x + y);\n\t\t\t\
    Arrays.fill(ret, -1);\n\t\t\tfor(int i = lms.size(); --i >= 0;) {\n\t\t\t\tret[--r[s[lms.get(i)]]]\
    \ = lms.get(i);\n\t\t\t}\n\t\t\tfor(final var v: ret) {\n\t\t\t\tif(v >= 1 &&\
    \ isS[v - 1]) {\n\t\t\t\t\tret[l[s[v - 1]]++] = v - 1;\n\t\t\t\t}\n\t\t\t}\n\t\
    \t\tArrays.fill(r, 0);\n\t\t\tfor(final var v: s) {\n\t\t\t\t++r[v];\n\t\t\t}\n\
    \t\t\tArrays.parallelPrefix(r, (x, y) -> x + y);\n\t\t\tfor(int k = ret.length\
    \ - 1, i = ret[k]; k >= 1; i = ret[--k]) {\n\t\t\t\tif(i >= 1 && !isS[i - 1])\
    \ {\n\t\t\t\t\tret[--r[s[i - 1]]] = i - 1;\n\t\t\t\t}\n\t\t\t}\n\t\t};\n\t\tfinal\
    \ ArrayList<Integer> lms = new ArrayList<>(), newLMS = new ArrayList<>();\n\t\t\
    for(int i = 0; ++i < n;) {\n\t\t\tif(isLMS[i]) {\n\t\t\t\tlms.add(i);\n\t\t\t\
    }\n\t\t}\n\t\tinducedSort.accept(lms);\n\t\tfor(int i = 0; i < n; ++i) {\n\t\t\
    \tif(!isS[ret[i]] && ret[i] > 0 && isS[ret[i] - 1]) {\n\t\t\t\tnewLMS.add(ret[i]);\n\
    \t\t\t}\n\t\t}\n\t\tfinal BiPredicate<Integer, Integer> same = (a, b) -> {\n\t\
    \t\tif(s[a++] != s[b++]) {\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\twhile(true)\
    \ {\n\t\t\t\tif(s[a] != s[b]) {\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\t\
    if(isLMS[a] || isLMS[b]) {\n\t\t\t\t\treturn isLMS[a] && isLMS[b];\n\t\t\t\t}\n\
    \t\t\t\ta++;\n\t\t\t\tb++;\n\t\t\t}\n\t\t};\n\t\tint rank = 0;\n\t\tret[n - 1]\
    \ = 0;\n\t\tfor(int i = 0; ++i < m;) {\n\t\t\tif(!same.test(newLMS.get(i - 1),\
    \ newLMS.get(i))) {\n\t\t\t\t++rank;\n\t\t\t}\n\t\t\tret[newLMS.get(i)] = rank;\n\
    \t\t}\n\t\tif(rank + 1 < m) {\n\t\t\tint[] newS = new int[m];\n\t\t\tfor(int i\
    \ = 0; i < m; ++i) {\n\t\t\t\tnewS[i] = ret[lms.get(i)];\n\t\t\t}\n\t\t\tfinal\
    \ var lmsSA = SAIS(newS);\n\t\t\tIntStream.range(0, m).forEach(i -> newLMS.set(i,\
    \ lms.get(lmsSA[i])));\n\t\t}\n\t\tinducedSort.accept(newLMS);\n\t\treturn ret;\n\
    \t}\n\tfinal boolean ltSubstr(final String t, int si, int ti) {\n\t\tfinal int\
    \ sn = vs.length(), tn = t.length();\n\t\twhile(si < sn && ti < tn) {\n\t\t\t\
    if(vs.charAt(si) < t.charAt(ti)) {\n\t\t\t\treturn true;\n\t\t\t}\n\t\t\tif(vs.charAt(si)\
    \ > t.charAt(ti)) {\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\t++si;\n\t\t\t++ti;\n\
    \t\t}\n\t\treturn si >= sn && ti < tn;\n\t}\n\tfinal int lowerBound(final String\
    \ t) {\n\t\tint ok = this.size(), ng = 0;\n\t\twhile(ok - ng > 1) {\n\t\t\tfinal\
    \ int mid = (ok + ng) / 2;\n\t\t\tif(ltSubstr(t, this.get(mid), 0)) {\n\t\t\t\t\
    ng = mid;\n\t\t\t} else {\n\t\t\t\tok = mid;\n\t\t\t}\n\t\t}\n\t\treturn ok;\n\
    \t}\n\tfinal Pair<Integer, Integer> equalRange(final String t) {\n\t\tfinal int\
    \ low = lowerBound(t);\n\t\tint ng = low - 1, ok = this.size();\n\t\tvar sb =\
    \ new StringBuilder(t);\n\t\tsb.setCharAt(t.length() - 1, (char)(sb.charAt(sb.length()\
    \ - 1) - 1));\n\t\tfinal String u = sb.toString();\n\t\twhile(ok - ng > 1) {\n\
    \t\t\tfinal int mid = (ok + ng) / 2;\n\t\t\tif(ltSubstr(u, this.get(mid), 0))\
    \ {\n\t\t\t\tng = mid;\n\t\t\t} else {\n\t\t\t\tok = mid;\n\t\t\t}\n\t\t}\n\t\t\
    final int end = this.size() - 1;\n\t\tthis.add(end, this.get(end) - 1);\n\t\t\
    return Pair.of(low, ok);\n\t}\n\tfinal int[] lcpArray() {\n\t\tfinal int n = this.size()\
    \ - 1;\n\t\tint[] lcp = new int[n + 1], rank = new int[n + 1];\n\t\tfor(int i\
    \ = 0; i <= n; ++i) {\n\t\t\trank[this.get(i)] = i;\n\t\t}\n\t\tint h = 0;\n\t\
    \tfor(int i = 0; i <= n; ++i) {\n\t\t\tif(rank[i] < n) {\n\t\t\t\tfinal int j\
    \ = this.get(rank[i] + 1);\n\t\t\t\tfor(; j + h < n && i + h < n; ++h) {\n\t\t\
    \t\t\tif(vs.charAt(j + h) != vs.charAt(i + h)) {\n\t\t\t\t\t\tbreak;\n\t\t\t\t\
    \t}\n\t\t\t\t}\n\t\t\t\tlcp[rank[i] + 1] = h;\n\t\t\t\tif(h > 0) {\n\t\t\t\t\t\
    h--;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\treturn lcp;\n\t}\n\t@Override\n\tpublic final\
    \ String toString() { \n\t\tStringBuilder sb = new StringBuilder();\n\t\tfor(int\
    \ i = 0; i < this.size(); ++i) {\n\t\t\tsb.append(i + \":[\" + this.get(i) + \"\
    ]\");\n\t\t\tfor(int j = this.get(i); j < vs.length(); ++j) {\n\t\t\t\tsb.append(\"\
    \ \" + vs.charAt(j));\n\t\t\t}\n\t\t\tsb.append(\"\\n\");\n\t\t}\n\t\treturn sb.toString();\n\
    \t}\n}"
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
  - Java/extension/AVLTree.java
  - Java/extension/Graph.java
  - Java/extension/Template.java
  - Java/all.java
  isVerificationFile: false
  path: Java/extension/SuffixArray.java
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
  - Java/extension/AVLTree.java
  - Java/extension/Graph.java
  - Java/extension/Template.java
  - Java/all.java
  timestamp: '2024-01-01 07:53:04+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: Java/extension/SuffixArray.java
layout: document
redirect_from:
- /library/Java/extension/SuffixArray.java
- /library/Java/extension/SuffixArray.java.html
title: Java/extension/SuffixArray.java
---
