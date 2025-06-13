#pragma once

#include <vector>
#include <ranges>
namespace man {
struct p_table {
    std::vector<int> SoE;
    p_table(const int n): SoE(n + 1, 1) {
        SoE[0] = SoE[1] = 0;
        for(const long long i: std::views::iota(2, n + 1)) {
            if(!SoE[i]) {
                continue;
            }
            for(long long j = i * i; j <= n; j += i) {
                SoE[j] = 0;
            }
        }
    }
    std::vector<int> get() {
        std::vector<int> p;
        for(const auto i: std::views::iota(2, std::ssize(SoE))) {
            if(SoE[i]) {
                p.emplace_back(i);
            }
        }
        return p;
    }
};
}

/**
 * @brief Sieve of Eratosthenes
 */