---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: Java/all.java
    title: Java/all.java
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
    path: Java/extension/WeightedUnionFind.java
    title: Java/extension/WeightedUnionFind.java
  _extendedRequiredBy:
  - icon: ':warning:'
    path: Java/all.java
    title: Java/all.java
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
    RuntimeError: bundler is not specified: Java/extension/Pair.java\n"
  code: "package extension;\n\nclass Pair<F, S> {\n\tprotected final F first;\n\t\
    protected final S second;\n\tPair(final F first, final S second) {\n\t\tthis.first\
    \ = first;\n\t\tthis.second = second;\n\t}\n\t@Override\n\tpublic boolean equals(final\
    \ Object o) {\n\t\tif(this == o) {\n\t\t\treturn true;\n\t\t}\n\t\tif(o == null\
    \ || getClass() != o.getClass()) {\n\t\t\treturn false;\n\t\t}\n\t\tfinal Pair<?,\
    \ ?> p = (Pair<?, ?>) o;\n\t\tif(!first.equals(p.first)) {\n\t\t\treturn false;\n\
    \t\t}\n\t\treturn second.equals(p.second);\n\t}\n\t@Override\n\tpublic int hashCode(){\
    \ return 31 * first.hashCode() + second.hashCode(); }\n\t@Override\n\tpublic String\
    \ toString(){ return \"(\" + first + \", \" + second + \")\"; }\n\tpublic static\
    \ <F, S> Pair<F, S> of(final F a, final S b){ return new Pair<>(a, b); }\n\tPair<S,\
    \ F> swap(){ return Pair.of(second, first); }\n}\nclass NumPair extends Pair<Number,\
    \ Number> implements Comparable<NumPair>  {\n\tNumPair(final Number first, final\
    \ Number second){ super(first, second); }\n\tNumPair rotate(){ return new NumPair(-second.doubleValue(),\
    \ first.doubleValue()); } \n\tNumPair rotate(final int ang) {\n\t\tfinal double\
    \ rad = Math.toRadians(Utility.mod(ang, 360));\n\t\treturn new NumPair(first.doubleValue()\
    \ * Math.cos(rad) - second.doubleValue() * Math.sin(rad),\n\t\t\t\t\t\t\tfirst.doubleValue()\
    \ * Math.sin(rad) + second.doubleValue() * Math.cos(rad));\n\t}\n\tlong dot(final\
    \ NumPair p){ return first.longValue() * p.first.longValue() + second.longValue()\
    \ + p.second.longValue(); }\n\tdouble dotf(final NumPair p){ return first.doubleValue()\
    \ * p.first.doubleValue() + second.doubleValue() + p.second.doubleValue(); }\n\
    \tlong cross(final NumPair p){ return this.rotate().dot(p); }\n\tdouble crossf(final\
    \ NumPair p){ return this.rotate().dotf(p); }\n\tlong sqr(){ return this.dot(this);\
    \ }\n\tdouble sqrf(){ return this.dotf(this); }\n\tdouble grad() { \n\t\ttry {\n\
    \t\t\treturn second.doubleValue() / first.doubleValue();\n\t\t} catch(ArithmeticException\
    \ e) {\n\t\t\te.printStackTrace();\n\t\t}\n\t\treturn Double.NaN;\n\t}\n\tdouble\
    \ abs(){ return Math.hypot(first.doubleValue(), second.doubleValue()); }\n\tlong\
    \ lcm(){ return Utility.lcm(first.longValue(), second.longValue()); }\n\tlong\
    \ gcd(){ return Utility.gcd(first.longValue(), second.longValue()); }\n\tNumPair\
    \ extgcd() {\n\t\tlong x = 1, y = 0, t1 = 0, t2 = 0, t3 = 1, a = first.longValue(),\
    \ b = second.longValue();\n\t\twhile(b > 0) {\n\t\t\tt1 = a / b;\n\t\t\ta -= t1\
    \ * b;\n\t\t\ta ^= b;\n\t\t\tb ^= a;\n\t\t\ta ^= b;\n\t\t\tx -= t1 * t2;\n\t\t\
    \tx ^= t2;\n\t\t\tt2 ^= x;\n\t\t\tx ^= t2;\n\t\t\ty -= t1 * t3;\n\t\t\ty ^= t3;\n\
    \t\t\tt3 ^= y;\n\t\t\ty ^= t3;\n\t\t}\n\t\treturn new NumPair(x, y);\n\t}\n\t\
    @Override\n\tpublic int compareTo(final NumPair o) {\n\t\tif(first.doubleValue()\
    \ == o.first.doubleValue()) {\n\t\t\treturn Double.compare(second.doubleValue(),\
    \ o.second.doubleValue());\n\t\t}\n\t\treturn Double.compare(first.doubleValue(),\
    \ o.first.doubleValue());\n\t}\n}"
  dependsOn:
  - Java/extension/MyScanner.java
  - Java/extension/LowestCommonAncestor.java
  - Java/extension/WeightedUnionFind.java
  - Java/extension/FenwickTree.java
  - Java/extension/MyPrinter.java
  - Java/extension/PrefixSum.java
  - Java/extension/UnionFind.java
  - Java/extension/SuffixArray.java
  - Java/extension/LargePrime.java
  - Java/extension/SparseTable.java
  - Java/extension/PrimeTable.java
  - Java/extension/Graph.java
  - Java/extension/PrimeFactor.java
  - Java/extension/PrimeCounter.java
  - Java/extension/SegmentTree.java
  - Java/extension/UndoUnionFind.java
  - Java/extension/Template.java
  - Java/all.java
  isVerificationFile: false
  path: Java/extension/Pair.java
  requiredBy:
  - Java/extension/MyScanner.java
  - Java/extension/LowestCommonAncestor.java
  - Java/extension/WeightedUnionFind.java
  - Java/extension/FenwickTree.java
  - Java/extension/MyPrinter.java
  - Java/extension/PrefixSum.java
  - Java/extension/UnionFind.java
  - Java/extension/SuffixArray.java
  - Java/extension/LargePrime.java
  - Java/extension/SparseTable.java
  - Java/extension/PrimeTable.java
  - Java/extension/Graph.java
  - Java/extension/PrimeFactor.java
  - Java/extension/PrimeCounter.java
  - Java/extension/SegmentTree.java
  - Java/extension/UndoUnionFind.java
  - Java/extension/Template.java
  - Java/all.java
  timestamp: '2023-12-03 20:12:57+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: Java/extension/Pair.java
layout: document
redirect_from:
- /library/Java/extension/Pair.java
- /library/Java/extension/Pair.java.html
title: Java/extension/Pair.java
---
