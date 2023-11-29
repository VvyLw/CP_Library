#define PROBLEM "https://judge.yosupo.jp/problem/factorize"
#include <iostream>
#include <C++/Pollards_rho.hpp>
int main() {
    std::cin.tie(nullptr) -> sync_with_stdio(false);
    int q;
    std::cin >> q;
    const auto solve = [&]{
        ul n;
        std::cin >> n;
        const auto ans = rho(n);
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