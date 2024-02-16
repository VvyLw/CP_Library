---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/lazysegtree.test.cpp
    title: test/lazysegtree.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/lazysegtree2.test.cpp
    title: test/lazysegtree2.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/lazysegtree3.test.cpp
    title: test/lazysegtree3.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/lazysegtree4.test.cpp
    title: test/lazysegtree4.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/lazysegtree5.test.cpp
    title: test/lazysegtree5.test.cpp
  - icon: ':heavy_check_mark:'
    path: test/rangeaffine.test.cpp
    title: test/rangeaffine.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: "\u9045\u5EF6\u30BB\u30B0\u6728"
    links:
    - https://ei1333.github.io/library/structure/segment-tree/lazy-segment-tree.hpp
  bundledCode: "#line 2 \"C++/LazySegmentTree.hpp\"\n\n#include <ostream>\n#include\
    \ <cassert>\n#include <vector>\n#include <functional>\ntemplate <class T, class\
    \ U> struct LazySegTree {\nprivate:\n    using F = std::function<T(T, T)>;\n \
    \   using M = std::function<T(T, U)>;\n    using C = std::function<U(U, U)>;\n\
    \    int n, sz, h;\n    std::vector<T> data;\n    std::vector<U> lazy;\n    const\
    \ F f;\n    const M map;\n    const C comp;\n    const T e;\n    const U id;\n\
    \    inline void update(const int k){ data[k] = f(data[2 * k], data[2 * k + 1]);\
    \ }\n    inline void all_apply(const int k, const U &x) {\n        data[k] = map(data[k],\
    \ x);\n        if(k < sz) {\n            lazy[k] = comp(lazy[k], x);\n       \
    \ }\n    }\n    inline void propagate(const int k) {\n        if(lazy[k] != id)\
    \ {\n            all_apply(2 * k, lazy[k]);\n            all_apply(2 * k + 1,\
    \ lazy[k]);\n            lazy[k] = id;\n        }\n    }\npublic:\n    LazySegTree(const\
    \ int n, const F &f, const M &map, const C &comp, const T &e, const U &id): n(n),\
    \ f(f), map(map), comp(comp), e(e), id(id) {\n        sz = 1;\n        h = 0;\n\
    \        while(sz < n) {\n            sz <<= 1;\n            h++;\n        }\n\
    \        data.assign(2 * sz, e);\n        lazy.assign(2 * sz, id);\n    }\n  \
    \  LazySegTree(const std::vector<T> &v, const F &f, const M &map, const C &comp,\
    \ const T &e, const U &id): LazySegTree(v.size(), f, map, comp, e, id){ build(v);\
    \ }\n    void build(const std::vector<T> &v) {\n        assert(n == (int) v.size());\n\
    \        for(int k = 0; k < n; ++k) {\n            data[k + sz] = v[k];\n    \
    \    }\n        for(int k = sz; --k > 0;) {\n            update(k);\n        }\n\
    \    }\n    void set(int k, const T &x) {\n        k += sz;\n        for(int i\
    \ = h; i > 0; i--) {\n            propagate(k >> i);\n        }\n        data[k]\
    \ = x;\n        for(int i = 0; ++i <= h;) {\n            update(k >> i);\n   \
    \     }\n    }\n    T &operator[](int k) {\n        k += sz;\n        for(int\
    \ i = h; i > 0; i--) {\n            propagate(k >> i);\n        }\n        return\
    \ data[k];\n    }\n    T const& operator[](const int k) const { return data[k\
    \ + sz]; }\n    T query(int l, int r) {\n        if(l >= r) {\n            return\
    \ e;\n        }\n        l += sz;\n        r += sz;\n        for(int i = h; i\
    \ > 0; i--) {\n            if(((l >> i) << i) != l) {\n                propagate(l\
    \ >> i);\n            }\n            if(((r >> i) << i) != r) {\n            \
    \    propagate((r - 1) >> i);\n            }\n        }\n        T L = e, R =\
    \ e;\n        for(; l < r; l >>= 1, r >>= 1) {\n            if(l & 1) {\n    \
    \            L = f(L, data[l++]);\n            }\n            if(r & 1) {\n  \
    \              R = f(data[--r], R);\n            }\n        }\n        return\
    \ f(L, R);\n    }\n    T all() const { return data[1]; }\n    void apply(int k,\
    \ const U &x) {\n        k += sz;\n        for(int i = h; i > 0; i--) {\n    \
    \        propagate(k >> i);\n        }\n        data[k] = map(data[k], x);\n \
    \       for(int i = 0; ++i <= h;) {\n            update(k >> i);\n        }\n\
    \    }\n    void apply(int l, int r, const U &x) {\n        if(l >= r) {\n   \
    \         return;\n        }\n        l += sz;\n        r += sz;\n        for(int\
    \ i = h; i > 0; i--) {\n            if(((l >> i) << i) != l) {\n             \
    \   propagate(l >> i);\n            }\n            if(((r >> i) << i) != r) {\n\
    \                propagate((r - 1) >> i);\n            }\n        }\n        int\
    \ l2 = l, r2 = r;\n        for(; l < r; l >>= 1, r >>= 1) {\n            if(l\
    \ & 1) {\n                all_apply(l++, x);\n            }\n            if(r\
    \ & 1) {\n                all_apply(--r, x);\n            }\n        }\n     \
    \   l = l2, r = r2;\n        for(int i = 0; ++i <= h;) {\n            if(((l >>\
    \ i) << i) != l) {\n                update(l >> i);\n            }\n         \
    \   if(((r >> i) << i) != r) {\n                update((r - 1) >> i);\n      \
    \      }\n        }\n    }\n    inline int size() const { return n; }\n    template\
    \ <class Boolean> int find_first(int l, const Boolean &fn) {\n        if(l >=\
    \ n) {\n            return n;\n        }\n        l += sz;\n        for(int i\
    \ = h; i > 0; i--) {\n            propagate(l >> i);\n        }\n        T sum\
    \ = e;\n        do {\n            while((l & 1) == 0) {\n                l >>=\
    \ 1;\n            }\n            if(fn(f(sum, data[l]))) {\n                while(l\
    \ < sz) {\n                    propagate(l);\n                    l <<= 1;\n \
    \                   const auto nxt = f(sum, data[l]);\n                    if(!fn(nxt))\
    \ {\n                        sum = nxt;\n                        l++;\n      \
    \              }\n                }\n                return l + 1 - sz;\n    \
    \        }\n            sum = f(sum, data[l++]);\n        } while((l & -l) !=\
    \ l);\n        return n;\n    }\n    template <class Boolean> int find_last(int\
    \ r, const Boolean &fn) {\n        if(r <= 0) {\n            return -1;\n    \
    \    }\n        r += sz;\n        for(int i = h; i > 0; i--) {\n            propagate((r\
    \ - 1) >> i);\n        }\n        T sum = e;\n        do {\n            r--;\n\
    \            while(r > 1 && r & 1) {\n                r >>= 1;\n            }\n\
    \            if(fn(f(data[r], sum))) {\n                while(r < sz) {\n    \
    \                propagate(r);\n                    r = (r << 1) + 1;\n      \
    \              const auto nxt = f(data[r], sum);\n                    if(!fn(nxt))\
    \ {\n                        sum = nxt;\n                        r--;\n      \
    \              }\n                }\n                return r - sz;\n        \
    \    }\n            sum = f(data[r], sum);\n        } while((r & -r) != r);\n\
    \        return -1;\n    }\n    void clear(){ std::fill(data.cbegin(), data.cend(),\
    \ e); }\n    friend std::ostream &operator<<(std::ostream &os, const LazySegTree\
    \ &seg) {\n        os << seg[0];\n        for(int i = 0; ++i < seg.size();) {\n\
    \            os << ' ' << seg[i];\n        }\n        return os;\n    }\n};\n\n\
    \n#include <cmath>\n#include <limits>\n\ntemplate <class T> struct zwei {\n  \
    \  T first, second;\n    zwei(){}\n    zwei(const T &f, const T &s): first(f),\
    \ second(s){}\n    constexpr bool operator!=(const zwei<T> &z) noexcept { return\
    \ first != z.first || second != z.second; }\n    operator T(){ return first; }\n\
    \    friend std::ostream &operator<<(std::ostream &os, const zwei &z) {\n    \
    \    os << z.first;\n        return os;\n    }\n};\n\ntemplate <class T> struct\
    \ RAMX: LazySegTree<T, T> {    \n    RAMX(const std::vector<T> &v): LazySegTree<T,\
    \ T>(v, [](const T a, const T b){ return std::max(a, b); }, [](const T a, const\
    \ T b){ return a + b; }, [](const T a, const T b){ return a + b; }, std::numeric_limits<T>::min(),\
    \ 0){}\n};\ntemplate <class T> struct RAMN: LazySegTree<T, T> {\n    RAMN(const\
    \ std::vector<T> &v): LazySegTree<T, T>(v, [](const T a, const T b){ return std::min(a,\
    \ b); }, [](const T a, const T b){ return a + b; }, [](const T a, const T b){\
    \ return a + b; }, std::numeric_limits<T>::max(), 0){}\n};\ntemplate <class T>\
    \ struct RASM: LazySegTree<zwei<T>, T> {\n    RASM(const std::vector<T> &v): LazySegTree<zwei<T>,\
    \ T>(v.size(), [](const zwei<T> a, const zwei<T> b){ return zwei<T>(a.first +\
    \ b.first, a.second + b.second); }, [](const zwei<T> a, const T b){ return zwei<T>(a.first\
    \ + a.second * b, a.second); }, [](const T a, const T b){ return a + b; }, zwei<T>(0,\
    \ 0), 0) {\n        std::vector<zwei<T>> w(v.size());\n        for(size_t i =\
    \ 0; i < v.size(); ++i) {\n            w[i] = zwei<T>(v[i], 1);\n        }\n \
    \       LazySegTree<zwei<T>, T>::build(w);\n    }\n};\ntemplate <class T> struct\
    \ RUMX: LazySegTree<T, T> {    \n    RUMX(const std::vector<T> &v): LazySegTree<T,\
    \ T>(v, [](const T a, const T b){ return std::max(a, b); }, [](const T, const\
    \ T b){ return b; }, [](const T, const T b){ return b; }, std::numeric_limits<T>::min(),\
    \ std::numeric_limits<T>::min()){}\n};\ntemplate <class T> struct RUMN: LazySegTree<T,\
    \ T> {\n    RUMN(const std::vector<T> &v): LazySegTree<T, T>(v, [](const T a,\
    \ const T b){ return std::min(a, b); }, [](const T, const T b){ return b; }, [](const\
    \ T, const T b){ return b; }, std::numeric_limits<T>::max(), std::numeric_limits<T>::max()){}\n\
    };\ntemplate <class T> struct RUSM: LazySegTree<zwei<T>, T> {\n    RUSM(const\
    \ std::vector<T> &v): LazySegTree<zwei<T>, T>(v.size(), [](const zwei<T> a, const\
    \ zwei<T> b){ return zwei<T>(a.first + b.first, a.second + b.second); }, [](const\
    \ zwei<T> a, const T b){ return zwei<T>(a.second * b, a.second); }, [](const T\
    \ a, const T b){ return b; }, zwei<T>(0, 0), std::numeric_limits<T>::min()) {\n\
    \        std::vector<zwei<T>> w(v.size());\n        for(size_t i = 0; i < v.size();\
    \ ++i) {\n            w[i] = zwei<T>(v[i], 1);\n        }\n        LazySegTree<zwei<T>,\
    \ T>::build(w);\n    }\n};\n\n/**\n * @brief \u9045\u5EF6\u30BB\u30B0\u6728\n\
    \ * @see https://ei1333.github.io/library/structure/segment-tree/lazy-segment-tree.hpp\n\
    \ */\n"
  code: "#pragma once\n\n#include <ostream>\n#include <cassert>\n#include <vector>\n\
    #include <functional>\ntemplate <class T, class U> struct LazySegTree {\nprivate:\n\
    \    using F = std::function<T(T, T)>;\n    using M = std::function<T(T, U)>;\n\
    \    using C = std::function<U(U, U)>;\n    int n, sz, h;\n    std::vector<T>\
    \ data;\n    std::vector<U> lazy;\n    const F f;\n    const M map;\n    const\
    \ C comp;\n    const T e;\n    const U id;\n    inline void update(const int k){\
    \ data[k] = f(data[2 * k], data[2 * k + 1]); }\n    inline void all_apply(const\
    \ int k, const U &x) {\n        data[k] = map(data[k], x);\n        if(k < sz)\
    \ {\n            lazy[k] = comp(lazy[k], x);\n        }\n    }\n    inline void\
    \ propagate(const int k) {\n        if(lazy[k] != id) {\n            all_apply(2\
    \ * k, lazy[k]);\n            all_apply(2 * k + 1, lazy[k]);\n            lazy[k]\
    \ = id;\n        }\n    }\npublic:\n    LazySegTree(const int n, const F &f, const\
    \ M &map, const C &comp, const T &e, const U &id): n(n), f(f), map(map), comp(comp),\
    \ e(e), id(id) {\n        sz = 1;\n        h = 0;\n        while(sz < n) {\n \
    \           sz <<= 1;\n            h++;\n        }\n        data.assign(2 * sz,\
    \ e);\n        lazy.assign(2 * sz, id);\n    }\n    LazySegTree(const std::vector<T>\
    \ &v, const F &f, const M &map, const C &comp, const T &e, const U &id): LazySegTree(v.size(),\
    \ f, map, comp, e, id){ build(v); }\n    void build(const std::vector<T> &v) {\n\
    \        assert(n == (int) v.size());\n        for(int k = 0; k < n; ++k) {\n\
    \            data[k + sz] = v[k];\n        }\n        for(int k = sz; --k > 0;)\
    \ {\n            update(k);\n        }\n    }\n    void set(int k, const T &x)\
    \ {\n        k += sz;\n        for(int i = h; i > 0; i--) {\n            propagate(k\
    \ >> i);\n        }\n        data[k] = x;\n        for(int i = 0; ++i <= h;) {\n\
    \            update(k >> i);\n        }\n    }\n    T &operator[](int k) {\n \
    \       k += sz;\n        for(int i = h; i > 0; i--) {\n            propagate(k\
    \ >> i);\n        }\n        return data[k];\n    }\n    T const& operator[](const\
    \ int k) const { return data[k + sz]; }\n    T query(int l, int r) {\n       \
    \ if(l >= r) {\n            return e;\n        }\n        l += sz;\n        r\
    \ += sz;\n        for(int i = h; i > 0; i--) {\n            if(((l >> i) << i)\
    \ != l) {\n                propagate(l >> i);\n            }\n            if(((r\
    \ >> i) << i) != r) {\n                propagate((r - 1) >> i);\n            }\n\
    \        }\n        T L = e, R = e;\n        for(; l < r; l >>= 1, r >>= 1) {\n\
    \            if(l & 1) {\n                L = f(L, data[l++]);\n            }\n\
    \            if(r & 1) {\n                R = f(data[--r], R);\n            }\n\
    \        }\n        return f(L, R);\n    }\n    T all() const { return data[1];\
    \ }\n    void apply(int k, const U &x) {\n        k += sz;\n        for(int i\
    \ = h; i > 0; i--) {\n            propagate(k >> i);\n        }\n        data[k]\
    \ = map(data[k], x);\n        for(int i = 0; ++i <= h;) {\n            update(k\
    \ >> i);\n        }\n    }\n    void apply(int l, int r, const U &x) {\n     \
    \   if(l >= r) {\n            return;\n        }\n        l += sz;\n        r\
    \ += sz;\n        for(int i = h; i > 0; i--) {\n            if(((l >> i) << i)\
    \ != l) {\n                propagate(l >> i);\n            }\n            if(((r\
    \ >> i) << i) != r) {\n                propagate((r - 1) >> i);\n            }\n\
    \        }\n        int l2 = l, r2 = r;\n        for(; l < r; l >>= 1, r >>= 1)\
    \ {\n            if(l & 1) {\n                all_apply(l++, x);\n           \
    \ }\n            if(r & 1) {\n                all_apply(--r, x);\n           \
    \ }\n        }\n        l = l2, r = r2;\n        for(int i = 0; ++i <= h;) {\n\
    \            if(((l >> i) << i) != l) {\n                update(l >> i);\n   \
    \         }\n            if(((r >> i) << i) != r) {\n                update((r\
    \ - 1) >> i);\n            }\n        }\n    }\n    inline int size() const {\
    \ return n; }\n    template <class Boolean> int find_first(int l, const Boolean\
    \ &fn) {\n        if(l >= n) {\n            return n;\n        }\n        l +=\
    \ sz;\n        for(int i = h; i > 0; i--) {\n            propagate(l >> i);\n\
    \        }\n        T sum = e;\n        do {\n            while((l & 1) == 0)\
    \ {\n                l >>= 1;\n            }\n            if(fn(f(sum, data[l])))\
    \ {\n                while(l < sz) {\n                    propagate(l);\n    \
    \                l <<= 1;\n                    const auto nxt = f(sum, data[l]);\n\
    \                    if(!fn(nxt)) {\n                        sum = nxt;\n    \
    \                    l++;\n                    }\n                }\n        \
    \        return l + 1 - sz;\n            }\n            sum = f(sum, data[l++]);\n\
    \        } while((l & -l) != l);\n        return n;\n    }\n    template <class\
    \ Boolean> int find_last(int r, const Boolean &fn) {\n        if(r <= 0) {\n \
    \           return -1;\n        }\n        r += sz;\n        for(int i = h; i\
    \ > 0; i--) {\n            propagate((r - 1) >> i);\n        }\n        T sum\
    \ = e;\n        do {\n            r--;\n            while(r > 1 && r & 1) {\n\
    \                r >>= 1;\n            }\n            if(fn(f(data[r], sum)))\
    \ {\n                while(r < sz) {\n                    propagate(r);\n    \
    \                r = (r << 1) + 1;\n                    const auto nxt = f(data[r],\
    \ sum);\n                    if(!fn(nxt)) {\n                        sum = nxt;\n\
    \                        r--;\n                    }\n                }\n    \
    \            return r - sz;\n            }\n            sum = f(data[r], sum);\n\
    \        } while((r & -r) != r);\n        return -1;\n    }\n    void clear(){\
    \ std::fill(data.cbegin(), data.cend(), e); }\n    friend std::ostream &operator<<(std::ostream\
    \ &os, const LazySegTree &seg) {\n        os << seg[0];\n        for(int i = 0;\
    \ ++i < seg.size();) {\n            os << ' ' << seg[i];\n        }\n        return\
    \ os;\n    }\n};\n\n\n#include <cmath>\n#include <limits>\n\ntemplate <class T>\
    \ struct zwei {\n    T first, second;\n    zwei(){}\n    zwei(const T &f, const\
    \ T &s): first(f), second(s){}\n    constexpr bool operator!=(const zwei<T> &z)\
    \ noexcept { return first != z.first || second != z.second; }\n    operator T(){\
    \ return first; }\n    friend std::ostream &operator<<(std::ostream &os, const\
    \ zwei &z) {\n        os << z.first;\n        return os;\n    }\n};\n\ntemplate\
    \ <class T> struct RAMX: LazySegTree<T, T> {    \n    RAMX(const std::vector<T>\
    \ &v): LazySegTree<T, T>(v, [](const T a, const T b){ return std::max(a, b); },\
    \ [](const T a, const T b){ return a + b; }, [](const T a, const T b){ return\
    \ a + b; }, std::numeric_limits<T>::min(), 0){}\n};\ntemplate <class T> struct\
    \ RAMN: LazySegTree<T, T> {\n    RAMN(const std::vector<T> &v): LazySegTree<T,\
    \ T>(v, [](const T a, const T b){ return std::min(a, b); }, [](const T a, const\
    \ T b){ return a + b; }, [](const T a, const T b){ return a + b; }, std::numeric_limits<T>::max(),\
    \ 0){}\n};\ntemplate <class T> struct RASM: LazySegTree<zwei<T>, T> {\n    RASM(const\
    \ std::vector<T> &v): LazySegTree<zwei<T>, T>(v.size(), [](const zwei<T> a, const\
    \ zwei<T> b){ return zwei<T>(a.first + b.first, a.second + b.second); }, [](const\
    \ zwei<T> a, const T b){ return zwei<T>(a.first + a.second * b, a.second); },\
    \ [](const T a, const T b){ return a + b; }, zwei<T>(0, 0), 0) {\n        std::vector<zwei<T>>\
    \ w(v.size());\n        for(size_t i = 0; i < v.size(); ++i) {\n            w[i]\
    \ = zwei<T>(v[i], 1);\n        }\n        LazySegTree<zwei<T>, T>::build(w);\n\
    \    }\n};\ntemplate <class T> struct RUMX: LazySegTree<T, T> {    \n    RUMX(const\
    \ std::vector<T> &v): LazySegTree<T, T>(v, [](const T a, const T b){ return std::max(a,\
    \ b); }, [](const T, const T b){ return b; }, [](const T, const T b){ return b;\
    \ }, std::numeric_limits<T>::min(), std::numeric_limits<T>::min()){}\n};\ntemplate\
    \ <class T> struct RUMN: LazySegTree<T, T> {\n    RUMN(const std::vector<T> &v):\
    \ LazySegTree<T, T>(v, [](const T a, const T b){ return std::min(a, b); }, [](const\
    \ T, const T b){ return b; }, [](const T, const T b){ return b; }, std::numeric_limits<T>::max(),\
    \ std::numeric_limits<T>::max()){}\n};\ntemplate <class T> struct RUSM: LazySegTree<zwei<T>,\
    \ T> {\n    RUSM(const std::vector<T> &v): LazySegTree<zwei<T>, T>(v.size(), [](const\
    \ zwei<T> a, const zwei<T> b){ return zwei<T>(a.first + b.first, a.second + b.second);\
    \ }, [](const zwei<T> a, const T b){ return zwei<T>(a.second * b, a.second); },\
    \ [](const T a, const T b){ return b; }, zwei<T>(0, 0), std::numeric_limits<T>::min())\
    \ {\n        std::vector<zwei<T>> w(v.size());\n        for(size_t i = 0; i <\
    \ v.size(); ++i) {\n            w[i] = zwei<T>(v[i], 1);\n        }\n        LazySegTree<zwei<T>,\
    \ T>::build(w);\n    }\n};\n\n/**\n * @brief \u9045\u5EF6\u30BB\u30B0\u6728\n\
    \ * @see https://ei1333.github.io/library/structure/segment-tree/lazy-segment-tree.hpp\n\
    \ */"
  dependsOn: []
  isVerificationFile: false
  path: C++/LazySegmentTree.hpp
  requiredBy: []
  timestamp: '2024-02-16 12:14:01+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/rangeaffine.test.cpp
  - test/lazysegtree.test.cpp
  - test/lazysegtree3.test.cpp
  - test/lazysegtree4.test.cpp
  - test/lazysegtree5.test.cpp
  - test/lazysegtree2.test.cpp
documentation_of: C++/LazySegmentTree.hpp
layout: document
redirect_from:
- /library/C++/LazySegmentTree.hpp
- /library/C++/LazySegmentTree.hpp.html
title: "\u9045\u5EF6\u30BB\u30B0\u6728"
---
