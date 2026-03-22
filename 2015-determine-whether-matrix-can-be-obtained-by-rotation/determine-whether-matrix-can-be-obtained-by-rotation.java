class Solution {
    public int[] reverse(int[] arr){
        int i=0;
        int j=arr.length-1;
        while(i<j){
            int temp1=arr[i];
            arr[i]=arr[j];
            arr[j]=temp1;
            i++;
            j--;
        }
        return arr;
    }
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(i<j){
                    int temp=matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=temp;
                }
                
            }
        }
        for(int i=0;i<matrix.length;i++){
            reverse(matrix[i]);
        }
    }
    public boolean r(int[][] mat, int[][] target){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]!=target[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        for(int k=0;k<4;k++){
            if(r(mat,target)==true){
                return true;
            }
            rotate(mat);
        }
        return false;
    }
}