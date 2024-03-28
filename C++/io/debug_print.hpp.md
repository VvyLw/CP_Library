---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: hpp
  _verificationStatusIcon: ':warning:'
  attributes:
    links: []
  bundledCode: "#line 1 \"C++/io/debug_print.hpp\"\n/* last update: 2022-08-03 */\n\
    \n#ifndef DEBUG_PRINT_HPP\n#define DEBUG_PRINT_HPP\n\n#define INCLUDED(n) ((defined\
    \ _GLIBCXX_##n) || (defined _LIBCPP_##n))\n\n#if __cplusplus < 201703L\n#  warning\
    \ Please use C++17 (or later version).\n#endif\n#if !INCLUDED(ALGORITHM)\n#  warning\
    \ Please include <algorithm> before including debug_print.hpp.\n#endif\n#if !INCLUDED(CCTYPE)\n\
    #  warning Please include <cctype> before including debug_print.hpp.\n#endif\n\
    #if !INCLUDED(IOSTREAM)\n#  warning Please include <iostream> before including\
    \ debug_print.hpp.\n#endif\n#if !INCLUDED(ITERATOR)\n#  warning Please include\
    \ <iterator> before including debug_print.hpp.\n#endif\n#if !INCLUDED(STRING_VIEW)\n\
    #  warning Please include <string_view> before including debug_print.hpp.\n#endif\n\
    #if !INCLUDED(TYPE_TRAITS)\n#  warning Please include <type_traits> before including\
    \ debug_print.hpp.\n#endif\n\nnamespace debug_print {\n  std::ostream& os = std::cerr;\n\
    \n  template <class Tp> auto has_cbegin(int)     -> decltype(std::cbegin(std::declval<Tp>()),\
    \ std::true_type {});\n  template <class Tp> auto has_cbegin(...)     -> std::false_type;\n\
    \  template <class Tp> auto has_value_type(int) -> decltype(std::declval<typename\
    \ Tp::value_type>(), std::true_type {});\n  template <class Tp> auto has_value_type(...)\
    \ -> std::false_type;\n\n  template <class Tp>[[maybe_unused]] constexpr bool\
    \ is_iterable_container_v = decltype(has_cbegin<Tp>(int {}))::value;\n  template\
    \ <class Tp>[[maybe_unused]] constexpr bool is_container_v          = decltype(has_value_type<Tp>(int\
    \ {}))::value\n                                                              \
    \                 || is_iterable_container_v<Tp>;\n\n  template <>        [[maybe_unused]]\
    \ constexpr bool is_iterable_container_v<std::string_view> = false;\n  template\
    \ <>        [[maybe_unused]] constexpr bool is_container_v<std::string_view> \
    \         = false;\n#if INCLUDED(STRING)\n  template <>        [[maybe_unused]]\
    \ constexpr bool is_iterable_container_v<std::string>      = false;\n  template\
    \ <>        [[maybe_unused]] constexpr bool is_container_v<std::string>      \
    \         = false;\n#endif\n\n  template <class Tp, class... Ts> struct first_element\
    \ { using type = Tp; };\n  template <class... Ts> using first_t = typename first_element<Ts...>::type;\n\
    \n  template <class Tp, std::enable_if_t<!decltype(has_value_type<Tp>(int {}))::value,\
    \ std::nullptr_t> = nullptr>\n    auto check_elem(int) -> decltype(*std::cbegin(std::declval<Tp>()));\n\
    \  template <class Tp, std::enable_if_t<decltype(has_value_type<Tp>(int {}))::value,\
    \ std::nullptr_t> = nullptr>\n    auto check_elem(int) -> typename Tp::value_type;\n\
    \  template <class Tp>\n    auto check_elem(...) -> void;\n\n  template <class\
    \ Tp> using elem_t = decltype(check_elem<Tp>(int {}));\n\n  template <class Tp>\
    \ [[maybe_unused]] constexpr bool is_multidim_container_v = is_container_v<Tp>\n\
    \                                                                            \
    \    && is_container_v<elem_t<Tp>>;\n\n  template <class Tp> std::enable_if_t<!is_container_v<Tp>>\
    \ out(const Tp&);\n  void out(const char&);\n  void out(const char*);\n  void\
    \ out(const std::string_view&);\n\n#if INCLUDED(STRING)\n  void out(const std::string&);\n\
    #endif\n\n#ifdef __SIZEOF_INT128__\n  void out(const __int128&);\n  void out(const\
    \ unsigned __int128&);\n#endif\n\n  template <class Tp1, class Tp2> void out(const\
    \ std::pair<Tp1, Tp2>&);\n\n#if INCLUDED(TUPLE)\n  template <class... Ts> void\
    \ out(const std::tuple<Ts...>&);\n#endif\n\n#if INCLUDED(STACK)\n  template <class...\
    \ Ts> void out(std::stack<Ts...>);\n#endif\n\n#if INCLUDED(QUEUE)\n  template\
    \ <class... Ts> void out(std::queue<Ts...>);\n  template <class... Ts> void out(std::priority_queue<Ts...>);\n\
    #endif\n\n  template <class C> std::enable_if_t<is_iterable_container_v<C>> out(const\
    \ C&);\n\n  template <class Tp> std::enable_if_t<!is_container_v<Tp>> out(const\
    \ Tp& arg) {\n    os << arg;\n  }\n\n  void out(const char& arg) {\n    os <<\
    \ '\\'' << arg << '\\'';\n  }\n\n  void out(const char* arg) {\n    os << '\\\"\
    ' << arg << '\\\"';\n  }\n\n  void out(const std::string_view& arg) {\n    os\
    \ << '\\\"' << arg << '\\\"';\n  }\n\n#if INCLUDED(STRING)\n  void out(const std::string&\
    \ arg) {\n    os << '\\\"' << arg << '\\\"';\n  }\n#endif\n\n#ifdef __SIZEOF_INT128__\n\
    \  void out(const __int128& arg) {\n    int sign = (arg < 0) ? (-1) : 1;\n   \
    \ if (sign == -1)\n      os << '-';\n    __int128 base = sign;\n    while (sign\
    \ * arg >= sign * base * 10)\n      base *= 10;\n    while (base) {\n      os\
    \ << static_cast<char>('0' + (arg / base % 10));\n      base /= 10;\n    }\n \
    \ }\n\n  void out(const unsigned __int128& arg) {\n    unsigned __int128 base\
    \ = 1;\n    while (arg >= base * 10)\n      base *= 10;\n    while (base) {\n\
    \      os << static_cast<char>('0' + (arg / base % 10));\n      base /= 10;\n\
    \    }\n  }\n#endif\n\n  template <class Tp1, class Tp2> void out(const std::pair<Tp1,\
    \ Tp2>& arg) {\n    os << '(';\n    out(arg.first);\n    os << \", \";\n    out(arg.second);\n\
    \    os << ')';\n  }\n\n#if INCLUDED(TUPLE)\n  template <class T, std::size_t...\
    \ Is> void print_tuple(const T& arg, std::index_sequence<Is...>) {\n    static_cast<void>(((os\
    \ << (Is == 0 ? \"\" : \", \"), out(std::get<Is>(arg))), ...));\n  }\n\n  template\
    \ <class... Ts> void out(const std::tuple<Ts...>& arg) {\n    os << '(';\n   \
    \ print_tuple(arg, std::make_index_sequence<sizeof...(Ts)>());\n    os << ')';\n\
    \  }\n#endif\n\n#if INCLUDED(STACK)\n  template <class... Ts> void out(std::stack<Ts...>\
    \ arg) {\n    if (arg.empty()) {\n      os << \"<empty stack>\";\n      return;\n\
    \    }\n    os << \"[ \";\n    while (!arg.empty()) {\n      out(arg.top());\n\
    \      os << ' ';\n      arg.pop();\n    }\n    os << ']';\n  }\n#endif\n\n#if\
    \ INCLUDED(QUEUE)\n  template <class... Ts> void out(std::queue<Ts...> arg) {\n\
    \    if (arg.empty()) {\n      os << \"<empty queue>\";\n      return;\n    }\n\
    \    os << \"[ \";\n    while (!arg.empty()) {\n      out(arg.front());\n    \
    \  os << ' ';\n      arg.pop();\n    }\n    os << ']';\n  }\n  template <class...\
    \ Ts> void out(std::priority_queue<Ts...> arg) {\n    if (arg.empty()) {\n   \
    \   os << \"<empty priority_queue>\";\n      return;\n    }\n    os << \"[ \"\
    ;\n    while (!arg.empty()) {\n      out(arg.top());\n      os << ' ';\n     \
    \ arg.pop();\n    }\n    os << ']';\n  }\n#endif\n\n  template <class Container>\n\
    \  std::enable_if_t<is_iterable_container_v<Container>> out(const Container& arg)\
    \ {\n    if (std::distance(std::cbegin(arg), std::cend(arg)) == 0) {\n      os\
    \ << \"<empty container>\";\n      return;\n    }\n    os << \"[ \";\n    std::for_each(std::cbegin(arg),\
    \ std::cend(arg), [](const elem_t<Container>& elem) {\n      out(elem);\n    \
    \  os << ' ';\n    });\n    os << ']';\n  }\n\n  template <class Tp> std::enable_if_t<!is_multidim_container_v<Tp>>\n\
    \  print(std::string_view name, const Tp& arg) {\n    os << name << \": \";\n\
    \    out(arg);\n    if constexpr (is_container_v<Tp>)\n      os << '\\n';\n  }\n\
    \n  template <class Tp> std::enable_if_t<is_multidim_container_v<Tp>>\n  print(std::string_view\
    \ name, const Tp& arg) {\n    os << name << \": \";\n    if (std::distance(std::cbegin(arg),\
    \ std::cend(arg)) == 0) {\n      os << \"<empty multidimensional container>\\\
    n\";\n      return;\n    }\n    std::for_each(std::cbegin(arg), std::cend(arg),\n\
    \      [&name, is_first_elem = true](const elem_t<Tp>& elem) mutable {\n     \
    \   if (is_first_elem)\n          is_first_elem = false;\n        else\n     \
    \     for (std::size_t i = 0; i < name.length() + 2; i++)\n            os << '\
    \ ';\n        out(elem);\n        os << '\\n';\n    });\n  }\n\n  template <class\
    \ Tp, class... Ts> void multi_print(std::string_view names, const Tp& arg, const\
    \ Ts&... args) {\n    if constexpr (sizeof...(Ts) == 0) {\n      names.remove_suffix(\n\
    \        std::distance(\n          names.crbegin(),\n          std::find_if_not(names.crbegin(),\
    \ names.crend(),\n                           [](const char c) { return std::isspace(c);\
    \ })\n        )\n      );\n      print(names, arg);\n      if constexpr (!is_container_v<Tp>)\n\
    \        os << '\\n';\n    } else {\n      std::size_t comma_pos = 0;\n\n    \
    \  for (std::size_t i = 0, paren_depth = 0, inside_quote = false; i < names.length();\
    \ i++) {\n        if (!inside_quote && paren_depth == 0 && i > 0 && names[i -\
    \ 1] != '\\'' && names[i] == ',') {\n          comma_pos = i;\n          break;\n\
    \        }\n        if (names[i] == '\\\"' || names[i] == '\\'') {\n         \
    \ if (i > 0 && names[i - 1] == '\\\\') continue;\n          inside_quote ^= true;\n\
    \        }\n        if (!inside_quote && names[i] == '(' && (i == 0 || names[i\
    \ - 1] != '\\''))\n          paren_depth++;\n        if (!inside_quote && names[i]\
    \ == ')' && (i == 0 || names[i - 1] != '\\''))\n          paren_depth--;\n   \
    \   }\n\n      const std::size_t first_varname_length = comma_pos - std::distance(\n\
    \        names.crend() - comma_pos,\n        std::find_if_not(\n          names.crend()\
    \ - comma_pos, names.crend(),\n          [](const char c) { return std::isspace(c);\
    \ }\n        )\n      );\n      print(names.substr(0, first_varname_length), arg);\n\
    \n      if constexpr (!is_container_v<Tp>) {\n        if constexpr (is_container_v<first_t<Ts...>>)\n\
    \          os << '\\n';\n        else\n          os << \" | \";\n      }\n\n \
    \     const std::size_t next_varname_begins_at = std::distance(\n        names.cbegin(),\n\
    \        std::find_if_not(\n          names.cbegin() + comma_pos + 1, names.cend(),\n\
    \          [](const char c) { return std::isspace(c); }\n        )\n      );\n\
    \      names.remove_prefix(next_varname_begins_at);\n\n      multi_print(names,\
    \ args...);\n    }\n  }\n}  // namespace debug_print\n\n#undef INCLUDED\n\n#endif\
    \  // DEBUG_PRINT_HPP\n\n#define dump(...) debug_print::multi_print(#__VA_ARGS__,\
    \ __VA_ARGS__)\n"
  code: "/* last update: 2022-08-03 */\n\n#ifndef DEBUG_PRINT_HPP\n#define DEBUG_PRINT_HPP\n\
    \n#define INCLUDED(n) ((defined _GLIBCXX_##n) || (defined _LIBCPP_##n))\n\n#if\
    \ __cplusplus < 201703L\n#  warning Please use C++17 (or later version).\n#endif\n\
    #if !INCLUDED(ALGORITHM)\n#  warning Please include <algorithm> before including\
    \ debug_print.hpp.\n#endif\n#if !INCLUDED(CCTYPE)\n#  warning Please include <cctype>\
    \ before including debug_print.hpp.\n#endif\n#if !INCLUDED(IOSTREAM)\n#  warning\
    \ Please include <iostream> before including debug_print.hpp.\n#endif\n#if !INCLUDED(ITERATOR)\n\
    #  warning Please include <iterator> before including debug_print.hpp.\n#endif\n\
    #if !INCLUDED(STRING_VIEW)\n#  warning Please include <string_view> before including\
    \ debug_print.hpp.\n#endif\n#if !INCLUDED(TYPE_TRAITS)\n#  warning Please include\
    \ <type_traits> before including debug_print.hpp.\n#endif\n\nnamespace debug_print\
    \ {\n  std::ostream& os = std::cerr;\n\n  template <class Tp> auto has_cbegin(int)\
    \     -> decltype(std::cbegin(std::declval<Tp>()), std::true_type {});\n  template\
    \ <class Tp> auto has_cbegin(...)     -> std::false_type;\n  template <class Tp>\
    \ auto has_value_type(int) -> decltype(std::declval<typename Tp::value_type>(),\
    \ std::true_type {});\n  template <class Tp> auto has_value_type(...) -> std::false_type;\n\
    \n  template <class Tp>[[maybe_unused]] constexpr bool is_iterable_container_v\
    \ = decltype(has_cbegin<Tp>(int {}))::value;\n  template <class Tp>[[maybe_unused]]\
    \ constexpr bool is_container_v          = decltype(has_value_type<Tp>(int {}))::value\n\
    \                                                                            \
    \   || is_iterable_container_v<Tp>;\n\n  template <>        [[maybe_unused]] constexpr\
    \ bool is_iterable_container_v<std::string_view> = false;\n  template <>     \
    \   [[maybe_unused]] constexpr bool is_container_v<std::string_view>         \
    \ = false;\n#if INCLUDED(STRING)\n  template <>        [[maybe_unused]] constexpr\
    \ bool is_iterable_container_v<std::string>      = false;\n  template <>     \
    \   [[maybe_unused]] constexpr bool is_container_v<std::string>              \
    \ = false;\n#endif\n\n  template <class Tp, class... Ts> struct first_element\
    \ { using type = Tp; };\n  template <class... Ts> using first_t = typename first_element<Ts...>::type;\n\
    \n  template <class Tp, std::enable_if_t<!decltype(has_value_type<Tp>(int {}))::value,\
    \ std::nullptr_t> = nullptr>\n    auto check_elem(int) -> decltype(*std::cbegin(std::declval<Tp>()));\n\
    \  template <class Tp, std::enable_if_t<decltype(has_value_type<Tp>(int {}))::value,\
    \ std::nullptr_t> = nullptr>\n    auto check_elem(int) -> typename Tp::value_type;\n\
    \  template <class Tp>\n    auto check_elem(...) -> void;\n\n  template <class\
    \ Tp> using elem_t = decltype(check_elem<Tp>(int {}));\n\n  template <class Tp>\
    \ [[maybe_unused]] constexpr bool is_multidim_container_v = is_container_v<Tp>\n\
    \                                                                            \
    \    && is_container_v<elem_t<Tp>>;\n\n  template <class Tp> std::enable_if_t<!is_container_v<Tp>>\
    \ out(const Tp&);\n  void out(const char&);\n  void out(const char*);\n  void\
    \ out(const std::string_view&);\n\n#if INCLUDED(STRING)\n  void out(const std::string&);\n\
    #endif\n\n#ifdef __SIZEOF_INT128__\n  void out(const __int128&);\n  void out(const\
    \ unsigned __int128&);\n#endif\n\n  template <class Tp1, class Tp2> void out(const\
    \ std::pair<Tp1, Tp2>&);\n\n#if INCLUDED(TUPLE)\n  template <class... Ts> void\
    \ out(const std::tuple<Ts...>&);\n#endif\n\n#if INCLUDED(STACK)\n  template <class...\
    \ Ts> void out(std::stack<Ts...>);\n#endif\n\n#if INCLUDED(QUEUE)\n  template\
    \ <class... Ts> void out(std::queue<Ts...>);\n  template <class... Ts> void out(std::priority_queue<Ts...>);\n\
    #endif\n\n  template <class C> std::enable_if_t<is_iterable_container_v<C>> out(const\
    \ C&);\n\n  template <class Tp> std::enable_if_t<!is_container_v<Tp>> out(const\
    \ Tp& arg) {\n    os << arg;\n  }\n\n  void out(const char& arg) {\n    os <<\
    \ '\\'' << arg << '\\'';\n  }\n\n  void out(const char* arg) {\n    os << '\\\"\
    ' << arg << '\\\"';\n  }\n\n  void out(const std::string_view& arg) {\n    os\
    \ << '\\\"' << arg << '\\\"';\n  }\n\n#if INCLUDED(STRING)\n  void out(const std::string&\
    \ arg) {\n    os << '\\\"' << arg << '\\\"';\n  }\n#endif\n\n#ifdef __SIZEOF_INT128__\n\
    \  void out(const __int128& arg) {\n    int sign = (arg < 0) ? (-1) : 1;\n   \
    \ if (sign == -1)\n      os << '-';\n    __int128 base = sign;\n    while (sign\
    \ * arg >= sign * base * 10)\n      base *= 10;\n    while (base) {\n      os\
    \ << static_cast<char>('0' + (arg / base % 10));\n      base /= 10;\n    }\n \
    \ }\n\n  void out(const unsigned __int128& arg) {\n    unsigned __int128 base\
    \ = 1;\n    while (arg >= base * 10)\n      base *= 10;\n    while (base) {\n\
    \      os << static_cast<char>('0' + (arg / base % 10));\n      base /= 10;\n\
    \    }\n  }\n#endif\n\n  template <class Tp1, class Tp2> void out(const std::pair<Tp1,\
    \ Tp2>& arg) {\n    os << '(';\n    out(arg.first);\n    os << \", \";\n    out(arg.second);\n\
    \    os << ')';\n  }\n\n#if INCLUDED(TUPLE)\n  template <class T, std::size_t...\
    \ Is> void print_tuple(const T& arg, std::index_sequence<Is...>) {\n    static_cast<void>(((os\
    \ << (Is == 0 ? \"\" : \", \"), out(std::get<Is>(arg))), ...));\n  }\n\n  template\
    \ <class... Ts> void out(const std::tuple<Ts...>& arg) {\n    os << '(';\n   \
    \ print_tuple(arg, std::make_index_sequence<sizeof...(Ts)>());\n    os << ')';\n\
    \  }\n#endif\n\n#if INCLUDED(STACK)\n  template <class... Ts> void out(std::stack<Ts...>\
    \ arg) {\n    if (arg.empty()) {\n      os << \"<empty stack>\";\n      return;\n\
    \    }\n    os << \"[ \";\n    while (!arg.empty()) {\n      out(arg.top());\n\
    \      os << ' ';\n      arg.pop();\n    }\n    os << ']';\n  }\n#endif\n\n#if\
    \ INCLUDED(QUEUE)\n  template <class... Ts> void out(std::queue<Ts...> arg) {\n\
    \    if (arg.empty()) {\n      os << \"<empty queue>\";\n      return;\n    }\n\
    \    os << \"[ \";\n    while (!arg.empty()) {\n      out(arg.front());\n    \
    \  os << ' ';\n      arg.pop();\n    }\n    os << ']';\n  }\n  template <class...\
    \ Ts> void out(std::priority_queue<Ts...> arg) {\n    if (arg.empty()) {\n   \
    \   os << \"<empty priority_queue>\";\n      return;\n    }\n    os << \"[ \"\
    ;\n    while (!arg.empty()) {\n      out(arg.top());\n      os << ' ';\n     \
    \ arg.pop();\n    }\n    os << ']';\n  }\n#endif\n\n  template <class Container>\n\
    \  std::enable_if_t<is_iterable_container_v<Container>> out(const Container& arg)\
    \ {\n    if (std::distance(std::cbegin(arg), std::cend(arg)) == 0) {\n      os\
    \ << \"<empty container>\";\n      return;\n    }\n    os << \"[ \";\n    std::for_each(std::cbegin(arg),\
    \ std::cend(arg), [](const elem_t<Container>& elem) {\n      out(elem);\n    \
    \  os << ' ';\n    });\n    os << ']';\n  }\n\n  template <class Tp> std::enable_if_t<!is_multidim_container_v<Tp>>\n\
    \  print(std::string_view name, const Tp& arg) {\n    os << name << \": \";\n\
    \    out(arg);\n    if constexpr (is_container_v<Tp>)\n      os << '\\n';\n  }\n\
    \n  template <class Tp> std::enable_if_t<is_multidim_container_v<Tp>>\n  print(std::string_view\
    \ name, const Tp& arg) {\n    os << name << \": \";\n    if (std::distance(std::cbegin(arg),\
    \ std::cend(arg)) == 0) {\n      os << \"<empty multidimensional container>\\\
    n\";\n      return;\n    }\n    std::for_each(std::cbegin(arg), std::cend(arg),\n\
    \      [&name, is_first_elem = true](const elem_t<Tp>& elem) mutable {\n     \
    \   if (is_first_elem)\n          is_first_elem = false;\n        else\n     \
    \     for (std::size_t i = 0; i < name.length() + 2; i++)\n            os << '\
    \ ';\n        out(elem);\n        os << '\\n';\n    });\n  }\n\n  template <class\
    \ Tp, class... Ts> void multi_print(std::string_view names, const Tp& arg, const\
    \ Ts&... args) {\n    if constexpr (sizeof...(Ts) == 0) {\n      names.remove_suffix(\n\
    \        std::distance(\n          names.crbegin(),\n          std::find_if_not(names.crbegin(),\
    \ names.crend(),\n                           [](const char c) { return std::isspace(c);\
    \ })\n        )\n      );\n      print(names, arg);\n      if constexpr (!is_container_v<Tp>)\n\
    \        os << '\\n';\n    } else {\n      std::size_t comma_pos = 0;\n\n    \
    \  for (std::size_t i = 0, paren_depth = 0, inside_quote = false; i < names.length();\
    \ i++) {\n        if (!inside_quote && paren_depth == 0 && i > 0 && names[i -\
    \ 1] != '\\'' && names[i] == ',') {\n          comma_pos = i;\n          break;\n\
    \        }\n        if (names[i] == '\\\"' || names[i] == '\\'') {\n         \
    \ if (i > 0 && names[i - 1] == '\\\\') continue;\n          inside_quote ^= true;\n\
    \        }\n        if (!inside_quote && names[i] == '(' && (i == 0 || names[i\
    \ - 1] != '\\''))\n          paren_depth++;\n        if (!inside_quote && names[i]\
    \ == ')' && (i == 0 || names[i - 1] != '\\''))\n          paren_depth--;\n   \
    \   }\n\n      const std::size_t first_varname_length = comma_pos - std::distance(\n\
    \        names.crend() - comma_pos,\n        std::find_if_not(\n          names.crend()\
    \ - comma_pos, names.crend(),\n          [](const char c) { return std::isspace(c);\
    \ }\n        )\n      );\n      print(names.substr(0, first_varname_length), arg);\n\
    \n      if constexpr (!is_container_v<Tp>) {\n        if constexpr (is_container_v<first_t<Ts...>>)\n\
    \          os << '\\n';\n        else\n          os << \" | \";\n      }\n\n \
    \     const std::size_t next_varname_begins_at = std::distance(\n        names.cbegin(),\n\
    \        std::find_if_not(\n          names.cbegin() + comma_pos + 1, names.cend(),\n\
    \          [](const char c) { return std::isspace(c); }\n        )\n      );\n\
    \      names.remove_prefix(next_varname_begins_at);\n\n      multi_print(names,\
    \ args...);\n    }\n  }\n}  // namespace debug_print\n\n#undef INCLUDED\n\n#endif\
    \  // DEBUG_PRINT_HPP\n\n#define dump(...) debug_print::multi_print(#__VA_ARGS__,\
    \ __VA_ARGS__)"
  dependsOn: []
  isVerificationFile: false
  path: C++/io/debug_print.hpp
  requiredBy: []
  timestamp: '2024-03-29 03:01:06+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: C++/io/debug_print.hpp
layout: document
redirect_from:
- /library/C++/io/debug_print.hpp
- /library/C++/io/debug_print.hpp.html
title: C++/io/debug_print.hpp
---
