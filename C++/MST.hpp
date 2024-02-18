#pragma once

#pragma GCC diagnostic ignored "-Wreorder"

#include <cassert>
#include <map>
#include <numeric>
#include "C++/edge.hpp"
#include "C++/UnionFind.hpp"

struct MST {
    std::vector<edge> tree;
    long long cost;
};

inline MST kruskal(std::vector<edge> edges, const int n) {
    std::sort(edges.begin(), edges.end(), [&](const edge &e, const edge &f){ return e.cost < f.cost; });
    UnionFind uf(n);
    std::vector<edge> e;
    long long res = 0;
    for(const auto &ed: edges) {
        if(uf.unite(ed.src, ed)) {
            e.emplace_back(ed);
            res += ed.cost;
        }
    }
    return MST{e, res};
}
template<bool is_min = true> struct SkewHeap {
    struct Node {
        long long key, lazy;
        Node *l, *r;
        int idx;
        explicit Node(const long long &key, const int idx): key(key), idx(idx), lazy(0), l(nullptr), r(nullptr){}
    };
private:
    Node *alloc(const long long &key, int idx = -1) {
        return new Node(key, idx);
    }
    Node *propagate(Node *t) {
        if(t && t -> lazy != 0) {
            if(t -> l) {
                t -> l -> lazy += t -> lazy;
            }
            if(t -> r) {
                t -> r -> lazy += t -> lazy;
            }
            t -> key += t -> lazy;
            t -> lazy = 0;
        }
        return t;
    }
public:
    SkewHeap(){}
    Node *meld(Node *x, Node *y) {
        propagate(x), propagate(y);
        if(!x || !y) {
            return x ? x : y;
        }
        if((x -> key < y -> key) ^ is_min) {
            std::swap(x, y);
        }
        x -> r = meld(y, x -> r);
        std::swap(x -> l, x -> r);
        return x;
    }
    Node *push(Node *t, const long long &key, int idx = -1){ return meld(t, alloc(key, idx)); }
    Node *pop(Node *t) {
        assert(t);
        return meld(t -> l, t -> r);
    }
    Node *add(Node *t, const long long &lazy) {
        if(t) {
            t -> lazy += lazy;
            propagate(t);
        }
        return t;
    }
};
inline MST directed(std::vector<edge> edges, const int n, const int v) {
    for(int i = 0; i < n; ++i) {
        if(i != v) {
            edges.emplace_back(i, v, 0);
        }
    }
    int x = 0;
    std::vector<int> par(2 * n, -1), vis(par), link(par), st;
    using Node = typename SkewHeap<>::Node;
    SkewHeap heap;
    std::vector<Node*> ins(2 * n, nullptr);
    for(size_t i = 0; i < edges.size(); ++i) {
        const auto &e = edges[i];
        ins[e] = heap.push(ins[e], e.cost, i);
    }
    const auto go = [&](int z) -> int {
        z = edges[ins[z] -> idx].src;
        while(link[z] != -1) {
            st.emplace_back(z);
            z = link[z];
        }
        for(const auto &p : st) {
            link[p] = z;
        }
        st.clear();
        return z;
    };
    for(int i = n; ins[x]; ++i) {
        while(vis[x] == -1) {
            vis[x] = 0;
            x = go(x);
        }
        while(x != i) {
            const auto w = ins[x] -> key;
            auto z = heap.pop(ins[x]);
            z = heap.add(z, -w);
            ins[i] = heap.meld(ins[i], z);
            par[x] = i;
            link[x] = i;
            x = go(x);
        }
        while(ins[x] && go(x) == x) {
            ins[x] = heap.pop(ins[x]);
        }
    }
    for(int i = v; i != -1; i = par[i]) {
		vis[i] = 1;
	}
    long long cost = 0;
    std::vector<edge> e;
    for(int i = x; i >= 0; i--) {
		if(vis[i] == 1) {
			continue;
		}
        cost += edges[ins[i] -> idx].cost;
        e.emplace_back(edges[ins[i] -> idx]);
        for(int j = edges[ins[i] -> idx]; j != -1 && vis[j] == 0; j = par[j]) {
            vis[j] = 1;
        }
    }
    return MST{e, cost};
}
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
 * @brief 最小全域木
 */