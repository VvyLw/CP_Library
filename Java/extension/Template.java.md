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
    path: Java/extension/Graph.java
    title: Java/extension/Graph.java
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
    path: Java/extension/Graph.java
    title: Java/extension/Graph.java
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
    RuntimeError: bundler is not specified: Java/extension/Template.java\n"
  code: "package extension;\n\nimport java.io.OutputStream;\nimport java.io.PrintWriter;\n\
    import java.util.ArrayList;\nimport java.util.Arrays;\nimport java.util.Collection;\n\
    import java.util.Collections;\nimport java.util.List;\nimport java.util.Scanner;\n\
    import java.util.function.Predicate;\nimport java.util.stream.Collectors;\nimport\
    \ java.util.stream.IntStream;\n\nclass VvyLw extends Utility {\n\tprotected static\
    \ final MyScanner sc = new MyScanner();\n\tprotected static final MyPrinter o\
    \ = new MyPrinter(System.out, false);\n\tprotected static final MyPrinter e =\
    \ new MyPrinter(System.err, true);\n\tstatic final int[] dx = {0, -1, 1, 0, 0,\
    \ -1, -1, 1, 1};\n\tstatic final int[] dy = {0, 0, 0, -1, 1, -1, 1, -1, 1};\n\t\
    static final int inf = 1 << 30;\n\tstatic final long linf = (1L << 61) - 1;\n\t\
    static final int mod998 = 998244353;\n\tstatic final int mod107 = (int)1e9 + 7;\n\
    \tstatic final double eps = 1e-18;\n\tprotected static final void solve() {\n\t\
    \t\n\t}\n}\nfinal class Main extends VvyLw {\n\tpublic static void main(final\
    \ String[] args) {\n\t\tint t = 1;\n\t\t//t = sc.ni();\n\t\twhile(t-- > 0) {\n\
    \t\t\tsolve();\n\t\t}\n\t\to.flush();\n\t\tsc.close();\n\t\to.close();\n\t\te.close();\n\
    \t}\n}\n\nclass Utility {\n\tprotected static final String yes(final boolean ok){\
    \ return ok ? \"Yes\" : \"No\"; }\n\tprotected static final String no(final boolean\
    \ ok){ return yes(!ok); }\n\tprotected static final long sqr(final long x){ return\
    \ x * x; }\n\tprotected static final int mod(final long n, final int m){ return\
    \ (int) ((n + m) % m); }\n\tprotected static final long ceil(final long a, final\
    \ long b){ return (long) Math.ceil((double) a / b); }\n\tprotected static final\
    \ double round(final double a, final long b, final int c) {\n\t\tfinal long d\
    \ = intPow(10, c);\n\t\treturn (double) Math.round((a * d) / b) / d;\n\t}\n\t\
    protected static final long intPow(long a, int b) {\n\t\tlong res = 1;\n\t\twhile(b\
    \ > 0) {\n\t\t\tif(b % 2 == 1) {\n\t\t\t\tres *= a;\n\t\t\t}\n\t\t\ta *= a;\n\t\
    \t\tb >>= 1;\n\t\t}\n\t\treturn res;\n\t}\n\tprotected static final long intPow(long\
    \ a, long b, final int m) {\n\t\tlong res = 1;\n\t\twhile(b > 0) {\n\t\t\tif(b\
    \ % 2 == 1) {\n\t\t\t\tres *= a;\n\t\t\t\tres = mod(res, m);\n\t\t\t}\n\t\t\t\
    a *= a;\n\t\t\ta = mod(a, m);\n\t\t\tb >>= 1;\n\t\t}\n\t\treturn res;\n\t}\n\t\
    protected static final ArrayList<Long> div(final long n) {\n\t\tArrayList<Long>\
    \ d = new ArrayList<>();\n\t\tfor(long i = 1; i * i <= n; ++i) {\n\t\t\tif(n %\
    \ i == 0) {\n\t\t\t\td.add(i);\n\t\t\t\tif(i * i != n) {\n\t\t\t\t\td.add(n /\
    \ i);\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tCollections.sort(d);\n\t\treturn d;\n\t\
    }\n\tprotected static final ArrayList<Pair<Long, Integer>> primeFactor(long n)\
    \ {\n\t\tArrayList<Pair<Long, Integer>> pf = new ArrayList<>();\n\t\tfor(long\
    \ i = 2; i * i <= n; ++i) {\n\t\t\tif(n % i != 0) {\n\t\t\t\tcontinue;\n\t\t\t\
    }\n\t\t\tint cnt = 0;\n\t\t\twhile(n % i == 0) {\n\t\t\t\tcnt++;\n\t\t\t\tn /=\
    \ i;\n\t\t\t}\n\t\t\tpf.add(Pair.of(i, cnt));\n\t\t}\n\t\tif(n != 1) {\n\t\t\t\
    pf.add(Pair.of(n, 1));\n\t\t}\n\t\treturn pf;\n\t}\n\tprotected static final long\
    \ binom(int a, final int b) {\n\t\tlong res = 1;\n\t\tfor(int i = 1; i <= b; ++i)\
    \ {\n\t\t\tres *= a--;\n\t\t\tres /= i;\n\t\t}\n\t\treturn res;\n\t}\n\tprotected\
    \ static final boolean isInt(final double n){ long r = (long) Math.floor(n); return\
    \ r == n; }\n\tprotected static final boolean isSqr(final long n){ return isInt(Math.sqrt(n));\
    \ }\n\tprotected static final boolean isPrime(final long n) {\n\t\tif(n == 1)\
    \ return false;\n\t\tfor(long i = 2; i * i <= n; ++i) {\n\t\t\tif(n % i == 0)\
    \ return false;\n\t\t}\n\t\treturn true;\n\t}\n\tprotected static final boolean\
    \ scope(final int l, final int x, final int r){ return l <= x && x <= r; }\n\t\
    protected static final int[] nextPerm(int[] a) {\n\t\tfor(int i = a.length - 1;\
    \ i > 0; i--) {\n\t\t\tif(a[i - 1] < a[i]) {\n\t\t\t\tfinal int j = find(a[i -\
    \ 1], a, i, a.length - 1);\n\t\t\t\ta[i - 1] ^= a[j];\n\t\t\t\ta[j] ^= a[i - 1];\n\
    \t\t\t\ta[i - 1] ^= a[j];\n\t\t\t\tArrays.sort(a, i, a.length);\n\t\t\t\treturn\
    \ a;\n\t\t\t}\n\t\t}\n\t\treturn null;\n\t}\n\tprotected static final long[] nextPerm(long[]\
    \ a) {\n\t\tfor(int i = a.length - 1; i > 0; i--) {\n\t\t\tif(a[i - 1] < a[i])\
    \ {\n\t\t\t\tfinal int j = find(a[i - 1], a, i, a.length - 1);\n\t\t\t\ta[i -\
    \ 1] ^= a[j];\n\t\t\t\ta[j] ^= a[i - 1];\n\t\t\t\ta[i - 1] ^= a[j];\n\t\t\t\t\
    Arrays.sort(a, i, a.length);\n\t\t\t\treturn a;\n\t\t\t}\n\t\t}\n\t\treturn null;\n\
    \t}\n\tprotected static final double[] nextPerm(double[] a) {\n\t\tfor(int i =\
    \ a.length - 1; i > 0; i--) {\n\t\t\tif(a[i - 1] < a[i]) {\n\t\t\t\tfinal int\
    \ j = find(a[i - 1], a, i, a.length - 1);\n\t\t\t\tfinal var tmp = a[i - 1];\n\
    \t\t\t\ta[i - 1] = a[j];\n\t\t\t\ta[j] = tmp;\n\t\t\t\tArrays.sort(a, i, a.length);\n\
    \t\t\t\treturn a;\n\t\t\t}\n\t\t}\n\t\treturn null;\n\t}\n\tprotected static final\
    \ String nextPerm(final String s) {\n\t\tvar a = s.chars().mapToObj(i -> (char)i).collect(Collectors.toList());\n\
    \t\tfor(int i = a.size() - 1; i > 0; i--) {\n\t\t\tif(a.get(i - 1).compareTo(a.get(i))\
    \ < 0) {\n\t\t\t\tfinal int j = find(a.get(i - 1), a, i, a.size() - 1);\n\t\t\t\
    \tCollections.swap(a, i - 1, j);\n\t\t\t\tCollections.sort(a.subList(i, a.size()));\n\
    \t\t\t\treturn a.stream().map(String::valueOf).collect(Collectors.joining());\n\
    \t\t\t}\n\t\t}\n\t\treturn null;\n\t}\n\tprotected static final int[] prevPerm(int[]\
    \ a) {\n\t\tfor(int i = a.length - 1; i > 0; i--) {\n\t\t\tif(a[i - 1] > a[i])\
    \ {\n\t\t\t\tfinal int j = findRev(a[i - 1], a, i, a.length - 1);\n\t\t\t\ta[i\
    \ - 1] ^= a[j];\n\t\t\t\ta[j] ^= a[i - 1];\n\t\t\t\ta[i - 1] ^= a[j];\n\t\t\t\t\
    Arrays.sort(a, i, a.length);\n\t\t\t\treturn reverse(a);\n\t\t\t}\n\t\t}\n\t\t\
    return null;\n\t}\n\tprotected static final long[] prevPerm(long[] a) {\n\t\t\
    for(int i = a.length - 1; i > 0; i--) {\n\t\t\tif(a[i - 1] > a[i]) {\n\t\t\t\t\
    final int j = findRev(a[i - 1], a, i, a.length - 1);\n\t\t\t\ta[i - 1] ^= a[j];\n\
    \t\t\t\ta[j] ^= a[i - 1];\n\t\t\t\ta[i - 1] ^= a[j];\n\t\t\t\tArrays.sort(a, i,\
    \ a.length);\n\t\t\t\treturn reverse(a);\n\t\t\t}\n\t\t}\n\t\treturn null;\n\t\
    }\n\tprotected static final double[] prevPerm(double[] a) {\n\t\tfor(int i = a.length\
    \ - 1; i > 0; i--) {\n\t\t\tif(a[i - 1] > a[i]) {\n\t\t\t\tfinal int j = findRev(a[i\
    \ - 1], a, i, a.length - 1);\n\t\t\t\tfinal var tmp = a[i - 1];\n\t\t\t\ta[i -\
    \ 1] = a[j];\n\t\t\t\ta[j] = tmp;\n\t\t\t\tArrays.sort(a, i, a.length);\n\t\t\t\
    \treturn reverse(a);\n\t\t\t}\n\t\t}\n\t\treturn null;\n\t}\n\tprotected static\
    \ final String prevPerm(final String s) {\n\t\tvar a = s.chars().mapToObj(i ->\
    \ (char)i).collect(Collectors.toList());\n\t\tfor(int i = a.size() - 1; i > 0;\
    \ i--) {\n\t\t\tif(a.get(i - 1).compareTo(a.get(i)) > 0) {\n\t\t\t\tfinal int\
    \ j = findRev(a.get(i - 1), a, i, a.size() - 1);\n\t\t\t\tCollections.swap(a,\
    \ i - 1, j);\n\t\t\t\tCollections.sort(a.subList(i, a.size()), Collections.reverseOrder());\n\
    \t\t\t\treturn a.stream().map(String::valueOf).collect(Collectors.joining());\n\
    \t\t\t}\n\t\t}\n\t\treturn null;\n\t}\n\tprivate static final int find(final int\
    \ dest, final int[] a, final int s, final int e) {\n\t\tif(s == e) {\n\t\t\treturn\
    \ s;\n\t\t}\n\t\tfinal int m = (s + e + 1) / 2;\n\t\treturn a[m] <= dest ? find(dest,\
    \ a, s, m - 1) : find(dest, a, m, e);\n\t}\n\tprivate static final int find(final\
    \ long dest, final long[] a, final int s, final int e) {\n\t\tif(s == e) {\n\t\
    \t\treturn s;\n\t\t}\n\t\tfinal int m = (s + e + 1) / 2;\n\t\treturn a[m] <= dest\
    \ ? find(dest, a, s, m - 1) : find(dest, a, m, e);\n\t}\n\tprivate static final\
    \ int find(final double dest, final double[] a, final int s, final int e) {\n\t\
    \tif(s == e) {\n\t\t\treturn s;\n\t\t}\n\t\tfinal int m = (s + e + 1) / 2;\n\t\
    \treturn a[m] <= dest ? find(dest, a, s, m - 1) : find(dest, a, m, e);\n\t}\n\t\
    private static final int find(final char dest, final List<Character> a, final\
    \ int s, final int e) {\n\t\tif(s == e) {\n\t\t\treturn s;\n\t\t}\n\t\tfinal int\
    \ m = (s + e + 1) / 2;\n\t\treturn a.get(m).compareTo(dest) <= 0 ? find(dest,\
    \ a, s, m - 1) : find(dest, a, m, e);\n\t}\n\tprivate static final int findRev(final\
    \ int dest, final int[] a, final int s, final int e) {\n\t\tif(s == e) {\n\t\t\
    \treturn s;\n\t\t}\n\t\tfinal int m = (s + e + 1) / 2;\n\t\treturn a[m] > dest\
    \ ? findRev(dest, a, s, m - 1) : findRev(dest, a, m, e);\n\t}\n\tprivate static\
    \ final int findRev(final long dest, final long[] a, final int s, final int e)\
    \ {\n\t\tif(s == e) {\n\t\t\treturn s;\n\t\t}\n\t\tfinal int m = (s + e + 1) /\
    \ 2;\n\t\treturn a[m] > dest ? findRev(dest, a, s, m - 1) : findRev(dest, a, m,\
    \ e);\n\t}\n\tprivate static final int findRev(final double dest, final double[]\
    \ a, final int s, final int e) {\n\t\tif(s == e) {\n\t\t\treturn s;\n\t\t}\n\t\
    \tfinal int m = (s + e + 1) / 2;\n\t\treturn a[m] > dest ? findRev(dest, a, s,\
    \ m - 1) : findRev(dest, a, m, e);\n\t}\n\tprivate static final int findRev(final\
    \ char dest, final List<Character> a, final int s, final int e) {\n\t\tif(s ==\
    \ e) {\n\t\t\treturn s;\n\t\t}\n\t\tfinal int m = (s + e + 1) / 2;\n\t\treturn\
    \ a.get(m).compareTo(dest) > 0 ? find(dest, a, s, m - 1) : find(dest, a, m, e);\n\
    \t}\n\tprotected static final boolean binarySearch(final int[] a, final int x)\
    \ {\n\t\treturn Arrays.binarySearch(a, x) >= 0;\n\t}\n\tprotected static final\
    \ boolean binarySearch(final long[] a, final long x) {\n\t\treturn Arrays.binarySearch(a,\
    \ x) >= 0;\n\t}\n    protected static final boolean binarySearch(final Object[]\
    \ a, final Object x) {\n        return binarySearch(Arrays.stream(a).collect(Collectors.toList()),\
    \ x);\n    }\n\tprotected static final int lowerBound(final int[] a, final int\
    \ x) {\n\t\treturn lowerBound(Arrays.stream(a).boxed().collect(Collectors.toList()),\
    \ x);\n\t}\n\tprotected static final int lowerBound(final long[] a, final long\
    \ x) {\n\t\treturn lowerBound(Arrays.stream(a).boxed().collect(Collectors.toList()),\
    \ x);\n\t}\n    protected static final <T extends Comparable<? super T>> int lowerBound(final\
    \ T[] a, final T x) {\n\t\treturn lowerBound(Arrays.asList(a), x);\n\t}\n\tprotected\
    \ static final int upperBound(final int[] a, final int x) {\n\t\treturn upperBound(Arrays.stream(a).boxed().collect(Collectors.toList()),\
    \ x);\n\t}\n\tprotected static final int upperBound(final long[] a, final long\
    \ x) {\n\t\treturn upperBound(Arrays.stream(a).boxed().collect(Collectors.toList()),\
    \ x);\n\t}\n    protected static final <T extends Comparable<? super T>> int upperBound(final\
    \ T[] a, final T x) {\n\t\treturn upperBound(Arrays.asList(a), x);\n\t}\n\tprotected\
    \ static final <T> boolean binarySearch(final List<T> a, final T x) {\n\t\treturn\
    \ Collections.binarySearch(a, x, null) >= 0;\n\t}\n\tprotected static final <T\
    \ extends Comparable<? super T>> int lowerBound(final List<T> a, final T x) {\n\
    \t\treturn ~Collections.binarySearch(a, x, (p, q) -> p.compareTo(q) >= 0 ? 1 :\
    \ -1);\n\t}\n\tprotected static final <T extends Comparable<? super T>> int upperBound(final\
    \ List<T> a, final T x) {\n\t\treturn ~Collections.binarySearch(a, x, (p, q) ->\
    \ p.compareTo(q) > 0 ? 1 : -1);\n\t}\n\tprotected static final String reverse(final\
    \ String s){ return new StringBuilder(s).reverse().toString(); }\n\tprotected\
    \ static final int[] reverse(final int[] a) {\n\t\tfinal int n = a.length;\n\t\
    \tint[] b = new int[n];\n\t\tfor(int i = 0; i <= n / 2; ++i) {\n\t\t\tb[i] = a[n\
    \ - 1 - i];\n\t\t\tb[n - 1 - i] = a[i];\n\t\t}\n\t\treturn b;\n\t}\n\tprotected\
    \ static final long[] reverse(final long[] a) {\n\t\tfinal int n = a.length;\n\
    \t\tlong[] b = new long[n];\n\t\tfor(int i = 0; i <= n / 2; ++i) {\n\t\t\tb[i]\
    \ = a[n - 1 - i];\n\t\t\tb[n - 1 - i] = a[i];\n\t\t}\n\t\treturn b;\n\t}\n\tprotected\
    \ static final double[] reverse(final double[] a) {\n\t\tfinal int n = a.length;\n\
    \t\tdouble[] b = new double[n];\n\t\tfor(int i = 0; i <= n / 2; ++i) {\n\t\t\t\
    b[i] = a[n - 1 - i];\n\t\t\tb[n - 1 - i] = a[i];\n\t\t}\n\t\treturn b;\n\t}\n\t\
    protected static final Object[] reverse(final Object[] a) {\n\t\tfinal int n =\
    \ a.length;\n\t\tObject[] b = new Object[n];\n\t\tfor(int i = 0; i <= n / 2; ++i)\
    \ {\n\t\t\tb[i] = a[n - 1 - i];\n\t\t\tb[n - 1 - i] = a[i];\n\t\t}\n\t\treturn\
    \ b;\n\t}\n\tprotected static final int[] rotate(final int[] a, final int id)\
    \ {\n\t\tArrayList<Integer> t = new ArrayList<>(a.length);\n\t\tfor(final var\
    \ el: a) {\n\t\t\tt.add(el);\n\t\t}\n\t\tCollections.rotate(t, id);\n\t\tint[]\
    \ res = new int[t.size()];\n\t\tfor(int i = 0; i < t.size(); ++i) {\n\t\t\tres[i]\
    \ = t.get(i);\n\t\t}\n\t\treturn res;\n\t}\n\tprotected static final long[] rotate(final\
    \ long[] a, final int id) {\n\t\tArrayList<Long> t = new ArrayList<>(a.length);\n\
    \t\tfor(final var el: a) {\n\t\t\tt.add(el);\n\t\t}\n\t\tCollections.rotate(t,\
    \ id);\n\t\tlong[] res = new long[t.size()];\n\t\tfor(int i = 0; i < t.size();\
    \ ++i) {\n\t\t\tres[i] = t.get(i);\n\t\t}\n\t\treturn res;\n\t}\n\tprotected static\
    \ final double[] rotate(final double[] a, final int id) {\n\t\tArrayList<Double>\
    \ t = new ArrayList<>(a.length);\n\t\tfor(final var el: a) {\n\t\t\tt.add(el);\n\
    \t\t}\n\t\tCollections.rotate(t, id);\n\t\tdouble[] res = new double[t.size()];\n\
    \t\tfor(int i = 0; i < t.size(); ++i) {\n\t\t\tres[i] = t.get(i);\n\t\t}\n\t\t\
    return res;\n\t}\n\tprotected static final String rotate(final String s, final\
    \ int id) {\n\t\tArrayList<Character> t = new ArrayList<>();\n\t\tfor(final char\
    \ c: s.toCharArray()) {\n\t\t\tt.add(c);\n\t\t}\n\t\tCollections.rotate(t, id);\n\
    \t\tStringBuilder sb = new StringBuilder();\n\t\tfor(final var c: t) {\n\t\t\t\
    sb.append(c);\n\t\t}\n\t\treturn sb.toString(); \n\t}\n\tprotected static final\
    \ int[][] rotate(final int[][] a) {\n\t\tfinal int h = a.length, w = a[0].length;\n\
    \t\tint[][] b = new int[w][h];\n\t\tIntStream.range(0, h).forEach(i -> {\n\t\t\
    \tIntStream.range(0, w).forEach(j -> b[j][i] = a[i][j]);\n\t\t});\n\t\tIntStream.range(0,\
    \ w).forEach(i -> b[i] = reverse(b[i]));\n\t\treturn b;\n\t}\n\tprotected static\
    \ final long[][] rotate(final long[][] a) {\n\t\tfinal int h = a.length, w = a[0].length;\n\
    \t\tlong[][] b = new long[w][h];\n\t\tIntStream.range(0, h).forEach(i -> {\n\t\
    \t\tIntStream.range(0, w).forEach(j -> b[j][i] = a[i][j]);\n\t\t});\n\t\tIntStream.range(0,\
    \ w).forEach(i -> b[i] = reverse(b[i]));\n\t\treturn b;\n\t}\n\tprotected static\
    \ final double[][] rotate(final double[][] a) {\n\t\tfinal int h = a.length, w\
    \ = a[0].length;\n\t\tdouble[][] b = new double[w][h];\n\t\tIntStream.range(0,\
    \ h).forEach(i -> {\n\t\t\tIntStream.range(0, w).forEach(j -> b[j][i] = a[i][j]);\n\
    \t\t});\n\t\tIntStream.range(0, w).forEach(i -> b[i] = reverse(b[i]));\n\t\treturn\
    \ b;\n\t}\n\tprotected static final String[] rotate(final String[] s) {\n\t\t\
    final int h = s.length, w = s[0].length();\n\t\tchar[][] t = new char[w][h];\n\
    \t\tIntStream.range(0, h).forEach(i -> {\n\t\t\tIntStream.range(0, w).forEach(j\
    \ -> t[j][i] = s[i].charAt(j));\n\t\t});\n\t\tIntStream.range(0, w).forEach(i\
    \ -> t[i] = new StringBuilder(new String(t[i])).reverse().toString().toCharArray());\n\
    \t\tString[] res = new String[w];\n\t\tIntStream.range(0, w).forEach(i -> res[i]\
    \ = new String(t[i]));\n\t\treturn res;\n\t}\n\tprotected static final long lcm(final\
    \ long a, final long b){ return a * b / gcd(a, b); }\n\tprotected static final\
    \ long gcd(final long a, final long b){ return b > 0 ? gcd(b, a % b) : a; }\n\t\
    protected static final long lcm(final long... a){ return Arrays.stream(a).reduce(1,\
    \ (x, y) -> lcm(x, y)); }\n\tprotected static final long gcd(final long... a){\
    \ return Arrays.stream(a).reduce(0, (x, y) -> gcd(x, y)); }\n\tprotected static\
    \ final long min(final long... a){ return Arrays.stream(a).reduce(Long.MAX_VALUE,\
    \ (x, y) -> Math.min(x, y)); }\n\tprotected static final long max(final long...\
    \ a){ return Arrays.stream(a).reduce(Long.MIN_VALUE, (x, y) -> Math.max(x, y));\
    \ }\n\tprotected static final <F, S> ArrayList<F> first(final List<Pair<F, S>>\
    \ p) {\n\t\tArrayList<F> f = new ArrayList<>();\n\t\tfor(final var el: p) {\n\t\
    \t\tf.add(el.first);\n\t\t}\n\t\treturn f;\n\t}\n\tprotected static final <F,\
    \ S> ArrayList<S> second(final List<Pair<F, S>> p) {\n\t\tArrayList<S> s = new\
    \ ArrayList<>();\n\t\tfor(final var el: p) {\n\t\t\ts.add(el.second);\n\t\t}\n\
    \t\treturn s;\n\t}\n\tprotected static final int[] iota(final int n){ return IntStream.range(0,\
    \ n).toArray(); }\n\tprotected static final int[] iota(final int n, final int\
    \ init){ return IntStream.range(0 + init, n + init).toArray(); }\n\tprotected\
    \ static final long bins(long ok, long ng, final Predicate<Long> fn) {\n\t\twhile(Math.abs(ok\
    \ - ng) > 1) {\n\t\t\tfinal long mid = (ok + ng) / 2;\n\t\t\tif(fn.test(mid))\
    \ {\n\t\t\t\tok = mid;\n\t\t\t}\n\t\t\telse {\n\t\t\t\tng = mid;\n\t\t\t}\n\t\t\
    }\n\t\treturn ok;\n\t}\n\tprotected static final double bins(double ok, double\
    \ ng, final Predicate<Double> fn) {\n\t\twhile(Math.abs(ok - ng) > VvyLw.eps)\
    \ {\n\t\t\tfinal double mid = (ok + ng) / 2;\n\t\t\tif(fn.test(mid)) {\n\t\t\t\
    \tok = mid;\n\t\t\t}\n\t\t\telse {\n\t\t\t\tng = mid;\n\t\t\t}\n\t\t}\n\t\treturn\
    \ ok;\n\t}\n\tprotected static final ArrayList<Integer> press(final ArrayList<Long>\
    \ a) {\n\t\tArrayList<Integer> res = new ArrayList<>();\n\t\tfinal var cp = a.stream().sorted().distinct().collect(Collectors.toList());\n\
    \t\tfor(final var el: a) {\n\t\t\tres.add(lowerBound(cp, el));\n\t\t}\n\t\treturn\
    \ res;\n\t}\n\tprotected static final int[] zAlgorithm(final String s) {\n\t\t\
    final int n = s.length();\n\t\tint j = 0;\n\t\tint[] pre = new int[n];\n\t\tfor(int\
    \ i = 0; ++i < n;) {\n\t\t\tif(i + pre[i - j] < j + pre[j]) {\n\t\t\t\tpre[i]\
    \ = pre[i - j];\n\t\t\t}\n\t\t\telse {\n\t\t\t\tint k = Math.max(0, j + pre[j]\
    \ - i);\n\t\t\t\twhile(i + k < n && s.charAt(k) == s.charAt(i + k)) {\n\t\t\t\t\
    \t++k;\n\t\t\t\t}\n\t\t\t\tpre[i] = k;\n\t\t\t\tj = i;\n\t\t\t}\n\t\t}\n\t\tpre[0]\
    \ = n;\n\t\treturn pre;\n\t}\n\tprotected static final int[] manacher(final String\
    \ s_, final boolean calcEven) {\n\t\tint n = s_.length();\n\t\tchar[] s;\n\t\t\
    if(calcEven) {\n\t\t\ts = new char[2 * n - 1];\n\t\t\tIntStream.range(0, n).forEach(i\
    \ -> s[i] = s_.charAt(i));\n\t\t\tfor(int i = n; --i >= 0;) {\n\t\t\t\ts[2 * i]\
    \ = s_.charAt(i);\n\t\t\t}\n\t\t\tfinal var d = Collections.min(s_.chars().mapToObj(c\
    \ -> (char) c).collect(Collectors.toList()));\n\t\t\tfor(int i = 0; i < n - 1;\
    \ ++i) {\n\t\t\t\ts[2 * i + 1] = d;\n\t\t\t}\n\t\t} else {\n\t\t\ts = new char[n];\n\
    \t\t\tIntStream.range(0, n).forEach(i -> s[i] = s_.charAt(i));\n\t\t}\n\t\tn =\
    \ s.length;\n\t\tint[] rad = new int[n];\n\t\tfor(int i = 0, j = 0; i < n;) {\n\
    \t\t\twhile(i - j >= 0 && i + j < n && s[i - j] == s[i + j]) {\n\t\t\t\t++j;\n\
    \t\t\t}\n\t\t\trad[i] = j;\n\t\t\tint k = 1;\n\t\t\twhile(i - k >= 0 && i + k\
    \ < n && k + rad[i - k] < j) {\n\t\t\t\trad[i + k] = rad[i - k];\n\t\t\t\t++k;\n\
    \t\t\t}\n\t\t\ti += k;\n\t\t\tj -= k;\n\t\t}\n\t\tif(calcEven) {\n\t\t\tfor(int\
    \ i = 0; i < n; ++i) {\n\t\t\t\tif(((i ^ rad[i]) & 1) == 0) {\n\t\t\t\t\trad[i]--;\n\
    \t\t\t\t}\n\t\t\t}\n\t\t} else {\n\t\t\tfor(var x: rad) {\n\t\t\t\tx = 2 * x -\
    \ 1;\n\t\t\t}\n\t\t}\n\t\treturn rad;\n\t}\n\tprotected static final long kthRoot(final\
    \ long n, final int k) {\n\t\tif(k == 1) {\n\t\t\treturn n;\n\t\t}\n\t\tfinal\
    \ Predicate<Long> chk = (x) -> {\n\t\t\tlong mul = 1;\n\t\t\tfor(int j = 0; j\
    \ < k; ++j) {\n\t\t\t\ttry {\n\t\t\t\t\tmul = Math.multiplyExact(mul, x);\n\t\t\
    \t\t} catch(ArithmeticException e) {\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\
    \t}\n\t\t\treturn mul <= n;\n\t\t};\n\t\tlong ret = 0;\n\t\tfor(int i = 32; --i\
    \ >= 0;) {\n\t\t\tif(chk.test(ret | (1L << i))) {\n\t\t\t\tret |= 1L << i;\n\t\
    \t\t}\n\t\t}\n\t\treturn ret;\n\t}\n\tprotected static final int invNum(final\
    \ int[] a) {\n\t\tfinal var bit = new FenwickTree(a.length);\n\t\tint res = 0;\n\
    \t\tfor(int i = 0; i < a.length; ++i) {\n\t\t\tres += i - bit.sum(a[i]);\n\t\t\
    \tbit.add(a[i], 1);\n\t\t}\n\t\treturn res;\n\t}\n}\n\nfinal class MyScanner {\n\
    \tprivate final Scanner sc = new Scanner(System.in);\n\tfinal int ni(){ return\
    \ sc.nextInt(); }\n\tfinal long nl(){ return sc.nextLong(); }\n\tfinal double\
    \ nd(){ return sc.nextDouble(); }\n\tfinal String ns(){ return sc.next(); }\n\t\
    final int[] ni(final int n){\n\t\tint[] a = new int[n];\n\t\tIntStream.range(0,\
    \ n).forEach(i -> a[i] = ni());\n\t\treturn a;\n\t}\n\tfinal long[] nl(final int\
    \ n){\n\t\tlong[] a = new long[n];\n\t\tIntStream.range(0, n).forEach(i -> a[i]\
    \ = nl());\n\t\treturn a;\n\t}\n\tfinal double[] nd(final int n){\n\t\tdouble[]\
    \ a = new double[n];\n\t\tIntStream.range(0, n).forEach(i -> a[i] = nd());\n\t\
    \treturn a;\n\t}\n\tfinal String[] ns(final int n){\n\t\tString[] a = new String[n];\n\
    \t\tIntStream.range(0, n).forEach(i -> a[i] = ns());\n\t\treturn a;\n\t}\n\tfinal\
    \ int[][] ni(final int h, final int w) {\n\t\tint[][] a = new int[h][w];\n\t\t\
    IntStream.range(0, h).forEach(i -> a[i] = ni(w));\n\t\treturn a;\n\t}\n\tfinal\
    \ long[][] nl(final int h, final int w) {\n\t\tlong[][] a = new long[h][w];\n\t\
    \tIntStream.range(0, h).forEach(i -> a[i] = nl(w));\n\t\treturn a;\n\t}\n\tfinal\
    \ double[][] nd(final int h, final int w) {\n\t\tdouble[][] a = new double[h][w];\n\
    \t\tIntStream.range(0, h).forEach(i -> a[i] = nd(w));\n\t\treturn a;\n\t}\n\t\
    final void close(){ sc.close(); }\n}\n\nfinal class MyPrinter {\n\tprivate final\
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
    \ tail);\n\t\tflush();\n\t\tSystem.exit(0);\n\t}\n\tfinal void fin(final int[]\
    \ args) {\n\t\tout(args);\n\t\tflush();\n\t\tSystem.exit(0);\n\t}\n\tfinal void\
    \ fin(final long[] args) {\n\t\tout(args);\n\t\tflush();\n\t\tSystem.exit(0);\n\
    \t}\n\tfinal void fin(final double[] args) {\n\t\tout(args);\n\t\tflush();\n\t\
    \tSystem.exit(0);\n\t}\n\tfinal void fin(final boolean[] args) {\n\t\tout(args);\n\
    \t\tflush();\n\t\tSystem.exit(0);\n\t}\n\tfinal void fin(final char[] args) {\n\
    \t\tout(args);\n\t\tflush();\n\t\tSystem.exit(0);\n\t}\n\tfinal void fin(final\
    \ Object[] args) {\n\t\tout(args);\n\t\tflush();\n\t\tSystem.exit(0);\n\t}\n\t\
    final <T> void fin(final List<T> args) {\n\t\tout(args);\n\t\tflush();\n\t\tSystem.exit(0);\n\
    \t}\n\tfinal void ende(final int[] args) {\n\t\toutl(args);\n\t\tflush();\n\t\t\
    System.exit(0);\n\t}\n\tfinal void ende(final long[] args) {\n\t\toutl(args);\n\
    \t\tflush();\n\t\tSystem.exit(0);\n\t}\n\tfinal void ende(final double[] args)\
    \ {\n\t\toutl(args);\n\t\tflush();\n\t\tSystem.exit(0);\n\t}\n\tfinal void ende(final\
    \ boolean[] args) {\n\t\toutl(args);\n\t\tflush();\n\t\tSystem.exit(0);\n\t}\n\
    \tfinal void ende(final char[] args) {\n\t\toutl(args);\n\t\tflush();\n\t\tSystem.exit(0);\n\
    \t}\n\tfinal void ende(final Object[] args) {\n\t\toutl(args);\n\t\tflush();\n\
    \t\tSystem.exit(0);\n\t}\n\tfinal <E> void ende(final Collection<E> args) {\n\t\
    \toutl(args);\n\t\tflush();\n\t\tSystem.exit(0);\n\t}\n\tfinal void flush(){ pw.flush();\
    \ }\n\tfinal void close(){ pw.close(); }\n}\n\nclass Pair<F, S> {\n\tprotected\
    \ final F first;\n\tprotected final S second;\n\tPair(final F first, final S second)\
    \ {\n\t\tthis.first = first;\n\t\tthis.second = second;\n\t}\n\t@Override\n\t\
    public final boolean equals(final Object o) {\n\t\tif(this == o) {\n\t\t\treturn\
    \ true;\n\t\t}\n\t\tif(o == null || getClass() != o.getClass()) {\n\t\t\treturn\
    \ false;\n\t\t}\n\t\tfinal Pair<?, ?> p = (Pair<?, ?>) o;\n\t\tif(!first.equals(p.first))\
    \ {\n\t\t\treturn false;\n\t\t}\n\t\treturn second.equals(p.second);\n\t}\n\t\
    @Override\n\tpublic final int hashCode(){ return 31 * first.hashCode() + second.hashCode();\
    \ }\n\t@Override\n\tpublic final String toString(){ return \"(\" + first + \"\
    , \" + second + \")\"; }\n\tpublic static final <F, S> Pair<F, S> of(final F a,\
    \ final S b){ return new Pair<>(a, b); }\n\tfinal Pair<S, F> swap(){ return Pair.of(second,\
    \ first); }\n}\nfinal class NumPair extends Pair<Number, Number> implements Comparable<NumPair>\
    \  {\n\tNumPair(final Number first, final Number second){ super(first, second);\
    \ }\n\tfinal NumPair rotate(){ return new NumPair(-second.doubleValue(), first.doubleValue());\
    \ } \n\tfinal NumPair rotate(final int ang) {\n\t\tfinal double rad = Math.toRadians(Utility.mod(ang,\
    \ 360));\n\t\treturn new NumPair(first.doubleValue() * Math.cos(rad) - second.doubleValue()\
    \ * Math.sin(rad),\n\t\t\t\t\t\t\tfirst.doubleValue() * Math.sin(rad) + second.doubleValue()\
    \ * Math.cos(rad));\n\t}\n\tfinal long dot(final NumPair p){ return first.longValue()\
    \ * p.first.longValue() + second.longValue() + p.second.longValue(); }\n\tfinal\
    \ double dotf(final NumPair p){ return first.doubleValue() * p.first.doubleValue()\
    \ + second.doubleValue() + p.second.doubleValue(); }\n\tfinal long cross(final\
    \ NumPair p){ return this.rotate().dot(p); }\n\tfinal double crossf(final NumPair\
    \ p){ return this.rotate().dotf(p); }\n\tfinal long sqr(){ return this.dot(this);\
    \ }\n\tfinal double sqrf(){ return this.dotf(this); }\n\tfinal double grad() {\
    \ \n\t\ttry {\n\t\t\treturn second.doubleValue() / first.doubleValue();\n\t\t\
    } catch(ArithmeticException e) {\n\t\t\te.printStackTrace();\n\t\t}\n\t\treturn\
    \ Double.NaN;\n\t}\n\tfinal double abs(){ return Math.hypot(first.doubleValue(),\
    \ second.doubleValue()); }\n\tfinal long lcm(){ return Utility.lcm(first.longValue(),\
    \ second.longValue()); }\n\tfinal long gcd(){ return Utility.gcd(first.longValue(),\
    \ second.longValue()); }\n\tfinal NumPair extgcd() {\n\t\tlong x = 1, y = 0, t1\
    \ = 0, t2 = 0, t3 = 1, a = first.longValue(), b = second.longValue();\n\t\twhile(b\
    \ > 0) {\n\t\t\tt1 = a / b;\n\t\t\ta -= t1 * b;\n\t\t\ta ^= b;\n\t\t\tb ^= a;\n\
    \t\t\ta ^= b;\n\t\t\tx -= t1 * t2;\n\t\t\tx ^= t2;\n\t\t\tt2 ^= x;\n\t\t\tx ^=\
    \ t2;\n\t\t\ty -= t1 * t3;\n\t\t\ty ^= t3;\n\t\t\tt3 ^= y;\n\t\t\ty ^= t3;\n\t\
    \t}\n\t\treturn new NumPair(x, y);\n\t}\n\t@Override\n\tfinal public int compareTo(final\
    \ NumPair o) {\n\t\tif(first.doubleValue() == o.first.doubleValue()) {\n\t\t\t\
    return Double.compare(second.doubleValue(), o.second.doubleValue());\n\t\t}\n\t\
    \treturn Double.compare(first.doubleValue(), o.first.doubleValue());\n\t}\n}\n\
    \nfinal class FenwickTree {\n\tprivate final int n;\n\tprivate final long[] data;\n\
    \tFenwickTree(final int n) {\n\t\tthis.n = n + 2;\n\t\tdata = new long[this.n\
    \ + 1];\n\t}\n\tfinal long sum(int k) {\n\t\tif(k < 0) return 0;\n\t\tlong ret\
    \ = 0;\n\t\tfor(++k; k > 0; k -= k & -k) {\n\t\t\tret += data[k];\n\t\t}\n\t\t\
    return ret;\n\t}\n\tfinal long sum(final int l, final int r){ return sum(r) -\
    \ sum(l - 1); }\n\tfinal long get(final int k){ return sum(k) - sum(k - 1); }\n\
    \tfinal void add(int k, final long x) {\n\t\tfor(++k; k < n; k += k & -k) {\n\t\
    \t\tdata[k] += x;\n\t\t}\n\t}\n\tfinal void imos(final int l, final int r, long\
    \ x) {\n\t\tadd(l, x);\n\t\tadd(r + 1, -x);\n\t}\n\tprivate final int lg(final\
    \ int n){ return 63 - Integer.numberOfLeadingZeros(n); }\n\tfinal int lowerBound(long\
    \ w) {\n\t\tif(w <= 0) {\n\t\t\treturn 0;\n\t\t}\n\t\tint x = 0;\n\t\tfor(int\
    \ k = 1 << lg(n); k > 0; k >>= 1) {\n\t\t\tif(x + k <= n - 1 && data[x + k] <\
    \ w) {\n\t\t\t\tw -= data[x + k];\n\t\t\t\tx += k;\n\t\t\t}\n\t\t}\n\t\treturn\
    \ x;\n\t}\n\tfinal int upperBound(long w) {\n\t\tif(w < 0) {\n\t\t\treturn 0;\n\
    \t\t}\n\t\tint x = 0;\n\t\tfor(int k = 1 << lg(n); k > 0; k >>= 1) {\n\t\t\tif(x\
    \ + k <= n - 1 && data[x + k] <= w) {\n\t\t\t\tw -= data[x + k];\n\t\t\t\tx +=\
    \ k;\n\t\t\t}\n\t\t}\n\t\treturn x;\n\t}\n}"
  dependsOn:
  - Java/extension/SparseTable.java
  - Java/extension/PrimeTable.java
  - Java/extension/PrefixSum.java
  - Java/extension/PrimeFactor.java
  - Java/extension/LargePrime.java
  - Java/extension/LowestCommonAncestor.java
  - Java/extension/UndoUnionFind.java
  - Java/extension/SuffixArray.java
  - Java/extension/WaveletMatrix.java
  - Java/extension/SegmentTree.java
  - Java/extension/WeightedUnionFind.java
  - Java/extension/DoubleEndedPriorityQueue.java
  - Java/extension/Graph.java
  - Java/extension/UnionFind.java
  - Java/extension/PrimeCounter.java
  - Java/all.java
  isVerificationFile: false
  path: Java/extension/Template.java
  requiredBy:
  - Java/extension/SparseTable.java
  - Java/extension/PrimeTable.java
  - Java/extension/PrefixSum.java
  - Java/extension/PrimeFactor.java
  - Java/extension/LargePrime.java
  - Java/extension/LowestCommonAncestor.java
  - Java/extension/UndoUnionFind.java
  - Java/extension/SuffixArray.java
  - Java/extension/WaveletMatrix.java
  - Java/extension/SegmentTree.java
  - Java/extension/WeightedUnionFind.java
  - Java/extension/DoubleEndedPriorityQueue.java
  - Java/extension/Graph.java
  - Java/extension/UnionFind.java
  - Java/extension/PrimeCounter.java
  - Java/all.java
  timestamp: '2023-12-11 01:34:41+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: Java/extension/Template.java
layout: document
redirect_from:
- /library/Java/extension/Template.java
- /library/Java/extension/Template.java.html
title: Java/extension/Template.java
---
