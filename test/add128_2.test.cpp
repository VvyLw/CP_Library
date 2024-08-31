#define PROBLEM "https://judge.yosupo.jp/problem/many_aplusb_128bit"
#include "C++/core/io/input.hpp"
#include "C++/core/io/output.hpp"
using namespace IO;
inline i128 solve() noexcept {
    std::string s, t;
    std::cin >> s >> t;
    const i128 a = to_i128(s), b = to_i128(t);
    return a + b;
}
int main() {
    std::cin.tie(nullptr) -> sync_with_stdio(false);
    int t;
    std::cin >> t;
    while(t--) {
        std::cout << solve() << '\n';
    }
}