#pragma once

#include <vector>
#include <algorithm>

namespace man {
template <class T = long long> struct SegmentTreeBeats {
private:
    static constexpr int64_t INF = (1LL << 61) - 1;
    struct Node {
        int64_t sum = 0, g1 = 0, l1 = 0, g2 = -INF, gc = 1, l2 = INF, lc = 1, add = 0;
    };
    std::vector<Node> v;
    int n, log;
    constexpr inline void update(const int k) noexcept {
        Node& p = v[k], l = v[k * 2 + 0], r = v[k * 2 + 1];
        p.sum = l.sum + r.sum;
        if(l.g1 == r.g1) {
            p.g1 = l.g1;
            p.g2 = std::max(l.g2, r.g2);
            p.gc = l.gc + r.gc;
        } else {
            const bool f = l.g1 > r.g1;
            p.g1 = f ? l.g1 : r.g1;
            p.gc = f ? l.gc : r.gc;
            p.g2 = std::max(f ? r.g1 : l.g1, f ? l.g2 : r.g2);
        }
        if(l.l1 == r.l1) {
            p.l1 = l.l1;
            p.l2 = std::min(l.l2, r.l2);
            p.lc = l.lc + r.lc;
        } else {
            const bool f = l.l1 < r.l1;
            p.l1 = f ? l.l1 : r.l1;
            p.lc = f ? l.lc : r.lc;
            p.l2 = std::min(f ? r.l1 : l.l1, f ? l.l2 : r.l2);
        }
    }
    constexpr inline void push_add(const int k, const int64_t x) noexcept {
        Node& p = v[k];
        p.sum += x << (log + __builtin_clz(k) - 31);
        p.g1 += x;
        p.l1 += x;
        if(p.g2 != -INF) {
            p.g2 += x;
        }
        if(p.l2 != INF) {
            p.l2 += x;
        }
        p.add += x;
    }
    constexpr inline void push_min(const int k, const int64_t x) noexcept {
        Node& p = v[k];
        p.sum += (x - p.g1) * p.gc;
        if(p.l1 == p.g1) {
            p.l1 = x;
        }
        if(p.l2 == p.g1) {
            p.l2 = x;
        }
        p.g1 = x;
    }
    constexpr inline void push_max(const int k, const int64_t x) noexcept {
        Node& p = v[k];
        p.sum += (x - p.l1) * p.lc;
        if(p.g1 == p.l1) {
            p.g1 = x;
        }
        if(p.g2 == p.l1) {
            p.g2 = x;
        }
        p.l1 = x;
    }
    constexpr inline void push(const int k) noexcept {
        Node& p = v[k];
        if(p.add != 0) {
            push_add(k * 2 + 0, p.add);
            push_add(k * 2 + 1, p.add);
            p.add = 0;
        }
        if(p.g1 < v[k * 2 + 0].g1) {
            push_min(k * 2 + 0, p.g1);
        }
        if(p.l1 > v[k * 2 + 0].l1) {
            push_max(k * 2 + 0, p.l1);
        }
        if(p.g1 < v[k * 2 + 1].g1) {
            push_min(k * 2 + 1, p.g1);
        }
        if(p.l1 > v[k * 2 + 1].l1) {
            push_max(k * 2 + 1, p.l1);
        }
    }
    constexpr inline void subtree_chmin(const int k, const int64_t x) noexcept {
        if(v[k].g1 <= x) {
            return;
        }
        if(v[k].g2 < x) {
            push_min(k, x);
            return;
        }
        push(k);
        subtree_chmin(k * 2 + 0, x);
        subtree_chmin(k * 2 + 1, x);
        update(k);
    }
    constexpr inline void subtree_chmax(const int k, const int64_t x) noexcept {
        if(x <= v[k].l1) {
            return;
        }
        if(x < v[k].l2) {
            push_max(k, x);
            return;
        }
        push(k);
        subtree_chmax(k * 2 + 0, x);
        subtree_chmax(k * 2 + 1, x);
        update(k);
    }
    template <int cmd> constexpr inline void _apply(const int k, const int64_t x) noexcept {
        if constexpr (cmd == 1) {
            subtree_chmin(k, x);
        }
        if constexpr (cmd == 2) {
            subtree_chmax(k, x);
        }
        if constexpr (cmd == 3) {
            push_add(k, x);
        }
        if constexpr (cmd == 4) {
            subtree_chmin(k, x);
            subtree_chmax(k, x);
        }
    }
    template <int cmd> void inner_apply(int l, int r, const int64_t x) {
        if(l == r) {
            return;
        }
        l += n, r += n;
        for(int i = log; i >= 1; i--) {
            if(((l >> i) << i) != l) {
                push(l >> i);
            }
            if(((r >> i) << i) != r) {
                push((r - 1) >> i);
            }
        }
        {
            int l2 = l, r2 = r;
            while(l < r) {
                if(l & 1) {
                    _apply<cmd>(l++, x);
                }
                if(r & 1) {
                    _apply<cmd>(--r, x);
                }
                l >>= 1;
                r >>= 1;
            }
            l = l2;
            r = r2;
        }
        for(int i = 1; i <= log; ++i) {
            if(((l >> i) << i) != l) {
                update(l >> i);
            }
            if(((r >> i) << i) != r) {
                update((r - 1) >> i);
            }
        }
    }
    template <int cmd> constexpr inline int64_t e() noexcept {
        if constexpr (cmd == 1) {
            return INF;
        }
        if constexpr (cmd == 2) {
            return -INF;
        }
        return 0;
    }
    template <int cmd> constexpr inline void op(int64_t& a, const Node& b) noexcept {
        if constexpr (cmd == 1) {
            a = min(a, b.l1);
        }
        if constexpr (cmd == 2) {
            a = max(a, b.g1);
        }
        if constexpr (cmd == 3) {
            a += b.sum;
        }
    }
    template <int cmd> constexpr inline int64_t inner_fold(int l, int r) noexcept {
        if(l == r) {
            return e<cmd>();
        }
        l += n, r += n;
        for(int i = log; i >= 1; i--) {
            if(((l >> i) << i) != l) {
                push(l >> i);
            }
            if(((r >> i) << i) != r) {
                push((r - 1) >> i);
            }
        }
        int64_t lx = e<cmd>(), rx = e<cmd>();
        while(l < r) {
            if(l & 1) {
                op<cmd>(lx, v[l++]);
            }
            if(r & 1) {
                op<cmd>(rx, v[--r]);
            }
            l >>= 1;
            r >>= 1;
        }
        if constexpr (cmd == 1) {
            lx = std::min(lx, rx);
        }
        if constexpr (cmd == 2) {
            lx = std::max(lx, rx);
        }
        if constexpr (cmd == 3) {
            lx += rx;
        }
        return lx;
    }
public:
    SegmentTreeBeats(const int n): SegmentTreeBeats(std::vector<T>(n)){}
    SegmentTreeBeats(const std::vector<T> &a) {
        const int m = a.size();
        n = 1, log = 0;
        while(n < m) {
            log++;
            n <<= 1;
        }
        v.resize(2 * n);
        for(int i = 0; i < m; ++i) {
            v[i + n].sum = v[i + n].g1 = v[i + n].l1 = a[i];
        }
        for(int i = n; --i >= 0;) {
            update(i);
        }
    }
    constexpr inline void chmin(const int l, const int r, const int64_t x) noexcept { inner_apply<1>(l, r, x); }
    constexpr inline void chmax(const int l, const int r, const int64_t x) noexcept { inner_apply<2>(l, r, x); }
    constexpr inline void add(const int l, const int r, const int64_t x) noexcept { inner_apply<3>(l, r, x); }
    constexpr inline void update(const int l, const int r, const int64_t x) noexcept { inner_apply<4>(l, r, x); }
    constexpr inline int64_t min(const int l, const int r) noexcept { return inner_fold<1>(l, r); }
    constexpr inline int64_t max(const int l, const int r) noexcept{ return inner_fold<2>(l, r); }
    constexpr inline int64_t sum(const int l, const int r) noexcept { return inner_fold<3>(l, r); }
};
}

/**
 * @brief SegmentTreeBeats!
 * @see https://nyaannyaan.github.io/library/segment-tree/segment-tree-beats.hpp
 */