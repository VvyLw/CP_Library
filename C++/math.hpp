#pragma once

#include <vector>
#include <cmath>
#include <algorithm>
#include <numeric>
#include <map>
#include <limits>
#include <numbers>
typedef long long ll;
typedef long double ld;
typedef unsigned long long ul;
template <class T> using L = std::numeric_limits<T>;
constexpr int dx[]={0,0,0,-1,1,-1,-1,1,1};
constexpr int dy[]={0,-1,1,0,0,-1,1,-1,1};
constexpr int MOD = 0x3b800001;
constexpr int M0D = 1e9+7;
constexpr int INF = 1<<30;
constexpr ll LINF = (1LL<<61)-1;
constexpr ld DINF = L<ld>::infinity();
template <class T> constexpr T LIM = L<T>::max();
#if __cplusplus >= 202100L
constexpr ld PI = std::numbers::pi;
constexpr ld E = std::numbers::e;
#else
const ld PI = std::acos(-1);
const ld E = 2.718281828459045;
#endif

template <class T, class U> inline bool overflow_if_add(const T a, const U b){ return (LIM<T>-a)<b; }
template <class T, class U> inline bool overflow_if_mul(const T a, const U b){ return (LIM<T>/a)<b; }

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

template <class T> inline std::vector<T> div(T n) {
    std::vector<T> d;
    for(ll i = 1; i * i <= n; ++i) {
        if(n % i == 0) {
            d.emplace_back(i);
            if(i * i != n) d.emplace_back(n / i);
        }
    }
    std::sort(d.begin(), d.end());
    return d;
}

inline bool is_prime(ul n) {
    if(n == 1) return 0;
    for(ul i = 2; i * i <= n; ++i) if(n % i == 0) return 0;
    return 1;
}

struct p_table {
    std::vector<bool> SoE;
    p_table(int n): SoE(n+1,1){
        SoE[0] = 0, SoE[1] = 0;
        for(ll i = 2; i <= n; ++i) {
            if(!SoE[i]) continue;
            for(ll j = i * i; j <= n; j += i) SoE[j] = 0;
        }
    }
    std::vector<int> get() const {
        std::vector<int> p;
        for(size_t i = 2; i < SoE.size(); ++i) if(SoE[i]) p.emplace_back(i);
        return p;
    }
};

template <class T> inline std::vector<std::pair<T, T>> prmfct(T n) {
    std::vector<std::pair<T, T>> res;
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

struct p_fact {
    std::vector<int> spf;
    p_fact(int n): spf(n + 1){
        std::iota(spf.begin(), spf.end() ,0);
        for(int i = 2; i * i <= n; ++i) {
            if(spf[i]==i) {
                for(int j = i * i; j <= n; j += i) {
                    if(spf[j]==j) spf[j]=i;
                }
            }
        }
    }
    std::map<int,int> get(int n) {
        std::map<int,int> m;
        while(n!=1) {
            m[spf[n]]++;
            n/=spf[n];
        }
        return m;
    }
};

inline ul kthrooti(const ul n, const int k) {
    if(k == 1) {
		return n;
	}
	const auto chk = [&](const unsigned x) -> bool {
		ul mul = 1;
		for(int j = 0; j < k; ++j) {
            if(overflow_if_mul(mul, x)) {
                return false;
            }
            mul *= x;
        }
		return mul <= n;
	};
	ul ret = 0;
	for(int i = 32; --i >= 0;) {
		if(chk(ret | (1U << i))) {
			ret |= 1U << i;
		}
	}
	return ret;
}

struct p_count {
private:
    ll sq;
    std::vector<bool> prime;
    std::vector<ll> prime_sum, primes;
    ll p2(const ll x, const ll y) {
        if(x < 4) {
            return 0;
        }
        const ll a = pi(y);
        const ll b = pi(kthrooti(x, 2));
        if(a >= b) {
            return 0;
        }
        ll sum = (a - 2) * (a + 1) / 2 - (b - 2) * (b + 1) / 2;
        for(ll i = a; i < b; ++i) {
            sum += pi(x / primes[i]);
        }
        return sum;
    }
    ll phi(const ll m, const ll n) {
        if(m < 1) {
            return 0;
        }
        if(n > m) {
            return 1;
        }
        if(n < 1) {
            return m;
        }
        if(m <= primes[n - 1] * primes[n - 1]) {
            return pi(m) - n + 1;
        }
        if(m <= primes[n - 1] * primes[n - 1] * primes[n - 1] && m <= sq) {
            const ll sx = pi(kthrooti(m, 2));
            ll ans = pi(m) - (sx + n - 2) * (sx - n + 1) / 2;
            for(ll i = n; i < sx; ++i) {
                ans += pi(m / primes[i]);
            }
            return ans;
        }
        return phi(m, n - 1) - phi(m / primes[n - 1], n - 1);
    }
public:
    p_count(const ll lim): sq(kthrooti(lim, 2)), prime_sum(sq + 1) {
        prime = p_table(sq).SoE;
        for(int i = 1; i <= sq; ++i) {
            prime_sum[i] = prime_sum[i - 1] + prime[i];
        }
        primes.reserve(prime_sum[sq]);
        for(int i = 1; i <= sq; ++i) {
            if(prime[i]) {
                primes.emplace_back(i);
            }
        }
    }

    ll pi(const ll n) {
        if(n <= sq) {
            return prime_sum[n];
        }
        const ll m = kthrooti(n, 3);
        const ll a = pi(m);
        return phi(n, a) + a - 1 - p2(n, m);
    }
};

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
