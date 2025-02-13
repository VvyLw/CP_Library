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
  code: "import bitops, algorithm\nproc `|`(x: int, y: int): int = x or y\nproc `&`(x:\
    \ int, y: int): int = x and y\nproc `>>`(x: int, y: int): int = x shr y\nproc\
    \ `<<`(x: int, y: int): int = x shl y\nproc `|=`(x: var int, y: int): void = x\
    \ = x | y\nproc `?`(x: bool): int =\n    if x: 1\n    else: 0\ntype Pair[F, S]\
    \ = ref object\n    first*: F\n    second*: S\nproc initPair[F, S](f: F, s: S):\
    \ Pair[F, S] {.inline} = Pair[F, S](first: f, second: s)\ntype SIDict = ref object\n\
    \    blk: int\n    bit, sum: seq[int]\nproc initSIDict(n: int): SIDict {.inline}\
    \ =\n    var sid = new SIDict\n    sid.blk = (n + 31) >> 5\n    sid.bit.setLen((n\
    \ + 31) >> 5)\n    sid.sum.setLen((n + 31) >> 5)\n    sid\nproc set(sid: SIDict,\
    \ i: int) {.inline} = sid.bit[i >> 5] |= 1 << (i & 31)\nproc build(sid: SIDict)\
    \ {.inline} =\n    sid.sum[0] = 0\n    for i in 0..<sid.blk - 1: sid.sum[i + 1]\
    \ = sid.sum[i] + popcount(sid.bit[i])\nproc `[]`(sid: SIDict, i: int): bool {.inline}\
    \ = ((sid.bit[i >> 5] >> (i & 31)) & 1) == 1\nproc rank(sid: SIDict, i: int):\
    \ int {.inline} = (sid.sum[i >> 5] + popcount(sid.bit[i >> 5] & ((1 << (i & 31))\
    \ - 1)))\nproc rank(sid: SIDict, val: bool, i: int): int {.inline} =\n    if val:\
    \ sid.rank(i)\n    else: i - sid.rank(i)\ntype WMBeta = ref object\n    log: int\n\
    \    mat: seq[SIDict]\n    mid: seq[int]\nproc initWMBeta(arr: seq[int], log:\
    \ int): WMBeta {.inline} =\n    var wmb = new WMBeta\n    var a = arr\n    let\
    \ len = len(a)\n    wmb.log = log\n    wmb.mat.setLen(log)\n    wmb.mid.setLen(log)\n\
    \    var l, r: seq[int]\n    l.setLen(len)\n    r.setLen(len)\n    for level in\
    \ countdown(log - 1, 0):\n        wmb.mat[level] = initSIDict(len + 1)\n     \
    \   var left, right: int\n        left = 0\n        right = 0\n        for i in\
    \ 0..<len:\n            if ((a[i] >> level) & 1) == 1:\n                wmb.mat[level].set(i)\n\
    \                r[right] = a[i]\n                right += 1\n            else:\n\
    \                l[left] = a[i]\n                left += 1\n        wmb.mid[level]\
    \ = left;\n        wmb.mat[level].build();\n        swap(a, l)\n        for i\
    \ in 0..<right: a[left + i] = r[i]\n    wmb\nproc `[]`(wmb: WMBeta, i: int): int\
    \ {.inline} =\n    var res, k: int\n    res = 0\n    k = i\n    for level in countdown(wmb.log\
    \ - 1, 0):\n        let f = wmb.mat[level][k]\n        if f: res |= 1 << level\n\
    \        k = wmb.mat[level].rank(f, k) + wmb.mid[level] * ?f\n    res\nproc succ(wmb:\
    \ WMBeta, f: bool, l: int, r: int, level: int): Pair[int, int] {.inline} = initPair(wmb.mat[level].rank(f,\
    \ l) + wmb.mid[level] * ?f, wmb.mat[level].rank(f, r) + wmb.mid[level] * ?f)\n\
    proc rank(wmb: WMBeta, x: int, id: int): int {.inline} =\n    var l = 0\n    var\
    \ r = id\n    for level in countdown(wmb.log - 1, 0):\n        let p = wmb.succ((x\
    \ >> level) & 1 == 1, l, r, level)\n        l = p.first\n        r = p.second\n\
    \    r - l\nproc kthMin(wmb: WMBeta, a: int, b: int, i: int): int {.inline} =\n\
    \    assert 0 <= i and i < b - a\n    var l, r, k, ret: int\n    l = a\n    r\
    \ = b\n    k = i\n    ret = 0\n    for level in countdown(wmb.log - 1, 0):\n \
    \       let cnt = wmb.mat[level].rank(false, r) - wmb.mat[level].rank(false, l)\n\
    \        let f = cnt <= k\n        if f:\n            ret |= 1 << level\n    \
    \        k -= cnt\n        let p = wmb.succ(f, l, r, level)\n        l = p.first\n\
    \        r = p.second\n    ret\nproc kthMax(wmb: WMBeta, l: int, r: int, k: int):\
    \ int {.inline} = wmb.kthMin(l, r, r - l - k - 1)\nproc rangeFreq(wmb: WMBeta,\
    \ a: int, b: int, upper: int): int {.inline} =\n    var l, r, ret: int\n    l\
    \ = a\n    r = b\n    ret = 0\n    for level in countdown(wmb.log - 1, 0):\n \
    \       let f = upper >> level & 1 == 1\n        if f: ret += wmb.mat[level].rank(false,\
    \ r) - wmb.mat[level].rank(false, l)\n        let p = wmb.succ(f, l, r, level)\n\
    \        l = p.first\n        r = p.second\n    ret\nproc rangeFreq(wmb: WMBeta,\
    \ l: int, r: int, lower: int, upper: int): int {.inline} = wmb.rangeFreq(l, r,\
    \ upper) - wmb.rangeFreq(l, r, lower)\nproc prev(wmb: WMBeta, l: int, r: int,\
    \ upper: int): int {.inline} =\n    let cnt = wmb.rangeFreq(l, r, upper)\n   \
    \ if cnt == 0: -1\n    else: wmb.kthMin(l, r, cnt - 1)\nproc next(wmb: WMBeta,\
    \ l: int, r: int, lower: int): int {.inline} =\n    let cnt = wmb.rangeFreq(l,\
    \ r, lower)\n    if cnt == 0: r - l\n    else: wmb.kthMin(l, r, cnt)\ntype WaveletMatrix\
    \ = ref object\n    mat: WMBeta\n    ys: seq[int]\nproc get(wm: WaveletMatrix,\
    \ x: int): int {.inline} = lowerBound(wm.ys, x)\nproc uniq(a: openArray[int]):\
    \ seq[int] {.inline} =\n    var res: seq[int]\n    var j = -1\n    if len(a) >\
    \ 0:\n        j = 0\n        res.add(a[0])\n    for i, el in a:\n        if a[j]\
    \ == el: continue\n        j = i\n        res.add(el)\n    res\nproc initWaveletMatrix*(a:\
    \ seq[int], log: int = 20): WaveletMatrix {.inline} =\n    var wm = new WaveletMatrix\n\
    \    wm.ys = sorted(a).uniq\n    var t = newSeq[int](len(a))\n    for i, el in\
    \ a: t[i] = wm.get(el)\n    wm.mat = initWMBeta(t, log)\n    wm\nproc `[]`*(wm:\
    \ WaveletMatrix, i: int): int {.inline} = wm.ys[wm.mat[i]]\nproc rank*(wm: WaveletMatrix,\
    \ r: int, x: int): int {.inline} =\n    let pos = wm.get(x)\n    if pos == len(wm.ys)\
    \ or wm.ys[pos] != x: 0\n    else: wm.mat.rank(pos, r)\nproc rank*(wm: WaveletMatrix,\
    \ l: int, r: int, x: int): int {.inline} = wm.rank(r, x) - wm.rank(l, x)\nproc\
    \ kthMin*(wm: WaveletMatrix, l: int, r: int, k: int): int {.inline} = wm.ys[wm.mat.kthMin(l,\
    \ r, k)]\nproc kthMax*(wm: WaveletMatrix, l: int, r: int, k: int): int {.inline}\
    \ = wm.ys[wm.mat.kthMax(l, r, k)]\nproc rangeFreq*(wm: WaveletMatrix, l: int,\
    \ r: int, upper: int): int {.inline} = wm.mat.rangeFreq(l, r, wm.get(upper))\n\
    proc rangeFreq*(wm: WaveletMatrix, l: int, r: int, lower: int, upper: int): int\
    \ {.inline} = wm.mat.rangeFreq(l, r, wm.get(lower), wm.get(upper))\nproc prev*(wm:\
    \ WaveletMatrix, l: int, r: int, upper: int): int {.inline} =\n    let ret = wm.mat.prev(l,\
    \ r, wm.get(upper))\n    if ret == -1: -1\n    else: wm.ys[ret]\nproc next*(wm:\
    \ WaveletMatrix, l: int, r: int, lower: int): int {.inline} =\n    let ret = wm.mat.next(l,\
    \ r, wm.get(lower))\n    if ret == -1: -1\n    else: wm.ys[ret]"
  dependsOn: []
  isVerificationFile: false
  path: Nim/WaveletMatrix.nim
  requiredBy: []
  timestamp: '2024-03-10 21:06:06+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: Nim/WaveletMatrix.nim
layout: document
redirect_from:
- /library/Nim/WaveletMatrix.nim
- /library/Nim/WaveletMatrix.nim.html
title: Nim/WaveletMatrix.nim
---
