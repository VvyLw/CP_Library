#pragma once

#include <vector>
#include <cstdint>
namespace man {
constexpr inline bool miller(const uint64_t n) noexcept;
namespace internal {
constexpr inline uint bsf(const uint64_t n) noexcept { return __builtin_ctzll(n); }
constexpr inline uint64_t gcd(uint64_t a, uint64_t b) noexcept {
    if(a == 0) {
        return b;
    }
    if(b == 0) {
        return a;
    }
    const uint shift = internal::bsf(a | b);
    a >>= internal::bsf(a);
    do {
        b >>= internal::bsf(b);
        if(a > b) {
            std::swap(a, b);
        }
        b -= a;
    } while(b > 0);
    return a << shift;
}
constexpr inline uint64_t mod_pow(const uint64_t a, uint64_t b, const uint64_t mod) noexcept {
    uint64_t r = 1;
    __uint128_t x = a % mod;
    while(b > 0) {
        if(b & 1) {
            r = (__uint128_t(r) * x) % mod;
        }
        x = (__uint128_t(x) * x) % mod;
        b >>= 1;
    }
    return r;
}
constexpr inline uint64_t find(const uint64_t n) noexcept {
    if(miller(n)) {
        return n;
    }
    if(n % 2 == 0) {
        return 2;
    }
    int st = 0;
    const auto f = [&](const uint64_t x) -> uint64_t { return (__uint128_t(x) * x + st) % n; };
    while(true) {
        st++;
        uint64_t x = st, y = f(x);
        while(true) {
            const uint64_t p = gcd(y - x + n, n);
            if(p == 0 || p == n) {
                break;
            }
            if(p != 1) {
                return p;
            }
            x = f(x);
            y = f(f(y));
        }
    }
}
}
constexpr inline bool miller(const uint64_t n) noexcept {
    if(n <= 1) {
        return false;
    }
    if(n == 2) {
        return true;
    }
    if(n % 2 == 0) {
        return false;
    }
    uint64_t d = n - 1;
    while(d % 2 == 0) {
        d /= 2;
    }
    for(const uint a: {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37}) {
        if(n <= a) {
            break;
        }
        uint64_t t = d, y = internal::mod_pow(a, t, n);
        while(t != n - 1 && y != 1 && y != n - 1) {
            y = internal::mod_pow(y, 2, n);
            t <<= 1;
        }
        if(y != n - 1 && t % 2 == 0) {
            return false;
        }
    }
    return true;
}
inline std::vector<uint64_t> rho(const uint64_t n) noexcept {
    if(n == 1) {
        return {};
    }
    const uint64_t x = internal::find(n);
    if(x == n) {
        return {x};
    }
    std::vector<uint64_t> le = rho(x);
    const std::vector<uint64_t> ri = rho(n / x);
    le.insert(le.end(), ri.begin(), ri.end());
    return le;
}
}
/**
 * @brief Pollard's Rho
 * @docs docs/pollard_rho.md
 */