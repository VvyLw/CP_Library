---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: C++/math.hpp
    title: C++/math.hpp
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: cpp
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    '*NOT_SPECIAL_COMMENTS*': ''
    PROBLEM: https://judge.yosupo.jp/problem/counting_primes
    links:
    - https://judge.yosupo.jp/problem/counting_primes
  bundledCode: "#line 1 \"test/pcounter.test.cpp\"\n#define PROBLEM \"https://judge.yosupo.jp/problem/counting_primes\"\
    \n#include <iostream>\n#line 2 \"C++/math.hpp\"\n\r\n#include <vector>\r\n#include\
    \ <cmath>\r\n#include <algorithm>\r\n#include <numeric>\r\n#include <map>\r\n\
    #include <limits>\r\n#include <numbers>\r\ntypedef long long ll;\r\ntypedef long\
    \ double ld;\r\ntypedef unsigned long long ul;\r\ntemplate <class T> using L =\
    \ std::numeric_limits<T>;\r\nconstexpr int dx[]={0,0,0,-1,1,-1,-1,1,1};\r\nconstexpr\
    \ int dy[]={0,-1,1,0,0,-1,1,-1,1};\r\nconstexpr int MOD = 0x3b800001;\r\nconstexpr\
    \ int M0D = 1e9+7;\r\nconstexpr int INF = 1<<30;\r\nconstexpr ll LINF = (1LL<<61)-1;\r\
    \nconstexpr ld DINF = L<ld>::infinity();\r\ntemplate <class T> constexpr T LIM\
    \ = L<T>::max();\r\n#if __cplusplus >= 202100L\r\nconstexpr ld PI = std::numbers::pi;\r\
    \nconstexpr ld E = std::numbers::e;\r\n#else\r\nconst ld PI = std::acos(-1);\r\
    \nconst ld E = 2.718281828459045;\r\n#endif\r\n\r\ntemplate <class T, class U>\
    \ inline bool overflow_if_add(const T a, const U b){ return (LIM<T>-a)<b; }\r\n\
    template <class T, class U> inline bool overflow_if_mul(const T a, const U b){\
    \ return (LIM<T>/a)<b; }\r\n\r\ntemplate <class T> inline T Pow(T a, T b, T mod=0)\
    \ {\r\n    T res = 1;\r\n    if(mod) {\r\n        res %= mod;\r\n        a %=\
    \ mod;\r\n    }\r\n    while(b > 0) {\r\n        if(b & 1) res *= a;\r\n     \
    \   if(mod) res %= mod;\r\n        a *= a;\r\n        if(mod) a %= mod;\r\n  \
    \      b >>= 1;\r\n    }\r\n    return res;\r\n}\r\n\r\ntemplate <class T> inline\
    \ std::vector<T> div(T n) {\r\n    std::vector<T> d;\r\n    for(ll i = 1; i *\
    \ i <= n; ++i) {\r\n        if(n % i == 0) {\r\n            d.emplace_back(i);\r\
    \n            if(i * i != n) d.emplace_back(n / i);\r\n        }\r\n    }\r\n\
    \    std::sort(d.begin(), d.end());\r\n    return d;\r\n}\r\n\r\ninline bool is_prime(ul\
    \ n) {\r\n    if(n == 1) return 0;\r\n    for(ul i = 2; i * i <= n; ++i) if(n\
    \ % i == 0) return 0;\r\n    return 1;\r\n}\r\n\r\nstruct p_table {\r\n    std::vector<bool>\
    \ SoE;\r\n    p_table(int n): SoE(n+1,1){\r\n        SoE[0] = 0, SoE[1] = 0;\r\
    \n        for(ll i = 2; i <= n; ++i) {\r\n            if(!SoE[i]) continue;\r\n\
    \            for(ll j = i * i; j <= n; j += i) SoE[j] = 0;\r\n        }\r\n  \
    \  }\r\n    std::vector<int> get() const {\r\n        std::vector<int> p;\r\n\
    \        for(size_t i = 2; i < SoE.size(); ++i) if(SoE[i]) p.emplace_back(i);\r\
    \n        return p;\r\n    }\r\n};\r\n\r\ntemplate <class T> inline std::vector<std::pair<T,\
    \ T>> prmfct(T n) {\r\n    std::vector<std::pair<T, T>> res;\r\n    for(T i =\
    \ 2; i * i <= n; ++i) {\r\n        if(n%i) continue;\r\n        T tmp=0;\r\n \
    \       while(n%i==0) {\r\n            tmp++;\r\n            n/=i;\r\n       \
    \ }\r\n        res.emplace_back(i,tmp);\r\n    }\r\n    if(n!=1) res.emplace_back(n,1);\r\
    \n    return res;\r\n}\r\n\r\nstruct p_fact {\r\n    std::vector<int> spf;\r\n\
    \    p_fact(int n): spf(n + 1){\r\n        std::iota(spf.begin(), spf.end() ,0);\r\
    \n        for(int i = 2; i * i <= n; ++i) {\r\n            if(spf[i]==i) {\r\n\
    \                for(int j = i * i; j <= n; j += i) {\r\n                    if(spf[j]==j)\
    \ spf[j]=i;\r\n                }\r\n            }\r\n        }\r\n    }\r\n  \
    \  std::map<int,int> get(int n) {\r\n        std::map<int,int> m;\r\n        while(n!=1)\
    \ {\r\n            m[spf[n]]++;\r\n            n/=spf[n];\r\n        }\r\n   \
    \     return m;\r\n    }\r\n};\r\n\r\ninline ul kthrooti(const ul n, const int\
    \ k) {\r\n    if(k == 1) {\r\n\t\treturn n;\r\n\t}\r\n\tconst auto chk = [&](const\
    \ unsigned x) -> bool {\r\n\t\tul mul = 1;\r\n\t\tfor(int j = 0; j < k; ++j) {\r\
    \n            if(overflow_if_mul(mul, x)) {\r\n                return false;\r\
    \n            }\r\n            mul *= x;\r\n        }\r\n\t\treturn mul <= n;\r\
    \n\t};\r\n\tul ret = 0;\r\n\tfor(int i = 32; --i >= 0;) {\r\n\t\tif(chk(ret |\
    \ (1U << i))) {\r\n\t\t\tret |= 1U << i;\r\n\t\t}\r\n\t}\r\n\treturn ret;\r\n\
    }\r\n\r\nstruct p_count {\r\nprivate:\r\n    ll sq;\r\n    std::vector<bool> prime;\r\
    \n    std::vector<ll> prime_sum, primes;\r\n    ll p2(const ll x, const ll y)\
    \ {\r\n        if(x < 4) {\r\n            return 0;\r\n        }\r\n        const\
    \ ll a = pi(y);\r\n        const ll b = pi(kthrooti(x, 2));\r\n        if(a >=\
    \ b) {\r\n            return 0;\r\n        }\r\n        ll sum = (a - 2) * (a\
    \ + 1) / 2 - (b - 2) * (b + 1) / 2;\r\n        for(ll i = a; i < b; ++i) {\r\n\
    \            sum += pi(x / primes[i]);\r\n        }\r\n        return sum;\r\n\
    \    }\r\n    ll phi(const ll m, const ll n) {\r\n        if(m < 1) {\r\n    \
    \        return 0;\r\n        }\r\n        if(n > m) {\r\n            return 1;\r\
    \n        }\r\n        if(n < 1) {\r\n            return m;\r\n        }\r\n \
    \       if(m <= primes[n - 1] * primes[n - 1]) {\r\n            return pi(m) -\
    \ n + 1;\r\n        }\r\n        if(m <= primes[n - 1] * primes[n - 1] * primes[n\
    \ - 1] && m <= sq) {\r\n            const ll sx = pi(kthrooti(m, 2));\r\n    \
    \        ll ans = pi(m) - (sx + n - 2) * (sx - n + 1) / 2;\r\n            for(ll\
    \ i = n; i < sx; ++i) {\r\n                ans += pi(m / primes[i]);\r\n     \
    \       }\r\n            return ans;\r\n        }\r\n        return phi(m, n -\
    \ 1) - phi(m / primes[n - 1], n - 1);\r\n    }\r\npublic:\r\n    p_count(const\
    \ ll lim): sq(kthrooti(lim, 2)), prime_sum(sq + 1) {\r\n        prime = p_table(sq).SoE;\r\
    \n        for(int i = 1; i <= sq; ++i) {\r\n            prime_sum[i] = prime_sum[i\
    \ - 1] + prime[i];\r\n        }\r\n        primes.reserve(prime_sum[sq]);\r\n\
    \        for(int i = 1; i <= sq; ++i) {\r\n            if(prime[i]) {\r\n    \
    \            primes.emplace_back(i);\r\n            }\r\n        }\r\n    }\r\n\
    \r\n    ll pi(const ll n) {\r\n        if(n <= sq) {\r\n            return prime_sum[n];\r\
    \n        }\r\n        const ll m = kthrooti(n, 3);\r\n        const ll a = pi(m);\r\
    \n        return phi(n, a) + a - 1 - p2(n, m);\r\n    }\r\n};\r\n\r\ntemplate\
    \ <class T=ll> T factor(T n, T mod=0) {\r\n    T res=1;\r\n    while(n>0) {\r\n\
    \        res*=n--;\r\n        if(mod) res%=mod;\r\n    }\r\n    return res;\r\n\
    }\r\n\r\ntemplate <class T=ll> T perm(T n, T r, T mod=0) {\r\n    const T tmp=n;\r\
    \n    T res=1;\r\n    while(n>tmp-r) {\r\n        res*=n--;\r\n        if(mod)\
    \ res%=mod;\r\n    }\r\n    return res;\r\n}\r\n\r\ntemplate <class T=ll> T binom(T\
    \ n, T r, T mod=0) {\r\n    if(r < 0 || n < r) return 0;\r\n    T ret = 1;\r\n\
    \    for(T i = 1; i <= r; ++i) {\r\n        ret *= n--;\r\n        if(mod) ret%=mod;\r\
    \n        ret /= i;\r\n        if(mod) ret%=mod;\r\n    }\r\n    return ret;\r\
    \n}\r\n#line 4 \"test/pcounter.test.cpp\"\nint main() {\n    ll n;\n    std::cin\
    \ >> n;\n    std::cout << p_count(ll(1e11)).pi(n) << '\\n';\n}\n"
  code: "#define PROBLEM \"https://judge.yosupo.jp/problem/counting_primes\"\n#include\
    \ <iostream>\n#include \"C++/math.hpp\"\nint main() {\n    ll n;\n    std::cin\
    \ >> n;\n    std::cout << p_count(ll(1e11)).pi(n) << '\\n';\n}"
  dependsOn:
  - C++/math.hpp
  isVerificationFile: true
  path: test/pcounter.test.cpp
  requiredBy: []
  timestamp: '2023-12-11 21:08:07+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: test/pcounter.test.cpp
layout: document
redirect_from:
- /verify/test/pcounter.test.cpp
- /verify/test/pcounter.test.cpp.html
title: test/pcounter.test.cpp
---
