---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: nim
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/unionfind
    links:
    - https://judge.yosupo.jp/problem/unionfind
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/nim.py\"\
    , line 86, in bundle\n    raise NotImplementedError\nNotImplementedError\n"
  code: "# verification-helper: PROBLEM https://judge.yosupo.jp/problem/unionfind\n\
    import strutils, sequtils\n# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\
    \ #\ntype UnionFind = ref object\n    par: seq[int]\nproc initUnionFind*(n: int):\
    \ UnionFind {.inline} = UnionFind(par: newSeqWith(n, -1))\nproc `[]`*(uf: UnionFind,\
    \ k: int): int {.inline} =\n    var i = k\n    while uf.par[i] >= 0:\n       \
    \ let p = uf.par[uf.par[i]]\n        if p < 0: return uf.par[i]\n        uf.par[i]\
    \ = p\n        i = p\n    i\nproc size*(uf: UnionFind, i: int): int {.inline}\
    \ = -uf.par[uf[i]]\nproc unite*(uf: UnionFind, i: int, j: int) {.inline} =\n \
    \   var x = uf[i]\n    var y = uf[j]\n    if x == y: return\n    if x > y: swap(x,\
    \ y)\n    uf.par[x] += uf.par[y]\n    uf.par[y] = x\nproc groups*(uf: UnionFind):\
    \ seq[seq[int]] {.inline} =\n    let n = uf.par.len\n    var res = newSeq[seq[int]](n)\n\
    \    for i in 0..<n: res[uf[i]].add(i)\n    res.filterIt(it.len > 0)\n\nproc isBipartite*(uf:\
    \ UnionFind): bool {.inline} =\n    assert(uf.par.len mod 2 == 0)\n    let n =\
    \ uf.par.len div 2\n    var ok = true\n    for i in 0..<n: ok = ok and uf[i] !=\
    \ uf[i + n]\n    ok\n# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\
    \ #\nlet nq = stdin.readLine.split.map parseInt\nlet n = nq[0]\nlet q = nq[1]\n\
    var uf = initUnionFind(n)\nfor _ in 0..<q:\n    let tuv = stdin.readLine.split.map\
    \ parseInt\n    let t = tuv[0]\n    let u = tuv[1]\n    let v = tuv[2]\n    if\
    \ t == 0: uf.unite(u, v)\n    else:\n        if uf[u] == uf[v]: echo 1\n     \
    \   else: echo 0"
  dependsOn: []
  isVerificationFile: true
  path: test/Nim/UnionFind_test.nim
  requiredBy: []
  timestamp: '2024-03-02 19:12:32+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: test/Nim/UnionFind_test.nim
layout: document
redirect_from:
- /verify/test/Nim/UnionFind_test.nim
- /verify/test/Nim/UnionFind_test.nim.html
title: test/Nim/UnionFind_test.nim
---
