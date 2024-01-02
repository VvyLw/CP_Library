---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: Java/all.java
    title: Java/all.java
  - icon: ':warning:'
    path: Java/extension/AVLTree.java
    title: Java/extension/AVLTree.java
  - icon: ':warning:'
    path: Java/extension/DoubleEndedPriorityQueue.java
    title: Java/extension/DoubleEndedPriorityQueue.java
  - icon: ':warning:'
    path: Java/extension/EulerPhiTable.java
    title: Java/extension/EulerPhiTable.java
  - icon: ':warning:'
    path: Java/extension/FenwickTree.java
    title: Java/extension/FenwickTree.java
  - icon: ':warning:'
    path: Java/extension/Graph.java
    title: Java/extension/Graph.java
  - icon: ':warning:'
    path: Java/extension/Huitloxopetl.java
    title: Java/extension/Huitloxopetl.java
  - icon: ':warning:'
    path: Java/extension/LargePrime.java
    title: Java/extension/LargePrime.java
  - icon: ':warning:'
    path: Java/extension/LowestCommonAncestor.java
    title: Java/extension/LowestCommonAncestor.java
  - icon: ':warning:'
    path: Java/extension/PrefixSum.java
    title: Java/extension/PrefixSum.java
  - icon: ':warning:'
    path: Java/extension/PrimeCounter.java
    title: Java/extension/PrimeCounter.java
  - icon: ':warning:'
    path: Java/extension/PrimeFactor.java
    title: Java/extension/PrimeFactor.java
  - icon: ':warning:'
    path: Java/extension/PrimeTable.java
    title: Java/extension/PrimeTable.java
  - icon: ':warning:'
    path: Java/extension/SegmentTree.java
    title: Java/extension/SegmentTree.java
  - icon: ':warning:'
    path: Java/extension/SparseTable.java
    title: Java/extension/SparseTable.java
  - icon: ':warning:'
    path: Java/extension/SuffixArray.java
    title: Java/extension/SuffixArray.java
  - icon: ':warning:'
    path: Java/extension/Template.java
    title: Java/extension/Template.java
  - icon: ':warning:'
    path: Java/extension/UndoUnionFind.java
    title: Java/extension/UndoUnionFind.java
  - icon: ':warning:'
    path: Java/extension/UnionFind.java
    title: Java/extension/UnionFind.java
  - icon: ':warning:'
    path: Java/extension/WaveletMatrix.java
    title: Java/extension/WaveletMatrix.java
  - icon: ':warning:'
    path: Java/extension/WeightedGraph.java
    title: Java/extension/WeightedGraph.java
  - icon: ':warning:'
    path: Java/extension/WeightedUnionFind.java
    title: Java/extension/WeightedUnionFind.java
  _extendedRequiredBy:
  - icon: ':warning:'
    path: Java/all.java
    title: Java/all.java
  - icon: ':warning:'
    path: Java/extension/AVLTree.java
    title: Java/extension/AVLTree.java
  - icon: ':warning:'
    path: Java/extension/DoubleEndedPriorityQueue.java
    title: Java/extension/DoubleEndedPriorityQueue.java
  - icon: ':warning:'
    path: Java/extension/EulerPhiTable.java
    title: Java/extension/EulerPhiTable.java
  - icon: ':warning:'
    path: Java/extension/FenwickTree.java
    title: Java/extension/FenwickTree.java
  - icon: ':warning:'
    path: Java/extension/Graph.java
    title: Java/extension/Graph.java
  - icon: ':warning:'
    path: Java/extension/Huitloxopetl.java
    title: Java/extension/Huitloxopetl.java
  - icon: ':warning:'
    path: Java/extension/LargePrime.java
    title: Java/extension/LargePrime.java
  - icon: ':warning:'
    path: Java/extension/LowestCommonAncestor.java
    title: Java/extension/LowestCommonAncestor.java
  - icon: ':warning:'
    path: Java/extension/PrefixSum.java
    title: Java/extension/PrefixSum.java
  - icon: ':warning:'
    path: Java/extension/PrimeCounter.java
    title: Java/extension/PrimeCounter.java
  - icon: ':warning:'
    path: Java/extension/PrimeFactor.java
    title: Java/extension/PrimeFactor.java
  - icon: ':warning:'
    path: Java/extension/PrimeTable.java
    title: Java/extension/PrimeTable.java
  - icon: ':warning:'
    path: Java/extension/SegmentTree.java
    title: Java/extension/SegmentTree.java
  - icon: ':warning:'
    path: Java/extension/SparseTable.java
    title: Java/extension/SparseTable.java
  - icon: ':warning:'
    path: Java/extension/SuffixArray.java
    title: Java/extension/SuffixArray.java
  - icon: ':warning:'
    path: Java/extension/Template.java
    title: Java/extension/Template.java
  - icon: ':warning:'
    path: Java/extension/UndoUnionFind.java
    title: Java/extension/UndoUnionFind.java
  - icon: ':warning:'
    path: Java/extension/UnionFind.java
    title: Java/extension/UnionFind.java
  - icon: ':warning:'
    path: Java/extension/WaveletMatrix.java
    title: Java/extension/WaveletMatrix.java
  - icon: ':warning:'
    path: Java/extension/WeightedGraph.java
    title: Java/extension/WeightedGraph.java
  - icon: ':warning:'
    path: Java/extension/WeightedUnionFind.java
    title: Java/extension/WeightedUnionFind.java
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':warning:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/home/runner/.local/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: Java/extension/Deque.java\n"
  code: "package extension;\n\nimport java.util.Arrays;\nimport java.util.Iterator;\n\
    import java.util.NoSuchElementException;\n\nfinal class Deque<T> implements Iterable<T>\
    \ {\n\tprivate int n, head, tail;\n\tprivate Object[] buf;\n\tDeque(){ this(1\
    \ << 17); }\n\tDeque(final int n) {\n\t\tthis.n = n;\n\t\thead = tail = 0;\n\t\
    \tbuf = new Object[n];\n\t}\n\tDeque(final T[] a) {\n\t\tthis(a.length);\n\t\t\
    Arrays.stream(a).forEach(i -> add(i));\n\t}\n\tprivate final int next(final int\
    \ index) {\n\t\tfinal int next = index + 1;\n\t\treturn next == n ? 0 : next;\n\
    \t}\n\tprivate final int prev(final int index) {\n\t\tfinal int prev = index -\
    \ 1;\n\t\treturn prev == -1 ? n - 1 : prev;\n\t}\n\tprivate final int index(final\
    \ int i) {\n\t\tfinal int size = size();\n\t\tif(i >= size) {\n\t\t\tthrow new\
    \ IndexOutOfBoundsException(\"Index \"+ i +\" out of bounds for length \" + size);\n\
    \t\t}\n\t\tfinal int id = head + i;\n\t\treturn n <= id ? id - n : id;\n\t}\n\t\
    private final void extend() {\n\t\tbuf = Arrays.copyOf(buf, n << 1);\n\t\tn =\
    \ buf.length;\n\t}\n\tfinal boolean isEmpty(){ return size() == 0; }\n\tfinal\
    \ int size() {\n\t\tfinal int size = tail - head;\n\t\treturn size < 0 ? size\
    \ + n : size;\n\t}\n\tfinal void addFirst(final T x) {\n\t\thead = prev(head);\n\
    \t\tif(head == tail) {\n\t\t\textend();\n\t\t}\n\t\tbuf[head] = x;\n\t}\n\tfinal\
    \ void addLast(final T x) {\n\t\tif(next(tail) == head) {\n\t\t\textend();\n\t\
    \t}\n\t\tbuf[tail] = x;\n\t\ttail = next(tail);\n\t}\n\tfinal void removeFirst()\
    \ {\n\t\tif(head == tail) {\n\t\t\tthrow new NoSuchElementException(\"Buffer is\
    \ empty\");\n\t\t}\n\t\thead = next(head);\n\t}\n\tfinal void removeLast() {\n\
    \t\tif(head == tail) {\n\t\t\tthrow new NoSuchElementException(\"Buffer is empty\"\
    );\n\t\t}\n\t\ttail = prev(tail);\n\t}\n\t@SuppressWarnings(\"unchecked\")\n\t\
    final T pollFirst() {\n\t\tif(head == tail) {\n\t\t\tthrow new NoSuchElementException(\"\
    Buffer is empty\");\n\t\t}\n\t\tfinal T ans = (T) buf[head];\n\t\thead = next(head);\n\
    \t\treturn ans;\n\t}\n\t@SuppressWarnings(\"unchecked\")\n\tfinal T pollLast()\
    \ {\n\t\tif(head == tail) {\n\t\t\tthrow new NoSuchElementException(\"Buffer is\
    \ empty\");\n\t\t}\n\t\ttail = prev(tail);\n\t\treturn (T) buf[tail];\n\t}\n\t\
    final T peekFirst(){ return get(0); }\n\tfinal T peekLast(){ return get(n - 1);\
    \ }\n\t@SuppressWarnings(\"unchecked\")\n\tfinal T get(final int i){ return (T)\
    \ buf[index(i)]; }\n\tfinal void set(final int i, final T x){ buf[index(i)] =\
    \ x; }\n\tfinal void add(final T x){ addLast(x); }\n\tfinal T poll(){ return pollFirst();\
    \ }\n\tfinal T peek(){ return peekFirst(); }\n\t@SuppressWarnings(\"unchecked\"\
    )\n\tfinal void swap(final int a, final int b) {\n\t\tfinal int i = index(a);\n\
    \t\tfinal int j = index(b);\n\t\tfinal T num = (T) buf[i];\n\t\tbuf[i] = buf[j];\n\
    \t\tbuf[j] = num;\n\t}\n\tfinal void clear(){ head = tail = 0; }\n\t@SuppressWarnings(\"\
    unchecked\")\n\tfinal T[] toArray(){ return (T[]) Arrays.copyOf(buf, size());\
    \ }\n\t@Override\n\tpublic final String toString(){ return Arrays.toString(toArray());\
    \ }\n\t@Override\n\tpublic final Iterator<T> iterator(){ return new DequeIterator();\
    \ }\n\tprivate class DequeIterator implements Iterator<T> {\n\t\tprivate int now\
    \ = head;\n\t\tprivate int rem = size();\n\t\t@Override\n\t\tpublic boolean hasNext(){\
    \ return rem > 0; }\n\t\t@Override\n\t\tpublic final T next() {\n\t\t\tif(!hasNext())\
    \ {\n\t\t\t\tthrow new NoSuchElementException();\n\t\t\t}\n\t\t\t@SuppressWarnings(\"\
    unchecked\")\n\t\t\tfinal T res = (T) buf[now];\n\t\t\tnow = (now + 1) % n;\n\t\
    \t\trem--;\n\t\t\treturn res;\n\t\t}\n\t\t@Override\n\t\tpublic final void remove()\
    \ {\n\t\t\tif(isEmpty()) {\n\t\t\t\tthrow new IllegalStateException();\n\t\t\t\
    }\n\t\t\tnow = (now - 1 + n) % n;\n\t\t\tbuf[now] = null;\n\t\t\thead = (head\
    \ + 1) % n;\n\t\t\trem++;\n\t\t}\n\t}\n}\nfinal class IntDeque {\n\tprivate int\
    \ n, head, tail;\n\tprivate long[] buf;\n\tIntDeque(){ this(1 << 17); }\n\tIntDeque(final\
    \ int n) {\n\t\tthis.n = n;\n\t\thead = tail = 0;\n\t\tbuf = new long[n];\n\t\
    }\n\tIntDeque(final int[] a) {\n\t\tthis(a.length);\n\t\tArrays.stream(a).forEach(i\
    \ -> add(i));\n\t}\n\tIntDeque(final long[] a) {\n\t\tthis(a.length);\n\t\tArrays.stream(a).forEach(i\
    \ -> add(i));\n\t}\n\tprivate final int next(final int index) {\n\t\tfinal int\
    \ next = index + 1;\n\t\treturn next == n ? 0 : next;\n\t}\n\tprivate final int\
    \ prev(final int index) {\n\t\tfinal int prev = index - 1;\n\t\treturn prev ==\
    \ -1 ? n - 1 : prev;\n\t}\n\tprivate final int index(final int i) {\n\t\tfinal\
    \ int size = size();\n\t\tif(i >= size) {\n\t\t\tthrow new IndexOutOfBoundsException(\"\
    Index \"+ i +\" out of bounds for length \" + size);\n\t\t}\n\t\tfinal int id\
    \ = head + i;\n\t\treturn n <= id ? id - n : id;\n\t}\n\tprivate final void extend()\
    \ {\n\t\tbuf = Arrays.copyOf(buf, n << 1);\n\t\tn = buf.length;\n\t}\n\tfinal\
    \ boolean isEmpty(){ return size() == 0; }\n\tfinal int size() {\n\t\tfinal int\
    \ size = tail - head;\n\t\treturn size < 0 ? size + n : size;\n\t}\n\tfinal void\
    \ addFirst(final long x) {\n\t\thead = prev(head);\n\t\tif(head == tail) {\n\t\
    \t\textend();\n\t\t}\n\t\tbuf[head] = x;\n\t}\n\tfinal void addLast(final long\
    \ x) {\n\t\tif(next(tail) == head) {\n\t\t\textend();\n\t\t}\n\t\tbuf[tail] =\
    \ x;\n\t\ttail = next(tail);\n\t}\n\tfinal void removeFirst() {\n\t\tif(head ==\
    \ tail) {\n\t\t\tthrow new NoSuchElementException(\"Buffer is empty\");\n\t\t\
    }\n\t\thead = next(head);\n\t}\n\tfinal void removeLast() {\n\t\tif(head == tail)\
    \ {\n\t\t\tthrow new NoSuchElementException(\"Buffer is empty\");\n\t\t}\n\t\t\
    tail = prev(tail);\n\t}\n\tfinal long pollFirst() {\n\t\tif(head == tail) {\n\t\
    \t\tthrow new NoSuchElementException(\"Buffer is empty\");\n\t\t}\n\t\tfinal long\
    \ ans = buf[head];\n\t\thead = next(head);\n\t\treturn ans;\n\t}\n\tfinal long\
    \ pollLast() {\n\t\tif(head == tail) {\n\t\t\tthrow new NoSuchElementException(\"\
    Buffer is empty\");\n\t\t}\n\t\ttail = prev(tail);\n\t\treturn buf[tail];\n\t\
    }\n\tfinal long peekFirst(){ return get(0); }\n\tfinal long peekLast(){ return\
    \ get(n - 1); }\n\tfinal long get(final int i){ return buf[index(i)]; }\n\tfinal\
    \ void set(final int i, final long x){ buf[index(i)] = x; }\n\tfinal void add(final\
    \ long x){ addLast(x); }\n\tfinal long poll(){ return pollFirst(); }\n\tfinal\
    \ long peek(){ return peekFirst(); }\n\tfinal void swap(final int a, final int\
    \ b) {\n\t\tfinal int i = index(a);\n\t\tfinal int j = index(b);\n\t\tfinal long\
    \ num = buf[i];\n\t\tbuf[i] = buf[j];\n\t\tbuf[j] = num;\n\t}\n\tfinal void clear(){\
    \ head = tail = 0; }\n\tfinal long[] toArray(){ return Arrays.copyOf(buf, size());\
    \ }\n\t@Override\n\tpublic final String toString(){ return Arrays.toString(toArray());\
    \ }\n}"
  dependsOn:
  - Java/extension/SparseTable.java
  - Java/extension/PrimeCounter.java
  - Java/extension/PrefixSum.java
  - Java/extension/SegmentTree.java
  - Java/extension/DoubleEndedPriorityQueue.java
  - Java/extension/WeightedGraph.java
  - Java/extension/PrimeFactor.java
  - Java/extension/UnionFind.java
  - Java/extension/EulerPhiTable.java
  - Java/extension/PrimeTable.java
  - Java/extension/Huitloxopetl.java
  - Java/extension/LowestCommonAncestor.java
  - Java/extension/WaveletMatrix.java
  - Java/extension/WeightedUnionFind.java
  - Java/extension/UndoUnionFind.java
  - Java/extension/LargePrime.java
  - Java/extension/FenwickTree.java
  - Java/extension/SuffixArray.java
  - Java/extension/AVLTree.java
  - Java/extension/Graph.java
  - Java/extension/Template.java
  - Java/all.java
  isVerificationFile: false
  path: Java/extension/Deque.java
  requiredBy:
  - Java/extension/SparseTable.java
  - Java/extension/PrimeCounter.java
  - Java/extension/PrefixSum.java
  - Java/extension/SegmentTree.java
  - Java/extension/DoubleEndedPriorityQueue.java
  - Java/extension/WeightedGraph.java
  - Java/extension/PrimeFactor.java
  - Java/extension/UnionFind.java
  - Java/extension/EulerPhiTable.java
  - Java/extension/PrimeTable.java
  - Java/extension/Huitloxopetl.java
  - Java/extension/LowestCommonAncestor.java
  - Java/extension/WaveletMatrix.java
  - Java/extension/WeightedUnionFind.java
  - Java/extension/UndoUnionFind.java
  - Java/extension/LargePrime.java
  - Java/extension/FenwickTree.java
  - Java/extension/SuffixArray.java
  - Java/extension/AVLTree.java
  - Java/extension/Graph.java
  - Java/extension/Template.java
  - Java/all.java
  timestamp: '2024-01-03 04:00:35+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: Java/extension/Deque.java
layout: document
redirect_from:
- /library/Java/extension/Deque.java
- /library/Java/extension/Deque.java.html
title: Java/extension/Deque.java
---
