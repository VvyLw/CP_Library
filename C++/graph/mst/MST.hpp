#pragma once

#include <vector>
#include "graph/edge.hpp"
struct MST {
    std::vector<edge> tree;
    long long cost;
};

/**
 * @brief 最小全域木
 */