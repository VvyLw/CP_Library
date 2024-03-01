class UnionFind
    def initialize(n)
        @par = Array.new(n, -1)
    end
    def length
        @par.length
    end
    def [](i)
        while @par[i] >= 0
            p = @par[@par[i]]
            return @par[i] if p < 0
            i = @par[i] = p
        end
        i
    end
    def size(i)
        -@par[i]
    end
    def unite(i, j)
        i = self[i]
        j = self[j]
        return false if i == j
        i, j = j, i if i > j
        @par[i] += @par[j]
		@par[j] = i
		true
    end
    def groups
        @par.size.times.group_by{self[_1]}.values
    end
end

def is_bipartite?(uf)
    raise "Assertion failed: Length of UnionFind must be even" unless uf.length % 2 == 0
    n = uf.length / 2
    ok = true
    n.times{ok &&= uf[_1] != uf[_1 + n]}
    ok
end
