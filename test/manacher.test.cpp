#define PROBLEM "https://judge.yosupo.jp/problem/enumerate_palindromes"
#include <iostream>
#include "C++/string/manacher.hpp"
int main() {
    std::string s;
    std::cin >> s;
    const auto res = man::manacher(s);
    for(size_t i = 0; i < res.size(); ++i) {
        std::cout << res[i] << " \n"[i + 1 == res.size()];
    }
}