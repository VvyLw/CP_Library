#pragma once

#include <vector>
namespace Heileden {
struct p_table {
    std::vector<int> SoE;
    p_table(const int n): SoE(n + 1, 1) {
        SoE[0] = SoE[1] = 0;
        for(int64_t i = 2; i <= n; ++i) {
            if(!SoE[i]) {
                continue;
            }
            for(int64_t j = i * i; j <= n; j += i) {
                SoE[j] = 0;
            }
        }
    }
    std::vector<int> get() {
        std::vector<int> p;
        for(size_t i = 2; i < SoE.size(); ++i) {
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