---
data:
  _extendedDependsOn:
  - icon: ':x:'
    path: C++/ds/LazySegmentTree.hpp
    title: "\u9045\u5EF6\u30BB\u30B0\u6728"
  - icon: ':x:'
    path: C++/math/Modint.hpp
    title: Modint
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: cpp
  _verificationStatusIcon: ':x:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://judge.yosupo.jp/problem/range_affine_range_sum
    links:
    - https://judge.yosupo.jp/problem/range_affine_range_sum
  bundledCode: "#line 1 \"test/rangeaffine.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/range_affine_range_sum\"\
    \n#line 2 \"C++/math/Modint.hpp\"\n\n#include <iostream>\n#include <cassert>\n\
    #include <vector>\n#include <utility>\n#include <type_traits>\n#include <numeric>\n\
    #ifndef TEMPLATE\ntypedef long long ll;\ntypedef unsigned uint;\ntypedef unsigned\
    \ long long ul;\n#endif\ntemplate <uint mod> struct Modint {\n    uint num = 0;\n\
    \    constexpr Modint() noexcept {}\n    constexpr Modint(const Modint &x) noexcept\
    \ : num(x.num){}\n    constexpr operator ll() const noexcept { return num; }\n\
    \    constexpr static uint get_mod(){ return mod; }\n    constexpr Modint& operator+=(Modint\
    \ x) noexcept { num += x.num; if(num >= mod) num -= mod; return *this; }\n   \
    \ constexpr Modint& operator++() noexcept { if(num == mod - 1) num = 0; else num++;\
    \ return *this; }\n    constexpr Modint operator++(int) noexcept { Modint ans(*this);\
    \ operator++(); return ans; }\n    constexpr Modint operator-() const noexcept\
    \ { return Modint(0) -= *this; }\n    constexpr Modint& operator-=(Modint x) noexcept\
    \ { if(num < x.num) num += mod; num -= x.num; return *this; }\n    constexpr Modint&\
    \ operator--() noexcept { if(num == 0) num = mod - 1; else num--; return *this;\
    \ }\n    constexpr Modint operator--(int) noexcept { Modint ans(*this); operator--();\
    \ return ans; }\n    constexpr Modint& operator*=(Modint x) noexcept { num = ul(num)\
    \ * x.num % mod; return *this; }\n    constexpr Modint& operator/=(Modint x) noexcept\
    \ { return operator*=(x.inv()); }\n    constexpr void operator%=(Modint x) noexcept\
    \ { void(0); }\n    template <class T> constexpr Modint(T x) noexcept {\n    \
    \    using U = typename std::conditional<sizeof(T)>= 4, T, int>::type;\n     \
    \   U y = x; y %= U(mod); if(y < 0) y += mod; num = uint(y);\n    }\n    template\
    \ <class T> constexpr Modint operator+(T x) const noexcept { return Modint(*this)\
    \ += x; }\n    template <class T> constexpr Modint& operator+=(T x) noexcept {\
    \ return operator+=(Modint(x)); }\n    template <class T> constexpr Modint operator-(T\
    \ x) const noexcept { return Modint(*this) -= x; }\n    template <class T> constexpr\
    \ Modint& operator-=(T x) noexcept { return operator-=(Modint(x)); }\n    template\
    \ <class T> constexpr Modint operator*(T x) const noexcept { return Modint(*this)\
    \ *= x; }\n    template <class T> constexpr Modint& operator*=(T x) noexcept {\
    \ return operator*=(Modint(x)); }\n    template <class T> constexpr Modint operator/(T\
    \ x) const noexcept { return Modint(*this) /= x; }\n    template <class T> constexpr\
    \ Modint& operator/=(T x) noexcept { return operator/=(Modint(x)); }\n    constexpr\
    \ Modint inv() const noexcept { ll x = 0, y = 0; extgcd(num, mod, x, y); return\
    \ x; }\n    static constexpr ll extgcd(ll a, ll b, ll &x, ll &y) noexcept { ll\
    \ g = a; x = 1; y = 0; if(b){ g = extgcd(b, a % b, y, x); y -= a / b * x; } return\
    \ g; }\n    constexpr Modint pow(ul x) const noexcept { Modint ans = 1, cnt =\
    \ *this; while(x){ if(x & 1) ans *= cnt; cnt *= cnt; x /= 2; } return ans; }\n\
    \    friend std::ostream& operator<<(std::ostream& os, const Modint& m){ os <<\
    \ m.num; return os; }\n    friend std::istream &operator>>(std::istream &is, Modint\
    \ &a) {\n        ll t;\n        is >> t;\n        a=Modint(t);\n        return\
    \ (is);\n    }\n};\nusing mint = Modint<998244353>;\n//using mint = Modint<1000000007>;\n\
    using vm = std::vector<mint>;\nusing wm = std::vector<vm>;\nusing pm = std::pair<mint,\
    \ mint>;\ntemplate <class T> inline T msum(const std::vector<T> &v){ return std::accumulate(v.begin(),\
    \ v.end(), mint(0)); }\ntemplate <class T> inline T msum(const std::vector<T>\
    \ &v, ll a, ll b){ return std::accumulate(v.begin() + a, v.begin() + b, mint(0));\
    \ }\ntemplate <class T> inline T mmul(const std::vector<T> &v){ return std::accumulate(v.begin(),\
    \ v.end(), mint(1), [](T acc, T i){ return acc*i; }); }\ntemplate <class T> inline\
    \ T mmul(const std::vector<T> &v, ll a, ll b){ return std::accumulate(v.begin()\
    \ + a, v.begin() + b, mint(1), [](T acc, T i){ return acc*i; }); }\nvm fac(1,1),inv(1,1);\n\
    void reserve(ul a){\n    if(fac.size()>=a) return;\n    if(a<fac.size()*2) a=fac.size()*2;\n\
    \    if(a>=mint::get_mod()) a=mint::get_mod();\n    while(fac.size()<a) fac.emplace_back(fac.back()*mint(fac.size()));\n\
    \    inv.resize(fac.size());\n    inv.back()=fac.back().inv();\n    for(ll i=inv.size()-1;\
    \ !inv[i-1]; i--) inv[i-1]=inv[i]*i;\n}\nmint fact(ll n){ if(n<0) return 0; reserve(n\
    \ + 1); return fac[n]; }\nmint nPr(ll n,ll r){\n    if(r<0 || n<r) return 0;\n\
    \    if(n>>24){ mint ans=1; for(int i = 0; i < r; ++i) ans*=n--; return ans; }\n\
    \    reserve(n+1); return fac[n]*inv[n-r];\n}\nmint nCr(ll n,ll r){ if(r<0 ||\
    \ n<r) return 0; r=std::min(r,n-r); reserve(r+1); return nPr(n,r)*inv[r]; }\n\
    mint nHr(ll n,ll r){ if(!n && !r) return 1; if(n<=0 || r<0) return 0; return nCr(n+r-1,r);\
    \ }\n\nstruct a_mint {\n    int val;\n    a_mint() : val(0){}\n    a_mint(ll x)\
    \ : val(x >= 0 ? x % get_mod() : (get_mod() - (-x) % get_mod()) % get_mod()){}\n\
    \    int getmod() { return get_mod(); }\n    static int &get_mod() {\n       \
    \ static int mod = 0;\n        return mod;\n    }\n    static void set_mod(int\
    \ md) { assert(md>0); get_mod() = md; }\n    a_mint &operator+=(const a_mint &p)\
    \ {\n        if ((val += p.val) >= get_mod()) val -= get_mod();\n        return\
    \ *this;\n    }\n    a_mint &operator-=(const a_mint &p) {\n        if((val +=\
    \ get_mod() - p.val) >= get_mod()) val -= get_mod();\n        return *this;\n\
    \    }\n    a_mint &operator*=(const a_mint &p) {\n        val = (int)(1LL * val\
    \ * p.val % get_mod());\n        return *this;\n    }\n    a_mint &operator/=(const\
    \ a_mint &p) {\n        *this *= p.inv();\n        return *this;\n    }\n    a_mint\
    \ operator-() const { return a_mint(-val); }\n    a_mint operator+(const a_mint\
    \ &p) const { return a_mint(*this) += p; }\n    a_mint operator-(const a_mint\
    \ &p) const { return a_mint(*this) -= p; }\n    a_mint operator*(const a_mint\
    \ &p) const { return a_mint(*this) *= p; }\n    a_mint operator/(const a_mint\
    \ &p) const { return a_mint(*this) /= p; }\n    a_mint& operator++() noexcept\
    \ { if(val == get_mod() - 1) val = 0; else val++; return *this; }\n    a_mint\
    \ operator++(int) noexcept { a_mint ans(*this); operator++(); return ans; }\n\
    \    a_mint& operator--() noexcept { if(val == 0) val = get_mod() - 1; else val--;\
    \ return *this; }\n    a_mint operator--(int) noexcept { a_mint ans(*this); operator--();\
    \ return ans; }\n    bool operator==(const a_mint &p) const { return val == p.val;\
    \ }\n    bool operator!=(const a_mint &p) const { return val != p.val; }\n   \
    \ bool operator!() const { return val == 0; }\n    bool operator<=(const a_mint\
    \ &p) const { return val <= p.val; }\n    bool operator>=(const a_mint &p) const\
    \ { return val >= p.val; }\n    bool operator<(const a_mint &p) const { return\
    \ val < p.val; }\n    bool operator>(const a_mint &p) const { return val > p.val;\
    \ }\n    a_mint inv() const {\n        int a=val, b=get_mod(), u=1, v=0, t;\n\
    \        while(b>0) {\n            t=a/b;\n            std::swap(a -= t*b,b);\n\
    \            std::swap(u -= t*v,v);\n        }\n        return a_mint(u);\n  \
    \  }\n    a_mint pow(ll n) const {\n        a_mint res(1), mul(val);\n       \
    \ while(n>0) {\n            if(n & 1) res *= mul;\n            mul *= mul;\n \
    \           n >>= 1;\n        }\n        return res;\n    }\n    friend std::ostream\
    \ &operator<<(std::ostream &os, const a_mint &p) { return os << p.val; }\n   \
    \ friend std::istream &operator>>(std::istream &is, a_mint &a) {\n        ll t;\n\
    \        is >> t;\n        a=a_mint(t);\n        return is;\n    }\n};\nusing\
    \ va = std::vector<a_mint>;\nusing wa = std::vector<va>;\nusing pa = std::pair<a_mint,\
    \ a_mint>;\n#ifdef TEMPLATE\n#define MINT(...) mint __VA_ARGS__; in(__VA_ARGS__)\n\
    #define AINT(...) a_mint __VA_ARGS__; in(__VA_ARGS__)\n#endif\n/**\n * @brief\
    \ Modint\n * @docs docs/Modint.md\n * @see https://atcoder.jp/contests/arc151/submissions/35526971\n\
    \ */\n#line 2 \"C++/ds/LazySegmentTree.hpp\"\n\n#include <ostream>\n#line 6 \"\
    C++/ds/LazySegmentTree.hpp\"\n#include <functional>\ntemplate <class T, class\
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
    \ f(L, R);\n    }\n    T alle() const { return data[1]; }\n    void apply(int\
    \ k, const U &x) {\n        k += sz;\n        for(int i = h; i > 0; i--) {\n \
    \           propagate(k >> i);\n        }\n        data[k] = map(data[k], x);\n\
    \        for(int i = 0; ++i <= h;) {\n            update(k >> i);\n        }\n\
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
    \ first != z.first || second != z.second; }\n    operator T() const { return first;\
    \ }\n    friend std::ostream &operator<<(std::ostream &os, const zwei &z) {\n\
    \        os << z.first;\n        return os;\n    }\n};\n\ntemplate <class T> struct\
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
    \ */\n#line 4 \"test/rangeaffine.test.cpp\"\nusing Z = zwei<mint>;\nint main()\
    \ {\n    int n, q;\n    std::cin >> n >> q;\n    LazySegTree<Z, Z> seg(n, [](const\
    \ Z &a, const Z &b) -> Z { return Z(a.first + b.first, a.second + b.second); },\
    \ [](const Z &a, const Z &b) -> Z { return Z(a.first * b.first + a.second * b.second,\
    \ a.second); }, [](const Z &a, const Z &b) -> Z { return Z(a.first * b.first,\
    \ a.second * b.first + b.second); }, Z(0, 0), Z(1, 0));\n\tstd::vector<Z> a(n);\n\
    \    for(int i = 0; i < n; ++i) {\n        int x;\n        std::cin >> x;\n  \
    \      a[i] = Z(x, 1);\n    }\n    seg.build(a);\n    while(q--) {\n        int\
    \ t, l, r;\n        std::cin >> t >> l >> r;\n        if(t == 0) {\n         \
    \   int p, q;\n            std::cin >> p >> q;\n            seg.apply(l, r, Z(p,\
    \ q));\n        } else {\n            std::cout << seg.query(l, r) << '\\n';\n\
    \        }\n    }\n}\n\n// verified but actually failed(slowest: 9.000372 sec.)\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/range_affine_range_sum\"\
    \n#include \"C++/math/Modint.hpp\"\n#include \"C++/ds/LazySegmentTree.hpp\"\n\
    using Z = zwei<mint>;\nint main() {\n    int n, q;\n    std::cin >> n >> q;\n\
    \    LazySegTree<Z, Z> seg(n, [](const Z &a, const Z &b) -> Z { return Z(a.first\
    \ + b.first, a.second + b.second); }, [](const Z &a, const Z &b) -> Z { return\
    \ Z(a.first * b.first + a.second * b.second, a.second); }, [](const Z &a, const\
    \ Z &b) -> Z { return Z(a.first * b.first, a.second * b.first + b.second); },\
    \ Z(0, 0), Z(1, 0));\n\tstd::vector<Z> a(n);\n    for(int i = 0; i < n; ++i) {\n\
    \        int x;\n        std::cin >> x;\n        a[i] = Z(x, 1);\n    }\n    seg.build(a);\n\
    \    while(q--) {\n        int t, l, r;\n        std::cin >> t >> l >> r;\n  \
    \      if(t == 0) {\n            int p, q;\n            std::cin >> p >> q;\n\
    \            seg.apply(l, r, Z(p, q));\n        } else {\n            std::cout\
    \ << seg.query(l, r) << '\\n';\n        }\n    }\n}\n\n// verified but actually\
    \ failed(slowest: 9.000372 sec.)"
  dependsOn:
  - C++/math/Modint.hpp
  - C++/ds/LazySegmentTree.hpp
  isVerificationFile: true
  path: test/rangeaffine.test.cpp
  requiredBy: []
  timestamp: '2024-03-02 19:57:59+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: test/rangeaffine.test.cpp
layout: document
redirect_from:
- /verify/test/rangeaffine.test.cpp
- /verify/test/rangeaffine.test.cpp.html
title: test/rangeaffine.test.cpp
---
