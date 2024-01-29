package library.graph;

import java.util.Objects;

/**
 * 辺を表すクラス
 */
public final class Edge {
	public int src;
	public int to;
	public long cost;
	public Edge(final int to){ this.to = to; }
	public Edge(final int to, final long cost) {
		this.to = to;
		this.cost = cost;
	}
	public Edge(final int src, final int to, final long cost) {
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
		return src == e.src && to == e.to && cost == e.cost;
	}
	@Override
	public final int hashCode(){ return Objects.hash(src, to, cost); }
	@Override
	public final String toString(){ return "(" + src + ", " + to + ", " + cost + ")"; }
}