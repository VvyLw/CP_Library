#pragma once

#include <vector>
#include <algorithm>
namespace Heileden {
template <class T> inline std::vector<T> div(const T n) {
    std::vector<T> d;
    for(int64_t i = 1; i * i <= n; ++i) {
        if(n % i == 0) {
            d.emplace_back(i);
            if(i * i != n) {
                d.emplace_back(n / i);
            }
        }
    }
    std::ranges::sort(d);
    return d;
}
}

/**
 * @brief 約数列挙
 */