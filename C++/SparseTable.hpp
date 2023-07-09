#include <vector>
using namespace std;
template <class T> struct SparseTable {
    using F = function<T(T,T)>;
    vector<vector<T>> st;
    vector<T> lookup;
    F f;
    SparseTable(const vector<T> &v, const F &f_) : f(f_) { init(v); }
    void init(const vector<T> &v) {
        int b = 0;
        while((1 << b) <= v.size()) ++b;
        st.assign(b, vector<T>(1 << b));
        for(int i = 0; i < v.size(); i++) {
            st[0][i] = v[i];
        }
        for(int i = 1; i < b; i++) {
            for(int j = 0; j + (1 << i) <= (1 << b); j++) {
                st[i][j] = f(st[i - 1][j], st[i - 1][j + (1 << (i - 1))]);
            }
        }
        lookup.resize(v.size() + 1);
        for(int i = 2; i < lookup.size(); i++) {
            lookup[i] = lookup[i >> 1] + 1;
        }
    }
    inline T query(T l, T r) {
        int b = lookup[r - l];
        return f(st[b][l], st[b][r - (1 << b)]);
    }
};