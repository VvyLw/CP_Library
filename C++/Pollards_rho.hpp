#pragma once

#include <vector>
#include <algorithm>
#include <numeric>
#include <functional>
typedef long long ll;
typedef unsigned long long ul;
typedef __int128_t i128;
ll gcd(const ll _a, const ll _b) {
    ul a = std::abs(_a), b = std::abs(_b);
    if(a == 0) return b;
    if(b == 0) return a;
    const int shift = __builtin_ctzll(a | b);
    a >>= __builtin_ctzll(a);
    do {
        b >>= __builtin_ctzll(b);
        if(a > b) std::swap(a, b);
        b -= a;
    } while(b);
    return a << shift;
}
template <class T, class U> T pow_mod(T x, U n, T md) {
    T r = 1 % md;
    x %= md;
    while(n) {
        if(n & 1) r = (r * x) % md;
        x = (x * x) % md;
        n >>= 1;
    }
    return r;
}
bool is_prime(const ll n) {
    if(n <= 1) return false;
    if(n == 2) return true;
    if(n % 2 == 0) return false;
    ll d = n - 1;
    while(d % 2 == 0) d /= 2;
    for(const ll a : {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37}) {
        if(n <= a) break;
        ll t = d;
        ll y = pow_mod<i128>(a, t, n);
        while (t != n - 1 && y != 1 && y != n - 1) {
            y = i128(y) * y % n;
            t <<= 1;
        }
        if (y != n - 1 && t % 2 == 0) {
            return false;
        }
    }
    return true;
}
ll find(const ll n) {
    if(is_prime(n)) return n;
    if(n % 2 == 0) return 2;
    int st = 0;
    const std::function<ll(ll)> f = [&](const ll x){ return (i128(x) * x + st) % n; };
    while(true) {
        st++;
        ll x = st, y = f(x);
        while (true) {
            ll p = gcd((y - x + n), n);
            if(p == 0 || p == n) break;
            if(p != 1) return p;
            x = f(x);
            y = f(f(y));
        }
    }
}

std::vector<ll> rho(const ll n) {
    if(n == 1) return {};
    const ll x = find(n);
    if(x == n) return {x};
    std::vector<ll> le = rho(x);
    const std::vector<ll> ri = rho(n / x);
    le.insert(le.end(), ri.begin(), ri.end());
    return le;
}
/**
 * @brief Pollard's rho
 * @docs docs/Pollards_rho.md
 */