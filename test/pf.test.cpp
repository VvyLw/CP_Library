#define PROBLEM "https://judge.yosupo.jp/problem/factorize"
#include <iostream>
#include <map>
#include "C++/math/Pollards_rho.hpp"
int main() {
    std::cin.tie(nullptr) -> sync_with_stdio(false);
    int q;
    std::cin >> q;
    std::map<ll, std::vector<ll>> m;
    const auto solve = [&]{
        ll n;
        std::cin >> n;
        if(m.find(n) == m.end()) {
            auto p = rho(n);
            std::sort(p.begin(), p.end());
            m.try_emplace(n, p);
        }
        const auto ans = m[n];
        std::cout << ans.size();
        if(ans.size()) {
            std::cout << ' ' << ans.front();
            for(auto i = ans.begin(); ++i != ans.end();) {
                std::cout << ' ' << *i;
            }
        }
        std::cout << '\n';
    };
    while(q--) {
        solve();
    }
}