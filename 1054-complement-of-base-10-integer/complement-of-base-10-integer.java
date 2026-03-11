class Solution {
    public String toBinary(int n){
        
        StringBuilder str=new StringBuilder();
        while(n>0){
            str.append(n%2);
            n=n/2;
        }
        return str.toString();
    }
    public int bitwiseComplement(int n) {
        if(n==0){
            return 1;
        }
        String str=toBinary(n);
        int sum=0;
        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i)=='0'){
                sum+=Math.pow(2,i);
            }
        }
        return sum;
    }
}