package library.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import library.core.VvyLw;
import library.other.SkewHeap;
import library.structure.pair.IntPair;
import library.structure.unionfind.UnionFind;

/**
 * 重みつきグラフクラス
 */
public final class WeightedGraph extends Graph {
	/**
	 * コンストラクタ
	 * グラフクラスから継承
	 * @param n
	 * @param indexed
	 * @param undirected
	 */
	public WeightedGraph(final int n, final int indexed, final boolean undirected){ super(n, indexed, undirected); }
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
	public final long[] dijkstra(final int v) {
		final long[] cost = new long[n];
		Arrays.fill(cost, Long.MAX_VALUE);
		final Queue<IntPair> dj = new PriorityQueue<>();
		cost[v] = 0;
		dj.add(IntPair.of(cost[v], v));
		while(!dj.isEmpty()) {
			final IntPair tmp = dj.poll();
			if(cost[tmp.second.intValue()] < tmp.first.longValue()) {
				continue;
			}
			for(final Edge el: this.get(tmp.second.intValue())) {
				if(cost[el.to] > tmp.first.longValue() + el.cost) {
					cost[el.to] = tmp.first.longValue() + el.cost;
					dj.add(IntPair.of(cost[el.to], el.to));
				}
			}
		}
		return cost;
	}
	/**
	 * Bellman-Ford法
	 * 負辺が存在していても単一始点全点間最短路を求められる
	 * 負閉路も検出する
	 * @param v
	 */
	public final long[] bellmanFord(final int v) {
		final long[] cost = new long[n];
		Arrays.fill(cost, Long.MAX_VALUE);
		cost[v] = 0;
		for(int i = 0; i < edge.size() - 1; ++i) {
			for(final Edge e: edge) {
				if(cost[e.src] == Long.MAX_VALUE) {
					continue;
				}
				if(cost[e.to] > cost[e.src] + e.cost) {
					cost[e.to] = cost[e.src] + e.cost;
				}
			}
		}
		for(final Edge e: edge) {
			if(cost[e.src] == Long.MAX_VALUE) {
				continue;
			}
			if(cost[e.src] + e.cost < cost[e.to]) {
				return null;
			}
		}
		return cost;
	}
	/**
	 * Warshall-Floyd法
	 * 全点対間最短路を求める
	 */
	public final long[][] warshallFloyd() {
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
}