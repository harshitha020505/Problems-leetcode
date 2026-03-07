class Solution {
    public int orangesRotting(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
    int fresh=0;
        // Step 1: push all 0s into queue
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(mat[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
                else if(mat[i][j]==1){
                   fresh++;
                }
                    

            }
        }

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        // Step 2: BFS
        int minutes=0;
        while(!q.isEmpty() && fresh>0){
            int size=q.size();
            for(int i=0;i<size;i++){
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            for(int[] d : dir){

                int nr = r + d[0];
                int nc = c + d[1];

                if(nr>=0 && nc>=0 && nr<m && nc<n &&
                   mat[nr][nc] ==1){

                    mat[nr][nc] = 2;
                    fresh--;
                    q.offer(new int[]{nr,nc});
                }
            }
            }
            minutes++;
        }

if(fresh > 0) return -1;
        return minutes;
    }
}