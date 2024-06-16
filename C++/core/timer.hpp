#pragma once

#include <ostream>
#include <chrono>
using Timer = std::chrono::system_clock::time_point;
Timer start, stop;
#if local
void now(Timer &t){ t = std::chrono::system_clock::now(); }
void time(const Timer &t1, const Timer &t2){ std::cerr << std::chrono::duration_cast<std::chrono::milliseconds>(t2 - t1).count() << "ms\n"; }
#else
void now(Timer &t){ void(0); }
void time(const Timer &t1, const Timer &t2){ void(0); }
#endif

/**
 * @brief タイマー
 */