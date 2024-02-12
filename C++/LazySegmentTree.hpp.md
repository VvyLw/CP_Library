---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    document_title: "\u9045\u5EF6\u30BB\u30B0\u6728"
    links:
    - https://nyaannyaan.github.io/library/segment-tree/lazy-segment-tree-utility.hpp
  bundledCode: "#line 2 \"C++/LazySegmentTree.hpp\"\n\n#include <ostream>\n#include\
    \ <cassert>\n#include <vector>\n#include <cmath>\n#include <functional>\ntemplate\
    \ <class T, class U> struct LazySegTree {\nprivate:\n    using F = std::function<T(T,\
    \ T)>;\n    using M = std::function<T(T, U)>;\n    using C = std::function<U(U,\
    \ U)>;\n    int n, log, s;\n    std::vector<T> val;\n    std::vector<U> lazy;\n\
    \    const F f;\n    const T e;\n    const M map;\n    const C comp;\n    const\
    \ U id;\n    void push(const int i) {\n        if(lazy[i] != id) {\n         \
    \   val[2 * i + 0] = map(val[2 * i + 0], lazy[i]);\n            val[2 * i + 1]\
    \ = map(val[2 * i + 1], lazy[i]);\n            if(2 * i < n) {\n             \
    \   compose(lazy[2 * i + 0], lazy[i]);\n                compose(lazy[2 * i + 1],\
    \ lazy[i]);\n            }\n            lazy[i] = id;\n        }\n    }\n    inline\
    \ void upd(const int i){ val[i] = f(val[2 * i + 0], val[2 * i + 1]); }\n    inline\
    \ void apply(int i, const U& x) {\n        if(x != id) {\n            val[i] =\
    \ map(val[i], x);\n            if(i < n) {\n                compose(lazy[i], x);\n\
    \            }\n        }\n    }\n    inline void compose(U& a, const U& b){ a\
    \ = a == id ? b : comp(a, b); }\npublic:\n    LazySegTree(const int s, const F\
    \ &f, const M &map, const C &comp, const T e, const U id): s(s), f(f), map(map),\
    \ comp(comp), e(e), id(id){}\n    LazySegTree(const std::vector<T> &v, const F\
    \ &f, const M &map, const C &comp, const T e, const U id): s(v.size()), f(f),\
    \ map(map), comp(comp), e(e), id(id){}\n    void init(const std::vector<T> &v)\
    \ {\n        n = 1, log = 0;\n        while(n < s) {\n            n <<= 1;\n \
    \           log++;\n        }\n        val.resize(2 * n, e);\n        lazy.resize(n,\
    \ id);\n        for(int i = 0; i < s; ++i) {\n            val[i + n] = v[i];\n\
    \        }\n        for(int i = n - 1; i--;) {\n            upd(i);\n        }\n\
    \    }\n    void set(const int k, const U &x){ update(k, k + 1, x); }\n    void\
    \ update(int l, int r, const U& x) {\n        if(l == r) {\n            return;\n\
    \        }\n        l += n, r += n;\n        for(int i = log; i >= 1; i--) {\n\
    \            if(((l >> i) << i) != l) {\n                push(l >> i);\n     \
    \       }\n            if(((r >> i) << i) != r) {\n                push((r - 1)\
    \ >> i);\n            }\n        }\n        for(int p = l, q = r; p < q; p >>=\
    \ 1, q >>= 1) {\n            if(p & 1) {\n                apply(p++, x);\n   \
    \         }\n            if(q & 1) {\n                apply(--q, x);\n       \
    \     }\n        }\n        for(int i = 1; i <= log; ++i) {\n            if(((l\
    \ >> i) << i) != l) {\n                upd(l >> i);\n            }\n         \
    \   if(((r >> i) << i) != r) {\n                upd((r - 1) >> i);\n         \
    \   }\n        }\n    }\n    T query(int l, int r) {\n        if(l == r) {\n \
    \           return e;\n        }\n        l += n, r += n;\n        T L = e, R\
    \ = e;\n        for(int i = log; i >= 1; i--) {\n            if(((l >> i) << i)\
    \ != l) {\n                push(l >> i);\n            }\n            if(((r >>\
    \ i) << i) != r) {\n                push((r - 1) >> i);\n            }\n     \
    \   }\n        while(l < r) {\n            if(l & 1) {\n                L = f(L,\
    \ val[l++]);\n            }\n            if(r & 1) {\n                R = f(val[--r],\
    \ R);\n            }\n            l >>= 1;\n            r >>= 1;\n        }\n\
    \        return f(L, R);\n    }\n    T const& operator[](const int k) const {\
    \ return val[k + n]; }\n    T &operator[](int k) {\n        k += n;\n        for(int\
    \ i = log; i >= 1; i--) {\n            if(((k >> i) << i) != k || (((k + 1) >>\
    \ i) << i) != (k + 1)) {\n                push(k >> i);\n            }\n     \
    \   }\n        return val[k];\n    }\n    inline int size() const { return s;\
    \ }\n    template <class Boolean> int max_right(int l, const Boolean &fn) {\n\
    \        assert(0 <= l && l <= s);\n        assert(fn(id));\n        if(l == n)\
    \ {\n            return n;\n        }\n        l += n;\n        for(int i = log;\
    \ i >= 1; i--) {\n            push(l >> i);\n        }\n        T sm = e;\n  \
    \      do {\n            while(l & 1 == 0) {\n                l >>= 1;\n     \
    \       }\n            if(!fn(f(sm, val[l]))) {\n                while(l < n)\
    \ {\n                    push(l);\n                    l = (2 * l);\n        \
    \            if(fn(f(sm, val[l]))) {\n                        sm = f(sm, val[l]);\n\
    \                        l++;\n                    }\n                }\n    \
    \            return l - n;\n            }\n            sm = f(sm, val[l]);\n \
    \           l++;\n        } while((l & -l) != l);\n        return s;\n    }\n\
    \    template <class Boolean> int min_left(int r, const Boolean &fn) {\n     \
    \   assert(0 <= r && r <= s);\n        assert(fn(id));\n        if(r == 0) {\n\
    \            return 0;\n        }\n        r += n;\n        for(int i = log; i\
    \ >= 1; i--) {\n            push((r - 1) >> i);\n        }\n        T sm = e;\n\
    \        do {\n            r--;\n            while(r > 1 && (r & 1)) {\n     \
    \           r >>= 1;\n            }\n            if(!fn(f(val[r], sm))) {\n  \
    \              while(r < n) {\n                    push(r);\n                \
    \    r = 2 * r + 1;\n                    if(fn(f(val[r], sm))) {\n           \
    \             sm = f(val[r], sm);\n                        r--;\n            \
    \        }\n                }\n                return r + 1 - n;\n           \
    \ }\n            sm = f(val[r], sm);\n        } while((r & -r) != r);\n      \
    \  return 0;\n    }\n    void clear() {\n        for(auto& el: val) {\n      \
    \      el = e;\n        }\n    }\n    friend std::ostream &operator<<(std::ostream\
    \ &os, const LazySegTree &seg) {\n        os << seg[0];\n        for(int i = 0;\
    \ ++i < seg.size();) {\n            os << ' ' << seg[i];\n        }\n        return\
    \ os;\n    }\n};\n\ntemplate <class T> struct zwei {\n    T first, second;\n \
    \   zwei(){}\n    zwei(const T &f, const T &s): first(f), second(s){}\n    operator\
    \ T(){ return first; }\n    friend std::ostream &operator<<(std::ostream &os,\
    \ const zwei &z) {\n        os << z.first;\n        return os;\n    }\n};\n\n\
    template <class T> struct RAQRMX: LazySegTree<T, T> {    \n    RAQRMX(const std::vector<T>\
    \ &v, const T &e): LazySegTree<T, T>(v, [](const T a, const T b){ return std::max(a,\
    \ b); }, [](const T a, const T b){ return a + b; }, [](const T a, const T b){\
    \ return a + b; }, e, 0){ LazySegTree<T, T>::init(v); }\n};\ntemplate <class T>\
    \ struct RAQRMN: LazySegTree<T, T> {\n    RAQRMN(const std::vector<T> &v, const\
    \ T &e): LazySegTree<T, T>(v, [](const T a, const T b){ return std::min(a, b);\
    \ }, [](const T a, const T b){ return a + b; }, [](const T a, const T b){ return\
    \ a + b; }, e, 0){ LazySegTree<T, T>::init(v); }\n};\ntemplate <class T> struct\
    \ RAQRSM: LazySegTree<zwei<T>, T> {\n    RAQRSM(const std::vector<T> &v): LazySegTree<zwei<T>,\
    \ T>(v.size(), [](const zwei<T> a, const zwei<T> b){ return zwei<T>(a.first *\
    \ b.first, a.second * b.second); }, [](const zwei<T> a, const T b){ return zwei<T>(a.first\
    \ + a.second * b, a.second); }, [](const T a, const T b){ return a + b; }, zwei<T>(0,\
    \ 0), 0) {\n        std::vector<zwei<T>> w(v.size());\n        for(size_t i =\
    \ 0; i < v.size(); ++i) {\n            w[i] = zwei<T>(v[i], 1);\n        }\n \
    \       LazySegTree<zwei<T>, T>::init(w);\n    }\n};\ntemplate <class T> struct\
    \ RUQRMX: LazySegTree<T, T> {    \n    RUQRMX(const std::vector<T> &v, const T\
    \ &eid): LazySegTree<T, T>(v, [](const T a, const T b){ return std::max(a, b);\
    \ }, [](const T, const T b){ return b; }, [](const T, const T b){ return b; },\
    \ eid, eid){ LazySegTree<T, T>::init(v); }\n};\ntemplate <class T> struct RUQRMN:\
    \ LazySegTree<T, T> {\n    RUQRMN(const std::vector<T> &v, const T &eid): LazySegTree<T,\
    \ T>(v, [](const T a, const T b){ return std::min(a, b); }, [](const T, const\
    \ T b){ return b; }, [](const T, const T b){ return b; }, eid, eid){ LazySegTree<T,\
    \ T>::init(v); }\n};\ntemplate <class T> struct RUQRSM: LazySegTree<zwei<T>, T>\
    \ {\n    RUQRSM(const std::vector<T> &v, const T &id): LazySegTree<zwei<T>, T>(v.size(),\
    \ [](const zwei<T> a, const zwei<T> b){ return zwei<T>(a.first * b.first, a.second\
    \ * b.second); }, [](const zwei<T> a, const T b){ return zwei<T>(a.first + a.second\
    \ * b, a.second); }, [](const T a, const T b){ return a + b; }, zwei<T>(0, 0),\
    \ id) {\n        std::vector<zwei<T>> w(v.size());\n        for(size_t i = 0;\
    \ i < v.size(); ++i) {\n            w[i] = zwei<T>(v[i], 1);\n        }\n    \
    \    LazySegTree<zwei<T>, T>::init(w);\n    }\n};\n\n/**\n * @brief \u9045\u5EF6\
    \u30BB\u30B0\u6728\n * @see https://nyaannyaan.github.io/library/segment-tree/lazy-segment-tree-utility.hpp\n\
    \ */\n"
  code: "#pragma once\n\n#include <ostream>\n#include <cassert>\n#include <vector>\n\
    #include <cmath>\n#include <functional>\ntemplate <class T, class U> struct LazySegTree\
    \ {\nprivate:\n    using F = std::function<T(T, T)>;\n    using M = std::function<T(T,\
    \ U)>;\n    using C = std::function<U(U, U)>;\n    int n, log, s;\n    std::vector<T>\
    \ val;\n    std::vector<U> lazy;\n    const F f;\n    const T e;\n    const M\
    \ map;\n    const C comp;\n    const U id;\n    void push(const int i) {\n   \
    \     if(lazy[i] != id) {\n            val[2 * i + 0] = map(val[2 * i + 0], lazy[i]);\n\
    \            val[2 * i + 1] = map(val[2 * i + 1], lazy[i]);\n            if(2\
    \ * i < n) {\n                compose(lazy[2 * i + 0], lazy[i]);\n           \
    \     compose(lazy[2 * i + 1], lazy[i]);\n            }\n            lazy[i] =\
    \ id;\n        }\n    }\n    inline void upd(const int i){ val[i] = f(val[2 *\
    \ i + 0], val[2 * i + 1]); }\n    inline void apply(int i, const U& x) {\n   \
    \     if(x != id) {\n            val[i] = map(val[i], x);\n            if(i <\
    \ n) {\n                compose(lazy[i], x);\n            }\n        }\n    }\n\
    \    inline void compose(U& a, const U& b){ a = a == id ? b : comp(a, b); }\n\
    public:\n    LazySegTree(const int s, const F &f, const M &map, const C &comp,\
    \ const T e, const U id): s(s), f(f), map(map), comp(comp), e(e), id(id){}\n \
    \   LazySegTree(const std::vector<T> &v, const F &f, const M &map, const C &comp,\
    \ const T e, const U id): s(v.size()), f(f), map(map), comp(comp), e(e), id(id){}\n\
    \    void init(const std::vector<T> &v) {\n        n = 1, log = 0;\n        while(n\
    \ < s) {\n            n <<= 1;\n            log++;\n        }\n        val.resize(2\
    \ * n, e);\n        lazy.resize(n, id);\n        for(int i = 0; i < s; ++i) {\n\
    \            val[i + n] = v[i];\n        }\n        for(int i = n - 1; i--;) {\n\
    \            upd(i);\n        }\n    }\n    void set(const int k, const U &x){\
    \ update(k, k + 1, x); }\n    void update(int l, int r, const U& x) {\n      \
    \  if(l == r) {\n            return;\n        }\n        l += n, r += n;\n   \
    \     for(int i = log; i >= 1; i--) {\n            if(((l >> i) << i) != l) {\n\
    \                push(l >> i);\n            }\n            if(((r >> i) << i)\
    \ != r) {\n                push((r - 1) >> i);\n            }\n        }\n   \
    \     for(int p = l, q = r; p < q; p >>= 1, q >>= 1) {\n            if(p & 1)\
    \ {\n                apply(p++, x);\n            }\n            if(q & 1) {\n\
    \                apply(--q, x);\n            }\n        }\n        for(int i =\
    \ 1; i <= log; ++i) {\n            if(((l >> i) << i) != l) {\n              \
    \  upd(l >> i);\n            }\n            if(((r >> i) << i) != r) {\n     \
    \           upd((r - 1) >> i);\n            }\n        }\n    }\n    T query(int\
    \ l, int r) {\n        if(l == r) {\n            return e;\n        }\n      \
    \  l += n, r += n;\n        T L = e, R = e;\n        for(int i = log; i >= 1;\
    \ i--) {\n            if(((l >> i) << i) != l) {\n                push(l >> i);\n\
    \            }\n            if(((r >> i) << i) != r) {\n                push((r\
    \ - 1) >> i);\n            }\n        }\n        while(l < r) {\n            if(l\
    \ & 1) {\n                L = f(L, val[l++]);\n            }\n            if(r\
    \ & 1) {\n                R = f(val[--r], R);\n            }\n            l >>=\
    \ 1;\n            r >>= 1;\n        }\n        return f(L, R);\n    }\n    T const&\
    \ operator[](const int k) const { return val[k + n]; }\n    T &operator[](int\
    \ k) {\n        k += n;\n        for(int i = log; i >= 1; i--) {\n           \
    \ if(((k >> i) << i) != k || (((k + 1) >> i) << i) != (k + 1)) {\n           \
    \     push(k >> i);\n            }\n        }\n        return val[k];\n    }\n\
    \    inline int size() const { return s; }\n    template <class Boolean> int max_right(int\
    \ l, const Boolean &fn) {\n        assert(0 <= l && l <= s);\n        assert(fn(id));\n\
    \        if(l == n) {\n            return n;\n        }\n        l += n;\n   \
    \     for(int i = log; i >= 1; i--) {\n            push(l >> i);\n        }\n\
    \        T sm = e;\n        do {\n            while(l & 1 == 0) {\n          \
    \      l >>= 1;\n            }\n            if(!fn(f(sm, val[l]))) {\n       \
    \         while(l < n) {\n                    push(l);\n                    l\
    \ = (2 * l);\n                    if(fn(f(sm, val[l]))) {\n                  \
    \      sm = f(sm, val[l]);\n                        l++;\n                   \
    \ }\n                }\n                return l - n;\n            }\n       \
    \     sm = f(sm, val[l]);\n            l++;\n        } while((l & -l) != l);\n\
    \        return s;\n    }\n    template <class Boolean> int min_left(int r, const\
    \ Boolean &fn) {\n        assert(0 <= r && r <= s);\n        assert(fn(id));\n\
    \        if(r == 0) {\n            return 0;\n        }\n        r += n;\n   \
    \     for(int i = log; i >= 1; i--) {\n            push((r - 1) >> i);\n     \
    \   }\n        T sm = e;\n        do {\n            r--;\n            while(r\
    \ > 1 && (r & 1)) {\n                r >>= 1;\n            }\n            if(!fn(f(val[r],\
    \ sm))) {\n                while(r < n) {\n                    push(r);\n    \
    \                r = 2 * r + 1;\n                    if(fn(f(val[r], sm))) {\n\
    \                        sm = f(val[r], sm);\n                        r--;\n \
    \                   }\n                }\n                return r + 1 - n;\n\
    \            }\n            sm = f(val[r], sm);\n        } while((r & -r) != r);\n\
    \        return 0;\n    }\n    void clear() {\n        for(auto& el: val) {\n\
    \            el = e;\n        }\n    }\n    friend std::ostream &operator<<(std::ostream\
    \ &os, const LazySegTree &seg) {\n        os << seg[0];\n        for(int i = 0;\
    \ ++i < seg.size();) {\n            os << ' ' << seg[i];\n        }\n        return\
    \ os;\n    }\n};\n\ntemplate <class T> struct zwei {\n    T first, second;\n \
    \   zwei(){}\n    zwei(const T &f, const T &s): first(f), second(s){}\n    operator\
    \ T(){ return first; }\n    friend std::ostream &operator<<(std::ostream &os,\
    \ const zwei &z) {\n        os << z.first;\n        return os;\n    }\n};\n\n\
    template <class T> struct RAQRMX: LazySegTree<T, T> {    \n    RAQRMX(const std::vector<T>\
    \ &v, const T &e): LazySegTree<T, T>(v, [](const T a, const T b){ return std::max(a,\
    \ b); }, [](const T a, const T b){ return a + b; }, [](const T a, const T b){\
    \ return a + b; }, e, 0){ LazySegTree<T, T>::init(v); }\n};\ntemplate <class T>\
    \ struct RAQRMN: LazySegTree<T, T> {\n    RAQRMN(const std::vector<T> &v, const\
    \ T &e): LazySegTree<T, T>(v, [](const T a, const T b){ return std::min(a, b);\
    \ }, [](const T a, const T b){ return a + b; }, [](const T a, const T b){ return\
    \ a + b; }, e, 0){ LazySegTree<T, T>::init(v); }\n};\ntemplate <class T> struct\
    \ RAQRSM: LazySegTree<zwei<T>, T> {\n    RAQRSM(const std::vector<T> &v): LazySegTree<zwei<T>,\
    \ T>(v.size(), [](const zwei<T> a, const zwei<T> b){ return zwei<T>(a.first *\
    \ b.first, a.second * b.second); }, [](const zwei<T> a, const T b){ return zwei<T>(a.first\
    \ + a.second * b, a.second); }, [](const T a, const T b){ return a + b; }, zwei<T>(0,\
    \ 0), 0) {\n        std::vector<zwei<T>> w(v.size());\n        for(size_t i =\
    \ 0; i < v.size(); ++i) {\n            w[i] = zwei<T>(v[i], 1);\n        }\n \
    \       LazySegTree<zwei<T>, T>::init(w);\n    }\n};\ntemplate <class T> struct\
    \ RUQRMX: LazySegTree<T, T> {    \n    RUQRMX(const std::vector<T> &v, const T\
    \ &eid): LazySegTree<T, T>(v, [](const T a, const T b){ return std::max(a, b);\
    \ }, [](const T, const T b){ return b; }, [](const T, const T b){ return b; },\
    \ eid, eid){ LazySegTree<T, T>::init(v); }\n};\ntemplate <class T> struct RUQRMN:\
    \ LazySegTree<T, T> {\n    RUQRMN(const std::vector<T> &v, const T &eid): LazySegTree<T,\
    \ T>(v, [](const T a, const T b){ return std::min(a, b); }, [](const T, const\
    \ T b){ return b; }, [](const T, const T b){ return b; }, eid, eid){ LazySegTree<T,\
    \ T>::init(v); }\n};\ntemplate <class T> struct RUQRSM: LazySegTree<zwei<T>, T>\
    \ {\n    RUQRSM(const std::vector<T> &v, const T &id): LazySegTree<zwei<T>, T>(v.size(),\
    \ [](const zwei<T> a, const zwei<T> b){ return zwei<T>(a.first * b.first, a.second\
    \ * b.second); }, [](const zwei<T> a, const T b){ return zwei<T>(a.first + a.second\
    \ * b, a.second); }, [](const T a, const T b){ return a + b; }, zwei<T>(0, 0),\
    \ id) {\n        std::vector<zwei<T>> w(v.size());\n        for(size_t i = 0;\
    \ i < v.size(); ++i) {\n            w[i] = zwei<T>(v[i], 1);\n        }\n    \
    \    LazySegTree<zwei<T>, T>::init(w);\n    }\n};\n\n/**\n * @brief \u9045\u5EF6\
    \u30BB\u30B0\u6728\n * @see https://nyaannyaan.github.io/library/segment-tree/lazy-segment-tree-utility.hpp\n\
    \ */"
  dependsOn: []
  isVerificationFile: false
  path: C++/LazySegmentTree.hpp
  requiredBy: []
  timestamp: '2024-02-12 13:50:18+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/LazySegmentTree.hpp
layout: document
redirect_from:
- /library/C++/LazySegmentTree.hpp
- /library/C++/LazySegmentTree.hpp.html
title: "\u9045\u5EF6\u30BB\u30B0\u6728"
---
