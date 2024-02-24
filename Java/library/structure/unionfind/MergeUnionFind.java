package library.structure.unionfind;

public abstract class MergeUnionFind<T> extends UnionFind {
	public MergeUnionFind(final int n){ super(n); }
	abstract void merge(final int i, final int j);
	abstract T get(final int i);
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
