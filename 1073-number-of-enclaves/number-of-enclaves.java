class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            if(grid[i][0]==1) dfs(grid,i,0);
            if(grid[i][n-1]==1) dfs(grid,i,n-1);
       }
       for(int j=0;j<n;j++){
            if(grid[0][j]==1) dfs(grid,0,j);
            if(grid[m-1][j]==1) dfs(grid,m-1,j);
       }
       int c=0;
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(grid[i][j]==1){
                c++;
            }
        }
       }
       return c;

    }
    public void dfs(int[][] grid,int i,int j){
        grid[i][j]=0;
        int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};
        for(int[] d:dir){
            int r=i+d[0];
            int c=j+d[1];
            if(r<0 || c<0 || r>grid.length-1 || c>grid[0].length-1) continue;
            if(grid[r][c]==1){
                dfs(grid,r,c);
            }
        }
    }
}