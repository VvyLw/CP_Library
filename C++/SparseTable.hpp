// inspired by Luzhiled(https://ei1333.github.io/luzhiled/snippets/structure/sparse-table.html)
#pragma once

#include <vector>
#include <functional>
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
    inline T query(const T l, const T r) {
        int b = lookup[r - l];
        return f(st[b][l], st[b][r - (1 << b)]);
    }
    template <class Boolean=bool> inline int min_left(const int x, const Boolean &fn) {
        if(!x) return 0;
        int ok=x, ng=-1;
        while(abs(ok-ng)>1) {
            int mid=(ok+ng)/2;
            (fn(query(mid,x)-1)?ok:ng)=mid;
        }
        return ok;
    }
    template <class Boolean=bool> inline int max_right(const int x, const Boolean &fn) {
        if(x==lookup.size()-1) return lookup.size()-1;
        int ok=x, ng=lookup.size();
        while(abs(ok-ng)>1) {
            int mid=(ok+ng)/2;
            (fn(query(x,mid))?ok:ng)=mid;
        }
        return ok;
    }
};
