#pragma once

#pragma GCC diagnostic ignored "-Wdeprecated-copy"

#ifndef MODINT
#define MODINT
#endif

#include <iostream>
#include <cassert>
#include <cstdint>
#include <vector>
#include <utility>
#include <type_traits>
#include <numeric>
#include <ranges>
namespace man {
template <uint mod> struct Modint {
    uint num = 0;
    constexpr Modint() noexcept {}
    constexpr Modint(const Modint &x) noexcept : num(x.num){}
    constexpr operator int64_t() const noexcept { return num; }
    constexpr static unsigned get_mod(){ return mod; }
    constexpr Modint& operator+=(Modint x) noexcept { num += x.num; if(num >= mod) num -= mod; return *this; }
    constexpr Modint& operator++() noexcept { if(num == mod - 1) num = 0; else num++; return *this; }
    constexpr Modint operator++(int) noexcept { Modint ans(*this); operator++(); return ans; }
    constexpr Modint operator-() const noexcept { return Modint(0) -= *this; }
    constexpr Modint& operator-=(Modint x) noexcept { if(num < x.num) num += mod; num -= x.num; return *this; }
    constexpr Modint& operator--() noexcept { if(num == 0) num = mod - 1; else num--; return *this; }
    constexpr Modint operator--(int) noexcept { Modint ans(*this); operator--(); return ans; }
    constexpr Modint& operator*=(Modint x) noexcept { num = uint64_t(num) * x.num % mod; return *this; }
    constexpr Modint& operator/=(Modint x) noexcept { return operator*=(x.inv()); }
    constexpr void operator%=(Modint x) noexcept { void(0); }
    template <class T> constexpr Modint(T x) noexcept {
        using U = typename std::conditional<sizeof(T)>= 4, T, int>::type;
        U y = x; y %= U(mod); if(y < 0) y += mod; num = unsigned(y);
    }
    template <class T> constexpr Modint operator+(T x) const noexcept { return Modint(*this) += x; }
    template <class T> constexpr Modint& operator+=(T x) noexcept { return operator+=(Modint(x)); }
    template <class T> constexpr Modint operator-(T x) const noexcept { return Modint(*this) -= x; }
    template <class T> constexpr Modint& operator-=(T x) noexcept { return operator-=(Modint(x)); }
    template <class T> constexpr Modint operator*(T x) const noexcept { return Modint(*this) *= x; }
    template <class T> constexpr Modint& operator*=(T x) noexcept { return operator*=(Modint(x)); }
    template <class T> constexpr Modint operator/(T x) const noexcept { return Modint(*this) /= x; }
    template <class T> constexpr Modint& operator/=(T x) noexcept { return operator/=(Modint(x)); }
    constexpr Modint inv() const noexcept { int64_t x = 0, y = 0; extgcd(num, mod, x, y); return x; }
    static constexpr int64_t extgcd(int64_t a, int64_t b, int64_t &x, int64_t &y) noexcept { int64_t g = a; x = 1; y = 0; if(b){ g = extgcd(b, a % b, y, x); y -= a / b * x; } return g; }
    constexpr Modint pow(uint64_t x) const noexcept { Modint ans = 1, cnt = *this; while(x){ if(x & 1) ans *= cnt; cnt *= cnt; x /= 2; } return ans; }
    friend std::ostream& operator<<(std::ostream& os, const Modint& m){ os << m.num; return os; }
    friend std::istream &operator>>(std::istream &is, Modint &a) {
        int64_t t;
        is >> t;
        a = Modint(t);
        return (is);
    }
};
template <class mint> struct Comb {
private:
    std::vector<mint> fac{1}, inv{1};
    inline void reserve(uint64_t a) noexcept {
        if(std::ssize(fac) >= a) {
            return;
        }
        if(a < std::ssize(fac) * 2) {
            a = std::ssize(fac) * 2;
        }
        if(a >= mint::get_mod()) {
            a = mint::get_mod();
        }
        while(std::ssize(fac) < a) {
            fac.emplace_back(fac.back() * mint(std::ssize(fac)));
        }
        inv.resize(std::ssize(fac));
        inv.back() = fac.back().inv();
        for(const auto i: std::views::iota(0, std::ssize(inv)) | std::views::reverse) {
            inv[i - 1] = inv[i] * i;
        }
    }
public:
    inline mint fact(const int64_t n) noexcept {
        if(n < 0) {
            return 0;
        }
        reserve(n + 1);
        return fac[n];
    }
    inline mint nPr(int64_t n, const int64_t r) noexcept {
        if(r < 0 || n < r) {
            return 0;
        }
        if(n >> 24) {
            mint ans = 1;
            for(const auto i: std::views::iota(0, r)) {
                ans *= n--;
            }
            return ans;
        }
        reserve(n + 1);
        return fac[n] * inv[n - r];
    }
    inline mint nCr(const int64_t n, int64_t r) noexcept {
        if(r < 0 || n < r) {
            return 0;
        }
        r = std::min(r, n - r);
        reserve(r + 1);
        return nPr(n, r) * inv[r];
    }
    inline mint nHr(const int64_t n, const int64_t r) noexcept {
        if(n == 0 && r == 0) {
            return 1;
        }
        if(n <= 0 || r < 0) {
            return 0;
        }
        return nCr(n + r - 1, r);
    }
};

struct a_mint {
    int val;
    a_mint() : val(0){}
    a_mint(const int64_t x) : val(x >= 0 ? x % get_mod() : (get_mod() - (-x) % get_mod()) % get_mod()){}
    int getmod() { return get_mod(); }
    static int &get_mod() {
        static int mod = 0;
        return mod;
    }
    static void set_mod(int md) { assert(md>0); get_mod() = md; }
    a_mint &operator+=(const a_mint &p) noexcept {
        if((val += p.val) >= get_mod()) {
            val -= get_mod();
        }
        return *this;
    }
    a_mint &operator-=(const a_mint &p) noexcept {
        if((val += get_mod() - p.val) >= get_mod()) {
            val -= get_mod();
        }
        return *this;
    }
    a_mint &operator*=(const a_mint &p) noexcept {
        val = (int)(1LL * val * p.val % get_mod());
        return *this;
    }
    a_mint &operator/=(const a_mint &p) noexcept {
        *this *= p.inv();
        return *this;
    }
    a_mint operator-() const noexcept { return a_mint(-val); }
    a_mint operator+(const a_mint &p) const noexcept { return a_mint(*this) += p; }
    a_mint operator-(const a_mint &p) const noexcept { return a_mint(*this) -= p; }
    a_mint operator*(const a_mint &p) const noexcept { return a_mint(*this) *= p; }
    a_mint operator/(const a_mint &p) const noexcept { return a_mint(*this) /= p; }
    a_mint& operator++() noexcept { if(val == get_mod() - 1){ val = 0; } else { val++; } return *this; }
    a_mint operator++(int) noexcept { a_mint ans(*this); operator++(); return ans; }
    a_mint& operator--() noexcept { if(val == 0){ val = get_mod() - 1; } else { val--; } return *this; }
    a_mint operator--(int) noexcept { a_mint ans(*this); operator--(); return ans; }
    constexpr inline bool operator==(const a_mint &p) const noexcept { return val == p.val; }
    constexpr inline bool operator!=(const a_mint &p) const noexcept { return val != p.val; }
    constexpr inline bool operator!() const noexcept { return val == 0; }
    constexpr inline bool operator<=(const a_mint &p) const noexcept { return val <= p.val; }
    constexpr inline bool operator>=(const a_mint &p) const noexcept { return val >= p.val; }
    constexpr inline bool operator<(const a_mint &p) const noexcept { return val < p.val; }
    constexpr inline bool operator>(const a_mint &p) const noexcept { return val > p.val; }
    inline a_mint inv() const noexcept {
        int a = val, b = get_mod(), u = 1, v = 0, t;
        while(b > 0) {
            t = a / b;
            ::std::swap(a -= t * b, b);
            ::std::swap(u -= t * v, v);
        }
        return a_mint(u);
    }
    inline a_mint pow(int64_t n) const noexcept {
        a_mint ret(1), mul(val);
        while(n > 0) {
            if(n & 1) {
                ret *= mul;
            }
            mul *= mul;
            n >>= 1;
        }
        return ret;
    }
    inline friend ::std::ostream &operator<<(::std::ostream &os, const a_mint &p) noexcept { return os << p.val; }
    inline friend ::std::istream &operator>>(::std::istream &is, a_mint &a) noexcept {
        int64_t t;
        is >> t;
        a = a_mint(t);
        return is;
    }
};
}

/**
 * @brief Modint
 * @docs docs/Modint.md
 * @see https://atcoder.jp/contests/arc151/submissions/35526971
 */