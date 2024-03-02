---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: py
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/unionfind
    links:
    - https://judge.yosupo.jp/problem/unionfind
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/python.py\"\
    , line 96, in bundle\n    raise NotImplementedError\nNotImplementedError\n"
  code: "# verification-helper: PROBLEM https://judge.yosupo.jp/problem/unionfind\n\
    class UnionFind:\n    def __init__(self, n: int) -> None: self.__par = [-1] *\
    \ n\n    def __len__(self) -> int: return len(self.__par)\n    def root(self,\
    \ i: int) -> int:\n        if self.__par[i] >= 0:\n            self.__par[i] =\
    \ self.root(self.__par[i])\n            return self.__par[i]\n        return i\n\
    \    def size(self, i: int) -> int: return -self.__par[self.root(i)]\n    def\
    \ unite(self, i: int, j: int) -> bool:\n        i = self.root(i)\n        j =\
    \ self.root(j)\n        if i == j: return False\n        if i > j: i, j = j, i\n\
    \        self.__par[i] += self.__par[j]\n        self.__par[j] = i\n        return\
    \ True\n    def same(self, i: int, j: int) -> bool: return self.root(i) == self.root(j)\n\
    \    def groups(self) -> list[list[int]]:\n        n = len(self.__par)\n     \
    \   res = [[] for _ in range(n)]\n        for i in range(n): res[self.root(i)].append(i)\n\
    \        return list(filter(lambda x: x, res))\n\ndef is_bipartite(uf: UnionFind)\
    \ -> bool:\n    assert len(uf) % 2 == 0\n    n = len(uf) // 2\n    ok = True\n\
    \    for i in range(n): ok &= not uf.same(i, i + n)\n    return ok\n\nn, q = map(int,\
    \ input().split())\nuf = UnionFind(n)\nfor _ in range(q):\n    t, u, v = map(int,\
    \ input().split())\n    if t == 0: uf.unite(u, v)\n    else: print(1 if uf.same(u,\
    \ v) else 0)"
  dependsOn: []
  isVerificationFile: true
  path: test/Python/UnionFind.test.py
  requiredBy: []
  timestamp: '2024-03-03 06:22:53+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: test/Python/UnionFind.test.py
layout: document
redirect_from:
- /verify/test/Python/UnionFind.test.py
- /verify/test/Python/UnionFind.test.py.html
title: test/Python/UnionFind.test.py
---
