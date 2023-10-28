#pragma once
#include <vector>
#include <algorithm>
using namespace std;
typedef long long ll;
typedef unsigned long long ul;
typedef __uint128_t u128;

vector<ll> manacher(const string &s) {
    const ll n = s.size();
    vector<ll> rad(n);
    ll i=0,j=0;
    while(i < n) {
        while(i - j >= 0 && i +j < n && s[i - j] == s[i + j]) ++j;
        rad[i] = j;
        ll k = 1;
        while(i- k >= 0 && i + k < n && k + rad[i - k] < j) {
            rad[i + k] = rad[i - k];
            ++k;
        }
        i += k;
        j -= k;
    }
    return rad;
}

vector<ll> zalg(const string &s) {
    const ll n = s.size();
    ll j = 0;
    vector<ll> pre(n);
    for(ll i = 1; i < n; ++i) {
        if(i + pre[i - j] < j + pre[j]) pre[i] = pre[i - j];
        else {
            ll k = max(0LL, j + pre[j] - i);
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
const ul mod = (1LL << 61) - 1, base = chrono::duration_cast<chrono::microseconds>(chrono::system_clock::now().time_since_epoch()).count() % mod;
struct RollingHash {
    vector<ul> hashed, power;
    static constexpr ul mask(const ll a){ return (1ULL << a) - 1; }
    inline ul mul(const ul a, const ul b) const {
        u128 ans = u128(a) * b;
        ans = (ans >> 61) + (ans & mod);
        if(ans >= mod) ans -= mod;
        return ans;
    }
    RollingHash(const string &s) {
        const ll n = s.size();
        hashed.assign(n + 1, 0);
        power.assign(n + 1, 0);
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
    void connect(const string &s){
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
        ll low = -1, high = min(r1 - l1, r2 - l2) + 1;
        while(high - low > 1) {
            ll mid = (low + high) / 2;
            if(get(l1, l1 + mid) == b.get(l2, l2 + mid)) low = mid;
            else high = mid;
        }
        return low;
    }
};