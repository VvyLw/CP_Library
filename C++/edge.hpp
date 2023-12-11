#pragma once

struct edge {
    int src, to;
    long long cost;
    edge(){}
    edge(const int to_): to(to_){}
    edge(const int to_, const long long cost_): to(to_), cost(cost_){}
    edge(const int src_, const int to_, const long long cost_): src(src_), to(to_), cost(cost_){}
};