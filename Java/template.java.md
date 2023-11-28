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
  code: "import java.io.OutputStream;\nimport java.io.PrintWriter;\nimport java.util.ArrayList;\n\
    import java.util.Arrays;\nimport java.util.Collections;\nimport java.util.List;\n\
    import java.util.Scanner;\nimport java.util.stream.IntStream;\n\nclass VvyLw extends\
    \ MyFunction {\n\tprotected static final MyScanner sc = new MyScanner();\n\tprotected\
    \ static final MyPrinter o = new MyPrinter(System.out, false);\n\tprotected static\
    \ final MyPrinter e = new MyPrinter(System.err, false);\n\tstatic final int[]\
    \ dx = {0, -1, 1, 0, 0, -1, -1, 1, 1};\n\tstatic final int[] dy = {0, 0, 0, -1,\
    \ 1, -1, 1, -1, 1};\n\tstatic final int inf = 1 << 30;\n\tstatic final long linf\
    \ = (1L << 61) - 1;\n\tstatic final int mod998 = 998244353;\n\tstatic final int\
    \ mod107 = (int)1e9 + 7;\n\tprotected static void solve() {\n\t\t\n\t}\n}\nclass\
    \ Main extends VvyLw {\n\tpublic static void main(final String[] args) {\n\t\t\
    int t = 1;\n\t\t//t = sc.ni();\n\t\twhile(t-- > 0) {\n\t\t\tsolve();\n\t\t}\n\t\
    \to.flush();\n\t\tsc.close();\n\t\to.close();\n\t\te.close();\n\t}\n}\n\nclass\
    \ MyFunction {\n\tprotected static String yes(final boolean ok){ return ok ? \"\
    Yes\" : \"No\"; }\n\tprotected static String no(final boolean ok){ return yes(!ok);\
    \ }\n\tprotected static long sqr(final long x){ return x * x; }\n\tprotected static\
    \ int mod(final long n, final int m){ return (int) ((n + m) % m); }\n\tprotected\
    \ static long intCeil(long a, long b) { return (long) Math.ceil((double)a / b);\
    \ }\n\tprotected static long intPow(long a, int b) {\n\t\tlong res = 1;\n\t\t\
    while(b > 0) {\n\t\t\tif(b % 2 == 1) {\n\t\t\t\tres *= a;\n\t\t\t}\n\t\t\ta *=\
    \ a;\n\t\t\tb >>= 1;\n\t\t}\n\t\treturn res;\n\t}\n\tprotected static long modPow(long\
    \ a, long b, final int m) {\n\t\tlong res = 1;\n\t\twhile(b > 0) {\n\t\t\tif(b\
    \ % 2 == 1) {\n\t\t\t\tres *= a;\n\t\t\t\tres = mod(res, m);\n\t\t\t}\n\t\t\t\
    a *= a;\n\t\t\ta = mod(a, m);\n\t\t\tb >>= 1;\n\t\t}\n\t\treturn res;\n\t}\n\t\
    protected static ArrayList<Long> div(final Long n) {\n\t\tArrayList<Long> d =\
    \ new ArrayList<>();\n\t\tfinal long num = n.longValue();\n\t\tfor(long i = 1;\
    \ i * i <= num; ++i) {\n\t\t\tif(num % i == 0) {\n\t\t\t\td.add(Long.valueOf(i));\n\
    \t\t\t\tif(i * i != num) d.add(Long.valueOf(num / i));\n\t\t\t}\n\t\t}\n\t\tCollections.sort(d);\n\
    \t\treturn d;\n\t}\n\tprotected static ArrayList<Long> primeFactor(Long n) {\n\
    \t\tArrayList<Long> pf = new ArrayList<>();\n\t\tfor(long i = 2; i * i <= n; ++i)\
    \ {\n\t\t\tif(n % i != 0) continue;\n\t\t\twhile(n % i == 0) {\n\t\t\t\tpf.add(i);\n\
    \t\t\t\tn /= i;\n\t\t\t}\n\t\t}\n\t\tif(n != 1) pf.add(n);\n\t\treturn pf;\n\t\
    }\n\tprotected static long binom(int a, final int b) {\n\t\tlong res = 1;\n\t\t\
    for(int i = 1; i <= b; ++i) {\n\t\t\tres *= a--;\n\t\t\tres /= i;\n\t\t}\n\t\t\
    return res;\n\t}\n\tprotected static boolean isInt(final double n){ long r = (long)\
    \ Math.floor(n); return r == n; }\n\tprotected static boolean isSqr(final long\
    \ n){ return isInt(Math.sqrt(n)); }\n\tprotected static boolean isPrime(final\
    \ long n) {\n\t\tif(n == 1) return false;\n\t\tfor(long i = 2; i * i <= n; ++i)\
    \ {\n\t\t\tif(n % i == 0) return false;\n\t\t}\n\t\treturn true;\n\t}\n\tprotected\
    \ static boolean nextPerm(ArrayList<Integer> a) {\n\t\tfor(int i = a.size() -\
    \ 1; i > 0; i--) {\n\t\t\tif(a.get(i - 1).compareTo(a.get(i)) < 0) {\n\t\t\t\t\
    final int j = find(a.get(i - 1), a, i, a.size() - 1);\n\t\t\t\tCollections.swap(a,\
    \ i - 1, j);\n\t\t\t\tCollections.sort(a.subList(i, a.size()));\n\t\t\t\treturn\
    \ true;\n\t\t\t}\n\t\t}\n\t\treturn false;\n\t}\n\tprivate static <T extends Comparable<?\
    \ super T>> int find(T dest, ArrayList<T> a, int s, int e) {\n\t\tif (s == e)\
    \ return s;\n\t\tfinal int m = (s + e + 1) / 2;\n\t\treturn a.get(m).compareTo(dest)\
    \ <= 0 ? find(dest, a, s, m - 1):find(dest, a, m, e);\n\t}\n\tprotected static\
    \ boolean binarySearch(final int[] a, final int x) {\n\t\treturn Arrays.binarySearch(a,\
    \ x) >= 0;\n\t}\n\tprotected static boolean binarySearch(final long[] a, final\
    \ long x) {\n\t\treturn Arrays.binarySearch(a, x) >= 0;\n\t}\n\tprotected static\
    \ int lowerBound(final List<Integer> a, final int x) {\n\t\treturn ~Collections.binarySearch(a,\
    \ x, (p, q) -> p.compareTo(q) >= 0 ? 1 : -1);\n\t}\n\tprotected static int lowerBound(final\
    \ List<Long> a, final long x) {\n\t\treturn ~Collections.binarySearch(a, x, (p,\
    \ q) -> p.compareTo(q) >= 0 ? 1 : -1);\n\t}\n\tprotected static int upperBound(final\
    \ List<Integer>a, final int x) {\n\t\treturn ~Collections.binarySearch(a, x, (p,\
    \ q) -> p.compareTo(q) > 0 ? 1 : -1);\n\t}\n\tprotected static int upperBound(final\
    \ List<Long> a, final long x) {\n\t\treturn ~Collections.binarySearch(a, x, (p,\
    \ q) -> p.compareTo(q) > 0 ? 1 : -1);\n\t}\n\tprotected static int[] rotate(final\
    \ int[] a, final int id) {\n\t\tArrayList<Integer> t = new ArrayList<>();\n\t\t\
    for(final var el: a) {\n\t\t\tt.add(el);\n\t\t}\n\t\tCollections.rotate(t, id);\n\
    \t\tint[] res = new int[t.size()];\n\t\tfor(int i = 0; i < t.size(); ++i) {\n\t\
    \t\tres[i] = t.get(i);\n\t\t}\n\t\treturn res;\n\t}\n\tprotected static String\
    \ rotate(final String s, final int id) {\n\t\tArrayList<Character> t = new ArrayList<>();\n\
    \t\tfor(final char c: s.toCharArray()) {\n\t\t\tt.add(c);\n\t\t}\n\t\tCollections.rotate(t,\
    \ id);\n\t\tStringBuilder sb = new StringBuilder();\n\t\tfor(final var c: t) {\n\
    \t\t\tsb.append(c);\n\t\t}\n\t\treturn sb.toString(); \n\t}\n}\n\nclass MyScanner\
    \ {\n\tprivate Scanner sc = new Scanner(System.in);\n\tint ni(){ return sc.nextInt();\
    \ }\n\tlong nl(){ return sc.nextLong(); }\n\tdouble nd(){ return sc.nextDouble();\
    \ }\n\tString ns(){ return sc.next(); }\n\tint[] nil(final int n){\n\t\tint[]\
    \ a = new int[n];\n\t\tIntStream.range(0, n).forEach(i -> a[i] = ni());\n\t\t\
    return a;\n\t}\n\tlong[] nll(final int n){\n\t\tlong[] a = new long[n];\n\t\t\
    IntStream.range(0, n).forEach(i -> a[i] = nl());\n\t\treturn a;\n\t}\n\tdouble[]\
    \ ndl(final int n){\n\t\tdouble[] a = new double[n];\n\t\tIntStream.range(0, n).forEach(i\
    \ -> a[i] = nd());\n\t\treturn a;\n\t}\n\tString[] nsl(final int n){\n\t\tString[]\
    \ a = new String[n];\n\t\tIntStream.range(0, n).forEach(i -> a[i] = ns());\n\t\
    \treturn a;\n\t}\n\tArrayList<Integer> nial(final int n) {\n\t\tvar a = new ArrayList<Integer>(n);\n\
    \t\tIntStream.range(0, n).forEach(i -> a.add(i, ni()));\n\t\treturn a;\n\t}\n\t\
    ArrayList<Long> nlal(final int n) {\n\t\tvar a = new ArrayList<Long>(n);\n\t\t\
    IntStream.range(0, n).forEach(i -> a.add(i, nl()));\n\t\treturn a;\n\t}\n\tArrayList<Double>\
    \ ndal(final int n) {\n\t\tvar a = new ArrayList<Double>(n);\n\t\tIntStream.range(0,\
    \ n).forEach(i -> a.add(i, nd()));\n\t\treturn a;\n\t}\n\tArrayList<String> nsal(final\
    \ int n) {\n\t\tvar a = new ArrayList<String>(n);\n\t\tIntStream.range(0, n).forEach(i\
    \ -> a.add(i, ns()));\n\t\treturn a;\n\t}\n\tvoid close(){ sc.close(); }\n}\n\n\
    class MyPrinter {\n\tprivate PrintWriter pw;\n\tMyPrinter(final OutputStream os,\
    \ final boolean flush){ pw = new PrintWriter(os, flush); }\n\tvoid out(){ pw.println();\
    \ }\n\t<T> void out(final T arg){ pw.println(arg); }\n\tvoid out(final int[] args){\
    \ IntStream.range(0, args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length\
    \ ? \" \" : \"\\n\"))); }\n\tvoid out(final long[] args){ IntStream.range(0, args.length).forEach(i\
    \ -> pw.print(args[i] + (i + 1 < args.length ? \" \" : \"\\n\"))); }\n\tvoid out(final\
    \ double[] args){ IntStream.range(0, args.length).forEach(i -> pw.print(args[i]\
    \ + (i + 1 < args.length ? \" \" : \"\\n\"))); }\n\tvoid out(final char[] args){\
    \ IntStream.range(0, args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length\
    \ ? \" \" : \"\\n\"))); }\n\tvoid out(final String[] args){ IntStream.range(0,\
    \ args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length ? \" \" :\
    \ \"\\n\"))); }\n\t<T> void out(final List<T> args){ IntStream.range(0, args.size()).forEach(i\
    \ -> pw.print(args.get(i) + (i + 1 < args.size() ? \" \" : \"\\n\"))); }\n\t<T>\
    \ void outl(final List<T> args){ IntStream.range(0, args.size()).forEach(i ->\
    \ out(args.get(i))); }\n\t<T> void fin(final T arg) {\n\t\tout(arg);\n\t\tSystem.exit(0);\n\
    \t}\n\t<T> void fin(final List<T> args) {\n\t\tout(args);\n\t\tSystem.exit(0);\n\
    \t}\n\t<T> void fine(final List<T> args) {\n\t\toutl(args);\n\t\tSystem.exit(0);\n\
    \t}\n\tvoid flush(){ pw.flush(); }\n\tvoid close(){ pw.close(); }\n}\n\nclass\
    \ UnionFind {\n\tprivate int[] par;\n\tUnionFind(final int n) {\n\t\tpar = new\
    \ int[n];\n\t\tArrays.fill(par, -1);\n\t}\n\tint root(final int i){ return par[i]\
    \ >= 0 ? par[i] = root(par[i]) : i; }\n\tint size(final int i){ return -par[root(i)];\
    \ }\n\tboolean unite(int i, int j) {\n\t\ti = root(i);\n\t\tj = root(j);\n\t\t\
    if(i == j) return false;\n\t\tif(i > j) {\n\t\t\ti ^= j;\n\t\t\tj ^= i;\n\t\t\t\
    i ^= j;\n\t\t}\n\t\tpar[i] += par[j];\n\t\tpar[j] = i;\n\t\treturn true;\n\t}\n\
    \tboolean same(final int i, final int j){ return root(i) == root(j); }\n\tArrayList<ArrayList<Integer>>\
    \ groups() {\n\t\tfinal int n = par.length;\n\t\tArrayList<ArrayList<Integer>>\
    \ res = new ArrayList<>(n);\n\t\tfor(int i = 0; i < n; ++i) {\n\t\t\tres.add(new\
    \ ArrayList<>());\n\t\t}\n\t\tfor(int i = 0; i < n; ++i) {\n\t\t\tres.get(root(i)).add(i);\n\
    \t\t}\n\t\tres.removeIf(ArrayList::isEmpty);\n\t\treturn res;\n\t}\n\tboolean\
    \ is_bipartite() {\n\t\tfinal int n = par.length / 2;\n\t\tboolean ok = true;\n\
    \t\tfor(int i = 0; i < n; ++i) {\n\t\t\tok &= root(i) != root(i + n);\n\t\t}\n\
    \t\treturn ok;\n\t}\n}"
  dependsOn: []
  isVerificationFile: false
  path: Java/template.java
  requiredBy: []
  timestamp: '2023-11-28 12:18:19+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: Java/template.java
layout: document
redirect_from:
- /library/Java/template.java
- /library/Java/template.java.html
title: Java/template.java
---
