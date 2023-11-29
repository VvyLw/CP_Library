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
    import java.util.ArrayList;\nimport java.util.Arrays;\nimport java.util.Collection;\n\
    import java.util.Collections;\nimport java.util.List;\nimport java.util.Scanner;\n\
    import java.util.function.BiFunction;\nimport java.util.stream.IntStream;\n\n\
    class VvyLw extends MyFunction {\n\tprotected static final MyScanner sc = new\
    \ MyScanner();\n\tprotected static final MyPrinter o = new MyPrinter(System.out,\
    \ false);\n\tprotected static final MyPrinter e = new MyPrinter(System.err, true);\n\
    \tstatic final int[] dx = {0, -1, 1, 0, 0, -1, -1, 1, 1};\n\tstatic final int[]\
    \ dy = {0, 0, 0, -1, 1, -1, 1, -1, 1};\n\tstatic final int inf = 1 << 30;\n\t\
    static final long linf = (1L << 61) - 1;\n\tstatic final int mod998 = 998244353;\n\
    \tstatic final int mod107 = (int)1e9 + 7;\n\tprotected static void solve() {\n\
    \t\t\n\t}\n}\nclass Main extends VvyLw {\n\tpublic static void main(final String[]\
    \ args) {\n\t\tint t = 1;\n\t\t//t = sc.ni();\n\t\twhile(t-- > 0) {\n\t\t\tsolve();\n\
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
    \t}\n\tprotected static int[] rotate(final int[] a, final int id) {\n\t\tArrayList<Integer>\
    \ t = new ArrayList<>();\n\t\tfor(final var el: a) {\n\t\t\tt.add(el);\n\t\t}\n\
    \t\tCollections.rotate(t, id);\n\t\tint[] res = new int[t.size()];\n\t\tfor(int\
    \ i = 0; i < t.size(); ++i) {\n\t\t\tres[i] = t.get(i);\n\t\t}\n\t\treturn res;\n\
    \t}\n\tprotected static String rotate(final String s, final int id) {\n\t\tArrayList<Character>\
    \ t = new ArrayList<>();\n\t\tfor(final char c: s.toCharArray()) {\n\t\t\tt.add(c);\n\
    \t\t}\n\t\tCollections.rotate(t, id);\n\t\tStringBuilder sb = new StringBuilder();\n\
    \t\tfor(final var c: t) {\n\t\t\tsb.append(c);\n\t\t}\n\t\treturn sb.toString();\
    \ \n\t}\n\tprotected static long lcm(final long a, final long b){ return a * b\
    \ / gcd(a, b); }\n\tprotected static long gcd(final long a, final long b){ return\
    \ b > 0 ? gcd(b, a % b) : a; }\n\tprotected static <F, S> ArrayList<F> first(final\
    \ List<Pair<F, S>> p) {\n\t\tArrayList<F> f = new ArrayList<>();\n\t\tfor(final\
    \ var el: p) {\n\t\t\tf.add(el.first);\n\t\t}\n\t\treturn f;\n\t}\n\tprotected\
    \ static <F, S> ArrayList<S> second(final List<Pair<F, S>> p) {\n\t\tArrayList<S>\
    \ s = new ArrayList<>();\n\t\tfor(final var el: p) {\n\t\t\ts.add(el.second);\n\
    \t\t}\n\t\treturn s;\n\t}\n}\n\nclass MyScanner {\n\tprivate Scanner sc = new\
    \ Scanner(System.in);\n\tint ni(){ return sc.nextInt(); }\n\tlong nl(){ return\
    \ sc.nextLong(); }\n\tdouble nd(){ return sc.nextDouble(); }\n\tString ns(){ return\
    \ sc.next(); }\n\tint[] ni(final int n){\n\t\tint[] a = new int[n];\n\t\tIntStream.range(0,\
    \ n).forEach(i -> a[i] = ni());\n\t\treturn a;\n\t}\n\tlong[] nl(final int n){\n\
    \t\tlong[] a = new long[n];\n\t\tIntStream.range(0, n).forEach(i -> a[i] = nl());\n\
    \t\treturn a;\n\t}\n\tdouble[] nd(final int n){\n\t\tdouble[] a = new double[n];\n\
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
    \ }\n\tvoid outl(final long[] args){ Arrays.stream(args).forEach(pw::println);\
    \ }\n\tvoid outl(final double[] args){ Arrays.stream(args).forEach(pw::println);\
    \ }\n\tvoid outl(final char[] args){ IntStream.range(0, args.length).forEach(i\
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
    \ int ang) {\n\t\tfinal double rad = Math.PI * MyFunction.mod(ang, 360) / 180;\n\
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
    \ res = new ArrayList<>(n);\n\t\tfor(int i = 0; i < n; ++i) {\n\t\t\tres.add(new\
    \ ArrayList<>());\n\t\t}\n\t\tfor(int i = 0; i < n; ++i) {\n\t\t\tres.get(root(i)).add(i);\n\
    \t\t}\n\t\tres.removeIf(ArrayList::isEmpty);\n\t\treturn res;\n\t}\n\tboolean\
    \ is_bipartite() {\n\t\tfinal int n = par.length / 2;\n\t\tboolean ok = true;\n\
    \t\tfor(int i = 0; i < n; ++i) {\n\t\t\tok &= root(i) != root(i + n);\n\t\t}\n\
    \t\treturn ok;\n\t}\n}\n\nclass BigPrime {\n\tprivate int bsf(final long x){ return\
    \ Long.numberOfTrailingZeros(x); }\n\tprivate long gcd(long a, long b) {\n\t\t\
    a = Math.abs(a);\n\t\tb = Math.abs(b);\n\t\tif(a == 0) {\n\t\t\treturn b;\n\t\t\
    }\n\t\tif(b == 0) {\n\t\t\treturn a;\n\t\t}\n\t\tfinal int shift = bsf(a|b);\n\
    \t\ta >>= bsf(a);\n\t\tdo {\n\t\t\tb >>= bsf(b);\n\t\t\tif(a > b) {\n\t\t\t\t\
    a ^= b;\n\t\t\t\tb ^= a;\n\t\t\t\ta ^= b;\n\t\t\t}\n\t\t\tb -= a;\n\t\t} while(b\
    \ > 0);\n\t\treturn a << shift;\n\t}\n\tboolean isPrime(final long n) {\n\t\t\
    if(n <= 1) {\n\t\t\treturn false;\n\t\t}\n\t\tif(n == 2) {\n\t\t\treturn true;\n\
    \t\t}\n\t\tif(n % 2 == 0) {\n\t\t\treturn false;\n\t\t}\n\t\tlong d = n - 1;\n\
    \t\twhile(d % 2 == 0) {\n\t\t\td /= 2;\n\t\t}\n\t\tfinal long[] sample = {2, 3,\
    \ 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};\n\t\tfor(final long a: sample) {\n\t\t\
    \tif(n <= a) {\n\t\t\t\tbreak;\n\t\t\t}\n\t\t\tlong t = d;\n\t\t\tBigInteger y\
    \ = BigInteger.valueOf(a).modPow(BigInteger.valueOf(t), BigInteger.valueOf(n));\n\
    \t\t\twhile(t != n - 1 && !y.equals(BigInteger.ONE) && !y.equals(BigInteger.valueOf(n).subtract(BigInteger.ONE)))\
    \ {\n\t\t\t\ty = y.multiply(y).mod(BigInteger.valueOf(n));\n\t\t\t\tt <<= 1;\n\
    \t\t\t}\n\t\t\tif(!y.equals(BigInteger.valueOf(n).subtract(BigInteger.ONE)) &&\
    \ t % 2 == 0) {\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t\treturn true;\n\t}\n\
    \tprivate long find(final long n) {\n\t\tif(isPrime(n)) {\n\t\t\treturn n;\n\t\
    \t}\n\t\tif(n % 2 == 0) {\n\t\t\treturn 2;\n\t\t}\n\t\tint st = 0;\n\t\tfinal\
    \ BiFunction<Long, Integer, Long> f = (x, y) -> { return BigInteger.valueOf(x).multiply(BigInteger.valueOf(x)).add(BigInteger.valueOf(y)).mod(BigInteger.valueOf(n)).longValue();\
    \ };\n\t\twhile(true) {\n\t\t\tst++;\n\t\t\tlong x = st, y = f.apply(x, st);\n\
    \t\t\twhile(true) {\n\t\t\t\tfinal long p = gcd(y - x + n, n);\n\t\t\t\tif(p ==\
    \ 0 || p == n) {\n\t\t\t\t\tbreak;\n\t\t\t\t}\n\t\t\t\tif(p != 1) {\n\t\t\t\t\t\
    return p;\n\t\t\t\t}\n\t\t\t\tx = f.apply(x, st);\n\t\t\t\ty = f.apply(f.apply(y,\
    \ st), st);\n\t\t\t}\n\t\t}\n\t}\n\tArrayList<Long> primeFactor(final long n)\
    \ {\n\t\tif(n == 1) return new ArrayList<>();\n\t\tfinal long x = find(n);\n\t\
    \tif(x == n) return new ArrayList<>(Arrays.asList(x));\n\t\tArrayList<Long> le\
    \ = primeFactor(x);\n\t\tfinal ArrayList<Long> ri = primeFactor(n / x);\n\t\t\
    le.addAll(ri);\n\t\treturn le;\n\t}\n}"
  dependsOn: []
  isVerificationFile: false
  path: Java/template.java
  requiredBy: []
  timestamp: '2023-11-29 22:47:00+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: Java/template.java
layout: document
redirect_from:
- /library/Java/template.java
- /library/Java/template.java.html
title: Java/template.java
---
