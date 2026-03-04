class Solution {
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // int[][] ans=new int[image.length][image[0].length];
        int original=image[sr][sc];
        if(original==color) return image;
        image[sr][sc]=color;
        dfs(image,sr,sc,color,original);
        return image;

    }
    public void dfs(int[][] image,int sr,int sc,int color,int original){
    int[][] dir = {{-1,0},{0,-1},{0,1},{1,0}};
        for(int[] i:dir){
        if(sr+i[0]<0 || sc+i[1]<0 || sr+i[0]>=image.length || sc+i[1]>=image[0].length){
        continue;} 
            if(image[sr+i[0]][sc+i[1]]==original){
                image[sr+i[0]][sc+i[1]]=color;
                dfs(image,sr+i[0],sc+i[1],color,original);
            }
            
            
        }
    }
}