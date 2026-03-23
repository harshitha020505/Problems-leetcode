class Solution {
    public int maxProductPath(int[][] grid) {
        int mod=1000000007;
        long[][][] dp=new long[grid.length][grid[0].length][2];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                dp[i][j][0]=Long.MIN_VALUE;
                dp[i][j][1]=Long.MAX_VALUE;
            }
        }
        long [] a= helper(grid,grid.length-1,grid[0].length-1,dp);
        if(a[0]<0) return -1;
        return (int)(a[0]%mod);
    }
        public long[] helper(int[][] grid,int m,int n,long[][][] dp){
            if(m==0 && n==0){
                return new long[]{grid[0][0],grid[0][0]};
            }
            if(m<0 || n<0){
                return new long[]{Long.MIN_VALUE,Long.MAX_VALUE};
            }
            if(dp[m][n][0]!=Long.MIN_VALUE){
                return dp[m][n];
            }
            long val=grid[m][n];
            long[] up=helper(grid,m-1,n,dp);
            long[] left=helper(grid,m,n-1,dp);
            long min_val=Long.MAX_VALUE;
            long max_val=Long.MIN_VALUE;
            if(up[0]!=Long.MIN_VALUE){
                max_val=Math.max(max_val,up[0]*val);
                min_val=Math.min(min_val,up[0]*val);
            }
            if(up[1]!=Long.MAX_VALUE){
                max_val=Math.max(max_val,up[1]*val);
                min_val=Math.min(min_val,up[1]*val);
            }
            if(left[0]!=Long.MIN_VALUE){
                max_val=Math.max(max_val,left[0]*val);
                min_val=Math.min(min_val,left[0]*val);
            }
            if(left[1]!=Long.MAX_VALUE){
                max_val=Math.max(max_val,left[1]*val);
                min_val=Math.min(min_val,left[1]*val);
            }
            
            dp[m][n]=new long[]{max_val,min_val};
            return dp[m][n];
        }
    
}