// inspired by tatyam(https://github.com/tatyam-prime/kyopro_library/blob/master/SegmentTree.cpp)
#pragma once

#include <vector>
#include <functional>
using namespace std;
typedef long long ll;
template <class T> struct SegTree {
private:
    using F = function<T(T, T)>;
    ll n, rank, fine;
    const F f;
    const T e;
    vector<T> dat;
public:
    SegTree(const ll n_, const F f_, const T& e_): f(f_), e(e_), fine(n_) {
        n=1,rank=0;
        while(fine>n) n<<=1LL,rank++;
        dat.assign(2*n,e_);
    }
    T operator[](ll i) const { return dat[i+n]; }
    void update(ll i, const T& x) {
        i+=n;
        dat[i]=x;
        while(i>>=1LL) dat[i]=f(dat[2*i],dat[2*i+1]);
    }
    void add(ll i, const T& x) {
        i+=n;
        dat[i]+=x;
        while(i>>=1LL) dat[i]=f(dat[2*i],dat[2*i+1]);
    }
    T query(ll a, ll b) const {
        T l=e,r=e;
        for(a+=n, b+=n; a<b; a>>=1LL,b>>=1LL) {
            if(a&1) l=f(l,dat[a++]);
            if(b&1) r=f(dat[--b],r);
        }
        return f(l,r);
    }
    template <class Boolean=bool> inline int find_left(ll r, const Boolean &fn) {
        if(!r) return 0;
        ll h=0,i=r+n;
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
    template <class Boolean=bool> inline int find_right(ll l, const Boolean &fn) {
        if(l==fine) return fine;
        ll h=0,i=l+n;
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
        return min(i-n,fine);
    }
};
