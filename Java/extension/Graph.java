package extension;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

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
	@Override
	public boolean equals(final Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || getClass() != o.getClass()) {
			return false;
		}
		final Edge e = (Edge) o;
		if(src != e.src) {
			return false;
		}
		if(to != e.to) {
			return false;
		}
		return cost == e.cost;
	}
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + src;
		result = 31 * result + to;
		result = 31 * result + (int) (cost ^ (cost >>> 32)); // XOR for long values
		return result;
	}
	@Override
	public String toString(){ return src + " " + to + " " + cost; }
}
class Graph extends ArrayList<ArrayList<Edge>> {
	protected boolean undirected;
	protected int n, indexed;
	Graph(final int n, final int indexed, final boolean undirected) {
		this.n = n;
		this.indexed = indexed;
		this.undirected = undirected;
		IntStream.range(0, n).forEach(i -> this.add(new ArrayList<>()));
	}
	void addEdge(int a, int b) {
		a -= indexed;
		b -= indexed;
		this.get(a).add(new Edge(b));
		if(undirected) {
			this.get(b).add(new Edge(a));
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
			for(final var el: this.get(tmp)) {
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
	WeightedGraph(final int n, final int indexed, final boolean undirected) {
		super(n, indexed, undirected);
	}
	void addEdge(int a, int b, final long cost) {
		a -= indexed;
		b -= indexed;
		this.get(a).add(new Edge(b, cost));
		if(undirected) {
			this.get(b).add(new Edge(a, cost));
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
			for(final var el: this.get(tmp.second.intValue())) {
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
			for(final var j: this.get(i)) {
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
	private ArrayList<Edge> edge;
	private int n, indexed;
	Tree(final int n, final int indexed) {
		edge = new ArrayList<>(n);
		this.n = n;
		this.indexed = indexed;
	}
	void addEdge(final int a, final int b, final long cost){ edge.add(new Edge(a - indexed, b - indexed, cost)); }
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