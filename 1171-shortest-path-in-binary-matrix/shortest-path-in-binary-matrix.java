class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dir={{1,0},{0,1},{1,1},{-1,-1},{-1,0},{0,-1},{-1,1},{1,-1}};
        if(grid[0][0]!=0 || grid[m-1][n-1]!=0) return -1;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[] {0,0});
        grid[0][0]=1;
        while(!q.isEmpty()){
            int[] a=q.poll();
                int x=a[0];
                int y=a[1];
                int dist=grid[x][y];
                if(x==m-1 && y==n-1){
                    return dist;
                }
            for(int[] d: dir){
                int dx=x+d[0];
                int dy=y+d[1];
                if(dx>=0 && dy>=0 && dx<grid.length && dy< grid[0].length && grid[dx][dy]==0){
                    q.add(new int[] {dx,dy});
                    grid[dx][dy]=dist+1;
                }
            }
        }
        return -1;
        
    }
    
}