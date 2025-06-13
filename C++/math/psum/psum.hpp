#pragma once

#include <vector>
#include <numeric>
namespace man {
template <std::integral T> struct psum {
private:
    int n;
    bool not_built;
    std::vector<long long> s;
public:
    psum(const std::vector<T> &v): s{0} { std::partial_sum(v.cbegin(), v.cend(), std::back_inserter(s)); }
    psum(const int n): n(n), not_built(true), s(n + 1){}
    constexpr inline std::vector<long long> get() const noexcept { return s; }
    // [l, r]
    constexpr inline long long sum(const int l, const int r) const noexcept  { return s[r] - s[l]; }
    constexpr inline void add(const int l, const int r, const long long x = 1) noexcept {
        static_assert(not_built);
        s[l] += x;
        s[r] -= x;
    }
    constexpr inline std::vector<long long> build() noexcept {
        static_assert(not_built);
        std::vector<long long> res;
        std::partial_sum(s.cbegin(), s.cend(), std::back_inserter(res));
        not_built = false;
        res.resize(n);
        return res;
    }
};
}

/**
 * @brief 累積和
 */