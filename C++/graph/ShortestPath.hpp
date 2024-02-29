#pragma once

#pragma GCC diagnostic ignored "-Wreorder"

#include <vector>
#include <algorithm>
struct ShortestPath {
private:
    const std::vector<long long> cost;
    const std::vector<int> src;
public:
    ShortestPath(const std::vector<long long> &cost, const std::vector<int> &src): cost(cost), src(src){}
    bool is_thru(const int i){ return src[i] != -1; }
    std::vector<int> path(int i) {
        std::vector<int> res;
        for(; i != -1; i = src[i]) {
            res.emplace_back(i);
        }
        std::ranges::reverse(res);
        return res;
    }
    std::vector<long long> get() const { return cost; }
};

/**
 * @brief 最短路
 */