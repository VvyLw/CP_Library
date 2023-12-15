package extension;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.IntStream;

final class Edge {
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
	public final boolean equals(final Object o) {
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
	public final int hashCode() {
		int result = 17;
		result = 31 * result + src;
		result = 31 * result + to;
		result = 31 * result + (int) (cost ^ (cost >>> 32)); // XOR for long values
		return result;
	}
	@Override
	public final String toString(){ return "(" + src + ", " + to + ", " + cost + ")"; }
}
class Graph extends ArrayList<ArrayList<Edge>> {
	protected final boolean undirected;
	protected final int n, indexed;
	protected final ArrayList<Edge> edge;
	Graph(final int n, final int indexed, final boolean undirected) {
		this.n = n;
		this.indexed = indexed;
		this.undirected = undirected;
		edge = new ArrayList<>();
		IntStream.range(0, n).forEach(i -> this.add(new ArrayList<>()));
	}
	final void addEdge(int a, int b) {
		a -= indexed;
		b -= indexed;
		this.get(a).add(new Edge(b));
		edge.add(new Edge(a, b, 0));
		if(undirected) {
			this.get(b).add(new Edge(a));
		}
	}
	protected final int[] allDist(final int v) {
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
	protected final int dist(final int u, final int v){ return allDist(u)[v]; }
	protected final ArrayList<Integer> topologicalSort() {
		int[] deg = new int[n];
		for(int i = 0; i < n; ++i) {
			for(final var ed: this.get(i)) {
				deg[ed.to]++;
			}
		}
		final var sk = new Stack<Integer>();
		for(int i = 0; i < n; ++i) {
			if(deg[i] == 0) {
				sk.add(i);
			}
		}
		final var ord = new ArrayList<Integer>();
		while(!sk.isEmpty()) {
			final var tmp = sk.pop();
			ord.add(tmp);
			for(final var ed: this.get(tmp)) {
				if(--deg[ed.to] == 0) {
					sk.add(ed.to);
				}
			}
		}
		return ord.size() == size() ? ord : new ArrayList<>();
	}
}