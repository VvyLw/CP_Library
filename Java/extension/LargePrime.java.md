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
    RuntimeError: bundler is not specified: Java/extension/LargePrime.java\n"
  code: "package extension;\n\nimport java.math.BigInteger;\nimport java.util.ArrayList;\n\
    import java.util.Arrays;\nimport java.util.Collections;\nimport java.util.function.BiFunction;\n\
    import java.util.function.LongBinaryOperator;\n\n// N <= 1e18;\nfinal class LongPrime\
    \ {\n\tprivate final int bsf(final long x){ return Long.numberOfTrailingZeros(x);\
    \ }\n\tprivate final long gcd(long a, long b) {\n\t\ta = Math.abs(a);\n\t\tb =\
    \ Math.abs(b);\n\t\tif(a == 0) {\n\t\t\treturn b;\n\t\t}\n\t\tif(b == 0) {\n\t\
    \t\treturn a;\n\t\t}\n\t\tfinal int shift = bsf(a|b);\n\t\ta >>= bsf(a);\n\t\t\
    do {\n\t\t\tb >>= bsf(b);\n\t\t\tif(a > b) {\n\t\t\t\ta ^= b;\n\t\t\t\tb ^= a;\n\
    \t\t\t\ta ^= b;\n\t\t\t}\n\t\t\tb -= a;\n\t\t} while(b > 0);\n\t\treturn a <<\
    \ shift;\n\t}\n\tfinal boolean isPrime(final long n) {\n\t\tif(n <= 1) {\n\t\t\
    \treturn false;\n\t\t}\n\t\tif(n == 2) {\n\t\t\treturn true;\n\t\t}\n\t\tif(n\
    \ % 2 == 0) {\n\t\t\treturn false;\n\t\t}\n\t\tlong d = n - 1;\n\t\twhile(d %\
    \ 2 == 0) {\n\t\t\td /= 2;\n\t\t}\n\t\tfinal long[] sample = {2, 3, 5, 7, 11,\
    \ 13, 17, 19, 23, 29, 31, 37};\n\t\tfor(final long a: sample) {\n\t\t\tif(n <=\
    \ a) {\n\t\t\t\tbreak;\n\t\t\t}\n\t\t\tlong t = d;\n\t\t\tBigInteger y = BigInteger.valueOf(a).modPow(BigInteger.valueOf(t),\
    \ BigInteger.valueOf(n));\n\t\t\twhile(t != n - 1 && !y.equals(BigInteger.ONE)\
    \ && !y.equals(BigInteger.valueOf(n).subtract(BigInteger.ONE))) {\n\t\t\t\ty =\
    \ y.multiply(y).mod(BigInteger.valueOf(n));\n\t\t\t\tt <<= 1;\n\t\t\t}\n\t\t\t\
    if(!y.equals(BigInteger.valueOf(n).subtract(BigInteger.ONE)) && t % 2 == 0) {\n\
    \t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t\treturn true;\n\t}\n\tfinal private\
    \ long find(final long n) {\n\t\tif(isPrime(n)) {\n\t\t\treturn n;\n\t\t}\n\t\t\
    if(n % 2 == 0) {\n\t\t\treturn 2;\n\t\t}\n\t\tlong st = 0;\n\t\tfinal LongBinaryOperator\
    \ f = (x, y) -> { return BigInteger.valueOf(x).multiply(BigInteger.valueOf(x)).add(BigInteger.valueOf(y)).mod(BigInteger.valueOf(n)).longValue();\
    \ };\n\t\twhile(true) {\n\t\t\tst++;\n\t\t\tlong x = st, y = f.applyAsLong(x,\
    \ st);\n\t\t\twhile(true) {\n\t\t\t\tfinal long p = gcd(y - x + n, n);\n\t\t\t\
    \tif(p == 0 || p == n) {\n\t\t\t\t\tbreak;\n\t\t\t\t}\n\t\t\t\tif(p != 1) {\n\t\
    \t\t\t\treturn p;\n\t\t\t\t}\n\t\t\t\tx = f.applyAsLong(x, st);\n\t\t\t\ty = f.applyAsLong(f.applyAsLong(y,\
    \ st), st);\n\t\t\t}\n\t\t}\n\t}\n\tfinal ArrayList<Long> primeFactor(final long\
    \ n) {\n\t\tif(n == 1) return new ArrayList<>();\n\t\tfinal long x = find(n);\n\
    \t\tif(x == n) return new ArrayList<>(Arrays.asList(x));\n\t\tArrayList<Long>\
    \ l = primeFactor(x);\n\t\tfinal ArrayList<Long> r = primeFactor(n / x);\n\t\t\
    l.addAll(r);\n\t\tCollections.sort(l);\n\t\treturn l;\n\t}\n}\n// N > 1e18\nfinal\
    \ class BigPrime {\n\tprotected final int bsf(final long x){ return Long.numberOfTrailingZeros(x);\
    \ }\n\tprivate final BigInteger gcd(BigInteger a, BigInteger b) {\n\t\ta = a.abs();\n\
    \t\tb = b.abs();\n\t\tif(a.equals(BigInteger.ZERO)) {\n\t\t\treturn b;\n\t\t}\n\
    \t\tif(b.equals(BigInteger.ZERO)) {\n\t\t\treturn a;\n\t\t}\n\t\tfinal int shift\
    \ = bsf(a.or(b).longValue());\n\t\ta = a.shiftRight(bsf(a.longValue()));\n\t\t\
    do {\n\t\t\tb = b.shiftRight(bsf(b.longValue()));\n\t\t\tif(a.compareTo(b) > 0)\
    \ {\n\t\t\t\tfinal var tmp = b;\n\t\t\t\tb = a;\n\t\t\t\ta = tmp;\n\t\t\t}\n\t\
    \t\tb = b.subtract(a);\n\t\t} while(b.compareTo(BigInteger.ZERO) > 0);\n\t\treturn\
    \ a.shiftLeft(shift);\n\t}\n\tfinal boolean isPrime(final BigInteger n) {\n\t\t\
    if(n.compareTo(BigInteger.ONE) <= 0) {\n\t\t\treturn false;\n\t\t}\n\t\tif(n.equals(BigInteger.TWO))\
    \ {\n\t\t\treturn true;\n\t\t}\n\t\tif(n.and(BigInteger.ONE).equals(BigInteger.valueOf(0)))\
    \ {\n\t\t\treturn false;\n\t\t}\n\t\tBigInteger d = n.subtract(BigInteger.ONE);\n\
    \t\twhile(d.and(BigInteger.ONE).equals(BigInteger.valueOf(0))) {\n\t\t\td = d.shiftRight(1);\n\
    \t\t}\n\t\tfinal long[] sample = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};\n\
    \t\tfor(final long a: sample) {\n\t\t\tif(n.compareTo(BigInteger.valueOf(a)) <=\
    \ 0) {\n\t\t\t\tbreak;\n\t\t\t}\n\t\t\tBigInteger t = d;\n\t\t\tBigInteger y =\
    \ BigInteger.valueOf(a).modPow(t, n);\n\t\t\twhile(!t.equals(n.subtract(BigInteger.ONE))\
    \ && !y.equals(BigInteger.ONE) && !y.equals(n.subtract(BigInteger.ONE))) {\n\t\
    \t\t\ty = y.multiply(y).mod(n);\n\t\t\t\tt = t.shiftLeft(1);\n\t\t\t}\n\t\t\t\
    if(!y.equals(n.subtract(BigInteger.ONE)) && t.and(BigInteger.ONE).equals(BigInteger.ZERO))\
    \ {\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t\treturn true;\n\t}\n\tprivate final\
    \ BigInteger find(final BigInteger n) {\n\t\tif(isPrime(n)) {\n\t\t\treturn n;\n\
    \t\t}\n\t\tif(n.and(BigInteger.ONE).equals(BigInteger.ZERO)) {\n\t\t\treturn BigInteger.TWO;\n\
    \t\t}\n\t\tint st = 0;\n\t\tfinal BiFunction<BigInteger, Integer, BigInteger>\
    \ f = (x, y) -> { return x.multiply(x).add(BigInteger.valueOf(y)).mod(n); };\n\
    \t\twhile(true) {\n\t\t\tst++;\n\t\t\tBigInteger x = BigInteger.valueOf(st), y\
    \ = f.apply(x, st);\n\t\t\twhile(true) {\n\t\t\t\tfinal BigInteger p = gcd(y.subtract(x).add(n),\
    \ n);\n\t\t\t\tif(p.equals(BigInteger.ZERO) || p.equals(n)) {\n\t\t\t\t\tbreak;\n\
    \t\t\t\t}\n\t\t\t\tif(!p.equals(BigInteger.ONE)) {\n\t\t\t\t\treturn p;\n\t\t\t\
    \t}\n\t\t\t\tx = f.apply(x, st);\n\t\t\t\ty = f.apply(f.apply(y, st), st);\n\t\
    \t\t}\n\t\t}\n\t}\n\tfinal ArrayList<BigInteger> primeFactor(final BigInteger\
    \ n) {\n\t\tif(n.equals(BigInteger.ONE)) {\n\t\t\treturn new ArrayList<>();\n\t\
    \t}\n\t\tfinal BigInteger x = find(n);\n\t\tif(x.equals(n)) {\n\t\t\treturn new\
    \ ArrayList<>(Arrays.asList(x));\n\t\t}\n\t\tvar l = primeFactor(x);\n\t\tfinal\
    \ var r = primeFactor(n.divide(x));\n\t\tl.addAll(r);\n\t\tCollections.sort(l);\n\
    \t\treturn l;\n\t}\n}"
  dependsOn:
  - Java/extension/SparseTable.java
  - Java/extension/PrimeCounter.java
  - Java/extension/PrefixSum.java
  - Java/extension/SegmentTree.java
  - Java/extension/DoubleEndedPriorityQueue.java
  - Java/extension/WeightedGraph.java
  - Java/extension/PrimeFactor.java
  - Java/extension/UnionFind.java
  - Java/extension/EulerPhiTable.java
  - Java/extension/PrimeTable.java
  - Java/extension/Huitloxopetl.java
  - Java/extension/LowestCommonAncestor.java
  - Java/extension/WaveletMatrix.java
  - Java/extension/WeightedUnionFind.java
  - Java/extension/UndoUnionFind.java
  - Java/extension/FenwickTree.java
  - Java/extension/SuffixArray.java
  - Java/extension/Graph.java
  - Java/extension/Template.java
  - Java/all.java
  isVerificationFile: false
  path: Java/extension/LargePrime.java
  requiredBy:
  - Java/extension/SparseTable.java
  - Java/extension/PrimeCounter.java
  - Java/extension/PrefixSum.java
  - Java/extension/SegmentTree.java
  - Java/extension/DoubleEndedPriorityQueue.java
  - Java/extension/WeightedGraph.java
  - Java/extension/PrimeFactor.java
  - Java/extension/UnionFind.java
  - Java/extension/EulerPhiTable.java
  - Java/extension/PrimeTable.java
  - Java/extension/Huitloxopetl.java
  - Java/extension/LowestCommonAncestor.java
  - Java/extension/WaveletMatrix.java
  - Java/extension/WeightedUnionFind.java
  - Java/extension/UndoUnionFind.java
  - Java/extension/FenwickTree.java
  - Java/extension/SuffixArray.java
  - Java/extension/Graph.java
  - Java/extension/Template.java
  - Java/all.java
  timestamp: '2023-12-19 01:42:15+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: Java/extension/LargePrime.java
layout: document
redirect_from:
- /library/Java/extension/LargePrime.java
- /library/Java/extension/LargePrime.java.html
title: Java/extension/LargePrime.java
---
