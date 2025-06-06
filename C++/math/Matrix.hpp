#pragma once

#include <ostream>
#include <cassert>
#include <vector>
#include <ranges>
namespace man {
template <class T> struct Matrix {
private:
    const int h, w;
    std::vector<std::vector<T>> mat;
public:
    Matrix(const size_t n): h(n), w(n), mat(h, std::vector<T>(w)){}
    Matrix(const size_t h, const size_t w): h(h), w(w), mat(h, std::vector<T>(w)){}
    Matrix(const std::vector<std::vector<T>> &m): h(std::ssize(m)), w(std::ssize(m.front())), mat(h, std::vector<T>(w)) {
        for(const auto i: std::views::iota(0, h)) {
            for(const auto j: std::views::iota(0, w)) {
                mat[i][j] = m[i][j];
            }
        }
    }
    static Matrix E(const int n) {
        Matrix m(n);
        for(const auto i: std::views::iota(0, n)) {
            m[i][i] = 1;
        }
        return m;
    }
    std::vector<std::vector<T>> get() const { return mat; }
    inline const std::vector<T> &operator[](const int i) const noexcept { return mat[i]; }
    inline std::vector<T> &operator[](const int i) noexcept { return mat[i]; }
    constexpr inline Matrix &operator+=(const Matrix &m) noexcept {
        assert(h == m.h && m == m.w);
        for(const auto i: std::views::iota(0, h)) {
            for(const auto j: std::views::iota(0, w)) {
                (*this)[i][j] += m[i][j];
            }
        }            
        return *this;
    }
    constexpr inline Matrix &operator-=(const Matrix &m) noexcept {
        assert(h == m.h && m == m.w);
        for(const auto i: std::views::iota(0, h)) {
            for(const auto j: std::views::iota(0, w)) {
                (*this)[i][j] -= m[i][j];
            }
        }
        return *this;
    }
    constexpr inline Matrix &operator*=(const Matrix &m) noexcept {
        assert(w == m.h);
        std::vector mt(h, std::vector<T>(m.w));
        for(const auto i: std::views::iota(0, h)) {
            for(const auto j: std::views::iota(0, w)) {
                for(const auto k: std::views::iota(0, w)) {
                    mt[i][j] += (*this)[i][k] * m[k][j];
                }
            }
        }
        mat.swap(mt);
        return *this;
    }
    constexpr inline Matrix &operator^=(int64_t k) noexcept {
        Matrix m = Matrix::E(h);
        while(k > 0) {
            if(k & 1) {
                m *= *this;
            }
            *this *= *this;
            k >>= 1LL;
        }
        mat.swap(m.mat);
        return *this;
    }
    constexpr inline bool operator==(const Matrix &m) const noexcept {
        if(h != m.h || w != m.w) {
            return false;
        }
        for(const auto i: std::views::iota(0, h)) {
            for(const auto j: std::views::iota(0, w)) {
                if((*this)[i][j] != m[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    constexpr inline Matrix operator+(const Matrix &m) const noexcept { return Matrix(*this) += m; }
    constexpr inline Matrix operator-(const Matrix &m) const noexcept { return Matrix(*this) -= m; }
    constexpr inline Matrix operator*(const Matrix &m) const noexcept { return Matrix(*this) *= m; }
    constexpr inline Matrix operator^(const long long k) const noexcept { return Matrix(*this) ^= k; }
    inline friend std::ostream &operator<<(std::ostream &os, const Matrix &m) noexcept {
        for(const auto i: std::views::iota(0, m.h)) {
            os << '[' << m[i][0];
            for(const auto j: std::views::iota(1, m.w)) {
                os << ' ' << m[i][j];
            }
            os << ']';
            if(i + 1 < m.h) {
                os << '\n';
            }
        }
        return os;
    }
};
}
/**
 * @brief 行列ライブラリ
 * @see https://ei1333.github.io/luzhiled/snippets/math/matrix.html
 */