class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m=grid.length;
        int l=grid[0].length;
        int[] arr=new int[m*l];
        int idx1=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<l;j++){
                arr[idx1++]=grid[i][j];
            }
        }
        int n=arr.length;
        int[] pre=new int[n];
        int[] suff=new int[n];
        pre[0]=1;
        for(int i=1;i<pre.length;i++){
            pre[i]=(int)(((long)pre[i-1]*arr[i-1])%12345);
        }
        suff[n-1]=1;
        for(int i=n-2;i>=0;i--){
            suff[i]=(int)(((long)suff[i+1]*arr[i+1])%12345);
        }
        int idx=0;
        int[][] p=new int[m][l];
        for(int i=0;i<m;i++){
            for(int j=0;j<l;j++){
                p[i][j]=(int)(((long)suff[idx]*pre[idx])%12345);
                idx++;
            }
        }
        return p;
    }
}