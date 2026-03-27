class Solution {
    public int countPaths(int V, int[][] edges) {
         List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        int mod=1000000007;
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            graph.get(u).add(new int[] {v,w});
            graph.get(v).add(new int[] {u,w});
        }
        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->
        Long.compare(a[1],b[1]));
        long[] dist=new long[V];
        int[] ways=new int[V];
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new long[]{0,0});
        Arrays.fill(dist, Long.MAX_VALUE);
        while(!pq.isEmpty()){
            long[] d=pq.poll();
            int a=(int)d[0];
            long dis=d[1];
            if(dis > dist[a]) continue;
            for(int[] i:graph.get(a)){
                int next=i[0];
                long newdist=dis+i[1];
                if(newdist<dist[next]){
                    dist[next]=newdist;
                    ways[next]=ways[a];
                    pq.add(new long[] {next,newdist});
                }
                else if(newdist==dist[next]){
                    ways[next]=(ways[next]+ways[a])%mod;
                }
            }
        }
        return ways[V-1];
    }
}