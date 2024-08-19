#pragma once

#include <vector>
#include <cmath>
template <class T, typename std::enable_if<std::is_same<T, std::vector<typename T::value_type>>::value || std::is_same<T, std::valarray<typename T::value_type>>::value, std::nullptr_t>::type = nullptr>
constexpr inline std::vector<std::vector<int>> doubling(const T &a, const int64_t k) noexcept {
    const int z = std::ceil(std::log2(k)), n = a.size();
    std::vector dbl(z, std::vector(n, 0));
    for(int i = 0; i < n; ++i) {
        dbl.front()[i] = a[i];
    }
    for(int i = 0; ++i < z;) {
        for(int j = 0; j < n; ++j) {
            dbl[i][j] = dbl[i - 1][dbl[i - 1][j]];
        }
    }
    return dbl;
}

/**
 * @brief doubling
 * @see https://algo-logic.info/doubling/
 */