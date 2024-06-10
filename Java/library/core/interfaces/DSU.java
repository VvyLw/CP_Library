package library.core.interfaces;

import java.util.ArrayList;

/**
 * UnionFindのベースとなるインターフェース
 * Disjoint Set Union
 */
public interface DSU {
	/**
	 * 頂点iの根を返す
	 * @param i
	 * @return iの根
	 */
	public int root(final int i);
	/**
	 * 頂点iを含む連結成分のサイズ
	 * @param i
	 * @return iを含む連結成分のサイズ
	 */
	public int size(final int i);
	/**
	 * UnionFindの大きさを返す
	 * @return UnionFindのサイズ
	 */
	public int size();
	/**
	 * 二頂点が同じ連結成分に所属しているかを返す
	 * @param i
	 * @param j
	 * @return iとjが同じ連結成分に所属しているか
	 */
	public default boolean same(final int i, final int j){ return root(i) == root(j); }
	/**
	 * 二頂点をマージする
	 * @param i
	 * @param j
	 * @return 未マージでtrue, マージ済でfalse
	 */
	public boolean unite(int i, int j);
	/**
	 * グラフを連結成分に分け、その情報を返す
	 * @see <a href="https://atcoder.github.io/ac-library/production/document_ja/dsu.html">atcoder::dsu::groups</a>
	 * @return グラフを連結成分に分けた時の状態
	 */
	public ArrayList<ArrayList<Integer>> groups();
}