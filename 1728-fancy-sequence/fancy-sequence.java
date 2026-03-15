class Fancy {
List<Long> lst=new ArrayList<>();
long add=0;
long mul=1;
long mod=(long)Math.pow(10,9)+7;
    public Fancy() {
        
        
    }
    
    public void append(int val) {
        long v=(val-add+mod)%mod;
        v=(v*modInverse(mul))%mod;
        lst.add(v);
    }
    
    public void addAll(int inc) {
        add=(add+inc)%mod;
        
    }
    
    public void multAll(int m) {
        mul=(mul*m)%mod;
        add=(add*m)%mod;
    }
    
    public int getIndex(int idx) {
        if(idx >= lst.size()) return -1;
        return (int)((lst.get(idx)*mul+add)%mod);
    }
   long modInverse(long x){
    return power(x, mod - 2);
}

long power(long x, long y){
    long res = 1;
    x %= mod;

    while(y > 0){
        if((y & 1) == 1)
            res = (res * x) % mod;

        x = (x * x) % mod;
        y >>= 1;
    }

    return res;
}
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */