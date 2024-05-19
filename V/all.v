// import core
// import graph
// import ds
// import mathe
// import other
import time{StopWatch}

fn solve()! {
	
}
fn main() {
	mut tm:=StopWatch{}
	tm.start()
	mut t:=1
	//t=ni()
	for t-->0 { solve()! }
	tm.stop()
	$if debug {
		eprintln(tm.elapsed())
	}
}