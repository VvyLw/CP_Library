import std.algorithm: swap, filter;
import std.array: array;
import std.range;
class UnionFind {
private:
    int n;
    int[] par;
public:
    this(const int n) {
        this.n = n;
        par = new int[n];
        par[] = -1;
    }
    int length() const { return n; }
    int root(const int i){ return par[i] >= 0 ? par[i] = root(par[i]) : i; }
    int size(const int i){ return -par[root(i)]; }
    bool unite(int i, int j) {
        i = root(i);
        j = root(j);
        if (i == j) {
            return false;
        }
        if (i > j) {
            swap(i, j);
        }
        par[i] += par[j];
        par[j] = i;
        return true;
    }
    bool same(const int i, const int j){ return root(i) == root(j); }
    int[][] groups() {
        int[][] res = new int[][n];
        foreach(i; 0..n) {
            res[root(i)] ~= i;
        }
        return res.filter!(a => !a.empty).array;
    }
}

bool isBipartite(UnionFind uf) {
    assert(uf.length % 2 == 0);
    const n = uf.length / 2;
    bool ok = true;
    foreach(i; 0..n) {
        ok &= !uf.same(i, i + n);
    }
    return ok;
}