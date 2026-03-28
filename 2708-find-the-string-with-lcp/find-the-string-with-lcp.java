class Solution {
    public String findTheString(int[][] lcp) {
        int n=lcp.length;
        char[] word=new char[n];
        word[0]='a';
        
        for(int i=1;i<n;i++){
            char temp='a';
            boolean found=false;
            for(int j=0;j<i;j++){
                temp=(char)Math.max(temp,word[j]);
                if(lcp[i][j]>0){
                    word[i]=word[j];
                    found=true;
                    break;
                }
            }
            if(!found){
                temp++;
                word[i]=temp;
            }
            if(temp>'z'){
                return "";
            }
        }
        int[][] dp=new int[n+1][n+1];
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int val=0;
                if(word[i]!=word[j]){
                    val=0;
                }
                else{
                    val=1+dp[i+1][j+1];
                    dp[i][j]=val;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(lcp[i][j]!=dp[i][j]){
                    return "";
                }
            }
        }
        return String.valueOf(word);
    }
}