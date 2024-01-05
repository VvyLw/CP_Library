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
    RuntimeError: bundler is not specified: Java/extension/WaveletMatrix.java\n"
  code: "package extension;\n\nimport java.util.Arrays;\nimport java.util.stream.IntStream;\n\
    \nfinal class SuccinctIndexableDictionary {\n\tprivate final int blk;\n\tprivate\
    \ final int[] bit, sum;\n\tSuccinctIndexableDictionary(final int len) {\n\t\t\
    blk = (len + 31) >> 5;\n\t\tbit = new int[blk];\n\t\tsum = new int[blk];\n\t}\n\
    \tfinal void set(final int k){ bit[k >> 5] |= 1 << (k & 31); }\n\tfinal void build()\
    \ {\n\t\tsum[0] = 0;\n\t\tfor(int i = 0; ++i < blk;) {\n\t\t\tsum[i] = sum[i -\
    \ 1] + Integer.bitCount(bit[i - 1]);\n\t\t}\n\t}\n\tfinal boolean get(final int\
    \ k){ return ((bit[k >> 5] >> (k & 31)) & 1) == 1; }\n\tfinal int rank(final int\
    \ k){ return (sum[k >> 5] + Integer.bitCount(bit[k >> 5] & ((1 << (k & 31)) -\
    \ 1))); }\n\tfinal int rank(final boolean val, final int k){ return val ? rank(k)\
    \ : k - rank(k); }\n}\nfinal class WaveletMatrixBeta {\n\tprivate final int log;\n\
    \tprivate final SuccinctIndexableDictionary[] matrix;\n\tprivate final int[] mid;\n\
    \tWaveletMatrixBeta(long[] arr, final int log) {\n\t\tfinal int len = arr.length;\n\
    \t\tthis.log = log;\n\t\tmatrix = new SuccinctIndexableDictionary[log];\n\t\t\
    mid = new int[log];\n\t\tfinal long[] l = new long[len], r = new long[len];\n\t\
    \tfor(int level = log; --level >= 0;) {\n\t\t\tmatrix[level] = new SuccinctIndexableDictionary(len\
    \ + 1);\n\t\t\tint left = 0, right = 0;\n\t\t\tfor(int i = 0; i < len; ++i) {\n\
    \t\t\t\tif(((arr[i] >> level) & 1) == 1) {\n\t\t\t\t\tmatrix[level].set(i);\n\t\
    \t\t\t\tr[right++] = arr[i];\n\t\t\t\t} else {\n\t\t\t\t\tl[left++] = arr[i];\n\
    \t\t\t\t}\n\t\t\t}\n\t\t\tmid[level] = left;\n\t\t\tmatrix[level].build();\n\t\
    \t\tfinal long[] tmp = new long[len];\n\t\t\tSystem.arraycopy(arr, 0, tmp, 0,\
    \ len);\n\t\t\tSystem.arraycopy(l, 0, arr, 0, len);\n\t\t\tSystem.arraycopy(tmp,\
    \ 0, l, 0, len);\n\t\t\tfor(int i = 0; i < right; ++i) {\n\t\t\t\tarr[left + i]\
    \ = r[i];\n\t\t\t}\n\t\t}\n\t}\n\tprivate final IntPair succ(final boolean f,\
    \ final int l, final int r, final int level){ return new IntPair(matrix[level].rank(f,\
    \ l) + mid[level] * (f ? 1 : 0), matrix[level].rank(f, r) + mid[level] * (f ?\
    \ 1 : 0)); }\n\tfinal long access(int k) {\n\t\tlong ret = 0;\n\t\tfor(int level\
    \ = log; --level >= 0;) {\n\t\t\tfinal boolean f = matrix[level].get(k);\n\t\t\
    \tif(f) {\n\t\t\t\tret |= 1L << level;\n\t\t\t}\n\t\t\tk = matrix[level].rank(f,\
    \ k) + mid[level] * (f ? 1 : 0);\n\t\t}\t\n\t\treturn ret;\n\t}\n\tfinal int rank(final\
    \ long x, int r) {\n\t\tint l = 0;\n\t\tfor(int level = log; --level >= 0;) {\n\
    \t\t\tfinal IntPair p = succ(((x >> level) & 1) == 1, l, r, level);\n\t\t\tl =\
    \ p.first.intValue();\n\t\t\tr = p.second.intValue();\n\t\t}\n\t\treturn r - l;\n\
    \t}\n\tfinal long kthMin(int l, int r, int k) {\n\t\tif(!Utility.scope(0, k, r\
    \ - l - 1)) {\n\t\t\tthrow new IndexOutOfBoundsException();\n\t\t}\n\t\tlong ret\
    \ = 0;\n\t\tfor(int level = log; --level >= 0;) {\n\t\t\tfinal int cnt = matrix[level].rank(false,\
    \ r) - matrix[level].rank(false, l);\n\t\t\tfinal boolean f = cnt <= k;\n\t\t\t\
    if(f) {\n\t\t\t\tret |= 1 << level;\n\t\t\t\tk -= cnt;\n\t\t\t}\n\t\t\tfinal IntPair\
    \ p = succ(f, l, r, level);\n\t\t\tl = p.first.intValue();\n\t\t\tr = p.second.intValue();\n\
    \t\t}\n\t\treturn ret;\n\t}\n\tfinal long kthMax(final int l, final int r, final\
    \ int k){ return kthMin(l, r, r - l - k - 1); }\n\tfinal int rangeFreq(int l,\
    \ int r, final long upper) {\n\t\tint ret = 0;\n\t\tfor(int level = log; --level\
    \ >= 0;) {\n\t\t\tfinal boolean f = ((upper >> level) & 1) == 1;\n\t\t\tif(f)\
    \ {\n\t\t\t\tret += matrix[level].rank(false, r) - matrix[level].rank(false, l);\n\
    \t\t\t}\n\t\t\tfinal IntPair p = succ(f, l, r, level); \n\t\t\tl = p.first.intValue();\n\
    \t\t\tr = p.second.intValue();\n\t\t}\n\t\treturn ret;\n\t}\n\tfinal int rangeFreq(final\
    \ int l, final int r, final long lower, final long upper){ return rangeFreq(l,\
    \ r, upper) - rangeFreq(l, r, lower); }\n\tfinal long prev(final int l, final\
    \ int r, final long upper) {\n\t\tfinal int cnt = rangeFreq(l, r, upper);\n\t\t\
    return cnt == 0 ? -1 : kthMin(l, r, cnt - 1);\n\t}\n\tfinal long next(final int\
    \ l, final int r, final long lower) {\n\t\tfinal int cnt = rangeFreq(l, r, lower);\n\
    \t\treturn cnt == r - l ? -1 : kthMin(l, r, cnt);\n\t}\n}\nfinal class WaveletMatrix\
    \ {\n\tprivate final WaveletMatrixBeta mat;\n\tprivate final long[] ys;\n\tWaveletMatrix(final\
    \ long[] arr, final int log) {\n\t\tys = Arrays.stream(arr).sorted().distinct().toArray();\n\
    \t\tfinal long[] t = new long[arr.length];\n\t\tIntStream.range(0, arr.length).forEach(i\
    \ -> t[i] = get(arr[i]));\n\t\tmat = new WaveletMatrixBeta(t, log);\n\t}\n\tprivate\
    \ final int get(final long x){ return Utility.lowerBound(ys, x); }\n\tfinal long\
    \ access(final int k){ return ys[(int) mat.access(k)]; }\n\tfinal int rank(final\
    \ long x, final int r) {\n\t\tfinal int pos = get(x);\n\t\tif(pos == ys.length\
    \ || ys[pos] != x) {\n\t\t\treturn 0;\n\t\t}\n\t\treturn mat.rank(pos, r);\n\t\
    }\n\tfinal long kthMin(final int l, final int r, final int k){ return ys[(int)\
    \ mat.kthMin(l, r, k)]; }\n\tfinal long kthMax(final int l, final int r, final\
    \ int k){ return ys[(int) mat.kthMax(l, r, k)]; }\n\tfinal int rangeFreq(final\
    \ int l, final int r, final long upper){ return mat.rangeFreq(l, r, get(upper));\
    \ }\n\tfinal int rangeFreq(final int l, final int r, final long lower, final long\
    \ upper){ return mat.rangeFreq(l, r, get(lower), get(upper)); }\n\tfinal long\
    \ prev(final int l, final int r, final long upper) {\n\t\tfinal long ret = mat.prev(l,\
    \ r, get(upper));\n\t\treturn ret == -1 ? -1 : ys[(int) ret];\n\t}\n\tfinal long\
    \ next(final int l, final int r, final long lower) {\n\t\tfinal long ret = mat.next(l,\
    \ r, get(lower));\n\t\treturn ret == -1 ? -1 : ys[(int) ret];\n\t}\n}"
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
  path: Java/extension/WaveletMatrix.java
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
  - Java/extension/WeightedUnionFind.java
  - Java/extension/UndoUnionFind.java
  - Java/extension/LargePrime.java
  - Java/extension/FenwickTree.java
  - Java/extension/SuffixArray.java
  - Java/extension/AVLTree.java
  - Java/extension/Graph.java
  - Java/extension/Template.java
  - Java/all.java
  timestamp: '2024-01-06 02:41:32+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: Java/extension/WaveletMatrix.java
layout: document
redirect_from:
- /library/Java/extension/WaveletMatrix.java
- /library/Java/extension/WaveletMatrix.java.html
title: Java/extension/WaveletMatrix.java
---
