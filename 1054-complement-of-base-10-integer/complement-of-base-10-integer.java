class Solution {
    public int bitwiseComplement(int n) {
      if(n==0) return 1;
      int a=1;
      while(a<=n){
        a=a*2;
      }
      return a-n-1;   
    }
}