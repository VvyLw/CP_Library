module graph

pub struct Edge {
	src int
	to int
	cost i64
}
fn (ed Edge) str() string { return '($ed.src, $ed.to, $ed.cost)' }