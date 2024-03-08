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
    ref auto opIndex(int i) {
        while(par[i] >= 0) {
            const p = par[par[i]];
            if(p < 0) {
                return par[i];
            }
            i = par[i] = p;
        }
        return i;
    }
    int size(const int i){ return -par[this[i]]; }
    bool unite(int i, int j) {
        i = this[i];
        j = this[j];
        if(i == j) {
            return false;
        }
        if(i > j) {
            swap(i, j);
        }
        par[i] += par[j];
        par[j] = i;
        return true;
    }
    int[][] groups() {
        int[][] res = new int[][n];
        foreach(i; 0..n) {
            res[this[i]] ~= i;
        }
        return res.filter!(a => !a.empty).array;
    }
}

bool isBipartite(UnionFind uf) {
    assert(uf.length % 2 == 0);
    const n = uf.length / 2;
    bool ok = true;
    foreach(i; 0..n) {
        ok &= uf[i] != uf[i + n];
    }
    return ok;
}