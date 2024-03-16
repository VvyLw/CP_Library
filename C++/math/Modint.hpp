#pragma once

#include <iostream>
#include <cassert>
#include <vector>
#include <utility>
#include <type_traits>
#include <numeric>
#ifndef TEMPLATE
typedef long long ll;
typedef unsigned uint;
typedef unsigned long long ul;
#endif
template <uint mod> struct Modint {
    uint num = 0;
    constexpr Modint() noexcept {}
    constexpr Modint(const Modint &x) noexcept : num(x.num){}
    constexpr operator ll() const noexcept { return num; }
    constexpr static uint get_mod(){ return mod; }
    constexpr Modint& operator+=(Modint x) noexcept { num += x.num; if(num >= mod) num -= mod; return *this; }
    constexpr Modint& operator++() noexcept { if(num == mod - 1) num = 0; else num++; return *this; }
    constexpr Modint operator++(int) noexcept { Modint ans(*this); operator++(); return ans; }
    constexpr Modint operator-() const noexcept { return Modint(0) -= *this; }
    constexpr Modint& operator-=(Modint x) noexcept { if(num < x.num) num += mod; num -= x.num; return *this; }
    constexpr Modint& operator--() noexcept { if(num == 0) num = mod - 1; else num--; return *this; }
    constexpr Modint operator--(int) noexcept { Modint ans(*this); operator--(); return ans; }
    constexpr Modint& operator*=(Modint x) noexcept { num = ul(num) * x.num % mod; return *this; }
    constexpr Modint& operator/=(Modint x) noexcept { return operator*=(x.inv()); }
    constexpr void operator%=(Modint x) noexcept { void(0); }
    template <class T> constexpr Modint(T x) noexcept {
        using U = typename std::conditional<sizeof(T)>= 4, T, int>::type;
        U y = x; y %= U(mod); if(y < 0) y += mod; num = uint(y);
    }
    template <class T> constexpr Modint operator+(T x) const noexcept { return Modint(*this) += x; }
    template <class T> constexpr Modint& operator+=(T x) noexcept { return operator+=(Modint(x)); }
    template <class T> constexpr Modint operator-(T x) const noexcept { return Modint(*this) -= x; }
    template <class T> constexpr Modint& operator-=(T x) noexcept { return operator-=(Modint(x)); }
    template <class T> constexpr Modint operator*(T x) const noexcept { return Modint(*this) *= x; }
    template <class T> constexpr Modint& operator*=(T x) noexcept { return operator*=(Modint(x)); }
    template <class T> constexpr Modint operator/(T x) const noexcept { return Modint(*this) /= x; }
    template <class T> constexpr Modint& operator/=(T x) noexcept { return operator/=(Modint(x)); }
    constexpr Modint inv() const noexcept { ll x = 0, y = 0; extgcd(num, mod, x, y); return x; }
    static constexpr ll extgcd(ll a, ll b, ll &x, ll &y) noexcept { ll g = a; x = 1; y = 0; if(b){ g = extgcd(b, a % b, y, x); y -= a / b * x; } return g; }
    constexpr Modint pow(ul x) const noexcept { Modint ans = 1, cnt = *this; while(x){ if(x & 1) ans *= cnt; cnt *= cnt; x /= 2; } return ans; }
    friend std::ostream& operator<<(std::ostream& os, const Modint& m){ os << m.num; return os; }
    friend std::istream &operator>>(std::istream &is, Modint &a) {
        ll t;
        is >> t;
        a=Modint(t);
        return (is);
    }
};
using mint = Modint<998244353>;
using Mint = Modint<1000000007>;
template <class T> inline T msum(const std::vector<T> &v){ return std::accumulate(v.begin(), v.end(), mint(0)); }
template <class T> inline T msum(const std::vector<T> &v, ll a, ll b){ return std::accumulate(v.begin() + a, v.begin() + b, mint(0)); }
template <class T> inline T mmul(const std::vector<T> &v){ return std::accumulate(v.begin(), v.end(), mint(1), [](T acc, T i){ return acc*i; }); }
template <class T> inline T mmul(const std::vector<T> &v, ll a, ll b){ return std::accumulate(v.begin() + a, v.begin() + b, mint(1), [](T acc, T i){ return acc*i; }); }
template <class mint> struct Comb {
private:
    std::vector<mint> fac{1},inv{1};
    void reserve(ul a){
        if(fac.size()>=a) return;
        if(a<fac.size()*2) a=fac.size()*2;
        if(a>=mint::get_mod()) a=mint::get_mod();
        while(fac.size()<a) fac.emplace_back(fac.back()*mint(fac.size()));
        inv.resize(fac.size());
        inv.back()=fac.back().inv();
        for(ll i=inv.size()-1; !inv[i-1]; i--) inv[i-1]=inv[i]*i;
    }
public:
    mint fact(const ll n){ if(n<0) return 0; reserve(n + 1); return fac[n]; }
    mint nPr(ll n, const ll r){
        if(r<0 || n<r) return 0;
        if(n>>24){ mint ans=1; for(int i = 0; i < r; ++i) ans*=n--; return ans; }
        reserve(n+1); return fac[n]*inv[n-r];
    }
    mint nCr(const ll n, ll r){ if(r<0 || n<r) return 0; r=std::min(r,n-r); reserve(r+1); return nPr(n,r)*inv[r]; }
    mint nHr(const ll n, const ll r){ if(!n && !r) return 1; if(n<=0 || r<0) return 0; return nCr(n+r-1,r); }
};

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
            std::swap(a -= t*b,b);
            std::swap(u -= t*v,v);
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
    friend std::ostream &operator<<(std::ostream &os, const a_mint &p) { return os << p.val; }
    friend std::istream &operator>>(std::istream &is, a_mint &a) {
        ll t;
        is >> t;
        a=a_mint(t);
        return is;
    }
};

/**
 * @brief Modint
 * @docs docs/Modint.md
 * @see https://atcoder.jp/contests/arc151/submissions/35526971
 */