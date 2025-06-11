#pragma once

#include <vector>
#include <ranges>
namespace man {
template <std::integral T> struct psum2d {
private:
    int h, w;
    std::vector<std::vector<T>> data;
public:
    psum2d(const int h, const int w): h(h + 3), w(w + 3), data(h + 3, std::vector<T>(w + 3)){}
    psum2d(const std::vector<std::vector<T>> &v): h(std::ssize(v) + 3), w(std::ssize(v.front()) + 3), data(std::ssize(v) + 3, std::vector<T>(std::ssize(v.front()) + 3)) {
        for(const auto i: std::views::iota(0, std::ssize(v))) {
            for(const auto j: std::views::iota(0, std::ssize(v[i]))) {
                add(i, j, v[i][j]);
            }
        }
    }
    constexpr inline void add(int i, int j, const T &x) noexcept {
		i++;
		j++;
		if(i >= h || j >= w) {
			return;
		}
		data[i][j] += x;
	}
    constexpr inline void add(const int i1, const int j1, const int i2, const int j2, const T &x) noexcept {
		add(i1, j1, x);
		add(i1, j2, -x);
		add(i2, j1, -x);
		add(i2, j2, x);
	}
    constexpr inline void build() noexcept {
		for(const auto i: std::views::iota(1, h)) {
			for(const auto j: std::views::iota(1, w)) {
				data[i][j] += data[i][j - 1] + data[i - 1][j] - data[i - 1][j - 1];
			}
		}
	}
    constexpr inline T get(const int i1, const int j1, const int i2, const int j2) const noexcept { return data[i2][j2] - data[i1][j2] - data[i2][j1] + data[i1][j1]; }
    constexpr inline T get(const int i, const int j) const noexcept { return data[i + 1][j + 1]; }
};
}

/**
 * @brief 二次元累積和
 */