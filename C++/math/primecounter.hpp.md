---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: C++/math/kthrooti.hpp
    title: "k\u4E57\u6839(\u6574\u6570)"
  - icon: ':question:'
    path: C++/math/primetable.hpp
    title: Sieve of Eratosthenes
  - icon: ':question:'
    path: C++/myvector.hpp
    title: C++/myvector.hpp
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: test/C++/pcounter.test.cpp
    title: test/C++/pcounter.test.cpp
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    document_title: "\u7D20\u6570\u306E\u500B\u6570"
    links: []
  bundledCode: "#line 2 \"C++/math/primecounter.hpp\"\n\n#include <vector>\n#line\
    \ 2 \"C++/math/kthrooti.hpp\"\n\n#include <limits>\n#ifndef TEMPLATE\ntypedef\
    \ unsigned long long ul;\ntemplate <class T, class U> inline bool overflow_if_mul(const\
    \ T a, const U b){ return (std::numeric_limits<T>::max()/a)<b; }\n#endif\nnamespace\
    \ Heileden {\ninline ul kthrooti(const ul n, const int k) {\n    if(k==1) {\n\t\
    \treturn n;\n\t}\n\tconst auto chk=[&](const unsigned x) {\n\t\tul mul=1;\n\t\t\
    for(int i = 0; i < k; ++i) {\n            if(overflow_if_mul(mul, x)) {\n    \
    \            return false;\n            }\n            mul*=x;\n        }\n\t\t\
    return mul<=n;\n\t};\n\tul ret=0;\n\tfor(int i = 32; --i >= 0;) {\n\t\tif(chk(ret|(1U<<i)))\
    \ {\n\t\t\tret|=1U<<i;\n\t\t}\n\t}\n\treturn ret;\n}\n}\n\n/**\n * @brief k\u4E57\
    \u6839(\u6574\u6570)\n */\n#line 2 \"C++/math/primetable.hpp\"\n\n#line 2 \"C++/myvector.hpp\"\
    \n\n#line 4 \"C++/myvector.hpp\"\n\n#ifndef TEMPLATE\ntypedef long long ll;\n\
    typedef unsigned long long ul;\ntypedef long double ld;\n#endif\nnamespace vectors\
    \ {\ntemplate <class T> using V = std::vector<T>;\nusing vi = V<ll>;\nusing vu\
    \ = V<ul>;\nusing vd = V<ld>;\nusing vc = V<char>;\nusing vs = V<std::string>;\n\
    using vb = V<bool>;\nusing wi = V<vi>;\nusing wu = V<vu>;\nusing wd = V<vd>;\n\
    using wc = V<vc>;\nusing ws = V<vs>;\nusing wb = V<vb>;\ntemplate <class T, class\
    \ U> inline V<U> ndiv(T&& n, U&& v) noexcept {\n  return V<U>(std::forward<T>(n),\
    \ std::forward<U>(v));\n}\ntemplate <class T, class... Ts> inline decltype(auto)\
    \ ndiv(T&& n, Ts&&... v) noexcept {\n  return V<decltype(ndiv(std::forward<Ts>(v)...))>(std::forward<T>(n),\
    \ ndiv(std::forward<Ts>(v)...));\n}\ntemplate <class T> constexpr V<T>& operator++(V<T>&\
    \ v) noexcept { for(auto &el: v) el++; return v; }\ntemplate <class T> constexpr\
    \ V<T>& operator--(V<T>& v) noexcept { for(auto &el: v) el--; return v; }\ntemplate\
    \ <class T, class U> constexpr V<T>& operator+=(V<T>& v, const U x) noexcept {\
    \ for(auto &el: v) el+=x; return v; }\ntemplate <class T, class U> constexpr V<T>&\
    \ operator-=(V<T>& v, const U x) noexcept { for(auto &el: v) el-=x; return v;\
    \ }\ntemplate <class T, class U> constexpr V<T>& operator*=(V<T>& v, const U x)\
    \ noexcept { for(auto &el: v) el*=x; return v; }\ntemplate <class T, class U>\
    \ constexpr V<T>& operator/=(V<T>& v, const U x) noexcept { for(auto &el: v) el/=x;\
    \ return v; }\ntemplate <class T, class U> constexpr V<T>& operator%=(V<T>& v,\
    \ const U x) noexcept { for(auto &el: v) el%=x; return v; }\ntemplate <class T,\
    \ class U> constexpr V<T> operator+(const V<T>& v, const U x) noexcept { V<T>\
    \ res = v; res+=x; return res; }\ntemplate <class T, class U> constexpr V<T> operator-(const\
    \ V<T>& v, const U x) noexcept { V<T> res = v; res-=x; return res; }\ntemplate\
    \ <class T, class U> constexpr V<T> operator*(const V<T>& v, const U x) noexcept\
    \ { V<T> res = v; res*=x; return res; }\ntemplate <class T, class U> constexpr\
    \ V<T> operator/(const V<T>& v, const U x) noexcept { V<T> res = v; res/=x; return\
    \ res; }\ntemplate <class T, class U> constexpr V<T> operator%(const V<T>& v,\
    \ const U x) noexcept { V<T> res = v; res%=x; return res; }\n} // vectors\n#line\
    \ 4 \"C++/math/primetable.hpp\"\nnamespace Heileden {\nstruct p_table {\n    vectors::vb\
    \ SoE;\n    p_table(const int n): SoE(n+1,1){\n        SoE[0]=SoE[1]=0;\n    \
    \    for(int64_t i = 2; i <= n; ++i) {\n            if(!SoE[i]) continue;\n  \
    \          for(int64_t j = i * i; j <= n; j += i) SoE[j] = 0;\n        }\n   \
    \ }\n    vectors::vi get() {\n        vectors::vi p;\n        for(size_t i = 2;\
    \ i < SoE.size(); ++i) if(SoE[i]) p.emplace_back(i);\n        return p;\n    }\n\
    };\n}\n\n/**\n * @brief Sieve of Eratosthenes\n */\n#line 6 \"C++/math/primecounter.hpp\"\
    \n#ifndef TEMPLATE\ntypedef long long ll;\nnamespace zia_qu {\ntemplate <class\
    \ T> inline T sqr(const T x){ return x*x; }\ntemplate <class T> inline T cub(const\
    \ T x){ return x*x*x; }\n}\n#endif\nstruct p_count {\nprivate:\n    ll sq;\n \
    \   std::vector<bool> prime;\n    std::vector<ll> prime_sum, primes;\n    ll p2(const\
    \ ll x, const ll y) {\n        if(x < 4) {\n            return 0;\n        }\n\
    \        const ll a = pi(y), b = pi(Heileden::kthrooti(x, 2));\n        if(a >=\
    \ b) {\n            return 0;\n        }\n        ll sum = (a - 2) * (a + 1) /\
    \ 2 - (b - 2) * (b + 1) / 2;\n        for(ll i = a; i < b; ++i) {\n          \
    \  sum += pi(x / primes[i]);\n        }\n        return sum;\n    }\n    ll phi(const\
    \ ll m, const ll n) {\n        if(m < 1) {\n            return 0;\n        }\n\
    \        if(n > m) {\n            return 1;\n        }\n        if(n < 1) {\n\
    \            return m;\n        }\n        if(m <= zia_qu::sqr(primes[n - 1]))\
    \ {\n            return pi(m) - n + 1;\n        }\n        if(m <= zia_qu::cub(primes[n\
    \ - 1]) && m <= sq) {\n            const ll sx = pi(Heileden::kthrooti(m, 2));\n\
    \            ll ans = pi(m) - (sx + n - 2) * (sx - n + 1) / 2;\n            for(ll\
    \ i = n; i < sx; ++i) {\n                ans += pi(m / primes[i]);\n         \
    \   }\n            return ans;\n        }\n        return phi(m, n - 1) - phi(m\
    \ / primes[n - 1], n - 1);\n    }\npublic:\n    p_count(const ll lim): sq(Heileden::kthrooti(lim,\
    \ 2)), prime_sum(sq + 1) {\n        prime = Heileden::p_table(sq).SoE;\n     \
    \   for(int i = 1; i <= sq; ++i) {\n            prime_sum[i] = prime_sum[i - 1]\
    \ + prime[i];\n        }\n        primes.reserve(prime_sum[sq]);\n        for(int\
    \ i = 1; i <= sq; ++i) {\n            if(prime[i]) {\n                primes.emplace_back(i);\n\
    \            }\n        }\n    }\n    ll pi(const ll n) {\n        if(n <= sq)\
    \ {\n            return prime_sum[n];\n        }\n        const ll m = Heileden::kthrooti(n,\
    \ 3);\n        const ll a = pi(m);\n        return phi(n, a) + a - 1 - p2(n, m);\n\
    \    }\n};\n\n/**\n * @brief \u7D20\u6570\u306E\u500B\u6570\n */\n"
  code: "#pragma once\n\n#include <vector>\n#include \"C++/math/kthrooti.hpp\"\n#include\
    \ \"C++/math/primetable.hpp\"\n#ifndef TEMPLATE\ntypedef long long ll;\nnamespace\
    \ zia_qu {\ntemplate <class T> inline T sqr(const T x){ return x*x; }\ntemplate\
    \ <class T> inline T cub(const T x){ return x*x*x; }\n}\n#endif\nstruct p_count\
    \ {\nprivate:\n    ll sq;\n    std::vector<bool> prime;\n    std::vector<ll> prime_sum,\
    \ primes;\n    ll p2(const ll x, const ll y) {\n        if(x < 4) {\n        \
    \    return 0;\n        }\n        const ll a = pi(y), b = pi(Heileden::kthrooti(x,\
    \ 2));\n        if(a >= b) {\n            return 0;\n        }\n        ll sum\
    \ = (a - 2) * (a + 1) / 2 - (b - 2) * (b + 1) / 2;\n        for(ll i = a; i <\
    \ b; ++i) {\n            sum += pi(x / primes[i]);\n        }\n        return\
    \ sum;\n    }\n    ll phi(const ll m, const ll n) {\n        if(m < 1) {\n   \
    \         return 0;\n        }\n        if(n > m) {\n            return 1;\n \
    \       }\n        if(n < 1) {\n            return m;\n        }\n        if(m\
    \ <= zia_qu::sqr(primes[n - 1])) {\n            return pi(m) - n + 1;\n      \
    \  }\n        if(m <= zia_qu::cub(primes[n - 1]) && m <= sq) {\n            const\
    \ ll sx = pi(Heileden::kthrooti(m, 2));\n            ll ans = pi(m) - (sx + n\
    \ - 2) * (sx - n + 1) / 2;\n            for(ll i = n; i < sx; ++i) {\n       \
    \         ans += pi(m / primes[i]);\n            }\n            return ans;\n\
    \        }\n        return phi(m, n - 1) - phi(m / primes[n - 1], n - 1);\n  \
    \  }\npublic:\n    p_count(const ll lim): sq(Heileden::kthrooti(lim, 2)), prime_sum(sq\
    \ + 1) {\n        prime = Heileden::p_table(sq).SoE;\n        for(int i = 1; i\
    \ <= sq; ++i) {\n            prime_sum[i] = prime_sum[i - 1] + prime[i];\n   \
    \     }\n        primes.reserve(prime_sum[sq]);\n        for(int i = 1; i <= sq;\
    \ ++i) {\n            if(prime[i]) {\n                primes.emplace_back(i);\n\
    \            }\n        }\n    }\n    ll pi(const ll n) {\n        if(n <= sq)\
    \ {\n            return prime_sum[n];\n        }\n        const ll m = Heileden::kthrooti(n,\
    \ 3);\n        const ll a = pi(m);\n        return phi(n, a) + a - 1 - p2(n, m);\n\
    \    }\n};\n\n/**\n * @brief \u7D20\u6570\u306E\u500B\u6570\n */"
  dependsOn:
  - C++/math/kthrooti.hpp
  - C++/math/primetable.hpp
  - C++/myvector.hpp
  isVerificationFile: false
  path: C++/math/primecounter.hpp
  requiredBy: []
  timestamp: '2024-02-19 13:17:33+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - test/C++/pcounter.test.cpp
documentation_of: C++/math/primecounter.hpp
layout: document
redirect_from:
- /library/C++/math/primecounter.hpp
- /library/C++/math/primecounter.hpp.html
title: "\u7D20\u6570\u306E\u500B\u6570"
---
