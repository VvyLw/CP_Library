#pragma once

#include <vector>
#include <numeric>
#include <ranges>
namespace man {
struct phi_table {
private:
    int n;
	std::vector<int> euler;
public:
	phi_table(const int n_): n(n_), euler(n_ + 1) {
		std::iota(euler.begin(), euler.end(), 0);
		for(const auto i: std::views::iota(2, n + 1)) {
			if(euler[i] == i) {
				for(int j = i; j <= n; j += i) {
					euler[j] = euler[j] / i * (i - 1);
				}
			}
		}
	}
	inline std::vector<int> get() const noexcept { return euler; }
};
}

/**
 * @brief Euler's Phi-function(table)
 */