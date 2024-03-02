import sequtils
type UnionFind = ref object
    par: seq[int]
proc initUnionFind*(n: int): UnionFind {.inline} = UnionFind(par: newSeqWith(n, -1))
proc `[]`*(uf: UnionFind, k: int): int {.inline} =
    var i = k
    while uf.par[i] >= 0:
        let p = uf.par[uf.par[i]]
        if p < 0: return uf.par[i]
        uf.par[i] = p
        i = p
    i
proc size*(uf: UnionFind, i: int): int {.inline} = -uf.par[uf[i]]
proc unite*(uf: UnionFind, i: int, j: int) {.inline} =
    var x = uf[i]
    var y = uf[j]
    if x == y: return
    if x > y: swap(x, y)
    uf.par[x] += uf.par[y]
    uf.par[y] = x
proc groups*(uf: UnionFind): seq[seq[int]] {.inline} =
    let n = uf.par.len
    var res = newSeq[seq[int]](n)
    for i in 0..<n: res[uf[i]].add(i)
    res.filterIt(it.len > 0)

proc isBipartite*(uf: UnionFind): bool {.inline} =
    assert(uf.par.len mod 2 == 0)
    let n = uf.par.len div 2
    var ok = true
    for i in 0..<n: ok = ok and uf[i] != uf[i + n]
    ok