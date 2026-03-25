class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        long[] prefix=new long[n*m];
        long[] suffix=new long[n*m];
        int[] arr=new int[m*n];
        int idx=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                arr[idx++]=grid[i][j];
            }
        }
        idx=0;
        int[] arr1=new int[m*n];
        long[] prefix1=new long[arr.length];
        long[] suffix1=new long[arr.length];
        for(int i=0;i<grid[0].length;i++){
            for(int j=0;j<grid.length;j++){
                arr1[idx++]=grid[j][i];
            }
        }
        prefix[0]=arr[0];
        prefix1[0]=arr1[0];
        for(int i=1;i<arr.length;i++){
            prefix[i]=prefix[i-1]+arr[i];
        }
        suffix[arr.length-1]=arr[arr.length-1];
        suffix1[arr.length-1]=arr1[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
            suffix[i]=suffix[i+1]+arr[i];
        }
        for(int i=1;i<arr.length;i++){
            prefix1[i]=prefix1[i-1]+arr1[i];
        }
        for(int i=arr.length-2;i>=0;i--){
            suffix1[i]=suffix1[i+1]+arr1[i];
        }
        // System.out.println(prefix);
        // System.out.println(suffix);
        // System.out.println(prefix1);
        // System.out.println(suffix1);
        for(int i=0;i<prefix.length-1;i++){
            if(prefix[i]==suffix[i+1]){
                return true;
            }
        }
        for(int i=0;i<prefix.length-1;i++){
            if(prefix1[i]==suffix1[i+1]){
                return true;
            }
        }
        return false;
    }
}