#pragma once
#include <cassert>
#include <vector>
#include <algorithm>
#include <chrono>
typedef long long ll;
typedef unsigned long long ul;
typedef __uint128_t u128;

std::vector<int> manacher(std::string s, const bool calc_even = true) {
    int n = s.size();
    if(calc_even) {
        assert(n > 0);
        s.resize(2 * n - 1);
        for(int i = n; --i >= 0;) {
            s[2 * i] = s[i];
        }
        const auto d = *std::min_element(s.begin(), s.end());
        for(int i = 0; i < n - 1; ++i) {
            s[2 * i + 1] = d;
        }
    }
    n = s.size();
    std::vector<int> rad(n);
    for(int i = 0, j = 0; i < n;) {
        while(i - j >= 0 && i + j < n && s[i - j] == s[i + j]) {
            ++j;
        }
        rad[i] = j;
        int k = 1;
        while(i - k >= 0 && i + k < n && k + rad[i - k] < j) {
            rad[i + k] = rad[i - k];
            ++k;
        }
        i += k, j -= k;
    }
    if(calc_even) {
        for(int i = 0; i < n; ++i) {
            if(((i ^ rad[i]) & 1) == 0) {
                rad[i]--;
            }
        }
    }
    else {
        for(auto &x: rad) x = 2 * x - 1;
    }
    return rad;
}

std::vector<ll> zalg(const std::string &s) {
    const ll n = s.size();
    ll j = 0;
    std::vector<ll> pre(n);
    for(ll i = 1; i < n; ++i) {
        if(i + pre[i - j] < j + pre[j]) pre[i] = pre[i - j];
        else {
            ll k = std::max(0LL, j + pre[j] - i);
            while(i + k < n && s[k] == s[i + k]) ++k;
            pre[i] = k;
            j = i;
        }
    }
    pre.front() = n;
    return pre;
}

/*vector<ll> SA(const string &s) {
    const ll n = s.size();
    sort(s.begin(), s.end());
}//*/

// inspired by tatyam(https://github.com/tatyam-prime/kyopro_library/blob/master/RollingHash.cpp)
const ul LINF = (1LL << 61) - 1, base = std::chrono::duration_cast<std::chrono::microseconds>(std::chrono::system_clock::now().time_since_epoch()).count() % LINF;
template <ul mod> struct RollingHash {
    std::vector<ul> hashed, power;
    static constexpr ul mask(const ll a){ return (1ULL << a) - 1; }
    inline ul mul(const ul a, const ul b) const {
        u128 ans = u128(a) * b;
        ans = (ans >> 61) + (ans & mod);
        if(ans >= mod) ans -= mod;
        return ans;
    }
    RollingHash(const std::string &s) {
        const ll n = s.size();
        hashed.resize(n + 1);
        power.resize(n + 1);
        power[0] = 1;
        for(ll i = 0; i < n; ++i) {
            power[i + 1] = mul(power[i], base);
            hashed[i + 1] = mul(hashed[i], base) + s[i];
            if(hashed[i + 1] >= mod) hashed[i + 1] -= mod;
        }
    }
    ul get(const ll l, const ll r) const {
        ul ret = hashed[r] + mod - mul(hashed[l], power[r - l]);
        if(ret >= mod) ret -= mod;
        return ret;
    }
    ul connect(const ul h1, const ul h2, const ll h2len) const {
        ul ret = mul(h1, power[h2len]) + h2;
        if(ret >= mod) ret -= mod;
        return ret;
    }
    void connect(const std::string &s){
        const ll n = hashed.size() - 1, m = s.size();
        hashed.resize(n + m + 1);
        power.resize(n + m + 1);
        for(ll i = n; i < n + m; ++i) {
            power[i + 1] = mul(power[i], base);
            hashed[i + 1] = mul(hashed[i], base) + s[i - n];
            if(hashed[i + 1] >= mod) hashed[i + 1] -= mod;
        }
    }
    ll LCP(const RollingHash &b, ll l1, ll r1, ll l2, ll r2) {
        ll low = -1, high = std::min(r1 - l1, r2 - l2) + 1;
        while(high - low > 1) {
            const ll mid = (low + high) / 2;
            if(get(l1, l1 + mid) == b.get(l2, l2 + mid)) low = mid;
            else high = mid;
        }
        return low;
    }
};
using RH = RollingHash<LINF>;