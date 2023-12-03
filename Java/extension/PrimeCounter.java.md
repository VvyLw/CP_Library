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
    RuntimeError: bundler is not specified: Java/extension/PrimeCounter.java\n"
  code: "package extension;\n\nimport java.util.ArrayList;\n\nclass PrimeCounter {\n\
    \tprivate int sq;\n\tprivate boolean[] p;\n\tprivate int[] psum;\n\tprivate ArrayList<Integer>\
    \ ps;\n\tPrimeCounter(final long lim) {\n\t\tsq = (int) kthRooti(lim, 2);\n\t\t\
    psum = new int[sq + 1];\n\t\tp = new PrimeTable(sq).table();\n\t\tfor(int i =\
    \ 1; i <= sq; ++i) {\n\t\t\tpsum[i] = psum[i - 1] + (p[i] ? 1 : 0);\n\t\t}\n\t\
    \tps = new ArrayList<>();\n\t\tfor(int i = 1; i <= sq; ++i) {\n\t\t\tif(p[i])\
    \ {\n\t\t\t\tps.add(i);\n\t\t\t}\n\t\t}\n\t}\n\tprivate long kthRooti(final long\
    \ n, final int k){ return Utility.kthRoot(n, k); }\n\tprivate long p2(final long\
    \ x, final long y) {\n\t\tif(x < 4) {\n\t\t\treturn 0;\n\t\t}\n\t\tfinal long\
    \ a = pi(y);\n\t\tfinal long b = pi(kthRooti(x, 2));\n\t\tif(a >= b) {\n\t\t\t\
    return 0;\n\t\t}\n\t\tlong sum = (long) (a - 2) * (a + 1) / 2 - (b - 2) * (b +\
    \ 1) / 2;\n\t\tfor(long i = a; i < b; ++i) {\n\t\t\tsum += pi(x / ps.get((int)\
    \ i));\n\t\t}\n\t\treturn sum;\n\t}\n\tprivate long phi(final long m, final long\
    \ a) {\n\t\tif(m < 1) {\n\t\t\treturn 0;\n\t\t}\n\t\tif(a > m) {\n\t\t\treturn\
    \ 1;\n\t\t}\n\t\tif(a < 1) {\n\t\t\treturn m;\n\t\t}\n\t\tif(m <= (long) ps.get((int)\
    \ (a - 1)) * ps.get((int) (a - 1))) {\n\t\t\treturn pi(m) - a + 1;\n\t\t}\n\t\t\
    if(m <= (long) ps.get((int) (a - 1)) * ps.get((int) (a - 1)) * ps.get((int) (a\
    \ - 1)) && m <= sq) {\n\t\t\tfinal long sx = pi(kthRooti(m, 2));\n\t\t\tlong ans\
    \ = pi(m) - (long) (sx + a - 2) * (sx - a + 1) / 2;\n\t\t\tfor(long i = a; i <\
    \ sx; ++i) {\n\t\t\t\tans += pi(m / ps.get((int) i));\n\t\t\t}\n\t\t\treturn ans;\n\
    \t\t}\n\t\treturn phi(m, a - 1) - phi(m / ps.get((int) (a - 1)), a - 1);\n\t}\n\
    \tlong pi(final long n) {\n\t\tif(n <= sq) {\n\t\t\treturn psum[(int) n];\n\t\t\
    }\n\t\tfinal long m = kthRooti(n, 3);\n\t\tfinal long a = pi(m);\n\t\treturn phi(n,\
    \ a) + a - 1 - p2(n, m);\n\t}\n}"
  dependsOn:
  - Java/extension/MyScanner.java
  - Java/extension/LowestCommonAncestor.java
  - Java/extension/WeightedUnionFind.java
  - Java/extension/FenwickTree.java
  - Java/extension/Pair.java
  - Java/extension/MyPrinter.java
  - Java/extension/PrefixSum.java
  - Java/extension/UnionFind.java
  - Java/extension/SuffixArray.java
  - Java/extension/LargePrime.java
  - Java/extension/DoubleEndedPriorityQueue.java
  - Java/extension/SparseTable.java
  - Java/extension/PrimeTable.java
  - Java/extension/Graph.java
  - Java/extension/PrimeFactor.java
  - Java/extension/SegmentTree.java
  - Java/extension/UndoUnionFind.java
  - Java/extension/Template.java
  - Java/all.java
  isVerificationFile: false
  path: Java/extension/PrimeCounter.java
  requiredBy:
  - Java/extension/MyScanner.java
  - Java/extension/LowestCommonAncestor.java
  - Java/extension/WeightedUnionFind.java
  - Java/extension/FenwickTree.java
  - Java/extension/Pair.java
  - Java/extension/MyPrinter.java
  - Java/extension/PrefixSum.java
  - Java/extension/UnionFind.java
  - Java/extension/SuffixArray.java
  - Java/extension/LargePrime.java
  - Java/extension/DoubleEndedPriorityQueue.java
  - Java/extension/SparseTable.java
  - Java/extension/PrimeTable.java
  - Java/extension/Graph.java
  - Java/extension/PrimeFactor.java
  - Java/extension/SegmentTree.java
  - Java/extension/UndoUnionFind.java
  - Java/extension/Template.java
  - Java/all.java
  timestamp: '2023-12-03 23:57:21+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: Java/extension/PrimeCounter.java
layout: document
redirect_from:
- /library/Java/extension/PrimeCounter.java
- /library/Java/extension/PrimeCounter.java.html
title: Java/extension/PrimeCounter.java
---
