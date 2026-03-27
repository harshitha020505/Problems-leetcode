class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }
        int c=1;
        int maxi=0;
        for(int i:hs){
        
            c=0;
            if(!hs.contains(i-1)){
            while(hs.contains(i)){
                c++;
                // System.out.println("c"+c);
                i=i+1;
                // System.out.println(k);
            }
            
            maxi=Math.max(maxi,c);}
        }
        return maxi;
    }
}