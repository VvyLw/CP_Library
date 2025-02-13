---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: nim
  _verificationStatusIcon: ':warning:'
  attributes:
    links: []
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.12/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n          \
    \         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\
    \  File \"/home/runner/.local/lib/python3.12/site-packages/onlinejudge_verify/languages/nim.py\"\
    , line 86, in bundle\n    raise NotImplementedError\nNotImplementedError\n"
  code: "import sequtils\ntype UnionFind = ref object\n    par: seq[int]\nproc initUnionFind*(n:\
    \ int): UnionFind {.inline} = UnionFind(par: newSeqWith(n, -1))\nproc `[]`*(uf:\
    \ UnionFind, k: int): int {.inline} =\n    var i = k\n    while uf.par[i] >= 0:\n\
    \        let p = uf.par[uf.par[i]]\n        if p < 0: return uf.par[i]\n     \
    \   uf.par[i] = p\n        i = p\n    i\nproc size*(uf: UnionFind, i: int): int\
    \ {.inline} = -uf.par[uf[i]]\nproc unite*(uf: UnionFind, i: int, j: int) {.inline}\
    \ =\n    var x = uf[i]\n    var y = uf[j]\n    if x == y: return\n    if x > y:\
    \ swap(x, y)\n    uf.par[x] += uf.par[y]\n    uf.par[y] = x\nproc groups*(uf:\
    \ UnionFind): seq[seq[int]] {.inline} =\n    let n = uf.par.len\n    var res =\
    \ newSeq[seq[int]](n)\n    for i in 0..<n: res[uf[i]].add(i)\n    res.filterIt(it.len\
    \ > 0)\n\nproc isBipartite*(uf: UnionFind): bool {.inline} =\n    assert(uf.par.len\
    \ mod 2 == 0)\n    let n = uf.par.len div 2\n    var ok = true\n    for i in 0..<n:\
    \ ok = ok and uf[i] != uf[i + n]\n    ok"
  dependsOn: []
  isVerificationFile: false
  path: Nim/UnionFind.nim
  requiredBy: []
  timestamp: '2024-03-02 10:34:23+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: Nim/UnionFind.nim
layout: document
redirect_from:
- /library/Nim/UnionFind.nim
- /library/Nim/UnionFind.nim.html
title: Nim/UnionFind.nim
---
