#pragma once

#include <ostream>
#include <cassert>
#include <vector>
template <class T> struct Matrix {
private:
    const size_t h, w;
    std::vector<std::vector<T>> mat;
public:
    Matrix(const size_t n): h(n), w(n), mat(h, std::vector<T>(w)){}
    Matrix(const size_t h, const size_t w): h(h), w(w), mat(h, std::vector<T>(w)){}
    Matrix(const std::vector<std::vector<T>> &m): h(m.size()), w(m[0].size()), mat(h, std::vector<T>(w)) {
        for(size_t i = 0; i < m.size(); ++i) {
            for(size_t j = 0; j < m[0].size(); ++j) {
                mat[i][j] = m[i][j];
            }
        }
    }
    static Matrix E(const size_t n) {
        Matrix m(n);
        for(size_t i = 0; i < n; ++i) {
            m[i][i] = 1;
        }
        return m;
    }
    std::vector<std::vector<T>> get() const { return mat; }
    inline const std::vector<T> &operator[](const size_t i) const { return mat[i]; }
    inline std::vector<T> &operator[](const size_t i){ return mat[i]; }
    Matrix &operator+=(const Matrix &m) {
        assert(h == m.h && m == m.w);
        for(int i = 0; i < h; ++i) {
            for(int j = 0; j < w; ++j) {
                (*this)[i][j] += m[i][j];
            }
        }            
        return *this;
    }
    Matrix &operator-=(const Matrix &m) {
        assert(h == m.h && m == m.w);
        for(int i = 0; i < h; ++i) {
            for(int j = 0; j < w; ++j) {
                (*this)[i][j] -= m[i][j];
            }
        }
        return *this;
    }
    Matrix &operator*=(const Matrix &m) {
        assert(w == m.h);
        std::vector<std::vector<T>> mt(h, std::vector<T>(m.w));
        for(size_t i = 0; i < h; ++i) {
            for(size_t j = 0; j < m.w; ++j) {
                for(size_t k = 0; k < w; ++k) {
                    mt[i][j] += (*this)[i][k] * m[k][j];
                }
            }
        }
        mat.swap(mt);
        return *this;
    }
    Matrix &operator^=(long long k) {
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
    bool operator==(const Matrix &m) const {
        if(h != m.h || w != m.w) {
            return false;
        }
        for(size_t i = 0; i < h; ++i) {
            for(size_t j = 0; j < w; ++j) {
                if((*this)[i][j] != m[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    Matrix operator+(const Matrix &m) const { return Matrix(*this) += m; }
    Matrix operator-(const Matrix &m) const { return Matrix(*this) -= m; }
    Matrix operator*(const Matrix &m) const { return Matrix(*this) *= m; }
    Matrix operator^(const long long k) const { return Matrix(*this) ^= k; }
    friend std::ostream &operator<<(std::ostream &os, const Matrix &m) {
        for(size_t i = 0; i < m.h; ++i) {
            os << '[' << m[i][0];
            for(size_t j = 0; ++j < m.w;) {
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
/**
 * @brief 行列ライブラリ
 * @see https://ei1333.github.io/luzhiled/snippets/math/matrix.html
 */