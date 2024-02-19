#define PROBLEM "https://judge.yosupo.jp/problem/many_aplusb_128bit"
#include "io/input.hpp"
#include "io/output.hpp"
using namespace IO;
int main() {
    std::cin.tie(nullptr) -> sync_with_stdio(false);
    const auto solve = [&] {
        std::string s, t;
        std::cin >> s >> t;
        const i128 a = to_i128(s), b = to_i128(t);
        std::cout << (a + b) << '\n';
    };
    int t = 1;
    std::cin >> t;
    while(t--) {
        solve();
    }
}