#pragma once

#include <vector>
std::vector<int> zalg(const std::string &s) {
    const int n = s.size();
    int j = 0;
    std::vector<int> pre(n);
    for(int i = 1; i < n; ++i) {
        if(i + pre[i - j] < j + pre[j]) pre[i] = pre[i - j];
        else {
            int k = std::max(0, j + pre[j] - i);
            while(i + k < n && s[k] == s[i + k]) ++k;
            pre[i] = k;
            j = i;
        }
    }
    pre.front() = n;
    return pre;
}

/**
 * @brief Z-Algorithm
 */