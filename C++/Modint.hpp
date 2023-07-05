// inspired by tatyam(https://atcoder.jp/contests/arc151/submissions/35526971)
#include <iostream>
#include <vector>
#include <utility>
#include <type_traits>
using namespace std;
typedef long long ll;
typedef unsigned uint;
typedef unsigned long long ul;
constexpr const int mod = 998244353;
//constexpr const int mod = 1e9+7;
struct mint {
    uint num = 0;
    constexpr mint() noexcept {}
    constexpr mint(const mint &x) noexcept : num(x.num){}
    constexpr operator ll() const noexcept { return num; }
    constexpr mint& operator+=(mint x) noexcept { num += x.num; if(num >= mod) num -= mod; return *this; }
    constexpr mint& operator++() noexcept { if(num == mod - 1) num = 0; else num++; return *this; }
    constexpr mint operator++(int) noexcept { mint ans(*this); operator++(); return ans; }
    constexpr mint operator-() const noexcept { return mint(0) -= *this; }
    constexpr mint& operator-=(mint x) noexcept { if(num < x.num) num += mod; num -= x.num; return *this; }
    constexpr mint& operator--() noexcept { if(num == 0) num = mod - 1; else num--; return *this; }
    constexpr mint operator--(int) noexcept { mint ans(*this); operator--(); return ans; }
    constexpr mint& operator*=(mint x) noexcept { num = ul(num) * x.num % mod; return *this; }
    constexpr mint& operator/=(mint x) noexcept { return operator*=(x.inv()); }
    template<class T> constexpr mint(T x) noexcept {
        using U = typename conditional<sizeof(T)>= 4, T, int>::type;
        U y = x; y %= U(mod); if(y < 0) y += mod; num = uint(y);
    }
    template <class T> constexpr mint operator+(T x) const noexcept { return mint(*this) += x; }
    template <class T> constexpr mint& operator+=(T x) noexcept { return operator+=(mint(x)); }
    template <class T> constexpr mint operator-(T x) const noexcept { return mint(*this) -= x; }
    template <class T> constexpr mint& operator-=(T x) noexcept { return operator-=(mint(x)); }
    template <class T> constexpr mint operator*(T x) const noexcept { return mint(*this) *= x; }
    template <class T> constexpr mint& operator*=(T x) noexcept { return operator*=(mint(x)); }
    template <class T> constexpr mint operator/(T x) const noexcept { return mint(*this) /= x; }
    template <class T> constexpr mint& operator/=(T x) noexcept { return operator/=(mint(x)); }
    constexpr mint inv() const noexcept { ll x = 0, y = 0; extgcd(num, mod, x, y); return x; }
    static constexpr ll extgcd(ll a, ll b, ll &x, ll &y) noexcept { ll g = a; x = 1; y = 0; if(b){ g = extgcd(b, a % b, y, x); y -= a / b * x; } return g; }
    constexpr mint pow(ul x) const noexcept { mint ans = 1, cnt = *this; while(x){ if(x & 1) ans *= cnt; cnt *= cnt; x /= 2; } return ans; }
    friend ostream& operator<<(ostream& os, const mint& m){ os << m.num; return os; }
    friend istream &operator>>(istream &is, mint &a) {
        ll t;
        is >> t;
        a=mint(t);
        return (is);
    }
};
//#include "template.hpp"
//#define MINT(...) mint __VA_ARGS__; in(__VA_ARGS__)
using vm = vector<mint>;
using wm = vector<vm>;
using pm = pair<mint, mint>;
vm fac(1,1), inv(1,1);
void reserve(ll a){
    if(fac.size()>=a) return;
    if(a<fac.size()*2) a=fac.size()*2;
    if(a>=mod) a=mod;
    while(fac.size()<a) fac.emplace_back(fac.back()*mint(fac.size()));
    inv.resize(fac.size());
    inv.back()=fac.back().inv();
    for(ll i=inv.size()-1; !inv[i-1]; i--) inv[i-1]=inv[i]*i;
}
mint fact(ll n){ if(n<0) return 0; reserve(n + 1); return fac[n]; }
mint nPr(ll n,ll r){
    if(r<0 || n<r) return 0;
    if(n>>24){ mint ans=1; for(int i = 0; i < r; ++i) ans*=n--; return ans; }
    reserve(n+1); return fac[n]*inv[n-r];
}
mint nCr(ll n,ll r){ if(r<0 || n<r) return 0; r=min(r,n-r); reserve(r+1); return nPr(n,r)*inv[r]; }
mint nHr(ll n,ll r){ if(!n && !r) return 1; if(n<=0 || r<0) return 0; return nCr(n+r-1,r); }

