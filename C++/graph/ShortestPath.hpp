#pragma once

#pragma GCC diagnostic ignored "-Wreorder"

#include <vector>
#include <algorithm>
namespace man {
struct ShortestPath {
private:
    const std::vector<int64_t> cost;
    const std::vector<int> src;
public:
    ShortestPath(const std::vector<int64_t> &cost, const std::vector<int> &src): cost(cost), src(src){}
    inline bool is_thru(const int i) const noexcept { return src[i] != -1; }
    inline std::vector<int> path(int i) noexcept {
        std::vector<int> ret;
        for(; i != -1; i = src[i]) {
            ret.emplace_back(i);
        }
        std::ranges::reverse(ret);
        return ret;
    }
    inline std::vector<int64_t> get() const noexcept { return cost; }
};
}

/**
 * @brief 最短路
 */