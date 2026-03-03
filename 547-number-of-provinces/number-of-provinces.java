class Solution {
    public int findCircleNum(int[][] isConnected) {
        // List<List<Integer>> lst=new ArrayList<>();
        // for(int i=0;i<isConnected.length;i++){
        //     lst.add(new ArrayList<>());
        // }
        // for(int i=0;i<isConnected.length;i++){
        //     for(int j=0;j<isConnected[0].length;j++){
        //         if(isConnected[i][j]==1){
        //         lst.get(j).add(i);
        //         lst.get(i).add(j);}
        //     }
        // }
        int c=0;
        int[] visited=new int[isConnected.length];
        for(int i=0;i<isConnected.length;i++){
            if(visited[i]!=1){
                c++;
               dfs(isConnected,i,visited);
               }}
               return c;

    }
    public void dfs(int[][] isConnected,int node,int[] visited){
        visited[node]=1;
        // int c=0;
        for(int i=0;i<isConnected[node].length;i++){
            if(isConnected[node][i]==1 && visited[i]!=1){
                dfs(isConnected,i,visited);
                // c++;
            }
        }
        // return c;
    }
}