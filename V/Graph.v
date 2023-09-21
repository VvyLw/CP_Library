[params]
struct G_Param {
	idx int=1
	dir bool=true
}
struct Graph {
	undirected bool
mut:
	g [][]i64
}
fn (gr Graph) str() string { return '${gr.g}' }
fn new_g(n int, gp G_Param) Graph{
	return Graph{
		g: [][]i64{len:n}
		undirected: gp.dir
	}
}
fn (mut gr Graph) add(a i64, b i64, gp G_Param) {
	x:=a-gp.idx
	y:=b-gp.idx
	gr.g[x]<<y
	if gp.dir{ gr.g[y]<<x }
}
fn (mut gr Graph) ing(m int, gp G_Param) {
	for _ in 0..m {
		a,b:=pl(lbi())
		gr.add(a,b,gp)
	}
}