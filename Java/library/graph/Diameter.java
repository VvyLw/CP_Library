package library.graph;

import static java.lang.Math.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import library.ds.pair.IntPair;

/**
 * 木の直径
 * @see <a href="https://ei1333.github.io/library/graph/tree/tree-diameter.hpp">参考元</a>
 */
public final class Diameter extends WeightedGraph {
	private final int[] to;
	private final ArrayList<Edge> path;
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
	 * コンストラクタ(1-indexed)
	 * @param n
	 * @param undirected
	 */
	public Diameter(final int n, final boolean undirected){ this(n, 1, undirected); }
	/**
	 * コンストラクタ
	 * @param n
	 * @param id
	 * @param undirected
	 */
	public Diameter(final int n, final int id, final boolean undirected){
		super(n, id, undirected);
		to = new int[n];
		Arrays.fill(to, -1);
		path = new ArrayList<>();
	}
	/**
	 * @param g
	 * @param undirected
	 * @return List<ArrayList<Edge>>をDiameter化したもの
	 */
	public static final Diameter of(final List<ArrayList<Edge>> g, final boolean undirected) {
		int max = 0, min = Integer.MAX_VALUE;
		for(int i = 0; i < g.size(); ++i) {
			for(final Edge e: g.get(i)) {
				max = max(e.src, e.to);
				min = min(e.src, e.to);
			}
		}
		final Diameter gp = new Diameter(max, min, undirected);
		for(int i = 0; i < g.size(); ++i) {
			for(final Edge e: g.get(i)) {
				gp.addEdge(e.src, e.to, e.cost);
			}
		}
		return gp;
	}
	/**
	 * path(直径を構成する辺)を構築する
	 * @return 木の直径
	 */
	public final long build() {
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
}