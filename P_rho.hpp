#include <vector>
#include <algorithm>
#include <numeric>
typedef long long ll;
typedef unsigned long long ul;
using namespace std;
using vu = vector<ul>;
ul modmul(ul a, ul b, ul M) {
    ll ret = a * b - M * ul(1.L / M * a * b);
    return ret + M * (ret < 0) - M * (ret >= (ll)M);
}
ul modpow(ul b, ul e, ul mod) {
    ul ans = 1;
    for(; e; b = modmul(b, b, mod), e /= 2)
        if (e & 1) ans = modmul(ans, b, mod);
    return ans;
}
bool isp(ul n) {
    if (n < 2 || n % 6 % 4 != 1) return (n | 1) == 3;
    ul A[] = {2, 325, 9375, 28178, 450775, 9780504, 1795265022};
    ul s = __builtin_ctzll(n - 1), d = n >> s;
    for(auto a: A) {
        ul p = modpow(a % n, d, n), i = s;
        while (p != 1 && p != n - 1 && a % n && i--) p = modmul(p, p, n);
        if (p != n - 1 && i != s) return 0;
    }
    return 1;
}
ul pollard(ul n) {
    auto f = [n](ul x){ return modmul(x, x, n) + 1; };
    ul x = 0, y(0), t(30), prd(2), i(1), q;
    while (t++ % 40 || gcd(prd, n) == 1) {
        if (x == y) x = ++i, y = f(x);
        if ((q = modmul(prd, max(x, y) - min(x, y), n))) prd = q;
        x = f(x), y = f(f(y));
    }
    return gcd(prd, n);
}
vu rho(ul n) {
    if (n == 1) return {};
    if (isp(n)) return {n};
    ll x = pollard(n);
    auto l = rho(x), r = rho(n / x);
    l.emplace(l.end(), r.begin(), r.end());
    sort(l.begin(), l.end());
    return l;
}