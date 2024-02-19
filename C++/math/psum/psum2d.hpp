#pragma once

#include <vector>
template <class T> struct psum2d {
private:
    int h, w;
    std::vector<std::vector<T>> data;
public:
    psum2d(const int h, const int w): h(h + 3), w(w + 3), data(h + 3, std::vector<T>(w + 3)){}
    psum2d(const std::vector<std::vector<T>> &v): h(v.size() + 3), w(v[0].size() + 3), data(v.size() + 3, std::vector<T>(v[0].size() + 3)) {
        for(size_t i = 0; i < v.size(); ++i) {
            for(size_t j = 0; j < v[i].size(); ++j) {
                add(i, j, v[i][j]);
            }
        }
    }
    void add(int i, int j, const T &x) {
		i++;
		j++;
		if(i >= h || j >= w) {
			return;
		}
		data[i][j] += x;
	}
    void add(const int i1, const int j1, const int i2, const int j2, const T &x) {
		add(i1, j1, x);
		add(i1, j2, -x);
		add(i2, j1, -x);
		add(i2, j2, x);
	}
    void build() {
		for(int i = 0; ++i < h;) {
			for(int j = 0; ++j < w;) {
				data[i][j] += data[i][j - 1] + data[i - 1][j] - data[i - 1][j - 1];
			}
		}
	}
    T get(const int i1, const int j1, const int i2, const int j2) const { return data[i2][j2] - data[i1][j2] - data[i2][j1] + data[i1][j1]; }
    T get(const int i, const int j) const { return data[i + 1][j + 1]; }
};