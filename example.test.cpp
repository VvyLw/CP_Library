#define PROBLEM "https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/4/ALDS1_4_B"
#include <iostream>
#include <cassert>
#include <vector>
#include <algorithm>
int main() {
    std::cin.tie(nullptr) -> sync_with_stdio(false);
    int n, q, ans = 0;
    std::cin >> n;
    std::vector<int> s(n);
    std::for_each(s.begin(), s.end(),[](int &el){ std::cin >> el; });
    assert(is_sorted(s.begin(), s.end()));
    std::cin >> q;
    while(q--) {
        int t;
        std::cin >> t;
        ans += std::binary_search(s.begin(), s.end(), t);
    }
    std::cout << ans << '\n';
}
