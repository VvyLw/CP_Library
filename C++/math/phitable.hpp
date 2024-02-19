#pragma once

#include <vector>
#include <numeric>
struct phi_table {
private:
    int n;
	std::vector<int> euler;
public:
	phi_table(const int n_): n(n_), euler(n_ + 1) {
		std::iota(euler.begin(), euler.end(), 0);
		for(int i = 2; i <= n; ++i) {
			if(euler[i] == i) {
				for(int j = i; j <= n; j += i) {
					euler[j] = euler[j] / i * (i - 1);
				}
			}
		}
	}
	std::vector<int> get() const { return euler; }
};

/**
 * @brief Euler's Phi-function(table)
 */