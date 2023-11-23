---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    links: []
  bundledCode: "#line 2 \"C++/math.hpp\"\n\r\n#include <vector>\r\n#include <cmath>\r\
    \n#include <algorithm>\r\n#include <numeric>\r\n#include <map>\r\n#include <limits>\r\
    \nusing namespace std;\r\ntypedef long long ll;\r\ntypedef long double ld;\r\n\
    typedef unsigned long long ul;\r\nconst int dx[]={0,0,0,-1,1,-1,-1,1,1};\r\nconst\
    \ int dy[]={0,-1,1,0,0,-1,1,-1,1};\r\nconst int MOD = 998244353;\r\nconst int\
    \ M0D = 1000000007;\r\nconst int INF = 0x3fffffff;\r\nconst ll LINF = 0x1fffffffffffffff;\r\
    \nconst ld DINF = numeric_limits<ld>::infinity();\r\nconst double PI = acos(-1);\r\
    \nconst double E = 2.718281828459045;\r\n\r\ntemplate <class T> inline T Pow(T\
    \ a, T b, T mod=0) {\r\n    T res = 1;\r\n    if(mod) {\r\n        res %= mod;\r\
    \n        a %= mod;\r\n    }\r\n    while(b > 0) {\r\n        if(b & 1) res *=\
    \ a;\r\n        if(mod) res %= mod;\r\n        a *= a;\r\n        if(mod) a %=\
    \ mod;\r\n        b >>= 1;\r\n    }\r\n    return res;\r\n}\r\n\r\ntemplate <class\
    \ T> inline vector<T> div(T n) {\r\n    vector<T> d;\r\n    for(ll i = 1; i *\
    \ i <= n; ++i) {\r\n        if(n % i == 0) {\r\n            d.emplace_back(i);\r\
    \n            if(i * i != n) d.emplace_back(n / i);\r\n        }\r\n    }\r\n\
    \    sort(d.begin(), d.end());\r\n    return d;\r\n}\r\n\r\ninline bool is_prime(ul\
    \ n) {\r\n    if(n == 1) return 0;\r\n    for(ul i = 2; i * i <= n; ++i) if(n\
    \ % i == 0) return 0;\r\n    return 1;\r\n}\r\n\r\nstruct p_table {\r\n    vector<bool>\
    \ SoE;\r\n    p_table(int n): SoE(n+1,1){\r\n        SoE[0] = 0, SoE[1] = 0;\r\
    \n        for(ll i = 2; i <= n; ++i) {\r\n            if(!SoE[i]) continue;\r\n\
    \            for(ll j = i * i; j <= n; j += i) SoE[j] = 0;\r\n        }\r\n  \
    \  }\r\n    vector<int> get() const {\r\n        vector<int> p;\r\n        for(size_t\
    \ i = 2; i < SoE.size(); ++i) if(SoE[i]) p.emplace_back(i);\r\n        return\
    \ p;\r\n    }\r\n};\r\n\r\ntemplate <class T> inline vector<pair<T, T>> prmfct(T\
    \ n) {\r\n    vector<pair<T, T>> res;\r\n    for(T i = 2; i * i <= n; ++i) {\r\
    \n        if(n%i) continue;\r\n        T tmp=0;\r\n        while(n%i==0) {\r\n\
    \            tmp++;\r\n            n/=i;\r\n        }\r\n        res.emplace_back(i,tmp);\r\
    \n    }\r\n    if(n!=1) res.emplace_back(n,1);\r\n    return res;\r\n}\r\n\r\n\
    struct p_fact {\r\n    vector<int> spf;\r\n    p_fact(int n): spf(n + 1){\r\n\
    \        iota(spf.begin(), spf.end() ,0);\r\n        for(int i = 2; i * i <= n;\
    \ ++i) {\r\n            if(spf[i]==i) {\r\n                for(int j = i * i;\
    \ j <= n; j += i) {\r\n                    if(spf[j]==j) spf[j]=i;\r\n       \
    \         }\r\n            }\r\n        }\r\n    }\r\n    map<int,int> get(int\
    \ n) {\r\n        map<int,int> m;\r\n        while(n!=1) {\r\n            m[spf[n]]++;\r\
    \n            n/=spf[n];\r\n        }\r\n        return m;\r\n    }\r\n};\r\n\r\
    \ntemplate <class T=ll> T factor(T n, T mod=0) {\r\n    T res=1;\r\n    while(n>0)\
    \ {\r\n        res*=n--;\r\n        if(mod) res%=mod;\r\n    }\r\n    return res;\r\
    \n}\r\n\r\ntemplate <class T=ll> T perm(T n, T r, T mod=0) {\r\n    const T tmp=n;\r\
    \n    T res=1;\r\n    while(n>tmp-r) {\r\n        res*=n--;\r\n        if(mod)\
    \ res%=mod;\r\n    }\r\n    return res;\r\n}\r\n\r\ntemplate <class T=ll> T binom(T\
    \ n, T r, T mod=0) {\r\n    if(r < 0 || n < r) return 0;\r\n    T ret = 1;\r\n\
    \    for(T i = 1; i <= r; ++i) {\r\n        ret *= n--;\r\n        if(mod) ret%=mod;\r\
    \n        ret /= i;\r\n        if(mod) ret%=mod;\r\n    }\r\n    return ret;\r\
    \n}\r\n"
  code: "#pragma once\r\n\r\n#include <vector>\r\n#include <cmath>\r\n#include <algorithm>\r\
    \n#include <numeric>\r\n#include <map>\r\n#include <limits>\r\nusing namespace\
    \ std;\r\ntypedef long long ll;\r\ntypedef long double ld;\r\ntypedef unsigned\
    \ long long ul;\r\nconst int dx[]={0,0,0,-1,1,-1,-1,1,1};\r\nconst int dy[]={0,-1,1,0,0,-1,1,-1,1};\r\
    \nconst int MOD = 998244353;\r\nconst int M0D = 1000000007;\r\nconst int INF =\
    \ 0x3fffffff;\r\nconst ll LINF = 0x1fffffffffffffff;\r\nconst ld DINF = numeric_limits<ld>::infinity();\r\
    \nconst double PI = acos(-1);\r\nconst double E = 2.718281828459045;\r\n\r\ntemplate\
    \ <class T> inline T Pow(T a, T b, T mod=0) {\r\n    T res = 1;\r\n    if(mod)\
    \ {\r\n        res %= mod;\r\n        a %= mod;\r\n    }\r\n    while(b > 0) {\r\
    \n        if(b & 1) res *= a;\r\n        if(mod) res %= mod;\r\n        a *= a;\r\
    \n        if(mod) a %= mod;\r\n        b >>= 1;\r\n    }\r\n    return res;\r\n\
    }\r\n\r\ntemplate <class T> inline vector<T> div(T n) {\r\n    vector<T> d;\r\n\
    \    for(ll i = 1; i * i <= n; ++i) {\r\n        if(n % i == 0) {\r\n        \
    \    d.emplace_back(i);\r\n            if(i * i != n) d.emplace_back(n / i);\r\
    \n        }\r\n    }\r\n    sort(d.begin(), d.end());\r\n    return d;\r\n}\r\n\
    \r\ninline bool is_prime(ul n) {\r\n    if(n == 1) return 0;\r\n    for(ul i =\
    \ 2; i * i <= n; ++i) if(n % i == 0) return 0;\r\n    return 1;\r\n}\r\n\r\nstruct\
    \ p_table {\r\n    vector<bool> SoE;\r\n    p_table(int n): SoE(n+1,1){\r\n  \
    \      SoE[0] = 0, SoE[1] = 0;\r\n        for(ll i = 2; i <= n; ++i) {\r\n   \
    \         if(!SoE[i]) continue;\r\n            for(ll j = i * i; j <= n; j +=\
    \ i) SoE[j] = 0;\r\n        }\r\n    }\r\n    vector<int> get() const {\r\n  \
    \      vector<int> p;\r\n        for(size_t i = 2; i < SoE.size(); ++i) if(SoE[i])\
    \ p.emplace_back(i);\r\n        return p;\r\n    }\r\n};\r\n\r\ntemplate <class\
    \ T> inline vector<pair<T, T>> prmfct(T n) {\r\n    vector<pair<T, T>> res;\r\n\
    \    for(T i = 2; i * i <= n; ++i) {\r\n        if(n%i) continue;\r\n        T\
    \ tmp=0;\r\n        while(n%i==0) {\r\n            tmp++;\r\n            n/=i;\r\
    \n        }\r\n        res.emplace_back(i,tmp);\r\n    }\r\n    if(n!=1) res.emplace_back(n,1);\r\
    \n    return res;\r\n}\r\n\r\nstruct p_fact {\r\n    vector<int> spf;\r\n    p_fact(int\
    \ n): spf(n + 1){\r\n        iota(spf.begin(), spf.end() ,0);\r\n        for(int\
    \ i = 2; i * i <= n; ++i) {\r\n            if(spf[i]==i) {\r\n               \
    \ for(int j = i * i; j <= n; j += i) {\r\n                    if(spf[j]==j) spf[j]=i;\r\
    \n                }\r\n            }\r\n        }\r\n    }\r\n    map<int,int>\
    \ get(int n) {\r\n        map<int,int> m;\r\n        while(n!=1) {\r\n       \
    \     m[spf[n]]++;\r\n            n/=spf[n];\r\n        }\r\n        return m;\r\
    \n    }\r\n};\r\n\r\ntemplate <class T=ll> T factor(T n, T mod=0) {\r\n    T res=1;\r\
    \n    while(n>0) {\r\n        res*=n--;\r\n        if(mod) res%=mod;\r\n    }\r\
    \n    return res;\r\n}\r\n\r\ntemplate <class T=ll> T perm(T n, T r, T mod=0)\
    \ {\r\n    const T tmp=n;\r\n    T res=1;\r\n    while(n>tmp-r) {\r\n        res*=n--;\r\
    \n        if(mod) res%=mod;\r\n    }\r\n    return res;\r\n}\r\n\r\ntemplate <class\
    \ T=ll> T binom(T n, T r, T mod=0) {\r\n    if(r < 0 || n < r) return 0;\r\n \
    \   T ret = 1;\r\n    for(T i = 1; i <= r; ++i) {\r\n        ret *= n--;\r\n \
    \       if(mod) ret%=mod;\r\n        ret /= i;\r\n        if(mod) ret%=mod;\r\n\
    \    }\r\n    return ret;\r\n}\r\n"
  dependsOn: []
  isVerificationFile: false
  path: C++/math.hpp
  requiredBy: []
  timestamp: '2023-11-23 12:08:21+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/math.hpp
layout: document
redirect_from:
- /library/C++/math.hpp
- /library/C++/math.hpp.html
title: C++/math.hpp
---
