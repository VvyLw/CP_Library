#pragma once

#include <iostream>
#include <chrono>
typedef std::chrono::system_clock::time_point Timer;
Timer start, stop;
#if local
inline void now(Timer &t) noexcept { t = std::chrono::system_clock::now(); }
inline void time(const Timer &t1, const Timer &t2) noexcept { std::cerr << std::chrono::duration_cast<std::chrono::milliseconds>(t2 - t1).count() << "ms\n"; }
#else
void now(Timer &t){ void(0); }
void time(const Timer &t1, const Timer &t2){ void(0); }
#endif

/**
 * @brief タイマー
 */