---
data:
  _extendedDependsOn:
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
    RuntimeError: bundler is not specified: Java/all.java\n"
  code: "import java.io.OutputStream;\nimport java.io.PrintWriter;\nimport java.math.BigInteger;\n\
    import java.util.ArrayDeque;\nimport java.util.ArrayList;\nimport java.util.Arrays;\n\
    import java.util.Collection;\nimport java.util.Collections;\nimport java.util.Comparator;\n\
    import java.util.List;\nimport java.util.PriorityQueue;\nimport java.util.Queue;\n\
    import java.util.Scanner;\nimport java.util.Stack;\nimport java.util.TreeMap;\n\
    import java.util.function.BiFunction;\nimport java.util.function.BiPredicate;\n\
    import java.util.function.BinaryOperator;\nimport java.util.function.Consumer;\n\
    import java.util.function.Predicate;\nimport java.util.stream.Collectors;\nimport\
    \ java.util.stream.IntStream;\n\nclass VvyLw extends Utility {\n\tprotected static\
    \ final MyScanner sc = new MyScanner();\n\tprotected static final MyPrinter o\
    \ = new MyPrinter(System.out, false);\n\tprotected static final MyPrinter e =\
    \ new MyPrinter(System.err, true);\n\tstatic final int[] dx = {0, -1, 1, 0, 0,\
    \ -1, -1, 1, 1};\n\tstatic final int[] dy = {0, 0, 0, -1, 1, -1, 1, -1, 1};\n\t\
    static final int inf = 1 << 30;\n\tstatic final long linf = (1L << 61) - 1;\n\t\
    static final int mod998 = 998244353;\n\tstatic final int mod107 = (int)1e9 + 7;\n\
    \tprotected static void solve() {\n\t\t\n\t}\n}\nclass Main extends VvyLw {\n\t\
    public static void main(final String[] args) {\n\t\tint t = 1;\n\t\t//t = sc.ni();\n\
    \t\twhile(t-- > 0) {\n\t\t\tsolve();\n\t\t}\n\t\to.flush();\n\t\tsc.close();\n\
    \t\to.close();\n\t\te.close();\n\t}\n}\n\nclass Utility {\n\tprotected static\
    \ String yes(final boolean ok){ return ok ? \"Yes\" : \"No\"; }\n\tprotected static\
    \ String no(final boolean ok){ return yes(!ok); }\n\tprotected static long sqr(final\
    \ long x){ return x * x; }\n\tprotected static int mod(final long n, final int\
    \ m){ return (int) ((n + m) % m); }\n\tprotected static long intCeil(long a, long\
    \ b){ return (long) Math.ceil((double)a / b); }\n\tprotected static long intPow(long\
    \ a, int b) {\n\t\tlong res = 1;\n\t\twhile(b > 0) {\n\t\t\tif(b % 2 == 1) {\n\
    \t\t\t\tres *= a;\n\t\t\t}\n\t\t\ta *= a;\n\t\t\tb >>= 1;\n\t\t}\n\t\treturn res;\n\
    \t}\n\tprotected static long intPow(long a, long b, final int m) {\n\t\tlong res\
    \ = 1;\n\t\twhile(b > 0) {\n\t\t\tif(b % 2 == 1) {\n\t\t\t\tres *= a;\n\t\t\t\t\
    res = mod(res, m);\n\t\t\t}\n\t\t\ta *= a;\n\t\t\ta = mod(a, m);\n\t\t\tb >>=\
    \ 1;\n\t\t}\n\t\treturn res;\n\t}\n\tprotected static ArrayList<Long> div(final\
    \ long n) {\n\t\tArrayList<Long> d = new ArrayList<>();\n\t\tfor(long i = 1; i\
    \ * i <= n; ++i) {\n\t\t\tif(n % i == 0) {\n\t\t\t\td.add(i);\n\t\t\t\tif(i *\
    \ i != n) {\n\t\t\t\t\td.add(n / i);\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tCollections.sort(d);\n\
    \t\treturn d;\n\t}\n\tprotected static ArrayList<Pair<Long, Integer>> primeFactor(long\
    \ n) {\n\t\tArrayList<Pair<Long, Integer>> pf = new ArrayList<>();\n\t\tfor(long\
    \ i = 2; i * i <= n; ++i) {\n\t\t\tif(n % i != 0) {\n\t\t\t\tcontinue;\n\t\t\t\
    }\n\t\t\tint cnt = 0;\n\t\t\twhile(n % i == 0) {\n\t\t\t\tcnt++;\n\t\t\t\tn /=\
    \ i;\n\t\t\t}\n\t\t\tpf.add(Pair.of(i, cnt));\n\t\t}\n\t\tif(n != 1) {\n\t\t\t\
    pf.add(Pair.of(n, 1));\n\t\t}\n\t\treturn pf;\n\t}\n\tprotected static long binom(int\
    \ a, final int b) {\n\t\tlong res = 1;\n\t\tfor(int i = 1; i <= b; ++i) {\n\t\t\
    \tres *= a--;\n\t\t\tres /= i;\n\t\t}\n\t\treturn res;\n\t}\n\tprotected static\
    \ boolean isInt(final double n){ long r = (long) Math.floor(n); return r == n;\
    \ }\n\tprotected static boolean isSqr(final long n){ return isInt(Math.sqrt(n));\
    \ }\n\tprotected static boolean isPrime(final long n) {\n\t\tif(n == 1) return\
    \ false;\n\t\tfor(long i = 2; i * i <= n; ++i) {\n\t\t\tif(n % i == 0) return\
    \ false;\n\t\t}\n\t\treturn true;\n\t}\n\tprotected static boolean nextPerm(ArrayList<?\
    \ extends Number> a) {\n\t\tfor(int i = a.size() - 1; i > 0; i--) {\n\t\t\tif(a.get(i\
    \ - 1).longValue() < a.get(i).longValue()) {\n\t\t\t\tfinal int j = find(a.get(i\
    \ - 1).longValue(), a, i, a.size() - 1);\n\t\t\t\tCollections.swap(a, i - 1, j);\n\
    \t\t\t\tCollections.sort(a.subList(i, a.size()), (x, y) -> Long.compare(x.longValue(),\
    \ y.longValue()));\n\t\t\t\treturn true;\n\t\t\t}\n\t\t}\n\t\treturn false;\n\t\
    }\n\tprotected static String nextPerm(final String s) {\n\t\tvar a = s.chars().mapToObj(i\
    \ -> (char)i).collect(Collectors.toList());\n\t\tfor(int i = a.size() - 1; i >\
    \ 0; i--) {\n\t\t\tif(a.get(i - 1).compareTo(a.get(i)) < 0) {\n\t\t\t\tfinal int\
    \ j = find(a.get(i - 1), a, i, a.size() - 1);\n\t\t\t\tCollections.swap(a, i -\
    \ 1, j);\n\t\t\t\tCollections.sort(a.subList(i, a.size()));\n\t\t\t\treturn a.stream().map(String::valueOf).collect(Collectors.joining());\n\
    \t\t\t}\n\t\t}\n\t\treturn null;\n\t}\n\tprotected static boolean prevPerm(ArrayList<?\
    \ extends Number> a) {\n\t\tfor(int i = a.size() - 1; i > 0; i--) {\n\t\t\tif(a.get(i\
    \ - 1).longValue() > a.get(i).longValue()) {\n\t\t\t\tfinal int j = findRev(a.get(i\
    \ - 1).longValue(), a, i, a.size() - 1);\n\t\t\t\tCollections.swap(a, i - 1, j);\n\
    \t\t\t\tCollections.sort(a.subList(i, a.size()), Collections.reverseOrder());\n\
    \t\t\t\treturn true;\n\t\t\t}\n\t\t}\n\t\treturn false;\n\t}\n\tprotected static\
    \ String prevPerm(final String s) {\n\t\tvar a = s.chars().mapToObj(i -> (char)i).collect(Collectors.toList());\n\
    \t\tfor(int i = a.size() - 1; i > 0; i--) {\n\t\t\tif(a.get(i - 1).compareTo(a.get(i))\
    \ > 0) {\n\t\t\t\tfinal int j = findRev(a.get(i - 1), a, i, a.size() - 1);\n\t\
    \t\t\tCollections.swap(a, i - 1, j);\n\t\t\t\tCollections.sort(a.subList(i, a.size()),\
    \ Collections.reverseOrder());\n\t\t\t\treturn a.stream().map(String::valueOf).collect(Collectors.joining());\n\
    \t\t\t}\n\t\t}\n\t\treturn null;\n\t}\n\tprivate static int find(final long dest,\
    \ final List<? extends Number> a, final int s, final int e) {\n\t\tif(s == e)\
    \ {\n\t\t\treturn s;\n\t\t}\n\t\tfinal int m = (s + e + 1) / 2;\n\t\treturn a.get(m).longValue()\
    \ <= dest ? find(dest, a, s, m - 1) : find(dest, a, m, e);\n\t}\n\tprivate static\
    \ int find(final char dest, final List<Character> a, final int s, final int e)\
    \ {\n\t\tif(s == e) {\n\t\t\treturn s;\n\t\t}\n\t\tfinal int m = (s + e + 1) /\
    \ 2;\n\t\treturn a.get(m).compareTo(dest) <= 0 ? find(dest, a, s, m - 1) : find(dest,\
    \ a, m, e);\n\t}\n\tprivate static int findRev(final long dest, final List<? extends\
    \ Number> a, final int s, final int e) {\n\t\tif(s == e) {\n\t\t\treturn s;\n\t\
    \t}\n\t\tfinal int m = (s + e + 1) / 2;\n\t\treturn a.get(m).longValue() > dest\
    \ ? findRev(dest, a, s, m - 1) : findRev(dest, a, m, e);\n\t}\n\tprivate static\
    \ int findRev(final char dest, final List<Character> a, final int s, final int\
    \ e) {\n\t\tif(s == e) {\n\t\t\treturn s;\n\t\t}\n\t\tfinal int m = (s + e + 1)\
    \ / 2;\n\t\treturn a.get(m).compareTo(dest) > 0 ? find(dest, a, s, m - 1) : find(dest,\
    \ a, m, e);\n\t}\n\tprotected static boolean binarySearch(final int[] a, final\
    \ int x) {\n\t\treturn Arrays.binarySearch(a, x) >= 0;\n\t}\n\tprotected static\
    \ boolean binarySearch(final long[] a, final long x) {\n\t\treturn Arrays.binarySearch(a,\
    \ x) >= 0;\n\t}\n\tprotected static int lowerBound(final int[] a, final int x)\
    \ {\n\t\tfinal int id = Arrays.binarySearch(a, x);\n\t\treturn id < 0 ? -(id +\
    \ 1) : id;\n\t}\n\tprotected static int lowerBound(final long[] a, final long\
    \ x) {\n\t\tfinal int id = Arrays.binarySearch(a, x);\n\t\treturn id < 0 ? -(id\
    \ + 1) : id;\n\t}\n\tprotected static int upperBound(final int[] a, final int\
    \ x) {\n\t\tint id = Arrays.binarySearch(a, x);\n\t\tif(id >= 0) {\n\t\t\twhile(id\
    \ < a.length && a[id] == x) {\n\t\t\t\tid++;\n\t\t\t}\n\t\t} else {\n\t\t\tid\
    \ = -(id + 1);\n\t\t}\n\t\treturn id;\n\t}\n\tprotected static int upperBound(final\
    \ long[] a, final long x) {\n\t\tint id = Arrays.binarySearch(a, x);\n\t\tif(id\
    \ >= 0) {\n\t\t\twhile(id < a.length && a[id] == x) {\n\t\t\t\tid++;\n\t\t\t}\n\
    \t\t} else {\n\t\t\tid = -(id + 1);\n\t\t}\n\t\treturn id;\n\t}\n\tprotected static\
    \ boolean binarySearch(final List<Integer> a, final int x) {\n\t\treturn Collections.binarySearch(a,\
    \ x) >= 0;\n\t}\n\tprotected static boolean binarySearch(final List<Long> a, final\
    \ long x) {\n\t\treturn Collections.binarySearch(a, x) >= 0;\n\t}\n\tprotected\
    \ static int lowerBound(final List<Integer> a, final int x) {\n\t\treturn ~Collections.binarySearch(a,\
    \ x, (p, q) -> p.compareTo(q) >= 0 ? 1 : -1);\n\t}\n\tprotected static int lowerBound(final\
    \ List<Long> a, final long x) {\n\t\treturn ~Collections.binarySearch(a, x, (p,\
    \ q) -> p.compareTo(q) >= 0 ? 1 : -1);\n\t}\n\tprotected static int upperBound(final\
    \ List<Integer>a, final int x) {\n\t\treturn ~Collections.binarySearch(a, x, (p,\
    \ q) -> p.compareTo(q) > 0 ? 1 : -1);\n\t}\n\tprotected static int upperBound(final\
    \ List<Long> a, final long x) {\n\t\treturn ~Collections.binarySearch(a, x, (p,\
    \ q) -> p.compareTo(q) > 0 ? 1 : -1);\n\t}\n\tprotected static int[] reverse(final\
    \ int[] a) {\n\t\tfinal int n = a.length;\n\t\tint[] b = new int[n];\n\t\tfor(int\
    \ i = 0; i <= n / 2; ++i) {\n\t\t\tb[i] = a[n - 1 - i];\n\t\t\tb[n - 1 - i] =\
    \ a[i];\n\t\t}\n\t\treturn b;\n\t}\n\tprotected static long[] reverse(final long[]\
    \ a) {\n\t\tfinal int n = a.length;\n\t\tlong[] b = new long[n];\n\t\tfor(int\
    \ i = 0; i <= n / 2; ++i) {\n\t\t\tb[i] = a[n - 1 - i];\n\t\t\tb[n - 1 - i] =\
    \ a[i];\n\t\t}\n\t\treturn b;\n\t}\n\tprotected static double[] reverse(final\
    \ double[] a) {\n\t\tfinal int n = a.length;\n\t\tdouble[] b = new double[n];\n\
    \t\tfor(int i = 0; i <= n / 2; ++i) {\n\t\t\tb[i] = a[n - 1 - i];\n\t\t\tb[n -\
    \ 1 - i] = a[i];\n\t\t}\n\t\treturn b;\n\t}\n\tprotected static Object[] reverse(final\
    \ Object[] a) {\n\t\tfinal int n = a.length;\n\t\tObject[] b = new Object[n];\n\
    \t\tfor(int i = 0; i <= n / 2; ++i) {\n\t\t\tb[i] = a[n - 1 - i];\n\t\t\tb[n -\
    \ 1 - i] = a[i];\n\t\t}\n\t\treturn b;\n\t}\n\tprotected static int[] rotate(final\
    \ int[] a, final int id) {\n\t\tArrayList<Integer> t = new ArrayList<>(a.length);\n\
    \t\tfor(final var el: a) {\n\t\t\tt.add(el);\n\t\t}\n\t\tCollections.rotate(t,\
    \ id);\n\t\tint[] res = new int[t.size()];\n\t\tfor(int i = 0; i < t.size(); ++i)\
    \ {\n\t\t\tres[i] = t.get(i);\n\t\t}\n\t\treturn res;\n\t}\n\tprotected static\
    \ long[] rotate(final long[] a, final int id) {\n\t\tArrayList<Long> t = new ArrayList<>(a.length);\n\
    \t\tfor(final var el: a) {\n\t\t\tt.add(el);\n\t\t}\n\t\tCollections.rotate(t,\
    \ id);\n\t\tlong[] res = new long[t.size()];\n\t\tfor(int i = 0; i < t.size();\
    \ ++i) {\n\t\t\tres[i] = t.get(i);\n\t\t}\n\t\treturn res;\n\t}\n\tprotected static\
    \ double[] rotate(final double[] a, final int id) {\n\t\tArrayList<Double> t =\
    \ new ArrayList<>(a.length);\n\t\tfor(final var el: a) {\n\t\t\tt.add(el);\n\t\
    \t}\n\t\tCollections.rotate(t, id);\n\t\tdouble[] res = new double[t.size()];\n\
    \t\tfor(int i = 0; i < t.size(); ++i) {\n\t\t\tres[i] = t.get(i);\n\t\t}\n\t\t\
    return res;\n\t}\n\tprotected static String rotate(final String s, final int id)\
    \ {\n\t\tArrayList<Character> t = new ArrayList<>();\n\t\tfor(final char c: s.toCharArray())\
    \ {\n\t\t\tt.add(c);\n\t\t}\n\t\tCollections.rotate(t, id);\n\t\tStringBuilder\
    \ sb = new StringBuilder();\n\t\tfor(final var c: t) {\n\t\t\tsb.append(c);\n\t\
    \t}\n\t\treturn sb.toString(); \n\t}\n\tprotected static int[][] rotate(final\
    \ int[][] a) {\n\t\tfinal int h = a.length, w = a[0].length;\n\t\tint[][] b =\
    \ new int[w][h];\n\t\tIntStream.range(0, h).forEach(i -> {\n\t\t\tIntStream.range(0,\
    \ w).forEach(j -> b[j][i] = a[i][j]);\n\t\t});\n\t\tIntStream.range(0, w).forEach(i\
    \ -> b[i] = reverse(b[i]));\n\t\treturn b;\n\t}\n\tprotected static long[][] rotate(final\
    \ long[][] a) {\n\t\tfinal int h = a.length, w = a[0].length;\n\t\tlong[][] b\
    \ = new long[w][h];\n\t\tIntStream.range(0, h).forEach(i -> {\n\t\t\tIntStream.range(0,\
    \ w).forEach(j -> b[j][i] = a[i][j]);\n\t\t});\n\t\tIntStream.range(0, w).forEach(i\
    \ -> b[i] = reverse(b[i]));\n\t\treturn b;\n\t}\n\tprotected static double[][]\
    \ rotate(final double[][] a) {\n\t\tfinal int h = a.length, w = a[0].length;\n\
    \t\tdouble[][] b = new double[w][h];\n\t\tIntStream.range(0, h).forEach(i -> {\n\
    \t\t\tIntStream.range(0, w).forEach(j -> b[j][i] = a[i][j]);\n\t\t});\n\t\tIntStream.range(0,\
    \ w).forEach(i -> b[i] = reverse(b[i]));\n\t\treturn b;\n\t}\n\tprotected static\
    \ String[] rotate(final String[] s) {\n\t\tfinal int h = s.length, w = s[0].length();\n\
    \t\tchar[][] t = new char[w][h];\n\t\tIntStream.range(0, h).forEach(i -> {\n\t\
    \t\tIntStream.range(0, w).forEach(j -> t[j][i] = s[i].charAt(j));\n\t\t});\n\t\
    \tIntStream.range(0, w).forEach(i -> t[i] = new StringBuilder(new String(t[i])).reverse().toString().toCharArray());\n\
    \t\tString[] res = new String[w];\n\t\tIntStream.range(0, w).forEach(i -> res[i]\
    \ = new String(t[i]));\n\t\treturn res;\n\t}\n\tprotected static long lcm(final\
    \ long a, final long b){ return a * b / gcd(a, b); }\n\tprotected static long\
    \ gcd(final long a, final long b){ return b > 0 ? gcd(b, a % b) : a; }\n\tprotected\
    \ static long lcm(final long... a){ return Arrays.stream(a).reduce(1, (x, y) ->\
    \ lcm(x, y)); }\n\tprotected static long gcd(final long... a){ return Arrays.stream(a).reduce(0,\
    \ (x, y) -> gcd(x, y)); }\n\tprotected static long min(final long... a){ return\
    \ Arrays.stream(a).reduce(Long.MAX_VALUE, (x, y) -> Math.min(x, y)); }\n\tprotected\
    \ static long max(final long... a){ return Arrays.stream(a).reduce(Long.MIN_VALUE,\
    \ (x, y) -> Math.max(x, y)); }\n\tprotected static <F, S> ArrayList<F> first(final\
    \ List<Pair<F, S>> p) {\n\t\tArrayList<F> f = new ArrayList<>();\n\t\tfor(final\
    \ var el: p) {\n\t\t\tf.add(el.first);\n\t\t}\n\t\treturn f;\n\t}\n\tprotected\
    \ static <F, S> ArrayList<S> second(final List<Pair<F, S>> p) {\n\t\tArrayList<S>\
    \ s = new ArrayList<>();\n\t\tfor(final var el: p) {\n\t\t\ts.add(el.second);\n\
    \t\t}\n\t\treturn s;\n\t}\n\tprotected static int[] iota(final int n){ return\
    \ IntStream.range(0, n).toArray(); }\n\tprotected static int[] iota(final int\
    \ n, final int init){ return IntStream.range(0 + init, n + init).toArray(); }\n\
    \tprotected static long bins(long ok, long ng, final Predicate<Long> fn) {\n\t\
    \twhile(Math.abs(ok - ng) > 1) {\n\t\t\tfinal long mid = (ok + ng) / 2;\n\t\t\t\
    if(fn.test(mid)) {\n\t\t\t\tok = mid;\n\t\t\t}\n\t\t\telse {\n\t\t\t\tng = mid;\n\
    \t\t\t}\n\t\t}\n\t\treturn ok;\n\t}\n\tprotected static ArrayList<Integer> press(final\
    \ ArrayList<Long> a) {\n\t\tArrayList<Integer> res = new ArrayList<>();\n\t\t\
    final var cp = a.stream().sorted().distinct().collect(Collectors.toList());\n\t\
    \tfor(final var el: a) {\n\t\t\tres.add(lowerBound(cp, el));\n\t\t}\n\t\treturn\
    \ res;\n\t}\n\tprotected static int[] zAlgorithm(final String s) {\n\t\tfinal\
    \ int n = s.length();\n\t\tint j = 0;\n\t\tint[] pre = new int[n];\n\t\tfor(int\
    \ i = 0; ++i < n;) {\n\t\t\tif(i + pre[i - j] < j + pre[j]) {\n\t\t\t\tpre[i]\
    \ = pre[i - j];\n\t\t\t}\n\t\t\telse {\n\t\t\t\tint k = Math.max(0, j + pre[j]\
    \ - i);\n\t\t\t\twhile(i + k < n && s.charAt(k) == s.charAt(i + k)) {\n\t\t\t\t\
    \t++k;\n\t\t\t\t}\n\t\t\t\tpre[i] = k;\n\t\t\t\tj = i;\n\t\t\t}\n\t\t}\n\t\tpre[0]\
    \ = n;\n\t\treturn pre;\n\t}\n\tprotected static int[] manacher(final String s_,\
    \ final boolean calcEven) {\n\t\tint n = s_.length();\n\t\tchar[] s;\n\t\tif(calcEven)\
    \ {\n\t\t\ts = new char[2 * n - 1];\n\t\t\tIntStream.range(0, n).forEach(i ->\
    \ s[i] = s_.charAt(i));\n\t\t\tfor(int i = n; --i >= 0;) {\n\t\t\t\ts[2 * i] =\
    \ s_.charAt(i);\n\t\t\t}\n\t\t\tfinal var d = Collections.min(s_.chars().mapToObj(c\
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
    \ 1;\n\t\t\t}\n\t\t}\n\t\treturn rad;\n\t}\n\tprotected static long kthRoot(final\
    \ long n, final int k) {\n\t\tif(k == 1) {\n\t\t\treturn n;\n\t\t}\n\t\tfinal\
    \ Predicate<Long> chk = (x) -> {\n\t\t\tlong mul = 1;\n\t\t\tfor(int j = 0; j\
    \ < k; ++j) {\n\t\t\t\ttry {\n\t\t\t\t\tmul = Math.multiplyExact(mul, x);\n\t\t\
    \t\t} catch(ArithmeticException e) {\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\
    \t}\n\t\t\treturn mul <= n;\n\t\t};\n\t\tlong ret = 0;\n\t\tfor(int i = 32; --i\
    \ >= 0;) {\n\t\t\tif(chk.test(ret | (1L << i))) {\n\t\t\t\tret |= 1L << i;\n\t\
    \t\t}\n\t\t}\n\t\treturn ret;\n\t}\n}\n\nclass MyScanner {\n\tprivate Scanner\
    \ sc = new Scanner(System.in);\n\tint ni(){ return sc.nextInt(); }\n\tlong nl(){\
    \ return sc.nextLong(); }\n\tdouble nd(){ return sc.nextDouble(); }\n\tString\
    \ ns(){ return sc.next(); }\n\tint[] ni(final int n){\n\t\tint[] a = new int[n];\n\
    \t\tIntStream.range(0, n).forEach(i -> a[i] = ni());\n\t\treturn a;\n\t}\n\tlong[]\
    \ nl(final int n){\n\t\tlong[] a = new long[n];\n\t\tIntStream.range(0, n).forEach(i\
    \ -> a[i] = nl());\n\t\treturn a;\n\t}\n\tdouble[] nd(final int n){\n\t\tdouble[]\
    \ a = new double[n];\n\t\tIntStream.range(0, n).forEach(i -> a[i] = nd());\n\t\
    \treturn a;\n\t}\n\tString[] ns(final int n){\n\t\tString[] a = new String[n];\n\
    \t\tIntStream.range(0, n).forEach(i -> a[i] = ns());\n\t\treturn a;\n\t}\n\tArrayList<Integer>\
    \ nia(final int n) {\n\t\tvar a = new ArrayList<Integer>(n);\n\t\tIntStream.range(0,\
    \ n).forEach(i -> a.add(i, ni()));\n\t\treturn a;\n\t}\n\tArrayList<Long> nla(final\
    \ int n) {\n\t\tvar a = new ArrayList<Long>(n);\n\t\tIntStream.range(0, n).forEach(i\
    \ -> a.add(i, nl()));\n\t\treturn a;\n\t}\n\tArrayList<Double> nda(final int n)\
    \ {\n\t\tvar a = new ArrayList<Double>(n);\n\t\tIntStream.range(0, n).forEach(i\
    \ -> a.add(i, nd()));\n\t\treturn a;\n\t}\n\tArrayList<String> nsa(final int n)\
    \ {\n\t\tvar a = new ArrayList<String>(n);\n\t\tIntStream.range(0, n).forEach(i\
    \ -> a.add(i, ns()));\n\t\treturn a;\n\t}\n\tvoid close(){ sc.close(); }\n}\n\n\
    class MyPrinter {\n\tprivate PrintWriter pw;\n\tMyPrinter(final OutputStream os,\
    \ final boolean flush){ pw = new PrintWriter(os, flush); }\n\tvoid print(final\
    \ Object arg){ pw.print(arg); }\n\tvoid out(){ pw.println(); }\n\tvoid out(final\
    \ Object head, final Object... tail) {\n\t\tpw.print(head);\n\t\tfor(final var\
    \ el: tail) {\n\t\t\tpw.print(\" \" + el);\n\t\t}\n\t\tout();\n\t}\n\t<F, S> void\
    \ out(final Pair<F, S> arg){ pw.println(arg.first + \" \" + arg.second); }\n\t\
    void out(final int[] args){ IntStream.range(0, args.length).forEach(i -> pw.print(args[i]\
    \ + (i + 1 < args.length ? \" \" : \"\\n\"))); }\n\tvoid out(final long[] args){\
    \ IntStream.range(0, args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length\
    \ ? \" \" : \"\\n\"))); }\n\tvoid out(final double[] args){ IntStream.range(0,\
    \ args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length ? \" \" :\
    \ \"\\n\"))); }\n\tvoid out(final boolean[] args){ IntStream.range(0, args.length).forEach(i\
    \ -> pw.print(args[i] + (i + 1 < args.length ? \" \" : \"\\n\"))); }\n\tvoid out(final\
    \ char[] args){ IntStream.range(0, args.length).forEach(i -> pw.print(args[i]\
    \ + (i + 1 < args.length ? \" \" : \"\\n\"))); }\n\tvoid out(final Object[] args){\
    \ IntStream.range(0, args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length\
    \ ? \" \" : \"\\n\"))); }\n\t<T> void out(final List<T> args){ IntStream.range(0,\
    \ args.size()).forEach(i -> pw.print(args.get(i) + (i + 1 < args.size() ? \" \"\
    \ : \"\\n\"))); }\n\tvoid outl(final Object head, final Object... tail) {\n\t\t\
    out(head);\n\t\tArrays.stream(tail).forEach(pw::println);\n\t}\n\tvoid outl(final\
    \ int[] args){ Arrays.stream(args).forEach(pw::println); }\n\tvoid outl(final\
    \ int[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }\n\
    \tvoid outl(final long[] args){ Arrays.stream(args).forEach(pw::println); }\n\t\
    void outl(final long[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i]));\
    \ }\n\tvoid outl(final double[] args){ Arrays.stream(args).forEach(pw::println);\
    \ }\n\tvoid outl(final double[][] args){ IntStream.range(0, args.length).forEach(i\
    \ -> out(args[i])); }\n\tvoid outl(final boolean[] args){ IntStream.range(0, args.length).forEach(i\
    \ -> out(args[i])); }\n\tvoid outl(final boolean[][] args){ IntStream.range(0,\
    \ args.length).forEach(i -> out(args[i])); }\n\tvoid outl(final char[] args){\
    \ IntStream.range(0, args.length).forEach(i -> out(args[i])); }\n\tvoid outl(final\
    \ Object[] args){ Arrays.stream(args).forEach(pw::println); }\n\t<E> void outl(final\
    \ Collection<E> args){ args.stream().forEach(pw::println); }\n\tvoid fin(final\
    \ Object head, final Object... tail) {\n\t\tout(head, tail);\n\t\tflush();\n\t\
    \tSystem.exit(0);\n\t}\n\t<T> void fin(final List<T> args) {\n\t\tout(args);\n\
    \t\tflush();\n\t\tSystem.exit(0);\n\t}\n\t<E> void fine(final Collection<E> args)\
    \ {\n\t\toutl(args);\n\t\tflush();\n\t\tSystem.exit(0);\n\t}\n\tvoid flush(){\
    \ pw.flush(); }\n\tvoid close(){ pw.close(); }\n}\n\nclass Pair<F, S> {\n\tprotected\
    \ final F first;\n\tprotected final S second;\n\tPair(final F first, final S second)\
    \ {\n\t\tthis.first = first;\n\t\tthis.second = second;\n\t}\n\t@Override\n\t\
    public boolean equals(final Object o) {\n\t\tif(this == o) {\n\t\t\treturn true;\n\
    \t\t}\n\t\tif(o == null || getClass() != o.getClass()) {\n\t\t\treturn false;\n\
    \t\t}\n\t\tfinal Pair<?, ?> p = (Pair<?, ?>) o;\n\t\tif(!first.equals(p.first))\
    \ {\n\t\t\treturn false;\n\t\t}\n\t\treturn second.equals(p.second);\n\t}\n\t\
    @Override\n\tpublic int hashCode(){ return 31 * first.hashCode() + second.hashCode();\
    \ }\n\t@Override\n\tpublic String toString(){ return \"(\" + first + \", \" +\
    \ second + \")\"; }\n\tpublic static <F, S> Pair<F, S> of(final F a, final S b){\
    \ return new Pair<>(a, b); }\n\tPair<S, F> swap(){ return Pair.of(second, first);\
    \ }\n}\nclass NumPair extends Pair<Number, Number> implements Comparable<NumPair>\
    \  {\n\tNumPair(final Number first, final Number second){ super(first, second);\
    \ }\n\tNumPair rotate(){ return new NumPair(-second.doubleValue(), first.doubleValue());\
    \ } \n\tNumPair rotate(final int ang) {\n\t\tfinal double rad = Math.toRadians(Utility.mod(ang,\
    \ 360));\n\t\treturn new NumPair(first.doubleValue() * Math.cos(rad) - second.doubleValue()\
    \ * Math.sin(rad),\n\t\t\t\t\t\t\tfirst.doubleValue() * Math.sin(rad) + second.doubleValue()\
    \ * Math.cos(rad));\n\t}\n\tlong dot(final NumPair p){ return first.longValue()\
    \ * p.first.longValue() + second.longValue() + p.second.longValue(); }\n\tdouble\
    \ dotf(final NumPair p){ return first.doubleValue() * p.first.doubleValue() +\
    \ second.doubleValue() + p.second.doubleValue(); }\n\tlong cross(final NumPair\
    \ p){ return this.rotate().dot(p); }\n\tdouble crossf(final NumPair p){ return\
    \ this.rotate().dotf(p); }\n\tlong sqr(){ return this.dot(this); }\n\tdouble sqrf(){\
    \ return this.dotf(this); }\n\tdouble grad() { \n\t\ttry {\n\t\t\treturn second.doubleValue()\
    \ / first.doubleValue();\n\t\t} catch(ArithmeticException e) {\n\t\t\te.printStackTrace();\n\
    \t\t}\n\t\treturn Double.NaN;\n\t}\n\tdouble abs(){ return Math.hypot(first.doubleValue(),\
    \ second.doubleValue()); }\n\tlong lcm(){ return Utility.lcm(first.longValue(),\
    \ second.longValue()); }\n\tlong gcd(){ return Utility.gcd(first.longValue(),\
    \ second.longValue()); }\n\tNumPair extgcd() {\n\t\tlong x = 1, y = 0, t1 = 0,\
    \ t2 = 0, t3 = 1, a = first.longValue(), b = second.longValue();\n\t\twhile(b\
    \ > 0) {\n\t\t\tt1 = a / b;\n\t\t\ta -= t1 * b;\n\t\t\ta ^= b;\n\t\t\tb ^= a;\n\
    \t\t\ta ^= b;\n\t\t\tx -= t1 * t2;\n\t\t\tx ^= t2;\n\t\t\tt2 ^= x;\n\t\t\tx ^=\
    \ t2;\n\t\t\ty -= t1 * t3;\n\t\t\ty ^= t3;\n\t\t\tt3 ^= y;\n\t\t\ty ^= t3;\n\t\
    \t}\n\t\treturn new NumPair(x, y);\n\t}\n\t@Override\n\tpublic int compareTo(final\
    \ NumPair o) {\n\t\tif(first.doubleValue() == o.first.doubleValue()) {\n\t\t\t\
    return Double.compare(second.doubleValue(), o.second.doubleValue());\n\t\t}\n\t\
    \treturn Double.compare(first.doubleValue(), o.first.doubleValue());\n\t}\n}\n\
    \nclass UnionFind {\n\tprivate int[] par;\n\tUnionFind(final int n) {\n\t\tpar\
    \ = new int[n];\n\t\tArrays.fill(par, -1);\n\t}\n\tint root(final int i){ return\
    \ par[i] >= 0 ? par[i] = root(par[i]) : i; }\n\tint size(final int i){ return\
    \ -par[root(i)]; }\n\tboolean unite(int i, int j) {\n\t\ti = root(i);\n\t\tj =\
    \ root(j);\n\t\tif(i == j) return false;\n\t\tif(i > j) {\n\t\t\ti ^= j;\n\t\t\
    \tj ^= i;\n\t\t\ti ^= j;\n\t\t}\n\t\tpar[i] += par[j];\n\t\tpar[j] = i;\n\t\t\
    return true;\n\t}\n\tboolean same(final int i, final int j){ return root(i) ==\
    \ root(j); }\n\tArrayList<ArrayList<Integer>> groups() {\n\t\tfinal int n = par.length;\n\
    \t\tArrayList<ArrayList<Integer>> res = new ArrayList<>(n);\n\t\tIntStream.range(0,\
    \ n).forEach(i -> res.add(new ArrayList<>()));\n\t\tIntStream.range(0, n).forEach(i\
    \ -> res.get(root(i)).add(i));\n\t\tres.removeIf(ArrayList::isEmpty);\n\t\treturn\
    \ res;\n\t}\n\tboolean isBipartite() {\n\t\tfinal int n = par.length / 2;\n\t\t\
    boolean ok = true;\n\t\tfor(int i = 0; i < n; ++i) {\n\t\t\tok &= root(i) != root(i\
    \ + n);\n\t\t}\n\t\treturn ok;\n\t}\n}\n\nclass WeightedUnionFind {\n\tprivate\
    \ int[] par;\n\tprivate long[] weight;\n\tWeightedUnionFind(final int n) {\n\t\
    \tpar = new int[n];\n\t\tweight = new long[n];\n\t\tArrays.fill(par, -1);\n\t\
    }\n\tint root(final int i) {\n\t\tif(par[i] < 0) {\n\t\t\treturn i;\n\t\t}\n\t\
    \tfinal int r = root(par[i]);\n\t\tweight[i] += weight[par[i]];\n\t\treturn par[i]\
    \ = r;\n\t}\n\tlong get(final int i) {\n\t\troot(i);\n\t\treturn weight[i];\n\t\
    }\n\tlong diff(final int x, final int y){ return get(y) - get(x); }\n\tint unite(int\
    \ x, int y, long w) {\n\t\tw += diff(y, x);\n\t\tx = root(x);\n\t\ty = root(y);\n\
    \t\tif(x == y) {\n\t\t\treturn w == 0 ? 0 : -1;\n\t\t}\n\t\tif(par[x] > par[y])\
    \ {\n\t\t\tx ^= y;\n\t\t\ty ^= x;\n\t\t\tx ^= y;\n\t\t\tw = -w;\n\t\t}\n\t\tpar[x]\
    \ += par[y];\n\t\tpar[y] = x;\n\t\tweight[y] = w;\n\t\treturn 1;\n\t}\n\tboolean\
    \ same(final int x, final int y){ return root(x) == root(y); }\n}\n\nclass UndoUnionFind\
    \ {\n\tprivate int[] par;\n\tprivate Stack<Pair<Integer, Integer>> his;\n\tUndoUnionFind(final\
    \ int n) {\n\t    par = new int[n];\n\t    Arrays.fill(par, -1);\n\t    his =\
    \ new Stack<>();\n\t}\n\tboolean unite(int x, int y) {\n\t\tx = root(x);\n\t\t\
    y = root(y);\n\t\this.add(Pair.of(x, par[x]));\n\t\this.add(Pair.of(y, par[y]));\n\
    \t\tif(x == y) {\n\t\t\treturn false;\n\t\t}\n\t\tif(par[x] > par[y]) {\n\t\t\t\
    x ^= y;\n\t\t\ty ^= x;\n\t\t\tx ^= y;\n\t\t}\n\t\tpar[x] += par[y];\n\t\tpar[y]\
    \ = x;\n\t\treturn true;\n\t}\n\tint root(final int i) {\n\t\tif(par[i] < 0) {\n\
    \t\t\treturn i;\n\t\t}\n\t\treturn root(par[i]);\n\t}\n\tint size(final int i){\
    \ return -par[root(i)]; }\n\tvoid undo() {\n\t\tfinal Pair<Integer, Integer> pop1\
    \ = his.pop(), pop2 = his.pop();\n\t\tpar[pop1.first] = pop1.second;\n\t\tpar[pop2.first]\
    \ = pop2.second;\n\t}\n\tvoid snapshot() {\n\t\twhile(!his.empty()) {\n\t\t\t\
    his.pop();\n\t\t}\n\t}\n\tvoid rollback() {\n\t\twhile(!his.empty()) {\n\t\t\t\
    undo();\n\t\t}\n\t}\n}\n\nclass Edge {\n\tpublic int src;\n\tpublic int to;\n\t\
    public long cost;\n\tEdge(final int to) {\n\t\tthis.to = to;\n\t}\n\tEdge(final\
    \ int to, final long cost) {\n\t\tthis.to = to;\n\t\tthis.cost = cost;\n\t}\n\t\
    Edge(final int src, final int to, final long cost) {\n\t\tthis.src = src;\n\t\t\
    this.to = to;\n\t\tthis.cost = cost;\n\t}\n\t@Override\n\tpublic boolean equals(final\
    \ Object o) {\n\t\tif(this == o) {\n\t\t\treturn true;\n\t\t}\n\t\tif(o == null\
    \ || getClass() != o.getClass()) {\n\t\t\treturn false;\n\t\t}\n\t\tfinal Edge\
    \ e = (Edge) o;\n\t\tif(src != e.src) {\n\t\t\treturn false;\n\t\t}\n\t\tif(to\
    \ != e.to) {\n\t\t\treturn false;\n\t\t}\n\t\treturn cost == e.cost;\n\t}\n\t\
    @Override\n\tpublic int hashCode() {\n\t\tint result = 17;\n\t\tresult = 31 *\
    \ result + src;\n\t\tresult = 31 * result + to;\n\t\tresult = 31 * result + (int)\
    \ (cost ^ (cost >>> 32)); // XOR for long values\n\t\treturn result;\n\t}\n\t\
    @Override\n\tpublic String toString(){ return src + \" \" + to + \" \" + cost;\
    \ }\n}\nclass Graph extends ArrayList<ArrayList<Edge>> {\n\tprotected boolean\
    \ undirected;\n\tprotected int n, indexed;\n\tGraph(final int n, final int indexed,\
    \ final boolean undirected) {\n\t\tthis.n = n;\n\t\tthis.indexed = indexed;\n\t\
    \tthis.undirected = undirected;\n\t\tIntStream.range(0, n).forEach(i -> this.add(new\
    \ ArrayList<>()));\n\t}\n\tvoid addEdge(int a, int b) {\n\t\ta -= indexed;\n\t\
    \tb -= indexed;\n\t\tthis.get(a).add(new Edge(b));\n\t\tif(undirected) {\n\t\t\
    \tthis.get(b).add(new Edge(a));\n\t\t}\n\t}\n\tprotected int[] allDist(final int\
    \ v) {\n\t\tint[] d = new int[n];\n\t\tArrays.fill(d, -1);\n\t\tQueue<Integer>\
    \ q = new ArrayDeque<>();\n\t\td[v] = 0;\n\t\tq.add(v);\n\t\twhile(!q.isEmpty())\
    \ {\n\t\t\tfinal int tmp = q.poll();\n\t\t\tfor(final var el: this.get(tmp)) {\n\
    \t\t\t\tif(d[el.to] != -1) {\n\t\t\t\t\tcontinue;\n\t\t\t\t}\n\t\t\t\td[el.to]=d[tmp]+1;\n\
    \t\t\t\tq.add(el.to);\n\t\t\t}\n\t\t}\n\t\treturn d;\n\t}\n\tprotected int dist(final\
    \ int u, final int v){ return allDist(u)[v]; }\n}\nclass WeightedGraph extends\
    \ Graph {\n\tWeightedGraph(final int n, final int indexed, final boolean undirected)\
    \ {\n\t\tsuper(n, indexed, undirected);\n\t}\n\tvoid addEdge(int a, int b, final\
    \ long cost) {\n\t\ta -= indexed;\n\t\tb -= indexed;\n\t\tthis.get(a).add(new\
    \ Edge(b, cost));\n\t\tif(undirected) {\n\t\t\tthis.get(b).add(new Edge(a, cost));\n\
    \t\t}\n\t}\n\tlong[] dijkstra(final int v) {\n\t\tlong[] cost = new long[n];\n\
    \t\tArrays.fill(cost, Long.MAX_VALUE);\n\t\tQueue<NumPair> dj = new PriorityQueue<>(Collections.reverseOrder());\n\
    \t\tcost[v] = 0;\n\t\tdj.add(new NumPair(cost[v], v));\n\t\twhile(!dj.isEmpty())\
    \ {\n\t\t\tfinal var tmp = dj.poll();\n\t\t\tif(cost[tmp.second.intValue()] <\
    \ tmp.first.longValue()) {\n\t\t\t\tcontinue;\n\t\t\t}\n\t\t\tfor(final var el:\
    \ this.get(tmp.second.intValue())) {\n\t\t\t\tif(cost[el.to] > tmp.first.longValue()\
    \ + el.cost) {\n\t\t\t\t\tcost[el.to] = tmp.first.longValue() + el.cost;\n\t\t\
    \t\t\tdj.add(new NumPair(cost[el.to], el.to));\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\t\
    return cost;\n\t}\n\tlong[][] warshallFloyd() {\n\t\tlong[][] cost = new long[n][n];\n\
    \t\tIntStream.range(0, n).forEach(i -> Arrays.fill(cost[i], Long.MAX_VALUE));\n\
    \t\tIntStream.range(0, n).forEach(i -> cost[i][i] = 0);\n\t\tfor(int i = 0; i\
    \ < n; ++i) {\n\t\t\tfor(final var j: this.get(i)) {\n\t\t\t\tcost[i][j.to] =\
    \ j.cost;\n\t\t\t}\n\t\t}\n\t\tfor(int k = 0 ; k < n; ++k) {\n\t\t\tfor(int i\
    \ = 0; i < n; ++i) {\n\t\t\t\tfor(int j = 0; j < n; ++j) {\n\t\t\t\t\tif(cost[i][j]\
    \ > cost[i][k] + cost[k][j]) {\n\t\t\t\t\t\tcost[i][j] = cost[i][k] + cost[k][j];\n\
    \t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\treturn cost;\n\t}\n}\nclass Tree {\n\
    \tprivate ArrayList<Edge> edge;\n\tprivate int n, indexed;\n\tTree(final int n,\
    \ final int indexed) {\n\t\tedge = new ArrayList<>(n);\n\t\tthis.n = n;\n\t\t\
    this.indexed = indexed;\n\t}\n\tvoid addEdge(final int a, final int b, final long\
    \ cost){ edge.add(new Edge(a - indexed, b - indexed, cost)); }\n\tlong kruskal()\
    \ {\n\t\tCollections.sort(edge, Comparator.comparing(e -> e.cost));\n\t\tUnionFind\
    \ uf = new UnionFind(n);\n\t\tlong res = 0;\n\t\tfor(final var ed: edge) {\n\t\
    \t\tif(uf.unite(ed.src, ed.to)) {\n\t\t\t\tres += ed.cost;\n\t\t\t}\n\t\t}\n\t\
    \treturn res;\n\t}\n}\n\nclass LowestCommonAncestor<G extends Graph> {\n\tprivate\
    \ int log;\n\tint[] dep;\n\tprivate G g;\n\tint[][] table;\n\tLowestCommonAncestor(final\
    \ G g) {\n\t\tthis.g = g;\n\t\tfinal int n = g.size();\n\t\tdep = new int[n];\n\
    \t\tlog = Integer.toBinaryString(n).length();\n\t\ttable = new int[log][n];\n\t\
    \tIntStream.range(0, log).forEach(i -> Arrays.fill(table[i], -1));\n\t\tbuild();\n\
    \t}\n\tprivate void dfs(final int idx, final int par, final int d) {\n\t\ttable[0][idx]\
    \ = par;\n\t\tdep[idx] = d;\n\t\tfor(final var el: g.get(idx)) {\n\t\t\tif(el.to\
    \ != par) {\n\t\t\t\tdfs(el.to, idx, d + 1);\n\t\t\t}\n\t\t}\n\t}\n\tprivate void\
    \ build() {\n\t\tdfs(0, -1, 0);\n\t\tfor(int k = 0; k < log - 1; ++k) {\n\t\t\t\
    for(int i = 0; i < table[k].length; ++i) {\n\t\t\t\tif(table[k][i] == -1) {\n\t\
    \t\t\t\ttable[k + 1][i] = -1;\n\t\t\t\t} else {\n\t\t\t\t\ttable[k + 1][i] = table[k][table[k][i]];\n\
    \t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\tint query(int u, int v) {\n\t\tif(dep[u] > dep[v])\
    \ {\n\t\t\tu ^= v;\n\t\t\tv ^= u;\n\t\t\tu ^= v;\n\t\t}\n\t\tfor(int i = log;\
    \ --i >= 0;) {\n\t\t\tif(((dep[v] - dep[u]) >> i) % 2 == 1) {\n\t\t\t\tv = table[i][v];\n\
    \t\t\t}\n\t\t}\n\t\tif(u == v) {\n\t\t\treturn u;\n\t\t}\n\t\tfor(int i = log;\
    \ --i >= 0;) {\n\t\t\tif(table[i][u] != table[i][v]) {\n\t\t\t\tu = table[i][u];\n\
    \t\t\t\tv = table[i][v];\n\t\t\t}\n\t\t}\n\t\treturn table[0][u];\n\t}\n\tint\
    \ dist(final int u, final int v){ return dep[u] + dep[v] - 2 * query(u, v); }\n\
    }\n\nclass PrimeTable {\n\tprivate int n, size;\n\tprivate boolean[] sieve;\n\t\
    PrimeTable(final int n) {\n\t\tthis.n = n;\n\t\tsieve = new boolean[n + 1];\n\t\
    \tArrays.fill(sieve, true);\n\t\tsieve[0] = sieve[1] = false;\n\t\tfor(long i\
    \ = 2; i <= n; ++i) {\n\t\t\tif(!sieve[(int) i]) {\n\t\t\t\tcontinue;\n\t\t\t\
    }\n\t\t\tfor(long j = i * i; j <= n; j += i) {\n\t\t\t\tsieve[(int) j] = false;\n\
    \t\t\t}\n\t\t}\n\t\tsize = (int) IntStream.rangeClosed(0, n).filter(i -> sieve[i]).count();\n\
    \t}\n\tboolean[] table(){ return sieve; }\n\tint[] get() {\n\t\tint j = 0;\n\t\
    \tint[] p = new int[size];\n\t\tfor(int i = 2; i <= n; ++i) {\n\t\t\tif(sieve[i])\
    \ {\n\t\t\t\tp[j++] = i; \n\t\t\t}\n\t\t}\n\t\treturn p;\n\t}\n}\n\nclass PrimeFactor\
    \ {\n\tprivate int[] spf;\n\tPrimeFactor(final int n) {\n\t\tspf = IntStream.rangeClosed(0,\
    \ n).toArray();\n\t\tfor(int i = 2; i * i <= n; ++i) {\n\t\t\tif(spf[i] == i)\
    \ {\n\t\t\t\tfor(int j = i * i; j <= n; j += i) {\n\t\t\t\t\tif(spf[j] == j) {\n\
    \t\t\t\t\t\tspf[j] = i;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\tTreeMap<Integer,\
    \ Integer> get(int n) {\n\t\tTreeMap<Integer, Integer> m = new TreeMap<>();\n\t\
    \twhile(n != 1) {\n\t\t\tm.merge(spf[n], 1, (a, b) -> (a + b));\n\t\t\tn /= spf[n];\n\
    \t\t}\n\t\treturn m;\n\t}\n}\n\nclass PrimeCounter {\n\tprivate int sq;\n\tprivate\
    \ boolean[] p;\n\tprivate int[] psum;\n\tprivate ArrayList<Integer> ps;\n\tPrimeCounter(final\
    \ long lim) {\n\t\tsq = (int) kthRooti(lim, 2);\n\t\tpsum = new int[sq + 1];\n\
    \t\tp = new PrimeTable(sq).table();\n\t\tfor(int i = 1; i <= sq; ++i) {\n\t\t\t\
    psum[i] = psum[i - 1] + (p[i] ? 1 : 0);\n\t\t}\n\t\tps = new ArrayList<>();\n\t\
    \tfor(int i = 1; i <= sq; ++i) {\n\t\t\tif(p[i]) {\n\t\t\t\tps.add(i);\n\t\t\t\
    }\n\t\t}\n\t}\n\tprivate long kthRooti(final long n, final int k){ return Utility.kthRoot(n,\
    \ k); }\n\tprivate long p2(final long x, final long y) {\n\t\tif(x < 4) {\n\t\t\
    \treturn 0;\n\t\t}\n\t\tfinal long a = pi(y);\n\t\tfinal long b = pi(kthRooti(x,\
    \ 2));\n\t\tif(a >= b) {\n\t\t\treturn 0;\n\t\t}\n\t\tlong sum = (long) (a - 2)\
    \ * (a + 1) / 2 - (b - 2) * (b + 1) / 2;\n\t\tfor(long i = a; i < b; ++i) {\n\t\
    \t\tsum += pi(x / ps.get((int) i));\n\t\t}\n\t\treturn sum;\n\t}\n\tprivate long\
    \ phi(final long m, final long a) {\n\t\tif(m < 1) {\n\t\t\treturn 0;\n\t\t}\n\
    \t\tif(a > m) {\n\t\t\treturn 1;\n\t\t}\n\t\tif(a < 1) {\n\t\t\treturn m;\n\t\t\
    }\n\t\tif(m <= (long) ps.get((int) (a - 1)) * ps.get((int) (a - 1))) {\n\t\t\t\
    return pi(m) - a + 1;\n\t\t}\n\t\tif(m <= (long) ps.get((int) (a - 1)) * ps.get((int)\
    \ (a - 1)) * ps.get((int) (a - 1)) && m <= sq) {\n\t\t\tfinal long sx = pi(kthRooti(m,\
    \ 2));\n\t\t\tlong ans = pi(m) - (long) (sx + a - 2) * (sx - a + 1) / 2;\n\t\t\
    \tfor(long i = a; i < sx; ++i) {\n\t\t\t\tans += pi(m / ps.get((int) i));\n\t\t\
    \t}\n\t\t\treturn ans;\n\t\t}\n\t\treturn phi(m, a - 1) - phi(m / ps.get((int)\
    \ (a - 1)), a - 1);\n\t}\n\tlong pi(final long n) {\n\t\tif(n <= sq) {\n\t\t\t\
    return psum[(int) n];\n\t\t}\n\t\tfinal long m = kthRooti(n, 3);\n\t\tfinal long\
    \ a = pi(m);\n\t\treturn phi(n, a) + a - 1 - p2(n, m);\n\t}\n}\n\n// N <= 1e18;\n\
    class LongPrime {\n\tprivate int bsf(final long x){ return Long.numberOfTrailingZeros(x);\
    \ }\n\tprivate long gcd(long a, long b) {\n\t\ta = Math.abs(a);\n\t\tb = Math.abs(b);\n\
    \t\tif(a == 0) {\n\t\t\treturn b;\n\t\t}\n\t\tif(b == 0) {\n\t\t\treturn a;\n\t\
    \t}\n\t\tfinal int shift = bsf(a|b);\n\t\ta >>= bsf(a);\n\t\tdo {\n\t\t\tb >>=\
    \ bsf(b);\n\t\t\tif(a > b) {\n\t\t\t\ta ^= b;\n\t\t\t\tb ^= a;\n\t\t\t\ta ^= b;\n\
    \t\t\t}\n\t\t\tb -= a;\n\t\t} while(b > 0);\n\t\treturn a << shift;\n\t}\n\tboolean\
    \ isPrime(final long n) {\n\t\tif(n <= 1) {\n\t\t\treturn false;\n\t\t}\n\t\t\
    if(n == 2) {\n\t\t\treturn true;\n\t\t}\n\t\tif(n % 2 == 0) {\n\t\t\treturn false;\n\
    \t\t}\n\t\tlong d = n - 1;\n\t\twhile(d % 2 == 0) {\n\t\t\td /= 2;\n\t\t}\n\t\t\
    final long[] sample = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};\n\t\tfor(final\
    \ long a: sample) {\n\t\t\tif(n <= a) {\n\t\t\t\tbreak;\n\t\t\t}\n\t\t\tlong t\
    \ = d;\n\t\t\tBigInteger y = BigInteger.valueOf(a).modPow(BigInteger.valueOf(t),\
    \ BigInteger.valueOf(n));\n\t\t\twhile(t != n - 1 && !y.equals(BigInteger.ONE)\
    \ && !y.equals(BigInteger.valueOf(n).subtract(BigInteger.ONE))) {\n\t\t\t\ty =\
    \ y.multiply(y).mod(BigInteger.valueOf(n));\n\t\t\t\tt <<= 1;\n\t\t\t}\n\t\t\t\
    if(!y.equals(BigInteger.valueOf(n).subtract(BigInteger.ONE)) && t % 2 == 0) {\n\
    \t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t\treturn true;\n\t}\n\tprivate long find(final\
    \ long n) {\n\t\tif(isPrime(n)) {\n\t\t\treturn n;\n\t\t}\n\t\tif(n % 2 == 0)\
    \ {\n\t\t\treturn 2;\n\t\t}\n\t\tlong st = 0;\n\t\tfinal BiFunction<Long, Long,\
    \ Long> f = (x, y) -> { return BigInteger.valueOf(x).multiply(BigInteger.valueOf(x)).add(BigInteger.valueOf(y)).mod(BigInteger.valueOf(n)).longValue();\
    \ };\n\t\twhile(true) {\n\t\t\tst++;\n\t\t\tlong x = st, y = f.apply(x, st);\n\
    \t\t\twhile(true) {\n\t\t\t\tfinal long p = gcd(y - x + n, n);\n\t\t\t\tif(p ==\
    \ 0 || p == n) {\n\t\t\t\t\tbreak;\n\t\t\t\t}\n\t\t\t\tif(p != 1) {\n\t\t\t\t\t\
    return p;\n\t\t\t\t}\n\t\t\t\tx = f.apply(x, st);\n\t\t\t\ty = f.apply(f.apply(y,\
    \ st), st);\n\t\t\t}\n\t\t}\n\t}\n\tArrayList<Long> primeFactor(final long n)\
    \ {\n\t\tif(n == 1) return new ArrayList<>();\n\t\tfinal long x = find(n);\n\t\
    \tif(x == n) return new ArrayList<>(Arrays.asList(x));\n\t\tArrayList<Long> l\
    \ = primeFactor(x);\n\t\tfinal ArrayList<Long> r = primeFactor(n / x);\n\t\tl.addAll(r);\n\
    \t\tCollections.sort(l);\n\t\treturn l;\n\t}\n}\n// N > 1e18\nclass BigPrime {\n\
    \tprotected int bsf(final long x){ return Long.numberOfTrailingZeros(x); }\n\t\
    private BigInteger gcd(BigInteger a, BigInteger b) {\n\t\ta = a.abs();\n\t\tb\
    \ = b.abs();\n\t\tif(a.equals(BigInteger.ZERO)) {\n\t\t\treturn b;\n\t\t}\n\t\t\
    if(b.equals(BigInteger.ZERO)) {\n\t\t\treturn a;\n\t\t}\n\t\tfinal int shift =\
    \ bsf(a.or(b).longValue());\n\t\ta = a.shiftRight(bsf(a.longValue()));\n\t\tdo\
    \ {\n\t\t\tb = b.shiftRight(bsf(b.longValue()));\n\t\t\tif(a.compareTo(b) > 0)\
    \ {\n\t\t\t\tfinal var tmp = b;\n\t\t\t\tb = a;\n\t\t\t\ta = tmp;\n\t\t\t}\n\t\
    \t\tb = b.subtract(a);\n\t\t} while(b.compareTo(BigInteger.ZERO) > 0);\n\t\treturn\
    \ a.shiftLeft(shift);\n\t}\n\tboolean isPrime(final BigInteger n) {\n\t\tif(n.compareTo(BigInteger.ONE)\
    \ <= 0) {\n\t\t\treturn false;\n\t\t}\n\t\tif(n.equals(BigInteger.TWO)) {\n\t\t\
    \treturn true;\n\t\t}\n\t\tif(n.and(BigInteger.ONE).equals(BigInteger.valueOf(0)))\
    \ {\n\t\t\treturn false;\n\t\t}\n\t\tBigInteger d = n.subtract(BigInteger.ONE);\n\
    \t\twhile(d.and(BigInteger.ONE).equals(BigInteger.valueOf(0))) {\n\t\t\td = d.shiftRight(1);\n\
    \t\t}\n\t\tfinal long[] sample = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};\n\
    \t\tfor(final long a: sample) {\n\t\t\tif(n.compareTo(BigInteger.valueOf(a)) <=\
    \ 0) {\n\t\t\t\tbreak;\n\t\t\t}\n\t\t\tBigInteger t = d;\n\t\t\tBigInteger y =\
    \ BigInteger.valueOf(a).modPow(t, n);\n\t\t\twhile(!t.equals(n.subtract(BigInteger.ONE))\
    \ && !y.equals(BigInteger.ONE) && !y.equals(n.subtract(BigInteger.ONE))) {\n\t\
    \t\t\ty = y.multiply(y).mod(n);\n\t\t\t\tt = t.shiftLeft(1);\n\t\t\t}\n\t\t\t\
    if(!y.equals(n.subtract(BigInteger.ONE)) && t.and(BigInteger.ONE).equals(BigInteger.ZERO))\
    \ {\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t\treturn true;\n\t}\n\tprivate BigInteger\
    \ find(final BigInteger n) {\n\t\tif(isPrime(n)) {\n\t\t\treturn n;\n\t\t}\n\t\
    \tif(n.and(BigInteger.ONE).equals(BigInteger.ZERO)) {\n\t\t\treturn BigInteger.TWO;\n\
    \t\t}\n\t\tint st = 0;\n\t\tfinal BiFunction<BigInteger, Integer, BigInteger>\
    \ f = (x, y) -> { return x.multiply(x).add(BigInteger.valueOf(y)).mod(n); };\n\
    \t\twhile(true) {\n\t\t\tst++;\n\t\t\tBigInteger x = BigInteger.valueOf(st), y\
    \ = f.apply(x, st);\n\t\t\twhile(true) {\n\t\t\t\tfinal BigInteger p = gcd(y.subtract(x).add(n),\
    \ n);\n\t\t\t\tif(p.equals(BigInteger.ZERO) || p.equals(n)) {\n\t\t\t\t\tbreak;\n\
    \t\t\t\t}\n\t\t\t\tif(!p.equals(BigInteger.ONE)) {\n\t\t\t\t\treturn p;\n\t\t\t\
    \t}\n\t\t\t\tx = f.apply(x, st);\n\t\t\t\ty = f.apply(f.apply(y, st), st);\n\t\
    \t\t}\n\t\t}\n\t}\n\tArrayList<BigInteger> primeFactor(final BigInteger n) {\n\
    \t\tif(n.equals(BigInteger.ONE)) {\n\t\t\treturn new ArrayList<>();\n\t\t}\n\t\
    \tfinal BigInteger x = find(n);\n\t\tif(x.equals(n)) {\n\t\t\treturn new ArrayList<>(Arrays.asList(x));\n\
    \t\t}\n\t\tvar l = primeFactor(x);\n\t\tfinal var r = primeFactor(n.divide(x));\n\
    \t\tl.addAll(r);\n\t\tCollections.sort(l);\n\t\treturn l;\n\t}\n}\n\nclass PrefixSum\
    \ {\n\tprivate int n;\n\tprivate long[] s;\n\tPrefixSum(final int[] a) {\n\t\t\
    n = a.length;\n\t\ts = new long[n + 1];\n\t\tIntStream.range(0, n).forEach(i ->\
    \ s[i + 1] = s[i] + a[i]);\n\t}\n\tPrefixSum(final long[] a) {\n\t\tn = a.length;\n\
    \t\ts = new long[n + 1];\n\t\tIntStream.range(0, n).forEach(i -> s[i + 1] = s[i]\
    \ + a[i]);\n\t}\n\tlong[] get(){ return s; }\n\tlong query(final int l, final\
    \ int r){ return s[r] - s[l]; }\n}\n\nclass FenwickTree {\n\tprivate int n;\n\t\
    private long[] data;\n\tFenwickTree(final int n) {\n\t\tthis.n = n + 2;\n\t\t\
    data = new long[this.n + 1];\n\t}\n\tlong sum(int k) {\n\t\tif(k < 0) return 0;\n\
    \t\tlong ret = 0;\n\t\tfor(++k; k > 0; k -= k & -k) {\n\t\t\tret += data[k];\n\
    \t\t}\n\t\treturn ret;\n\t}\n\tlong sum(final int l, final int r){ return sum(r)\
    \ - sum(l - 1); }\n\tlong get(final int k){ return sum(k) - sum(k - 1); }\n\t\
    void add(int k, final long x) {\n\t\tfor(++k; k < n; k += k & -k) {\n\t\t\tdata[k]\
    \ += x;\n\t\t}\n\t}\n\tvoid imos(final int l, final int r, long x) {\n\t\tadd(l,\
    \ x);\n\t\tadd(r + 1, -x);\n\t}\n\tprivate int lg(final int n){ return 63 - Integer.numberOfLeadingZeros(n);\
    \ }\n\tint lowerBound(long w) {\n\t\tif(w <= 0) {\n\t\t\treturn 0;\n\t\t}\n\t\t\
    int x = 0;\n\t\tfor(int k = 1 << lg(n); k > 0; k >>= 1) {\n\t\t\tif(x + k <= n\
    \ - 1 && data[x + k] < w) {\n\t\t\t\tw -= data[x + k];\n\t\t\t\tx += k;\n\t\t\t\
    }\n\t\t}\n\t\treturn x;\n\t}\n\tint upper_bound(long w) {\n\t\tif(w < 0) {\n\t\
    \t\treturn 0;\n\t\t}\n\t\tint x = 0;\n\t\tfor(int k = 1 << lg(n); k > 0; k >>=\
    \ 1) {\n\t\t\tif(x + k <= n - 1 && data[x + k] <= w) {\n\t\t\t\tw -= data[x +\
    \ k];\n\t\t\t\tx += k;\n\t\t\t}\n\t\t}\n\t\treturn x;\n\t}\n}\n\nclass SegmentTree<T\
    \ extends Number> {\n\tprivate int n = 1, rank = 0, fini;\n\tprivate BinaryOperator<T>\
    \ op;\n\tprivate T e;\n\tprivate Object[] dat;\n\tSegmentTree(final int fini,\
    \ final BinaryOperator<T> op, final T e) {\n\t\tthis.fini = fini;\n\t\tthis.op\
    \ = op;\n\t\tthis.e = e;\n\t\twhile(this.fini > n) {\n\t\t\tn <<= 1;\n\t\t\trank++;\n\
    \t\t}\n\t\tdat = new Object[2 * n];\n\t\tArrays.fill(dat, e);\n\t}\n\t@SuppressWarnings(\"\
    unchecked\")\n\tvoid update(int i, final T x) {\n\t\ti += n;\n\t\tdat[i] = x;\n\
    \t\tdo {\n\t\t\ti >>= 1;\n\t\t\tdat[i] = op.apply((T) dat[2 * i], (T) dat[2 *\
    \ i + 1]);\n\t\t} while(i > 0);\n\t}\n\t@SuppressWarnings(\"unchecked\")\n\tT\
    \ query(int a, int b) {\n\t\tT l = e, r = e;\n\t\tfor(a += n, b += n; a < b; a\
    \ >>= 1, b >>= 1) {\n\t\t\tif(a % 2 == 1) {\n\t\t\t\tl = op.apply(l, (T) dat[a++]);\n\
    \t\t\t}\n\t\t\tif(b % 2 == 1) {\n\t\t\t\tr = op.apply((T) dat[--b], r);\n\t\t\t\
    }\n\t\t}\n\t\treturn op.apply(l,r);\n\t}\n\t@SuppressWarnings(\"unchecked\")\n\
    \tint findLeft(int r, final Predicate<T> fn) {\n\t\tif(r == 0) {\n\t\t\treturn\
    \ 0;\n\t\t}\n\t\tint h = 0, i = r + n;\n\t\tT val = e;\n\t\tfor(; h <= rank; h++)\
    \ {\n\t\t\tif(i >> (h & 1) > 0) {\n\t\t\t\tfinal T val2 = op.apply(val, (T) dat[i\
    \ >> (h ^ 1)]);\n\t\t\t\tif(fn.test(val2)){\n\t\t\t\t\ti -= 1 << h;\n\t\t\t\t\t\
    if(i == n) {\n\t\t\t\t\t\treturn 0;\n\t\t\t\t\t}\n\t\t\t\t\tval = val2;\n\t\t\t\
    \t}\n\t\t\t\telse {\n\t\t\t\t\tbreak;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tfor(; h--\
    \ > 0;) {\n\t\t\tfinal T val2 = op.apply(val, (T) dat[(i >> h) - 1]);\n\t\t\t\
    if(fn.test(val2)){\n\t\t\t\ti -= 1 << h;\n\t\t\t\tif(i == n) {\n\t\t\t\t\treturn\
    \ 0;\n\t\t\t\t}\n\t\t\t\tval = val2;\n\t\t\t}\n\t\t}\n\t\treturn i - n;\n\t}\n\
    \t@SuppressWarnings(\"unchecked\")\n\tint findRight(int l, final Predicate<T>\
    \ fn) {\n\t\tif(l == fini) {\n\t\t\treturn fini;\n\t\t}\n\t\tint h = 0, i = l\
    \ + n;\n\t\tT val = e;\n\t\tfor(; h <= rank; h++) {\n\t\t\tif(i >> (h & 1) > 0){\n\
    \t\t\t\tfinal T val2 = op.apply(val, (T) dat[i >> h]);\n\t\t\t\tif(fn.test(val2)){\n\
    \t\t\t\t\ti += 1 << h;\n\t\t\t\t\tif(i == n * 2) {\n\t\t\t\t\t\treturn fini;\n\
    \t\t\t\t\t}\n\t\t\t\t\tval = val2;\n\t\t\t\t}\n\t\t\t\telse {\n\t\t\t\t\tbreak;\n\
    \t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tfor(; h-- > 0;) {\n\t\t\tfinal T val2 = op.apply(val,\
    \ (T) dat[i>>h]);\n\t\t\tif(fn.test(val2)) {\n\t\t\t\ti += 1 << h;\n\t\t\t\tif(i\
    \ == n * 2) {\n\t\t\t\t\treturn fini;\n\t\t\t\t}\n\t\t\t\tval = val2;\n\t\t\t\
    }\n\t\t}\n\t\treturn Math.min(i - n, fini);\n\t}\n}\n\nclass SparseTable {\n\t\
    private long[][] st;\n\tprivate int[] lookup;\n\tprivate BinaryOperator<Long>\
    \ op;\n\tSparseTable(final int[] a, final BinaryOperator<Long> op) {\n\t\tthis.op\
    \ = op;\n\t\tint b = 0;\n\t\twhile((1 << b) <= a.length) {\n\t\t\t++b;\n\t\t}\n\
    \t\tst = new long[b][1 << b];\n\t\tfor(int i = 0; i < a.length; i++) {\n\t\t\t\
    st[0][i] = a[i];\n\t\t}\n\t\tfor(int i = 1; i < b; i++) {\n\t\t\tfor(int j = 0;\
    \ j + (1 << i) <= (1 << b); j++) {\n\t\t\t\tst[i][j] = op.apply(st[i - 1][j],\
    \ st[i - 1][j + (1 << (i - 1))]);\n\t\t\t}\n\t\t}\n\t\tlookup = new int[a.length\
    \ + 1];\n\t\tfor(int i = 2; i < lookup.length; i++) {\n\t\t\tlookup[i] = lookup[i\
    \ >> 1] + 1;\n\t\t}\n\t}\n\tSparseTable(final long[] a, final BinaryOperator<Long>\
    \ op) {\n\t\tthis.op = op;\n\t\tint b = 0;\n\t\twhile((1 << b) <= a.length) {\n\
    \t\t\t++b;\n\t\t}\n\t\tst = new long[b][1 << b];\n\t\tfor(int i = 0; i < a.length;\
    \ i++) {\n\t\t\tst[0][i] = a[i];\n\t\t}\n\t\tfor(int i = 1; i < b; i++) {\n\t\t\
    \tfor(int j = 0; j + (1 << i) <= (1 << b); j++) {\n\t\t\t\tst[i][j] = op.apply(st[i\
    \ - 1][j], st[i - 1][j + (1 << (i - 1))]);\n\t\t\t}\n\t\t}\n\t\tlookup = new int[a.length\
    \ + 1];\n\t\tfor(int i = 2; i < lookup.length; i++) {\n\t\t\tlookup[i] = lookup[i\
    \ >> 1] + 1;\n\t\t}\n\t}\n\tlong query(final int l, final int r) {\n\t\tfinal\
    \ int b = lookup[r - l];\n\t\treturn op.apply(st[b][l], st[b][r - (1 << b)]);\n\
    \t}\n\tint minLeft(final int x, final Predicate<Long> fn) {\n\t\tif(x == 0) {\n\
    \t\t\treturn 0;\n\t\t}\n\t\tint ok = x, ng = -1;\n\t\twhile(Math.abs(ok - ng)\
    \ > 1) {\n\t\t\tfinal int mid = (ok + ng) / 2;\n\t\t\tif(fn.test(query(mid, x)\
    \ - 1)) {\n\t\t\t\tok = mid;\n\t\t\t}\n\t\t\telse {\n\t\t\t\tng = mid;\n\t\t\t\
    }\n\t\t}\n\t\treturn ok;\n\t}\n\tint maxRight(final int x, final Predicate<Long>\
    \ fn) {\n\t\tif(x == lookup.length - 1) {\n\t\t\treturn lookup.length - 1;\n\t\
    \t}\n\t\tint ok = x, ng = lookup.length;\n\t\twhile(Math.abs(ok - ng) > 1) {\n\
    \t\t\tint mid = (ok + ng) / 2;\n\t\t\tif(fn.test(query(x, mid))) {\n\t\t\t\tok\
    \ = mid;\n\t\t\t}\n\t\t\telse {\n\t\t\t\tng = mid;\n\t\t\t}\n\t\t}\n\t\treturn\
    \ ok;\n\t}\n}\n\nclass SuffixArray extends ArrayList<Integer> {\n\tprivate String\
    \ vs;\n\tSuffixArray(final String vs, final boolean compress) {\n\t\tthis.vs =\
    \ vs;\n\t\tint[] newVS = new int[vs.length() + 1];\n\t\tif(compress) {\n\t\t\t\
    final var xs = vs.chars().sorted().distinct().boxed().collect(Collectors.toList());\n\
    \t\t\tfor(int i = 0; i < vs.length(); ++i) {\n\t\t\t\tnewVS[i] = Utility.lowerBound(xs,\
    \ vs.charAt(i)) + 1;\n\t\t\t}\n\t\t} else {\n\t\t\tfinal int d = vs.chars().min().getAsInt();\n\
    \t\t\tfor(int i = 0; i < vs.length(); ++i) {\n\t\t\t\tnewVS[i] = vs.charAt(i)\
    \ - d + 1;\n\t\t\t}\n\t\t}\n\t\tthis.addAll(Arrays.stream(SAIS(newVS)).boxed().collect(Collectors.toList()));\n\
    \t}\n\tprivate int[] SAIS(final int[] s) {\n\t\tfinal int n = s.length;\n\t\t\
    int[] ret = new int[n];\n\t\tboolean[] isS = new boolean[n], isLMS = new boolean[n];\n\
    \t\tint m = 0;\n\t\tfor(int i = n - 2; i >= 0; i--) {\n\t\t\tisS[i] = (s[i] >\
    \ s[i + 1]) || (s[i] == s[i + 1] && isS[i + 1]);\n\t\t\tm += (isLMS[i + 1] = isS[i]\
    \ && !isS[i + 1]) ? 1 : 0;\n\t\t}\n\t\tfinal Consumer<ArrayList<Integer>> inducedSort\
    \ = (lms) -> {\n\t\t\tfinal int upper = Arrays.stream(s).max().getAsInt();\n\t\
    \t\tint[] l = new int[upper + 2], r = new int[upper + 2];\n\t\t\tfor(final var\
    \ v: s) {\n\t\t\t\t++l[v + 1];\n\t\t\t\t++r[v];\n\t\t\t}\n\t\t\tArrays.parallelPrefix(l,\
    \ (x, y) -> x + y);\n\t\t\tArrays.parallelPrefix(r, (x, y) -> x + y);\n\t\t\t\
    Arrays.fill(ret, -1);\n\t\t\tfor(int i = lms.size(); --i >= 0;) {\n\t\t\t\tret[--r[s[lms.get(i)]]]\
    \ = lms.get(i);\n\t\t\t}\n\t\t\tfor(final var v: ret) {\n\t\t\t\tif(v >= 1 &&\
    \ isS[v - 1]) {\n\t\t\t\t\tret[l[s[v - 1]]++] = v - 1;\n\t\t\t\t}\n\t\t\t}\n\t\
    \t\tArrays.fill(r, 0);\n\t\t\tfor(final var v: s) {\n\t\t\t\t++r[v];\n\t\t\t}\n\
    \t\t\tArrays.parallelPrefix(r, (x, y) -> x + y);\n\t\t\tfor(int k = ret.length\
    \ - 1, i = ret[k]; k >= 1; i = ret[--k]) {\n\t\t\t\tif(i >= 1 && !isS[i - 1])\
    \ {\n\t\t\t\t\tret[--r[s[i - 1]]] = i - 1;\n\t\t\t\t}\n\t\t\t}\n\t\t};\n\t\tArrayList<Integer>\
    \ lms = new ArrayList<>(), newLMS = new ArrayList<>();\n\t\tfor(int i = 0; ++i\
    \ < n;) {\n\t\t\tif(isLMS[i]) {\n\t\t\t\tlms.add(i);\n\t\t\t}\n\t\t}\n\t\tinducedSort.accept(lms);\n\
    \t\tfor(int i = 0; i < n; ++i) {\n\t\t\tif(!isS[ret[i]] && ret[i] > 0 && isS[ret[i]\
    \ - 1]) {\n\t\t\t\tnewLMS.add(ret[i]);\n\t\t\t}\n\t\t}\n\t\tfinal BiPredicate<Integer,\
    \ Integer> same = (a, b) -> {\n\t\t\tif(s[a++] != s[b++]) {\n\t\t\t\treturn false;\n\
    \t\t\t}\n\t\t\twhile(true) {\n\t\t\t\tif(s[a] != s[b]) {\n\t\t\t\t\treturn false;\n\
    \t\t\t\t}\n\t\t\t\tif(isLMS[a] || isLMS[b]) {\n\t\t\t\t\treturn isLMS[a] && isLMS[b];\n\
    \t\t\t\t}\n\t\t\t\ta++;\n\t\t\t\tb++;\n\t\t\t}\n\t\t};\n\t\tint rank = 0;\n\t\t\
    ret[n - 1] = 0;\n\t\tfor(int i = 0; ++i < m;) {\n\t\t\tif(!same.test(newLMS.get(i\
    \ - 1), newLMS.get(i))) {\n\t\t\t\t++rank;\n\t\t\t}\n\t\t\tret[newLMS.get(i)]\
    \ = rank;\n\t\t}\n\t\tif(rank + 1 < m) {\n\t\t\tint[] newS = new int[m];\n\t\t\
    \tfor(int i = 0; i < m; ++i) {\n\t\t\t\tnewS[i] = ret[lms.get(i)];\n\t\t\t}\n\t\
    \t\tfinal var lmsSA = SAIS(newS);\n\t\t\tIntStream.range(0, m).forEach(i -> newLMS.set(i,\
    \ lms.get(lmsSA[i])));\n\t\t}\n\t\tinducedSort.accept(newLMS);\n\t\treturn ret;\n\
    \t}\n\tboolean ltSubstr(final String t, int si, int ti) {\n\t\tfinal int sn =\
    \ vs.length(), tn = t.length();\n\t\twhile(si < sn && ti < tn) {\n\t\t\tif(vs.charAt(si)\
    \ < t.charAt(ti)) {\n\t\t\t\treturn true;\n\t\t\t}\n\t\t\tif(vs.charAt(si) > t.charAt(ti))\
    \ {\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\t++si;\n\t\t\t++ti;\n\t\t}\n\t\treturn\
    \ si >= sn && ti < tn;\n\t}\n\tint lowerBound(final String t) {\n\t\tint ok =\
    \ this.size(), ng = 0;\n\t\twhile(ok - ng > 1) {\n\t\t\tfinal int mid = (ok +\
    \ ng) / 2;\n\t\t\tif(ltSubstr(t, this.get(mid), 0)) {\n\t\t\t\tng = mid;\n\t\t\
    \t} else {\n\t\t\t\tok = mid;\n\t\t\t}\n\t\t}\n\t\treturn ok;\n\t}\n\tPair<Integer,\
    \ Integer> equalRange(final String t) {\n\t\tfinal int low = lowerBound(t);\n\t\
    \tint ng = low - 1, ok = this.size();\n\t\tvar sb = new StringBuilder(t);\n\t\t\
    sb.setCharAt(t.length() - 1, (char)(sb.charAt(sb.length() - 1) - 1));\n\t\tfinal\
    \ String u = sb.toString();\n\t\twhile(ok - ng > 1) {\n\t\t\tfinal int mid = (ok\
    \ + ng) / 2;\n\t\t\tif(ltSubstr(u, this.get(mid), 0)) {\n\t\t\t\tng = mid;\n\t\
    \t\t} else {\n\t\t\t\tok = mid;\n\t\t\t}\n\t\t}\n\t\tfinal int end = this.size()\
    \ - 1;\n\t\tthis.add(end, this.get(end) - 1);\n\t\treturn Pair.of(low, ok);\n\t\
    }\n\tint[] lcpArray() {\n\t\tfinal int n = this.size() - 1;\n\t\tint[] lcp = new\
    \ int[n + 1], rank = new int[n + 1];\n\t\tfor(int i = 0; i <= n; ++i) {\n\t\t\t\
    rank[this.get(i)] = i;\n\t\t}\n\t\tint h = 0;\n\t\tfor(int i = 0; i <= n; ++i)\
    \ {\n\t\t\tif(rank[i] < n) {\n\t\t\t\tfinal int j = this.get(rank[i] + 1);\n\t\
    \t\t\tfor(; j + h < n && i + h < n; ++h) {\n\t\t\t\t\tif(vs.charAt(j + h) != vs.charAt(i\
    \ + h)) {\n\t\t\t\t\t\tbreak;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tlcp[rank[i] + 1]\
    \ = h;\n\t\t\t\tif(h > 0) {\n\t\t\t\t\th--;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\treturn\
    \ lcp;\n\t}\n\t@Override\n\tpublic String toString() { \n\t\tStringBuilder sb\
    \ = new StringBuilder();\n\t\tfor(int i = 0; i < this.size(); ++i) {\n\t\t\tsb.append(i\
    \ + \":[\" + this.get(i) + \"]\");\n\t\t\tfor(int j = this.get(i); j < vs.length();\
    \ ++j) {\n\t\t\t\tsb.append(\" \" + vs.charAt(j));\n\t\t\t}\n\t\t\tsb.append(\"\
    \\n\");\n\t\t}\n\t\treturn sb.toString();\n\t}\n}\n\nclass DoubleEndedPriorityQueue<T\
    \ extends Number> {\n\tprivate ArrayList<T> d;\n\tDoubleEndedPriorityQueue(final\
    \ ArrayList<T> d) {\n\t\tthis.d = d;\n\t\tmake_heap();\n\t}\n\tprivate void make_heap()\
    \ {\n\t\tfor(int i = d.size(); i-- > 0;) {\n\t\t\tif (i % 2 == 1 && d.get(i -\
    \ 1).longValue() < d.get(i).longValue()) {\n\t\t\t\tCollections.swap(d, i - 1,\
    \ i);\n\t\t\t}\n\t\t\tup(down(i), i);\n\t\t}\n\t}\n\tprivate int down(int k) {\n\
    \t\tfinal int n = d.size();\n\t\tif(k % 2 == 1) {\n\t\t\twhile(2 * k + 1 < n)\
    \ {\n\t\t\t\tint c = 2 * k + 3;\n\t\t\t\tif(n <= c || d.get(c - 2).longValue()\
    \ < d.get(c).longValue()) {\n\t\t\t\t\t c -= 2;\n\t\t\t\t}\n\t\t\t\tif(c < n &&\
    \ d.get(c).longValue() < d.get(k).longValue()) {\n\t\t\t\t\tCollections.swap(d,\
    \ k, c);\n\t\t\t\t\tk = c;\n\t\t\t\t}\n\t\t\t\telse {\n\t\t\t\t\tbreak;\n\t\t\t\
    \t}\n\t\t\t}\n\t\t} else {\n\t\t\twhile(2 * k + 2 < n) {\n\t\t\t\tint c = 2 *\
    \ k + 4;\n\t\t\t\tif(n <= c || d.get(c).longValue() < d.get(c - 2).longValue())\
    \ {\n\t\t\t\t\tc -= 2;\n\t\t\t\t}\n\t\t\t\tif(c < n && d.get(k).longValue() <\
    \ d.get(c).longValue()) {\n\t\t\t\t\tCollections.swap(d, k, c);\n\t\t\t\t\tk =\
    \ c;\n\t\t\t\t}\n\t\t\t\telse {\n\t\t\t\t\tbreak;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\
    \t\treturn k;\n\t}\n\tprivate int up(int k, final int root) {\n\t\tif((k | 1)\
    \ < d.size() && d.get(k & ~1).longValue() < d.get(k | 1).longValue()) {\n\t\t\t\
    Collections.swap(d, k & ~1, k | 1);\n\t\t\tk ^= 1;\n\t\t}\n\t\tint p;\n\t\twhile(root\
    \ < k && d.get(p = parent(k)).longValue() < d.get(k).longValue()) {\n\t\t\tCollections.swap(d,\
    \ p, k);\n\t\t\tk = p;\n\t\t}\n\t\twhile(root < k && d.get(k).longValue() < d.get(p\
    \ = parent(k) | 1).longValue()) {\n\t\t\tCollections.swap(d, p, k);\n\t\t\tk =\
    \ p;\n\t\t}\n\t\treturn k;\n\t}\n\tprivate int parent(final int k){ return ((k\
    \ >> 1) - 1) & ~1; }\n\tprivate void popBack(final ArrayList<T> d){ d.remove(d.size()\
    \ - 1); } \n\tvoid push(final T x) {\n\t\tfinal int k = d.size();\n\t\td.add(x);\n\
    \t\tup(k, 1);\n\t}\n\tT popMin() {\n\t\tfinal var res = getMin();\n\t\tif(d.size()\
    \ < 3) {\n\t\t\tpopBack(d); \n\t\t} else {\n\t\t\tCollections.swap(d, 1, d.size()\
    \ - 1);\n\t\t\tpopBack(d);\n\t\t\tup(down(1), 1);\n\t\t}\n\t\treturn res;\n\t\
    }\n\tT popMax() {\n\t\tfinal var res = getMax();\n\t\tif(d.size() < 2) { \n\t\t\
    \tpopBack(d);\n\t\t} else {\n\t\t\tCollections.swap(d, 0, d.size() - 1);\n\t\t\
    \tpopBack(d);\n\t\t\tup(down(0), 1);\n\t\t}\n\t\treturn res;\n\t}\n\tT getMin(){\
    \ return d.size() < 2 ? d.get(0) : d.get(1); }\n\tT getMax(){ return d.get(0);\
    \ }\n\tint size(){ return d.size(); }\n\tboolean isEmpty(){ return d.isEmpty();\
    \ }\n}\n\nclass SuccinctIndexableDictionary {\n\tprivate int blk;\n\tprivate int[]\
    \ bit, sum;\n\tSuccinctIndexableDictionary(final int len) {\n\t\tblk = (len +\
    \ 31) >> 5;\n\t\tbit = new int[blk];\n\t\tsum = new int[blk];\n\t}\n\tvoid set(final\
    \ int k){ bit[k >> 5] |= 1 << (k & 31); }\n\tvoid build() {\n\t\tsum[0] = 0;\n\
    \t\tfor(int i = 0; ++i < blk;) {\n\t\t\tsum[i] = sum[i - 1] + Integer.bitCount(bit[i\
    \ - 1]);\n\t\t}\n\t}\n\tboolean get(final int k){ return ((bit[k >> 5] >> (k &\
    \ 31)) & 1) == 1; }\n\tint rank(final int k){ return (sum[k >> 5] + Integer.bitCount(bit[k\
    \ >> 5] & ((1 << (k & 31)) - 1))); }\n\tint rank(final boolean val, final int\
    \ k){ return val ? rank(k) : k - rank(k); }\n}\nclass WaveletMatrixBeta {\n\t\
    private int log;\n\tprivate SuccinctIndexableDictionary[] matrix;\n\tprivate int[]\
    \ mid;\n\tWaveletMatrixBeta(long[] arr, final int log) {\n\t\tfinal int len =\
    \ arr.length;\n\t\tthis.log = log;\n\t\tmatrix = new SuccinctIndexableDictionary[log];\n\
    \t\tmid = new int[log];\n\t\tlong[] l = new long[len], r = new long[len];\n\t\t\
    for(int level = log; --level >= 0;) {\n\t\t\tmatrix[level] = new SuccinctIndexableDictionary(len\
    \ + 1);\n\t\t\tint left = 0, right = 0;\n\t\t\tfor(int i = 0; i < len; ++i) {\n\
    \t\t\t\tif(((arr[i] >> level) & 1) == 1) {\n\t\t\t\t\tmatrix[level].set(i);\n\t\
    \t\t\t\tr[right++] = arr[i];\n\t\t\t\t} else {\n\t\t\t\t\tl[left++] = arr[i];\n\
    \t\t\t\t}\n\t\t\t}\n\t\t\tmid[level] = left;\n\t\t\tmatrix[level].build();\n\t\
    \t\tfinal long[] tmp = new long[len];\n\t\t\tSystem.arraycopy(arr, 0, tmp, 0,\
    \ len);\n\t\t\tSystem.arraycopy(l, 0, arr, 0, len);\n\t\t\tSystem.arraycopy(tmp,\
    \ 0, l, 0, len);\n\t\t\tfor(int i = 0; i < right; i++) {\n\t\t\t\tarr[left + i]\
    \ = r[i];\n\t\t\t}\n\t\t}\n\t}\n\tNumPair succ(final boolean f, final int l, final\
    \ int r, final int level){ return new NumPair(matrix[level].rank(f, l) + mid[level]\
    \ * (f ? 1 : 0), matrix[level].rank(f, r) + mid[level] * (f ? 1 : 0)); }\n\tlong\
    \ access(int k) {\n\t\tlong ret = 0;\n\t\tfor(int level = log; --level >= 0;)\
    \ {\n\t\t\tfinal boolean f = matrix[level].get(k);\n\t\t\tif(f) {\n\t\t\t\tret\
    \ |= 1L << level;\n\t\t\t}\n\t\t\tk = matrix[level].rank(f, k) + mid[level] *\
    \ (f ? 1 : 0);\n\t\t}\t\n\t\treturn ret;\n\t}\n\tint rank(final long x, int r)\
    \ {\n\t\tint l = 0;\n\t\tfor(int level = log; --level >= 0;) {\n\t\t\tfinal var\
    \ p = succ(((x >> level) & 1) == 1, l, r, level);\n\t\t\tl = p.first.intValue();\n\
    \t\t\tr = p.second.intValue();\n\t\t}\n\t\treturn r - l;\n\t}\n\tlong kthSmallest(int\
    \ l, int r, int k) {\n\t\tassert(0 <= k && k < r - l);\n\t\tlong ret = 0;\n\t\t\
    for(int level = log; --level >= 0;) {\n\t\t\tfinal int cnt = matrix[level].rank(false,\
    \ r) - matrix[level].rank(false, l);\n\t\t\tfinal boolean f = cnt <= k;\n\t\t\t\
    if(f) {\n\t\t\t\tret |= 1 << level;\n\t\t\t\tk -= cnt;\n\t\t\t}\n\t\t\tfinal var\
    \ p = succ(f, l, r, level);\n\t\t\tl = p.first.intValue();\n\t\t\tr = p.second.intValue();\n\
    \t\t}\n\t\treturn ret;\n\t}\n\tlong kthLargest(final int l, final int r, final\
    \ int k){ return kthSmallest(l, r, r - l - k - 1); }\n\tint rangeFreq(int l, int\
    \ r, final long upper) {\n\t\tint ret = 0;\n\t\tfor(int level = log; --level >=\
    \ 0;) {\n\t\t\tfinal boolean f = ((upper >> level) & 1) == 1;\n\t\t\tif(f) {\n\
    \t\t\t\tret += matrix[level].rank(false, r) - matrix[level].rank(false, l);\n\t\
    \t\t}\n\t\t\tfinal var p = succ(f, l, r, level); \n\t\t\tl = p.first.intValue();\n\
    \t\t\tr = p.second.intValue();\n\t\t}\n\t\treturn ret;\n\t}\n\tint rangeFreq(final\
    \ int l, final int r, final long lower, final long upper){ return rangeFreq(l,\
    \ r, upper) - rangeFreq(l, r, lower); }\n\tlong prevValue(final int l, final int\
    \ r, final long upper) {\n\t\tfinal int cnt = rangeFreq(l, r, upper);\n\t\treturn\
    \ cnt == 0 ? -1 : kthSmallest(l, r, cnt - 1);\n\t}\n\tlong nextValue(final int\
    \ l, final int r, final long lower) {\n\t\tfinal int cnt = rangeFreq(l, r, lower);\n\
    \t\treturn cnt == r - l ? -1 : kthSmallest(l, r, cnt);\n\t}\n}\nclass WaveletMatrix\
    \ {\n\tprivate WaveletMatrixBeta mat;\n\tprivate long[] ys;\n\tWaveletMatrix(final\
    \ long[] arr, final int log) {\n\t\tys = Arrays.stream(arr).sorted().distinct().toArray();\n\
    \t\tlong[] t = new long[arr.length];\n\t\tfor(int i = 0; i < arr.length; ++i)\
    \ {\n\t\t\tt[i] = get(arr[i]);\n\t\t}\n\t\tmat = new WaveletMatrixBeta(t, log);\n\
    \t}\n\tprivate int lowerBound(final long[] arr, final long x) {\n\t\tfinal int\
    \ id = Arrays.binarySearch(arr, x);\n\t\treturn id < 0 ? -(id - 1) : id;\n\t}\n\
    \tprivate int get(final long x){ return lowerBound(ys, x); }\n\tlong access(final\
    \ int k){ return ys[(int) mat.access(k)]; }\n\tint rank(final long x, final int\
    \ r) {\n\t\tfinal var pos = get(x);\n\t\tif(pos == ys.length || ys[pos] != x)\
    \ {\n\t\t\treturn 0;\n\t\t}\n\t\treturn mat.rank(pos, r);\n\t}\n\tlong kthSmallest(final\
    \ int l, final int r, final int k){ return ys[(int) mat.kthSmallest(l, r, k)];\
    \ }\n\tlong kthLargest(final int l, final int r, final int k){ return ys[(int)\
    \ mat.kthLargest(l, r, k)]; }\n\tint rangeFreq(final int l, final int r, final\
    \ long upper){ return mat.rangeFreq(l, r, get(upper)); }\n\tint rangeFreq(final\
    \ int l, final int r, final long lower, final long upper){ return mat.rangeFreq(l,\
    \ r, get(lower), get(upper)); }\n\tlong prevValue(final int l, final int r, final\
    \ long upper) {\n\t\tfinal var ret = mat.prevValue(l, r, get(upper));\n\t\treturn\
    \ ret == -1 ? -1 : ys[(int) ret];\n\t}\n\tlong nextValue(final int l, final int\
    \ r, final long lower) {\n\t\tfinal var ret = mat.nextValue(l, r, get(lower));\n\
    \t\treturn ret == -1 ? -1 : ys[(int) ret];\n\t}\n}"
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
  - Java/extension/Graph.java
  - Java/extension/PrimeFactor.java
  - Java/extension/PrimeCounter.java
  - Java/extension/SegmentTree.java
  - Java/extension/UndoUnionFind.java
  - Java/extension/Template.java
  isVerificationFile: false
  path: Java/all.java
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
  - Java/extension/Graph.java
  - Java/extension/PrimeFactor.java
  - Java/extension/PrimeCounter.java
  - Java/extension/SegmentTree.java
  - Java/extension/UndoUnionFind.java
  - Java/extension/Template.java
  timestamp: '2023-12-05 15:10:49+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: Java/all.java
layout: document
redirect_from:
- /library/Java/all.java
- /library/Java/all.java.html
title: Java/all.java
---
