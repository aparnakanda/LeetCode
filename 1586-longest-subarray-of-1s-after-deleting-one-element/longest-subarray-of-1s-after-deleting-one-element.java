class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int zeroCount=0;
        int longWindow=0;
        int start=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                zeroCount++;
            }
            while(zeroCount>1){
                if(nums[start]==0){
                    zeroCount--;
                }
                start++;
            }
            longWindow=Math.max(longWindow,i-start);
        }
        return longWindow;
    }
}