#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/courses/library/6/NTL/1/NTL_1_D"
#include <iostream>
#include "math/euler_phi.hpp"
int main() {
    long n;
    std::cin >> n;
    std::cout << euler_phi(n) << '\n';
}