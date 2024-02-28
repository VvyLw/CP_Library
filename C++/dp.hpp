#pragma once

#include <vector>
#include <utility>
#include <algorithm>
#include <iterator>
#include <limits>
#include <numeric>

template <class T> T knapsack01_v(const std::vector<int> &a, const std::vector<T> &v, const int w) {
    const int n = a.size();
    std::vector dp(w + 1, std::numeric_limits<T>::min());
    dp[0] = 0;
    for(int i = 0; i < n; i++) {
        for(int j = w; j >= a[i]; j--) {
            if(dp[j - a[i]] != std::numeric_limits<T>::min()) {
                if(dp[j - a[i]] + v[i] > dp[j]) {
                    dp[j] = dp[j - a[i]] + v[i];
                }
            }
        }
    }
    return *std::ranges::max_element(dp);
}

template <class T> int knapsack01_w(const std::vector<T> &a, const std::vector<int> &v, const T &w) {
    const int n = a.size();
    const int s = std::accumulate(v.begin(), v.end(), 0);
    std::vector dp(s + 1, w + 1);
    dp[0] = 0;
    for(int i = 0; i < n; i++) {
        for(int j = s; j >= v[i]; j--) {
            dp[j] = std::min(dp[j], dp[j - v[i]] + a[i]);
        }
    }
    int res = 0;
    for(int i = 0; i <= s; i++) {
        if(dp[i] <= w) {
            res = i;
        }
    }
    return res;
}

template <class T> std::vector<T> knapsack_sup_v(const std::vector<int> &a, const std::vector<T> &v, const std::vector<int> &m, const int w, const bool less = false) {
    const int n = a.size();
    std::vector<T> dp(w + 1, std::numeric_limits<T>::min()), deqv(w + 1);
    dp[0] = 0;
    std::vector<int> deq(w + 1);
    for(int i = 0; i < n; ++i) {
        if(a[i] == 0) {
            for(int j = 0; j <= w; ++j) {
                if(dp[j] != std::numeric_limits<T>::min() && (less ? dp[j] + v[i] * m[i] < dp[j] : dp[j] + v[i] * m[i] > dp[j])) {
                    dp[j] = dp[j] + v[i] * m[i];
                }
            }
        } else {
            for(int k = 0; k < a[i]; ++k) {
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

template <class T> T knapsack_sup_w(const std::vector<T> &a, const std::vector<int> &v, const std::vector<T> &m, const T &w) {
    const int n = a.size();
    const int max = *std::ranges::max_element(v);
    if(max == 0) {
        return 0;
    }
    std::vector<int> ma(n);
    std::vector<T> mb(n);
    for(int i = 0; i < n; i++) {
        ma[i] = std::min<int>(m[i], max - 1);
        mb[i] = m[i] - ma[i];
    }
    int sum = 0;
    for(int i = 0; i < n; ++i) {
        sum += ma[i] * v[i];
    }
    std::vector dp = knapsack_sup_v(v, a, ma, sum, true);
    std::vector<int> id(n);
    std::iota(id.begin(), id.end(), 0);
    std::stable_sort(id.begin(), id.end(), [&](const int i, const int j) -> bool { return v[i] * a[j] > v[j] * a[i]; });
    T res = T{};
    for(size_t i = 0; i < dp.size(); ++i) {
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

template <class T> T knapsack(const std::vector<int> &a, const std::vector<T> &v, const int w) {
    const int n = a.size();
    std::vector dp(w + 1, std::numeric_limits<T>::min());
    dp[0] = 0;
    for(int i = 0; i < n; i++) {
        for(int j = a[i]; j <= w; j++) {
            if(dp[j - a[i]] != std::numeric_limits<T>::min()) {
                if(dp[j - a[i]] + v[i] > dp[j]) {
                    dp[j] = dp[j - a[i]] + v[i];
                }
            }
        }
    }
    return *std::ranges::max_element(dp);
}

template <class T> inline std::vector<int> lis(const std::vector<T> &v) {
    const int n = v.size();
    std::vector<std::pair<T, int>> dp;
    std::vector<int> p(n, -1), res;
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