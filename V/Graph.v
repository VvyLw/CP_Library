import os { input }
import datatypes { Queue }
@[params]
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
fn graph(n int, gp G_Param) Graph{
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
		l:=input('').split(' ').map(it.i64())
		gr.add(l[0],l[1],gp)
	}
}
fn (gr Graph) all_dist(v int) ![]int {
	mut d:=[]int{len:gr.g.len,init:-1}
	mut q:=Queue[i64]{}
	d[v]=0
	q.push(v)
	for !q.is_empty() {
		tmp:=q.pop()!
		for el in gr.g[tmp] {
			if d[el]!=-1 { continue }
			d[el]=d[tmp]+1
			q.push(el)
		}
	}
	return d
	}
	fn (gr Graph) dist(a int, b int) !int {
	d:=gr.all_dist(a)!
	return d[b]
}