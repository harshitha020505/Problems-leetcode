class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(i<j){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;}
            }
        }
        for(int[] i:matrix){
            reverse(i);
        }
    }
    public void reverse(int[] row){
        int i=0;
        int h=row.length-1;
        while(i<=h){
            
            int temp1=row[i];
            row[i]=row[h];
            row[h]=temp1;
            i++;
            h--;
        }
    }
}