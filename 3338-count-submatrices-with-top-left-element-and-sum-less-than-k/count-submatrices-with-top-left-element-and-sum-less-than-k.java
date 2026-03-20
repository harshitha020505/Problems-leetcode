class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] ps=new int[m][n];
        int c=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                ps=grid;
                
                if(j>0){
                    ps[i][j]=ps[i][j]+ps[i][j-1];
                }
                if(i>0){
                    ps[i][j]=ps[i][j]+ps[i-1][j];
                }
                if(i>0 && j>0){
                    ps[i][j]-=ps[i-1][j-1];
                }
                if(grid[0][0]<=k && ps[i][j]<=k){
                    c++;
                }
            }
            
        }
        return c;
    }
}