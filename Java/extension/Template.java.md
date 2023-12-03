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
  code: "package extension;\n\nimport java.util.ArrayList;\nimport java.util.Arrays;\n\
    import java.util.Collections;\nimport java.util.List;\nimport java.util.function.Predicate;\n\
    import java.util.stream.Collectors;\nimport java.util.stream.IntStream;\n\nclass\
    \ VvyLw extends Utility {\n\tprotected static final MyScanner sc = new MyScanner();\n\
    \tprotected static final MyPrinter o = new MyPrinter(System.out, false);\n\tprotected\
    \ static final MyPrinter e = new MyPrinter(System.err, true);\n\tstatic final\
    \ int[] dx = {0, -1, 1, 0, 0, -1, -1, 1, 1};\n\tstatic final int[] dy = {0, 0,\
    \ 0, -1, 1, -1, 1, -1, 1};\n\tstatic final int inf = 1 << 30;\n\tstatic final\
    \ long linf = (1L << 61) - 1;\n\tstatic final int mod998 = 998244353;\n\tstatic\
    \ final int mod107 = (int)1e9 + 7;\n\tprotected static void solve() {\n\t\t\n\t\
    }\n}\nclass Main extends VvyLw {\n\tpublic static void main(final String[] args)\
    \ {\n\t\tint t = 1;\n\t\t//t = sc.ni();\n\t\twhile(t-- > 0) {\n\t\t\tsolve();\n\
    \t\t}\n\t\to.flush();\n\t\tsc.close();\n\t\to.close();\n\t\te.close();\n\t}\n\
    }\n\nclass Utility {\n\tprotected static String yes(final boolean ok){ return\
    \ ok ? \"Yes\" : \"No\"; }\n\tprotected static String no(final boolean ok){ return\
    \ yes(!ok); }\n\tprotected static long sqr(final long x){ return x * x; }\n\t\
    protected static int mod(final long n, final int m){ return (int) ((n + m) % m);\
    \ }\n\tprotected static long intCeil(long a, long b){ return (long) Math.ceil((double)a\
    \ / b); }\n\tprotected static long intPow(long a, int b) {\n\t\tlong res = 1;\n\
    \t\twhile(b > 0) {\n\t\t\tif(b % 2 == 1) {\n\t\t\t\tres *= a;\n\t\t\t}\n\t\t\t\
    a *= a;\n\t\t\tb >>= 1;\n\t\t}\n\t\treturn res;\n\t}\n\tprotected static long\
    \ intPow(long a, long b, final int m) {\n\t\tlong res = 1;\n\t\twhile(b > 0) {\n\
    \t\t\tif(b % 2 == 1) {\n\t\t\t\tres *= a;\n\t\t\t\tres = mod(res, m);\n\t\t\t\
    }\n\t\t\ta *= a;\n\t\t\ta = mod(a, m);\n\t\t\tb >>= 1;\n\t\t}\n\t\treturn res;\n\
    \t}\n\tprotected static ArrayList<Long> div(final long n) {\n\t\tArrayList<Long>\
    \ d = new ArrayList<>();\n\t\tfor(long i = 1; i * i <= n; ++i) {\n\t\t\tif(n %\
    \ i == 0) {\n\t\t\t\td.add(i);\n\t\t\t\tif(i * i != n) {\n\t\t\t\t\td.add(n /\
    \ i);\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tCollections.sort(d);\n\t\treturn d;\n\t\
    }\n\tprotected static ArrayList<Pair<Long, Integer>> primeFactor(long n) {\n\t\
    \tArrayList<Pair<Long, Integer>> pf = new ArrayList<>();\n\t\tfor(long i = 2;\
    \ i * i <= n; ++i) {\n\t\t\tif(n % i != 0) {\n\t\t\t\tcontinue;\n\t\t\t}\n\t\t\
    \tint cnt = 0;\n\t\t\twhile(n % i == 0) {\n\t\t\t\tcnt++;\n\t\t\t\tn /= i;\n\t\
    \t\t}\n\t\t\tpf.add(Pair.of(i, cnt));\n\t\t}\n\t\tif(n != 1) {\n\t\t\tpf.add(Pair.of(n,\
    \ 1));\n\t\t}\n\t\treturn pf;\n\t}\n\tprotected static long binom(int a, final\
    \ int b) {\n\t\tlong res = 1;\n\t\tfor(int i = 1; i <= b; ++i) {\n\t\t\tres *=\
    \ a--;\n\t\t\tres /= i;\n\t\t}\n\t\treturn res;\n\t}\n\tprotected static boolean\
    \ isInt(final double n){ long r = (long) Math.floor(n); return r == n; }\n\tprotected\
    \ static boolean isSqr(final long n){ return isInt(Math.sqrt(n)); }\n\tprotected\
    \ static boolean isPrime(final long n) {\n\t\tif(n == 1) return false;\n\t\tfor(long\
    \ i = 2; i * i <= n; ++i) {\n\t\t\tif(n % i == 0) return false;\n\t\t}\n\t\treturn\
    \ true;\n\t}\n\tprotected static boolean nextPerm(ArrayList<? extends Number>\
    \ a) {\n\t\tfor(int i = a.size() - 1; i > 0; i--) {\n\t\t\tif(a.get(i - 1).longValue()\
    \ < a.get(i).longValue()) {\n\t\t\t\tfinal int j = find(a.get(i - 1).longValue(),\
    \ a, i, a.size() - 1);\n\t\t\t\tCollections.swap(a, i - 1, j);\n\t\t\t\tCollections.sort(a.subList(i,\
    \ a.size()), (x, y) -> Long.compare(x.longValue(), y.longValue()));\n\t\t\t\t\
    return true;\n\t\t\t}\n\t\t}\n\t\treturn false;\n\t}\n\tprotected static String\
    \ nextPerm(final String s) {\n\t\tvar a = s.chars().mapToObj(i -> (char)i).collect(Collectors.toList());\n\
    \t\tfor(int i = a.size() - 1; i > 0; i--) {\n\t\t\tif(a.get(i - 1).compareTo(a.get(i))\
    \ < 0) {\n\t\t\t\tfinal int j = find(a.get(i - 1), a, i, a.size() - 1);\n\t\t\t\
    \tCollections.swap(a, i - 1, j);\n\t\t\t\tCollections.sort(a.subList(i, a.size()));\n\
    \t\t\t\treturn a.stream().map(String::valueOf).collect(Collectors.joining());\n\
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
    \ x) >= 0;\n\t}\n\tprotected static int lowerBound(final List<Integer> a, final\
    \ int x) {\n\t\treturn ~Collections.binarySearch(a, x, (p, q) -> p.compareTo(q)\
    \ >= 0 ? 1 : -1);\n\t}\n\tprotected static int lowerBound(final List<Long> a,\
    \ final long x) {\n\t\treturn ~Collections.binarySearch(a, x, (p, q) -> p.compareTo(q)\
    \ >= 0 ? 1 : -1);\n\t}\n\tprotected static int upperBound(final List<Integer>a,\
    \ final int x) {\n\t\treturn ~Collections.binarySearch(a, x, (p, q) -> p.compareTo(q)\
    \ > 0 ? 1 : -1);\n\t}\n\tprotected static int upperBound(final List<Long> a, final\
    \ long x) {\n\t\treturn ~Collections.binarySearch(a, x, (p, q) -> p.compareTo(q)\
    \ > 0 ? 1 : -1);\n\t}\n\tprotected static int[] reverse(final int[] a) {\n\t\t\
    final int n = a.length;\n\t\tint[] b = new int[n];\n\t\tfor(int i = 0; i <= n\
    \ / 2; ++i) {\n\t\t\tb[i] = a[n - 1 - i];\n\t\t\tb[n - 1 - i] = a[i];\n\t\t}\n\
    \t\treturn b;\n\t}\n\tprotected static long[] reverse(final long[] a) {\n\t\t\
    final int n = a.length;\n\t\tlong[] b = new long[n];\n\t\tfor(int i = 0; i <=\
    \ n / 2; ++i) {\n\t\t\tb[i] = a[n - 1 - i];\n\t\t\tb[n - 1 - i] = a[i];\n\t\t\
    }\n\t\treturn b;\n\t}\n\tprotected static double[] reverse(final double[] a) {\n\
    \t\tfinal int n = a.length;\n\t\tdouble[] b = new double[n];\n\t\tfor(int i =\
    \ 0; i <= n / 2; ++i) {\n\t\t\tb[i] = a[n - 1 - i];\n\t\t\tb[n - 1 - i] = a[i];\n\
    \t\t}\n\t\treturn b;\n\t}\n\tprotected static Object[] reverse(final Object[]\
    \ a) {\n\t\tfinal int n = a.length;\n\t\tObject[] b = new Object[n];\n\t\tfor(int\
    \ i = 0; i <= n / 2; ++i) {\n\t\t\tb[i] = a[n - 1 - i];\n\t\t\tb[n - 1 - i] =\
    \ a[i];\n\t\t}\n\t\treturn b;\n\t}\n\tprotected static int[] rotate(final int[]\
    \ a, final int id) {\n\t\tArrayList<Integer> t = new ArrayList<>(a.length);\n\t\
    \tfor(final var el: a) {\n\t\t\tt.add(el);\n\t\t}\n\t\tCollections.rotate(t, id);\n\
    \t\tint[] res = new int[t.size()];\n\t\tfor(int i = 0; i < t.size(); ++i) {\n\t\
    \t\tres[i] = t.get(i);\n\t\t}\n\t\treturn res;\n\t}\n\tprotected static long[]\
    \ rotate(final long[] a, final int id) {\n\t\tArrayList<Long> t = new ArrayList<>(a.length);\n\
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
    \t\t}\n\t\t}\n\t\treturn ret;\n\t}\n}"
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
  - Java/extension/PrimeCounter.java
  - Java/extension/SegmentTree.java
  - Java/extension/UndoUnionFind.java
  - Java/all.java
  isVerificationFile: false
  path: Java/extension/Template.java
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
  - Java/extension/PrimeCounter.java
  - Java/extension/SegmentTree.java
  - Java/extension/UndoUnionFind.java
  - Java/all.java
  timestamp: '2023-12-03 22:43:45+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: Java/extension/Template.java
layout: document
redirect_from:
- /library/Java/extension/Template.java
- /library/Java/extension/Template.java.html
title: Java/extension/Template.java
---
