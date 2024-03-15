#pragma once

#include <cassert>
#include <utility>
#include <limits>
#ifndef TEMPLATE
typedef long double ld;
#endif
template <class T> inline std::pair<ld, ld> intersection(const std::pair<T, T> &a, const T sec1, const std::pair<T, T> &b, const T sec2) {
    ld m1, m2, b1, b2;
    if(a.first == 0 && b.first == 0) {
        return {std::numeric_limits<T>::min(), std::numeric_limits<T>::max()};
    } else if(a.second == 0) {
        m2 = (ld) -b.first / b.second;
        b2 = (ld) -sec2 / b.second;
        const ld x = (ld) -sec1 / a.first, y = b2 + m2 * x; 
        return {x, y};
    } else if(b.second == 0) {
        m1 = (ld) -a.first / a.second;
        b1 = (ld) -sec1 / a.second;
        const ld x = (ld) -sec2 / b.first, y = b1 + m1 * x;
        return {x, y};
    }
    m1 = (ld) -a.first / a.second;
    m2 = (ld) -b.first / b.second;
    b1 = (ld) -sec1 / a.second;
    b2 = (ld) -sec2 / b.second;
    assert(m1 != m2);
    const ld x = (b1 - b2) / (m2 - m1), y = m1 * x + b1;
    return {x, y};
}

/**
 * @brief 交点
 */