#pragma once
#include <vector>
#include <algorithm>
using namespace std;
typedef long long ll;

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

template <unsigned mod> struct RollingHash {
    vector<unsigned> hashed, power;
    inline unsigned mul(ul a, ul b) const {
        unsigned long long x = a * b;
        unsigned xh = (x >> 32), xl = x, d, m;
        asm("divl %4; \n\t" : "=a" (d), "=d" (m) : "d" (xh), "a" (xl), "r" (mod));
        return m;
    }
    RollingHash(const string &s, uint base = 10007) {
        const ll sz = s.size();
        hashed.assign(sz + 1, 0);
        power.assign(sz + 1, 0);
        power[0] = 1;
        rep(sz) {
            power[i + 1] = mul(power[i], base);
            hashed[i + 1] = mul(hashed[i], base) + s[i];
            if(hashed[i + 1] >= mod) hashed[i + 1] -= mod;
        }
    }
    unsigned get(ll l, ll r) const {
        uint ret = hashed[r] + mod - mul(hashed[l], power[r - l]);
        if(ret >= mod) ret -= mod;
        return ret;
    }
    uint connect(unsigned h1, int h2, int h2len) const {
        uint ret = mul(h1, power[h2len]) + h2;
        if(ret >= mod) ret -= mod;
        return ret;
    }
    int LCP(const RollingHash<mod> &b, ll l1, ll r1, ll l2, ll r2) {
        ll len = min(r1 - l1, r2 - l2);
        ll low = -1, high = len + 1;
        while(high - low > 1) {
            ll mid = (low + high) / 2;
            if(get(l1, l1 + mid) == b.get(l2, l2 + mid)) low = mid;
            else high = mid;
        }
        return low;
    }
};
using RH = RollingHash<M0D>;