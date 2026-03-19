class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        int[][] psX=new int[m][n];
        int[][] psY=new int[m][n];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='X'){
                    psX[i][j]++;
                }
                if(grid[i][j]=='Y'){
                    psY[i][j]++;
                }
                if(i>0){
                    psX[i][j]+=psX[i-1][j];
                    psY[i][j]+=psY[i-1][j];

                }

                if(j>0){
                   
                        psX[i][j]+=psX[i][j-1];
                    
                    
                        psY[i][j]+=psY[i][j-1];
                    
                }
                if(i>0 && j>0){
                    psX[i][j]-=psX[i-1][j-1];
                    psY[i][j]-=psY[i-1][j-1];
                }
                if(psX[i][j]==psY[i][j] & psX[i][j]>0){
                    count++;
                }
                
            }
        }
        return count;
    }
}