struct UnionFind {
mut:
	par []int
}
fn new_uf(n int) UnionFind {
	uf:=UnionFind{
		par: []int{len:n,init:-1}
	}
	return uf
}
fn (mut uf UnionFind) root(i int) int { 
	if uf.par[i]<0{ return i }
	uf.par[i]=uf.root(uf.par[i])
	return uf.par[i]
}
fn (mut uf UnionFind) same(i int, j int) bool { return uf.root(i)==uf.root(j) }
fn (mut uf UnionFind) size(i int) int { return -uf.par[uf.root(i)] }
fn (mut uf UnionFind) unite(i int, j int) bool {
	a:=uf.root(i)
	b:=uf.root(j)
	if a==b { return false }
	if uf.par[a]>uf.par[b] { uf.par[a],uf.par[b]=uf.par[b],uf.par[a] }
	uf.par[a]+=uf.par[b]
	uf.par[b]=a
	return true
}