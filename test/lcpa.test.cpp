#define PROBLEM "https://judge.yosupo.jp/problem/number_of_substrings"
#include "Strings.hpp"
int main() {
    std::string s;
    std::cin >> s;
    SuffixArray sa(s);
    const ll n = s.size();
    const auto lcp = sa.lcp_array();
    std::cout << n * (n + 1) / 2 - std::accumulate(lcp.begin(), lcp.end(), 0LL) << '\n';
}