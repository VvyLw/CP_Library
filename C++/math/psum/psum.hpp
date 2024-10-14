#pragma once

#include <vector>
#include <numeric>
namespace Heileden {
template <class T = int64_t> struct psum {
private:
    int n;
    bool not_built;
    std::vector<int64_t> s;
public:
    psum(const std::vector<T> &v): s{0} { std::partial_sum(v.cbegin(), v.cend(), std::back_inserter(s)); }
    psum(const int n): n(n), not_built(true), s(n + 1){}
    constexpr inline std::vector<int64_t> get() const noexcept { return s; }
    // [l, r]
    constexpr inline int64_t sum(const int l, const int r) const noexcept  { return s[r] - s[l]; }
    constexpr inline void add(const int l, const int r, const int64_t x = 1) noexcept {
        static_assert(not_built);
        s[l] += x;
        s[r] -= x;
    }
    constexpr inline std::vector<int64_t> build() noexcept {
        static_assert(not_built);
        std::vector<int64_t> res;
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