class Solution {
    public boolean canPartition(int[] nums) {
        int totsum=0;
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            totsum+=nums[i];
        }
        if(totsum%2==1){
            return false;
        }
        int target=totsum/2;
        int[][] dp=new int[n][target+1];
     for(int[] row:dp){
        Arrays.fill(row,-1);
     }
     return helper(nums,target,n-1,dp);
    }
    public boolean helper(int[] nums,int target,int n,int[][] dp){
        if(target==0){
            return true;
        }
        if(n==0){
            return nums[0]==target;
        }
        if(dp[n][target]!=-1){
            return dp[n][target]==0?false:true;
        }
        boolean nottaken=helper(nums,target,n-1,dp);
        boolean take=false;
        if(nums[n]<=target){
            take=helper(nums,target-nums[n],n-1,dp);
        }   
        dp[n][target]=take||nottaken?1:0;
        return take||nottaken;
     
     }
}