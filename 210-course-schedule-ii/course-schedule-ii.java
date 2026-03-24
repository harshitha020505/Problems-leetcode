class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
      for(int i=0;i<numCourses;i++){
        graph.add(new ArrayList<>());
      }   
      Queue<Integer> q=new LinkedList<>();
      int[] inorder=new int[numCourses];
      for(int[] g:prerequisites){
        graph.get(g[1]).add(g[0]);
        inorder[g[0]]++;
      }
      for(int i=0;i<numCourses;i++){
        if(inorder[i]==0){
            q.add(i);
        }
      }
      int idx=0;
      int[] arr=new int[numCourses];
      while(!q.isEmpty()){
        int a=q.poll();
        arr[idx++]=a;
        for(int i:graph.get(a)){
            inorder[i]--;
            if(inorder[i]==0){
                // count++;
                q.add(i);
            }
        }
      }
      return idx==numCourses?arr:new int[0];
    }
}