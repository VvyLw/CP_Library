#pragma once

#include <vector>
#include <ranges>
namespace man {
inline std::vector<int> zalg(const std::string &s) noexcept {
    const int n = std::ssize(s);
    int j = 0;
    std::vector<int> pre(n);
    for(const auto i: std::views::iota(1, n)) {
        if(i + pre[i - j] < j + pre[j]) {
            pre[i] = pre[i - j];
        } else {
            int k = std::max(0, j + pre[j] - i);
            while(i + k < n && s[k] == s[i + k]) {
                ++k;
            }
            pre[i] = k;
            j = i;
        }
    }
    pre.front() = n;
    return pre;
}
}

/**
 * @brief Z-Algorithm
 */