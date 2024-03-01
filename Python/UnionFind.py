class UnionFind:
    def __init__(self, n: int) -> None: self.__par = [-1] * n
    def __len__(self) -> int: return len(self.__par)
    def root(self, i: int) -> int:
        if self.__par[i] >= 0:
            self.__par[i] = self.root(self.__par[i])
            return self.__par[i]
        return i
    def size(self, i: int) -> int: return -self.__par[self.root(i)]
    def unite(self, i: int, j: int) -> bool:
        i = self.root(i)
        j = self.root(j)
        if i == j: return False
        if i > j: i, j = j, i
        self.__par[i] += self.__par[j]
        self.__par[j] = i
        return True
    def same(self, i: int, j: int) -> bool: return self.root(i) == self.root(j)
    def groups(self) -> list[list[int]]:
        n = len(self.__par)
        res = [[] for _ in range(n)]
        for i in range(n): res[self.root(i)].append(i)
        return list(filter(lambda x: x, res))

def is_bipartite(uf: UnionFind) -> bool:
    assert len(uf) % 2 == 0
    n = len(uf) // 2
    ok = True
    for i in range(n): ok &= not uf.same(i, i + n)
    return ok