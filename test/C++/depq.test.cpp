#define PROBLEM "https://judge.yosupo.jp/problem/double_ended_priority_queue"
#include <iostream>
#include "C++/ds/depq.hpp"
int main() {
    int n, q;
    std::cin >> n >> q;
    std::vector<int> s(n);
    for(auto &el: s) {
        std::cin >> el;
    }
    depq<int> depq(s);
    while(q--) {
        int t;
        std::cin >> t;
        if(t == 0) {
            int x;
            std::cin >> x;
            depq.push(x);
        }
        else if(t == 1) {
            std::cout << depq.pop_min() << '\n';
        }
        else {
            std::cout << depq.pop_max() << '\n';
        }
    }
}