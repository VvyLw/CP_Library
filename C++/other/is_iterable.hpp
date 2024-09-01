#pragma once

#include <type_traits>
#include <concepts>

template <class T> concept is_iterable = requires(const T &a) {
    { std::begin(a) } -> std::same_as<typename std::remove_reference<decltype(std::begin(a))>::type>;
    { std::end(a) } -> std::same_as<typename std::remove_reference<decltype(std::end(a))>::type>;
};