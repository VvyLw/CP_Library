#pragma once

#include <algorithm>
#include "C++/structure/fwtree/FenwickTree.hpp"
template <class T> inline long long inv_num(const std::vector<T> &a) {
    std::vector<std::pair<T, int>> p(a.size());
    for(size_t i = 0; i < a.size(); ++i) {
        p[i] = {a[i], i};
    }
    std::sort(p.begin(), p.end());
    std::vector<int> id(a.size());
    for(size_t i = 0; i < a.size(); ++i) {
        id[p[i].second] = i;
    }
    FenwickTree<T> bit(a.size());
    long long res = 0;
    for(size_t i = 0; i < a.size(); ++i) {
        res += i - bit.sum(id[i]);
        bit.add(id[i], 1);
    }
    return res;
}

/**
 * @brief 転倒数
 */