#pragma once

#include <cassert>
#include <utility>
#include <limits>
#ifndef ALIAS
namespace internal {
template <typename T> concept num = std::integral<T> || std::floating_point<T>;
}
#endif
namespace man {
template <internal::num T> constexpr inline std::pair<long double, long double> intersection(const std::pair<T, T> &a, const T sec1, const std::pair<T, T> &b, const T sec2) noexcept {
    long double m1, m2, b1, b2;
    if(a.first == 0 && b.first == 0) {
        return {std::numeric_limits<T>::min(), std::numeric_limits<T>::max()};
    } else if(a.second == 0) {
        m2 = (long double) -b.first / b.second;
        b2 = (long double) -sec2 / b.second;
        const long double x = (long double) -sec1 / a.first, y = b2 + m2 * x; 
        return {x, y};
    } else if(b.second == 0) {
        m1 = (long double) -a.first / a.second;
        b1 = (long double) -sec1 / a.second;
        const long double x = (long double) -sec2 / b.first, y = b1 + m1 * x;
        return {x, y};
    }
    m1 = (long double) -a.first / a.second;
    m2 = (long double) -b.first / b.second;
    b1 = (long double) -sec1 / a.second;
    b2 = (long double) -sec2 / b.second;
    assert(m1 != m2);
    const long double x = (b1 - b2) / (m2 - m1), y = m1 * x + b1;
    return {x, y};
}
}

/**
 * @brief 交点
 * @docs docs/intersect.md
 */