#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/14/ALDS1_14_B"
#include <iostream>
#include "string/RH.hpp"
int main() {
    std::string t, p;
    std::cin >> t >> p;
    RH rh1(t), rh2(p);
    for(size_t i = 0; i + p.size() <= t.size(); ++i) {
        if(rh1.get(i, i + p.size()) == rh2.get(0, p.size())) {
            std::cout << i << '\n';
        }
    }
}