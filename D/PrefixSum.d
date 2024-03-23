struct PrefixSum(T) {
import std.algorithm.iteration: cumulativeFold;
import std.array: array, insertInPlace;
private:
    int n;
    bool notBuilt;
    T[] s;
public:
    this(const int n) {
        this.n = n;
        notBuilt = true;
        s = new T[n + 1];
    }
    this(const T[] a) {
        s = cumulativeFold!"a + b"(a, cast(T)0).array;
        insertInPlace(s, 0, 0);
    }
    T[] get(){ return s; }
    T sum(const int l, const int r) const { return s[r] - s[l]; }
    void add(const int l, const int r, const T x) {
        assert(notBuilt);
        s[l] += x;
        s[r] -= x;
    }
    T[] build() {
        assert(notBuilt);
        auto res = cumulativeFold!"a + b"(s).array;
        notBuilt = false;
        return res[0..n];
    }
}