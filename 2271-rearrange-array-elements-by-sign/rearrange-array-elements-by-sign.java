class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] nums1=new int[nums.length];
        int k=0;
        int l=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                nums1[2*k+1]=nums[i];
                k++;
            }
            else{
                nums1[2*l]=nums[i];
                l++;
            }
        }
        return nums1;
    }
}