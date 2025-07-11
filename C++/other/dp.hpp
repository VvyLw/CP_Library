#pragma once

#include <vector>
#include <utility>
#include <algorithm>
#include <stack>
#include <iterator>
#include <limits>
#include <numeric>
#include <ranges>

namespace man {
template <std::integral T> constexpr inline T knapsack01_v(const std::vector<int> &a, const std::vector<T> &v, const int w) noexcept {
    const int n = std::ssize(a);
    std::vector dp(w + 1, std::numeric_limits<T>::min());
    dp[0] = 0;
    for(const auto i: std::views::iota(0, n)) {
        for(const auto j: std::views::iota(a[i], w + 1) | std::views::reverse) {
            if(dp[j - a[i]] != std::numeric_limits<T>::min()) {
                if(dp[j - a[i]] + v[i] > dp[j]) {
                    dp[j] = dp[j - a[i]] + v[i];
                }
            }
        }
    }
    return *std::ranges::max_element(dp);
}
/**
 * @see https://ei1333.github.io/library/dp/knapsack-01.hpp
 */

template <std::integral T> int knapsack01_w(const std::vector<T> &a, const std::vector<int> &v, const T &w) {
    const int n = std::ssize(a);
    const int s = std::accumulate(v.cbegin(), v.cend(), 0);
    std::vector dp(s + 1, w + 1);
    dp[0] = 0;
    for(const auto i: std::views::iota(0, n)) {
        for(const auto j: std::views::iota(v[i], s + 1) | std::views::reverse) {
            dp[j] = std::min(dp[j], dp[j - v[i]] + a[i]);
        }
    }
    int res = 0;
    for(const auto i: std::views::iota(0, s + 1)) {
        if(dp[i] <= w) {
            res = i;
        }
    }
    return res;
}
/**
 * @see https://ei1333.github.io/library/dp/knapsack-01-2.hpp
 */

template <std::integral T> std::vector<T> knapsack_sup_v(const std::vector<int> &a, const std::vector<T> &v, const std::vector<int> &m, const int w, const bool less = false) {
    const int n = std::ssize(a);
    std::vector<T> dp(w + 1, std::numeric_limits<T>::min()), deqv(w + 1);
    dp[0] = 0;
    std::vector<int> deq(w + 1);
    for(const auto i: std::views::iota(0, n)) {
        if(a[i] == 0) {
            for(const auto j: std::views::iota(0, w + 1)) {
                if(dp[j] != std::numeric_limits<T>::min() && (less ? dp[j] + v[i] * m[i] < dp[j] : dp[j] + v[i] * m[i] > dp[j])) {
                    dp[j] = dp[j] + v[i] * m[i];
                }
            }
        } else {
            for(const auto k: std::views::iota(0, a[i])) {
                int s = 0, t = 0;
                for(int j = 0; a[i] * j + k <= w; ++j) {
                    if(dp[a[i] * j + k] != std::numeric_limits<T>::min()) {
                        const T val = dp[a[i] * j + k] - j * v[i];
                        while(s < t && (less ? val < deqv[t - 1] : val > deqv[t - 1])) {
                            t--;
                        }
                        deq[t] = j;
                        deqv[t++] = val;
                    }
                    if(s < t) {
                        dp[j * a[i] + k] = deqv[s] + j * v[i];
                        if(deq[s] == j - m[i]) {
                            s++;
                        }
                    }
                }
            }
        }
    }
    return dp;
}
/**
 * @see https://ei1333.github.io/library/dp/knapsack-limitations.hpp
 */

template <std::integral T> T knapsack_sup_w(const std::vector<T> &a, const std::vector<int> &v, const std::vector<T> &m, const T &w) {
    const int n = std::ssize(a);
    const int max = *std::ranges::max_element(v);
    if(max == 0) {
        return 0;
    }
    std::vector<int> ma(n);
    std::vector<T> mb(n);
    for(const auto i: std::views::iota(0, n)) {
        ma[i] = std::min<int>(m[i], max - 1);
        mb[i] = m[i] - ma[i];
    }
    int sum = 0;
    for(const auto i: std::views::iota(0, n)) {
        sum += ma[i] * v[i];
    }
    std::vector dp = knapsack_sup_v(v, a, ma, sum, true);
    std::vector<int> id(n);
    std::iota(id.begin(), id.end(), 0);
    std::stable_sort(id.begin(), id.end(), [&](const int i, const int j) -> bool { return v[i] * a[j] > v[j] * a[i]; });
    T res = T{};
    for(const auto i: std::views::iota(0, std::ssize(dp))) {
        if(dp[i] > w || dp[i] == std::numeric_limits<T>::min()) {
            continue;
        }
        T rest = w - dp[i], cost = i;
        for(const int j: id) {
            const T get = std::min(mb[j], rest / a[j]);
            if(get <= 0) {
                continue;
            }
            cost += get * v[j];
            rest -= get * a[j];
        }
        res = std::max(res, cost);
    }
    return res;
}
/**
 * @see https://ei1333.github.io/library/dp/knapsack-limitations-2.hpp
 */

template <std::integral T> T knapsack(const std::vector<int> &a, const std::vector<T> &v, const int w) {
    const int n = std::ssize(a);
    std::vector dp(w + 1, std::numeric_limits<T>::min());
    dp[0] = 0;
    for(const auto i: std::views::iota(0, n)) {
        for(const auto j: std::views::iota(a[i], w + 1)) {
            if(dp[j - a[i]] != std::numeric_limits<T>::min()) {
                if(dp[j - a[i]] + v[i] > dp[j]) {
                    dp[j] = dp[j - a[i]] + v[i];
                }
            }
        }
    }
    return *std::ranges::max_element(dp);
}
/**
 * @see https://ei1333.github.io/library/dp/knapsack.hpp
 */

template <std::integral T> inline long long max_rectangle(std::vector<T> h) {
    h.resize(std::ssize(h) + 1);
    std::stack<size_t> sk;
    std::vector<int> l(std::ssize(h));
    long long ret = 0;
    for(const auto i: std::views::iota(0, std::ssize(h))) {
        while(!sk.empty() && h[sk.top()] >= h[i]) {
            ret = std::max(ret, static_cast<long long>(i - l[sk.top()] - 1) * h[sk.top()]);
            sk.pop();
        }
        l[i] = sk.empty() ? -1 : sk.top();
        sk.emplace(i);
    }
    return ret;
}
/**
 * @see https://ei1333.github.io/library/dp/largest-rectangle.hpp
 */

inline int lcs(const std::string &s, const std::string &t) {
    const int n = std::ssize(s);
    std::vector<int> dp(n + 1), ndp(n + 1);
    for(const auto i: std::views::iota(0, std::ssize(t))) {
        for(const auto j: std::views::iota(0, n)) {
            if(s[j] == t[i]) {
                ndp[j + 1] = dp[j] + 1;
            } else {
                ndp[j + 1] = std::max(ndp[j], dp[j + 1]);
            }
        }
        dp.swap(ndp);
    }
    return dp[n];
}
/**
 * @see https://maku.blog/p/a3jyhwd/
 */

template <std::integral T> inline std::vector<int> lis(const std::vector<T> &v) {
    const int n = std::ssize(v);
    std::vector<std::pair<T, int>> dp;
    std::vector<int> p(n, -1), ret;
    for(const auto i: std::views::iota(0, n)) {
        const auto it = std::ranges::lower_bound(dp, std::make_pair(v[i], -i));
        if(it != dp.cbegin()) {
            p[i] = -prev(it) -> second;
        }
        if(it == dp.cend()) {
            dp.emplace_back(std::make_pair(v[i], -i));
        } else {
            *it = std::make_pair(v[i], -i);
        }
    }
    for(int i = -dp.back().second; i != -1; i = p[i]) {
        ret.emplace_back(i);
    }
    std::ranges::reverse(ret);
    return ret;
}
/**
 * @see https://nyaannyaan.github.io/library/dp/longest-increasing-sequence.hpp
 */
}

/**
 * @brief DP(Knapsack, LCS, LIS, 最大長方形, coin)
 */