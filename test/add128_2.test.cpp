#define PROBLEM "https://judge.yosupo.jp/problem/many_aplusb_128bit"
#include "C++/core/io/input.hpp"
#include "C++/core/io/output.hpp"
using namespace IO;
#include <ranges>
namespace man {
typedef __int128_t i128;
inline i128 solve() noexcept {
    i128 a, b;
    IO::input(a, b);
    return a + b;
}
}
int main() {
    std::cin.tie(nullptr) -> sync_with_stdio(false);
    int t;
    std::cin >> t;
    for([[maybe_unused]] const auto _: std::views::iota(0, t)) {
        IO::println(man::solve());
    }
}