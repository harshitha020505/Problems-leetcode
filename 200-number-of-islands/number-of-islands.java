class Solution {
    public int numIslands(char[][] grid) {
        int c=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    c++;
                    dfs(grid,i,j);
                }
            }
        }
        return c;
    }
    public void dfs(char[][] grid,int r,int c){
        int[][] dir = {{-1,0},{0,-1},{0,1},{1,0}};
        grid[r][c]='0';
        for(int[] d:dir){
            if(r+d[0]<0 || c+d[1]<0 || r+d[0]>=grid.length || c+d[1]>=grid[0].length){
                continue;
            }
            if(grid[r+d[0]][c+d[1]]=='1')
            dfs(grid,r+d[0],c+d[1]);
        }
    }
}