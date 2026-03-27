class Solution {
    public boolean areSimilar(int[][] mat, int k) {
       int m = mat.length;
int n = mat[0].length;

int[][] a = new int[m][n];

for (int i = 0; i < m; i++) {
    for (int j = 0; j < n; j++) {
        a[i][j] = mat[i][j];
    }
}
     for(int i=0;i<a.length;i++){
        for(int j=0;j<a[i].length-1;j++){
            int temp=a[i][j];
            a[i][j]=a[i][(j+k)%a[i].length];
            a[i][(j+k)%a[i].length]=a[i][j];
        }
     }   
     for(int i=0;i<mat.length;i++){
        for(int j=0;j<mat[0].length;j++){
            if(mat[i][j]!=a[i][j]){
                return false;
            }
        }
     }
     return true;
    }
}