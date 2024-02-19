#pragma once

#pragma GCC diagnostic ignored "-Wreorder"

#include <cassert>
#include <algorithm>
template <bool is_min = true> struct SkewHeap {
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

/**
 * @brief SkewHeap
 * @see https://ei1333.github.io/library/structure/heap/skew-heap.hpp
 */