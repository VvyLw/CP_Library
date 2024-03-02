#define PROBLEM "https://judge.yosupo.jp/problem/zalgorithm"
#include <iostream>
#include "C++/string/z-algo.hpp"
int main() {
    std::string s;
    std::cin >> s;
    const auto res = zalg(s);
    for(size_t i = 0; i < s.size(); ++i) {
        std::cout << res[i] << " \n"[i + 1 == s.size()];
    }
}