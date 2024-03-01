package library.core.interfaces;

import java.util.ArrayList;

/**
 * UnionFindのベースとなるインターフェース
 * Disjoint Set Union
 */
public interface DSU {
	/**
	 * @param i
	 * @return iの根
	 */
	public int root(final int i);
	/**
	 * @param i
	 * @return iを含む連結成分のサイズ
	 */
	public int size(final int i);
	/**
	 * @return UnionFindのサイズ
	 */
	public int size();
	/**
	 * @param i
	 * @param j
	 * @return iとjが同じ連結成分に所属しているか
	 */
	public default boolean same(final int i, final int j){ return root(i) == root(j); }
	/**
	 * @param i
	 * @param j
	 * @return 未マージでtrue, マージ済でfalse
	 */
	public boolean unite(int i, int j);
	/**
	 * @see <a href="https://atcoder.github.io/ac-library/production/document_ja/dsu.html">atcoder::dsu::groups</a>
	 * @return グラフを連結成分に分け、その情報を返す
	 */
	public ArrayList<ArrayList<Integer>> groups();
}