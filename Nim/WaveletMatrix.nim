import bitops, algorithm
proc `|`(x: int, y: int): int = x or y
proc `&`(x: int, y: int): int = x and y
proc `>>`(x: int, y: int): int = x shr y
proc `<<`(x: int, y: int): int = x shl y
proc `|=`(x: var int, y: int): void = x = x | y
proc `?`(x: bool): int =
    if x: 1
    else: 0
type Pair[F, S] = ref object
    first*: F
    second*: S
proc initPair[F, S](f: F, s: S): Pair[F, S] {.inline} = Pair[F, S](first: f, second: s)
type SIDict = ref object
    blk: int
    bit, sum: seq[int]
proc initSIDict(n: int): SIDict {.inline} =
    var sid = new SIDict
    sid.blk = (n + 31) >> 5
    sid.bit.setLen((n + 31) >> 5)
    sid.sum.setLen((n + 31) >> 5)
    sid
proc set(sid: SIDict, i: int) {.inline} = sid.bit[i >> 5] |= 1 << (i & 31)
proc build(sid: SIDict) {.inline} =
    sid.sum[0] = 0
    for i in 0..<sid.blk - 1: sid.sum[i + 1] = sid.sum[i] + popcount(sid.bit[i])
proc `[]`(sid: SIDict, i: int): bool {.inline} = ((sid.bit[i >> 5] >> (i & 31)) & 1) == 1
proc rank(sid: SIDict, i: int): int {.inline} = (sid.sum[i >> 5] + popcount(sid.bit[i >> 5] & ((1 << (i & 31)) - 1)))
proc rank(sid: SIDict, val: bool, i: int): int {.inline} =
    if val: sid.rank(i)
    else: i - sid.rank(i)
type WMBeta = ref object
    log: int
    mat: seq[SIDict]
    mid: seq[int]
proc initWMBeta(arr: seq[int], log: int): WMBeta {.inline} =
    var wmb = new WMBeta
    var a = arr
    let len = len(a)
    wmb.log = log
    wmb.mat.setLen(log)
    wmb.mid.setLen(log)
    var l, r: seq[int]
    l.setLen(len)
    r.setLen(len)
    for level in countdown(log - 1, 0):
        wmb.mat[level] = initSIDict(len + 1)
        var left, right: int
        left = 0
        right = 0
        for i in 0..<len:
            if ((a[i] >> level) & 1) == 1:
                wmb.mat[level].set(i)
                r[right] = a[i]
                right += 1
            else:
                l[left] = a[i]
                left += 1
        wmb.mid[level] = left;
        wmb.mat[level].build();
        swap(a, l)
        for i in 0..<right: a[left + i] = r[i]
    wmb
proc `[]`(wmb: WMBeta, i: int): int {.inline} =
    var res, k: int
    res = 0
    k = i
    for level in countdown(wmb.log - 1, 0):
        let f = wmb.mat[level][k]
        if f: res |= 1 << level
        k = wmb.mat[level].rank(f, k) + wmb.mid[level] * ?f
    res
proc succ(wmb: WMBeta, f: bool, l: int, r: int, level: int): Pair[int, int] {.inline} = initPair(wmb.mat[level].rank(f, l) + wmb.mid[level] * ?f, wmb.mat[level].rank(f, r) + wmb.mid[level] * ?f)
proc rank(wmb: WMBeta, x: int, id: int): int {.inline} =
    var l = 0
    var r = id
    for level in countdown(wmb.log - 1, 0):
        let p = wmb.succ((x >> level) & 1 == 1, l, r, level)
        l = p.first
        r = p.second
    r - l
proc kthMin(wmb: WMBeta, a: int, b: int, i: int): int {.inline} =
    assert 0 <= i and i < b - a
    var l, r, k, ret: int
    l = a
    r = b
    k = i
    ret = 0
    for level in countdown(wmb.log - 1, 0):
        let cnt = wmb.mat[level].rank(false, r) - wmb.mat[level].rank(false, l)
        let f = cnt <= k
        if f:
            ret |= 1 << level
            k -= cnt
        let p = wmb.succ(f, l, r, level)
        l = p.first
        r = p.second
    ret
