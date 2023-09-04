struct Graph {
	directed bool
mut:
	g [][]i64
}
fn new_gr(n int, dir bool) Graph{
	return Graph{
		g: [][]i64{len:n}
		directed: dir
	}
}
fn (mut G Graph) add(a i64, b i64, indexed int) {
	x:=a-indexed
	y:=b-indexed
	G.g[x]<<y
	if G.directed{ G.g[y]<<x }
}
fn (mut G Graph) in_g(m int, indexed int) {
	for _ in 0..m {
		l:=lbi()
		G.add(l[0],l[1],indexed)
	}
}