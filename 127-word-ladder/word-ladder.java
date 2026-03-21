class Solution {
    public boolean IsCount1(String s1,String s2){
        int i=0;
        int c=0;
        while(i<s1.length()){
            if(s1.charAt(i)!=s2.charAt(i)){
                c++;
            }
            i++;
            if(c > 1) return false;
        }
        return c==1;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if(!wordList.contains(beginWord)){
            wordList.add(0, beginWord);
        }
int n=wordList.size();
        int[][] mat=new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && IsCount1(wordList.get(i),wordList.get(j))){
                   mat[i][j]=1; 
                }
                else{
                    mat[i][j]=0;
                }
            }
        }
        int start=wordList.indexOf(beginWord);
        int end=wordList.indexOf(endWord);
        if(end==-1) return 0;
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        int level=1;
        int[] visited=new int[n];
        visited[start]=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int k=q.poll();
                if(k==end) return level;
                for(int j=0;j<n;j++){
                    if(mat[k][j]==1 && visited[j]!=1){
                        visited[j]=1;
                        q.add(j);
                    }
                }
            }
            level++;
        }
        return 0;

        
        
    }
    

}