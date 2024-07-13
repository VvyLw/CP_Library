package library.graph;

import static java.lang.Math.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import library.core.VvyLw;
import library.core.interfaces.lambda.RecursiveIntPredicate;
import library.ds.pair.IntPair;
import library.ds.unionfind.UnionFind;
import library.other.SkewHeap;

/**
 * グラフクラス
 */
public class Graph extends ArrayList<ArrayList<Edge>> {
	private final boolean undirected, weighted;
	private final int n, indexed;
	private int id;
	private final ArrayList<Edge> edge;
	private final int[] to;
	private final ArrayList<Edge> path;
	/**
	 * コンストラクタ
	 * @param n 頂点の個数
	 * @param indexed ?-indexed
	 * 0-indexedなら0, 1-indexedなら1
	 * @param undirected 無向グラフかどうか
	 * 無向グラフならtrue, 有向グラフならfalse
	 * @param weighted 重みつきかどうか
	 * 重みつきならtrue, 重みなしならfalse
	 */
	public Graph(final int n, final int indexed, final boolean undirected, final boolean weighted) {
		this.n = n;
		this.indexed = indexed;
		this.undirected = undirected;
		this.weighted = weighted;
		id = 0;
		edge = new ArrayList<>();
		IntStream.range(0, n).forEach(i -> add(new ArrayList<>()));
		to = new int[n];
		Arrays.fill(to, -1);
		path = new ArrayList<>();
	}
	/**
	 * グラフ化する
	 * @param g
	 * @param undirected
	 * @param weighted
	 * @return List<ArrayList<Edge>>をWeightedGraph化したもの
	 * @apiNote streamでGraphに操作を加えた後に再度グラフに直すときに使えるかも
	 */
	public static Graph of(final List<ArrayList<Edge>> g, final boolean undirected, final boolean weighted) {
		int max = 0, min = Integer.MAX_VALUE;
		for(int i = 0; i < g.size(); ++i) {
			for(final Edge e: g.get(i)) {
				max = max(e.src, e.to);
				min = min(e.src, e.to);
			}
		}
		final Graph gp = new Graph(max, min, undirected, weighted);
		for(int i = 0; i < g.size(); ++i) {
			for(final Edge e: g.get(i)) {
				if(weighted) {
					gp.addEdge(e.src, e.to, e.cost);
				} else {
					gp.addEdge(e.src, e.to);
				}
			}
		}
		return gp;
	}
	/**
	 * 辺を追加する
	 * @param a
	 * @param b
	 */
	public final void addEdge(int a, int b){ addEdge(a, b, 1); }
	/**
	 * 重みつきの辺を追加する
	 * @param a
	 * @param b
	 * @param cost
	 */
	public final void addEdge(int a, int b, final long cost) {
		a -= indexed;
		b -= indexed;
		this.get(a).add(new Edge(a, b, cost, id));
		edge.add(new Edge(a, b, cost, id));
		if(undirected) {
			this.get(b).add(new Edge(b, a, cost, id));
			edge.add(new Edge(b, a, cost, id));
		}
		id++;
	}
	/**
	 * 辺をm個入力する
	 * @param m 辺の個数
	 */
	public final void input(final int m) {
		IntStream.range(0, m).forEach(i -> {
			if(weighted) {
				addEdge(VvyLw.io.ni(), VvyLw.io.ni(), VvyLw.io.nl());
			} else {
				addEdge(VvyLw.io.ni(), VvyLw.io.ni());
			}
		});
	}
	/**
	 * 辺の配列を返す
	 * @return 辺の配列
	 */
	public final Edge[] getEdge(){ return edge.toArray(Edge[]::new); }
	/**
	 * グラフを二次元配列にして返す
	 * @return 二次元配列にしたグラフ
	 */
	@Override
	public final int[][] toArray() {
		final int[][] res = new int[n][];
		IntStream.range(0, n).forEach(i -> res[i] = get(i).stream().mapToInt(e -> e.to).toArray());
		return res;
	}
	/**
	 * BFSをして頂点vから各頂点に対する距離を求める
	 * @param v
	 */
	public final int[] allDist(final int v) {
		final int[] d = new int[n];
		Arrays.fill(d, -1);
		final Queue<Integer> q = new ArrayDeque<>();
		d[v] = 0;
		q.add(v);
		while(!q.isEmpty()) {
			final int tmp = q.poll();
			for(final Edge el: this.get(tmp)) {
				if(d[el.to] != -1) {
					continue;
				}
				d[el.to] = d[tmp] + 1;
				q.add(el.to);
			}
		}
		return d;
	}
	/**
	 * 頂点uと頂点vとの距離
	 * @param u
	 * @param v
	 * @return 頂点uと頂点vとの距離
	 */
	public final int dist(final int u, final int v){ return allDist(u)[v]; }
	/**
	 * トポロジカルソート
	 */
	public final ArrayList<Integer> topologicalSort() {
		final int[] deg = new int[n];
		for(int i = 0; i < n; ++i) {
			for(final Edge ed: this.get(i)) {
				deg[ed.to]++;
			}
		}
		final Stack<Integer> sk = new Stack<>();
		for(int i = 0; i < n; ++i) {
			if(deg[i] == 0) {
				sk.add(i);
			}
		}
		final ArrayList<Integer> ord = new ArrayList<>();
		while(!sk.isEmpty()) {
			final int tmp = sk.pop();
			ord.add(tmp);
			for(final Edge ed: this.get(tmp)) {
				if(--deg[ed.to] == 0) {
					sk.add(ed.to);
				}
			}
		}
		return ord.size() == n ? ord : null;
	}
	/**
	 * サイクル検出
	 * @return サイクル
	 * if non-existence: 空配列
	 * @apiNote 有向グラフ
	 */
	public final int[] cycleDetector() {
		final int[] used = new int[n];
		final Edge[] pre = new Edge[n];
		final ArrayList<Edge> cycle = new ArrayList<>();
		final RecursiveIntPredicate dfs = (rec, i) -> {
			used[i] = 1;
			for(final Edge e: get(i)) {
				if(used[e.to] == 0) {
					pre[e.to] = e;
					if(rec.test(rec, e.to)) {
						return true;
					}
				} else if(used[e.to] == 1) {
					int now = i;
					while(now != e.to) {
						cycle.add(pre[now]);
						now = pre[now].src;
					}
					cycle.add(e);
					return true;
				}
			}
			used[i] = 2;
			return false;
		};
		for(int i = 0; i < n; ++i) {
			if(used[i] == 0 && dfs.test(dfs, i)) {
				Collections.reverse(cycle);
				return cycle.stream().mapToInt(e -> e.to).toArray();
			}
		}
		return null;
	}
	private final IntPair dfs(final int i, final int par) {
		IntPair ret = IntPair.of(0, i);
		for(final Edge e: this.get(i)) {
			if(e.to == par) {
				continue;
			}
			final IntPair cost = dfs(e.to, i);
			cost.first += e.cost;
			if(ret.compareTo(cost) < 0) {
				ret = cost;
				to[i] = e.to;
			}
		}
		return ret;
	}
	/**
	 * path(直径を構成する辺)を構築する
	 * @return 木の直径
	 */
	public final long diameter() {
		final IntPair p = dfs(0, -1);
		final IntPair q = dfs(p.second.intValue(), -1);
		int now = p.second.intValue();
		while(now != q.second) {
			for(final Edge e: this.get(now)) {
				if(to[now] == e.to) {
					path.add(e);
				}
			}
			now = to[now];
		}
		return q.first;
	}
	/**
	 * pathを返す
	 * @return 直径を構成する辺
	 */
	public final Edge[] getPath(){ return path.toArray(Edge[]::new); }
	/**
	 * Dijkstra法
	 * 負辺のないグラフで単一始点全点間最短路を求める
	 * @param v
	 */
	public final ShortestPath dijkstra(final int v) {
		final long[] cost = new long[n];
		final int[] src = new int[n];
		Arrays.fill(cost, Long.MAX_VALUE);
		Arrays.fill(src, -1);
		final Queue<IntPair> dj = new PriorityQueue<>();
		cost[v] = 0;
		dj.add(IntPair.of(cost[v], v));
		while(!dj.isEmpty()) {
			final IntPair tmp = dj.poll();
			if(cost[tmp.second.intValue()] < tmp.first.longValue()) {
				continue;
			}
			for(final Edge ed: this.get(tmp.second.intValue())) {
				final long next = tmp.first.longValue() + ed.cost;
				if(cost[ed.to] <= next) {
					continue;
				}
				cost[ed.to] = next;
				src[ed.to] = tmp.second.intValue();
				dj.add(IntPair.of(cost[ed.to], ed.to));
			}
		}
		return new ShortestPath(cost, src);
	}
	/**
	 * Shortest Path Faster Algorithm
	 * 負辺が存在していても単一始点全点間最短路を求められる
	 * 負閉路も検出する
	 * @param v
	 */
	public final long[] spfa(final int v) {
		final long[] cost = new long[n];
		Arrays.fill(cost, Long.MAX_VALUE);
		final boolean[] pend = new boolean[n];
		final int[] cnt = new int[n];
		final Queue<Integer> q = new ArrayDeque<>();
		q.add(v);
		pend[v] = true;
		cnt[v]++;
		cost[v] = 0;
		while(!q.isEmpty()) {
			final int p = q.poll();
			pend[p] = false;
			for(final Edge e: this.get(p)) {
				final long next = cost[p] + e.cost;
				if(next >= cost[e.to]) {
					continue;
				}
				cost[e.to] = next;
				if(!pend[e.to]) {
					if(++cnt[e.to] >= n) {
						return null;
					}
					pend[e.to] = true;
					q.add(e.to);
				}
			}
		}
		return cost;
	}
	/**
	 * Floyd-Warshall法
	 * 全点対間最短路を求める
	 */
	public final long[][] floydWarshall() {
		final long[][] cost = new long[n][n];
		IntStream.range(0, n).forEach(i -> Arrays.fill(cost[i], VvyLw.LINF));
		IntStream.range(0, n).forEach(i -> cost[i][i] = 0);
		for(int i = 0; i < n; ++i) {
			for(final Edge j: this.get(i)) {
				cost[i][j.to] = j.cost;
			}
		}
		for(int k = 0; k < n; ++k) {
			for(int i = 0; i < n; ++i) {
				for(int j = 0; j < n; ++j) {
					if(cost[i][k] == VvyLw.LINF || cost[k][j] == VvyLw.LINF) {
						continue;
					}
					if(cost[i][j] > cost[i][k] + cost[k][j]) {
						cost[i][j] = cost[i][k] + cost[k][j];
					}
				}
			}
		}
		return cost;
	}
	/**
	 * Kruskal法によって最小全域木を求める
	 */
	public final MST kruskal() {
		final UnionFind uf = new UnionFind(n);
		final ArrayList<Edge> e = new ArrayList<>();
		long res = 0;
		for(final Edge ed: edge.stream().sorted(Comparator.comparing(ed -> ed.cost)).collect(Collectors.toList())) {
			if(uf.unite(ed.src, ed.to)) {
				e.add(ed);
				res += ed.cost;
			}
		}
		return new MST(e, res);
	}
	/**
	 * 最小有向全域木を求める
	 * @param v
	 * @see <a href="https://ei1333.github.io/library/graph/mst/directed-mst.hpp">参考元</a>
	 */
	public final MST directed(final int v) {
		@SuppressWarnings("unchecked")
		final ArrayList<Edge> ed = (ArrayList<Edge>) edge.clone();
		for(int i = 0; i < n; ++i) {
			if(i != v) {
				ed.add(new Edge(i, v, 1, 0));
			}
		}
		int x = 0;
		final int[] par = new int[2 * n], vis = new int[2 * n], link = new int[2 * n];
		Arrays.fill(par, -1);
		Arrays.fill(vis, -1);
		Arrays.fill(link, -1);
		final SkewHeap heap = new SkewHeap(true);
		final SkewHeap.Node[] ins = new SkewHeap.Node[2 * n];
		Arrays.fill(ins, null);
		for(int i = 0; i < ed.size(); i++) {
			final Edge e = ed.get(i);
			ins[e.to] = heap.push(ins[e.to], e.cost, i);
		}
		final ArrayList<Integer> st = new ArrayList<>();
		final IntUnaryOperator go = z -> {
			z = ed.get(ins[z].idx).src;
			while(link[z] != -1) {
				st.add(z);
				z = link[z];
			}
			for(final int p: st) {
				link[p] = z;
			}
			st.clear();
			return z;
		};
		for(int i = n; ins[x] != null; ++i) {
			while(vis[x] == -1) {
				vis[x] = 0;
				x = go.applyAsInt(x);
			}
			while(x != i) {
				final long w = ins[x].key;
				SkewHeap.Node z = heap.pop(ins[x]);
				z = heap.add(z, -w);
				ins[i] = heap.meld(ins[i], z);
				par[x] = i;
				link[x] = i;
				x = go.applyAsInt(x);
			}
			while(ins[x] != null && go.applyAsInt(x) == x) {
				ins[x] = heap.pop(ins[x]);
			}
		}
		for(int i = v; i != -1; i = par[i]) {
			vis[i] = 1;
		}
		long cost = 0;
		final ArrayList<Edge> e = new ArrayList<>();
		for(int i = x; i >= 0; i--) {
			if(vis[i] == 1) {
				continue;
			}
			cost += ed.get(ins[i].idx).cost;
			e.add(ed.get(ins[i].idx));
			for(int j = ed.get(ins[i].idx).to; j != -1 && vis[j] == 0; j = par[j]) {
				vis[j] = 1;
			}
		}
		return new MST(e, cost);
	}
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; ++i) {
			final int m = get(i).size();
			sb.append(i + ": [");
			for(int j = 0; j < m; ++j) {
				if(weighted) {
					sb.append("(to: " + get(i).get(j).to + ", cost: " + get(i).get(j).cost + ')');
				} else {
					sb.append(get(i).get(j).to);
				}
				if(j + 1 < m) {
					sb.append(", ");
				}
			}
			sb.append(']');
			if(i + 1 < n) {
				sb.append('\n');
			}
		}
		return sb.toString();
	}
}