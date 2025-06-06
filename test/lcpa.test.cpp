#define PROBLEM "https://judge.yosupo.jp/problem/number_of_substrings"
#include "C++/string/SA.hpp"
int main() {
    std::string s;
    std::cin >> s;
    man::SuffixArray sa(s);
    const int64_t n = s.size();
    const auto lcp = sa.lcp_array();
    std::cout << n * (n + 1) / 2 - std::accumulate(lcp.begin(), lcp.end(), 0LL) << '\n';
}