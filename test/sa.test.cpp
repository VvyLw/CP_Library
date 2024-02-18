#define PROBLEM "https://judge.yosupo.jp/problem/suffixarray"
#include "Strings.hpp"
int main() {
    std::string s;
    std::cin >> s;
    SuffixArray sa(s);
    sa.erase(sa.begin());
    for(size_t i = 0; i < sa.size(); ++i) {
        std::cout << sa[i] << " \n"[i + 1 == sa.size()];
    }
}