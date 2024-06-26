---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/segtreebeats.test.cpp
    title: test/segtreebeats.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: SegmentTreeBeats!
    links:
    - https://nyaannyaan.github.io/library/segment-tree/segment-tree-beats.hpp
  bundledCode: "#line 2 \"C++/ds/SegmentTreeBeats.hpp\"\n\n#include <vector>\n#include\
    \ <algorithm>\n\ntemplate <class T> struct SegmentTreeBeats {\nprivate:\n    static\
    \ constexpr int64_t INF = (1LL << 61) - 1;\n    struct Node {\n        int64_t\
    \ sum = 0, g1 = 0, l1 = 0, g2 = -INF, gc = 1, l2 = INF, lc = 1, add = 0;\n   \
    \ };\n    std::vector<Node> v;\n    int n, log;\nprivate:\n    void update(const\
    \ int k) {\n        Node& p = v[k];\n        Node& l = v[k * 2 + 0];\n       \
    \ Node& r = v[k * 2 + 1];\n        p.sum = l.sum + r.sum;\n        if(l.g1 ==\
    \ r.g1) {\n            p.g1 = l.g1;\n            p.g2 = std::max(l.g2, r.g2);\n\
    \            p.gc = l.gc + r.gc;\n        } else {\n            const bool f =\
    \ l.g1 > r.g1;\n            p.g1 = f ? l.g1 : r.g1;\n            p.gc = f ? l.gc\
    \ : r.gc;\n            p.g2 = std::max(f ? r.g1 : l.g1, f ? l.g2 : r.g2);\n  \
    \      }\n        if(l.l1 == r.l1) {\n            p.l1 = l.l1;\n            p.l2\
    \ = std::min(l.l2, r.l2);\n            p.lc = l.lc + r.lc;\n        } else {\n\
    \            const bool f = l.l1 < r.l1;\n            p.l1 = f ? l.l1 : r.l1;\n\
    \            p.lc = f ? l.lc : r.lc;\n            p.l2 = std::min(f ? r.l1 : l.l1,\
    \ f ? l.l2 : r.l2);\n        }\n    }\n    void push_add(const int k, const int64_t\
    \ x) {\n        Node& p = v[k];\n        p.sum += x << (log + __builtin_clz(k)\
    \ - 31);\n        p.g1 += x;\n        p.l1 += x;\n        if(p.g2 != -INF) {\n\
    \            p.g2 += x;\n        }\n        if(p.l2 != INF) {\n            p.l2\
    \ += x;\n        }\n        p.add += x;\n    }\n    void push_min(const int k,\
    \ const int64_t x) {\n        Node& p = v[k];\n        p.sum += (x - p.g1) * p.gc;\n\
    \        if(p.l1 == p.g1) {\n            p.l1 = x;\n        }\n        if(p.l2\
    \ == p.g1) {\n            p.l2 = x;\n        }\n        p.g1 = x;\n    }\n   \
    \ void push_max(const int k, const int64_t x) {\n        Node& p = v[k];\n   \
    \     p.sum += (x - p.l1) * p.lc;\n        if(p.g1 == p.l1) {\n            p.g1\
    \ = x;\n        }\n        if(p.g2 == p.l1) {\n            p.g2 = x;\n       \
    \ }\n        p.l1 = x;\n    }\n    void push(const int k) {\n        Node& p =\
    \ v[k];\n        if(p.add != 0) {\n            push_add(k * 2 + 0, p.add);\n \
    \           push_add(k * 2 + 1, p.add);\n            p.add = 0;\n        }\n \
    \       if(p.g1 < v[k * 2 + 0].g1) {\n            push_min(k * 2 + 0, p.g1);\n\
    \        }\n        if(p.l1 > v[k * 2 + 0].l1) {\n            push_max(k * 2 +\
    \ 0, p.l1);\n        }\n        if(p.g1 < v[k * 2 + 1].g1) {\n            push_min(k\
    \ * 2 + 1, p.g1);\n        }\n        if(p.l1 > v[k * 2 + 1].l1) {\n         \
    \   push_max(k * 2 + 1, p.l1);\n        }\n    }\n    void subtree_chmin(const\
    \ int k, const int64_t x) {\n        if(v[k].g1 <= x) {\n            return;\n\
    \        }\n        if(v[k].g2 < x) {\n            push_min(k, x);\n         \
    \   return;\n        }\n        push(k);\n        subtree_chmin(k * 2 + 0, x);\n\
    \        subtree_chmin(k * 2 + 1, x);\n        update(k);\n    }\n    void subtree_chmax(const\
    \ int k, const int64_t x) {\n        if(x <= v[k].l1) {\n            return;\n\
    \        }\n        if(x < v[k].l2) {\n            push_max(k, x);\n         \
    \   return;\n        }\n        push(k);\n        subtree_chmax(k * 2 + 0, x);\n\
    \        subtree_chmax(k * 2 + 1, x);\n        update(k);\n    }\n    template\
    \ <int cmd> inline void _apply(const int k, const int64_t x) {\n        if constexpr\
    \ (cmd == 1) {\n            subtree_chmin(k, x);\n        }\n        if constexpr\
    \ (cmd == 2) {\n            subtree_chmax(k, x);\n        }\n        if constexpr\
    \ (cmd == 3) {\n            push_add(k, x);\n        }\n        if constexpr (cmd\
    \ == 4) {\n            subtree_chmin(k, x);\n            subtree_chmax(k, x);\n\
    \        }\n    }\n    template <int cmd> void inner_apply(int l, int r, const\
    \ int64_t x) {\n        if(l == r) {\n            return;\n        }\n       \
    \ l += n, r += n;\n        for(int i = log; i >= 1; i--) {\n            if(((l\
    \ >> i) << i) != l) {\n                push(l >> i);\n            }\n        \
    \    if(((r >> i) << i) != r) {\n                push((r - 1) >> i);\n       \
    \     }\n        }\n        {\n            int l2 = l, r2 = r;\n            while\
    \ (l < r) {\n                if (l & 1) {\n                    _apply<cmd>(l++,\
    \ x);\n                }\n                if (r & 1) {\n                    _apply<cmd>(--r,\
    \ x);\n                }\n                l >>= 1;\n                r >>= 1;\n\
    \            }\n            l = l2;\n            r = r2;\n        }\n        for(int\
    \ i = 1; i <= log; ++i) {\n            if(((l >> i) << i) != l) {\n          \
    \      update(l >> i);\n            }\n            if(((r >> i) << i) != r) {\n\
    \                update((r - 1) >> i);\n            }\n        }\n    }\n    template\
    \ <int cmd> inline int64_t e() {\n        if constexpr (cmd == 1) {\n        \
    \    return INF;\n        }\n        if constexpr (cmd == 2) {\n            return\
    \ -INF;\n        }\n        return 0;\n    }\n\n    template <int cmd> inline\
    \ void op(int64_t& a, const Node& b) {\n        if constexpr (cmd == 1) {\n  \
    \          a = min(a, b.l1);\n        }\n        if constexpr (cmd == 2) {\n \
    \           a = max(a, b.g1);\n        }\n        if constexpr (cmd == 3) {\n\
    \            a += b.sum;\n        }\n    }\n    template <int cmd> int64_t inner_fold(int\
    \ l, int r) {\n        if(l == r) {\n            return e<cmd>();\n        }\n\
    \        l += n, r += n;\n        for(int i = log; i >= 1; i--) {\n          \
    \  if(((l >> i) << i) != l) {\n                push(l >> i);\n            }\n\
    \            if(((r >> i) << i) != r) {\n                push((r - 1) >> i);\n\
    \            }\n        }\n        int64_t lx = e<cmd>(), rx = e<cmd>();\n   \
    \     while(l < r) {\n            if(l & 1) {\n                op<cmd>(lx, v[l++]);\n\
    \            }\n            if(r & 1) {\n                op<cmd>(rx, v[--r]);\n\
    \            }\n            l >>= 1;\n            r >>= 1;\n        }\n      \
    \  if constexpr (cmd == 1) {\n            lx = std::min(lx, rx);\n        }\n\
    \        if constexpr (cmd == 2) {\n            lx = std::max(lx, rx);\n     \
    \   }\n        if constexpr (cmd == 3) {\n            lx += rx;\n        }\n \
    \       return lx;\n    }\npublic:\n    SegmentTreeBeats(const int n): SegmentTreeBeats(std::vector<int64_t>(n)){}\n\
    \    SegmentTreeBeats(const std::vector<T> &a) {\n        const int m = a.size();\n\
    \        n = 1, log = 0;\n        while(n < m) {\n            log++;\n       \
    \     n <<= 1;\n        }\n        v.resize(2 * n);\n        for(int i = 0; i\
    \ < m; ++i) {\n            v[i + n].sum = v[i + n].g1 = v[i + n].l1 = a[i];\n\
    \        }\n        for(int i = n; --i >= 0;) {\n            update(i);\n    \
    \    }\n    }\n    void chmin(const int l, const int r, const int64_t x) noexcept\
    \ { inner_apply<1>(l, r, x); }\n    void chmax(const int l, const int r, const\
    \ int64_t x) noexcept { inner_apply<2>(l, r, x); }\n    void add(const int l,\
    \ const int r, const int64_t x) noexcept { inner_apply<3>(l, r, x); }\n    void\
    \ update(const int l, const int r, const int64_t x) noexcept { inner_apply<4>(l,\
    \ r, x); }\n    int64_t min(const int l, const int r) noexcept { return inner_fold<1>(l,\
    \ r); }\n    int64_t max(const int l, const int r) noexcept{ return inner_fold<2>(l,\
    \ r); }\n    int64_t sum(const int l, const int r) noexcept { return inner_fold<3>(l,\
    \ r); }\n};\n\n/**\n * @brief SegmentTreeBeats!\n * @see https://nyaannyaan.github.io/library/segment-tree/segment-tree-beats.hpp\n\
    \ */\n"
  code: "#pragma once\n\n#include <vector>\n#include <algorithm>\n\ntemplate <class\
    \ T> struct SegmentTreeBeats {\nprivate:\n    static constexpr int64_t INF = (1LL\
    \ << 61) - 1;\n    struct Node {\n        int64_t sum = 0, g1 = 0, l1 = 0, g2\
    \ = -INF, gc = 1, l2 = INF, lc = 1, add = 0;\n    };\n    std::vector<Node> v;\n\
    \    int n, log;\nprivate:\n    void update(const int k) {\n        Node& p =\
    \ v[k];\n        Node& l = v[k * 2 + 0];\n        Node& r = v[k * 2 + 1];\n  \
    \      p.sum = l.sum + r.sum;\n        if(l.g1 == r.g1) {\n            p.g1 =\
    \ l.g1;\n            p.g2 = std::max(l.g2, r.g2);\n            p.gc = l.gc + r.gc;\n\
    \        } else {\n            const bool f = l.g1 > r.g1;\n            p.g1 =\
    \ f ? l.g1 : r.g1;\n            p.gc = f ? l.gc : r.gc;\n            p.g2 = std::max(f\
    \ ? r.g1 : l.g1, f ? l.g2 : r.g2);\n        }\n        if(l.l1 == r.l1) {\n  \
    \          p.l1 = l.l1;\n            p.l2 = std::min(l.l2, r.l2);\n          \
    \  p.lc = l.lc + r.lc;\n        } else {\n            const bool f = l.l1 < r.l1;\n\
    \            p.l1 = f ? l.l1 : r.l1;\n            p.lc = f ? l.lc : r.lc;\n  \
    \          p.l2 = std::min(f ? r.l1 : l.l1, f ? l.l2 : r.l2);\n        }\n   \
    \ }\n    void push_add(const int k, const int64_t x) {\n        Node& p = v[k];\n\
    \        p.sum += x << (log + __builtin_clz(k) - 31);\n        p.g1 += x;\n  \
    \      p.l1 += x;\n        if(p.g2 != -INF) {\n            p.g2 += x;\n      \
    \  }\n        if(p.l2 != INF) {\n            p.l2 += x;\n        }\n        p.add\
    \ += x;\n    }\n    void push_min(const int k, const int64_t x) {\n        Node&\
    \ p = v[k];\n        p.sum += (x - p.g1) * p.gc;\n        if(p.l1 == p.g1) {\n\
    \            p.l1 = x;\n        }\n        if(p.l2 == p.g1) {\n            p.l2\
    \ = x;\n        }\n        p.g1 = x;\n    }\n    void push_max(const int k, const\
    \ int64_t x) {\n        Node& p = v[k];\n        p.sum += (x - p.l1) * p.lc;\n\
    \        if(p.g1 == p.l1) {\n            p.g1 = x;\n        }\n        if(p.g2\
    \ == p.l1) {\n            p.g2 = x;\n        }\n        p.l1 = x;\n    }\n   \
    \ void push(const int k) {\n        Node& p = v[k];\n        if(p.add != 0) {\n\
    \            push_add(k * 2 + 0, p.add);\n            push_add(k * 2 + 1, p.add);\n\
    \            p.add = 0;\n        }\n        if(p.g1 < v[k * 2 + 0].g1) {\n   \
    \         push_min(k * 2 + 0, p.g1);\n        }\n        if(p.l1 > v[k * 2 + 0].l1)\
    \ {\n            push_max(k * 2 + 0, p.l1);\n        }\n        if(p.g1 < v[k\
    \ * 2 + 1].g1) {\n            push_min(k * 2 + 1, p.g1);\n        }\n        if(p.l1\
    \ > v[k * 2 + 1].l1) {\n            push_max(k * 2 + 1, p.l1);\n        }\n  \
    \  }\n    void subtree_chmin(const int k, const int64_t x) {\n        if(v[k].g1\
    \ <= x) {\n            return;\n        }\n        if(v[k].g2 < x) {\n       \
    \     push_min(k, x);\n            return;\n        }\n        push(k);\n    \
    \    subtree_chmin(k * 2 + 0, x);\n        subtree_chmin(k * 2 + 1, x);\n    \
    \    update(k);\n    }\n    void subtree_chmax(const int k, const int64_t x) {\n\
    \        if(x <= v[k].l1) {\n            return;\n        }\n        if(x < v[k].l2)\
    \ {\n            push_max(k, x);\n            return;\n        }\n        push(k);\n\
    \        subtree_chmax(k * 2 + 0, x);\n        subtree_chmax(k * 2 + 1, x);\n\
    \        update(k);\n    }\n    template <int cmd> inline void _apply(const int\
    \ k, const int64_t x) {\n        if constexpr (cmd == 1) {\n            subtree_chmin(k,\
    \ x);\n        }\n        if constexpr (cmd == 2) {\n            subtree_chmax(k,\
    \ x);\n        }\n        if constexpr (cmd == 3) {\n            push_add(k, x);\n\
    \        }\n        if constexpr (cmd == 4) {\n            subtree_chmin(k, x);\n\
    \            subtree_chmax(k, x);\n        }\n    }\n    template <int cmd> void\
    \ inner_apply(int l, int r, const int64_t x) {\n        if(l == r) {\n       \
    \     return;\n        }\n        l += n, r += n;\n        for(int i = log; i\
    \ >= 1; i--) {\n            if(((l >> i) << i) != l) {\n                push(l\
    \ >> i);\n            }\n            if(((r >> i) << i) != r) {\n            \
    \    push((r - 1) >> i);\n            }\n        }\n        {\n            int\
    \ l2 = l, r2 = r;\n            while (l < r) {\n                if (l & 1) {\n\
    \                    _apply<cmd>(l++, x);\n                }\n               \
    \ if (r & 1) {\n                    _apply<cmd>(--r, x);\n                }\n\
    \                l >>= 1;\n                r >>= 1;\n            }\n         \
    \   l = l2;\n            r = r2;\n        }\n        for(int i = 1; i <= log;\
    \ ++i) {\n            if(((l >> i) << i) != l) {\n                update(l >>\
    \ i);\n            }\n            if(((r >> i) << i) != r) {\n               \
    \ update((r - 1) >> i);\n            }\n        }\n    }\n    template <int cmd>\
    \ inline int64_t e() {\n        if constexpr (cmd == 1) {\n            return\
    \ INF;\n        }\n        if constexpr (cmd == 2) {\n            return -INF;\n\
    \        }\n        return 0;\n    }\n\n    template <int cmd> inline void op(int64_t&\
    \ a, const Node& b) {\n        if constexpr (cmd == 1) {\n            a = min(a,\
    \ b.l1);\n        }\n        if constexpr (cmd == 2) {\n            a = max(a,\
    \ b.g1);\n        }\n        if constexpr (cmd == 3) {\n            a += b.sum;\n\
    \        }\n    }\n    template <int cmd> int64_t inner_fold(int l, int r) {\n\
    \        if(l == r) {\n            return e<cmd>();\n        }\n        l += n,\
    \ r += n;\n        for(int i = log; i >= 1; i--) {\n            if(((l >> i) <<\
    \ i) != l) {\n                push(l >> i);\n            }\n            if(((r\
    \ >> i) << i) != r) {\n                push((r - 1) >> i);\n            }\n  \
    \      }\n        int64_t lx = e<cmd>(), rx = e<cmd>();\n        while(l < r)\
    \ {\n            if(l & 1) {\n                op<cmd>(lx, v[l++]);\n         \
    \   }\n            if(r & 1) {\n                op<cmd>(rx, v[--r]);\n       \
    \     }\n            l >>= 1;\n            r >>= 1;\n        }\n        if constexpr\
    \ (cmd == 1) {\n            lx = std::min(lx, rx);\n        }\n        if constexpr\
    \ (cmd == 2) {\n            lx = std::max(lx, rx);\n        }\n        if constexpr\
    \ (cmd == 3) {\n            lx += rx;\n        }\n        return lx;\n    }\n\
    public:\n    SegmentTreeBeats(const int n): SegmentTreeBeats(std::vector<int64_t>(n)){}\n\
    \    SegmentTreeBeats(const std::vector<T> &a) {\n        const int m = a.size();\n\
    \        n = 1, log = 0;\n        while(n < m) {\n            log++;\n       \
    \     n <<= 1;\n        }\n        v.resize(2 * n);\n        for(int i = 0; i\
    \ < m; ++i) {\n            v[i + n].sum = v[i + n].g1 = v[i + n].l1 = a[i];\n\
    \        }\n        for(int i = n; --i >= 0;) {\n            update(i);\n    \
    \    }\n    }\n    void chmin(const int l, const int r, const int64_t x) noexcept\
    \ { inner_apply<1>(l, r, x); }\n    void chmax(const int l, const int r, const\
    \ int64_t x) noexcept { inner_apply<2>(l, r, x); }\n    void add(const int l,\
    \ const int r, const int64_t x) noexcept { inner_apply<3>(l, r, x); }\n    void\
    \ update(const int l, const int r, const int64_t x) noexcept { inner_apply<4>(l,\
    \ r, x); }\n    int64_t min(const int l, const int r) noexcept { return inner_fold<1>(l,\
    \ r); }\n    int64_t max(const int l, const int r) noexcept{ return inner_fold<2>(l,\
    \ r); }\n    int64_t sum(const int l, const int r) noexcept { return inner_fold<3>(l,\
    \ r); }\n};\n\n/**\n * @brief SegmentTreeBeats!\n * @see https://nyaannyaan.github.io/library/segment-tree/segment-tree-beats.hpp\n\
    \ */"
  dependsOn: []
  isVerificationFile: false
  path: C++/ds/SegmentTreeBeats.hpp
  requiredBy: []
  timestamp: '2024-06-26 14:59:53+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/segtreebeats.test.cpp
documentation_of: C++/ds/SegmentTreeBeats.hpp
layout: document
redirect_from:
- /library/C++/ds/SegmentTreeBeats.hpp
- /library/C++/ds/SegmentTreeBeats.hpp.html
title: SegmentTreeBeats!
---
