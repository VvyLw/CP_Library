#define PROBLEM "https://yukicoder.me/problems/no/2441"
#include <iostream>
#include <Matrix.hpp>
int main() {
    int a, b, c, d;
    std::cin >> a >> b >> c >> d;
    Matrix<int64_t> m(2);
    m[0][0] = a;
    m[0][1] = b;
    m[1][0] = c;
    m[1][1] = d;
    m ^= 3;
    for(int i = 0; i < 2; ++i) {
        std::cout << m[i][0] << ' ' << m[i][1] << '\n';
    }
}