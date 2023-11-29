#pragma once

#include <vector>
#include <algorithm>
#include <numeric>
typedef long long ll;
typedef unsigned long long ul;
ll gcd(ll _a, ll _b) {
    ull a = abs(_a), b = abs(_b);
    if(a == 0) return b;
    if(b == 0) return a;
    const int shift = __builtin_ctzll(a|b);
    a >>= __builtin_ctzll(a);
    do {
        b >>= bsf(b);
        if (a > b) swap(a, b);
        b -= a;
    } while (b);
    return (a << shift);
}

template<class T, class U>
T pow_mod(T x, U n, T md) {
    T r = 1 % md;
    x %= md;
    while (n) {
        if (n & 1) r = (r * x) % md;
        x = (x * x) % md;
        n >>= 1;
    }
    return r;
}

bool is_prime(ll n) {
    if (n <= 1) return false;
    if (n == 2) return true;
    if (n % 2 == 0) return false;
    ll d = n - 1;
    while (d % 2 == 0) d /= 2;
    for (ll a : {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37}) {
        if (n <= a) break;
        ll t = d;
        ll y = pow_mod<__int128_t>(a, t, n);  // over
        while (t != n - 1 && y != 1 && y != n - 1) {
            y = __int128_t(y) * y % n;  // flow
            t <<= 1;
        }
        if (y != n - 1 && t % 2 == 0) {
            return false;
        }
    }
    return true;
}

ll pollard_single(ll n) {
    if (is_prime(n)) return n;
    if (n % 2 == 0) return 2;
    ll st = 0;
    auto f = [&](ll x) { return (__int128_t(x) * x + st) % n; };
    while (true) {
        st++;
        ll x = st, y = f(x);
        while (true) {
            ll p = gcd((y - x + n), n);
            if (p == 0 || p == n) break;
            if (p != 1) return p;
            x = f(x);
            y = f(f(y));
        }
    }
}

V<ll> pollard(ll n) {
    if (n == 1) return {};
    ll x = pollard_single(n);
    if (x == n) return {x};
    V<ll> le = pollard(x);
    V<ll> ri = pollard(n / x);
    le.insert(le.end(), ri.begin(), ri.end());
    return le;
}