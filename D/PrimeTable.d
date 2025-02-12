class PrimeTable {
    private bool[] isPrime;
    private int n;
    this(const int n) {
        this.n = n;
        isPrime = new bool[n + 1];
        isPrime[] = true;
        isPrime[0] = isPrime[1] = false;
        foreach(i; 2U..n + 1) {
            if(!isPrime[i]) {
                continue;
            }
            foreach(j; iota(i * i, n + 1, i)) {
                isPrime[j] = false;
            }
        }
    }
    bool[] table() pure nothrow @safe @nogc {
        return isPrime;
    }
    int[] prime() pure const nothrow @safe {
        int[] p;
        foreach(i; 2..n + 1) {
            if(isPrime[i]) {
                p ~= i;
            }
        }
        return p;
    }
}