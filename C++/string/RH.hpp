#pragma once

#include <vector>
#include <chrono>
#include <ranges>
namespace man {
#ifndef ALIAS
constexpr long long LINF = (1LL << 61) - 1;
#endif
const unsigned long long base = std::chrono::duration_cast<std::chrono::microseconds>(std::chrono::system_clock::now().time_since_epoch()).count() % LINF;
template <unsigned long long mod> struct RollingHash {
private:
    std::vector<unsigned long long> hashed, power;
    static constexpr inline unsigned long long mask(const long long a) noexcept { return (1ULL << a) - 1; }
    constexpr inline unsigned long long mul(const unsigned long long a, const unsigned long long b) const noexcept {
        __uint128_t ans = __uint128_t(a) * b;
        ans = (ans >> 61) + (ans & mod);
        if(ans >= mod) {
            ans -= mod;
        }
        return ans;
    }
public:
    RollingHash(const std::string &s) {
        const int n = std::ssize(s);
        hashed.resize(n + 1);
        power.resize(n + 1);
        power[0] = 1;
        for(const auto i: std::views::iota(0, n)) {
            power[i + 1] = mul(power[i], base);
            hashed[i + 1] = mul(hashed[i], base) + s[i];
            if(hashed[i + 1] >= mod) {
                hashed[i + 1] -= mod;
            }
        }
    }
    constexpr inline unsigned long long get(const long long l, const long long r) const noexcept {
        unsigned long long ret = hashed[r] + mod - mul(hashed[l], power[r - l]);
        if(ret >= mod) {
            ret -= mod;
        }
        return ret;
    }
    constexpr inline unsigned long long connect(const unsigned long long h1, const unsigned long long h2, const long long h2len) const noexcept {
        unsigned long long ret = mul(h1, power[h2len]) + h2;
        if(ret >= mod) {
            ret -= mod;
        }
        return ret;
    }
    constexpr inline long long LCP(const RollingHash &b, long long l1, long long r1, long long l2, long long r2) noexcept {
        long long low = -1, high = std::min(r1 - l1, r2 - l2) + 1;
        while(high - low > 1) {
            const long long mid = (low + high) / 2;
            if(get(l1, l1 + mid) == b.get(l2, l2 + mid)) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }
};
typedef RollingHash<LINF> RH;
}

/**
 * @brief Rolling Hash
 * @see https://github.com/tatyam-prime/kyopro_library/blob/master/RollingHash.cpp
 */