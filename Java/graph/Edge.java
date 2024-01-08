package library.graph;

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
		result = 31 * result + (int) (cost ^ (cost >>> 32));
		return result;
	}
	@Override
	public final String toString(){ return "(" + src + ", " + to + ", " + cost + ")"; }
}
