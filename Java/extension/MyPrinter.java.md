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
    path: Java/extension/Graph.java
    title: Java/extension/Graph.java
  - icon: ':warning:'
    path: Java/extension/LargePrime.java
    title: Java/extension/LargePrime.java
  - icon: ':warning:'
    path: Java/extension/LowestCommonAncestor.java
    title: Java/extension/LowestCommonAncestor.java
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
    RuntimeError: bundler is not specified: Java/extension/MyPrinter.java\n"
  code: "package extension;\n\nimport java.io.OutputStream;\nimport java.io.PrintWriter;\n\
    import java.util.Arrays;\nimport java.util.Collection;\nimport java.util.List;\n\
    import java.util.stream.IntStream;\n\nfinal class MyPrinter {\n\tprivate final\
    \ PrintWriter pw;\n\tMyPrinter(final OutputStream os, final boolean flush){ pw\
    \ = new PrintWriter(os, flush); }\n\tfinal void print(final Object arg){ pw.print(arg);\
    \ }\n\tfinal void out(){ pw.println(); }\n\tfinal void out(final Object head,\
    \ final Object... tail) {\n\t\tpw.print(head);\n\t\tfor(final var el: tail) {\n\
    \t\t\tpw.print(\" \" + el);\n\t\t}\n\t\tout();\n\t}\n\tfinal <F, S> void out(final\
    \ Pair<F, S> arg){ pw.println(arg.first + \" \" + arg.second); }\n\tfinal void\
    \ out(final int[] args){ IntStream.range(0, args.length).forEach(i -> pw.print(args[i]\
    \ + (i + 1 < args.length ? \" \" : \"\\n\"))); }\n\tfinal void out(final long[]\
    \ args){ IntStream.range(0, args.length).forEach(i -> pw.print(args[i] + (i +\
    \ 1 < args.length ? \" \" : \"\\n\"))); }\n\tfinal void out(final double[] args){\
    \ IntStream.range(0, args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length\
    \ ? \" \" : \"\\n\"))); }\n\tfinal void out(final boolean[] args){ IntStream.range(0,\
    \ args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length ? \" \" :\
    \ \"\\n\"))); }\n\tfinal void out(final char[] args){ IntStream.range(0, args.length).forEach(i\
    \ -> pw.print(args[i] + (i + 1 < args.length ? \" \" : \"\\n\"))); }\n\tfinal\
    \ void out(final Object[] args){ IntStream.range(0, args.length).forEach(i ->\
    \ pw.print(args[i] + (i + 1 < args.length ? \" \" : \"\\n\"))); }\n\tfinal <T>\
    \ void out(final List<T> args){ IntStream.range(0, args.size()).forEach(i -> pw.print(args.get(i)\
    \ + (i + 1 < args.size() ? \" \" : \"\\n\"))); }\n\tfinal void outl(final Object\
    \ head, final Object... tail) {\n\t\tout(head);\n\t\tArrays.stream(tail).forEach(pw::println);\n\
    \t}\n\tfinal void outl(final int[] args){ Arrays.stream(args).forEach(pw::println);\
    \ }\n\tfinal void outl(final int[][] args){ IntStream.range(0, args.length).forEach(i\
    \ -> out(args[i])); }\n\tfinal void outl(final long[] args){ Arrays.stream(args).forEach(pw::println);\
    \ }\n\tfinal void outl(final long[][] args){ IntStream.range(0, args.length).forEach(i\
    \ -> out(args[i])); }\n\tfinal void outl(final double[] args){ Arrays.stream(args).forEach(pw::println);\
    \ }\n\tfinal void outl(final double[][] args){ IntStream.range(0, args.length).forEach(i\
    \ -> out(args[i])); }\n\tfinal void outl(final boolean[] args){ IntStream.range(0,\
    \ args.length).forEach(i -> out(args[i])); }\n\tfinal void outl(final boolean[][]\
    \ args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }\n\tfinal\
    \ void outl(final char[] args){ IntStream.range(0, args.length).forEach(i -> out(args[i]));\
    \ }\n\tfinal void outl(final Object[] args){ Arrays.stream(args).forEach(pw::println);\
    \ }\n\tfinal <E> void outl(final Collection<E> args){ args.stream().forEach(pw::println);\
    \ }\n\tfinal void fin(final Object head, final Object... tail) {\n\t\tout(head,\
    \ tail);\n\t\tflush();\n\t\tSystem.exit(0);\n\t}\n\tfinal <T> void fin(final List<T>\
    \ args) {\n\t\tout(args);\n\t\tflush();\n\t\tSystem.exit(0);\n\t}\n\tfinal <E>\
    \ void fine(final Collection<E> args) {\n\t\toutl(args);\n\t\tflush();\n\t\tSystem.exit(0);\n\
    \t}\n\tfinal void flush(){ pw.flush(); }\n\tfinal void close(){ pw.close(); }\n\
    }"
  dependsOn:
  - Java/extension/MyScanner.java
  - Java/extension/LowestCommonAncestor.java
  - Java/extension/WeightedUnionFind.java
  - Java/extension/FenwickTree.java
  - Java/extension/Pair.java
  - Java/extension/WaveletMatrix.java
  - Java/extension/PrefixSum.java
  - Java/extension/UnionFind.java
  - Java/extension/SuffixArray.java
  - Java/extension/LargePrime.java
  - Java/extension/DoubleEndedPriorityQueue.java
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
  path: Java/extension/MyPrinter.java
  requiredBy:
  - Java/extension/MyScanner.java
  - Java/extension/LowestCommonAncestor.java
  - Java/extension/WeightedUnionFind.java
  - Java/extension/FenwickTree.java
  - Java/extension/Pair.java
  - Java/extension/WaveletMatrix.java
  - Java/extension/PrefixSum.java
  - Java/extension/UnionFind.java
  - Java/extension/SuffixArray.java
  - Java/extension/LargePrime.java
  - Java/extension/DoubleEndedPriorityQueue.java
  - Java/extension/SparseTable.java
  - Java/extension/PrimeTable.java
  - Java/extension/Graph.java
  - Java/extension/PrimeFactor.java
  - Java/extension/PrimeCounter.java
  - Java/extension/SegmentTree.java
  - Java/extension/UndoUnionFind.java
  - Java/extension/Template.java
  - Java/all.java
  timestamp: '2023-12-06 01:59:37+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: Java/extension/MyPrinter.java
layout: document
redirect_from:
- /library/Java/extension/MyPrinter.java
- /library/Java/extension/MyPrinter.java.html
title: Java/extension/MyPrinter.java
---
