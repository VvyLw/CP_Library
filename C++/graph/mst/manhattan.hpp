#pragma once

#include <cassert>
#include <map>
#include <numeric>
#include <ranges>
#include "C++/graph/mst/MST.hpp"
namespace man {
template <std::integral T> inline std::vector<edge> manhattan(std::vector<T> x, std::vector<T> y) noexcept {
    assert(std::ssize(x) == std::ssize(y));
    std::vector<edge> ret;
    std::vector<int> id(std::ssize(x));
    std::iota(id.begin(), id.end(), 0);
    for([[maybe_unused]] const auto _: std::views::iota(0, 2)) {
        for([[maybe_unused]] const auto _: std::views::iota(0, 2)) {
            std::ranges::sort(id, [&](const int i, const int j) -> bool { return x[i] + y[i] < x[j] + y[j]; });
            std::map<T, int> idx;
            for(const auto i: id) {
                for(auto it = idx.lower_bound(-y[i]); it != idx.end(); it = idx.erase(it)) {
                    const int j = it->second;
                    if(x[i] - x[j] < y[i] - y[j]) {
                        break;
                    }
                    ret.emplace_back(i, j, -1, std::abs(x[i] - x[j]) + std::abs(y[i] - y[j]));
                }
                idx[-y[i]] = i;
            }
            x.swap(y);
        }
        for(const auto i: std::views::iota(0, std::ssize(x))) {
            x[i] *= -1;
        }
    }
    return ret;
}
}

/**
 * @brief Manhattan MST
 * @see https://ei1333.github.io/library/graph/mst/manhattan-mst.hpp
 */