proc kthMax(wmb: WMBeta, l: int, r: int, k: int): int {.inline} = wmb.kthMin(l, r, r - l - k - 1)
proc rangeFreq(wmb: WMBeta, a: int, b: int, upper: int): int {.inline} =
    var l, r, ret: int
    l = a
    r = b
    ret = 0
    for level in countdown(wmb.log - 1, 0):
        let f = upper >> level & 1 == 1
        if f: ret += wmb.mat[level].rank(false, r) - wmb.mat[level].rank(false, l)
        let p = wmb.succ(f, l, r, level)
        l = p.first
        r = p.second
    ret
proc rangeFreq(wmb: WMBeta, l: int, r: int, lower: int, upper: int): int {.inline} = wmb.rangeFreq(l, r, upper) - wmb.rangeFreq(l, r, lower)
proc prev(wmb: WMBeta, l: int, r: int, upper: int): int {.inline} =
    let cnt = wmb.rangeFreq(l, r, upper)
    if cnt == 0: -1
    else: wmb.kthMin(l, r, cnt - 1)
proc next(wmb: WMBeta, l: int, r: int, lower: int): int {.inline} =
    let cnt = wmb.rangeFreq(l, r, lower)
    if cnt == 0: r - l
    else: wmb.kthMin(l, r, cnt)
type WaveletMatrix = ref object
    mat: WMBeta
    ys: seq[int]
proc get(wm: WaveletMatrix, x: int): int {.inline} = lowerBound(wm.ys, x)
proc uniq(a: openArray[int]): seq[int] {.inline} =
    var res: seq[int]
    var j = -1
    if len(a) > 0:
        j = 0
        res.add(a[0])
    for i, el in a:
        if a[j] == el: continue
        j = i
        res.add(el)
    res
proc initWaveletMatrix*(a: seq[int], log: int = 20): WaveletMatrix {.inline} =
    var wm = new WaveletMatrix
    wm.ys = sorted(a).uniq
    var t = newSeq[int](len(a))
    for i, el in a: t[i] = wm.get(el)
    wm.mat = initWMBeta(t, log)
    wm
proc `[]`*(wm: WaveletMatrix, i: int): int {.inline} = wm.ys[wm.mat[i]]
proc rank*(wm: WaveletMatrix, r: int, x: int): int {.inline} =
    let pos = wm.get(x)
    if pos == len(wm.ys) or wm.ys[pos] != x: 0
    else: wm.mat.rank(pos, r)
proc rank*(wm: WaveletMatrix, l: int, r: int, x: int): int {.inline} = wm.rank(r, x) - wm.rank(l, x)
proc kthMin*(wm: WaveletMatrix, l: int, r: int, k: int): int {.inline} = wm.ys[wm.mat.kthMin(l, r, k)]
proc kthMax*(wm: WaveletMatrix, l: int, r: int, k: int): int {.inline} = wm.ys[wm.mat.kthMax(l, r, k)]
proc rangeFreq*(wm: WaveletMatrix, l: int, r: int, upper: int): int {.inline} = wm.mat.rangeFreq(l, r, wm.get(upper))
proc rangeFreq*(wm: WaveletMatrix, l: int, r: int, lower: int, upper: int): int {.inline} = wm.mat.rangeFreq(l, r, wm.get(lower), wm.get(upper))
proc prev*(wm: WaveletMatrix, l: int, r: int, upper: int): int {.inline} =
    let ret = wm.mat.prev(l, r, wm.get(upper))
    if ret == -1: -1
    else: wm.ys[ret]
proc next*(wm: WaveletMatrix, l: int, r: int, lower: int): int {.inline} =
    let ret = wm.mat.next(l, r, wm.get(lower))
    if ret == -1: -1
    else: wm.ys[ret]