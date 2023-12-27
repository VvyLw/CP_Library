package extension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

final class MST {
	public final ArrayList<Edge> tree;
	public final long cost;
	MST(final ArrayList<Edge> tree, final long cost) {
		this.tree = tree;
		this.cost = cost;
	}
}
final class WeightedGraph extends Graph {
	WeightedGraph(final int n, final int indexed, final boolean undirected){ super(n, indexed, undirected); }
	final void addEdge(int a, int b, final long cost) {
		a -= indexed;
		b -= indexed;
		this.get(a).add(new Edge(b, cost));
		edge.add(new Edge(a, b, cost));
		if(undirected) {
			this.get(b).add(new Edge(a, cost));
			edge.add(new Edge(b, a, cost));
		}
	}
	final void input(final int m){ IntStream.range(0, m).forEach(i -> addEdge(VvyLw.sc.ni(), VvyLw.sc.ni(), VvyLw.sc.ni())); }
	final long[] dijkstra(final int v) {
		long[] cost = new long[n];
		Arrays.fill(cost, Long.MAX_VALUE);
		Queue<NumPair> dj = new PriorityQueue<>();
		cost[v] = 0;
		dj.add(new NumPair(cost[v], v));
		while(!dj.isEmpty()) {
			final var tmp = dj.poll();
			if(cost[tmp.second.intValue()] < tmp.first.longValue()) {
				continue;
			}
			for(final var el: this.get(tmp.second.intValue())) {
				if(cost[el.to] > tmp.first.longValue() + el.cost) {
					cost[el.to] = tmp.first.longValue() + el.cost;
					dj.add(new NumPair(cost[el.to], el.to));
				}
			}
		}
		return cost;
	}
	final long[] bellmanFord(final int v) {
		long[] cost = new long[n];
		Arrays.fill(cost, Long.MAX_VALUE);
		cost[v] = 0;
		for(int i = 0; i < edge.size() - 1; ++i) {
			for(final var e: edge) {
				if(cost[e.src] == Long.MAX_VALUE) {
					continue;
				}
				cost[e.to] = Math.min(cost[e.to], cost[e.src] + e.cost);
			}
		}
		for(final var e: edge) {
			if(cost[e.src] == Long.MAX_VALUE) {
				continue;
			}
			if(cost[e.src] + e.cost < cost[e.to]) {
				return null;
			}
		}
		return cost;
	}
	final long[][] warshallFloyd() {
		long[][] cost = new long[n][n];
		IntStream.range(0, n).forEach(i -> Arrays.fill(cost[i], Long.MAX_VALUE));
		IntStream.range(0, n).forEach(i -> cost[i][i] = 0);
		for(int i = 0; i < n; ++i) {
			for(final var j: this.get(i)) {
				cost[i][j.to] = j.cost;
			}
		}
		for(int k = 0; k < n; ++k) {
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
	final MST kruskal() {
		final UnionFind uf = new UnionFind(n);
		final var e = new ArrayList<Edge>();
		long res = 0;
		for(final var ed: edge.stream().sorted(Comparator.comparing(ed -> ed.cost)).collect(Collectors.toList())) {
			if(uf.unite(ed.src, ed.to)) {
				e.add(ed);
				res += ed.cost;
			}
		}
		return new MST(e, res);
	}
	final MST directed(final int v) {
		@SuppressWarnings("unchecked")
		final var ed = (ArrayList<Edge>) edge.clone();
		for(int i = 0; i < n; ++i) {
			if(i != v) {
				ed.add(new Edge(i, v, 0));
			}
		}
		int x = 0;
		int[] par = new int[2 * n], vis = new int[2 * n], link = new int[2 * n];
		Arrays.fill(par, -1);
		Arrays.fill(vis, -1);
		Arrays.fill(link, -1);
		final var heap = new SkewHeap(true);
		final var ins = new SkewHeap.Node[2 * n];
		Arrays.fill(ins, null);
		for(int i = 0; i < ed.size(); i++) {
			final var e = ed.get(i);
			ins[e.to] = heap.push(ins[e.to], e.cost, i);
		}
		final var st = new ArrayList<Integer>();
		final Function<Integer, Integer> go = z -> {
			z = ed.get(ins[z].idx).src;
			while(link[z] != -1) {
				st.add(z);
				z = link[z];
			}
			for(final var p: st) {
				link[p] = z;
			}
			st.clear();
			return z;
		};
		for(int i = n; ins[x] != null; ++i) {
			while(vis[x] == -1) {
				vis[x] = 0;
				x = go.apply(x);
			}
			while(x != i) {
				final var w = ins[x].key;
				var z = heap.pop(ins[x]);
				z = heap.add(z, -w);
				ins[i] = heap.meld(ins[i], z);
				par[x] = i;
				link[x] = i;
				x = go.apply(x);
			}
			while(ins[x] != null && go.apply(x) == x) {
				ins[x] = heap.pop(ins[x]);
			}
		}
		for(int i = v; i != -1; i = par[i]) {
			vis[i] = 1;
		}
		long cost = 0;
		ArrayList<Edge> e = new ArrayList<>();
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
final class SkewHeap {
	static final class Node {
		long key, lazy;
		Node l, r;
		final int idx;
		Node(final long key, final int idx) {
			this.key = key;
			this.idx = idx;
			lazy = 0;
			l = null;
			r = null;
		}
	}
	private final boolean isMin;
	SkewHeap(final boolean isMin){ this.isMin = isMin; }
	private final Node alloc(final long key, final int idx){ return new Node(key, idx); }
	private final Node propagate(final Node t) {
		if(t != null && t.lazy != 0) {
			if(t.l != null) {
				t.l.lazy += t.lazy;
			}
			if(t.r != null) {
				t.r.lazy += t.lazy;
			}
			t.key += t.lazy;
			t.lazy = 0;
		}
		return t;
	}
	final Node meld(Node x, Node y) {
		propagate(x);
		propagate(y);
		if(x == null || y == null) {
			return x != null ? x : y;
		}
		if((x.key < y.key) ^ isMin) {
			final var tmp = x;
			x = y;
			y = tmp;
		}
		x.r = meld(y, x.r);
		final var tmp = x.l;
		x.l = x.r;
		x.r = tmp;
		return x;
	}
	final Node push(final Node t, final long key, int idx){ return meld(t, alloc(key, idx)); }
	final Node pop(final Node t) {
		if(t == null) {
			throw new NullPointerException();
		}
		return meld(t.l, t.r);
	}
	final Node add(Node t, final long lazy) {
		if(t != null) {
			t.lazy += lazy;
			propagate(t);
		}
		return t;
	}
}
