package library.graph;

import java.util.Objects;

/**
 * 辺を表すクラス
 */
public final class Edge {
	public int src, to, id;
	public long cost;
	/**
	 * コンストラクタ
	 * @param src
	 * @param to
	 * @param id
	 */
	public Edge(final int src, final int to, final int id) {
		this.src = src;
		this.to = to;
		this.id = id;
	}
	/**
	 * コンストラクタ
	 * @param src
	 * @param to
	 * @param cost
	 * @param id
	 */
	public Edge(final int src, final int to, final long cost, final int id) {
		this.src = src;
		this.to = to;
		this.cost = cost;
		this.id = id;
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
	public final int hashCode(){ return Objects.hash(src, to, cost, id); }
	@Override
	public final String toString(){ return "(" + src + ", " + to + ", " + cost + ", " + id + ")"; }
}