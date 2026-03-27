class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top=0;
        int m=matrix.length;
        int n=matrix[0].length;
        int right=n-1;
        int left=0;
        int bottom=m-1;
        List<Integer> lst=new ArrayList<>();
        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++){
                lst.add(matrix[top][i]);
            }
            top++;
            for(int j=top;j<=bottom;j++){
                lst.add(matrix[j][right]);
            }
            right--;
            if(top<=bottom){
                for(int k=right;k>=left;k--){
                    lst.add(matrix[bottom][k]);
                }
            }
            bottom--;
            if(left<=right){
                for(int l=bottom;l>=top;l--){
                    lst.add(matrix[l][left]);
                }
            }
            left++;
        }
        return lst;
    }
}