#pragma once

#include <vector>
#include <utility>
#include <algorithm>
#include <iterator>
template <class T> inline std::vector<int> lis(const std::vector<T> &v) {
    const int n = v.size();
    std::vector<std::pair<T, int>> dp;
    std::vector<int> p(n, -1);
    for(int i = 0; i < n; ++i) {
        const auto it = std::ranges::lower_bound(dp, std::make_pair(v[i], -i));
        if(it != dp.begin()) {
            p[i] = -prev(it) -> second;
        }
        if(it == dp.end()) {
            dp.emplace_back(std::make_pair(v[i], -i));
        } else {
            *it = std::make_pair(v[i], -i);
        }
    }
    std::vector<int> res;
    for(int i = -dp.back().second; i != -1; i = p[i]) {
        res.emplace_back(i);
    }
    std::ranges::reverse(res);
    return res;
}
/**
 * @brief Longest Increasing Subsequence
 * @see https://nyaannyaan.github.io/library/dp/longest-increasing-sequence.hpp
 */