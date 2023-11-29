import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.IntStream;

class VvyLw extends MyFunction {
	protected static final MyScanner sc = new MyScanner();
	protected static final MyPrinter o = new MyPrinter(System.out, false);
	protected static final MyPrinter e = new MyPrinter(System.err, true);
	static final int[] dx = {0, -1, 1, 0, 0, -1, -1, 1, 1};
	static final int[] dy = {0, 0, 0, -1, 1, -1, 1, -1, 1};
	static final int inf = 1 << 30;
	static final long linf = (1L << 61) - 1;
	static final int mod998 = 998244353;
	static final int mod107 = (int)1e9 + 7;
	protected static void solve() {
		
	}
}
class Main extends VvyLw {
	public static void main(final String[] args) {
		int t = 1;
		//t = sc.ni();
		while(t-- > 0) {
			solve();
		}
		o.flush();
		sc.close();
		o.close();
		e.close();
	}
}

class MyFunction {
	protected static String yes(final boolean ok){ return ok ? "Yes" : "No"; }
	protected static String no(final boolean ok){ return yes(!ok); }
	protected static long sqr(final long x){ return x * x; }
	protected static int mod(final long n, final int m){ return (int) ((n + m) % m); }
	protected static long intCeil(long a, long b){ return (long) Math.ceil((double)a / b); }
	protected static long intPow(long a, int b) {
		long res = 1;
		while(b > 0) {
			if(b % 2 == 1) {
				res *= a;
			}
			a *= a;
			b >>= 1;
		}
		return res;
	}
	protected static long intPow(long a, long b, final int m) {
		long res = 1;
		while(b > 0) {
			if(b % 2 == 1) {
				res *= a;
				res = mod(res, m);
			}
			a *= a;
			a = mod(a, m);
			b >>= 1;
		}
		return res;
	}
	protected static ArrayList<Long> div(final long n) {
		ArrayList<Long> d = new ArrayList<>();
		for(long i = 1; i * i <= n; ++i) {
			if(n % i == 0) {
				d.add(i);
				if(i * i != n) {
					d.add(n / i);
				}
			}
		}
		Collections.sort(d);
		return d;
	}
	protected static ArrayList<Long> primeFactor(long n) {
		ArrayList<Long> pf = new ArrayList<>();
		for(long i = 2; i * i <= n; ++i) {
			if(n % i != 0) continue;
			while(n % i == 0) {
				pf.add(i);
				n /= i;
			}
		}
		if(n != 1) pf.add(n);
		return pf;
	}
	protected static long binom(int a, final int b) {
		long res = 1;
		for(int i = 1; i <= b; ++i) {
			res *= a--;
			res /= i;
		}
		return res;
	}
	protected static boolean isInt(final double n){ long r = (long) Math.floor(n); return r == n; }
	protected static boolean isSqr(final long n){ return isInt(Math.sqrt(n)); }
	protected static boolean isPrime(final long n) {
		if(n == 1) return false;
		for(long i = 2; i * i <= n; ++i) {
			if(n % i == 0) return false;
		}
		return true;
	}
	protected static boolean nextPerm(ArrayList<Integer> a) {
		for(int i = a.size() - 1; i > 0; i--) {
			if(a.get(i - 1).compareTo(a.get(i)) < 0) {
				final int j = find(a.get(i - 1), a, i, a.size() - 1);
				Collections.swap(a, i - 1, j);
				Collections.sort(a.subList(i, a.size()));
				return true;
			}
		}
		return false;
	}
	private static <T extends Comparable<? super T>> int find(T dest, ArrayList<T> a, int s, int e) {
		if (s == e) return s;
		final int m = (s + e + 1) / 2;
		return a.get(m).compareTo(dest) <= 0 ? find(dest, a, s, m - 1):find(dest, a, m, e);
	}
	protected static boolean binarySearch(final int[] a, final int x) {
		return Arrays.binarySearch(a, x) >= 0;
	}
	protected static boolean binarySearch(final long[] a, final long x) {
		return Arrays.binarySearch(a, x) >= 0;
	}
	protected static int lowerBound(final List<Integer> a, final int x) {
		return ~Collections.binarySearch(a, x, (p, q) -> p.compareTo(q) >= 0 ? 1 : -1);
	}
	protected static int lowerBound(final List<Long> a, final long x) {
		return ~Collections.binarySearch(a, x, (p, q) -> p.compareTo(q) >= 0 ? 1 : -1);
	}
	protected static int upperBound(final List<Integer>a, final int x) {
		return ~Collections.binarySearch(a, x, (p, q) -> p.compareTo(q) > 0 ? 1 : -1);
	}
	protected static int upperBound(final List<Long> a, final long x) {
		return ~Collections.binarySearch(a, x, (p, q) -> p.compareTo(q) > 0 ? 1 : -1);
	}
	protected static int[] reverse(final int[] a) {
		final int n = a.length;
		int[] b = new int[n];
		for(int i = 0; i <= n / 2; ++i) {
			b[i] = a[n - 1 - i];
			b[n - 1 - i] = a[i];
		}
		return b;
	}
	protected static long[] reverse(final long[] a) {
		final int n = a.length;
		long[] b = new long[n];
		for(int i = 0; i <= n / 2; ++i) {
			b[i] = a[n - 1 - i];
			b[n - 1 - i] = a[i];
		}
		return b;
	}
	protected static double[] reverse(final double[] a) {
		final int n = a.length;
		double[] b = new double[n];
		for(int i = 0; i <= n / 2; ++i) {
			b[i] = a[n - 1 - i];
			b[n - 1 - i] = a[i];
		}
		return b;
	}
	protected static Object[] reverse(final Object[] a) {
		final int n = a.length;
		Object[] b = new Object[n];
		for(int i = 0; i <= n / 2; ++i) {
			b[i] = a[n - 1 - i];
			b[n - 1 - i] = a[i];
		}
		return b;
	}
	protected static int[] rotate(final int[] a, final int id) {
		ArrayList<Integer> t = new ArrayList<>(a.length);
		for(final var el: a) {
			t.add(el);
		}
		Collections.rotate(t, id);
		int[] res = new int[t.size()];
		for(int i = 0; i < t.size(); ++i) {
			res[i] = t.get(i);
		}
		return res;
	}
	protected static long[] rotate(final long[] a, final int id) {
		ArrayList<Long> t = new ArrayList<>(a.length);
		for(final var el: a) {
			t.add(el);
		}
		Collections.rotate(t, id);
		long[] res = new long[t.size()];
		for(int i = 0; i < t.size(); ++i) {
			res[i] = t.get(i);
		}
		return res;
	}
	protected static double[] rotate(final double[] a, final int id) {
		ArrayList<Double> t = new ArrayList<>(a.length);
		for(final var el: a) {
			t.add(el);
		}
		Collections.rotate(t, id);
		double[] res = new double[t.size()];
		for(int i = 0; i < t.size(); ++i) {
			res[i] = t.get(i);
		}
		return res;
	}
	protected static String rotate(final String s, final int id) {
		ArrayList<Character> t = new ArrayList<>();
		for(final char c: s.toCharArray()) {
			t.add(c);
		}
		Collections.rotate(t, id);
		StringBuilder sb = new StringBuilder();
		for(final var c: t) {
			sb.append(c);
		}
		return sb.toString(); 
	}
	protected static int[][] rotate(final int[][] a) {
		final int h = a.length, w = a[0].length;
		int[][] b = new int[w][h];
		IntStream.range(0, h).forEach(i -> {
			IntStream.range(0, w).forEach(j -> b[j][i] = a[i][j]);
		});
		IntStream.range(0, w).forEach(i -> b[i] = reverse(b[i]));
		return b;
	}
	protected static long[][] rotate(final long[][] a) {
		final int h = a.length, w = a[0].length;
		long[][] b = new long[w][h];
		IntStream.range(0, h).forEach(i -> {
			IntStream.range(0, w).forEach(j -> b[j][i] = a[i][j]);
		});
		IntStream.range(0, w).forEach(i -> b[i] = reverse(b[i]));
		return b;
	}
	protected static double[][] rotate(final double[][] a) {
		final int h = a.length, w = a[0].length;
		double[][] b = new double[w][h];
		IntStream.range(0, h).forEach(i -> {
			IntStream.range(0, w).forEach(j -> b[j][i] = a[i][j]);
		});
		IntStream.range(0, w).forEach(i -> b[i] = reverse(b[i]));
		return b;
	}
	protected static String[] rotate(final String[] s) {
		final int h = s.length, w = s[0].length();
		char[][] t = new char[w][h];
		IntStream.range(0, h).forEach(i -> {
			IntStream.range(0, w).forEach(j -> t[j][i] = s[i].charAt(j));
		});
		IntStream.range(0, w).forEach(i -> t[i] = new StringBuilder(new String(t[i])).reverse().toString().toCharArray());
		String[] res = new String[w];
		IntStream.range(0, w).forEach(i -> res[i] = new String(t[i]));
		return res;
	}
	protected static long lcm(final long a, final long b){ return a * b / gcd(a, b); }
	protected static long gcd(final long a, final long b){ return b > 0 ? gcd(b, a % b) : a; }
	protected static long lcm(final long... a){ return Arrays.stream(a).reduce(1, (x, y) -> lcm(x, y)); }
	protected static long gcd(final long... a){ return Arrays.stream(a).reduce(0, (x, y) -> gcd(x, y)); }
	protected static long min(final long... a){ return Arrays.stream(a).reduce(Long.MAX_VALUE, (x, y) -> Math.min(x, y)); }
	protected static long max(final long... a){ return Arrays.stream(a).reduce(Long.MIN_VALUE, (x, y) -> Math.max(x, y)); }
	protected static <F, S> ArrayList<F> first(final List<Pair<F, S>> p) {
		ArrayList<F> f = new ArrayList<>();
		for(final var el: p) {
			f.add(el.first);
		}
		return f;
	}
	protected static <F, S> ArrayList<S> second(final List<Pair<F, S>> p) {
		ArrayList<S> s = new ArrayList<>();
		for(final var el: p) {
			s.add(el.second);
		}
		return s;
	}
	protected static int[] iota(final int n){ return IntStream.range(0, n).toArray(); }
	protected static int[] iota(final int n, final int init){ return IntStream.range(0 + init, n + init).toArray(); }
	protected static long bins(long ok, long ng, final Predicate<Long> fn) {
		while(Math.abs(ok - ng) > 1) {
			final long mid = (ok + ng) / 2;
			if(fn.test(mid)) {
				ok = mid;
			}
			else {
				ng = mid;
			}
		}
		return ok;
	}
	protected static ArrayList<Integer> press(final ArrayList<Long> a) {
		ArrayList<Integer> res = new ArrayList<>();
		final var cp = a.stream().sorted().distinct().toList();
		for(final var el: a) {
			res.add(lowerBound(cp, el));
		}
		return res;
	}
}

