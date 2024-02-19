#pragma once

#pragma GCC diagnostic ignored "-Wreorder"

#include <vector>
#include <functional>
template <class T> struct SegTree {
private:
    using F = std::function<T(T, T)>;
    int n, rank, fine;
    const F f;
    const T e;
    std::vector<T> dat;
public:
    SegTree(const int n_, const F f_, const T& e_): f(f_), e(e_), fine(n_) {
        n=1,rank=0;
        while(fine>n) n<<=1LL,rank++;
        dat.assign(2*n,e_);
    }
    T operator[](int i) const { return dat[i+n]; }
    void update(int i, const T& x) {
        i+=n;
        dat[i]=x;
        while(i>>=1LL) dat[i]=f(dat[2*i],dat[2*i+1]);
    }
    void add(int i, const T& x) {
        i+=n;
        dat[i]+=x;
        while(i>>=1LL) dat[i]=f(dat[2*i],dat[2*i+1]);
    }
    T query(int a, int b) const {
        T l=e,r=e;
        for(a+=n, b+=n; a<b; a>>=1LL,b>>=1LL) {
            if(a&1) l=f(l,dat[a++]);
            if(b&1) r=f(dat[--b],r);
        }
        return f(l,r);
    }
    template <class Boolean=bool> inline int find_left(int r, const Boolean &fn) {
        if(!r) return 0;
        int h=0,i=r+n;
        T val=e;
        for(; h <= rank; h++) if(i>>h&1){
            T val2=f(val,dat[i>>h^1]);
            if(fn(val2)){
                i -= 1<<h;
                if(i==n) return 0;
                val=val2;
            }
            else break;
        }
        for(; h--;){
            T val2 = f(val,dat[(i>>h)-1]);
            if(fn(val2)){
                i-=1<<h;
                if(i==n) return 0;
                val=val2;
            }
        }
        return i-n;
    }
    template <class Boolean=bool> inline int find_right(int l, const Boolean &fn) {
        if(l==fine) return fine;
        int h=0,i=l+n;
        T val=e;
        for(; h<=rank; h++) if(i>>h&1){
            T val2=f(val,dat[i>>h]);
            if(fn(val2)){
                i+=1LL<<h;
                if(i==n*2) return fine;
                val=val2;
            }
            else break;
        }
        for(; h--;){
            T val2=f(val, dat[i>>h]);
            if(fn(val2)){
                i+=1LL<<h;
                if(i==n*2) return fine;
                val=val2;
            }
        }
        return std::min(i-n,fine);
    }
};
/**
 * @brief セグメント木
 * @see https://github.com/tatyam-prime/kyopro_library/blob/master/SegmentTree.cpp
 */