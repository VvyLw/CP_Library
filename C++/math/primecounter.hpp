#pragma once

#include <vector>
#include "C++/math/kthrooti.hpp"
#include "C++/math/primetable.hpp"
#ifndef TEMPLATE
namespace man {
template <class T> constexpr inline T sqr(const T x) noexcept { return x * x; }
template <class T> constexpr inline T cub(const T x) noexcept { return x * x * x; }
}
#endif
namespace man {
struct p_count {
private:
    long long sq;
    std::vector<int> prime;
    std::vector<long long> prime_sum, primes;
    constexpr inline long long p2(const long long x, const long long y) noexcept {
        if(x < 4) {
            return 0;
        }
        const long long a = pi(y), b = pi(kthrooti(x, 2));
        if(a >= b) {
            return 0;
        }
        long long sum = (a - 2) * (a + 1) / 2 - (b - 2) * (b + 1) / 2;
        for(const auto i: std::views::iota(a, b)) {
            sum += pi(x / primes[i]);
        }
        return sum;
    }
    constexpr inline long long phi(const long long m, const long long n) noexcept {
        if(m < 1) {
            return 0;
        }
        if(n > m) {
            return 1;
        }
        if(n < 1) {
            return m;
        }
        if(m <= sqr(primes[n - 1])) {
            return pi(m) - n + 1;
        }
        if(m <= cub(primes[n - 1]) && m <= sq) {
            const long long sx = pi(kthrooti(m, 2));
            long long ans = pi(m) - (sx + n - 2) * (sx - n + 1) / 2;
            for(const auto i: std::views::iota(n, sx)) {
                ans += pi(m / primes[i]);
            }
            return ans;
        }
        return phi(m, n - 1) - phi(m / primes[n - 1], n - 1);
    }
public:
    p_count(const long long lim): sq(kthrooti(lim, 2)), prime_sum(sq + 1) {
        prime = p_table(sq).SoE;
        for(const auto i: std::views::iota(1) | std::views::take(sq)) {
            prime_sum[i] = prime_sum[i - 1] + prime[i];
        }
        primes.reserve(prime_sum[sq]);
        for(const auto i: std::views::iota(1) | std::views::take(sq)) {
            if(prime[i]) {
                primes.emplace_back(i);
            }
        }
    }
    inline long long pi(const long long n) noexcept {
        if(n <= sq) {
            return prime_sum[n];
        }
        const long long m = kthrooti(n, 3);
        const long long a = pi(m);
        return phi(n, a) + a - 1 - p2(n, m);
    }
};
}

/**
 * @brief 素数の個数
 */