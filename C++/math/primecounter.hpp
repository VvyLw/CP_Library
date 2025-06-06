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
    int64_t sq;
    std::vector<int> prime;
    std::vector<int64_t> prime_sum, primes;
    constexpr inline int64_t p2(const int64_t x, const int64_t y) noexcept {
        if(x < 4) {
            return 0;
        }
        const int64_t a = pi(y), b = pi(kthrooti(x, 2));
        if(a >= b) {
            return 0;
        }
        int64_t sum = (a - 2) * (a + 1) / 2 - (b - 2) * (b + 1) / 2;
        for(const auto i: std::views::iota(a, b)) {
            sum += pi(x / primes[i]);
        }
        return sum;
    }
    constexpr inline int64_t phi(const int64_t m, const int64_t n) noexcept {
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
            const int64_t sx = pi(kthrooti(m, 2));
            int64_t ans = pi(m) - (sx + n - 2) * (sx - n + 1) / 2;
            for(const auto i: std::views::iota(n, sx)) {
                ans += pi(m / primes[i]);
            }
            return ans;
        }
        return phi(m, n - 1) - phi(m / primes[n - 1], n - 1);
    }
public:
    p_count(const int64_t lim): sq(kthrooti(lim, 2)), prime_sum(sq + 1) {
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
    inline int64_t pi(const int64_t n) noexcept {
        if(n <= sq) {
            return prime_sum[n];
        }
        const int64_t m = kthrooti(n, 3);
        const int64_t a = pi(m);
        return phi(n, a) + a - 1 - p2(n, m);
    }
};
}

/**
 * @brief 素数の個数
 */