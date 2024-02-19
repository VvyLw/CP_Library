#pragma once

#include <cassert>
#include <map>
#include <numeric>
#include "graph/mst/MST.hpp"
template <class T> inline std::vector<edge> manhattan(std::vector<T> x, std::vector<T> y) {
    assert(x.size() == y.size());
    std::vector<edge> res;
    std::vector<int> id(x.size());
    std::iota(id.begin(), id.end(), 0);
    for(int s = 0; s < 2; ++s) {
        for(int t = 0; t < 2; ++t) {
            std::sort(id.begin(), id.end(), [&](const int i, const int j){ return x[i] + y[i] < x[j] + y[j]; });
            std::map<T, int> idx;
            for(const auto i: id) {
                for(auto it = idx.lower_bound(-y[i]); it != idx.end(); it = idx.erase(it)) {
                    const int j = it -> second;
                    if(x[i] - x[j] < y[i] - y[j]) {
                        break;
                    }
                    res.emplace_back(i, j, -1, std::abs(x[i] - x[j]) + std::abs(y[i] - y[j]));
                }
                idx[-y[i]] = i;
            }
            x.swap(y);
        }
        for(size_t i = 0; i < x.size(); ++i) {
            x[i] *= -1;
        }
    }
    return res;
}

/**
 * @brief Manhattan MST
 * @see https://ei1333.github.io/library/graph/mst/manhattan-mst.hpp
 */