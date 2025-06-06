#pragma once

#ifndef ROLLING_HASH
#define ROLLING_HASH
#endif

#include <vector>
#include <chrono>
#include <ranges>
namespace man {
const uint64_t base = std::chrono::duration_cast<std::chrono::microseconds>(std::chrono::system_clock::now().time_since_epoch()).count() % ((1LL << 61) - 1);
template <uint64_t mod> struct RollingHash {
private:
    std::vector<uint64_t> hashed, power;
    static constexpr inline uint64_t mask(const int64_t a) noexcept { return (1ULL << a) - 1; }
    constexpr inline uint64_t mul(const uint64_t a, const uint64_t b) const noexcept {
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
    constexpr inline uint64_t get(const int64_t l, const int64_t r) const noexcept {
        uint64_t ret = hashed[r] + mod - mul(hashed[l], power[r - l]);
        if(ret >= mod) {
            ret -= mod;
        }
        return ret;
    }
    constexpr inline uint64_t connect(const uint64_t h1, const uint64_t h2, const int64_t h2len) const noexcept {
        uint64_t ret = mul(h1, power[h2len]) + h2;
        if(ret >= mod) {
            ret -= mod;
        }
        return ret;
    }
    constexpr inline int64_t LCP(const RollingHash &b, int64_t l1, int64_t r1, int64_t l2, int64_t r2) noexcept {
        int64_t low = -1, high = std::min(r1 - l1, r2 - l2) + 1;
        while(high - low > 1) {
            const int64_t mid = (low + high) / 2;
            if(get(l1, l1 + mid) == b.get(l2, l2 + mid)) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }
};
}

/**
 * @brief Rolling Hash
 * @see https://github.com/tatyam-prime/kyopro_library/blob/master/RollingHash.cpp
 */