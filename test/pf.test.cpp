#define PROBLEM "https://judge.yosupo.jp/problem/factorize"
#include <iostream>
#include <unordered_map>
#include "C++/math/Pollards_rho.hpp"
int main() {
    std::cin.tie(nullptr) -> sync_with_stdio(false);
    int q;
    std::cin >> q;
    std::unordered_map<int64_t, std::vector<uint64_t>> m;
    const auto solve = [&]{
        int64_t n;
        std::cin >> n;
        if(!m.contains(n)) {
            const auto p = rho(n);
            m.try_emplace(n, p);
        }
        const auto ans = m[n];
        std::cout << ans.size();
        if(ans.size()) {
            std::cout << ' ' << ans.front();
            for(size_t i = 0; ++i < ans.size();) {
                std::cout << ' ' << ans[i];
            }
        }
        std::cout << '\n';
    };
    while(q--) {
        solve();
    }
}