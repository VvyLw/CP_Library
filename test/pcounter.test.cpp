#define PROBLEM "https://judge.yosupo.jp/problem/counting_primes"
#include <iostream>
#include "C++/math/primecounter.hpp"
int main() {
    int64_t n;
    std::cin >> n;
    std::cout << man::p_count(int64_t(1e11)).pi(n) << '\n';
}