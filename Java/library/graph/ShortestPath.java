package library.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 最短路クラス
 */
public final class ShortestPath {
	private final long[] cost;
	private final int[] src;
	/**
	 * コンストラクタ
	 * @param cost
	 * @param src
	 */
	public ShortestPath(final long[] cost, final int[] src) {
		this.cost = cost;
		this.src = src;
	}
	/**
	 * @param i
	 * @return 経路があるか
	 */
	public final boolean isThru(final int i){ return src[i] != -1; }
	/**
	 * 経路復元
	 * @param i
	 */
	public final int[] path(int i) {
		final List<Integer> res = new ArrayList<>();
		for(; i != -1; i = src[i]) {
			res.add(i);
		}
		Collections.reverse(res);
		return res.stream().mapToInt(k -> k).toArray();
	}
	/**
	 * @return 全点間の最短コスト
	 */
	public final long[] get(){ return cost; }
}