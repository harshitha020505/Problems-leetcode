class Solution {
    public int subarraySum(int[] nums, int k) {
     HashMap<Integer,Integer> hm=new HashMap<>();
     int pre=0;
     int c=0;
     hm.put(0,1);
     for(int i=0;i<nums.length;i++){
        pre+=nums[i];
        if(hm.containsKey(pre-k)){
            c+=hm.get(pre-k);
        }
        if(hm.containsKey(pre)){
            hm.put(pre,hm.get(pre)+1);
        }
        else{
            hm.put(pre,1);
        }
     } 
     return c;  
    }
}