// Arbitrary Modint
struct a_mint {
    int val;
    a_mint() : val(0){}
    a_mint(ll x) : val(x >= 0 ? x % get_mod() : (get_mod() - (-x) % get_mod()) % get_mod()){}
    int getmod() { return get_mod(); }
    static int &get_mod() {
        static int mod = 0;
        return mod;
    }
    static void set_mod(int md) { assert(md>0); get_mod() = md; }
    a_mint &operator+=(const a_mint &p) {
        if ((val += p.val) >= get_mod()) val -= get_mod();
        return *this;
    }
    a_mint &operator-=(const a_mint &p) {
        if((val += get_mod() - p.val) >= get_mod()) val -= get_mod();
        return *this;
    }
    a_mint &operator*=(const a_mint &p) {
        val = (int)(1LL * val * p.val % get_mod());
        return *this;
    }
    a_mint &operator/=(const a_mint &p) {
        *this *= p.inv();
        return *this;
    }
    a_mint operator-() const { return a_mint(-val); }
    a_mint operator+(const a_mint &p) const { return a_mint(*this) += p; }
    a_mint operator-(const a_mint &p) const { return a_mint(*this) -= p; }
    a_mint operator*(const a_mint &p) const { return a_mint(*this) *= p; }
    a_mint operator/(const a_mint &p) const { return a_mint(*this) /= p; }
    a_mint& operator++() noexcept { if(val == get_mod() - 1) val = 0; else val++; return *this; }
    a_mint operator++(int) noexcept { a_mint ans(*this); operator++(); return ans; }
    a_mint& operator--() noexcept { if(val == 0) val = get_mod() - 1; else val--; return *this; }
    a_mint operator--(int) noexcept { a_mint ans(*this); operator--(); return ans; }
    bool operator==(const a_mint &p) const { return val == p.val; }
    bool operator!=(const a_mint &p) const { return val != p.val; }
    bool operator!() const { return val == 0; }
    bool operator<=(const a_mint &p) const { return val <= p.val; }
    bool operator>=(const a_mint &p) const { return val >= p.val; }
    bool operator<(const a_mint &p) const { return val < p.val; }
    bool operator>(const a_mint &p) const { return val > p.val; }
    a_mint inv() const {
        int a=val, b=get_mod(), u=1, v=0, t;
        while(b>0) {
            t=a/b;
            swap(a -= t*b,b);
            swap(u -= t*v,v);
        }
        return a_mint(u);
    }
    a_mint pow(ll n) const {
        a_mint res(1), mul(val);
        while(n>0) {
            if(n & 1) res *= mul;
            mul *= mul;
            n >>= 1;
        }
        return res;
    }
    friend ostream &operator<<(ostream &os, const a_mint &p) { return os << p.val; }
    friend istream &operator>>(istream &is, a_mint &a) {
        ll t;
        is >> t;
        a=a_mint(t);
        return (is);
    }
};
//#include "template.hpp"
//#define MINT(...) a_mint __VA_ARGS__; in(__VA_ARGS__)
using vm = vector<a_mint>;
using wm = vector<vm>;
using pm = pair<a_mint, a_mint>;
