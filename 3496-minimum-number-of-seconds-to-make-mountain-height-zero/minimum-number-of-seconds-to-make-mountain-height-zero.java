class Solution {
    class Worker {
        long nextTime;
        int baseTime;
        int k;
        
        Worker(int t) {
            baseTime = t;
            k = 1;
            nextTime = t;
        }
    }
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        PriorityQueue<Worker> pq=new PriorityQueue<>(
            (a,b)-> Long.compare(a.nextTime,b.nextTime)
        );
        for(int i:workerTimes){
            pq.add(new Worker(i));
        }
        long ans=0;
        for(int i=0;i<mountainHeight;i++){
            Worker w=pq.poll();
            ans=w.nextTime;
            w.k++;
            w.nextTime+=(long) w.baseTime*w.k;
            pq.add(w);
        }
        return ans;
    }
}