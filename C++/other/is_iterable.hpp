#pragma once

#include <type_traits>
#include <concepts>

template <class T> concept is_iterable = requires(const T &a) {
    { std::begin(a) } -> std::input_iterator;
    { std::end(a) } -> std::same_as<decltype(std::begin(a))>;
};