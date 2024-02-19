#pragma once

#include <vector>
#include <chrono>
#ifndef TEMPLATE
typedef long long ll;
typedef unsigned long long ul;
typedef __uint128_t u128;
constexpr ul LINF = (1LL << 61) - 1;
#endif
const ul base = std::chrono::duration_cast<std::chrono::microseconds>(std::chrono::system_clock::now().time_since_epoch()).count() % LINF;
template <ul mod> struct RollingHash {
private:
    std::vector<ul> hashed, power;
    static constexpr ul mask(const ll a){ return (1ULL << a) - 1; }
    inline ul mul(const ul a, const ul b) const {
        u128 ans = u128(a) * b;
        ans = (ans >> 61) + (ans & mod);
        if(ans >= mod) ans -= mod;
        return ans;
    }
public:
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

/**
 * @brief Rolling Hash
 * @see https://github.com/tatyam-prime/kyopro_library/blob/master/RollingHash.cpp
 */