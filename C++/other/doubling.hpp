#pragma once

#include <vector>
#include <cmath>
#include <ranges>
namespace man {
template <class T> requires std::ranges::random_access_range<T> constexpr inline std::vector<std::vector<int>> doubling(const T &a, const int64_t k) noexcept {
    const int z = std::ceil(std::log2(k)), n = std::ssize(a);
    std::vector dbl(z, std::vector(n, 0));
    for(const auto &i: std::views::iota(0, n)) {
        dbl.front()[i] = a[i];
    }
    for(const auto &i: std::views::iota(1, z)) {
        for(const auto &j: std::views::iota(0, n)) {
            dbl[i][j] = dbl[i - 1][dbl[i - 1][j]];
        }
    }
    return dbl;
}
}

/**
 * @brief doubling
 * @see https://algo-logic.info/doubling/
 */