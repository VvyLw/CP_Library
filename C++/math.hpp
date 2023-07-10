#include <vector>
#include <cmath>
#include <algorithm>
#include <limits>
using namespace std;
typedef long long ll;
typedef long double ld;
typedef unsigned long long ul;
const int dx[]={0,0,-1,1,-1,-1,1,1};
const int dy[]={-1,1,0,0,-1,1,-1,1};
const int MOD = 998244353;
const int M0D = 1000000007;
const int INF = 0x3fffffff;
const ll LINF = 0x1fffffffffffffff;
const ld DINF = numeric_limits<ld>::infinity();
const double PI = acos(-1);
const double E = 2.718281828459045;

template <class T> inline T Pow(T a, T b, T mod=0) {
    T res = 1;
    if(mod) {
        res %= mod;
        a %= mod;
    }
    while(b > 0) {
        if(b & 1) res *= a;
        if(mod) res %= mod;
        a *= a;
        if(mod) a %= mod;
        b >>= 1;
    }
    return res;
}

template <class T> inline vector<T> divisor(T n) {
    vector<T> div;
    for(int64_t i = 1; i * i <= n; ++i) {
        if(n % i == 0) {
            div.emplace_back(i);
            if(i * i != n) div.emplace_back(n / i);
        }
    }
    sort(div.begin(), div.end());
    return div;
}

inline bool is_prime(ul n) {
    if(n == 1) return 0;
    for(ul i = 2; i * i <= n; ++i) if(n % i == 0) return 0;
    return 1;
}

inline vector<int> SoE(ll n) {
    vector<bool> prime(n + 1, 1);
    vector<int> p;
    for(ll i = 2; i <= n; ++i) {
        if(!prime[i]) continue;
        for(ll j = i * i; j <= n; j += i) prime[j]=0;
        p.emplace_back(i);
    }
    return p;
}

template <class T> inline vector<pair<T, T>> prmfct(T n) {
    vector<pair<T, T>> res;
    for(T i = 2; i * i <= n; ++i) {
        if(n%i) continue;
        T tmp=0;
        while(n%i==0) {
            tmp++;
            n/=i;
        }
        res.emplace_back(i,tmp);
    }
    if(n!=1) res.emplace_back(n,1);
    return res;
}

template <class T=ll> T factor(T n, T mod=0) {
    T res=1;
    while(n>0) {
        res*=n--;
        if(mod) res%=mod;
    }
    return res;
}

template <class T=ll> T perm(T n, T r, T mod=0) {
    const T tmp=n;
    T res=1;
    while(n>tmp-r) {
        res*=n--;
        if(mod) res%=mod;
    }
    return res;
}

template <class T=ll> T binom(T n, T r, T mod=0) {
    if(r < 0 || n < r) return 0;
    T ret = 1;
    for(T i = 1; i <= r; ++i) {
        ret *= n--;
        if(mod) ret%=mod;
        ret /= i;
        if(mod) ret%=mod;
    }
    return ret;
}