class MyScanner {
	private Scanner sc = new Scanner(System.in);
	int ni(){ return sc.nextInt(); }
	long nl(){ return sc.nextLong(); }
	double nd(){ return sc.nextDouble(); }
	String ns(){ return sc.next(); }
	int[] ni(final int n){
		int[] a = new int[n];
		IntStream.range(0, n).forEach(i -> a[i] = ni());
		return a;
	}
	long[] nl(final int n){
		long[] a = new long[n];
		IntStream.range(0, n).forEach(i -> a[i] = nl());
		return a;
	}
	double[] nd(final int n){
		double[] a = new double[n];
		IntStream.range(0, n).forEach(i -> a[i] = nd());
		return a;
	}
	String[] ns(final int n){
		String[] a = new String[n];
		IntStream.range(0, n).forEach(i -> a[i] = ns());
		return a;
	}
	ArrayList<Integer> nia(final int n) {
		var a = new ArrayList<Integer>(n);
		IntStream.range(0, n).forEach(i -> a.add(i, ni()));
		return a;
	}
	ArrayList<Long> nla(final int n) {
		var a = new ArrayList<Long>(n);
		IntStream.range(0, n).forEach(i -> a.add(i, nl()));
		return a;
	}
	ArrayList<Double> nda(final int n) {
		var a = new ArrayList<Double>(n);
		IntStream.range(0, n).forEach(i -> a.add(i, nd()));
		return a;
	}
	ArrayList<String> nsa(final int n) {
		var a = new ArrayList<String>(n);
		IntStream.range(0, n).forEach(i -> a.add(i, ns()));
		return a;
	}
	void close(){ sc.close(); }
}

