#pragma once

#include <algorithm>
#include "C++/ds/fwtree/FenwickTree.hpp"
namespace man {
template <std::integral T> constexpr inline long long inv_num(const std::vector<T> &a) noexcept {
    const int n = std::ssize(a);
    std::vector<std::pair<T, int>> p(n);
    for(const auto i: std::views::iota(0, n)) {
        p[i] = {a[i], i};
    }
    std::ranges::sort(p);
    std::vector<int> id(n);
    for(const auto i: std::views::iota(0, n)) {
        id[p[i].second] = i;
    }
    FenwickTree<T> bit(n);
    long long ret = 0;
    for(const auto i: std::views::iota(0, n)) {
        ret += i - bit.sum(id[i]);
        bit.add(id[i], 1);
    }
    return ret;
}
}

/**
 * @brief 転倒数
 */