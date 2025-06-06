#pragma once

#include <cassert>
#include <vector>
#include <algorithm>
#include <ranges>
namespace man {
inline std::vector<int> manacher(std::string s, const bool calc_even = true) noexcept {
    int n = std::ssize(s);
    if(calc_even) {
        assert(n > 0);
        s.resize(2 * n - 1);
        for(const auto i: std::views::iota(0, n) | std::views::reverse) {
            s[2 * i] = s[i];
        }
        const auto d = *std::ranges::min_element(s);
        for(const auto i: std::views::iota(0, n - 1)) {
            s[2 * i + 1] = d;
        }
    }
    n = std::ssize(s);
    std::vector<int> rad(n);
    for(int i = 0, j = 0; i < n;) {
        while(i - j >= 0 && i + j < n && s[i - j] == s[i + j]) {
            ++j;
        }
        rad[i] = j;
        int k = 1;
        while(i - k >= 0 && i + k < n && k + rad[i - k] < j) {
            rad[i + k] = rad[i - k];
            ++k;
        }
        i += k, j -= k;
    }
    if(calc_even) {
        for(int i = 0; i < n; ++i) {
            if(((i ^ rad[i]) & 1) == 0) {
                rad[i]--;
            }
        }
    } else {
        for(auto &x: rad) {
            x = 2 * x - 1;
        }
    }
    return rad;
}
}

/**
 * @brief Manacher
 * @see https://ei1333.github.io/library/string/manacher.hpp
 */