#pragma once

struct edge {
    int src, to, id;
    long long cost;
    edge(){}
    edge(const int src_, const int to_, const int id_ = -1, const long long cost_ = 0): src(src_), to(to_), id(id_), cost(cost_){}
    operator int() const { return to; }
};

/**
 * @brief Edge
 */