fn next_permutation[T](mut a []T) bool {
	for i:=a.len-2; i>=0; i-- {
		if a[i]<a[i+1] {
			for j:=a.len-1; j>i; j-- {
				if a[i]<a[j] {
					a[i],a[j]=a[j],a[i]
					mut p:=i+1
					mut q:=a.len-1
					for p<q {
						a[p],a[q]=a[q],a[p]
						p++
						q--
					}
					return true
				}
			}
		}
	}
	return false
}