class MyPrinter {
	private PrintWriter pw;
	MyPrinter(final OutputStream os, final boolean flush){ pw = new PrintWriter(os, flush); }
	void print(final Object arg){ pw.print(arg); }
	void out(){ pw.println(); }
	void out(final Object head, final Object... tail) {
		pw.print(head);
		for(final var el: tail) {
			pw.print(" " + el);
		}
		out();
	}
	<F, S> void out(final Pair<F, S> arg){ pw.println(arg.first + " " + arg.second); }
	void out(final int[] args){ IntStream.range(0, args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	void out(final long[] args){ IntStream.range(0, args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	void out(final double[] args){ IntStream.range(0, args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	void out(final char[] args){ IntStream.range(0, args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	void out(final Object[] args){ IntStream.range(0, args.length).forEach(i -> pw.print(args[i] + (i + 1 < args.length ? " " : "\n"))); }
	<T> void out(final List<T> args){ IntStream.range(0, args.size()).forEach(i -> pw.print(args.get(i) + (i + 1 < args.size() ? " " : "\n"))); }
	void outl(final Object head, final Object... tail) {
		out(head);
		Arrays.stream(tail).forEach(pw::println);
	}
	void outl(final int[] args){ Arrays.stream(args).forEach(pw::println); }
	void outl(final int[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	void outl(final long[] args){ Arrays.stream(args).forEach(pw::println); }
	void outl(final long[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	void outl(final double[] args){ Arrays.stream(args).forEach(pw::println); }
	void outl(final double[][] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	void outl(final char[] args){ IntStream.range(0, args.length).forEach(i -> out(args[i])); }
	void outl(final Object[] args){ Arrays.stream(args).forEach(pw::println); }
	<E> void outl(final Collection<E> args){ args.stream().forEach(pw::println); }
	void fin(final Object head, final Object... tail) {
		out(head, tail);
		flush();
		System.exit(0);
	}
	<T> void fin(final List<T> args) {
		out(args);
		flush();
		System.exit(0);
	}
	<E> void fine(final Collection<E> args) {
		outl(args);
		flush();
		System.exit(0);
	}
	void flush(){ pw.flush(); }
	void close(){ pw.close(); }
}

class Pair<F, S> {
	protected final F first;
	protected final S second;
	Pair(final F first, final S second) {
		this.first = first;
		this.second = second;
	}
	@Override
	public boolean equals(final Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || getClass() != o.getClass()) {
			return false;
		}
		final Pair<?, ?> p = (Pair<?, ?>) o;
		if(!first.equals(p.first)) {
			return false;
		}
		return second.equals(p.second);
	}
	@Override
	public int hashCode(){ return 31 * first.hashCode() + second.hashCode(); }
	@Override
	public String toString(){ return "(" + first + ", " + second + ")"; }
	public static <F, S> Pair<F, S> of(final F a, final S b){ return new Pair<>(a, b); }
	Pair<S, F> swap(){ return Pair.of(second, first); }
}

class NumPair extends Pair<Number, Number> {
	NumPair(final Number first, final Number second){ super(first, second); }
	NumPair rotate(){ return new NumPair(-second.doubleValue(), first.doubleValue()); } 
	NumPair rotate(final int ang) {
		final double rad = Math.toRadians(MyFunction.mod(ang, 360));
		return new NumPair(first.doubleValue() * Math.cos(rad) - second.doubleValue() * Math.sin(rad),
							first.doubleValue() * Math.sin(rad) + second.doubleValue() * Math.cos(rad));
	}
	long dot(final NumPair p){ return first.longValue() * p.first.longValue() + second.longValue() + p.second.longValue(); }
	long cross(final NumPair p){ return this.rotate().dot(p); }
	long square(){ return this.dot(this); }
	double grad() { 
		try {
			return second.doubleValue() / first.doubleValue();
		} catch(ArithmeticException e) {
			e.printStackTrace();
			return Double.NaN;
		}
	}
	double abs(){ return Math.hypot(first.doubleValue(), second.doubleValue()); }
	double lcm(){ return MyFunction.lcm(first.longValue(), second.longValue()); }
	double gcd(){ return MyFunction.gcd(first.longValue(), second.longValue()); }
	NumPair extgcd() {
		long x = 1, y = 0, t1 = 0, t2 = 0, t3 = 1, a = first.longValue(), b = second.longValue();
		while(b > 0) {
			t1=a / b;
			a -= t1 * b;
			a ^= b;
			b ^= a;
			a ^= b;
			x -= t1 * t2;
			x ^= t2;
			t2 ^= x;
			x ^= t2;
			y -= t1 * t3;
			y ^= t3;
			t3 ^= y;
			y ^= t3;
		}
		return new NumPair(x, y);
	}
}

class UnionFind {
	private int[] par;
	UnionFind(final int n) {
		par = new int[n];
		Arrays.fill(par, -1);
	}
	int root(final int i){ return par[i] >= 0 ? par[i] = root(par[i]) : i; }
	int size(final int i){ return -par[root(i)]; }
	boolean unite(int i, int j) {
		i = root(i);
		j = root(j);
		if(i == j) return false;
		if(i > j) {
			i ^= j;
			j ^= i;
			i ^= j;
		}
		par[i] += par[j];
		par[j] = i;
		return true;
	}
	boolean same(final int i, final int j){ return root(i) == root(j); }
	ArrayList<ArrayList<Integer>> groups() {
		final int n = par.length;
		ArrayList<ArrayList<Integer>> res = new ArrayList<>(n);
		IntStream.range(0, n).forEach(i -> res.add(new ArrayList<>()));
		IntStream.range(0, n).forEach(i -> res.get(root(i)).add(i));
		res.removeIf(ArrayList::isEmpty);
		return res;
	}
	boolean is_bipartite() {
		final int n = par.length / 2;
		boolean ok = true;
		for(int i = 0; i < n; ++i) {
			ok &= root(i) != root(i + n);
		}
		return ok;
	}
}

class Edge {
	public int src;
	public int to;
	public long cost;
	Edge(final int to) {
		this.to = to;
	}
	Edge(final int to, final long cost) {
		this.to = to;
		this.cost = cost;
	}
	Edge(final int src, final int to, final long cost) {
		this.src = src;
		this.to = to;
		this.cost = cost;
	}
}
class Graph {
	protected boolean undirected;
	protected int n, indexed;
	ArrayList<ArrayList<Edge>> g;
	Graph(final int n, final int indexed, final boolean undirected) {
		this.n = n;
		this.indexed = indexed;
		this.undirected = undirected;
		g = new ArrayList<>(n);
		IntStream.range(0, n).forEach(i -> g.add(new ArrayList<>()));
	}
	void add(int a, int b, final long cost) {
		a -= indexed;
		b -= indexed;
		g.get(a).add(new Edge(b));
		if(undirected) {
			g.get(b).add(new Edge(a));
		}
	}
	protected int[] allDist(final int v) {
		int[] d = new int[n];
		Arrays.fill(d, -1);
		Queue<Integer> q = new ArrayDeque<>();
		d[v] = 0;
		q.add(v);
		while(!q.isEmpty()) {
			final int tmp = q.poll();
			for(final var el: g.get(tmp)) {
				if(d[el.to] != -1) {
					continue;
				}
				d[el.to]=d[tmp]+1;
				q.add(el.to);
			}
		}
		return d;
	}
	protected int dist(final int u, final int v){ return allDist(u)[v]; }
}
class WeightedGraph extends Graph {
	ArrayList<ArrayList<Edge>> g;
	WeightedGraph(final int n, final int indexed, final boolean undirected) {
		super(n, indexed, undirected);
		g = new ArrayList<>(n);
		IntStream.range(0, n).forEach(i -> g.add(new ArrayList<>()));
	}
	void add(int a, int b, final long cost) {
		a -= indexed;
		b -= indexed;
		g.get(a).add(new Edge(b, cost));
		if(undirected) {
			g.get(b).add(new Edge(a, cost));
		}
	}
	long[] dijkstra(final int v) {
		long[] cost = new long[n];
		Arrays.fill(cost, Long.MAX_VALUE);
		Queue<NumPair> dj = new PriorityQueue<>(Collections.reverseOrder());
		cost[v] = 0;
		dj.add(new NumPair(cost[v], v));
		while(!dj.isEmpty()) {
			final var tmp = dj.poll();
			if(cost[tmp.second.intValue()] < tmp.first.longValue()) {
				continue;
			}
			for(final var el: g.get(tmp.second.intValue())) {
				if(cost[el.to] > tmp.first.longValue() + el.cost) {
					cost[el.to] = tmp.first.longValue() + el.cost;
					dj.add(new NumPair(cost[el.to], el.to));
				}
			}
		}
		return cost;
	}
	long[][] warshallFloyd() {
		long[][] cost = new long[n][n];
		IntStream.range(0, n).forEach(i -> Arrays.fill(cost[i], Long.MAX_VALUE));
		IntStream.range(0, n).forEach(i -> cost[i][i] = 0);
		for(int i = 0; i < n; ++i) {
			for(final var j: g.get(i)) {
				cost[i][j.to] = j.cost;
			}
		}
		for(int k = 0 ; k < n; ++k) {
			for(int i = 0; i < n; ++i) {
				for(int j = 0; j < n; ++j) {
					if(cost[i][j] > cost[i][k] + cost[k][j]) {
						cost[i][j] = cost[i][k] + cost[k][j];
					}
				}
			}
		}
		return cost;
	}
}
class Tree {
	public ArrayList<Edge> edge;
	private int n, indexed;
	Tree(final int n, final int indexed) {
		edge = new ArrayList<>(n);
		this.n = n;
		this.indexed = indexed;
	}
	void add(final Edge e){ edge.add(new Edge(e.src - indexed, e.to - indexed, e.cost)); }
	long kruskal() {
		Collections.sort(edge, Comparator.comparing(e -> e.cost));
		UnionFind uf = new UnionFind(n);
		long res = 0;
		for(final var ed: edge) {
			if(uf.unite(ed.src, ed.to)) {
				res += ed.cost;
			}
		}
		return res;
	}
}

class PrimeTable {
	private int n;
	boolean[] sieve;
	PrimeTable(final int n) {
		this.n = n;
		sieve = new boolean[n + 1];
		Arrays.fill(sieve, true);
		for(long i = 2; i <= n; ++i) {
			if(!sieve[(int) i]) {
				continue;
			}
			for(long j = i * i; j <= n; j += i) {
				sieve[(int) j] = false;
			}
		}
	}
	ArrayList<Integer> get() {
		ArrayList<Integer> p = new ArrayList<>();;
		for(int i = 2; i <= n; ++i) {
			if(sieve[i]) {
				p.add(i);
			}
		}
		return p;
	}
}

class PrimeFactor {
	private int[] spf;
	PrimeFactor(final int n) {
		spf = IntStream.rangeClosed(0, n).toArray();
		for(int i = 2; i * i <= n; ++i) {
			if(spf[i] == i) {
				for(int j = i * i; j <= n; j += i) {
					if(spf[j] == j) {
						spf[j] = i;
					}
				}
			}
		}
	}
	TreeMap<Integer, Integer> get(int n) {
		TreeMap<Integer, Integer> m = new TreeMap<>();
		while(n != 1) {
			m.merge(spf[n], 1, (a, b) -> (a + b));
			n /= spf[n];
		}
		return m;
	}
}

class BigPrime {
	private int bsf(final long x){ return Long.numberOfTrailingZeros(x); }
	private long gcd(long a, long b) {
		a = Math.abs(a);
		b = Math.abs(b);
		if(a == 0) {
			return b;
		}
		if(b == 0) {
			return a;
		}
		final int shift = bsf(a|b);
		a >>= bsf(a);
		do {
			b >>= bsf(b);
			if(a > b) {
				a ^= b;
				b ^= a;
				a ^= b;
			}
			b -= a;
		} while(b > 0);
		return a << shift;
	}
	boolean isPrime(final long n) {
		if(n <= 1) {
			return false;
		}
		if(n == 2) {
			return true;
		}
		if(n % 2 == 0) {
			return false;
		}
		long d = n - 1;
		while(d % 2 == 0) {
			d /= 2;
		}
		final long[] sample = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
		for(final long a: sample) {
			if(n <= a) {
				break;
			}
			long t = d;
			BigInteger y = BigInteger.valueOf(a).modPow(BigInteger.valueOf(t), BigInteger.valueOf(n));
			while(t != n - 1 && !y.equals(BigInteger.ONE) && !y.equals(BigInteger.valueOf(n).subtract(BigInteger.ONE))) {
				y = y.multiply(y).mod(BigInteger.valueOf(n));
				t <<= 1;
			}
			if(!y.equals(BigInteger.valueOf(n).subtract(BigInteger.ONE)) && t % 2 == 0) {
				return false;
			}
		}
		return true;
	}
	private long find(final long n) {
		if(isPrime(n)) {
			return n;
		}
		if(n % 2 == 0) {
			return 2;
		}
		int st = 0;
		final BiFunction<Long, Integer, Long> f = (x, y) -> { return BigInteger.valueOf(x).multiply(BigInteger.valueOf(x)).add(BigInteger.valueOf(y)).mod(BigInteger.valueOf(n)).longValue(); };
		while(true) {
			st++;
			long x = st, y = f.apply(x, st);
			while(true) {
				final long p = gcd(y - x + n, n);
				if(p == 0 || p == n) {
					break;
				}
				if(p != 1) {
					return p;
				}
				x = f.apply(x, st);
				y = f.apply(f.apply(y, st), st);
			}
		}
	}
	ArrayList<Long> primeFactor(final long n) {
		if(n == 1) return new ArrayList<>();
		final long x = find(n);
		if(x == n) return new ArrayList<>(Arrays.asList(x));
		ArrayList<Long> le = primeFactor(x);
		final ArrayList<Long> ri = primeFactor(n / x);
		le.addAll(ri);
		return le;
	}
}

class FenwickTree {
	private int n;
	private long[] data;
	FenwickTree(final int n) {
		this.n = n + 2;
		data = new long[n + 1];
	}
	long sum(int k) {
		if(k < 0) return 0;
		long ret = 0;
		for(++k; k > 0; k -= k & -k) {
			ret += data[k];
		}
		return ret;
	}
	long sum(final int l, final int r){ return sum(r) - sum(l - 1); }
	long get(final int k){ return sum(k) - sum(k - 1); }
	void add(int k, final long x) {
		for(++k; k < n; k += k & -k) {
			data[k] += x;
		}
	}
	void imos(final int l, final int r, long x) {
		add(l, x);
		add(r + 1, -x);
	}
	private int lg(final int n){ return 63 - Integer.numberOfLeadingZeros(n); }
	int lowerBound(long w) {
		if(w <= 0) {
			return 0;
		}
		int x = 0;
		for(int k = 1 << lg(n); k > 0; k >>= 1) {
			if(x + k <= n - 1 && data[x + k] < w) {
				w -= data[x + k];
				x += k;
			}
		}
		return x;
	}
	int upper_bound(long w) {
		if(w < 0) {
			return 0;
		}
		int x = 0;
		for(int k = 1 << lg(n); k > 0; k >>= 1) {
			if(x + k <= n - 1 && data[x + k] <= w) {
				w -= data[x + k];
				x += k;
			}
		}
		return x;
	}
}

class SegmentTree {
	private int n = 1, rank = 0, fini;
	final BinaryOperator<Long> op;
	final long e;
	private long[] dat;
	SegmentTree(final int fini, final BinaryOperator<Long> op, final long e) {
		this.fini = fini;
		this.op = op;
		this.e = e;
		while(this.fini > n) {
			n <<= 1;
			rank++;
		}
		dat = new long[2 * n];
		Arrays.fill(dat, e);
	}
	void update(int i, final long x) {
		i += n;
		dat[i] = x;
		i >>= 1;
		while(i > 0) {
			dat[i] = op.apply(dat[2 * i], dat[2 * i + 1]);
		}
	}
	void add(int i, final long x) {
		i += n;
		dat[i] += x;
		i >>= 1;
		while(i > 0) {
			dat[i] = op.apply(dat[2 * i], dat[2 * i + 1]);
		}
	}
	long query(int a, int b) {
		long l=e,r=e;
		for(a += n, b += n; a < b; a >>= 1, b >>= 1) {
			if(a % 2 == 1) {
				l = op.apply(l, dat[a++]);
			}
			if(b % 2 == 1) {
				r = op.apply(dat[--b], r);
			}
		}
		return op.apply(l,r);
	}
	int findLeft(int r, final Predicate<Long> fn) {
		if(r == 0) {
			return 0;
		}
		int h = 0, i = r + n;
		long val = e;
		for(; h <= rank; h++) {
			if(i >> (h & 1) > 0) {
				final long val2 = op.apply(val, dat[i >> (h ^ 1)]);
				if(fn.test(val2)){
					i -= 1 << h;
					if(i == n) {
						return 0;
					}
					val = val2;
				}
				else {
					break;
				}
			}
		}
		for(; h-- > 0;) {
			long val2 = op.apply(val, dat[(i >> h) - 1]);
			if(fn.test(val2)){
				i -= 1 << h;
				if(i == n) {
					return 0;
				}
				val = val2;
			}
		}
		return i - n;
	}
	int findRight(int l, final Predicate<Long> fn) {
		if(l == fini) {
			return fini;
		}
		int h = 0, i = l + n;
		long val = e;
		for(; h <= rank; h++) {
			if(i >> (h & 1) > 0){
				long val2 = op.apply(val, dat[i >> h]);
				if(fn.test(val2)){
					i += 1 << h;
					if(i == n * 2) {
						return fini;
					}
					val = val2;
				}
				else {
					break;
				}
			}
		}
		for(; h-- > 0;) {
			long val2 = op.apply(val, dat[i>>h]);
			if(fn.test(val2)) {
				i += 1 << h;
				if(i == n * 2) {
					return fini;
				}
				val = val2;
			}
		}
		return Math.min(i - n, fini);
	}
}

class SparseTable {
	private long[][] st;
	private int[] lookup;
	private BinaryOperator<Long> op;
	SparseTable(final long[] a, final BinaryOperator<Long> op) {
		this.op = op;
		int b = 0;
		while((1 << b) <= a.length) {
			++b;
		}
		st = new long[b][1 << b];
		for(int i = 0; i < a.length; i++) {
			st[0][i] = a[i];
		}
		for(int i = 1; i < b; i++) {
			for(int j = 0; j + (1 << i) <= (1 << b); j++) {
				st[i][j] = op.apply(st[i - 1][j], st[i - 1][j + (1 << (i - 1))]);
			}
		}
		lookup = new int[a.length + 1];
		for(int i = 2; i < lookup.length; i++) {
			lookup[i] = lookup[i >> 1] + 1;
		}
	}
	long query(final int l, final int r) {
		final int b = lookup[r - l];
		return op.apply(st[b][l], st[b][r - (1 << b)]);
	}
	int minLeft(final int x, final Predicate<Long> fn) {
		if(x == 0) {
			return 0;
		}
		int ok = x, ng = -1;
		while(Math.abs(ok - ng) > 1) {
			final int mid = (ok + ng) / 2;
			if(fn.test(query(mid, x) - 1)) {
				ok = mid;
			}
			else {
				ng = mid;
			}
		}
		return ok;
	}
	int maxRight(final int x, final Predicate<Long> fn) {
		if(x == lookup.length - 1) {
			return lookup.length - 1;
		}
		int ok = x, ng = lookup.length;
		while(Math.abs(ok - ng) > 1) {
			int mid = (ok + ng) / 2;
			if(fn.test(query(x, mid))) {
				ok = mid;
			}
			else {
				ng = mid;
			}
		}
		return ok;
	}
}