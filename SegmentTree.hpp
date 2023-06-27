#include <vector>
using namespace std;
typedef long long ll;
template <class X> struct SegTree {
    using FX = function<X(X, X)>;
    ll n;
    FX fx;
    const X ex;
    vector<X> dat;
    SegTree(ll n_, FX fx_, X ex_) : n(), fx(fx_), ex(ex_), dat(n_ * 4, ex_) {
        ll x = 1;
        while (n_ > x) x *= 2;
        n = x;
    }
    void set(ll i, X x) { dat[i+n-1] = x; }
    void build() { for(int i = n - 2; i >= 0; i--) dat[i] = fx(dat[2*i+1], dat[2*i+2]); }
    void update(ll i, X x) {
        i+=n-1;
        dat[i]=x;
        while(i > 0) {
            i=(i-1)/2;  // parent
            dat[i]=fx(dat[i * 2 + 1], dat[i * 2 + 2]);
        }
    }
    X query(ll a, ll b) { return query_sub(a, b, 0, 0, n); }
    X query_sub(ll a, ll b, ll k, ll l, ll r) {
        if(r<=a || b<=l) return ex;
        else if(a<=l && r<=b) return dat[k];
        else {
            X vl = query_sub(a,b,k*2+1,l,(l+r)/2);
            X vr = query_sub(a,b,k*2+2,(l+r)/2,r);
            return fx(vl, vr);
        }
    }
};