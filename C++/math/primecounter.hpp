#pragma once

#include <vector>
#include "C++/math/kthrooti.hpp"
#include "C++/math/primetable.hpp"
#ifndef TEMPLATE
typedef long long ll;
namespace zia_qu {
template <class T> inline T sqr(const T x){ return x*x; }
template <class T> inline T cub(const T x){ return x*x*x; }
}
#endif
struct p_count {
private:
    ll sq;
    std::vector<bool> prime;
    std::vector<ll> prime_sum, primes;
    ll p2(const ll x, const ll y) {
        if(x < 4) {
            return 0;
        }
        const ll a = pi(y), b = pi(Heileden::kthrooti(x, 2));
        if(a >= b) {
            return 0;
        }
        ll sum = (a - 2) * (a + 1) / 2 - (b - 2) * (b + 1) / 2;
        for(ll i = a; i < b; ++i) {
            sum += pi(x / primes[i]);
        }
        return sum;
    }
    ll phi(const ll m, const ll n) {
        if(m < 1) {
            return 0;
        }
        if(n > m) {
            return 1;
        }
        if(n < 1) {
            return m;
        }
        if(m <= zia_qu::sqr(primes[n - 1])) {
            return pi(m) - n + 1;
        }
        if(m <= zia_qu::cub(primes[n - 1]) && m <= sq) {
            const ll sx = pi(Heileden::kthrooti(m, 2));
            ll ans = pi(m) - (sx + n - 2) * (sx - n + 1) / 2;
            for(ll i = n; i < sx; ++i) {
                ans += pi(m / primes[i]);
            }
            return ans;
        }
        return phi(m, n - 1) - phi(m / primes[n - 1], n - 1);
    }
public:
    p_count(const ll lim): sq(Heileden::kthrooti(lim, 2)), prime_sum(sq + 1) {
        prime = Heileden::p_table(sq).SoE;
        for(int i = 1; i <= sq; ++i) {
            prime_sum[i] = prime_sum[i - 1] + prime[i];
        }
        primes.reserve(prime_sum[sq]);
        for(int i = 1; i <= sq; ++i) {
            if(prime[i]) {
                primes.emplace_back(i);
            }
        }
    }
    ll pi(const ll n) {
        if(n <= sq) {
            return prime_sum[n];
        }
        const ll m = Heileden::kthrooti(n, 3);
        const ll a = pi(m);
        return phi(n, a) + a - 1 - p2(n, m);
    }
};

/**
 * @brief 素数の個数
 */