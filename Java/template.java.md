---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':warning:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: Java/template.java\n"
  code: "import java.io.OutputStream;\nimport java.io.PrintWriter;\nimport java.math.BigInteger;\n\
    import java.util.ArrayDeque;\nimport java.util.ArrayList;\nimport java.util.Arrays;\n\
    import java.util.Collection;\nimport java.util.Collections;\nimport java.util.Comparator;\n\
    import java.util.List;\nimport java.util.PriorityQueue;\nimport java.util.Queue;\n\
    import java.util.Scanner;\nimport java.util.TreeMap;\nimport java.util.function.BiFunction;\n\
    import java.util.function.BinaryOperator;\nimport java.util.function.Predicate;\n\
    import java.util.stream.Collectors;\nimport java.util.stream.IntStream;\n\nclass\
    \ VvyLw extends MyFunction {\n\tprotected static final MyScanner sc = new MyScanner();\n\
    \tprotected static final MyPrinter o = new MyPrinter(System.out, false);\n\tprotected\
    \ static final MyPrinter e = new MyPrinter(System.err, true);\n\tstatic final\
    \ int[] dx = {0, -1, 1, 0, 0, -1, -1, 1, 1};\n\tstatic final int[] dy = {0, 0,\
    \ 0, -1, 1, -1, 1, -1, 1};\n\tstatic final int inf = 1 << 30;\n\tstatic final\
    \ long linf = (1L << 61) - 1;\n\tstatic final int mod998 = 998244353;\n\tstatic\
    \ final int mod107 = (int)1e9 + 7;\n\tprotected static void solve() {\n\t\t\n\t\
    }\n}\nclass Main extends VvyLw {\n\tpublic static void main(final String[] args)\
    \ {\n\t\tint t = 1;\n\t\t//t = sc.ni();\n\t\twhile(t-- > 0) {\n\t\t\tsolve();\n\
    \t\t}\n\t\to.flush();\n\t\tsc.close();\n\t\to.close();\n\t\te.close();\n\t}\n\
    }\n\nclass MyFunction {\n\tprotected static String yes(final boolean ok){ return\
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
    }\n\tprotected static ArrayList<Long> primeFactor(long n) {\n\t\tArrayList<Long>\
    \ pf = new ArrayList<>();\n\t\tfor(long i = 2; i * i <= n; ++i) {\n\t\t\tif(n\
    \ % i != 0) continue;\n\t\t\twhile(n % i == 0) {\n\t\t\t\tpf.add(i);\n\t\t\t\t\
    n /= i;\n\t\t\t}\n\t\t}\n\t\tif(n != 1) pf.add(n);\n\t\treturn pf;\n\t}\n\tprotected\
    \ static long binom(int a, final int b) {\n\t\tlong res = 1;\n\t\tfor(int i =\
    \ 1; i <= b; ++i) {\n\t\t\tres *= a--;\n\t\t\tres /= i;\n\t\t}\n\t\treturn res;\n\
    \t}\n\tprotected static boolean isInt(final double n){ long r = (long) Math.floor(n);\
    \ return r == n; }\n\tprotected static boolean isSqr(final long n){ return isInt(Math.sqrt(n));\
    \ }\n\tprotected static boolean isPrime(final long n) {\n\t\tif(n == 1) return\
    \ false;\n\t\tfor(long i = 2; i * i <= n; ++i) {\n\t\t\tif(n % i == 0) return\
    \ false;\n\t\t}\n\t\treturn true;\n\t}\n\tprotected static boolean nextPerm(ArrayList<Integer>\
    \ a) {\n\t\tfor(int i = a.size() - 1; i > 0; i--) {\n\t\t\tif(a.get(i - 1).compareTo(a.get(i))\
    \ < 0) {\n\t\t\t\tfinal int j = find(a.get(i - 1), a, i, a.size() - 1);\n\t\t\t\
    \tCollections.swap(a, i - 1, j);\n\t\t\t\tCollections.sort(a.subList(i, a.size()));\n\
    \t\t\t\treturn true;\n\t\t\t}\n\t\t}\n\t\treturn false;\n\t}\n\tprivate static\
    \ <T extends Comparable<? super T>> int find(T dest, ArrayList<T> a, int s, int\
    \ e) {\n\t\tif (s == e) return s;\n\t\tfinal int m = (s + e + 1) / 2;\n\t\treturn\
    \ a.get(m).compareTo(dest) <= 0 ? find(dest, a, s, m - 1):find(dest, a, m, e);\n\
    \t}\n\tprotected static boolean binarySearch(final int[] a, final int x) {\n\t\
    \treturn Arrays.binarySearch(a, x) >= 0;\n\t}\n\tprotected static boolean binarySearch(final\
    \ long[] a, final long x) {\n\t\treturn Arrays.binarySearch(a, x) >= 0;\n\t}\n\
    \tprotected static int lowerBound(final List<Integer> a, final int x) {\n\t\t\
    return ~Collections.binarySearch(a, x, (p, q) -> p.compareTo(q) >= 0 ? 1 : -1);\n\
    \t}\n\tprotected static int lowerBound(final List<Long> a, final long x) {\n\t\
    \treturn ~Collections.binarySearch(a, x, (p, q) -> p.compareTo(q) >= 0 ? 1 : -1);\n\
    \t}\n\tprotected static int upperBound(final List<Integer>a, final int x) {\n\t\
    \treturn ~Collections.binarySearch(a, x, (p, q) -> p.compareTo(q) > 0 ? 1 : -1);\n\
    \t}\n\tprotected static int upperBound(final List<Long> a, final long x) {\n\t\
    \treturn ~Collections.binarySearch(a, x, (p, q) -> p.compareTo(q) > 0 ? 1 : -1);\n\
    \t}\n\tprotected static int[] reverse(final int[] a) {\n\t\tfinal int n = a.length;\n\
    \t\tint[] b = new int[n];\n\t\tfor(int i = 0; i <= n / 2; ++i) {\n\t\t\tb[i] =\
    \ a[n - 1 - i];\n\t\t\tb[n - 1 - i] = a[i];\n\t\t}\n\t\treturn b;\n\t}\n\tprotected\
    \ static long[] reverse(final long[] a) {\n\t\tfinal int n = a.length;\n\t\tlong[]\
    \ b = new long[n];\n\t\tfor(int i = 0; i <= n / 2; ++i) {\n\t\t\tb[i] = a[n -\
    \ 1 - i];\n\t\t\tb[n - 1 - i] = a[i];\n\t\t}\n\t\treturn b;\n\t}\n\tprotected\
    \ static double[] reverse(final double[] a) {\n\t\tfinal int n = a.length;\n\t\
    \tdouble[] b = new double[n];\n\t\tfor(int i = 0; i <= n / 2; ++i) {\n\t\t\tb[i]\
    \ = a[n - 1 - i];\n\t\t\tb[n - 1 - i] = a[i];\n\t\t}\n\t\treturn b;\n\t}\n\tprotected\
    \ static Object[] reverse(final Object[] a) {\n\t\tfinal int n = a.length;\n\t\
    \tObject[] b = new Object[n];\n\t\tfor(int i = 0; i <= n / 2; ++i) {\n\t\t\tb[i]\
    \ = a[n - 1 - i];\n\t\t\tb[n - 1 - i] = a[i];\n\t\t}\n\t\treturn b;\n\t}\n\tprotected\
    \ static int[] rotate(final int[] a, final int id) {\n\t\tArrayList<Integer> t\
    \ = new ArrayList<>(a.length);\n\t\tfor(final var el: a) {\n\t\t\tt.add(el);\n\
    \t\t}\n\t\tCollections.rotate(t, id);\n\t\tint[] res = new int[t.size()];\n\t\t\
    for(int i = 0; i < t.size(); ++i) {\n\t\t\tres[i] = t.get(i);\n\t\t}\n\t\treturn\
    \ res;\n\t}\n\tprotected static long[] rotate(final long[] a, final int id) {\n\
    \t\tArrayList<Long> t = new ArrayList<>(a.length);\n\t\tfor(final var el: a) {\n\
    \t\t\tt.add(el);\n\t\t}\n\t\tCollections.rotate(t, id);\n\t\tlong[] res = new\
    \ long[t.size()];\n\t\tfor(int i = 0; i < t.size(); ++i) {\n\t\t\tres[i] = t.get(i);\n\
    \t\t}\n\t\treturn res;\n\t}\n\tprotected static double[] rotate(final double[]\
    \ a, final int id) {\n\t\tArrayList<Double> t = new ArrayList<>(a.length);\n\t\
    \tfor(final var el: a) {\n\t\t\tt.add(el);\n\t\t}\n\t\tCollections.rotate(t, id);\n\
    \t\tdouble[] res = new double[t.size()];\n\t\tfor(int i = 0; i < t.size(); ++i)\
    \ {\n\t\t\tres[i] = t.get(i);\n\t\t}\n\t\treturn res;\n\t}\n\tprotected static\
    \ String rotate(final String s, final int id) {\n\t\tArrayList<Character> t =\
    \ new ArrayList<>();\n\t\tfor(final char c: s.toCharArray()) {\n\t\t\tt.add(c);\n\
    \t\t}\n\t\tCollections.rotate(t, id);\n\t\tStringBuilder sb = new StringBuilder();\n\
    \t\tfor(final var c: t) {\n\t\t\tsb.append(c);\n\t\t}\n\t\treturn sb.toString();\
    \ \n\t}\n\tprotected static int[][] rotate(final int[][] a) {\n\t\tfinal int h\
    \ = a.length, w = a[0].length;\n\t\tint[][] b = new int[w][h];\n\t\tIntStream.range(0,\
    \ h).forEach(i -> {\n\t\t\tIntStream.range(0, w).forEach(j -> b[j][i] = a[i][j]);\n\
    \t\t});\n\t\tIntStream.range(0, w).forEach(i -> b[i] = reverse(b[i]));\n\t\treturn\
    \ b;\n\t}\n\tprotected static long[][] rotate(final long[][] a) {\n\t\tfinal int\
    \ h = a.length, w = a[0].length;\n\t\tlong[][] b = new long[w][h];\n\t\tIntStream.range(0,\
    \ h).forEach(i -> {\n\t\t\tIntStream.range(0, w).forEach(j -> b[j][i] = a[i][j]);\n\
    \t\t});\n\t\tIntStream.range(0, w).forEach(i -> b[i] = reverse(b[i]));\n\t\treturn\
    \ b;\n\t}\n\tprotected static double[][] rotate(final double[][] a) {\n\t\tfinal\
    \ int h = a.length, w = a[0].length;\n\t\tdouble[][] b = new double[w][h];\n\t\
    \tIntStream.range(0, h).forEach(i -> {\n\t\t\tIntStream.range(0, w).forEach(j\
    \ -> b[j][i] = a[i][j]);\n\t\t});\n\t\tIntStream.range(0, w).forEach(i -> b[i]\
    \ = reverse(b[i]));\n\t\treturn b;\n\t}\n\tprotected static String[] rotate(final\
    \ String[] s) {\n\t\tfinal int h = s.length, w = s[0].length();\n\t\tchar[][]\
    \ t = new char[w][h];\n\t\tIntStream.range(0, h).forEach(i -> {\n\t\t\tIntStream.range(0,\
    \ w).forEach(j -> t[j][i] = s[i].charAt(j));\n\t\t});\n\t\tIntStream.range(0,\
    \ w).forEach(i -> t[i] = new StringBuilder(new String(t[i])).reverse().toString().toCharArray());\n\
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
    \ res;\n\t}\n}\n\nclass MyScanner {\n\tprivate Scanner sc = new Scanner(System.in);\n\
    \tint ni(){ return sc.nextInt(); }\n\tlong nl(){ return sc.nextLong(); }\n\tdouble\
    \ nd(){ return sc.nextDouble(); }\n\tString ns(){ return sc.next(); }\n\tint[]\
    \ ni(final int n){\n\t\tint[] a = new int[n];\n\t\tIntStream.range(0, n).forEach(i\
    \ -> a[i] = ni());\n\t\treturn a;\n\t}\n\tlong[] nl(final int n){\n\t\tlong[]\
    \ a = new long[n];\n\t\tIntStream.range(0, n).forEach(i -> a[i] = nl());\n\t\t\
    return a;\n\t}\n\tdouble[] nd(final int n){\n\t\tdouble[] a = new double[n];\n\
    \t\tIntStream.range(0, n).forEach(i -> a[i] = nd());\n\t\treturn a;\n\t}\n\tString[]\
    \ ns(final int n){\n\t\tString[] a = new String[n];\n\t\tIntStream.range(0, n).forEach(i\
    \ -> a[i] = ns());\n\t\treturn a;\n\t}\n\tArrayList<Integer> nia(final int n)\
    \ {\n\t\tvar a = new ArrayList<Integer>(n);\n\t\tIntStream.range(0, n).forEach(i\
    \ -> a.add(i, ni()));\n\t\treturn a;\n\t}\n\tArrayList<Long> nla(final int n)\
    \ {\n\t\tvar a = new ArrayList<Long>(n);\n\t\tIntStream.range(0, n).forEach(i\
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
    \ \"\\n\"))); }\n\tvoid out(final char[] args){ IntStream.range(0, args.length).forEach(i\
    \ -> pw.print(args[i] + (i + 1 < args.length ? \" \" : \"\\n\"))); }\n\tvoid out(final\
    \ Object[] args){ IntStream.range(0, args.length).forEach(i -> pw.print(args[i]\
    \ + (i + 1 < args.length ? \" \" : \"\\n\"))); }\n\t<T> void out(final List<T>\
    \ args){ IntStream.range(0, args.size()).forEach(i -> pw.print(args.get(i) + (i\
    \ + 1 < args.size() ? \" \" : \"\\n\"))); }\n\tvoid outl(final Object head, final\
    \ Object... tail) {\n\t\tout(head);\n\t\tArrays.stream(tail).forEach(pw::println);\n\
    \t}\n\tvoid outl(final int[] args){ Arrays.stream(args).forEach(pw::println);\
    \ }\n\tvoid outl(final int[][] args){ IntStream.range(0, args.length).forEach(i\
    \ -> out(args[i])); }\n\tvoid outl(final long[] args){ Arrays.stream(args).forEach(pw::println);\
    \ }\n\tvoid outl(final long[][] args){ IntStream.range(0, args.length).forEach(i\
    \ -> out(args[i])); }\n\tvoid outl(final double[] args){ Arrays.stream(args).forEach(pw::println);\
    \ }\n\tvoid outl(final double[][] args){ IntStream.range(0, args.length).forEach(i\
    \ -> out(args[i])); }\n\tvoid outl(final char[] args){ IntStream.range(0, args.length).forEach(i\
    \ -> out(args[i])); }\n\tvoid outl(final Object[] args){ Arrays.stream(args).forEach(pw::println);\
    \ }\n\t<E> void outl(final Collection<E> args){ args.stream().forEach(pw::println);\
    \ }\n\tvoid fin(final Object head, final Object... tail) {\n\t\tout(head, tail);\n\
    \t\tflush();\n\t\tSystem.exit(0);\n\t}\n\t<T> void fin(final List<T> args) {\n\
    \t\tout(args);\n\t\tflush();\n\t\tSystem.exit(0);\n\t}\n\t<E> void fine(final\
    \ Collection<E> args) {\n\t\toutl(args);\n\t\tflush();\n\t\tSystem.exit(0);\n\t\
    }\n\tvoid flush(){ pw.flush(); }\n\tvoid close(){ pw.close(); }\n}\n\nclass Pair<F,\
    \ S> {\n\tprotected final F first;\n\tprotected final S second;\n\tPair(final\
    \ F first, final S second) {\n\t\tthis.first = first;\n\t\tthis.second = second;\n\
    \t}\n\t@Override\n\tpublic boolean equals(final Object o) {\n\t\tif(this == o)\
    \ {\n\t\t\treturn true;\n\t\t}\n\t\tif(o == null || getClass() != o.getClass())\
    \ {\n\t\t\treturn false;\n\t\t}\n\t\tfinal Pair<?, ?> p = (Pair<?, ?>) o;\n\t\t\
    if(!first.equals(p.first)) {\n\t\t\treturn false;\n\t\t}\n\t\treturn second.equals(p.second);\n\
    \t}\n\t@Override\n\tpublic int hashCode(){ return 31 * first.hashCode() + second.hashCode();\
    \ }\n\t@Override\n\tpublic String toString(){ return \"(\" + first + \", \" +\
    \ second + \")\"; }\n\tpublic static <F, S> Pair<F, S> of(final F a, final S b){\
    \ return new Pair<>(a, b); }\n\tPair<S, F> swap(){ return Pair.of(second, first);\
    \ }\n}\n\nclass NumPair extends Pair<Number, Number> {\n\tNumPair(final Number\
    \ first, final Number second){ super(first, second); }\n\tNumPair rotate(){ return\
    \ new NumPair(-second.doubleValue(), first.doubleValue()); } \n\tNumPair rotate(final\
    \ int ang) {\n\t\tfinal double rad = Math.toRadians(MyFunction.mod(ang, 360));\n\
    \t\treturn new NumPair(first.doubleValue() * Math.cos(rad) - second.doubleValue()\
    \ * Math.sin(rad),\n\t\t\t\t\t\t\tfirst.doubleValue() * Math.sin(rad) + second.doubleValue()\
    \ * Math.cos(rad));\n\t}\n\tlong dot(final NumPair p){ return first.longValue()\
    \ * p.first.longValue() + second.longValue() + p.second.longValue(); }\n\tlong\
    \ cross(final NumPair p){ return this.rotate().dot(p); }\n\tlong square(){ return\
    \ this.dot(this); }\n\tdouble grad() { \n\t\ttry {\n\t\t\treturn second.doubleValue()\
    \ / first.doubleValue();\n\t\t} catch(ArithmeticException e) {\n\t\t\te.printStackTrace();\n\
    \t\t\treturn Double.NaN;\n\t\t}\n\t}\n\tdouble abs(){ return Math.hypot(first.doubleValue(),\
    \ second.doubleValue()); }\n\tdouble lcm(){ return MyFunction.lcm(first.longValue(),\
    \ second.longValue()); }\n\tdouble gcd(){ return MyFunction.gcd(first.longValue(),\
    \ second.longValue()); }\n\tNumPair extgcd() {\n\t\tlong x = 1, y = 0, t1 = 0,\
    \ t2 = 0, t3 = 1, a = first.longValue(), b = second.longValue();\n\t\twhile(b\
    \ > 0) {\n\t\t\tt1=a / b;\n\t\t\ta -= t1 * b;\n\t\t\ta ^= b;\n\t\t\tb ^= a;\n\t\
    \t\ta ^= b;\n\t\t\tx -= t1 * t2;\n\t\t\tx ^= t2;\n\t\t\tt2 ^= x;\n\t\t\tx ^= t2;\n\
    \t\t\ty -= t1 * t3;\n\t\t\ty ^= t3;\n\t\t\tt3 ^= y;\n\t\t\ty ^= t3;\n\t\t}\n\t\
    \treturn new NumPair(x, y);\n\t}\n}\n\nclass UnionFind {\n\tprivate int[] par;\n\
    \tUnionFind(final int n) {\n\t\tpar = new int[n];\n\t\tArrays.fill(par, -1);\n\
    \t}\n\tint root(final int i){ return par[i] >= 0 ? par[i] = root(par[i]) : i;\
    \ }\n\tint size(final int i){ return -par[root(i)]; }\n\tboolean unite(int i,\
    \ int j) {\n\t\ti = root(i);\n\t\tj = root(j);\n\t\tif(i == j) return false;\n\
    \t\tif(i > j) {\n\t\t\ti ^= j;\n\t\t\tj ^= i;\n\t\t\ti ^= j;\n\t\t}\n\t\tpar[i]\
    \ += par[j];\n\t\tpar[j] = i;\n\t\treturn true;\n\t}\n\tboolean same(final int\
    \ i, final int j){ return root(i) == root(j); }\n\tArrayList<ArrayList<Integer>>\
    \ groups() {\n\t\tfinal int n = par.length;\n\t\tArrayList<ArrayList<Integer>>\
    \ res = new ArrayList<>(n);\n\t\tIntStream.range(0, n).forEach(i -> res.add(new\
    \ ArrayList<>()));\n\t\tIntStream.range(0, n).forEach(i -> res.get(root(i)).add(i));\n\
    \t\tres.removeIf(ArrayList::isEmpty);\n\t\treturn res;\n\t}\n\tboolean is_bipartite()\
    \ {\n\t\tfinal int n = par.length / 2;\n\t\tboolean ok = true;\n\t\tfor(int i\
    \ = 0; i < n; ++i) {\n\t\t\tok &= root(i) != root(i + n);\n\t\t}\n\t\treturn ok;\n\
    \t}\n}\n\nclass Edge {\n\tpublic int src;\n\tpublic int to;\n\tpublic long cost;\n\
    \tEdge(final int to) {\n\t\tthis.to = to;\n\t}\n\tEdge(final int to, final long\
    \ cost) {\n\t\tthis.to = to;\n\t\tthis.cost = cost;\n\t}\n\tEdge(final int src,\
    \ final int to, final long cost) {\n\t\tthis.src = src;\n\t\tthis.to = to;\n\t\
    \tthis.cost = cost;\n\t}\n}\nclass Graph {\n\tprotected boolean undirected;\n\t\
    protected int n, indexed;\n\tArrayList<ArrayList<Edge>> g;\n\tGraph(final int\
    \ n, final int indexed, final boolean undirected) {\n\t\tthis.n = n;\n\t\tthis.indexed\
    \ = indexed;\n\t\tthis.undirected = undirected;\n\t\tg = new ArrayList<>(n);\n\
    \t\tIntStream.range(0, n).forEach(i -> g.add(new ArrayList<>()));\n\t}\n\tvoid\
    \ add(int a, int b, final long cost) {\n\t\ta -= indexed;\n\t\tb -= indexed;\n\
    \t\tg.get(a).add(new Edge(b));\n\t\tif(undirected) {\n\t\t\tg.get(b).add(new Edge(a));\n\
    \t\t}\n\t}\n\tprotected int[] allDist(final int v) {\n\t\tint[] d = new int[n];\n\
    \t\tArrays.fill(d, -1);\n\t\tQueue<Integer> q = new ArrayDeque<>();\n\t\td[v]\
    \ = 0;\n\t\tq.add(v);\n\t\twhile(!q.isEmpty()) {\n\t\t\tfinal int tmp = q.poll();\n\
    \t\t\tfor(final var el: g.get(tmp)) {\n\t\t\t\tif(d[el.to] != -1) {\n\t\t\t\t\t\
    continue;\n\t\t\t\t}\n\t\t\t\td[el.to]=d[tmp]+1;\n\t\t\t\tq.add(el.to);\n\t\t\t\
    }\n\t\t}\n\t\treturn d;\n\t}\n\tprotected int dist(final int u, final int v){\
    \ return allDist(u)[v]; }\n}\nclass WeightedGraph extends Graph {\n\tArrayList<ArrayList<Edge>>\
    \ g;\n\tWeightedGraph(final int n, final int indexed, final boolean undirected)\
    \ {\n\t\tsuper(n, indexed, undirected);\n\t\tg = new ArrayList<>(n);\n\t\tIntStream.range(0,\
    \ n).forEach(i -> g.add(new ArrayList<>()));\n\t}\n\tvoid add(int a, int b, final\
    \ long cost) {\n\t\ta -= indexed;\n\t\tb -= indexed;\n\t\tg.get(a).add(new Edge(b,\
    \ cost));\n\t\tif(undirected) {\n\t\t\tg.get(b).add(new Edge(a, cost));\n\t\t\
    }\n\t}\n\tlong[] dijkstra(final int v) {\n\t\tlong[] cost = new long[n];\n\t\t\
    Arrays.fill(cost, Long.MAX_VALUE);\n\t\tQueue<NumPair> dj = new PriorityQueue<>(Collections.reverseOrder());\n\
    \t\tcost[v] = 0;\n\t\tdj.add(new NumPair(cost[v], v));\n\t\twhile(!dj.isEmpty())\
    \ {\n\t\t\tfinal var tmp = dj.poll();\n\t\t\tif(cost[tmp.second.intValue()] <\
    \ tmp.first.longValue()) {\n\t\t\t\tcontinue;\n\t\t\t}\n\t\t\tfor(final var el:\
    \ g.get(tmp.second.intValue())) {\n\t\t\t\tif(cost[el.to] > tmp.first.longValue()\
    \ + el.cost) {\n\t\t\t\t\tcost[el.to] = tmp.first.longValue() + el.cost;\n\t\t\
    \t\t\tdj.add(new NumPair(cost[el.to], el.to));\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\t\
    return cost;\n\t}\n\tlong[][] warshallFloyd() {\n\t\tlong[][] cost = new long[n][n];\n\
    \t\tIntStream.range(0, n).forEach(i -> Arrays.fill(cost[i], Long.MAX_VALUE));\n\
    \t\tIntStream.range(0, n).forEach(i -> cost[i][i] = 0);\n\t\tfor(int i = 0; i\
    \ < n; ++i) {\n\t\t\tfor(final var j: g.get(i)) {\n\t\t\t\tcost[i][j.to] = j.cost;\n\
    \t\t\t}\n\t\t}\n\t\tfor(int k = 0 ; k < n; ++k) {\n\t\t\tfor(int i = 0; i < n;\
    \ ++i) {\n\t\t\t\tfor(int j = 0; j < n; ++j) {\n\t\t\t\t\tif(cost[i][j] > cost[i][k]\
    \ + cost[k][j]) {\n\t\t\t\t\t\tcost[i][j] = cost[i][k] + cost[k][j];\n\t\t\t\t\
    \t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\treturn cost;\n\t}\n}\nclass Tree {\n\tpublic\
    \ ArrayList<Edge> edge;\n\tprivate int n, indexed;\n\tTree(final int n, final\
    \ int indexed) {\n\t\tedge = new ArrayList<>(n);\n\t\tthis.n = n;\n\t\tthis.indexed\
    \ = indexed;\n\t}\n\tvoid add(final int a, final int b, final long cost){ edge.add(new\
    \ Edge(a - indexed, b - indexed, cost)); }\n\tlong kruskal() {\n\t\tCollections.sort(edge,\
    \ Comparator.comparing(e -> e.cost));\n\t\tUnionFind uf = new UnionFind(n);\n\t\
    \tlong res = 0;\n\t\tfor(final var ed: edge) {\n\t\t\tif(uf.unite(ed.src, ed.to))\
    \ {\n\t\t\t\tres += ed.cost;\n\t\t\t}\n\t\t}\n\t\treturn res;\n\t}\n}\n\nclass\
    \ PrimeTable {\n\tprivate int n;\n\tboolean[] sieve;\n\tPrimeTable(final int n)\
    \ {\n\t\tthis.n = n;\n\t\tsieve = new boolean[n + 1];\n\t\tArrays.fill(sieve,\
    \ true);\n\t\tfor(long i = 2; i <= n; ++i) {\n\t\t\tif(!sieve[(int) i]) {\n\t\t\
    \t\tcontinue;\n\t\t\t}\n\t\t\tfor(long j = i * i; j <= n; j += i) {\n\t\t\t\t\
    sieve[(int) j] = false;\n\t\t\t}\n\t\t}\n\t}\n\tArrayList<Integer> get() {\n\t\
    \tArrayList<Integer> p = new ArrayList<>();;\n\t\tfor(int i = 2; i <= n; ++i)\
    \ {\n\t\t\tif(sieve[i]) {\n\t\t\t\tp.add(i);\n\t\t\t}\n\t\t}\n\t\treturn p;\n\t\
    }\n}\n\nclass PrimeFactor {\n\tprivate int[] spf;\n\tPrimeFactor(final int n)\
    \ {\n\t\tspf = IntStream.rangeClosed(0, n).toArray();\n\t\tfor(int i = 2; i *\
    \ i <= n; ++i) {\n\t\t\tif(spf[i] == i) {\n\t\t\t\tfor(int j = i * i; j <= n;\
    \ j += i) {\n\t\t\t\t\tif(spf[j] == j) {\n\t\t\t\t\t\tspf[j] = i;\n\t\t\t\t\t\
    }\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\tTreeMap<Integer, Integer> get(int n) {\n\t\
    \tTreeMap<Integer, Integer> m = new TreeMap<>();\n\t\twhile(n != 1) {\n\t\t\t\
    m.merge(spf[n], 1, (a, b) -> (a + b));\n\t\t\tn /= spf[n];\n\t\t}\n\t\treturn\
    \ m;\n\t}\n}\n\nclass BigPrime {\n\tprivate int bsf(final long x){ return Long.numberOfTrailingZeros(x);\
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
    \ {\n\t\t\treturn 2;\n\t\t}\n\t\tint st = 0;\n\t\tfinal BiFunction<Long, Integer,\
    \ Long> f = (x, y) -> { return BigInteger.valueOf(x).multiply(BigInteger.valueOf(x)).add(BigInteger.valueOf(y)).mod(BigInteger.valueOf(n)).longValue();\
    \ };\n\t\twhile(true) {\n\t\t\tst++;\n\t\t\tlong x = st, y = f.apply(x, st);\n\
    \t\t\twhile(true) {\n\t\t\t\tfinal long p = gcd(y - x + n, n);\n\t\t\t\tif(p ==\
    \ 0 || p == n) {\n\t\t\t\t\tbreak;\n\t\t\t\t}\n\t\t\t\tif(p != 1) {\n\t\t\t\t\t\
    return p;\n\t\t\t\t}\n\t\t\t\tx = f.apply(x, st);\n\t\t\t\ty = f.apply(f.apply(y,\
    \ st), st);\n\t\t\t}\n\t\t}\n\t}\n\tArrayList<Long> primeFactor(final long n)\
    \ {\n\t\tif(n == 1) return new ArrayList<>();\n\t\tfinal long x = find(n);\n\t\
    \tif(x == n) return new ArrayList<>(Arrays.asList(x));\n\t\tArrayList<Long> le\
    \ = primeFactor(x);\n\t\tfinal ArrayList<Long> ri = primeFactor(n / x);\n\t\t\
    le.addAll(ri);\n\t\treturn le;\n\t}\n}\n\nclass FenwickTree {\n\tprivate int n;\n\
    \tprivate long[] data;\n\tFenwickTree(final int n) {\n\t\tthis.n = n + 2;\n\t\t\
    data = new long[n + 1];\n\t}\n\tlong sum(int k) {\n\t\tif(k < 0) return 0;\n\t\
    \tlong ret = 0;\n\t\tfor(++k; k > 0; k -= k & -k) {\n\t\t\tret += data[k];\n\t\
    \t}\n\t\treturn ret;\n\t}\n\tlong sum(final int l, final int r){ return sum(r)\
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
    \ k];\n\t\t\t\tx += k;\n\t\t\t}\n\t\t}\n\t\treturn x;\n\t}\n}\n\nclass SegmentTree\
    \ {\n\tprivate int n = 1, rank = 0, fini;\n\tfinal BinaryOperator<Long> op;\n\t\
    final long e;\n\tprivate long[] dat;\n\tSegmentTree(final int fini, final BinaryOperator<Long>\
    \ op, final long e) {\n\t\tthis.fini = fini;\n\t\tthis.op = op;\n\t\tthis.e =\
    \ e;\n\t\twhile(this.fini > n) {\n\t\t\tn <<= 1;\n\t\t\trank++;\n\t\t}\n\t\tdat\
    \ = new long[2 * n];\n\t\tArrays.fill(dat, e);\n\t}\n\tvoid update(int i, final\
    \ long x) {\n\t\ti += n;\n\t\tdat[i] = x;\n\t\ti >>= 1;\n\t\twhile(i > 0) {\n\t\
    \t\tdat[i] = op.apply(dat[2 * i], dat[2 * i + 1]);\n\t\t}\n\t}\n\tvoid add(int\
    \ i, final long x) {\n\t\ti += n;\n\t\tdat[i] += x;\n\t\ti >>= 1;\n\t\twhile(i\
    \ > 0) {\n\t\t\tdat[i] = op.apply(dat[2 * i], dat[2 * i + 1]);\n\t\t}\n\t}\n\t\
    long query(int a, int b) {\n\t\tlong l=e,r=e;\n\t\tfor(a += n, b += n; a < b;\
    \ a >>= 1, b >>= 1) {\n\t\t\tif(a % 2 == 1) {\n\t\t\t\tl = op.apply(l, dat[a++]);\n\
    \t\t\t}\n\t\t\tif(b % 2 == 1) {\n\t\t\t\tr = op.apply(dat[--b], r);\n\t\t\t}\n\
    \t\t}\n\t\treturn op.apply(l,r);\n\t}\n\tint findLeft(int r, final Predicate<Long>\
    \ fn) {\n\t\tif(r == 0) {\n\t\t\treturn 0;\n\t\t}\n\t\tint h = 0, i = r + n;\n\
    \t\tlong val = e;\n\t\tfor(; h <= rank; h++) {\n\t\t\tif(i >> (h & 1) > 0) {\n\
    \t\t\t\tfinal long val2 = op.apply(val, dat[i >> (h ^ 1)]);\n\t\t\t\tif(fn.test(val2)){\n\
    \t\t\t\t\ti -= 1 << h;\n\t\t\t\t\tif(i == n) {\n\t\t\t\t\t\treturn 0;\n\t\t\t\t\
    \t}\n\t\t\t\t\tval = val2;\n\t\t\t\t}\n\t\t\t\telse {\n\t\t\t\t\tbreak;\n\t\t\t\
    \t}\n\t\t\t}\n\t\t}\n\t\tfor(; h-- > 0;) {\n\t\t\tlong val2 = op.apply(val, dat[(i\
    \ >> h) - 1]);\n\t\t\tif(fn.test(val2)){\n\t\t\t\ti -= 1 << h;\n\t\t\t\tif(i ==\
    \ n) {\n\t\t\t\t\treturn 0;\n\t\t\t\t}\n\t\t\t\tval = val2;\n\t\t\t}\n\t\t}\n\t\
    \treturn i - n;\n\t}\n\tint findRight(int l, final Predicate<Long> fn) {\n\t\t\
    if(l == fini) {\n\t\t\treturn fini;\n\t\t}\n\t\tint h = 0, i = l + n;\n\t\tlong\
    \ val = e;\n\t\tfor(; h <= rank; h++) {\n\t\t\tif(i >> (h & 1) > 0){\n\t\t\t\t\
    long val2 = op.apply(val, dat[i >> h]);\n\t\t\t\tif(fn.test(val2)){\n\t\t\t\t\t\
    i += 1 << h;\n\t\t\t\t\tif(i == n * 2) {\n\t\t\t\t\t\treturn fini;\n\t\t\t\t\t\
    }\n\t\t\t\t\tval = val2;\n\t\t\t\t}\n\t\t\t\telse {\n\t\t\t\t\tbreak;\n\t\t\t\t\
    }\n\t\t\t}\n\t\t}\n\t\tfor(; h-- > 0;) {\n\t\t\tlong val2 = op.apply(val, dat[i>>h]);\n\
    \t\t\tif(fn.test(val2)) {\n\t\t\t\ti += 1 << h;\n\t\t\t\tif(i == n * 2) {\n\t\t\
    \t\t\treturn fini;\n\t\t\t\t}\n\t\t\t\tval = val2;\n\t\t\t}\n\t\t}\n\t\treturn\
    \ Math.min(i - n, fini);\n\t}\n}\n\nclass SparseTable {\n\tprivate long[][] st;\n\
    \tprivate int[] lookup;\n\tprivate BinaryOperator<Long> op;\n\tSparseTable(final\
    \ long[] a, final BinaryOperator<Long> op) {\n\t\tthis.op = op;\n\t\tint b = 0;\n\
    \t\twhile((1 << b) <= a.length) {\n\t\t\t++b;\n\t\t}\n\t\tst = new long[b][1 <<\
    \ b];\n\t\tfor(int i = 0; i < a.length; i++) {\n\t\t\tst[0][i] = a[i];\n\t\t}\n\
    \t\tfor(int i = 1; i < b; i++) {\n\t\t\tfor(int j = 0; j + (1 << i) <= (1 << b);\
    \ j++) {\n\t\t\t\tst[i][j] = op.apply(st[i - 1][j], st[i - 1][j + (1 << (i - 1))]);\n\
    \t\t\t}\n\t\t}\n\t\tlookup = new int[a.length + 1];\n\t\tfor(int i = 2; i < lookup.length;\
    \ i++) {\n\t\t\tlookup[i] = lookup[i >> 1] + 1;\n\t\t}\n\t}\n\tlong query(final\
    \ int l, final int r) {\n\t\tfinal int b = lookup[r - l];\n\t\treturn op.apply(st[b][l],\
    \ st[b][r - (1 << b)]);\n\t}\n\tint minLeft(final int x, final Predicate<Long>\
    \ fn) {\n\t\tif(x == 0) {\n\t\t\treturn 0;\n\t\t}\n\t\tint ok = x, ng = -1;\n\t\
    \twhile(Math.abs(ok - ng) > 1) {\n\t\t\tfinal int mid = (ok + ng) / 2;\n\t\t\t\
    if(fn.test(query(mid, x) - 1)) {\n\t\t\t\tok = mid;\n\t\t\t}\n\t\t\telse {\n\t\
    \t\t\tng = mid;\n\t\t\t}\n\t\t}\n\t\treturn ok;\n\t}\n\tint maxRight(final int\
    \ x, final Predicate<Long> fn) {\n\t\tif(x == lookup.length - 1) {\n\t\t\treturn\
    \ lookup.length - 1;\n\t\t}\n\t\tint ok = x, ng = lookup.length;\n\t\twhile(Math.abs(ok\
    \ - ng) > 1) {\n\t\t\tint mid = (ok + ng) / 2;\n\t\t\tif(fn.test(query(x, mid)))\
    \ {\n\t\t\t\tok = mid;\n\t\t\t}\n\t\t\telse {\n\t\t\t\tng = mid;\n\t\t\t}\n\t\t\
    }\n\t\treturn ok;\n\t}\n}"
  dependsOn: []
  isVerificationFile: false
  path: Java/template.java
  requiredBy: []
  timestamp: '2023-11-30 05:11:40+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: Java/template.java
layout: document
redirect_from:
- /library/Java/template.java
- /library/Java/template.java.html
title: Java/template.java
---
