#define PROBLEM "https://judge.yosupo.jp/problem/counting_primes"
#include <iostream>
#include "C++/math/primecounter.hpp"
int main() {
    ll n;
    std::cin >> n;
    std::cout << p_count(ll(1e11)).pi(n) << '\n';
}