package library.graph;

import static java.lang.Math.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import library.core.VvyLw;
import library.ds.pair.IntPair;
import library.ds.unionfind.UnionFind;
import library.other.SkewHeap;

/**
 * 重みつきグラフクラス
 */
public final class WeightedGraph extends Graph {
	/**
	 * コンストラクタ
	 * グラフクラスから継承
	 * @param n
	 * @param undirected
	 */
	public WeightedGraph(final int n, final boolean undirected){ super(n, 1, undirected); }
	/**
	 * コンストラクタ
	 * グラフクラスから継承
	 * @param n
	 * @param indexed
	 * @param undirected
	 */
	public WeightedGraph(final int n, final int indexed, final boolean undirected){ super(n, indexed, undirected); }
	/**
	 * グラフ化する
	 * @param g
	 * @param undirected
	 * @return List<ArrayList<Edge>>をWeightedGraph化したもの
	 */
	public static final WeightedGraph of(final List<ArrayList<Edge>> g, final boolean undirected) {
		int max = 0, min = Integer.MAX_VALUE;
		for(int i = 0; i < g.size(); ++i) {
			for(final Edge e: g.get(i)) {
				max = max(e.src, e.to);
				min = min(e.src, e.to);
			}
		}
		final WeightedGraph gp = new WeightedGraph(max, min, undirected);
		for(int i = 0; i < g.size(); ++i) {
			for(final Edge e: g.get(i)) {
				gp.addEdge(e.src, e.to, e.cost);
			}
		}
		return gp;
	}
	/**
	 * 辺を追加する
	 * @param a
	 * @param b
	 * @param cost
	 */
	public final void addEdge(int a, int b, final long cost) {
		a -= indexed;
		b -= indexed;
		this.get(a).add(new Edge(a, b, cost, id));
		edge.add(new Edge(a, b, cost, id++));
		if(undirected) {
			this.get(b).add(new Edge(b, a, cost, --id));
			edge.add(new Edge(b, a, cost, id++));
		}
	}
	/**
	 * 辺をm個入力する
	 * @param m
	 */
	@Override
	public final void input(final int m){ IntStream.range(0, m).forEach(i -> addEdge(VvyLw.io.ni(), VvyLw.io.ni(), VvyLw.io.nl())); }
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
				ed.add(new Edge(i, v, 0));
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
	public final String toString() {
		final StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; ++i) {
			final int m = get(i).size();
			sb.append(i + ": [");
			for(int j = 0; j < m; ++j) {
				sb.append("(to: " + get(i).get(j).to + ", cost: " + get(i).get(j).cost + ')');
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