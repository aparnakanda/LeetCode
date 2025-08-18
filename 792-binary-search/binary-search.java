class Solution {
    public int bs(int[] nums,int low, int high, int target){
        if(low>high){
            return -1;
        }
        int mid=(low+high)/2;
        if(nums[mid]==target){
            return mid;
        }
        else if(target<nums[mid]){
            return bs(nums,low,mid-1,target);
        }
        else{
            return bs(nums,mid+1,high,target);
        }
    }
    public int search(int[] nums, int target) {
       int low=0;
       int high=nums.length-1;
       return bs(nums,low,high,target);
    }
}