package library.structure.unionfind;

/**
 * UnionFind内でマージテクを使いたい時に使うクラス
 * @param <T>
 */
public abstract class MergeUnionFind<T> extends UnionFind {
	/**
	 * コンストラクタ
	 * @param n
	 */
	public MergeUnionFind(final int n){ super(n); }
	/**
	 * マージテク
	 * @param i
	 * @param j
	 */
	abstract void merge(final int i, final int j);
	/**
	 * @param i
	 * @return
	 */
	abstract T get(final int i);
	@Override
	public final boolean unite(int i, int j) {
		i = root(i);
		j = root(j);
		if(i == j) {
			return false;
		}
		if(i > j) {
			i ^= j;
			j ^= i;
			i ^= j;
		}
		par[i] += par[j];
		par[j] = i;
		merge(i, j);
		return true;
	}
}